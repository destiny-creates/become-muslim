package expo.modules.taskManager;

import android.os.Bundle;
import expo.p307b.p317j.C6038b;
import expo.p307b.p317j.C6039c;
import expo.p307b.p317j.C6040d;
import expo.p307b.p317j.C7390g;
import java.util.Map;

public class Task implements C6040d {
    private String mAppId;
    private String mAppUrl;
    private C6038b mConsumer;
    private String mName;
    private Map<String, Object> mOptions;
    private C7390g mService;

    public Task(String str, String str2, String str3, C6038b c6038b, Map<String, Object> map, C7390g c7390g) {
        this.mName = str;
        this.mAppId = str2;
        this.mAppUrl = str3;
        this.mConsumer = c6038b;
        this.mOptions = map;
        this.mService = c7390g;
    }

    public String getName() {
        return this.mName;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppUrl() {
        return this.mAppUrl;
    }

    public C6038b getConsumer() {
        return this.mConsumer;
    }

    public Map<String, Object> getOptions() {
        return this.mOptions;
    }

    public Bundle getOptionsBundle() {
        return TaskManagerUtils.mapToBundle(this.mOptions);
    }

    public void execute(Bundle bundle, Error error) {
        execute(bundle, error, null);
    }

    public void execute(Bundle bundle, Error error, C6039c c6039c) {
        this.mService.executeTask(this, bundle, error, c6039c);
    }

    public void setOptions(Map<String, Object> map) {
        this.mOptions = map;
    }
}
