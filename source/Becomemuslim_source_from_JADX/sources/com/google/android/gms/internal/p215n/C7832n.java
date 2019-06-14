package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.n.n */
public final class C7832n extends C4363a {
    public static final Creator<C7832n> CREATOR = new C5068o();
    /* renamed from: a */
    private byte[] f29142a;

    C7832n() {
        this(new byte[0]);
    }

    public C7832n(byte[] bArr) {
        this.f29142a = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29142a, false);
        C2835c.a(parcel, i);
    }
}
