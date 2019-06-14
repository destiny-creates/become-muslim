package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.g */
public final class C7891g extends C4363a {
    public static final Creator<C7891g> CREATOR = new C5177r();
    /* renamed from: a */
    private String f29476a;
    /* renamed from: b */
    private String f29477b;

    C7891g() {
    }

    public C7891g(String str, String str2) {
        this.f29476a = str;
        this.f29477b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29476a, false);
        C2835c.a(parcel, 3, this.f29477b, false);
        C2835c.a(parcel, i);
    }
}
