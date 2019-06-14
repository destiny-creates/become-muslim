package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class alq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ali f14725a;
    /* renamed from: b */
    final /* synthetic */ WebView f14726b;
    /* renamed from: c */
    final /* synthetic */ boolean f14727c;
    /* renamed from: d */
    final /* synthetic */ alo f14728d;
    /* renamed from: e */
    private ValueCallback<String> f14729e = new alr(this);

    alq(alo alo, ali ali, WebView webView, boolean z) {
        this.f14728d = alo;
        this.f14725a = ali;
        this.f14726b = webView;
        this.f14727c = z;
    }

    public final void run() {
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
        r3 = this;
        r0 = r3.f14726b;
        r0 = r0.getSettings();
        r0 = r0.getJavaScriptEnabled();
        if (r0 == 0) goto L_0x001d;
    L_0x000c:
        r0 = r3.f14726b;	 Catch:{ Throwable -> 0x0016 }
        r1 = "(function() { return  {text:document.body.innerText}})();";	 Catch:{ Throwable -> 0x0016 }
        r2 = r3.f14729e;	 Catch:{ Throwable -> 0x0016 }
        r0.evaluateJavascript(r1, r2);	 Catch:{ Throwable -> 0x0016 }
        return;
    L_0x0016:
        r0 = r3.f14729e;
        r1 = "";
        r0.onReceiveValue(r1);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.alq.run():void");
    }
}
