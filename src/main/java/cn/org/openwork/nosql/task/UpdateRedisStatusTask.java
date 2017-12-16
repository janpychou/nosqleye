package cn.org.openwork.nosql.task;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.bean.RedisServerExample;
import cn.org.openwork.nosql.bean.RedisStatusHistory;
import cn.org.openwork.nosql.mapper.RedisServerMapper;
import cn.org.openwork.nosql.mapper.RedisStatusHistoryMapper;
import cn.org.openwork.nosql.service.impl.AbstractRedisService;

@Component
public class UpdateRedisStatusTask extends AbstractRedisService
{
    @Resource
    private RedisServerMapper redisServerMapper;
    
    @Resource
    private RedisStatusHistoryMapper redisStatusHistoryMapper;
    
    public final static long DELAY_TIME = 3000;
    
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute()
    {
        // 遍历redis server
        List<RedisServer> redisServers = redisServerMapper.selectByExample(new RedisServerExample());
        for (RedisServer redisServer : redisServers)
        {
            String host = redisServer.getHost();
            Integer port = redisServer.getPort();
            String password = redisServer.getPassword();
            if (isConnRedis(host, port, password))
            {
                // 使用info命令获取redis状态信息
                String info = getRedisInfo(redisServer);
                //将info中的数据转为RedisStatusHistory对象
                RedisStatusHistory redisStatusHistory = getRedisStatusHistory(info, redisServer);
                // 将该节点的info数据存入MySQL
                redisStatusHistoryMapper.insert(redisStatusHistory);
            }
        }
    }
    
    /**
     * 将redis info数据封装为RedisStatusHistory对象
     * @Title: getRedisStatusHistory   
     * @param info
     * @return        
     * @throws
     */
    private RedisStatusHistory getRedisStatusHistory(String info, RedisServer redisServer)
    {
        RedisStatusHistory redisStatusHistory = new RedisStatusHistory();
        redisStatusHistory.setBlockedClients(getRedisInfoKeyValue(info, "blocked_clients").trim());
        redisStatusHistory.setConnectedClients(getRedisInfoKeyValue(info, "connected_clients").trim());
        redisStatusHistory.setCreateTime(new Date());
        redisStatusHistory.setExpiredKeys(getRedisInfoKeyValue(info, "expired_keys").trim());
        redisStatusHistory.setInstantaneousOpsPerSec(getRedisInfoKeyValue(info, "instantaneous_ops_per_sec").trim());
        redisStatusHistory.setKeyspace(getRedisInfoBySection(redisServer, "Keyspace"));
        redisStatusHistory.setTotalCommandsProcessed(getRedisInfoKeyValue(info, "total_commands_processed").trim());
        redisStatusHistory.setTotalConnectionsReceived(getRedisInfoKeyValue(info, "total_connections_received").trim());
        redisStatusHistory.setTotalNetInputBytes(getRedisInfoKeyValue(info, "total_net_input_bytes").trim());
        redisStatusHistory.setTotalNetOutputBytes(getRedisInfoKeyValue(info, "total_net_output_bytes").trim());
        redisStatusHistory.setTotalSystemMemory(getRedisInfoKeyValue(info, "total_system_memory").trim());
        redisStatusHistory.setTotalSystemMemoryHuman(getRedisInfoKeyValue(info, "total_system_memory_human").trim());
        redisStatusHistory.setUsedCpuSys(getRedisInfoKeyValue(info, "used_cpu_sys").trim());
        redisStatusHistory.setUsedCpuUser(getRedisInfoKeyValue(info, "used_cpu_user").trim());
        redisStatusHistory.setUsedMemory(getRedisInfoKeyValue(info, "used_memory").trim());
        redisStatusHistory.setUsedMemoryHuman(getRedisInfoKeyValue(info, "used_memory_human").trim());
        redisStatusHistory.setUsedMemoryPeak(getRedisInfoKeyValue(info, "used_memory_peak").trim());
        redisStatusHistory.setUsedMemoryPeakHuman(getRedisInfoKeyValue(info, "used_memory_peak_human").trim());
        redisStatusHistory.setUsedMemoryRss(getRedisInfoKeyValue(info, "used_memory_rss").trim());
        redisStatusHistory.setUsedMemoryRssHuman(getRedisInfoKeyValue(info, "used_memory_rss_human").trim());
        redisStatusHistory.setMemFragmentationRatio(getRedisInfoKeyValue(info, "mem_fragmentation_ratio").trim());
        redisStatusHistory.setServerId(redisServer.getId());
        return redisStatusHistory;
    }
}
