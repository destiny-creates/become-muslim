package com.google.android.gms.maps.p216a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p212k.C5022a;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.a.as */
public final class as extends C5022a implements C5093c {
    as(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    /* renamed from: a */
    public final void mo4835a() {
        m21122b(3, D_());
    }

    /* renamed from: a */
    public final void mo4836a(Bundle bundle) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) bundle);
        m21122b(2, D_);
    }

    /* renamed from: a */
    public final void mo4837a(C5101q c5101q) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5101q);
        m21122b(9, D_);
    }

    /* renamed from: b */
    public final void mo4838b() {
        m21122b(4, D_());
    }

    /* renamed from: b */
    public final void mo4839b(Bundle bundle) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) bundle);
        D_ = m21121a(7, D_);
        if (D_.readInt() != 0) {
            bundle.readFromParcel(D_);
        }
        D_.recycle();
    }

    /* renamed from: c */
    public final void mo4840c() {
        m21122b(5, D_());
    }

    /* renamed from: c */
    public final void mo4841c(Bundle bundle) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) bundle);
        m21122b(10, D_);
    }

    /* renamed from: d */
    public final void mo4842d() {
        m21122b(6, D_());
    }

    /* renamed from: e */
    public final C2758b mo4843e() {
        Parcel a = m21121a(8, D_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: f */
    public final void mo4844f() {
        m21122b(11, D_());
    }

    /* renamed from: g */
    public final void mo4845g() {
        m21122b(12, D_());
    }

    /* renamed from: h */
    public final void mo4846h() {
        m21122b(13, D_());
    }
}
