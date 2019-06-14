package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.maps.model.o */
public final class C7853o extends C4363a {
    public static final Creator<C7853o> CREATOR = new al();
    /* renamed from: a */
    public final LatLng f29285a;
    /* renamed from: b */
    public final String f29286b;
    /* renamed from: c */
    public final String f29287c;

    public C7853o(LatLng latLng, String str, String str2) {
        this.f29285a = latLng;
        this.f29286b = str;
        this.f29287c = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29285a, i, false);
        C2835c.a(parcel, 3, this.f29286b, false);
        C2835c.a(parcel, 4, this.f29287c, false);
        C2835c.a(parcel, a);
    }
}
