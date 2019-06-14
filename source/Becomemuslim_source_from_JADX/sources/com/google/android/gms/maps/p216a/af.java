package com.google.android.gms.maps.p216a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p212k.C5022a;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.ab;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.a.af */
public final class af extends C5022a implements C5094d {
    af(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    /* renamed from: a */
    public final C2758b mo4779a(LatLng latLng) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLng);
        Parcel a = m21121a(2, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final LatLng mo4780a(C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        Parcel a = m21121a(1, D_);
        LatLng latLng = (LatLng) C5026k.m21175a(a, LatLng.CREATOR);
        a.recycle();
        return latLng;
    }

    /* renamed from: a */
    public final ab mo4781a() {
        Parcel a = m21121a(3, D_());
        ab abVar = (ab) C5026k.m21175a(a, ab.CREATOR);
        a.recycle();
        return abVar;
    }
}
