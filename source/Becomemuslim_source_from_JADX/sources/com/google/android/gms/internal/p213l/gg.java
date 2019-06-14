package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gg */
public final class gg extends C6823d<gg> {
    /* renamed from: c */
    public Long f29024c;
    /* renamed from: d */
    public String f29025d;
    /* renamed from: e */
    public gh[] f29026e;
    /* renamed from: f */
    public gf[] f29027f;
    /* renamed from: g */
    public fz[] f29028g;
    /* renamed from: h */
    private Integer f29029h;

    public gg() {
        this.f29024c = null;
        this.f29025d = null;
        this.f29029h = null;
        this.f29026e = gh.m38137e();
        this.f29027f = gf.m38130e();
        this.f29028g = fz.m38106e();
        this.a = null;
        this.b = -1;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int i;
        int a = super.mo4756a();
        if (this.f29024c != null) {
            a += C5035b.m21291c(1, this.f29024c.longValue());
        }
        if (this.f29025d != null) {
            a += C5035b.m21289b(2, this.f29025d);
        }
        if (this.f29029h != null) {
            a += C5035b.m21287b(3, this.f29029h.intValue());
        }
        if (this.f29026e != null && this.f29026e.length > 0) {
            i = a;
            for (C5043j c5043j : this.f29026e) {
                if (c5043j != null) {
                    i += C5035b.m21288b(4, c5043j);
                }
            }
            a = i;
        }
        if (this.f29027f != null && this.f29027f.length > 0) {
            i = a;
            for (C5043j c5043j2 : this.f29027f) {
                if (c5043j2 != null) {
                    i += C5035b.m21288b(5, c5043j2);
                }
            }
            a = i;
        }
        if (this.f29028g != null && this.f29028g.length > 0) {
            for (C5043j c5043j3 : this.f29028g) {
                if (c5043j3 != null) {
                    a += C5035b.m21288b(6, c5043j3);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f29024c = Long.valueOf(c5033a.m21226e());
            } else if (a == 18) {
                this.f29025d = c5033a.m21223c();
            } else if (a == 24) {
                this.f29029h = Integer.valueOf(c5033a.m21224d());
            } else if (a == 34) {
                a = C5046m.m21448a(c5033a, 34);
                r1 = this.f29026e == null ? 0 : this.f29026e.length;
                r0 = new gh[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f29026e, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new gh();
                    c5033a.m21216a(r0[r1]);
                    c5033a.m21214a();
                    r1++;
                }
                r0[r1] = new gh();
                c5033a.m21216a(r0[r1]);
                this.f29026e = r0;
            } else if (a == 42) {
                a = C5046m.m21448a(c5033a, 42);
                r1 = this.f29027f == null ? 0 : this.f29027f.length;
                r0 = new gf[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f29027f, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new gf();
                    c5033a.m21216a(r0[r1]);
                    c5033a.m21214a();
                    r1++;
                }
                r0[r1] = new gf();
                c5033a.m21216a(r0[r1]);
                this.f29027f = r0;
            } else if (a == 50) {
                a = C5046m.m21448a(c5033a, 50);
                r1 = this.f29028g == null ? 0 : this.f29028g.length;
                r0 = new fz[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f29028g, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new fz();
                    c5033a.m21216a(r0[r1]);
                    c5033a.m21214a();
                    r1++;
                }
                r0[r1] = new fz();
                c5033a.m21216a(r0[r1]);
                this.f29028g = r0;
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29024c != null) {
            c5035b.m21303b(1, this.f29024c.longValue());
        }
        if (this.f29025d != null) {
            c5035b.m21300a(2, this.f29025d);
        }
        if (this.f29029h != null) {
            c5035b.m21297a(3, this.f29029h.intValue());
        }
        if (this.f29026e != null && this.f29026e.length > 0) {
            for (C5043j c5043j : this.f29026e) {
                if (c5043j != null) {
                    c5035b.m21299a(4, c5043j);
                }
            }
        }
        if (this.f29027f != null && this.f29027f.length > 0) {
            for (C5043j c5043j2 : this.f29027f) {
                if (c5043j2 != null) {
                    c5035b.m21299a(5, c5043j2);
                }
            }
        }
        if (this.f29028g != null && this.f29028g.length > 0) {
            for (C5043j c5043j3 : this.f29028g) {
                if (c5043j3 != null) {
                    c5035b.m21299a(6, c5043j3);
                }
            }
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gg)) {
            return false;
        }
        gg ggVar = (gg) obj;
        if (this.f29024c == null) {
            if (ggVar.f29024c != null) {
                return false;
            }
        } else if (!this.f29024c.equals(ggVar.f29024c)) {
            return false;
        }
        if (this.f29025d == null) {
            if (ggVar.f29025d != null) {
                return false;
            }
        } else if (!this.f29025d.equals(ggVar.f29025d)) {
            return false;
        }
        if (this.f29029h == null) {
            if (ggVar.f29029h != null) {
                return false;
            }
        } else if (!this.f29029h.equals(ggVar.f29029h)) {
            return false;
        }
        if (!C5041h.m21398a(this.f29026e, ggVar.f29026e) || !C5041h.m21398a(this.f29027f, ggVar.f29027f) || !C5041h.m21398a(this.f29028g, ggVar.f29028g)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(ggVar.a);
            }
        }
        if (ggVar.a != null) {
            if (!ggVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29024c == null ? 0 : this.f29024c.hashCode())) * 31) + (this.f29025d == null ? 0 : this.f29025d.hashCode())) * 31) + (this.f29029h == null ? 0 : this.f29029h.hashCode())) * 31) + C5041h.m21395a(this.f29026e)) * 31) + C5041h.m21395a(this.f29027f)) * 31) + C5041h.m21395a(this.f29028g)) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
