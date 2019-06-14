package com.google.android.gms.internal.p210i;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.os.Handler;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.bt */
public final class bt<T extends Context & bx> {
    /* renamed from: c */
    private static Boolean f16438c;
    /* renamed from: a */
    private final Handler f16439a = new ck();
    /* renamed from: b */
    private final T f16440b;

    public bt(T t) {
        C2872v.a(t);
        this.f16440b = t;
    }

    /* renamed from: a */
    public static boolean m20356a(Context context) {
        C2872v.a(context);
        if (f16438c != null) {
            return f16438c.booleanValue();
        }
        context = bz.m20377a(context, "com.google.android.gms.analytics.AnalyticsService");
        f16438c = Boolean.valueOf(context);
        return context;
    }

    /* renamed from: a */
    public final void m20358a() {
        C5008q.m21057a(this.f16440b).m21063e().m21036e("Local AnalyticsService is starting up");
    }

    /* renamed from: b */
    public final void m20362b() {
        C5008q.m21057a(this.f16440b).m21063e().m21036e("Local AnalyticsService is shutting down");
    }

    /* renamed from: a */
    public final int m20357a(android.content.Intent r4, int r5, int r6) {
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
        r5 = com.google.android.gms.internal.p210i.bs.f16435a;	 Catch:{ SecurityException -> 0x0015 }
        monitor-enter(r5);	 Catch:{ SecurityException -> 0x0015 }
        r0 = com.google.android.gms.internal.p210i.bs.f16436b;	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0010;	 Catch:{ all -> 0x0012 }
    L_0x0007:
        r1 = r0.b();	 Catch:{ all -> 0x0012 }
        if (r1 == 0) goto L_0x0010;	 Catch:{ all -> 0x0012 }
    L_0x000d:
        r0.a();	 Catch:{ all -> 0x0012 }
    L_0x0010:
        monitor-exit(r5);	 Catch:{ all -> 0x0012 }
        goto L_0x0015;	 Catch:{ all -> 0x0012 }
    L_0x0012:
        r0 = move-exception;	 Catch:{ all -> 0x0012 }
        monitor-exit(r5);	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ SecurityException -> 0x0015 }
    L_0x0015:
        r5 = r3.f16440b;
        r5 = com.google.android.gms.internal.p210i.C5008q.m21057a(r5);
        r5 = r5.m21063e();
        r0 = 2;
        if (r4 != 0) goto L_0x0028;
    L_0x0022:
        r4 = "AnalyticsService started with null intent";
        r5.m21040h(r4);
        return r0;
    L_0x0028:
        r4 = r4.getAction();
        r1 = "Local AnalyticsService called. startId, action";
        r2 = java.lang.Integer.valueOf(r6);
        r5.m21027a(r1, r2, r4);
        r1 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x0045;
    L_0x003d:
        r4 = new com.google.android.gms.internal.i.bu;
        r4.<init>(r3, r6, r5);
        r3.m20355a(r4);
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bt.a(android.content.Intent, int, int):int");
    }

    /* renamed from: a */
    private final void m20355a(Runnable runnable) {
        C5008q.m21057a(this.f16440b).m21066h().m37937a(new bw(this, runnable));
    }

    @TargetApi(24)
    /* renamed from: a */
    public final boolean m20361a(JobParameters jobParameters) {
        C5006n e = C5008q.m21057a(this.f16440b).m21063e();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        e.m21026a("Local AnalyticsJobService called. action", string);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            m20355a(new bv(this, e, jobParameters));
        }
        return true;
    }

    /* renamed from: a */
    final /* synthetic */ void m20360a(bl blVar, JobParameters jobParameters) {
        blVar.m21036e("AnalyticsJobService processed last dispatch request");
        ((bx) this.f16440b).m20363a(jobParameters, false);
    }

    /* renamed from: a */
    final /* synthetic */ void m20359a(int i, bl blVar) {
        if (((bx) this.f16440b).m20364a(i) != 0) {
            blVar.m21036e("Local AnalyticsService processed last dispatch request");
        }
    }
}
