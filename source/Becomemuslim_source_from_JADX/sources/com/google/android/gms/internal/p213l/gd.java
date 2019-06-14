package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gd */
public final class gd extends C6823d<gd> {
    /* renamed from: f */
    private static volatile gd[] f29011f;
    /* renamed from: c */
    public Integer f29012c;
    /* renamed from: d */
    public String f29013d;
    /* renamed from: e */
    public gb f29014e;

    public gd() {
        this.f29012c = null;
        this.f29013d = null;
        this.f29014e = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gd[] m38122e() {
        if (f29011f == null) {
            synchronized (C5041h.f17265b) {
                if (f29011f == null) {
                    f29011f = new gd[0];
                }
            }
        }
        return f29011f;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29012c != null) {
            a += C5035b.m21287b(1, this.f29012c.intValue());
        }
        if (this.f29013d != null) {
            a += C5035b.m21289b(2, this.f29013d);
        }
        return this.f29014e != null ? a + C5035b.m21288b(3, this.f29014e) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f29012c = Integer.valueOf(c5033a.m21224d());
            } else if (a == 18) {
                this.f29013d = c5033a.m21223c();
            } else if (a == 26) {
                if (this.f29014e == null) {
                    this.f29014e = new gb();
                }
                c5033a.m21216a(this.f29014e);
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29012c != null) {
            c5035b.m21297a(1, this.f29012c.intValue());
        }
        if (this.f29013d != null) {
            c5035b.m21300a(2, this.f29013d);
        }
        if (this.f29014e != null) {
            c5035b.m21299a(3, this.f29014e);
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gd)) {
            return false;
        }
        gd gdVar = (gd) obj;
        if (this.f29012c == null) {
            if (gdVar.f29012c != null) {
                return false;
            }
        } else if (!this.f29012c.equals(gdVar.f29012c)) {
            return false;
        }
        if (this.f29013d == null) {
            if (gdVar.f29013d != null) {
                return false;
            }
        } else if (!this.f29013d.equals(gdVar.f29013d)) {
            return false;
        }
        if (this.f29014e == null) {
            if (gdVar.f29014e != null) {
                return false;
            }
        } else if (!this.f29014e.equals(gdVar.f29014e)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gdVar.a);
            }
        }
        if (gdVar.a != null) {
            if (!gdVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((getClass().getName().hashCode() + 527) * 31) + (this.f29012c == null ? 0 : this.f29012c.hashCode())) * 31) + (this.f29013d == null ? 0 : this.f29013d.hashCode());
        gb gbVar = this.f29014e;
        hashCode = ((hashCode * 31) + (gbVar == null ? 0 : gbVar.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
