package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.wobs.h */
public final class C7892h extends C4363a {
    public static final Creator<C7892h> CREATOR = new C5178s();
    /* renamed from: a */
    String f29478a;
    /* renamed from: b */
    String f29479b;
    /* renamed from: c */
    C7890f f29480c;
    /* renamed from: d */
    C7891g f29481d;
    /* renamed from: e */
    C7891g f29482e;

    C7892h() {
    }

    C7892h(String str, String str2, C7890f c7890f, C7891g c7891g, C7891g c7891g2) {
        this.f29478a = str;
        this.f29479b = str2;
        this.f29480c = c7890f;
        this.f29481d = c7891g;
        this.f29482e = c7891g2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29478a, false);
        C2835c.a(parcel, 3, this.f29479b, false);
        C2835c.a(parcel, 4, this.f29480c, i, false);
        C2835c.a(parcel, 5, this.f29481d, i, false);
        C2835c.a(parcel, 6, this.f29482e, i, false);
        C2835c.a(parcel, a);
    }
}
