package com.google.p217b.p235f.p236a;

import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;

/* compiled from: BoundingBox */
/* renamed from: com.google.b.f.a.c */
final class C5260c {
    /* renamed from: a */
    private final C5202b f17748a;
    /* renamed from: b */
    private final C5316s f17749b;
    /* renamed from: c */
    private final C5316s f17750c;
    /* renamed from: d */
    private final C5316s f17751d;
    /* renamed from: e */
    private final C5316s f17752e;
    /* renamed from: f */
    private final int f17753f;
    /* renamed from: g */
    private final int f17754g;
    /* renamed from: h */
    private final int f17755h;
    /* renamed from: i */
    private final int f17756i;

    C5260c(C5202b c5202b, C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4) {
        Object obj;
        Object obj2 = null;
        if (c5316s != null) {
            if (c5316s2 != null) {
                obj = null;
                if (c5316s3 == null || c5316s4 == null) {
                    obj2 = 1;
                }
                if (obj != null) {
                    if (obj2 == null) {
                        throw C6894l.m32349a();
                    }
                }
                if (obj != null) {
                    c5316s = new C5316s(0.0f, c5316s3.m22583b());
                    c5316s2 = new C5316s(0.0f, c5316s4.m22583b());
                } else if (obj2 != null) {
                    c5316s3 = new C5316s((float) (c5202b.m22010f() - 1), c5316s.m22583b());
                    c5316s4 = new C5316s((float) (c5202b.m22010f() - 1), c5316s2.m22583b());
                }
                this.f17748a = c5202b;
                this.f17749b = c5316s;
                this.f17750c = c5316s2;
                this.f17751d = c5316s3;
                this.f17752e = c5316s4;
                this.f17753f = (int) Math.min(c5316s.m22582a(), c5316s2.m22582a());
                this.f17754g = (int) Math.max(c5316s3.m22582a(), c5316s4.m22582a());
                this.f17755h = (int) Math.min(c5316s.m22583b(), c5316s3.m22583b());
                this.f17756i = (int) Math.max(c5316s2.m22583b(), c5316s4.m22583b());
            }
        }
        obj = 1;
        obj2 = 1;
        if (obj != null) {
            if (obj2 == null) {
                throw C6894l.m32349a();
            }
        }
        if (obj != null) {
            c5316s = new C5316s(0.0f, c5316s3.m22583b());
            c5316s2 = new C5316s(0.0f, c5316s4.m22583b());
        } else if (obj2 != null) {
            c5316s3 = new C5316s((float) (c5202b.m22010f() - 1), c5316s.m22583b());
            c5316s4 = new C5316s((float) (c5202b.m22010f() - 1), c5316s2.m22583b());
        }
        this.f17748a = c5202b;
        this.f17749b = c5316s;
        this.f17750c = c5316s2;
        this.f17751d = c5316s3;
        this.f17752e = c5316s4;
        this.f17753f = (int) Math.min(c5316s.m22582a(), c5316s2.m22582a());
        this.f17754g = (int) Math.max(c5316s3.m22582a(), c5316s4.m22582a());
        this.f17755h = (int) Math.min(c5316s.m22583b(), c5316s3.m22583b());
        this.f17756i = (int) Math.max(c5316s2.m22583b(), c5316s4.m22583b());
    }

    C5260c(C5260c c5260c) {
        this.f17748a = c5260c.f17748a;
        this.f17749b = c5260c.m22281e();
        this.f17750c = c5260c.m22283g();
        this.f17751d = c5260c.m22282f();
        this.f17752e = c5260c.m22284h();
        this.f17753f = c5260c.m22276a();
        this.f17754g = c5260c.m22278b();
        this.f17755h = c5260c.m22279c();
        this.f17756i = c5260c.m22280d();
    }

    /* renamed from: a */
    static C5260c m22275a(C5260c c5260c, C5260c c5260c2) {
        if (c5260c == null) {
            return c5260c2;
        }
        return c5260c2 == null ? c5260c : new C5260c(c5260c.f17748a, c5260c.f17749b, c5260c.f17750c, c5260c2.f17751d, c5260c2.f17752e);
    }

    /* renamed from: a */
    C5260c m22277a(int i, int i2, boolean z) {
        C5316s c5316s;
        C5316s c5316s2;
        int b;
        C5316s c5316s3;
        C5316s c5316s4;
        C5316s c5316s5 = this.f17749b;
        C5316s c5316s6 = this.f17750c;
        C5316s c5316s7 = this.f17751d;
        C5316s c5316s8 = this.f17752e;
        if (i > 0) {
            C5316s c5316s9 = z ? this.f17749b : this.f17751d;
            int b2 = ((int) c5316s9.m22583b()) - i;
            if (b2 < 0) {
                b2 = 0;
            }
            i = new C5316s(c5316s9.m22582a(), (float) b2);
            if (z) {
                c5316s = i;
            } else {
                c5316s2 = i;
                c5316s = c5316s5;
                if (i2 <= 0) {
                    i = z ? this.f17750c : this.f17752e;
                    b = ((int) i.m22583b()) + i2;
                    if (b >= this.f17748a.m22011g()) {
                        b = this.f17748a.m22011g() - 1;
                    }
                    i2 = new C5316s(i.m22582a(), (float) b);
                    if (z) {
                        c5316s3 = i2;
                        c5316s4 = c5316s6;
                        return new C5260c(this.f17748a, c5316s, c5316s4, c5316s2, c5316s3);
                    }
                    c5316s4 = i2;
                } else {
                    c5316s4 = c5316s6;
                }
                c5316s3 = c5316s8;
                return new C5260c(this.f17748a, c5316s, c5316s4, c5316s2, c5316s3);
            }
        }
        c5316s = c5316s5;
        c5316s2 = c5316s7;
        if (i2 <= 0) {
            c5316s4 = c5316s6;
        } else {
            if (z) {
            }
            b = ((int) i.m22583b()) + i2;
            if (b >= this.f17748a.m22011g()) {
                b = this.f17748a.m22011g() - 1;
            }
            i2 = new C5316s(i.m22582a(), (float) b);
            if (z) {
                c5316s3 = i2;
                c5316s4 = c5316s6;
                return new C5260c(this.f17748a, c5316s, c5316s4, c5316s2, c5316s3);
            }
            c5316s4 = i2;
        }
        c5316s3 = c5316s8;
        return new C5260c(this.f17748a, c5316s, c5316s4, c5316s2, c5316s3);
    }

    /* renamed from: a */
    int m22276a() {
        return this.f17753f;
    }

    /* renamed from: b */
    int m22278b() {
        return this.f17754g;
    }

    /* renamed from: c */
    int m22279c() {
        return this.f17755h;
    }

    /* renamed from: d */
    int m22280d() {
        return this.f17756i;
    }

    /* renamed from: e */
    C5316s m22281e() {
        return this.f17749b;
    }

    /* renamed from: f */
    C5316s m22282f() {
        return this.f17751d;
    }

    /* renamed from: g */
    C5316s m22283g() {
        return this.f17750c;
    }

    /* renamed from: h */
    C5316s m22284h() {
        return this.f17752e;
    }
}
