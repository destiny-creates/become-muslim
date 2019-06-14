package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class aqr extends ajm implements aqq {
    public aqr() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo3929a();
                break;
            case 2:
                mo3930a(parcel.readFloat());
                break;
            case 3:
                mo3932a(parcel.readString());
                break;
            case 4:
                mo3934a(ajn.m18505a(parcel));
                break;
            case 5:
                mo3931a(C4325a.a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 6:
                mo3933a(parcel.readString(), C4325a.a(parcel.readStrongBinder()));
                break;
            case 7:
                float b = mo3935b();
                parcel2.writeNoException();
                parcel2.writeFloat(b);
                break;
            case 8:
                boolean c = mo3936c();
                parcel2.writeNoException();
                ajn.m18504a(parcel2, c);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
