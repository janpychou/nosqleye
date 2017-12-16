/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongodbServiceImpl.java   
 * @Package cn.org.openwork.nosql.service.impl   
 * @Description:    mongodb service实现 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月7日 下午1:51:06   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.MongodbHostInfoDto;
import cn.org.openwork.nosql.bean.MongodbListDatabasesDto;
import cn.org.openwork.nosql.bean.MongodbOverviewDto;
import cn.org.openwork.nosql.bean.MongodbServer;
import cn.org.openwork.nosql.bean.MongodbServerDto;
import cn.org.openwork.nosql.bean.MongodbServerExample;
import cn.org.openwork.nosql.bean.MongodbServerExample.Criteria;
import cn.org.openwork.nosql.bean.MongodbTopHistory;
import cn.org.openwork.nosql.bean.MongodbTopHistoryExample;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RestResponse;
import cn.org.openwork.nosql.mapper.MongodbServerMapper;
import cn.org.openwork.nosql.mapper.MongodbTopHistoryMapper;
import cn.org.openwork.nosql.service.MongodbService;
import cn.org.openwork.nosql.util.MiscUtil;
import cn.org.openwork.nosql.util.MongodbUtil;

/**
 * @ClassName: MongodbServiceImpl
 * @Description:mongodb service实现
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月7日 下午1:51:06
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class MongodbServiceImpl implements MongodbService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MongodbServiceImpl.class);
    
    @Resource
    private MongodbServerMapper mongodbServerMapper;
    
    @Resource
    private MongodbTopHistoryMapper mongodbTopHistoryMapper;
    
    @Override
    public PagedDto<MongodbServerDto> getMongodbList(int draw, int startIndex, int pageSize)
    {
        PagedDto<MongodbServerDto> pagedDto=null;
        try
        {
            MongodbServerExample mongodbServerExample = new MongodbServerExample();
            mongodbServerExample.setLimitStart(startIndex);
            mongodbServerExample.setPageSize(pageSize);
            mongodbServerExample.setOrderByClause("id desc");
            List<MongodbServer> MongodbServerList = mongodbServerMapper.selectByExample(mongodbServerExample);
            List<MongodbServerDto> mongodbServerDtoList = new ArrayList<>();
            for (MongodbServer mongodbServer : MongodbServerList)
            {
                MongodbServerDto mongodbServerDto = new MongodbServerDto();
                mongodbServerDto.setCreateTime(mongodbServer.getCreateTime());
                mongodbServerDto.setHost(mongodbServer.getHost());
                mongodbServerDto.setId(mongodbServer.getId());
                mongodbServerDto.setPassword(mongodbServer.getPassword());
                mongodbServerDto.setPort(mongodbServer.getPort());
                mongodbServerDto.setTags(mongodbServer.getTags());
                CommandResult commandResult = getMongodbStatus(mongodbServer.getHost(),
                    Integer.valueOf(mongodbServer.getPort()),
                    mongodbServer.getUsername(),
                    mongodbServer.getPassword());
                if (commandResult == null)
                {
                    mongodbServerDto.setStatus(Constant.ABNORMAL);
                }
                else
                {
                    mongodbServerDto.setStatus(Constant.OK);
                    // 获取Mongodb info字符串
                    Long uptime = commandResult.getLong("uptime");
                    mongodbServerDto.setUptime(MiscUtil.getHumanTimeBySeconds(uptime));
                }
                mongodbServerDtoList.add(mongodbServerDto);
            }
            int count = mongodbServerMapper.countByExample(null);
            pagedDto = new PagedDto<>();
            pagedDto.setData(mongodbServerDtoList);
            pagedDto.setDraw(draw);
            pagedDto.setRecordsFiltered(count);
            pagedDto.setRecordsTotal(count);
            return pagedDto;
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        return pagedDto;
    }
    
    @Override
    public RestResponse<String> deleteMongodb(Long id)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            mongodbServerMapper.deleteByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
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
    public RestResponse<String> saveMongodb(Long id, String host, String port, String username, String password,
        String tags)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        try
        {
            // 判断redis是否可以连接成功
            if (isConnMongodb(host, port, username, password))
            {
                MongodbServer mongodbServer = new MongodbServer();
                mongodbServer.setCreateTime(new Date());
                mongodbServer.setUsername(username);
                mongodbServer.setPassword(password);
                mongodbServer.setPort(port);
                mongodbServer.setHost(host);
                mongodbServer.setTags(tags);
                // 当id为0，是新增
                if (id == Constant.ZERO)
                {
                    // 判断节点是否已经存在
                    if (isMongodbExist(host, port))
                    {
                        restResponse.setCode(Constant.FAIL_REDIS_EXIST_CODE);
                        restResponse.setMessage(Constant.FAIL_REDIS_EXIST_MESSAGE);
                        // 如果节点已经存在直接返回
                        return restResponse;
                    }
                    else
                    {
                        mongodbServerMapper.insert(mongodbServer);
                    }
                }
                // 否则为更新
                else
                {
                    mongodbServer.setId(id);
                    mongodbServerMapper.updateByPrimaryKey(mongodbServer);
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
            LOGGER.error(e.getMessage());
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<Integer> countMongodb()
    {
        RestResponse<Integer> restResponse = new RestResponse<>();
        try
        {
            int count = mongodbServerMapper.countByExample(new MongodbServerExample());
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(count);
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
    public RestResponse<MongodbServer> getMongodb(Long id)
    {
        RestResponse<MongodbServer> restResponse = new RestResponse<>();
        try
        {
            MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(mongodbServer);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    
    
    @Override
    public PagedDto<MongodbOverviewDto> getMongodbOverview(Long id)
    {
        // 获取mongodb信息
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        String host = mongodbServer.getHost();
        String port = mongodbServer.getPort();
        String username = mongodbServer.getUsername();
        String password = mongodbServer.getPassword();
        // 获取serversStatus命令结果
        Map<String, Integer> map = new HashMap<>();
        map.put("serverStatus", 1);
        map.put("version", 1);
        map.put("pid", 1);
        DBObject dbObject = new BasicDBObject(map);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject jsonObjectServersStatus =
            mongodbUtil.getMongodbCommandResult(host, port, username, password, dbObject);
        
        JSONObject jsonObjectIsMaster =
            mongodbUtil.getMongodbCommandResult(host, port, username, password, new BasicDBObject("isMaster", 1));
        
        MongodbOverviewDto dto = new MongodbOverviewDto();
        dto.setHost(host);
        dto.setPort(port);
        dto.setVersion(jsonObjectServersStatus.getString("version"));
        Long uptime = jsonObjectServersStatus.getLong("uptime");
        dto.setUptime(MiscUtil.getHumanTimeBySeconds(uptime));
        dto.setPid(jsonObjectServersStatus.getJSONObject("pid").getString("$numberLong"));
        dto.setIsMaster(jsonObjectIsMaster.getString("ismaster"));
        List<MongodbOverviewDto> data = new ArrayList<>();
        data.add(dto);
        PagedDto<MongodbOverviewDto> pagedDto = new PagedDto<>();
        pagedDto.setData(data);
        return pagedDto;
    }
    
    @Override
    public List<String> getMongodbTopNs(Long id)
    {
        // 获取mongodb信息
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        String host = mongodbServer.getHost();
        String port = mongodbServer.getPort();
        String username = mongodbServer.getUsername();
        String password = mongodbServer.getPassword();
        DBObject dbObject = new BasicDBObject("top", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(host, port, username, password, dbObject);
        JSONObject total = commandResult.getJSONObject("totals");
        total.remove("note");
        total.remove("ok");
        List<String> nsList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : total.entrySet())
        {
            nsList.add(entry.getKey());
        }
        return nsList;
    }
    
    @Override
    public PagedDto<MongodbTopHistory> getMongodbTopHistory(Long id, String ns)
    {
        if (ns.equals("null"))
        {
            ns = getMongodbTopNs(id).get(0);
        }
        MongodbTopHistoryExample mongodbTopHistoryExample = new MongodbTopHistoryExample();
        cn.org.openwork.nosql.bean.MongodbTopHistoryExample.Criteria createCriteria =
            mongodbTopHistoryExample.createCriteria();
        createCriteria.andServerIdEqualTo(id);
        createCriteria.andNsEqualTo(ns);
        mongodbTopHistoryExample.setLimitStart(0);
        mongodbTopHistoryExample.setPageSize(10);
        mongodbTopHistoryExample.setOrderByClause("id desc");
        List<MongodbTopHistory> data = mongodbTopHistoryMapper.selectByExample(mongodbTopHistoryExample);
        PagedDto<MongodbTopHistory> pagedDto = new PagedDto<>();
        pagedDto.setData(data);
        return pagedDto;
    }
    
    @Override
    public PagedDto<MongodbListDatabasesDto> getMongodbListDatabases(Long id)
    {
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        String host = mongodbServer.getHost();
        String port = mongodbServer.getPort();
        String username = mongodbServer.getUsername();
        String password = mongodbServer.getPassword();
        DBObject dbObject = new BasicDBObject("listDatabases", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(host, port, username, password, dbObject);
        JSONArray jsonArray = commandResult.getJSONArray("databases");
        List<MongodbListDatabasesDto> data = new ArrayList<>();
        for (Object object : jsonArray)
        {
            MongodbListDatabasesDto dto = new MongodbListDatabasesDto();
            JSONObject jsonObject = (JSONObject)object;
            dto.setName(jsonObject.getString("name"));
            Long sizeOnDiskBytes = jsonObject.getLong("sizeOnDisk");
            dto.setSizeOnDisk(MiscUtil.getHumanSizeByBytes(sizeOnDiskBytes));
            data.add(dto);
        }
        PagedDto<MongodbListDatabasesDto> pagedDto = new PagedDto<>();
        pagedDto.setData(data);
        return pagedDto;
    }
    
    @Override
    public PagedDto<MongodbHostInfoDto> getMongodbHostInfo(Long id)
    {
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        String host = mongodbServer.getHost();
        String port = mongodbServer.getPort();
        String username = mongodbServer.getUsername();
        String password = mongodbServer.getPassword();
        DBObject dbObject = new BasicDBObject("hostInfo", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(host, port, username, password, dbObject);
        MongodbHostInfoDto dto = new MongodbHostInfoDto();
        Long currentTimeStr = commandResult.getJSONObject("system").getJSONObject("currentTime").getLong("$date");
        Date date = new Date(currentTimeStr);
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(date);
        Integer cpuAddrSize = commandResult.getJSONObject("system").getInteger("cpuAddrSize");
        Integer memSizeMB = commandResult.getJSONObject("system").getInteger("memSizeMB");
        Integer cpuNumCores = commandResult.getJSONObject("system").getInteger("numCores");
        Boolean numaEnabled = commandResult.getJSONObject("system").getBoolean("numaEnabled");
        String osName = commandResult.getJSONObject("os").getString("name");
        String osVersion = commandResult.getJSONObject("os").getString("version");
        dto.setCpuAddrSize(cpuAddrSize);
        dto.setCpuNumCores(cpuNumCores);
        dto.setCurrentTime(currentTime);
        dto.setMemSizeMB(memSizeMB);
        dto.setNumaEnabled(numaEnabled);
        dto.setOsName(osName);
        dto.setOsVersion(osVersion);
        List<MongodbHostInfoDto> data = new ArrayList<>();
        data.add(dto);
        PagedDto<MongodbHostInfoDto> pagedDto = new PagedDto<>();
        pagedDto.setData(data);
        return pagedDto;
    }
    
    @Override
    public Object getMongodbReplSetGetStatus(Long id)
    {
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        DBObject dbObject = new BasicDBObject("replSetGetStatus", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(mongodbServer, dbObject);
        return commandResult.toJSONString();
    }
    
    @Override
    public Object getMongodbReplSetGetConfig(Long id)
    {
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        DBObject dbObject = new BasicDBObject("replSetGetConfig", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(mongodbServer, dbObject);
        return commandResult.toJSONString();
    }
    
    @Override
    public Object getMongodbLockInfo(Long id)
    {
        MongodbServer mongodbServer = mongodbServerMapper.selectByPrimaryKey(id);
        DBObject dbObject = new BasicDBObject("lockInfo", 1);
        MongodbUtil mongodbUtil = new MongodbUtil();
        JSONObject commandResult = mongodbUtil.getMongodbCommandResult(mongodbServer, dbObject);
        return commandResult.toJSONString();
    }
    /**
     * 检查mongodb节点在数据库中是否已经存在
     * @Title: isMongodbExist   
     * @param host
     * @param port
     * @return        
     * @throws
     */
    private boolean isMongodbExist(String host, String port)
    {
        boolean isExist = false;
        MongodbServerExample mongodbServerExample = new MongodbServerExample();
        Criteria createCriteria = mongodbServerExample.createCriteria();
        createCriteria.andHostEqualTo(host);
        createCriteria.andPortEqualTo(port);
        List<MongodbServer> list = mongodbServerMapper.selectByExample(mongodbServerExample);
        if (list != null && list.size() > 0)
        {
            isExist = true;
        }
        return isExist;
    }
    /**
     * 检查mongodb是否连接成功
     * @Title: isConnMongodb   
     * @param host
     * @param port
     * @param username
     * @param password
     * @return        
     * @throws
     */
    private boolean isConnMongodb(String host, String port, String username, String password)
    {
        boolean isConn = false;
        CommandResult commandResult = getMongodbStatus(host, Integer.valueOf(port), username, password);
        if (commandResult != null)
        {
            isConn = true;
        }
        
        return isConn;
    }
    /**
     * 获取mongodb状态
     * @Title: getMongodbStatus   
     * @param host
     * @param port
     * @param username
     * @param password
     * @return        
     * @throws
     */
    private CommandResult getMongodbStatus(String host, Integer port, String username, String password)
    {
        String sURI = "";
        if ((username == null || username.isEmpty()) && (password == null || password.isEmpty()))
        {
            sURI = String.format("mongodb://" + host + ":" + port);
        }
        else
        {
            sURI = String.format("mongodb://" + username + ":" + password + "@" + host + ":" + port);
        }
        CommandResult commandResult = null;
        try
        {
            MongoClientURI uri = new MongoClientURI(sURI);
            MongoClient mongoClient = new MongoClient(uri);
            // 设置连接超时时间
            List<String> databaseNames = mongoClient.getDatabaseNames();
            if (!databaseNames.isEmpty())
            {
                DB db = mongoClient.getDB(databaseNames.get(0));
                commandResult = db.command("serverStatus");
            }
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            commandResult = null;
        }
        return commandResult;
    }
}
