package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: AnimatorUtilsApi19 */
/* renamed from: android.support.transition.c */
class C3149c implements C0227d {
    C3149c() {
    }

    /* renamed from: a */
    public void mo140a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* renamed from: a */
    public void mo139a(Animator animator) {
        animator.pause();
    }

    /* renamed from: b */
    public void mo141b(Animator animator) {
        animator.resume();
    }
}
