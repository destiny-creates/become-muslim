package com.google.android.gms.maps.p216a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p212k.C5022a;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.a.y */
public final class C6844y extends C5022a implements C5091a {
    C6844y(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    /* renamed from: a */
    public final C2758b mo4847a(CameraPosition cameraPosition) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) cameraPosition);
        Parcel a = m21121a(7, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4848a(LatLng latLng) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLng);
        Parcel a = m21121a(8, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4849a(LatLng latLng, float f) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLng);
        D_.writeFloat(f);
        Parcel a = m21121a(9, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4850a(LatLngBounds latLngBounds, int i) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLngBounds);
        D_.writeInt(i);
        Parcel a = m21121a(10, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4851a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLngBounds);
        D_.writeInt(i);
        D_.writeInt(i2);
        D_.writeInt(i3);
        Parcel a = m21121a(11, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
