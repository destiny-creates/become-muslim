package com.google.android.gms.p175c.p176a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.C2862o;
import com.google.android.gms.internal.p205d.C4952a;
import com.google.android.gms.internal.p205d.C4954c;

/* renamed from: com.google.android.gms.c.a.h */
public final class C4331h extends C4952a implements C2767g {
    C4331h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    /* renamed from: a */
    public final void mo2372a(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(7, a);
    }

    /* renamed from: a */
    public final void mo2374a(C2862o c2862o, int i, boolean z) {
        Parcel a = a();
        C4954c.a(a, c2862o);
        a.writeInt(i);
        C4954c.a(a, z);
        b(9, a);
    }

    /* renamed from: a */
    public final void mo2373a(C4760i c4760i, C2766e c2766e) {
        Parcel a = a();
        C4954c.a(a, c4760i);
        C4954c.a(a, c2766e);
        b(12, a);
    }
}
