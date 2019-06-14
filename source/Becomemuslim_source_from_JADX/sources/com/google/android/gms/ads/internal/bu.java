package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.anc;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.hy;
import com.google.android.gms.internal.ads.hz;
import com.google.android.gms.internal.ads.ie;
import com.google.android.gms.internal.ads.oy;
import com.google.android.gms.internal.ads.pf;
import com.google.android.gms.internal.ads.pt;
import com.google.android.gms.internal.ads.qe;

@cm
public final class bu {
    /* renamed from: a */
    public final qe f6843a;
    /* renamed from: b */
    public final oy f6844b;
    /* renamed from: c */
    public final ie f6845c;
    /* renamed from: d */
    public final anc f6846d;

    private bu(qe qeVar, oy oyVar, ie ieVar, anc anc) {
        this.f6843a = qeVar;
        this.f6844b = oyVar;
        this.f6845c = ieVar;
        this.f6846d = anc;
    }

    /* renamed from: a */
    public static bu m7504a(Context context) {
        return new bu(new pt(), new pf(), new hy(new hz()), new anc(context));
    }
}
