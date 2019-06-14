package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0153e;
import android.support.v4.p028d.C0384a;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v4.view.aa;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior */
/* renamed from: android.support.design.widget.h */
abstract class C4444h extends C3139o<View> {
    /* renamed from: a */
    final Rect f11882a = new Rect();
    /* renamed from: b */
    final Rect f11883b = new Rect();
    /* renamed from: c */
    private int f11884c = 0;
    /* renamed from: d */
    private int f11885d;

    /* renamed from: c */
    private static int m14830c(int i) {
        return i == 0 ? 8388659 : i;
    }

    /* renamed from: a */
    float mo3320a(View view) {
        return 1.0f;
    }

    /* renamed from: b */
    abstract View mo3324b(List<View> list);

    public C4444h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo2648a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        C4444h c4444h = this;
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = mo3324b(coordinatorLayout.m14810c(view));
            if (b != null) {
                View view2;
                if (!C0517s.m1722p(b) || C0517s.m1722p(view)) {
                    view2 = view;
                } else {
                    view2 = view;
                    C0517s.m1704b(view, true);
                    if (C0517s.m1722p(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m14797a(view, i, i2, MeasureSpec.makeMeasureSpec((size - b.getMeasuredHeight()) + mo3323b(b), i5 == -1 ? 1073741824 : LinearLayoutManager.INVALID_OFFSET), i4);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    protected void mo2649b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = mo3324b(coordinatorLayout.m14810c(view));
        if (b != null) {
            C0153e c0153e = (C0153e) view.getLayoutParams();
            Rect rect = this.f11882a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0153e.leftMargin, b.getBottom() + c0153e.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0153e.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0153e.bottomMargin);
            aa lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || C0517s.m1722p(coordinatorLayout) == null || C0517s.m1722p(view) != null)) {
                rect.left += lastWindowInsets.m1561a();
                rect.right -= lastWindowInsets.m1564c();
            }
            coordinatorLayout = this.f11883b;
            C0501e.m1588a(C4444h.m14830c(c0153e.f336c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, coordinatorLayout, i);
            i = m14838c(b);
            view.layout(coordinatorLayout.left, coordinatorLayout.top - i, coordinatorLayout.right, coordinatorLayout.bottom - i);
            this.f11884c = coordinatorLayout.top - b.getBottom();
            return;
        }
        super.mo2649b(coordinatorLayout, view, i);
        this.f11884c = null;
    }

    /* renamed from: c */
    final int m14838c(View view) {
        return this.f11885d == 0 ? 0 : C0384a.m1163a((int) (mo3320a(view) * ((float) this.f11885d)), 0, this.f11885d);
    }

    /* renamed from: b */
    int mo3323b(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: a */
    final int m14832a() {
        return this.f11884c;
    }

    /* renamed from: b */
    public final void m14836b(int i) {
        this.f11885d = i;
    }

    /* renamed from: d */
    public final int m14839d() {
        return this.f11885d;
    }
}
