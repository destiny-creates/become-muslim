package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.a.l */
public abstract class C6837l extends C5025j implements C5098k {
    public C6837l() {
        super("com.google.android.gms.maps.internal.IOnMapClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6254a((LatLng) C5026k.m21175a(parcel, LatLng.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
