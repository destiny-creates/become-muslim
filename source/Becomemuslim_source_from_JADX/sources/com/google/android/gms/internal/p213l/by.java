package com.google.android.gms.internal.p213l;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

/* renamed from: com.google.android.gms.internal.l.by */
final class by implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ cg f17018a;
    /* renamed from: b */
    private final /* synthetic */ long f17019b;
    /* renamed from: c */
    private final /* synthetic */ Bundle f17020c;
    /* renamed from: d */
    private final /* synthetic */ Context f17021d;
    /* renamed from: e */
    private final /* synthetic */ bb f17022e;
    /* renamed from: f */
    private final /* synthetic */ PendingResult f17023f;

    by(bw bwVar, cg cgVar, long j, Bundle bundle, Context context, bb bbVar, PendingResult pendingResult) {
        this.f17018a = cgVar;
        this.f17019b = j;
        this.f17020c = bundle;
        this.f17021d = context;
        this.f17022e = bbVar;
        this.f17023f = pendingResult;
    }

    public final void run() {
        long a = this.f17018a.m31961c().f32331h.m21318a();
        long j = this.f17019b;
        if (a > 0 && (j >= a || j <= 0)) {
            j = a - 1;
        }
        if (j > 0) {
            this.f17020c.putLong("click_timestamp", j);
        }
        this.f17020c.putString("_cis", "referrer broadcast");
        AppMeasurement.getInstance(this.f17021d).logEventInternal("auto", "_cmp", this.f17020c);
        this.f17022e.m42579w().m21307a("Install campaign recorded");
        if (this.f17023f != null) {
            this.f17023f.finish();
        }
    }
}
