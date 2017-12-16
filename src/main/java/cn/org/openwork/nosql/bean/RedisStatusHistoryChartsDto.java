/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  RedisStatusHistoryChartsDto.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    redis历史状态数据（供图表使用）
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月21日 上午11:28:17   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**   
 * @ClassName:  RedisStatusHistoryChartsDto   
 * @Description:redis历史状态数据（供图表使用）
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月21日 上午11:28:17   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class RedisStatusHistoryChartsDto
{
    private String[] xAxis;
    private String[] seriesQps;
    private String[] seriesKeys;
    private String[] seriesExpires;
    private String[] seriesExpiredKeys;
    private String[] seriesUsedMemory;
    private String[] seriesTotalMemory;
    private String[] seriesUsedPeakMemory;
    private String[] seriesUsedRssMemory;
    private String[] seriesCpuSys;
    private String[] seriesCpuUser;
    private String[] seriesConnectedClients;
    private String[] seriesBlockedClients;
    
    
    public RedisStatusHistoryChartsDto(String[] xAxis, String[] seriesQps, String[] seriesKeys, String[] seriesExpires,
        String[] seriesExpiredKeys, String[] seriesUsedMemory, String[] seriesTotalMemory,
        String[] seriesUsedPeakMemory, String[] seriesUsedRssMemory, String[] seriesCpuSys, String[] seriesCpuUser,
        String[] seriesConnectedClients, String[] seriesBlockedClients)
    {
        super();
        this.xAxis = xAxis;
        this.seriesQps = seriesQps;
        this.seriesKeys = seriesKeys;
        this.seriesExpires = seriesExpires;
        this.seriesExpiredKeys = seriesExpiredKeys;
        this.seriesUsedMemory = seriesUsedMemory;
        this.seriesTotalMemory = seriesTotalMemory;
        this.seriesUsedPeakMemory = seriesUsedPeakMemory;
        this.seriesUsedRssMemory = seriesUsedRssMemory;
        this.seriesCpuSys = seriesCpuSys;
        this.seriesCpuUser = seriesCpuUser;
        this.seriesConnectedClients = seriesConnectedClients;
        this.seriesBlockedClients = seriesBlockedClients;
    }
    /**
     * @return the xAxis
     */
    public String[] getxAxis()
    {
        return xAxis;
    }
    /**
     * @param xAxis the xAxis to set
     */
    public void setxAxis(String[] xAxis)
    {
        this.xAxis = xAxis;
    }
    /**
     * @return the seriesQps
     */
    public String[] getSeriesQps()
    {
        return seriesQps;
    }
    /**
     * @param seriesQps the seriesQps to set
     */
    public void setSeriesQps(String[] seriesQps)
    {
        this.seriesQps = seriesQps;
    }
    /**
     * @return the seriesKeys
     */
    public String[] getSeriesKeys()
    {
        return seriesKeys;
    }
    /**
     * @param seriesKeys the seriesKeys to set
     */
    public void setSeriesKeys(String[] seriesKeys)
    {
        this.seriesKeys = seriesKeys;
    }
    /**
     * @return the seriesExpires
     */
    public String[] getSeriesExpires()
    {
        return seriesExpires;
    }
    /**
     * @param seriesExpires the seriesExpires to set
     */
    public void setSeriesExpires(String[] seriesExpires)
    {
        this.seriesExpires = seriesExpires;
    }
    /**
     * @return the seriesExpiredKeys
     */
    public String[] getSeriesExpiredKeys()
    {
        return seriesExpiredKeys;
    }
    /**
     * @param seriesExpiredKeys the seriesExpiredKeys to set
     */
    public void setSeriesExpiredKeys(String[] seriesExpiredKeys)
    {
        this.seriesExpiredKeys = seriesExpiredKeys;
    }
    /**
     * @return the seriesUsedMemory
     */
    public String[] getSeriesUsedMemory()
    {
        return seriesUsedMemory;
    }
    /**
     * @param seriesUsedMemory the seriesUsedMemory to set
     */
    public void setSeriesUsedMemory(String[] seriesUsedMemory)
    {
        this.seriesUsedMemory = seriesUsedMemory;
    }
    /**
     * @return the seriesTotalMemory
     */
    public String[] getSeriesTotalMemory()
    {
        return seriesTotalMemory;
    }
    /**
     * @param seriesTotalMemory the seriesTotalMemory to set
     */
    public void setSeriesTotalMemory(String[] seriesTotalMemory)
    {
        this.seriesTotalMemory = seriesTotalMemory;
    }
    
    /**
     * @return the seriesUsedPeakMemory
     */
    public String[] getSeriesUsedPeakMemory()
    {
        return seriesUsedPeakMemory;
    }
    /**
     * @param seriesUsedPeakMemory the seriesUsedPeakMemory to set
     */
    public void setSeriesUsedPeakMemory(String[] seriesUsedPeakMemory)
    {
        this.seriesUsedPeakMemory = seriesUsedPeakMemory;
    }
    /**
     * @return the seriesUsedRssMemory
     */
    public String[] getSeriesUsedRssMemory()
    {
        return seriesUsedRssMemory;
    }
    /**
     * @param seriesUsedRssMemory the seriesUsedRssMemory to set
     */
    public void setSeriesUsedRssMemory(String[] seriesUsedRssMemory)
    {
        this.seriesUsedRssMemory = seriesUsedRssMemory;
    }
    /**
     * @return the seriesCpuSys
     */
    public String[] getSeriesCpuSys()
    {
        return seriesCpuSys;
    }
    /**
     * @param seriesCpuSys the seriesCpuSys to set
     */
    public void setSeriesCpuSys(String[] seriesCpuSys)
    {
        this.seriesCpuSys = seriesCpuSys;
    }
    /**
     * @return the seriesCpuUser
     */
    public String[] getSeriesCpuUser()
    {
        return seriesCpuUser;
    }
    /**
     * @param seriesCpuUser the seriesCpuUser to set
     */
    public void setSeriesCpuUser(String[] seriesCpuUser)
    {
        this.seriesCpuUser = seriesCpuUser;
    }
    /**
     * @return the seriesConnectedClients
     */
    public String[] getSeriesConnectedClients()
    {
        return seriesConnectedClients;
    }
    /**
     * @param seriesConnectedClients the seriesConnectedClients to set
     */
    public void setSeriesConnectedClients(String[] seriesConnectedClients)
    {
        this.seriesConnectedClients = seriesConnectedClients;
    }
    /**
     * @return the seriesBlockedClients
     */
    public String[] getSeriesBlockedClients()
    {
        return seriesBlockedClients;
    }
    /**
     * @param seriesBlockedClients the seriesBlockedClients to set
     */
    public void setSeriesBlockedClients(String[] seriesBlockedClients)
    {
        this.seriesBlockedClients = seriesBlockedClients;
    }
    
    
    
}
