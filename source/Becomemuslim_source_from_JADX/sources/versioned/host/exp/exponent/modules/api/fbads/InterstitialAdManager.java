package versioned.host.exp.exponent.modules.api.fbads;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class InterstitialAdManager extends ReactContextBaseJavaModule implements InterstitialAdListener, LifecycleEventListener {
    private boolean mDidClick = false;
    private InterstitialAd mInterstitial;
    private Promise mPromise;

    public String getName() {
        return "CTKInterstitialAdManager";
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void onInterstitialDisplayed(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public InterstitialAdManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void showAd(String str, Promise promise) {
        if (this.mPromise != null) {
            promise.reject("E_FAILED_TO_SHOW", "Only one `showAd` can be called at once");
            return;
        }
        Context reactApplicationContext = getReactApplicationContext();
        this.mPromise = promise;
        this.mInterstitial = new InterstitialAd(reactApplicationContext, str);
        this.mInterstitial.setAdListener(this);
        this.mInterstitial.loadAd();
    }

    public void onError(Ad ad, AdError adError) {
        this.mPromise.reject("E_FAILED_TO_LOAD", adError.getErrorMessage());
        cleanUp();
    }

    public void onAdLoaded(Ad ad) {
        if (ad == this.mInterstitial) {
            this.mInterstitial.show();
        }
    }

    public void onAdClicked(Ad ad) {
        this.mDidClick = true;
    }

    public void onInterstitialDismissed(Ad ad) {
        this.mPromise.resolve(Boolean.valueOf(this.mDidClick));
        cleanUp();
    }

    private void cleanUp() {
        this.mPromise = null;
        this.mDidClick = false;
        if (this.mInterstitial != null) {
            this.mInterstitial.destroy();
            this.mInterstitial = null;
        }
    }

    public void onHostDestroy() {
        cleanUp();
    }
}
