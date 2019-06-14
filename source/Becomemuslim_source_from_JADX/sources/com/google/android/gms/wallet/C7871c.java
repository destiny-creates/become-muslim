package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.c */
public final class C7871c extends C4363a {
    public static final Creator<C7871c> CREATOR = new al();
    /* renamed from: a */
    private String f29355a;
    /* renamed from: b */
    private String f29356b;
    /* renamed from: c */
    private String f29357c;
    /* renamed from: d */
    private int f29358d;
    /* renamed from: e */
    private UserAddress f29359e;

    private C7871c() {
    }

    C7871c(String str, String str2, String str3, int i, UserAddress userAddress) {
        this.f29355a = str;
        this.f29356b = str2;
        this.f29357c = str3;
        this.f29358d = i;
        this.f29359e = userAddress;
    }

    /* renamed from: a */
    public final UserAddress m38403a() {
        return this.f29359e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29355a, false);
        C2835c.a(parcel, 2, this.f29356b, false);
        C2835c.a(parcel, 3, this.f29357c, false);
        C2835c.a(parcel, 4, this.f29358d);
        C2835c.a(parcel, 5, this.f29359e, i, false);
        C2835c.a(parcel, a);
    }
}
