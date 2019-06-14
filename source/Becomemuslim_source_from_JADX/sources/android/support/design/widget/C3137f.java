package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FloatingActionButtonLollipop */
/* renamed from: android.support.design.widget.f */
class C3137f extends C0187e {
    /* renamed from: p */
    private InsetDrawable f8037p;

    /* renamed from: a */
    void mo88a(int[] iArr) {
    }

    /* renamed from: b */
    void mo89b() {
    }

    /* renamed from: h */
    boolean mo92h() {
        return false;
    }

    C3137f(C0201s c0201s, C0189j c0189j) {
        super(c0201s, c0189j);
    }

    /* renamed from: a */
    void mo86a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo86a(i);
        }
    }

    /* renamed from: a */
    void mo85a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(k, animatorSet);
            f2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            f2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            f2.setInterpolator(a);
            stateListAnimator.addState(l, f2);
            f = new AnimatorSet();
            f.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            f.setInterpolator(a);
            stateListAnimator.addState(m, f);
            this.n.setStateListAnimator(stateListAnimator);
        } else if (this.n.isEnabled()) {
            this.n.setElevation(f);
            if (this.n.isFocused() == null) {
                if (this.n.isPressed() == null) {
                    this.n.setTranslationZ(0.0f);
                }
            }
            this.n.setTranslationZ(f2);
        } else {
            this.n.setElevation(0.0f);
            this.n.setTranslationZ(0.0f);
        }
        if (this.o.mo72b() != null) {
            m422e();
        }
    }

    /* renamed from: a */
    public float mo84a() {
        return this.n.getElevation();
    }

    /* renamed from: d */
    void mo91d() {
        m422e();
    }

    /* renamed from: b */
    void mo90b(Rect rect) {
        if (this.o.mo72b()) {
            this.f8037p = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.o.mo71a(this.f8037p);
            return;
        }
        this.o.mo71a(this.e);
    }

    /* renamed from: a */
    void mo87a(Rect rect) {
        if (this.o.mo72b()) {
            float a = this.o.mo69a();
            float a2 = mo84a() + this.i;
            int ceil = (int) Math.ceil((double) C3138i.m9258b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C3138i.m9255a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
