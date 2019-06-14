package com.google.android.gms.internal.p210i;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.i.am */
public final class am implements Parcelable {
    @Deprecated
    public static final Creator<am> CREATOR = new an();
    /* renamed from: a */
    private String f16349a;
    /* renamed from: b */
    private String f16350b;
    /* renamed from: c */
    private String f16351c;

    /* renamed from: a */
    public final String m20279a() {
        return this.f16349a;
    }

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    /* renamed from: b */
    public final String m20280b() {
        return this.f16351c;
    }

    @Deprecated
    am(Parcel parcel) {
        this.f16349a = parcel.readString();
        this.f16350b = parcel.readString();
        this.f16351c = parcel.readString();
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16349a);
        parcel.writeString(this.f16350b);
        parcel.writeString(this.f16351c);
    }
}
