package campinvent.model;

import campinvent.Dto.Inventory;
import campinvent.uitl.AppPlatform;
import org.apache.commons.lang3.StringUtils;

import static campinvent.model.DataProcessor.INVENTORY_MAP;
import static campinvent.model.DataProcessor.RELATIONSHIP_MAP;

public class QueryProcessor {

    static {
        DataProcessor.generateMapFromFile();
    }

    public static String query(Integer campaignId, String appName, String appPlatform, String domainName, String topLevelDomain, Integer weight) {

        if (campaignId == null) {
            return "CampaignId could not be empty!";
        }

        if ((StringUtils.isBlank(appName) || StringUtils.isBlank(appPlatform)) && (StringUtils.isBlank(domainName) || StringUtils.isBlank(topLevelDomain))) {
            return "(AppName and AppPlatform) or (DomainName and TopLevelDomain) must be all present!";
        }

        if (StringUtils.isBlank(appName) && StringUtils.isBlank(appPlatform) && StringUtils.isBlank(domainName) && StringUtils.isBlank(topLevelDomain)) {
            return "AppName, AppPlatform, DomainName and TopLevelDomain can not be all present!";
        }

        AppPlatform appPF;
        String inventoryKey = null;
        if (StringUtils.isNotBlank(appName) && StringUtils.isNotBlank(appPlatform)) {
            try {
                appPF = AppPlatform.valueOf(appPlatform);
            } catch (Exception e) {
                System.out.println("Input AppPlatform is not the standard one, use UNKNOWN instead!");
                appPF = AppPlatform.UNKNOWN;
            }
            inventoryKey = appName + "_" + appPF;
        }

        if (StringUtils.isNotBlank(domainName) && StringUtils.isNotBlank(topLevelDomain)) {
            inventoryKey = domainName + "_" + topLevelDomain;
        }

        Inventory inventory = INVENTORY_MAP.get(inventoryKey);

        if (inventory != null) {
            if (weight > inventory.getWeight()) {
                return "Blocked: weight not matched!";
            } else {
                String campaignInventoryKey = campaignId + "_" + inventory.getId();
                return RELATIONSHIP_MAP.get(campaignInventoryKey) ? "Blocked" : "Unblocked";
            }
        } else {
            return "Unblocked";
        }
    }
}
