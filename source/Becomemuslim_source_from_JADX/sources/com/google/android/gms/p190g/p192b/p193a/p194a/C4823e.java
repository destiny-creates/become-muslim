package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.g.b.a.a.e */
public final class C4823e extends C4363a {
    public static final Creator<C4823e> CREATOR = new C3044f();
    /* renamed from: a */
    public int f13644a;
    /* renamed from: b */
    public int f13645b;
    /* renamed from: c */
    public int f13646c;
    /* renamed from: d */
    public boolean f13647d;
    /* renamed from: e */
    public boolean f13648e;
    /* renamed from: f */
    public float f13649f;

    public C4823e(int i, int i2, int i3, boolean z, boolean z2, float f) {
        this.f13644a = i;
        this.f13645b = i2;
        this.f13646c = i3;
        this.f13647d = z;
        this.f13648e = z2;
        this.f13649f = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 2, this.f13644a);
        C2835c.m8184a(parcel, 3, this.f13645b);
        C2835c.m8184a(parcel, 4, this.f13646c);
        C2835c.m8196a(parcel, 5, this.f13647d);
        C2835c.m8196a(parcel, 6, this.f13648e);
        C2835c.m8183a(parcel, 7, this.f13649f);
        C2835c.m8180a(parcel, i);
    }
}
