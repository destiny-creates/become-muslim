package com.google.android.gms.internal.p210i;

import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.analytics.p171a.C2702a;
import com.google.android.gms.analytics.p171a.C2703b;
import com.google.android.gms.analytics.p171a.C2704c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.jm */
public final class jm extends C2716q<jm> {
    /* renamed from: a */
    private final List<C2702a> f24544a = new ArrayList();
    /* renamed from: b */
    private final List<C2704c> f24545b = new ArrayList();
    /* renamed from: c */
    private final Map<String, List<C2702a>> f24546c = new HashMap();
    /* renamed from: d */
    private C2703b f24547d;

    /* renamed from: a */
    public final C2703b m31771a() {
        return this.f24547d;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.f24544a.isEmpty()) {
            hashMap.put("products", this.f24544a);
        }
        if (!this.f24545b.isEmpty()) {
            hashMap.put("promotions", this.f24545b);
        }
        if (!this.f24546c.isEmpty()) {
            hashMap.put("impressions", this.f24546c);
        }
        hashMap.put("productAction", this.f24547d);
        return jm.a(hashMap);
    }

    /* renamed from: b */
    public final List<C2702a> m31773b() {
        return Collections.unmodifiableList(this.f24544a);
    }

    /* renamed from: c */
    public final Map<String, List<C2702a>> m31774c() {
        return this.f24546c;
    }

    /* renamed from: d */
    public final List<C2704c> m31775d() {
        return Collections.unmodifiableList(this.f24545b);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31772a(C2716q c2716q) {
        jm jmVar = (jm) c2716q;
        jmVar.f24544a.addAll(this.f24544a);
        jmVar.f24545b.addAll(this.f24545b);
        for (Entry entry : this.f24546c.entrySet()) {
            String str = (String) entry.getKey();
            for (C2702a c2702a : (List) entry.getValue()) {
                if (c2702a != null) {
                    Object obj = str == null ? "" : str;
                    if (!jmVar.f24546c.containsKey(obj)) {
                        jmVar.f24546c.put(obj, new ArrayList());
                    }
                    ((List) jmVar.f24546c.get(obj)).add(c2702a);
                }
            }
        }
        if (this.f24547d != null) {
            jmVar.f24547d = this.f24547d;
        }
    }
}
