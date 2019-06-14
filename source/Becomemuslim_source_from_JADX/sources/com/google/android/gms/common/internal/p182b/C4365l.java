package com.google.android.gms.common.internal.p182b;

import android.os.Parcel;
import com.google.android.gms.internal.p205d.C4953b;

/* renamed from: com.google.android.gms.common.internal.b.l */
public abstract class C4365l extends C4953b implements C2840k {
    public C4365l() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    /* renamed from: a */
    protected boolean m14374a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo3290a(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
