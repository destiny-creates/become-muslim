package com.facebook.ads.internal.p105q.p106a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.internal.q.a.d */
public class C1496d {
    /* renamed from: a */
    public static <P, PR, R> AsyncTask<P, PR, R> m5269a(Executor executor, AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(executor, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    /* renamed from: a */
    public static void m5270a() {
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
        r0 = "android.os.AsyncTask";	 Catch:{ Throwable -> 0x0005 }
        java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.d.a():void");
    }

    /* renamed from: a */
    public static void m5271a(Context context, String str) {
        if (AdInternalSettings.isTestMode(context)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" (displayed for test ads only)");
            Log.d("FBAudienceNetworkLog", stringBuilder.toString());
        }
    }
}
