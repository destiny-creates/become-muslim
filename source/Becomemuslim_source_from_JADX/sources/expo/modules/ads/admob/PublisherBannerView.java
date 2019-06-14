package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.p167a.C2595a;
import com.google.android.gms.ads.p167a.C2599d.C2598a;
import com.google.android.gms.ads.p167a.C2600e;
import expo.modules.ads.admob.PublisherBannerViewManager.Events;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class PublisherBannerView extends FrameLayout implements C2595a {
    private C5991a mEventEmitter;
    private String testDeviceID = null;

    public PublisherBannerView(Context context, C5991a c5991a) {
        super(context);
        this.mEventEmitter = c5991a;
        attachNewAdView();
    }

    public void onAppEvent(String str, String str2) {
        Log.d("PublisherAdBanner", String.format("Received app event (%s, %s)", new Object[]{str, str2}));
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        sendEvent(Events.EVENT_ADMOB_EVENT_RECEIVED, bundle);
    }

    protected void attachNewAdView() {
        View c2600e = new C2600e(getContext());
        c2600e.setAppEventListener(this);
        C2600e c2600e2 = (C2600e) getChildAt(0);
        removeAllViews();
        if (c2600e2 != null) {
            c2600e2.a();
        }
        addView(c2600e, new LayoutParams(-1, -1));
        attachEvents();
    }

    protected void attachEvents() {
        final C2600e c2600e = (C2600e) getChildAt(0);
        c2600e.setAdListener(new C2603a() {
            public void onAdLoaded() {
                int b = c2600e.getAdSize().b(PublisherBannerView.this.getContext());
                int a = c2600e.getAdSize().a(PublisherBannerView.this.getContext());
                int left = c2600e.getLeft();
                int top = c2600e.getTop();
                c2600e.measure(b, a);
                c2600e.layout(left, top, b + left, a + top);
                PublisherBannerView.this.sendEvent(Events.EVENT_RECEIVE_AD);
            }

            public void onAdFailedToLoad(int i) {
                PublisherBannerView.this.sendEvent(Events.EVENT_ERROR, AdMobUtils.createEventForAdFailedToLoad(i));
            }

            public void onAdOpened() {
                PublisherBannerView.this.sendEvent(Events.EVENT_WILL_PRESENT);
            }

            public void onAdClosed() {
                PublisherBannerView.this.sendEvent(Events.EVENT_WILL_DISMISS);
            }

            public void onAdLeftApplication() {
                PublisherBannerView.this.sendEvent(Events.EVENT_WILL_LEAVE_APP);
            }
        });
    }

    public void setBannerSize(String str) {
        C2631d[] c2631dArr = new C2631d[]{AdMobUtils.getAdSizeFromString(str)};
        String adUnitId = ((C2600e) getChildAt(0)).getAdUnitId();
        attachNewAdView();
        C2600e c2600e = (C2600e) getChildAt(0);
        c2600e.setAdSizes(c2631dArr);
        c2600e.setAdUnitId(adUnitId);
        sendEvent(Events.EVENT_SIZE_CHANGE, AdMobUtils.createEventForSizeChange(getContext(), str));
        loadAd(c2600e);
    }

    public void setAdUnitID(String str) {
        C2631d[] adSizes = ((C2600e) getChildAt(0)).getAdSizes();
        attachNewAdView();
        C2600e c2600e = (C2600e) getChildAt(0);
        c2600e.setAdUnitId(str);
        c2600e.setAdSizes(adSizes);
        loadAd(c2600e);
    }

    public void setPropTestDeviceID(String str) {
        this.testDeviceID = str;
    }

    private void loadAd(C2600e c2600e) {
        if (c2600e.getAdSizes() != null && c2600e.getAdUnitId() != null) {
            C2598a c2598a = new C2598a();
            if (this.testDeviceID != null) {
                if (this.testDeviceID.equals("EMULATOR")) {
                    c2598a = c2598a.a("B3EEABB8EE11C2BE770B684D95219ECB");
                } else {
                    c2598a = c2598a.a(this.testDeviceID);
                }
            }
            c2600e.a(c2598a.a());
        }
    }

    private void sendEvent(Events events) {
        sendEvent(events, new Bundle());
    }

    private void sendEvent(final Events events, final Bundle bundle) {
        this.mEventEmitter.mo5141a(getId(), new C7368a() {
            public String getEventName() {
                return events.toString();
            }

            public Bundle getEventBody() {
                return bundle;
            }
        });
    }
}
