package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class ai extends C4363a {
    public static final Creator<ai> CREATOR = new aj();
    /* renamed from: a */
    private String f29354a;

    private ai() {
    }

    ai(String str) {
        this.f29354a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29354a, false);
        C2835c.a(parcel, i);
    }
}
