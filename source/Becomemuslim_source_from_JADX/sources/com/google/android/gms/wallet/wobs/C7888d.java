package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.d */
public final class C7888d extends C4363a {
    public static final Creator<C7888d> CREATOR = new C5173n();
    /* renamed from: a */
    int f29466a;
    /* renamed from: b */
    String f29467b;
    /* renamed from: c */
    double f29468c;
    /* renamed from: d */
    String f29469d;
    /* renamed from: e */
    long f29470e;
    /* renamed from: f */
    int f29471f;

    C7888d() {
        this.f29471f = -1;
        this.f29466a = -1;
        this.f29468c = -1.0d;
    }

    C7888d(int i, String str, double d, String str2, long j, int i2) {
        this.f29466a = i;
        this.f29467b = str;
        this.f29468c = d;
        this.f29469d = str2;
        this.f29470e = j;
        this.f29471f = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29466a);
        C2835c.a(parcel, 3, this.f29467b, false);
        C2835c.a(parcel, 4, this.f29468c);
        C2835c.a(parcel, 5, this.f29469d, false);
        C2835c.a(parcel, 6, this.f29470e);
        C2835c.a(parcel, 7, this.f29471f);
        C2835c.a(parcel, i);
    }
}
