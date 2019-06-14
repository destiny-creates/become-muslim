package com.google.android.exoplayer2.p164l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SlidingPercentile */
/* renamed from: com.google.android.exoplayer2.l.p */
public class C2536p {
    /* renamed from: a */
    private static final Comparator<C2535a> f6454a = new C25331();
    /* renamed from: b */
    private static final Comparator<C2535a> f6455b = new C25342();
    /* renamed from: c */
    private final int f6456c;
    /* renamed from: d */
    private final ArrayList<C2535a> f6457d = new ArrayList();
    /* renamed from: e */
    private final C2535a[] f6458e = new C2535a[5];
    /* renamed from: f */
    private int f6459f = -1;
    /* renamed from: g */
    private int f6460g;
    /* renamed from: h */
    private int f6461h;
    /* renamed from: i */
    private int f6462i;

    /* compiled from: SlidingPercentile */
    /* renamed from: com.google.android.exoplayer2.l.p$1 */
    static class C25331 implements Comparator<C2535a> {
        C25331() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7138a((C2535a) obj, (C2535a) obj2);
        }

        /* renamed from: a */
        public int m7138a(C2535a c2535a, C2535a c2535a2) {
            return c2535a.f6451a - c2535a2.f6451a;
        }
    }

    /* compiled from: SlidingPercentile */
    /* renamed from: com.google.android.exoplayer2.l.p$2 */
    static class C25342 implements Comparator<C2535a> {
        C25342() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7139a((C2535a) obj, (C2535a) obj2);
        }

        /* renamed from: a */
        public int m7139a(C2535a c2535a, C2535a c2535a2) {
            if (c2535a.f6453c < c2535a2.f6453c) {
                return -1;
            }
            return c2535a2.f6453c < c2535a.f6453c ? 1 : null;
        }
    }

    /* compiled from: SlidingPercentile */
    /* renamed from: com.google.android.exoplayer2.l.p$a */
    private static class C2535a {
        /* renamed from: a */
        public int f6451a;
        /* renamed from: b */
        public int f6452b;
        /* renamed from: c */
        public float f6453c;

        private C2535a() {
        }
    }

    public C2536p(int i) {
        this.f6456c = i;
    }

    /* renamed from: a */
    public void m7143a(int i, float f) {
        int i2;
        C2535a c2535a;
        m7140a();
        if (this.f6462i > 0) {
            C2535a[] c2535aArr = this.f6458e;
            i2 = this.f6462i - 1;
            this.f6462i = i2;
            c2535a = c2535aArr[i2];
        } else {
            c2535a = new C2535a();
        }
        i2 = this.f6460g;
        this.f6460g = i2 + 1;
        c2535a.f6451a = i2;
        c2535a.f6452b = i;
        c2535a.f6453c = f;
        this.f6457d.add(c2535a);
        this.f6461h += i;
        while (this.f6461h > this.f6456c) {
            i = this.f6461h - this.f6456c;
            C2535a c2535a2 = (C2535a) this.f6457d.get(0);
            if (c2535a2.f6452b <= i) {
                this.f6461h -= c2535a2.f6452b;
                this.f6457d.remove(0);
                if (this.f6462i < 5) {
                    i = this.f6458e;
                    int i3 = this.f6462i;
                    this.f6462i = i3 + 1;
                    i[i3] = c2535a2;
                }
            } else {
                c2535a2.f6452b -= i;
                this.f6461h -= i;
            }
        }
    }

    /* renamed from: a */
    public float m7142a(float f) {
        m7141b();
        f *= (float) this.f6461h;
        int i = 0;
        for (int i2 = 0; i2 < this.f6457d.size(); i2++) {
            C2535a c2535a = (C2535a) this.f6457d.get(i2);
            i += c2535a.f6452b;
            if (((float) i) >= f) {
                return c2535a.f6453c;
            }
        }
        return this.f6457d.isEmpty() != null ? Float.NaN : ((C2535a) this.f6457d.get(this.f6457d.size() - 1)).f6453c;
    }

    /* renamed from: a */
    private void m7140a() {
        if (this.f6459f != 1) {
            Collections.sort(this.f6457d, f6454a);
            this.f6459f = 1;
        }
    }

    /* renamed from: b */
    private void m7141b() {
        if (this.f6459f != 0) {
            Collections.sort(this.f6457d, f6455b);
            this.f6459f = 0;
        }
    }
}
