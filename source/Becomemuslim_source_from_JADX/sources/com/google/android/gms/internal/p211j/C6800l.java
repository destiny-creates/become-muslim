package com.google.android.gms.internal.p211j;

import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.j.l */
public abstract class C6800l extends ab implements C5017k {
    public C6800l() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4640a((C7821e) ap.m21095a(parcel, C7821e.CREATOR));
        return true;
    }
}
