package com.google.android.gms.internal.p209h;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.h.b */
public class C4978b {
    /* renamed from: a */
    private static final ClassLoader f16219a = C4978b.class.getClassLoader();

    private C4978b() {
    }

    /* renamed from: a */
    public static void m20266a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
