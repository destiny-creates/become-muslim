package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.internal.k.r */
public final class C6817r extends C5022a implements C5029p {
    C6817r(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    public final void B_() {
        m21122b(1, D_());
    }

    /* renamed from: a */
    public final void mo4712a(double d) {
        Parcel D_ = D_();
        D_.writeDouble(d);
        m21122b(5, D_);
    }

    /* renamed from: a */
    public final void mo4713a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(7, D_);
    }

    /* renamed from: a */
    public final void mo4714a(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(9, D_);
    }

    /* renamed from: a */
    public final void mo4715a(LatLng latLng) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLng);
        m21122b(3, D_);
    }

    /* renamed from: a */
    public final boolean mo4716a(C5029p c5029p) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5029p);
        Parcel a = m21121a(17, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final int mo4717b() {
        Parcel a = m21121a(18, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: b */
    public final void mo4718b(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(13, D_);
    }

    /* renamed from: b */
    public final void mo4719b(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(11, D_);
    }
}
