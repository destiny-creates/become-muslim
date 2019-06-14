package com.google.android.gms.internal.p214m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.m.c */
public final class C7828c extends C4363a {
    public static final Creator<C7828c> CREATOR = new C5056d();
    /* renamed from: a */
    public int f29135a;

    public C7828c(int i) {
        this.f29135a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29135a);
        C2835c.a(parcel, i);
    }
}
