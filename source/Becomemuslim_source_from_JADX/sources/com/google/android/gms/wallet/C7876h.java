package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* renamed from: com.google.android.gms.wallet.h */
public final class C7876h extends C4363a {
    public static final Creator<C7876h> CREATOR = new C5163t();
    /* renamed from: a */
    String f29395a;
    /* renamed from: b */
    String f29396b;
    /* renamed from: c */
    CommonWalletObject f29397c;
    /* renamed from: d */
    private final int f29398d;

    C7876h() {
        this.f29398d = 3;
    }

    C7876h(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.f29398d = i;
        this.f29396b = str2;
        if (i < 3) {
            this.f29397c = CommonWalletObject.m38420a().m21876a(str).m21877a();
        } else {
            this.f29397c = commonWalletObject;
        }
    }

    /* renamed from: a */
    public final int m38409a() {
        return this.f29398d;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, m38409a());
        C2835c.a(parcel, 2, this.f29395a, false);
        C2835c.a(parcel, 3, this.f29396b, false);
        C2835c.a(parcel, 4, this.f29397c, i, false);
        C2835c.a(parcel, a);
    }
}
