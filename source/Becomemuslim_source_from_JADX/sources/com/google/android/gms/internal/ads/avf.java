package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class avf extends ajl implements avd {
    avf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    /* renamed from: a */
    public final C2758b mo3996a() {
        Parcel a = m18499a(1, x_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final Uri mo3997b() {
        Parcel a = m18499a(2, x_());
        Uri uri = (Uri) ajn.m18501a(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    /* renamed from: c */
    public final double mo3998c() {
        Parcel a = m18499a(3, x_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }
}
