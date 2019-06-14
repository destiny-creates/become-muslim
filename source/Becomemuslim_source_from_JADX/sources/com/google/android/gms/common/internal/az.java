package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class az extends C4958a implements ax {
    az(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    /* renamed from: a */
    public final C2758b mo2469a() {
        Parcel a = a(1, c());
        C2758b a2 = C4325a.m14024a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final int mo2470b() {
        Parcel a = a(2, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
