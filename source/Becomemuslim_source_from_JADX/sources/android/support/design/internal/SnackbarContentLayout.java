package android.support.design.internal;

import android.content.Context;
import android.support.design.C0140a.C0132c;
import android.support.design.C0140a.C0134e;
import android.support.design.C0140a.C0139j;
import android.support.design.widget.C0179b.C0175c;
import android.support.v4.view.C0517s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements C0175c {
    /* renamed from: a */
    private TextView f7957a;
    /* renamed from: b */
    private Button f7958b;
    /* renamed from: c */
    private int f7959c;
    /* renamed from: d */
    private int f7960d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, C0139j.SnackbarLayout);
        this.f7959c = context.getDimensionPixelSize(C0139j.SnackbarLayout_android_maxWidth, -1);
        this.f7960d = context.getDimensionPixelSize(C0139j.SnackbarLayout_maxActionInlineWidth, -1);
        context.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f7957a = (TextView) findViewById(C0134e.snackbar_text);
        this.f7958b = (Button) findViewById(C0134e.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f7957a;
    }

    public Button getActionView() {
        return this.f7958b;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7959c > 0 && getMeasuredWidth() > this.f7959c) {
            i = MeasureSpec.makeMeasureSpec(this.f7959c, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0132c.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0132c.design_snackbar_padding_vertical);
        int i3 = 1;
        Object obj = this.f7957a.getLayout().getLineCount() > 1 ? 1 : null;
        if (obj == null || this.f7960d <= 0 || this.f7958b.getMeasuredWidth() <= this.f7960d) {
            if (obj == null) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m9163a(0, dimensionPixelSize, dimensionPixelSize)) {
                if (i3 == 0) {
                    super.onMeasure(i, i2);
                }
            }
        } else if (m9163a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            if (i3 == 0) {
                super.onMeasure(i, i2);
            }
        }
        i3 = 0;
        if (i3 == 0) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: a */
    private boolean m9163a(int i, int i2, int i3) {
        if (i != getOrientation()) {
            setOrientation(i);
            i = 1;
        } else {
            i = 0;
        }
        if (this.f7957a.getPaddingTop() == i2 && this.f7957a.getPaddingBottom() == i3) {
            return i;
        }
        m9162a(this.f7957a, i2, i3);
        return true;
    }

    /* renamed from: a */
    private static void m9162a(View view, int i, int i2) {
        if (C0517s.m1724r(view)) {
            C0517s.m1690a(view, C0517s.m1713g(view), i, C0517s.m1714h(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    /* renamed from: a */
    public void mo42a(int i, int i2) {
        this.f7957a.setAlpha(0.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.f7957a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f7958b.getVisibility() == 0) {
            this.f7958b.setAlpha(0.0f);
            this.f7958b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    /* renamed from: b */
    public void mo43b(int i, int i2) {
        this.f7957a.setAlpha(1.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.f7957a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f7958b.getVisibility() == 0) {
            this.f7958b.setAlpha(1.0f);
            this.f7958b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
