package cn.org.openwork.nosql.bean;

import java.io.Serializable;
import java.util.Date;

public class RedisStatusHistory implements Serializable {
    private Long id;

    private Long serverId;

    private String connectedClients;

    private String blockedClients;

    private String usedMemory;

    private String usedMemoryHuman;

    private String usedMemoryRss;

    private String usedMemoryRssHuman;

    private String usedMemoryPeak;

    private String usedMemoryPeakHuman;

    private String memFragmentationRatio;

    private String totalSystemMemory;

    private String totalSystemMemoryHuman;

    private String totalConnectionsReceived;

    private String totalCommandsProcessed;

    private String instantaneousOpsPerSec;

    private String totalNetInputBytes;

    private String totalNetOutputBytes;

    private String expiredKeys;

    private String usedCpuSys;

    private String usedCpuUser;

    private String keyspace;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getConnectedClients() {
        return connectedClients;
    }

    public void setConnectedClients(String connectedClients) {
        this.connectedClients = connectedClients == null ? null : connectedClients.trim();
    }

    public String getBlockedClients() {
        return blockedClients;
    }

    public void setBlockedClients(String blockedClients) {
        this.blockedClients = blockedClients == null ? null : blockedClients.trim();
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory == null ? null : usedMemory.trim();
    }

    public String getUsedMemoryHuman() {
        return usedMemoryHuman;
    }

    public void setUsedMemoryHuman(String usedMemoryHuman) {
        this.usedMemoryHuman = usedMemoryHuman == null ? null : usedMemoryHuman.trim();
    }

    public String getUsedMemoryRss() {
        return usedMemoryRss;
    }

    public void setUsedMemoryRss(String usedMemoryRss) {
        this.usedMemoryRss = usedMemoryRss == null ? null : usedMemoryRss.trim();
    }

    public String getUsedMemoryRssHuman() {
        return usedMemoryRssHuman;
    }

    public void setUsedMemoryRssHuman(String usedMemoryRssHuman) {
        this.usedMemoryRssHuman = usedMemoryRssHuman == null ? null : usedMemoryRssHuman.trim();
    }

    public String getUsedMemoryPeak() {
        return usedMemoryPeak;
    }

    public void setUsedMemoryPeak(String usedMemoryPeak) {
        this.usedMemoryPeak = usedMemoryPeak == null ? null : usedMemoryPeak.trim();
    }

    public String getUsedMemoryPeakHuman() {
        return usedMemoryPeakHuman;
    }

    public void setUsedMemoryPeakHuman(String usedMemoryPeakHuman) {
        this.usedMemoryPeakHuman = usedMemoryPeakHuman == null ? null : usedMemoryPeakHuman.trim();
    }

    public String getMemFragmentationRatio() {
        return memFragmentationRatio;
    }

    public void setMemFragmentationRatio(String memFragmentationRatio) {
        this.memFragmentationRatio = memFragmentationRatio == null ? null : memFragmentationRatio.trim();
    }

    public String getTotalSystemMemory() {
        return totalSystemMemory;
    }

    public void setTotalSystemMemory(String totalSystemMemory) {
        this.totalSystemMemory = totalSystemMemory == null ? null : totalSystemMemory.trim();
    }

    public String getTotalSystemMemoryHuman() {
        return totalSystemMemoryHuman;
    }

    public void setTotalSystemMemoryHuman(String totalSystemMemoryHuman) {
        this.totalSystemMemoryHuman = totalSystemMemoryHuman == null ? null : totalSystemMemoryHuman.trim();
    }

    public String getTotalConnectionsReceived() {
        return totalConnectionsReceived;
    }

    public void setTotalConnectionsReceived(String totalConnectionsReceived) {
        this.totalConnectionsReceived = totalConnectionsReceived == null ? null : totalConnectionsReceived.trim();
    }

    public String getTotalCommandsProcessed() {
        return totalCommandsProcessed;
    }

    public void setTotalCommandsProcessed(String totalCommandsProcessed) {
        this.totalCommandsProcessed = totalCommandsProcessed == null ? null : totalCommandsProcessed.trim();
    }

    public String getInstantaneousOpsPerSec() {
        return instantaneousOpsPerSec;
    }

    public void setInstantaneousOpsPerSec(String instantaneousOpsPerSec) {
        this.instantaneousOpsPerSec = instantaneousOpsPerSec == null ? null : instantaneousOpsPerSec.trim();
    }

    public String getTotalNetInputBytes() {
        return totalNetInputBytes;
    }

    public void setTotalNetInputBytes(String totalNetInputBytes) {
        this.totalNetInputBytes = totalNetInputBytes == null ? null : totalNetInputBytes.trim();
    }

    public String getTotalNetOutputBytes() {
        return totalNetOutputBytes;
    }

    public void setTotalNetOutputBytes(String totalNetOutputBytes) {
        this.totalNetOutputBytes = totalNetOutputBytes == null ? null : totalNetOutputBytes.trim();
    }

    public String getExpiredKeys() {
        return expiredKeys;
    }

    public void setExpiredKeys(String expiredKeys) {
        this.expiredKeys = expiredKeys == null ? null : expiredKeys.trim();
    }

    public String getUsedCpuSys() {
        return usedCpuSys;
    }

    public void setUsedCpuSys(String usedCpuSys) {
        this.usedCpuSys = usedCpuSys == null ? null : usedCpuSys.trim();
    }

    public String getUsedCpuUser() {
        return usedCpuUser;
    }

    public void setUsedCpuUser(String usedCpuUser) {
        this.usedCpuUser = usedCpuUser == null ? null : usedCpuUser.trim();
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace == null ? null : keyspace.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverId=").append(serverId);
        sb.append(", connectedClients=").append(connectedClients);
        sb.append(", blockedClients=").append(blockedClients);
        sb.append(", usedMemory=").append(usedMemory);
        sb.append(", usedMemoryHuman=").append(usedMemoryHuman);
        sb.append(", usedMemoryRss=").append(usedMemoryRss);
        sb.append(", usedMemoryRssHuman=").append(usedMemoryRssHuman);
        sb.append(", usedMemoryPeak=").append(usedMemoryPeak);
        sb.append(", usedMemoryPeakHuman=").append(usedMemoryPeakHuman);
        sb.append(", memFragmentationRatio=").append(memFragmentationRatio);
        sb.append(", totalSystemMemory=").append(totalSystemMemory);
        sb.append(", totalSystemMemoryHuman=").append(totalSystemMemoryHuman);
        sb.append(", totalConnectionsReceived=").append(totalConnectionsReceived);
        sb.append(", totalCommandsProcessed=").append(totalCommandsProcessed);
        sb.append(", instantaneousOpsPerSec=").append(instantaneousOpsPerSec);
        sb.append(", totalNetInputBytes=").append(totalNetInputBytes);
        sb.append(", totalNetOutputBytes=").append(totalNetOutputBytes);
        sb.append(", expiredKeys=").append(expiredKeys);
        sb.append(", usedCpuSys=").append(usedCpuSys);
        sb.append(", usedCpuUser=").append(usedCpuUser);
        sb.append(", keyspace=").append(keyspace);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}