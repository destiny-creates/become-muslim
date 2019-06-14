package com.facebook.internal;

import java.util.HashSet;

public class FacebookSignatureValidator {
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL2_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    private static final HashSet<String> validAppSignatureHashes = buildAppSignatureHashes();

    private static HashSet<String> buildAppSignatureHashes() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add(FBR_HASH);
        hashSet.add(FBR2_HASH);
        hashSet.add(FBI_HASH);
        hashSet.add(FBL_HASH);
        hashSet.add(FBL2_HASH);
        hashSet.add(MSR_HASH);
        hashSet.add(FBF_HASH);
        return hashSet;
    }

    public static boolean validateSignature(android.content.Context r5, java.lang.String r6) {
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
        r0 = android.os.Build.BRAND;
        r1 = r5.getApplicationInfo();
        r1 = r1.flags;
        r2 = "generic";
        r0 = r0.startsWith(r2);
        r2 = 1;
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r1 & 2;
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r0 = 0;
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0049 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = r5.getPackageInfo(r6, r1);	 Catch:{ NameNotFoundException -> 0x0049 }
        r6 = r5.signatures;
        if (r6 == 0) goto L_0x0048;
    L_0x0025:
        r6 = r5.signatures;
        r6 = r6.length;
        if (r6 > 0) goto L_0x002b;
    L_0x002a:
        goto L_0x0048;
    L_0x002b:
        r5 = r5.signatures;
        r6 = r5.length;
        r1 = 0;
    L_0x002f:
        if (r1 >= r6) goto L_0x0047;
    L_0x0031:
        r3 = r5[r1];
        r3 = r3.toByteArray();
        r3 = com.facebook.internal.Utility.sha1hash(r3);
        r4 = validAppSignatureHashes;
        r3 = r4.contains(r3);
        if (r3 != 0) goto L_0x0044;
    L_0x0043:
        return r0;
    L_0x0044:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x0047:
        return r2;
    L_0x0048:
        return r0;
    L_0x0049:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookSignatureValidator.validateSignature(android.content.Context, java.lang.String):boolean");
    }
}
