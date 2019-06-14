package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ao.C0757a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements ao {
    /* renamed from: a */
    private C0757a f8622a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0757a c0757a) {
        this.f8622a = c0757a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f8622a != null) {
            this.f8622a.mo375a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
