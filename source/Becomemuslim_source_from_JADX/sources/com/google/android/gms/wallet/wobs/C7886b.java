package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2892b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.b */
public final class C7886b extends C4363a {
    public static final Creator<C7886b> CREATOR = new C5172m();
    /* renamed from: a */
    String f29460a;
    /* renamed from: b */
    String f29461b;
    /* renamed from: c */
    ArrayList<C7885a> f29462c;

    C7886b() {
        this.f29462c = C2892b.a();
    }

    C7886b(String str, String str2, ArrayList<C7885a> arrayList) {
        this.f29460a = str;
        this.f29461b = str2;
        this.f29462c = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29460a, false);
        C2835c.a(parcel, 3, this.f29461b, false);
        C2835c.c(parcel, 4, this.f29462c, false);
        C2835c.a(parcel, i);
    }
}
