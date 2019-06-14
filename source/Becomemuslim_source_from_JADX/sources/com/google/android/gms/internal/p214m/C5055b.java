package com.google.android.gms.internal.p214m;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.m.b */
public class C5055b {
    /* renamed from: a */
    private static final ClassLoader f17348a = C5055b.class.getClassLoader();

    private C5055b() {
    }

    /* renamed from: a */
    public static void m21507a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m21508a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
