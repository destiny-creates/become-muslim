package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class arb extends C4363a {
    public static final Creator<arb> CREATOR = new arc();
    /* renamed from: a */
    public final int f28294a;

    public arb(int i) {
        this.f28294a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28294a);
        C2835c.a(parcel, i);
    }
}
