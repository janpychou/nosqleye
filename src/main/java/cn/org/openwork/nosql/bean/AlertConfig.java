package cn.org.openwork.nosql.bean;

import java.io.Serializable;
import java.util.Date;

public class AlertConfig implements Serializable {
    private Long id;

    private String serverType;

    private Long serverId;

    private String phoneNumbers;

    private Date createTime;

    private Date lastAlertTime;

    private Long realertSecondsLater;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType == null ? null : serverType.trim();
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers == null ? null : phoneNumbers.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastAlertTime() {
        return lastAlertTime;
    }

    public void setLastAlertTime(Date lastAlertTime) {
        this.lastAlertTime = lastAlertTime;
    }

    public Long getRealertSecondsLater() {
        return realertSecondsLater;
    }

    public void setRealertSecondsLater(Long realertSecondsLater) {
        this.realertSecondsLater = realertSecondsLater;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverType=").append(serverType);
        sb.append(", serverId=").append(serverId);
        sb.append(", phoneNumbers=").append(phoneNumbers);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAlertTime=").append(lastAlertTime);
        sb.append(", realertSecondsLater=").append(realertSecondsLater);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}