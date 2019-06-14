package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.widget.as.C0762a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout extends as {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        if (!m10213c(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: c */
    private boolean m10213c(int i, int i2) {
        int i3;
        int combineMeasuredStates;
        int c;
        int measuredHeight;
        int i4;
        AlertDialogLayout alertDialogLayout = this;
        int i5 = i;
        int i6 = i2;
        int childCount = getChildCount();
        View view = null;
        View view2 = view;
        View view3 = view2;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0586f.topPanel) {
                    view = childAt;
                } else if (id == C0586f.buttonPanel) {
                    view2 = childAt;
                } else {
                    if (id != C0586f.contentPanel) {
                        if (id != C0586f.customPanel) {
                            return false;
                        }
                    }
                    if (view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        i3 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i5, 0);
            paddingTop += view.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            combineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i5, 0);
            c = m10212c(view2);
            measuredHeight = view2.getMeasuredHeight() - c;
            paddingTop += c;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        } else {
            c = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            if (i3 == 0) {
                i4 = 0;
            } else {
                i4 = MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), i3);
            }
            view3.measure(i5, i4);
            i4 = view3.getMeasuredHeight();
            paddingTop += i4;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        } else {
            i4 = 0;
        }
        size -= paddingTop;
        if (view2 != null) {
            paddingTop -= c;
            measuredHeight = Math.min(size, measuredHeight);
            if (measuredHeight > 0) {
                size -= measuredHeight;
                c += measuredHeight;
            }
            view2.measure(i5, MeasureSpec.makeMeasureSpec(c, 1073741824));
            paddingTop += view2.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && size > 0) {
            paddingTop -= i4;
            view3.measure(i5, MeasureSpec.makeMeasureSpec(i4 + size, i3));
            paddingTop += view3.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        }
        int i7 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            view3 = getChildAt(i3);
            if (view3.getVisibility() != 8) {
                i7 = Math.max(i7, view3.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i7 + (getPaddingLeft() + getPaddingRight()), i5, combineMeasuredStates), View.resolveSizeAndState(paddingTop, i6, 0));
        if (mode != 1073741824) {
            m10214d(childCount, i6);
        }
        return true;
    }

    /* renamed from: d */
    private void m10214d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0762a c0762a = (C0762a) childAt.getLayoutParams();
                if (c0762a.width == -1) {
                    int i4 = c0762a.height;
                    c0762a.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    c0762a.height = i4;
                }
            }
        }
    }

    /* renamed from: c */
    private static int m10212c(View view) {
        int j = C0517s.m1716j(view);
        if (j > 0) {
            return j;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return m10212c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        i6 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 112;
        int i8 = gravity & 8388615;
        if (i7 == 16) {
            paddingTop = (((i4 - i2) - i6) / 2) + getPaddingTop();
        } else if (i7 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i4) - i2) - i6;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i5 = 0;
        } else {
            i5 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                i7 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                C0762a c0762a = (C0762a) childAt.getLayoutParams();
                i6 = c0762a.f2028h;
                if (i6 < 0) {
                    i6 = i8;
                }
                i6 = C0501e.m1587a(i6, C0517s.m1711e(this)) & 7;
                if (i6 == 1) {
                    i6 = ((((paddingRight2 - i7) / 2) + paddingLeft) + c0762a.leftMargin) - c0762a.rightMargin;
                } else if (i6 != 5) {
                    i6 = c0762a.leftMargin + paddingLeft;
                } else {
                    i6 = (paddingRight - i7) - c0762a.rightMargin;
                }
                if (m2674c(i9)) {
                    paddingTop += i5;
                }
                int i10 = paddingTop + c0762a.topMargin;
                m10211a(childAt, i6, i10, i7, measuredHeight);
                paddingTop = i10 + (measuredHeight + c0762a.bottomMargin);
            }
        }
    }

    /* renamed from: a */
    private void m10211a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
