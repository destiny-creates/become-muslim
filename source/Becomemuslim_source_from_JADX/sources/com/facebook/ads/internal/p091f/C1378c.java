package com.facebook.ads.internal.p091f;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.f.c */
public class C1378c implements UncaughtExceptionHandler {
    /* renamed from: a */
    private final UncaughtExceptionHandler f4007a;
    /* renamed from: b */
    private final Context f4008b;
    /* renamed from: c */
    private final Map<String, String> f4009c;

    public C1378c(UncaughtExceptionHandler uncaughtExceptionHandler, Context context, Map<String, String> map) {
        this.f4007a = uncaughtExceptionHandler;
        if (context != null) {
            this.f4008b = context.getApplicationContext();
            this.f4009c = map;
            return;
        }
        throw new IllegalArgumentException("Missing Context");
    }

    /* renamed from: a */
    private void m4712a(java.lang.Thread r2, java.lang.Throwable r3) {
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
        r0 = r1.f4007a;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.f4007a;
        r0.uncaughtException(r2, r3);
        goto L_0x0016;
    L_0x000a:
        r2 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0011 }
        android.os.Process.killProcess(r2);	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        r2 = 10;
        java.lang.System.exit(r2);	 Catch:{ Throwable -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.f.c.a(java.lang.Thread, java.lang.Throwable):void");
    }

    public void uncaughtException(java.lang.Thread r6, java.lang.Throwable r7) {
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
        r5 = this;
        r0 = com.facebook.ads.internal.p105q.p106a.C1514q.m5319a(r7);	 Catch:{ Exception -> 0x0039 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x0006:
        r1 = "com.facebook.ads";	 Catch:{ Exception -> 0x0039 }
        r1 = r0.contains(r1);	 Catch:{ Exception -> 0x0039 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x000e:
        r1 = new com.facebook.ads.internal.f.b;	 Catch:{ Exception -> 0x0039 }
        r2 = r5.f4009c;	 Catch:{ Exception -> 0x0039 }
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x0039 }
        r0 = r1.m4711a();	 Catch:{ Exception -> 0x0039 }
        r1 = "subtype";	 Catch:{ Exception -> 0x0039 }
        r2 = "crash";	 Catch:{ Exception -> 0x0039 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0039 }
        r1 = "subtype_code";	 Catch:{ Exception -> 0x0039 }
        r2 = "0";	 Catch:{ Exception -> 0x0039 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0039 }
        r1 = new com.facebook.ads.internal.f.d;	 Catch:{ Exception -> 0x0039 }
        r2 = com.facebook.ads.internal.p105q.p106a.C1511n.m5313b();	 Catch:{ Exception -> 0x0039 }
        r4 = com.facebook.ads.internal.p105q.p106a.C1511n.m5314c();	 Catch:{ Exception -> 0x0039 }
        r1.<init>(r2, r4, r0);	 Catch:{ Exception -> 0x0039 }
        r0 = r5.f4008b;	 Catch:{ Exception -> 0x0039 }
        com.facebook.ads.internal.p091f.C1380e.m4722a(r1, r0);	 Catch:{ Exception -> 0x0039 }
    L_0x0039:
        r5.m4712a(r6, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.f.c.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
