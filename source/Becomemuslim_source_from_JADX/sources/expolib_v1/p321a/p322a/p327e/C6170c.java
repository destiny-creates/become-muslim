package expolib_v1.p321a.p322a.p327e;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;

/* compiled from: Header */
/* renamed from: expolib_v1.a.a.e.c */
public final class C6170c {
    /* renamed from: a */
    public static final C6251f f19931a = C6251f.m25837a(":");
    /* renamed from: b */
    public static final C6251f f19932b = C6251f.m25837a(":status");
    /* renamed from: c */
    public static final C6251f f19933c = C6251f.m25837a(":method");
    /* renamed from: d */
    public static final C6251f f19934d = C6251f.m25837a(":path");
    /* renamed from: e */
    public static final C6251f f19935e = C6251f.m25837a(":scheme");
    /* renamed from: f */
    public static final C6251f f19936f = C6251f.m25837a(":authority");
    /* renamed from: g */
    public final C6251f f19937g;
    /* renamed from: h */
    public final C6251f f19938h;
    /* renamed from: i */
    final int f19939i;

    public C6170c(String str, String str2) {
        this(C6251f.m25837a(str), C6251f.m25837a(str2));
    }

    public C6170c(C6251f c6251f, String str) {
        this(c6251f, C6251f.m25837a(str));
    }

    public C6170c(C6251f c6251f, C6251f c6251f2) {
        this.f19937g = c6251f;
        this.f19938h = c6251f2;
        this.f19939i = (c6251f.mo5366h() + 32) + c6251f2.mo5366h();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C6170c)) {
            return false;
        }
        C6170c c6170c = (C6170c) obj;
        if (this.f19937g.equals(c6170c.f19937g) && this.f19938h.equals(c6170c.f19938h) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((527 + this.f19937g.hashCode()) * 31) + this.f19938h.hashCode();
    }

    public String toString() {
        return C6165c.m25308a("%s: %s", this.f19937g.mo5355a(), this.f19938h.mo5355a());
    }
}
