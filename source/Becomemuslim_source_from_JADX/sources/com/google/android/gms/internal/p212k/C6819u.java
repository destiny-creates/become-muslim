package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.internal.k.u */
public final class C6819u extends C5022a implements C5030s {
    C6819u(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    public final void C_() {
        m21122b(1, D_());
    }

    /* renamed from: a */
    public final void mo4721a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(13, D_);
    }

    /* renamed from: a */
    public final void mo4722a(C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        m21122b(21, D_);
    }

    /* renamed from: a */
    public final void mo4723a(LatLngBounds latLngBounds) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLngBounds);
        m21122b(9, D_);
    }

    /* renamed from: a */
    public final void mo4724a(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(15, D_);
    }

    /* renamed from: a */
    public final boolean mo4725a(C5030s c5030s) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5030s);
        Parcel a = m21121a(19, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final int mo4726b() {
        Parcel a = m21121a(20, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: b */
    public final void mo4727b(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(22, D_);
    }
}
