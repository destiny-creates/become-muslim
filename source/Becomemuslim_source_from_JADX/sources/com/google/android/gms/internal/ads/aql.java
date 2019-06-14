package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class aql extends ajm implements aqk {
    public aql() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static aqk asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof aqk ? (aqk) queryLocalInterface : new aqm(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface createBannerAdManager;
        switch (i) {
            case 1:
                createBannerAdManager = createBannerAdManager(C4325a.a(parcel.readStrongBinder()), (aou) ajn.m18501a(parcel, aou.CREATOR), parcel.readString(), bcz.m30474a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 2:
                createBannerAdManager = createInterstitialAdManager(C4325a.a(parcel.readStrongBinder()), (aou) ajn.m18501a(parcel, aou.CREATOR), parcel.readString(), bcz.m30474a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                createBannerAdManager = createAdLoaderBuilder(C4325a.a(parcel.readStrongBinder()), parcel.readString(), bcz.m30474a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 4:
                createBannerAdManager = getMobileAdsSettingsManager(C4325a.a(parcel.readStrongBinder()));
                break;
            case 5:
                createBannerAdManager = createNativeAdViewDelegate(C4325a.a(parcel.readStrongBinder()), C4325a.a(parcel.readStrongBinder()));
                break;
            case 6:
                createBannerAdManager = createRewardedVideoAd(C4325a.a(parcel.readStrongBinder()), bcz.m30474a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 7:
                createBannerAdManager = createInAppPurchaseManager(C4325a.a(parcel.readStrongBinder()));
                break;
            case 8:
                createBannerAdManager = createAdOverlay(C4325a.a(parcel.readStrongBinder()));
                break;
            case 9:
                createBannerAdManager = getMobileAdsSettingsManagerWithClientJarVersion(C4325a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                createBannerAdManager = createSearchAdManager(C4325a.a(parcel.readStrongBinder()), (aou) ajn.m18501a(parcel, aou.CREATOR), parcel.readString(), parcel.readInt());
                break;
            case 11:
                createBannerAdManager = createNativeAdViewHolderDelegate(C4325a.a(parcel.readStrongBinder()), C4325a.a(parcel.readStrongBinder()), C4325a.a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        ajn.m18502a(parcel2, createBannerAdManager);
        return true;
    }
}
