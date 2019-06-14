package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p211j.C5015a;
import com.google.android.gms.internal.p211j.ap;

public final class au extends C5015a implements as {
    au(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    /* renamed from: a */
    public final void mo4778a(Location location) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) location);
        m21089c(1, a);
    }
}
