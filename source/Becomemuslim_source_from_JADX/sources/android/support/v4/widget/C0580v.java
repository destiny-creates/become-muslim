package android.support.v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtils */
/* renamed from: android.support.v4.widget.v */
public class C0580v {
    /* renamed from: a */
    private static final ThreadLocal<Matrix> f1435a = new ThreadLocal();
    /* renamed from: b */
    private static final ThreadLocal<RectF> f1436b = new ThreadLocal();

    /* renamed from: a */
    static void m1960a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = (Matrix) f1435a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f1435a.set(matrix);
        } else {
            matrix.reset();
        }
        C0580v.m1961a((ViewParent) viewGroup, view, matrix);
        viewGroup = (RectF) f1436b.get();
        if (viewGroup == null) {
            viewGroup = new RectF();
            f1436b.set(viewGroup);
        }
        viewGroup.set(rect);
        matrix.mapRect(viewGroup);
        rect.set((int) (viewGroup.left + 1056964608), (int) (viewGroup.top + 0.5f), (int) (viewGroup.right + 0.5f), (int) (viewGroup.bottom + 1056964608));
    }

    /* renamed from: b */
    public static void m1962b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C0580v.m1960a(viewGroup, view, rect);
    }

    /* renamed from: a */
    private static void m1961a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            C0580v.m1961a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (view.getMatrix().isIdentity() == null) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
