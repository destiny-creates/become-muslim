package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.ax;
import java.lang.ref.WeakReference;

@cm
final class oi extends ok implements OnGlobalLayoutListener {
    /* renamed from: a */
    private final WeakReference<OnGlobalLayoutListener> f24195a;

    public oi(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f24195a = new WeakReference(onGlobalLayoutListener);
    }

    /* renamed from: a */
    protected final void mo4322a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* renamed from: b */
    protected final void mo4323b(ViewTreeObserver viewTreeObserver) {
        ax.g().mo6844a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public final void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f24195a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m19969b();
        }
    }
}
