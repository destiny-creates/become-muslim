package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.internal.ads.t */
public final class C6768t extends ajl implements C4936r {
    C6768t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    /* renamed from: a */
    public final void mo4358a(int i, int i2, Intent intent) {
        Parcel x_ = x_();
        x_.writeInt(i);
        x_.writeInt(i2);
        ajn.m18503a(x_, (Parcelable) intent);
        m18500b(12, x_);
    }

    /* renamed from: a */
    public final void mo4359a(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        m18500b(1, x_);
    }

    /* renamed from: a */
    public final void mo4360a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(13, x_);
    }

    /* renamed from: b */
    public final void mo4361b(Bundle bundle) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) bundle);
        x_ = m18499a(6, x_);
        if (x_.readInt() != 0) {
            bundle.readFromParcel(x_);
        }
        x_.recycle();
    }

    /* renamed from: d */
    public final void mo4362d() {
        m18500b(10, x_());
    }

    /* renamed from: e */
    public final boolean mo4363e() {
        Parcel a = m18499a(11, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: f */
    public final void mo4364f() {
        m18500b(2, x_());
    }

    /* renamed from: g */
    public final void mo4365g() {
        m18500b(3, x_());
    }

    /* renamed from: h */
    public final void mo4366h() {
        m18500b(4, x_());
    }

    /* renamed from: i */
    public final void mo4367i() {
        m18500b(5, x_());
    }

    /* renamed from: j */
    public final void mo4368j() {
        m18500b(7, x_());
    }

    /* renamed from: k */
    public final void mo4369k() {
        m18500b(8, x_());
    }

    /* renamed from: l */
    public final void mo4370l() {
        m18500b(9, x_());
    }
}
