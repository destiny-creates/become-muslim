package versioned.host.exp.exponent.modules.api.fbads;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;

public class BannerView extends ReactViewGroup implements AdListener, LifecycleEventListener {
    private ReactContext mContext;
    private RCTEventEmitter mEventEmitter = ((RCTEventEmitter) this.mContext.getJSModule(RCTEventEmitter.class));
    private String mPlacementId;
    private AdSize mSize;
    private AdView myAdView;

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public BannerView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.mContext = themedReactContext;
        this.mContext.addLifecycleEventListener(this);
    }

    public void setPlacementId(String str) {
        this.mPlacementId = str;
        createAdViewIfCan();
    }

    public void setSize(AdSize adSize) {
        this.mSize = adSize;
        createAdViewIfCan();
    }

    public void onError(Ad ad, AdError adError) {
        ad = Arguments.createMap();
        ad.putInt("errorCode", adError.getErrorCode());
        ad.putString("errorMessage", adError.getErrorMessage());
        this.mEventEmitter.receiveEvent(getId(), "onAdError", ad);
        this.myAdView = null;
    }

    public void onAdLoaded(Ad ad) {
        removeAllViews();
        ad = this.mContext.getResources();
        DisplayMetrics displayMetrics = ad.getDisplayMetrics();
        if (this.mSize.getWidth() > 0) {
            ad = dp2px(this.mSize.getWidth(), displayMetrics);
        } else {
            ad = ad.getDisplayMetrics().widthPixels;
        }
        int dp2px = dp2px(this.mSize.getHeight(), displayMetrics);
        this.myAdView.measure(ad, dp2px);
        this.myAdView.layout(0, 0, ad, dp2px);
        addView(this.myAdView);
    }

    public void onAdClicked(Ad ad) {
        this.mEventEmitter.receiveEvent(getId(), "onAdPress", null);
    }

    public void onLoggingImpression(Ad ad) {
        this.mEventEmitter.receiveEvent(getId(), "onLoggingImpression", null);
    }

    private void createAdViewIfCan() {
        if (this.myAdView == null && this.mPlacementId != null && this.mSize != null) {
            this.myAdView = new AdView(getContext(), this.mPlacementId, this.mSize);
            this.myAdView.setAdListener(this);
            this.myAdView.loadAd();
        }
    }

    private int dp2px(int i, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, (float) i, displayMetrics));
    }

    public void onHostDestroy() {
        if (this.myAdView != null) {
            this.myAdView.destroy();
        }
    }
}
