package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ajn {
    /* renamed from: a */
    private static final ClassLoader f14606a = ajn.class.getClassLoader();

    private ajn() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m18501a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m18502a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m18503a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m18504a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static boolean m18505a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: b */
    public static ArrayList m18506b(Parcel parcel) {
        return parcel.readArrayList(f14606a);
    }

    /* renamed from: b */
    public static void m18507b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }
}
