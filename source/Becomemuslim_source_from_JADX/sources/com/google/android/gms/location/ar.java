package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p211j.C5015a;
import com.google.android.gms.internal.p211j.ap;

public final class ar extends C5015a implements ap {
    ar(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    /* renamed from: a */
    public final void mo4776a(LocationAvailability locationAvailability) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) locationAvailability);
        m21089c(2, a);
    }

    /* renamed from: a */
    public final void mo4777a(LocationResult locationResult) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) locationResult);
        m21089c(1, a);
    }
}
