package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.g.az */
public final class az extends C4970a implements ax {
    az(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    /* renamed from: a */
    public final void mo4407a(Status status) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) status);
        m20250b(1, a);
    }
}
