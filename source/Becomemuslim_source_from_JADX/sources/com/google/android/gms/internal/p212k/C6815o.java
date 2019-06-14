package com.google.android.gms.internal.p212k;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.internal.k.o */
public final class C6815o extends C5022a implements C5028m {
    C6815o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    public final C2758b A_() {
        Parcel a = m21121a(4, D_());
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4708a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        Parcel a = m21121a(5, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4709a(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        Parcel a = m21121a(1, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C2758b mo4710a(Bitmap bitmap) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) bitmap);
        Parcel a = m21121a(6, D_);
        C2758b a2 = C4325a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
