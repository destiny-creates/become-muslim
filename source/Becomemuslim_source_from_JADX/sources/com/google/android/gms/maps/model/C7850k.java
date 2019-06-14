package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.maps.model.k */
public final class C7850k extends C4363a {
    public static final Creator<C7850k> CREATOR = new ai();
    /* renamed from: a */
    private static final String f29266a = "k";
    /* renamed from: b */
    private String f29267b;

    public C7850k(String str) {
        this.f29267b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29267b, false);
        C2835c.a(parcel, i);
    }
}
