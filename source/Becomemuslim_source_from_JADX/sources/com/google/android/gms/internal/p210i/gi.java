package com.google.android.gms.internal.p210i;

import com.google.android.gms.analytics.C2716q;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.gi */
public final class gi extends C2716q<gi> {
    /* renamed from: a */
    private Map<Integer, String> f24503a = new HashMap(4);

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f24503a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 9);
            stringBuilder.append("dimension");
            stringBuilder.append(valueOf);
            hashMap.put(stringBuilder.toString(), entry.getValue());
        }
        return gi.a(hashMap);
    }

    /* renamed from: a */
    public final Map<Integer, String> m31611a() {
        return Collections.unmodifiableMap(this.f24503a);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31612a(C2716q c2716q) {
        ((gi) c2716q).f24503a.putAll(this.f24503a);
    }
}
