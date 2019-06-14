package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtilsApi21 */
/* renamed from: android.support.transition.p */
class C3154p implements C0244q {
    C3154p() {
    }

    /* renamed from: a */
    public PropertyValuesHolder mo143a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofObject(property, null, path);
    }
}
