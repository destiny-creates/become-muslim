package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.internal.C2872v;

@cm
public final class pe {
    /* renamed from: a */
    private final Context f15877a;
    /* renamed from: b */
    private final pn f15878b;
    /* renamed from: c */
    private final ViewGroup f15879c;
    /* renamed from: d */
    private oz f15880d;

    private pe(Context context, ViewGroup viewGroup, pn pnVar, oz ozVar) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f15877a = context;
        this.f15879c = viewGroup;
        this.f15878b = pnVar;
        this.f15880d = null;
    }

    public pe(Context context, ViewGroup viewGroup, qo qoVar) {
        this(context, viewGroup, qoVar, null);
    }

    /* renamed from: a */
    public final oz m19993a() {
        C2872v.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f15880d;
    }

    /* renamed from: a */
    public final void m19994a(int i, int i2, int i3, int i4) {
        C2872v.b("The underlay may only be modified from the UI thread.");
        if (this.f15880d != null) {
            this.f15880d.m30944a(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public final void m19995a(int i, int i2, int i3, int i4, int i5, boolean z, pm pmVar) {
        if (this.f15880d == null) {
            asv.m18908a(r0.f15878b.mo6132j().m18913a(), r0.f15878b.mo6688c(), "vpr2");
            r0.f15880d = new oz(r0.f15877a, r0.f15878b, i5, z, r0.f15878b.mo6132j().m18913a(), pmVar);
            r0.f15879c.addView(r0.f15880d, 0, new LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            r0.f15880d.m30944a(i, i2, i3, i4);
            r0.f15878b.mo6681a(false);
        }
    }

    /* renamed from: b */
    public final void m19996b() {
        C2872v.b("onPause must be called from the UI thread.");
        if (this.f15880d != null) {
            this.f15880d.m30955i();
        }
    }

    /* renamed from: c */
    public final void m19997c() {
        C2872v.b("onDestroy must be called from the UI thread.");
        if (this.f15880d != null) {
            this.f15880d.m30960n();
            this.f15879c.removeView(this.f15880d);
            this.f15880d = null;
        }
    }
}
