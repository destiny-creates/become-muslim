package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;

/* renamed from: com.google.android.gms.maps.a.au */
public abstract class au extends C5025j implements at {
    public au() {
        super("com.google.android.gms.maps.internal.IOnCameraIdleListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6253a();
        parcel2.writeNoException();
        return true;
    }
}
