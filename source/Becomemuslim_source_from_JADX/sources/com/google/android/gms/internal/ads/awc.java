package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;
import java.util.List;

public final class awc extends ajl implements awa {
    awc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    /* renamed from: a */
    public final String mo4043a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(1, x_);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final List<String> mo4044a() {
        Parcel a = m18499a(3, x_());
        List createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    /* renamed from: a */
    public final boolean mo4045a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(10, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final C2758b mo4046b() {
        Parcel a = m18499a(11, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final avd mo4047b(String str) {
        avd avd;
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(2, x_);
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

    /* renamed from: c */
    public final aqv mo4048c() {
        Parcel a = m18499a(7, x_());
        aqv a2 = aqw.m30145a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final void mo4049c(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(5, x_);
    }

    /* renamed from: d */
    public final void mo4050d() {
        m18500b(6, x_());
    }

    /* renamed from: e */
    public final C2758b mo4051e() {
        Parcel a = m18499a(9, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: f */
    public final void mo4052f() {
        m18500b(8, x_());
    }

    /* renamed from: l */
    public final String mo4053l() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
