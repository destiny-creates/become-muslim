package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet extends C4363a implements ReflectedParcelable {
    public static final Creator<FullWallet> CREATOR = new ao();
    /* renamed from: a */
    private String f29332a;
    /* renamed from: b */
    private String f29333b;
    /* renamed from: c */
    private C7881o f29334c;
    /* renamed from: d */
    private String f29335d;
    /* renamed from: e */
    private C7884s f29336e;
    /* renamed from: f */
    private C7884s f29337f;
    /* renamed from: g */
    private String[] f29338g;
    /* renamed from: h */
    private UserAddress f29339h;
    /* renamed from: i */
    private UserAddress f29340i;
    /* renamed from: j */
    private C7873e[] f29341j;
    /* renamed from: k */
    private C7879k f29342k;

    private FullWallet() {
    }

    FullWallet(String str, String str2, C7881o c7881o, String str3, C7884s c7884s, C7884s c7884s2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, C7873e[] c7873eArr, C7879k c7879k) {
        this.f29332a = str;
        this.f29333b = str2;
        this.f29334c = c7881o;
        this.f29335d = str3;
        this.f29336e = c7884s;
        this.f29337f = c7884s2;
        this.f29338g = strArr;
        this.f29339h = userAddress;
        this.f29340i = userAddress2;
        this.f29341j = c7873eArr;
        this.f29342k = c7879k;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29332a, false);
        C2835c.a(parcel, 3, this.f29333b, false);
        C2835c.a(parcel, 4, this.f29334c, i, false);
        C2835c.a(parcel, 5, this.f29335d, false);
        C2835c.a(parcel, 6, this.f29336e, i, false);
        C2835c.a(parcel, 7, this.f29337f, i, false);
        C2835c.a(parcel, 8, this.f29338g, false);
        C2835c.a(parcel, 9, this.f29339h, i, false);
        C2835c.a(parcel, 10, this.f29340i, i, false);
        C2835c.a(parcel, 11, this.f29341j, i, false);
        C2835c.a(parcel, 12, this.f29342k, i, false);
        C2835c.a(parcel, a);
    }
}
