package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* compiled from: ObjectAnimatorUtils */
/* renamed from: android.support.transition.h */
class C0239h {
    /* renamed from: a */
    private static final C0240k f594a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f594a = new C3152j();
        } else {
            f594a = new C3151i();
        }
    }

    /* renamed from: a */
    static <T> ObjectAnimator m612a(T t, Property<T, PointF> property, Path path) {
        return f594a.mo142a(t, property, path);
    }
}
