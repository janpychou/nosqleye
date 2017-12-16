/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  AbstractRedisService.java   
 * @Package cn.org.openwork.nosql.service.impl   
 * @Description:    AbstractRedisService 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月4日 上午9:52:34   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.util.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: AbstractRedisService
 * @Description:AbstractRedisService
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月4日 上午9:52:34
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class AbstractRedisService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRedisService.class);
    private int disConnectCount = 0;
    
    /**
     * 使用info命令获取redis状态信息
     * @Title: getRedisInfo   
     * @param redisServer
     * @return        
     * @throws
     */
    protected String getRedisInfo(RedisServer redisServer)
    {
        String host = redisServer.getHost();
        Integer port = redisServer.getPort();
        String password = redisServer.getPassword();
        String info = null;
        Jedis jedis = null;
        try
        {
            RedisUtil redisUtil = new RedisUtil(host, port, password);
            jedis = redisUtil.getJedis();
            info = jedis.info();
            
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            info = null;
        }
        finally
        {
            if (jedis != null)
            {
                jedis.close();
            }
        }
        
        return info;
    }
    /**
     * 根据分段获取redis info信息
     * @Title: getRedisInfoBySection   
     * @param redisServer
     * @param section
     * @param key
     * @return        
     * @throws
     */
    protected String getRedisInfoBySection(RedisServer redisServer,String section){
        Jedis jedis=null;
        String value="";
        try
        {
            RedisUtil redisUtil = new RedisUtil(redisServer);
            jedis = redisUtil.getJedis();
            String sectionInfo = jedis.info(section);
            String needRemove="# "+section;
            value=sectionInfo.replaceAll(needRemove, "").trim();
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        finally {
            if (jedis != null)
            {
                jedis.close();
            }
        }
        return value;
        
    }
    /**
     * 在info结果中获取指定key的值
     * @Title: getRedisInfoKeyValue   
     * @param info
     * @param key
     * @return        
     * @throws
     */
    protected String getRedisInfoKeyValue(String info, String key)
    {
        if (info == null)
        {
            return null;
        }
        String value = "";
        try
        {
            String keyMore = info.substring(info.indexOf(key));
            int prefixLength = new String(key + ":").length();
            value = keyMore.substring(prefixLength, keyMore.indexOf("\n")).replaceAll("\r", "").trim();
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            value = "";
        }
        
        return value;
    }
    
    /**
     * redis是否可以连接
     * @Title: isConnRedis   
     * @param host
     * @param port
     * @param password
     * @return        
     * @throws
     */
    protected boolean isConnRedis(String host, Integer port, String password)
    {
        boolean isConn = false;
        String ping = getRedisStatus(host, port, password);
        if (ping.equals("PONG"))
        {
            isConn = true;
        }
        return isConn;
    }
    
    protected boolean isConnRedisRetry(String host, Integer port, String password)
    {
        boolean isConn = false;
        String ping = getRedisStatus(host, port, password);
        //如果ping通，返回true，如果ping不通，则每隔1秒尝试一次重连，如果3次重连失败，则认为连接失败
        if (ping.equals("PONG"))
        {
            isConn = true;
        }
        else
        {
            //未连同计数加1
            disConnectCount++;
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (disConnectCount > Constant.REDIS_MAX_DISCONNECT_COUNT)
            {
                return false;
            }
            //重连
            isConnRedisRetry(host, port, password);
        }
        return isConn;
    }
    
    /**
     * 获取redis连接结果
     * @Title: getRedisStatus   
     * @param host
     * @param port
     * @param password
     * @return        
     * @throws
     */
    protected String getRedisStatus(String host, Integer port, String password)
    {
        String status = "";
        Jedis jedis = null;
        try
        {
            RedisUtil redisUtil = new RedisUtil(host, port, password);
            jedis = redisUtil.getJedis();
            status = jedis.ping();
        }
        catch (Exception e)
        {
            status = e.getMessage();
            LOGGER.error(e.getMessage());
        }
        finally
        {
            if (jedis != null)
            {
                jedis.close();
            }
        }
        return status;
    }
}
