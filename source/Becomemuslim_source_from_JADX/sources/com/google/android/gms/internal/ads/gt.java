package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class gt extends C4363a {
    public static final Creator<gt> CREATOR = new gu();
    /* renamed from: a */
    public final aoq f28663a;
    /* renamed from: b */
    public final String f28664b;

    public gt(aoq aoq, String str) {
        this.f28663a = aoq;
        this.f28664b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28663a, i, false);
        C2835c.a(parcel, 3, this.f28664b, false);
        C2835c.a(parcel, a);
    }
}
