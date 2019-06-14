package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.c */
public final class C7887c extends C4363a {
    public static final Creator<C7887c> CREATOR = new C5174o();
    /* renamed from: a */
    String f29463a;
    /* renamed from: b */
    C7888d f29464b;
    /* renamed from: c */
    C7890f f29465c;

    C7887c() {
    }

    C7887c(String str, C7888d c7888d, C7890f c7890f) {
        this.f29463a = str;
        this.f29464b = c7888d;
        this.f29465c = c7890f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29463a, false);
        C2835c.a(parcel, 3, this.f29464b, i, false);
        C2835c.a(parcel, 5, this.f29465c, i, false);
        C2835c.a(parcel, a);
    }
}
