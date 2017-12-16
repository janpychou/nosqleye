/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  ApiService.java   
 * @Package cn.bqjr.redis.agent.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年6月28日 下午2:13:28   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.service;

import java.util.List;

import cn.org.openwork.nosql.bean.ClusterNetworkDto;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RedisCluster;
import cn.org.openwork.nosql.bean.RedisDetailDto;
import cn.org.openwork.nosql.bean.RedisKeysDto;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.bean.RedisServerDto;
import cn.org.openwork.nosql.bean.RedisStatusHistory;
import cn.org.openwork.nosql.bean.RedisStatusHistoryChartsDto;
import cn.org.openwork.nosql.bean.RestResponse;

/**
 * @ClassName: ApiService
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年6月28日 下午2:13:28
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public interface RedisService
{
    /**
     * 获取redis服务器信息
     * @Title: getInfo 
     * @param redisServerId 
     * @return 
     * @throws
     */
    public RestResponse<String> getInfo(Long redisServerId);
    
    /**
     * 获取redis服务器列表
     * @Title: getRedisList   
     * @return        
     * @throws
     */
    public PagedDto<RedisServerDto> getRedisList(int draw, int startIndex, int pageSize, String search);
    
    /**
     * 新增redis
     * @Title: addRedis   
     * @param host
     * @param port
     * @param password
     * @return        
     * @throws
     */
    public RestResponse<String> saveRedis(Long id, String host, Integer port, String password, String tags,
        Long clusterId);
    
    /**
     * 删除redis节点
     * @Title: deleteRedis   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<String> deleteRedis(Long id);
    
    /**
     * 备份Redis
     * @Title: backupRedis   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<String> backupRedis(Long id);
    
    /**
     * 获取redis节点信息
     * @Title: getRedis   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<RedisServer> getRedis(Long id);
    
    /**
     * 获取redis节点数量
     * @Title: countRedis   
     * @return        
     * @throws
     */
    public RestResponse<Integer> countRedis();
    
    /**
     * 获取Redis详细信息
     * @Title: getRedisDetail   
     * @param id
     * @return        
     * @throws
     */
    public PagedDto<RedisDetailDto> getRedisDetail(Long id);
    
    /**
     * 获取Redis实时监控数据
     * @Title: getRedisMonitoring   
     * @param id
     * @return        
     * @throws
     */
    public PagedDto<RedisStatusHistory> getRedisMonitoring(Long id);
    
    /**
     * 获取redis历史数据
     * @Title: getRedisStatusHistoryChart   
     * @param id
     * @param timeRange
     * @return        
     * @throws
     */
    public RedisStatusHistoryChartsDto getRedisStatusHistoryChart(Long id, String timeRange);
    
    /**
     * 获取redis集群列表
     * @Title: getRedisClusters   
     * @return        
     * @throws
     */
    public List<RedisCluster> getRedisClusters();
    
    /**
     * 获取指定集群的拓扑图
     * @Title: getClusterNetworkById   
     * @param clusterId
     * @return        
     * @throws
     */
    public ClusterNetworkDto getClusterNetworkById(Long clusterId);
    
    /**
     * 保存redis集群信息
     * @Title: saveRedisCluster   
     * @param id
     * @param name
     * @return        
     * @throws
     */
    public Object saveRedisCluster(Long id, String name);
    
    /**
     * 删除redis集群信息
     * @Title: deleteRedisCluster   
     * @param id
     * @return        
     * @throws
     */
    public Object deleteRedisCluster(Long id);
    
    /**
     * @param dbIndex TODO
     * 查询redis key
     * @Title: queryRedisKeys   
     * @param id
     * @return        
     * @throws
     */
    public List<RedisKeysDto> queryRedisKeys(Long id, Integer dbIndex, String keyPattern);
    
    /**
     * 查询redis key，并设置最大返回条数
     * @Title: queryRedisKeys   
     * @param id
     * @param dbIndex
     * @param keyPattern
     * @param maxKeysCount
     * @return        
     * @throws
     */
    public List<RedisKeysDto> queryRedisKeys(Long id, Integer dbIndex, String keyPattern, Integer maxKeysCount);
    
    /**
     * 查询redis指定key的值
     * @Title: queryRedisValueByKey   
     * @param id
     * @param dbIndex
     * @param key
     * @param type
     * @return        
     * @throws
     */
    public Object queryRedisValueByKey(Long id, Integer dbIndex, String key, String type);
}
