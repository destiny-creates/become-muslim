package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class go extends ajm implements gn {
    public go() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    /* renamed from: a */
    public static gn m30747a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        return queryLocalInterface instanceof gn ? (gn) queryLocalInterface : new gp(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4267a();
                break;
            case 2:
                mo4270b();
                break;
            case 3:
                mo4271c();
                break;
            case 4:
                mo4272d();
                break;
            case 5:
                gc gcVar;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    gcVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    gcVar = queryLocalInterface instanceof gc ? (gc) queryLocalInterface : new ge(readStrongBinder);
                }
                mo4269a(gcVar);
                break;
            case 6:
                mo4273e();
                break;
            case 7:
                mo4268a(parcel.readInt());
                break;
            case 8:
                mo4274f();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
