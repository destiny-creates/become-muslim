package com.google.android.gms.internal.p204c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.c.h */
public class C4949h {
    /* renamed from: a */
    private static final ClassLoader f16195a = C4949h.class.getClassLoader();

    private C4949h() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m20221a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m20222a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
