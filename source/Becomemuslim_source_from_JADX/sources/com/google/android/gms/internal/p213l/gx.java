package com.google.android.gms.internal.p213l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.l.gx */
public final class gx extends gr implements gv {
    gx(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    /* renamed from: a */
    public final Bundle mo4764a(Bundle bundle) {
        Parcel a = m21376a();
        gt.m21381a(a, (Parcelable) bundle);
        Parcel a2 = m21377a(1, a);
        Bundle bundle2 = (Bundle) gt.m21380a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle2;
    }
}
