package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class gp extends ajl implements gn {
    gp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    /* renamed from: a */
    public final void mo4267a() {
        m18500b(1, x_());
    }

    /* renamed from: a */
    public final void mo4268a(int i) {
        Parcel x_ = x_();
        x_.writeInt(i);
        m18500b(7, x_);
    }

    /* renamed from: a */
    public final void mo4269a(gc gcVar) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) gcVar);
        m18500b(5, x_);
    }

    /* renamed from: b */
    public final void mo4270b() {
        m18500b(2, x_());
    }

    /* renamed from: c */
    public final void mo4271c() {
        m18500b(3, x_());
    }

    /* renamed from: d */
    public final void mo4272d() {
        m18500b(4, x_());
    }

    /* renamed from: e */
    public final void mo4273e() {
        m18500b(6, x_());
    }

    /* renamed from: f */
    public final void mo4274f() {
        m18500b(8, x_());
    }
}
