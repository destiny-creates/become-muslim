package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;

/* renamed from: com.google.android.gms.maps.a.am */
public abstract class am extends C5025j implements al {
    public am() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6232a();
                break;
            case 2:
                mo6233b();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
