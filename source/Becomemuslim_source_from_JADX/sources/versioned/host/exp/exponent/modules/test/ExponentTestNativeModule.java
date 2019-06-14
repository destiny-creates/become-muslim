package versioned.host.exp.exponent.modules.test;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import de.p287a.p288a.C5884c;
import host.exp.exponent.p339f.C6348k;
import host.exp.exponent.p345i.C6378a;
import host.exp.exponent.p345i.C6379b;
import host.exp.exponent.p345i.C6380c;
import java.util.HashMap;
import java.util.Map;

public class ExponentTestNativeModule extends ReactContextBaseJavaModule {
    private static final String TAG = "ExponentTestNativeModule";
    private int mCurrentId = null;
    private Map<Integer, Promise> mIdToPromise = new HashMap();

    public String getName() {
        return "ExponentTest";
    }

    public ExponentTestNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        C5884c.m24753a().m24765a((Object) this);
    }

    private int getPromiseId(Promise promise) {
        int i = this.mCurrentId;
        this.mCurrentId = i + 1;
        this.mIdToPromise.put(Integer.valueOf(i), promise);
        return i;
    }

    public void onEvent(C6380c c6380c) {
        if (this.mIdToPromise.containsKey(Integer.valueOf(c6380c.f20660a))) {
            ((Promise) this.mIdToPromise.get(Integer.valueOf(c6380c.f20660a))).resolve(Boolean.valueOf(true));
            this.mIdToPromise.remove(Integer.valueOf(c6380c.f20660a));
        }
    }

    @ReactMethod
    public void action(ReadableMap readableMap, Promise promise) {
        if (!C6348k.f20602a) {
            promise.resolve(Boolean.valueOf(true));
        }
        C5884c.m24753a().m24769d(new C6378a(getPromiseId(promise), readableMap.getString("selectorType"), readableMap.hasKey("selectorValue") ? readableMap.getString("selectorValue") : null, readableMap.getString("actionType"), readableMap.hasKey("actionValue") ? readableMap.getString("actionValue") : null, readableMap.hasKey("delay") ? readableMap.getInt("delay") : 0, readableMap.hasKey("timeout") ? readableMap.getInt("timeout") : 0));
    }

    @ReactMethod
    public void completed(String str, Promise promise) {
        if (!C6348k.f20602a) {
            promise.resolve(Boolean.valueOf(true));
        }
        C5884c.m24753a().m24769d(new C6379b(getPromiseId(promise), str));
    }
}
