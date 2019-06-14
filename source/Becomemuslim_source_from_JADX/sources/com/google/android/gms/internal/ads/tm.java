package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class tm extends C4363a {
    public static final Creator<tm> CREATOR = new tn();
    /* renamed from: a */
    private final int f28757a;
    /* renamed from: b */
    private final String f28758b;
    /* renamed from: c */
    private final String f28759c;

    tm(int i, String str, String str2) {
        this.f28757a = i;
        this.f28758b = str;
        this.f28759c = str2;
    }

    public tm(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28757a);
        C2835c.a(parcel, 2, this.f28758b, false);
        C2835c.a(parcel, 3, this.f28759c, false);
        C2835c.a(parcel, i);
    }
}
