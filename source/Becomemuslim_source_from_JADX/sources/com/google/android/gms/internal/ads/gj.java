package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class gj extends ajm implements gh {
    public gj() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* renamed from: a */
    public static gh m30729a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof gh ? (gh) queryLocalInterface : new gk(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 34) {
            gn gnVar = null;
            IBinder readStrongBinder;
            IInterface queryLocalInterface;
            switch (i) {
                case 1:
                    mo4255a((gt) ajn.m18501a(parcel, gt.CREATOR));
                    break;
                case 2:
                    mo4250a();
                    break;
                case 3:
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                        gnVar = queryLocalInterface instanceof gn ? (gn) queryLocalInterface : new gp(readStrongBinder);
                    }
                    mo4254a(gnVar);
                    break;
                default:
                    switch (i) {
                        case 5:
                            boolean c = mo4261c();
                            parcel2.writeNoException();
                            ajn.m18504a(parcel2, c);
                            break;
                        case 6:
                            mo4262d();
                            break;
                        case 7:
                            mo4263e();
                            break;
                        case 8:
                            mo4264f();
                            break;
                        case 9:
                            mo4251a(C4325a.a(parcel.readStrongBinder()));
                            break;
                        case 10:
                            mo4259b(C4325a.a(parcel.readStrongBinder()));
                            break;
                        case 11:
                            mo4260c(C4325a.a(parcel.readStrongBinder()));
                            break;
                        case 12:
                            String g = mo4265g();
                            parcel2.writeNoException();
                            parcel2.writeString(g);
                            break;
                        case 13:
                            mo4256a(parcel.readString());
                            break;
                        case 14:
                            mo4252a(aqe.m30132a(parcel.readStrongBinder()));
                            break;
                        case 15:
                            Parcelable b = mo4258b();
                            parcel2.writeNoException();
                            ajn.m18507b(parcel2, b);
                            break;
                        case 16:
                            gf ggVar;
                            readStrongBinder = parcel.readStrongBinder();
                            if (readStrongBinder != null) {
                                queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                                ggVar = queryLocalInterface instanceof gf ? (gf) queryLocalInterface : new gg(readStrongBinder);
                            }
                            mo4253a(ggVar);
                            break;
                        default:
                            return false;
                    }
            }
        }
        mo4257a(ajn.m18505a(parcel));
        parcel2.writeNoException();
        return true;
    }
}
