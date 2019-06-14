package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class ti extends ajl implements tg {
    ti(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    /* renamed from: a */
    public final C2758b mo4371a(String str, C2758b c2758b, String str2, String str3, String str4) {
        Parcel x_ = x_();
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str2);
        x_.writeString(str3);
        x_.writeString(str4);
        Parcel a = m18499a(3, x_);
        c2758b = C4325a.a(a.readStrongBinder());
        a.recycle();
        return c2758b;
    }

    /* renamed from: a */
    public final String mo4372a() {
        Parcel a = m18499a(6, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo4373a(C2758b c2758b, C2758b c2758b2) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        m18500b(5, x_);
    }

    /* renamed from: a */
    public final boolean mo4374a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(2, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final void mo4375b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(4, x_);
    }

    /* renamed from: c */
    public final void mo4376c(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(7, x_);
    }
}
