package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.C2628c.C2625a;
import com.google.android.gms.ads.C2635i;
import com.google.android.gms.ads.reward.C2697a;
import com.google.android.gms.ads.reward.C2698b;
import com.google.android.gms.ads.reward.C2699c;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;

public class AdMobRewardedVideoAdModule extends C6006c implements C2699c, C6001h {
    private C5995b mActivityProvider;
    private String mAdUnitID;
    private C5991a mEventEmitter;
    private C6009f mRequestAdPromise;
    private C2698b mRewardedVideoAd;
    private C6009f mShowAdPromise;
    private String mTestDeviceID;

    public enum Events {
        DID_REWARD("rewardedVideoDidRewardUser"),
        DID_LOAD("rewardedVideoDidLoad"),
        DID_FAIL_TO_LOAD("rewardedVideoDidFailToLoad"),
        DID_OPEN("rewardedVideoDidOpen"),
        DID_START("rewardedVideoDidStart"),
        DID_COMPLETE("rewardedVideoDidComplete"),
        DID_CLOSE("rewardedVideoDidClose"),
        WILL_LEAVE_APPLICATION("rewardedVideoWillLeaveApplication");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public String getName() {
        return "ExpoAdsAdMobRewardedVideoAdManager";
    }

    public AdMobRewardedVideoAdModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
        this.mActivityProvider = (C5995b) c6007d.m25133a(C5995b.class);
    }

    public void onRewarded(C2697a c2697a) {
        Bundle bundle = new Bundle();
        bundle.putInt("amount", c2697a.b());
        bundle.putString("type", c2697a.a());
        sendEvent(Events.DID_REWARD.toString(), bundle);
    }

    public void onRewardedVideoAdLoaded() {
        sendEvent(Events.DID_LOAD.toString(), new Bundle());
        this.mRequestAdPromise.mo5137a(null);
    }

    public void onRewardedVideoAdOpened() {
        sendEvent(Events.DID_OPEN.toString(), new Bundle());
    }

    public void onRewardedVideoStarted() {
        sendEvent(Events.DID_START.toString(), new Bundle());
    }

    public void onRewardedVideoAdClosed() {
        sendEvent(Events.DID_CLOSE.toString(), new Bundle());
    }

    public void onRewardedVideoAdLeftApplication() {
        sendEvent(Events.WILL_LEAVE_APPLICATION.toString(), new Bundle());
    }

    public void onRewardedVideoCompleted() {
        sendEvent(Events.DID_COMPLETE.toString(), new Bundle());
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        sendEvent(Events.DID_FAIL_TO_LOAD.toString(), AdMobUtils.createEventForAdFailedToLoad(i));
        this.mRequestAdPromise.mo5138a("E_AD_REQUEST_FAILED", AdMobUtils.errorStringForAdFailedCode(i), null);
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
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd = C2635i.a(AdMobRewardedVideoAdModule.this.mActivityProvider.getCurrentActivity());
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.a(AdMobRewardedVideoAdModule.this);
                if (AdMobRewardedVideoAdModule.this.mRewardedVideoAd.a()) {
                    c6009f.mo5138a("E_AD_ALREADY_LOADED", "Ad is already loaded.", null);
                    return;
                }
                AdMobRewardedVideoAdModule.this.mRequestAdPromise = c6009f;
                C2625a c2625a = new C2625a();
                if (AdMobRewardedVideoAdModule.this.mTestDeviceID != null) {
                    if (AdMobRewardedVideoAdModule.this.mTestDeviceID.equals("EMULATOR")) {
                        c2625a = c2625a.b("B3EEABB8EE11C2BE770B684D95219ECB");
                    } else {
                        c2625a = c2625a.b(AdMobRewardedVideoAdModule.this.mTestDeviceID);
                    }
                }
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.a(AdMobRewardedVideoAdModule.this.mAdUnitID, c2625a.a());
            }
        });
    }

    @C5996c
    public void showAd(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (AdMobRewardedVideoAdModule.this.mRewardedVideoAd == null || !AdMobRewardedVideoAdModule.this.mRewardedVideoAd.a()) {
                    c6009f.mo5138a("E_AD_NOT_READY", "Ad is not ready.", null);
                    return;
                }
                AdMobRewardedVideoAdModule.this.mShowAdPromise = c6009f;
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.b();
            }
        });
    }

    @C5996c
    public void getIsReady(final C6009f c6009f) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                C6009f c6009f = c6009f;
                boolean z = AdMobRewardedVideoAdModule.this.mRewardedVideoAd != null && AdMobRewardedVideoAdModule.this.mRewardedVideoAd.a();
                c6009f.mo5137a(Boolean.valueOf(z));
            }
        });
    }
}
