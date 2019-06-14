package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.a */
public final class C2656a {
    /* renamed from: a */
    private static boolean m7541a(Context context, Intent intent, C2668t c2668t) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            jn.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            ax.m7464e();
            jw.a(context, intent);
            if (c2668t != null) {
                c2668t.mo3253g();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            jn.e(e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m7542a(android.content.Context r6, com.google.android.gms.ads.internal.overlay.C4739c r7, com.google.android.gms.ads.internal.overlay.C2668t r8) {
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
        r0 = 0;
        if (r7 != 0) goto L_0x0009;
    L_0x0003:
        r6 = "No intent data for launcher overlay.";
    L_0x0005:
        com.google.android.gms.internal.ads.jn.e(r6);
        return r0;
    L_0x0009:
        com.google.android.gms.internal.ads.asp.a(r6);
        r1 = r7.f13042f;
        if (r1 == 0) goto L_0x0017;
    L_0x0010:
        r7 = r7.f13042f;
        r6 = com.google.android.gms.ads.internal.overlay.C2656a.m7541a(r6, r7, r8);
        return r6;
    L_0x0017:
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = r7.f13037a;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0027;
    L_0x0024:
        r6 = "Open GMSG did not contain a URL.";
        goto L_0x0005;
    L_0x0027:
        r2 = r7.f13038b;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x003b;
    L_0x002f:
        r2 = r7.f13037a;
        r2 = android.net.Uri.parse(r2);
        r3 = r7.f13038b;
        r1.setDataAndType(r2, r3);
        goto L_0x0044;
    L_0x003b:
        r2 = r7.f13037a;
        r2 = android.net.Uri.parse(r2);
        r1.setData(r2);
    L_0x0044:
        r2 = "android.intent.action.VIEW";
        r1.setAction(r2);
        r2 = r7.f13039c;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0056;
    L_0x0051:
        r2 = r7.f13039c;
        r1.setPackage(r2);
    L_0x0056:
        r2 = r7.f13040d;
        r2 = android.text.TextUtils.isEmpty(r2);
        r3 = 1;
        if (r2 != 0) goto L_0x008f;
    L_0x005f:
        r2 = r7.f13040d;
        r4 = "/";
        r5 = 2;
        r2 = r2.split(r4, r5);
        r4 = r2.length;
        if (r4 >= r5) goto L_0x0088;
    L_0x006b:
        r6 = "Could not parse component name from open GMSG: ";
        r7 = r7.f13040d;
        r7 = java.lang.String.valueOf(r7);
        r8 = r7.length();
        if (r8 == 0) goto L_0x007e;
    L_0x0079:
        r6 = r6.concat(r7);
        goto L_0x0084;
    L_0x007e:
        r7 = new java.lang.String;
        r7.<init>(r6);
        r6 = r7;
    L_0x0084:
        com.google.android.gms.internal.ads.jn.e(r6);
        return r0;
    L_0x0088:
        r4 = r2[r0];
        r2 = r2[r3];
        r1.setClassName(r4, r2);
    L_0x008f:
        r7 = r7.f13041e;
        r2 = android.text.TextUtils.isEmpty(r7);
        if (r2 != 0) goto L_0x00a5;
    L_0x0097:
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x009c }
        goto L_0x00a2;
    L_0x009c:
        r7 = "Could not parse intent flags.";
        com.google.android.gms.internal.ads.jn.e(r7);
        r7 = 0;
    L_0x00a2:
        r1.addFlags(r7);
    L_0x00a5:
        r7 = com.google.android.gms.internal.ads.asp.cN;
        r0 = com.google.android.gms.internal.ads.aph.f();
        r7 = r0.a(r7);
        r7 = (java.lang.Boolean) r7;
        r7 = r7.booleanValue();
        if (r7 == 0) goto L_0x00c2;
    L_0x00b7:
        r7 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r1.addFlags(r7);
        r7 = "android.support.customtabs.extra.user_opt_out";
        r1.putExtra(r7, r3);
        goto L_0x00da;
    L_0x00c2:
        r7 = com.google.android.gms.internal.ads.asp.cM;
        r0 = com.google.android.gms.internal.ads.aph.f();
        r7 = r0.a(r7);
        r7 = (java.lang.Boolean) r7;
        r7 = r7.booleanValue();
        if (r7 == 0) goto L_0x00da;
    L_0x00d4:
        com.google.android.gms.ads.internal.ax.m7464e();
        com.google.android.gms.internal.ads.jw.b(r6, r1);
    L_0x00da:
        r6 = com.google.android.gms.ads.internal.overlay.C2656a.m7541a(r6, r1, r8);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.a.a(android.content.Context, com.google.android.gms.ads.internal.overlay.c, com.google.android.gms.ads.internal.overlay.t):boolean");
    }
}
