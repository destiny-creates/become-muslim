package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.p188b.C4800b;

/* renamed from: com.google.android.gms.internal.g.ah */
public final class ah extends C4970a implements af {
    ah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }

    /* renamed from: a */
    public final void mo4400a(C4800b c4800b) {
        Parcel a = m20248a();
        ap.m20256a(a, (Parcelable) c4800b);
        m20250b(1, a);
    }
}
