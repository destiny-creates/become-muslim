package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class aq extends C4363a {
    public static final Creator<aq> CREATOR = new ar();
    /* renamed from: a */
    Bundle f13214a;
    /* renamed from: b */
    C4776d[] f13215b;

    aq(Bundle bundle, C4776d[] c4776dArr) {
        this.f13214a = bundle;
        this.f13215b = c4776dArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8186a(parcel, 1, this.f13214a, false);
        C2835c.m8200a(parcel, 2, this.f13215b, i, false);
        C2835c.m8180a(parcel, a);
    }
}
