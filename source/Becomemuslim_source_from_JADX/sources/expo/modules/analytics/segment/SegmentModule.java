package expo.modules.analytics.segment;

import android.content.Context;
import android.content.SharedPreferences;
import com.p073d.p074a.C1133a;
import com.p073d.p074a.C1133a.C1125a;
import com.p073d.p074a.C1153k;
import com.p073d.p074a.C3483n;
import com.p073d.p074a.C3490s;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p310c.C6023a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SegmentModule extends C6006c implements C6001h {
    private static final String ENABLED_PREFERENCE_KEY = "enabled";
    private static final String NAME = "ExponentSegment";
    private static final String TAG = "SegmentModule";
    private static int sCurrentTag;
    private C1133a mClient;
    private C6023a mConstants;
    private Context mContext;
    private SharedPreferences mSharedPreferences = this.mContext.getSharedPreferences(NAME, 0);

    public String getName() {
        return NAME;
    }

    public SegmentModule(Context context) {
        super(context);
        this.mContext = context;
    }

    private static C3490s readableMapToTraits(Map<String, Object> map) {
        C3490s c3490s = new C3490s();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                c3490s.c(str, coalesceAnonymousMapToJsonObject((Map) obj));
            } else {
                c3490s.c(str, obj);
            }
        }
        return c3490s;
    }

    private static Map<String, Object> coalesceAnonymousMapToJsonObject(Map map) {
        Map<String, Object> hashMap = new HashMap();
        for (Object next : map.keySet()) {
            if (next instanceof String) {
                Object obj = map.get(next);
                if (obj instanceof Map) {
                    hashMap.put((String) next, coalesceAnonymousMapToJsonObject((Map) obj));
                } else {
                    hashMap.put((String) next, obj);
                }
            }
        }
        return hashMap;
    }

    private static C1153k readableMapToOptions(Map<String, Object> map) {
        C1153k c1153k = new C1153k();
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                if (entry.getValue() instanceof Map) {
                    Map map2 = (Map) entry.getValue();
                    if (map2.get("enabled") instanceof Double) {
                        c1153k.a(str, ((Double) map2.get("enabled")).doubleValue() > 0.0d);
                    }
                    if (map2.get("options") instanceof Map) {
                        c1153k.a(str, coalesceAnonymousMapToJsonObject((Map) map2.get("options")));
                    }
                }
            }
        }
        return c1153k;
    }

    private static C3483n readableMapToProperties(Map<String, Object> map) {
        C3483n c3483n = new C3483n();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                c3483n.c(str, coalesceAnonymousMapToJsonObject((Map) obj));
            } else {
                c3483n.c(str, obj);
            }
        }
        return c3483n;
    }

    @C5996c
    public void initializeAndroid(String str, C6009f c6009f) {
        C1125a c1125a = new C1125a(this.mContext, str);
        str = sCurrentTag;
        sCurrentTag = str + 1;
        c1125a.a(Integer.toString(str));
        this.mClient = c1125a.a();
        this.mClient.a(getEnabledPreferenceValue() ^ 1);
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void initializeIOS(String str, C6009f c6009f) {
        c6009f.m25152a("E_WRONG_PLATFORM", "Method initializeIOS should not be called on Android, please file an issue on GitHub.");
    }

    @C5996c
    public void identify(String str, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.a(str);
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void identifyWithTraits(String str, Map<String, Object> map, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.a(str, readableMapToTraits(map), new C1153k());
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void track(String str, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.c(str);
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void trackWithProperties(String str, Map<String, Object> map, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.a(str, readableMapToProperties(map));
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void alias(String str, Map<String, Object> map, C6009f c6009f) {
        C1133a c1133a = this.mClient;
        if (c1133a != null) {
            c1133a.a(str, readableMapToOptions(map));
            c6009f.mo5137a((Object) null);
            return;
        }
        c6009f.m25152a("E_NO_SEG", "Segment instance has not been initialized yet, have you tried calling Segment.initialize prior to calling Segment.alias?");
    }

    @C5996c
    public void group(String str, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.b(str);
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void groupWithTraits(String str, Map<String, Object> map, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.b(str, readableMapToTraits(map), new C1153k());
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void screen(String str, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.d(str);
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void screenWithProperties(String str, Map<String, Object> map, C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.b(str, readableMapToProperties(map));
        }
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void flush(C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.c();
        }
        c6009f.mo5137a(null);
    }

    @C5996c
    public void reset(C6009f c6009f) {
        if (this.mClient != null) {
            this.mClient.f();
        }
        c6009f.mo5137a(null);
    }

    @C5996c
    public void getEnabledAsync(C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(getEnabledPreferenceValue()));
    }

    @C5996c
    public void setEnabledAsync(boolean z, C6009f c6009f) {
        if (this.mConstants.getAppOwnership().equals("expo")) {
            c6009f.m25152a("E_UNSUPPORTED", "Setting Segment's `enabled` is not supported in Expo Client.");
            return;
        }
        this.mSharedPreferences.edit().putBoolean("enabled", z).apply();
        if (this.mClient != null) {
            this.mClient.a(z ^ 1);
        }
        c6009f.mo5137a((Object) false);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mConstants = null;
        if (c6007d != null) {
            this.mConstants = (C6023a) c6007d.m25133a(C6023a.class);
        }
    }

    private boolean getEnabledPreferenceValue() {
        return this.mSharedPreferences.getBoolean("enabled", true);
    }
}
