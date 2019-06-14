package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gj */
public final class gj extends C6823d<gj> {
    /* renamed from: e */
    private static volatile gj[] f29038e;
    /* renamed from: c */
    public Integer f29039c;
    /* renamed from: d */
    public Long f29040d;

    public gj() {
        this.f29039c = null;
        this.f29040d = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gj[] m38145e() {
        if (f29038e == null) {
            synchronized (C5041h.f17265b) {
                if (f29038e == null) {
                    f29038e = new gj[0];
                }
            }
        }
        return f29038e;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29039c != null) {
            a += C5035b.m21287b(1, this.f29039c.intValue());
        }
        return this.f29040d != null ? a + C5035b.m21291c(2, this.f29040d.longValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f29039c = Integer.valueOf(c5033a.m21224d());
            } else if (a == 16) {
                this.f29040d = Long.valueOf(c5033a.m21226e());
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29039c != null) {
            c5035b.m21297a(1, this.f29039c.intValue());
        }
        if (this.f29040d != null) {
            c5035b.m21303b(2, this.f29040d.longValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gj)) {
            return false;
        }
        gj gjVar = (gj) obj;
        if (this.f29039c == null) {
            if (gjVar.f29039c != null) {
                return false;
            }
        } else if (!this.f29039c.equals(gjVar.f29039c)) {
            return false;
        }
        if (this.f29040d == null) {
            if (gjVar.f29040d != null) {
                return false;
            }
        } else if (!this.f29040d.equals(gjVar.f29040d)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gjVar.a);
            }
        }
        if (gjVar.a != null) {
            if (!gjVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.f29039c == null ? 0 : this.f29039c.hashCode())) * 31) + (this.f29040d == null ? 0 : this.f29040d.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
