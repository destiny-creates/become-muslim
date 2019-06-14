package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class eq extends C4363a {
    public static final Creator<eq> CREATOR = new er();
    /* renamed from: a */
    String f28649a;

    public eq(String str) {
        this.f28649a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28649a, false);
        C2835c.a(parcel, i);
    }
}
