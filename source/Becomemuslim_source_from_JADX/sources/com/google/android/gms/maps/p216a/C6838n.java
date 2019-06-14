package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;

/* renamed from: com.google.android.gms.maps.a.n */
public abstract class C6838n extends C5025j implements C5099m {
    public C6838n() {
        super("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6245a();
        parcel2.writeNoException();
        return true;
    }
}
