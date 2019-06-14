package android.support.design.widget;

import android.support.v4.view.p034b.C3219a;
import android.support.v4.view.p034b.C3220b;
import android.support.v4.view.p034b.C3221c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils */
/* renamed from: android.support.design.widget.a */
class C0166a {
    /* renamed from: a */
    static final Interpolator f362a = new LinearInterpolator();
    /* renamed from: b */
    static final Interpolator f363b = new C3220b();
    /* renamed from: c */
    static final Interpolator f364c = new C3219a();
    /* renamed from: d */
    static final Interpolator f365d = new C3221c();
    /* renamed from: e */
    static final Interpolator f366e = new DecelerateInterpolator();

    /* renamed from: a */
    static float m376a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
