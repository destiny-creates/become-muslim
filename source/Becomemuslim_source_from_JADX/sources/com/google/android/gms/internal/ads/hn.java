package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class hn extends ajm implements hm {
    public hn() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    /* renamed from: a */
    public static hm m30767a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof hm ? (hm) queryLocalInterface : new ho(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4277a(C4325a.a(parcel.readStrongBinder()));
                break;
            case 2:
                mo4278a(C4325a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                mo4280b(C4325a.a(parcel.readStrongBinder()));
                break;
            case 4:
                mo4282c(C4325a.a(parcel.readStrongBinder()));
                break;
            case 5:
                mo4283d(C4325a.a(parcel.readStrongBinder()));
                break;
            case 6:
                mo4284e(C4325a.a(parcel.readStrongBinder()));
                break;
            case 7:
                mo4279a(C4325a.a(parcel.readStrongBinder()), (hq) ajn.m18501a(parcel, hq.CREATOR));
                break;
            case 8:
                mo4285f(C4325a.a(parcel.readStrongBinder()));
                break;
            case 9:
                mo4281b(C4325a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                mo4286g(C4325a.a(parcel.readStrongBinder()));
                break;
            case 11:
                mo4287h(C4325a.a(parcel.readStrongBinder()));
                break;
            case 12:
                mo4276a((Bundle) ajn.m18501a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
