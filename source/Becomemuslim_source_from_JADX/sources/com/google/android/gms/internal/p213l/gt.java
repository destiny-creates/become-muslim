package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.l.gt */
public class gt {
    /* renamed from: a */
    private static final ClassLoader f17250a = gt.class.getClassLoader();

    private gt() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m21380a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: a */
    public static void m21381a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* renamed from: a */
    public static void m21382a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static boolean m21383a(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
