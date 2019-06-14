package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.maps.model.w */
public final class C7856w extends C4363a {
    public static final Creator<C7856w> CREATOR = new ao();
    /* renamed from: a */
    public final int f29310a;
    /* renamed from: b */
    public final int f29311b;
    /* renamed from: c */
    public final byte[] f29312c;

    public C7856w(int i, int i2, byte[] bArr) {
        this.f29310a = i;
        this.f29311b = i2;
        this.f29312c = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29310a);
        C2835c.a(parcel, 3, this.f29311b);
        C2835c.a(parcel, 4, this.f29312c, false);
        C2835c.a(parcel, i);
    }
}
