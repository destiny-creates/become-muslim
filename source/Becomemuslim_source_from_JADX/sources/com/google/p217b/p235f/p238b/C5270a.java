package com.google.p217b.p235f.p238b;

import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5316s;
import com.google.p217b.p222b.C5202b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector */
/* renamed from: com.google.b.f.b.a */
public final class C5270a {
    /* renamed from: a */
    private static final int[] f17784a = new int[]{0, 4, 1, 5};
    /* renamed from: b */
    private static final int[] f17785b = new int[]{6, 2, 7, 3};
    /* renamed from: c */
    private static final int[] f17786c = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
    /* renamed from: d */
    private static final int[] f17787d = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: a */
    public static C5271b m22356a(C5232c c5232c, Map<C5254e, ?> map, boolean z) {
        c5232c = c5232c.m22164c();
        map = C5270a.m22357a(z, c5232c);
        if (map.isEmpty()) {
            c5232c = c5232c.m22012h();
            c5232c.m22003b();
            map = C5270a.m22357a(z, c5232c);
        }
        return new C5271b(c5232c, map);
    }

    /* renamed from: a */
    private static List<C5316s[]> m22357a(boolean z, C5202b c5202b) {
        List<C5316s[]> arrayList = new ArrayList();
        int i = 0;
        loop0:
        while (true) {
            int i2 = 0;
            Object obj = null;
            while (i < c5202b.m22011g()) {
                Object a = C5270a.m22360a(c5202b, i, i2);
                if (a[0] == null && a[3] == null) {
                    if (obj == null) {
                        break;
                    }
                    for (C5316s[] c5316sArr : arrayList) {
                        if (c5316sArr[1] != null) {
                            i = (int) Math.max((float) i, c5316sArr[1].m22583b());
                        }
                        if (c5316sArr[3] != null) {
                            i = Math.max(i, (int) c5316sArr[3].m22583b());
                        }
                    }
                    i += 5;
                } else {
                    arrayList.add(a);
                    if (!z) {
                        break loop0;
                    }
                    int a2;
                    if (a[2] != null) {
                        a2 = (int) a[2].m22582a();
                        i = (int) a[2].m22583b();
                    } else {
                        a2 = (int) a[4].m22582a();
                        i = (int) a[4].m22583b();
                    }
                    i2 = a2;
                    obj = 1;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C5316s[] m22360a(C5202b c5202b, int i, int i2) {
        int g = c5202b.m22011g();
        int f = c5202b.m22010f();
        C5316s[] c5316sArr = new C5316s[8];
        C5270a.m22358a(c5316sArr, C5270a.m22361a(c5202b, g, f, i, i2, f17786c), f17784a);
        if (c5316sArr[4] != null) {
            i2 = (int) c5316sArr[4].m22582a();
            i = (int) c5316sArr[4].m22583b();
        }
        C5270a.m22358a(c5316sArr, C5270a.m22361a(c5202b, g, f, i, i2, f17787d), f17785b);
        return c5316sArr;
    }

    /* renamed from: a */
    private static void m22358a(C5316s[] c5316sArr, C5316s[] c5316sArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            c5316sArr[iArr[i]] = c5316sArr2[i];
        }
    }

    /* renamed from: a */
    private static C5316s[] m22361a(C5202b c5202b, int i, int i2, int i3, int i4, int[] iArr) {
        Object obj;
        int i5;
        int[] iArr2;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        C5316s[] c5316sArr = new C5316s[4];
        int[] iArr3 = new int[iArr.length];
        int i10 = i3;
        while (i10 < i9) {
            int[] a = C5270a.m22359a(c5202b, i4, i10, i2, false, iArr, iArr3);
            float f;
            if (a != null) {
                int[] iArr4;
                while (true) {
                    iArr4 = a;
                    if (i10 <= 0) {
                        break;
                    }
                    i10--;
                    a = C5270a.m22359a(c5202b, i4, i10, i2, false, iArr, iArr3);
                    if (a == null) {
                        break;
                    }
                }
                i10++;
                f = (float) i10;
                c5316sArr[0] = new C5316s((float) iArr4[0], f);
                c5316sArr[1] = new C5316s((float) iArr4[1], f);
                obj = 1;
                i5 = i10 + 1;
                if (obj != null) {
                    iArr2 = new int[]{(int) c5316sArr[0].m22582a(), (int) c5316sArr[1].m22582a()};
                    i6 = i5;
                    i7 = 0;
                    while (i6 < i9) {
                        i8 = i7;
                        a = C5270a.m22359a(c5202b, iArr2[0], i6, i2, false, iArr, iArr3);
                        if (a != null || Math.abs(iArr2[0] - a[0]) >= 5 || Math.abs(iArr2[1] - a[1]) >= 5) {
                            if (i8 <= 25) {
                                break;
                            }
                            i7 = i8 + 1;
                        } else {
                            iArr2 = a;
                            i7 = 0;
                        }
                        i6++;
                    }
                    i8 = i7;
                    i5 = i6 - (i8 + 1);
                    f = (float) i5;
                    c5316sArr[2] = new C5316s((float) iArr2[0], f);
                    c5316sArr[3] = new C5316s((float) iArr2[1], f);
                }
                if (i5 - i10 < 10) {
                    Arrays.fill(c5316sArr, null);
                }
                return c5316sArr;
            }
            i10 += 5;
        }
        obj = null;
        i5 = i10 + 1;
        if (obj != null) {
            iArr2 = new int[]{(int) c5316sArr[0].m22582a(), (int) c5316sArr[1].m22582a()};
            i6 = i5;
            i7 = 0;
            while (i6 < i9) {
                i8 = i7;
                a = C5270a.m22359a(c5202b, iArr2[0], i6, i2, false, iArr, iArr3);
                if (a != null) {
                }
                if (i8 <= 25) {
                    break;
                }
                i7 = i8 + 1;
                i6++;
            }
            i8 = i7;
            i5 = i6 - (i8 + 1);
            f = (float) i5;
            c5316sArr[2] = new C5316s((float) iArr2[0], f);
            c5316sArr[3] = new C5316s((float) iArr2[1], f);
        }
        if (i5 - i10 < 10) {
            Arrays.fill(c5316sArr, null);
        }
        return c5316sArr;
    }

    /* renamed from: a */
    private static int[] m22359a(C5202b c5202b, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (c5202b.m22002a(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i--;
            i5 = i4;
        }
        i5 = iArr.length;
        int i6 = i;
        i4 = 0;
        while (true) {
            boolean z2 = true;
            if (i >= i3) {
                break;
            }
            if (c5202b.m22002a(i, i2) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != i5 - 1) {
                    i4++;
                } else if (C5270a.m22355a(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i6, i};
                } else {
                    i6 += iArr2[0] + iArr2[1];
                    int i7 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
        }
        if (i4 != i5 - 1 || C5270a.m22355a(iArr2, iArr, 0.8f) >= 1054280253) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    /* renamed from: a */
    private static float m22355a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        f *= f3;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = ((float) iArr2[i4]) * f3;
            float f6 = (float) iArr[i4];
            f6 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f6 > f) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / f2;
    }
}
