package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

public final class ajr extends ajl implements ajp {
    ajr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    /* renamed from: a */
    public final void mo3823a() {
        m18500b(3, x_());
    }

    /* renamed from: a */
    public final void mo3824a(int i) {
        Parcel x_ = x_();
        x_.writeInt(i);
        m18500b(6, x_);
    }

    /* renamed from: a */
    public final void mo3825a(C2758b c2758b, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str);
        m18500b(2, x_);
    }

    /* renamed from: a */
    public final void mo3826a(C2758b c2758b, String str, String str2) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str);
        x_.writeString(null);
        m18500b(8, x_);
    }

    /* renamed from: a */
    public final void mo3827a(byte[] bArr) {
        Parcel x_ = x_();
        x_.writeByteArray(bArr);
        m18500b(5, x_);
    }

    /* renamed from: a */
    public final void mo3828a(int[] iArr) {
        Parcel x_ = x_();
        x_.writeIntArray(null);
        m18500b(4, x_);
    }

    /* renamed from: b */
    public final void mo3829b(int i) {
        Parcel x_ = x_();
        x_.writeInt(i);
        m18500b(7, x_);
    }
}
