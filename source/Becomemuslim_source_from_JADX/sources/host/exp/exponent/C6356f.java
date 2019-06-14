package host.exp.exponent;

import android.os.Handler;

/* compiled from: ExpoHandler */
/* renamed from: host.exp.exponent.f */
public class C6356f {
    /* renamed from: a */
    private Handler f20618a;

    public C6356f(Handler handler) {
        this.f20618a = handler;
    }

    /* renamed from: a */
    public boolean m26075a(Runnable runnable) {
        return this.f20618a.post(runnable);
    }

    /* renamed from: a */
    public boolean m26076a(Runnable runnable, long j) {
        return this.f20618a.postDelayed(runnable, j);
    }

    /* renamed from: b */
    public void m26077b(Runnable runnable) {
        this.f20618a.removeCallbacks(runnable);
    }
}
