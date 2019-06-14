package com.google.android.gms.internal.p213l;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.bw */
public final class bw {
    /* renamed from: a */
    private final bz f17015a;

    public bw(bz bzVar) {
        C2872v.a(bzVar);
        this.f17015a = bzVar;
    }

    /* renamed from: a */
    public static boolean m21331a(android.content.Context r4) {
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
        com.google.android.gms.common.internal.C2872v.a(r4);
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001e }
        if (r1 != 0) goto L_0x000b;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x000a:
        return r0;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x000b:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001e }
        r3 = "com.google.android.gms.measurement.AppMeasurementReceiver";	 Catch:{ NameNotFoundException -> 0x001e }
        r2.<init>(r4, r3);	 Catch:{ NameNotFoundException -> 0x001e }
        r4 = r1.getReceiverInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x001e }
        if (r4 == 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x0018:
        r4 = r4.enabled;	 Catch:{ NameNotFoundException -> 0x001e }
        if (r4 == 0) goto L_0x001e;
    L_0x001c:
        r4 = 1;
        return r4;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.bw.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    public final void m21332a(Context context, Intent intent) {
        cg a = cg.m31947a(context, null, null);
        bb r = a.mo4754r();
        if (intent == null) {
            r.m42565i().m21307a("Receiver called with null intent");
            return;
        }
        a.mo4755u();
        String action = intent.getAction();
        r.m42579w().m21308a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            intent = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            intent.setAction("com.google.android.gms.measurement.UPLOAD");
            r.m42579w().m21307a("Starting wakeful intent.");
            this.f17015a.mo4854a(context, intent);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a.mo4753q().m42612a(new bx(this, a, r));
            } catch (Exception e) {
                r.m42565i().m21308a("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult a2 = this.f17015a.mo4853a();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                r.m42579w().m21307a("Install referrer extras are null");
                if (a2 != null) {
                    a2.finish();
                }
                return;
            }
            r.m42567k().m21308a("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle a3 = a.m31969k().m42656a(Uri.parse(action));
            if (a3 == null) {
                r.m42579w().m21307a("No campaign defined in install referrer broadcast");
                if (a2 != null) {
                    a2.finish();
                    return;
                }
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
            if (longExtra == 0) {
                r.m42565i().m21307a("Install referrer is missing timestamp");
            }
            a.mo4753q().m42612a(new by(this, a, longExtra, a3, context, r, a2));
        }
    }
}
