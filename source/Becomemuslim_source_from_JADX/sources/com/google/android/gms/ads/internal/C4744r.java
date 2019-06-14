package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.ads.cm;

@cm
/* renamed from: com.google.android.gms.ads.internal.r */
public final class C4744r extends C4363a {
    public static final Creator<C4744r> CREATOR = new C2673s();
    /* renamed from: a */
    public final boolean f13073a;
    /* renamed from: b */
    public final boolean f13074b;
    /* renamed from: c */
    public final boolean f13075c;
    /* renamed from: d */
    public final float f13076d;
    /* renamed from: e */
    public final int f13077e;
    /* renamed from: f */
    public final boolean f13078f;
    /* renamed from: g */
    public final boolean f13079g;
    /* renamed from: h */
    public final boolean f13080h;
    /* renamed from: i */
    private final String f13081i;

    C4744r(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.f13073a = z;
        this.f13074b = z2;
        this.f13081i = str;
        this.f13075c = z3;
        this.f13076d = f;
        this.f13077e = i;
        this.f13078f = z4;
        this.f13079g = z5;
        this.f13080h = z6;
    }

    public C4744r(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f, i, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8196a(parcel, 2, this.f13073a);
        C2835c.m8196a(parcel, 3, this.f13074b);
        C2835c.m8193a(parcel, 4, this.f13081i, false);
        C2835c.m8196a(parcel, 5, this.f13075c);
        C2835c.m8183a(parcel, 6, this.f13076d);
        C2835c.m8184a(parcel, 7, this.f13077e);
        C2835c.m8196a(parcel, 8, this.f13078f);
        C2835c.m8196a(parcel, 9, this.f13079g);
        C2835c.m8196a(parcel, 10, this.f13080h);
        C2835c.m8180a(parcel, i);
    }
}
