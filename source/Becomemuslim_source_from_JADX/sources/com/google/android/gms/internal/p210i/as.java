package com.google.android.gms.internal.p210i;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2906q;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.i.as */
public final class as {
    /* renamed from: a */
    private final C5008q f16355a;
    /* renamed from: b */
    private volatile Boolean f16356b;
    /* renamed from: c */
    private String f16357c;
    /* renamed from: d */
    private Set<Integer> f16358d;

    protected as(C5008q c5008q) {
        C2872v.a(c5008q);
        this.f16355a = c5008q;
    }

    /* renamed from: a */
    public final boolean m20297a() {
        if (this.f16356b == null) {
            synchronized (this) {
                if (this.f16356b == null) {
                    ApplicationInfo applicationInfo = this.f16355a.m21059a().getApplicationInfo();
                    String a = C2906q.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f16356b = Boolean.valueOf(z);
                    }
                    if ((this.f16356b == null || !this.f16356b.booleanValue()) && "com.google.android.gms.analytics".equals(a)) {
                        this.f16356b = Boolean.TRUE;
                    }
                    if (this.f16356b == null) {
                        this.f16356b = Boolean.TRUE;
                        this.f16355a.m21063e().m21042i("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f16356b.booleanValue();
    }

    /* renamed from: b */
    public static boolean m20287b() {
        return ((Boolean) ba.f16382a.m20315a()).booleanValue();
    }

    /* renamed from: c */
    public static int m20288c() {
        return ((Integer) ba.f16399r.m20315a()).intValue();
    }

    /* renamed from: d */
    public static long m20289d() {
        return ((Long) ba.f16387f.m20315a()).longValue();
    }

    /* renamed from: e */
    public static long m20290e() {
        return ((Long) ba.f16388g.m20315a()).longValue();
    }

    /* renamed from: f */
    public static int m20291f() {
        return ((Integer) ba.f16390i.m20315a()).intValue();
    }

    /* renamed from: g */
    public static int m20292g() {
        return ((Integer) ba.f16391j.m20315a()).intValue();
    }

    /* renamed from: h */
    public static String m20293h() {
        return (String) ba.f16393l.m20315a();
    }

    /* renamed from: i */
    public static String m20294i() {
        return (String) ba.f16392k.m20315a();
    }

    /* renamed from: j */
    public static String m20295j() {
        return (String) ba.f16394m.m20315a();
    }

    /* renamed from: k */
    public final java.util.Set<java.lang.Integer> m20298k() {
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
        r6 = this;
        r0 = com.google.android.gms.internal.p210i.ba.f16402u;
        r0 = r0.m20315a();
        r0 = (java.lang.String) r0;
        r1 = r6.f16358d;
        if (r1 == 0) goto L_0x0018;
    L_0x000c:
        r1 = r6.f16357c;
        if (r1 == 0) goto L_0x0018;
    L_0x0010:
        r1 = r6.f16357c;
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x003b;
    L_0x0018:
        r1 = ",";
        r1 = android.text.TextUtils.split(r0, r1);
        r2 = new java.util.HashSet;
        r2.<init>();
        r3 = r1.length;
        r4 = 0;
    L_0x0025:
        if (r4 >= r3) goto L_0x0037;
    L_0x0027:
        r5 = r1[r4];
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ NumberFormatException -> 0x0034 }
        r2.add(r5);	 Catch:{ NumberFormatException -> 0x0034 }
    L_0x0034:
        r4 = r4 + 1;
        goto L_0x0025;
    L_0x0037:
        r6.f16357c = r0;
        r6.f16358d = r2;
    L_0x003b:
        r0 = r6.f16358d;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.as.k():java.util.Set<java.lang.Integer>");
    }

    /* renamed from: l */
    public static long m20296l() {
        return ((Long) ba.f16406y.m20315a()).longValue();
    }
}
