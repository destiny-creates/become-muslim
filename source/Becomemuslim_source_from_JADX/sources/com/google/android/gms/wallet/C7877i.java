package com.google.android.gms.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C2837e;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.i */
public final class C7877i extends C4363a implements C5151a {
    public static final Creator<C7877i> CREATOR = new C5164u();
    /* renamed from: a */
    private String f29399a;
    /* renamed from: b */
    private C7871c f29400b;
    /* renamed from: c */
    private UserAddress f29401c;
    /* renamed from: d */
    private C7879k f29402d;
    /* renamed from: e */
    private String f29403e;
    /* renamed from: f */
    private Bundle f29404f;
    /* renamed from: g */
    private String f29405g;

    private C7877i() {
    }

    C7877i(String str, C7871c c7871c, UserAddress userAddress, C7879k c7879k, String str2, Bundle bundle, String str3) {
        this.f29399a = str;
        this.f29400b = c7871c;
        this.f29401c = userAddress;
        this.f29402d = c7879k;
        this.f29403e = str2;
        this.f29404f = bundle;
        this.f29405g = str3;
    }

    /* renamed from: b */
    public static C7877i m38410b(Intent intent) {
        return (C7877i) C2837e.a(intent, "com.google.android.gms.wallet.PaymentData", CREATOR);
    }

    /* renamed from: a */
    public final C7871c m38411a() {
        return this.f29400b;
    }

    /* renamed from: a */
    public final void mo6255a(Intent intent) {
        C2837e.a(this, intent, "com.google.android.gms.wallet.PaymentData");
    }

    /* renamed from: b */
    public final UserAddress m38413b() {
        return this.f29401c;
    }

    /* renamed from: c */
    public final C7879k m38414c() {
        return this.f29402d;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29399a, false);
        C2835c.a(parcel, 2, this.f29400b, i, false);
        C2835c.a(parcel, 3, this.f29401c, i, false);
        C2835c.a(parcel, 4, this.f29402d, i, false);
        C2835c.a(parcel, 5, this.f29403e, false);
        C2835c.a(parcel, 6, this.f29404f, false);
        C2835c.a(parcel, 7, this.f29405g, false);
        C2835c.a(parcel, a);
    }
}
