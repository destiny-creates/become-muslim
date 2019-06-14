package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.ac;

/* renamed from: com.google.android.gms.maps.a.v */
public abstract class C6842v extends C5025j implements C5103u {
    public C6842v() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6238a(ac.m31840a(parcel.readStrongBinder()));
                break;
            case 2:
                mo6239b(ac.m31840a(parcel.readStrongBinder()));
                break;
            case 3:
                mo6240c(ac.m31840a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
