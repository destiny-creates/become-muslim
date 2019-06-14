package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class gd extends ajm implements gc {
    public gd() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String a = mo4247a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                break;
            case 2:
                i = mo4248b();
                parcel2.writeNoException();
                parcel2.writeInt(i);
                break;
            default:
                return false;
        }
        return true;
    }
}
