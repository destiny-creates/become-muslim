package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.j.e */
public final class C7821e extends C4363a implements C2814k {
    public static final Creator<C7821e> CREATOR = new C5016f();
    /* renamed from: a */
    private static final C7821e f28962a = new C7821e(Status.f13151a);
    /* renamed from: b */
    private final Status f28963b;

    public C7821e(Status status) {
        this.f28963b = status;
    }

    /* renamed from: b */
    public final Status m38026b() {
        return this.f28963b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, m38026b(), i, false);
        C2835c.a(parcel, a);
    }
}
