package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.j.o */
public abstract class C6802o extends ab implements C5018n {
    public C6802o() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6203a(parcel.readInt(), parcel.createStringArray());
                break;
            case 2:
                mo6204b(parcel.readInt(), parcel.createStringArray());
                break;
            case 3:
                mo6202a(parcel.readInt(), (PendingIntent) ap.m21095a(parcel, PendingIntent.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
