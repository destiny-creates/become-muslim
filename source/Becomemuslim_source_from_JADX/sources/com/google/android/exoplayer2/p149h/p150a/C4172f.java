package com.google.android.exoplayer2.p149h.p150a;

import android.util.Log;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2437n;
import com.google.android.exoplayer2.p149h.C2437n.C2436a;
import com.google.android.exoplayer2.p149h.C4220l;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4251s.C2509d;
import com.google.android.exoplayer2.p164l.C2516a;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ChunkSampleStream */
/* renamed from: com.google.android.exoplayer2.h.a.f */
public class C4172f<T extends C2372g> implements C2435m, C2437n, C2506a<C4168c>, C2509d {
    /* renamed from: a */
    long f10829a;
    /* renamed from: b */
    boolean f10830b;
    /* renamed from: c */
    private final int f10831c;
    /* renamed from: d */
    private final int[] f10832d;
    /* renamed from: e */
    private final boolean[] f10833e;
    /* renamed from: f */
    private final T f10834f;
    /* renamed from: g */
    private final C2436a<C4172f<T>> f10835g;
    /* renamed from: h */
    private final C2429a f10836h;
    /* renamed from: i */
    private final int f10837i;
    /* renamed from: j */
    private final C4251s f10838j = new C4251s("Loader:ChunkSampleStream");
    /* renamed from: k */
    private final C2371e f10839k = new C2371e();
    /* renamed from: l */
    private final LinkedList<C4854a> f10840l = new LinkedList();
    /* renamed from: m */
    private final List<C4854a> f10841m = Collections.unmodifiableList(this.f10840l);
    /* renamed from: n */
    private final C4220l f10842n;
    /* renamed from: o */
    private final C4220l[] f10843o;
    /* renamed from: p */
    private final C4167b f10844p;
    /* renamed from: q */
    private C2515k f10845q;
    /* renamed from: r */
    private long f10846r;

    /* compiled from: ChunkSampleStream */
    /* renamed from: com.google.android.exoplayer2.h.a.f$a */
    public final class C4171a implements C2435m {
        /* renamed from: a */
        public final C4172f<T> f10825a;
        /* renamed from: b */
        final /* synthetic */ C4172f f10826b;
        /* renamed from: c */
        private final C4220l f10827c;
        /* renamed from: d */
        private final int f10828d;

        public void f_() {
        }

        public C4171a(C4172f c4172f, C4172f<T> c4172f2, C4220l c4220l, int i) {
            this.f10826b = c4172f;
            this.f10825a = c4172f2;
            this.f10827c = c4220l;
            this.f10828d = i;
        }

        /* renamed from: c */
        public boolean mo2236c() {
            if (!this.f10826b.f10830b) {
                if (this.f10826b.m13299f() || !this.f10827c.m13676d()) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        public int mo2234a(long j) {
            if (this.f10826b.f10830b && j > this.f10827c.m13680h()) {
                return this.f10827c.m13684l();
            }
            j = this.f10827c.m13672b(j, true, true);
            if (j == -1) {
                j = null;
            }
            return j;
        }

        /* renamed from: a */
        public int mo2235a(C2543l c2543l, C4085e c4085e, boolean z) {
            if (this.f10826b.m13299f()) {
                return -3;
            }
            return this.f10827c.m13662a(c2543l, c4085e, z, this.f10826b.f10830b, this.f10826b.f10829a);
        }

        /* renamed from: a */
        public void m13276a() {
            C2516a.m7019b(this.f10826b.f10833e[this.f10828d]);
            this.f10826b.f10833e[this.f10828d] = false;
        }
    }

    public C4172f(int i, int[] iArr, T t, C2436a<C4172f<T>> c2436a, C2492b c2492b, long j, int i2, C2429a c2429a) {
        T t2;
        this.f10831c = i;
        this.f10832d = iArr;
        this.f10834f = t;
        this.f10835g = c2436a;
        this.f10836h = c2429a;
        this.f10837i = i2;
        t = null;
        if (iArr == null) {
            t2 = null;
        } else {
            t2 = iArr.length;
        }
        this.f10843o = new C4220l[t2];
        this.f10833e = new boolean[t2];
        i2 = t2 + 1;
        c2429a = new int[i2];
        i2 = new C4220l[i2];
        this.f10842n = new C4220l(c2492b);
        c2429a[0] = i;
        i2[0] = this.f10842n;
        while (t < t2) {
            i = new C4220l(c2492b);
            this.f10843o[t] = i;
            T t3 = t + 1;
            i2[t3] = i;
            c2429a[t3] = iArr[t];
            t = t3;
        }
        this.f10844p = new C4167b(c2429a, i2);
        this.f10846r = j;
        this.f10829a = j;
    }

    /* renamed from: b */
    public void m13293b(long j) {
        for (int i = 0; i < this.f10843o.length; i++) {
            this.f10843o[i].m13667a(j, true, this.f10833e[i]);
        }
    }

    /* renamed from: a */
    public C4171a m13286a(long j, int i) {
        for (int i2 = 0; i2 < this.f10843o.length; i2++) {
            if (this.f10832d[i2] == i) {
                C2516a.m7019b(this.f10833e[i2] ^ 1);
                this.f10833e[i2] = 1;
                this.f10843o[i2].m13681i();
                this.f10843o[i2].m13672b(j, true, true);
                return new C4171a(this, this, this.f10843o[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public T m13287a() {
        return this.f10834f;
    }

    /* renamed from: d */
    public long mo2242d() {
        if (this.f10830b) {
            return Long.MIN_VALUE;
        }
        if (m13299f()) {
            return this.f10846r;
        }
        long j = this.f10829a;
        C4854a c4854a = (C4854a) this.f10840l.getLast();
        if (!c4854a.mo3423h()) {
            c4854a = this.f10840l.size() > 1 ? (C4854a) this.f10840l.get(this.f10840l.size() - 2) : null;
        }
        if (c4854a != null) {
            j = Math.max(j, c4854a.g);
        }
        return Math.max(j, this.f10842n.m13680h());
    }

    /* renamed from: d */
    public void m13297d(long j) {
        Object obj;
        int i;
        int length;
        this.f10829a = j;
        int i2 = 0;
        if (!m13299f()) {
            if (this.f10842n.m13672b(j, true, j < mo2243e()) != -1) {
                obj = 1;
                if (obj == null) {
                    m13278a(this.f10842n.m13677e());
                    this.f10842n.m13682j();
                    for (C4220l c4220l : this.f10843o) {
                        c4220l.m13681i();
                        c4220l.m13667a(j, true, false);
                    }
                }
                this.f10846r = j;
                this.f10830b = false;
                this.f10840l.clear();
                if (this.f10838j.m13799a() == null) {
                    this.f10838j.m13801b();
                    return;
                }
                this.f10842n.m13663a();
                j = this.f10843o;
                length = j.length;
                while (i2 < length) {
                    j[i2].m13663a();
                    i2++;
                }
                return;
            }
        }
        obj = null;
        if (obj == null) {
            this.f10846r = j;
            this.f10830b = false;
            this.f10840l.clear();
            if (this.f10838j.m13799a() == null) {
                this.f10842n.m13663a();
                j = this.f10843o;
                length = j.length;
                while (i2 < length) {
                    j[i2].m13663a();
                    i2++;
                }
                return;
            }
            this.f10838j.m13801b();
            return;
        }
        m13278a(this.f10842n.m13677e());
        this.f10842n.m13682j();
        for (i = 0; i < r3; i++) {
            c4220l.m13681i();
            c4220l.m13667a(j, true, false);
        }
    }

    /* renamed from: b */
    public void m13292b() {
        if (!this.f10838j.m13800a((C2509d) this)) {
            this.f10842n.m13683k();
            for (C4220l k : this.f10843o) {
                k.m13683k();
            }
        }
    }

    /* renamed from: g */
    public void mo2244g() {
        this.f10842n.m13663a();
        for (C4220l a : this.f10843o) {
            a.m13663a();
        }
    }

    /* renamed from: c */
    public boolean mo2236c() {
        if (!this.f10830b) {
            if (m13299f() || !this.f10842n.m13676d()) {
                return false;
            }
        }
        return true;
    }

    public void f_() {
        this.f10838j.mo2322d();
        if (!this.f10838j.m13799a()) {
            this.f10834f.mo3210a();
        }
    }

    /* renamed from: a */
    public int mo2235a(C2543l c2543l, C4085e c4085e, boolean z) {
        if (m13299f()) {
            return -3;
        }
        m13278a(this.f10842n.m13677e());
        c2543l = this.f10842n.m13662a(c2543l, c4085e, z, this.f10830b, this.f10829a);
        if (c2543l == -4) {
            this.f10842n.m13682j();
        }
        return c2543l;
    }

    /* renamed from: a */
    public int mo2234a(long j) {
        int i = 0;
        if (m13299f()) {
            return 0;
        }
        if (!this.f10830b || j <= this.f10842n.m13680h()) {
            j = this.f10842n.m13672b(j, true, true);
            if (j != -1) {
                i = j;
            }
        } else {
            i = this.f10842n.m13684l();
        }
        if (i > 0) {
            this.f10842n.m13682j();
        }
        return i;
    }

    /* renamed from: a */
    public void m13288a(C4168c c4168c, long j, long j2) {
        C4168c c4168c2 = c4168c;
        long j3 = j;
        long j4 = j2;
        this.f10834f.mo3211a(c4168c2);
        this.f10836h.m6669a(c4168c2.f10804a, c4168c2.f10805b, this.f10831c, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j3, j4, c4168c.mo3197f());
        this.f10835g.mo3205a(this);
    }

    /* renamed from: a */
    public void m13289a(C4168c c4168c, long j, long j2, boolean z) {
        C4168c c4168c2 = c4168c;
        this.f10836h.m6674b(c4168c2.f10804a, c4168c2.f10805b, this.f10831c, c4168c2.f10806c, c4168c2.f10807d, c4168c2.f10808e, c4168c2.f10809f, c4168c2.f10810g, j, j2, c4168c.mo3197f());
        if (!z) {
            r0.f10842n.m13663a();
            for (C4220l a : r0.f10843o) {
                a.m13663a();
            }
            r0.f10835g.mo3205a(r0);
        }
    }

    /* renamed from: a */
    public int m13283a(C4168c c4168c, long j, long j2, IOException iOException) {
        boolean z;
        C4168c c4168c2;
        int i;
        boolean z2;
        C4172f c4172f = this;
        C4168c c4168c3 = c4168c;
        long f = c4168c.mo3197f();
        boolean a = m13279a(c4168c);
        if (f != 0 && a) {
            if (m13281h()) {
                z = false;
                if (c4172f.f10834f.mo3214a(c4168c3, z, iOException)) {
                    if (z) {
                        Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
                    } else {
                        if (a) {
                            c4168c2 = (C4854a) c4172f.f10840l.removeLast();
                            C2516a.m7019b(c4168c2 != c4168c3);
                            c4172f.f10842n.m13674b(c4168c2.m17291a(0));
                            i = 0;
                            while (i < c4172f.f10843o.length) {
                                C4220l c4220l = c4172f.f10843o[i];
                                i++;
                                c4220l.m13674b(c4168c2.m17291a(i));
                            }
                            if (c4172f.f10840l.isEmpty()) {
                                c4172f.f10846r = c4172f.f10829a;
                            }
                        }
                        z2 = true;
                        c4172f.f10836h.m6670a(c4168c3.f10804a, c4168c3.f10805b, c4172f.f10831c, c4168c3.f10806c, c4168c3.f10807d, c4168c3.f10808e, c4168c3.f10809f, c4168c3.f10810g, j, j2, f, iOException, z2);
                        if (!z2) {
                            return 0;
                        }
                        c4172f.f10835g.mo3205a(c4172f);
                        return 2;
                    }
                }
                z2 = false;
                c4172f.f10836h.m6670a(c4168c3.f10804a, c4168c3.f10805b, c4172f.f10831c, c4168c3.f10806c, c4168c3.f10807d, c4168c3.f10808e, c4168c3.f10809f, c4168c3.f10810g, j, j2, f, iOException, z2);
                if (!z2) {
                    return 0;
                }
                c4172f.f10835g.mo3205a(c4172f);
                return 2;
            }
        }
        z = true;
        if (c4172f.f10834f.mo3214a(c4168c3, z, iOException)) {
            if (z) {
                if (a) {
                    c4168c2 = (C4854a) c4172f.f10840l.removeLast();
                    if (c4168c2 != c4168c3) {
                    }
                    C2516a.m7019b(c4168c2 != c4168c3);
                    c4172f.f10842n.m13674b(c4168c2.m17291a(0));
                    i = 0;
                    while (i < c4172f.f10843o.length) {
                        C4220l c4220l2 = c4172f.f10843o[i];
                        i++;
                        c4220l2.m13674b(c4168c2.m17291a(i));
                    }
                    if (c4172f.f10840l.isEmpty()) {
                        c4172f.f10846r = c4172f.f10829a;
                    }
                }
                z2 = true;
                c4172f.f10836h.m6670a(c4168c3.f10804a, c4168c3.f10805b, c4172f.f10831c, c4168c3.f10806c, c4168c3.f10807d, c4168c3.f10808e, c4168c3.f10809f, c4168c3.f10810g, j, j2, f, iOException, z2);
                if (!z2) {
                    return 0;
                }
                c4172f.f10835g.mo3205a(c4172f);
                return 2;
            }
            Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        }
        z2 = false;
        c4172f.f10836h.m6670a(c4168c3.f10804a, c4168c3.f10805b, c4172f.f10831c, c4168c3.f10806c, c4168c3.f10807d, c4168c3.f10808e, c4168c3.f10809f, c4168c3.f10810g, j, j2, f, iOException, z2);
        if (!z2) {
            return 0;
        }
        c4172f.f10835g.mo3205a(c4172f);
        return 2;
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        if (!this.f10830b) {
            if (!r0.f10838j.m13799a()) {
                C4712l c4712l;
                long j2;
                if (m13299f()) {
                    c4712l = null;
                    j2 = r0.f10846r;
                } else {
                    c4712l = (C4712l) r0.f10840l.getLast();
                    j2 = c4712l.g;
                }
                r0.f10834f.mo3212a(c4712l, j, j2, r0.f10839k);
                boolean z = r0.f10839k.f5829b;
                C4168c c4168c = r0.f10839k.f5828a;
                r0.f10839k.m6559a();
                if (z) {
                    r0.f10846r = -9223372036854775807L;
                    r0.f10830b = true;
                    return true;
                } else if (c4168c == null) {
                    return false;
                } else {
                    if (m13279a(c4168c)) {
                        r0.f10846r = -9223372036854775807L;
                        C4854a c4854a = (C4854a) c4168c;
                        c4854a.m17292a(r0.f10844p);
                        r0.f10840l.add(c4854a);
                    }
                    r0.f10836h.m6668a(c4168c.f10804a, c4168c.f10805b, r0.f10831c, c4168c.f10806c, c4168c.f10807d, c4168c.f10808e, c4168c.f10809f, c4168c.f10810g, r0.f10838j.m13797a(c4168c, r0, r0.f10837i));
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public long mo2243e() {
        if (m13299f()) {
            return this.f10846r;
        }
        return this.f10830b ? Long.MIN_VALUE : ((C4854a) this.f10840l.getLast()).g;
    }

    /* renamed from: a */
    private boolean m13279a(C4168c c4168c) {
        return c4168c instanceof C4854a;
    }

    /* renamed from: h */
    private boolean m13281h() {
        C4854a c4854a = (C4854a) this.f10840l.getLast();
        if (this.f10842n.m13677e() > c4854a.m17291a(0)) {
            return true;
        }
        int i = 0;
        while (i < this.f10843o.length) {
            int e = this.f10843o[i].m13677e();
            i++;
            if (e > c4854a.m17291a(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    boolean m13299f() {
        return this.f10846r != -9223372036854775807L;
    }

    /* renamed from: a */
    private void m13278a(int i) {
        if (!this.f10840l.isEmpty()) {
            while (this.f10840l.size() > 1 && ((C4854a) this.f10840l.get(1)).m17291a(0) <= i) {
                this.f10840l.removeFirst();
            }
            C4854a c4854a = (C4854a) this.f10840l.getFirst();
            C2515k c2515k = c4854a.c;
            if (!c2515k.equals(this.f10845q)) {
                this.f10836h.m6667a(this.f10831c, c2515k, c4854a.d, c4854a.e, c4854a.f);
            }
            this.f10845q = c2515k;
        }
    }
}
