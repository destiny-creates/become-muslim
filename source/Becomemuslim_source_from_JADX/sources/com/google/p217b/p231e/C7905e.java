package com.google.p217b.p231e;

import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C5316s;
import com.google.p217b.C6866d;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code39Reader */
/* renamed from: com.google.b.e.e */
public final class C7905e extends C6873r {
    /* renamed from: a */
    static final int[] f29501a = new int[]{52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, TiffUtil.TIFF_TAG_ORIENTATION, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, JfifUtil.MARKER_RST0, 133, 388, 196, 168, 162, 138, 42};
    /* renamed from: b */
    private final boolean f29502b;
    /* renamed from: c */
    private final boolean f29503c;
    /* renamed from: d */
    private final StringBuilder f29504d;
    /* renamed from: e */
    private final int[] f29505e;

    public C7905e() {
        this(false);
    }

    public C7905e(boolean z) {
        this(z, false);
    }

    public C7905e(boolean z, boolean z2) {
        this.f29502b = z;
        this.f29503c = z2;
        this.f29504d = new StringBuilder(true);
        this.f29505e = new int[true];
    }

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        int i2;
        int c;
        int[] iArr = this.f29505e;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f29504d;
        charSequence.setLength(0);
        int[] a = C7905e.m38467a(c5196a, iArr);
        int c2 = c5196a.m21965c(a[1]);
        int a2 = c5196a.m21954a();
        while (true) {
            C6873r.m32295a(c5196a, c2, iArr);
            int a3 = C7905e.m38465a(iArr);
            if (a3 >= 0) {
                char a4 = C7905e.m38464a(a3);
                charSequence.append(a4);
                i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                c = c5196a.m21965c(i2);
                if (a4 == '*') {
                    break;
                }
                c2 = c;
            } else {
                throw C6894l.m32349a();
            }
        }
        charSequence.setLength(charSequence.length() - 1);
        int i4 = 0;
        for (int i22 : iArr) {
            i4 += i22;
        }
        c5196a = (c - c2) - i4;
        if (c != a2) {
            if ((c5196a << 1) < i4) {
                throw C6894l.m32349a();
            }
        }
        if (this.f29502b != null) {
            Map<C5254e, ?> length = charSequence.length() - 1;
            a2 = 0;
            for (map = null; map < length; map++) {
                a2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f29504d.charAt(map));
            }
            if (charSequence.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(a2 % 43)) {
                charSequence.setLength(length);
            } else {
                throw C6866d.m32277a();
            }
        }
        if (charSequence.length() != null) {
            if (this.f29503c != null) {
                c5196a = C7905e.m38466a(charSequence);
            } else {
                c5196a = charSequence.toString();
            }
            float f = ((float) c2) + (((float) i4) / 2.0f);
            r5 = new C5316s[2];
            i = (float) i;
            r5[0] = new C5316s(((float) (a[1] + a[0])) / 1073741824, i);
            r5[1] = new C5316s(f, i);
            return new C5314q(c5196a, null, r5, C5193a.CODE_39);
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int[] m38467a(C5196a c5196a, int[] iArr) {
        int a = c5196a.m21954a();
        int c = c5196a.m21965c(0);
        int length = iArr.length;
        int i = c;
        int i2 = 0;
        int i3 = 0;
        while (c < a) {
            if (c5196a.m21959a(c) != i2) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C7905e.m38465a(iArr) == 148 && c5196a.m21960a(Math.max(0, i - ((c - i) / 2)), i, false)) {
                    return new int[]{i, c};
                } else {
                    i += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                i2 ^= 1;
            }
            c++;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m38465a(int[] iArr) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > r2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            i = 0;
            int i42 = 0;
            for (i2 = 0; i2 < length; i2++) {
                int i6 = iArr[i2];
                if (i6 > i3) {
                    i |= 1 << ((length - 1) - i2);
                    i5++;
                    i42 += i6;
                }
            }
            if (i5 == 3) {
                break;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
        for (int i7 = 0; i7 < length && i5 > 0; i7++) {
            i2 = iArr[i7];
            if (i2 > i3) {
                i5--;
                if ((i2 << 1) >= i42) {
                    return -1;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private static char m38464a(int i) {
        for (int i2 = 0; i2 < f29501a.length; i2++) {
            if (f29501a[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
            }
        }
        if (i == 148) {
            return '*';
        }
        throw C6894l.m32349a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.String m38466a(java.lang.CharSequence r10) {
        /*
        r0 = r10.length();
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r2 = 0;
        r3 = 0;
    L_0x000b:
        if (r3 >= r0) goto L_0x00c3;
    L_0x000d:
        r4 = r10.charAt(r3);
        r5 = 47;
        r6 = 43;
        if (r4 == r6) goto L_0x0027;
    L_0x0017:
        r7 = 36;
        if (r4 == r7) goto L_0x0027;
    L_0x001b:
        r7 = 37;
        if (r4 == r7) goto L_0x0027;
    L_0x001f:
        if (r4 != r5) goto L_0x0022;
    L_0x0021:
        goto L_0x0027;
    L_0x0022:
        r1.append(r4);
        goto L_0x00ba;
    L_0x0027:
        r3 = r3 + 1;
        r7 = r10.charAt(r3);
        r8 = 90;
        r9 = 65;
        if (r4 == r6) goto L_0x00b0;
    L_0x0033:
        r6 = 79;
        if (r4 == r5) goto L_0x009e;
    L_0x0037:
        switch(r4) {
            case 36: goto L_0x0091;
            case 37: goto L_0x003d;
            default: goto L_0x003a;
        };
    L_0x003a:
        r4 = 0;
        goto L_0x00b7;
    L_0x003d:
        if (r7 < r9) goto L_0x0048;
    L_0x003f:
        r4 = 69;
        if (r7 > r4) goto L_0x0048;
    L_0x0043:
        r7 = r7 + -38;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x0048:
        r4 = 70;
        if (r7 < r4) goto L_0x0055;
    L_0x004c:
        r4 = 74;
        if (r7 > r4) goto L_0x0055;
    L_0x0050:
        r7 = r7 + -11;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x0055:
        r4 = 75;
        if (r7 < r4) goto L_0x005f;
    L_0x0059:
        if (r7 > r6) goto L_0x005f;
    L_0x005b:
        r7 = r7 + 16;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x005f:
        r4 = 80;
        if (r7 < r4) goto L_0x006b;
    L_0x0063:
        r4 = 84;
        if (r7 > r4) goto L_0x006b;
    L_0x0067:
        r7 = r7 + 43;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x006b:
        r4 = 85;
        if (r7 != r4) goto L_0x0070;
    L_0x006f:
        goto L_0x003a;
    L_0x0070:
        r4 = 86;
        if (r7 != r4) goto L_0x0077;
    L_0x0074:
        r4 = 64;
        goto L_0x00b7;
    L_0x0077:
        r4 = 87;
        if (r7 != r4) goto L_0x007e;
    L_0x007b:
        r4 = 96;
        goto L_0x00b7;
    L_0x007e:
        r4 = 88;
        if (r7 == r4) goto L_0x008e;
    L_0x0082:
        r4 = 89;
        if (r7 == r4) goto L_0x008e;
    L_0x0086:
        if (r7 != r8) goto L_0x0089;
    L_0x0088:
        goto L_0x008e;
    L_0x0089:
        r10 = com.google.p217b.C6891h.m32342a();
        throw r10;
    L_0x008e:
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x00b7;
    L_0x0091:
        if (r7 < r9) goto L_0x0099;
    L_0x0093:
        if (r7 > r8) goto L_0x0099;
    L_0x0095:
        r7 = r7 + -64;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x0099:
        r10 = com.google.p217b.C6891h.m32342a();
        throw r10;
    L_0x009e:
        if (r7 < r9) goto L_0x00a6;
    L_0x00a0:
        if (r7 > r6) goto L_0x00a6;
    L_0x00a2:
        r7 = r7 + -32;
        r4 = (char) r7;
        goto L_0x00b7;
    L_0x00a6:
        if (r7 != r8) goto L_0x00ab;
    L_0x00a8:
        r4 = 58;
        goto L_0x00b7;
    L_0x00ab:
        r10 = com.google.p217b.C6891h.m32342a();
        throw r10;
    L_0x00b0:
        if (r7 < r9) goto L_0x00be;
    L_0x00b2:
        if (r7 > r8) goto L_0x00be;
    L_0x00b4:
        r7 = r7 + 32;
        r4 = (char) r7;
    L_0x00b7:
        r1.append(r4);
    L_0x00ba:
        r3 = r3 + 1;
        goto L_0x000b;
    L_0x00be:
        r10 = com.google.p217b.C6891h.m32342a();
        throw r10;
    L_0x00c3:
        r10 = r1.toString();
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.e.a(java.lang.CharSequence):java.lang.String");
    }
}
