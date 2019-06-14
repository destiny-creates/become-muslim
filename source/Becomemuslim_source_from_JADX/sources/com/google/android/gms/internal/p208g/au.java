package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.p187a.C4793b;
import com.google.android.gms.fitness.p187a.C4795h;
import com.google.android.gms.fitness.p187a.C4796k;

/* renamed from: com.google.android.gms.internal.g.au */
public final class au extends C4970a implements at {
    au(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
    }

    /* renamed from: a */
    public final void mo4404a(C4793b c4793b) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4793b);
        m20249a(1, a);
    }

    /* renamed from: a */
    public final void mo4405a(C4795h c4795h) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4795h);
        m20249a(2, a);
    }

    /* renamed from: a */
    public final void mo4406a(C4796k c4796k) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4796k);
        m20249a(3, a);
    }
}
