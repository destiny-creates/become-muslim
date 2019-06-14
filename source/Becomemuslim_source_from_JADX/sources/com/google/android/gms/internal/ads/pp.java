package com.google.android.gms.internal.ads;

@cm
final class pp implements Runnable {
    /* renamed from: a */
    private oz f15919a;
    /* renamed from: b */
    private boolean f15920b = false;

    pp(oz ozVar) {
        this.f15919a = ozVar;
    }

    /* renamed from: c */
    private final void m20015c() {
        jw.f15691a.removeCallbacks(this);
        jw.f15691a.postDelayed(this, 250);
    }

    /* renamed from: a */
    public final void m20016a() {
        this.f15920b = true;
    }

    /* renamed from: b */
    public final void m20017b() {
        this.f15920b = false;
        m20015c();
    }

    public final void run() {
        if (!this.f15920b) {
            this.f15919a.m30961o();
            m20015c();
        }
    }
}
