package com.google.android.gms.internal.p210i;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(24)
/* renamed from: com.google.android.gms.internal.i.cc */
public final class cc {
    /* renamed from: b */
    private static final Method f16451b = cc.m20388b();
    /* renamed from: c */
    private static final Method f16452c = cc.m20389c();
    /* renamed from: d */
    private static volatile ce f16453d = cd.f24458a;
    /* renamed from: a */
    private final JobScheduler f16454a;

    /* renamed from: b */
    private static java.lang.reflect.Method m20388b() {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x0037;
    L_0x0006:
        r0 = android.app.job.JobScheduler.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = "scheduleAsPackage";	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = 4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = android.app.job.JobInfo.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 1;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 2;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 3;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0026 }
        return r0;
        r0 = "JobSchedulerCompat";
        r1 = 6;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r0 = "JobSchedulerCompat";
        r1 = "No scheduleAsPackage method available, falling back to schedule";
        android.util.Log.e(r0, r1);
    L_0x0037:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.cc.b():java.lang.reflect.Method");
    }

    /* renamed from: c */
    private static java.lang.reflect.Method m20389c() {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 0;
        r2 = 24;
        if (r0 < r2) goto L_0x0021;
    L_0x0007:
        r0 = android.os.UserHandle.class;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r2 = "myUserId";	 Catch:{ NoSuchMethodException -> 0x0010 }
        r0 = r0.getDeclaredMethod(r2, r1);	 Catch:{ NoSuchMethodException -> 0x0010 }
        return r0;
        r0 = "JobSchedulerCompat";
        r2 = 6;
        r0 = android.util.Log.isLoggable(r0, r2);
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = "JobSchedulerCompat";
        r2 = "No myUserId method available";
        android.util.Log.e(r0, r2);
    L_0x0021:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.cc.c():java.lang.reflect.Method");
    }

    /* renamed from: d */
    private static int m20390d() {
        if (f16452c != null) {
            try {
                return ((Integer) f16452c.invoke(null, new Object[0])).intValue();
            } catch (Throwable e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    private cc(JobScheduler jobScheduler) {
        this.f16454a = jobScheduler;
    }

    /* renamed from: a */
    private final int m20385a(JobInfo jobInfo, String str, int i, String str2) {
        if (f16451b != null) {
            try {
                return ((Integer) f16451b.invoke(this.f16454a, new Object[]{jobInfo, str, Integer.valueOf(i), str2})).intValue();
            } catch (String str3) {
                Log.e(str2, "error calling scheduleAsPackage", str3);
            }
        }
        return this.f16454a.schedule(jobInfo);
    }

    /* renamed from: a */
    public static int m20386a(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (f16451b != null && f16453d.mo4422a()) {
            if (context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == null) {
                return new cc(jobScheduler).m20385a(jobInfo, str, cc.m20390d(), str2);
            }
        }
        return jobScheduler.schedule(jobInfo);
    }
}
