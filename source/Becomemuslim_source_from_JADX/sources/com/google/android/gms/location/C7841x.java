package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.location.x */
public final class C7841x extends C4363a {
    public static final Creator<C7841x> CREATOR = new C5089y();
    /* renamed from: a */
    private final String f29200a;
    /* renamed from: b */
    private final String f29201b;
    /* renamed from: c */
    private final String f29202c;

    C7841x(String str, String str2, String str3) {
        this.f29202c = str;
        this.f29200a = str2;
        this.f29201b = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29200a, false);
        C2835c.a(parcel, 2, this.f29201b, false);
        C2835c.a(parcel, 5, this.f29202c, false);
        C2835c.a(parcel, i);
    }
}
