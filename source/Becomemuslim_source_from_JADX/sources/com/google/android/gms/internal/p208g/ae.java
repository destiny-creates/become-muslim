package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.p188b.C4799a;

/* renamed from: com.google.android.gms.internal.g.ae */
public final class ae extends C4970a implements ac {
    ae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    /* renamed from: a */
    public final void mo4399a(C4799a c4799a) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4799a);
        m20250b(1, a);
    }
}
