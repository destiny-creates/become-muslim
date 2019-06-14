package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p099n.C1422e;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1425f.C1424c;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C3591i;
import com.facebook.ads.internal.p105q.p106a.C1507j;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.view.hscroll.C4895b;
import org.json.JSONObject;

public abstract class NativeAdBase implements Ad {
    /* renamed from: a */
    private final C1425f f9401a;

    public static class Image {
        /* renamed from: a */
        private final C1427h f3691a;

        Image(C1427h c1427h) {
            this.f3691a = c1427h;
        }

        public Image(String str, int i, int i2) {
            this.f3691a = new C1427h(str, i, i2);
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            C1427h a = C1427h.m5021a(jSONObject);
            return a == null ? null : new Image(a);
        }

        public int getHeight() {
            return this.f3691a.m5024c();
        }

        public int getWidth() {
            return this.f3691a.m5023b();
        }
    }

    public enum MediaCacheFlag {
        NONE(C1422e.NONE),
        ALL(C1422e.ALL);
        
        /* renamed from: a */
        private final C1422e f3693a;

        private MediaCacheFlag(C1422e c1422e) {
            this.f3693a = c1422e;
        }

        /* renamed from: a */
        C1422e m4415a() {
            return this.f3693a;
        }

        public long getCacheFlagValue() {
            return this.f3693a.m4935a();
        }
    }

    public enum NativeComponentTag {
        AD_ICON(C1507j.INTERNAL_AD_ICON),
        AD_TITLE(C1507j.INTERNAL_AD_TITLE),
        AD_COVER_IMAGE(C1507j.INTERNAL_AD_COVER_IMAGE),
        AD_SUBTITLE(C1507j.INTERNAL_AD_SUBTITLE),
        AD_BODY(C1507j.INTERNAL_AD_BODY),
        AD_CALL_TO_ACTION(C1507j.INTERNAL_AD_CALL_TO_ACTION),
        AD_SOCIAL_CONTEXT(C1507j.INTERNAL_AD_SOCIAL_CONTEXT),
        AD_CHOICES_ICON(C1507j.INTERNAL_AD_CHOICES_ICON),
        AD_MEDIA(C1507j.INTERNAL_AD_MEDIA);
        
        /* renamed from: a */
        private final C1507j f3695a;

        private NativeComponentTag(C1507j c1507j) {
            this.f3695a = c1507j;
        }

        public static void tagView(View view, NativeComponentTag nativeComponentTag) {
            if (view != null && nativeComponentTag != null) {
                C1507j.m5304a(view, nativeComponentTag.f3695a);
            }
        }
    }

    public static class Rating {
        /* renamed from: a */
        private final C1428j f3696a;

        public Rating(double d, double d2) {
            this.f3696a = new C1428j(d, d2);
        }

        Rating(C1428j c1428j) {
            this.f3696a = c1428j;
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            C1428j a = C1428j.m5025a(jSONObject);
            return a == null ? null : new Rating(a);
        }

        public double getScale() {
            return this.f3696a.m5027b();
        }

        public double getValue() {
            return this.f3696a.m5026a();
        }
    }

    /* renamed from: com.facebook.ads.NativeAdBase$1 */
    static class C35311 implements C1424c {
        C35311() {
        }

        /* renamed from: a */
        public boolean mo878a(View view) {
            if (!((view instanceof MediaViewVideoRenderer) || (view instanceof AdChoicesView))) {
                if (!(view instanceof C4895b)) {
                    return false;
                }
            }
            return true;
        }
    }

    public NativeAdBase(Context context, C3572y c3572y, C1389d c1389d) {
        this.f9401a = new C1425f(context, c3572y, c1389d, getViewTraversalPredicate());
    }

    public NativeAdBase(Context context, String str) {
        this.f9401a = new C1425f(context, str, getViewTraversalPredicate());
    }

    NativeAdBase(NativeAdBase nativeAdBase) {
        this.f9401a = new C1425f(nativeAdBase.f9401a);
    }

    NativeAdBase(C1425f c1425f) {
        this.f9401a = c1425f;
    }

    public static C1424c getViewTraversalPredicate() {
        return new C35311();
    }

    /* renamed from: a */
    void m11391a(AdIconView adIconView) {
        if (adIconView != null) {
            this.f9401a.m4998d(true);
        }
    }

    /* renamed from: a */
    void m11392a(MediaView mediaView) {
        if (mediaView != null) {
            this.f9401a.m4995c(true);
        }
    }

    /* renamed from: a */
    void m11393a(C1487f c1487f) {
        this.f9401a.m4989a(c1487f);
    }

    /* renamed from: a */
    void m11394a(boolean z) {
        this.f9401a.m4991a(z);
    }

    public void destroy() {
        this.f9401a.m4999e();
    }

    public void downloadMedia() {
        this.f9401a.m4997d();
    }

    /* renamed from: g */
    C1425f m11395g() {
        return this.f9401a;
    }

    public String getAdBodyText() {
        return this.f9401a.m5009o();
    }

    public String getAdCallToAction() {
        return this.f9401a.m5011q();
    }

    public Image getAdChoicesIcon() {
        return this.f9401a.m5019y() == null ? null : new Image(this.f9401a.m5019y());
    }

    public String getAdChoicesImageUrl() {
        return this.f9401a.m5019y() == null ? null : this.f9401a.m5019y().m5022a();
    }

    public String getAdChoicesLinkUrl() {
        return this.f9401a.m5020z();
    }

    public String getAdChoicesText() {
        return this.f9401a.m4971A();
    }

    public Image getAdCoverImage() {
        return this.f9401a.m5005k() == null ? null : new Image(this.f9401a.m5005k());
    }

    public String getAdHeadline() {
        return this.f9401a.m5008n();
    }

    public Image getAdIcon() {
        return this.f9401a.m5004j() == null ? null : new Image(this.f9401a.m5004j());
    }

    public String getAdLinkDescription() {
        return this.f9401a.m5013s();
    }

    public AdNetwork getAdNetwork() {
        return AdNetwork.fromInternalAdNetwork(this.f9401a.m4993b());
    }

    public String getAdSocialContext() {
        return this.f9401a.m5012r();
    }

    @Deprecated
    public Rating getAdStarRating() {
        return this.f9401a.m5017w() == null ? null : new Rating(this.f9401a.m5017w());
    }

    public String getAdTranslation() {
        return this.f9401a.m5015u();
    }

    public String getAdUntrimmedBodyText() {
        return this.f9401a.m5010p();
    }

    public NativeAdViewAttributes getAdViewAttributes() {
        return this.f9401a.m5006l() == null ? null : new NativeAdViewAttributes(this.f9401a.m5006l());
    }

    public String getAdvertiserName() {
        return this.f9401a.m5007m();
    }

    public String getId() {
        return this.f9401a.m5018x();
    }

    public String getPlacementId() {
        return this.f9401a.m5000f();
    }

    public String getPromotedTranslation() {
        return this.f9401a.m5016v();
    }

    public String getSponsoredTranslation() {
        return this.f9401a.m5014t();
    }

    /* renamed from: h */
    C3572y m11396h() {
        return this.f9401a.m4981a();
    }

    public boolean hasCallToAction() {
        return this.f9401a.m5003i();
    }

    /* renamed from: i */
    String m11397i() {
        return this.f9401a.m4977G();
    }

    public boolean isAdInvalidated() {
        return this.f9401a.m4996c();
    }

    public boolean isAdLoaded() {
        return this.f9401a.m5001g();
    }

    public boolean isNativeConfigEnabled() {
        return this.f9401a.m5002h();
    }

    public void loadAd() {
        loadAd(MediaCacheFlag.ALL);
    }

    public void loadAd(MediaCacheFlag mediaCacheFlag) {
        this.f9401a.m4986a(mediaCacheFlag.m4415a(), null);
    }

    public void loadAdFromBid(String str) {
        loadAdFromBid(str, MediaCacheFlag.ALL);
    }

    public void loadAdFromBid(String str, MediaCacheFlag mediaCacheFlag) {
        this.f9401a.m4986a(mediaCacheFlag.m4415a(), str);
    }

    public void onCtaBroadcast() {
        this.f9401a.m4978H();
    }

    public void setAdListener(final NativeAdListener nativeAdListener) {
        if (nativeAdListener != null) {
            this.f9401a.m4987a(new C3591i(this) {
                /* renamed from: b */
                final /* synthetic */ NativeAdBase f12284b;

                /* renamed from: a */
                public void mo2810a() {
                    nativeAdListener.onMediaDownloaded(this.f12284b);
                }

                /* renamed from: a */
                public void mo2811a(C1481a c1481a) {
                    nativeAdListener.onError(this.f12284b, AdError.getAdErrorFromWrapper(c1481a));
                }

                /* renamed from: b */
                public void mo2812b() {
                    nativeAdListener.onAdLoaded(this.f12284b);
                }

                /* renamed from: c */
                public void mo2813c() {
                    nativeAdListener.onAdClicked(this.f12284b);
                }

                /* renamed from: d */
                public void mo2814d() {
                    nativeAdListener.onLoggingImpression(this.f12284b);
                }
            });
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f9401a.m4982a(onTouchListener);
    }

    public void unregisterView() {
        this.f9401a.m4980J();
    }
}
