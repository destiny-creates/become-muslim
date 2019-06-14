package com.google.android.exoplayer2.p149h.p151b.p152a;

import android.net.Uri;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.p151b.C2391d;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C4177a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2384h.C4178e;
import java.util.Collections;
import java.util.List;

/* compiled from: Representation */
/* renamed from: com.google.android.exoplayer2.h.b.a.g */
public abstract class C2382g {
    /* renamed from: a */
    public final String f5863a;
    /* renamed from: b */
    public final long f5864b;
    /* renamed from: c */
    public final C2515k f5865c;
    /* renamed from: d */
    public final String f5866d;
    /* renamed from: e */
    public final long f5867e;
    /* renamed from: f */
    public final List<C2378d> f5868f;
    /* renamed from: g */
    private final C2380f f5869g;

    /* compiled from: Representation */
    /* renamed from: com.google.android.exoplayer2.h.b.a.g$a */
    public static class C4175a extends C2382g implements C2391d {
        /* renamed from: g */
        private final C4177a f10852g;

        /* renamed from: d */
        public C2380f mo2253d() {
            return null;
        }

        /* renamed from: e */
        public C2391d mo2254e() {
            return this;
        }

        /* renamed from: f */
        public String mo2255f() {
            return null;
        }

        public C4175a(String str, long j, C2515k c2515k, String str2, C4177a c4177a, List<C2378d> list) {
            super(str, j, c2515k, str2, c4177a, list);
            this.f10852g = c4177a;
        }

        /* renamed from: b */
        public C2380f mo2251b(int i) {
            return this.f10852g.mo3199a((C2382g) this, i);
        }

        /* renamed from: a */
        public int mo2248a(long j, long j2) {
            return this.f10852g.m13364a(j, j2);
        }

        /* renamed from: a */
        public long mo2249a(int i) {
            return this.f10852g.m13365a(i);
        }

        /* renamed from: a */
        public long mo2250a(int i, long j) {
            return this.f10852g.m13366a(i, j);
        }

        /* renamed from: a */
        public int mo2246a() {
            return this.f10852g.m13368b();
        }

        /* renamed from: a */
        public int mo2247a(long j) {
            return this.f10852g.mo3198a(j);
        }

        /* renamed from: b */
        public boolean mo2252b() {
            return this.f10852g.mo3200c();
        }
    }

    /* compiled from: Representation */
    /* renamed from: com.google.android.exoplayer2.h.b.a.g$b */
    public static class C4176b extends C2382g {
        /* renamed from: g */
        public final Uri f10853g;
        /* renamed from: h */
        public final long f10854h;
        /* renamed from: i */
        private final String f10855i;
        /* renamed from: j */
        private final C2380f f10856j;
        /* renamed from: k */
        private final C4179i f10857k;

        public C4176b(String str, long j, C2515k c2515k, String str2, C4178e c4178e, List<C2378d> list, String str3, long j2) {
            String str4;
            String str5 = str;
            super(str, j, c2515k, str2, c4178e, list);
            this.f10853g = Uri.parse(str2);
            this.f10856j = c4178e.m13370b();
            C4179i c4179i = null;
            if (str3 != null) {
                str4 = str3;
            } else if (str5 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".");
                stringBuilder.append(c2515k.f6375a);
                stringBuilder.append(".");
                long j3 = j;
                stringBuilder.append(j);
                str4 = stringBuilder.toString();
            } else {
                str4 = null;
            }
            r9.f10855i = str4;
            r9.f10854h = j2;
            if (r9.f10856j == null) {
                c4179i = new C4179i(new C2380f(null, 0, j2));
            }
            r9.f10857k = c4179i;
        }

        /* renamed from: d */
        public C2380f mo2253d() {
            return this.f10856j;
        }

        /* renamed from: e */
        public C2391d mo2254e() {
            return this.f10857k;
        }

        /* renamed from: f */
        public String mo2255f() {
            return this.f10855i;
        }
    }

    /* renamed from: d */
    public abstract C2380f mo2253d();

    /* renamed from: e */
    public abstract C2391d mo2254e();

    /* renamed from: f */
    public abstract String mo2255f();

    /* renamed from: a */
    public static C2382g m6576a(String str, long j, C2515k c2515k, String str2, C2384h c2384h, List<C2378d> list) {
        return C2382g.m6577a(str, j, c2515k, str2, c2384h, list, null);
    }

    /* renamed from: a */
    public static C2382g m6577a(String str, long j, C2515k c2515k, String str2, C2384h c2384h, List<C2378d> list, String str3) {
        C2384h c2384h2 = c2384h;
        if (c2384h2 instanceof C4178e) {
            return new C4176b(str, j, c2515k, str2, (C4178e) c2384h2, list, str3, -1);
        } else if (c2384h2 instanceof C4177a) {
            return new C4175a(str, j, c2515k, str2, (C4177a) c2384h2, list);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    private C2382g(String str, long j, C2515k c2515k, String str2, C2384h c2384h, List<C2378d> list) {
        this.f5863a = str;
        this.f5864b = j;
        this.f5865c = c2515k;
        this.f5866d = str2;
        if (list == null) {
            str = Collections.emptyList();
        } else {
            str = Collections.unmodifiableList(list);
        }
        this.f5868f = str;
        this.f5869g = c2384h.mo3201a(this);
        this.f5867e = c2384h.m6582a();
    }

    /* renamed from: c */
    public C2380f m6578c() {
        return this.f5869g;
    }
}
