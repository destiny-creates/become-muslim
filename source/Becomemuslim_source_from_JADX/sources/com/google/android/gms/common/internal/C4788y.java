package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.internal.y */
public class C4788y extends C4363a {
    public static final Creator<C4788y> CREATOR = new ap();
    /* renamed from: a */
    private final int f13247a;
    /* renamed from: b */
    private final int f13248b;
    /* renamed from: c */
    private final int f13249c;
    @Deprecated
    /* renamed from: d */
    private final Scope[] f13250d;

    C4788y(int i, int i2, int i3, Scope[] scopeArr) {
        this.f13247a = i;
        this.f13248b = i2;
        this.f13249c = i3;
        this.f13250d = scopeArr;
    }

    public C4788y(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    /* renamed from: a */
    public int m16858a() {
        return this.f13248b;
    }

    /* renamed from: b */
    public int m16859b() {
        return this.f13249c;
    }

    @Deprecated
    /* renamed from: c */
    public Scope[] m16860c() {
        return this.f13250d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13247a);
        C2835c.m8184a(parcel, 2, m16858a());
        C2835c.m8184a(parcel, 3, m16859b());
        C2835c.m8200a(parcel, 4, m16860c(), i, false);
        C2835c.m8180a(parcel, a);
    }
}
