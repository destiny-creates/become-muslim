package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C6808b;

/* renamed from: com.google.android.gms.maps.a.ae */
public abstract class ae extends C5025j implements ad {
    public ae() {
        super("com.google.android.gms.maps.internal.IOnPolylineClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6247a(C6808b.m31875a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
