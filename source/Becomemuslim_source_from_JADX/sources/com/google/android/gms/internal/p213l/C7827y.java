package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.l.y */
public final class C7827y extends C4363a {
    public static final Creator<C7827y> CREATOR = new C5053z();
    /* renamed from: a */
    public String f29124a;
    /* renamed from: b */
    public String f29125b;
    /* renamed from: c */
    public ft f29126c;
    /* renamed from: d */
    public long f29127d;
    /* renamed from: e */
    public boolean f29128e;
    /* renamed from: f */
    public String f29129f;
    /* renamed from: g */
    public aq f29130g;
    /* renamed from: h */
    public long f29131h;
    /* renamed from: i */
    public aq f29132i;
    /* renamed from: j */
    public long f29133j;
    /* renamed from: k */
    public aq f29134k;

    C7827y(C7827y c7827y) {
        C2872v.a(c7827y);
        this.f29124a = c7827y.f29124a;
        this.f29125b = c7827y.f29125b;
        this.f29126c = c7827y.f29126c;
        this.f29127d = c7827y.f29127d;
        this.f29128e = c7827y.f29128e;
        this.f29129f = c7827y.f29129f;
        this.f29130g = c7827y.f29130g;
        this.f29131h = c7827y.f29131h;
        this.f29132i = c7827y.f29132i;
        this.f29133j = c7827y.f29133j;
        this.f29134k = c7827y.f29134k;
    }

    C7827y(String str, String str2, ft ftVar, long j, boolean z, String str3, aq aqVar, long j2, aq aqVar2, long j3, aq aqVar3) {
        this.f29124a = str;
        this.f29125b = str2;
        this.f29126c = ftVar;
        this.f29127d = j;
        this.f29128e = z;
        this.f29129f = str3;
        this.f29130g = aqVar;
        this.f29131h = j2;
        this.f29132i = aqVar2;
        this.f29133j = j3;
        this.f29134k = aqVar3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29124a, false);
        C2835c.a(parcel, 3, this.f29125b, false);
        C2835c.a(parcel, 4, this.f29126c, i, false);
        C2835c.a(parcel, 5, this.f29127d);
        C2835c.a(parcel, 6, this.f29128e);
        C2835c.a(parcel, 7, this.f29129f, false);
        C2835c.a(parcel, 8, this.f29130g, i, false);
        C2835c.a(parcel, 9, this.f29131h);
        C2835c.a(parcel, 10, this.f29132i, i, false);
        C2835c.a(parcel, 11, this.f29133j);
        C2835c.a(parcel, 12, this.f29134k, i, false);
        C2835c.a(parcel, a);
    }
}
