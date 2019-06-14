package versioned.host.exp.exponent.modules.api;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;
import host.exp.exponent.p336c.C6294a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class URLHandlerModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "EXURLHandler";
    }

    public URLHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        C6294a.m25957a().m25961b(URLHandlerModule.class, this);
    }

    public Map<String, Object> getConstants() {
        List arrayList = new ArrayList();
        arrayList.add("exp");
        arrayList.add("exps");
        return MapBuilder.of("schemes", arrayList, "initialURL", null, "settingsURL", "http://settings");
    }

    @ReactMethod
    public void openURLAsync(String str, Promise promise) {
        if (str == null) {
            promise.resolve(Boolean.valueOf(false));
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null) {
            getCurrentActivity().startActivity(intent);
            promise.resolve(Boolean.valueOf(true));
            return;
        }
        promise.resolve(Boolean.valueOf(false));
    }

    @ReactMethod
    public void canOpenURLAsync(String str, Promise promise) {
        boolean z = false;
        if (str == null) {
            promise.resolve(Boolean.valueOf(false));
        }
        if (new Intent("android.intent.action.VIEW", Uri.parse(str)).resolveActivity(getReactApplicationContext().getPackageManager()) != null) {
            z = true;
        }
        promise.resolve(Boolean.valueOf(z));
    }
}
