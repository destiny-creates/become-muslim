package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

final class bo implements OnGlobalLayoutListener {
    /* renamed from: a */
    private final /* synthetic */ WeakReference f15261a;
    /* renamed from: b */
    private final /* synthetic */ bi f15262b;

    bo(bi biVar, WeakReference weakReference) {
        this.f15262b = biVar;
        this.f15261a = weakReference;
    }

    public final void onGlobalLayout() {
        this.f15262b.m19361a(this.f15261a, false);
    }
}
