package com.facebook.ads.internal.protocol;

import com.facebook.internal.AnalyticsEvents;

public enum AdPlacementType {
    BANNER("banner"),
    INSTREAM("instream"),
    INTERSTITIAL("interstitial"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    NATIVE_BANNER("native_banner"),
    REWARDED_VIDEO("rewarded_video"),
    UNKNOWN("unknown");
    
    /* renamed from: a */
    private String f4359a;

    private AdPlacementType(String str) {
        this.f4359a = str;
    }

    public static com.facebook.ads.internal.protocol.AdPlacementType fromString(java.lang.String r1) {
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
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r1 = UNKNOWN;
        return r1;
    L_0x0009:
        r0 = java.util.Locale.US;	 Catch:{ Exception -> 0x0014 }
        r1 = r1.toUpperCase(r0);	 Catch:{ Exception -> 0x0014 }
        r1 = valueOf(r1);	 Catch:{ Exception -> 0x0014 }
        return r1;
    L_0x0014:
        r1 = UNKNOWN;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.protocol.AdPlacementType.fromString(java.lang.String):com.facebook.ads.internal.protocol.AdPlacementType");
    }

    public String toString() {
        return this.f4359a;
    }
}
