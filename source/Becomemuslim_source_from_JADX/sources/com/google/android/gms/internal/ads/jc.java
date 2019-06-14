package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

@cm
public final class jc {
    /* renamed from: a */
    int f15644a = -1;
    /* renamed from: b */
    private long f15645b = -1;
    /* renamed from: c */
    private long f15646c = -1;
    /* renamed from: d */
    private int f15647d = -1;
    /* renamed from: e */
    private long f15648e = 0;
    /* renamed from: f */
    private final Object f15649f = new Object();
    /* renamed from: g */
    private final String f15650g;
    /* renamed from: h */
    private int f15651h = 0;
    /* renamed from: i */
    private int f15652i = 0;

    public jc(String str) {
        this.f15650g = str;
    }

    /* renamed from: a */
    private static boolean m19592a(android.content.Context r5) {
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
        r0 = r5.getResources();
        r1 = "Theme.Translucent";
        r2 = "style";
        r3 = "android";
        r0 = r0.getIdentifier(r1, r2, r3);
        r1 = 0;
        if (r0 != 0) goto L_0x0017;
    L_0x0011:
        r5 = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";
        com.google.android.gms.internal.ads.mt.m19922d(r5);
        return r1;
    L_0x0017:
        r2 = new android.content.ComponentName;
        r3 = r5.getPackageName();
        r4 = "com.google.android.gms.ads.AdActivity";
        r2.<init>(r3, r4);
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0036 }
        r5 = r5.getActivityInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0036 }
        r5 = r5.theme;	 Catch:{ NameNotFoundException -> 0x0036 }
        if (r0 != r5) goto L_0x0030;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x002e:
        r5 = 1;	 Catch:{ NameNotFoundException -> 0x0036 }
        return r5;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0030:
        r5 = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";	 Catch:{ NameNotFoundException -> 0x0036 }
        com.google.android.gms.internal.ads.mt.m19922d(r5);	 Catch:{ NameNotFoundException -> 0x0036 }
        return r1;
    L_0x0036:
        r5 = "Fail to fetch AdActivity theme";
        com.google.android.gms.internal.ads.mt.m19924e(r5);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jc.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    public final Bundle m19593a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f15649f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f15650g);
            bundle.putLong("basets", this.f15646c);
            bundle.putLong("currts", this.f15645b);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f15647d);
            bundle.putInt("preqs_in_session", this.f15644a);
            bundle.putLong("time_in_session", this.f15648e);
            bundle.putInt("pclick", this.f15651h);
            bundle.putInt("pimp", this.f15652i);
            bundle.putBoolean("support_transparent_background", m19592a(context));
        }
        return bundle;
    }

    /* renamed from: a */
    public final void m19594a() {
        synchronized (this.f15649f) {
            this.f15651h++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m19595a(com.google.android.gms.internal.ads.aoq r10, long r11) {
        /*
        r9 = this;
        r0 = r9.f15649f;
        monitor-enter(r0);
        r1 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0091 }
        r1 = r1.m30847l();	 Catch:{ all -> 0x0091 }
        r1 = r1.m19672i();	 Catch:{ all -> 0x0091 }
        r3 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ all -> 0x0091 }
        r3 = r3.a();	 Catch:{ all -> 0x0091 }
        r5 = r9.f15646c;	 Catch:{ all -> 0x0091 }
        r7 = -1;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 != 0) goto L_0x004b;
    L_0x001f:
        r1 = r3 - r1;
        r5 = com.google.android.gms.internal.ads.asp.aI;	 Catch:{ all -> 0x0091 }
        r6 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0091 }
        r5 = r6.m18889a(r5);	 Catch:{ all -> 0x0091 }
        r5 = (java.lang.Long) r5;	 Catch:{ all -> 0x0091 }
        r5 = r5.longValue();	 Catch:{ all -> 0x0091 }
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x0039;
    L_0x0035:
        r1 = -1;
        r9.f15644a = r1;	 Catch:{ all -> 0x0091 }
        goto L_0x0047;
    L_0x0039:
        r1 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0091 }
        r1 = r1.m30847l();	 Catch:{ all -> 0x0091 }
        r1 = r1.m19673j();	 Catch:{ all -> 0x0091 }
        r9.f15644a = r1;	 Catch:{ all -> 0x0091 }
    L_0x0047:
        r9.f15646c = r11;	 Catch:{ all -> 0x0091 }
        r11 = r9.f15646c;	 Catch:{ all -> 0x0091 }
    L_0x004b:
        r9.f15645b = r11;	 Catch:{ all -> 0x0091 }
        r11 = 1;
        if (r10 == 0) goto L_0x0061;
    L_0x0050:
        r12 = r10.f28263c;	 Catch:{ all -> 0x0091 }
        if (r12 == 0) goto L_0x0061;
    L_0x0054:
        r10 = r10.f28263c;	 Catch:{ all -> 0x0091 }
        r12 = "gw";
        r1 = 2;
        r10 = r10.getInt(r12, r1);	 Catch:{ all -> 0x0091 }
        if (r10 != r11) goto L_0x0061;
    L_0x005f:
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        return;
    L_0x0061:
        r10 = r9.f15647d;	 Catch:{ all -> 0x0091 }
        r10 = r10 + r11;
        r9.f15647d = r10;	 Catch:{ all -> 0x0091 }
        r10 = r9.f15644a;	 Catch:{ all -> 0x0091 }
        r10 = r10 + r11;
        r9.f15644a = r10;	 Catch:{ all -> 0x0091 }
        r10 = r9.f15644a;	 Catch:{ all -> 0x0091 }
        if (r10 != 0) goto L_0x007f;
    L_0x006f:
        r10 = 0;
        r9.f15648e = r10;	 Catch:{ all -> 0x0091 }
        r10 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0091 }
        r10 = r10.m30847l();	 Catch:{ all -> 0x0091 }
        r10.m19656b(r3);	 Catch:{ all -> 0x0091 }
        goto L_0x008f;
    L_0x007f:
        r10 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0091 }
        r10 = r10.m30847l();	 Catch:{ all -> 0x0091 }
        r10 = r10.m19674k();	 Catch:{ all -> 0x0091 }
        r12 = 0;
        r3 = r3 - r10;
        r9.f15648e = r3;	 Catch:{ all -> 0x0091 }
    L_0x008f:
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        return;
    L_0x0091:
        r10 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0091 }
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jc.a(com.google.android.gms.internal.ads.aoq, long):void");
    }

    /* renamed from: b */
    public final void m19596b() {
        synchronized (this.f15649f) {
            this.f15652i++;
        }
    }
}
