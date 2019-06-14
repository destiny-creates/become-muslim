package com.google.android.exoplayer2.p149h;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.ByteConstants;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C4159f;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p149h.C2423i.C2421a;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C4722f.C2419c;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;
import java.io.IOException;

/* compiled from: ExtractorMediaSource */
/* renamed from: com.google.android.exoplayer2.h.g */
public final class C4217g implements C2419c, C2423i {
    /* renamed from: a */
    private final Uri f11088a;
    /* renamed from: b */
    private final C2497a f11089b;
    /* renamed from: c */
    private final C2323h f11090c;
    /* renamed from: d */
    private final int f11091d;
    /* renamed from: e */
    private final C2429a f11092e;
    /* renamed from: f */
    private final String f11093f;
    /* renamed from: g */
    private final int f11094g;
    /* renamed from: h */
    private C2421a f11095h;
    /* renamed from: i */
    private long f11096i;
    /* renamed from: j */
    private boolean f11097j;

    @Deprecated
    /* compiled from: ExtractorMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.g$a */
    public interface C2420a {
        void onLoadError(IOException iOException);
    }

    /* compiled from: ExtractorMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.g$b */
    private static final class C4216b implements C2430j {
        /* renamed from: a */
        private final C2420a f11087a;

        public void onDownstreamFormatChanged(int i, C2515k c2515k, int i2, Object obj, long j) {
        }

        public void onLoadCanceled(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        }

        public void onLoadCompleted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        }

        public void onLoadStarted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3) {
        }

        public C4216b(C2420a c2420a) {
            this.f11087a = (C2420a) C2516a.m7015a((Object) c2420a);
        }

        public void onLoadError(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            this.f11087a.onLoadError(iOException);
        }
    }

    /* renamed from: a */
    public void mo2262a() {
    }

    @Deprecated
    public C4217g(Uri uri, C2497a c2497a, C2323h c2323h, Handler handler, C2420a c2420a) {
        this(uri, c2497a, c2323h, handler, c2420a, null);
    }

    @Deprecated
    public C4217g(Uri uri, C2497a c2497a, C2323h c2323h, Handler handler, C2420a c2420a, String str) {
        this(uri, c2497a, c2323h, -1, handler, c2420a, str, (int) ByteConstants.MB);
    }

    @Deprecated
    public C4217g(Uri uri, C2497a c2497a, C2323h c2323h, int i, Handler handler, C2420a c2420a, String str, int i2) {
        C2420a c2420a2 = c2420a;
        this(uri, c2497a, c2323h, i, handler, c2420a2 == null ? null : new C4216b(c2420a2), str, i2);
    }

    private C4217g(Uri uri, C2497a c2497a, C2323h c2323h, int i, Handler handler, C2430j c2430j, String str, int i2) {
        this.f11088a = uri;
        this.f11089b = c2497a;
        this.f11090c = c2323h;
        this.f11091d = i;
        this.f11092e = new C2429a(handler, c2430j);
        this.f11093f = str;
        this.f11094g = i2;
    }

    /* renamed from: a */
    public void mo2263a(C4159f c4159f, boolean z, C2421a c2421a) {
        this.f11095h = c2421a;
        m13635b(1, null);
    }

    /* renamed from: a */
    public C4219h mo2261a(C2422b c2422b, C2492b c2492b) {
        C2516a.m7017a(c2422b.f5978b == null ? true : null);
        return new C4722f(this.f11088a, this.f11089b.createDataSource(), this.f11090c.mo2161a(), this.f11091d, this.f11092e, this, c2492b, this.f11093f, this.f11094g);
    }

    /* renamed from: a */
    public void mo2264a(C4219h c4219h) {
        ((C4722f) c4219h).m16209f();
    }

    /* renamed from: b */
    public void mo2265b() {
        this.f11095h = null;
    }

    /* renamed from: a */
    public void mo2290a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.f11096i;
        }
        if (this.f11096i != j || this.f11097j != z) {
            m13635b(j, z);
        }
    }

    /* renamed from: b */
    private void m13635b(long j, boolean z) {
        this.f11096i = j;
        this.f11097j = z;
        this.f11095h.mo3249a(this, new C4221o(this.f11096i, this.f11097j), false);
    }
}
