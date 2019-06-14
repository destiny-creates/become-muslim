package com.google.android.gms.internal.p210i;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.da */
public final class da {
    /* renamed from: a */
    private final Map<String, ct> f16471a;
    /* renamed from: b */
    private ct f16472b;

    private da() {
        this.f16471a = new HashMap();
    }

    /* renamed from: a */
    public final da m20412a(String str, ct ctVar) {
        this.f16471a.put(str, ctVar);
        return this;
    }

    /* renamed from: a */
    public final da m20411a(ct ctVar) {
        this.f16472b = ctVar;
        return this;
    }

    /* renamed from: a */
    public final cz m20410a() {
        return new cz(this.f16471a, this.f16472b);
    }
}
