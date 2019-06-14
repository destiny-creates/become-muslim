package com.google.android.gms.internal.p195a;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.a.g */
public final class C4435g extends C3080a implements C3084e {
    C4435g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    /* renamed from: a */
    public final String mo2607a() {
        Parcel a = m9019a(1, y_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final boolean mo2608a(boolean z) {
        Parcel y_ = y_();
        C3082c.m9020a(y_, true);
        y_ = m9019a(2, y_);
        boolean a = C3082c.m9021a(y_);
        y_.recycle();
        return a;
    }

    /* renamed from: b */
    public final boolean mo2609b() {
        Parcel a = m9019a(6, y_());
        boolean a2 = C3082c.m9021a(a);
        a.recycle();
        return a2;
    }
}
