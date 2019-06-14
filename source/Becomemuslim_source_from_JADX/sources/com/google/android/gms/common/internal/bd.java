package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.C4790y;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4960c;
import com.google.android.gms.p174b.C2758b;

public final class bd extends C4958a implements bb {
    bd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    /* renamed from: a */
    public final boolean mo2476a(C4790y c4790y, C2758b c2758b) {
        Parcel c = c();
        C4960c.a(c, c4790y);
        C4960c.a(c, c2758b);
        c4790y = a(5, c);
        c2758b = C4960c.a(c4790y);
        c4790y.recycle();
        return c2758b;
    }
}
