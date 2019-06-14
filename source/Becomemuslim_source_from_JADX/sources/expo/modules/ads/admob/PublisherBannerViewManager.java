package expo.modules.ads.admob;

import android.content.Context;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.C6012g.C6011b;
import expo.p304a.p305a.C5997d;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import java.util.ArrayList;
import java.util.List;

public class PublisherBannerViewManager extends C6012g<PublisherBannerView> implements C6001h {
    public static final String PROP_AD_UNIT_ID = "adUnitID";
    public static final String PROP_BANNER_SIZE = "bannerSize";
    public static final String PROP_TEST_DEVICE_ID = "testDeviceID";
    private C5991a mEventEmitter;

    public enum Events {
        EVENT_SIZE_CHANGE("onSizeChange"),
        EVENT_RECEIVE_AD("onAdViewDidReceiveAd"),
        EVENT_ERROR("onDidFailToReceiveAdWithError"),
        EVENT_WILL_PRESENT("onAdViewWillPresentScreen"),
        EVENT_WILL_DISMISS("onAdViewWillDismissScreen"),
        EVENT_DID_DISMISS("onAdViewDidDismissScreen"),
        EVENT_WILL_LEAVE_APP("onAdViewWillLeaveApplication"),
        EVENT_ADMOB_EVENT_RECEIVED("onAdmobDispatchAppEvent");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public String getName() {
        return "ExpoAdsPublisherBannerView";
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
    }

    public PublisherBannerView createViewInstance(Context context) {
        return new PublisherBannerView(context, this.mEventEmitter);
    }

    public C6011b getViewManagerType() {
        return C6011b.GROUP;
    }

    public List<String> getExportedEventNames() {
        List<String> arrayList = new ArrayList(expo.modules.ads.admob.AdMobBannerViewManager.Events.values().length);
        for (expo.modules.ads.admob.AdMobBannerViewManager.Events events : expo.modules.ads.admob.AdMobBannerViewManager.Events.values()) {
            arrayList.add(events.toString());
        }
        return arrayList;
    }

    @C5997d(a = "bannerSize")
    public void setBannerSize(PublisherBannerView publisherBannerView, String str) {
        publisherBannerView.setBannerSize(str);
    }

    @C5997d(a = "adUnitID")
    public void setAdUnitID(PublisherBannerView publisherBannerView, String str) {
        publisherBannerView.setAdUnitID(str);
    }

    @C5997d(a = "testDeviceID")
    public void setPropTestDeviceID(PublisherBannerView publisherBannerView, String str) {
        publisherBannerView.setPropTestDeviceID(str);
    }
}
