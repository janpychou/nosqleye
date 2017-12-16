/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  RedisServerStatus.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月23日 上午9:04:26   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**   
 * @ClassName:  RedisServerStatus   
 * @Description:redisserver 状态
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月23日 上午9:04:26   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class RedisServerStatus
{
    private Long id;

    private String host;

    private String port;
    
    private String tags;
    
    private String status;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
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
     * @return the tags
     */
    public String getTags()
    {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags)
    {
        this.tags = tags;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
