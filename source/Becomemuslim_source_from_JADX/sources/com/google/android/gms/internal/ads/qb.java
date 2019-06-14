package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class qb implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15939a;
    /* renamed from: b */
    private final /* synthetic */ String f15940b;
    /* renamed from: c */
    private final /* synthetic */ int f15941c;
    /* renamed from: d */
    private final /* synthetic */ pz f15942d;

    qb(pz pzVar, String str, String str2, int i) {
        this.f15942d = pzVar;
        this.f15939a = str;
        this.f15940b = str2;
        this.f15941c = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f15939a);
        hashMap.put("cachedSrc", this.f15940b);
        hashMap.put("totalBytes", Integer.toString(this.f15941c));
        this.f15942d.m30993a("onPrecacheEvent", hashMap);
    }
}
