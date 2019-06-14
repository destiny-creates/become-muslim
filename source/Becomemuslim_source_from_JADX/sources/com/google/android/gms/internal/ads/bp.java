package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

final class bp implements OnScrollChangedListener {
    /* renamed from: a */
    private final /* synthetic */ WeakReference f15263a;
    /* renamed from: b */
    private final /* synthetic */ bi f15264b;

    bp(bi biVar, WeakReference weakReference) {
        this.f15264b = biVar;
        this.f15263a = weakReference;
    }

    public final void onScrollChanged() {
        this.f15264b.m19361a(this.f15263a, true);
    }
}
