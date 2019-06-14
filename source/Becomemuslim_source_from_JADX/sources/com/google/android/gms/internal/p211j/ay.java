package com.google.android.gms.internal.p211j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.location.am;
import com.google.android.gms.location.an;

/* renamed from: com.google.android.gms.internal.j.ay */
public final class ay extends C4363a {
    public static final Creator<ay> CREATOR = new az();
    /* renamed from: a */
    private int f28957a;
    /* renamed from: b */
    private aw f28958b;
    /* renamed from: c */
    private am f28959c;
    /* renamed from: d */
    private C5017k f28960d;

    ay(int i, aw awVar, IBinder iBinder, IBinder iBinder2) {
        this.f28957a = i;
        this.f28958b = awVar;
        C5017k c5017k = null;
        this.f28959c = iBinder == null ? null : an.m32104a(iBinder);
        if (iBinder2 != null) {
            if (iBinder2 != null) {
                IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                c5017k = queryLocalInterface instanceof C5017k ? (C5017k) queryLocalInterface : new C6801m(iBinder2);
            }
        }
        this.f28960d = c5017k;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28957a);
        C2835c.a(parcel, 2, this.f28958b, i, false);
        IBinder iBinder = null;
        C2835c.a(parcel, 3, this.f28959c == null ? null : this.f28959c.asBinder(), false);
        if (this.f28960d != null) {
            iBinder = this.f28960d.asBinder();
        }
        C2835c.a(parcel, 4, iBinder, false);
        C2835c.a(parcel, a);
    }
}
