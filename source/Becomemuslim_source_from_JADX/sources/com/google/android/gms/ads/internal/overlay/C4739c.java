package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.ads.cm;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.c */
public final class C4739c extends C4363a {
    public static final Creator<C4739c> CREATOR = new C2657b();
    /* renamed from: a */
    public final String f13037a;
    /* renamed from: b */
    public final String f13038b;
    /* renamed from: c */
    public final String f13039c;
    /* renamed from: d */
    public final String f13040d;
    /* renamed from: e */
    public final String f13041e;
    /* renamed from: f */
    public final Intent f13042f;
    /* renamed from: g */
    private final String f13043g;
    /* renamed from: h */
    private final String f13044h;

    public C4739c(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    public C4739c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public C4739c(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.f13043g = str;
        this.f13037a = str2;
        this.f13038b = str3;
        this.f13039c = str4;
        this.f13040d = str5;
        this.f13041e = str6;
        this.f13044h = str7;
        this.f13042f = intent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 2, this.f13043g, false);
        C2835c.m8193a(parcel, 3, this.f13037a, false);
        C2835c.m8193a(parcel, 4, this.f13038b, false);
        C2835c.m8193a(parcel, 5, this.f13039c, false);
        C2835c.m8193a(parcel, 6, this.f13040d, false);
        C2835c.m8193a(parcel, 7, this.f13041e, false);
        C2835c.m8193a(parcel, 8, this.f13044h, false);
        C2835c.m8188a(parcel, 9, this.f13042f, i, false);
        C2835c.m8180a(parcel, a);
    }
}
