package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.af;

/* renamed from: com.google.android.gms.maps.a.ac */
public abstract class ac extends C5025j implements ab {
    public ac() {
        super("com.google.android.gms.maps.internal.IOnPolygonClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6246a(af.m31861a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
