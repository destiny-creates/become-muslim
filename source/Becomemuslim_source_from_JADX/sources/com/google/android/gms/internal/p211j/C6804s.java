package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import com.google.android.gms.location.C7837o;

/* renamed from: com.google.android.gms.internal.j.s */
public abstract class C6804s extends ab implements C5020r {
    public C6804s() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo6205a((C7837o) ap.m21095a(parcel, C7837o.CREATOR));
        return true;
    }
}
