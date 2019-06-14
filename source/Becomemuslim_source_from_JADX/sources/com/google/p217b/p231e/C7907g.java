package com.google.p217b.p231e;

import com.facebook.imageutils.TiffUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C5316s;
import com.google.p217b.C6866d;
import com.google.p217b.C6891h;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader */
/* renamed from: com.google.b.e.g */
public final class C7907g extends C6873r {
    /* renamed from: a */
    static final int[] f29506a;
    /* renamed from: b */
    private static final char[] f29507b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    /* renamed from: c */
    private static final int f29508c;
    /* renamed from: d */
    private final StringBuilder f29509d = new StringBuilder(20);
    /* renamed from: e */
    private final int[] f29510e = new int[6];

    static {
        int[] iArr = new int[]{276, 328, 324, 322, 296, 292, 290, 336, TiffUtil.TIFF_TAG_ORIENTATION, 266, 424, 420, 418, HttpStatus.HTTP_NOT_FOUND, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 366, 374, 430, 294, 474, 470, 306, 350};
        f29506a = iArr;
        f29508c = iArr[47];
    }

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        int i2;
        int c;
        map = m38477a(c5196a);
        int c2 = c5196a.m21965c(map[1]);
        int a = c5196a.m21954a();
        int[] iArr = this.f29510e;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f29509d;
        charSequence.setLength(0);
        while (true) {
            C6873r.m32295a(c5196a, c2, iArr);
            int a2 = C7907g.m38474a(iArr);
            if (a2 >= 0) {
                char a3 = C7907g.m38473a(a2);
                charSequence.append(a3);
                i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                c = c5196a.m21965c(i2);
                if (a3 == '*') {
                    break;
                }
                c2 = c;
            } else {
                throw C6894l.m32349a();
            }
        }
        charSequence.deleteCharAt(charSequence.length() - 1);
        i2 = 0;
        for (int i32 : iArr) {
            i2 += i32;
        }
        if (c == a || c5196a.m21959a(c) == null) {
            throw C6894l.m32349a();
        } else if (charSequence.length() >= 2) {
            C7907g.m38478b(charSequence);
            charSequence.setLength(charSequence.length() - 2);
            c5196a = C7907g.m38475a(charSequence);
            float f = ((float) c2) + (((float) i2) / 2.0f);
            r2 = new C5316s[2];
            i = (float) i;
            r2[0] = new C5316s(((float) (map[1] + map[0])) / 1073741824, i);
            r2[1] = new C5316s(f, i);
            return new C5314q(c5196a, null, r2, C5193a.CODE_93);
        } else {
            throw C6894l.m32349a();
        }
    }

    /* renamed from: a */
    private int[] m38477a(C5196a c5196a) {
        int a = c5196a.m21954a();
        int c = c5196a.m21965c(0);
        Arrays.fill(this.f29510e, 0);
        int[] iArr = this.f29510e;
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
                } else if (C7907g.m38474a(iArr) == f29508c) {
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
    private static int m38474a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        int i22 = 0;
        while (i3 < length) {
            int round = Math.round((((float) iArr[i3]) * 9.0f) / ((float) i));
            if (round > 0) {
                if (round <= 4) {
                    if ((i3 & 1) == 0) {
                        int i4 = i22;
                        for (i22 = 0; i22 < round; i22++) {
                            i4 = (i4 << 1) | 1;
                        }
                        i22 = i4;
                    } else {
                        i22 <<= round;
                    }
                    i3++;
                }
            }
            return -1;
        }
        return i22;
    }

    /* renamed from: a */
    private static char m38473a(int i) {
        for (int i2 = 0; i2 < f29506a.length; i2++) {
            if (f29506a[i2] == i) {
                return f29507b[i2];
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static String m38475a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
            } else if (i < length - 1) {
                i++;
                char charAt2 = charSequence.charAt(i);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw C6891h.m32342a();
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 < 'F' || charAt2 > 'J') {
                                if (charAt2 < 'K' || charAt2 > 'O') {
                                    if (charAt2 < 'P' || charAt2 > 'S') {
                                        if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                            charAt = '';
                                            break;
                                        }
                                        throw C6891h.m32342a();
                                    }
                                    charAt = (char) (charAt2 + 43);
                                    break;
                                }
                                charAt = (char) (charAt2 + 16);
                                break;
                            }
                            charAt = (char) (charAt2 - 11);
                            break;
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw C6891h.m32342a();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw C6891h.m32342a();
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
            } else {
                throw C6891h.m32342a();
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static void m38478b(CharSequence charSequence) {
        int length = charSequence.length();
        C7907g.m38476a(charSequence, length - 2, 20);
        C7907g.m38476a(charSequence, length - 1, 15);
    }

    /* renamed from: a */
    private static void m38476a(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f29507b[i3 % 47]) {
            throw C6866d.m32277a();
        }
    }
}
