package com.google.android.gms.ads.p168b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.avi;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.ads.b.e */
public class C2612e extends FrameLayout {
    /* renamed from: a */
    private final FrameLayout f6655a;
    /* renamed from: b */
    private final avi f6656b = m7372a();

    public C2612e(Context context) {
        super(context);
        this.f6655a = m7371a(context);
    }

    /* renamed from: a */
    private final FrameLayout m7371a(Context context) {
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    /* renamed from: a */
    private final avi m7372a() {
        C2872v.m8381a(this.f6655a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return isInEditMode() ? null : aph.b().a(this.f6655a.getContext(), this, this.f6655a);
    }

    /* renamed from: a */
    protected final View m7373a(String str) {
        try {
            C2758b a = this.f6656b.a(str);
            if (a != null) {
                return (View) C4757d.m16685a(a);
            }
        } catch (Throwable e) {
            mt.b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    /* renamed from: a */
    protected final void m7374a(String str, View view) {
        try {
            this.f6656b.a(str, C4757d.m16684a((Object) view));
        } catch (Throwable e) {
            mt.b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f6655a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f6655a != view) {
            super.bringChildToFront(this.f6655a);
        }
    }

    public C2605a getAdChoicesView() {
        View a = m7373a("1098");
        return a instanceof C2605a ? (C2605a) a : null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f6656b != null) {
            try {
                this.f6656b.a(C4757d.m16684a((Object) view), i);
            } catch (Throwable e) {
                mt.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f6655a);
    }

    public void removeView(View view) {
        if (this.f6655a != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(C2605a c2605a) {
        m7374a("1098", c2605a);
    }

    public void setNativeAd(C2609c c2609c) {
        try {
            this.f6656b.a((C2758b) c2609c.m7354a());
        } catch (Throwable e) {
            mt.b("Unable to call setNativeAd on delegate", e);
        }
    }
}
