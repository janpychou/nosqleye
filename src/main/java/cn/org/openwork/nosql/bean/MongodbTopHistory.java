package cn.org.openwork.nosql.bean;

import java.io.Serializable;
import java.util.Date;

public class MongodbTopHistory implements Serializable {
    private Long id;

    private Long serverId;

    private String ns;

    private Long totalCount;

    private Long totalTime;

    private String totalCountPersecond;

    private Long writeLockCount;

    private Long writeLockTime;

    private String writeLockCountPersecond;

    private Long readLockCount;

    private Long readLockTime;

    private String readLockCountPersecond;

    private Long insertCount;

    private Long insertTime;

    private String insertCountPersecond;

    private Long updateCount;

    private Long updateTime;

    private String updateCountPersecond;

    private Long getMoreCount;

    private Long getMoreTime;

    private String getMoreCountPersecond;

    private Long queriesCount;

    private Long queriesTime;

    private String queriesCountPersecond;

    private Long removeCount;

    private Long removeTime;

    private String removeCountPersecond;

    private Long commandsCount;

    private Long commandsTime;

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

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns == null ? null : ns.trim();
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public String getTotalCountPersecond() {
        return totalCountPersecond;
    }

    public void setTotalCountPersecond(String totalCountPersecond) {
        this.totalCountPersecond = totalCountPersecond == null ? null : totalCountPersecond.trim();
    }

    public Long getWriteLockCount() {
        return writeLockCount;
    }

    public void setWriteLockCount(Long writeLockCount) {
        this.writeLockCount = writeLockCount;
    }

    public Long getWriteLockTime() {
        return writeLockTime;
    }

    public void setWriteLockTime(Long writeLockTime) {
        this.writeLockTime = writeLockTime;
    }

    public String getWriteLockCountPersecond() {
        return writeLockCountPersecond;
    }

    public void setWriteLockCountPersecond(String writeLockCountPersecond) {
        this.writeLockCountPersecond = writeLockCountPersecond == null ? null : writeLockCountPersecond.trim();
    }

    public Long getReadLockCount() {
        return readLockCount;
    }

    public void setReadLockCount(Long readLockCount) {
        this.readLockCount = readLockCount;
    }

    public Long getReadLockTime() {
        return readLockTime;
    }

    public void setReadLockTime(Long readLockTime) {
        this.readLockTime = readLockTime;
    }

    public String getReadLockCountPersecond() {
        return readLockCountPersecond;
    }

    public void setReadLockCountPersecond(String readLockCountPersecond) {
        this.readLockCountPersecond = readLockCountPersecond == null ? null : readLockCountPersecond.trim();
    }

    public Long getInsertCount() {
        return insertCount;
    }

    public void setInsertCount(Long insertCount) {
        this.insertCount = insertCount;
    }

    public Long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    public String getInsertCountPersecond() {
        return insertCountPersecond;
    }

    public void setInsertCountPersecond(String insertCountPersecond) {
        this.insertCountPersecond = insertCountPersecond == null ? null : insertCountPersecond.trim();
    }

    public Long getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateCountPersecond() {
        return updateCountPersecond;
    }

    public void setUpdateCountPersecond(String updateCountPersecond) {
        this.updateCountPersecond = updateCountPersecond == null ? null : updateCountPersecond.trim();
    }

    public Long getGetMoreCount() {
        return getMoreCount;
    }

    public void setGetMoreCount(Long getMoreCount) {
        this.getMoreCount = getMoreCount;
    }

    public Long getGetMoreTime() {
        return getMoreTime;
    }

    public void setGetMoreTime(Long getMoreTime) {
        this.getMoreTime = getMoreTime;
    }

    public String getGetMoreCountPersecond() {
        return getMoreCountPersecond;
    }

    public void setGetMoreCountPersecond(String getMoreCountPersecond) {
        this.getMoreCountPersecond = getMoreCountPersecond == null ? null : getMoreCountPersecond.trim();
    }

    public Long getQueriesCount() {
        return queriesCount;
    }

    public void setQueriesCount(Long queriesCount) {
        this.queriesCount = queriesCount;
    }

    public Long getQueriesTime() {
        return queriesTime;
    }

    public void setQueriesTime(Long queriesTime) {
        this.queriesTime = queriesTime;
    }

    public String getQueriesCountPersecond() {
        return queriesCountPersecond;
    }

    public void setQueriesCountPersecond(String queriesCountPersecond) {
        this.queriesCountPersecond = queriesCountPersecond == null ? null : queriesCountPersecond.trim();
    }

    public Long getRemoveCount() {
        return removeCount;
    }

    public void setRemoveCount(Long removeCount) {
        this.removeCount = removeCount;
    }

    public Long getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(Long removeTime) {
        this.removeTime = removeTime;
    }

    public String getRemoveCountPersecond() {
        return removeCountPersecond;
    }

    public void setRemoveCountPersecond(String removeCountPersecond) {
        this.removeCountPersecond = removeCountPersecond == null ? null : removeCountPersecond.trim();
    }

    public Long getCommandsCount() {
        return commandsCount;
    }

    public void setCommandsCount(Long commandsCount) {
        this.commandsCount = commandsCount;
    }

    public Long getCommandsTime() {
        return commandsTime;
    }

    public void setCommandsTime(Long commandsTime) {
        this.commandsTime = commandsTime;
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
        sb.append(", ns=").append(ns);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", totalTime=").append(totalTime);
        sb.append(", totalCountPersecond=").append(totalCountPersecond);
        sb.append(", writeLockCount=").append(writeLockCount);
        sb.append(", writeLockTime=").append(writeLockTime);
        sb.append(", writeLockCountPersecond=").append(writeLockCountPersecond);
        sb.append(", readLockCount=").append(readLockCount);
        sb.append(", readLockTime=").append(readLockTime);
        sb.append(", readLockCountPersecond=").append(readLockCountPersecond);
        sb.append(", insertCount=").append(insertCount);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", insertCountPersecond=").append(insertCountPersecond);
        sb.append(", updateCount=").append(updateCount);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateCountPersecond=").append(updateCountPersecond);
        sb.append(", getMoreCount=").append(getMoreCount);
        sb.append(", getMoreTime=").append(getMoreTime);
        sb.append(", getMoreCountPersecond=").append(getMoreCountPersecond);
        sb.append(", queriesCount=").append(queriesCount);
        sb.append(", queriesTime=").append(queriesTime);
        sb.append(", queriesCountPersecond=").append(queriesCountPersecond);
        sb.append(", removeCount=").append(removeCount);
        sb.append(", removeTime=").append(removeTime);
        sb.append(", removeCountPersecond=").append(removeCountPersecond);
        sb.append(", commandsCount=").append(commandsCount);
        sb.append(", commandsTime=").append(commandsTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}