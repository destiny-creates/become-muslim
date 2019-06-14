package com.facebook.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.adapters.C3570s;
import com.facebook.ads.internal.adapters.C4561j;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.view.p113b.C1576c;
import com.facebook.ads.p084a.C1288a;
import java.util.EnumSet;

public class InstreamVideoAdView extends RelativeLayout implements Ad {
    /* renamed from: a */
    private final Context f9367a;
    /* renamed from: b */
    private final String f9368b;
    /* renamed from: c */
    private final AdSize f9369c;
    /* renamed from: d */
    private DisplayAdController f9370d;
    /* renamed from: e */
    private C4561j f9371e;
    /* renamed from: f */
    private boolean f9372f;
    /* renamed from: g */
    private InstreamVideoAdListener f9373g;
    /* renamed from: h */
    private View f9374h;
    /* renamed from: i */
    private Bundle f9375i;
    /* renamed from: j */
    private C1576c f9376j;

    /* renamed from: com.facebook.ads.InstreamVideoAdView$1 */
    class C35251 extends C1322a {
        /* renamed from: a */
        final /* synthetic */ InstreamVideoAdView f9365a;

        /* renamed from: com.facebook.ads.InstreamVideoAdView$1$1 */
        class C12851 implements OnLongClickListener {
            /* renamed from: a */
            final /* synthetic */ C35251 f3677a;

            C12851(C35251 c35251) {
                this.f3677a = c35251;
            }

            public boolean onLongClick(View view) {
                if (this.f3677a.f9365a.f9374h != null) {
                    if (this.f3677a.f9365a.f9376j != null) {
                        this.f3677a.f9365a.f9376j.setBounds(0, 0, this.f3677a.f9365a.f9374h.getWidth(), this.f3677a.f9365a.f9374h.getHeight());
                        this.f3677a.f9365a.f9376j.m5500a(this.f3677a.f9365a.f9376j.m5501a() ^ true);
                        return true;
                    }
                }
                return false;
            }
        }

        C35251(InstreamVideoAdView instreamVideoAdView) {
            this.f9365a = instreamVideoAdView;
        }

        /* renamed from: a */
        public void mo843a() {
            if (this.f9365a.f9373g != null) {
                this.f9365a.f9373g.onAdClicked(this.f9365a);
            }
        }

        /* renamed from: a */
        public void mo844a(View view) {
            if (view != null) {
                this.f9365a.f9374h = view;
                this.f9365a.removeAllViews();
                this.f9365a.f9374h.setLayoutParams(new LayoutParams(-1, -1));
                this.f9365a.addView(this.f9365a.f9374h);
                if (C1405a.m4820b(this.f9365a.f9367a)) {
                    this.f9365a.f9376j = new C1576c();
                    this.f9365a.f9376j.m5499a(this.f9365a.f9368b);
                    this.f9365a.f9376j.m5503b(this.f9365a.f9367a.getPackageName());
                    if (this.f9365a.f9370d.m11474a() != null) {
                        this.f9365a.f9376j.m5497a(this.f9365a.f9370d.m11474a().m4766a());
                    }
                    this.f9365a.f9374h.getOverlay().add(this.f9365a.f9376j);
                    this.f9365a.f9374h.setOnLongClickListener(new C12851(this));
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot present null view");
        }

        /* renamed from: a */
        public void mo845a(AdAdapter adAdapter) {
            if (this.f9365a.f9370d != null) {
                this.f9365a.f9372f = true;
                if (this.f9365a.f9373g != null) {
                    this.f9365a.f9373g.onAdLoaded(this.f9365a);
                }
            }
        }

        /* renamed from: a */
        public void mo846a(C1481a c1481a) {
            if (this.f9365a.f9373g != null) {
                this.f9365a.f9373g.onError(this.f9365a, AdError.getAdErrorFromWrapper(c1481a));
            }
        }

        /* renamed from: b */
        public void mo847b() {
            if (this.f9365a.f9373g != null) {
                this.f9365a.f9373g.onLoggingImpression(this.f9365a);
            }
        }

        /* renamed from: c */
        public void mo860c() {
            if (this.f9365a.f9373g != null) {
                this.f9365a.f9373g.onAdVideoComplete(this.f9365a);
            }
        }
    }

    /* renamed from: com.facebook.ads.InstreamVideoAdView$2 */
    class C35262 implements C1288a {
        /* renamed from: a */
        final /* synthetic */ InstreamVideoAdView f9366a;

        C35262(InstreamVideoAdView instreamVideoAdView) {
            this.f9366a = instreamVideoAdView;
        }

        /* renamed from: a */
        public void mo861a(C3570s c3570s) {
            this.f9366a.f9372f = true;
            if (this.f9366a.f9373g != null) {
                this.f9366a.f9373g.onAdLoaded(this.f9366a);
            }
        }

        /* renamed from: a */
        public void mo862a(C3570s c3570s, View view) {
            if (view != null) {
                this.f9366a.f9374h = view;
                this.f9366a.removeAllViews();
                this.f9366a.f9374h.setLayoutParams(new LayoutParams(-1, -1));
                this.f9366a.addView(this.f9366a.f9374h);
                return;
            }
            throw new IllegalStateException("Cannot present null view");
        }

        /* renamed from: a */
        public void mo863a(C3570s c3570s, AdError adError) {
            if (this.f9366a.f9373g != null) {
                this.f9366a.f9373g.onError(this.f9366a, adError);
            }
        }

        /* renamed from: b */
        public void mo864b(C3570s c3570s) {
            if (this.f9366a.f9373g != null) {
                this.f9366a.f9373g.onAdClicked(this.f9366a);
            }
        }

        /* renamed from: c */
        public void mo865c(C3570s c3570s) {
        }

        /* renamed from: d */
        public void mo866d(C3570s c3570s) {
            if (this.f9366a.f9373g != null) {
                this.f9366a.f9373g.onAdVideoComplete(this.f9366a);
            }
        }
    }

    public InstreamVideoAdView(Context context, Bundle bundle) {
        this(context, bundle.getString("placementID"), (AdSize) bundle.get("adSize"));
        this.f9375i = bundle;
    }

    public InstreamVideoAdView(Context context, String str, AdSize adSize) {
        super(context);
        this.f9372f = false;
        this.f9367a = context;
        this.f9368b = str;
        this.f9369c = adSize;
        this.f9370d = getController();
    }

    /* renamed from: a */
    private final void m11354a() {
        if (this.f9370d != null) {
            this.f9370d.m11483b(true);
            this.f9370d = null;
            this.f9370d = getController();
            this.f9371e = null;
            this.f9372f = false;
            removeAllViews();
        }
    }

    /* renamed from: a */
    private void m11355a(String str) {
        if (this.f9375i != null) {
            this.f9371e = new C4561j();
            this.f9371e.m15570a(getContext(), new C35262(this), this.f9370d.m11486e(), this.f9375i.getBundle("adapter"), EnumSet.of(CacheFlag.NONE));
            return;
        }
        this.f9370d.m11480a(str);
    }

    private DisplayAdController getController() {
        this.f9370d = new DisplayAdController(getContext(), this.f9368b, C1487f.INSTREAM_VIDEO, AdPlacementType.INSTREAM, this.f9369c.toInternalAdSize(), C1485d.ADS, 1, true);
        this.f9370d.m11477a(new C35251(this));
        return this.f9370d;
    }

    public void destroy() {
        if (this.f9376j != null && C1405a.m4820b(this.f9367a)) {
            this.f9376j.m5502b();
            if (this.f9374h != null) {
                this.f9374h.getOverlay().remove(this.f9376j);
            }
        }
        m11354a();
    }

    public String getPlacementId() {
        return this.f9368b;
    }

    public Bundle getSaveInstanceState() {
        C3570s c3570s = this.f9371e != null ? this.f9371e : (C3570s) this.f9370d.m11487f();
        if (c3570s == null) {
            return null;
        }
        Bundle g = c3570s.mo937g();
        if (g == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("adapter", g);
        bundle.putString("placementID", this.f9368b);
        bundle.putSerializable("adSize", this.f9369c);
        return bundle;
    }

    public boolean isAdInvalidated() {
        if (this.f9370d != null) {
            if (!this.f9370d.m11485d()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAdLoaded() {
        return this.f9372f;
    }

    public void loadAd() {
        m11355a(null);
    }

    public void loadAdFromBid(String str) {
        m11355a(str);
    }

    public void setAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.f9373g = instreamVideoAdListener;
    }

    public boolean show() {
        if (this.f9372f) {
            if (this.f9370d != null || this.f9371e != null) {
                if (this.f9371e != null) {
                    this.f9371e.mo2861e();
                } else {
                    this.f9370d.m11482b();
                }
                this.f9372f = false;
                return true;
            }
        }
        if (this.f9373g != null) {
            this.f9373g.onError(this, AdError.INTERNAL_ERROR);
        }
        return false;
    }
}
