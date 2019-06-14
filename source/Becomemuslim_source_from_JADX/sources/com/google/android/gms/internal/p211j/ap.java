package com.google.android.gms.internal.p211j;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.j.ap */
public class ap {
    /* renamed from: a */
    private static final ClassLoader f16850a = ap.class.getClassLoader();

    private ap() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m21095a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m21096a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m21097a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m21098a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }
}
