package com.google.android.gms.internal.p214m;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.internal.m.i */
public final class C6827i extends C5054a implements C5058h {
    C6827i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    /* renamed from: a */
    public final C5057f mo4772a(C2758b c2758b, C7828c c7828c) {
        C5057f c5057f;
        Parcel a = m21504a();
        C5055b.m21507a(a, (IInterface) c2758b);
        C5055b.m21508a(a, (Parcelable) c7828c);
        Parcel a2 = m21505a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            c5057f = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            c5057f = queryLocalInterface instanceof C5057f ? (C5057f) queryLocalInterface : new C6826g(readStrongBinder);
        }
        a2.recycle();
        return c5057f;
    }
}
