package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.a */
public final class C7885a extends C4363a {
    public static final Creator<C7885a> CREATOR = new C5171l();
    /* renamed from: a */
    private String f29458a;
    /* renamed from: b */
    private String f29459b;

    C7885a() {
    }

    public C7885a(String str, String str2) {
        this.f29458a = str;
        this.f29459b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29458a, false);
        C2835c.a(parcel, 3, this.f29459b, false);
        C2835c.a(parcel, i);
    }
}
