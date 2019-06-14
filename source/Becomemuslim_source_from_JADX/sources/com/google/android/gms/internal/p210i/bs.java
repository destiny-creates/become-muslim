package com.google.android.gms.internal.p210i;

import android.content.Context;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p184d.C2917b;

/* renamed from: com.google.android.gms.internal.i.bs */
public final class bs {
    /* renamed from: a */
    static Object f16435a = new Object();
    /* renamed from: b */
    static C2917b f16436b;
    /* renamed from: c */
    private static Boolean f16437c;

    /* renamed from: a */
    public static boolean m20353a(Context context) {
        C2872v.a(context);
        if (f16437c != null) {
            return f16437c.booleanValue();
        }
        context = bz.m20378a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f16437c = Boolean.valueOf(context);
        return context;
    }

    /* renamed from: a */
    public static void m20352a(android.content.Context r5, android.content.Intent r6) {
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
        r0 = com.google.android.gms.internal.p210i.C5008q.m21057a(r5);
        r0 = r0.m21063e();
        if (r6 != 0) goto L_0x0010;
    L_0x000a:
        r5 = "AnalyticsReceiver called with null intent";
        r0.m21040h(r5);
        return;
    L_0x0010:
        r6 = r6.getAction();
        r1 = "Local AnalyticsReceiver got";
        r0.m21026a(r1, r6);
        r1 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x0069;
    L_0x0021:
        r6 = com.google.android.gms.internal.p210i.bt.m20356a(r5);
        r1 = new android.content.Intent;
        r2 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r1.<init>(r2);
        r2 = new android.content.ComponentName;
        r3 = "com.google.android.gms.analytics.AnalyticsService";
        r2.<init>(r5, r3);
        r1.setComponent(r2);
        r2 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r1.setAction(r2);
        r2 = f16435a;
        monitor-enter(r2);
        r5.startService(r1);	 Catch:{ all -> 0x0066 }
        if (r6 != 0) goto L_0x0045;	 Catch:{ all -> 0x0066 }
    L_0x0043:
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        return;
    L_0x0045:
        r6 = f16436b;	 Catch:{ SecurityException -> 0x005f }
        if (r6 != 0) goto L_0x0057;	 Catch:{ SecurityException -> 0x005f }
    L_0x0049:
        r6 = new com.google.android.gms.d.b;	 Catch:{ SecurityException -> 0x005f }
        r1 = 1;	 Catch:{ SecurityException -> 0x005f }
        r3 = "Analytics WakeLock";	 Catch:{ SecurityException -> 0x005f }
        r6.<init>(r5, r1, r3);	 Catch:{ SecurityException -> 0x005f }
        f16436b = r6;	 Catch:{ SecurityException -> 0x005f }
        r5 = 0;	 Catch:{ SecurityException -> 0x005f }
        r6.a(r5);	 Catch:{ SecurityException -> 0x005f }
    L_0x0057:
        r5 = f16436b;	 Catch:{ SecurityException -> 0x005f }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ SecurityException -> 0x005f }
        r5.a(r3);	 Catch:{ SecurityException -> 0x005f }
        goto L_0x0064;
    L_0x005f:
        r5 = "Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.";	 Catch:{ all -> 0x0066 }
        r0.m21040h(r5);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        return;	 Catch:{ all -> 0x0066 }
    L_0x0066:
        r5 = move-exception;	 Catch:{ all -> 0x0066 }
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        throw r5;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bs.a(android.content.Context, android.content.Intent):void");
    }
}
