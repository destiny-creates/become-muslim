package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

public final class UserAddress extends C4363a implements ReflectedParcelable {
    public static final Creator<UserAddress> CREATOR = new C3059a();
    /* renamed from: a */
    private String f13650a;
    /* renamed from: b */
    private String f13651b;
    /* renamed from: c */
    private String f13652c;
    /* renamed from: d */
    private String f13653d;
    /* renamed from: e */
    private String f13654e;
    /* renamed from: f */
    private String f13655f;
    /* renamed from: g */
    private String f13656g;
    /* renamed from: h */
    private String f13657h;
    /* renamed from: i */
    private String f13658i;
    /* renamed from: j */
    private String f13659j;
    /* renamed from: k */
    private String f13660k;
    /* renamed from: l */
    private String f13661l;
    /* renamed from: m */
    private boolean f13662m;
    /* renamed from: n */
    private String f13663n;
    /* renamed from: o */
    private String f13664o;

    UserAddress() {
    }

    UserAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.f13650a = str;
        this.f13651b = str2;
        this.f13652c = str3;
        this.f13653d = str4;
        this.f13654e = str5;
        this.f13655f = str6;
        this.f13656g = str7;
        this.f13657h = str8;
        this.f13658i = str9;
        this.f13659j = str10;
        this.f13660k = str11;
        this.f13661l = str12;
        this.f13662m = z;
        this.f13663n = str13;
        this.f13664o = str14;
    }

    /* renamed from: a */
    public final String m17036a() {
        return this.f13650a;
    }

    /* renamed from: b */
    public final String m17037b() {
        return this.f13651b;
    }

    /* renamed from: c */
    public final String m17038c() {
        return this.f13652c;
    }

    /* renamed from: d */
    public final String m17039d() {
        return this.f13653d;
    }

    /* renamed from: e */
    public final String m17040e() {
        return this.f13654e;
    }

    /* renamed from: f */
    public final String m17041f() {
        return this.f13655f;
    }

    /* renamed from: g */
    public final String m17042g() {
        return this.f13656g;
    }

    /* renamed from: h */
    public final String m17043h() {
        return this.f13657h;
    }

    /* renamed from: i */
    public final String m17044i() {
        return this.f13658i;
    }

    /* renamed from: j */
    public final String m17045j() {
        return this.f13659j;
    }

    /* renamed from: k */
    public final String m17046k() {
        return this.f13660k;
    }

    /* renamed from: l */
    public final String m17047l() {
        return this.f13661l;
    }

    /* renamed from: m */
    public final String m17048m() {
        return this.f13663n;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 2, this.f13650a, false);
        C2835c.m8193a(parcel, 3, this.f13651b, false);
        C2835c.m8193a(parcel, 4, this.f13652c, false);
        C2835c.m8193a(parcel, 5, this.f13653d, false);
        C2835c.m8193a(parcel, 6, this.f13654e, false);
        C2835c.m8193a(parcel, 7, this.f13655f, false);
        C2835c.m8193a(parcel, 8, this.f13656g, false);
        C2835c.m8193a(parcel, 9, this.f13657h, false);
        C2835c.m8193a(parcel, 10, this.f13658i, false);
        C2835c.m8193a(parcel, 11, this.f13659j, false);
        C2835c.m8193a(parcel, 12, this.f13660k, false);
        C2835c.m8193a(parcel, 13, this.f13661l, false);
        C2835c.m8196a(parcel, 14, this.f13662m);
        C2835c.m8193a(parcel, 15, this.f13663n, false);
        C2835c.m8193a(parcel, 16, this.f13664o, false);
        C2835c.m8180a(parcel, i);
    }
}
