package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class apo extends ajm implements apn {
    public apo() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo3858a();
                break;
            case 2:
                mo3859a(parcel.readInt());
                break;
            case 3:
                mo3860b();
                break;
            case 4:
                mo3861c();
                break;
            case 5:
                mo3862d();
                break;
            case 6:
                mo3863e();
                break;
            case 7:
                mo3864f();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
