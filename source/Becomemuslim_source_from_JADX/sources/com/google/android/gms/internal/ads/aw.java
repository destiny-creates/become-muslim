package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ae;
import java.util.concurrent.Future;

@cm
public final class aw extends ji {
    /* renamed from: a */
    private final ap f28427a;
    /* renamed from: b */
    private final dp f28428b;
    /* renamed from: c */
    private final it f28429c;
    /* renamed from: d */
    private final ay f28430d;
    /* renamed from: e */
    private final Object f28431e;
    /* renamed from: f */
    private Future<is> f28432f;

    public aw(Context context, ae aeVar, it itVar, ahi ahi, ap apVar, atc atc) {
        this(itVar, apVar, new ay(context, aeVar, new lg(context), ahi, itVar, atc));
    }

    private aw(it itVar, ap apVar, ay ayVar) {
        this.f28431e = new Object();
        this.f28429c = itVar;
        this.f28428b = itVar.f15601b;
        this.f28427a = apVar;
        this.f28430d = ayVar;
    }

    /* renamed from: a */
    public final void mo6079a() {
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
        r48 = this;
        r1 = r48;
        r2 = 0;
        r3 = 0;
        r4 = r1.f28431e;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        monitor-enter(r4);	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r0 = r1.f28430d;	 Catch:{ all -> 0x0021 }
        r0 = com.google.android.gms.internal.ads.ju.m19679a(r0);	 Catch:{ all -> 0x0021 }
        r1.f28432f = r0;	 Catch:{ all -> 0x0021 }
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
        r0 = r1.f28432f;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r0 = r0.get(r4, r6);	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r0 = (com.google.android.gms.internal.ads.is) r0;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
        r2 = -2;
        r3 = r0;
        r8 = -2;
        goto L_0x0033;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
        throw r0;	 Catch:{ TimeoutException -> 0x0026, ExecutionException -> 0x0024, ExecutionException -> 0x0024, ExecutionException -> 0x0024 }
    L_0x0024:
        r8 = 0;
        goto L_0x0033;
    L_0x0026:
        r0 = "Timed out waiting for native ad.";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
        r2 = 2;
        r0 = r1.f28432f;
        r4 = 1;
        r0.cancel(r4);
        r8 = 2;
    L_0x0033:
        if (r3 == 0) goto L_0x0038;
    L_0x0035:
        r0 = r3;
        goto L_0x00d7;
    L_0x0038:
        r0 = new com.google.android.gms.internal.ads.is;
        r4 = r0;
        r2 = r1.f28429c;
        r2 = r2.f15600a;
        r5 = r2.f28547c;
        r6 = 0;
        r7 = 0;
        r9 = 0;
        r10 = 0;
        r2 = r1.f28428b;
        r11 = r2.f28606k;
        r2 = r1.f28428b;
        r12 = r2.f28605j;
        r2 = r1.f28429c;
        r2 = r2.f15600a;
        r14 = r2.f28553i;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r2 = r1.f28428b;
        r2 = r2.f28603h;
        r21 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15603d;
        r23 = r2;
        r2 = r1.f28428b;
        r2 = r2.f28601f;
        r24 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15605f;
        r26 = r2;
        r2 = r1.f28428b;
        r2 = r2.f28608m;
        r28 = r2;
        r2 = r1.f28428b;
        r2 = r2.f28609n;
        r30 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15607h;
        r31 = r2;
        r32 = 0;
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28575D;
        r36 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28576E;
        r37 = r2;
        r38 = 0;
        r39 = 0;
        r2 = r1.f28428b;
        r2 = r2.f28583L;
        r40 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15608i;
        r41 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28586O;
        r42 = r2;
        r43 = 0;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28588Q;
        r44 = r2;
        r45 = 0;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28590S;
        r46 = r2;
        r2 = r1.f28429c;
        r2 = r2.f15601b;
        r2 = r2.f28591T;
        r47 = r2;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    L_0x00d7:
        r2 = com.google.android.gms.internal.ads.jw.f15691a;
        r3 = new com.google.android.gms.internal.ads.ax;
        r3.<init>(r1, r0);
        r2.post(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aw.a():void");
    }

    public final void h_() {
        synchronized (this.f28431e) {
            if (this.f28432f != null) {
                this.f28432f.cancel(true);
            }
        }
    }
}
