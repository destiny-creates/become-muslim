package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.C2698b;

@cm
public final class arj {
    /* renamed from: a */
    private static arj f14883a;
    /* renamed from: b */
    private static final Object f14884b = new Object();
    /* renamed from: c */
    private C2698b f14885c;

    private arj() {
    }

    /* renamed from: a */
    public static arj m18859a() {
        arj arj;
        synchronized (f14884b) {
            if (f14883a == null) {
                f14883a = new arj();
            }
            arj = f14883a;
        }
        return arj;
    }

    /* renamed from: a */
    public final C2698b m18860a(Context context) {
        synchronized (f14884b) {
            if (this.f14885c != null) {
                C2698b c2698b = this.f14885c;
                return c2698b;
            }
            this.f14885c = new gv(context, (gh) aoy.m18670a(context, false, new ape(aph.m18684b(), context, new bcx())));
            c2698b = this.f14885c;
            return c2698b;
        }
    }
}
