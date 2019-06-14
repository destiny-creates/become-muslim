package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.d */
public abstract class C6823d<M extends C6823d<M>> extends C5043j {
    /* renamed from: a */
    protected C5039f f24597a;

    /* renamed from: a */
    protected int mo4756a() {
        if (this.f24597a == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f24597a.m21359a(); i2++) {
            i += this.f24597a.m21362b(i2).m21373a();
        }
        return i;
    }

    /* renamed from: a */
    public void mo4757a(C5035b c5035b) {
        if (this.f24597a != null) {
            for (int i = 0; i < this.f24597a.m21359a(); i++) {
                this.f24597a.m21362b(i).m21374a(c5035b);
            }
        }
    }

    /* renamed from: a */
    protected final boolean m31987a(C5033a c5033a, int i) {
        int i2 = c5033a.m21231i();
        if (!c5033a.m21221b(i)) {
            return false;
        }
        int i3 = i >>> 3;
        C5045l c5045l = new C5045l(i, c5033a.m21218a(i2, c5033a.m21231i() - i2));
        C5040g c5040g = null;
        if (this.f24597a == null) {
            this.f24597a = new C5039f();
        } else {
            c5040g = this.f24597a.m21360a(i3);
        }
        if (c5040g == null) {
            c5040g = new C5040g();
            this.f24597a.m21361a(i3, c5040g);
        }
        c5040g.m21375a(c5045l);
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C5043j mo4758b() {
        return (C6823d) clone();
    }

    public /* synthetic */ Object clone() {
        C6823d c6823d = (C6823d) super.mo4758b();
        C5041h.m21396a(this, c6823d);
        return c6823d;
    }
}
