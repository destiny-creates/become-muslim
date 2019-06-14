package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;

/* renamed from: com.google.android.gms.e.av */
final class av extends aq {
    /* renamed from: a */
    private static final String f11619a = C4992a.f16282x.toString();
    /* renamed from: b */
    private static final String f11620b = ab.f16318f.toString();
    /* renamed from: c */
    private static final String f11621c = ab.f16314c.toString();
    /* renamed from: d */
    private static final String f11622d = ab.f16333u.toString();

    public av() {
        super(f11619a, f11620b);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.ct mo2506a(java.util.Map<java.lang.String, com.google.android.gms.internal.p210i.ct> r4) {
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
        r3 = this;
        r0 = f11620b;
        r0 = r4.get(r0);
        r0 = (com.google.android.gms.internal.p210i.ct) r0;
        if (r0 == 0) goto L_0x00a3;
    L_0x000a:
        r1 = com.google.android.gms.p185e.eu.m8736g();
        if (r0 != r1) goto L_0x0012;
    L_0x0010:
        goto L_0x00a3;
    L_0x0012:
        r0 = com.google.android.gms.p185e.eu.m8719a(r0);
        r1 = f11621c;
        r1 = r4.get(r1);
        r1 = (com.google.android.gms.internal.p210i.ct) r1;
        if (r1 != 0) goto L_0x0023;
    L_0x0020:
        r1 = "MD5";
        goto L_0x0027;
    L_0x0023:
        r1 = com.google.android.gms.p185e.eu.m8719a(r1);
    L_0x0027:
        r2 = f11622d;
        r4 = r4.get(r2);
        r4 = (com.google.android.gms.internal.p210i.ct) r4;
        if (r4 != 0) goto L_0x0034;
    L_0x0031:
        r4 = "text";
        goto L_0x0038;
    L_0x0034:
        r4 = com.google.android.gms.p185e.eu.m8719a(r4);
    L_0x0038:
        r2 = "text";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0045;
    L_0x0040:
        r4 = r0.getBytes();
        goto L_0x0051;
    L_0x0045:
        r2 = "base16";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0085;
    L_0x004d:
        r4 = com.google.android.gms.p185e.fg.m8747a(r0);
    L_0x0051:
        r0 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0065 }
        r0.update(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0065 }
        r4 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0065 }
        r4 = com.google.android.gms.p185e.fg.m8746a(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0065 }
        r4 = com.google.android.gms.p185e.eu.m8716a(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0065 }
        return r4;
        r4 = "Hash: unknown algorithm: ";
        r0 = java.lang.String.valueOf(r1);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0077;
    L_0x0072:
        r4 = r4.concat(r0);
        goto L_0x007d;
    L_0x0077:
        r0 = new java.lang.String;
        r0.<init>(r4);
        r4 = r0;
    L_0x007d:
        com.google.android.gms.p185e.bs.m8582a(r4);
        r4 = com.google.android.gms.p185e.eu.m8736g();
        return r4;
    L_0x0085:
        r0 = "Hash: unknown input format: ";
        r4 = java.lang.String.valueOf(r4);
        r1 = r4.length();
        if (r1 == 0) goto L_0x0096;
    L_0x0091:
        r4 = r0.concat(r4);
        goto L_0x009b;
    L_0x0096:
        r4 = new java.lang.String;
        r4.<init>(r0);
    L_0x009b:
        com.google.android.gms.p185e.bs.m8582a(r4);
        r4 = com.google.android.gms.p185e.eu.m8736g();
        return r4;
    L_0x00a3:
        r4 = com.google.android.gms.p185e.eu.m8736g();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.av.a(java.util.Map):com.google.android.gms.internal.i.ct");
    }
}
