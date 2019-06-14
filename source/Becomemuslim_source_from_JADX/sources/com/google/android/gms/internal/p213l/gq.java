package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gq */
public final class gq extends C6823d<gq> {
    /* renamed from: h */
    private static volatile gq[] f29100h;
    /* renamed from: c */
    public Long f29101c;
    /* renamed from: d */
    public String f29102d;
    /* renamed from: e */
    public String f29103e;
    /* renamed from: f */
    public Long f29104f;
    /* renamed from: g */
    public Double f29105g;
    /* renamed from: i */
    private Float f29106i;

    public gq() {
        this.f29101c = null;
        this.f29102d = null;
        this.f29103e = null;
        this.f29104f = null;
        this.f29106i = null;
        this.f29105g = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gq[] m38171e() {
        if (f29100h == null) {
            synchronized (C5041h.f17265b) {
                if (f29100h == null) {
                    f29100h = new gq[0];
                }
            }
        }
        return f29100h;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29101c != null) {
            a += C5035b.m21291c(1, this.f29101c.longValue());
        }
        if (this.f29102d != null) {
            a += C5035b.m21289b(2, this.f29102d);
        }
        if (this.f29103e != null) {
            a += C5035b.m21289b(3, this.f29103e);
        }
        if (this.f29104f != null) {
            a += C5035b.m21291c(4, this.f29104f.longValue());
        }
        if (this.f29106i != null) {
            this.f29106i.floatValue();
            a += C5035b.m21286b(5) + 4;
        }
        if (this.f29105g == null) {
            return a;
        }
        this.f29105g.doubleValue();
        return a + (C5035b.m21286b(6) + 8);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f29101c = Long.valueOf(c5033a.m21226e());
            } else if (a == 18) {
                this.f29102d = c5033a.m21223c();
            } else if (a == 26) {
                this.f29103e = c5033a.m21223c();
            } else if (a == 32) {
                this.f29104f = Long.valueOf(c5033a.m21226e());
            } else if (a == 45) {
                this.f29106i = Float.valueOf(Float.intBitsToFloat(c5033a.m21228f()));
            } else if (a == 49) {
                this.f29105g = Double.valueOf(Double.longBitsToDouble(c5033a.m21229g()));
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29101c != null) {
            c5035b.m21303b(1, this.f29101c.longValue());
        }
        if (this.f29102d != null) {
            c5035b.m21300a(2, this.f29102d);
        }
        if (this.f29103e != null) {
            c5035b.m21300a(3, this.f29103e);
        }
        if (this.f29104f != null) {
            c5035b.m21303b(4, this.f29104f.longValue());
        }
        if (this.f29106i != null) {
            c5035b.m21296a(5, this.f29106i.floatValue());
        }
        if (this.f29105g != null) {
            c5035b.m21295a(6, this.f29105g.doubleValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gq)) {
            return false;
        }
        gq gqVar = (gq) obj;
        if (this.f29101c == null) {
            if (gqVar.f29101c != null) {
                return false;
            }
        } else if (!this.f29101c.equals(gqVar.f29101c)) {
            return false;
        }
        if (this.f29102d == null) {
            if (gqVar.f29102d != null) {
                return false;
            }
        } else if (!this.f29102d.equals(gqVar.f29102d)) {
            return false;
        }
        if (this.f29103e == null) {
            if (gqVar.f29103e != null) {
                return false;
            }
        } else if (!this.f29103e.equals(gqVar.f29103e)) {
            return false;
        }
        if (this.f29104f == null) {
            if (gqVar.f29104f != null) {
                return false;
            }
        } else if (!this.f29104f.equals(gqVar.f29104f)) {
            return false;
        }
        if (this.f29106i == null) {
            if (gqVar.f29106i != null) {
                return false;
            }
        } else if (!this.f29106i.equals(gqVar.f29106i)) {
            return false;
        }
        if (this.f29105g == null) {
            if (gqVar.f29105g != null) {
                return false;
            }
        } else if (!this.f29105g.equals(gqVar.f29105g)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gqVar.a);
            }
        }
        if (gqVar.a != null) {
            if (!gqVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29101c == null ? 0 : this.f29101c.hashCode())) * 31) + (this.f29102d == null ? 0 : this.f29102d.hashCode())) * 31) + (this.f29103e == null ? 0 : this.f29103e.hashCode())) * 31) + (this.f29104f == null ? 0 : this.f29104f.hashCode())) * 31) + (this.f29106i == null ? 0 : this.f29106i.hashCode())) * 31) + (this.f29105g == null ? 0 : this.f29105g.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
