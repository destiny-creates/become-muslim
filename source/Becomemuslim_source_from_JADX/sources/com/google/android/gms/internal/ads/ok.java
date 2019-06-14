package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@cm
abstract class ok {
    /* renamed from: a */
    private final WeakReference<View> f15853a;

    public ok(View view) {
        this.f15853a = new WeakReference(view);
    }

    /* renamed from: c */
    private final ViewTreeObserver m19966c() {
        View view = (View) this.f15853a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                return viewTreeObserver;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m19967a() {
        ViewTreeObserver c = m19966c();
        if (c != null) {
            mo4322a(c);
        }
    }

    /* renamed from: a */
    protected abstract void mo4322a(ViewTreeObserver viewTreeObserver);

    /* renamed from: b */
    public final void m19969b() {
        ViewTreeObserver c = m19966c();
        if (c != null) {
            mo4323b(c);
        }
    }

    /* renamed from: b */
    protected abstract void mo4323b(ViewTreeObserver viewTreeObserver);
}
