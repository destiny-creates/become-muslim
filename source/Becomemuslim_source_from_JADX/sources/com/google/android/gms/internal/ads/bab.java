package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final /* synthetic */ class bab implements Runnable {
    /* renamed from: a */
    private final baa f15118a;
    /* renamed from: b */
    private final ae f15119b;
    /* renamed from: c */
    private final Map f15120c;

    bab(baa baa, ae aeVar, Map map) {
        this.f15118a = baa;
        this.f15119b = aeVar;
        this.f15120c = map;
    }

    public final void run() {
        baa baa = this.f15118a;
        this.f15119b.zza(baa.mo4357o(), this.f15120c);
    }
}
