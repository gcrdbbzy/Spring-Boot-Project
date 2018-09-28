package campinvent.Dto;

public class Domain extends Inventory {

    private String domainName;
    private String topLevelDomain;

    public Domain() {
    }

    public Domain(Integer id, Integer weight, String domainName, String topLevelDomain) {
        super(id, weight);
        this.domainName = domainName;
        this.topLevelDomain = topLevelDomain;
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
}
