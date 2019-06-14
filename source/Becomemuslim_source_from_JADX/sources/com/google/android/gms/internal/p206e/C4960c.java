package com.google.android.gms.internal.p206e;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.e.c */
public class C4960c {
    /* renamed from: a */
    private static final ClassLoader f16204a = C4960c.class.getClassLoader();

    private C4960c() {
    }

    /* renamed from: a */
    public static boolean m20242a(Parcel parcel) {
        return parcel.readInt() != null ? true : null;
    }

    /* renamed from: a */
    public static void m20241a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m20238a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m20240a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: b */
    public static void m20243b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(null);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }

    /* renamed from: a */
    public static void m20239a(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
