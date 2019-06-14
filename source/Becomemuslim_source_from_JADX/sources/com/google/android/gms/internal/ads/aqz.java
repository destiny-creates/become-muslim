package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class aqz extends ajm implements aqy {
    public aqz() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo3949a();
                break;
            case 2:
                mo3951b();
                break;
            case 3:
                mo3952c();
                break;
            case 4:
                mo3953d();
                break;
            case 5:
                mo3950a(ajn.m18505a(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
