package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gi */
public final class gi extends C6823d<gi> {
    /* renamed from: g */
    private static volatile gi[] f29033g;
    /* renamed from: c */
    public Integer f29034c;
    /* renamed from: d */
    public go f29035d;
    /* renamed from: e */
    public go f29036e;
    /* renamed from: f */
    public Boolean f29037f;

    public gi() {
        this.f29034c = null;
        this.f29035d = null;
        this.f29036e = null;
        this.f29037f = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gi[] m38141e() {
        if (f29033g == null) {
            synchronized (C5041h.f17265b) {
                if (f29033g == null) {
                    f29033g = new gi[0];
                }
            }
        }
        return f29033g;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29034c != null) {
            a += C5035b.m21287b(1, this.f29034c.intValue());
        }
        if (this.f29035d != null) {
            a += C5035b.m21288b(2, this.f29035d);
        }
        if (this.f29036e != null) {
            a += C5035b.m21288b(3, this.f29036e);
        }
        if (this.f29037f == null) {
            return a;
        }
        this.f29037f.booleanValue();
        return a + (C5035b.m21286b(4) + 1);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a != 8) {
                C5043j c5043j;
                if (a == 18) {
                    if (this.f29035d == null) {
                        this.f29035d = new go();
                    }
                    c5043j = this.f29035d;
                } else if (a == 26) {
                    if (this.f29036e == null) {
                        this.f29036e = new go();
                    }
                    c5043j = this.f29036e;
                } else if (a == 32) {
                    this.f29037f = Boolean.valueOf(c5033a.m21220b());
                } else if (!super.m31987a(c5033a, a)) {
                    return this;
                }
                c5033a.m21216a(c5043j);
            } else {
                this.f29034c = Integer.valueOf(c5033a.m21224d());
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29034c != null) {
            c5035b.m21297a(1, this.f29034c.intValue());
        }
        if (this.f29035d != null) {
            c5035b.m21299a(2, this.f29035d);
        }
        if (this.f29036e != null) {
            c5035b.m21299a(3, this.f29036e);
        }
        if (this.f29037f != null) {
            c5035b.m21301a(4, this.f29037f.booleanValue());
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gi)) {
            return false;
        }
        gi giVar = (gi) obj;
        if (this.f29034c == null) {
            if (giVar.f29034c != null) {
                return false;
            }
        } else if (!this.f29034c.equals(giVar.f29034c)) {
            return false;
        }
        if (this.f29035d == null) {
            if (giVar.f29035d != null) {
                return false;
            }
        } else if (!this.f29035d.equals(giVar.f29035d)) {
            return false;
        }
        if (this.f29036e == null) {
            if (giVar.f29036e != null) {
                return false;
            }
        } else if (!this.f29036e.equals(giVar.f29036e)) {
            return false;
        }
        if (this.f29037f == null) {
            if (giVar.f29037f != null) {
                return false;
            }
        } else if (!this.f29037f.equals(giVar.f29037f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(giVar.a);
            }
        }
        if (giVar.a != null) {
            if (!giVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.f29034c == null ? 0 : this.f29034c.hashCode());
        go goVar = this.f29035d;
        hashCode = (hashCode * 31) + (goVar == null ? 0 : goVar.hashCode());
        goVar = this.f29036e;
        hashCode = ((((hashCode * 31) + (goVar == null ? 0 : goVar.hashCode())) * 31) + (this.f29037f == null ? 0 : this.f29037f.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
