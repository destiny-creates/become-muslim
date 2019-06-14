package com.facebook.ads.internal.p091f;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.f.b */
public class C1377b {
    /* renamed from: a */
    private final String f4004a;
    /* renamed from: b */
    private final Map<String, String> f4005b;
    /* renamed from: c */
    private final String f4006c;

    public C1377b(String str, Map<String, String> map) {
        this(str, map, false);
    }

    public C1377b(String str, Map<String, String> map, boolean z) {
        this.f4004a = str;
        this.f4005b = map;
        this.f4006c = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    /* renamed from: a */
    public Map<String, String> m4711a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("stacktrace", this.f4004a);
        hashMap.put("caught_exception", this.f4006c);
        hashMap.putAll(this.f4005b);
        return hashMap;
    }
}
