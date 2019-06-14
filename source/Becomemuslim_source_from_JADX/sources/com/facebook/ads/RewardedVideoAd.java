package com.facebook.ads;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.adapters.ab;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1486e;
import com.facebook.ads.internal.protocol.C1487f;

public class RewardedVideoAd implements Ad {
    public static final int UNSET_VIDEO_DURATION = -1;
    /* renamed from: a */
    private static final String f9410a = "RewardedVideoAd";
    /* renamed from: b */
    private final Context f9411b;
    /* renamed from: c */
    private final String f9412c;
    /* renamed from: d */
    private DisplayAdController f9413d;
    /* renamed from: e */
    private boolean f9414e = false;
    /* renamed from: f */
    private RewardedVideoAdListener f9415f;
    /* renamed from: g */
    private RewardData f9416g;
    /* renamed from: h */
    private int f9417h = -1;

    /* renamed from: com.facebook.ads.RewardedVideoAd$1 */
    class C35361 extends C1322a {
        /* renamed from: a */
        final /* synthetic */ RewardedVideoAd f9409a;

        C35361(RewardedVideoAd rewardedVideoAd) {
            this.f9409a = rewardedVideoAd;
        }

        /* renamed from: a */
        public void mo843a() {
            if (this.f9409a.f9415f != null) {
                this.f9409a.f9415f.onAdClicked(this.f9409a);
            }
        }

        /* renamed from: a */
        public void mo845a(AdAdapter adAdapter) {
            ab abVar = (ab) adAdapter;
            if (this.f9409a.f9416g != null) {
                abVar.m11514a(this.f9409a.f9416g);
            }
            this.f9409a.f9417h = abVar.mo2866a();
            this.f9409a.f9414e = true;
            if (this.f9409a.f9415f != null) {
                this.f9409a.f9415f.onAdLoaded(this.f9409a);
            }
        }

        /* renamed from: a */
        public void mo846a(C1481a c1481a) {
            if (this.f9409a.f9415f != null) {
                this.f9409a.f9415f.onError(this.f9409a, AdError.getAdErrorFromWrapper(c1481a));
            }
        }

        /* renamed from: b */
        public void mo847b() {
            if (this.f9409a.f9415f != null) {
                this.f9409a.f9415f.onLoggingImpression(this.f9409a);
            }
        }

        /* renamed from: f */
        public void mo886f() {
            this.f9409a.f9415f.onRewardedVideoCompleted();
        }

        /* renamed from: g */
        public void mo887g() {
            if (this.f9409a.f9415f != null) {
                this.f9409a.f9415f.onRewardedVideoClosed();
            }
        }

        /* renamed from: h */
        public void mo888h() {
            if (this.f9409a.f9415f instanceof S2SRewardedVideoAdListener) {
                ((S2SRewardedVideoAdListener) this.f9409a.f9415f).onRewardServerFailed();
            }
        }

        /* renamed from: i */
        public void mo889i() {
            if (this.f9409a.f9415f instanceof S2SRewardedVideoAdListener) {
                ((S2SRewardedVideoAdListener) this.f9409a.f9415f).onRewardServerSuccess();
            }
        }
    }

    public RewardedVideoAd(Context context, String str) {
        this.f9411b = context;
        this.f9412c = str;
    }

    /* renamed from: a */
    private void m11414a(String str, boolean z) {
        try {
            m11418b(str, z);
        } catch (Throwable e) {
            Log.e(f9410a, "Error loading rewarded video ad", e);
            if (this.f9415f != null) {
                this.f9415f.onError(this, AdError.INTERNAL_ERROR);
            }
        }
    }

    /* renamed from: a */
    private final void m11415a(boolean z) {
        if (this.f9413d != null) {
            this.f9413d.m11483b(z);
            this.f9413d = null;
        }
    }

    /* renamed from: b */
    private void m11418b(String str, boolean z) {
        m11415a(false);
        this.f9414e = false;
        this.f9413d = new DisplayAdController(this.f9411b, this.f9412c, C1487f.REWARDED_VIDEO, AdPlacementType.REWARDED_VIDEO, C1486e.INTERSTITIAL, C1485d.ADS, 1, true);
        this.f9413d.m11481a(z);
        this.f9413d.m11477a(new C35361(this));
        this.f9413d.m11480a(str);
    }

    public void destroy() {
        m11415a(true);
    }

    public String getPlacementId() {
        return this.f9412c;
    }

    public int getVideoDuration() {
        return this.f9417h;
    }

    public boolean isAdInvalidated() {
        if (this.f9413d != null) {
            if (!this.f9413d.m11485d()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAdLoaded() {
        return this.f9414e;
    }

    public void loadAd() {
        m11414a(null, false);
    }

    public void loadAd(boolean z) {
        m11414a(null, z);
    }

    public void loadAdFromBid(String str) {
        m11414a(str, false);
    }

    public void loadAdFromBid(String str, boolean z) {
        m11414a(str, z);
    }

    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f9415f = rewardedVideoAdListener;
    }

    public void setRewardData(RewardData rewardData) {
        this.f9416g = rewardData;
        if (this.f9414e) {
            this.f9413d.m11476a(rewardData);
        }
    }

    public boolean show() {
        return show(-1);
    }

    public boolean show(int i) {
        if (this.f9414e) {
            this.f9413d.m11475a(i);
            this.f9413d.m11482b();
            this.f9414e = false;
            return true;
        }
        if (this.f9415f != null) {
            this.f9415f.onError(this, AdError.INTERNAL_ERROR);
        }
        return false;
    }
}
