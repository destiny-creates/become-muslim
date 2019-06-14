package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0373d;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.internal.adapters.t */
public class C1339t extends BroadcastReceiver {
    /* renamed from: a */
    private String f3894a;
    /* renamed from: b */
    private Context f3895b;
    /* renamed from: c */
    private InterstitialAdapterListener f3896c;
    /* renamed from: d */
    private InterstitialAdapter f3897d;

    public C1339t(Context context, String str, InterstitialAdapter interstitialAdapter, InterstitialAdapterListener interstitialAdapterListener) {
        this.f3895b = context;
        this.f3894a = str;
        this.f3896c = interstitialAdapterListener;
        this.f3897d = interstitialAdapter;
    }

    /* renamed from: a */
    public void m4606a() {
        IntentFilter intentFilter = new IntentFilter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.impression.logged:");
        stringBuilder.append(this.f3894a);
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.displayed:");
        stringBuilder.append(this.f3894a);
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.dismissed:");
        stringBuilder.append(this.f3894a);
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.clicked:");
        stringBuilder.append(this.f3894a);
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.error:");
        stringBuilder.append(this.f3894a);
        intentFilter.addAction(stringBuilder.toString());
        C0373d.m1138a(this.f3895b).m1142a(this, intentFilter);
    }

    /* renamed from: b */
    public void m4607b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.f3895b;	 Catch:{ Exception -> 0x0009 }
        r0 = android.support.v4.content.C0373d.m1138a(r0);	 Catch:{ Exception -> 0x0009 }
        r0.m1141a(r1);	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.t.b():void");
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = intent.getAction().split(":")[0];
        if (this.f3896c == null) {
            return;
        }
        if (obj != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
                this.f3896c.onInterstitialAdClicked(this.f3897d, null, true);
            } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
                this.f3896c.onInterstitialAdDismissed(this.f3897d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
                this.f3896c.onInterstitialAdDisplayed(this.f3897d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
                this.f3896c.onInterstitialLoggingImpression(this.f3897d);
            } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
                this.f3896c.onInterstitialError(this.f3897d, AdError.INTERNAL_ERROR);
            }
        }
    }
}
