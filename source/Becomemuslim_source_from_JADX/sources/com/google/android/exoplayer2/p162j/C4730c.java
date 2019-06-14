package com.google.android.exoplayer2.p162j;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2576u;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p162j.C2484f.C2483a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DefaultTrackSelector */
/* renamed from: com.google.android.exoplayer2.j.c */
public class C4730c extends C4237e {
    /* renamed from: a */
    private static final int[] f12918a = new int[0];
    /* renamed from: b */
    private final C2483a f12919b;
    /* renamed from: c */
    private final AtomicReference<C2480c> f12920c;

    /* compiled from: DefaultTrackSelector */
    /* renamed from: com.google.android.exoplayer2.j.c$a */
    private static final class C2478a {
        /* renamed from: a */
        public final int f6296a;
        /* renamed from: b */
        public final int f6297b;
        /* renamed from: c */
        public final String f6298c;

        public C2478a(int i, int i2, String str) {
            this.f6296a = i;
            this.f6297b = i2;
            this.f6298c = str;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C2478a c2478a = (C2478a) obj;
                    if (this.f6296a != c2478a.f6296a || this.f6297b != c2478a.f6297b || TextUtils.equals(this.f6298c, c2478a.f6298c) == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f6296a * 31) + this.f6297b) * 31) + (this.f6298c != null ? this.f6298c.hashCode() : 0);
        }
    }

    /* compiled from: DefaultTrackSelector */
    /* renamed from: com.google.android.exoplayer2.j.c$b */
    private static final class C2479b implements Comparable<C2479b> {
        /* renamed from: a */
        private final C2480c f6299a;
        /* renamed from: b */
        private final int f6300b;
        /* renamed from: c */
        private final int f6301c;
        /* renamed from: d */
        private final int f6302d;
        /* renamed from: e */
        private final int f6303e;
        /* renamed from: f */
        private final int f6304f;
        /* renamed from: g */
        private final int f6305g;

        public /* synthetic */ int compareTo(Object obj) {
            return m6913a((C2479b) obj);
        }

        public C2479b(C2515k c2515k, C2480c c2480c, int i) {
            this.f6299a = c2480c;
            this.f6300b = C4730c.m16342a(i, false);
            this.f6301c = C4730c.m16345a(c2515k, c2480c.f6306a);
            i = 1;
            if ((c2515k.f6398x & 1) == null) {
                i = 0;
            }
            this.f6302d = i;
            this.f6303e = c2515k.f6392r;
            this.f6304f = c2515k.f6393s;
            this.f6305g = c2515k.f6376b;
        }

        /* renamed from: a */
        public int m6913a(C2479b c2479b) {
            if (this.f6300b != c2479b.f6300b) {
                return C4730c.m16353c(this.f6300b, c2479b.f6300b);
            }
            if (this.f6301c != c2479b.f6301c) {
                return C4730c.m16353c(this.f6301c, c2479b.f6301c);
            }
            if (this.f6302d != c2479b.f6302d) {
                return C4730c.m16353c(this.f6302d, c2479b.f6302d);
            }
            if (this.f6299a.f6316k) {
                return C4730c.m16353c(c2479b.f6305g, this.f6305g);
            }
            int i = 1;
            if (this.f6300b != 1) {
                i = -1;
            }
            if (this.f6303e != c2479b.f6303e) {
                return i * C4730c.m16353c(this.f6303e, c2479b.f6303e);
            }
            if (this.f6304f != c2479b.f6304f) {
                return i * C4730c.m16353c(this.f6304f, c2479b.f6304f);
            }
            return i * C4730c.m16353c(this.f6305g, c2479b.f6305g);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C2479b c2479b = (C2479b) obj;
                    if (this.f6300b != c2479b.f6300b || this.f6301c != c2479b.f6301c || this.f6302d != c2479b.f6302d || this.f6303e != c2479b.f6303e || this.f6304f != c2479b.f6304f || this.f6305g != c2479b.f6305g) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.f6300b * 31) + this.f6301c) * 31) + this.f6302d) * 31) + this.f6303e) * 31) + this.f6304f) * 31) + this.f6305g;
        }
    }

    /* compiled from: DefaultTrackSelector */
    /* renamed from: com.google.android.exoplayer2.j.c$c */
    public static final class C2480c {
        /* renamed from: a */
        public final String f6306a;
        /* renamed from: b */
        public final String f6307b;
        /* renamed from: c */
        public final boolean f6308c;
        /* renamed from: d */
        public final int f6309d;
        /* renamed from: e */
        public final int f6310e;
        /* renamed from: f */
        public final int f6311f;
        /* renamed from: g */
        public final boolean f6312g;
        /* renamed from: h */
        public final int f6313h;
        /* renamed from: i */
        public final int f6314i;
        /* renamed from: j */
        public final boolean f6315j;
        /* renamed from: k */
        public final boolean f6316k;
        /* renamed from: l */
        public final boolean f6317l;
        /* renamed from: m */
        public final boolean f6318m;
        /* renamed from: n */
        public final boolean f6319n;

        public C2480c() {
            this(null, null, false, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C2480c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, int i3, boolean z5, boolean z6, int i4, int i5, boolean z7) {
            this.f6306a = str;
            this.f6307b = str2;
            this.f6308c = z;
            this.f6316k = z2;
            this.f6317l = z3;
            this.f6318m = z4;
            this.f6309d = i;
            this.f6310e = i2;
            this.f6311f = i3;
            this.f6312g = z5;
            this.f6319n = z6;
            this.f6313h = i4;
            this.f6314i = i5;
            this.f6315j = z7;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C2480c c2480c = (C2480c) obj;
                    if (this.f6316k != c2480c.f6316k || this.f6317l != c2480c.f6317l || this.f6318m != c2480c.f6318m || this.f6309d != c2480c.f6309d || this.f6310e != c2480c.f6310e || this.f6312g != c2480c.f6312g || this.f6319n != c2480c.f6319n || this.f6315j != c2480c.f6315j || this.f6313h != c2480c.f6313h || this.f6314i != c2480c.f6314i || this.f6311f != c2480c.f6311f || !TextUtils.equals(this.f6306a, c2480c.f6306a) || TextUtils.equals(this.f6307b, c2480c.f6307b) == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.f6306a.hashCode() * 31) + this.f6307b.hashCode()) * 31) + this.f6316k) * 31) + this.f6317l) * 31) + this.f6318m) * 31) + this.f6309d) * 31) + this.f6310e) * 31) + this.f6311f) * 31) + this.f6312g) * 31) + this.f6319n) * 31) + this.f6315j) * 31) + this.f6313h) * 31) + this.f6314i;
        }
    }

    /* renamed from: a */
    protected static boolean m16342a(int i, boolean z) {
        i &= 7;
        if (i != 4) {
            if (!z || i != 3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static int m16349b(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    /* renamed from: c */
    private static int m16353c(int i, int i2) {
        return i > i2 ? 1 : i2 > i ? -1 : 0;
    }

    public C4730c() {
        this((C2483a) null);
    }

    public C4730c(C2483a c2483a) {
        this.f12919b = c2483a;
        this.f12920c = new AtomicReference(new C2480c());
    }

    /* renamed from: a */
    protected C2484f[] mo3250a(C2576u[] c2576uArr, C2439q[] c2439qArr, int[][][] iArr) {
        C2576u[] c2576uArr2 = c2576uArr;
        int length = c2576uArr2.length;
        C2484f[] c2484fArr = new C2484f[length];
        C2480c c2480c = (C2480c) this.f12920c.get();
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= length) {
                break;
            }
            if (2 == c2576uArr2[i].mo3177a()) {
                if (obj == null) {
                    c2484fArr[i] = m16357a(c2576uArr2[i], c2439qArr[i], iArr[i], c2480c, r6.f12919b);
                    obj = c2484fArr[i] != null ? 1 : null;
                }
                if (c2439qArr[i].f6068b <= 0) {
                    i3 = 0;
                }
                i2 |= i3;
            }
            i++;
        }
        Object obj2 = null;
        Object obj3 = null;
        for (int i4 = 0; i4 < length; i4++) {
            switch (c2576uArr2[i4].mo3177a()) {
                case 1:
                    if (obj2 != null) {
                        break;
                    }
                    c2484fArr[i4] = m16356a(c2439qArr[i4], iArr[i4], c2480c, i2 != 0 ? null : r6.f12919b);
                    if (c2484fArr[i4] == null) {
                        obj2 = null;
                        break;
                    }
                    obj2 = 1;
                    break;
                case 2:
                    break;
                case 3:
                    if (obj3 != null) {
                        break;
                    }
                    c2484fArr[i4] = m16355a(c2439qArr[i4], iArr[i4], c2480c);
                    if (c2484fArr[i4] == null) {
                        obj3 = null;
                        break;
                    }
                    obj3 = 1;
                    break;
                default:
                    c2484fArr[i4] = m16354a(c2576uArr2[i4].mo3177a(), c2439qArr[i4], iArr[i4], c2480c);
                    break;
            }
        }
        return c2484fArr;
    }

    /* renamed from: a */
    protected C2484f m16357a(C2576u c2576u, C2439q c2439q, int[][] iArr, C2480c c2480c, C2483a c2483a) {
        c2576u = (c2480c.f6316k || c2483a == null) ? null : C4730c.m16351b(c2576u, c2439q, iArr, c2480c, c2483a);
        return c2576u == null ? C4730c.m16350b(c2439q, iArr, c2480c) : c2576u;
    }

    /* renamed from: b */
    private static C2484f m16351b(C2576u c2576u, C2439q c2439q, int[][] iArr, C2480c c2480c, C2483a c2483a) {
        C2439q c2439q2 = c2439q;
        C2480c c2480c2 = c2480c;
        int i = c2480c2.f6318m ? 24 : 16;
        boolean z = c2480c2.f6317l && (c2576u.mo3194m() & i) != 0;
        for (int i2 = 0; i2 < c2439q2.f6068b; i2++) {
            C2438p a = c2439q2.m6714a(i2);
            int[] a2 = C4730c.m16348a(a, iArr[i2], z, i, c2480c2.f6309d, c2480c2.f6310e, c2480c2.f6311f, c2480c2.f6313h, c2480c2.f6314i, c2480c2.f6315j);
            if (a2.length > 0) {
                return c2483a.mo2297b(a, a2);
            }
            C2483a c2483a2 = c2483a;
        }
        return null;
    }

    /* renamed from: a */
    private static int[] m16348a(C2438p c2438p, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        C2438p c2438p2 = c2438p;
        if (c2438p2.f6064a < 2) {
            return f12918a;
        }
        List a = C4730c.m16341a(c2438p2, i5, i6, z2);
        if (a.size() < 2) {
            return f12918a;
        }
        String str;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < a.size(); i8++) {
                String str3 = c2438p2.m6712a(((Integer) a.get(i8)).intValue()).f6380f;
                if (hashSet.add(str3)) {
                    int a2 = C4730c.m16338a(c2438p, iArr, i, str3, i2, i3, i4, a);
                    if (a2 > i7) {
                        i7 = a2;
                        str2 = str3;
                    }
                }
            }
            str = str2;
        }
        C4730c.m16352b(c2438p, iArr, i, str, i2, i3, i4, a);
        return a.size() < 2 ? f12918a : C2541v.m7180a(a);
    }

    /* renamed from: a */
    private static int m16338a(C2438p c2438p, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = ((Integer) list.get(i6)).intValue();
            C2438p c2438p2 = c2438p;
            if (C4730c.m16346a(c2438p.m6712a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    /* renamed from: b */
    private static void m16352b(C2438p c2438p, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list2.get(size)).intValue();
            C2438p c2438p2 = c2438p;
            if (!C4730c.m16346a(c2438p.m6712a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list2.remove(size);
            }
        }
    }

    /* renamed from: a */
    private static boolean m16346a(C2515k c2515k, String str, int i, int i2, int i3, int i4, int i5) {
        if (!C4730c.m16342a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && C2541v.m7179a(c2515k.f6380f, (Object) str) == null) {
            return false;
        }
        if (c2515k.f6384j != -1 && c2515k.f6384j > i3) {
            return false;
        }
        if (c2515k.f6385k != -1 && c2515k.f6385k > i4) {
            return false;
        }
        if (c2515k.f6376b == -1 || c2515k.f6376b <= i5) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static com.google.android.exoplayer2.p162j.C2484f m16350b(com.google.android.exoplayer2.p149h.C2439q r20, int[][] r21, com.google.android.exoplayer2.p162j.C4730c.C2480c r22) {
        /*
        r0 = r20;
        r1 = r22;
        r3 = -1;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = -1;
        r10 = -1;
    L_0x000b:
        r11 = r0.f6068b;
        if (r5 >= r11) goto L_0x00db;
    L_0x000f:
        r11 = r0.m6714a(r5);
        r12 = r1.f6313h;
        r13 = r1.f6314i;
        r14 = r1.f6315j;
        r12 = com.google.android.exoplayer2.p162j.C4730c.m16341a(r11, r12, r13, r14);
        r14 = r21[r5];
        r15 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = 0;
    L_0x0025:
        r2 = r11.f6064a;
        if (r6 >= r2) goto L_0x00cc;
    L_0x0029:
        r2 = r14[r6];
        r4 = r1.f6319n;
        r2 = com.google.android.exoplayer2.p162j.C4730c.m16342a(r2, r4);
        if (r2 == 0) goto L_0x00c1;
    L_0x0033:
        r2 = r11.m6712a(r6);
        r4 = java.lang.Integer.valueOf(r6);
        r4 = r12.contains(r4);
        r18 = 1;
        if (r4 == 0) goto L_0x0065;
    L_0x0043:
        r4 = r2.f6384j;
        if (r4 == r3) goto L_0x004d;
    L_0x0047:
        r4 = r2.f6384j;
        r3 = r1.f6309d;
        if (r4 > r3) goto L_0x0065;
    L_0x004d:
        r3 = r2.f6385k;
        r4 = -1;
        if (r3 == r4) goto L_0x0058;
    L_0x0052:
        r3 = r2.f6385k;
        r4 = r1.f6310e;
        if (r3 > r4) goto L_0x0065;
    L_0x0058:
        r3 = r2.f6376b;
        r4 = -1;
        if (r3 == r4) goto L_0x0063;
    L_0x005d:
        r3 = r2.f6376b;
        r4 = r1.f6311f;
        if (r3 > r4) goto L_0x0065;
    L_0x0063:
        r3 = 1;
        goto L_0x0066;
    L_0x0065:
        r3 = 0;
    L_0x0066:
        if (r3 != 0) goto L_0x006d;
    L_0x0068:
        r4 = r1.f6312g;
        if (r4 != 0) goto L_0x006d;
    L_0x006c:
        goto L_0x00c1;
    L_0x006d:
        if (r3 == 0) goto L_0x0071;
    L_0x006f:
        r4 = 2;
        goto L_0x0072;
    L_0x0071:
        r4 = 1;
    L_0x0072:
        r0 = r14[r6];
        r19 = r8;
        r8 = 0;
        r0 = com.google.android.exoplayer2.p162j.C4730c.m16342a(r0, r8);
        if (r0 == 0) goto L_0x007f;
    L_0x007d:
        r4 = r4 + 1000;
    L_0x007f:
        if (r4 <= r9) goto L_0x0084;
    L_0x0081:
        r17 = 1;
        goto L_0x0086;
    L_0x0084:
        r17 = 0;
    L_0x0086:
        if (r4 != r9) goto L_0x00b5;
    L_0x0088:
        r8 = r1.f6316k;
        if (r8 == 0) goto L_0x009a;
    L_0x008c:
        r0 = r2.f6376b;
        r0 = com.google.android.exoplayer2.p162j.C4730c.m16349b(r0, r10);
        if (r0 >= 0) goto L_0x0097;
    L_0x0094:
        r17 = 1;
        goto L_0x00b5;
    L_0x0097:
        r17 = 0;
        goto L_0x00b5;
    L_0x009a:
        r8 = r2.m7005a();
        if (r8 == r15) goto L_0x00a5;
    L_0x00a0:
        r8 = com.google.android.exoplayer2.p162j.C4730c.m16349b(r8, r15);
        goto L_0x00ab;
    L_0x00a5:
        r8 = r2.f6376b;
        r8 = com.google.android.exoplayer2.p162j.C4730c.m16349b(r8, r10);
    L_0x00ab:
        if (r0 == 0) goto L_0x00b2;
    L_0x00ad:
        if (r3 == 0) goto L_0x00b2;
    L_0x00af:
        if (r8 <= 0) goto L_0x0097;
    L_0x00b1:
        goto L_0x0094;
    L_0x00b2:
        if (r8 >= 0) goto L_0x0097;
    L_0x00b4:
        goto L_0x0094;
    L_0x00b5:
        if (r17 == 0) goto L_0x00c3;
    L_0x00b7:
        r10 = r2.f6376b;
        r15 = r2.m7005a();
        r9 = r4;
        r8 = r6;
        r7 = r11;
        goto L_0x00c5;
    L_0x00c1:
        r19 = r8;
    L_0x00c3:
        r8 = r19;
    L_0x00c5:
        r6 = r6 + 1;
        r0 = r20;
        r3 = -1;
        goto L_0x0025;
    L_0x00cc:
        r19 = r8;
        r5 = r5 + 1;
        r6 = r7;
        r8 = r9;
        r9 = r10;
        r10 = r15;
        r7 = r19;
        r0 = r20;
        r3 = -1;
        goto L_0x000b;
    L_0x00db:
        if (r6 != 0) goto L_0x00e0;
    L_0x00dd:
        r16 = 0;
        goto L_0x00e7;
    L_0x00e0:
        r2 = new com.google.android.exoplayer2.j.d;
        r2.<init>(r6, r7);
        r16 = r2;
    L_0x00e7:
        return r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.c.b(com.google.android.exoplayer2.h.q, int[][], com.google.android.exoplayer2.j.c$c):com.google.android.exoplayer2.j.f");
    }

    /* renamed from: a */
    protected C2484f m16356a(C2439q c2439q, int[][] iArr, C2480c c2480c, C2483a c2483a) {
        C2439q c2439q2 = c2439q;
        C2480c c2480c2 = c2480c;
        C2483a c2483a2 = c2483a;
        C2484f c2484f = null;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < c2439q2.f6068b) {
            C2438p a = c2439q2.m6714a(i);
            int[] iArr2 = iArr[i];
            int i4 = i3;
            C2479b c2479b = c2484f;
            int i5 = i2;
            for (i2 = 0; i2 < a.f6064a; i2++) {
                if (C4730c.m16342a(iArr2[i2], c2480c2.f6319n)) {
                    C2479b c2479b2 = new C2479b(a.m6712a(i2), c2480c2, iArr2[i2]);
                    if (c2479b == null || c2479b2.m6913a(c2479b) > 0) {
                        i5 = i;
                        i4 = i2;
                        c2479b = c2479b2;
                    }
                }
            }
            i++;
            i2 = i5;
            Object obj = c2479b;
            i3 = i4;
        }
        if (i2 == -1) {
            return null;
        }
        C2438p a2 = c2439q2.m6714a(i2);
        if (!(c2480c2.f6316k || c2483a2 == null)) {
            int[] a3 = C4730c.m16347a(a2, iArr[i2], c2480c2.f6317l);
            if (a3.length > 0) {
                return c2483a2.mo2297b(a2, a3);
            }
        }
        return new C4731d(a2, i3);
    }

    /* renamed from: a */
    private static int[] m16347a(C2438p c2438p, int[] iArr, boolean z) {
        HashSet hashSet = new HashSet();
        C2478a c2478a = null;
        boolean z2 = false;
        for (int i = 0; i < c2438p.f6064a; i++) {
            C2515k a = c2438p.m6712a(i);
            C2478a c2478a2 = new C2478a(a.f6392r, a.f6393s, z ? null : a.f6380f);
            if (hashSet.add(c2478a2)) {
                boolean a2 = C4730c.m16339a(c2438p, iArr, c2478a2);
                if (a2 > z2) {
                    z2 = a2;
                    c2478a = c2478a2;
                }
            }
        }
        if (z2 <= true) {
            return f12918a;
        }
        z = new int[z2];
        int i2 = 0;
        for (int i3 = 0; i3 < c2438p.f6064a; i3++) {
            if (C4730c.m16344a(c2438p.m6712a(i3), iArr[i3], c2478a)) {
                int i4 = i2 + 1;
                z[i2] = i3;
                i2 = i4;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static int m16339a(C2438p c2438p, int[] iArr, C2478a c2478a) {
        int i = 0;
        for (int i2 = 0; i2 < c2438p.f6064a; i2++) {
            if (C4730c.m16344a(c2438p.m6712a(i2), iArr[i2], c2478a)) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static boolean m16344a(C2515k c2515k, int i, C2478a c2478a) {
        if (C4730c.m16342a(i, false) == 0 || c2515k.f6392r != c2478a.f6296a || c2515k.f6393s != c2478a.f6297b) {
            return false;
        }
        if (c2478a.f6298c == 0 || TextUtils.equals(c2478a.f6298c, c2515k.f6380f) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    protected C2484f m16355a(C2439q c2439q, int[][] iArr, C2480c c2480c) {
        C2439q c2439q2 = c2439q;
        C2480c c2480c2 = c2480c;
        int i = 0;
        C2438p c2438p = null;
        int i2 = 0;
        int i3 = 0;
        while (i < c2439q2.f6068b) {
            C2438p a = c2439q2.m6714a(i);
            int[] iArr2 = iArr[i];
            int i4 = i3;
            i3 = i2;
            C2438p c2438p2 = c2438p;
            for (int i5 = 0; i5 < a.f6064a; i5++) {
                if (C4730c.m16342a(iArr2[i5], c2480c2.f6319n)) {
                    int i6;
                    C2515k a2 = a.m6712a(i5);
                    Object obj = (a2.f6398x & 1) != 0 ? 1 : null;
                    Object obj2 = (a2.f6398x & 2) != 0 ? 1 : null;
                    boolean a3 = C4730c.m16345a(a2, c2480c2.f6307b);
                    if (!a3) {
                        if (!c2480c2.f6308c || !C4730c.m16343a(a2)) {
                            if (obj != null) {
                                i6 = 3;
                            } else if (obj2 != null) {
                                i6 = C4730c.m16345a(a2, c2480c2.f6306a) ? 2 : 1;
                            }
                            if (C4730c.m16342a(iArr2[i5], false)) {
                                i6 += 1000;
                            }
                            if (i6 > i4) {
                                i3 = i5;
                                c2438p2 = a;
                                i4 = i6;
                            }
                        }
                    }
                    int i7 = obj != null ? 8 : obj2 == null ? 6 : 4;
                    i6 = i7 + a3;
                    if (C4730c.m16342a(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i4) {
                        i3 = i5;
                        c2438p2 = a;
                        i4 = i6;
                    }
                }
            }
            i++;
            c2438p = c2438p2;
            i2 = i3;
            i3 = i4;
        }
        return c2438p == null ? null : new C4731d(c2438p, i2);
    }

    /* renamed from: a */
    protected C2484f m16354a(int i, C2439q c2439q, int[][] iArr, C2480c c2480c) {
        C2438p c2438p = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < c2439q.f6068b) {
            C2438p a = c2439q.m6714a(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            i4 = i3;
            C2438p c2438p2 = c2438p;
            for (int i6 = 0; i6 < a.f6064a; i6++) {
                if (C4730c.m16342a(iArr2[i6], c2480c.f6319n)) {
                    int i7 = 1;
                    if (((a.m6712a(i6).f6398x & 1) != 0 ? 1 : null) != null) {
                        i7 = 2;
                    }
                    if (C4730c.m16342a(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i5) {
                        i4 = i6;
                        c2438p2 = a;
                        i5 = i7;
                    }
                }
            }
            i2++;
            c2438p = c2438p2;
            i3 = i4;
            i4 = i5;
        }
        if (c2438p == null) {
            return null;
        }
        return new C4731d(c2438p, i3);
    }

    /* renamed from: a */
    protected static boolean m16343a(C2515k c2515k) {
        if (!TextUtils.isEmpty(c2515k.f6399y)) {
            if (C4730c.m16345a(c2515k, "und") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected static boolean m16345a(C2515k c2515k, String str) {
        return (str == null || TextUtils.equals(str, C2541v.m7186b(c2515k.f6399y)) == null) ? null : true;
    }

    /* renamed from: a */
    private static List<Integer> m16341a(C2438p c2438p, int i, int i2, boolean z) {
        List<Integer> arrayList = new ArrayList(c2438p.f6064a);
        for (int i3 = 0; i3 < c2438p.f6064a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i != Integer.MAX_VALUE) {
            if (i2 != Integer.MAX_VALUE) {
                boolean z2 = true;
                for (int i4 = 0; i4 < c2438p.f6064a; i4++) {
                    C2515k a = c2438p.m6712a(i4);
                    if (a.f6384j > 0 && a.f6385k > 0) {
                        Point a2 = C4730c.m16340a(z, i, i2, a.f6384j, a.f6385k);
                        boolean z3 = a.f6384j * a.f6385k;
                        if (a.f6384j >= ((int) (((float) a2.x) * 0.98f)) && a.f6385k >= ((int) (((float) a2.y) * 0.98f)) && z3 < z2) {
                            z2 = z3;
                        }
                    }
                }
                if (!z2) {
                    for (i = arrayList.size() - 1; i >= 0; i--) {
                        boolean a3 = c2438p.m6712a(((Integer) arrayList.get(i)).intValue()).m7005a();
                        if (a3 || a3 > z2) {
                            arrayList.remove(i);
                        }
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static Point m16340a(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (z) {
            z = false;
            boolean z2 = i3 > i4;
            if (i > i2) {
                z = true;
            }
            if (z2 != z) {
                i5 = i3 * i;
                i6 = i4 * i2;
                if (i5 < i6) {
                    return new Point(i2, C2541v.m7163a(i6, i3));
                }
                return new Point(C2541v.m7163a(i5, i4), i);
            }
        }
        int i7 = i2;
        i2 = i;
        i = i7;
        i5 = i3 * i;
        i6 = i4 * i2;
        if (i5 < i6) {
            return new Point(C2541v.m7163a(i5, i4), i);
        }
        return new Point(i2, C2541v.m7163a(i6, i3));
    }
}
