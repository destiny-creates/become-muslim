package com.google.android.gms.maps.p216a;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.internal.p212k.ac;

/* renamed from: com.google.android.gms.maps.a.ar */
public abstract class ar extends C5025j implements aq {
    public ar() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface a;
        switch (i) {
            case 1:
                a = mo6242a(ac.m31840a(parcel.readStrongBinder()));
                break;
            case 2:
                a = mo6243b(ac.m31840a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        C5026k.m21176a(parcel2, a);
        return true;
    }
}
