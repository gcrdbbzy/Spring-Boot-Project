package campinvent.model;

import campinvent.Dao.DataDao;
import campinvent.Dto.App;
import campinvent.Dto.Domain;
import campinvent.Dto.Inventory;
import campinvent.uitl.FileUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataProcessor {

    public static Map<String, Inventory> INVENTORY_MAP = new HashMap<>();
    public static Map<Integer, Inventory> INVENTORY_ID_MAP = new HashMap<>();
    public static Map<String, Boolean> RELATIONSHIP_MAP = new HashMap<>();

    public static void generateMapFromFile() {
        Set<DataDao> dataDaoSet = FileUtils.loadExcel();
        for (DataDao data : dataDaoSet) {
            if (INVENTORY_ID_MAP.get(data.getInventoryID()) == null) {
                if (data.getAppName() != null && !data.getAppName().isEmpty() && data.getAppPlatform() != null) {
                    String key = data.getAppName() + "_" + data.getAppPlatform();
                    if (INVENTORY_MAP.get(key) != null) {
                        Inventory inventory = INVENTORY_MAP.get(key);
                        inventory.setWeight(inventory.getWeight() + 1);
                        INVENTORY_MAP.put(key, inventory);
                    } else {
                        INVENTORY_MAP.put(key, new App(data.getInventoryID(), 1, data.getAppName(), data.getAppPlatform()));
                        INVENTORY_ID_MAP.put(data.getInventoryID(), new App(data.getInventoryID(), 1, data.getAppName(), data.getAppPlatform()));
                    }
                }

                if (data.getDomainName() != null && !data.getDomainName().isEmpty() && data.getTopLevelDomain() != null && !data.getTopLevelDomain().isEmpty()) {
                    String key = data.getDomainName() + "_" + data.getTopLevelDomain();
                    if (INVENTORY_MAP.get(key) != null) {
                        Inventory inventory = INVENTORY_MAP.get(key);
                        inventory.setWeight(inventory.getWeight() + 1);
                        INVENTORY_MAP.put(key, inventory);
                    } else {
                        INVENTORY_MAP.put(key, new Domain(data.getInventoryID(), 1, data.getDomainName(), data.getTopLevelDomain()));
                        INVENTORY_ID_MAP.put(data.getInventoryID(), new Domain(data.getInventoryID(), 1, data.getDomainName(), data.getTopLevelDomain()));
                    }
                }
            }

            String campaignInventoryKey = data.getCampaignID() + "_" + data.getInventoryID();
            RELATIONSHIP_MAP.put(campaignInventoryKey, data.isBlocked());
        }
    }

}
