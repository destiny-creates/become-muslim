package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader */
/* renamed from: com.google.b.e.a */
public final class C7901a extends C6873r {
    /* renamed from: a */
    static final char[] f29490a = "0123456789-$:/.+ABCD".toCharArray();
    /* renamed from: b */
    static final int[] f29491b = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    /* renamed from: c */
    private static final char[] f29492c = new char[]{'A', 'B', 'C', 'D'};
    /* renamed from: d */
    private final StringBuilder f29493d = new StringBuilder(20);
    /* renamed from: e */
    private int[] f29494e = new int[80];
    /* renamed from: f */
    private int f29495f = 0;

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        int c;
        Arrays.fill(this.f29494e, 0);
        m38451a(c5196a);
        c5196a = m38449a();
        this.f29493d.setLength(0);
        int i2 = c5196a;
        do {
            c = m38454c(i2);
            if (c != -1) {
                this.f29493d.append((char) c);
                i2 += 8;
                if (this.f29493d.length() > 1 && C7901a.m38452a(f29492c, f29490a[c])) {
                    break;
                }
            } else {
                throw C6894l.m32349a();
            }
        } while (i2 < this.f29495f);
        int i3 = i2 - 1;
        c = this.f29494e[i3];
        int i4 = 0;
        for (int i5 = -8; i5 < -1; i5++) {
            i4 += this.f29494e[i2 + i5];
        }
        if (i2 < this.f29495f) {
            if (c < i4 / 2) {
                throw C6894l.m32349a();
            }
        }
        m38450a((int) c5196a);
        for (i2 = 0; i2 < this.f29493d.length(); i2++) {
            this.f29493d.setCharAt(i2, f29490a[this.f29493d.charAt(i2)]);
        }
        if (C7901a.m38452a(f29492c, this.f29493d.charAt(0))) {
            if (!C7901a.m38452a(f29492c, this.f29493d.charAt(this.f29493d.length() - 1))) {
                throw C6894l.m32349a();
            } else if (this.f29493d.length() > 3) {
                if (map == null || map.containsKey(C5254e.RETURN_CODABAR_START_END) == null) {
                    this.f29493d.deleteCharAt(this.f29493d.length() - 1);
                    this.f29493d.deleteCharAt(0);
                }
                i2 = 0;
                for (map = null; map < c5196a; map++) {
                    i2 += this.f29494e[map];
                }
                map = (float) i2;
                while (c5196a < i3) {
                    i2 += this.f29494e[c5196a];
                    c5196a++;
                }
                c5196a = (float) i2;
                String stringBuilder = this.f29493d.toString();
                r4 = new C5316s[2];
                i = (float) i;
                r4[0] = new C5316s(map, i);
                r4[1] = new C5316s(c5196a, i);
                return new C5314q(stringBuilder, null, r4, C5193a.CODABAR);
            } else {
                throw C6894l.m32349a();
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private void m38450a(int i) {
        int[] iArr = new int[]{0, 0, 0, 0};
        int[] iArr2 = new int[]{0, 0, 0, 0};
        int length = this.f29493d.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5;
            int i6 = f29491b[this.f29493d.charAt(i4)];
            for (i5 = 6; i5 >= 0; i5--) {
                int i7 = (i5 & 1) + ((i6 & 1) << 1);
                iArr[i7] = iArr[i7] + this.f29494e[i3 + i5];
                iArr2[i7] = iArr2[i7] + 1;
                i6 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (i3 = 0; i3 < 2; i3++) {
            fArr2[i3] = 0.0f;
            i5 = i3 + 2;
            fArr2[i5] = ((((float) iArr[i3]) / ((float) iArr2[i3])) + (((float) iArr[i5]) / ((float) iArr2[i5]))) / 2.0f;
            fArr[i3] = fArr2[i5];
            fArr[i5] = ((((float) iArr[i5]) * 2.0f) + 1.5f) / ((float) iArr2[i5]);
        }
        loop3:
        while (true) {
            int i8 = f29491b[this.f29493d.charAt(i2)];
            int i9 = 6;
            while (i9 >= 0) {
                i3 = (i9 & 1) + ((i8 & 1) << 1);
                float f = (float) this.f29494e[i + i9];
                if (f >= fArr2[i3] && f <= fArr[i3]) {
                    i8 >>= 1;
                    i9--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private void m38451a(C5196a c5196a) {
        this.f29495f = 0;
        int d = c5196a.m21967d(0);
        int a = c5196a.m21954a();
        if (d < a) {
            int i = 1;
            int i2 = 0;
            while (d < a) {
                if (c5196a.m21959a(d) != i) {
                    i2++;
                } else {
                    m38453b(i2);
                    i ^= 1;
                    i2 = 1;
                }
                d++;
            }
            m38453b(i2);
            return;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: b */
    private void m38453b(int i) {
        this.f29494e[this.f29495f] = i;
        this.f29495f++;
        if (this.f29495f >= this.f29494e.length) {
            i = new int[(this.f29495f << 1)];
            System.arraycopy(this.f29494e, 0, i, 0, this.f29495f);
            this.f29494e = i;
        }
    }

    /* renamed from: a */
    private int m38449a() {
        int i = 1;
        while (i < this.f29495f) {
            int c = m38454c(i);
            if (c != -1 && C7901a.m38452a(f29492c, f29490a[c])) {
                int i2 = 0;
                for (c = i; c < i + 7; c++) {
                    i2 += this.f29494e[c];
                }
                if (i == 1 || this.f29494e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
            i += 2;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    static boolean m38452a(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return 1;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private int m38454c(int i) {
        int i2 = i + 7;
        if (i2 >= this.f29495f) {
            return -1;
        }
        int i3;
        int[] iArr = this.f29494e;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (i3 = i; i3 < i2; i3 += 2) {
            int i7 = iArr[i3];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 > i6) {
                i6 = i7;
            }
        }
        i5 = (i5 + i6) / 2;
        i6 = 0;
        for (i3 = i + 1; i3 < i2; i3 += 2) {
            i7 = iArr[i3];
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i6) {
                i6 = i7;
            }
        }
        i2 = (i4 + i6) / 2;
        i3 = 128;
        i6 = 0;
        for (i4 = 0; i4 < 7; i4++) {
            i3 >>= 1;
            if (iArr[i + i4] > ((i4 & 1) == 0 ? i5 : i2)) {
                i6 |= i3;
            }
        }
        for (int i8 = 0; i8 < f29491b.length; i8++) {
            if (f29491b[i8] == i6) {
                return i8;
            }
        }
        return -1;
    }
}
