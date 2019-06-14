package com.p079e.p080a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: DeferredRequestCreator */
/* renamed from: com.e.a.h */
class C1214h implements OnPreDrawListener {
    /* renamed from: a */
    final C1243x f3421a;
    /* renamed from: b */
    final WeakReference<ImageView> f3422b;
    /* renamed from: c */
    C1212e f3423c;

    C1214h(C1243x c1243x, ImageView imageView, C1212e c1212e) {
        this.f3421a = c1243x;
        this.f3422b = new WeakReference(imageView);
        this.f3423c = c1212e;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f3422b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0) {
            if (height > 0) {
                viewTreeObserver.removeOnPreDrawListener(this);
                this.f3421a.m4338a().m4339a(width, height).m4340a(imageView, this.f3423c);
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    void m4262a() {
        this.f3423c = null;
        ImageView imageView = (ImageView) this.f3422b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
