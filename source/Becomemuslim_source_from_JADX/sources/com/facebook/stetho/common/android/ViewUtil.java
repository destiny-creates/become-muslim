package com.facebook.stetho.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.Util;

public final class ViewUtil {

    private static class ViewCompat {
        private static final ViewCompat sInstance;

        @TargetApi(11)
        private static class ViewCompatHoneycomb extends ViewCompat {
            private ViewCompatHoneycomb() {
            }

            public float getAlpha(View view) {
                return view.getAlpha();
            }
        }

        public float getAlpha(View view) {
            return 1.0f;
        }

        static {
            if (VERSION.SDK_INT >= 11) {
                sInstance = new ViewCompatHoneycomb();
            } else {
                sInstance = new ViewCompat();
            }
        }

        public static ViewCompat getInstance() {
            return sInstance;
        }

        protected ViewCompat() {
        }
    }

    private ViewUtil() {
    }

    private static boolean isHittable(View view) {
        if (view.getVisibility() == 0 && ViewCompat.getInstance().getAlpha(view) >= 0.001f) {
            return true;
        }
        return false;
    }

    public static View hitTest(View view, float f, float f2) {
        return hitTest(view, f, f2, null);
    }

    public static View hitTest(View view, float f, float f2, Predicate<View> predicate) {
        View hitTestImpl = hitTestImpl(view, f, f2, predicate, false);
        return hitTestImpl == null ? hitTestImpl(view, f, f2, predicate, true) : hitTestImpl;
    }

    private static View hitTestImpl(View view, float f, float f2, Predicate<View> predicate, boolean z) {
        if (!isHittable(view) || !pointInView(view, f, f2)) {
            return null;
        }
        if (predicate != null && !predicate.apply(view)) {
            return null;
        }
        if (!(view instanceof ViewGroup)) {
            return view;
        }
        view = (ViewGroup) view;
        if (view.getChildCount() > 0) {
            PointF pointF = new PointF();
            for (int childCount = view.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = view.getChildAt(childCount);
                if (isTransformedPointInView(view, childAt, f, f2, pointF)) {
                    childAt = hitTestImpl(childAt, pointF.x, pointF.y, predicate, z);
                    if (childAt != null) {
                        return childAt;
                    }
                }
            }
        }
        if (!z) {
            view = null;
        }
        return view;
    }

    public static boolean pointInView(View view, float f, float f2) {
        return (f < 0.0f || f >= ((float) (view.getRight() - view.getLeft())) || f2 < 0.0f || f2 >= ((float) (view.getBottom() - view.getTop()))) ? null : true;
    }

    public static boolean isTransformedPointInView(ViewGroup viewGroup, View view, float f, float f2, PointF pointF) {
        Util.throwIfNull(viewGroup);
        Util.throwIfNull(view);
        f = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        f2 = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        viewGroup = pointInView(view, f, f2);
        if (!(viewGroup == null || pointF == null)) {
            pointF.set(f, f2);
        }
        return viewGroup;
    }

    public static Activity tryGetActivity(View view) {
        if (view == null) {
            return null;
        }
        Activity tryGetActivity = tryGetActivity(view.getContext());
        if (tryGetActivity != null) {
            return tryGetActivity;
        }
        view = view.getParent();
        if (view instanceof View) {
            return tryGetActivity(view);
        }
        return null;
    }

    private static Activity tryGetActivity(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
