package com.google.android.gms.internal.p210i;

import android.os.Handler;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.au */
abstract class au {
    /* renamed from: b */
    private static volatile Handler f16359b;
    /* renamed from: a */
    private final C5008q f16360a;
    /* renamed from: c */
    private final Runnable f16361c = new av(this);
    /* renamed from: d */
    private volatile long f16362d;

    au(C5008q c5008q) {
        C2872v.a(c5008q);
        this.f16360a = c5008q;
    }

    /* renamed from: a */
    public abstract void mo4412a();

    /* renamed from: a */
    public final void m20303a(long j) {
        m20307d();
        if (j >= 0) {
            this.f16362d = this.f16360a.m21061c().a();
            if (!m20301e().postDelayed(this.f16361c, j)) {
                this.f16360a.m21063e().m21037e("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: b */
    public final void m20305b(long j) {
        if (!m20306c()) {
            return;
        }
        if (j < 0) {
            m20307d();
            return;
        }
        j -= Math.abs(this.f16360a.m21061c().a() - this.f16362d);
        if (j < 0) {
            j = 0;
        }
        m20301e().removeCallbacks(this.f16361c);
        if (!m20301e().postDelayed(this.f16361c, j)) {
            this.f16360a.m21063e().m21037e("Failed to adjust delayed post. time", Long.valueOf(j));
        }
    }

    /* renamed from: b */
    public final long m20304b() {
        if (this.f16362d == 0) {
            return 0;
        }
        return Math.abs(this.f16360a.m21061c().a() - this.f16362d);
    }

    /* renamed from: c */
    public final boolean m20306c() {
        return this.f16362d != 0;
    }

    /* renamed from: d */
    public final void m20307d() {
        this.f16362d = 0;
        m20301e().removeCallbacks(this.f16361c);
    }

    /* renamed from: e */
    private final Handler m20301e() {
        if (f16359b != null) {
            return f16359b;
        }
        Handler handler;
        synchronized (au.class) {
            if (f16359b == null) {
                f16359b = new ck(this.f16360a.m21059a().getMainLooper());
            }
            handler = f16359b;
        }
        return handler;
    }
}
