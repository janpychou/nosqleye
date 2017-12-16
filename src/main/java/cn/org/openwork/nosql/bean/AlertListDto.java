package cn.org.openwork.nosql.bean;

public class AlertListDto
{
    private Long serverId;
    
    private String host;
    
    private String port;

    private String alertLevel;

    private String alertContent;

    private String createTime;

    /**
     * @return the serverId
     */
    public Long getServerId()
    {
        return serverId;
    }

    /**
     * @param serverId the serverId to set
     */
    public void setServerId(Long serverId)
    {
        this.serverId = serverId;
    }

    /**
     * @return the host
     */
    public String getHost()
    {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host)
    {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort()
    {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port)
    {
        this.port = port;
    }

    /**
     * @return the alertLevel
     */
    public String getAlertLevel()
    {
        return alertLevel;
    }

    /**
     * @param alertLevel the alertLevel to set
     */
    public void setAlertLevel(String alertLevel)
    {
        this.alertLevel = alertLevel;
    }

    /**
     * @return the alertContent
     */
    public String getAlertContent()
    {
        return alertContent;
    }

    /**
     * @param alertContent the alertContent to set
     */
    public void setAlertContent(String alertContent)
    {
        this.alertContent = alertContent;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime()
    {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
}
