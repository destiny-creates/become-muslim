package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p205d.C4952a;
import com.google.android.gms.internal.p205d.C4954c;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

public final class aj extends C4952a implements C2866s {
    aj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    /* renamed from: a */
    public final C2758b mo2465a(C2758b c2758b, C4788y c4788y) {
        Parcel a = a();
        C4954c.a(a, c2758b);
        C4954c.a(a, c4788y);
        c2758b = a(2, a);
        c4788y = C4325a.m14024a(c2758b.readStrongBinder());
        c2758b.recycle();
        return c4788y;
    }
}
