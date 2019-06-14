package com.facebook.ads.internal.p105q.p106a;

import com.facebook.imageutils.JfifUtil;
import java.io.File;

/* renamed from: com.facebook.ads.internal.q.a.i */
public class C1506i {
    /* renamed from: a */
    public static java.lang.String m5300a(java.io.File r4) {
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
        r0 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x003e }
        r0.<init>(r4);	 Catch:{ FileNotFoundException -> 0x003e }
        r4 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r4 = java.security.MessageDigest.getInstance(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r1 = new byte[r1];	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
    L_0x000f:
        r2 = r0.read(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        if (r2 <= 0) goto L_0x0019;	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
    L_0x0015:
        r3 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r4.update(r1, r3, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
    L_0x0019:
        r3 = -1;	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        if (r2 != r3) goto L_0x000f;	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
    L_0x001c:
        r4 = r4.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r4 = com.facebook.ads.internal.p105q.p106a.C1506i.m5303b(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0032, IOException -> 0x002a }
        r0.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        return r4;
    L_0x0028:
        r4 = move-exception;
        goto L_0x003a;
    L_0x002a:
        r4 = new java.lang.Exception;	 Catch:{ all -> 0x0028 }
        r1 = "IO exception.";	 Catch:{ all -> 0x0028 }
        r4.<init>(r1);	 Catch:{ all -> 0x0028 }
        throw r4;	 Catch:{ all -> 0x0028 }
    L_0x0032:
        r4 = new java.lang.Exception;	 Catch:{ all -> 0x0028 }
        r1 = "No such algorithm.";	 Catch:{ all -> 0x0028 }
        r4.<init>(r1);	 Catch:{ all -> 0x0028 }
        throw r4;	 Catch:{ all -> 0x0028 }
    L_0x003a:
        r0.close();	 Catch:{ IOException -> 0x003d }
    L_0x003d:
        throw r4;
    L_0x003e:
        r4 = new java.lang.Exception;
        r0 = "File not found or not accessible.";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.i.a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    public static final String m5301a(String str) {
        return C1506i.m5300a(new File(str));
    }

    /* renamed from: a */
    public static String m5302a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = (b >>> 4) & 15;
            int i2 = 0;
            while (true) {
                i = (i < 0 || i > 9) ? (i - 10) + 97 : i + 48;
                stringBuilder.append((char) i);
                i = b & 15;
                int i3 = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i3;
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m5303b(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & JfifUtil.MARKER_FIRST_BYTE) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }
}
