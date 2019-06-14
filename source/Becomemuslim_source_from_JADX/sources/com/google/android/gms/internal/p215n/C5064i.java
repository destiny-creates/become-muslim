package com.google.android.gms.internal.p215n;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.n.i */
public class C5064i {
    /* renamed from: a */
    private static final ClassLoader f17360a = C5064i.class.getClassLoader();

    private C5064i() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m21520a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m21521a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    /* renamed from: a */
    public static void m21522a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static boolean m21523a(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
