package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.ga */
public final class ga extends C6823d<ga> {
    /* renamed from: g */
    private static volatile ga[] f28993g;
    /* renamed from: c */
    public Integer f28994c;
    /* renamed from: d */
    public String f28995d;
    /* renamed from: e */
    public gb[] f28996e;
    /* renamed from: f */
    public gc f28997f;
    /* renamed from: h */
    private Boolean f28998h;

    public ga() {
        this.f28994c = null;
        this.f28995d = null;
        this.f28996e = gb.m38114e();
        this.f28998h = null;
        this.f28997f = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static ga[] m38110e() {
        if (f28993g == null) {
            synchronized (C5041h.f17265b) {
                if (f28993g == null) {
                    f28993g = new ga[0];
                }
            }
        }
        return f28993g;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f28994c != null) {
            a += C5035b.m21287b(1, this.f28994c.intValue());
        }
        if (this.f28995d != null) {
            a += C5035b.m21289b(2, this.f28995d);
        }
        if (this.f28996e != null && this.f28996e.length > 0) {
            for (C5043j c5043j : this.f28996e) {
                if (c5043j != null) {
                    a += C5035b.m21288b(3, c5043j);
                }
            }
        }
        if (this.f28998h != null) {
            this.f28998h.booleanValue();
            a += C5035b.m21286b(4) + 1;
        }
        return this.f28997f != null ? a + C5035b.m21288b(5, this.f28997f) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28994c = Integer.valueOf(c5033a.m21224d());
            } else if (a == 18) {
                this.f28995d = c5033a.m21223c();
            } else if (a == 26) {
                a = C5046m.m21448a(c5033a, 26);
                int length = this.f28996e == null ? 0 : this.f28996e.length;
                Object obj = new gb[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28996e, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new gb();
                    c5033a.m21216a(obj[length]);
                    c5033a.m21214a();
                    length++;
                }
                obj[length] = new gb();
                c5033a.m21216a(obj[length]);
                this.f28996e = obj;
            } else if (a == 32) {
                this.f28998h = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 42) {
                if (this.f28997f == null) {
                    this.f28997f = new gc();
                }
                c5033a.m21216a(this.f28997f);
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f28994c != null) {
            c5035b.m21297a(1, this.f28994c.intValue());
        }
        if (this.f28995d != null) {
            c5035b.m21300a(2, this.f28995d);
        }
        if (this.f28996e != null && this.f28996e.length > 0) {
            for (C5043j c5043j : this.f28996e) {
                if (c5043j != null) {
                    c5035b.m21299a(3, c5043j);
                }
            }
        }
        if (this.f28998h != null) {
            c5035b.m21301a(4, this.f28998h.booleanValue());
        }
        if (this.f28997f != null) {
            c5035b.m21299a(5, this.f28997f);
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ga)) {
            return false;
        }
        ga gaVar = (ga) obj;
        if (this.f28994c == null) {
            if (gaVar.f28994c != null) {
                return false;
            }
        } else if (!this.f28994c.equals(gaVar.f28994c)) {
            return false;
        }
        if (this.f28995d == null) {
            if (gaVar.f28995d != null) {
                return false;
            }
        } else if (!this.f28995d.equals(gaVar.f28995d)) {
            return false;
        }
        if (!C5041h.m21398a(this.f28996e, gaVar.f28996e)) {
            return false;
        }
        if (this.f28998h == null) {
            if (gaVar.f28998h != null) {
                return false;
            }
        } else if (!this.f28998h.equals(gaVar.f28998h)) {
            return false;
        }
        if (this.f28997f == null) {
            if (gaVar.f28997f != null) {
                return false;
            }
        } else if (!this.f28997f.equals(gaVar.f28997f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gaVar.a);
            }
        }
        if (gaVar.a != null) {
            if (!gaVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((getClass().getName().hashCode() + 527) * 31) + (this.f28994c == null ? 0 : this.f28994c.hashCode())) * 31) + (this.f28995d == null ? 0 : this.f28995d.hashCode())) * 31) + C5041h.m21395a(this.f28996e)) * 31) + (this.f28998h == null ? 0 : this.f28998h.hashCode());
        gc gcVar = this.f28997f;
        hashCode = ((hashCode * 31) + (gcVar == null ? 0 : gcVar.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
