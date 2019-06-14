package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.C2679l;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class ary extends C4363a {
    public static final Creator<ary> CREATOR = new arz();
    /* renamed from: a */
    public final boolean f28302a;
    /* renamed from: b */
    public final boolean f28303b;
    /* renamed from: c */
    public final boolean f28304c;

    public ary(C2679l c2679l) {
        this(c2679l.a(), c2679l.b(), c2679l.c());
    }

    public ary(boolean z, boolean z2, boolean z3) {
        this.f28302a = z;
        this.f28303b = z2;
        this.f28304c = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28302a);
        C2835c.a(parcel, 3, this.f28303b);
        C2835c.a(parcel, 4, this.f28304c);
        C2835c.a(parcel, i);
    }
}
