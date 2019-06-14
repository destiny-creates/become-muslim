package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class avu extends ajl implements avs {
    avu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    /* renamed from: a */
    public final String mo4009a() {
        Parcel a = m18499a(3, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4010a(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(14, x_);
    }

    /* renamed from: b */
    public final List mo4011b() {
        Parcel a = m18499a(4, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final boolean mo4012b(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        Parcel a = m18499a(15, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final String mo4013c() {
        Parcel a = m18499a(5, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4014c(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(16, x_);
    }

    /* renamed from: d */
    public final avd mo4015d() {
        avd avd;
        Parcel a = m18499a(6, x_());
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
    public final String mo4016e() {
        Parcel a = m18499a(7, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final double mo4017f() {
        Parcel a = m18499a(8, x_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    /* renamed from: g */
    public final String mo4018g() {
        Parcel a = m18499a(9, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: h */
    public final String mo4019h() {
        Parcel a = m18499a(10, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: i */
    public final aqv mo4020i() {
        Parcel a = m18499a(13, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: j */
    public final C2758b mo4021j() {
        Parcel a = m18499a(2, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final Bundle mo4022n() {
        Parcel a = m18499a(11, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: p */
    public final C2758b mo4023p() {
        Parcel a = m18499a(18, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: q */
    public final String mo4024q() {
        Parcel a = m18499a(19, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: r */
    public final auz mo4025r() {
        auz auz;
        Parcel a = m18499a(17, x_());
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

    /* renamed from: s */
    public final void mo4026s() {
        m18500b(12, x_());
    }
}
