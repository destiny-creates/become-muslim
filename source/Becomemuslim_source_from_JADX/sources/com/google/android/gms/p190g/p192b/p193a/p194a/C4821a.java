package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@UsedByNative("wrapper.cc")
/* renamed from: com.google.android.gms.g.b.a.a.a */
public class C4821a extends C4363a {
    public static final Creator<C4821a> CREATOR = new C3043d();
    /* renamed from: a */
    public final int f13628a;
    /* renamed from: b */
    public final float f13629b;
    /* renamed from: c */
    public final float f13630c;
    /* renamed from: d */
    public final float f13631d;
    /* renamed from: e */
    public final float f13632e;
    /* renamed from: f */
    public final float f13633f;
    /* renamed from: g */
    public final float f13634g;
    /* renamed from: h */
    public final C4822b[] f13635h;
    /* renamed from: i */
    public final float f13636i;
    /* renamed from: j */
    public final float f13637j;
    /* renamed from: k */
    public final float f13638k;
    /* renamed from: l */
    private final int f13639l;

    public C4821a(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, C4822b[] c4822bArr, float f7, float f8, float f9) {
        this.f13639l = i;
        this.f13628a = i2;
        this.f13629b = f;
        this.f13630c = f2;
        this.f13631d = f3;
        this.f13632e = f4;
        this.f13633f = f5;
        this.f13634g = f6;
        this.f13635h = c4822bArr;
        this.f13636i = f7;
        this.f13637j = f8;
        this.f13638k = f9;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13639l);
        C2835c.m8184a(parcel, 2, this.f13628a);
        C2835c.m8183a(parcel, 3, this.f13629b);
        C2835c.m8183a(parcel, 4, this.f13630c);
        C2835c.m8183a(parcel, 5, this.f13631d);
        C2835c.m8183a(parcel, 6, this.f13632e);
        C2835c.m8183a(parcel, 7, this.f13633f);
        C2835c.m8183a(parcel, 8, this.f13634g);
        C2835c.m8200a(parcel, 9, this.f13635h, i, false);
        C2835c.m8183a(parcel, 10, this.f13636i);
        C2835c.m8183a(parcel, 11, this.f13637j);
        C2835c.m8183a(parcel, 12, this.f13638k);
        C2835c.m8180a(parcel, a);
    }
}
