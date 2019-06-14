package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gh */
public final class gh extends C6823d<gh> {
    /* renamed from: e */
    private static volatile gh[] f29030e;
    /* renamed from: c */
    public String f29031c;
    /* renamed from: d */
    public String f29032d;

    public gh() {
        this.f29031c = null;
        this.f29032d = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: e */
    public static gh[] m38137e() {
        if (f29030e == null) {
            synchronized (C5041h.f17265b) {
                if (f29030e == null) {
                    f29030e = new gh[0];
                }
            }
        }
        return f29030e;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29031c != null) {
            a += C5035b.m21289b(1, this.f29031c);
        }
        return this.f29032d != null ? a + C5035b.m21289b(2, this.f29032d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f29031c = c5033a.m21223c();
            } else if (a == 18) {
                this.f29032d = c5033a.m21223c();
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29031c != null) {
            c5035b.m21300a(1, this.f29031c);
        }
        if (this.f29032d != null) {
            c5035b.m21300a(2, this.f29032d);
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gh)) {
            return false;
        }
        gh ghVar = (gh) obj;
        if (this.f29031c == null) {
            if (ghVar.f29031c != null) {
                return false;
            }
        } else if (!this.f29031c.equals(ghVar.f29031c)) {
            return false;
        }
        if (this.f29032d == null) {
            if (ghVar.f29032d != null) {
                return false;
            }
        } else if (!this.f29032d.equals(ghVar.f29032d)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(ghVar.a);
            }
        }
        if (ghVar.a != null) {
            if (!ghVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.f29031c == null ? 0 : this.f29031c.hashCode())) * 31) + (this.f29032d == null ? 0 : this.f29032d.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
