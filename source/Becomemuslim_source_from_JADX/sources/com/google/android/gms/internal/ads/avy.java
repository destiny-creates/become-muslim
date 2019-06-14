package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class avy extends ajl implements avw {
    avy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* renamed from: a */
    public final String mo4027a() {
        Parcel a = m18499a(3, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4028a(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(12, x_);
    }

    /* renamed from: b */
    public final List mo4029b() {
        Parcel a = m18499a(4, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final boolean mo4030b(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        Parcel a = m18499a(13, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final C2758b mo4031c() {
        Parcel a = m18499a(16, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final void mo4032c(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(14, x_);
    }

    /* renamed from: d */
    public final String mo4033d() {
        Parcel a = m18499a(17, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: e */
    public final String mo4034e() {
        Parcel a = m18499a(5, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final avd mo4035f() {
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

    /* renamed from: g */
    public final String mo4036g() {
        Parcel a = m18499a(7, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: h */
    public final String mo4037h() {
        Parcel a = m18499a(8, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: i */
    public final aqv mo4038i() {
        Parcel a = m18499a(11, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: j */
    public final C2758b mo4039j() {
        Parcel a = m18499a(2, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final Bundle mo4040n() {
        Parcel a = m18499a(9, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: p */
    public final auz mo4041p() {
        auz auz;
        Parcel a = m18499a(15, x_());
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

    /* renamed from: q */
    public final void mo4042q() {
        m18500b(10, x_());
    }
}
