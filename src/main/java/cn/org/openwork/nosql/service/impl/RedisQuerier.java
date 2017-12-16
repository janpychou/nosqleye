package cn.org.openwork.nosql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RedisDataTypeHash;
import cn.org.openwork.nosql.bean.RedisDataTypeList;
import cn.org.openwork.nosql.bean.RedisDataTypeSet;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.mapper.RedisServerMapper;
import cn.org.openwork.nosql.util.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

@Service
public class RedisQuerier
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisQuerier.class);
    
    @Resource
    private RedisServerMapper redisServerMapper;
    
    /**
     * 根据类型执行查询
     * @Title: query   
     * @param id
     * @param dbIndex
     * @param key
     * @param type
     * @return        
     * @throws
     */
    public Object query(Long id, Integer dbIndex, String key, String type)
    {
    	//BASE64解密
    	key=new String(Base64.decodeBase64(key));
        RedisServer redisServer = redisServerMapper.selectByPrimaryKey(id);
        Object result = null;
        switch (type)
        {
            case Constant.REDIS_TYPE_STRING:
                result = queryString(redisServer, dbIndex, key);
                break;
            case Constant.REDIS_TYPE_ZSET:
                result = queryZset(redisServer, dbIndex, key);
                break;
            case Constant.REDIS_TYPE_LIST:
                result = queryList(redisServer, dbIndex, key);
                break;
            case Constant.REDIS_TYPE_HASH:
                result = queryHash(redisServer, dbIndex, key);
                break;
            case Constant.REDIS_TYPE_SET:
                result = querySet(redisServer, dbIndex, key);
                break;
            default:
                break;
        }
        return result;
    }
    
    /**
     * 查询set类型数据
     * @Title: querySet   
     * @param redisServer
     * @param dbIndex
     * @param key
     * @return        
     * @throws
     */
    private Object querySet(RedisServer redisServer, Integer dbIndex, String key)
    {
        PagedDto<RedisDataTypeSet> pagedDto = null;
        Jedis jedis = null;
        try
        {
            jedis = getJedisAndSwitchDbIndex(redisServer,dbIndex);
            List<RedisDataTypeSet> redisDataTypeSets = new ArrayList<>();
            Set<String> queryResultSet = jedis.smembers(key);
            for (String value : queryResultSet)
            {
                redisDataTypeSets.add(new RedisDataTypeSet(value));
            }
            pagedDto = new PagedDto<>();
            pagedDto.setData(redisDataTypeSets);
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
        
        return pagedDto;
    }
    
    /**
     * 查询hash类型数据
     * @Title: queryHash   
     * @param redisServer
     * @param dbIndex
     * @param key
     * @return        
     * @throws
     */
    private Object queryHash(RedisServer redisServer, Integer dbIndex, String key)
    {
        PagedDto<RedisDataTypeHash> pagedDto = null;
        Jedis jedis = null;
        try
        {
            jedis = getJedisAndSwitchDbIndex(redisServer,dbIndex);
            Map<String, String> queryResultMap = jedis.hgetAll(key);
            List<RedisDataTypeHash> redisDataTypeHashs = new ArrayList<>();
            for (Map.Entry<String, String> entry : queryResultMap.entrySet())
            {
                RedisDataTypeHash redisDataTypeHash = new RedisDataTypeHash(entry.getKey(), entry.getValue());
                redisDataTypeHashs.add(redisDataTypeHash);
            }
            pagedDto = new PagedDto<>();
            pagedDto.setData(redisDataTypeHashs);
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
        
        return pagedDto;
    }
    
    /**
     * 查询list类型数据
     * @Title: queryList   
     * @param redisServer
     * @param dbIndex
     * @param key
     * @return        
     * @throws
     */
    private Object queryList(RedisServer redisServer, Integer dbIndex, String key)
    {
        Jedis jedis = null;
        PagedDto<RedisDataTypeList> pagedDto = null;
        try
        {
            jedis = getJedisAndSwitchDbIndex(redisServer,dbIndex);
            Long len = jedis.llen(key);
            List<String> queryResultList = jedis.lrange(key, 0, len);
            List<RedisDataTypeList> redisDataTypeLists = new ArrayList<>();
            for (String value : queryResultList)
            {
                redisDataTypeLists.add(new RedisDataTypeList(value));
            }
            pagedDto = new PagedDto<>();
            pagedDto.setData(redisDataTypeLists);
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
        return pagedDto;
    }
    /**
     * 查询zset类型数据
     * @Title: queryZset   
     * @param redisServer
     * @param dbIndex
     * @param key
     * @return        
     * @throws
     */
    @SuppressWarnings("deprecation")
    private Object queryZset(RedisServer redisServer, Integer dbIndex, String key)
    {
        Jedis jedis = null;
        PagedDto<Tuple> page = null;
        try
        {
            jedis = getJedisAndSwitchDbIndex(redisServer,dbIndex);
            List<Tuple> tuples = new ArrayList<>();
            //根据游标遍历有序集合，当遍历到游标=0时表示遍历完成
            int cursor = 0;
            while (true)
            {
                ScanResult<Tuple> scanResult = jedis.zscan(key, cursor);
                tuples.addAll(scanResult.getResult());
                cursor = scanResult.getCursor();
                if (cursor == 0)
                {
                    break;
                }
            }
            page = new PagedDto<>();
            page.setData(tuples);
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
        
        return page;
    }
    
    /**
     * 查询字符串类型数据
     * @Title: queryString   
     * @param redisServer
     * @param dbIndex
     * @param key
     * @return        
     * @throws
     */
    private Object queryString(RedisServer redisServer, Integer dbIndex, String key)
    {
        
        Jedis jedis = null;
        Object result = null;
        try
        {
            jedis = getJedisAndSwitchDbIndex(redisServer,dbIndex);
            result = jedis.get(key);
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
        
        return result;
    }

    /**
     * 获取jedis，并切换到相应db
     * @param redisServer
     * @param dbIndex
     * @return
     */
    private Jedis getJedisAndSwitchDbIndex(RedisServer redisServer,int dbIndex){
        RedisUtil redisUtil = new RedisUtil(redisServer);
        Jedis jedis = redisUtil.getJedis();
        jedis.select(dbIndex);
        return jedis;
    }
    
    public static String str2HexStr(String str)    
    {      
      
        char[] chars = "0123456789ABCDEF".toCharArray();      
        StringBuilder sb = new StringBuilder("");    
        byte[] bs = str.getBytes();      
        int bit;      
            
        for (int i = 0; i < bs.length; i++)    
        {      
            bit = (bs[i] & 0x0f0) >> 4;      
            sb.append(chars[bit]);      
            bit = bs[i] & 0x0f;      
            sb.append(chars[bit]);    
            sb.append(' ');    
        }      
        return sb.toString().trim();      
    }    
}
