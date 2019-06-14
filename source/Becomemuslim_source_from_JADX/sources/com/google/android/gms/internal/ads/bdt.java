package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class bdt extends ajl implements bdr {
    bdt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    /* renamed from: a */
    public final String mo4185a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4186a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(20, x_);
    }

    /* renamed from: a */
    public final void mo4187a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        ajn.m18502a(x_, (IInterface) c2758b3);
        m18500b(21, x_);
    }

    /* renamed from: b */
    public final List mo4188b() {
        Parcel a = m18499a(3, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final void mo4189b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(22, x_);
    }

    /* renamed from: c */
    public final String mo4190c() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: d */
    public final avd mo4191d() {
        Parcel a = m18499a(5, x_());
        avd a2 = ave.m30251a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: e */
    public final String mo4192e() {
        Parcel a = m18499a(6, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final String mo4193f() {
        Parcel a = m18499a(7, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: g */
    public final double mo4194g() {
        Parcel a = m18499a(8, x_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    /* renamed from: h */
    public final String mo4195h() {
        Parcel a = m18499a(9, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: i */
    public final String mo4196i() {
        Parcel a = m18499a(10, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: j */
    public final aqv mo4197j() {
        Parcel a = m18499a(11, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: k */
    public final auz mo4198k() {
        Parcel a = m18499a(12, x_());
        auz a2 = ava.m30248a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: l */
    public final C2758b mo4199l() {
        Parcel a = m18499a(13, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: m */
    public final C2758b mo4200m() {
        Parcel a = m18499a(14, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final C2758b mo4201n() {
        Parcel a = m18499a(15, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final Bundle mo4202o() {
        Parcel a = m18499a(16, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: p */
    public final boolean mo4203p() {
        Parcel a = m18499a(17, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: q */
    public final boolean mo4204q() {
        Parcel a = m18499a(18, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: r */
    public final void mo4205r() {
        m18500b(19, x_());
    }
}
