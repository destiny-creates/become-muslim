package com.facebook.ads.internal.p105q.p106a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;

/* renamed from: com.facebook.ads.internal.q.a.g */
public class C1504g {
    /* renamed from: a */
    private static final String f4447a = "g";

    /* renamed from: com.facebook.ads.internal.q.a.g$a */
    public enum C1503a {
        UNKNOWN(0),
        UNROOTED(1),
        ROOTED(2);
        
        /* renamed from: d */
        public final int f4446d;

        private C1503a(int i) {
            this.f4446d = i;
        }
    }

    /* renamed from: a */
    public static com.facebook.ads.internal.p105q.p106a.C1504g.C1503a m5290a() {
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
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.m5296c();	 Catch:{ Throwable -> 0x0020 }
        if (r0 != 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0020 }
    L_0x0006:
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.m5295b();	 Catch:{ Throwable -> 0x0020 }
        if (r0 != 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0020 }
    L_0x000c:
        r0 = "su";	 Catch:{ Throwable -> 0x0020 }
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.m5293a(r0);	 Catch:{ Throwable -> 0x0020 }
        if (r0 == 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0020 }
    L_0x0014:
        goto L_0x0017;	 Catch:{ Throwable -> 0x0020 }
    L_0x0015:
        r0 = 0;	 Catch:{ Throwable -> 0x0020 }
        goto L_0x0018;	 Catch:{ Throwable -> 0x0020 }
    L_0x0017:
        r0 = 1;	 Catch:{ Throwable -> 0x0020 }
    L_0x0018:
        if (r0 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0020 }
    L_0x001a:
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.C1503a.ROOTED;	 Catch:{ Throwable -> 0x0020 }
        return r0;	 Catch:{ Throwable -> 0x0020 }
    L_0x001d:
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.C1503a.UNROOTED;	 Catch:{ Throwable -> 0x0020 }
        return r0;
    L_0x0020:
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.C1503a.UNKNOWN;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.g.a():com.facebook.ads.internal.q.a.g$a");
    }

    /* renamed from: a */
    public static java.lang.String m5291a(android.content.Context r0) {
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
        r0 = com.facebook.ads.internal.p105q.p106a.C1504g.m5294b(r0);	 Catch:{ Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.g.a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private static PublicKey m5292a(Signature signature) {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getPublicKey();
    }

    /* renamed from: a */
    private static boolean m5293a(String str) {
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File name : listFiles) {
                            if (name.getName().equals(str)) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    /* renamed from: b */
    private static String m5294b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Signature a : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
            stringBuilder.append(C1506i.m5302a(MessageDigest.getInstance("SHA1").digest(C1504g.m5292a(a).getEncoded())));
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static boolean m5295b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: c */
    private static boolean m5296c() {
        return new File("/system/app/Superuser.apk").exists();
    }
}
