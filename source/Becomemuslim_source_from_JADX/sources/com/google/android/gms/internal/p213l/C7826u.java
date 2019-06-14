package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.l.u */
public final class C7826u extends C4363a {
    public static final Creator<C7826u> CREATOR = new C5051v();
    /* renamed from: a */
    public final String f29107a;
    /* renamed from: b */
    public final String f29108b;
    /* renamed from: c */
    public final String f29109c;
    /* renamed from: d */
    public final String f29110d;
    /* renamed from: e */
    public final long f29111e;
    /* renamed from: f */
    public final long f29112f;
    /* renamed from: g */
    public final String f29113g;
    /* renamed from: h */
    public final boolean f29114h;
    /* renamed from: i */
    public final boolean f29115i;
    /* renamed from: j */
    public final long f29116j;
    /* renamed from: k */
    public final String f29117k;
    /* renamed from: l */
    public final long f29118l;
    /* renamed from: m */
    public final long f29119m;
    /* renamed from: n */
    public final int f29120n;
    /* renamed from: o */
    public final boolean f29121o;
    /* renamed from: p */
    public final boolean f29122p;
    /* renamed from: q */
    public final boolean f29123q;

    C7826u(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5) {
        C2872v.a(str);
        this.f29107a = str;
        r0.f29108b = TextUtils.isEmpty(str2) ? null : str2;
        r0.f29109c = str3;
        r0.f29116j = j;
        r0.f29110d = str4;
        r0.f29111e = j2;
        r0.f29112f = j3;
        r0.f29113g = str5;
        r0.f29114h = z;
        r0.f29115i = z2;
        r0.f29117k = str6;
        r0.f29118l = j4;
        r0.f29119m = j5;
        r0.f29120n = i;
        r0.f29121o = z3;
        r0.f29122p = z4;
        r0.f29123q = z5;
    }

    C7826u(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5) {
        this.f29107a = str;
        this.f29108b = str2;
        this.f29109c = str3;
        this.f29116j = j3;
        this.f29110d = str4;
        this.f29111e = j;
        this.f29112f = j2;
        this.f29113g = str5;
        this.f29114h = z;
        this.f29115i = z2;
        this.f29117k = str6;
        this.f29118l = j4;
        this.f29119m = j5;
        this.f29120n = i;
        this.f29121o = z3;
        this.f29122p = z4;
        this.f29123q = z5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29107a, false);
        C2835c.a(parcel, 3, this.f29108b, false);
        C2835c.a(parcel, 4, this.f29109c, false);
        C2835c.a(parcel, 5, this.f29110d, false);
        C2835c.a(parcel, 6, this.f29111e);
        C2835c.a(parcel, 7, this.f29112f);
        C2835c.a(parcel, 8, this.f29113g, false);
        C2835c.a(parcel, 9, this.f29114h);
        C2835c.a(parcel, 10, this.f29115i);
        C2835c.a(parcel, 11, this.f29116j);
        C2835c.a(parcel, 12, this.f29117k, false);
        C2835c.a(parcel, 13, this.f29118l);
        C2835c.a(parcel, 14, this.f29119m);
        C2835c.a(parcel, 15, this.f29120n);
        C2835c.a(parcel, 16, this.f29121o);
        C2835c.a(parcel, 17, this.f29122p);
        C2835c.a(parcel, 18, this.f29123q);
        C2835c.a(parcel, i);
    }
}
