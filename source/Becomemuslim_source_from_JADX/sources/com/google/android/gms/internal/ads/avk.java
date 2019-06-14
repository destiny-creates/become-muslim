package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class avk extends ajl implements avi {
    avk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    /* renamed from: a */
    public final C2758b mo3999a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(2, x_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo4000a() {
        m18500b(4, x_());
    }

    /* renamed from: a */
    public final void mo4001a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo4002a(C2758b c2758b, int i) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeInt(i);
        m18500b(5, x_);
    }

    /* renamed from: a */
    public final void mo4003a(String str, C2758b c2758b) {
        Parcel x_ = x_();
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(1, x_);
    }

    /* renamed from: b */
    public final void mo4004b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(6, x_);
    }
}
