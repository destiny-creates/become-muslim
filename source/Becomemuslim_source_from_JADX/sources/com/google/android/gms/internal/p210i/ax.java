package com.google.android.gms.internal.p210i;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.ax */
public final class ax extends C6797o {
    /* renamed from: a */
    private boolean f28801a;
    /* renamed from: b */
    private boolean f28802b;
    /* renamed from: c */
    private final AlarmManager f28803c = ((AlarmManager) m21044k().getSystemService("alarm"));
    /* renamed from: d */
    private Integer f28804d;

    protected ax(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
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
        r4 = this;
        r4.m37749e();	 Catch:{ NameNotFoundException -> 0x0030 }
        r0 = com.google.android.gms.internal.p210i.as.m20290e();	 Catch:{ NameNotFoundException -> 0x0030 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0030 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ NameNotFoundException -> 0x0030 }
        if (r0 <= 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0030 }
    L_0x000d:
        r0 = r4.m21044k();	 Catch:{ NameNotFoundException -> 0x0030 }
        r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0030 }
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0030 }
        r3 = "com.google.android.gms.analytics.AnalyticsReceiver";	 Catch:{ NameNotFoundException -> 0x0030 }
        r2.<init>(r0, r3);	 Catch:{ NameNotFoundException -> 0x0030 }
        r0 = 0;	 Catch:{ NameNotFoundException -> 0x0030 }
        r0 = r1.getReceiverInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0030 }
        if (r0 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0030 }
    L_0x0023:
        r0 = r0.enabled;	 Catch:{ NameNotFoundException -> 0x0030 }
        if (r0 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0030 }
    L_0x0027:
        r0 = "Receiver registered for local dispatch.";	 Catch:{ NameNotFoundException -> 0x0030 }
        r4.m21036e(r0);	 Catch:{ NameNotFoundException -> 0x0030 }
        r0 = 1;	 Catch:{ NameNotFoundException -> 0x0030 }
        r4.f28801a = r0;	 Catch:{ NameNotFoundException -> 0x0030 }
    L_0x002f:
        return;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ax.a():void");
    }

    /* renamed from: b */
    public final boolean m37746b() {
        return this.f28801a;
    }

    /* renamed from: c */
    public final boolean m37747c() {
        return this.f28802b;
    }

    /* renamed from: d */
    public final void m37748d() {
        m31800z();
        C2872v.a(this.f28801a, "Receiver not registered");
        long e = as.m20290e();
        if (e > 0) {
            m37749e();
            long b = m21043j().b() + e;
            this.f28802b = true;
            ((Boolean) ba.f16369F.m20315a()).booleanValue();
            if (VERSION.SDK_INT >= 24) {
                m21036e("Scheduling upload with JobScheduler");
                Context k = m21044k();
                ComponentName componentName = new ComponentName(k, "com.google.android.gms.analytics.AnalyticsJobService");
                int g = m37744g();
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                JobInfo build = new Builder(g, componentName).setMinimumLatency(e).setOverrideDeadline(e << 1).setExtras(persistableBundle).build();
                m21026a("Scheduling job. JobID", Integer.valueOf(g));
                cc.m20386a(k, build, "com.google.android.gms", "DispatchAlarm");
                return;
            }
            m21036e("Scheduling upload with AlarmManager");
            this.f28803c.setInexactRepeating(2, b, e, m37743f());
        }
    }

    /* renamed from: f */
    private final PendingIntent m37743f() {
        Context k = m21044k();
        return PendingIntent.getBroadcast(k, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(k, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }

    /* renamed from: e */
    public final void m37749e() {
        this.f28802b = false;
        this.f28803c.cancel(m37743f());
        if (VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) m21044k().getSystemService("jobscheduler");
            int g = m37744g();
            m21026a("Cancelling job. JobID", Integer.valueOf(g));
            jobScheduler.cancel(g);
        }
    }

    /* renamed from: g */
    private final int m37744g() {
        if (this.f28804d == null) {
            String str = "analytics";
            String valueOf = String.valueOf(m21044k().getPackageName());
            this.f28804d = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.f28804d.intValue();
    }
}
