package android.support.transition;

import android.support.transition.C0246r.C0245a;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene */
/* renamed from: android.support.transition.t */
public class C0248t {
    /* renamed from: a */
    private ViewGroup f603a;
    /* renamed from: b */
    private Runnable f604b;

    /* renamed from: a */
    public void m622a() {
        if (C0248t.m620a(this.f603a) == this && this.f604b != null) {
            this.f604b.run();
        }
    }

    /* renamed from: a */
    static void m621a(View view, C0248t c0248t) {
        view.setTag(C0245a.transition_current_scene, c0248t);
    }

    /* renamed from: a */
    static C0248t m620a(View view) {
        return (C0248t) view.getTag(C0245a.transition_current_scene);
    }
}
