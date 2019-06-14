package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class bex extends C4363a {
    public static final Creator<bex> CREATOR = new bey();
    /* renamed from: a */
    private final int f28498a;
    /* renamed from: b */
    private final int f28499b;
    /* renamed from: c */
    private final int f28500c;

    bex(int i, int i2, int i3) {
        this.f28498a = i;
        this.f28499b = i2;
        this.f28500c = i3;
    }

    /* renamed from: a */
    public static bex m37439a(tf tfVar) {
        return new bex(tfVar.f16037a, tfVar.f16038b, tfVar.f16039c);
    }

    public final String toString() {
        int i = this.f28498a;
        int i2 = this.f28499b;
        int i3 = this.f28500c;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append(i);
        stringBuilder.append(".");
        stringBuilder.append(i2);
        stringBuilder.append(".");
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28498a);
        C2835c.a(parcel, 2, this.f28499b);
        C2835c.a(parcel, 3, this.f28500c);
        C2835c.a(parcel, i);
    }
}
