package com.google.p217b.p240g.p242b;

import com.google.p217b.C5316s;
import com.google.p217b.C5317t;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder */
/* renamed from: com.google.b.g.b.b */
final class C5295b {
    /* renamed from: a */
    private final C5202b f17886a;
    /* renamed from: b */
    private final List<C6888a> f17887b = new ArrayList(5);
    /* renamed from: c */
    private final int f17888c;
    /* renamed from: d */
    private final int f17889d;
    /* renamed from: e */
    private final int f17890e;
    /* renamed from: f */
    private final int f17891f;
    /* renamed from: g */
    private final float f17892g;
    /* renamed from: h */
    private final int[] f17893h;
    /* renamed from: i */
    private final C5317t f17894i;

    C5295b(C5202b c5202b, int i, int i2, int i3, int i4, float f, C5317t c5317t) {
        this.f17886a = c5202b;
        this.f17888c = i;
        this.f17889d = i2;
        this.f17890e = i3;
        this.f17891f = i4;
        this.f17892g = f;
        this.f17893h = new int[3];
        this.f17894i = c5317t;
    }

    /* renamed from: a */
    C6888a m22469a() {
        int i = this.f17888c;
        int i2 = this.f17891f;
        int i3 = this.f17890e + i;
        int i4 = this.f17889d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f17886a.m22002a(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.f17886a.m22002a(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 == 2) {
                    if (m22468a(iArr)) {
                        C6888a a = m22467a(iArr, i6, i7);
                        if (a != null) {
                            return a;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                } else {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                }
                i7++;
            }
            if (m22468a(iArr)) {
                C6888a a2 = m22467a(iArr, i6, i3);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        if (!this.f17887b.isEmpty()) {
            return (C6888a) this.f17887b.get(0);
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static float m22466a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    /* renamed from: a */
    private boolean m22468a(int[] iArr) {
        float f = this.f17892g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: a */
    private float m22465a(int i, int i2, int i3, int i4) {
        C5202b c5202b = this.f17886a;
        int g = c5202b.m22011g();
        int[] iArr = this.f17893h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && c5202b.m22002a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 >= 0) {
            if (iArr[1] <= i3) {
                while (i5 >= 0 && !c5202b.m22002a(i2, i5) && iArr[0] <= i3) {
                    iArr[0] = iArr[0] + 1;
                    i5--;
                }
                if (iArr[0] > i3) {
                    return Float.NaN;
                }
                i++;
                while (i < g && c5202b.m22002a(i2, i) && iArr[1] <= i3) {
                    iArr[1] = iArr[1] + 1;
                    i++;
                }
                if (i != g) {
                    if (iArr[1] <= i3) {
                        while (i < g && !c5202b.m22002a(i2, i) && iArr[2] <= i3) {
                            iArr[2] = iArr[2] + 1;
                            i++;
                        }
                        if (iArr[2] <= i3 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 < i4 * 2 && m22468a(iArr) != 0) {
                            return C5295b.m22466a(iArr, i);
                        }
                        return Float.NaN;
                    }
                }
                return Float.NaN;
            }
        }
        return Float.NaN;
    }

    /* renamed from: a */
    private C6888a m22467a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        i2 = C5295b.m22466a(iArr, i2);
        i = m22465a(i, (int) i2, iArr[1] * 2, i3);
        if (!Float.isNaN(i)) {
            iArr = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (C6888a c6888a : this.f17887b) {
                if (c6888a.m32334a(iArr, i, i2)) {
                    return c6888a.m32335b(i, i2, iArr);
                }
            }
            C5316s c6888a2 = new C6888a(i2, i, iArr);
            this.f17887b.add(c6888a2);
            if (this.f17894i != null) {
                this.f17894i.m22584a(c6888a2);
            }
        }
        return null;
    }
}
