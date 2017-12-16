package cn.org.openwork.nosql.task;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.org.openwork.nosql.bean.AlertConfig;
import cn.org.openwork.nosql.bean.AlertConfigExample;
import cn.org.openwork.nosql.bean.AlertList;
import cn.org.openwork.nosql.bean.Constant;
import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.mapper.AlertConfigMapper;
import cn.org.openwork.nosql.mapper.AlertListMapper;
import cn.org.openwork.nosql.mapper.RedisServerMapper;
import cn.org.openwork.nosql.service.impl.AbstractRedisService;
import cn.org.openwork.nosql.util.HttpClientUtil;

@Component
public class AlertTask extends AbstractRedisService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AlertTask.class);
    
    @Resource
    private RedisServerMapper redisServerMapper;
    
    @Resource
    private AlertConfigMapper alertConfigMapper;
    
    @Resource
    private AlertListMapper alertListMapper;
    
    @Value(value = "${sms_url}")
    private String smsUrl;
    
    public final static long DELAY_TIME = 5000;
    
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute()
    {
        List<AlertConfig> alertConfigs = alertConfigMapper.selectByExample(new AlertConfigExample());
        //遍历报警配置
        for (AlertConfig alertConfig : alertConfigs)
        {
            //根据不同的服务器，做各自报警逻辑
            String serverType = alertConfig.getServerType();
            switch (serverType)
            {
                case Constant.REDIS:
                {
                    redisAlert(alertConfig);
                    break;
                }
                case Constant.MONGODB:
                {
                    mongoDbAlert(alertConfig);
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    /**
     * redis报警逻辑
     * @Title: redisAlert   
     * @param alertConfig        
     * @throws
     */
    private void redisAlert(AlertConfig alertConfig)
    {
        // 检查是否在短时间内重复报警
        Date lastAlertTime = alertConfig.getLastAlertTime();
        if (lastAlertTime != null)
        {
            long lastAlertTimestamp = lastAlertTime.getTime();
            long nowTimestamp = new Date().getTime();
            long interval = (nowTimestamp - lastAlertTimestamp) / 1000;
            Long realertSecondsLater = alertConfig.getRealertSecondsLater();
            //如果距离上次报警还不到realertSecondsLater秒，则返回不报警
            if (interval < realertSecondsLater)
            {
                return;
            }
        }
        RedisServer redisServer = redisServerMapper.selectByPrimaryKey(alertConfig.getServerId());
        String host = redisServer.getHost();
        Integer port = redisServer.getPort();
        String password = redisServer.getPassword();
        //检查redis连接状态
        boolean isConnRedis = isConnRedisRetry(host, port, password);
        if (!isConnRedis)
        {
            String phoneNumbers = alertConfig.getPhoneNumbers();
            String message = AlertMessage.getRedisIsNotConnectedMessage(redisServer);
            String url = smsUrl.replaceAll("#phone", phoneNumbers).replaceAll("#message", message);
            String smsResponseContent = HttpClientUtil.get(url);
            String redisDetail = "host:" + host + ",port:" + port + ",password:" + password;
            //保存报警记录
            AlertList alertList=new AlertList();
            alertList.setServerId(redisServer.getId());
            alertList.setAlertContent(message);
            alertList.setAlertLevel(Constant.ERROR);
            alertList.setCreateTime(new Date());
            alertListMapper.insert(alertList);
            //日志打印报警信息
            LOGGER.warn(smsResponseContent + ",redisDetail:" + redisDetail);
            if (smsResponseContent.contains(Constant.STRING_ZERO))
            {
                alertConfig.setLastAlertTime(new Date());
                alertConfigMapper.updateByPrimaryKey(alertConfig);
            }
        }
    }
    
    /**
     * mongodb告警逻辑
     * @Title: mongoDbAlert   
     * @param alertConfig        
     * @throws
     */
    private void mongoDbAlert(AlertConfig alertConfig)
    {
        //TODO
    }
    
    private static class AlertMessage
    {
        private final static String REDIS_IS_NOT_CONNECTED_MESSAGE = "Redis连接不成功，请立即检查！";
        
        /**
         * redis连接不成功短信内容
         * @Title: getRedisIsNotConnectedMessage   
         * @param redisServer
         * @return        
         * @throws
         */
        public static String getRedisIsNotConnectedMessage(RedisServer redisServer)
        {
            String host = redisServer.getHost();
            Integer port = redisServer.getPort();
            
            String message = "主机：" + host + ",端口:" + port + "," + REDIS_IS_NOT_CONNECTED_MESSAGE;
            return message;
        }
    }
}
