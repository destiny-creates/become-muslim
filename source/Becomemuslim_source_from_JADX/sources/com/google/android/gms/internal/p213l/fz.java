package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.fz */
public final class fz extends C6823d<fz> {
    /* renamed from: h */
    private static volatile fz[] f28987h;
    /* renamed from: c */
    public Integer f28988c;
    /* renamed from: d */
    public gd[] f28989d;
    /* renamed from: e */
    public ga[] f28990e;
    /* renamed from: f */
    public Boolean f28991f;
    /* renamed from: g */
    public Boolean f28992g;

    public fz() {
        this.f28988c = null;
        this.f28989d = gd.m38122e();
        this.f28990e = ga.m38110e();
        this.f28991f = null;
        this.f28992g = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static fz[] m38106e() {
        if (f28987h == null) {
            synchronized (C5041h.f17265b) {
                if (f28987h == null) {
                    f28987h = new fz[0];
                }
            }
        }
        return f28987h;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f28988c != null) {
            a += C5035b.m21287b(1, this.f28988c.intValue());
        }
        if (this.f28989d != null && this.f28989d.length > 0) {
            int i = a;
            for (C5043j c5043j : this.f28989d) {
                if (c5043j != null) {
                    i += C5035b.m21288b(2, c5043j);
                }
            }
            a = i;
        }
        if (this.f28990e != null && this.f28990e.length > 0) {
            for (C5043j c5043j2 : this.f28990e) {
                if (c5043j2 != null) {
                    a += C5035b.m21288b(3, c5043j2);
                }
            }
        }
        if (this.f28991f != null) {
            this.f28991f.booleanValue();
            a += C5035b.m21286b(4) + 1;
        }
        if (this.f28992g == null) {
            return a;
        }
        this.f28992g.booleanValue();
        return a + (C5035b.m21286b(5) + 1);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28988c = Integer.valueOf(c5033a.m21224d());
            } else if (a == 18) {
                a = C5046m.m21448a(c5033a, 18);
                r1 = this.f28989d == null ? 0 : this.f28989d.length;
                r0 = new gd[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f28989d, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new gd();
                    c5033a.m21216a(r0[r1]);
                    c5033a.m21214a();
                    r1++;
                }
                r0[r1] = new gd();
                c5033a.m21216a(r0[r1]);
                this.f28989d = r0;
            } else if (a == 26) {
                a = C5046m.m21448a(c5033a, 26);
                r1 = this.f28990e == null ? 0 : this.f28990e.length;
                r0 = new ga[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f28990e, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new ga();
                    c5033a.m21216a(r0[r1]);
                    c5033a.m21214a();
                    r1++;
                }
                r0[r1] = new ga();
                c5033a.m21216a(r0[r1]);
                this.f28990e = r0;
            } else if (a == 32) {
                this.f28991f = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 40) {
                this.f28992g = Boolean.valueOf(c5033a.m21220b());
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f28988c != null) {
            c5035b.m21297a(1, this.f28988c.intValue());
        }
        if (this.f28989d != null && this.f28989d.length > 0) {
            for (C5043j c5043j : this.f28989d) {
                if (c5043j != null) {
                    c5035b.m21299a(2, c5043j);
                }
            }
        }
        if (this.f28990e != null && this.f28990e.length > 0) {
            for (C5043j c5043j2 : this.f28990e) {
                if (c5043j2 != null) {
                    c5035b.m21299a(3, c5043j2);
                }
            }
        }
        if (this.f28991f != null) {
            c5035b.m21301a(4, this.f28991f.booleanValue());
        }
        if (this.f28992g != null) {
            c5035b.m21301a(5, this.f28992g.booleanValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fz)) {
            return false;
        }
        fz fzVar = (fz) obj;
        if (this.f28988c == null) {
            if (fzVar.f28988c != null) {
                return false;
            }
        } else if (!this.f28988c.equals(fzVar.f28988c)) {
            return false;
        }
        if (!C5041h.m21398a(this.f28989d, fzVar.f28989d) || !C5041h.m21398a(this.f28990e, fzVar.f28990e)) {
            return false;
        }
        if (this.f28991f == null) {
            if (fzVar.f28991f != null) {
                return false;
            }
        } else if (!this.f28991f.equals(fzVar.f28991f)) {
            return false;
        }
        if (this.f28992g == null) {
            if (fzVar.f28992g != null) {
                return false;
            }
        } else if (!this.f28992g.equals(fzVar.f28992g)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(fzVar.a);
            }
        }
        if (fzVar.a != null) {
            if (!fzVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f28988c == null ? 0 : this.f28988c.hashCode())) * 31) + C5041h.m21395a(this.f28989d)) * 31) + C5041h.m21395a(this.f28990e)) * 31) + (this.f28991f == null ? 0 : this.f28991f.hashCode())) * 31) + (this.f28992g == null ? 0 : this.f28992g.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
