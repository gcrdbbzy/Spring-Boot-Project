package campinvent.Dto;

import campinvent.uitl.AppPlatform;

public class App extends Inventory {

    private String appName;
    private AppPlatform appPlatform;

    public App(Integer id, Integer weight, String appName, AppPlatform appPlatform) {
        super(id, weight);
        this.appName = appName;
        this.appPlatform = appPlatform;
    }

    public App() {
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
}
