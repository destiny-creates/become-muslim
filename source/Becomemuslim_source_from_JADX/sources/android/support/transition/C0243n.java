package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtils */
/* renamed from: android.support.transition.n */
class C0243n {
    /* renamed from: a */
    private static final C0244q f601a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f601a = new C3154p();
        } else {
            f601a = new C3153o();
        }
    }

    /* renamed from: a */
    static PropertyValuesHolder m617a(Property<?, PointF> property, Path path) {
        return f601a.mo143a(property, path);
    }
}
