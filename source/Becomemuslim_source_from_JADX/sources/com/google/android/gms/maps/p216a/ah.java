package com.google.android.gms.maps.p216a;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.maps.a.ah */
public abstract class ah extends C5025j implements ag {
    public ah() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6248a((Bitmap) C5026k.m21175a(parcel, Bitmap.CREATOR));
                break;
            case 2:
                mo6249a(C4325a.a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
