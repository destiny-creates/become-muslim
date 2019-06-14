package com.google.android.gms.internal.ads;

final class bal implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15137a;
    /* renamed from: b */
    private final /* synthetic */ bae f15138b;

    bal(bae bae, String str) {
        this.f15138b = bae;
        this.f15137a = str;
    }

    public final void run() {
        this.f15138b.f32207a.loadUrl(this.f15137a);
    }
}
