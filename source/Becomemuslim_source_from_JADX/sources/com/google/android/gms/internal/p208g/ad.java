package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.p188b.C4799a;

/* renamed from: com.google.android.gms.internal.g.ad */
public abstract class ad extends C4976z implements ac {
    public ad() {
        super("com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    /* renamed from: a */
    public static ac m31269a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
        return queryLocalInterface instanceof ac ? (ac) queryLocalInterface : new ae(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4398a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4399a((C4799a) ap.m20255a(parcel, C4799a.CREATOR));
        return true;
    }
}
