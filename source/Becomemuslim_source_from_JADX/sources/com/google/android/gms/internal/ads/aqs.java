package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

public final class aqs extends ajl implements aqq {
    aqs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* renamed from: a */
    public final void mo3929a() {
        m18500b(1, x_());
    }

    /* renamed from: a */
    public final void mo3930a(float f) {
        Parcel x_ = x_();
        x_.writeFloat(f);
        m18500b(2, x_);
    }

    /* renamed from: a */
    public final void mo3931a(C2758b c2758b, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str);
        m18500b(5, x_);
    }

    /* renamed from: a */
    public final void mo3932a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo3933a(String str, C2758b c2758b) {
        Parcel x_ = x_();
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(6, x_);
    }

    /* renamed from: a */
    public final void mo3934a(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(4, x_);
    }

    /* renamed from: b */
    public final float mo3935b() {
        Parcel a = m18499a(7, x_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: c */
    public final boolean mo3936c() {
        Parcel a = m18499a(8, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }
}
