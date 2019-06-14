package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;

public final class gk extends ajl implements gh {
    gk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* renamed from: a */
    public final void mo4250a() {
        m18500b(2, x_());
    }

    /* renamed from: a */
    public final void mo4251a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(9, x_);
    }

    /* renamed from: a */
    public final void mo4252a(aqd aqd) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqd);
        m18500b(14, x_);
    }

    /* renamed from: a */
    public final void mo4253a(gf gfVar) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) gfVar);
        m18500b(16, x_);
    }

    /* renamed from: a */
    public final void mo4254a(gn gnVar) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) gnVar);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo4255a(gt gtVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) gtVar);
        m18500b(1, x_);
    }

    /* renamed from: a */
    public final void mo4256a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(13, x_);
    }

    /* renamed from: a */
    public final void mo4257a(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(34, x_);
    }

    /* renamed from: b */
    public final Bundle mo4258b() {
        Parcel a = m18499a(15, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: b */
    public final void mo4259b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(10, x_);
    }

    /* renamed from: c */
    public final void mo4260c(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(11, x_);
    }

    /* renamed from: c */
    public final boolean mo4261c() {
        Parcel a = m18499a(5, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final void mo4262d() {
        m18500b(6, x_());
    }

    /* renamed from: e */
    public final void mo4263e() {
        m18500b(7, x_());
    }

    /* renamed from: f */
    public final void mo4264f() {
        m18500b(8, x_());
    }

    /* renamed from: g */
    public final String mo4265g() {
        Parcel a = m18499a(12, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
