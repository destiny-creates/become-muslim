package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.a.x */
public abstract class C6843x extends C5025j implements C5104w {
    public C6843x() {
        super("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6244a(C4325a.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
