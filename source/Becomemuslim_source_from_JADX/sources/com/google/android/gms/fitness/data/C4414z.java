package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p208g.C4976z;
import com.google.android.gms.internal.p208g.ap;

/* renamed from: com.google.android.gms.fitness.data.z */
public abstract class C4414z extends C4976z implements C3009y {
    public C4414z() {
        super("com.google.android.gms.fitness.data.IDataSourceListener");
    }

    /* renamed from: a */
    public static C3009y m14686a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
        return queryLocalInterface instanceof C3009y ? (C3009y) queryLocalInterface : new aa(iBinder);
    }

    /* renamed from: a */
    protected final boolean m14687a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo2595a((DataPoint) ap.a(parcel, DataPoint.CREATOR));
        return true;
    }
}
