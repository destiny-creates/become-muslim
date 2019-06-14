package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.p188b.C4800b;

/* renamed from: com.google.android.gms.internal.g.ag */
public abstract class ag extends C4976z implements af {
    public ag() {
        super("com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }

    /* renamed from: a */
    public static af m31272a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
        return queryLocalInterface instanceof af ? (af) queryLocalInterface : new ah(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4398a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4400a((C4800b) ap.m20255a(parcel, C4800b.CREATOR));
        return true;
    }
}
