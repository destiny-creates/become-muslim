package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gl */
public final class gl extends C6823d<gl> {
    /* renamed from: g */
    private static volatile gl[] f29047g;
    /* renamed from: c */
    public String f29048c;
    /* renamed from: d */
    public String f29049d;
    /* renamed from: e */
    public Long f29050e;
    /* renamed from: f */
    public Double f29051f;
    /* renamed from: h */
    private Float f29052h;

    public gl() {
        this.f29048c = null;
        this.f29049d = null;
        this.f29050e = null;
        this.f29052h = null;
        this.f29051f = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gl[] m38153e() {
        if (f29047g == null) {
            synchronized (C5041h.f17265b) {
                if (f29047g == null) {
                    f29047g = new gl[0];
                }
            }
        }
        return f29047g;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29048c != null) {
            a += C5035b.m21289b(1, this.f29048c);
        }
        if (this.f29049d != null) {
            a += C5035b.m21289b(2, this.f29049d);
        }
        if (this.f29050e != null) {
            a += C5035b.m21291c(3, this.f29050e.longValue());
        }
        if (this.f29052h != null) {
            this.f29052h.floatValue();
            a += C5035b.m21286b(4) + 4;
        }
        if (this.f29051f == null) {
            return a;
        }
        this.f29051f.doubleValue();
        return a + (C5035b.m21286b(5) + 8);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f29048c = c5033a.m21223c();
            } else if (a == 18) {
                this.f29049d = c5033a.m21223c();
            } else if (a == 24) {
                this.f29050e = Long.valueOf(c5033a.m21226e());
            } else if (a == 37) {
                this.f29052h = Float.valueOf(Float.intBitsToFloat(c5033a.m21228f()));
            } else if (a == 41) {
                this.f29051f = Double.valueOf(Double.longBitsToDouble(c5033a.m21229g()));
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29048c != null) {
            c5035b.m21300a(1, this.f29048c);
        }
        if (this.f29049d != null) {
            c5035b.m21300a(2, this.f29049d);
        }
        if (this.f29050e != null) {
            c5035b.m21303b(3, this.f29050e.longValue());
        }
        if (this.f29052h != null) {
            c5035b.m21296a(4, this.f29052h.floatValue());
        }
        if (this.f29051f != null) {
            c5035b.m21295a(5, this.f29051f.doubleValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gl)) {
            return false;
        }
        gl glVar = (gl) obj;
        if (this.f29048c == null) {
            if (glVar.f29048c != null) {
                return false;
            }
        } else if (!this.f29048c.equals(glVar.f29048c)) {
            return false;
        }
        if (this.f29049d == null) {
            if (glVar.f29049d != null) {
                return false;
            }
        } else if (!this.f29049d.equals(glVar.f29049d)) {
            return false;
        }
        if (this.f29050e == null) {
            if (glVar.f29050e != null) {
                return false;
            }
        } else if (!this.f29050e.equals(glVar.f29050e)) {
            return false;
        }
        if (this.f29052h == null) {
            if (glVar.f29052h != null) {
                return false;
            }
        } else if (!this.f29052h.equals(glVar.f29052h)) {
            return false;
        }
        if (this.f29051f == null) {
            if (glVar.f29051f != null) {
                return false;
            }
        } else if (!this.f29051f.equals(glVar.f29051f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(glVar.a);
            }
        }
        if (glVar.a != null) {
            if (!glVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29048c == null ? 0 : this.f29048c.hashCode())) * 31) + (this.f29049d == null ? 0 : this.f29049d.hashCode())) * 31) + (this.f29050e == null ? 0 : this.f29050e.hashCode())) * 31) + (this.f29052h == null ? 0 : this.f29052h.hashCode())) * 31) + (this.f29051f == null ? 0 : this.f29051f.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
