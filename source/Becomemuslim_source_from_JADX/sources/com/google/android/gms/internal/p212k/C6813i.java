package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.C7856w;

/* renamed from: com.google.android.gms.internal.k.i */
public final class C6813i extends C5022a implements C5024g {
    C6813i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    /* renamed from: a */
    public final C7856w mo4706a(int i, int i2, int i3) {
        Parcel D_ = D_();
        D_.writeInt(i);
        D_.writeInt(i2);
        D_.writeInt(i3);
        Parcel a = m21121a(1, D_);
        C7856w c7856w = (C7856w) C5026k.m21175a(a, C7856w.CREATOR);
        a.recycle();
        return c7856w;
    }
}
