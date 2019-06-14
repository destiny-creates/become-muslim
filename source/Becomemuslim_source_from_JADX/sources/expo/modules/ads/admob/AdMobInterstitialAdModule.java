package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2628c.C2625a;
import com.google.android.gms.ads.C2634h;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;

public class AdMobInterstitialAdModule extends C6006c implements C6001h {
    private String mAdUnitID;
    private C5991a mEventEmitter;
    private C2634h mInterstitialAd;
    private C6009f mRequestAdPromise;
    private C6009f mShowAdPromise;
    private String mTestDeviceID;

    /* renamed from: expo.modules.ads.admob.AdMobInterstitialAdModule$5 */
    class C60535 implements Runnable {

        /* renamed from: expo.modules.ads.admob.AdMobInterstitialAdModule$5$1 */
        class C73921 extends C2603a {
            C73921() {
            }

            public void onAdClosed() {
                AdMobInterstitialAdModule.this.sendEvent(Events.DID_CLOSE.toString(), new Bundle());
            }

            public void onAdFailedToLoad(int i) {
                AdMobInterstitialAdModule.this.sendEvent(Events.DID_FAIL_TO_LOAD.toString(), AdMobUtils.createEventForAdFailedToLoad(i));
                if (AdMobInterstitialAdModule.this.mRequestAdPromise != null) {
                    AdMobInterstitialAdModule.this.mRequestAdPromise.mo5138a("E_AD_REQUEST_FAILED", AdMobUtils.errorStringForAdFailedCode(i), null);
                    AdMobInterstitialAdModule.this.mRequestAdPromise = null;
                }
            }

            public void onAdLeftApplication() {
                AdMobInterstitialAdModule.this.sendEvent(Events.WILL_LEAVE_APPLICATION.toString(), new Bundle());
            }

            public void onAdLoaded() {
                AdMobInterstitialAdModule.this.sendEvent(Events.DID_LOAD.toString(), new Bundle());
                if (AdMobInterstitialAdModule.this.mRequestAdPromise != null) {
                    AdMobInterstitialAdModule.this.mRequestAdPromise.mo5137a(null);
                    AdMobInterstitialAdModule.this.mRequestAdPromise = null;
                }
            }

            public void onAdOpened() {
                AdMobInterstitialAdModule.this.sendEvent(Events.DID_OPEN.toString(), new Bundle());
                if (AdMobInterstitialAdModule.this.mShowAdPromise != null) {
                    AdMobInterstitialAdModule.this.mShowAdPromise.mo5137a(null);
                    AdMobInterstitialAdModule.this.mShowAdPromise = null;
                }
            }
        }

        C60535() {
        }

        public void run() {
            AdMobInterstitialAdModule.this.mInterstitialAd.a(new C73921());
        }
    }

    public enum Events {
        DID_LOAD("interstitialDidLoad"),
        DID_FAIL_TO_LOAD("interstitialDidFailToLoad"),
        DID_OPEN("interstitialDidOpen"),
        DID_CLOSE("interstitialDidClose"),
        WILL_LEAVE_APPLICATION("interstitialWillLeaveApplication");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public String getName() {
        return "ExpoAdsAdMobInterstitialManager";
    }

    public AdMobInterstitialAdModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
    }

    private void sendEvent(String str, Bundle bundle) {
        this.mEventEmitter.mo5142a(str, bundle);
    }

    @C5996c
    public void setAdUnitID(String str, C6009f c6009f) {
        this.mAdUnitID = str;
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void setTestDeviceID(String str, C6009f c6009f) {
        this.mTestDeviceID = str;
        c6009f.mo5137a((Object) null);
    }

    @C5996c
    public void requestAd(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AdMobInterstitialAdModule.this.recreateInterstitialAdWithAdUnitID(AdMobInterstitialAdModule.this.mAdUnitID);
                if (!AdMobInterstitialAdModule.this.mInterstitialAd.a()) {
                    if (!AdMobInterstitialAdModule.this.mInterstitialAd.b()) {
                        AdMobInterstitialAdModule.this.mRequestAdPromise = c6009f;
                        C2625a c2625a = new C2625a();
                        if (AdMobInterstitialAdModule.this.mTestDeviceID != null) {
                            if (AdMobInterstitialAdModule.this.mTestDeviceID.equals("EMULATOR")) {
                                c2625a = c2625a.b("B3EEABB8EE11C2BE770B684D95219ECB");
                            } else {
                                c2625a = c2625a.b(AdMobInterstitialAdModule.this.mTestDeviceID);
                            }
                        }
                        AdMobInterstitialAdModule.this.mInterstitialAd.a(c2625a.a());
                        return;
                    }
                }
                c6009f.mo5138a("E_AD_ALREADY_LOADED", "Ad is already loaded.", null);
            }
        });
    }

    @C5996c
    public void showAd(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (AdMobInterstitialAdModule.this.mInterstitialAd == null || !AdMobInterstitialAdModule.this.mInterstitialAd.a()) {
                    c6009f.mo5138a("E_AD_NOT_READY", "Ad is not ready", null);
                    return;
                }
                AdMobInterstitialAdModule.this.mShowAdPromise = c6009f;
                AdMobInterstitialAdModule.this.mInterstitialAd.c();
            }
        });
    }

    @C5996c
    public void dismissAd(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (AdMobInterstitialAdModule.this.mInterstitialAd == null || !AdMobInterstitialAdModule.this.mInterstitialAd.a()) {
                    c6009f.mo5138a("E_AD_NOT_READY", "Ad is not ready", null);
                    return;
                }
                AdMobInterstitialAdModule.this.mShowAdPromise = c6009f;
                AdMobInterstitialAdModule.this.recreateInterstitialAdWithAdUnitID(AdMobInterstitialAdModule.this.mAdUnitID);
            }
        });
    }

    @C5996c
    public void getIsReady(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                C6009f c6009f = c6009f;
                boolean z = AdMobInterstitialAdModule.this.mInterstitialAd != null && AdMobInterstitialAdModule.this.mInterstitialAd.a();
                c6009f.mo5137a(Boolean.valueOf(z));
            }
        });
    }

    private void recreateInterstitialAdWithAdUnitID(String str) {
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        this.mInterstitialAd = new C2634h(getContext());
        this.mInterstitialAd.a(str);
        new Handler(Looper.getMainLooper()).post(new C60535());
    }
}
