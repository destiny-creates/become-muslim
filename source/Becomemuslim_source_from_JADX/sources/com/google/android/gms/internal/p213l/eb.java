package com.google.android.gms.internal.p213l;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.l.eb */
final class eb implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ boolean f17153a;
    /* renamed from: b */
    private final /* synthetic */ dz f17154b;
    /* renamed from: c */
    private final /* synthetic */ dz f17155c;
    /* renamed from: d */
    private final /* synthetic */ ea f17156d;

    eb(ea eaVar, boolean z, dz dzVar, dz dzVar2) {
        this.f17156d = eaVar;
        this.f17153a = z;
        this.f17154b = dzVar;
        this.f17155c = dzVar2;
    }

    public final void run() {
        Object obj;
        Bundle bundle;
        if (this.f17153a && this.f17156d.f32814a != null) {
            this.f17156d.m44135a(this.f17156d.f32814a);
        }
        if (this.f17154b != null && this.f17154b.f17147c == this.f17155c.f17147c && fw.m42649b(this.f17154b.f17146b, this.f17155c.f17146b)) {
            if (fw.m42649b(this.f17154b.f17145a, this.f17155c.f17145a)) {
                obj = null;
                if (obj != null) {
                    bundle = new Bundle();
                    ea.m44136a(this.f17155c, bundle, true);
                    if (this.f17154b != null) {
                        if (this.f17154b.f17145a != null) {
                            bundle.putString("_pn", this.f17154b.f17145a);
                        }
                        bundle.putString("_pc", this.f17154b.f17146b);
                        bundle.putLong("_pi", this.f17154b.f17147c);
                    }
                    this.f17156d.mo6742f().m44110b("auto", "_vs", bundle);
                }
                this.f17156d.f32814a = this.f17155c;
                this.f17156d.mo6744h().m44195a(this.f17155c);
            }
        }
        obj = 1;
        if (obj != null) {
            bundle = new Bundle();
            ea.m44136a(this.f17155c, bundle, true);
            if (this.f17154b != null) {
                if (this.f17154b.f17145a != null) {
                    bundle.putString("_pn", this.f17154b.f17145a);
                }
                bundle.putString("_pc", this.f17154b.f17146b);
                bundle.putLong("_pi", this.f17154b.f17147c);
            }
            this.f17156d.mo6742f().m44110b("auto", "_vs", bundle);
        }
        this.f17156d.f32814a = this.f17155c;
        this.f17156d.mo6744h().m44195a(this.f17155c);
    }
}
