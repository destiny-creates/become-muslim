package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@Deprecated
/* renamed from: com.google.android.gms.wallet.o */
public final class C7881o extends C4363a {
    public static final Creator<C7881o> CREATOR = new ac();
    /* renamed from: a */
    private String f29420a;
    /* renamed from: b */
    private String f29421b;
    /* renamed from: c */
    private int f29422c;
    /* renamed from: d */
    private int f29423d;

    public C7881o(String str, String str2, int i, int i2) {
        this.f29420a = str;
        this.f29421b = str2;
        this.f29422c = i;
        this.f29423d = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29420a, false);
        C2835c.a(parcel, 3, this.f29421b, false);
        C2835c.a(parcel, 4, this.f29422c);
        C2835c.a(parcel, 5, this.f29423d);
        C2835c.a(parcel, i);
    }
}
