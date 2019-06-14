package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;

public final class bep extends ajl implements ben {
    bep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    /* renamed from: a */
    public final bex mo4209a() {
        Parcel a = m18499a(2, x_());
        bex bex = (bex) ajn.m18501a(a, bex.CREATOR);
        a.recycle();
        return bex;
    }

    /* renamed from: a */
    public final void mo4210a(C2758b c2758b, String str, Bundle bundle, beq beq) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str);
        ajn.m18503a(x_, (Parcelable) bundle);
        ajn.m18502a(x_, (IInterface) beq);
        m18500b(1, x_);
    }

    /* renamed from: a */
    public final void mo4211a(byte[] bArr, String str, Bundle bundle, C2758b c2758b, bej bej, bde bde, aou aou) {
        Parcel x_ = x_();
        x_.writeByteArray(bArr);
        x_.writeString(str);
        ajn.m18503a(x_, (Parcelable) bundle);
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) bej);
        ajn.m18502a(x_, (IInterface) bde);
        ajn.m18503a(x_, (Parcelable) aou);
        m18500b(4, x_);
    }

    /* renamed from: a */
    public final void mo4212a(byte[] bArr, String str, Bundle bundle, C2758b c2758b, bel bel, bde bde) {
        Parcel x_ = x_();
        x_.writeByteArray(bArr);
        x_.writeString(str);
        ajn.m18503a(x_, (Parcelable) bundle);
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) bel);
        ajn.m18502a(x_, (IInterface) bde);
        m18500b(6, x_);
    }

    /* renamed from: b */
    public final bex mo4213b() {
        Parcel a = m18499a(3, x_());
        bex bex = (bex) ajn.m18501a(a, bex.CREATOR);
        a.recycle();
        return bex;
    }

    /* renamed from: c */
    public final aqv mo4214c() {
        Parcel a = m18499a(5, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final void mo4215d() {
        m18500b(7, x_());
    }
}
