package com.google.android.exoplayer2.p149h.p151b;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2437n.C2436a;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4212d;
import com.google.android.exoplayer2.p149h.C4213e;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p149h.p150a.C4172f;
import com.google.android.exoplayer2.p149h.p150a.C4172f.C4171a;
import com.google.android.exoplayer2.p149h.p151b.C4180a.C2374a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2375a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2376b;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2378d;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2382g;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2512t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: DashMediaPeriod */
/* renamed from: com.google.android.exoplayer2.h.b.b */
final class C4715b implements C4219h, C2436a<C4172f<C4180a>> {
    /* renamed from: a */
    final int f12739a;
    /* renamed from: b */
    private final C2374a f12740b;
    /* renamed from: c */
    private final int f12741c;
    /* renamed from: d */
    private final C2429a f12742d;
    /* renamed from: e */
    private final long f12743e;
    /* renamed from: f */
    private final C2512t f12744f;
    /* renamed from: g */
    private final C2492b f12745g;
    /* renamed from: h */
    private final C2439q f12746h;
    /* renamed from: i */
    private final C2387a[] f12747i;
    /* renamed from: j */
    private C4218a f12748j;
    /* renamed from: k */
    private C4172f<C4180a>[] f12749k = C4715b.m16079a(0);
    /* renamed from: l */
    private C4212d f12750l = new C4212d(this.f12749k);
    /* renamed from: m */
    private C2376b f12751m;
    /* renamed from: n */
    private int f12752n;

    /* compiled from: DashMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.b.b$a */
    private static final class C2387a {
        /* renamed from: a */
        public final int[] f5881a;
        /* renamed from: b */
        public final int f5882b;
        /* renamed from: c */
        public final boolean f5883c;
        /* renamed from: d */
        public final int f5884d;
        /* renamed from: e */
        public final boolean f5885e;
        /* renamed from: f */
        public final boolean f5886f;

        public C2387a(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.f5882b = i;
            this.f5881a = iArr;
            this.f5884d = i2;
            this.f5883c = z;
            this.f5885e = z2;
            this.f5886f = z3;
        }
    }

    /* renamed from: c */
    public long mo3208c() {
        return -9223372036854775807L;
    }

    public C4715b(int i, C2376b c2376b, int i2, C2374a c2374a, int i3, C2429a c2429a, long j, C2512t c2512t, C2492b c2492b) {
        this.f12739a = i;
        this.f12751m = c2376b;
        this.f12752n = i2;
        this.f12740b = c2374a;
        this.f12741c = i3;
        this.f12742d = c2429a;
        this.f12743e = j;
        this.f12744f = c2512t;
        this.f12745g = c2492b;
        i = C4715b.m16075a(c2376b.m6569a(i2).f5858c);
        this.f12746h = (C2439q) i.first;
        this.f12747i = (C2387a[]) i.second;
    }

    /* renamed from: a */
    public void m16086a(C2376b c2376b, int i) {
        this.f12751m = c2376b;
        this.f12752n = i;
        if (this.f12749k != null) {
            for (C4172f a : this.f12749k) {
                ((C4180a) a.m13287a()).mo3213a(c2376b, i);
            }
            this.f12748j.mo3205a(this);
        }
    }

    /* renamed from: f */
    public void m16095f() {
        for (C4172f b : this.f12749k) {
            b.m13292b();
        }
    }

    /* renamed from: a */
    public void mo3204a(C4218a c4218a, long j) {
        this.f12748j = c4218a;
        c4218a.mo3223a(this);
    }

    public void e_() {
        this.f12744f.mo2322d();
    }

    /* renamed from: b */
    public C2439q mo3207b() {
        return this.f12746h;
    }

    /* renamed from: a */
    public long mo3202a(C2484f[] c2484fArr, boolean[] zArr, C2435m[] c2435mArr, boolean[] zArr2, long j) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < c2484fArr.length) {
            if (c2435mArr[i] instanceof C4172f) {
                C4172f c4172f = (C4172f) c2435mArr[i];
                if (c2484fArr[i] != null) {
                    if (zArr[i]) {
                        hashMap.put(Integer.valueOf(this.f12746h.m6713a(c2484fArr[i].mo2305f())), c4172f);
                    }
                }
                c4172f.m13292b();
                c2435mArr[i] = null;
            }
            if (c2435mArr[i] == null && c2484fArr[i] != null) {
                int a = this.f12746h.m6713a(c2484fArr[i].mo2305f());
                C2387a c2387a = this.f12747i[a];
                if (c2387a.f5883c) {
                    C4172f a2 = m16076a(c2387a, c2484fArr[i], j);
                    hashMap.put(Integer.valueOf(a), a2);
                    c2435mArr[i] = a2;
                    zArr2[i] = true;
                }
            }
            i++;
        }
        i = 0;
        while (i < c2484fArr.length) {
            if (((c2435mArr[i] instanceof C4171a) || (c2435mArr[i] instanceof C4213e)) && (c2484fArr[i] == null || !zArr[i])) {
                C4715b.m16077a(c2435mArr[i]);
                c2435mArr[i] = null;
            }
            if (c2484fArr[i] != null) {
                C2387a c2387a2 = this.f12747i[this.f12746h.m6713a(c2484fArr[i].mo2305f())];
                if (!c2387a2.f5883c) {
                    C4172f c4172f2 = (C4172f) hashMap.get(Integer.valueOf(c2387a2.f5884d));
                    C2435m c2435m = c2435mArr[i];
                    boolean z = c4172f2 == null ? c2435m instanceof C4213e : (c2435m instanceof C4171a) && ((C4171a) c2435m).f10825a == c4172f2;
                    if (!z) {
                        C4213e c4213e;
                        C4715b.m16077a(c2435m);
                        if (c4172f2 == null) {
                            c4213e = new C4213e();
                        } else {
                            c4213e = c4172f2.m13286a(j, c2387a2.f5882b);
                        }
                        c2435mArr[i] = c4213e;
                        zArr2[i] = true;
                    }
                }
            }
            i++;
        }
        this.f12749k = C4715b.m16079a(hashMap.size());
        hashMap.values().toArray(this.f12749k);
        this.f12750l = new C4212d(this.f12749k);
        return j;
    }

    /* renamed from: a */
    public void mo3203a(long j) {
        for (C4172f b : this.f12749k) {
            b.m13293b(j);
        }
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        return this.f12750l.mo2241c(j);
    }

    /* renamed from: e */
    public long mo2243e() {
        return this.f12750l.mo2243e();
    }

    /* renamed from: d */
    public long mo2242d() {
        return this.f12750l.mo2242d();
    }

    /* renamed from: b */
    public long mo3206b(long j) {
        for (C4172f d : this.f12749k) {
            d.m13297d(j);
        }
        return j;
    }

    /* renamed from: a */
    public void m16085a(C4172f<C4180a> c4172f) {
        this.f12748j.mo3205a(this);
    }

    /* renamed from: a */
    private static Pair<C2439q, C2387a[]> m16075a(List<C2375a> list) {
        List list2 = list;
        int[][] b = C4715b.m16081b((List) list);
        int length = b.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int i = 0;
        int i2 = length;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            if (C4715b.m16078a(list2, b[i3])) {
                zArr[i3] = true;
                i2++;
            }
            if (C4715b.m16080b(list2, b[i3])) {
                zArr2[i3] = true;
                i2++;
            }
            i3++;
        }
        C2438p[] c2438pArr = new C2438p[i2];
        Object obj = new C2387a[i2];
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7;
            int i8;
            String str;
            int[] iArr = b[i5];
            List arrayList = new ArrayList();
            for (int i9 : iArr) {
                arrayList.addAll(((C2375a) list2.get(i9)).f5832c);
            }
            C2515k[] c2515kArr = new C2515k[arrayList.size()];
            for (i7 = 0; i7 < c2515kArr.length; i7++) {
                c2515kArr[i7] = ((C2382g) arrayList.get(i7)).f5865c;
            }
            C2375a c2375a = (C2375a) list2.get(iArr[i]);
            boolean z = zArr[i5];
            boolean z2 = zArr2[i5];
            c2438pArr[i6] = new C2438p(c2515kArr);
            int i10 = i6 + 1;
            C2375a c2375a2 = c2375a;
            int[] iArr2 = iArr;
            obj[i6] = new C2387a(c2375a.f5831b, iArr, i6, true, z, z2);
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c2375a2.f5830a);
                stringBuilder.append(":emsg");
                C2515k[] c2515kArr2 = new C2515k[i4];
                c2515kArr2[0] = C2515k.m6992a(stringBuilder.toString(), "application/x-emsg", null, -1, null);
                c2438pArr[i10] = new C2438p(c2515kArr2);
                i8 = i10 + 1;
                str = null;
                obj[i10] = new C2387a(4, iArr2, i6, false, false, false);
            } else {
                str = null;
                i8 = i10;
            }
            if (z2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(c2375a2.f5830a);
                stringBuilder.append(":cea608");
                C2515k a = C2515k.m6981a(stringBuilder.toString(), "application/cea-608", 0, str);
                c2438pArr[i8] = new C2438p(a);
                i = i8 + 1;
                obj[i8] = new C2387a(3, iArr2, i6, false, false, false);
                i8 = i;
            }
            i5++;
            i6 = i8;
            i = 0;
            i4 = 1;
        }
        return Pair.create(new C2439q(c2438pArr), obj);
    }

    /* renamed from: b */
    private static int[][] m16081b(List<C2375a> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(((C2375a) list.get(i)).f5830a, i);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (!zArr[i3]) {
                zArr[i3] = true;
                C2378d c = C4715b.m16082c(((C2375a) list.get(i3)).f5834e);
                if (c == null) {
                    int i4 = i2 + 1;
                    iArr[i2] = new int[]{i3};
                    i2 = i4;
                } else {
                    String[] split = c.f5854b.split(",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i3;
                    int i5 = 0;
                    while (i5 < split.length) {
                        int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                        zArr[i6] = true;
                        i5++;
                        iArr2[i5] = i6;
                    }
                    int i7 = i2 + 1;
                    iArr[i2] = iArr2;
                    i2 = i7;
                }
            }
        }
        return i2 < size ? (int[][]) Arrays.copyOf(iArr, i2) : iArr;
    }

    /* renamed from: a */
    private C4172f<C4180a> m16076a(C2387a c2387a, C2484f c2484f, long j) {
        C4715b c4715b = this;
        C2387a c2387a2 = c2387a;
        int[] iArr = new int[2];
        boolean z = c2387a2.f5885e;
        int i = 0;
        if (z) {
            iArr[0] = 4;
            i = 1;
        }
        boolean z2 = c2387a2.f5886f;
        if (z2) {
            int i2 = i + 1;
            iArr[i] = 3;
            i = i2;
        }
        if (i < iArr.length) {
            iArr = Arrays.copyOf(iArr, i);
        }
        return new C4172f(c2387a2.f5882b, iArr, c4715b.f12740b.mo2266a(c4715b.f12744f, c4715b.f12751m, c4715b.f12752n, c2387a2.f5881a, c2484f, c2387a2.f5882b, c4715b.f12743e, z, z2), this, c4715b.f12745g, j, c4715b.f12741c, c4715b.f12742d);
    }

    /* renamed from: c */
    private static C2378d m16082c(List<C2378d> list) {
        for (int i = 0; i < list.size(); i++) {
            C2378d c2378d = (C2378d) list.get(i);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(c2378d.f5853a)) {
                return c2378d;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m16078a(List<C2375a> list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((C2375a) list.get(i)).f5832c;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!((C2382g) list2.get(i2)).f5868f.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m16080b(List<C2375a> list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((C2375a) list.get(i)).f5833d;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(((C2378d) list2.get(i2)).f5853a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C4172f<C4180a>[] m16079a(int i) {
        return new C4172f[i];
    }

    /* renamed from: a */
    private static void m16077a(C2435m c2435m) {
        if (c2435m instanceof C4171a) {
            ((C4171a) c2435m).m13276a();
        }
    }
}
