package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class bdd extends ajl implements bdb {
    bdd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* renamed from: a */
    public final C2758b mo4105a() {
        Parcel a = m18499a(2, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo4106a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(21, x_);
    }

    /* renamed from: a */
    public final void mo4107a(C2758b c2758b, aoq aoq, String str, bde bde) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bde);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo4108a(C2758b c2758b, aoq aoq, String str, hm hmVar, String str2) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) hmVar);
        x_.writeString(str2);
        m18500b(10, x_);
    }

    /* renamed from: a */
    public final void mo4109a(C2758b c2758b, aoq aoq, String str, String str2, bde bde) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        x_.writeString(str2);
        ajn.m18502a(x_, (IInterface) bde);
        m18500b(7, x_);
    }

    /* renamed from: a */
    public final void mo4110a(C2758b c2758b, aoq aoq, String str, String str2, bde bde, aus aus, List<String> list) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        x_.writeString(str2);
        ajn.m18502a(x_, (IInterface) bde);
        ajn.m18503a(x_, (Parcelable) aus);
        x_.writeStringList(list);
        m18500b(14, x_);
    }

    /* renamed from: a */
    public final void mo4111a(C2758b c2758b, aou aou, aoq aoq, String str, bde bde) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bde);
        m18500b(1, x_);
    }

    /* renamed from: a */
    public final void mo4112a(C2758b c2758b, aou aou, aoq aoq, String str, String str2, bde bde) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        x_.writeString(str2);
        ajn.m18502a(x_, (IInterface) bde);
        m18500b(6, x_);
    }

    /* renamed from: a */
    public final void mo4113a(C2758b c2758b, hm hmVar, List<String> list) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) hmVar);
        x_.writeStringList(list);
        m18500b(23, x_);
    }

    /* renamed from: a */
    public final void mo4114a(aoq aoq, String str) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        m18500b(11, x_);
    }

    /* renamed from: a */
    public final void mo4115a(aoq aoq, String str, String str2) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeString(str);
        x_.writeString(str2);
        m18500b(20, x_);
    }

    /* renamed from: a */
    public final void mo4116a(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(25, x_);
    }

    /* renamed from: b */
    public final void mo4117b() {
        m18500b(4, x_());
    }

    /* renamed from: c */
    public final void mo4118c() {
        m18500b(5, x_());
    }

    /* renamed from: d */
    public final void mo4119d() {
        m18500b(8, x_());
    }

    /* renamed from: e */
    public final void mo4120e() {
        m18500b(9, x_());
    }

    /* renamed from: f */
    public final void mo4121f() {
        m18500b(12, x_());
    }

    /* renamed from: g */
    public final boolean mo4122g() {
        Parcel a = m18499a(13, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: h */
    public final bdk mo4123h() {
        bdk bdk;
        Parcel a = m18499a(15, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            bdk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            bdk = queryLocalInterface instanceof bdk ? (bdk) queryLocalInterface : new bdn(readStrongBinder);
        }
        a.recycle();
        return bdk;
    }

    /* renamed from: i */
    public final bdo mo4124i() {
        bdo bdo;
        Parcel a = m18499a(16, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            bdo = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            bdo = queryLocalInterface instanceof bdo ? (bdo) queryLocalInterface : new bdq(readStrongBinder);
        }
        a.recycle();
        return bdo;
    }

    /* renamed from: j */
    public final Bundle mo4125j() {
        Parcel a = m18499a(17, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: k */
    public final Bundle mo4126k() {
        Parcel a = m18499a(18, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: l */
    public final Bundle mo4127l() {
        Parcel a = m18499a(19, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: m */
    public final boolean mo4128m() {
        Parcel a = m18499a(22, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final awa mo4129n() {
        Parcel a = m18499a(24, x_());
        awa a2 = awb.m30304a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final aqv mo4130o() {
        Parcel a = m18499a(26, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: p */
    public final bdr mo4131p() {
        bdr bdr;
        Parcel a = m18499a(27, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            bdr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            bdr = queryLocalInterface instanceof bdr ? (bdr) queryLocalInterface : new bdt(readStrongBinder);
        }
        a.recycle();
        return bdr;
    }
}
