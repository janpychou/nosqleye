package cn.org.openwork.nosql.bean;

public class SlaveStatus
{
    private String masterLinkStatus;
    private String masterLastIoSecondsAgo;
    private String masterSyncInProgress;
    private String slaveReplOffset;
    private String slavePriority;
    private String slaveReadOnly;
    
    public SlaveStatus(String masterLinkStatus, String masterLastIoSecondsAgo, String masterSyncInProgress,
        String slaveReplOffset, String slavePriority, String slaveReadOnly)
    {
        super();
        this.masterLinkStatus = masterLinkStatus;
        this.masterLastIoSecondsAgo = masterLastIoSecondsAgo;
        this.masterSyncInProgress = masterSyncInProgress;
        this.slaveReplOffset = slaveReplOffset;
        this.slavePriority = slavePriority;
        this.slaveReadOnly = slaveReadOnly;
    }
    /**
     * @return the masterLinkStatus
     */
    public String getMasterLinkStatus()
    {
        return masterLinkStatus;
    }
    /**
     * @param masterLinkStatus the masterLinkStatus to set
     */
    public void setMasterLinkStatus(String masterLinkStatus)
    {
        this.masterLinkStatus = masterLinkStatus;
    }
    /**
     * @return the masterLastIoSecondsAgo
     */
    public String getMasterLastIoSecondsAgo()
    {
        return masterLastIoSecondsAgo;
    }
    /**
     * @param masterLastIoSecondsAgo the masterLastIoSecondsAgo to set
     */
    public void setMasterLastIoSecondsAgo(String masterLastIoSecondsAgo)
    {
        this.masterLastIoSecondsAgo = masterLastIoSecondsAgo;
    }
    /**
     * @return the masterSyncInProgress
     */
    public String getMasterSyncInProgress()
    {
        return masterSyncInProgress;
    }
    /**
     * @param masterSyncInProgress the masterSyncInProgress to set
     */
    public void setMasterSyncInProgress(String masterSyncInProgress)
    {
        this.masterSyncInProgress = masterSyncInProgress;
    }
    /**
     * @return the slaveReplOffset
     */
    public String getSlaveReplOffset()
    {
        return slaveReplOffset;
    }
    /**
     * @param slaveReplOffset the slaveReplOffset to set
     */
    public void setSlaveReplOffset(String slaveReplOffset)
    {
        this.slaveReplOffset = slaveReplOffset;
    }
    /**
     * @return the slavePriority
     */
    public String getSlavePriority()
    {
        return slavePriority;
    }
    /**
     * @param slavePriority the slavePriority to set
     */
    public void setSlavePriority(String slavePriority)
    {
        this.slavePriority = slavePriority;
    }
    /**
     * @return the slaveReadOnly
     */
    public String getSlaveReadOnly()
    {
        return slaveReadOnly;
    }
    /**
     * @param slaveReadOnly the slaveReadOnly to set
     */
    public void setSlaveReadOnly(String slaveReadOnly)
    {
        this.slaveReadOnly = slaveReadOnly;
    }
}
