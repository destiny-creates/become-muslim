package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

@Deprecated
/* compiled from: Space */
/* renamed from: android.support.v4.widget.p */
public class C0561p extends View {
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Deprecated
    public C0561p(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == null) {
            setVisibility(4);
        }
    }

    @Deprecated
    public C0561p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public C0561p(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static int m1897a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            return Math.min(i, i2);
        }
        if (mode == 0) {
            return i;
        }
        if (mode != 1073741824) {
            return i;
        }
        return i2;
    }

    @Deprecated
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(C0561p.m1897a(getSuggestedMinimumWidth(), i), C0561p.m1897a(getSuggestedMinimumHeight(), i2));
    }
}
