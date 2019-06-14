package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class bdq extends ajl implements bdo {
    bdq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    /* renamed from: a */
    public final String mo4166a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4167a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(9, x_);
    }

    /* renamed from: a */
    public final void mo4168a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        ajn.m18502a(x_, (IInterface) c2758b3);
        m18500b(22, x_);
    }

    /* renamed from: b */
    public final List mo4169b() {
        Parcel a = m18499a(3, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }

    /* renamed from: b */
    public final void mo4170b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(10, x_);
    }

    /* renamed from: c */
    public final String mo4171c() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo4172c(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(14, x_);
    }

    /* renamed from: d */
    public final avd mo4173d() {
        Parcel a = m18499a(5, x_());
        avd a2 = ave.m30251a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: e */
    public final String mo4174e() {
        Parcel a = m18499a(6, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final String mo4175f() {
        Parcel a = m18499a(7, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: g */
    public final void mo4176g() {
        m18500b(8, x_());
    }

    /* renamed from: h */
    public final boolean mo4177h() {
        Parcel a = m18499a(11, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: i */
    public final boolean mo4178i() {
        Parcel a = m18499a(12, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: j */
    public final Bundle mo4179j() {
        Parcel a = m18499a(13, x_());
        Bundle bundle = (Bundle) ajn.m18501a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: k */
    public final C2758b mo4180k() {
        Parcel a = m18499a(15, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: l */
    public final aqv mo4181l() {
        Parcel a = m18499a(16, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: m */
    public final auz mo4182m() {
        Parcel a = m18499a(19, x_());
        auz a2 = ava.m30248a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final C2758b mo4183n() {
        Parcel a = m18499a(20, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final C2758b mo4184o() {
        Parcel a = m18499a(21, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
