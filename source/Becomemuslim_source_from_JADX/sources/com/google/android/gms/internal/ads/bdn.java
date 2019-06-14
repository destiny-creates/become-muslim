package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class bdn extends ajl implements bdk {
    bdn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    /* renamed from: a */
    public final String mo4145a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4146a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(11, x_);
    }

    /* renamed from: a */
    public final void mo4147a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        ajn.m18502a(x_, (IInterface) c2758b3);
        m18500b(22, x_);
    }

    /* renamed from: b */
    public final List mo4148b() {
        Parcel a = m18499a(3, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final void mo4149b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(12, x_);
    }

    /* renamed from: c */
    public final String mo4150c() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4151c(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(16, x_);
    }

    /* renamed from: d */
    public final avd mo4152d() {
        Parcel a = m18499a(5, x_());
        avd a2 = ave.m30251a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: e */
    public final String mo4153e() {
        Parcel a = m18499a(6, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final double mo4154f() {
        Parcel a = m18499a(7, x_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    /* renamed from: g */
    public final String mo4155g() {
        Parcel a = m18499a(8, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: h */
    public final String mo4156h() {
        Parcel a = m18499a(9, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: i */
    public final void mo4157i() {
        m18500b(10, x_());
    }

    /* renamed from: j */
    public final boolean mo4158j() {
        Parcel a = m18499a(13, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: k */
    public final boolean mo4159k() {
        Parcel a = m18499a(14, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: l */
    public final Bundle mo4160l() {
        Parcel a = m18499a(15, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: m */
    public final aqv mo4161m() {
        Parcel a = m18499a(17, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final C2758b mo4162n() {
        Parcel a = m18499a(18, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final auz mo4163o() {
        Parcel a = m18499a(19, x_());
        auz a2 = ava.m30248a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: p */
    public final C2758b mo4164p() {
        Parcel a = m18499a(20, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: q */
    public final C2758b mo4165q() {
        Parcel a = m18499a(21, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
