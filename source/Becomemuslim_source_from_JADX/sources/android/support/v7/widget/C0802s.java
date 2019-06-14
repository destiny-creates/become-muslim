package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0560n;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: AppCompatPopupWindow */
/* renamed from: android.support.v7.widget.s */
class C0802s extends PopupWindow {
    /* renamed from: a */
    private static final boolean f2238a = (VERSION.SDK_INT < 21);
    /* renamed from: b */
    private boolean f2239b;

    public C0802s(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2931a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m2931a(Context context, AttributeSet attributeSet, int i, int i2) {
        context = bq.m2769a(context, attributeSet, C0590j.PopupWindow, i, i2);
        if (context.m2787g(C0590j.PopupWindow_overlapAnchor) != null) {
            m2932a(context.m2775a(C0590j.PopupWindow_overlapAnchor, (boolean) 0));
        }
        setBackgroundDrawable(context.m2773a(C0590j.PopupWindow_android_popupBackground));
        context.m2774a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2238a && this.f2239b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2238a && this.f2239b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f2238a && this.f2239b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m2932a(boolean z) {
        if (f2238a) {
            this.f2239b = z;
        } else {
            C0560n.m1896a((PopupWindow) this, z);
        }
    }
}
