package com.google.android.exoplayer2.p149h.p153c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2489j;
import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C4159f;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2423i.C2421a;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2430j;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4221o;
import com.google.android.exoplayer2.p149h.p153c.p154a.C2396c;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b.C2395a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4192d;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4194e;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4194e.C2402e;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.List;

/* compiled from: HlsMediaSource */
/* renamed from: com.google.android.exoplayer2.h.c.j */
public final class C4198j implements C2402e, C2423i {
    /* renamed from: a */
    private final C2406f f10980a;
    /* renamed from: b */
    private final Uri f10981b;
    /* renamed from: c */
    private final C2405e f10982c;
    /* renamed from: d */
    private final int f10983d;
    /* renamed from: e */
    private final C2429a f10984e;
    /* renamed from: f */
    private final C2513a<C2396c> f10985f;
    /* renamed from: g */
    private C4194e f10986g;
    /* renamed from: h */
    private C2421a f10987h;

    static {
        C2489j.m6939a("goog.exo.hls");
    }

    @Deprecated
    public C4198j(Uri uri, C2497a c2497a, Handler handler, C2430j c2430j) {
        this(uri, c2497a, 3, handler, c2430j);
    }

    @Deprecated
    public C4198j(Uri uri, C2497a c2497a, int i, Handler handler, C2430j c2430j) {
        this(uri, new C4196b(c2497a), C2406f.f5936a, i, handler, c2430j, new C4192d());
    }

    @Deprecated
    public C4198j(Uri uri, C2405e c2405e, C2406f c2406f, int i, Handler handler, C2430j c2430j, C2513a<C2396c> c2513a) {
        this.f10981b = uri;
        this.f10982c = c2405e;
        this.f10980a = c2406f;
        this.f10983d = i;
        this.f10985f = c2513a;
        this.f10984e = new C2429a(handler, c2430j);
    }

    /* renamed from: a */
    public void mo2263a(C4159f c4159f, boolean z, C2421a c2421a) {
        C2516a.m7019b(this.f10986g == null ? true : null);
        this.f10986g = new C4194e(this.f10981b, this.f10982c, this.f10984e, this.f10983d, this, this.f10985f);
        this.f10987h = c2421a;
        this.f10986g.m13496a();
    }

    /* renamed from: a */
    public void mo2262a() {
        this.f10986g.m13507d();
    }

    /* renamed from: a */
    public C4219h mo2261a(C2422b c2422b, C2492b c2492b) {
        C2516a.m7017a(c2422b.f5978b == null ? true : null);
        return new C4718i(this.f10980a, this.f10986g, this.f10982c, this.f10983d, this.f10984e, c2492b);
    }

    /* renamed from: a */
    public void mo2264a(C4219h c4219h) {
        ((C4718i) c4219h).m16128f();
    }

    /* renamed from: b */
    public void mo2265b() {
        if (this.f10986g != null) {
            this.f10986g.m13505c();
            this.f10986g = null;
        }
        this.f10987h = null;
    }

    /* renamed from: a */
    public void mo2273a(C4191b c4191b) {
        C2589y c4221o;
        C4198j c4198j = this;
        C4191b c4191b2 = c4191b;
        long j = c4191b2.f10921k ? 0 : -9223372036854775807L;
        long a = c4191b2.f10921k ? C2251b.m6221a(c4191b2.f10913c) : -9223372036854775807L;
        long j2 = c4191b2.f10912b;
        if (c4198j.f10986g.m13509e()) {
            long j3;
            long j4 = c4191b2.f10920j ? c4191b2.f10913c + c4191b2.f10925o : -9223372036854775807L;
            List list = c4191b2.f10924n;
            if (j2 == -9223372036854775807L) {
                long j5;
                if (list.isEmpty()) {
                    j5 = 0;
                } else {
                    j5 = ((C2395a) list.get(Math.max(0, list.size() - 3))).f5902d;
                }
                j3 = j5;
            } else {
                j3 = j2;
            }
            c4221o = new C4221o(j, a, j4, c4191b2.f10925o, c4191b2.f10913c, j3, true, c4191b2.f10920j ^ 1);
        } else {
            C2589y c4221o2 = new C4221o(j, a, c4191b2.f10913c + c4191b2.f10925o, c4191b2.f10925o, c4191b2.f10913c, j2 == -9223372036854775807L ? 0 : j2, true, false);
        }
        c4198j.f10987h.mo3249a(c4198j, c4221o, new C2407g(c4198j.f10986g.m13502b(), c4191b2));
    }
}
