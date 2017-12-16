/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongodbOverviewDto.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月10日 下午4:04:38   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**
 * @ClassName: MongodbOverviewDto
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月10日 下午4:04:38
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class MongodbOverviewDto {
    private String host;
    private String port;
    private String version;
    private String pid;
    private String uptime;
    private String isMaster;
    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }
    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }
    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }
    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }
    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }
    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }
    /**
     * @return the uptime
     */
    public String getUptime() {
        return uptime;
    }
    /**
     * @param uptime the uptime to set
     */
    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
    /**
     * @return the isMaster
     */
    public String getIsMaster() {
        return isMaster;
    }
    /**
     * @param isMaster the isMaster to set
     */
    public void setIsMaster(String isMaster) {
        this.isMaster = isMaster;
    }
    
}
