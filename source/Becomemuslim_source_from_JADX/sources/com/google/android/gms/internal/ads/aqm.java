package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.p174b.C2758b;

public final class aqm extends ajl implements aqk {
    aqm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final apt createAdLoaderBuilder(C2758b c2758b, String str, bcy bcy, int i) {
        apt apt;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(i);
        Parcel a = m18499a(3, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apt = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            apt = queryLocalInterface instanceof apt ? (apt) queryLocalInterface : new apv(readStrongBinder);
        }
        a.recycle();
        return apt;
    }

    public final C4936r createAdOverlay(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(8, x_);
        C4936r a2 = C6767s.m31047a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final apy createBannerAdManager(C2758b c2758b, aou aou, String str, bcy bcy, int i) {
        apy apy;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(i);
        Parcel a = m18499a(1, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            apy = queryLocalInterface instanceof apy ? (apy) queryLocalInterface : new aqa(readStrongBinder);
        }
        a.recycle();
        return apy;
    }

    public final ab createInAppPurchaseManager(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(7, x_);
        ab a2 = ad.m29766a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final apy createInterstitialAdManager(C2758b c2758b, aou aou, String str, bcy bcy, int i) {
        apy apy;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(i);
        Parcel a = m18499a(2, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            apy = queryLocalInterface instanceof apy ? (apy) queryLocalInterface : new aqa(readStrongBinder);
        }
        a.recycle();
        return apy;
    }

    public final avi createNativeAdViewDelegate(C2758b c2758b, C2758b c2758b2) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        Parcel a = m18499a(5, x_);
        avi a2 = avj.m30258a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final avn createNativeAdViewHolderDelegate(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) c2758b2);
        ajn.m18502a(x_, (IInterface) c2758b3);
        Parcel a = m18499a(11, x_);
        avn a2 = avo.m30266a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final gh createRewardedVideoAd(C2758b c2758b, bcy bcy, int i) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(i);
        Parcel a = m18499a(6, x_);
        gh a2 = gj.m30729a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final apy createSearchAdManager(C2758b c2758b, aou aou, String str, int i) {
        apy apy;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        x_.writeString(str);
        x_.writeInt(i);
        Parcel a = m18499a(10, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            apy = queryLocalInterface instanceof apy ? (apy) queryLocalInterface : new aqa(readStrongBinder);
        }
        a.recycle();
        return apy;
    }

    public final aqq getMobileAdsSettingsManager(C2758b c2758b) {
        aqq aqq;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(4, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            aqq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            aqq = queryLocalInterface instanceof aqq ? (aqq) queryLocalInterface : new aqs(readStrongBinder);
        }
        a.recycle();
        return aqq;
    }

    public final aqq getMobileAdsSettingsManagerWithClientJarVersion(C2758b c2758b, int i) {
        aqq aqq;
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        x_.writeInt(i);
        Parcel a = m18499a(9, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            aqq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            aqq = queryLocalInterface instanceof aqq ? (aqq) queryLocalInterface : new aqs(readStrongBinder);
        }
        a.recycle();
        return aqq;
    }
}
