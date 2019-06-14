package com.bugsnag.android;

import android.os.Bundle;

/* compiled from: ConfigFactory */
/* renamed from: com.bugsnag.android.k */
class C1090k {
    /* renamed from: a */
    static com.bugsnag.android.C1091l m3827a(android.content.Context r4, java.lang.String r5, boolean r6) {
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
        r4 = r4.getApplicationContext();
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r0 == 0) goto L_0x0027;
    L_0x000c:
        r2 = r4.getPackageManager();	 Catch:{ Exception -> 0x0022 }
        r3 = r4.getPackageName();	 Catch:{ Exception -> 0x0022 }
        r2 = r2.getApplicationInfo(r3, r1);	 Catch:{ Exception -> 0x0022 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x0022 }
        r3 = "com.bugsnag.android.API_KEY";	 Catch:{ Exception -> 0x0022 }
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x0022 }
        r5 = r2;
        goto L_0x0027;
    L_0x0022:
        r2 = "Bugsnag is unable to read api key from manifest.";
        com.bugsnag.android.ad.m3736b(r2);
    L_0x0027:
        if (r5 == 0) goto L_0x004b;
    L_0x0029:
        r2 = new com.bugsnag.android.l;
        r2.<init>(r5);
        r2.m3837b(r6);
        if (r0 == 0) goto L_0x004a;
    L_0x0033:
        r5 = r4.getPackageManager();	 Catch:{ Exception -> 0x0045 }
        r4 = r4.getPackageName();	 Catch:{ Exception -> 0x0045 }
        r4 = r5.getApplicationInfo(r4, r1);	 Catch:{ Exception -> 0x0045 }
        r4 = r4.metaData;	 Catch:{ Exception -> 0x0045 }
        com.bugsnag.android.C1090k.m3828a(r2, r4);	 Catch:{ Exception -> 0x0045 }
        goto L_0x004a;
    L_0x0045:
        r4 = "Bugsnag is unable to read config from manifest.";
        com.bugsnag.android.ad.m3736b(r4);
    L_0x004a:
        return r2;
    L_0x004b:
        r4 = new java.lang.NullPointerException;
        r5 = "You must provide a Bugsnag API key";
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.k.a(android.content.Context, java.lang.String, boolean):com.bugsnag.android.l");
    }

    /* renamed from: a */
    static void m3828a(C1091l c1091l, Bundle bundle) {
        c1091l.m3847e(bundle.getString("com.bugsnag.android.BUILD_UUID"));
        c1091l.m3831a(bundle.getString("com.bugsnag.android.APP_VERSION"));
        c1091l.m3850f(bundle.getString("com.bugsnag.android.RELEASE_STAGE"));
        if (bundle.containsKey("com.bugsnag.android.ENDPOINT")) {
            c1091l.m3832a(bundle.getString("com.bugsnag.android.ENDPOINT"), bundle.getString("com.bugsnag.android.SESSIONS_ENDPOINT"));
        }
        c1091l.m3833a(bundle.getBoolean("com.bugsnag.android.SEND_THREADS", true));
        c1091l.m3845d(bundle.getBoolean("com.bugsnag.android.PERSIST_USER_BETWEEN_SESSIONS", false));
        if (bundle.containsKey("com.bugsnag.android.AUTO_CAPTURE_SESSIONS")) {
            c1091l.m3841c(bundle.getBoolean("com.bugsnag.android.AUTO_CAPTURE_SESSIONS"));
        }
        c1091l.m3837b(bundle.getBoolean("com.bugsnag.android.ENABLE_EXCEPTION_HANDLER", true));
    }
}
