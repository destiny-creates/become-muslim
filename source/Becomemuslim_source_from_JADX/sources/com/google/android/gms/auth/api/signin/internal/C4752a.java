package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.auth.api.signin.internal.a */
public class C4752a extends C4363a {
    public static final Creator<C4752a> CREATOR = new C2743d();
    /* renamed from: a */
    private final int f13133a;
    /* renamed from: b */
    private int f13134b;
    /* renamed from: c */
    private Bundle f13135c;

    C4752a(int i, int i2, Bundle bundle) {
        this.f13133a = i;
        this.f13134b = i2;
        this.f13135c = bundle;
    }

    /* renamed from: a */
    public int m16673a() {
        return this.f13134b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13133a);
        C2835c.m8184a(parcel, 2, m16673a());
        C2835c.m8186a(parcel, 3, this.f13135c, false);
        C2835c.m8180a(parcel, i);
    }
}
