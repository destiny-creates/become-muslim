package com.geektime.rnonesignalandroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.onesignal.C5545z;
import com.onesignal.OSSubscriptionState;
import com.onesignal.aa;
import com.onesignal.ad;
import com.onesignal.ah;
import com.onesignal.aj;
import com.onesignal.am;
import com.onesignal.am.C5459d;
import com.onesignal.am.C5460e;
import com.onesignal.am.C5461f;
import com.onesignal.am.C5463h;
import com.onesignal.am.C5465j;
import com.onesignal.am.C5466k;
import com.onesignal.am.C5469n;
import org.json.JSONArray;
import org.json.JSONObject;

public class RNOneSignal extends ReactContextBaseJavaModule implements LifecycleEventListener, C5465j, C5466k {
    public static final String HIDDEN_MESSAGE_KEY = "hidden";
    private ad coldStartNotificationResult;
    private boolean didSetRequiresPrivacyConsent = false;
    private ReactApplicationContext mReactApplicationContext;
    private ReactContext mReactContext;
    private boolean oneSignalInitDone;
    private Callback pendingGetTagsCallback;
    private boolean registeredEvents = false;
    private boolean setNotificationOpenedHandler = false;
    private boolean waitingForUserPrivacyConsent = false;

    /* renamed from: com.geektime.rnonesignalandroid.RNOneSignal$1 */
    class C39741 implements C5461f {
        /* renamed from: a */
        final /* synthetic */ RNOneSignal f9980a;

        C39741(RNOneSignal rNOneSignal) {
            this.f9980a = rNOneSignal;
        }

        /* renamed from: a */
        public void m12179a(JSONObject jSONObject) {
            if (this.f9980a.pendingGetTagsCallback != null) {
                this.f9980a.pendingGetTagsCallback.invoke(C2093a.m5759a(jSONObject));
            }
            this.f9980a.pendingGetTagsCallback = null;
        }
    }

    /* renamed from: com.geektime.rnonesignalandroid.RNOneSignal$5 */
    class C39785 implements C5463h {
        /* renamed from: a */
        final /* synthetic */ RNOneSignal f9987a;

        C39785(RNOneSignal rNOneSignal) {
            this.f9987a = rNOneSignal;
        }

        /* renamed from: a */
        public void m12186a(String str, String str2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("userId", str);
            createMap.putString("pushToken", str2);
            this.f9987a.sendEvent("OneSignal-idsAvailable", createMap);
        }
    }

    /* renamed from: com.geektime.rnonesignalandroid.RNOneSignal$6 */
    class C39796 implements C5469n {
        /* renamed from: a */
        final /* synthetic */ RNOneSignal f9988a;

        C39796(RNOneSignal rNOneSignal) {
            this.f9988a = rNOneSignal;
        }

        /* renamed from: a */
        public void m12187a(JSONObject jSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("postNotification Success: ");
            stringBuilder.append(jSONObject.toString());
            Log.i("OneSignal", stringBuilder.toString());
        }

        /* renamed from: b */
        public void m12188b(JSONObject jSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("postNotification Failure: ");
            stringBuilder.append(jSONObject.toString());
            Log.e("OneSignal", stringBuilder.toString());
        }
    }

    public String getName() {
        return "OneSignal";
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public RNOneSignal(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactContext = reactApplicationContext;
        this.mReactContext.addLifecycleEventListener(this);
        initOneSignal();
    }

    private String appIdFromManifest(ReactApplicationContext reactApplicationContext) {
        try {
            PackageManager packageManager = reactApplicationContext.getPackageManager();
            String packageName = reactApplicationContext.getPackageName();
            reactApplicationContext.getPackageManager();
            return packageManager.getApplicationInfo(packageName, 128).metaData.getString("onesignal_app_id");
        } catch (ReactApplicationContext reactApplicationContext2) {
            reactApplicationContext2.printStackTrace();
            return null;
        }
    }

    private void initOneSignal() {
        am.f18406g = "react";
        String appIdFromManifest = appIdFromManifest(this.mReactApplicationContext);
        if (appIdFromManifest != null && appIdFromManifest.length() > 0) {
            init(appIdFromManifest);
        }
    }

    private void sendEvent(String str, Object obj) {
        ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    private JSONObject jsonFromErrorMessageString(String str) {
        return new JSONObject().put("error", str);
    }

    @ReactMethod
    public void init(String str) {
        Context currentActivity = this.mReactApplicationContext.getCurrentActivity();
        if (this.oneSignalInitDone) {
            Log.e("onesignal", "Already initialized the OneSignal React-Native SDK");
            return;
        }
        this.oneSignalInitDone = true;
        am.f18406g = "react";
        if (currentActivity == null) {
            currentActivity = this.mReactApplicationContext.getApplicationContext();
        }
        am.a(currentActivity, null, str, this, this);
        if (this.didSetRequiresPrivacyConsent != null) {
            this.waitingForUserPrivacyConsent = true;
        }
    }

    @ReactMethod
    public void sendTag(String str, String str2) {
        am.a(str, str2);
    }

    @ReactMethod
    public void sendTags(ReadableMap readableMap) {
        am.a(C2093a.m5760a(readableMap));
    }

    @ReactMethod
    public void getTags(Callback callback) {
        if (this.pendingGetTagsCallback == null) {
            this.pendingGetTagsCallback = callback;
        }
        am.a(new C39741(this));
    }

    @ReactMethod
    public void setUnauthenticatedEmail(String str, final Callback callback) {
        am.a(str, null, new C5460e(this) {
            /* renamed from: b */
            final /* synthetic */ RNOneSignal f9982b;

            /* renamed from: a */
            public void m12180a() {
                callback.invoke(new Object[0]);
            }

            /* renamed from: a */
            public void m12181a(C5459d c5459d) {
                try {
                    callback.invoke(C2093a.m5759a(this.f9982b.jsonFromErrorMessageString(c5459d.a())));
                } catch (C5459d c5459d2) {
                    c5459d2.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void setEmail(String str, String str2, final Callback callback) {
        am.a(str, str2, new C5460e(this) {
            /* renamed from: b */
            final /* synthetic */ RNOneSignal f9984b;

            /* renamed from: a */
            public void m12182a() {
                callback.invoke(new Object[0]);
            }

            /* renamed from: a */
            public void m12183a(C5459d c5459d) {
                try {
                    callback.invoke(C2093a.m5759a(this.f9984b.jsonFromErrorMessageString(c5459d.a())));
                } catch (C5459d c5459d2) {
                    c5459d2.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void logoutEmail(final Callback callback) {
        am.a(new C5460e(this) {
            /* renamed from: b */
            final /* synthetic */ RNOneSignal f9986b;

            /* renamed from: a */
            public void m12184a() {
                callback.invoke(new Object[0]);
            }

            /* renamed from: a */
            public void m12185a(C5459d c5459d) {
                try {
                    callback.invoke(C2093a.m5759a(this.f9986b.jsonFromErrorMessageString(c5459d.a())));
                } catch (C5459d c5459d2) {
                    c5459d2.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void configure() {
        am.a(new C39785(this));
    }

    @ReactMethod
    public void getPermissionSubscriptionState(Callback callback) {
        aj s = am.s();
        if (s != null) {
            ah a = s.a();
            OSSubscriptionState b = s.b();
            C5545z c = s.c();
            boolean b2 = a.b();
            boolean d = b.d();
            boolean c2 = b.c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notificationsEnabled", String.valueOf(b2)).put("subscriptionEnabled", String.valueOf(d)).put("userSubscriptionEnabled", String.valueOf(c2)).put("pushToken", b.b()).put("userId", b.a()).put("emailUserId", c.b()).put("emailAddress", c.c());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("permission subscription state: ");
                stringBuilder.append(jSONObject.toString());
                Log.d("onesignal", stringBuilder.toString());
                callback.invoke(C2093a.m5759a(jSONObject));
            } catch (Callback callback2) {
                callback2.printStackTrace();
            }
        }
    }

    @ReactMethod
    public void inFocusDisplaying(int i) {
        am.a(i);
    }

    @ReactMethod
    public void deleteTag(String str) {
        am.d(str);
    }

    @ReactMethod
    public void enableVibrate(Boolean bool) {
        am.e(bool.booleanValue());
    }

    @ReactMethod
    public void enableSound(Boolean bool) {
        am.f(bool.booleanValue());
    }

    @ReactMethod
    public void setSubscription(Boolean bool) {
        am.g(bool.booleanValue());
    }

    @ReactMethod
    public void promptLocation() {
        am.q();
    }

    @ReactMethod
    public void syncHashedEmail(String str) {
        am.b(str);
    }

    @ReactMethod
    public void setLogLevel(int i, int i2) {
        am.a(i, i2);
    }

    @ReactMethod
    public void setLocationShared(Boolean bool) {
        am.h(bool.booleanValue());
    }

    @ReactMethod
    public void postNotification(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("contents", new JSONObject(str));
            if (str3 != null) {
                str = new JSONArray();
                str.put(str3);
                jSONObject.put("include_player_ids", str);
            }
            if (str2 != null) {
                str = new JSONObject();
                str.put("p2p_notification", new JSONObject(str2));
                jSONObject.put("data", str);
            }
            if (str4 != null && str4.trim().isEmpty() == null) {
                str = new JSONObject(str4.trim());
                str2 = str.keys();
                while (str2.hasNext() != null) {
                    str3 = (String) str2.next();
                    jSONObject.put(str3, str.get(str3));
                }
                if (!(str.has("hidden") == null || str.getBoolean("hidden") == null)) {
                    jSONObject.getJSONObject("data").put("hidden", true);
                }
            }
            am.a(jSONObject, new C39796(this));
        } catch (String str5) {
            str5.printStackTrace();
        }
    }

    @ReactMethod
    public void clearOneSignalNotifications() {
        am.r();
    }

    @ReactMethod
    public void cancelNotification(int i) {
        am.b(i);
    }

    @ReactMethod
    public void setRequiresUserPrivacyConsent(Boolean bool) {
        am.b(bool.booleanValue());
    }

    @ReactMethod
    public void provideUserConsent(Boolean bool) {
        am.a(bool.booleanValue());
    }

    @ReactMethod
    public void userProvidedPrivacyConsent(Promise promise) {
        promise.resolve(Boolean.valueOf(am.d()));
    }

    @ReactMethod
    public void setExternalUserId(String str) {
        am.c(str);
    }

    @ReactMethod
    public void removeExternalUserId() {
        am.i();
    }

    public void notificationReceived(aa aaVar) {
        sendEvent("OneSignal-remoteNotificationReceived", C2093a.m5759a(aaVar.a()));
    }

    public void notificationOpened(ad adVar) {
        if (this.setNotificationOpenedHandler) {
            sendEvent("OneSignal-remoteNotificationOpened", C2093a.m5759a(adVar.a()));
        } else {
            this.coldStartNotificationResult = adVar;
        }
    }

    @ReactMethod
    public void didSetNotificationOpenedHandler() {
        this.setNotificationOpenedHandler = true;
        if (this.coldStartNotificationResult != null) {
            notificationOpened(this.coldStartNotificationResult);
            this.coldStartNotificationResult = null;
        }
    }

    public void onHostResume() {
        initOneSignal();
    }
}
