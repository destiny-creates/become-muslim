package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.p170d.C2629a;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class aru extends C4363a {
    public static final Creator<aru> CREATOR = new arv();
    /* renamed from: a */
    public final String f28300a;

    public aru(C2629a c2629a) {
        this.f28300a = c2629a.a();
    }

    aru(String str) {
        this.f28300a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 15, this.f28300a, false);
        C2835c.a(parcel, i);
    }
}
