package com.google.android.gms.internal.p210i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C2721s;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.i.f */
public final class C7816f extends C6797o {
    /* renamed from: a */
    private final ad f28902a;

    public C7816f(C5008q c5008q, C5010s c5010s) {
        super(c5008q);
        C2872v.a(c5010s);
        this.f28902a = new ad(c5008q, c5010s);
    }

    /* renamed from: a */
    protected final void mo6145a() {
        this.f28902a.m31797A();
    }

    /* renamed from: b */
    public final void m37940b() {
        this.f28902a.m37725b();
    }

    /* renamed from: a */
    public final void m37936a(int i) {
        m31800z();
        m21029b("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        m21047n().a(new C4997g(this, i));
    }

    /* renamed from: a */
    public final long m37934a(C5011t c5011t) {
        m31800z();
        C2872v.a(c5011t);
        C2721s.d();
        long a = this.f28902a.m37718a(c5011t, true);
        if (a == 0) {
            this.f28902a.m37723a(c5011t);
        }
        return a;
    }

    /* renamed from: a */
    public final void m37938a(bg bgVar) {
        C2872v.a(bgVar);
        m31800z();
        m21029b("Hit delivery requested", bgVar);
        m21047n().a(new C5002j(this, bgVar));
    }

    /* renamed from: c */
    public final void m37941c() {
        m31800z();
        m21047n().a(new C5003k(this));
    }

    /* renamed from: a */
    public final void m37937a(ay ayVar) {
        m31800z();
        m21047n().a(new C5004l(this, ayVar));
    }

    /* renamed from: d */
    public final void m37942d() {
        m31800z();
        Context k = m21044k();
        if (bs.m20353a(k) && bt.m20356a(k)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(k, "com.google.android.gms.analytics.AnalyticsService"));
            k.startService(intent);
            return;
        }
        m37937a(null);
    }

    /* renamed from: e */
    public final boolean m37943e() {
        m31800z();
        try {
            m21047n().a(new C5005m(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            m21034d("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            m21037e("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            m21034d("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    /* renamed from: f */
    public final void m37944f() {
        m31800z();
        C2721s.d();
        C5006n c5006n = this.f28902a;
        C2721s.d();
        c5006n.m31800z();
        c5006n.m21036e("Service disconnected");
    }

    /* renamed from: g */
    final void m37945g() {
        C2721s.d();
        this.f28902a.m37728e();
    }

    /* renamed from: h */
    final void m37946h() {
        C2721s.d();
        this.f28902a.m37727d();
    }

    /* renamed from: a */
    public final void m37939a(String str, Runnable runnable) {
        C2872v.a(str, "campaign param can't be empty");
        m21047n().a(new C4999i(this, str, runnable));
    }
}
