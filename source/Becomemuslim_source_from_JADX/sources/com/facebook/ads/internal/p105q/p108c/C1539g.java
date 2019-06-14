package com.facebook.ads.internal.p105q.p108c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.common.util.UriUtil;

/* renamed from: com.facebook.ads.internal.q.c.g */
public class C1539g {
    /* renamed from: a */
    private Intent m5387a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent(null);
        if (VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    /* renamed from: a */
    public static void m5388a(com.facebook.ads.internal.p105q.p108c.C1539g r3, android.content.Context r4, android.net.Uri r5, java.lang.String r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r5.getScheme();
        r0 = com.facebook.ads.internal.p105q.p108c.C1539g.m5390a(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x000a:
        r0 = r5.getHost();
        r1 = "play.google.com";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0018;
    L_0x0016:
        r0 = 1;
        goto L_0x0019;
    L_0x0018:
        r0 = 0;
    L_0x0019:
        r1 = r5.getScheme();
        r2 = "market";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x002c;
    L_0x0025:
        if (r0 == 0) goto L_0x0028;
    L_0x0027:
        goto L_0x002c;
    L_0x0028:
        r3.m5395a(r4, r5, r6);
        goto L_0x002f;
    L_0x002c:
        r3.m5394a(r4, r5);	 Catch:{ c -> 0x0028 }
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.g.a(com.facebook.ads.internal.q.c.g, android.content.Context, android.net.Uri, java.lang.String):void");
    }

    /* renamed from: a */
    private boolean m5389a(Context context) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/")), 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m5390a(String str) {
        if (!UriUtil.HTTP_SCHEME.equalsIgnoreCase(str)) {
            if (!UriUtil.HTTPS_SCHEME.equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m5391b(Context context, Uri uri) {
        context.startActivity(m5393c(context, uri));
    }

    /* renamed from: b */
    private void m5392b(android.content.Context r4, android.net.Uri r5, java.lang.String r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = r4.getPackageName();
        r2 = "com.facebook.ads.AudienceNetworkActivity";
        r0.setClassName(r1, r2);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r1);
        r1 = "viewType";
        r2 = com.facebook.ads.internal.settings.C1550a.C1549a.BROWSER;
        r0.putExtra(r1, r2);
        r1 = "browserURL";
        r2 = r5.toString();
        r0.putExtra(r1, r2);
        r1 = "clientToken";
        r0.putExtra(r1, r6);
        r6 = "handlerTime";
        r1 = java.lang.System.currentTimeMillis();
        r0.putExtra(r6, r1);
        r4.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0035 }
        goto L_0x0045;
    L_0x0035:
        r6 = r4.getPackageName();
        r1 = "com.facebook.ads.InterstitialAdActivity";
        r0.setClassName(r6, r1);
        r4.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0042 }
        goto L_0x0045;
    L_0x0042:
        r3.m5391b(r4, r5);
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.g.b(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    /* renamed from: c */
    private Intent m5393c(Context context, Uri uri) {
        Intent a = m5387a(uri);
        a.addCategory("android.intent.category.BROWSABLE");
        a.addFlags(268435456);
        a.putExtra("com.android.browser.application_id", context.getPackageName());
        a.putExtra("create_new_tab", false);
        return a;
    }

    /* renamed from: a */
    public void m5394a(Context context, Uri uri) {
        if (m5389a(context)) {
            Intent c = m5393c(context, uri);
            c.setPackage("com.android.vending");
            context.startActivity(c);
            return;
        }
        throw new C1533c();
    }

    /* renamed from: a */
    public void m5395a(Context context, Uri uri, String str) {
        if (C1539g.m5390a(uri.getScheme()) && C1405a.m4826g(context)) {
            m5392b(context, uri, str);
        } else {
            m5391b(context, uri);
        }
    }
}
