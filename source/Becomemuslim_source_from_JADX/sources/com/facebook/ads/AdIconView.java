package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;

public class AdIconView extends C1426g {
    /* renamed from: a */
    private ImageView f9350a;
    /* renamed from: b */
    private boolean f9351b;

    public AdIconView(Context context) {
        super(context);
        m11317a();
    }

    public AdIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11317a();
    }

    public AdIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11317a();
    }

    @TargetApi(21)
    public AdIconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m11317a();
    }

    /* renamed from: a */
    private void m11317a() {
        C1523w.m5346b(this.f9350a);
        this.f9350a = new ImageView(getContext());
        this.f9350a.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.f9350a);
        this.f9351b = true;
    }

    /* renamed from: a */
    private void m11318a(final NativeAdBase nativeAdBase, boolean z) {
        bringChildToFront(this.f9350a);
        nativeAdBase.m11391a(this);
        C1577d a = new C1577d(this.f9350a).m5504a();
        if (z) {
            a.m5506a(new C1578e(this) {
                /* renamed from: b */
                final /* synthetic */ AdIconView f9349b;

                /* renamed from: a */
                public void mo841a(boolean z) {
                    nativeAdBase.m11395g().m4992a(z, true);
                }
            });
        }
        a.m5508a(nativeAdBase.m11395g().m5004j().m5022a());
    }

    public void addView(View view) {
        if (!this.f9351b) {
            super.addView(view);
        }
    }

    public void addView(View view, int i) {
        if (!this.f9351b) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (!this.f9351b) {
            super.addView(view, i, i2);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f9351b) {
            super.addView(view, layoutParams);
        }
    }

    public void bringChildToFront(View view) {
        if (view == this.f9350a) {
            super.bringChildToFront(view);
        }
    }

    public void forceAddview(View view, ViewGroup.LayoutParams layoutParams) {
        this.f9351b = false;
        addView(view, layoutParams);
        this.f9351b = true;
    }

    protected View getAdContentsView() {
        return this.f9350a;
    }

    void setNativeAd(NativeAd nativeAd) {
        m11318a(nativeAd, false);
    }

    void setNativeBannerAd(NativeBannerAd nativeBannerAd) {
        m11318a(nativeBannerAd, true);
    }
}
