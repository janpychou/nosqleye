/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  RedisDetailDto.java   
 * @Package cn.bqjr.redis.monitor.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年6月30日 上午11:12:31   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**
 * @ClassName: RedisDetailDto
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年6月30日 上午11:12:31
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class RedisDetailDto {
    private String host;
    private String port;
    private String redisVersion;
    private String redisMode;
    private String processId;
    private String uptimeInSeconds;
    private String uptimeInDays;
    private String role;
    private String connectedSlaves;
    private String aofEnabled;
    private String clusterEnabled;
    private String aofLastWriteStatus;

    
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
     * @return the redisVersion
     */
    public String getRedisVersion() {
	return redisVersion;
    }

    /**
     * @param redisVersion
     *            the redisVersion to set
     */
    public void setRedisVersion(String redisVersion) {
	this.redisVersion = redisVersion;
    }

    /**
     * @return the redisMode
     */
    public String getRedisMode() {
	return redisMode;
    }

    /**
     * @param redisMode
     *            the redisMode to set
     */
    public void setRedisMode(String redisMode) {
	this.redisMode = redisMode;
    }

    /**
     * @return the processId
     */
    public String getProcessId() {
	return processId;
    }

    /**
     * @param processId
     *            the processId to set
     */
    public void setProcessId(String processId) {
	this.processId = processId;
    }

    /**
     * @return the uptimeInSeconds
     */
    public String getUptimeInSeconds() {
	return uptimeInSeconds;
    }

    /**
     * @param uptimeInSeconds
     *            the uptimeInSeconds to set
     */
    public void setUptimeInSeconds(String uptimeInSeconds) {
	this.uptimeInSeconds = uptimeInSeconds;
    }

    /**
     * @return the uptimeInDays
     */
    public String getUptimeInDays() {
	return uptimeInDays;
    }

    /**
     * @param uptimeInDays
     *            the uptimeInDays to set
     */
    public void setUptimeInDays(String uptimeInDays) {
	this.uptimeInDays = uptimeInDays;
    }

    /**
     * @return the role
     */
    public String getRole() {
	return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
	this.role = role;
    }

    /**
     * @return the connectedSlaves
     */
    public String getConnectedSlaves() {
	return connectedSlaves;
    }

    /**
     * @param connectedSlaves
     *            the connectedSlaves to set
     */
    public void setConnectedSlaves(String connectedSlaves) {
	this.connectedSlaves = connectedSlaves;
    }

    /**
     * @return the aofEnabled
     */
    public String getAofEnabled() {
	return aofEnabled;
    }

    /**
     * @param aofEnabled
     *            the aofEnabled to set
     */
    public void setAofEnabled(String aofEnabled) {
	this.aofEnabled = aofEnabled;
    }

    /**
     * @return the clusterEnabled
     */
    public String getClusterEnabled() {
	return clusterEnabled;
    }

    /**
     * @param clusterEnabled
     *            the clusterEnabled to set
     */
    public void setClusterEnabled(String clusterEnabled) {
	this.clusterEnabled = clusterEnabled;
    }

    /**
     * @return the aofLastWriteStatus
     */
    public String getAofLastWriteStatus() {
        return aofLastWriteStatus;
    }

    /**
     * @param aofLastWriteStatus the aofLastWriteStatus to set
     */
    public void setAofLastWriteStatus(String aofLastWriteStatus) {
        this.aofLastWriteStatus = aofLastWriteStatus;
    }
}
