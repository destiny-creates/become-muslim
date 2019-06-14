package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* renamed from: com.google.android.gms.internal.k.x */
public final class C6821x extends C5022a implements C5031v {
    C6821x(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    /* renamed from: a */
    public final int mo4728a() {
        Parcel a = m21121a(1, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: a */
    public final boolean mo4729a(C5031v c5031v) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5031v);
        Parcel a = m21121a(5, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final List<IBinder> mo4730b() {
        Parcel a = m21121a(3, D_());
        List createBinderArrayList = a.createBinderArrayList();
        a.recycle();
        return createBinderArrayList;
    }

    /* renamed from: c */
    public final boolean mo4731c() {
        Parcel a = m21121a(4, D_());
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final int mo4732d() {
        Parcel a = m21121a(6, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
