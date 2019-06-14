package com.google.android.exoplayer2.p149h.p153c;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2437n;
import com.google.android.exoplayer2.p149h.C2437n.C2436a;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4220l;
import com.google.android.exoplayer2.p149h.C4220l.C2434b;
import com.google.android.exoplayer2.p149h.p150a.C4168c;
import com.google.android.exoplayer2.p149h.p153c.C2404d.C2403b;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4251s.C2509d;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/* compiled from: HlsSampleStreamWrapper */
/* renamed from: com.google.android.exoplayer2.h.c.l */
final class C4201l implements C2320g, C2434b, C2437n, C2506a<C4168c>, C2509d {
    /* renamed from: A */
    private long f10990A;
    /* renamed from: B */
    private boolean f10991B;
    /* renamed from: C */
    private boolean f10992C;
    /* renamed from: D */
    private boolean f10993D;
    /* renamed from: a */
    private final int f10994a;
    /* renamed from: b */
    private final C4200a f10995b;
    /* renamed from: c */
    private final C2404d f10996c;
    /* renamed from: d */
    private final C2492b f10997d;
    /* renamed from: e */
    private final C2515k f10998e;
    /* renamed from: f */
    private final int f10999f;
    /* renamed from: g */
    private final C4251s f11000g = new C4251s("Loader:HlsSampleStreamWrapper");
    /* renamed from: h */
    private final C2429a f11001h;
    /* renamed from: i */
    private final C2403b f11002i = new C2403b();
    /* renamed from: j */
    private final LinkedList<C4856h> f11003j = new LinkedList();
    /* renamed from: k */
    private final Runnable f11004k = new C24081(this);
    /* renamed from: l */
    private final Handler f11005l = new Handler();
    /* renamed from: m */
    private C4220l[] f11006m = new C4220l[0];
    /* renamed from: n */
    private int[] f11007n = new int[0];
    /* renamed from: o */
    private boolean f11008o;
    /* renamed from: p */
    private boolean f11009p;
    /* renamed from: q */
    private int f11010q;
    /* renamed from: r */
    private C2515k f11011r;
    /* renamed from: s */
    private boolean f11012s;
    /* renamed from: t */
    private C2439q f11013t;
    /* renamed from: u */
    private int f11014u;
    /* renamed from: v */
    private boolean f11015v;
    /* renamed from: w */
    private boolean[] f11016w;
    /* renamed from: x */
    private boolean[] f11017x;
    /* renamed from: y */
    private long f11018y;
    /* renamed from: z */
    private long f11019z;

    /* compiled from: HlsSampleStreamWrapper */
    /* renamed from: com.google.android.exoplayer2.h.c.l$1 */
    class C24081 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4201l f5939a;

        C24081(C4201l c4201l) {
            this.f5939a = c4201l;
        }

        public void run() {
            this.f5939a.m13538l();
        }
    }

    /* compiled from: HlsSampleStreamWrapper */
    /* renamed from: com.google.android.exoplayer2.h.c.l$a */
    public interface C4200a extends C2436a<C4201l> {
        /* renamed from: a */
        void mo3219a(C2394a c2394a);

        /* renamed from: g */
        void mo3221g();
    }

    /* renamed from: a */
    public void mo2233a(C2327l c2327l) {
    }

    /* renamed from: a */
    public /* synthetic */ C2329m mo2231a(int i, int i2) {
        return m13560b(i, i2);
    }

    public C4201l(int i, C4200a c4200a, C2404d c2404d, C2492b c2492b, long j, C2515k c2515k, int i2, C2429a c2429a) {
        this.f10994a = i;
        this.f10995b = c4200a;
        this.f10996c = c2404d;
        this.f10997d = c2492b;
        this.f10998e = c2515k;
        this.f10999f = i2;
        this.f11001h = c2429a;
        this.f11019z = j;
        this.f10990A = j;
    }

    /* renamed from: b */
    public void m13561b() {
        if (!this.f11009p) {
            mo2241c(this.f11019z);
        }
    }

    /* renamed from: b */
    public void m13563b(C2515k c2515k) {
        m13560b(0, -1).mo2199a(c2515k);
        this.f11008o = true;
        m13538l();
    }

    /* renamed from: c */
    public void m13564c() {
        m13571i();
    }

    /* renamed from: f */
    public C2439q m13568f() {
        return this.f11013t;
    }

    /* renamed from: a */
    public boolean m13559a(C2484f[] c2484fArr, boolean[] zArr, C2435m[] c2435mArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        Object c;
        boolean z3;
        C2484f c2484f;
        C2484f c2484f2;
        int a;
        C4220l[] c4220lArr;
        int length;
        long j2;
        C2484f c2484f3;
        Object obj;
        boolean z4;
        C2484f[] c2484fArr2 = c2484fArr;
        C2435m[] c2435mArr2 = c2435mArr;
        long j3 = j;
        C2516a.m7019b(this.f11009p);
        int i = this.f11010q;
        int i2 = 0;
        int i3 = 0;
        while (i3 < c2484fArr2.length) {
            if (c2435mArr2[i3] != null && (c2484fArr2[i3] == null || !zArr[i3])) {
                m13534b(((C4199k) c2435mArr2[i3]).f10988a, false);
                c2435mArr2[i3] = null;
            }
            i3++;
        }
        if (!z) {
            if (r0.f10992C) {
                if (i == 0) {
                }
            } else if (j3 != r0.f11019z) {
            }
            z2 = false;
            c = r0.f10996c.m6625c();
            z3 = z2;
            c2484f = c;
            i = 0;
            while (i < c2484fArr2.length) {
                if (c2435mArr2[i] == null && c2484fArr2[i] != null) {
                    c2484f2 = c2484fArr2[i];
                    a = r0.f11013t.m6713a(c2484f2.mo2305f());
                    m13534b(a, true);
                    if (a == r0.f11014u) {
                        r0.f10996c.m6621a(c2484f2);
                        c2484f = c2484f2;
                    }
                    c2435mArr2[i] = new C4199k(r0, a);
                    zArr2[i] = true;
                    if (!z3) {
                        C4220l c4220l = r0.f11006m[a];
                        c4220l.m13681i();
                        z3 = (c4220l.m13672b(j3, true, true) == -1 || c4220l.m13677e() == 0) ? false : true;
                    }
                }
                i++;
            }
            if (r0.f11010q != 0) {
                r0.f10996c.m6626d();
                r0.f11011r = null;
                r0.f11003j.clear();
                if (r0.f11000g.m13799a()) {
                    m13537k();
                } else {
                    c4220lArr = r0.f11006m;
                    length = c4220lArr.length;
                    while (i2 < length) {
                        c4220lArr[i2].m13683k();
                        i2++;
                    }
                    r0.f11000g.m13801b();
                }
            } else {
                if (!(r0.f11003j.isEmpty() || C2541v.m7179a((Object) c2484f, c))) {
                    if (!r0.f10992C) {
                        j2 = 0;
                        if (j3 < 0) {
                            j2 = -j3;
                        }
                        c2484f3 = c2484f;
                        c2484f.mo3216a(j, j2, -9223372036854775807L);
                        if (c2484f3.mo2308i() != r0.f10996c.m6624b().m6711a(((C4856h) r0.f11003j.getLast()).c)) {
                            obj = null;
                            if (obj != null) {
                                r0.f10991B = true;
                                z4 = true;
                                z3 = true;
                                if (z3) {
                                    m13558a(j3, z4);
                                    while (i2 < c2435mArr2.length) {
                                        if (c2435mArr2[i2] == null) {
                                            zArr2[i2] = true;
                                        }
                                        i2++;
                                    }
                                }
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        r0.f10991B = true;
                        z4 = true;
                        z3 = true;
                        if (z3) {
                            m13558a(j3, z4);
                            while (i2 < c2435mArr2.length) {
                                if (c2435mArr2[i2] == null) {
                                    zArr2[i2] = true;
                                }
                                i2++;
                            }
                        }
                    }
                }
                z4 = z;
                if (z3) {
                    m13558a(j3, z4);
                    while (i2 < c2435mArr2.length) {
                        if (c2435mArr2[i2] == null) {
                            zArr2[i2] = true;
                        }
                        i2++;
                    }
                }
            }
            r0.f10992C = true;
            return z3;
        }
        z2 = true;
        c = r0.f10996c.m6625c();
        z3 = z2;
        c2484f = c;
        i = 0;
        while (i < c2484fArr2.length) {
            c2484f2 = c2484fArr2[i];
            a = r0.f11013t.m6713a(c2484f2.mo2305f());
            m13534b(a, true);
            if (a == r0.f11014u) {
                r0.f10996c.m6621a(c2484f2);
                c2484f = c2484f2;
            }
            c2435mArr2[i] = new C4199k(r0, a);
            zArr2[i] = true;
            if (!z3) {
                C4220l c4220l2 = r0.f11006m[a];
                c4220l2.m13681i();
                if (c4220l2.m13672b(j3, true, true) == -1) {
                }
            }
            i++;
        }
        if (r0.f11010q != 0) {
            if (r0.f10992C) {
                j2 = 0;
                if (j3 < 0) {
                    j2 = -j3;
                }
                c2484f3 = c2484f;
                c2484f.mo3216a(j, j2, -9223372036854775807L);
                if (c2484f3.mo2308i() != r0.f10996c.m6624b().m6711a(((C4856h) r0.f11003j.getLast()).c)) {
                    obj = null;
                    if (obj != null) {
                        r0.f10991B = true;
                        z4 = true;
                        z3 = true;
                        if (z3) {
                            m13558a(j3, z4);
                            while (i2 < c2435mArr2.length) {
                                if (c2435mArr2[i2] == null) {
                                    zArr2[i2] = true;
                                }
                                i2++;
                            }
                        }
                    }
                    z4 = z;
                    if (z3) {
                        m13558a(j3, z4);
                        while (i2 < c2435mArr2.length) {
                            if (c2435mArr2[i2] == null) {
                                zArr2[i2] = true;
                            }
                            i2++;
                        }
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                r0.f10991B = true;
                z4 = true;
                z3 = true;
                if (z3) {
                    m13558a(j3, z4);
                    while (i2 < c2435mArr2.length) {
                        if (c2435mArr2[i2] == null) {
                            zArr2[i2] = true;
                        }
                        i2++;
                    }
                }
            }
            z4 = z;
            if (z3) {
                m13558a(j3, z4);
                while (i2 < c2435mArr2.length) {
                    if (c2435mArr2[i2] == null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
        } else {
            r0.f10996c.m6626d();
            r0.f11011r = null;
            r0.f11003j.clear();
            if (r0.f11000g.m13799a()) {
                m13537k();
            } else {
                c4220lArr = r0.f11006m;
                length = c4220lArr.length;
                while (i2 < length) {
                    c4220lArr[i2].m13683k();
                    i2++;
                }
                r0.f11000g.m13801b();
            }
        }
        r0.f10992C = true;
        return z3;
    }

    /* renamed from: a */
    public void m13548a(long j) {
        int length = this.f11006m.length;
        for (int i = 0; i < length; i++) {
            this.f11006m[i].m13667a(j, false, this.f11016w[i]);
        }
    }

    /* renamed from: a */
    public boolean m13558a(long j, boolean z) {
        this.f11019z = j;
        if (!z && !m13540n() && m13535d(j)) {
            return false;
        }
        this.f10990A = j;
        this.f10993D = false;
        this.f11003j.clear();
        if (this.f11000g.m13799a() != null) {
            this.f11000g.m13801b();
        } else {
            m13537k();
        }
        return 1;
    }

    /* renamed from: d */
    public long mo2242d() {
        if (this.f10993D) {
            return Long.MIN_VALUE;
        }
        if (m13540n()) {
            return this.f10990A;
        }
        long j = this.f11019z;
        C4856h c4856h = (C4856h) this.f11003j.getLast();
        if (!c4856h.mo3423h()) {
            c4856h = this.f11003j.size() > 1 ? (C4856h) this.f11003j.get(this.f11003j.size() - 2) : null;
        }
        if (c4856h != null) {
            j = Math.max(j, c4856h.g);
        }
        for (C4220l h : this.f11006m) {
            j = Math.max(j, h.m13680h());
        }
        return j;
    }

    /* renamed from: h */
    public void m13570h() {
        boolean a = this.f11000g.m13800a((C2509d) this);
        if (this.f11009p && !a) {
            for (C4220l k : this.f11006m) {
                k.m13683k();
            }
        }
        this.f11005l.removeCallbacksAndMessages(null);
        this.f11012s = true;
    }

    /* renamed from: g */
    public void mo2244g() {
        m13537k();
    }

    /* renamed from: a */
    public void m13556a(boolean z) {
        this.f10996c.m6622a(z);
    }

    /* renamed from: a */
    public void m13552a(C2394a c2394a, long j) {
        this.f10996c.m6619a(c2394a, j);
    }

    /* renamed from: a */
    public boolean m13557a(int i) {
        if (!this.f10993D) {
            if (m13540n() || this.f11006m[i].m13676d() == 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public void m13571i() {
        this.f11000g.mo2322d();
        this.f10996c.m6617a();
    }

    /* renamed from: a */
    public int m13542a(int i, C2543l c2543l, C4085e c4085e, boolean z) {
        if (m13540n()) {
            return -3;
        }
        i = this.f11006m[i].m13662a(c2543l, c4085e, z, this.f10993D, this.f11019z);
        if (i == -4) {
            m13536j();
        }
        return i;
    }

    /* renamed from: a */
    public int m13541a(int i, long j) {
        int i2 = 0;
        if (m13540n()) {
            return 0;
        }
        i = this.f11006m[i];
        if (!this.f10993D || j <= i.m13680h()) {
            i = i.m13672b(j, true, true);
            if (i != -1) {
                i2 = i;
            }
        } else {
            i2 = i.m13684l();
        }
        if (i2 > 0) {
            m13536j();
        }
        return i2;
    }

    /* renamed from: j */
    private void m13536j() {
        if (!this.f11003j.isEmpty()) {
            while (this.f11003j.size() > 1 && m13532a((C4856h) this.f11003j.getFirst())) {
                this.f11003j.removeFirst();
            }
            C4856h c4856h = (C4856h) this.f11003j.getFirst();
            C2515k c2515k = c4856h.c;
            if (!c2515k.equals(this.f11011r)) {
                this.f11001h.m6667a(this.f10994a, c2515k, c4856h.d, c4856h.e, c4856h.f);
            }
            this.f11011r = c2515k;
        }
    }

    /* renamed from: a */
    private boolean m13532a(C4856h c4856h) {
        c4856h = c4856h.f13837j;
        int i = 0;
        while (i < this.f11006m.length) {
            if (this.f11016w[i] && this.f11006m[i].m13678f() == c4856h) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: k */
    private void m13537k() {
        for (C4220l a : this.f11006m) {
            a.m13671a(this.f10991B);
        }
        this.f10991B = false;
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        if (!this.f10993D) {
            if (!r0.f11000g.m13799a()) {
                C4856h c4856h;
                long j2;
                if (m13540n()) {
                    c4856h = null;
                    j2 = r0.f10990A;
                } else {
                    c4856h = (C4856h) r0.f11003j.getLast();
                    j2 = c4856h.g;
                }
                r0.f10996c.m6620a(c4856h, j, j2, r0.f11002i);
                boolean z = r0.f11002i.f5915b;
                C4168c c4168c = r0.f11002i.f5914a;
                C2394a c2394a = r0.f11002i.f5916c;
                r0.f11002i.m6611a();
                if (z) {
                    r0.f10990A = -9223372036854775807L;
                    r0.f10993D = true;
                    return true;
                } else if (c4168c == null) {
                    if (c2394a != null) {
                        r0.f10995b.mo3219a(c2394a);
                    }
                    return false;
                } else {
                    if (m13531a(c4168c)) {
                        r0.f10990A = -9223372036854775807L;
                        c4856h = (C4856h) c4168c;
                        c4856h.m17301a(r0);
                        r0.f11003j.add(c4856h);
                    }
                    long a = r0.f11000g.m13797a(c4168c, r0, r0.f10999f);
                    r0.f11001h.m6668a(c4168c.f10804a, c4168c.f10805b, r0.f10994a, c4168c.f10806c, c4168c.f10807d, c4168c.f10808e, c4168c.f10809f, c4168c.f10810g, a);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public long mo2243e() {
        if (m13540n()) {
            return this.f10990A;
        }
        return this.f10993D ? Long.MIN_VALUE : ((C4856h) this.f11003j.getLast()).g;
    }

    /* renamed from: a */
    public void m13550a(C4168c c4168c, long j, long j2) {
        C4168c c4168c2 = c4168c;
        long j3 = j;
        long j4 = j2;
        this.f10996c.m6618a(c4168c2);
        this.f11001h.m6669a(c4168c2.f10804a, c4168c2.f10805b, this.f10994a, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j3, j4, c4168c.mo3197f());
        if (this.f11009p) {
            r0.f10995b.mo3205a(r0);
        } else {
            mo2241c(r0.f11019z);
        }
    }

    /* renamed from: a */
    public void m13551a(C4168c c4168c, long j, long j2, boolean z) {
        C4168c c4168c2 = c4168c;
        this.f11001h.m6674b(c4168c2.f10804a, c4168c2.f10805b, this.f10994a, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j, j2, c4168c.mo3197f());
        if (!z) {
            m13537k();
            if (r0.f11010q > 0) {
                r0.f10995b.mo3205a(r0);
            }
        }
    }

    /* renamed from: a */
    public int m13543a(C4168c c4168c, long j, long j2, IOException iOException) {
        boolean z;
        C4201l c4201l = this;
        C4168c c4168c2 = c4168c;
        long f = c4168c.mo3197f();
        boolean a = m13531a(c4168c);
        boolean z2 = true;
        if (a) {
            if (f != 0) {
                z = false;
                if (c4201l.f10996c.m6623a(c4168c2, z, iOException)) {
                    z2 = false;
                } else if (a) {
                    C2516a.m7019b(((C4856h) c4201l.f11003j.removeLast()) != c4168c2);
                    if (c4201l.f11003j.isEmpty()) {
                        c4201l.f10990A = c4201l.f11019z;
                    }
                }
                c4201l.f11001h.m6670a(c4168c2.f10804a, c4168c2.f10805b, c4201l.f10994a, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j, j2, c4168c.mo3197f(), iOException, z2);
                if (z2) {
                    return 0;
                }
                if (c4201l.f11009p) {
                    mo2241c(c4201l.f11019z);
                } else {
                    c4201l.f10995b.mo3205a(c4201l);
                }
                return 2;
            }
        }
        z = true;
        if (c4201l.f10996c.m6623a(c4168c2, z, iOException)) {
            z2 = false;
        } else if (a) {
            if (((C4856h) c4201l.f11003j.removeLast()) != c4168c2) {
            }
            C2516a.m7019b(((C4856h) c4201l.f11003j.removeLast()) != c4168c2);
            if (c4201l.f11003j.isEmpty()) {
                c4201l.f10990A = c4201l.f11019z;
            }
        }
        c4201l.f11001h.m6670a(c4168c2.f10804a, c4168c2.f10805b, c4201l.f10994a, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j, j2, c4168c.mo3197f(), iOException, z2);
        if (z2) {
            return 0;
        }
        if (c4201l.f11009p) {
            c4201l.f10995b.mo3205a(c4201l);
        } else {
            mo2241c(c4201l.f11019z);
        }
        return 2;
    }

    /* renamed from: a */
    public void m13547a(int i, boolean z) {
        for (C4220l a : this.f11006m) {
            a.m13664a(i);
        }
        if (z) {
            for (C4220l b : this.f11006m) {
                b.m13673b();
            }
        }
    }

    /* renamed from: b */
    public C4220l m13560b(int i, int i2) {
        i2 = this.f11006m.length;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f11007n[i3] == i) {
                return this.f11006m[i3];
            }
        }
        C4220l c4220l = new C4220l(this.f10997d);
        c4220l.m13665a(this.f11018y);
        c4220l.m13668a((C2434b) this);
        int i4 = i2 + 1;
        this.f11007n = Arrays.copyOf(this.f11007n, i4);
        this.f11007n[i2] = i;
        this.f11006m = (C4220l[]) Arrays.copyOf(this.f11006m, i4);
        this.f11006m[i2] = c4220l;
        return c4220l;
    }

    /* renamed from: a */
    public void mo2232a() {
        this.f11008o = true;
        this.f11005l.post(this.f11004k);
    }

    /* renamed from: a */
    public void mo2274a(C2515k c2515k) {
        this.f11005l.post(this.f11004k);
    }

    /* renamed from: b */
    public void m13562b(long j) {
        this.f11018y = j;
        for (C4220l a : this.f11006m) {
            a.m13665a(j);
        }
    }

    /* renamed from: l */
    private void m13538l() {
        if (!(this.f11012s || this.f11009p)) {
            if (this.f11008o) {
                C4220l[] c4220lArr = this.f11006m;
                int length = c4220lArr.length;
                int i = 0;
                while (i < length) {
                    if (c4220lArr[i].m13679g() != null) {
                        i++;
                    } else {
                        return;
                    }
                }
                m13539m();
                this.f11009p = true;
                this.f10995b.mo3221g();
            }
        }
    }

    /* renamed from: m */
    private void m13539m() {
        int length = this.f11006m.length;
        int i = 0;
        Object obj = null;
        int i2 = -1;
        while (true) {
            Object obj2 = 3;
            if (i >= length) {
                break;
            }
            String str = this.f11006m[i].m13679g().f6380f;
            if (!C2524i.m7051b(str)) {
                obj2 = C2524i.m7050a(str) ? 2 : C2524i.m7052c(str) ? 1 : null;
            }
            if (obj2 > obj) {
                i2 = i;
                obj = obj2;
            } else if (obj2 == obj && i2 != -1) {
                i2 = -1;
            }
            i++;
        }
        C2438p b = this.f10996c.m6624b();
        int i3 = b.f6064a;
        this.f11014u = -1;
        this.f11016w = new boolean[length];
        this.f11017x = new boolean[length];
        C2438p[] c2438pArr = new C2438p[length];
        for (int i4 = 0; i4 < length; i4++) {
            boolean z;
            C2515k[] c2515kArr;
            int i5;
            C2515k g = this.f11006m[i4].m13679g();
            String str2 = g.f6380f;
            if (!C2524i.m7051b(str2)) {
                if (!C2524i.m7050a(str2)) {
                    z = false;
                    this.f11017x[i4] = z;
                    this.f11015v = z | this.f11015v;
                    if (i4 != i2) {
                        c2515kArr = new C2515k[i3];
                        for (i5 = 0; i5 < i3; i5++) {
                            c2515kArr[i5] = C4201l.m13527a(b.m6712a(i5), g);
                        }
                        c2438pArr[i4] = new C2438p(c2515kArr);
                        this.f11014u = i4;
                    } else {
                        C2515k c2515k = (obj == 3 || !C2524i.m7050a(g.f6380f)) ? null : this.f10998e;
                        c2438pArr[i4] = new C2438p(C4201l.m13527a(c2515k, g));
                    }
                }
            }
            z = true;
            this.f11017x[i4] = z;
            this.f11015v = z | this.f11015v;
            if (i4 != i2) {
                if (obj == 3) {
                }
                c2438pArr[i4] = new C2438p(C4201l.m13527a(c2515k, g));
            } else {
                c2515kArr = new C2515k[i3];
                for (i5 = 0; i5 < i3; i5++) {
                    c2515kArr[i5] = C4201l.m13527a(b.m6712a(i5), g);
                }
                c2438pArr[i4] = new C2438p(c2515kArr);
                this.f11014u = i4;
            }
        }
        this.f11013t = new C2439q(c2438pArr);
    }

    /* renamed from: b */
    private void m13534b(int i, boolean z) {
        int i2 = 1;
        C2516a.m7019b(this.f11016w[i] != z);
        this.f11016w[i] = z;
        i = this.f11010q;
        if (!z) {
            i2 = -1;
        }
        this.f11010q = i + i2;
    }

    /* renamed from: a */
    private static C2515k m13527a(C2515k c2515k, C2515k c2515k2) {
        if (c2515k == null) {
            return c2515k2;
        }
        String str = null;
        int g = C2524i.m7056g(c2515k2.f6380f);
        if (g == 1) {
            str = C4201l.m13528a(c2515k.f6377c);
        } else if (g == 2) {
            str = C4201l.m13533b(c2515k.f6377c);
        }
        return c2515k2.m7012a(c2515k.f6375a, str, c2515k.f6376b, c2515k.f6384j, c2515k.f6385k, c2515k.f6398x, c2515k.f6399y);
    }

    /* renamed from: a */
    private boolean m13531a(C4168c c4168c) {
        return c4168c instanceof C4856h;
    }

    /* renamed from: n */
    private boolean m13540n() {
        return this.f10990A != -9223372036854775807L;
    }

    /* renamed from: d */
    private boolean m13535d(long j) {
        int length = this.f11006m.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            C4220l c4220l = this.f11006m[i];
            c4220l.m13681i();
            if (c4220l.m13672b(j, true, false) == -1) {
                z = false;
            }
            if (z || (!this.f11017x[i] && this.f11015v)) {
                c4220l.m13682j();
                i++;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m13528a(String str) {
        return C4201l.m13529a(str, 1);
    }

    /* renamed from: b */
    private static String m13533b(String str) {
        return C4201l.m13529a(str, 2);
    }

    /* renamed from: a */
    private static String m13529a(String str, int i) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str3 : str) {
            if (i == C2524i.m7058i(str3)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str3);
            }
        }
        if (stringBuilder.length() > null) {
            str2 = stringBuilder.toString();
        }
        return str2;
    }
}
