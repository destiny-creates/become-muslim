package com.google.p217b.p222b;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5210b;
import com.google.p217b.C5310i;
import com.google.p217b.C6894l;

/* compiled from: GlobalHistogramBinarizer */
/* renamed from: com.google.b.b.h */
public class C6857h extends C5210b {
    /* renamed from: a */
    private static final byte[] f24677a = new byte[0];
    /* renamed from: b */
    private byte[] f24678b = f24677a;
    /* renamed from: c */
    private final int[] f24679c = new int[32];

    public C6857h(C5310i c5310i) {
        super(c5310i);
    }

    /* renamed from: a */
    public C5196a mo4863a(int i, C5196a c5196a) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int a;
        int i5;
        C5310i a2 = m22048a();
        int b = a2.m22566b();
        if (c5196a != null) {
            if (c5196a.m21954a() >= b) {
                c5196a.m21966c();
                m32245a(b);
                i = a2.mo4873a(i, this.f24678b);
                iArr = this.f24679c;
                i2 = 0;
                for (i3 = 0; i3 < b; i3++) {
                    i4 = (i[i3] & JfifUtil.MARKER_FIRST_BYTE) >> 3;
                    iArr[i4] = iArr[i4] + 1;
                }
                a = C6857h.m32244a(iArr);
                if (b >= 3) {
                    while (i2 < b) {
                        if ((i[i2] & JfifUtil.MARKER_FIRST_BYTE) < a) {
                            c5196a.m21962b(i2);
                        }
                        i2++;
                    }
                } else {
                    i3 = i[1] & JfifUtil.MARKER_FIRST_BYTE;
                    i4 = i[0] & JfifUtil.MARKER_FIRST_BYTE;
                    i2 = 1;
                    while (i2 < b - 1) {
                        int i6 = i2 + 1;
                        i5 = i[i6] & JfifUtil.MARKER_FIRST_BYTE;
                        if ((((i3 << 2) - i4) - i5) / 2 < a) {
                            c5196a.m21962b(i2);
                        }
                        i4 = i3;
                        i2 = i6;
                        i3 = i5;
                    }
                }
                return c5196a;
            }
        }
        c5196a = new C5196a(b);
        m32245a(b);
        i = a2.mo4873a(i, this.f24678b);
        iArr = this.f24679c;
        i2 = 0;
        for (i3 = 0; i3 < b; i3++) {
            i4 = (i[i3] & JfifUtil.MARKER_FIRST_BYTE) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        a = C6857h.m32244a(iArr);
        if (b >= 3) {
            i3 = i[1] & JfifUtil.MARKER_FIRST_BYTE;
            i4 = i[0] & JfifUtil.MARKER_FIRST_BYTE;
            i2 = 1;
            while (i2 < b - 1) {
                int i62 = i2 + 1;
                i5 = i[i62] & JfifUtil.MARKER_FIRST_BYTE;
                if ((((i3 << 2) - i4) - i5) / 2 < a) {
                    c5196a.m21962b(i2);
                }
                i4 = i3;
                i2 = i62;
                i3 = i5;
            }
        } else {
            while (i2 < b) {
                if ((i[i2] & JfifUtil.MARKER_FIRST_BYTE) < a) {
                    c5196a.m21962b(i2);
                }
                i2++;
            }
        }
        return c5196a;
    }

    /* renamed from: b */
    public C5202b mo4865b() {
        int i;
        C5310i a = m22048a();
        int b = a.m22566b();
        int c = a.m22567c();
        C5202b c5202b = new C5202b(b, c);
        m32245a(b);
        int[] iArr = this.f24679c;
        for (i = 1; i < 5; i++) {
            int i2;
            byte[] a2 = a.mo4873a((c * i) / 5, this.f24678b);
            int i3 = (b << 2) / 5;
            for (i2 = b / 5; i2 < i3; i2++) {
                int i4 = (a2[i2] & JfifUtil.MARKER_FIRST_BYTE) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = C6857h.m32244a(iArr);
        byte[] a4 = a.mo4872a();
        for (i = 0; i < c; i++) {
            i2 = i * b;
            for (int i5 = 0; i5 < b; i5++) {
                if ((a4[i2 + i5] & JfifUtil.MARKER_FIRST_BYTE) < a3) {
                    c5202b.m22004b(i5, i);
                }
            }
        }
        return c5202b;
    }

    /* renamed from: a */
    public C5210b mo4864a(C5310i c5310i) {
        return new C6857h(c5310i);
    }

    /* renamed from: a */
    private void m32245a(int i) {
        if (this.f24678b.length < i) {
            this.f24678b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f24679c[i2] = 0;
        }
    }

    /* renamed from: a */
    private static int m32244a(int[] iArr) {
        int i;
        int i2;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i3) {
                i3 = iArr[i];
                i5 = i;
            }
            if (iArr[i] > i4) {
                i4 = iArr[i];
            }
        }
        i = 0;
        i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            int i6 = i2 - i5;
            int i7 = (iArr[i2] * i6) * i6;
            if (i7 > i) {
                i3 = i2;
                i = i7;
            }
        }
        if (i5 > i3) {
            int i8 = i5;
            i5 = i3;
            i3 = i8;
        }
        if (i3 - i5 > length / 16) {
            length = i3 - 1;
            i2 = -1;
            i = length;
            while (length > i5) {
                i6 = length - i5;
                i6 = ((i6 * i6) * (i3 - length)) * (i4 - iArr[length]);
                if (i6 > i2) {
                    i = length;
                    i2 = i6;
                }
                length--;
            }
            return i << 3;
        }
        throw C6894l.m32349a();
    }
}
