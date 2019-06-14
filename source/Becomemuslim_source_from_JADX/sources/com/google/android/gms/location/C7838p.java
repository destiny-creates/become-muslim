package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.location.p */
public final class C7838p extends C4363a {
    public static final Creator<C7838p> CREATOR = new ab();
    /* renamed from: a */
    private final boolean f29194a;
    /* renamed from: b */
    private final boolean f29195b;
    /* renamed from: c */
    private final boolean f29196c;
    /* renamed from: d */
    private final boolean f29197d;
    /* renamed from: e */
    private final boolean f29198e;
    /* renamed from: f */
    private final boolean f29199f;

    public C7838p(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f29194a = z;
        this.f29195b = z2;
        this.f29196c = z3;
        this.f29197d = z4;
        this.f29198e = z5;
        this.f29199f = z6;
    }

    /* renamed from: a */
    public final boolean m38226a() {
        return this.f29194a;
    }

    /* renamed from: b */
    public final boolean m38227b() {
        return this.f29197d;
    }

    /* renamed from: c */
    public final boolean m38228c() {
        return this.f29195b;
    }

    /* renamed from: d */
    public final boolean m38229d() {
        return this.f29198e;
    }

    /* renamed from: e */
    public final boolean m38230e() {
        return this.f29196c;
    }

    /* renamed from: f */
    public final boolean m38231f() {
        return this.f29199f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, m38226a());
        C2835c.a(parcel, 2, m38228c());
        C2835c.a(parcel, 3, m38230e());
        C2835c.a(parcel, 4, m38227b());
        C2835c.a(parcel, 5, m38229d());
        C2835c.a(parcel, 6, m38231f());
        C2835c.a(parcel, i);
    }
}
