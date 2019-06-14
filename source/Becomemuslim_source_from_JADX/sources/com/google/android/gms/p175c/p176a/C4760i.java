package com.google.android.gms.p175c.p176a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C4786w;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.c.a.i */
public final class C4760i extends C4363a {
    public static final Creator<C4760i> CREATOR = new C2768j();
    /* renamed from: a */
    private final int f13144a;
    /* renamed from: b */
    private final C4786w f13145b;

    C4760i(int i, C4786w c4786w) {
        this.f13144a = i;
        this.f13145b = c4786w;
    }

    public C4760i(C4786w c4786w) {
        this(1, c4786w);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13144a);
        C2835c.m8188a(parcel, 2, this.f13145b, i, false);
        C2835c.m8180a(parcel, a);
    }
}
