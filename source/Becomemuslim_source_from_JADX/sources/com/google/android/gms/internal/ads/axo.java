package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class axo extends C4363a {
    public static final Creator<axo> CREATOR = new axp();
    /* renamed from: a */
    public final boolean f28441a;
    /* renamed from: b */
    public final String f28442b;
    /* renamed from: c */
    public final int f28443c;
    /* renamed from: d */
    public final byte[] f28444d;
    /* renamed from: e */
    public final String[] f28445e;
    /* renamed from: f */
    public final String[] f28446f;
    /* renamed from: g */
    public final boolean f28447g;
    /* renamed from: h */
    public final long f28448h;

    axo(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.f28441a = z;
        this.f28442b = str;
        this.f28443c = i;
        this.f28444d = bArr;
        this.f28445e = strArr;
        this.f28446f = strArr2;
        this.f28447g = z2;
        this.f28448h = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28441a);
        C2835c.a(parcel, 2, this.f28442b, false);
        C2835c.a(parcel, 3, this.f28443c);
        C2835c.a(parcel, 4, this.f28444d, false);
        C2835c.a(parcel, 5, this.f28445e, false);
        C2835c.a(parcel, 6, this.f28446f, false);
        C2835c.a(parcel, 7, this.f28447g);
        C2835c.a(parcel, 8, this.f28448h);
        C2835c.a(parcel, i);
    }
}
