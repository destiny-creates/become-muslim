package host.exp.exponent.p334a;

import android.app.Application;
import android.content.Context;
import com.amplitude.api.Amplitude;
import com.amplitude.api.Constants;
import host.exp.exponent.C6301d;
import host.exp.p333a.C6263a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Analytics */
/* renamed from: host.exp.exponent.a.a */
public class C6288a {
    /* renamed from: a */
    private static final String f20454a = "a";
    /* renamed from: b */
    private static final Map<C6287a, Long> f20455b = new HashMap();

    /* compiled from: Analytics */
    /* renamed from: host.exp.exponent.a.a$a */
    public enum C6287a {
        LAUNCHER_ACTIVITY_STARTED,
        STARTED_FETCHING_MANIFEST,
        STARTED_MANIFEST_NETWORK_REQUEST,
        FINISHED_MANIFEST_NETWORK_REQUEST,
        FINISHED_FETCHING_MANIFEST,
        STARTED_FETCHING_BUNDLE,
        FINISHED_FETCHING_BUNDLE,
        STARTED_WRITING_BUNDLE,
        FINISHED_WRITING_BUNDLE,
        STARTED_LOADING_REACT_NATIVE,
        FINISHED_LOADING_REACT_NATIVE
    }

    /* renamed from: a */
    public static void m25940a(Context context, Application application) {
        if (C6301d.f20508n) {
            C6288a.m25947b();
            try {
                Amplitude.getInstance().initialize(context, C6263a.f20400b ? "39c2521e973c2fe323143f1b1c4cde74" : "1b9250eab537ead4557ae2e38b02f9d9");
            } catch (Context context2) {
                C6289b.m25951a(context2);
            }
            if (application != null) {
                Amplitude.getInstance().enableForegroundTracking(application);
            }
            try {
                context2 = new JSONObject();
                context2.put("INITIAL_URL", C6301d.f20496b);
                context2.put("ABI_VERSIONS", C6301d.f20498d);
                context2.put("TEMPORARY_ABI_VERSION", "32.0.0");
                Amplitude.getInstance().setUserProperties(context2);
            } catch (Throwable e) {
                C6289b.m25950a(f20454a, e);
            }
        }
    }

    /* renamed from: a */
    public static void m25942a(String str) {
        if (C6301d.f20508n) {
            Amplitude.getInstance().logEvent(str);
        }
    }

    /* renamed from: a */
    public static void m25945a(String str, JSONObject jSONObject) {
        if (C6301d.f20508n) {
            Amplitude.getInstance().logEvent(str, jSONObject);
        }
    }

    /* renamed from: a */
    public static void m25943a(String str, String str2) {
        C6288a.m25944a(str, str2, null);
    }

    /* renamed from: a */
    public static void m25944a(String str, String str2, String str3) {
        if (C6301d.m26001a() || str.equals("LOAD_EXPERIENCE")) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (str2 != null) {
                    jSONObject.put("MANIFEST_URL", str2);
                }
                if (str3 != null) {
                    jSONObject.put("SDK_VERSION", str3);
                }
                C6288a.m25945a(str, jSONObject);
            } catch (String str4) {
                C6289b.m25953c(f20454a, str4.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static void m25941a(C6287a c6287a) {
        f20455b.put(c6287a, Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public static void m25948b(String str) {
        if (str != null) {
            try {
                Long a = C6288a.m25938a(C6287a.FINISHED_LOADING_REACT_NATIVE, C6287a.LAUNCHER_ACTIVITY_STARTED);
                if (a != null) {
                    if (a.longValue() <= Constants.EVENT_UPLOAD_PERIOD_MILLIS) {
                        JSONObject jSONObject = new JSONObject();
                        C6288a.m25946a(jSONObject, "TOTAL_DURATION", C6287a.FINISHED_LOADING_REACT_NATIVE, C6287a.LAUNCHER_ACTIVITY_STARTED);
                        C6288a.m25946a(jSONObject, "LAUNCH_TO_MANIFEST_START_DURATION", C6287a.STARTED_FETCHING_MANIFEST, C6287a.LAUNCHER_ACTIVITY_STARTED);
                        C6288a.m25946a(jSONObject, "MANIFEST_TOTAL_DURATION", C6287a.FINISHED_FETCHING_MANIFEST, C6287a.STARTED_FETCHING_MANIFEST);
                        C6288a.m25946a(jSONObject, "MANIFEST_NETWORK_DURATION", C6287a.FINISHED_MANIFEST_NETWORK_REQUEST, C6287a.STARTED_MANIFEST_NETWORK_REQUEST);
                        C6288a.m25946a(jSONObject, "BUNDLE_FETCH_DURATION", C6287a.FINISHED_FETCHING_BUNDLE, C6287a.STARTED_FETCHING_BUNDLE);
                        C6288a.m25946a(jSONObject, "BUNDLE_WRITE_DURATION", C6287a.FINISHED_WRITING_BUNDLE, C6287a.STARTED_WRITING_BUNDLE);
                        C6288a.m25946a(jSONObject, "REACT_NATIVE_DURATION", C6287a.FINISHED_LOADING_REACT_NATIVE, C6287a.STARTED_LOADING_REACT_NATIVE);
                        jSONObject.put("MANIFEST_URL", str);
                        C6288a.m25945a(str.equals(C6301d.f20496b) != null ? "SHELL_EXPERIENCE_LOADED" : "EXPERIENCE_LOADED", jSONObject);
                        f20455b.clear();
                        return;
                    }
                }
                f20455b.clear();
                f20455b.clear();
            } catch (String str2) {
                C6289b.m25953c(f20454a, str2.getMessage());
            } catch (Throwable th) {
                f20455b.clear();
            }
        }
    }

    /* renamed from: a */
    public static void m25939a() {
        f20455b.clear();
    }

    /* renamed from: a */
    private static Long m25938a(C6287a c6287a, C6287a c6287a2) {
        if (f20455b.containsKey(c6287a)) {
            if (f20455b.containsKey(c6287a2)) {
                return Long.valueOf(((Long) f20455b.get(c6287a)).longValue() - ((Long) f20455b.get(c6287a2)).longValue());
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m25946a(JSONObject jSONObject, String str, C6287a c6287a, C6287a c6287a2) {
        if (C6288a.m25938a(c6287a, c6287a2) != null) {
            jSONObject.put(str, C6288a.m25938a(c6287a, c6287a2));
        }
    }

    /* renamed from: b */
    public static void m25947b() {
        try {
            Field declaredField = Class.forName("com.amplitude.api.DatabaseHelper").getDeclaredField("instance");
            declaredField.setAccessible(true);
            declaredField.set(null, null);
        } catch (Throwable th) {
            C6289b.m25953c(f20454a, th.toString());
        }
    }
}
