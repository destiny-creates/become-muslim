package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p214m.C5054a;
import com.google.android.gms.internal.p214m.C5055b;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.g.b.a.a.j */
public final class C4424j extends C5054a implements C3046i {
    C4424j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    /* renamed from: a */
    public final C3045g mo2600a(C2758b c2758b, C4823e c4823e) {
        C3045g c3045g;
        Parcel a = a();
        C5055b.a(a, c2758b);
        C5055b.a(a, c4823e);
        Parcel a2 = a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            c3045g = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            c3045g = queryLocalInterface instanceof C3045g ? (C3045g) queryLocalInterface : new C4423h(readStrongBinder);
        }
        a2.recycle();
        return c3045g;
    }
}
