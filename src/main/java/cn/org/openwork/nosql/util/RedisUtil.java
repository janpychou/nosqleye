/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  RedisUtil.java   
 * @Package cn.bqjr.mysqleye.util   
 * @Description:    Redis工具类
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年3月13日 下午2:10:08   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.util;

import java.util.Set;

import cn.org.openwork.nosql.bean.RedisServer;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: RedisUtil
 * @Description:Redis工具类
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月13日 下午2:10:08
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class RedisUtil
{
    private Jedis jedis;
    
    public RedisUtil(String host, int port, String auth)
    {
        // 连接redis服务器
        jedis = new Jedis(host, port);
        if (auth != null && !auth.isEmpty())
        {
            // 权限认证
            jedis.auth(auth);
        }
    }
    
    public RedisUtil(RedisServer redisServer)
    {
        String host=redisServer.getHost();
        Integer port = redisServer.getPort();
        String auth = redisServer.getPassword();
        // 连接redis服务器
        jedis = new Jedis(host, port);
        if (auth != null && !auth.isEmpty())
        {
            // 权限认证
            jedis.auth(auth);
        }
    }
    
    /**
     * @return the jedis
     */
    public Jedis getJedis()
    {
        return jedis;
    }
}
