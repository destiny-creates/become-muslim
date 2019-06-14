package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
/* renamed from: android.support.design.widget.l */
final class C0196l {
    /* renamed from: a */
    ValueAnimator f449a = null;
    /* renamed from: b */
    private final ArrayList<C0195a> f450b = new ArrayList();
    /* renamed from: c */
    private C0195a f451c = null;
    /* renamed from: d */
    private final AnimatorListener f452d = new C01941(this);

    /* compiled from: StateListAnimator */
    /* renamed from: android.support.design.widget.l$1 */
    class C01941 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C0196l f446a;

        C01941(C0196l c0196l) {
            this.f446a = c0196l;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f446a.f449a == animator) {
                this.f446a.f449a = null;
            }
        }
    }

    /* compiled from: StateListAnimator */
    /* renamed from: android.support.design.widget.l$a */
    static class C0195a {
        /* renamed from: a */
        final int[] f447a;
        /* renamed from: b */
        final ValueAnimator f448b;

        C0195a(int[] iArr, ValueAnimator valueAnimator) {
            this.f447a = iArr;
            this.f448b = valueAnimator;
        }
    }

    C0196l() {
    }

    /* renamed from: a */
    public void m453a(int[] iArr, ValueAnimator valueAnimator) {
        C0195a c0195a = new C0195a(iArr, valueAnimator);
        valueAnimator.addListener(this.f452d);
        this.f450b.add(c0195a);
    }

    /* renamed from: a */
    void m452a(int[] iArr) {
        C0195a c0195a;
        int size = this.f450b.size();
        for (int i = 0; i < size; i++) {
            c0195a = (C0195a) this.f450b.get(i);
            if (StateSet.stateSetMatches(c0195a.f447a, iArr)) {
                break;
            }
        }
        c0195a = null;
        if (c0195a != this.f451c) {
            if (this.f451c != null) {
                m450b();
            }
            this.f451c = c0195a;
            if (c0195a != null) {
                m449a(c0195a);
            }
        }
    }

    /* renamed from: a */
    private void m449a(C0195a c0195a) {
        this.f449a = c0195a.f448b;
        this.f449a.start();
    }

    /* renamed from: b */
    private void m450b() {
        if (this.f449a != null) {
            this.f449a.cancel();
            this.f449a = null;
        }
    }

    /* renamed from: a */
    public void m451a() {
        if (this.f449a != null) {
            this.f449a.end();
            this.f449a = null;
        }
    }
}
