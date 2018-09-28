package campinvent.Dao;

import campinvent.uitl.AppPlatform;

import java.util.Objects;

public class DataDao {

    private Integer campaignID;
    private Integer inventoryID;
    private boolean blocked;
    private String appName;
    private AppPlatform appPlatform;
    private String domainName;
    private String topLevelDomain;

    public DataDao(Integer campaignID, Integer inventoryID, boolean blocked, String appName, AppPlatform appPlatform, String domainName, String topLevelDomain) {
        this.campaignID = campaignID;
        this.inventoryID = inventoryID;
        this.blocked = blocked;
        this.appName = appName;
        this.appPlatform = appPlatform;
        this.domainName = domainName;
        this.topLevelDomain = topLevelDomain;
    }

    public DataDao() {
    }

    public Integer getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public AppPlatform getAppPlatform() {
        return appPlatform;
    }

    public void setAppPlatform(AppPlatform appPlatform) {
        this.appPlatform = appPlatform;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(String topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataDao)) return false;
        DataDao dataDao = (DataDao) o;
        return isBlocked() == dataDao.isBlocked() &&
                Objects.equals(getCampaignID(), dataDao.getCampaignID()) &&
                Objects.equals(getInventoryID(), dataDao.getInventoryID()) &&
                Objects.equals(getAppName(), dataDao.getAppName()) &&
                Objects.equals(getAppPlatform(), dataDao.getAppPlatform()) &&
                Objects.equals(getDomainName(), dataDao.getDomainName()) &&
                Objects.equals(getTopLevelDomain(), dataDao.getTopLevelDomain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCampaignID(), getInventoryID(), isBlocked(), getAppName(), getAppPlatform(), getDomainName(), getTopLevelDomain());
    }
}
