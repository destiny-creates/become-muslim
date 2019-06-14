package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@cm
final class oj extends ok implements OnScrollChangedListener {
    /* renamed from: a */
    private final WeakReference<OnScrollChangedListener> f24196a;

    public oj(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f24196a = new WeakReference(onScrollChangedListener);
    }

    /* renamed from: a */
    protected final void mo4322a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    /* renamed from: b */
    protected final void mo4323b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public final void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f24196a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m19969b();
        }
    }
}
