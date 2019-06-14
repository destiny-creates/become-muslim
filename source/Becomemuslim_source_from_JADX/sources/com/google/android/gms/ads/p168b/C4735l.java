package com.google.android.gms.ads.p168b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.ads.aqh;
import com.google.android.gms.internal.ads.aqi;
import com.google.android.gms.internal.ads.cm;

@cm
/* renamed from: com.google.android.gms.ads.b.l */
public final class C4735l extends C4363a {
    public static final Creator<C4735l> CREATOR = new C2623p();
    /* renamed from: a */
    private final boolean f12963a;
    /* renamed from: b */
    private final aqh f12964b;

    C4735l(boolean z, IBinder iBinder) {
        this.f12963a = z;
        this.f12964b = iBinder != null ? aqi.a(iBinder) : null;
    }

    /* renamed from: a */
    public final boolean m16414a() {
        return this.f12963a;
    }

    /* renamed from: b */
    public final aqh m16415b() {
        return this.f12964b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8196a(parcel, 1, m16414a());
        C2835c.m8187a(parcel, 2, this.f12964b == null ? null : this.f12964b.asBinder(), false);
        C2835c.m8180a(parcel, i);
    }
}
