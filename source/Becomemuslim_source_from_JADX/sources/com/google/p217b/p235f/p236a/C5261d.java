package com.google.p217b.p235f.p236a;

/* compiled from: Codeword */
/* renamed from: com.google.b.f.a.d */
final class C5261d {
    /* renamed from: a */
    private final int f17757a;
    /* renamed from: b */
    private final int f17758b;
    /* renamed from: c */
    private final int f17759c;
    /* renamed from: d */
    private final int f17760d;
    /* renamed from: e */
    private int f17761e = -1;

    C5261d(int i, int i2, int i3, int i4) {
        this.f17757a = i;
        this.f17758b = i2;
        this.f17759c = i3;
        this.f17760d = i4;
    }

    /* renamed from: a */
    boolean m22285a() {
        return m22286a(this.f17761e);
    }

    /* renamed from: a */
    boolean m22286a(int i) {
        return i != -1 && this.f17759c == (i % 3) * 3;
    }

    /* renamed from: b */
    void m22287b() {
        this.f17761e = ((this.f17760d / 30) * 3) + (this.f17759c / 3);
    }

    /* renamed from: c */
    int m22289c() {
        return this.f17758b - this.f17757a;
    }

    /* renamed from: d */
    int m22290d() {
        return this.f17757a;
    }

    /* renamed from: e */
    int m22291e() {
        return this.f17758b;
    }

    /* renamed from: f */
    int m22292f() {
        return this.f17759c;
    }

    /* renamed from: g */
    int m22293g() {
        return this.f17760d;
    }

    /* renamed from: h */
    int m22294h() {
        return this.f17761e;
    }

    /* renamed from: b */
    void m22288b(int i) {
        this.f17761e = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f17761e);
        stringBuilder.append("|");
        stringBuilder.append(this.f17760d);
        return stringBuilder.toString();
    }
}
