package com.google.android.gms.internal.p214m;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p190g.p191a.C4820a;

/* renamed from: com.google.android.gms.internal.m.g */
public final class C6826g extends C5054a implements C5057f {
    C6826g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final void J_() {
        m21506b(3, m21504a());
    }

    /* renamed from: a */
    public final C4820a[] mo4770a(C2758b c2758b, C7829k c7829k) {
        Parcel a = m21504a();
        C5055b.m21507a(a, (IInterface) c2758b);
        C5055b.m21508a(a, (Parcelable) c7829k);
        Parcel a2 = m21505a(1, a);
        C4820a[] c4820aArr = (C4820a[]) a2.createTypedArray(C4820a.CREATOR);
        a2.recycle();
        return c4820aArr;
    }

    /* renamed from: b */
    public final C4820a[] mo4771b(C2758b c2758b, C7829k c7829k) {
        Parcel a = m21504a();
        C5055b.m21507a(a, (IInterface) c2758b);
        C5055b.m21508a(a, (Parcelable) c7829k);
        Parcel a2 = m21505a(2, a);
        C4820a[] c4820aArr = (C4820a[]) a2.createTypedArray(C4820a.CREATOR);
        a2.recycle();
        return c4820aArr;
    }
}
