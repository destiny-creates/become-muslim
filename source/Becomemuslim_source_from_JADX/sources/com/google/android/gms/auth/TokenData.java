package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

public class TokenData extends C4363a implements ReflectedParcelable {
    public static final Creator<TokenData> CREATOR = new C2755i();
    /* renamed from: a */
    private final int f13107a;
    /* renamed from: b */
    private final String f13108b;
    /* renamed from: c */
    private final Long f13109c;
    /* renamed from: d */
    private final boolean f13110d;
    /* renamed from: e */
    private final boolean f13111e;
    /* renamed from: f */
    private final List<String> f13112f;
    /* renamed from: g */
    private final String f13113g;

    /* renamed from: a */
    public static TokenData m16647a(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        bundle = bundle.getBundle(str);
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle.getParcelable("TokenData");
    }

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list, String str2) {
        this.f13107a = i;
        this.f13108b = C2872v.m8382a(str);
        this.f13109c = l;
        this.f13110d = z;
        this.f13111e = z2;
        this.f13112f = list;
        this.f13113g = str2;
    }

    /* renamed from: a */
    public final String m16648a() {
        return this.f13108b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (TextUtils.equals(this.f13108b, tokenData.f13108b) && C2868t.m8374a(this.f13109c, tokenData.f13109c) && this.f13110d == tokenData.f13110d && this.f13111e == tokenData.f13111e && C2868t.m8374a(this.f13112f, tokenData.f13112f) && C2868t.m8374a(this.f13113g, tokenData.f13113g) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C2868t.m8372a(this.f13108b, this.f13109c, Boolean.valueOf(this.f13110d), Boolean.valueOf(this.f13111e), this.f13112f, this.f13113g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13107a);
        C2835c.m8193a(parcel, 2, this.f13108b, false);
        C2835c.m8192a(parcel, 3, this.f13109c, false);
        C2835c.m8196a(parcel, 4, this.f13110d);
        C2835c.m8196a(parcel, 5, this.f13111e);
        C2835c.m8205b(parcel, 6, this.f13112f, false);
        C2835c.m8193a(parcel, 7, this.f13113g, false);
        C2835c.m8180a(parcel, i);
    }
}
