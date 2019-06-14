package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p208g.C4970a;
import com.google.android.gms.internal.p208g.ap;

public final class aa extends C4970a implements C3009y {
    aa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.data.IDataSourceListener");
    }

    /* renamed from: a */
    public final void mo2595a(DataPoint dataPoint) {
        Parcel a = a();
        ap.a(a, dataPoint);
        b(1, a);
    }
}
