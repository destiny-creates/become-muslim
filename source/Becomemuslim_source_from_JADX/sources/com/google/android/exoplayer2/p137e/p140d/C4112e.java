package com.google.android.exoplayer2.p137e.p140d;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p137e.C4097a;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4107a;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4108b;
import com.google.android.exoplayer2.p157i.p158a.C2447g;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* compiled from: FragmentedMp4Extractor */
/* renamed from: com.google.android.exoplayer2.e.d.e */
public final class C4112e implements C2303e {
    /* renamed from: a */
    public static final C2323h f10484a = new C41111();
    /* renamed from: b */
    private static final int f10485b = C2541v.m7193g("seig");
    /* renamed from: c */
    private static final byte[] f10486c = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    /* renamed from: A */
    private long f10487A;
    /* renamed from: B */
    private C2279b f10488B;
    /* renamed from: C */
    private int f10489C;
    /* renamed from: D */
    private int f10490D;
    /* renamed from: E */
    private int f10491E;
    /* renamed from: F */
    private boolean f10492F;
    /* renamed from: G */
    private C2320g f10493G;
    /* renamed from: H */
    private C2329m f10494H;
    /* renamed from: I */
    private C2329m[] f10495I;
    /* renamed from: J */
    private boolean f10496J;
    /* renamed from: d */
    private final int f10497d;
    /* renamed from: e */
    private final C2285j f10498e;
    /* renamed from: f */
    private final List<C2515k> f10499f;
    /* renamed from: g */
    private final C2255a f10500g;
    /* renamed from: h */
    private final SparseArray<C2279b> f10501h;
    /* renamed from: i */
    private final C2529l f10502i;
    /* renamed from: j */
    private final C2529l f10503j;
    /* renamed from: k */
    private final C2529l f10504k;
    /* renamed from: l */
    private final C2529l f10505l;
    /* renamed from: m */
    private final C2529l f10506m;
    /* renamed from: n */
    private final C2537s f10507n;
    /* renamed from: o */
    private final C2529l f10508o;
    /* renamed from: p */
    private final byte[] f10509p;
    /* renamed from: q */
    private final Stack<C4107a> f10510q;
    /* renamed from: r */
    private final LinkedList<C2278a> f10511r;
    /* renamed from: s */
    private int f10512s;
    /* renamed from: t */
    private int f10513t;
    /* renamed from: u */
    private long f10514u;
    /* renamed from: v */
    private int f10515v;
    /* renamed from: w */
    private C2529l f10516w;
    /* renamed from: x */
    private long f10517x;
    /* renamed from: y */
    private int f10518y;
    /* renamed from: z */
    private long f10519z;

    /* compiled from: FragmentedMp4Extractor */
    /* renamed from: com.google.android.exoplayer2.e.d.e$a */
    private static final class C2278a {
        /* renamed from: a */
        public final long f5526a;
        /* renamed from: b */
        public final int f5527b;

        public C2278a(long j, int i) {
            this.f5526a = j;
            this.f5527b = i;
        }
    }

    /* compiled from: FragmentedMp4Extractor */
    /* renamed from: com.google.android.exoplayer2.e.d.e$b */
    private static final class C2279b {
        /* renamed from: a */
        public final C2287l f5528a = new C2287l();
        /* renamed from: b */
        public final C2329m f5529b;
        /* renamed from: c */
        public C2285j f5530c;
        /* renamed from: d */
        public C2274c f5531d;
        /* renamed from: e */
        public int f5532e;
        /* renamed from: f */
        public int f5533f;
        /* renamed from: g */
        public int f5534g;

        public C2279b(C2329m c2329m) {
            this.f5529b = c2329m;
        }

        /* renamed from: a */
        public void m6304a(C2285j c2285j, C2274c c2274c) {
            this.f5530c = (C2285j) C2516a.m7015a((Object) c2285j);
            this.f5531d = (C2274c) C2516a.m7015a((Object) c2274c);
            this.f5529b.mo2199a(c2285j.f5578f);
            m6302a();
        }

        /* renamed from: a */
        public void m6302a() {
            this.f5528a.m6325a();
            this.f5532e = 0;
            this.f5534g = 0;
            this.f5533f = 0;
        }

        /* renamed from: a */
        public void m6303a(C2255a c2255a) {
            C2286k a = this.f5530c.m6323a(this.f5528a.f5589a.f5517a);
            this.f5529b.mo2199a(this.f5530c.f5578f.m7009a(c2255a.m6233a(a != null ? a.f5585b : null)));
        }
    }

    /* compiled from: FragmentedMp4Extractor */
    /* renamed from: com.google.android.exoplayer2.e.d.e$1 */
    static class C41111 implements C2323h {
        C41111() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4112e()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4112e() {
        this(0);
    }

    public C4112e(int i) {
        this(i, null);
    }

    public C4112e(int i, C2537s c2537s) {
        this(i, c2537s, null, null);
    }

    public C4112e(int i, C2537s c2537s, C2285j c2285j, C2255a c2255a) {
        this(i, c2537s, c2285j, c2255a, Collections.emptyList());
    }

    public C4112e(int i, C2537s c2537s, C2285j c2285j, C2255a c2255a, List<C2515k> list) {
        this.f10497d = i | (c2285j != null ? 8 : 0);
        this.f10507n = c2537s;
        this.f10498e = c2285j;
        this.f10500g = c2255a;
        this.f10499f = Collections.unmodifiableList(list);
        this.f10508o = new C2529l(16);
        this.f10502i = new C2529l(C2527j.f6433a);
        this.f10503j = new C2529l(5);
        this.f10504k = new C2529l();
        this.f10505l = new C2529l(1);
        this.f10506m = new C2529l();
        this.f10509p = new byte[16];
        this.f10510q = new Stack();
        this.f10511r = new LinkedList();
        this.f10501h = new SparseArray();
        this.f10519z = -9223372036854775807L;
        this.f10487A = -9223372036854775807L;
        m12925a();
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        return C2284i.m6320a(c2304f);
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10493G = c2320g;
        if (this.f10498e != null) {
            C2279b c2279b = new C2279b(c2320g.mo2231a(0, this.f10498e.f5574b));
            c2279b.m6304a(this.f10498e, new C2274c(0, 0, 0, 0));
            this.f10501h.put(0, c2279b);
            m12939b();
            this.f10493G.mo2232a();
        }
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        j = this.f10501h.size();
        for (j2 = null; j2 < j; j2++) {
            ((C2279b) this.f10501h.valueAt(j2)).m6302a();
        }
        this.f10511r.clear();
        this.f10518y = 0;
        this.f10510q.clear();
        m12925a();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        while (true) {
            switch (this.f10512s) {
                case null:
                    if (m12944b(c2304f) != null) {
                        break;
                    }
                    return -1;
                case 1:
                    m12947c(c2304f);
                    break;
                case 2:
                    m12949d(c2304f);
                    break;
                default:
                    if (m12950e(c2304f) == null) {
                        break;
                    }
                    return null;
            }
        }
    }

    /* renamed from: a */
    private void m12925a() {
        this.f10512s = 0;
        this.f10515v = 0;
    }

    /* renamed from: b */
    private boolean m12944b(C2304f c2304f) {
        long d;
        if (this.f10515v == 0) {
            if (!c2304f.mo2184a(this.f10508o.f6441a, 0, 8, true)) {
                return false;
            }
            this.f10515v = 8;
            this.f10508o.m7096c(0);
            this.f10514u = this.f10508o.m7109m();
            this.f10513t = this.f10508o.m7111o();
        }
        if (this.f10514u == 1) {
            c2304f.mo2187b(this.f10508o.f6441a, 8, 8);
            this.f10515v += 8;
            this.f10514u = this.f10508o.m7119w();
        } else if (this.f10514u == 0) {
            d = c2304f.mo2192d();
            if (d == -1 && !this.f10510q.isEmpty()) {
                d = ((C4107a) this.f10510q.peek()).aQ;
            }
            if (d != -1) {
                this.f10514u = (d - c2304f.mo2189c()) + ((long) this.f10515v);
            }
        }
        if (this.f10514u >= ((long) this.f10515v)) {
            d = c2304f.mo2189c() - ((long) this.f10515v);
            if (this.f10513t == C2268a.f5451K) {
                int size = this.f10501h.size();
                for (int i = 0; i < size; i++) {
                    C2287l c2287l = ((C2279b) this.f10501h.valueAt(i)).f5528a;
                    c2287l.f5590b = d;
                    c2287l.f5592d = d;
                    c2287l.f5591c = d;
                }
            }
            if (this.f10513t == C2268a.f5474h) {
                this.f10488B = null;
                this.f10517x = this.f10514u + d;
                if (this.f10496J == null) {
                    this.f10493G.mo2233a(new C4154a(this.f10519z, d));
                    this.f10496J = true;
                }
                this.f10512s = 2;
                return true;
            }
            if (C4112e.m12943b(this.f10513t)) {
                long c = (c2304f.mo2189c() + this.f10514u) - 8;
                this.f10510q.add(new C4107a(this.f10513t, c));
                if (this.f10514u == ((long) this.f10515v)) {
                    m12926a(c);
                } else {
                    m12925a();
                }
            } else if (C4112e.m12937a(this.f10513t) != null) {
                if (this.f10515v != 8) {
                    throw new C2571p("Leaf atom defines extended atom size (unsupported).");
                } else if (this.f10514u <= 2147483647L) {
                    this.f10516w = new C2529l((int) this.f10514u);
                    System.arraycopy(this.f10508o.f6441a, 0, this.f10516w.f6441a, 0, 8);
                    this.f10512s = 1;
                } else {
                    throw new C2571p("Leaf atom with length > 2147483647 (unsupported).");
                }
            } else if (this.f10514u <= 2147483647L) {
                this.f10516w = null;
                this.f10512s = 1;
            } else {
                throw new C2571p("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new C2571p("Atom size less than header length (unsupported).");
    }

    /* renamed from: c */
    private void m12947c(C2304f c2304f) {
        int i = ((int) this.f10514u) - this.f10515v;
        if (this.f10516w != null) {
            c2304f.mo2187b(this.f10516w.f6441a, 8, i);
            m12930a(new C4108b(this.f10513t, this.f10516w), c2304f.mo2189c());
        } else {
            c2304f.mo2186b(i);
        }
        m12926a(c2304f.mo2189c());
    }

    /* renamed from: a */
    private void m12926a(long j) {
        while (!this.f10510q.isEmpty() && ((C4107a) this.f10510q.peek()).aQ == j) {
            m12927a((C4107a) this.f10510q.pop());
        }
        m12925a();
    }

    /* renamed from: a */
    private void m12930a(C4108b c4108b, long j) {
        if (!this.f10510q.isEmpty()) {
            ((C4107a) this.f10510q.peek()).m12909a(c4108b);
        } else if (c4108b.aP == C2268a.f5441A) {
            c4108b = C4112e.m12921a(c4108b.aQ, j);
            this.f10487A = ((Long) c4108b.first).longValue();
            this.f10493G.mo2233a((C2327l) c4108b.second);
            this.f10496J = true;
        } else if (c4108b.aP == C2268a.aG) {
            m12932a(c4108b.aQ);
        }
    }

    /* renamed from: a */
    private void m12927a(C4107a c4107a) {
        if (c4107a.aP == C2268a.f5442B) {
            m12940b(c4107a);
        } else if (c4107a.aP == C2268a.f5451K) {
            m12946c(c4107a);
        } else if (!this.f10510q.isEmpty()) {
            ((C4107a) this.f10510q.peek()).m12908a(c4107a);
        }
    }

    /* renamed from: b */
    private void m12940b(C4107a c4107a) {
        C2255a c2255a;
        C4107a c4107a2 = c4107a;
        int i = 0;
        boolean z = true;
        C2516a.m7020b(this.f10498e == null, "Unexpected moov box.");
        if (r0.f10500g != null) {
            c2255a = r0.f10500g;
        } else {
            c2255a = C4112e.m12922a(c4107a2.aR);
        }
        C4107a e = c4107a2.m12911e(C2268a.f5453M);
        SparseArray sparseArray = new SparseArray();
        int size = e.aR.size();
        long j = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            C4108b c4108b = (C4108b) e.aR.get(i2);
            if (c4108b.aP == C2268a.f5491y) {
                Pair b = C4112e.m12938b(c4108b.aQ);
                sparseArray.put(((Integer) b.first).intValue(), b.second);
            } else if (c4108b.aP == C2268a.f5454N) {
                j = C4112e.m12945c(c4108b.aQ);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c4107a2.aS.size();
        int i3 = 0;
        while (i3 < size2) {
            int i4;
            int i5;
            e = (C4107a) c4107a2.aS.get(i3);
            if (e.aP == C2268a.f5444D) {
                i4 = i3;
                i5 = size2;
                C2285j a = C2273b.m6283a(e, c4107a2.m12910d(C2268a.f5443C), j, c2255a, (r0.f10497d & 16) != 0, false);
                if (a != null) {
                    sparseArray2.put(a.f5573a, a);
                }
            } else {
                i4 = i3;
                i5 = size2;
            }
            i3 = i4 + 1;
            size2 = i5;
        }
        int size3 = sparseArray2.size();
        if (r0.f10501h.size() == 0) {
            while (i < size3) {
                C2285j c2285j = (C2285j) sparseArray2.valueAt(i);
                C2279b c2279b = new C2279b(r0.f10493G.mo2231a(i, c2285j.f5574b));
                c2279b.m6304a(c2285j, (C2274c) sparseArray.get(c2285j.f5573a));
                r0.f10501h.put(c2285j.f5573a, c2279b);
                r0.f10519z = Math.max(r0.f10519z, c2285j.f5577e);
                i++;
            }
            m12939b();
            r0.f10493G.mo2232a();
            return;
        }
        if (r0.f10501h.size() != size3) {
            z = false;
        }
        C2516a.m7019b(z);
        while (i < size3) {
            c2285j = (C2285j) sparseArray2.valueAt(i);
            ((C2279b) r0.f10501h.get(c2285j.f5573a)).m6304a(c2285j, (C2274c) sparseArray.get(c2285j.f5573a));
            i++;
        }
    }

    /* renamed from: c */
    private void m12946c(C4107a c4107a) {
        C4112e.m12928a(c4107a, this.f10501h, this.f10497d, this.f10509p);
        if (this.f10500g != null) {
            c4107a = null;
        } else {
            c4107a = C4112e.m12922a(c4107a.aR);
        }
        if (c4107a != null) {
            int size = this.f10501h.size();
            for (int i = 0; i < size; i++) {
                ((C2279b) this.f10501h.valueAt(i)).m6303a(c4107a);
            }
        }
    }

    /* renamed from: b */
    private void m12939b() {
        if ((this.f10497d & 4) != 0 && this.f10494H == null) {
            this.f10494H = this.f10493G.mo2231a(this.f10501h.size(), 4);
            this.f10494H.mo2199a(C2515k.m6983a(null, "application/x-emsg", (long) Clock.MAX_TIME));
        }
        if (this.f10495I == null) {
            this.f10495I = new C2329m[this.f10499f.size()];
            for (int i = 0; i < this.f10495I.length; i++) {
                C2329m a = this.f10493G.mo2231a((this.f10501h.size() + 1) + i, 3);
                a.mo2199a((C2515k) this.f10499f.get(i));
                this.f10495I[i] = a;
            }
        }
    }

    /* renamed from: a */
    private void m12932a(C2529l c2529l) {
        if (this.f10494H != null) {
            c2529l.m7096c(12);
            c2529l.m7121y();
            c2529l.m7121y();
            long b = C2541v.m7185b(c2529l.m7109m(), 1000000, c2529l.m7109m());
            c2529l.m7096c(12);
            int b2 = c2529l.m7093b();
            this.f10494H.mo2200a(c2529l, b2);
            if (this.f10487A != -9223372036854775807L) {
                this.f10494H.mo2198a(this.f10487A + b, 1, b2, 0, null);
            } else {
                this.f10511r.addLast(new C2278a(b, b2));
                this.f10518y += b2;
            }
        }
    }

    /* renamed from: b */
    private static Pair<Integer, C2274c> m12938b(C2529l c2529l) {
        c2529l.m7096c(12);
        return Pair.create(Integer.valueOf(c2529l.m7111o()), new C2274c(c2529l.m7117u() - 1, c2529l.m7117u(), c2529l.m7117u(), c2529l.m7111o()));
    }

    /* renamed from: c */
    private static long m12945c(C2529l c2529l) {
        c2529l.m7096c(8);
        return C2268a.m6269a(c2529l.m7111o()) == 0 ? c2529l.m7109m() : c2529l.m7119w();
    }

    /* renamed from: a */
    private static void m12928a(C4107a c4107a, SparseArray<C2279b> sparseArray, int i, byte[] bArr) {
        int size = c4107a.aS.size();
        for (int i2 = 0; i2 < size; i2++) {
            C4107a c4107a2 = (C4107a) c4107a.aS.get(i2);
            if (c4107a2.aP == C2268a.f5452L) {
                C4112e.m12941b(c4107a2, sparseArray, i, bArr);
            }
        }
    }

    /* renamed from: b */
    private static void m12941b(C4107a c4107a, SparseArray<C2279b> sparseArray, int i, byte[] bArr) {
        C2279b a = C4112e.m12924a(c4107a.m12910d(C2268a.f5490x).aQ, (SparseArray) sparseArray, i);
        if (a != null) {
            C2287l c2287l = a.f5528a;
            long j = c2287l.f5607s;
            a.m6302a();
            if (c4107a.m12910d(C2268a.f5489w) != null && (i & 2) == 0) {
                j = C4112e.m12948d(c4107a.m12910d(C2268a.f5489w).aQ);
            }
            C4112e.m12929a(c4107a, a, j, i);
            C2286k a2 = a.f5530c.m6323a(c2287l.f5589a.f5517a);
            i = c4107a.m12910d(C2268a.ac);
            if (i != 0) {
                C4112e.m12931a(a2, i.aQ, c2287l);
            }
            i = c4107a.m12910d(C2268a.ad);
            if (i != 0) {
                C4112e.m12934a(i.aQ, c2287l);
            }
            i = c4107a.m12910d(C2268a.ah);
            if (i != 0) {
                C4112e.m12942b(i.aQ, c2287l);
            }
            i = c4107a.m12910d(C2268a.ae);
            C4108b d = c4107a.m12910d(C2268a.af);
            if (!(i == 0 || d == null)) {
                C4112e.m12936a(i.aQ, d.aQ, a2 != null ? a2.f5585b : null, c2287l);
            }
            sparseArray = c4107a.aR.size();
            for (i = 0; i < sparseArray; i++) {
                d = (C4108b) c4107a.aR.get(i);
                if (d.aP == C2268a.ag) {
                    C4112e.m12935a(d.aQ, c2287l, bArr);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12929a(C4107a c4107a, C2279b c2279b, long j, int i) {
        c4107a = c4107a.aR;
        int size = c4107a.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            C4108b c4108b = (C4108b) c4107a.get(i5);
            if (c4108b.aP == C2268a.f5492z) {
                C2529l c2529l = c4108b.aQ;
                c2529l.m7096c(12);
                int u = c2529l.m7117u();
                if (u > 0) {
                    i4 += u;
                    i3++;
                }
            }
        }
        c2279b.f5534g = 0;
        c2279b.f5533f = 0;
        c2279b.f5532e = 0;
        c2279b.f5528a.m6327a(i3, i4);
        i3 = 0;
        int i6 = 0;
        while (i2 < size) {
            C4108b c4108b2 = (C4108b) c4107a.get(i2);
            if (c4108b2.aP == C2268a.f5492z) {
                int i7 = i3 + 1;
                i6 = C4112e.m12920a(c2279b, i3, j, i, c4108b2.aQ, i6);
                i3 = i7;
            }
            i2++;
        }
    }

    /* renamed from: a */
    private static void m12931a(C2286k c2286k, C2529l c2529l, C2287l c2287l) {
        c2286k = c2286k.f5587d;
        c2529l.m7096c(8);
        boolean z = true;
        if ((C2268a.m6270b(c2529l.m7111o()) & 1) == 1) {
            c2529l.m7098d(8);
        }
        int g = c2529l.m7103g();
        int u = c2529l.m7117u();
        if (u == c2287l.f5594f) {
            int i;
            if (g == 0) {
                boolean[] zArr = c2287l.f5602n;
                i = 0;
                for (int i2 = 0; i2 < u; i2++) {
                    int g2 = c2529l.m7103g();
                    i += g2;
                    zArr[i2] = g2 > c2286k;
                }
            } else {
                if (g <= c2286k) {
                    z = false;
                }
                i = (g * u) + 0;
                Arrays.fill(c2287l.f5602n, 0, u, z);
            }
            c2287l.m6326a(i);
            return;
        }
        c2529l = new StringBuilder();
        c2529l.append("Length mismatch: ");
        c2529l.append(u);
        c2529l.append(", ");
        c2529l.append(c2287l.f5594f);
        throw new C2571p(c2529l.toString());
    }

    /* renamed from: a */
    private static void m12934a(C2529l c2529l, C2287l c2287l) {
        c2529l.m7096c(8);
        int o = c2529l.m7111o();
        if ((C2268a.m6270b(o) & 1) == 1) {
            c2529l.m7098d(8);
        }
        int u = c2529l.m7117u();
        if (u == 1) {
            long m;
            u = C2268a.m6269a(o);
            long j = c2287l.f5592d;
            if (u == 0) {
                m = c2529l.m7109m();
            } else {
                m = c2529l.m7119w();
            }
            c2287l.f5592d = j + m;
            return;
        }
        c2287l = new StringBuilder();
        c2287l.append("Unexpected saio entry count: ");
        c2287l.append(u);
        throw new C2571p(c2287l.toString());
    }

    /* renamed from: a */
    private static C2279b m12924a(C2529l c2529l, SparseArray<C2279b> sparseArray, int i) {
        c2529l.m7096c(8);
        int b = C2268a.m6270b(c2529l.m7111o());
        int o = c2529l.m7111o();
        if ((i & 8) != 0) {
            o = 0;
        }
        C2279b c2279b = (C2279b) sparseArray.get(o);
        if (c2279b == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long w = c2529l.m7119w();
            c2279b.f5528a.f5591c = w;
            c2279b.f5528a.f5592d = w;
        }
        i = c2279b.f5531d;
        c2279b.f5528a.f5589a = new C2274c((b & 2) != 0 ? c2529l.m7117u() - 1 : i.f5517a, (b & 8) != 0 ? c2529l.m7117u() : i.f5518b, (b & 16) != 0 ? c2529l.m7117u() : i.f5519c, (b & 32) != 0 ? c2529l.m7117u() : i.f5520d);
        return c2279b;
    }

    /* renamed from: d */
    private static long m12948d(C2529l c2529l) {
        c2529l.m7096c(8);
        return C2268a.m6269a(c2529l.m7111o()) == 1 ? c2529l.m7119w() : c2529l.m7109m();
    }

    /* renamed from: a */
    private static int m12920a(C2279b c2279b, int i, long j, int i2, C2529l c2529l, int i3) {
        long[] jArr;
        long j2;
        long j3;
        C2279b c2279b2 = c2279b;
        c2529l.m7096c(8);
        int b = C2268a.m6270b(c2529l.m7111o());
        C2285j c2285j = c2279b2.f5530c;
        C2287l c2287l = c2279b2.f5528a;
        C2274c c2274c = c2287l.f5589a;
        c2287l.f5596h[i] = c2529l.m7117u();
        c2287l.f5595g[i] = c2287l.f5591c;
        if ((b & 1) != 0) {
            long[] jArr2 = c2287l.f5595g;
            jArr2[i] = jArr2[i] + ((long) c2529l.m7111o());
        }
        Object obj = (b & 4) != 0 ? 1 : null;
        int i4 = c2274c.f5520d;
        if (obj != null) {
            i4 = c2529l.m7117u();
        }
        Object obj2 = (b & 256) != 0 ? 1 : null;
        Object obj3 = (b & 512) != 0 ? 1 : null;
        Object obj4 = (b & 1024) != 0 ? 1 : null;
        Object obj5 = (b & 2048) != 0 ? 1 : null;
        long j4 = 0;
        if (c2285j.f5580h != null && c2285j.f5580h.length == 1 && c2285j.f5580h[0] == 0) {
            j4 = C2541v.m7185b(c2285j.f5581i[0], 1000, c2285j.f5575c);
        }
        int[] iArr = c2287l.f5597i;
        int[] iArr2 = c2287l.f5598j;
        long[] jArr3 = c2287l.f5599k;
        int i5 = i4;
        boolean[] zArr = c2287l.f5600l;
        Object obj6 = (c2285j.f5574b != 2 || (i2 & 1) == 0) ? null : 1;
        i4 = i3 + c2287l.f5596h[i];
        Object obj7 = obj6;
        long j5 = c2285j.f5575c;
        if (i > 0) {
            jArr = jArr3;
            j2 = j4;
            j3 = c2287l.f5607s;
        } else {
            jArr = jArr3;
            j2 = j4;
            j3 = j;
        }
        int i6 = i3;
        while (i6 < i4) {
            Object obj8;
            int u;
            Object obj9;
            int i7;
            C2274c c2274c2;
            int u2 = obj2 != null ? c2529l.m7117u() : c2274c.f5518b;
            if (obj3 != null) {
                obj8 = obj2;
                u = c2529l.m7117u();
            } else {
                obj8 = obj2;
                u = c2274c.f5519c;
            }
            if (i6 == 0 && obj != null) {
                obj9 = obj;
                i7 = i5;
            } else if (obj4 != null) {
                i7 = c2529l.m7111o();
                obj9 = obj;
            } else {
                obj9 = obj;
                i7 = c2274c.f5520d;
            }
            if (obj5 != null) {
                c2274c2 = c2274c;
                iArr2[i6] = (int) ((((long) c2529l.m7111o()) * 1000) / j5);
            } else {
                c2274c2 = c2274c;
                iArr2[i6] = 0;
            }
            jArr[i6] = C2541v.m7185b(j3, 1000, j5) - j2;
            iArr[i6] = u;
            boolean z = ((i7 >> 16) & 1) == 0 && (obj7 == null || i6 == 0);
            zArr[i6] = z;
            j3 += (long) u2;
            i6++;
            obj2 = obj8;
            obj = obj9;
            c2274c = c2274c2;
        }
        c2287l.f5607s = j3;
        return i4;
    }

    /* renamed from: a */
    private static void m12935a(C2529l c2529l, C2287l c2287l, byte[] bArr) {
        c2529l.m7096c(8);
        c2529l.m7092a(bArr, 0, 16);
        if (Arrays.equals(bArr, f10486c) != null) {
            C4112e.m12933a(c2529l, 16, c2287l);
        }
    }

    /* renamed from: b */
    private static void m12942b(C2529l c2529l, C2287l c2287l) {
        C4112e.m12933a(c2529l, 0, c2287l);
    }

    /* renamed from: a */
    private static void m12933a(C2529l c2529l, int i, C2287l c2287l) {
        c2529l.m7096c(i + 8);
        i = C2268a.m6270b(c2529l.m7111o());
        if ((i & 1) == 0) {
            i = (i & 2) != 0 ? 1 : 0;
            int u = c2529l.m7117u();
            if (u == c2287l.f5594f) {
                Arrays.fill(c2287l.f5602n, 0, u, i);
                c2287l.m6326a(c2529l.m7093b());
                c2287l.m6329a(c2529l);
                return;
            }
            i = new StringBuilder();
            i.append("Length mismatch: ");
            i.append(u);
            i.append(", ");
            i.append(c2287l.f5594f);
            throw new C2571p(i.toString());
        }
        throw new C2571p("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* renamed from: a */
    private static void m12936a(C2529l c2529l, C2529l c2529l2, String str, C2287l c2287l) {
        c2529l.m7096c(8);
        int o = c2529l.m7111o();
        if (c2529l.m7111o() == f10485b) {
            if (C2268a.m6269a(o) == 1) {
                c2529l.m7098d(4);
            }
            if (c2529l.m7111o() == 1) {
                c2529l2.m7096c(8);
                c2529l = c2529l2.m7111o();
                if (c2529l2.m7111o() == f10485b) {
                    c2529l = C2268a.m6269a(c2529l);
                    if (c2529l == 1) {
                        if (c2529l2.m7109m() == 0) {
                            throw new C2571p("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (c2529l >= 2) {
                        c2529l2.m7098d(4);
                    }
                    if (c2529l2.m7109m() == 1) {
                        c2529l2.m7098d(1);
                        c2529l = c2529l2.m7103g();
                        int i = (c2529l & 240) >> 4;
                        int i2 = c2529l & 15;
                        boolean z = c2529l2.m7103g() == 1;
                        if (z) {
                            byte[] bArr;
                            int g = c2529l2.m7103g();
                            byte[] bArr2 = new byte[16];
                            c2529l2.m7092a(bArr2, 0, bArr2.length);
                            if (z && g == 0) {
                                c2529l = c2529l2.m7103g();
                                byte[] bArr3 = new byte[c2529l];
                                c2529l2.m7092a(bArr3, 0, c2529l);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            c2287l.f5601m = true;
                            c2287l.f5603o = new C2286k(z, str, g, bArr2, i, i2, bArr);
                            return;
                        }
                        return;
                    }
                    throw new C2571p("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new C2571p("Entry count in sbgp != 1 (unsupported).");
        }
    }

    /* renamed from: a */
    private static Pair<Long, C4097a> m12921a(C2529l c2529l, long j) {
        long m;
        long m2;
        C2529l c2529l2 = c2529l;
        c2529l2.m7096c(8);
        int a = C2268a.m6269a(c2529l.m7111o());
        c2529l2.m7098d(4);
        long m3 = c2529l.m7109m();
        if (a == 0) {
            m = c2529l.m7109m();
            m2 = j + c2529l.m7109m();
        } else {
            m = c2529l.m7119w();
            m2 = j + c2529l.m7119w();
        }
        long j2 = m2;
        m2 = m;
        long b = C2541v.m7185b(m2, 1000000, m3);
        c2529l2.m7098d(2);
        a = c2529l.m7104h();
        int[] iArr = new int[a];
        long[] jArr = new long[a];
        long[] jArr2 = new long[a];
        long[] jArr3 = new long[a];
        long j3 = m2;
        m = b;
        int i = 0;
        while (i < a) {
            int o = c2529l.m7111o();
            if ((o & LinearLayoutManager.INVALID_OFFSET) == 0) {
                long m4 = c2529l.m7109m();
                iArr[i] = o & Integer.MAX_VALUE;
                jArr[i] = j2;
                jArr3[i] = m;
                j3 += m4;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i2 = a;
                int[] iArr2 = iArr;
                long[] jArr6 = jArr;
                m = C2541v.m7185b(j3, 1000000, m3);
                jArr4[i] = m - jArr5[i];
                c2529l2.m7098d(4);
                j2 += (long) iArr2[i];
                i++;
                jArr2 = jArr4;
                iArr = iArr2;
                jArr3 = jArr5;
                a = i2;
                jArr = jArr6;
            } else {
                throw new C2571p("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(b), new C4097a(iArr, jArr, jArr2, jArr3));
    }

    /* renamed from: d */
    private void m12949d(C2304f c2304f) {
        int size = this.f10501h.size();
        C2279b c2279b = null;
        long j = Clock.MAX_TIME;
        for (int i = 0; i < size; i++) {
            C2287l c2287l = ((C2279b) this.f10501h.valueAt(i)).f5528a;
            if (c2287l.f5606r && c2287l.f5592d < j) {
                long j2 = c2287l.f5592d;
                c2279b = (C2279b) this.f10501h.valueAt(i);
                j = j2;
            }
        }
        if (c2279b == null) {
            this.f10512s = 3;
            return;
        }
        size = (int) (j - c2304f.mo2189c());
        if (size >= 0) {
            c2304f.mo2186b(size);
            c2279b.f5528a.m6328a(c2304f);
            return;
        }
        throw new C2571p("Offset to encryption data was negative.");
    }

    /* renamed from: e */
    private boolean m12950e(C2304f c2304f) {
        int i;
        C2328a c2328a;
        C2304f c2304f2 = c2304f;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.f10512s == 3) {
            if (r0.f10488B == null) {
                C2279b a = C4112e.m12923a(r0.f10501h);
                if (a == null) {
                    int c = (int) (r0.f10517x - c2304f.mo2189c());
                    if (c >= 0) {
                        c2304f2.mo2186b(c);
                        m12925a();
                        return false;
                    }
                    throw new C2571p("Offset to end of mdat was negative.");
                }
                int c2 = (int) (a.f5528a.f5595g[a.f5534g] - c2304f.mo2189c());
                if (c2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    c2 = 0;
                }
                c2304f2.mo2186b(c2);
                r0.f10488B = a;
            }
            r0.f10489C = r0.f10488B.f5528a.f5597i[r0.f10488B.f5532e];
            if (r0.f10488B.f5528a.f5601m) {
                r0.f10490D = m12919a(r0.f10488B);
                r0.f10489C += r0.f10490D;
            } else {
                r0.f10490D = 0;
            }
            if (r0.f10488B.f5530c.f5579g == 1) {
                r0.f10489C -= 8;
                c2304f2.mo2186b(8);
            }
            r0.f10512s = 4;
            r0.f10491E = 0;
        }
        C2287l c2287l = r0.f10488B.f5528a;
        C2285j c2285j = r0.f10488B.f5530c;
        C2329m c2329m = r0.f10488B.f5529b;
        int i5 = r0.f10488B.f5532e;
        if (c2285j.f5582j != 0) {
            byte[] bArr = r0.f10503j.f6441a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i6 = c2285j.f5582j + 1;
            int i7 = 4 - c2285j.f5582j;
            while (r0.f10490D < r0.f10489C) {
                if (r0.f10491E == 0) {
                    c2304f2.mo2187b(bArr, i7, i6);
                    r0.f10503j.m7096c(i4);
                    r0.f10491E = r0.f10503j.m7117u() - i3;
                    r0.f10502i.m7096c(i4);
                    c2329m.mo2200a(r0.f10502i, i2);
                    c2329m.mo2200a(r0.f10503j, i3);
                    boolean z = r0.f10495I.length > 0 && C2527j.m7066a(c2285j.f5578f.f6380f, bArr[i2]);
                    r0.f10492F = z;
                    r0.f10490D += 5;
                    r0.f10489C += i7;
                } else {
                    int i8;
                    if (r0.f10492F) {
                        r0.f10504k.m7089a(r0.f10491E);
                        c2304f2.mo2187b(r0.f10504k.f6441a, i4, r0.f10491E);
                        c2329m.mo2200a(r0.f10504k, r0.f10491E);
                        i8 = r0.f10491E;
                        i2 = C2527j.m7060a(r0.f10504k.f6441a, r0.f10504k.m7095c());
                        r0.f10504k.m7096c("video/hevc".equals(c2285j.f5578f.f6380f));
                        r0.f10504k.m7094b(i2);
                        C2447g.m6765a(c2287l.m6330b(i5) * 1000, r0.f10504k, r0.f10495I);
                    } else {
                        i8 = c2329m.mo2197a(c2304f2, r0.f10491E, false);
                    }
                    r0.f10490D += i8;
                    r0.f10491E -= i8;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        } else {
            while (r0.f10490D < r0.f10489C) {
                r0.f10490D += c2329m.mo2197a(c2304f2, r0.f10489C - r0.f10490D, false);
            }
        }
        long b = c2287l.m6330b(i5) * 1000;
        if (r0.f10507n != null) {
            b = r0.f10507n.m7151c(b);
        }
        boolean z2 = c2287l.f5600l[i5];
        if (c2287l.f5601m) {
            C2286k c2286k;
            int i9 = z2 | 1073741824;
            if (c2287l.f5603o != null) {
                c2286k = c2287l.f5603o;
            } else {
                c2286k = c2285j.m6323a(c2287l.f5589a.f5517a);
            }
            i = i9;
            c2328a = c2286k.f5586c;
        } else {
            i = z2;
            c2328a = null;
        }
        c2329m.mo2198a(b, i, r0.f10489C, 0, c2328a);
        while (!r0.f10511r.isEmpty()) {
            C2278a c2278a = (C2278a) r0.f10511r.removeFirst();
            r0.f10518y -= c2278a.f5527b;
            r0.f10494H.mo2198a(c2278a.f5526a + b, 1, c2278a.f5527b, r0.f10518y, null);
        }
        C2279b c2279b = r0.f10488B;
        c2279b.f5532e++;
        c2279b = r0.f10488B;
        c2279b.f5533f++;
        if (r0.f10488B.f5533f == c2287l.f5596h[r0.f10488B.f5534g]) {
            c2279b = r0.f10488B;
            c2279b.f5534g++;
            r0.f10488B.f5533f = 0;
            r0.f10488B = null;
        }
        r0.f10512s = 3;
        return true;
    }

    /* renamed from: a */
    private static C2279b m12923a(SparseArray<C2279b> sparseArray) {
        int size = sparseArray.size();
        C2279b c2279b = null;
        long j = Clock.MAX_TIME;
        for (int i = 0; i < size; i++) {
            C2279b c2279b2 = (C2279b) sparseArray.valueAt(i);
            if (c2279b2.f5534g != c2279b2.f5528a.f5593e) {
                long j2 = c2279b2.f5528a.f5595g[c2279b2.f5534g];
                if (j2 < j) {
                    c2279b = c2279b2;
                    j = j2;
                }
            }
        }
        return c2279b;
    }

    /* renamed from: a */
    private int m12919a(C2279b c2279b) {
        C2286k c2286k;
        C2529l c2529l;
        C2287l c2287l = c2279b.f5528a;
        int i = c2287l.f5589a.f5517a;
        if (c2287l.f5603o != null) {
            c2286k = c2287l.f5603o;
        } else {
            c2286k = c2279b.f5530c.m6323a(i);
        }
        if (c2286k.f5587d != 0) {
            c2529l = c2287l.f5605q;
            i = c2286k.f5587d;
        } else {
            byte[] bArr = c2286k.f5588e;
            this.f10506m.m7091a(bArr, bArr.length);
            c2529l = this.f10506m;
            i = bArr.length;
        }
        boolean z = c2287l.f5602n[c2279b.f5532e];
        this.f10505l.f6441a[0] = (byte) ((z ? 128 : 0) | i);
        this.f10505l.m7096c(0);
        c2279b = c2279b.f5529b;
        c2279b.mo2200a(this.f10505l, 1);
        c2279b.mo2200a(c2529l, i);
        if (!z) {
            return i + 1;
        }
        C2529l c2529l2 = c2287l.f5605q;
        int h = c2529l2.m7104h();
        c2529l2.m7098d(-2);
        h = (h * 6) + 2;
        c2279b.mo2200a(c2529l2, h);
        return (i + 1) + h;
    }

    /* renamed from: a */
    private static C2255a m12922a(List<C4108b> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            C4108b c4108b = (C4108b) list.get(i);
            if (c4108b.aP == C2268a.f5461U) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = c4108b.aQ.f6441a;
                UUID a = C2283h.m6315a(bArr);
                if (a == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    list2.add(new C2254a(a, "video/mp4", bArr));
                }
            }
        }
        if (list2 == null) {
            return null;
        }
        return new C2255a(list2);
    }

    /* renamed from: a */
    private static boolean m12937a(int i) {
        if (!(i == C2268a.f5459S || i == C2268a.f5458R || i == C2268a.f5443C || i == C2268a.f5441A || i == C2268a.f5460T || i == C2268a.f5489w || i == C2268a.f5490x || i == C2268a.f5455O || i == C2268a.f5491y || i == C2268a.f5492z || i == C2268a.f5461U || i == C2268a.ac || i == C2268a.ad || i == C2268a.ah || i == C2268a.ag || i == C2268a.ae || i == C2268a.af || i == C2268a.f5457Q || i == C2268a.f5454N)) {
            if (i != C2268a.aG) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m12943b(int i) {
        if (!(i == C2268a.f5442B || i == C2268a.f5444D || i == C2268a.f5445E || i == C2268a.f5446F || i == C2268a.f5447G || i == C2268a.f5451K || i == C2268a.f5452L || i == C2268a.f5453M)) {
            if (i != C2268a.f5456P) {
                return false;
            }
        }
        return true;
    }
}
