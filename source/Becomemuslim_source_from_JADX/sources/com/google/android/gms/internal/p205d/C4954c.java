package com.google.android.gms.internal.p205d;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.d.c */
public class C4954c {
    /* renamed from: a */
    private static final ClassLoader f16199a = C4954c.class.getClassLoader();

    private C4954c() {
    }

    /* renamed from: a */
    public static void m20233a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m20230a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m20232a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m20231a(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
