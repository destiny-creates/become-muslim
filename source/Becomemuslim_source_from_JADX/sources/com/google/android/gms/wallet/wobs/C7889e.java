package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.e */
public final class C7889e extends C4363a {
    public static final Creator<C7889e> CREATOR = new C5175p();
    /* renamed from: a */
    private String f29472a;
    /* renamed from: b */
    private String f29473b;

    C7889e() {
    }

    public C7889e(String str, String str2) {
        this.f29472a = str;
        this.f29473b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29472a, false);
        C2835c.a(parcel, 3, this.f29473b, false);
        C2835c.a(parcel, i);
    }
}
