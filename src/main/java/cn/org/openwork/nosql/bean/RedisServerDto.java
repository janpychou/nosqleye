package cn.org.openwork.nosql.bean;

import java.io.Serializable;
import java.util.Date;

public class RedisServerDto implements Serializable {
    private Long id;

    private String host;

    private Integer port;

    private String password;

    private String tags;

    private Date createTime;
    
    private String status;
    
    private String uptime="--";
    
    private String memory="--";
    
    private String role="--";
    
    private String master="--";
    
    private String qps="--";
    
    private String keyspace="--";
    
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * @return the port
     */
    public Integer getPort()
    {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(Integer port)
    {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the memory
     */
    public String getMemory() {
        return memory;
    }

    /**
     * @param memory the memory to set
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the master
     */
    public String getMaster() {
        return master;
    }

    /**
     * @param master the master to set
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * @return the qps
     */
    public String getQps() {
        return qps;
    }

    /**
     * @param qps the qps to set
     */
    public void setQps(String qps) {
        this.qps = qps;
    }

    /**
     * @return the keyspace
     */
    public String getKeyspace() {
        return keyspace;
    }

    /**
     * @param keyspace the keyspace to set
     */
    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", password=").append(password);
        sb.append(", tags=").append(tags);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}