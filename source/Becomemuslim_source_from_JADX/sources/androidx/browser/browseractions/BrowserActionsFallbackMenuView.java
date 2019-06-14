package androidx.browser.browseractions;

import android.content.Context;
import android.support.p015c.C0113h.C0112a;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class BrowserActionsFallbackMenuView extends LinearLayout {
    /* renamed from: a */
    private final int f2261a = getResources().getDimensionPixelOffset(C0112a.browser_actions_context_menu_min_padding);
    /* renamed from: b */
    private final int f2262b = getResources().getDimensionPixelOffset(C0112a.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f2261a * 2), this.f2262b), 1073741824), i2);
    }
}
