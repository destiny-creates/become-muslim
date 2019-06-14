package com.google.android.gms.internal.p213l;

import android.os.Handler;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.ai */
abstract class ai {
    /* renamed from: b */
    private static volatile Handler f16879b;
    /* renamed from: a */
    private final dd f16880a;
    /* renamed from: c */
    private final Runnable f16881c;
    /* renamed from: d */
    private volatile long f16882d;

    ai(dd ddVar) {
        C2872v.a(ddVar);
        this.f16880a = ddVar;
        this.f16881c = new aj(this, ddVar);
    }

    /* renamed from: d */
    private final Handler m21240d() {
        if (f16879b != null) {
            return f16879b;
        }
        Handler handler;
        synchronized (ai.class) {
            if (f16879b == null) {
                f16879b = new Handler(this.f16880a.mo4752n().getMainLooper());
            }
            handler = f16879b;
        }
        return handler;
    }

    /* renamed from: a */
    public abstract void mo4760a();

    /* renamed from: a */
    public final void m21242a(long j) {
        m21244c();
        if (j >= 0) {
            this.f16882d = this.f16880a.mo4751m().a();
            if (!m21240d().postDelayed(this.f16881c, j)) {
                this.f16880a.mo4754r().I_().m21308a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    /* renamed from: b */
    public final boolean m21243b() {
        return this.f16882d != 0;
    }

    /* renamed from: c */
    final void m21244c() {
        this.f16882d = 0;
        m21240d().removeCallbacks(this.f16881c);
    }
}
