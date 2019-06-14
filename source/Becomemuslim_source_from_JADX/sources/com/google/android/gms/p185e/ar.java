package com.google.android.gms.p185e;

import android.annotation.TargetApi;
import java.io.File;

/* renamed from: com.google.android.gms.e.ar */
final class ar {
    /* renamed from: a */
    private static int m8558a() {
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
        r0 = android.os.Build.VERSION.SDK;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        goto L_0x0024;
    L_0x0007:
        r0 = "Invalid version number: ";
        r1 = android.os.Build.VERSION.SDK;
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x001a;
    L_0x0015:
        r0 = r0.concat(r1);
        goto L_0x0020;
    L_0x001a:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0020:
        com.google.android.gms.p185e.bs.m8582a(r0);
        r0 = 0;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ar.a():int");
    }

    @TargetApi(9)
    /* renamed from: a */
    static boolean m8559a(String str) {
        if (ar.m8558a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
