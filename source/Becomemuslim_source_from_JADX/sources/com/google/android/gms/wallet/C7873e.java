package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.wallet.e */
public final class C7873e extends C4363a {
    public static final Creator<C7873e> CREATOR = new ap();
    /* renamed from: a */
    private String f29364a;
    /* renamed from: b */
    private String f29365b;
    /* renamed from: c */
    private int f29366c;

    private C7873e() {
    }

    public C7873e(String str, String str2, int i) {
        this.f29364a = str;
        this.f29365b = str2;
        this.f29366c = i;
    }

    /* renamed from: a */
    public final String m38405a() {
        return this.f29364a;
    }

    /* renamed from: b */
    public final String m38406b() {
        return this.f29365b;
    }

    /* renamed from: c */
    public final int m38407c() {
        switch (this.f29366c) {
            case 1:
            case 2:
            case 3:
                return this.f29366c;
            default:
                return 0;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, m38405a(), false);
        C2835c.a(parcel, 3, m38406b(), false);
        C2835c.a(parcel, 4, m38407c());
        C2835c.a(parcel, i);
    }
}
