package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* compiled from: AnimatorUtilsApi14 */
/* renamed from: android.support.transition.b */
class C3148b implements C0227d {

    /* compiled from: AnimatorUtilsApi14 */
    /* renamed from: android.support.transition.b$a */
    interface C0226a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* renamed from: a */
    public void mo140a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    C3148b() {
    }

    /* renamed from: a */
    public void mo139a(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof C0226a) {
                    ((C0226a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo141b(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof C0226a) {
                    ((C0226a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
