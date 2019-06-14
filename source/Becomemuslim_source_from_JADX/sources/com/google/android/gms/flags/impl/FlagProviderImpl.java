package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.C3015a.C4416a;
import com.google.android.gms.flags.impl.C3017a.C4417a;
import com.google.android.gms.flags.impl.C3017a.C4418b;
import com.google.android.gms.flags.impl.C3017a.C4419c;
import com.google.android.gms.flags.impl.C3017a.C4420d;

@DynamiteApi
public class FlagProviderImpl extends C4416a {
    /* renamed from: a */
    private boolean f13552a = false;
    /* renamed from: b */
    private SharedPreferences f13553b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f13552a ? z : C4417a.m14688a(this.f13553b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f13552a ? i : C4418b.m14689a(this.f13553b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f13552a ? j : C4419c.m14690a(this.f13553b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f13552a ? str2 : C4420d.m14691a(this.f13553b, str, str2);
    }

    public void init(com.google.android.gms.p174b.C2758b r4) {
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
        r4 = com.google.android.gms.p174b.C4757d.m16685a(r4);
        r4 = (android.content.Context) r4;
        r0 = r3.f13552a;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r4 = r4.createPackageContext(r0, r1);	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r4 = com.google.android.gms.flags.impl.C3018b.m8867a(r4);	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r3.f13553b = r4;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r4 = 1;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        r3.f13552a = r4;	 Catch:{ NameNotFoundException -> 0x003c, Exception -> 0x001c }
        return;
    L_0x001c:
        r4 = move-exception;
        r0 = "FlagProviderImpl";
        r1 = "Could not retrieve sdk flags, continuing with defaults: ";
        r4 = r4.getMessage();
        r4 = java.lang.String.valueOf(r4);
        r2 = r4.length();
        if (r2 == 0) goto L_0x0034;
    L_0x002f:
        r4 = r1.concat(r4);
        goto L_0x0039;
    L_0x0034:
        r4 = new java.lang.String;
        r4.<init>(r1);
    L_0x0039:
        android.util.Log.w(r0, r4);
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.flags.impl.FlagProviderImpl.init(com.google.android.gms.b.b):void");
    }
}
