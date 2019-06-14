package com.p050a.p051a.p061e;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator */
/* renamed from: com.a.a.e.a */
public abstract class C0944a extends ValueAnimator {
    /* renamed from: a */
    private final Set<AnimatorUpdateListener> f2634a = new CopyOnWriteArraySet();
    /* renamed from: b */
    private final Set<AnimatorListener> f2635b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f2634a.add(animatorUpdateListener);
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f2634a.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f2634a.clear();
    }

    public void addListener(AnimatorListener animatorListener) {
        this.f2635b.add(animatorListener);
    }

    public void removeListener(AnimatorListener animatorListener) {
        this.f2635b.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.f2635b.clear();
    }

    /* renamed from: a */
    void m3293a(boolean z) {
        for (AnimatorListener animatorListener : this.f2635b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* renamed from: a */
    void m3292a() {
        for (AnimatorListener onAnimationRepeat : this.f2635b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* renamed from: b */
    void m3295b(boolean z) {
        for (AnimatorListener animatorListener : this.f2635b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* renamed from: b */
    void m3294b() {
        for (AnimatorListener onAnimationCancel : this.f2635b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    /* renamed from: c */
    void m3296c() {
        for (AnimatorUpdateListener onAnimationUpdate : this.f2634a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
