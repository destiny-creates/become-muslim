package com.google.android.gms.ads.p168b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.avi;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.ads.b.n */
public final class C2621n extends FrameLayout {
    /* renamed from: a */
    private final FrameLayout f6660a;
    /* renamed from: b */
    private final avi f6661b;

    /* renamed from: a */
    private final View m7394a(String str) {
        try {
            C2758b a = this.f6661b.a(str);
            if (a != null) {
                return (View) C4757d.m16685a(a);
            }
        } catch (Throwable e) {
            mt.b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    /* renamed from: a */
    private final void m7395a(String str, View view) {
        try {
            this.f6661b.a(str, C4757d.m16684a((Object) view));
        } catch (Throwable e) {
            mt.b("Unable to call setAssetView on delegate", e);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f6660a);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f6660a != view) {
            super.bringChildToFront(this.f6660a);
        }
    }

    public final C2605a getAdChoicesView() {
        View a = m7394a("3011");
        return a instanceof C2605a ? (C2605a) a : null;
    }

    public final View getAdvertiserView() {
        return m7394a("3005");
    }

    public final View getBodyView() {
        return m7394a("3004");
    }

    public final View getCallToActionView() {
        return m7394a("3002");
    }

    public final View getHeadlineView() {
        return m7394a("3001");
    }

    public final View getIconView() {
        return m7394a("3003");
    }

    public final View getImageView() {
        return m7394a("3008");
    }

    public final C2606b getMediaView() {
        View a = m7394a("3010");
        if (a instanceof C2606b) {
            return (C2606b) a;
        }
        if (a != null) {
            mt.b("View is not an instance of MediaView");
        }
        return null;
    }

    public final View getPriceView() {
        return m7394a("3007");
    }

    public final View getStarRatingView() {
        return m7394a("3009");
    }

    public final View getStoreView() {
        return m7394a("3006");
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f6661b != null) {
            try {
                this.f6661b.a(C4757d.m16684a((Object) view), i);
            } catch (Throwable e) {
                mt.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f6660a);
    }

    public final void removeView(View view) {
        if (this.f6660a != view) {
            super.removeView(view);
        }
    }

    public final void setAdChoicesView(C2605a c2605a) {
        m7395a("3011", c2605a);
    }

    public final void setAdvertiserView(View view) {
        m7395a("3005", view);
    }

    public final void setBodyView(View view) {
        m7395a("3004", view);
    }

    public final void setCallToActionView(View view) {
        m7395a("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f6661b.b(C4757d.m16684a((Object) view));
        } catch (Throwable e) {
            mt.b("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        m7395a("3001", view);
    }

    public final void setIconView(View view) {
        m7395a("3003", view);
    }

    public final void setImageView(View view) {
        m7395a("3008", view);
    }

    public final void setMediaView(C2606b c2606b) {
        m7395a("3010", c2606b);
    }

    public final void setNativeAd(C2620m c2620m) {
        try {
            this.f6661b.a((C2758b) c2620m.m7392k());
        } catch (Throwable e) {
            mt.b("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        m7395a("3007", view);
    }

    public final void setStarRatingView(View view) {
        m7395a("3009", view);
    }

    public final void setStoreView(View view) {
        m7395a("3006", view);
    }
}
