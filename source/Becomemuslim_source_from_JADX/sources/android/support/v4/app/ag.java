package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: OneShotPreDrawListener */
class ag implements OnAttachStateChangeListener, OnPreDrawListener {
    /* renamed from: a */
    private final View f757a;
    /* renamed from: b */
    private ViewTreeObserver f758b;
    /* renamed from: c */
    private final Runnable f759c;

    private ag(View view, Runnable runnable) {
        this.f757a = view;
        this.f758b = view.getViewTreeObserver();
        this.f759c = runnable;
    }

    /* renamed from: a */
    public static ag m835a(View view, Runnable runnable) {
        ag agVar = new ag(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(agVar);
        view.addOnAttachStateChangeListener(agVar);
        return agVar;
    }

    public boolean onPreDraw() {
        m836a();
        this.f759c.run();
        return true;
    }

    /* renamed from: a */
    public void m836a() {
        if (this.f758b.isAlive()) {
            this.f758b.removeOnPreDrawListener(this);
        } else {
            this.f757a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f757a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f758b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        m836a();
    }
}
