package com.google.android.gms.internal.p208g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.g.ap */
public class ap {
    /* renamed from: a */
    private static final ClassLoader f16215a = ap.class.getClassLoader();

    private ap() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m20255a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m20256a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
