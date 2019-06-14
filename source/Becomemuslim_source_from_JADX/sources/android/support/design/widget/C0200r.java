package android.support.design.widget;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.support.design.C0140a.C0131b;
import android.support.design.C0140a.C0135f;
import android.view.View;

/* compiled from: ViewUtilsLollipop */
/* renamed from: android.support.design.widget.r */
class C0200r {
    /* renamed from: a */
    private static final int[] f459a = new int[]{16843848};

    /* renamed from: a */
    static void m461a(View view, float f) {
        int integer = view.getResources().getInteger(C0135f.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = (long) integer;
        stateListAnimator.addState(new int[]{16842766, C0131b.state_collapsible, -C0131b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }
}
