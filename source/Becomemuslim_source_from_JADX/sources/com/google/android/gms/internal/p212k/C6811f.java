package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.k.f */
public final class C6811f extends C5022a implements C5023d {
    C6811f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    /* renamed from: a */
    public final void mo4700a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(4, D_);
    }

    /* renamed from: a */
    public final boolean mo4701a(C5023d c5023d) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5023d);
        Parcel a = m21121a(8, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final void mo4702b() {
        m21122b(2, D_());
    }

    /* renamed from: c */
    public final int mo4703c() {
        Parcel a = m21121a(9, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final void z_() {
        m21122b(1, D_());
    }
}
