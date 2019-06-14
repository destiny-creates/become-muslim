package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

/* compiled from: AnimatorUtils */
/* renamed from: android.support.transition.a */
class C0219a {
    /* renamed from: a */
    private static final C0227d f540a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f540a = new C3149c();
        } else {
            f540a = new C3148b();
        }
    }

    /* renamed from: a */
    static void m556a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        f540a.mo140a(animator, animatorListenerAdapter);
    }

    /* renamed from: a */
    static void m555a(Animator animator) {
        f540a.mo139a(animator);
    }

    /* renamed from: b */
    static void m557b(Animator animator) {
        f540a.mo141b(animator);
    }
}
