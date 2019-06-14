package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@UsedByNative("wrapper.cc")
/* renamed from: com.google.android.gms.g.b.a.a.b */
public final class C4822b extends C4363a {
    public static final Creator<C4822b> CREATOR = new C3047k();
    /* renamed from: a */
    public final float f13640a;
    /* renamed from: b */
    public final float f13641b;
    /* renamed from: c */
    public final int f13642c;
    /* renamed from: d */
    private final int f13643d;

    public C4822b(int i, float f, float f2, int i2) {
        this.f13643d = i;
        this.f13640a = f;
        this.f13641b = f2;
        this.f13642c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13643d);
        C2835c.m8183a(parcel, 2, this.f13640a);
        C2835c.m8183a(parcel, 3, this.f13641b);
        C2835c.m8184a(parcel, 4, this.f13642c);
        C2835c.m8180a(parcel, i);
    }
}
