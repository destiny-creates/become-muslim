package com.google.p217b.p240g.p242b;

import com.google.p217b.C5254e;
import com.google.p217b.C5316s;
import com.google.p217b.C5317t;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder */
/* renamed from: com.google.b.g.b.e */
public class C5300e {
    /* renamed from: a */
    private final C5202b f17899a;
    /* renamed from: b */
    private final List<C6889d> f17900b = new ArrayList();
    /* renamed from: c */
    private boolean f17901c;
    /* renamed from: d */
    private final int[] f17902d = new int[5];
    /* renamed from: e */
    private final C5317t f17903e;

    /* compiled from: FinderPatternFinder */
    /* renamed from: com.google.b.g.b.e$a */
    private static final class C5298a implements Serializable, Comparator<C6889d> {
        /* renamed from: a */
        private final float f17897a;

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m22480a((C6889d) obj, (C6889d) obj2);
        }

        private C5298a(float f) {
            this.f17897a = f;
        }

        /* renamed from: a */
        public int m22480a(C6889d c6889d, C6889d c6889d2) {
            int compare = Integer.compare(c6889d2.m32339d(), c6889d.m32339d());
            return compare == 0 ? Float.compare(Math.abs(c6889d.m32338c() - this.f17897a), Math.abs(c6889d2.m32338c() - this.f17897a)) : compare;
        }
    }

    /* compiled from: FinderPatternFinder */
    /* renamed from: com.google.b.g.b.e$b */
    private static final class C5299b implements Serializable, Comparator<C6889d> {
        /* renamed from: a */
        private final float f17898a;

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m22481a((C6889d) obj, (C6889d) obj2);
        }

        private C5299b(float f) {
            this.f17898a = f;
        }

        /* renamed from: a */
        public int m22481a(C6889d c6889d, C6889d c6889d2) {
            return Float.compare(Math.abs(c6889d2.m32338c() - this.f17898a), Math.abs(c6889d.m32338c() - this.f17898a));
        }
    }

    public C5300e(C5202b c5202b, C5317t c5317t) {
        this.f17899a = c5202b;
        this.f17903e = c5317t;
    }

    /* renamed from: a */
    final C5301f m22492a(Map<C5254e, ?> map) {
        map = (map == null || map.containsKey(C5254e.TRY_HARDER) == null) ? null : true;
        int g = this.f17899a.m22011g();
        int f = this.f17899a.m22010f();
        int i = (g * 3) / 388;
        if (i < 3 || map != null) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        boolean z = false;
        while (i2 < g && !z) {
            m22494c(iArr);
            boolean z2 = z;
            int i4 = i3;
            i = 0;
            i3 = 0;
            while (i < f) {
                if (this.f17899a.m22002a(i, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 == 4) {
                    if (!C5300e.m22485a(iArr)) {
                        m22495d(iArr);
                    } else if (m22493a(iArr, i2, i)) {
                        if (this.f17901c) {
                            z2 = m22490c();
                        } else {
                            i3 = m22488b();
                            if (i3 > iArr[2]) {
                                i2 += (i3 - iArr[2]) - 2;
                                i = f - 1;
                            }
                        }
                        m22494c(iArr);
                        i3 = 0;
                        i4 = 2;
                    } else {
                        m22495d(iArr);
                    }
                    i3 = 3;
                } else {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                }
                i++;
            }
            if (C5300e.m22485a(iArr) && m22493a(iArr, i2, f)) {
                i = iArr[0];
                if (this.f17901c) {
                    i3 = i;
                    z = m22490c();
                    i2 += i3;
                } else {
                    i3 = i;
                }
            } else {
                i3 = i4;
            }
            z = z2;
            i2 += i3;
        }
        map = m22491d();
        C5316s.m22581a(map);
        return new C5301f(map);
    }

    /* renamed from: a */
    private static float m22483a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    /* renamed from: a */
    protected static boolean m22485a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    protected static boolean m22489b(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 1.333f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int[] m22486a() {
        m22494c(this.f17902d);
        return this.f17902d;
    }

    /* renamed from: c */
    protected final void m22494c(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    /* renamed from: d */
    protected final void m22495d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    /* renamed from: a */
    private boolean m22484a(int i, int i2) {
        int[] a = m22486a();
        int i3 = 0;
        while (i >= i3 && i2 >= i3 && this.f17899a.m22002a(i2 - i3, i - i3)) {
            a[2] = a[2] + 1;
            i3++;
        }
        if (a[2] == 0) {
            return false;
        }
        while (i >= i3 && i2 >= i3 && !this.f17899a.m22002a(i2 - i3, i - i3)) {
            a[1] = a[1] + 1;
            i3++;
        }
        if (a[1] == 0) {
            return false;
        }
        while (i >= i3 && i2 >= i3 && this.f17899a.m22002a(i2 - i3, i - i3)) {
            a[0] = a[0] + 1;
            i3++;
        }
        if (a[0] == 0) {
            return false;
        }
        i3 = this.f17899a.m22011g();
        int f = this.f17899a.m22010f();
        int i4 = 1;
        while (true) {
            int i5 = i + i4;
            if (i5 >= i3) {
                break;
            }
            int i6 = i2 + i4;
            if (i6 >= f || !this.f17899a.m22002a(i6, i5)) {
                break;
            }
            a[2] = a[2] + 1;
            i4++;
        }
        while (true) {
            int i7 = i + i4;
            if (i7 >= i3) {
                break;
            }
            i6 = i2 + i4;
            if (i6 >= f || this.f17899a.m22002a(i6, i7)) {
                break;
            }
            a[3] = a[3] + 1;
            i4++;
        }
        if (a[3] == 0) {
            return false;
        }
        while (true) {
            i7 = i + i4;
            if (i7 >= i3) {
                break;
            }
            i6 = i2 + i4;
            if (i6 >= f || !this.f17899a.m22002a(i6, i7)) {
                break;
            }
            a[4] = a[4] + 1;
            i4++;
        }
        if (a[4] == 0) {
            return false;
        }
        return C5300e.m22489b(a);
    }

    /* renamed from: a */
    private float m22482a(int i, int i2, int i3, int i4) {
        C5202b c5202b = this.f17899a;
        int g = c5202b.m22011g();
        int[] a = m22486a();
        int i5 = i;
        while (i5 >= 0 && c5202b.m22002a(i2, i5)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c5202b.m22002a(i2, i5) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 >= 0) {
            if (a[1] <= i3) {
                while (i5 >= 0 && c5202b.m22002a(i2, i5) && a[0] <= i3) {
                    a[0] = a[0] + 1;
                    i5--;
                }
                if (a[0] > i3) {
                    return Float.NaN;
                }
                i++;
                while (i < g && c5202b.m22002a(i2, i)) {
                    a[2] = a[2] + 1;
                    i++;
                }
                if (i == g) {
                    return Float.NaN;
                }
                while (i < g && !c5202b.m22002a(i2, i) && a[3] < i3) {
                    a[3] = a[3] + 1;
                    i++;
                }
                if (i != g) {
                    if (a[3] < i3) {
                        while (i < g && c5202b.m22002a(i2, i) && a[4] < i3) {
                            a[4] = a[4] + 1;
                            i++;
                        }
                        if (a[4] < i3 && Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 < i4 * 2 && C5300e.m22485a(a) != 0) {
                            return C5300e.m22483a(a, i);
                        }
                        return Float.NaN;
                    }
                }
                return Float.NaN;
            }
        }
        return Float.NaN;
    }

    /* renamed from: b */
    private float m22487b(int i, int i2, int i3, int i4) {
        C5202b c5202b = this.f17899a;
        int f = c5202b.m22010f();
        int[] a = m22486a();
        int i5 = i;
        while (i5 >= 0 && c5202b.m22002a(i5, i2)) {
            a[2] = a[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !c5202b.m22002a(i5, i2) && a[1] <= i3) {
            a[1] = a[1] + 1;
            i5--;
        }
        if (i5 >= 0) {
            if (a[1] <= i3) {
                while (i5 >= 0 && c5202b.m22002a(i5, i2) && a[0] <= i3) {
                    a[0] = a[0] + 1;
                    i5--;
                }
                if (a[0] > i3) {
                    return Float.NaN;
                }
                i++;
                while (i < f && c5202b.m22002a(i, i2)) {
                    a[2] = a[2] + 1;
                    i++;
                }
                if (i == f) {
                    return Float.NaN;
                }
                while (i < f && !c5202b.m22002a(i, i2) && a[3] < i3) {
                    a[3] = a[3] + 1;
                    i++;
                }
                if (i != f) {
                    if (a[3] < i3) {
                        while (i < f && c5202b.m22002a(i, i2) && a[4] < i3) {
                            a[4] = a[4] + 1;
                            i++;
                        }
                        if (a[4] < i3 && Math.abs(((((a[0] + a[1]) + a[2]) + a[3]) + a[4]) - i4) * 5 < i4 && C5300e.m22485a(a) != 0) {
                            return C5300e.m22483a(a, i);
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
    protected final boolean m22493a(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        i2 = (int) C5300e.m22483a(iArr, i2);
        i = m22482a(i, i2, iArr[2], i3);
        if (!Float.isNaN(i)) {
            int i4 = (int) i;
            iArr = m22487b(i2, i4, iArr[2], i3);
            if (Float.isNaN(iArr) == 0 && m22484a(i4, (int) iArr) != 0) {
                i2 = ((float) i3) / 1088421888;
                for (i3 = 0; i3 < this.f17900b.size(); i3++) {
                    C6889d c6889d = (C6889d) this.f17900b.get(i3);
                    if (c6889d.m32336a(i2, i, iArr)) {
                        this.f17900b.set(i3, c6889d.m32337b(i, iArr, i2));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    C5316s c6889d2 = new C6889d(iArr, i, i2);
                    this.f17900b.add(c6889d2);
                    if (this.f17903e != null) {
                        this.f17903e.m22584a(c6889d2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private int m22488b() {
        if (this.f17900b.size() <= 1) {
            return 0;
        }
        C5316s c5316s = null;
        for (C5316s c5316s2 : this.f17900b) {
            if (c5316s2.m32339d() >= 2) {
                if (c5316s == null) {
                    c5316s = c5316s2;
                } else {
                    this.f17901c = true;
                    return ((int) (Math.abs(c5316s.m22582a() - c5316s2.m22582a()) - Math.abs(c5316s.m22583b() - c5316s2.m22583b()))) / 2;
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    private boolean m22490c() {
        int size = this.f17900b.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (C6889d c6889d : this.f17900b) {
            if (c6889d.m32339d() >= 2) {
                i++;
                f2 += c6889d.m32338c();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (C6889d c : this.f17900b) {
            f += Math.abs(c.m32338c() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private C6889d[] m22491d() {
        int size = this.f17900b.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (C6889d c : this.f17900b) {
                    float c2 = c.m32338c();
                    f2 += c2;
                    f3 += c2 * c2;
                }
                float f4 = (float) size;
                f2 /= f4;
                f4 = (float) Math.sqrt((double) ((f3 / f4) - (f2 * f2)));
                Collections.sort(this.f17900b, new C5299b(f2));
                f4 = Math.max(0.2f * f2, f4);
                int i = 0;
                while (i < this.f17900b.size() && this.f17900b.size() > 3) {
                    if (Math.abs(((C6889d) this.f17900b.get(i)).m32338c() - f2) > f4) {
                        this.f17900b.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.f17900b.size() > 3) {
                for (C6889d c3 : this.f17900b) {
                    f += c3.m32338c();
                }
                Collections.sort(this.f17900b, new C5298a(f / ((float) this.f17900b.size())));
                this.f17900b.subList(3, this.f17900b.size()).clear();
            }
            return new C6889d[]{(C6889d) this.f17900b.get(0), (C6889d) this.f17900b.get(1), (C6889d) this.f17900b.get(2)};
        }
        throw C6894l.m32349a();
    }
}
