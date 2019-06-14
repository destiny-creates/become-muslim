package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ao.C0757a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements ao {
    /* renamed from: a */
    private C0757a f8621a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0757a c0757a) {
        this.f8621a = c0757a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f8621a != null) {
            this.f8621a.mo375a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
