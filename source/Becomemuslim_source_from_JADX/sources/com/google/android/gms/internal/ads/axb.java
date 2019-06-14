package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class axb extends ajl implements awz {
    axb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* renamed from: a */
    public final String mo4062a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4063a(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(15, x_);
    }

    /* renamed from: a */
    public final void mo4064a(awx awx) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awx);
        m18500b(21, x_);
    }

    /* renamed from: b */
    public final List mo4065b() {
        Parcel a = m18499a(3, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final boolean mo4066b(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        Parcel a = m18499a(16, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final String mo4067c() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4068c(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(17, x_);
    }

    /* renamed from: d */
    public final avd mo4069d() {
        avd avd;
        Parcel a = m18499a(5, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            avd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            avd = queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(readStrongBinder);
        }
        a.recycle();
        return avd;
    }

    /* renamed from: e */
    public final String mo4070e() {
        Parcel a = m18499a(6, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final String mo4071f() {
        Parcel a = m18499a(7, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: g */
    public final double mo4072g() {
        Parcel a = m18499a(8, x_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    /* renamed from: h */
    public final String mo4073h() {
        Parcel a = m18499a(9, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: i */
    public final String mo4074i() {
        Parcel a = m18499a(10, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: j */
    public final aqv mo4075j() {
        Parcel a = m18499a(11, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final C2758b mo4076n() {
        Parcel a = m18499a(18, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: p */
    public final C2758b mo4077p() {
        Parcel a = m18499a(19, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: q */
    public final String mo4078q() {
        Parcel a = m18499a(12, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: r */
    public final Bundle mo4079r() {
        Parcel a = m18499a(20, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: s */
    public final auz mo4080s() {
        auz auz;
        Parcel a = m18499a(14, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            auz = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            auz = queryLocalInterface instanceof auz ? (auz) queryLocalInterface : new avb(readStrongBinder);
        }
        a.recycle();
        return auz;
    }

    /* renamed from: t */
    public final void mo4081t() {
        m18500b(13, x_());
    }

    /* renamed from: u */
    public final void mo4082u() {
        m18500b(22, x_());
    }
}
