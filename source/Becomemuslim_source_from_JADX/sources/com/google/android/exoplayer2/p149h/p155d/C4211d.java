package com.google.android.exoplayer2.p149h.p155d;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.amplitude.api.Constants;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2489j;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C4159f;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2423i.C2421a;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2430j;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4221o;
import com.google.android.exoplayer2.p149h.p155d.C4210b.C2414a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a.C2411b;
import com.google.android.exoplayer2.p149h.p155d.p156a.C4209b;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2512t;
import com.google.android.exoplayer2.p163k.C2512t.C4252a;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4253u;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: SsMediaSource */
/* renamed from: com.google.android.exoplayer2.h.d.d */
public final class C4211d implements C2423i, C2506a<C4253u<C2412a>> {
    /* renamed from: a */
    private final Uri f11057a;
    /* renamed from: b */
    private final C2497a f11058b;
    /* renamed from: c */
    private final C2414a f11059c;
    /* renamed from: d */
    private final int f11060d;
    /* renamed from: e */
    private final long f11061e;
    /* renamed from: f */
    private final C2429a f11062f;
    /* renamed from: g */
    private final C2513a<? extends C2412a> f11063g;
    /* renamed from: h */
    private final ArrayList<C4721c> f11064h;
    /* renamed from: i */
    private C2421a f11065i;
    /* renamed from: j */
    private C2498g f11066j;
    /* renamed from: k */
    private C4251s f11067k;
    /* renamed from: l */
    private C2512t f11068l;
    /* renamed from: m */
    private long f11069m;
    /* renamed from: n */
    private C2412a f11070n;
    /* renamed from: o */
    private Handler f11071o;

    /* compiled from: SsMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.d.d$1 */
    class C24151 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4211d f5971a;

        C24151(C4211d c4211d) {
            this.f5971a = c4211d;
        }

        public void run() {
            this.f5971a.m13606e();
        }
    }

    static {
        C2489j.m6939a("goog.exo.smoothstreaming");
    }

    @Deprecated
    public C4211d(Uri uri, C2497a c2497a, C2414a c2414a, Handler handler, C2430j c2430j) {
        this(uri, c2497a, c2414a, 3, Constants.EVENT_UPLOAD_PERIOD_MILLIS, handler, c2430j);
    }

    @Deprecated
    public C4211d(Uri uri, C2497a c2497a, C2414a c2414a, int i, long j, Handler handler, C2430j c2430j) {
        this(uri, c2497a, new C4209b(), c2414a, i, j, handler, c2430j);
    }

    @Deprecated
    public C4211d(Uri uri, C2497a c2497a, C2513a<? extends C2412a> c2513a, C2414a c2414a, int i, long j, Handler handler, C2430j c2430j) {
        this(null, uri, c2497a, c2513a, c2414a, i, j, handler, c2430j);
    }

    private C4211d(C2412a c2412a, Uri uri, C2497a c2497a, C2513a<? extends C2412a> c2513a, C2414a c2414a, int i, long j, Handler handler, C2430j c2430j) {
        boolean z;
        if (c2412a != null) {
            if (c2412a.f5962d) {
                z = false;
                C2516a.m7019b(z);
                this.f11070n = c2412a;
                if (uri == null) {
                    uri = null;
                } else if (C2541v.m7190d(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?") != null) {
                    uri = Uri.withAppendedPath(uri, "Manifest");
                }
                this.f11057a = uri;
                this.f11058b = c2497a;
                this.f11063g = c2513a;
                this.f11059c = c2414a;
                this.f11060d = i;
                this.f11061e = j;
                this.f11062f = new C2429a(handler, c2430j);
                this.f11064h = new ArrayList();
            }
        }
        z = true;
        C2516a.m7019b(z);
        this.f11070n = c2412a;
        if (uri == null) {
            uri = null;
        } else if (C2541v.m7190d(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?") != null) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.f11057a = uri;
        this.f11058b = c2497a;
        this.f11063g = c2513a;
        this.f11059c = c2414a;
        this.f11060d = i;
        this.f11061e = j;
        this.f11062f = new C2429a(handler, c2430j);
        this.f11064h = new ArrayList();
    }

    /* renamed from: a */
    public void mo2263a(C4159f c4159f, boolean z, C2421a c2421a) {
        this.f11065i = c2421a;
        if (this.f11070n != null) {
            this.f11068l = new C4252a();
            m13604c();
            return;
        }
        this.f11066j = this.f11058b.createDataSource();
        this.f11067k = new C4251s("Loader:Manifest");
        this.f11068l = this.f11067k;
        this.f11071o = new Handler();
        m13606e();
    }

    /* renamed from: a */
    public void mo2262a() {
        this.f11068l.mo2322d();
    }

    /* renamed from: a */
    public C4219h mo2261a(C2422b c2422b, C2492b c2492b) {
        C2516a.m7017a(c2422b.f5978b == null ? true : null);
        C2422b c4721c = new C4721c(this.f11070n, this.f11059c, this.f11060d, this.f11062f, this.f11068l, c2492b);
        this.f11064h.add(c4721c);
        return c4721c;
    }

    /* renamed from: a */
    public void mo2264a(C4219h c4219h) {
        ((C4721c) c4219h).m16169f();
        this.f11064h.remove(c4219h);
    }

    /* renamed from: b */
    public void mo2265b() {
        this.f11065i = null;
        this.f11070n = null;
        this.f11066j = null;
        this.f11069m = 0;
        if (this.f11067k != null) {
            this.f11067k.m13802c();
            this.f11067k = null;
        }
        if (this.f11071o != null) {
            this.f11071o.removeCallbacksAndMessages(null);
            this.f11071o = null;
        }
    }

    /* renamed from: a */
    public void m13615a(C4253u<C2412a> c4253u, long j, long j2) {
        this.f11062f.m6672a(c4253u.f11218a, c4253u.f11219b, j, j2, c4253u.m13809e());
        this.f11070n = (C2412a) c4253u.m13808d();
        this.f11069m = j - j2;
        m13604c();
        m13605d();
    }

    /* renamed from: a */
    public void m13616a(C4253u<C2412a> c4253u, long j, long j2, boolean z) {
        this.f11062f.m6672a(c4253u.f11218a, c4253u.f11219b, j, j2, c4253u.m13809e());
    }

    /* renamed from: a */
    public int m13608a(C4253u<C2412a> c4253u, long j, long j2, IOException iOException) {
        C4253u<C2412a> c4253u2 = c4253u;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof C2571p;
        this.f11062f.m6673a(c4253u2.f11218a, c4253u2.f11219b, j, j2, c4253u.m13809e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* renamed from: c */
    private void m13604c() {
        C4211d c4211d = this;
        for (int i = 0; i < c4211d.f11064h.size(); i++) {
            ((C4721c) c4211d.f11064h.get(i)).m16160a(c4211d.f11070n);
        }
        long j = Long.MIN_VALUE;
        long j2 = Clock.MAX_TIME;
        for (C2411b c2411b : c4211d.f11070n.f5964f) {
            if (c2411b.f5953k > 0) {
                long min = Math.min(j2, c2411b.m6632a(0));
                j = Math.max(j, c2411b.m6632a(c2411b.f5953k - 1) + c2411b.m6634b(c2411b.f5953k - 1));
                j2 = min;
            }
        }
        if (j2 == Clock.MAX_TIME) {
            C2589y c4221o = new C4221o(c4211d.f11070n.f5962d ? -9223372036854775807L : 0, 0, 0, 0, true, c4211d.f11070n.f5962d);
        } else if (c4211d.f11070n.f5962d) {
            if (c4211d.f11070n.f5966h != -9223372036854775807L && c4211d.f11070n.f5966h > 0) {
                j2 = Math.max(j2, j - c4211d.f11070n.f5966h);
            }
            long j3 = j2;
            long j4 = j - j3;
            long b = j4 - C2251b.m6222b(c4211d.f11061e);
            if (b < 5000000) {
                b = Math.min(5000000, j4 / 2);
            }
            C2589y c4221o2 = new C4221o(-9223372036854775807L, j4, j3, b, true, true);
        } else {
            long j5 = c4211d.f11070n.f5965g != -9223372036854775807L ? c4211d.f11070n.f5965g : j - j2;
            C2589y c4221o3 = new C4221o(j2 + j5, j5, j2, 0, true, false);
        }
        c4211d.f11065i.mo3249a(c4211d, r1, c4211d.f11070n);
    }

    /* renamed from: d */
    private void m13605d() {
        if (this.f11070n.f5962d) {
            this.f11071o.postDelayed(new C24151(this), Math.max(0, (this.f11069m + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* renamed from: e */
    private void m13606e() {
        C4253u c4253u = new C4253u(this.f11066j, this.f11057a, 4, this.f11063g);
        this.f11062f.m6671a(c4253u.f11218a, c4253u.f11219b, this.f11067k.m13797a(c4253u, this, this.f11060d));
    }
}
