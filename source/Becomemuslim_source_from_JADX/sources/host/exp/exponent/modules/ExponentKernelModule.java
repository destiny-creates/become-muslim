package host.exp.exponent.modules;

import android.app.Activity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import host.exp.exponent.C6301d;
import host.exp.exponent.experience.ErrorActivity;
import host.exp.exponent.experience.ExperienceActivity;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6334g;
import host.exp.exponent.p339f.C6338h;
import host.exp.exponent.p339f.C6338h.C6336b;
import host.exp.exponent.p339f.C6338h.C6337c;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p346j.C6388f;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.inject.C6562a;
import org.json.JSONObject;

public class ExponentKernelModule extends ReactContextBaseJavaModule implements C6334g {
    private static final String TAG = "ExponentKernelModule";
    private static ExponentKernelModule sInstance;
    private static Map<String, C6337c> sKernelEventCallbacks = new HashMap();
    @C6562a
    C6368f mExponentNetwork;
    @C6562a
    C6373d mExponentSharedPreferences;
    @C6562a
    C7560j mKernel;

    public String getName() {
        return "ExponentKernel";
    }

    public ExponentKernelModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        C6294a.m25957a().m25961b(ExponentKernelModule.class, this);
        sInstance = this;
    }

    public Map<String, Object> getConstants() {
        return MapBuilder.of("sdkVersions", C6301d.f20499e);
    }

    public static void queueEvent(String str, WritableMap writableMap, C6337c c6337c) {
        queueEvent(new C6336b(str, writableMap, c6337c));
    }

    public static void queueEvent(C6336b c6336b) {
        C6338h.f20581a.add(c6336b);
        if (sInstance != null) {
            sInstance.consumeEventQueue();
        }
    }

    public void consumeEventQueue() {
        if (C6338h.f20581a.size() != 0) {
            C6336b c6336b = (C6336b) C6338h.f20581a.remove();
            String uuid = UUID.randomUUID().toString();
            c6336b.f20579b.putString("eventId", uuid);
            if (c6336b.f20580c != null) {
                sKernelEventCallbacks.put(uuid, c6336b.f20580c);
            }
            ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit(c6336b.f20578a, c6336b.f20579b);
            consumeEventQueue();
        }
    }

    @ReactMethod
    public void getSessionAsync(Promise promise) {
        try {
            promise.resolve(Arguments.fromBundle(C6388f.m26203a(new JSONObject(this.mExponentSharedPreferences.m26156b("expo_auth_session")))));
        } catch (Throwable e) {
            promise.resolve(null);
            C6289b.m25950a(TAG, e);
        }
    }

    @ReactMethod
    public void setSessionAsync(ReadableMap readableMap, Promise promise) {
        try {
            this.mExponentSharedPreferences.m26154a(new JSONObject(readableMap.toHashMap()));
            promise.resolve(null);
        } catch (Throwable e) {
            promise.reject("ERR_SESSION_NOT_SAVED", "Could not save session secret", e);
            C6289b.m25950a(TAG, e);
        }
    }

    @ReactMethod
    public void removeSessionAsync(Promise promise) {
        try {
            this.mExponentSharedPreferences.m26166f();
            promise.resolve(null);
        } catch (Throwable e) {
            promise.reject("ERR_SESSION_NOT_REMOVED", "Could not remove session secret", e);
            C6289b.m25950a(TAG, e);
        }
    }

    @ReactMethod
    public void createShortcutAsync(String str, ReadableMap readableMap, String str2, Promise promise) {
        this.mKernel.m34245a(str, readableMap, str2);
        promise.resolve(Boolean.valueOf(true));
    }

    @ReactMethod
    public void addDevMenu() {
        this.mKernel.m34264i();
    }

    @ReactMethod
    public void goToHomeFromErrorScreen() {
        ErrorActivity a = ErrorActivity.m44447a();
        if (a == null) {
            C6289b.m25953c(TAG, "visibleActivity was null in goToHomeFromErrorScreen");
        } else {
            a.m44454d();
        }
    }

    @ReactMethod
    public void reloadFromErrorScreen() {
        ErrorActivity a = ErrorActivity.m44447a();
        if (a == null) {
            C6289b.m25953c(TAG, "visibleActivity was null in reloadFromErrorScreen");
        } else {
            a.m44455e();
        }
    }

    @ReactMethod
    public void onEventSuccess(String str, ReadableMap readableMap) {
        if (sKernelEventCallbacks.containsKey(str)) {
            ((C6337c) sKernelEventCallbacks.remove(str)).onEventSuccess(readableMap);
        }
    }

    @ReactMethod
    public void onEventFailure(String str, String str2) {
        if (sKernelEventCallbacks.containsKey(str)) {
            ((C6337c) sKernelEventCallbacks.remove(str)).onEventFailure(str2);
        }
    }

    @ReactMethod
    public void dismissNuxAsync(Promise promise) {
        Activity c = this.mKernel.m34252c();
        if (c instanceof ExperienceActivity) {
            ((ExperienceActivity) c).m44596a(false);
        }
        promise.resolve(Boolean.valueOf(true));
    }
}
