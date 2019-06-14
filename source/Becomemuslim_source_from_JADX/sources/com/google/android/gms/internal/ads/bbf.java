package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.C2872v;

public final class bbf extends of<bac> {
    /* renamed from: a */
    private final Object f28464a = new Object();
    /* renamed from: b */
    private lb<bac> f28465b;
    /* renamed from: c */
    private boolean f28466c;
    /* renamed from: d */
    private int f28467d;

    public bbf(lb<bac> lbVar) {
        this.f28465b = lbVar;
        this.f28466c = false;
        this.f28467d = 0;
    }

    /* renamed from: f */
    private final void m37256f() {
        synchronized (this.f28464a) {
            C2872v.a(this.f28467d >= 0);
            if (this.f28466c && this.f28467d == 0) {
                jn.m30864a("No reference is left (including root). Cleaning up engine.");
                mo4320a(new bbi(this), new od());
            } else {
                jn.m30864a("There are still references to the engine. Not destroying.");
            }
        }
    }

    /* renamed from: c */
    public final bbb m37257c() {
        bbb bbb = new bbb(this);
        synchronized (this.f28464a) {
            mo4320a(new bbg(this, bbb), new bbh(this, bbb));
            C2872v.a(this.f28467d >= 0);
            this.f28467d++;
        }
        return bbb;
    }

    /* renamed from: d */
    protected final void m37258d() {
        synchronized (this.f28464a) {
            C2872v.a(this.f28467d > 0);
            jn.m30864a("Releasing 1 reference for JS Engine");
            this.f28467d--;
            m37256f();
        }
    }

    /* renamed from: e */
    public final void m37259e() {
        synchronized (this.f28464a) {
            C2872v.a(this.f28467d >= 0);
            jn.m30864a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f28466c = true;
            m37256f();
        }
    }
}
