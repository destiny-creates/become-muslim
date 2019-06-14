package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@Deprecated
/* renamed from: com.google.android.gms.wallet.s */
public final class C7884s extends C4363a {
    public static final Creator<C7884s> CREATOR = new ak();
    /* renamed from: a */
    private String f29428a;
    /* renamed from: b */
    private String f29429b;
    /* renamed from: c */
    private String f29430c;
    /* renamed from: d */
    private String f29431d;
    /* renamed from: e */
    private String f29432e;
    /* renamed from: f */
    private String f29433f;
    /* renamed from: g */
    private String f29434g;
    /* renamed from: h */
    private String f29435h;
    /* renamed from: i */
    private String f29436i;
    /* renamed from: j */
    private boolean f29437j;
    /* renamed from: k */
    private String f29438k;

    C7884s() {
    }

    C7884s(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.f29428a = str;
        this.f29429b = str2;
        this.f29430c = str3;
        this.f29431d = str4;
        this.f29432e = str5;
        this.f29433f = str6;
        this.f29434g = str7;
        this.f29435h = str8;
        this.f29436i = str9;
        this.f29437j = z;
        this.f29438k = str10;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29428a, false);
        C2835c.a(parcel, 3, this.f29429b, false);
        C2835c.a(parcel, 4, this.f29430c, false);
        C2835c.a(parcel, 5, this.f29431d, false);
        C2835c.a(parcel, 6, this.f29432e, false);
        C2835c.a(parcel, 7, this.f29433f, false);
        C2835c.a(parcel, 8, this.f29434g, false);
        C2835c.a(parcel, 9, this.f29435h, false);
        C2835c.a(parcel, 10, this.f29436i, false);
        C2835c.a(parcel, 11, this.f29437j);
        C2835c.a(parcel, 12, this.f29438k, false);
        C2835c.a(parcel, i);
    }
}
