package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C6820w;

/* renamed from: com.google.android.gms.maps.a.h */
public abstract class C6835h extends C5025j implements az {
    public C6835h() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6234a();
                break;
            case 2:
                mo6235a(C6820w.m31918a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
