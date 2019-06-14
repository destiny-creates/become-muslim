package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.C7847d;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: com.google.android.gms.internal.k.c */
public final class C6809c extends C5022a implements ah {
    C6809c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    /* renamed from: a */
    public final void mo4687a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(5, D_);
    }

    /* renamed from: a */
    public final void mo4688a(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(7, D_);
    }

    /* renamed from: a */
    public final void mo4689a(C7847d c7847d) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7847d);
        m21122b(19, D_);
    }

    /* renamed from: a */
    public final void mo4690a(List<LatLng> list) {
        Parcel D_ = D_();
        D_.writeTypedList(list);
        m21122b(3, D_);
    }

    /* renamed from: a */
    public final void mo4691a(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(11, D_);
    }

    /* renamed from: a */
    public final boolean mo4692a(ah ahVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) ahVar);
        Parcel a = m21121a(15, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final void mo4693b() {
        m21122b(1, D_());
    }

    /* renamed from: b */
    public final void mo4694b(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(9, D_);
    }

    /* renamed from: b */
    public final void mo4695b(C7847d c7847d) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7847d);
        m21122b(21, D_);
    }

    /* renamed from: b */
    public final void mo4696b(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(13, D_);
    }

    /* renamed from: c */
    public final List<LatLng> mo4697c() {
        Parcel a = m21121a(4, D_());
        List createTypedArrayList = a.createTypedArrayList(LatLng.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    /* renamed from: c */
    public final void mo4698c(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(17, D_);
    }

    /* renamed from: d */
    public final int mo4699d() {
        Parcel a = m21121a(16, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
