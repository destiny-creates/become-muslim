package com.google.p217b.p222b.p224b;

/* compiled from: GenericGF */
/* renamed from: com.google.b.b.b.a */
public final class C5197a {
    /* renamed from: a */
    public static final C5197a f17516a = new C5197a(4201, 4096, 1);
    /* renamed from: b */
    public static final C5197a f17517b = new C5197a(1033, 1024, 1);
    /* renamed from: c */
    public static final C5197a f17518c = new C5197a(67, 64, 1);
    /* renamed from: d */
    public static final C5197a f17519d = new C5197a(19, 16, 1);
    /* renamed from: e */
    public static final C5197a f17520e = new C5197a(285, 256, 0);
    /* renamed from: f */
    public static final C5197a f17521f;
    /* renamed from: g */
    public static final C5197a f17522g;
    /* renamed from: h */
    public static final C5197a f17523h = f17518c;
    /* renamed from: i */
    private final int[] f17524i;
    /* renamed from: j */
    private final int[] f17525j;
    /* renamed from: k */
    private final C5198b f17526k;
    /* renamed from: l */
    private final C5198b f17527l;
    /* renamed from: m */
    private final int f17528m;
    /* renamed from: n */
    private final int f17529n;
    /* renamed from: o */
    private final int f17530o;

    /* renamed from: b */
    static int m21971b(int i, int i2) {
        return i ^ i2;
    }

    static {
        C5197a c5197a = new C5197a(301, 256, 1);
        f17521f = c5197a;
        f17522g = c5197a;
    }

    public C5197a(int i, int i2, int i3) {
        this.f17529n = i;
        this.f17528m = i2;
        this.f17530o = i3;
        this.f17524i = new int[i2];
        this.f17525j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f17524i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i = 0; i < i2 - 1; i++) {
            this.f17525j[this.f17524i[i]] = i;
        }
        this.f17526k = new C5198b(this, new int[]{null});
        this.f17527l = new C5198b(this, new int[]{1});
    }

    /* renamed from: a */
    C5198b m21973a() {
        return this.f17526k;
    }

    /* renamed from: b */
    C5198b m21976b() {
        return this.f17527l;
    }

    /* renamed from: a */
    C5198b m21974a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f17526k;
        } else {
            i = new int[(i + 1)];
            i[0] = i2;
            return new C5198b(this, i);
        }
    }

    /* renamed from: a */
    int m21972a(int i) {
        return this.f17524i[i];
    }

    /* renamed from: b */
    int m21975b(int i) {
        if (i != 0) {
            return this.f17525j[i];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    int m21978c(int i) {
        if (i != 0) {
            return this.f17524i[(this.f17528m - this.f17525j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: c */
    int m21979c(int i, int i2) {
        if (i != 0) {
            if (i2 != 0) {
                return this.f17524i[(this.f17525j[i] + this.f17525j[i2]) % (this.f17528m - 1)];
            }
        }
        return 0;
    }

    /* renamed from: c */
    public int m21977c() {
        return this.f17528m;
    }

    /* renamed from: d */
    public int m21980d() {
        return this.f17530o;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GF(0x");
        stringBuilder.append(Integer.toHexString(this.f17529n));
        stringBuilder.append(',');
        stringBuilder.append(this.f17528m);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
