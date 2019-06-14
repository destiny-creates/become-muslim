package com.google.android.gms.internal.p210i;

import com.google.android.gms.analytics.C2716q;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.hj */
public final class hj extends C2716q<hj> {
    /* renamed from: a */
    private Map<Integer, Double> f24532a = new HashMap(4);

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f24532a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 6);
            stringBuilder.append("metric");
            stringBuilder.append(valueOf);
            hashMap.put(stringBuilder.toString(), entry.getValue());
        }
        return hj.a(hashMap);
    }

    /* renamed from: a */
    public final Map<Integer, Double> m31689a() {
        return Collections.unmodifiableMap(this.f24532a);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31690a(C2716q c2716q) {
        ((hj) c2716q).f24532a.putAll(this.f24532a);
    }
}
