package com.facebook.ads.internal.p105q.p108c;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.ads.internal.q.c.a */
public abstract class C1531a extends WebView {
    /* renamed from: a */
    private static final String f4535a = "a";
    /* renamed from: b */
    private boolean f4536b;

    public C1531a(Context context) {
        super(context);
        m5361d();
    }

    /* renamed from: d */
    private void m5361d() {
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
        r4 = this;
        r0 = r4.mo997a();
        r4.setWebChromeClient(r0);
        r0 = r4.mo998b();
        r4.setWebViewClient(r0);
        com.facebook.ads.internal.p105q.p108c.C1532b.m5367b(r4);
        r0 = r4.getSettings();
        r1 = 1;
        r0.setJavaScriptEnabled(r1);
        r0 = r4.getSettings();
        r0.setDomStorageEnabled(r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 0;
        r3 = 17;
        if (r0 < r3) goto L_0x002e;
    L_0x0027:
        r0 = r4.getSettings();
        r0.setMediaPlaybackRequiresUserGesture(r2);
    L_0x002e:
        r4.setHorizontalScrollBarEnabled(r2);
        r4.setHorizontalScrollbarOverlay(r2);
        r4.setVerticalScrollBarEnabled(r2);
        r4.setVerticalScrollbarOverlay(r2);
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r0 < r2) goto L_0x004f;
    L_0x0040:
        r0 = android.webkit.CookieManager.getInstance();	 Catch:{ Exception -> 0x0048 }
        r0.setAcceptThirdPartyCookies(r4, r1);	 Catch:{ Exception -> 0x0048 }
        goto L_0x004f;
    L_0x0048:
        r0 = f4535a;
        r1 = "Failed to initialize CookieManager.";
        android.util.Log.w(r0, r1);
    L_0x004f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.a.d():void");
    }

    /* renamed from: a */
    protected WebChromeClient mo997a() {
        return new WebChromeClient();
    }

    /* renamed from: b */
    protected WebViewClient mo998b() {
        return new WebViewClient();
    }

    /* renamed from: c */
    public boolean m5364c() {
        return this.f4536b;
    }

    public void destroy() {
        this.f4536b = true;
        super.destroy();
    }
}
