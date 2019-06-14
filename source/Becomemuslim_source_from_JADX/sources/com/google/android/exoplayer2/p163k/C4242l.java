package com.google.android.exoplayer2.p163k;

import android.os.Handler;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.p163k.C2495d.C2494a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2517b;
import com.google.android.exoplayer2.p164l.C2536p;

/* compiled from: DefaultBandwidthMeter */
/* renamed from: com.google.android.exoplayer2.k.l */
public final class C4242l implements C2495d, C2514v<Object> {
    /* renamed from: a */
    private final Handler f11184a;
    /* renamed from: b */
    private final C2494a f11185b;
    /* renamed from: c */
    private final C2536p f11186c;
    /* renamed from: d */
    private final C2517b f11187d;
    /* renamed from: e */
    private int f11188e;
    /* renamed from: f */
    private long f11189f;
    /* renamed from: g */
    private long f11190g;
    /* renamed from: h */
    private long f11191h;
    /* renamed from: i */
    private long f11192i;
    /* renamed from: j */
    private long f11193j;

    public C4242l() {
        this(null, null);
    }

    public C4242l(Handler handler, C2494a c2494a) {
        this(handler, c2494a, AdError.SERVER_ERROR_CODE);
    }

    public C4242l(Handler handler, C2494a c2494a, int i) {
        this(handler, c2494a, i, C2517b.f6401a);
    }

    public C4242l(Handler handler, C2494a c2494a, int i, C2517b c2517b) {
        this.f11184a = handler;
        this.f11185b = c2494a;
        this.f11186c = new C2536p(i);
        this.f11187d = c2517b;
        this.f11193j = -1;
    }

    /* renamed from: a */
    public synchronized long mo2316a() {
        return this.f11193j;
    }

    /* renamed from: a */
    public synchronized void mo2319a(Object obj, C2501j c2501j) {
        if (this.f11188e == null) {
            this.f11189f = this.f11187d.mo2326a();
        }
        this.f11188e++;
    }

    /* renamed from: a */
    public synchronized void mo2318a(Object obj, int i) {
        this.f11190g += (long) i;
    }

    /* renamed from: a */
    public synchronized void mo2317a(Object obj) {
        C2516a.m7019b(this.f11188e > null ? true : null);
        long a = this.f11187d.mo2326a();
        int i = (int) (a - this.f11189f);
        long j = (long) i;
        this.f11191h += j;
        this.f11192i += this.f11190g;
        if (i > 0) {
            this.f11186c.m7143a((int) Math.sqrt((double) this.f11190g), (float) ((this.f11190g * 8000) / j));
            if (this.f11191h >= 2000 || this.f11192i >= 524288) {
                obj = this.f11186c.m7142a(0.5f);
                this.f11193j = Float.isNaN(obj) ? -1 : (long) obj;
            }
        }
        m13772a(i, this.f11190g, this.f11193j);
        obj = this.f11188e - 1;
        this.f11188e = obj;
        if (obj > null) {
            this.f11189f = a;
        }
        this.f11190g = 0;
    }

    /* renamed from: a */
    private void m13772a(int i, long j, long j2) {
        if (this.f11184a != null && this.f11185b != null) {
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            this.f11184a.post(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C4242l f6359d;

                public void run() {
                    this.f6359d.f11185b.m6947a(i2, j3, j4);
                }
            });
        }
    }
}
