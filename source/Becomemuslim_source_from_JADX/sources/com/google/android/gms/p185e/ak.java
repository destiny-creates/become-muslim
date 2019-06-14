package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;

/* renamed from: com.google.android.gms.e.ak */
final class ak extends aq {
    /* renamed from: a */
    private static final String f11611a = C4992a.f16280v.toString();
    /* renamed from: b */
    private static final String f11612b = ab.f16318f.toString();
    /* renamed from: c */
    private static final String f11613c = ab.f16288C.toString();
    /* renamed from: d */
    private static final String f11614d = ab.f16333u.toString();
    /* renamed from: e */
    private static final String f11615e = ab.f16289D.toString();

    public ak() {
        super(f11611a, f11612b);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.ct mo2506a(java.util.Map<java.lang.String, com.google.android.gms.internal.p210i.ct> r6) {
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
        r0 = f11612b;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.internal.p210i.ct) r0;
        if (r0 == 0) goto L_0x00f8;
    L_0x000a:
        r1 = com.google.android.gms.p185e.eu.m8736g();
        if (r0 != r1) goto L_0x0012;
    L_0x0010:
        goto L_0x00f8;
    L_0x0012:
        r0 = com.google.android.gms.p185e.eu.m8719a(r0);
        r1 = f11614d;
        r1 = r6.get(r1);
        r1 = (com.google.android.gms.internal.p210i.ct) r1;
        if (r1 != 0) goto L_0x0023;
    L_0x0020:
        r1 = "text";
        goto L_0x0027;
    L_0x0023:
        r1 = com.google.android.gms.p185e.eu.m8719a(r1);
    L_0x0027:
        r2 = f11615e;
        r2 = r6.get(r2);
        r2 = (com.google.android.gms.internal.p210i.ct) r2;
        if (r2 != 0) goto L_0x0034;
    L_0x0031:
        r2 = "base16";
        goto L_0x0038;
    L_0x0034:
        r2 = com.google.android.gms.p185e.eu.m8719a(r2);
    L_0x0038:
        r3 = 2;
        r4 = f11613c;
        r6 = r6.get(r4);
        r6 = (com.google.android.gms.internal.p210i.ct) r6;
        if (r6 == 0) goto L_0x004e;
    L_0x0043:
        r6 = com.google.android.gms.p185e.eu.m8731e(r6);
        r6 = r6.booleanValue();
        if (r6 == 0) goto L_0x004e;
    L_0x004d:
        r3 = 3;
    L_0x004e:
        r6 = "text";	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = r6.equals(r1);	 Catch:{ IllegalArgumentException -> 0x00ee }
        if (r6 == 0) goto L_0x005b;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0056:
        r6 = r0.getBytes();	 Catch:{ IllegalArgumentException -> 0x00ee }
        goto L_0x0083;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x005b:
        r6 = "base16";	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = r6.equals(r1);	 Catch:{ IllegalArgumentException -> 0x00ee }
        if (r6 == 0) goto L_0x0068;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0063:
        r6 = com.google.android.gms.p185e.fg.m8747a(r0);	 Catch:{ IllegalArgumentException -> 0x00ee }
        goto L_0x0083;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0068:
        r6 = "base64";	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = r6.equals(r1);	 Catch:{ IllegalArgumentException -> 0x00ee }
        if (r6 == 0) goto L_0x0075;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0070:
        r6 = android.util.Base64.decode(r0, r3);	 Catch:{ IllegalArgumentException -> 0x00ee }
        goto L_0x0083;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0075:
        r6 = "base64url";	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = r6.equals(r1);	 Catch:{ IllegalArgumentException -> 0x00ee }
        if (r6 == 0) goto L_0x00cf;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x007d:
        r6 = r3 | 8;	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = android.util.Base64.decode(r0, r6);	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x0083:
        r0 = "base16";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0090;
    L_0x008b:
        r6 = com.google.android.gms.p185e.fg.m8746a(r6);
        goto L_0x00ab;
    L_0x0090:
        r0 = "base64";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x009d;
    L_0x0098:
        r6 = android.util.Base64.encodeToString(r6, r3);
        goto L_0x00ab;
    L_0x009d:
        r0 = "base64url";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x00b0;
    L_0x00a5:
        r0 = r3 | 8;
        r6 = android.util.Base64.encodeToString(r6, r0);
    L_0x00ab:
        r6 = com.google.android.gms.p185e.eu.m8716a(r6);
        return r6;
    L_0x00b0:
        r6 = "Encode: unknown output format: ";
        r0 = java.lang.String.valueOf(r2);
        r1 = r0.length();
        if (r1 == 0) goto L_0x00c1;
    L_0x00bc:
        r6 = r6.concat(r0);
        goto L_0x00c7;
    L_0x00c1:
        r0 = new java.lang.String;
        r0.<init>(r6);
        r6 = r0;
    L_0x00c7:
        com.google.android.gms.p185e.bs.m8582a(r6);
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
    L_0x00cf:
        r6 = "Encode: unknown input format: ";	 Catch:{ IllegalArgumentException -> 0x00ee }
        r0 = java.lang.String.valueOf(r1);	 Catch:{ IllegalArgumentException -> 0x00ee }
        r1 = r0.length();	 Catch:{ IllegalArgumentException -> 0x00ee }
        if (r1 == 0) goto L_0x00e0;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x00db:
        r6 = r6.concat(r0);	 Catch:{ IllegalArgumentException -> 0x00ee }
        goto L_0x00e6;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x00e0:
        r0 = new java.lang.String;	 Catch:{ IllegalArgumentException -> 0x00ee }
        r0.<init>(r6);	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = r0;	 Catch:{ IllegalArgumentException -> 0x00ee }
    L_0x00e6:
        com.google.android.gms.p185e.bs.m8582a(r6);	 Catch:{ IllegalArgumentException -> 0x00ee }
        r6 = com.google.android.gms.p185e.eu.m8736g();	 Catch:{ IllegalArgumentException -> 0x00ee }
        return r6;
    L_0x00ee:
        r6 = "Encode: invalid input:";
        com.google.android.gms.p185e.bs.m8582a(r6);
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
    L_0x00f8:
        r6 = com.google.android.gms.p185e.eu.m8736g();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ak.a(java.util.Map):com.google.android.gms.internal.i.ct");
    }
}
