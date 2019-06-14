package com.google.p217b.p225c.p228c;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5281f;

/* compiled from: SymbolInfo */
/* renamed from: com.google.b.c.c.k */
public class C5230k {
    /* renamed from: a */
    static final C5230k[] f17654a;
    /* renamed from: d */
    private static C5230k[] f17655d;
    /* renamed from: b */
    public final int f17656b;
    /* renamed from: c */
    public final int f17657c;
    /* renamed from: e */
    private final boolean f17658e;
    /* renamed from: f */
    private final int f17659f;
    /* renamed from: g */
    private final int f17660g;
    /* renamed from: h */
    private final int f17661h;
    /* renamed from: i */
    private final int f17662i;
    /* renamed from: j */
    private final int f17663j;

    static {
        C5230k[] c5230kArr = new C5230k[]{new C5230k(false, 3, 5, 8, 8, 1), new C5230k(false, 5, 7, 10, 10, 1), new C5230k(true, 5, 7, 16, 6, 1), new C5230k(false, 8, 10, 12, 12, 1), new C5230k(true, 10, 11, 14, 6, 2), new C5230k(false, 12, 12, 14, 14, 1), new C5230k(true, 16, 14, 24, 10, 1), new C5230k(false, 18, 14, 16, 16, 1), new C5230k(false, 22, 18, 18, 18, 1), new C5230k(true, 22, 18, 16, 10, 2), new C5230k(false, 30, 20, 20, 20, 1), new C5230k(true, 32, 24, 16, 14, 2), new C5230k(false, 36, 24, 22, 22, 1), new C5230k(false, 44, 28, 24, 24, 1), new C5230k(true, 49, 28, 22, 14, 2), new C5230k(false, 62, 36, 14, 14, 4), new C5230k(false, 86, 42, 16, 16, 4), new C5230k(false, 114, 48, 18, 18, 4), new C5230k(false, 144, 56, 20, 20, 4), new C5230k(false, 174, 68, 22, 22, 4), new C5230k(false, 204, 84, 24, 24, 4, 102, 42), new C5230k(false, 280, 112, 14, 14, 16, 140, 56), new C5230k(false, 368, 144, 16, 16, 16, 92, 36), new C5230k(false, 456, JfifUtil.MARKER_SOFn, 18, 18, 16, 114, 48), new C5230k(false, 576, 224, 20, 20, 16, 144, 56), new C5230k(false, 696, 272, 22, 22, 16, 174, 68), new C5230k(false, 816, 336, 24, 24, 16, 136, 56), new C5230k(false, 1050, 408, 18, 18, 36, 175, 68), new C5230k(false, 1304, 496, 20, 20, 36, 163, 62), new C6863d()};
        f17654a = c5230kArr;
        f17655d = c5230kArr;
    }

    public C5230k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    C5230k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f17658e = z;
        this.f17659f = i;
        this.f17660g = i2;
        this.f17656b = i3;
        this.f17657c = i4;
        this.f17661h = i5;
        this.f17662i = i6;
        this.f17663j = i7;
    }

    /* renamed from: a */
    public static C5230k m22149a(int i, C5231l c5231l, C5281f c5281f, C5281f c5281f2, boolean z) {
        for (C5230k c5230k : f17655d) {
            if ((c5231l != C5231l.FORCE_SQUARE || !c5230k.f17658e) && ((c5231l != C5231l.FORCE_RECTANGLE || c5230k.f17658e) && ((c5281f == null || (c5230k.m22157d() >= c5281f.m22413a() && c5230k.m22158e() >= c5281f.m22414b())) && ((c5281f2 == null || (c5230k.m22157d() <= c5281f2.m22413a() && c5230k.m22158e() <= c5281f2.m22414b())) && i <= c5230k.f17659f)))) {
                return c5230k;
            }
        }
        if (!z) {
            return 0;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
    }

    /* renamed from: h */
    private int m22150h() {
        int i = this.f17661h;
        if (i != 4) {
            if (i == 16) {
                return 4;
            }
            if (i == 36) {
                return 6;
            }
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    break;
                default:
                    throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return 2;
    }

    /* renamed from: i */
    private int m22151i() {
        int i = this.f17661h;
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        switch (i) {
            case 1:
            case 2:
                return 1;
            default:
                throw new IllegalStateException("Cannot handle this number of data regions");
        }
    }

    /* renamed from: b */
    public final int m22154b() {
        return m22150h() * this.f17656b;
    }

    /* renamed from: c */
    public final int m22156c() {
        return m22151i() * this.f17657c;
    }

    /* renamed from: d */
    public final int m22157d() {
        return m22154b() + (m22150h() << 1);
    }

    /* renamed from: e */
    public final int m22158e() {
        return m22156c() + (m22151i() << 1);
    }

    /* renamed from: a */
    public int mo4867a() {
        return this.f17659f / this.f17662i;
    }

    /* renamed from: f */
    public final int m22159f() {
        return this.f17659f;
    }

    /* renamed from: g */
    public final int m22160g() {
        return this.f17660g;
    }

    /* renamed from: a */
    public int mo4868a(int i) {
        return this.f17662i;
    }

    /* renamed from: b */
    public final int m22155b(int i) {
        return this.f17663j;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f17658e ? "Rectangular Symbol:" : "Square Symbol:");
        stringBuilder.append(" data region ");
        stringBuilder.append(this.f17656b);
        stringBuilder.append('x');
        stringBuilder.append(this.f17657c);
        stringBuilder.append(", symbol size ");
        stringBuilder.append(m22157d());
        stringBuilder.append('x');
        stringBuilder.append(m22158e());
        stringBuilder.append(", symbol data size ");
        stringBuilder.append(m22154b());
        stringBuilder.append('x');
        stringBuilder.append(m22156c());
        stringBuilder.append(", codewords ");
        stringBuilder.append(this.f17659f);
        stringBuilder.append('+');
        stringBuilder.append(this.f17660g);
        return stringBuilder.toString();
    }
}
