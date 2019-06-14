package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gp */
public final class gp extends C6823d<gp> {
    /* renamed from: c */
    private static volatile gp[] f29097c;
    /* renamed from: d */
    private Integer f29098d;
    /* renamed from: e */
    private long[] f29099e;

    public gp() {
        this.f29098d = null;
        this.f29099e = C5046m.f17298b;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gp[] m38167e() {
        if (f29097c == null) {
            synchronized (C5041h.f17265b) {
                if (f29097c == null) {
                    f29097c = new gp[0];
                }
            }
        }
        return f29097c;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29098d != null) {
            a += C5035b.m21287b(1, this.f29098d.intValue());
        }
        if (this.f29099e == null || this.f29099e.length <= 0) {
            return a;
        }
        int i = 0;
        for (long a2 : this.f29099e) {
            i += C5035b.m21280a(a2);
        }
        return (a + i) + (this.f29099e.length * 1);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f29098d = Integer.valueOf(c5033a.m21224d());
            } else if (a == 16) {
                a = C5046m.m21448a(c5033a, 16);
                r1 = this.f29099e == null ? 0 : this.f29099e.length;
                Object obj = new long[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f29099e, 0, obj, 0, r1);
                }
                while (r1 < obj.length - 1) {
                    obj[r1] = c5033a.m21226e();
                    c5033a.m21214a();
                    r1++;
                }
                obj[r1] = c5033a.m21226e();
                this.f29099e = obj;
            } else if (a == 18) {
                a = c5033a.m21222c(c5033a.m21224d());
                r1 = c5033a.m21231i();
                int i = 0;
                while (c5033a.m21230h() > 0) {
                    c5033a.m21226e();
                    i++;
                }
                c5033a.m21227e(r1);
                r1 = this.f29099e == null ? 0 : this.f29099e.length;
                Object obj2 = new long[(i + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f29099e, 0, obj2, 0, r1);
                }
                while (r1 < obj2.length) {
                    obj2[r1] = c5033a.m21226e();
                    r1++;
                }
                this.f29099e = obj2;
                c5033a.m21225d(a);
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29098d != null) {
            c5035b.m21297a(1, this.f29098d.intValue());
        }
        if (this.f29099e != null && this.f29099e.length > 0) {
            for (long b : this.f29099e) {
                c5035b.m21303b(2, b);
            }
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gp)) {
            return false;
        }
        gp gpVar = (gp) obj;
        if (this.f29098d == null) {
            if (gpVar.f29098d != null) {
                return false;
            }
        } else if (!this.f29098d.equals(gpVar.f29098d)) {
            return false;
        }
        if (!C5041h.m21397a(this.f29099e, gpVar.f29099e)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gpVar.a);
            }
        }
        if (gpVar.a != null) {
            if (!gpVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.f29098d == null ? 0 : this.f29098d.hashCode())) * 31) + C5041h.m21394a(this.f29099e)) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
