/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  RedisServiceImpl.java   
 * @Package cn.org.openwork.nosql.service.impl   
 * @Description:    Redis Service实现
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年6月28日 下午2:15:11   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.org.openwork.nosql.bean.ClusterNetworkDto;
import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RedisCluster;
import cn.org.openwork.nosql.bean.RedisClusterExample;
import cn.org.openwork.nosql.bean.RedisDetailDto;
import cn.org.openwork.nosql.bean.RedisKeysDto;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.bean.RedisServerDto;
import cn.org.openwork.nosql.bean.RedisServerExample;
import cn.org.openwork.nosql.bean.RedisServerStatus;
import cn.org.openwork.nosql.bean.RedisStatusHistory;
import cn.org.openwork.nosql.bean.RedisStatusHistoryChartsDto;
import cn.org.openwork.nosql.bean.RedisStatusHistoryExample;
import cn.org.openwork.nosql.bean.Relation;
import cn.org.openwork.nosql.bean.RestResponse;
import cn.org.openwork.nosql.bean.SlaveStatus;
import cn.org.openwork.nosql.bean.RedisServerExample.Criteria;
import cn.org.openwork.nosql.mapper.RedisClusterMapper;
import cn.org.openwork.nosql.mapper.RedisServerMapper;
import cn.org.openwork.nosql.mapper.RedisStatusHistoryMapper;
import cn.org.openwork.nosql.service.RedisService;
import cn.org.openwork.nosql.util.MiscUtil;
import cn.org.openwork.nosql.util.RedisUtil;
import cn.org.openwork.nosql.util.SysSampleUtil;
import redis.clients.jedis.DebugParams;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: ApiServiceImpl
 * @Description:Redis Service实现
 * @author: 李平(360841519@qq.com)
 * @date: 2017年6月28日 下午2:15:11
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class RedisServiceImpl extends AbstractRedisService implements RedisService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);
    
    @Resource
    private RedisServerMapper redisServerMapper;
    
    @Resource
    private RedisStatusHistoryMapper redisStatusHistoryMapper;
    
    @Resource
    private RedisClusterMapper redisClusterMapper;
    @Resource
    private RedisQuerier redisQuerier;
    
    /*
     * (non-Javadoc)
     * 
     * @see cn.bqjr.redis.agent.service.ApiService#getInfo(java.lang.Long)
     */
    @Override
    public RestResponse<String> getInfo(Long redisServerId)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            RedisServer redisServer = redisServerMapper.selectByPrimaryKey(redisServerId);
            String host = redisServer.getHost();
            Integer port = Integer.valueOf(redisServer.getPort());
            String auth = redisServer.getPassword();
            Jedis jedis = new RedisUtil(host, port, auth).getJedis();
            String data = jedis.info();
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(data);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public PagedDto<RedisServerDto> getRedisList(int draw, int startIndex, int pageSize, String search)
    {
        PagedDto<RedisServerDto> pagedDto = null;
        try
        {
            RedisServerExample redisServerExample = new RedisServerExample();
            redisServerExample.setLimitStart(startIndex);
            redisServerExample.setPageSize(pageSize);
            redisServerExample.setOrderByClause("id desc");
            if ((search != null) && (!search.isEmpty()))
            {
                redisServerExample.createCriteria().andTagsLike("%" + search + "%");
            }
            List<RedisServer> redisServerList = redisServerMapper.selectByExample(redisServerExample);
            List<RedisServerDto> redisServerDtoList = new ArrayList<>();
            for (RedisServer redisServer : redisServerList)
            {
                RedisServerDto redisServerDto = new RedisServerDto();
                redisServerDto.setCreateTime(redisServer.getCreateTime());
                redisServerDto.setHost(redisServer.getHost());
                redisServerDto.setId(redisServer.getId());
                redisServerDto.setPassword(redisServer.getPassword());
                redisServerDto.setPort(redisServer.getPort());
                redisServerDto.setTags(redisServer.getTags());
                String status =
                    getRedisStatus(redisServerDto.getHost(), redisServerDto.getPort(), redisServerDto.getPassword());
                redisServerDto.setStatus(status);
                if (Constant.REDIS_PONG.equals(status))
                {
                    // 获取redis info字符串
                    String info = getRedisInfo(redisServer);
                    // 获取角色
                    String role = getRedisInfoKeyValue(info, "role").trim();
                    redisServerDto.setRole(role);
                    if (Constant.REDIS_SLAVE.equals(role))
                    {
                        // 获取master信息
                        String master =
                            getRedisInfoKeyValue(info, "master_host") + ":" + getRedisInfoKeyValue(info, "master_port");
                        redisServerDto.setMaster(master);
                    }
                    // 获取QPS
                    String qps = getRedisInfoKeyValue(info, "instantaneous_ops_per_sec");
                    redisServerDto.setQps(qps);
                    // 获取keyspace
                    String keyspace = getRedisInfoBySection(redisServer, "Keyspace");
                    redisServerDto.setKeyspace(keyspace);
                    // 获取uptime
                    String uptime = MiscUtil
                        .secondsToHumanTime(Long.valueOf(getRedisInfoKeyValue(info, "uptime_in_seconds").trim()));
                    redisServerDto.setUptime(uptime);
                    String usedMemoryHuman = getRedisInfoKeyValue(info, "used_memory_human");
                    String totalSystemMemoryHuman = getRedisInfoKeyValue(info, "total_system_memory_human");
                    redisServerDto.setMemory(usedMemoryHuman + "/" + totalSystemMemoryHuman);
                }
                
                redisServerDtoList.add(redisServerDto);
            }
            int count = redisServerMapper.countByExample(null);
            pagedDto = new PagedDto<>();
            pagedDto.setData(redisServerDtoList);
            pagedDto.setDraw(draw);
            pagedDto.setRecordsFiltered(count);
            pagedDto.setRecordsTotal(count);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        return pagedDto;
    }
    
    @Override
    public RestResponse<String> saveRedis(Long id, String host, Integer port, String password, String tags,
        Long clusterId)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            // 判断redis是否可以连接成功
            if (isConnRedis(host, port, password))
            {
                RedisServer redisServer = new RedisServer();
                redisServer.setCreateTime(new Date());
                redisServer.setPassword(password);
                redisServer.setPort(port);
                redisServer.setHost(host);
                redisServer.setTags(tags);
                redisServer.setClusterId(clusterId);
                // 当id为0，是新增
                if (id == Constant.ZERO)
                {
                    // 判断节点是否已经存在
                    if (isRedisExist(host, port))
                    {
                        restResponse.setCode(Constant.FAIL_REDIS_EXIST_CODE);
                        restResponse.setMessage(Constant.FAIL_REDIS_EXIST_MESSAGE);
                        // 如果节点已经存在直接返回
                        return restResponse;
                    }
                    else
                    {
                        redisServerMapper.insert(redisServer);
                    }
                }
                // 否则为更新
                else
                {
                    redisServer.setId(id);
                    redisServerMapper.updateByPrimaryKey(redisServer);
                }
                restResponse.setCode(Constant.SUCCESS_CODE);
                restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            }
            else
            {
                restResponse.setCode(Constant.FAIL_REDIS_CONN_CODE);
                restResponse.setMessage(Constant.FAIL_REDIS_CONN_MESSAGE);
            }
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<String> deleteRedis(Long id)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            // 删除redis server信息
            redisServerMapper.deleteByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<RedisServer> getRedis(Long id)
    {
        RestResponse<RedisServer> restResponse = new RestResponse<>();
        try
        {
            RedisServer redisServer = redisServerMapper.selectByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(redisServer);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<Integer> countRedis()
    {
        RestResponse<Integer> restResponse = new RestResponse<>();
        try
        {
            int count = redisServerMapper.countByExample(new RedisServerExample());
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(count);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public PagedDto<RedisDetailDto> getRedisDetail(Long id)
    {
        // 获取redis server信息
        RedisServer redisServer = redisServerMapper.selectByPrimaryKey(id);
        // 获取redis info信息
        String info = getRedisInfo(redisServer);
        PagedDto<RedisDetailDto> pagedDto = new PagedDto<>();
        List<RedisDetailDto> list = new ArrayList<>();
        RedisDetailDto dto = new RedisDetailDto();
        dto.setHost(redisServer.getHost());
        dto.setPort(String.valueOf(redisServer.getPort()));
        dto.setAofEnabled(getRedisInfoKeyValue(info, "aof_enabled"));
        dto.setClusterEnabled(getRedisInfoKeyValue(info, "cluster_enabled"));
        dto.setConnectedSlaves(getRedisInfoKeyValue(info, "connected_slaves"));
        dto.setProcessId(getRedisInfoKeyValue(info, "process_id"));
        dto.setAofLastWriteStatus(getRedisInfoKeyValue(info, "aof_last_write_status"));
        dto.setRedisMode(getRedisInfoKeyValue(info, "redis_mode"));
        dto.setRedisVersion(getRedisInfoKeyValue(info, "redis_version"));
        dto.setRole(getRedisInfoKeyValue(info, "role"));
        dto.setUptimeInDays(getRedisInfoKeyValue(info, "uptime_in_days"));
        dto.setUptimeInSeconds(getRedisInfoKeyValue(info, "uptime_in_seconds"));
        list.add(dto);
        pagedDto.setData(list);
        return pagedDto;
    }
    
    @Override
    public PagedDto<RedisStatusHistory> getRedisMonitoring(Long id)
    {
        PagedDto<RedisStatusHistory> pagedDto = new PagedDto<>();
        RedisStatusHistoryExample redisStatusHistoryExample = new RedisStatusHistoryExample();
        cn.org.openwork.nosql.bean.RedisStatusHistoryExample.Criteria createCriteria =
            redisStatusHistoryExample.createCriteria();
        createCriteria.andServerIdEqualTo(id);
        redisStatusHistoryExample.setLimitStart(0);
        redisStatusHistoryExample.setPageSize(10);
        redisStatusHistoryExample.setOrderByClause("id desc");
        List<RedisStatusHistory> list = redisStatusHistoryMapper.selectByExample(redisStatusHistoryExample);
        pagedDto.setData(list);
        return pagedDto;
    }
    
    @Override
    public RestResponse<String> backupRedis(Long id)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            RedisServer redisServer = redisServerMapper.selectByPrimaryKey(id);
            String host = redisServer.getHost();
            Integer port = redisServer.getPort();
            String password = redisServer.getPassword();
            RedisUtil redisUtil = new RedisUtil(host, port, password);
            Jedis jedis = redisUtil.getJedis();
            String bgsave = jedis.bgsave();
            System.out.println("bgsave>>" + bgsave);
            jedis.close();
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    /* (non-Javadoc)
     * @see cn.org.openwork.nosql.service.RedisService#getRedisStatusHistoryChart(java.lang.Long, java.lang.String)
     */
    @Override
    public RedisStatusHistoryChartsDto getRedisStatusHistoryChart(Long id, String timeRange)
    {
        List<RedisStatusHistory> list = getRedisStatusHistoryByTimeRange(id, timeRange);
        String[] xAxis = new String[list.size()];
        String[] seriesQps = new String[list.size()];
        String[] seriesKeys = new String[list.size()];
        String[] seriesExpires = new String[list.size()];
        String[] seriesExpiredKeys = new String[list.size()];
        String[] seriesUsedMemory = new String[list.size()];
        String[] seriesTotalMemory = new String[list.size()];
        String[] seriesUsedPeakMemory = new String[list.size()];
        String[] seriesUsedRssMemory = new String[list.size()];
        String[] seriesCpuSys = new String[list.size()];
        String[] seriesCpuUser = new String[list.size()];
        String[] seriesConnectedClients = new String[list.size()];
        String[] seriesBlockedClients = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++)
        {
            try
            {
                xAxis[i] = MiscUtil.getFormatDateTime(list.get(i).getCreateTime());
                //如果keys存在
                String keyspace = list.get(i).getKeyspace();
                if (!keyspace.isEmpty())
                {
                    String[] dbInfos = keyspace.split("\r\n");
                    Integer keys=0;
                    Integer expires=0;
                    for(String dbInfo:dbInfos){
                        keys += getKeysFromDbInfo(dbInfo);
                        expires+= getExpiresFromDbInfo(dbInfo);
                    }
                    seriesKeys[i]=keys.toString();
                    seriesExpires[i]=expires.toString();
                }
                else
                {
                    seriesKeys[i] = Constant.STRING_ZERO;
                    seriesExpires[i] = Constant.STRING_ZERO;
                }
                seriesQps[i] = list.get(i).getInstantaneousOpsPerSec();
                seriesExpiredKeys[i] = list.get(i).getExpiredKeys();
                seriesUsedMemory[i] = MiscUtil.bytesToMb(list.get(i).getUsedMemory());
                seriesUsedPeakMemory[i] = MiscUtil.bytesToMb(list.get(i).getUsedMemoryPeak());
                seriesUsedRssMemory[i] = MiscUtil.bytesToMb(list.get(i).getUsedMemoryRss());
                seriesTotalMemory[i] = MiscUtil.bytesToMb(list.get(i).getTotalSystemMemory());
                seriesCpuSys[i] = list.get(i).getUsedCpuSys();
                seriesCpuUser[i] = list.get(i).getUsedCpuUser();
                seriesConnectedClients[i] = list.get(i).getConnectedClients();
                seriesBlockedClients[i] = list.get(i).getBlockedClients();
            }
            catch (Exception e)
            {
                LOGGER.error(e.getMessage());
            }
        }
        RedisStatusHistoryChartsDto redisStatusHistoryChartsDto = new RedisStatusHistoryChartsDto(xAxis, seriesQps,
            seriesKeys, seriesExpires, seriesExpiredKeys, seriesUsedMemory, seriesTotalMemory, seriesUsedPeakMemory,
            seriesUsedRssMemory, seriesCpuSys, seriesCpuUser, seriesConnectedClients, seriesBlockedClients);
        return redisStatusHistoryChartsDto;
    }

    /**
     * 根据时间区间获取redis历史数据
     * @Title: getRedisStatusHistoryByTimeRange   
     * @param serverId
     * @param timeRange
     * @return        
     * @throws
     */
    /**
     * 启用缓存，保证在短时间内（3分钟）数据直接从缓存中获取
     */
    private List<RedisStatusHistory> getRedisStatusHistoryByTimeRange(Long serverId, String timeRange)
    {
        String startTime = timeRange.split("-")[0].trim().replaceAll("/", "-");
        String endTime = timeRange.split("-")[1].trim().replaceAll("/", "-");
        RedisStatusHistoryExample redisStatusHistoryExample = new RedisStatusHistoryExample();
        cn.org.openwork.nosql.bean.RedisStatusHistoryExample.Criteria createCriteria =
            redisStatusHistoryExample.createCriteria();
        createCriteria.andServerIdEqualTo(serverId);
        createCriteria.andCreateTimeBetween(MiscUtil.strToDate(startTime), MiscUtil.strToDate(endTime));
        List<RedisStatusHistory> list = redisStatusHistoryMapper.selectByExample(redisStatusHistoryExample);
        //获取大量数据的采样结果
        return SysSampleUtil.getSysSample(list, Constant.SAMPLE_COUNT);
    }
    
    /**
     * 查询指定host、port节点是否已经存在
     * @Title: isRedisExist   
     * @param host
     * @param port
     * @return        
     * @throws
     */
    private boolean isRedisExist(String host, Integer port)
    {
        boolean isExist = false;
        RedisServerExample redisServerExample = new RedisServerExample();
        Criteria createCriteria = redisServerExample.createCriteria();
        createCriteria.andHostEqualTo(host);
        createCriteria.andPortEqualTo(port);
        List<RedisServer> list = redisServerMapper.selectByExample(redisServerExample);
        if (list != null && list.size() > 0)
        {
            isExist = true;
        }
        return isExist;
    }
    
    @Override
    public List<RedisCluster> getRedisClusters()
    {
        return redisClusterMapper.selectByExample(new RedisClusterExample());
    }
    
    @Override
    public ClusterNetworkDto getClusterNetworkById(Long clusterId)
    {
        ClusterNetworkDto clusterNetworkDto = new ClusterNetworkDto();
        RedisServerExample example = new RedisServerExample();
        example.createCriteria().andClusterIdEqualTo(clusterId);
        List<RedisServer> redisServers = redisServerMapper.selectByExample(example);
        List<RedisServerStatus> redisServerStatusList = getRedisServerStatusList(redisServers);
        clusterNetworkDto.setRedisServerStatus(redisServerStatusList);
        List<Relation> relations = getRelations(redisServers);
        clusterNetworkDto.setRelations(relations);
        return clusterNetworkDto;
    }
    
    /**
     * 获取redisserver的状态信息
     * @Title: getRedisServerStatusList   
     * @param redisServers
     * @return        
     * @throws
     */
    private List<RedisServerStatus> getRedisServerStatusList(List<RedisServer> redisServers)
    {
        List<RedisServerStatus> redisServerStatusList = new ArrayList<>();
        for (RedisServer redisServer : redisServers)
        {
            Long id = redisServer.getId();
            String host = redisServer.getHost();
            Integer port = redisServer.getPort();
            String tags = redisServer.getTags();
            String password = redisServer.getPassword();
            RedisServerStatus redisServerStatus = new RedisServerStatus();
            redisServerStatus.setId(id);
            redisServerStatus.setHost(host);
            redisServerStatus.setPort(String.valueOf(port));
            redisServerStatus.setTags(tags);
            String redisStatus = getRedisStatus(host, port, password);
            //如果redis未连接成功
            if (!redisStatus.equals(Constant.REDIS_PONG))
            {
                redisServerStatus.setStatus(Constant.REDIS_DISCONNECTED);
            }
            else
            {
                //如果redis连接成功，“状态”显示为当前的角色
                String redisInfo = getRedisInfo(redisServer);
                String role = getRedisInfoKeyValue(redisInfo, "role");
                redisServerStatus.setStatus(role);
            }
            redisServerStatusList.add(redisServerStatus);
        }
        return redisServerStatusList;
    }
    
    private List<Relation> getRelations(List<RedisServer> redisServers)
    {
        List<Relation> relations = new ArrayList<>();
        //遍历redis节点
        for (RedisServer redisServer : redisServers)
        {
            String redisInfo = getRedisInfo(redisServer);
            
            if (isSlave(redisInfo))
            {
                RedisServer master = getMaster(redisInfo);
                SlaveStatus slaveStatus = getSlaveStatus(redisInfo);
                if (master != null)
                {
                    Relation relation = new Relation(master, redisServer, slaveStatus);
                    relations.add(relation);
                }
            }
        }
        
        return relations;
    }
    
    /**
     * 获取redis从节点状态
     * @Title: getSlaveStatus   
     * @param redisInfo
     * @return        
     * @throws
     */
    private SlaveStatus getSlaveStatus(String redisInfo)
    {
        String masterLinkStatus = getRedisInfoKeyValue(redisInfo, "master_link_status");
        String masterLastIoSecondsAgo = getRedisInfoKeyValue(redisInfo, "master_last_io_seconds_ago");
        String masterSyncInProgress = getRedisInfoKeyValue(redisInfo, "master_sync_in_progress");
        String slaveReplOffset = getRedisInfoKeyValue(redisInfo, "slave_repl_offset");
        String slavePriority = getRedisInfoKeyValue(redisInfo, "slave_priority");
        String slaveReadOnly = getRedisInfoKeyValue(redisInfo, "slave_read_only");
        SlaveStatus slaveStatus = new SlaveStatus(masterLinkStatus, masterLastIoSecondsAgo, masterSyncInProgress,
            slaveReplOffset, slavePriority, slaveReadOnly);
        return slaveStatus;
    }
    
    /**
     * 获取主节点
     * @Title: getMaster   
     * @param redisInfo
     * @return        
     * @throws
     */
    private RedisServer getMaster(String redisInfo)
    {
        String masterHost = getRedisInfoKeyValue(redisInfo, "master_host");
        Integer masterPort = Integer.valueOf(getRedisInfoKeyValue(redisInfo, "master_port"));
        RedisServerExample example = new RedisServerExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andHostEqualTo(masterHost);
        createCriteria.andPortEqualTo(masterPort);
        List<RedisServer> redisServers = redisServerMapper.selectByExample(example);
        if (!redisServers.isEmpty())
        {
            return redisServers.get(0);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 判断该redis是否为从节点
     * @Title: isSlave   
     * @param redisInfo
     * @return        
     * @throws
     */
    private boolean isSlave(String redisInfo)
    {
        String role = getRedisInfoKeyValue(redisInfo, "role");
        if (role != null && role.endsWith(Constant.REDIS_SLAVE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public Object saveRedisCluster(Long id, String name)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        RedisCluster redisCluster = new RedisCluster();
        redisCluster.setName(name);
        redisCluster.setCreateTime(new Date());
        //判断是新增还是编辑，id为0是新增，不为0是编辑
        try
        {
            if (id == Constant.ZERO)
            {
                redisClusterMapper.insert(redisCluster);
            }
            else
            {
                redisCluster.setId(id);
                redisClusterMapper.updateByPrimaryKey(redisCluster);
            }
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        
        return restResponse;
    }
    
    @Override
    public Object deleteRedisCluster(Long id)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            // 删除redis server信息
            redisClusterMapper.deleteByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public List<RedisKeysDto> queryRedisKeys(Long id, Integer dbIndex, String keyPattern)
    {
        return queryRedisKeys(id, dbIndex,keyPattern, Constant.DEFAULT_MAX_KEYS_COUNT);
    }

    /**
     * 从debug信息中获取key占用空间大小
     * @Title: getKeySizeByDebug   
     * @param debug
     * @return        
     * @throws
     */
    private String getKeySizeByDebug(String debug)
    {
        String size="";
        try
        {
            int indexOfSerializedlength = debug.indexOf("serializedlength");
            String substringSerializedlength = debug.substring(indexOfSerializedlength);
            int indexOfSpace = substringSerializedlength.indexOf(" ");
            size = substringSerializedlength.substring("serializedlength".length()+1, indexOfSpace);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        
        return size;
    }

    @Override
    public List<RedisKeysDto> queryRedisKeys(Long id,Integer dbIndex, String keyPattern, Integer maxKeysCount)
    {
        RedisServer redisServer = redisServerMapper.selectByPrimaryKey(id);
        String host = redisServer.getHost();
        Integer port = redisServer.getPort();
        String password = redisServer.getPassword();
        Jedis jedis=null;
        List<RedisKeysDto> redisKeysDtos=new ArrayList<>();
        try
        {
            RedisUtil redisUtil = new RedisUtil(host, port, password);
            jedis = redisUtil.getJedis();
            jedis.select(dbIndex);
            Set<String> keys = jedis.keys(keyPattern);
            Integer keysCount=0;
            for (String key : keys)
            {
                //如果查询出的key条数大于设置的最大条数，则不再继续遍历
                if (keysCount>maxKeysCount)
                {
                    break;
                }
                //获取类型
                String type = jedis.type(key);
                //根据debug信息获取key占用空间大小
                DebugParams debugParams=DebugParams.OBJECT(key);
                String debug = jedis.debug(debugParams);
                String size=getKeySizeByDebug(debug);
                //获取剩余过期时间
                Long expires = jedis.ttl(key);
                
                RedisKeysDto redisKeysDto=new RedisKeysDto(key, type, size, String.valueOf(expires));
                redisKeysDtos.add(redisKeysDto);
                keysCount++;
            }  
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        finally
        {
            if (jedis != null)
            {
                jedis.close();
            }
        }
        return redisKeysDtos;
    }

    @Override
    public Object queryRedisValueByKey(Long id, Integer dbIndex, String key, String type)
    {
        return redisQuerier.query(id, dbIndex, key, type);
    }
    
    private Integer getExpiresFromDbInfo(String dbInfo)
    {
        String expires="0";
        try
        {
            int indexOfExpires = dbInfo.indexOf("expires");
            String substringExpires = dbInfo.substring(indexOfExpires);
            int indexOfComma = substringExpires.indexOf(",");
            expires = substringExpires.substring(0, indexOfComma).replace("expires=", "");  
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        
        return Integer.valueOf(expires);
    }

    private Integer getKeysFromDbInfo(String dbInfo)
    {
        String keys="0";
        try
        {
            int indexOfKeys = dbInfo.indexOf("keys");
            int indexOfComma = dbInfo.indexOf(",");
            keys = dbInfo.substring(indexOfKeys, indexOfComma).replace("keys=", "");  
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        
        return Integer.valueOf(keys);
    }
}
