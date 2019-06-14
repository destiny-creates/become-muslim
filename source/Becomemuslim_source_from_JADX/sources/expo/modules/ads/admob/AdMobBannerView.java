package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2628c.C2625a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C4263e;
import expo.modules.ads.admob.AdMobBannerViewManager.Events;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class AdMobBannerView extends FrameLayout {
    private C5991a mEventEmitter;
    private String mSizeString;
    private String testDeviceID = null;

    /* renamed from: expo.modules.ads.admob.AdMobBannerView$1 */
    class C60481 implements OnLayoutChangeListener {
        C60481() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (i != i5 || i3 != i7 || i2 != i6 || i4 != i8) {
                AdMobBannerView.this.setBannerSize(AdMobBannerView.this.mSizeString);
            }
        }
    }

    public AdMobBannerView(Context context, C5991a c5991a) {
        super(context);
        this.mEventEmitter = c5991a;
        init();
    }

    private void init() {
        attachNewAdView();
        addOnLayoutChangeListener(new C60481());
    }

    protected void attachNewAdView() {
        View c4263e = new C4263e(getContext());
        C4263e c4263e2 = (C4263e) getChildAt(0);
        removeAllViews();
        if (c4263e2 != null) {
            c4263e2.c();
        }
        addView(c4263e, new LayoutParams(-1, -1));
        attachEvents();
    }

    protected void attachEvents() {
        final C4263e c4263e = (C4263e) getChildAt(0);
        c4263e.setAdListener(new C2603a() {
            public void onAdLoaded() {
                int b = c4263e.getAdSize().b(AdMobBannerView.this.getContext());
                int a = c4263e.getAdSize().a(AdMobBannerView.this.getContext());
                int left = c4263e.getLeft();
                int top = c4263e.getTop();
                c4263e.measure(b, a);
                c4263e.layout(left, top, b + left, a + top);
                AdMobBannerView.this.sendEvent(Events.EVENT_RECEIVE_AD);
            }

            public void onAdFailedToLoad(int i) {
                AdMobBannerView.this.sendEvent(Events.EVENT_ERROR, AdMobUtils.createEventForAdFailedToLoad(i));
            }

            public void onAdOpened() {
                AdMobBannerView.this.sendEvent(Events.EVENT_WILL_PRESENT);
            }

            public void onAdClosed() {
                AdMobBannerView.this.sendEvent(Events.EVENT_WILL_DISMISS);
            }

            public void onAdLeftApplication() {
                AdMobBannerView.this.sendEvent(Events.EVENT_WILL_LEAVE_APP);
            }
        });
    }

    public void setBannerSize(String str) {
        this.mSizeString = str;
        str = AdMobUtils.getAdSizeFromString(str);
        String adUnitId = ((C4263e) getChildAt(0)).getAdUnitId();
        attachNewAdView();
        C4263e c4263e = (C4263e) getChildAt(0);
        c4263e.setAdSize(str);
        c4263e.setAdUnitId(adUnitId);
        sendEvent(Events.EVENT_SIZE_CHANGE, AdMobUtils.createEventForSizeChange(getContext(), str));
        loadAd(c4263e);
    }

    public void setAdUnitID(String str) {
        C2631d adSize = ((C4263e) getChildAt(0)).getAdSize();
        attachNewAdView();
        C4263e c4263e = (C4263e) getChildAt(0);
        c4263e.setAdUnitId(str);
        c4263e.setAdSize(adSize);
        loadAd(c4263e);
    }

    public void setPropTestDeviceID(String str) {
        this.testDeviceID = str;
    }

    private void loadAd(C4263e c4263e) {
        if (c4263e.getAdSize() != null && c4263e.getAdUnitId() != null) {
            C2625a c2625a = new C2625a();
            if (this.testDeviceID != null) {
                if (this.testDeviceID.equals("EMULATOR")) {
                    c2625a = c2625a.b("B3EEABB8EE11C2BE770B684D95219ECB");
                } else {
                    c2625a = c2625a.b(this.testDeviceID);
                }
            }
            c4263e.a(c2625a.a());
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
