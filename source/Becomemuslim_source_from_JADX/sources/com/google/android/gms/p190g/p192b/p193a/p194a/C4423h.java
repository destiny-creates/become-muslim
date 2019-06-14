package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p214m.C5054a;
import com.google.android.gms.internal.p214m.C5055b;
import com.google.android.gms.internal.p214m.C7829k;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.g.b.a.a.h */
public final class C4423h extends C5054a implements C3045g {
    C4423h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final void K_() {
        b(3, a());
    }

    /* renamed from: a */
    public final C4821a[] mo2599a(C2758b c2758b, C7829k c7829k) {
        Parcel a = a();
        C5055b.a(a, c2758b);
        C5055b.a(a, c7829k);
        Parcel a2 = a(1, a);
        C4821a[] c4821aArr = (C4821a[]) a2.createTypedArray(C4821a.CREATOR);
        a2.recycle();
        return c4821aArr;
    }
}
