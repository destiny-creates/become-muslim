package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@Deprecated
public final class bg extends C4363a {
    public static final Creator<bg> CREATOR = new bh();
    /* renamed from: a */
    private final int f13216a;

    bg(int i) {
        this.f13216a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13216a);
        C2835c.m8180a(parcel, i);
    }
}
