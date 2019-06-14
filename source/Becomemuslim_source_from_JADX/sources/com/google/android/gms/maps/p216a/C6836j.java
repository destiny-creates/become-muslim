package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.ac;

/* renamed from: com.google.android.gms.maps.a.j */
public abstract class C6836j extends C5025j implements C5097i {
    public C6836j() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6241a(ac.m31840a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
