package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gm */
public final class gm extends C6823d<gm> {
    /* renamed from: c */
    public gn[] f29053c;

    public gm() {
        this.f29053c = gn.m38160e();
        this.a = null;
        this.b = -1;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29053c != null && this.f29053c.length > 0) {
            for (C5043j c5043j : this.f29053c) {
                if (c5043j != null) {
                    a += C5035b.m21288b(1, c5043j);
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
            if (a == 10) {
                a = C5046m.m21448a(c5033a, 10);
                int length = this.f29053c == null ? 0 : this.f29053c.length;
                Object obj = new gn[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f29053c, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new gn();
                    c5033a.m21216a(obj[length]);
                    c5033a.m21214a();
                    length++;
                }
                obj[length] = new gn();
                c5033a.m21216a(obj[length]);
                this.f29053c = obj;
            } else if (!super.m31987a(c5033a, a)) {
                return this;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29053c != null && this.f29053c.length > 0) {
            for (C5043j c5043j : this.f29053c) {
                if (c5043j != null) {
                    c5035b.m21299a(1, c5043j);
                }
            }
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gm)) {
            return false;
        }
        gm gmVar = (gm) obj;
        if (!C5041h.m21398a(this.f29053c, gmVar.f29053c)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gmVar.a);
            }
        }
        if (gmVar.a != null) {
            if (!gmVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((getClass().getName().hashCode() + 527) * 31) + C5041h.m21395a(this.f29053c)) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                hashCode = this.a.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }
}
