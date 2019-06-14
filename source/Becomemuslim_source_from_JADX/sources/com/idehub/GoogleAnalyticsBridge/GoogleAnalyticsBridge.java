package com.idehub.GoogleAnalyticsBridge;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.analytics.C2709e.C4302a;
import com.google.android.gms.analytics.C2709e.C4303b;
import com.google.android.gms.analytics.C2709e.C4304d;
import com.google.android.gms.analytics.C2709e.C4305e;
import com.google.android.gms.analytics.C2709e.C4306f;
import com.google.android.gms.analytics.C4746d;
import com.google.android.gms.analytics.C4748h;
import java.util.HashMap;
import java.util.Map;

public class GoogleAnalyticsBridge extends ReactContextBaseJavaModule {
    private final String _trackingId;
    HashMap<String, C4748h> mTrackers = new HashMap();

    public String getName() {
        return "GoogleAnalyticsBridge";
    }

    public GoogleAnalyticsBridge(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        this._trackingId = str;
    }

    synchronized C4746d getAnalyticsInstance() {
        return C4746d.a(getReactApplicationContext());
    }

    synchronized C4748h getTracker(String str) {
        if (!this.mTrackers.containsKey(str)) {
            C4746d a = C4746d.a(getReactApplicationContext());
            a.a(20);
            C4748h a2 = a.a(str);
            a2.a(true);
            this.mTrackers.put(str, a2);
        }
        return (C4748h) this.mTrackers.get(str);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("nativeTrackerId", this._trackingId);
        return hashMap;
    }

    @ReactMethod
    public void trackScreenView(String str, String str2, ReadableMap readableMap) {
        str = getTracker(str);
        if (str != null) {
            str.b(str2);
            C4304d c4304d = new C4304d();
            if (readableMap != null) {
                C5403d.m22967a(c4304d, readableMap);
            }
            str.a(c4304d.b());
        }
    }

    @ReactMethod
    public void trackEvent(String str, String str2, String str3, String str4, String str5, ReadableMap readableMap) {
        str = getTracker(str);
        if (str != null) {
            C4302a b = new C4302a().a(str2).b(str3);
            if (str4 != null) {
                b.c(str4);
            }
            if (str5 != null) {
                b.a(Long.valueOf(str5).longValue());
            }
            if (readableMap != null) {
                C5403d.m22965a(b, readableMap);
            }
            str.a(b.b());
        }
    }

    @ReactMethod
    public void trackTiming(String str, String str2, Double d, String str3, String str4, ReadableMap readableMap) {
        str = getTracker(str);
        if (str != null) {
            C4306f a = new C4306f().b(str2).a(d.longValue()).a(str3);
            if (str4 != null) {
                a.c(str4);
            }
            if (readableMap != null) {
                C5403d.m22969a(a, readableMap);
            }
            str.a(a.b());
        }
    }

    @ReactMethod
    public void trackException(String str, String str2, Boolean bool, ReadableMap readableMap) {
        str = getTracker(str);
        if (str != null) {
            C4303b a = new C4303b().a(str2).a(bool.booleanValue());
            if (readableMap != null) {
                C5403d.m22966a(a, readableMap);
            }
            str.a(a.b());
        }
    }

    @ReactMethod
    public void trackSocialInteraction(String str, String str2, String str3, String str4, ReadableMap readableMap) {
        str = getTracker(str);
        if (str != null) {
            C4305e c = new C4305e().a(str2).b(str3).c(str4);
            if (readableMap != null) {
                C5403d.m22968a(c, readableMap);
            }
            str.a(c.b());
        }
    }

    @ReactMethod
    public void setUser(String str, String str2) {
        str = getTracker(str);
        if (str != null) {
            str.a("&uid", str2);
        }
    }

    @ReactMethod
    public void setClient(String str, String str2) {
        str = getTracker(str);
        if (str != null) {
            str.a("&cid", str2);
        }
    }

    @ReactMethod
    public void getClientId(String str, Promise promise) {
        try {
            str = getTracker(str);
            Object obj = "";
            if (str != null) {
                obj = str.a("&cid");
            }
            promise.resolve(obj);
        } catch (String str2) {
            promise.reject(str2);
        }
    }

    @ReactMethod
    public void allowIDFA(String str, Boolean bool) {
        str = getTracker(str);
        if (str != null) {
            str.c(bool.booleanValue());
        }
    }

    @ReactMethod
    public void setSamplingRate(String str, Double d) {
        str = getTracker(str);
        if (str != null) {
            str.a(d.doubleValue());
        }
    }

    @ReactMethod
    public void setAnonymizeIp(String str, Boolean bool) {
        str = getTracker(str);
        if (str != null) {
            str.b(bool.booleanValue());
        }
    }

    @ReactMethod
    public void setAppName(String str, String str2) {
        str = getTracker(str);
        if (str != null) {
            str.c(str2);
        }
    }

    @ReactMethod
    public void setAppVersion(String str, String str2) {
        str = getTracker(str);
        if (str != null) {
            str.d(str2);
        }
    }

    @ReactMethod
    public void setCurrency(String str, String str2) {
        str = getTracker(str);
        if (str != null) {
            str.a("&cu", str2);
        }
    }

    @ReactMethod
    public void setTrackUncaughtExceptions(String str, Boolean bool) {
        str = getTracker(str);
        if (str != null) {
            str.a(bool.booleanValue());
        }
    }

    @ReactMethod
    public void createNewSession(String str, String str2) {
        str = getTracker(str);
        str.b(str2);
        str.a(((C4304d) new C4304d().a()).b());
    }

    @ReactMethod
    public void dispatch(Promise promise) {
        try {
            getAnalyticsInstance().f();
            promise.resolve(Boolean.valueOf(true));
        } catch (Throwable e) {
            promise.reject(e);
        }
    }
}
