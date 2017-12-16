/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  UpdateMongodbTopTask.java   
 * @Package cn.org.openwork.nosql.task   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月10日 下午5:23:15   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.task;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.MongodbServer;
import cn.org.openwork.nosql.bean.MongodbServerExample;
import cn.org.openwork.nosql.bean.MongodbTopHistory;
import cn.org.openwork.nosql.bean.MongodbTopHistoryExample;
import cn.org.openwork.nosql.bean.MongodbTopHistoryExample.Criteria;
import cn.org.openwork.nosql.mapper.MongodbServerMapper;
import cn.org.openwork.nosql.mapper.MongodbTopHistoryMapper;
import cn.org.openwork.nosql.util.MongodbUtil;

/**   
 * @ClassName:  UpdateMongodbTopTask   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年7月10日 下午5:23:15   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
@Component
public class UpdateMongodbTopTask
{
    
    @Resource
    private MongodbServerMapper mongodbServerMapper;
    
    @Resource
    private MongodbTopHistoryMapper mongodbTopHistoryMapper;
    
    public final static long DELAY_TIME = 3000;
    
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute()
    {
        List<MongodbServer> list = mongodbServerMapper.selectByExample(new MongodbServerExample());
        for (MongodbServer mongodbServer : list)
        {
            Long id = mongodbServer.getId();
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
            for (Map.Entry<String, Object> entry : total.entrySet())
            {
                JSONObject value = JSONObject.parseObject(entry.getValue().toString());
                MongodbTopHistory mongodbTopHistory = new MongodbTopHistory();
                String ns = entry.getKey();
                mongodbTopHistory.setNs(ns);
                Long totalCount = value.getJSONObject("total").getLong("count");
                mongodbTopHistory.setTotalCount(totalCount);
                mongodbTopHistory.setTotalTime(value.getJSONObject("total").getLong("time"));
                Long commandsCount = value.getJSONObject("commands").getLong("count");
                mongodbTopHistory.setCommandsCount(commandsCount);
                mongodbTopHistory.setCommandsTime(value.getJSONObject("commands").getLong("time"));
                Date createTime = new Date();
                mongodbTopHistory.setCreateTime(createTime);
                Long getMoreCount = value.getJSONObject("getmore").getLong("count");
                mongodbTopHistory.setGetMoreCount(getMoreCount);
                mongodbTopHistory.setGetMoreTime(value.getJSONObject("getmore").getLong("time"));
                Long insertCount = value.getJSONObject("insert").getLong("count");
                mongodbTopHistory.setInsertCount(insertCount);
                mongodbTopHistory.setInsertTime(value.getJSONObject("insert").getLong("time"));
                Long queriesCount = value.getJSONObject("queries").getLong("count");
                mongodbTopHistory.setQueriesCount(queriesCount);
                mongodbTopHistory.setQueriesTime(value.getJSONObject("queries").getLong("time"));
                Long readLockCount = value.getJSONObject("readLock").getLong("count");
                mongodbTopHistory.setReadLockCount(readLockCount);
                mongodbTopHistory.setReadLockTime(value.getJSONObject("readLock").getLong("time"));
                Long removeCount = value.getJSONObject("remove").getLong("count");
                mongodbTopHistory.setRemoveCount(removeCount);
                mongodbTopHistory.setRemoveTime(value.getJSONObject("remove").getLong("time"));
                mongodbTopHistory.setServerId(id);
                Long updateCount = value.getJSONObject("update").getLong("count");
                mongodbTopHistory.setUpdateCount(updateCount);
                mongodbTopHistory.setUpdateTime(value.getJSONObject("update").getLong("time"));
                Long writeLockCount = value.getJSONObject("writeLock").getLong("count");
                mongodbTopHistory.setWriteLockCount(writeLockCount);
                mongodbTopHistory.setWriteLockTime(value.getJSONObject("writeLock").getLong("time"));
                
                MongodbTopHistory lastMongodbTopHistory = getLastMongodbTopHistoryByNs(mongodbServer.getId(), ns);
                if (lastMongodbTopHistory != null)
                {
                    Date lastTime = lastMongodbTopHistory.getCreateTime();
                    
                    Long lastGetMoreCount = lastMongodbTopHistory.getGetMoreCount();
                    String getMoreCountPersecond =
                        getCountPersecond(lastGetMoreCount, getMoreCount, lastTime, createTime);
                    mongodbTopHistory.setGetMoreCountPersecond(getMoreCountPersecond);
                    
                    Long lastInsertCount = lastMongodbTopHistory.getInsertCount();
                    String insertCountPersecond = getCountPersecond(lastInsertCount, insertCount, lastTime, createTime);
                    mongodbTopHistory.setInsertCountPersecond(insertCountPersecond);
                    
                    Long lastQueriesCount = lastMongodbTopHistory.getQueriesCount();
                    String queriesCountPersecond =
                        getCountPersecond(lastQueriesCount, queriesCount, lastTime, createTime);
                    mongodbTopHistory.setQueriesCountPersecond(queriesCountPersecond);
                    
                    Long lastReadLockCount = lastMongodbTopHistory.getReadLockCount();
                    String readLockCountPersecond =
                        getCountPersecond(lastReadLockCount, readLockCount, lastTime, createTime);
                    mongodbTopHistory.setReadLockCountPersecond(readLockCountPersecond);
                    
                    Long lastRemoveCount = lastMongodbTopHistory.getRemoveCount();
                    String removeCountPersecond = getCountPersecond(lastRemoveCount, removeCount, lastTime, createTime);
                    mongodbTopHistory.setRemoveCountPersecond(removeCountPersecond);
                    
                    Long lastTotalCount = lastMongodbTopHistory.getTotalCount();
                    String totalCountPersecond = getCountPersecond(lastTotalCount, totalCount, lastTime, createTime);
                    mongodbTopHistory.setTotalCountPersecond(totalCountPersecond);
                    
                    Long lastUpdateCount = lastMongodbTopHistory.getUpdateCount();
                    String updateCountPersecond = getCountPersecond(lastUpdateCount, updateCount, lastTime, createTime);
                    mongodbTopHistory.setUpdateCountPersecond(updateCountPersecond);
                    
                    Long lastWriteLockCount = lastMongodbTopHistory.getWriteLockCount();
                    String writeLockCountPersecond =
                        getCountPersecond(lastWriteLockCount, writeLockCount, lastTime, createTime);
                    mongodbTopHistory.setWriteLockCountPersecond(writeLockCountPersecond);
                    
                }
                mongodbTopHistoryMapper.insert(mongodbTopHistory);
            }
        }
    }
    
    /**
     * 根据名称空间获取数据库中最新的一条TOP数据
     * @Title: getLaskMongodbTopHistoryByNs   
     * @param ns
     * @return        
     * @throws
     */
    private MongodbTopHistory getLastMongodbTopHistoryByNs(Long serverId, String ns)
    {
        MongodbTopHistoryExample example = new MongodbTopHistoryExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andServerIdEqualTo(serverId);
        createCriteria.andNsEqualTo(ns);
        example.setOrderByClause("id desc");
        example.setLimitStart(1);
        example.setPageSize(1);
        
        List<MongodbTopHistory> list = mongodbTopHistoryMapper.selectByExample(example);
        MongodbTopHistory mongodbTopHistory = null;
        if (list != null && !list.isEmpty())
        {
            mongodbTopHistory = list.get(0);
        }
        return mongodbTopHistory;
    }
    
    private String getCountPersecond(Long lastCount, Long currentCount, Date lastTime, Date currentTime)
    {
        if ((currentCount == null) || (lastCount == null))
        {
            return Constant.ZERO.toString();
        }
        
        if (new BigDecimal(currentCount).compareTo(new BigDecimal(lastCount)) == 1)
        {
            Long second = diffSecond(lastTime, currentTime);
            Long count = currentCount - lastCount;
            BigDecimal resultBigDecimal =
                new BigDecimal(count).divide(new BigDecimal(second), 2, BigDecimal.ROUND_HALF_EVEN);
            
            String result = resultBigDecimal.toString();
            // 如果为负数则设为零
            if (result.indexOf("-") != -1)
            {
                result = Constant.ZERO.toString();
            }
            return result;
        }
        else
        {
            return Constant.ZERO.toString();
        }
    }
    
    private Long diffSecond(Date lastTime, Date currentTime)
    {
        long second = (currentTime.getTime() - lastTime.getTime()) / 1000;
        //如果秒数相差为0，则置为1
        if (second == 0)
        {
            second = 1L;
        }
        return second;
    }
}
