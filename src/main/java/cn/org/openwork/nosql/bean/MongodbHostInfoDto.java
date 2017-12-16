/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongodbHostInfoDto.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月11日 下午5:24:44   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**
 * @ClassName: MongodbHostInfoDto
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月11日 下午5:24:44
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class MongodbHostInfoDto {
    private String osName;
    private String osVersion;
    private Integer cpuAddrSize;
    private Integer cpuNumCores;
    private Integer memSizeMB;
    private boolean numaEnabled;
    private String currentTime;

    /**
     * @return the osName
     */
    public String getOsName() {
	return osName;
    }

    /**
     * @param osName
     *            the osName to set
     */
    public void setOsName(String osName) {
	this.osName = osName;
    }

    /**
     * @return the osVersion
     */
    public String getOsVersion() {
	return osVersion;
    }

    /**
     * @param osVersion
     *            the osVersion to set
     */
    public void setOsVersion(String osVersion) {
	this.osVersion = osVersion;
    }

    /**
     * @return the cpuAddrSize
     */
    public Integer getCpuAddrSize() {
	return cpuAddrSize;
    }

    /**
     * @param cpuAddrSize
     *            the cpuAddrSize to set
     */
    public void setCpuAddrSize(Integer cpuAddrSize) {
	this.cpuAddrSize = cpuAddrSize;
    }

    /**
     * @return the cpuNumCores
     */
    public Integer getCpuNumCores() {
	return cpuNumCores;
    }

    /**
     * @param cpuNumCores
     *            the cpuNumCores to set
     */
    public void setCpuNumCores(Integer cpuNumCores) {
	this.cpuNumCores = cpuNumCores;
    }

    /**
     * @return the memSizeMB
     */
    public Integer getMemSizeMB() {
	return memSizeMB;
    }

    /**
     * @param memSizeMB
     *            the memSizeMB to set
     */
    public void setMemSizeMB(Integer memSizeMB) {
	this.memSizeMB = memSizeMB;
    }

    /**
     * @return the numaEnabled
     */
    public boolean isNumaEnabled() {
	return numaEnabled;
    }

    /**
     * @param numaEnabled
     *            the numaEnabled to set
     */
    public void setNumaEnabled(boolean numaEnabled) {
	this.numaEnabled = numaEnabled;
    }

    /**
     * @return the currentTime
     */
    public String getCurrentTime() {
	return currentTime;
    }

    /**
     * @param currentTime
     *            the currentTime to set
     */
    public void setCurrentTime(String currentTime) {
	this.currentTime = currentTime;
    }

}
