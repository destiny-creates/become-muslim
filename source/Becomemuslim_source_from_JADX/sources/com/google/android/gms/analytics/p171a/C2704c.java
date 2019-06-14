package com.google.android.gms.analytics.p171a;

import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.a.c */
public class C2704c {
    /* renamed from: a */
    private Map<String, String> f6953a = new HashMap();

    /* renamed from: a */
    private final void m7701a(String str, String str2) {
        C2872v.m8381a((Object) str, (Object) "Name should be non-null");
        this.f6953a.put(str, str2);
    }

    /* renamed from: a */
    public C2704c m7702a(String str) {
        m7701a("id", str);
        return this;
    }

    /* renamed from: b */
    public C2704c m7703b(String str) {
        m7701a("nm", str);
        return this;
    }

    /* renamed from: c */
    public C2704c m7704c(String str) {
        m7701a("cr", str);
        return this;
    }

    /* renamed from: d */
    public C2704c m7705d(String str) {
        m7701a("ps", str);
        return this;
    }

    /* renamed from: e */
    public final Map<String, String> m7706e(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f6953a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return C2716q.m7759a(this.f6953a);
    }
}
