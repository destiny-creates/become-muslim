package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gb */
public final class gb extends C6823d<gb> {
    /* renamed from: i */
    private static volatile gb[] f28999i;
    /* renamed from: c */
    public ge f29000c;
    /* renamed from: d */
    public gc f29001d;
    /* renamed from: e */
    public Boolean f29002e;
    /* renamed from: f */
    public String f29003f;
    /* renamed from: g */
    public Boolean f29004g;
    /* renamed from: h */
    public Boolean f29005h;

    public gb() {
        this.f29000c = null;
        this.f29001d = null;
        this.f29002e = null;
        this.f29003f = null;
        this.f29004g = null;
        this.f29005h = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gb[] m38114e() {
        if (f28999i == null) {
            synchronized (C5041h.f17265b) {
                if (f28999i == null) {
                    f28999i = new gb[0];
                }
            }
        }
        return f28999i;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29000c != null) {
            a += C5035b.m21288b(1, this.f29000c);
        }
        if (this.f29001d != null) {
            a += C5035b.m21288b(2, this.f29001d);
        }
        if (this.f29002e != null) {
            this.f29002e.booleanValue();
            a += C5035b.m21286b(3) + 1;
        }
        if (this.f29003f != null) {
            a += C5035b.m21289b(4, this.f29003f);
        }
        if (this.f29004g != null) {
            this.f29004g.booleanValue();
            a += C5035b.m21286b(5) + 1;
        }
        if (this.f29005h == null) {
            return a;
        }
        this.f29005h.booleanValue();
        return a + (C5035b.m21286b(6) + 1);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            C5043j c5043j;
            if (a == 10) {
                if (this.f29000c == null) {
                    this.f29000c = new ge();
                }
                c5043j = this.f29000c;
            } else if (a == 18) {
                if (this.f29001d == null) {
                    this.f29001d = new gc();
                }
                c5043j = this.f29001d;
            } else if (a == 24) {
                this.f29002e = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 34) {
                this.f29003f = c5033a.m21223c();
            } else if (a == 40) {
                this.f29004g = Boolean.valueOf(c5033a.m21220b());
            } else if (a == 48) {
                this.f29005h = Boolean.valueOf(c5033a.m21220b());
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
            c5033a.m21216a(c5043j);
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29000c != null) {
            c5035b.m21299a(1, this.f29000c);
        }
        if (this.f29001d != null) {
            c5035b.m21299a(2, this.f29001d);
        }
        if (this.f29002e != null) {
            c5035b.m21301a(3, this.f29002e.booleanValue());
        }
        if (this.f29003f != null) {
            c5035b.m21300a(4, this.f29003f);
        }
        if (this.f29004g != null) {
            c5035b.m21301a(5, this.f29004g.booleanValue());
        }
        if (this.f29005h != null) {
            c5035b.m21301a(6, this.f29005h.booleanValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gb)) {
            return false;
        }
        gb gbVar = (gb) obj;
        if (this.f29000c == null) {
            if (gbVar.f29000c != null) {
                return false;
            }
        } else if (!this.f29000c.equals(gbVar.f29000c)) {
            return false;
        }
        if (this.f29001d == null) {
            if (gbVar.f29001d != null) {
                return false;
            }
        } else if (!this.f29001d.equals(gbVar.f29001d)) {
            return false;
        }
        if (this.f29002e == null) {
            if (gbVar.f29002e != null) {
                return false;
            }
        } else if (!this.f29002e.equals(gbVar.f29002e)) {
            return false;
        }
        if (this.f29003f == null) {
            if (gbVar.f29003f != null) {
                return false;
            }
        } else if (!this.f29003f.equals(gbVar.f29003f)) {
            return false;
        }
        if (this.f29004g == null) {
            if (gbVar.f29004g != null) {
                return false;
            }
        } else if (!this.f29004g.equals(gbVar.f29004g)) {
            return false;
        }
        if (this.f29005h == null) {
            if (gbVar.f29005h != null) {
                return false;
            }
        } else if (!this.f29005h.equals(gbVar.f29005h)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gbVar.a);
            }
        }
        if (gbVar.a != null) {
            if (!gbVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = getClass().getName().hashCode() + 527;
        ge geVar = this.f29000c;
        int i = 0;
        hashCode = (hashCode * 31) + (geVar == null ? 0 : geVar.hashCode());
        gc gcVar = this.f29001d;
        hashCode = ((((((((((hashCode * 31) + (gcVar == null ? 0 : gcVar.hashCode())) * 31) + (this.f29002e == null ? 0 : this.f29002e.hashCode())) * 31) + (this.f29003f == null ? 0 : this.f29003f.hashCode())) * 31) + (this.f29004g == null ? 0 : this.f29004g.hashCode())) * 31) + (this.f29005h == null ? 0 : this.f29005h.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
