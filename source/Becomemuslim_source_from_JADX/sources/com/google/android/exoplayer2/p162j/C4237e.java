package com.google.android.exoplayer2.p162j;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.C2576u;
import com.google.android.exoplayer2.C2583v;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p162j.C2484f.C2483a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: MappingTrackSelector */
/* renamed from: com.google.android.exoplayer2.j.e */
public abstract class C4237e extends C2487h {
    /* renamed from: a */
    private final SparseArray<Map<C2439q, C2482b>> f11156a = new SparseArray();
    /* renamed from: b */
    private final SparseBooleanArray f11157b = new SparseBooleanArray();
    /* renamed from: c */
    private int f11158c = 0;
    /* renamed from: d */
    private C2481a f11159d;

    /* compiled from: MappingTrackSelector */
    /* renamed from: com.google.android.exoplayer2.j.e$a */
    public static final class C2481a {
        /* renamed from: a */
        public final int f6320a;
        /* renamed from: b */
        private final int[] f6321b;
        /* renamed from: c */
        private final C2439q[] f6322c;
        /* renamed from: d */
        private final int[] f6323d;
        /* renamed from: e */
        private final int[][][] f6324e;
        /* renamed from: f */
        private final C2439q f6325f;

        C2481a(int[] iArr, C2439q[] c2439qArr, int[] iArr2, int[][][] iArr3, C2439q c2439q) {
            this.f6321b = iArr;
            this.f6322c = c2439qArr;
            this.f6324e = iArr3;
            this.f6323d = iArr2;
            this.f6325f = c2439q;
            this.f6320a = c2439qArr.length;
        }
    }

    /* compiled from: MappingTrackSelector */
    /* renamed from: com.google.android.exoplayer2.j.e$b */
    public static final class C2482b {
        /* renamed from: a */
        public final C2483a f6326a;
        /* renamed from: b */
        public final int f6327b;
        /* renamed from: c */
        public final int[] f6328c;

        /* renamed from: a */
        public C2484f m6914a(C2439q c2439q) {
            return this.f6326a.mo2297b(c2439q.m6714a(this.f6327b), this.f6328c);
        }
    }

    /* renamed from: a */
    protected abstract C2484f[] mo3250a(C2576u[] c2576uArr, C2439q[] c2439qArr, int[][][] iArr);

    /* renamed from: a */
    public final boolean m13749a(int i, C2439q c2439q) {
        Map map = (Map) this.f11156a.get(i);
        return (map == null || map.containsKey(c2439q) == 0) ? false : true;
    }

    /* renamed from: a */
    public final C2488i mo2309a(C2576u[] c2576uArr, C2439q c2439q) {
        int i;
        C4237e c4237e = this;
        C2576u[] c2576uArr2 = c2576uArr;
        C2439q c2439q2 = c2439q;
        int[] iArr = new int[(c2576uArr2.length + 1)];
        C2438p[][] c2438pArr = new C2438p[(c2576uArr2.length + 1)][];
        int[][][] iArr2 = new int[(c2576uArr2.length + 1)][][];
        for (i = 0; i < c2438pArr.length; i++) {
            c2438pArr[i] = new C2438p[c2439q2.f6068b];
            iArr2[i] = new int[c2439q2.f6068b][];
        }
        int[] a = C4237e.m13745a(c2576uArr);
        for (i = 0; i < c2439q2.f6068b; i++) {
            int[] iArr3;
            C2438p a2 = c2439q2.m6714a(i);
            int a3 = C4237e.m13741a(c2576uArr2, a2);
            if (a3 == c2576uArr2.length) {
                iArr3 = new int[a2.f6064a];
            } else {
                iArr3 = C4237e.m13744a(c2576uArr2[a3], a2);
            }
            int i2 = iArr[a3];
            c2438pArr[a3][i2] = a2;
            iArr2[a3][i2] = iArr3;
            iArr[a3] = iArr[a3] + 1;
        }
        C2439q[] c2439qArr = new C2439q[c2576uArr2.length];
        int[] iArr4 = new int[c2576uArr2.length];
        for (int i3 = 0; i3 < c2576uArr2.length; i3++) {
            int i4 = iArr[i3];
            c2439qArr[i3] = new C2439q((C2438p[]) Arrays.copyOf(c2438pArr[i3], i4));
            iArr2[i3] = (int[][]) Arrays.copyOf(iArr2[i3], i4);
            iArr4[i3] = c2576uArr2[i3].mo3177a();
        }
        C2439q c2439q3 = new C2439q((C2438p[]) Arrays.copyOf(c2438pArr[c2576uArr2.length], iArr[c2576uArr2.length]));
        C2484f[] a4 = mo3250a(c2576uArr2, c2439qArr, iArr2);
        int i5 = 0;
        while (true) {
            C2484f c2484f = null;
            if (i5 >= c2576uArr2.length) {
                break;
            }
            if (c4237e.f11157b.get(i5)) {
                a4[i5] = null;
            } else {
                C2439q c2439q4 = c2439qArr[i5];
                if (m13749a(i5, c2439q4)) {
                    C2482b c2482b = (C2482b) ((Map) c4237e.f11156a.get(i5)).get(c2439q4);
                    if (c2482b != null) {
                        c2484f = c2482b.m6914a(c2439q4);
                    }
                    a4[i5] = c2484f;
                }
            }
            i5++;
        }
        boolean[] a5 = m13746a(c2576uArr2, a4);
        C2481a c2481a = new C2481a(iArr4, c2439qArr, a, iArr2, c2439q3);
        C2583v[] c2583vArr = new C2583v[c2576uArr2.length];
        for (int i6 = 0; i6 < c2576uArr2.length; i6++) {
            c2583vArr[i6] = a5[i6] ? C2583v.f6615a : null;
        }
        C4237e.m13742a(c2576uArr, c2439qArr, iArr2, c2583vArr, a4, c4237e.f11158c);
        return new C2488i(c2439q, a5, new C2485g(a4), c2481a, c2583vArr);
    }

    /* renamed from: a */
    private boolean[] m13746a(C2576u[] c2576uArr, C2484f[] c2484fArr) {
        boolean[] zArr = new boolean[c2484fArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolean z = !this.f11157b.get(i) && (c2576uArr[i].mo3177a() == 5 || c2484fArr[i] != null);
            zArr[i] = z;
        }
        return zArr;
    }

    /* renamed from: a */
    public final void mo2310a(Object obj) {
        this.f11159d = (C2481a) obj;
    }

    /* renamed from: a */
    private static int m13741a(C2576u[] c2576uArr, C2438p c2438p) {
        int length = c2576uArr.length;
        int i = 0;
        int i2 = 0;
        while (i < c2576uArr.length) {
            C2576u c2576u = c2576uArr[i];
            int i3 = length;
            for (length = 0; length < c2438p.f6064a; length++) {
                int a = c2576u.mo3411a(c2438p.m6712a(length)) & 7;
                if (a > i2) {
                    if (a == 4) {
                        return i;
                    }
                    i3 = i;
                    i2 = a;
                }
            }
            i++;
            length = i3;
        }
        return length;
    }

    /* renamed from: a */
    private static int[] m13744a(C2576u c2576u, C2438p c2438p) {
        int[] iArr = new int[c2438p.f6064a];
        for (int i = 0; i < c2438p.f6064a; i++) {
            iArr[i] = c2576u.mo3411a(c2438p.m6712a(i));
        }
        return iArr;
    }

    /* renamed from: a */
    private static int[] m13745a(C2576u[] c2576uArr) {
        int[] iArr = new int[c2576uArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = c2576uArr[i].mo3194m();
        }
        return iArr;
    }

    /* renamed from: a */
    private static void m13742a(C2576u[] c2576uArr, C2439q[] c2439qArr, int[][][] iArr, C2583v[] c2583vArr, C2484f[] c2484fArr, int i) {
        if (i != 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (i3 < c2576uArr.length) {
                int a = c2576uArr[i3].mo3177a();
                C2484f c2484f = c2484fArr[i3];
                if ((a == 1 || a == 2) && c2484f != null && C4237e.m13743a(iArr[i3], c2439qArr[i3], c2484f)) {
                    if (a == 1) {
                        if (i4 == -1) {
                            i4 = i3;
                        }
                    } else if (i5 == -1) {
                        i5 = i3;
                    }
                    c2576uArr = null;
                    break;
                }
                i3++;
            }
            c2576uArr = 1;
            if (!(i4 == -1 || i5 == -1)) {
                i2 = 1;
            }
            if ((c2576uArr & i2) != null) {
                c2576uArr = new C2583v(i);
                c2583vArr[i4] = c2576uArr;
                c2583vArr[i5] = c2576uArr;
            }
        }
    }

    /* renamed from: a */
    private static boolean m13743a(int[][] iArr, C2439q c2439q, C2484f c2484f) {
        if (c2484f == null) {
            return false;
        }
        c2439q = c2439q.m6713a(c2484f.mo2305f());
        for (int i = 0; i < c2484f.mo2306g(); i++) {
            if ((iArr[c2439q][c2484f.mo2301b(i)] & 32) != 32) {
                return false;
            }
        }
        return 1;
    }
}
