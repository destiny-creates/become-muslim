package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.f */
public final class C7890f extends C4363a {
    public static final Creator<C7890f> CREATOR = new C5176q();
    /* renamed from: a */
    private long f29474a;
    /* renamed from: b */
    private long f29475b;

    C7890f() {
    }

    public C7890f(long j, long j2) {
        this.f29474a = j;
        this.f29475b = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29474a);
        C2835c.a(parcel, 3, this.f29475b);
        C2835c.a(parcel, i);
    }
}
