package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: Timeline */
/* renamed from: com.google.android.exoplayer2.y */
public abstract class C2589y {
    /* renamed from: a */
    public static final C2589y f6638a = new C42581();

    /* compiled from: Timeline */
    /* renamed from: com.google.android.exoplayer2.y$a */
    public static final class C2587a {
        /* renamed from: a */
        public Object f6617a;
        /* renamed from: b */
        public Object f6618b;
        /* renamed from: c */
        public int f6619c;
        /* renamed from: d */
        public long f6620d;
        /* renamed from: e */
        private long f6621e;
        /* renamed from: f */
        private long[] f6622f;
        /* renamed from: g */
        private int[] f6623g;
        /* renamed from: h */
        private int[] f6624h;
        /* renamed from: i */
        private int[] f6625i;
        /* renamed from: j */
        private long[][] f6626j;
        /* renamed from: k */
        private long f6627k;

        /* renamed from: a */
        public C2587a m7305a(Object obj, Object obj2, int i, long j, long j2) {
            return m7306a(obj, obj2, i, j, j2, null, null, null, null, (long[][]) null, -9223372036854775807L);
        }

        /* renamed from: a */
        public C2587a m7306a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.f6617a = obj;
            this.f6618b = obj2;
            this.f6619c = i;
            this.f6620d = j;
            this.f6621e = j2;
            this.f6622f = jArr;
            this.f6623g = iArr;
            this.f6624h = iArr2;
            this.f6625i = iArr3;
            this.f6626j = jArr2;
            this.f6627k = j3;
            return this;
        }

        /* renamed from: a */
        public long m7303a() {
            return this.f6620d;
        }

        /* renamed from: b */
        public long m7310b() {
            return C2251b.m6221a(this.f6621e);
        }

        /* renamed from: c */
        public int m7312c() {
            return this.f6622f == null ? 0 : this.f6622f.length;
        }

        /* renamed from: a */
        public long m7304a(int i) {
            return this.f6622f[i];
        }

        /* renamed from: b */
        public int m7308b(int i) {
            return this.f6625i[i];
        }

        /* renamed from: c */
        public boolean m7313c(int i) {
            return this.f6623g[i] != -1 && this.f6625i[i] == this.f6623g[i];
        }

        /* renamed from: a */
        public int m7302a(long j) {
            if (this.f6622f == null) {
                return -1;
            }
            int length = this.f6622f.length - 1;
            while (length >= 0 && (this.f6622f[length] == Long.MIN_VALUE || this.f6622f[length] > j)) {
                length--;
            }
            if (length < 0 || m7313c(length) != null) {
                length = -1;
            }
            return length;
        }

        /* renamed from: b */
        public int m7309b(long j) {
            if (this.f6622f == null) {
                return -1;
            }
            int i = 0;
            while (i < this.f6622f.length && this.f6622f[i] != Long.MIN_VALUE && (j >= this.f6622f[i] || m7313c(i))) {
                i++;
            }
            if (i >= this.f6622f.length) {
                i = -1;
            }
            return i;
        }

        /* renamed from: d */
        public int m7314d(int i) {
            return this.f6623g[i];
        }

        /* renamed from: a */
        public boolean m7307a(int i, int i2) {
            return i2 < this.f6624h[i];
        }

        /* renamed from: b */
        public long m7311b(int i, int i2) {
            if (i2 >= this.f6626j[i].length) {
                return 1;
            }
            return this.f6626j[i][i2];
        }

        /* renamed from: d */
        public long m7315d() {
            return this.f6627k;
        }
    }

    /* compiled from: Timeline */
    /* renamed from: com.google.android.exoplayer2.y$b */
    public static final class C2588b {
        /* renamed from: a */
        public Object f6628a;
        /* renamed from: b */
        public long f6629b;
        /* renamed from: c */
        public long f6630c;
        /* renamed from: d */
        public boolean f6631d;
        /* renamed from: e */
        public boolean f6632e;
        /* renamed from: f */
        public int f6633f;
        /* renamed from: g */
        public int f6634g;
        /* renamed from: h */
        public long f6635h;
        /* renamed from: i */
        public long f6636i;
        /* renamed from: j */
        public long f6637j;

        /* renamed from: a */
        public C2588b m7317a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.f6628a = obj;
            this.f6629b = j;
            this.f6630c = j2;
            this.f6631d = z;
            this.f6632e = z2;
            this.f6635h = j3;
            this.f6636i = j4;
            this.f6633f = i;
            this.f6634g = i2;
            this.f6637j = j5;
            return this;
        }

        /* renamed from: a */
        public long m7316a() {
            return this.f6635h;
        }

        /* renamed from: b */
        public long m7318b() {
            return C2251b.m6221a(this.f6636i);
        }

        /* renamed from: c */
        public long m7319c() {
            return this.f6637j;
        }
    }

    /* compiled from: Timeline */
    /* renamed from: com.google.android.exoplayer2.y$1 */
    static class C42581 extends C2589y {
        /* renamed from: a */
        public int mo2256a(Object obj) {
            return -1;
        }

        /* renamed from: b */
        public int mo2259b() {
            return 0;
        }

        /* renamed from: c */
        public int mo2260c() {
            return 0;
        }

        C42581() {
        }

        /* renamed from: a */
        public C2588b mo2258a(int i, C2588b c2588b, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        /* renamed from: a */
        public C2587a mo2257a(int i, C2587a c2587a, boolean z) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public abstract int mo2256a(Object obj);

    /* renamed from: a */
    public abstract C2587a mo2257a(int i, C2587a c2587a, boolean z);

    /* renamed from: a */
    public abstract C2588b mo2258a(int i, C2588b c2588b, boolean z, long j);

    /* renamed from: b */
    public abstract int mo2259b();

    /* renamed from: c */
    public abstract int mo2260c();

    /* renamed from: a */
    public final boolean m7331a() {
        return mo2259b() == 0;
    }

    /* renamed from: a */
    public int m7320a(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                return i == m7323a(z) ? -1 : i + 1;
            case 1:
                return i;
            case 2:
                if (i == m7323a(z)) {
                    i = m7333b(z);
                } else {
                    i++;
                }
                return i;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public int m7323a(boolean z) {
        return m7331a() ? true : mo2259b() - 1;
    }

    /* renamed from: b */
    public int m7333b(boolean z) {
        return m7331a() ? true : false;
    }

    /* renamed from: a */
    public final C2588b m7328a(int i, C2588b c2588b) {
        return m7329a(i, c2588b, false);
    }

    /* renamed from: a */
    public final C2588b m7329a(int i, C2588b c2588b, boolean z) {
        return mo2258a(i, c2588b, z, 0);
    }

    /* renamed from: a */
    public final int m7321a(int i, C2587a c2587a, C2588b c2588b, int i2, boolean z) {
        int i3 = m7326a(i, c2587a).f6619c;
        if (m7328a(i3, c2588b).f6634g != i) {
            return i + 1;
        }
        i = m7320a(i3, i2, z);
        if (i == -1) {
            return -1;
        }
        return m7328a(i, c2588b).f6633f;
    }

    /* renamed from: b */
    public final boolean m7334b(int i, C2587a c2587a, C2588b c2588b, int i2, boolean z) {
        return m7321a(i, c2587a, c2588b, i2, z) == -1;
    }

    /* renamed from: a */
    public final C2587a m7326a(int i, C2587a c2587a) {
        return mo2257a(i, c2587a, false);
    }

    /* renamed from: a */
    public final Pair<Integer, Long> m7324a(C2588b c2588b, C2587a c2587a, int i, long j) {
        return m7325a(c2588b, c2587a, i, j, 0);
    }

    /* renamed from: a */
    public final Pair<Integer, Long> m7325a(C2588b c2588b, C2587a c2587a, int i, long j, long j2) {
        C2516a.m7014a(i, 0, mo2259b());
        mo2258a(i, c2588b, false, j2);
        if (j == -9223372036854775807L) {
            j = c2588b.m7316a();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        i = c2588b.f6633f;
        long c = c2588b.m7319c() + j;
        j = m7326a(i, c2587a).m7303a();
        while (j != -9223372036854775807L && c >= j && i < c2588b.f6634g) {
            c -= j;
            i++;
            j = m7326a(i, c2587a).m7303a();
        }
        return Pair.create(Integer.valueOf(i), Long.valueOf(c));
    }
}
