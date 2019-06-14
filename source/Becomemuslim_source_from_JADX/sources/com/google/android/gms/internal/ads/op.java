package com.google.android.gms.internal.ads;

final class op implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15858a;
    /* renamed from: b */
    private final /* synthetic */ String f15859b;
    /* renamed from: c */
    private final /* synthetic */ ol f15860c;

    op(ol olVar, String str, String str2) {
        this.f15860c = olVar;
        this.f15858a = str;
        this.f15859b = str2;
    }

    public final void run() {
        if (this.f15860c.f28731r != null) {
            this.f15860c.f28731r.mo4327a(this.f15858a, this.f15859b);
        }
    }
}
