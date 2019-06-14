package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

final class qa implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15933a;
    /* renamed from: b */
    private final /* synthetic */ String f15934b;
    /* renamed from: c */
    private final /* synthetic */ int f15935c;
    /* renamed from: d */
    private final /* synthetic */ int f15936d;
    /* renamed from: e */
    private final /* synthetic */ boolean f15937e = false;
    /* renamed from: f */
    private final /* synthetic */ pz f15938f;

    qa(pz pzVar, String str, String str2, int i, int i2, boolean z) {
        this.f15938f = pzVar;
        this.f15933a = str;
        this.f15934b = str2;
        this.f15935c = i;
        this.f15936d = i2;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f15933a);
        hashMap.put("cachedSrc", this.f15934b);
        hashMap.put("bytesLoaded", Integer.toString(this.f15935c));
        hashMap.put("totalBytes", Integer.toString(this.f15936d));
        hashMap.put("cacheReady", this.f15937e ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f15938f.m30993a("onPrecacheEvent", hashMap);
    }
}
