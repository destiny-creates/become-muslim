package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4960c;

public final class ba extends C4958a implements C2864q {
    ba(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* renamed from: a */
    public final void mo2474a(int i, IBinder iBinder, Bundle bundle) {
        Parcel c = c();
        c.writeInt(i);
        c.writeStrongBinder(iBinder);
        C4960c.a(c, bundle);
        b(1, c);
    }

    /* renamed from: a */
    public final void mo2473a(int i, Bundle bundle) {
        Parcel c = c();
        c.writeInt(i);
        C4960c.a(c, bundle);
        b(2, c);
    }

    /* renamed from: a */
    public final void mo2475a(int i, IBinder iBinder, aq aqVar) {
        Parcel c = c();
        c.writeInt(i);
        c.writeStrongBinder(iBinder);
        C4960c.a(c, aqVar);
        b(3, c);
    }
}
