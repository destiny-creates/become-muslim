package com.google.android.gms.internal.p212k;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.k.k */
public class C5026k {
    /* renamed from: a */
    private static final ClassLoader f16861a = C5026k.class.getClassLoader();

    private C5026k() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m21175a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m21176a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m21177a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m21178a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static boolean m21179a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: b */
    public static void m21180b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }
}
