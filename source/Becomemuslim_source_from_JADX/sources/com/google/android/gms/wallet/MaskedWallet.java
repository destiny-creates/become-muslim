package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet extends C4363a implements ReflectedParcelable {
    public static final Creator<MaskedWallet> CREATOR = new at();
    /* renamed from: a */
    String f29343a;
    /* renamed from: b */
    String f29344b;
    /* renamed from: c */
    String[] f29345c;
    /* renamed from: d */
    String f29346d;
    /* renamed from: e */
    UserAddress f29347e;
    /* renamed from: f */
    UserAddress f29348f;
    /* renamed from: g */
    C7873e[] f29349g;
    /* renamed from: h */
    private C7884s f29350h;
    /* renamed from: i */
    private C7884s f29351i;
    /* renamed from: j */
    private C7875g[] f29352j;
    /* renamed from: k */
    private C7876h[] f29353k;

    private MaskedWallet() {
    }

    MaskedWallet(String str, String str2, String[] strArr, String str3, C7884s c7884s, C7884s c7884s2, C7875g[] c7875gArr, C7876h[] c7876hArr, UserAddress userAddress, UserAddress userAddress2, C7873e[] c7873eArr) {
        this.f29343a = str;
        this.f29344b = str2;
        this.f29345c = strArr;
        this.f29346d = str3;
        this.f29350h = c7884s;
        this.f29351i = c7884s2;
        this.f29352j = c7875gArr;
        this.f29353k = c7876hArr;
        this.f29347e = userAddress;
        this.f29348f = userAddress2;
        this.f29349g = c7873eArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29343a, false);
        C2835c.a(parcel, 3, this.f29344b, false);
        C2835c.a(parcel, 4, this.f29345c, false);
        C2835c.a(parcel, 5, this.f29346d, false);
        C2835c.a(parcel, 6, this.f29350h, i, false);
        C2835c.a(parcel, 7, this.f29351i, i, false);
        C2835c.a(parcel, 8, this.f29352j, i, false);
        C2835c.a(parcel, 9, this.f29353k, i, false);
        C2835c.a(parcel, 10, this.f29347e, i, false);
        C2835c.a(parcel, 11, this.f29348f, i, false);
        C2835c.a(parcel, 12, this.f29349g, i, false);
        C2835c.a(parcel, a);
    }
}
