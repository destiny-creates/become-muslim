package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

public final class avb extends ajl implements auz {
    avb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    /* renamed from: a */
    public final String mo3994a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: b */
    public final List<avd> mo3995b() {
        Parcel a = m18499a(3, x_());
        List b = ajn.m18506b(a);
        a.recycle();
        return b;
    }
}
