package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class bdg extends ajl implements bde {
    bdg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    /* renamed from: a */
    public final void mo4132a() {
        m18500b(1, x_());
    }

    /* renamed from: a */
    public final void mo4133a(int i) {
        Parcel x_ = x_();
        x_.writeInt(i);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo4134a(awa awa, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awa);
        x_.writeString(str);
        m18500b(10, x_);
    }

    /* renamed from: a */
    public final void mo4135a(bdh bdh) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) bdh);
        m18500b(7, x_);
    }

    /* renamed from: a */
    public final void mo4136a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(12, x_);
    }

    /* renamed from: a */
    public final void mo4137a(String str, String str2) {
        Parcel x_ = x_();
        x_.writeString(str);
        x_.writeString(str2);
        m18500b(9, x_);
    }

    /* renamed from: b */
    public final void mo4138b() {
        m18500b(2, x_());
    }

    /* renamed from: c */
    public final void mo4139c() {
        m18500b(4, x_());
    }

    /* renamed from: d */
    public final void mo4140d() {
        m18500b(5, x_());
    }

    /* renamed from: e */
    public final void mo4141e() {
        m18500b(6, x_());
    }

    /* renamed from: f */
    public final void mo4142f() {
        m18500b(8, x_());
    }

    /* renamed from: g */
    public final void mo4143g() {
        m18500b(11, x_());
    }
}
