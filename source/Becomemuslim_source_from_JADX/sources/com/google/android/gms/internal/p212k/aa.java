package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.k.aa */
public final class aa extends C5022a implements C5032y {
    aa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    /* renamed from: a */
    public final String mo4649a() {
        Parcel a = m21121a(1, D_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final boolean mo4650a(C5032y c5032y) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5032y);
        Parcel a = m21121a(4, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final String mo4651b() {
        Parcel a = m21121a(2, D_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4652c() {
        m21122b(3, D_());
    }

    /* renamed from: d */
    public final int mo4653d() {
        Parcel a = m21121a(5, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
