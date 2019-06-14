package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.location.C5084q;

/* renamed from: com.google.android.gms.internal.j.ac */
final class ac extends C6802o {
    /* renamed from: a */
    private C2795b<Status> f28925a;

    public ac(C2795b<Status> c2795b) {
        this.f28925a = c2795b;
    }

    /* renamed from: a */
    public final void mo6202a(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    /* renamed from: a */
    public final void mo6203a(int i, String[] strArr) {
        if (this.f28925a == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        }
        this.f28925a.a(C5084q.m21580b(C5084q.m21579a(i)));
        this.f28925a = null;
    }

    /* renamed from: b */
    public final void mo6204b(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
}
