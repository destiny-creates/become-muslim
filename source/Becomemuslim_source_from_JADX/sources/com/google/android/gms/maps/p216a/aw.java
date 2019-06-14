package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;

/* renamed from: com.google.android.gms.maps.a.aw */
public abstract class aw extends C5025j implements av {
    public aw() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6252a();
        parcel2.writeNoException();
        return true;
    }
}
