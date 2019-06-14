package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.location.o */
public final class C7837o extends C4363a implements C2814k {
    public static final Creator<C7837o> CREATOR = new aa();
    /* renamed from: a */
    private final Status f29192a;
    /* renamed from: b */
    private final C7838p f29193b;

    public C7837o(Status status) {
        this(status, null);
    }

    public C7837o(Status status, C7838p c7838p) {
        this.f29192a = status;
        this.f29193b = c7838p;
    }

    /* renamed from: a */
    public final C7838p m38224a() {
        return this.f29193b;
    }

    /* renamed from: b */
    public final Status m38225b() {
        return this.f29192a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, m38225b(), i, false);
        C2835c.a(parcel, 2, m38224a(), i, false);
        C2835c.a(parcel, a);
    }
}
