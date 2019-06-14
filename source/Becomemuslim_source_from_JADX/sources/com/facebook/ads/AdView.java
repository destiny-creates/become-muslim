package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1486e;
import com.facebook.ads.internal.protocol.C1488g;
import com.facebook.ads.internal.view.p113b.C1576c;
import com.facebook.ads.internal.view.p113b.C3616a;

public class AdView extends RelativeLayout implements Ad {
    /* renamed from: a */
    private static final C1485d f9354a = C1485d.ADS;
    /* renamed from: b */
    private final DisplayMetrics f9355b;
    /* renamed from: c */
    private final C1486e f9356c;
    /* renamed from: d */
    private final String f9357d;
    /* renamed from: e */
    private DisplayAdController f9358e;
    /* renamed from: f */
    private AdListener f9359f;
    /* renamed from: g */
    private View f9360g;
    /* renamed from: h */
    private C1576c f9361h;

    public AdView(Context context, final String str, AdSize adSize) {
        super(context);
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.f9355b = getContext().getResources().getDisplayMetrics();
        this.f9356c = adSize.toInternalAdSize();
        this.f9357d = str;
        this.f9358e = new DisplayAdController(context, str, C1488g.m5255a(this.f9356c), AdPlacementType.BANNER, adSize.toInternalAdSize(), f9354a, 1, true);
        this.f9358e.m11477a(new C1322a(this) {
            /* renamed from: b */
            final /* synthetic */ AdView f9353b;

            /* renamed from: com.facebook.ads.AdView$1$1 */
            class C12801 implements OnLongClickListener {
                /* renamed from: a */
                final /* synthetic */ C35221 f3657a;

                C12801(C35221 c35221) {
                    this.f3657a = c35221;
                }

                public boolean onLongClick(View view) {
                    this.f3657a.f9353b.f9361h.setBounds(0, 0, this.f3657a.f9353b.f9360g.getWidth(), this.f3657a.f9353b.f9360g.getHeight());
                    this.f3657a.f9353b.f9361h.m5500a(this.f3657a.f9353b.f9361h.m5501a() ^ true);
                    return true;
                }
            }

            /* renamed from: a */
            public void mo843a() {
                if (this.f9353b.f9359f != null) {
                    this.f9353b.f9359f.onAdClicked(this.f9353b);
                }
            }

            /* renamed from: a */
            public void mo844a(View view) {
                if (view != null) {
                    this.f9353b.f9360g = view;
                    this.f9353b.removeAllViews();
                    this.f9353b.addView(this.f9353b.f9360g);
                    if (this.f9353b.f9360g instanceof C3616a) {
                        C1488g.m5256a(this.f9353b.f9355b, this.f9353b.f9360g, this.f9353b.f9356c);
                    }
                    if (this.f9353b.f9359f != null) {
                        this.f9353b.f9359f.onAdLoaded(this.f9353b);
                    }
                    if (C1405a.m4820b(this.f9353b.getContext())) {
                        this.f9353b.f9361h = new C1576c();
                        this.f9353b.f9361h.m5499a(str);
                        this.f9353b.f9361h.m5503b(this.f9353b.getContext().getPackageName());
                        if (this.f9353b.f9358e.m11474a() != null) {
                            this.f9353b.f9361h.m5497a(this.f9353b.f9358e.m11474a().m4766a());
                        }
                        if (this.f9353b.f9360g instanceof C3616a) {
                            this.f9353b.f9361h.m5498a(((C3616a) this.f9353b.f9360g).getViewabilityChecker());
                        }
                        this.f9353b.f9360g.setOnLongClickListener(new C12801(this));
                        this.f9353b.f9360g.getOverlay().add(this.f9353b.f9361h);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Cannot present null view");
            }

            /* renamed from: a */
            public void mo845a(AdAdapter adAdapter) {
                if (this.f9353b.f9358e != null) {
                    this.f9353b.f9358e.m11482b();
                }
            }

            /* renamed from: a */
            public void mo846a(C1481a c1481a) {
                if (this.f9353b.f9359f != null) {
                    this.f9353b.f9359f.onError(this.f9353b, AdError.getAdErrorFromWrapper(c1481a));
                }
            }

            /* renamed from: b */
            public void mo847b() {
                if (this.f9353b.f9359f != null) {
                    this.f9353b.f9359f.onLoggingImpression(this.f9353b);
                }
            }
        });
    }

    /* renamed from: a */
    private void m11327a(String str) {
        this.f9358e.m11480a(str);
    }

    public void destroy() {
        if (this.f9358e != null) {
            this.f9358e.m11483b(true);
            this.f9358e = null;
        }
        if (this.f9361h != null && C1405a.m4820b(getContext())) {
            this.f9361h.m5502b();
            this.f9360g.getOverlay().remove(this.f9361h);
        }
        removeAllViews();
        this.f9360g = null;
        this.f9359f = null;
    }

    @Deprecated
    public void disableAutoRefresh() {
    }

    public String getPlacementId() {
        return this.f9357d;
    }

    public boolean isAdInvalidated() {
        if (this.f9358e != null) {
            if (!this.f9358e.m11485d()) {
                return false;
            }
        }
        return true;
    }

    public void loadAd() {
        m11327a(null);
    }

    public void loadAdFromBid(String str) {
        m11327a(str);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f9360g != null) {
            C1488g.m5256a(this.f9355b, this.f9360g, this.f9356c);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f9359f = adListener;
    }
}
