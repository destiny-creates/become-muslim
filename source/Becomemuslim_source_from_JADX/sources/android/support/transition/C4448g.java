package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.transition.C0254u.C0253c;
import android.support.v4.view.C0517s;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade */
/* renamed from: android.support.transition.g */
public class C4448g extends at {

    /* compiled from: Fade */
    /* renamed from: android.support.transition.g$a */
    private static class C0238a extends AnimatorListenerAdapter {
        /* renamed from: a */
        private final View f592a;
        /* renamed from: b */
        private boolean f593b = false;

        C0238a(View view) {
            this.f592a = view;
        }

        public void onAnimationStart(Animator animator) {
            if (C0517s.m1723q(this.f592a) != null && this.f592a.getLayerType() == null) {
                this.f593b = true;
                this.f592a.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            am.m576a(this.f592a, 1.0f);
            if (this.f593b != null) {
                this.f592a.setLayerType(0, null);
            }
        }
    }

    public C4448g(int i) {
        m9328a(i);
    }

    /* renamed from: a */
    public void mo135a(aa aaVar) {
        super.mo135a(aaVar);
        aaVar.f541a.put("android:fade:transitionAlpha", Float.valueOf(am.m582c(aaVar.f542b)));
    }

    /* renamed from: a */
    private Animator m14858a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        am.m576a(view, f);
        f = ObjectAnimator.ofFloat(view, am.f555a, new float[]{f2});
        f.addListener(new C0238a(view));
        mo146a((C0253c) new C3156v(this) {
            /* renamed from: b */
            final /* synthetic */ C4448g f11893b;

            /* renamed from: a */
            public void mo99a(C0254u c0254u) {
                am.m576a(view, 1.0f);
                am.m584e(view);
                c0254u.mo151b((C0253c) this);
            }
        });
        return f;
    }

    /* renamed from: a */
    public Animator mo2653a(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        viewGroup = null;
        aaVar = C4448g.m14857a(aaVar, 0.0f);
        if (aaVar != 1065353216) {
            viewGroup = aaVar;
        }
        return m14858a(view, viewGroup, 1.0f);
    }

    /* renamed from: b */
    public Animator mo2654b(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        am.m583d(view);
        return m14858a(view, C4448g.m14857a(aaVar, 1.0f), null);
    }

    /* renamed from: a */
    private static float m14857a(aa aaVar, float f) {
        if (aaVar == null) {
            return f;
        }
        Float f2 = (Float) aaVar.f541a.get("android:fade:transitionAlpha");
        return f2 != null ? f2.floatValue() : f;
    }
}
