package com.google.android.gms.internal.ads;

final class pd implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ boolean f15875a;
    /* renamed from: b */
    private final /* synthetic */ oz f15876b;

    pd(oz ozVar, boolean z) {
        this.f15876b = ozVar;
        this.f15875a = z;
    }

    public final void run() {
        this.f15876b.m30937a("windowVisibilityChanged", "isVisible", String.valueOf(this.f15875a));
    }
}
