package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.internal.k.ad */
public final class ad extends C5022a implements ab {
    ad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    /* renamed from: a */
    public final void mo4654a() {
        m21122b(1, D_());
    }

    /* renamed from: a */
    public final void mo4655a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(22, D_);
    }

    /* renamed from: a */
    public final void mo4656a(float f, float f2) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        D_.writeFloat(f2);
        m21122b(19, D_);
    }

    /* renamed from: a */
    public final void mo4657a(C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        m21122b(18, D_);
    }

    /* renamed from: a */
    public final void mo4658a(LatLng latLng) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLng);
        m21122b(3, D_);
    }

    /* renamed from: a */
    public final void mo4659a(String str) {
        Parcel D_ = D_();
        D_.writeString(str);
        m21122b(5, D_);
    }

    /* renamed from: a */
    public final void mo4660a(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(9, D_);
    }

    /* renamed from: a */
    public final boolean mo4661a(ab abVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) abVar);
        Parcel a = m21121a(16, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final LatLng mo4662b() {
        Parcel a = m21121a(4, D_());
        LatLng latLng = (LatLng) C5026k.m21175a(a, LatLng.CREATOR);
        a.recycle();
        return latLng;
    }

    /* renamed from: b */
    public final void mo4663b(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(25, D_);
    }

    /* renamed from: b */
    public final void mo4664b(float f, float f2) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        D_.writeFloat(f2);
        m21122b(24, D_);
    }

    /* renamed from: b */
    public final void mo4665b(String str) {
        Parcel D_ = D_();
        D_.writeString(str);
        m21122b(7, D_);
    }

    /* renamed from: b */
    public final void mo4666b(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(14, D_);
    }

    /* renamed from: c */
    public final String mo4667c() {
        Parcel a = m21121a(6, D_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4668c(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(27, D_);
    }

    /* renamed from: c */
    public final void mo4669c(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(20, D_);
    }

    /* renamed from: d */
    public final String mo4670d() {
        Parcel a = m21121a(8, D_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: e */
    public final void mo4671e() {
        m21122b(11, D_());
    }

    /* renamed from: f */
    public final void mo4672f() {
        m21122b(12, D_());
    }

    /* renamed from: g */
    public final int mo4673g() {
        Parcel a = m21121a(17, D_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
