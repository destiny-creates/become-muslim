package com.facebook.ads.internal.p088c;

/* renamed from: com.facebook.ads.internal.c.c */
public class C1357c {

    /* renamed from: com.facebook.ads.internal.c.c$a */
    public static class C1356a {
        /* renamed from: a */
        public String f3942a;
        /* renamed from: b */
        public String f3943b;
        /* renamed from: c */
        public boolean f3944c;

        public C1356a(String str, String str2, boolean z) {
            this.f3942a = str;
            this.f3943b = str2;
            this.f3944c = z;
        }
    }

    /* renamed from: a */
    public static com.facebook.ads.internal.p088c.C1357c.C1356a m4644a(android.content.ContentResolver r11) {
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
        r0 = 0;
        r1 = 0;
        r2 = "aid";	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r3 = "androidid";	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r4 = "limit_tracking";	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r7 = new java.lang.String[]{r2, r3, r4};	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r2 = "content://com.facebook.katana.provider.AttributionIdProvider";	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r6 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r8 = 0;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r9 = 0;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r10 = 0;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r5 = r11;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r11 = r5.query(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        if (r11 == 0) goto L_0x0054;
    L_0x001c:
        r2 = r11.moveToFirst();	 Catch:{ Exception -> 0x0063 }
        if (r2 != 0) goto L_0x0023;	 Catch:{ Exception -> 0x0063 }
    L_0x0022:
        goto L_0x0054;	 Catch:{ Exception -> 0x0063 }
    L_0x0023:
        r2 = "aid";	 Catch:{ Exception -> 0x0063 }
        r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0063 }
        r2 = r11.getString(r2);	 Catch:{ Exception -> 0x0063 }
        r3 = "androidid";	 Catch:{ Exception -> 0x0063 }
        r3 = r11.getColumnIndex(r3);	 Catch:{ Exception -> 0x0063 }
        r3 = r11.getString(r3);	 Catch:{ Exception -> 0x0063 }
        r4 = "limit_tracking";	 Catch:{ Exception -> 0x0063 }
        r4 = r11.getColumnIndex(r4);	 Catch:{ Exception -> 0x0063 }
        r4 = r11.getString(r4);	 Catch:{ Exception -> 0x0063 }
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0063 }
        r5 = new com.facebook.ads.internal.c.c$a;	 Catch:{ Exception -> 0x0063 }
        r4 = r4.booleanValue();	 Catch:{ Exception -> 0x0063 }
        r5.<init>(r2, r3, r4);	 Catch:{ Exception -> 0x0063 }
        if (r11 == 0) goto L_0x0053;
    L_0x0050:
        r11.close();
    L_0x0053:
        return r5;
    L_0x0054:
        r2 = new com.facebook.ads.internal.c.c$a;	 Catch:{ Exception -> 0x0063 }
        r2.<init>(r1, r1, r0);	 Catch:{ Exception -> 0x0063 }
        if (r11 == 0) goto L_0x005e;
    L_0x005b:
        r11.close();
    L_0x005e:
        return r2;
    L_0x005f:
        r0 = move-exception;
        r11 = r1;
        goto L_0x006f;
    L_0x0062:
        r11 = r1;
    L_0x0063:
        r2 = new com.facebook.ads.internal.c.c$a;	 Catch:{ all -> 0x006e }
        r2.<init>(r1, r1, r0);	 Catch:{ all -> 0x006e }
        if (r11 == 0) goto L_0x006d;
    L_0x006a:
        r11.close();
    L_0x006d:
        return r2;
    L_0x006e:
        r0 = move-exception;
    L_0x006f:
        if (r11 == 0) goto L_0x0074;
    L_0x0071:
        r11.close();
    L_0x0074:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.c.c.a(android.content.ContentResolver):com.facebook.ads.internal.c.c$a");
    }
}
