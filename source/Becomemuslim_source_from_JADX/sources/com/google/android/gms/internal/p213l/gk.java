package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gk */
public final class gk extends C6823d<gk> {
    /* renamed from: h */
    private static volatile gk[] f29041h;
    /* renamed from: c */
    public gl[] f29042c;
    /* renamed from: d */
    public String f29043d;
    /* renamed from: e */
    public Long f29044e;
    /* renamed from: f */
    public Long f29045f;
    /* renamed from: g */
    public Integer f29046g;

    public gk() {
        this.f29042c = gl.m38153e();
        this.f29043d = null;
        this.f29044e = null;
        this.f29045f = null;
        this.f29046g = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gk[] m38149e() {
        if (f29041h == null) {
            synchronized (C5041h.f17265b) {
                if (f29041h == null) {
                    f29041h = new gk[0];
                }
            }
        }
        return f29041h;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29042c != null && this.f29042c.length > 0) {
            for (C5043j c5043j : this.f29042c) {
                if (c5043j != null) {
                    a += C5035b.m21288b(1, c5043j);
                }
            }
        }
        if (this.f29043d != null) {
            a += C5035b.m21289b(2, this.f29043d);
        }
        if (this.f29044e != null) {
            a += C5035b.m21291c(3, this.f29044e.longValue());
        }
        if (this.f29045f != null) {
            a += C5035b.m21291c(4, this.f29045f.longValue());
        }
        return this.f29046g != null ? a + C5035b.m21287b(5, this.f29046g.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                a = C5046m.m21448a(c5033a, 10);
                int length = this.f29042c == null ? 0 : this.f29042c.length;
                Object obj = new gl[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f29042c, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new gl();
                    c5033a.m21216a(obj[length]);
                    c5033a.m21214a();
                    length++;
                }
                obj[length] = new gl();
                c5033a.m21216a(obj[length]);
                this.f29042c = obj;
            } else if (a == 18) {
                this.f29043d = c5033a.m21223c();
            } else if (a == 24) {
                this.f29044e = Long.valueOf(c5033a.m21226e());
            } else if (a == 32) {
                this.f29045f = Long.valueOf(c5033a.m21226e());
            } else if (a == 40) {
                this.f29046g = Integer.valueOf(c5033a.m21224d());
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29042c != null && this.f29042c.length > 0) {
            for (C5043j c5043j : this.f29042c) {
                if (c5043j != null) {
                    c5035b.m21299a(1, c5043j);
                }
            }
        }
        if (this.f29043d != null) {
            c5035b.m21300a(2, this.f29043d);
        }
        if (this.f29044e != null) {
            c5035b.m21303b(3, this.f29044e.longValue());
        }
        if (this.f29045f != null) {
            c5035b.m21303b(4, this.f29045f.longValue());
        }
        if (this.f29046g != null) {
            c5035b.m21297a(5, this.f29046g.intValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gk)) {
            return false;
        }
        gk gkVar = (gk) obj;
        if (!C5041h.m21398a(this.f29042c, gkVar.f29042c)) {
            return false;
        }
        if (this.f29043d == null) {
            if (gkVar.f29043d != null) {
                return false;
            }
        } else if (!this.f29043d.equals(gkVar.f29043d)) {
            return false;
        }
        if (this.f29044e == null) {
            if (gkVar.f29044e != null) {
                return false;
            }
        } else if (!this.f29044e.equals(gkVar.f29044e)) {
            return false;
        }
        if (this.f29045f == null) {
            if (gkVar.f29045f != null) {
                return false;
            }
        } else if (!this.f29045f.equals(gkVar.f29045f)) {
            return false;
        }
        if (this.f29046g == null) {
            if (gkVar.f29046g != null) {
                return false;
            }
        } else if (!this.f29046g.equals(gkVar.f29046g)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gkVar.a);
            }
        }
        if (gkVar.a != null) {
            if (!gkVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + C5041h.m21395a(this.f29042c)) * 31) + (this.f29043d == null ? 0 : this.f29043d.hashCode())) * 31) + (this.f29044e == null ? 0 : this.f29044e.hashCode())) * 31) + (this.f29045f == null ? 0 : this.f29045f.hashCode())) * 31) + (this.f29046g == null ? 0 : this.f29046g.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
