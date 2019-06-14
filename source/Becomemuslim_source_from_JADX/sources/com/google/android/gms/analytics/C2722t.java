package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.t */
final class C2722t implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2714o f6989a;
    /* renamed from: b */
    private final /* synthetic */ C2721s f6990b;

    C2722t(C2721s c2721s, C2714o c2714o) {
        this.f6990b = c2721s;
        this.f6989a = c2714o;
    }

    public final void run() {
        this.f6989a.m7753h().mo2355a(this.f6989a);
        for (C2724v a : this.f6990b.f6984c) {
            a.m7778a(this.f6989a);
        }
        C2721s.m7769b(this.f6989a);
    }
}
