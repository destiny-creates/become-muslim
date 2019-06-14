package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.ads.internal.p099n.C1421d;
import com.facebook.ads.internal.p099n.C1421d.C1420a;
import com.facebook.ads.internal.p099n.C1425f;
import java.lang.ref.WeakReference;

public final class DefaultMediaViewVideoRenderer extends MediaViewVideoRenderer {
    /* renamed from: d */
    private C1421d f9364d;

    /* renamed from: com.facebook.ads.DefaultMediaViewVideoRenderer$1 */
    class C12841 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ DefaultMediaViewVideoRenderer f3676a;

        C12841(DefaultMediaViewVideoRenderer defaultMediaViewVideoRenderer) {
            this.f3676a = defaultMediaViewVideoRenderer;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.DefaultMediaViewVideoRenderer$a */
    private static class C3524a implements C1420a {
        /* renamed from: a */
        private WeakReference<C1425f> f9363a;

        public C3524a(C1425f c1425f) {
            this.f9363a = new WeakReference(c1425f);
        }

        /* renamed from: a */
        public void mo856a(boolean z) {
            if (this.f9363a.get() != null) {
                ((C1425f) this.f9363a.get()).m4992a(z, false);
            }
        }
    }

    public DefaultMediaViewVideoRenderer(Context context) {
        super(context);
        this.f9364d = new C1421d(context, this);
        m11337b();
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9364d = new C1421d(context, this);
        m11337b();
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9364d = new C1421d(context, this);
        m11337b();
    }

    @TargetApi(21)
    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9364d = new C1421d(context, this);
        m11337b();
    }

    /* renamed from: b */
    private void m11337b() {
        setVolume(0.0f);
    }

    /* renamed from: a */
    protected void mo857a() {
        super.mo857a();
        this.f9364d.m4928a();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9364d.m4931c();
    }

    protected void onDetachedFromWindow() {
        this.f9364d.m4932d();
        super.onDetachedFromWindow();
    }

    public void onPrepared() {
        super.onPrepared();
        setOnTouchListener(new C12841(this));
        this.f9364d.m4930b();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f9364d.m4933e();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f9364d.m4934f();
    }

    protected void setNativeAd(NativeAd nativeAd) {
        super.setNativeAd(nativeAd);
        this.f9364d.m4929a(nativeAd.m11395g(), new C3524a(nativeAd.m11395g()));
    }
}
