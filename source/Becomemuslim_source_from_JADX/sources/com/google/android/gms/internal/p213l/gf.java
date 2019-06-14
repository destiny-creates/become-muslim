package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gf */
public final class gf extends C6823d<gf> {
    /* renamed from: g */
    private static volatile gf[] f29019g;
    /* renamed from: c */
    public String f29020c;
    /* renamed from: d */
    public Boolean f29021d;
    /* renamed from: e */
    public Boolean f29022e;
    /* renamed from: f */
    public Integer f29023f;

    public gf() {
        this.f29020c = null;
        this.f29021d = null;
        this.f29022e = null;
        this.f29023f = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gf[] m38130e() {
        if (f29019g == null) {
            synchronized (C5041h.f17265b) {
                if (f29019g == null) {
                    f29019g = new gf[0];
                }
            }
        }
        return f29019g;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29020c != null) {
            a += C5035b.m21289b(1, this.f29020c);
        }
        if (this.f29021d != null) {
            this.f29021d.booleanValue();
            a += C5035b.m21286b(2) + 1;
        }
        if (this.f29022e != null) {
            this.f29022e.booleanValue();
            a += C5035b.m21286b(3) + 1;
        }
        return this.f29023f != null ? a + C5035b.m21287b(4, this.f29023f.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f29020c = c5033a.m21223c();
            } else if (a == 16) {
                this.f29021d = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 24) {
                this.f29022e = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 32) {
                this.f29023f = Integer.valueOf(c5033a.m21224d());
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29020c != null) {
            c5035b.m21300a(1, this.f29020c);
        }
        if (this.f29021d != null) {
            c5035b.m21301a(2, this.f29021d.booleanValue());
        }
        if (this.f29022e != null) {
            c5035b.m21301a(3, this.f29022e.booleanValue());
        }
        if (this.f29023f != null) {
            c5035b.m21297a(4, this.f29023f.intValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gf)) {
            return false;
        }
        gf gfVar = (gf) obj;
        if (this.f29020c == null) {
            if (gfVar.f29020c != null) {
                return false;
            }
        } else if (!this.f29020c.equals(gfVar.f29020c)) {
            return false;
        }
        if (this.f29021d == null) {
            if (gfVar.f29021d != null) {
                return false;
            }
        } else if (!this.f29021d.equals(gfVar.f29021d)) {
            return false;
        }
        if (this.f29022e == null) {
            if (gfVar.f29022e != null) {
                return false;
            }
        } else if (!this.f29022e.equals(gfVar.f29022e)) {
            return false;
        }
        if (this.f29023f == null) {
            if (gfVar.f29023f != null) {
                return false;
            }
        } else if (!this.f29023f.equals(gfVar.f29023f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gfVar.a);
            }
        }
        if (gfVar.a != null) {
            if (!gfVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29020c == null ? 0 : this.f29020c.hashCode())) * 31) + (this.f29021d == null ? 0 : this.f29021d.hashCode())) * 31) + (this.f29022e == null ? 0 : this.f29022e.hashCode())) * 31) + (this.f29023f == null ? 0 : this.f29023f.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
