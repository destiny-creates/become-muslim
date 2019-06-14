package com.google.android.gms.internal.p213l;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.ex */
public final class ex<T extends Context & fb> {
    /* renamed from: a */
    private final T f17211a;

    public ex(T t) {
        C2872v.a(t);
        this.f17211a = t;
    }

    /* renamed from: a */
    private final void m21346a(Runnable runnable) {
        fm a = fm.m32020a(this.f17211a);
        a.mo4753q().m42612a(new fa(this, a, runnable));
    }

    /* renamed from: c */
    private final bb m21347c() {
        return cg.m31947a(this.f17211a, null, null).mo4754r();
    }

    /* renamed from: a */
    public final int m21348a(Intent intent, int i, int i2) {
        cg a = cg.m31947a(this.f17211a, null, null);
        bb r = a.mo4754r();
        if (intent == null) {
            r.m42565i().m21307a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a.mo4755u();
        r.m42579w().m21309a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            m21346a(new ey(this, i2, r, intent));
        }
        return 2;
    }

    /* renamed from: a */
    public final IBinder m21349a(Intent intent) {
        if (intent == null) {
            m21347c().I_().m21307a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new ci(fm.m32020a(this.f17211a));
        }
        m21347c().m42565i().m21308a("onBind received unknown action", action);
        return null;
    }

    /* renamed from: a */
    public final void m21350a() {
        cg a = cg.m31947a(this.f17211a, null, null);
        bb r = a.mo4754r();
        a.mo4755u();
        r.m42579w().m21307a("Local AppMeasurementService is starting up");
    }

    /* renamed from: a */
    final /* synthetic */ void m21351a(int i, bb bbVar, Intent intent) {
        if (((fb) this.f17211a).mo4857a(i)) {
            bbVar.m42579w().m21308a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            m21347c().m42579w().m21307a("Completed wakeful intent.");
            ((fb) this.f17211a).mo4856a(intent);
        }
    }

    /* renamed from: a */
    final /* synthetic */ void m21352a(bb bbVar, JobParameters jobParameters) {
        bbVar.m42579w().m21307a("AppMeasurementJobService processed last upload request.");
        ((fb) this.f17211a).mo4855a(jobParameters, false);
    }

    @TargetApi(24)
    /* renamed from: a */
    public final boolean m21353a(JobParameters jobParameters) {
        cg a = cg.m31947a(this.f17211a, null, null);
        bb r = a.mo4754r();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        a.mo4755u();
        r.m42579w().m21308a("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            m21346a(new ez(this, r, jobParameters));
        }
        return true;
    }

    /* renamed from: b */
    public final void m21354b() {
        cg a = cg.m31947a(this.f17211a, null, null);
        bb r = a.mo4754r();
        a.mo4755u();
        r.m42579w().m21307a("Local AppMeasurementService is shutting down");
    }

    /* renamed from: b */
    public final boolean m21355b(Intent intent) {
        if (intent == null) {
            m21347c().I_().m21307a("onUnbind called with null intent");
            return true;
        }
        m21347c().m42579w().m21308a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    /* renamed from: c */
    public final void m21356c(Intent intent) {
        if (intent == null) {
            m21347c().I_().m21307a("onRebind called with null intent");
            return;
        }
        m21347c().m42579w().m21308a("onRebind called. action", intent.getAction());
    }
}
