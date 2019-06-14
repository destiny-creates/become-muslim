package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p186f.C2955h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.internal.s */
public final class C2812s {
    /* renamed from: a */
    private final Map<BasePendingResult<?>, Boolean> f7213a = Collections.synchronizedMap(new WeakHashMap());
    /* renamed from: b */
    private final Map<C2955h<?>, Boolean> f7214b = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: a */
    final void m8101a(BasePendingResult<? extends C2814k> basePendingResult, boolean z) {
        this.f7213a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.mo2378a(new C4352t(this, basePendingResult));
    }

    /* renamed from: a */
    final <TResult> void m8102a(C2955h<TResult> c2955h, boolean z) {
        this.f7214b.put(c2955h, Boolean.valueOf(z));
        c2955h.m8783a().mo2578a(new C4353u(this, c2955h));
    }

    /* renamed from: a */
    final boolean m8103a() {
        if (this.f7213a.isEmpty()) {
            if (this.f7214b.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final void m8104b() {
        m8099a(false, C2798d.f7175a);
    }

    /* renamed from: c */
    public final void m8105c() {
        m8099a(true, by.f7151a);
    }

    /* renamed from: a */
    private final void m8099a(boolean z, Status status) {
        synchronized (this.f7213a) {
            Map hashMap = new HashMap(this.f7213a);
        }
        synchronized (this.f7214b) {
            Map hashMap2 = new HashMap(this.f7214b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m14072c(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C2955h) entry2.getKey()).m8786b(new C2782b(status));
            }
        }
    }
}
