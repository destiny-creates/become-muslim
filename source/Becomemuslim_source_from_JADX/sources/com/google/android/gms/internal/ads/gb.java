package com.google.android.gms.internal.ads;

final class gb implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ it f15509a;
    /* renamed from: b */
    private final /* synthetic */ fz f15510b;

    gb(fz fzVar, it itVar) {
        this.f15510b = fzVar;
        this.f15509a = itVar;
    }

    public final void run() {
        this.f15510b.b(new is(this.f15509a, null, null, null, null, null, null, null));
    }
}
