package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.location.C5084q;

/* renamed from: com.google.android.gms.internal.j.ad */
final class ad extends C6802o {
    /* renamed from: a */
    private C2795b<Status> f28926a;

    public ad(C2795b<Status> c2795b) {
        this.f28926a = c2795b;
    }

    /* renamed from: a */
    private final void m38015a(int i) {
        if (this.f28926a == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
            return;
        }
        this.f28926a.a(C5084q.m21580b(C5084q.m21579a(i)));
        this.f28926a = null;
    }

    /* renamed from: a */
    public final void mo6202a(int i, PendingIntent pendingIntent) {
        m38015a(i);
    }

    /* renamed from: a */
    public final void mo6203a(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }

    /* renamed from: b */
    public final void mo6204b(int i, String[] strArr) {
        m38015a(i);
    }
}
