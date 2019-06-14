package com.google.android.gms.maps.p216a;

import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.maps.model.C7853o;

/* renamed from: com.google.android.gms.maps.a.aa */
public abstract class aa extends C5025j implements C5105z {
    public aa() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6250a((C7853o) C5026k.m21175a(parcel, C7853o.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
