package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout extends LinearLayout {
    /* renamed from: a */
    private boolean f1752a;
    /* renamed from: b */
    private int f1753b = -1;
    /* renamed from: c */
    private int f1754c = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, C0590j.ButtonBarLayout);
        this.f1752a = context.getBoolean(C0590j.ButtonBarLayout_allowStacking, true);
        context.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f1752a != z) {
            this.f1752a = z;
            if (!this.f1752a && getOrientation()) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int size = MeasureSpec.getSize(i);
        int i3 = 0;
        if (this.f1752a) {
            if (size > this.f1753b && m2247a()) {
                setStacked(false);
            }
            this.f1753b = size;
        }
        if (m2247a() || MeasureSpec.getMode(i) != 1073741824) {
            size = i;
            obj = null;
        } else {
            size = MeasureSpec.makeMeasureSpec(size, LinearLayoutManager.INVALID_OFFSET);
            obj = 1;
        }
        super.onMeasure(size, i2);
        if (this.f1752a && !m2247a()) {
            if (((getMeasuredWidthAndState() & -16777216) == 16777216 ? 1 : null) != null) {
                setStacked(true);
                obj = 1;
            }
        }
        if (obj != null) {
            super.onMeasure(i, i2);
        }
        i = m2246a(0);
        if (i >= 0) {
            i2 = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            int paddingTop = (((getPaddingTop() + i2.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin) + 0;
            if (m2247a() != 0) {
                i = m2246a(i + 1);
                if (i >= 0) {
                    paddingTop += getChildAt(i).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 1098907648));
                }
                i3 = paddingTop;
            } else {
                i3 = paddingTop + getPaddingBottom();
            }
        }
        if (C0517s.m1716j(this) != i3) {
            setMinimumHeight(i3);
        }
    }

    /* renamed from: a */
    private int m2246a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.f1754c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0586f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? true : true);
        }
        for (z = getChildCount() - 2; z < false; z--) {
            bringChildToFront(getChildAt(z));
        }
    }

    /* renamed from: a */
    private boolean m2247a() {
        return getOrientation() == 1;
    }
}
