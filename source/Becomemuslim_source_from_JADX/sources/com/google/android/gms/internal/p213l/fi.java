package com.google.android.gms.internal.p213l;

import android.annotation.TargetApi;
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
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.l.fi */
public final class fi extends fl {
    /* renamed from: b */
    private final AlarmManager f32831b = ((AlarmManager) mo4752n().getSystemService("alarm"));
    /* renamed from: c */
    private final ai f32832c;
    /* renamed from: d */
    private Integer f32833d;

    protected fi(fm fmVar) {
        super(fmVar);
        this.f32832c = new fj(this, fmVar.m32075o(), fmVar);
    }

    @TargetApi(24)
    /* renamed from: j */
    private final void m44254j() {
        JobScheduler jobScheduler = (JobScheduler) mo4752n().getSystemService("jobscheduler");
        mo4754r().m42579w().m21308a("Cancelling job. JobID", Integer.valueOf(m44255k()));
        jobScheduler.cancel(m44255k());
    }

    /* renamed from: k */
    private final int m44255k() {
        if (this.f32833d == null) {
            String str = "measurement";
            String valueOf = String.valueOf(mo4752n().getPackageName());
            this.f32833d = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.f32833d.intValue();
    }

    /* renamed from: v */
    private final PendingIntent m44256v() {
        Intent className = new Intent().setClassName(mo4752n(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo4752n(), 0, className, 0);
    }

    public final /* bridge */ /* synthetic */ ad E_() {
        return super.E_();
    }

    public final /* bridge */ /* synthetic */ C8339w F_() {
        return super.F_();
    }

    public final /* bridge */ /* synthetic */ fs G_() {
        return super.G_();
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m44258a(long j) {
        m42632I();
        mo4755u();
        if (!bw.m21331a(mo4752n())) {
            mo4754r().m42578v().m21307a("Receiver not registered/enabled");
        }
        mo4755u();
        if (!fw.m42640a(mo4752n(), false)) {
            mo4754r().m42578v().m21307a("Service not registered/enabled");
        }
        m44263f();
        long b = mo4751m().b() + j;
        if (j < Math.max(0, ((Long) as.f16912F.m21260b()).longValue()) && !this.f32832c.m21243b()) {
            mo4754r().m42579w().m21307a("Scheduling upload with DelayedRunnable");
            this.f32832c.m21242a(j);
        }
        mo4755u();
        if (VERSION.SDK_INT >= 24) {
            mo4754r().m42579w().m21307a("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) mo4752n().getSystemService("jobscheduler");
            Builder builder = new Builder(m44255k(), new ComponentName(mo4752n(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            mo4754r().m42579w().m21308a("Scheduling job. JobID", Integer.valueOf(m44255k()));
            jobScheduler.schedule(build);
            return;
        }
        mo4754r().m42579w().m21307a("Scheduling upload with AlarmManager");
        this.f32831b.setInexactRepeating(2, b, Math.max(((Long) as.f16907A.m21260b()).longValue(), j), m44256v());
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6850e() {
        this.f32831b.cancel(m44256v());
        if (VERSION.SDK_INT >= 24) {
            m44254j();
        }
        return false;
    }

    /* renamed from: f */
    public final void m44263f() {
        m42632I();
        this.f32831b.cancel(m44256v());
        this.f32832c.m21244c();
        if (VERSION.SDK_INT >= 24) {
            m44254j();
        }
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}
