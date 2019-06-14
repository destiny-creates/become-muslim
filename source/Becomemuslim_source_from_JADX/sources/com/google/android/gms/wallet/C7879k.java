package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.k */
public final class C7879k extends C4363a {
    public static final Creator<C7879k> CREATOR = new C5179x();
    /* renamed from: a */
    private int f29416a;
    /* renamed from: b */
    private String f29417b;

    private C7879k() {
    }

    C7879k(int i, String str) {
        this.f29416a = i;
        this.f29417b = str;
    }

    /* renamed from: a */
    public final String m38416a() {
        return this.f29417b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29416a);
        C2835c.a(parcel, 3, this.f29417b, false);
        C2835c.a(parcel, i);
    }
}
