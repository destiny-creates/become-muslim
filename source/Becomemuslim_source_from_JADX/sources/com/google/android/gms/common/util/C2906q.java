package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.FileReader;

/* renamed from: com.google.android.gms.common.util.q */
public class C2906q {
    /* renamed from: a */
    private static String f7393a;
    /* renamed from: b */
    private static int f7394b;

    /* renamed from: a */
    public static String m8470a() {
        if (f7393a == null) {
            if (f7394b == 0) {
                f7394b = Process.myPid();
            }
            f7393a = C2906q.m8471a(f7394b);
        }
        return f7393a;
    }

    /* renamed from: a */
    private static java.lang.String m8471a(int r4) {
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
        r0 = 0;
        if (r4 > 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 25;
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r1 = "/proc/";	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r2.append(r1);	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r2.append(r4);	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r4 = "/cmdline";	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r2.append(r4);	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r4 = r2.toString();	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r4 = com.google.android.gms.common.util.C2906q.m8469a(r4);	 Catch:{ IOException -> 0x0037, all -> 0x0032 }
        r1 = r4.readLine();	 Catch:{ IOException -> 0x0038, all -> 0x002d }
        r1 = r1.trim();	 Catch:{ IOException -> 0x0038, all -> 0x002d }
        com.google.android.gms.common.util.C2902m.m8452a(r4);
        r0 = r1;
        goto L_0x003b;
    L_0x002d:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0033;
    L_0x0032:
        r4 = move-exception;
    L_0x0033:
        com.google.android.gms.common.util.C2902m.m8452a(r0);
        throw r4;
    L_0x0037:
        r4 = r0;
    L_0x0038:
        com.google.android.gms.common.util.C2902m.m8452a(r4);
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.q.a(int):java.lang.String");
    }

    /* renamed from: a */
    private static BufferedReader m8469a(String str) {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            return bufferedReader;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
