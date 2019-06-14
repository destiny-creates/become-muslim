package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.n.l */
public final class C7831l extends C4363a {
    public static final Creator<C7831l> CREATOR = new C5067m();
    /* renamed from: a */
    private byte[] f29141a;

    C7831l() {
        this(new byte[0]);
    }

    public C7831l(byte[] bArr) {
        this.f29141a = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29141a, false);
        C2835c.a(parcel, i);
    }
}
