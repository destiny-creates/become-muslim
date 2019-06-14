package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: ObjectAnimatorUtilsApi21 */
/* renamed from: android.support.transition.j */
class C3152j implements C0240k {
    C3152j() {
    }

    /* renamed from: a */
    public <T> ObjectAnimator mo142a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, null, path);
    }
}
