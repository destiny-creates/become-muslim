package versioned.host.exp.exponent.modules.api.fbads;

import android.view.View;
import com.facebook.ads.AdIconView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import java.lang.ref.WeakReference;
import java.util.List;

public class NativeAdView extends ReactViewGroup {
    private RCTEventEmitter mEventEmitter;
    private WeakReference<MediaView> mMediaView;
    private NativeAd mNativeAd;

    public NativeAdView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.mEventEmitter = (RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class);
    }

    public void setNativeAd(NativeAd nativeAd) {
        if (this.mNativeAd != null) {
            this.mNativeAd.unregisterView();
        }
        this.mNativeAd = nativeAd;
        if (nativeAd == null) {
            this.mEventEmitter.receiveEvent(getId(), "onAdLoaded", null);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("headline", nativeAd.getAdHeadline());
        createMap.putString("linkDescription", nativeAd.getAdLinkDescription());
        createMap.putString("advertiserName", nativeAd.getAdvertiserName());
        createMap.putString("socialContext", nativeAd.getAdSocialContext());
        createMap.putString("callToActionText", nativeAd.getAdCallToAction());
        createMap.putString("bodyText", nativeAd.getAdBodyText());
        createMap.putString("translation", nativeAd.getAdTranslation());
        createMap.putString("adTranslation", nativeAd.getAdTranslation());
        createMap.putString("promotedTranslation", nativeAd.getPromotedTranslation());
        createMap.putString("sponsoredTranslation", nativeAd.getSponsoredTranslation());
        this.mEventEmitter.receiveEvent(getId(), "onAdLoaded", createMap);
    }

    public void registerViewsForInteraction(MediaView mediaView, AdIconView adIconView, List<View> list) {
        list.add(mediaView);
        this.mNativeAd.registerViewForInteraction(this, mediaView, adIconView, list);
        this.mMediaView = new WeakReference(mediaView);
    }

    public void triggerClick() {
        MediaView mediaView = (MediaView) this.mMediaView.get();
        if (mediaView != null) {
            mediaView.performClick();
        }
    }
}
