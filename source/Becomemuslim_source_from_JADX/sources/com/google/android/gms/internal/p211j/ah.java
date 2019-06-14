package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.location.ap;
import com.google.android.gms.location.aq;
import com.google.android.gms.location.as;
import com.google.android.gms.location.at;

/* renamed from: com.google.android.gms.internal.j.ah */
public final class ah extends C4363a {
    public static final Creator<ah> CREATOR = new ai();
    /* renamed from: a */
    private int f28937a;
    /* renamed from: b */
    private af f28938b;
    /* renamed from: c */
    private as f28939c;
    /* renamed from: d */
    private PendingIntent f28940d;
    /* renamed from: e */
    private ap f28941e;
    /* renamed from: f */
    private C5017k f28942f;

    ah(int i, af afVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f28937a = i;
        this.f28938b = afVar;
        C5017k c5017k = null;
        this.f28939c = iBinder == null ? null : at.m32110a(iBinder);
        this.f28940d = pendingIntent;
        this.f28941e = iBinder2 == null ? null : aq.m32106a(iBinder2);
        if (iBinder3 != null) {
            if (iBinder3 != null) {
                IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                c5017k = queryLocalInterface instanceof C5017k ? (C5017k) queryLocalInterface : new C6801m(iBinder3);
            }
        }
        this.f28942f = c5017k;
    }

    /* renamed from: a */
    public static ah m38021a(ap apVar, C5017k c5017k) {
        return new ah(2, null, null, null, apVar.asBinder(), c5017k != null ? c5017k.asBinder() : null);
    }

    /* renamed from: a */
    public static ah m38022a(as asVar, C5017k c5017k) {
        return new ah(2, null, asVar.asBinder(), null, null, c5017k != null ? c5017k.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28937a);
        C2835c.a(parcel, 2, this.f28938b, i, false);
        IBinder iBinder = null;
        C2835c.a(parcel, 3, this.f28939c == null ? null : this.f28939c.asBinder(), false);
        C2835c.a(parcel, 4, this.f28940d, i, false);
        C2835c.a(parcel, 5, this.f28941e == null ? null : this.f28941e.asBinder(), false);
        if (this.f28942f != null) {
            iBinder = this.f28942f.asBinder();
        }
        C2835c.a(parcel, 6, iBinder, false);
        C2835c.a(parcel, a);
    }
}
