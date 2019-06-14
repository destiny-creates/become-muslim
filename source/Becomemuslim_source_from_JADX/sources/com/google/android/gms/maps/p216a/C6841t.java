package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.internal.p212k.ac;

/* renamed from: com.google.android.gms.maps.a.t */
public abstract class C6841t extends C5025j implements C5102s {
    public C6841t() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        boolean a = mo6237a(ac.m31840a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        C5026k.m21178a(parcel2, a);
        return true;
    }
}
