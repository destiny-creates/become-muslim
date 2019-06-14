package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class aqa extends ajl implements apy {
    aqa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* renamed from: C */
    public final String mo3881C() {
        Parcel a = m18499a(31, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: D */
    public final aqh mo3882D() {
        aqh aqh;
        Parcel a = m18499a(32, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            aqh = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            aqh = queryLocalInterface instanceof aqh ? (aqh) queryLocalInterface : new aqj(readStrongBinder);
        }
        a.recycle();
        return aqh;
    }

    /* renamed from: E */
    public final apn mo3883E() {
        apn apn;
        Parcel a = m18499a(33, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apn = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            apn = queryLocalInterface instanceof apn ? (apn) queryLocalInterface : new app(readStrongBinder);
        }
        a.recycle();
        return apn;
    }

    /* renamed from: H */
    public final void mo3884H() {
        m18500b(9, x_());
    }

    /* renamed from: a */
    public final String mo3885a() {
        Parcel a = m18499a(18, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo3886a(af afVar, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) afVar);
        x_.writeString(str);
        m18500b(15, x_);
    }

    /* renamed from: a */
    public final void mo3887a(aou aou) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aou);
        m18500b(13, x_);
    }

    /* renamed from: a */
    public final void mo3888a(apk apk) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) apk);
        m18500b(20, x_);
    }

    /* renamed from: a */
    public final void mo3889a(apn apn) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) apn);
        m18500b(7, x_);
    }

    /* renamed from: a */
    public final void mo3890a(aqd aqd) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqd);
        m18500b(36, x_);
    }

    /* renamed from: a */
    public final void mo3891a(aqh aqh) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqh);
        m18500b(8, x_);
    }

    /* renamed from: a */
    public final void mo3892a(aqn aqn) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqn);
        m18500b(21, x_);
    }

    /* renamed from: a */
    public final void mo3893a(arb arb) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) arb);
        m18500b(30, x_);
    }

    /* renamed from: a */
    public final void mo3894a(ary ary) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) ary);
        m18500b(29, x_);
    }

    /* renamed from: a */
    public final void mo3895a(atj atj) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) atj);
        m18500b(19, x_);
    }

    /* renamed from: a */
    public final void mo3896a(gn gnVar) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) gnVar);
        m18500b(24, x_);
    }

    /* renamed from: a */
    public final void mo3897a(C4939y c4939y) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c4939y);
        m18500b(14, x_);
    }

    /* renamed from: a */
    public final void mo3898a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(25, x_);
    }

    /* renamed from: b */
    public final void mo3899b(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(22, x_);
    }

    /* renamed from: b */
    public final boolean mo3900b(aoq aoq) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aoq);
        Parcel a = m18499a(4, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final void mo3901c(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(34, x_);
    }

    /* renamed from: i */
    public final void mo3902i() {
        m18500b(2, x_());
    }

    /* renamed from: j */
    public final C2758b mo3903j() {
        Parcel a = m18499a(1, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: k */
    public final aou mo3904k() {
        Parcel a = m18499a(12, x_());
        aou aou = (aou) ajn.m18501a(a, aou.CREATOR);
        a.recycle();
        return aou;
    }

    /* renamed from: l */
    public final boolean mo3905l() {
        Parcel a = m18499a(3, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: m */
    public final void mo3906m() {
        m18500b(11, x_());
    }

    /* renamed from: n */
    public final void mo3907n() {
        m18500b(5, x_());
    }

    /* renamed from: o */
    public final void mo3908o() {
        m18500b(6, x_());
    }

    /* renamed from: p */
    public final Bundle mo3909p() {
        Parcel a = m18499a(37, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: q */
    public final void mo3910q() {
        m18500b(10, x_());
    }

    /* renamed from: r */
    public final boolean mo3911r() {
        Parcel a = m18499a(23, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: s */
    public final aqv mo3912s() {
        aqv aqv;
        Parcel a = m18499a(26, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            aqv = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            aqv = queryLocalInterface instanceof aqv ? (aqv) queryLocalInterface : new aqx(readStrongBinder);
        }
        a.recycle();
        return aqv;
    }

    public final String w_() {
        Parcel a = m18499a(35, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
