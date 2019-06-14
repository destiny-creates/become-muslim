package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

@cm
public final class ee extends C4363a {
    public static final Creator<ee> CREATOR = new ef();
    /* renamed from: a */
    private final Bundle f28627a;
    /* renamed from: b */
    private final mv f28628b;
    /* renamed from: c */
    private final ApplicationInfo f28629c;
    /* renamed from: d */
    private final String f28630d;
    /* renamed from: e */
    private final List<String> f28631e;
    /* renamed from: f */
    private final PackageInfo f28632f;
    /* renamed from: g */
    private final String f28633g;
    /* renamed from: h */
    private final boolean f28634h;
    /* renamed from: i */
    private final String f28635i;

    public ee(Bundle bundle, mv mvVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, String str2, boolean z, String str3) {
        this.f28627a = bundle;
        this.f28628b = mvVar;
        this.f28630d = str;
        this.f28629c = applicationInfo;
        this.f28631e = list;
        this.f28632f = packageInfo;
        this.f28633g = str2;
        this.f28634h = z;
        this.f28635i = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28627a, false);
        C2835c.a(parcel, 2, this.f28628b, i, false);
        C2835c.a(parcel, 3, this.f28629c, i, false);
        C2835c.a(parcel, 4, this.f28630d, false);
        C2835c.b(parcel, 5, this.f28631e, false);
        C2835c.a(parcel, 6, this.f28632f, i, false);
        C2835c.a(parcel, 7, this.f28633g, false);
        C2835c.a(parcel, 8, this.f28634h);
        C2835c.a(parcel, 9, this.f28635i, false);
        C2835c.a(parcel, a);
    }
}
