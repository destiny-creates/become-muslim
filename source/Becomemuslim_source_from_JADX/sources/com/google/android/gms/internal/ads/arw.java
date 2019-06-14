package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.common.internal.p181a.C2835c;

@cm
public final class arw extends aou {
    public arw(aou aou) {
        super(aou.f28279a, aou.f28280b, aou.f28281c, aou.f28282d, aou.f28283e, aou.f28284f, aou.f28285g, aou.f28286h, aou.f28287i, aou.f28288j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.a, false);
        C2835c.a(parcel, 3, this.b);
        C2835c.a(parcel, 6, this.e);
        C2835c.a(parcel, i);
    }
}
