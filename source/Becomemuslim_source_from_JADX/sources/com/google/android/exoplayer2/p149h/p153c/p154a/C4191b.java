package com.google.android.exoplayer2.p149h.p153c.p154a;

import com.google.android.exoplayer2.p136c.C2255a;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsMediaPlaylist */
/* renamed from: com.google.android.exoplayer2.h.c.a.b */
public final class C4191b extends C2396c {
    /* renamed from: a */
    public final int f10911a;
    /* renamed from: b */
    public final long f10912b;
    /* renamed from: c */
    public final long f10913c;
    /* renamed from: d */
    public final boolean f10914d;
    /* renamed from: e */
    public final int f10915e;
    /* renamed from: f */
    public final int f10916f;
    /* renamed from: g */
    public final int f10917g;
    /* renamed from: h */
    public final long f10918h;
    /* renamed from: i */
    public final boolean f10919i;
    /* renamed from: j */
    public final boolean f10920j;
    /* renamed from: k */
    public final boolean f10921k;
    /* renamed from: l */
    public final C2255a f10922l;
    /* renamed from: m */
    public final C2395a f10923m;
    /* renamed from: n */
    public final List<C2395a> f10924n;
    /* renamed from: o */
    public final long f10925o;

    /* compiled from: HlsMediaPlaylist */
    /* renamed from: com.google.android.exoplayer2.h.c.a.b$a */
    public static final class C2395a implements Comparable<Long> {
        /* renamed from: a */
        public final String f5899a;
        /* renamed from: b */
        public final long f5900b;
        /* renamed from: c */
        public final int f5901c;
        /* renamed from: d */
        public final long f5902d;
        /* renamed from: e */
        public final String f5903e;
        /* renamed from: f */
        public final String f5904f;
        /* renamed from: g */
        public final long f5905g;
        /* renamed from: h */
        public final long f5906h;

        public /* synthetic */ int compareTo(Object obj) {
            return m6605a((Long) obj);
        }

        public C2395a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, null, null, j, j2);
        }

        public C2395a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.f5899a = str;
            this.f5900b = j;
            this.f5901c = i;
            this.f5902d = j2;
            this.f5903e = str2;
            this.f5904f = str3;
            this.f5905g = j3;
            this.f5906h = j4;
        }

        /* renamed from: a */
        public int m6605a(Long l) {
            if (this.f5902d > l.longValue()) {
                return 1;
            }
            return this.f5902d < l.longValue() ? -1 : null;
        }
    }

    public C4191b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, C2255a c2255a, C2395a c2395a, List<C2395a> list2) {
        String str2 = str;
        List<String> list3 = list;
        super(str, list);
        this.f10911a = i;
        this.f10913c = j2;
        this.f10914d = z;
        this.f10915e = i2;
        this.f10916f = i3;
        this.f10917g = i4;
        this.f10918h = j3;
        this.f10919i = z2;
        this.f10920j = z3;
        this.f10921k = z4;
        this.f10922l = c2255a;
        this.f10923m = c2395a;
        this.f10924n = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            r0.f10925o = 0;
        } else {
            C2395a c2395a2 = (C2395a) list2.get(list2.size() - 1);
            r0.f10925o = c2395a2.f5902d + c2395a2.f5900b;
        }
        long j4 = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : r0.f10925o + j;
        r0.f10912b = j4;
    }

    /* renamed from: a */
    public boolean m13440a(C4191b c4191b) {
        boolean z = true;
        if (c4191b != null) {
            if (this.f10916f <= c4191b.f10916f) {
                if (this.f10916f < c4191b.f10916f) {
                    return false;
                }
                int size = this.f10924n.size();
                int size2 = c4191b.f10924n.size();
                if (size <= size2) {
                    if (size != size2 || !this.f10920j || c4191b.f10920j != null) {
                        z = false;
                    }
                }
                return z;
            }
        }
        return true;
    }

    /* renamed from: a */
    public long m13438a() {
        return this.f10913c + this.f10925o;
    }

    /* renamed from: a */
    public C4191b m13439a(long j, int i) {
        return new C4191b(this.f10911a, this.p, this.q, this.f10912b, j, true, i, this.f10916f, this.f10917g, this.f10918h, this.f10919i, this.f10920j, this.f10921k, this.f10922l, this.f10923m, this.f10924n);
    }

    /* renamed from: b */
    public C4191b m13441b() {
        if (this.f10920j) {
            return r0;
        }
        C4191b c4191b = r2;
        C4191b c4191b2 = new C4191b(r0.f10911a, r0.p, r0.q, r0.f10912b, r0.f10913c, r0.f10914d, r0.f10915e, r0.f10916f, r0.f10917g, r0.f10918h, r0.f10919i, true, r0.f10921k, r0.f10922l, r0.f10923m, r0.f10924n);
        return c4191b;
    }
}
