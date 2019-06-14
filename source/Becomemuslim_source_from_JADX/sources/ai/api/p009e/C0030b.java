package ai.api.p009e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import java.util.LinkedList;

/* compiled from: RecognizerChecker */
/* renamed from: ai.api.e.b */
public class C0030b {
    /* renamed from: a */
    public static ComponentName m85a(Context context) {
        return C0030b.m86a(context, C0030b.m87a());
    }

    /* renamed from: a */
    private static ComponentName m86a(Context context, String str) {
        context = context.getPackageManager();
        Context<ResolveInfo> queryIntentServices = context != null ? context.queryIntentServices(new Intent("android.speech.RecognitionService"), 0) : new LinkedList();
        if (!(queryIntentServices.size() == 0 || str == null)) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && str.equals(serviceInfo.packageName)) {
                    return new ComponentName(serviceInfo.packageName, serviceInfo.name);
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static java.lang.String m88b(android.content.Context r2) {
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
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = ai.api.p009e.C0030b.m85a(r2);	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r2 == 0) goto L_0x0016;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x000a:
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x0019 }
        return r2;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0016:
        r2 = "";	 Catch:{ NameNotFoundException -> 0x0019 }
        return r2;
    L_0x0019:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.e.b.b(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private static String m87a() {
        return VERSION.SDK_INT >= 16 ? "com.google.android.googlequicksearchbox" : "com.google.android.voicesearch";
    }
}
