package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.p168b.C2611d;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class aus extends C4363a {
    public static final Creator<aus> CREATOR = new aut();
    /* renamed from: a */
    public final int f28387a;
    /* renamed from: b */
    public final boolean f28388b;
    /* renamed from: c */
    public final int f28389c;
    /* renamed from: d */
    public final boolean f28390d;
    /* renamed from: e */
    public final int f28391e;
    /* renamed from: f */
    public final ary f28392f;

    public aus(int i, boolean z, int i2, boolean z2, int i3, ary ary) {
        this.f28387a = i;
        this.f28388b = z;
        this.f28389c = i2;
        this.f28390d = z2;
        this.f28391e = i3;
        this.f28392f = ary;
    }

    public aus(C2611d c2611d) {
        this(3, c2611d.a(), c2611d.b(), c2611d.c(), c2611d.d(), c2611d.e() != null ? new ary(c2611d.e()) : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28387a);
        C2835c.a(parcel, 2, this.f28388b);
        C2835c.a(parcel, 3, this.f28389c);
        C2835c.a(parcel, 4, this.f28390d);
        C2835c.a(parcel, 5, this.f28391e);
        C2835c.a(parcel, 6, this.f28392f, i, false);
        C2835c.a(parcel, a);
    }
}
