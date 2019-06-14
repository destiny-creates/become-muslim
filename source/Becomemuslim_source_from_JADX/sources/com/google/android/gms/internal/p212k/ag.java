package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: com.google.android.gms.internal.k.ag */
public final class ag extends C5022a implements ae {
    ag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    /* renamed from: a */
    public final void mo4674a() {
        m21122b(1, D_());
    }

    /* renamed from: a */
    public final void mo4675a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(7, D_);
    }

    /* renamed from: a */
    public final void mo4676a(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(9, D_);
    }

    /* renamed from: a */
    public final void mo4677a(List<LatLng> list) {
        Parcel D_ = D_();
        D_.writeTypedList(list);
        m21122b(3, D_);
    }

    /* renamed from: a */
    public final void mo4678a(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(15, D_);
    }

    /* renamed from: a */
    public final boolean mo4679a(ae aeVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) aeVar);
        Parcel a = m21121a(19, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final List<LatLng> mo4680b() {
        Parcel a = m21121a(4, D_());
        List createTypedArrayList = a.createTypedArrayList(LatLng.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    /* renamed from: b */
    public final void mo4681b(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(13, D_);
    }

    /* renamed from: b */
    public final void mo4682b(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(11, D_);
    }

    /* renamed from: b */
    public final void mo4683b(List list) {
        Parcel D_ = D_();
        D_.writeList(list);
        m21122b(5, D_);
    }

    /* renamed from: b */
    public final void mo4684b(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(17, D_);
    }

    /* renamed from: c */
    public final int mo4685c() {
        Parcel a = m21121a(20, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: c */
    public final void mo4686c(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(21, D_);
    }
}
