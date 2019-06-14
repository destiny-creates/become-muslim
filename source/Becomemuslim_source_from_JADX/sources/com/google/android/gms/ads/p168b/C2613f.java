package com.google.android.gms.ads.p168b;

import android.view.View;
import com.google.android.gms.internal.ads.avn;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.p174b.C2758b;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.ads.b.f */
public final class C2613f {
    /* renamed from: a */
    public static WeakHashMap<View, C2613f> f6657a = new WeakHashMap();
    /* renamed from: b */
    private avn f6658b;
    /* renamed from: c */
    private WeakReference<View> f6659c;

    /* renamed from: a */
    private final void m7375a(C2758b c2758b) {
        Object obj = this.f6659c != null ? (View) this.f6659c.get() : null;
        if (obj == null) {
            mt.e("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!f6657a.containsKey(obj)) {
            f6657a.put(obj, this);
        }
        if (this.f6658b != null) {
            try {
                this.f6658b.a(c2758b);
            } catch (Throwable e) {
                mt.b("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    /* renamed from: a */
    public final void m7376a(C2609c c2609c) {
        m7375a((C2758b) c2609c.m7354a());
    }

    /* renamed from: a */
    public final void m7377a(C2620m c2620m) {
        m7375a((C2758b) c2620m.m7392k());
    }
}
