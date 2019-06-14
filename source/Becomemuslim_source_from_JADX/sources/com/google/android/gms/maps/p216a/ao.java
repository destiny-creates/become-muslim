package com.google.android.gms.maps.p216a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p212k.C5022a;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.internal.p212k.C5028m;
import com.google.android.gms.internal.p212k.C6814n;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.maps.a.ao */
public final class ao extends C5022a implements an {
    ao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    /* renamed from: a */
    public final C5091a mo4792a() {
        C5091a c5091a;
        Parcel a = m21121a(4, D_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            c5091a = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            c5091a = queryLocalInterface instanceof C5091a ? (C5091a) queryLocalInterface : new C6844y(readStrongBinder);
        }
        a.recycle();
        return c5091a;
    }

    /* renamed from: a */
    public final C5093c mo4793a(C2758b c2758b, GoogleMapOptions googleMapOptions) {
        C5093c c5093c;
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        C5026k.m21177a(D_, (Parcelable) googleMapOptions);
        Parcel a = m21121a(3, D_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            c5093c = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            c5093c = queryLocalInterface instanceof C5093c ? (C5093c) queryLocalInterface : new as(readStrongBinder);
        }
        a.recycle();
        return c5093c;
    }

    /* renamed from: a */
    public final void mo4794a(C2758b c2758b, int i) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        D_.writeInt(i);
        m21122b(6, D_);
    }

    /* renamed from: b */
    public final C5028m mo4795b() {
        Parcel a = m21121a(5, D_());
        C5028m a2 = C6814n.m31897a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
