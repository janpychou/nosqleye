/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  RedisController.java   
 * @Package cn.org.openwork.nosql.controller   
 * @Description:    Redis Controller
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年6月28日 下午2:10:46   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.org.openwork.nosql.bean.ClusterNetworkDto;
import cn.org.openwork.nosql.service.RedisService;

/**   
 * @ClassName:  RedisController   
 * @Description:Redis Controller
 * @author: 李平(360841519@qq.com)
 * @date:   2017年6月28日 下午2:10:46   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
@RestController
@RequestMapping(value = "/api")
public class RedisController
{
    @Resource
    private RedisService redisService;
    
    /**
     * 获取redis服务器列表
     * @Title: getRedisList   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-redis-list")
    public Object getRedisList(HttpServletRequest request, HttpServletResponse response)
    {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int startIndex = Integer.parseInt(request.getParameter("start"));
        int pageSize = Integer.parseInt(request.getParameter("length"));
        //搜索条件
        String search = request.getParameter("search[value]");
        return redisService.getRedisList(draw, startIndex, pageSize, search);
    }
    
    /**
     * 获取redis信息
     * @Title: getRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-redis")
    public Object getRedis(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.getRedis(id);
    }
    
    /**
     * 保存redis信息
     * @Title: saveRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/save-redis")
    public Object saveRedis(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String host = request.getParameter("host");
        Integer port = Integer.valueOf(request.getParameter("port"));
        String password = request.getParameter("password");
        String tags = request.getParameter("tags");
        Long clusterId=Long.valueOf(request.getParameter("clusterId"));
        return redisService.saveRedis(id, host, port, password, tags, clusterId);
    }
    
    /**
     * 删除redis服务器
     * @Title: deleteRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/delete-redis")
    public Object deleteRedis(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.deleteRedis(id);
    }
    
    /**
     * 备份redis数据库
     * @Title: backupRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/backup-redis")
    public Object backupRedis(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.backupRedis(id);
    }
    
    /**
     * 获取redis服务器数量
     * @Title: countRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/count-redis")
    public Object countRedis(HttpServletRequest request, HttpServletResponse response)
    {
        return redisService.countRedis();
    }
    
    /**
     * 获取redis详情
     * @Title: getRedisDetail   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-redis-detail")
    public Object getRedisDetail(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.getRedisDetail(id);
    }
    
    /**
     * 获取redis实时监控数据
     * @Title: getRedisMonitoring   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-redis-monitoring")
    public Object getRedisMonitoring(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.getRedisMonitoring(id);
    }
    
    /**
     * 获取redis 历史图表数据
     * @Title: getRedisStatusHistoryChart   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-redis-status-history-chart")
    public Object getRedisStatusHistoryChart(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String timeRange = request.getParameter("timeRange");
        return redisService.getRedisStatusHistoryChart(id,timeRange);
    }
    
    @RequestMapping(value = "/get-redis-clusters")
    public Object getRedisClusters(HttpServletRequest request, HttpServletResponse response)
    {
        return redisService.getRedisClusters();
    }
    
    /**
     * 获取指定集群的拓扑节点信息
     * @Title: getClusterNetWorkById   
     * @return        
     * @throws
     */
    @RequestMapping("/get-redis-cluster-network")
    public ClusterNetworkDto getClusterNetworkById(HttpServletRequest request) {
        //请求数据
        Long clusterId = Long.valueOf(request.getParameter("clusterId"));
        return redisService.getClusterNetworkById(clusterId);
    }
    /**
     * 保存redis集群信息
     * @Title: saveRedisCluster   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/save-redis-cluster")
    public Object saveRedisCluster(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        return redisService.saveRedisCluster(id, name);
    }
    /**
     * 删除redis集群信息
     * @Title: deleteRedisCluster   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/delete-redis-cluster")
    public Object deleteRedisCluster(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return redisService.deleteRedisCluster(id);
    }
    /**
     * 查询redis数据
     * @Title: queryRedis   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/query-redis-keys")
    public Object queryRedisKeys(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        Integer dbIndex = Integer.valueOf(request.getParameter("dbIndex"));
        String keyPattern = request.getParameter("keyPattern");
        return redisService.queryRedisKeys(id,dbIndex, keyPattern);
    }
    
    @RequestMapping(value = "/query-redis-value-by-key")
    public Object queryRedisValueByKey(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        Integer dbIndex = Integer.valueOf(request.getParameter("dbIndex"));
        String key = request.getParameter("key");
        String type = request.getParameter("type");
        return redisService.queryRedisValueByKey(id,dbIndex,key, type);
    }
}
