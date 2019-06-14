package com.google.p217b.p235f.p236a.p237a;

/* compiled from: ModulusGF */
/* renamed from: com.google.b.f.a.a.b */
public final class C5256b {
    /* renamed from: a */
    public static final C5256b f17734a = new C5256b(929, 3);
    /* renamed from: b */
    private final int[] f17735b;
    /* renamed from: c */
    private final int[] f17736c;
    /* renamed from: d */
    private final C5257c f17737d;
    /* renamed from: e */
    private final C5257c f17738e;
    /* renamed from: f */
    private final int f17739f;

    private C5256b(int i, int i2) {
        this.f17739f = i;
        this.f17735b = new int[i];
        this.f17736c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f17735b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (i2 = 0; i2 < i - 1; i2++) {
            this.f17736c[this.f17735b[i2]] = i2;
        }
        this.f17737d = new C5257c(this, new int[]{null});
        this.f17738e = new C5257c(this, new int[]{1});
    }

    /* renamed from: a */
    C5257c m22249a() {
        return this.f17737d;
    }

    /* renamed from: b */
    C5257c m22253b() {
        return this.f17738e;
    }

    /* renamed from: a */
    C5257c m22250a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f17737d;
        } else {
            i = new int[(i + 1)];
            i[0] = i2;
            return new C5257c(this, i);
        }
    }

    /* renamed from: b */
    int m22252b(int i, int i2) {
        return (i + i2) % this.f17739f;
    }

    /* renamed from: c */
    int m22256c(int i, int i2) {
        return ((this.f17739f + i) - i2) % this.f17739f;
    }

    /* renamed from: a */
    int m22248a(int i) {
        return this.f17735b[i];
    }

    /* renamed from: b */
    int m22251b(int i) {
        if (i != 0) {
            return this.f17736c[i];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    int m22255c(int i) {
        if (i != 0) {
            return this.f17735b[(this.f17739f - this.f17736c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: d */
    int m22257d(int i, int i2) {
        if (i != 0) {
            if (i2 != 0) {
                return this.f17735b[(this.f17736c[i] + this.f17736c[i2]) % (this.f17739f - 1)];
            }
        }
        return 0;
    }

    /* renamed from: c */
    int m22254c() {
        return this.f17739f;
    }
}
