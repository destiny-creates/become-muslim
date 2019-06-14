package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.p035a.C0591a.C0589i;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

/* compiled from: TooltipPopup */
class bu {
    /* renamed from: a */
    private final Context f2154a;
    /* renamed from: b */
    private final View f2155b;
    /* renamed from: c */
    private final TextView f2156c;
    /* renamed from: d */
    private final LayoutParams f2157d = new LayoutParams();
    /* renamed from: e */
    private final Rect f2158e = new Rect();
    /* renamed from: f */
    private final int[] f2159f = new int[2];
    /* renamed from: g */
    private final int[] f2160g = new int[2];

    bu(Context context) {
        this.f2154a = context;
        this.f2155b = LayoutInflater.from(this.f2154a).inflate(C0587g.abc_tooltip, null);
        this.f2156c = (TextView) this.f2155b.findViewById(C0586f.message);
        this.f2157d.setTitle(getClass().getSimpleName());
        this.f2157d.packageName = this.f2154a.getPackageName();
        this.f2157d.type = 1002;
        this.f2157d.width = -2;
        this.f2157d.height = -2;
        this.f2157d.format = -3;
        this.f2157d.windowAnimations = C0589i.Animation_AppCompat_Tooltip;
        this.f2157d.flags = 24;
    }

    /* renamed from: a */
    void m2800a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m2801b()) {
            m2799a();
        }
        this.f2156c.setText(charSequence);
        m2798a(view, i, i2, z, this.f2157d);
        ((WindowManager) this.f2154a.getSystemService("window")).addView(this.f2155b, this.f2157d);
    }

    /* renamed from: a */
    void m2799a() {
        if (m2801b()) {
            ((WindowManager) this.f2154a.getSystemService("window")).removeView(this.f2155b);
        }
    }

    /* renamed from: b */
    boolean m2801b() {
        return this.f2155b.getParent() != null;
    }

    /* renamed from: a */
    private void m2798a(View view, int i, int i2, boolean z, LayoutParams layoutParams) {
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2154a.getResources().getDimensionPixelOffset(C0584d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            dimensionPixelOffset = this.f2154a.getResources().getDimensionPixelOffset(C0584d.tooltip_precise_anchor_extra_offset);
            i3 = i2 + dimensionPixelOffset;
            i2 -= dimensionPixelOffset;
        } else {
            i3 = view.getHeight();
            i2 = 0;
        }
        layoutParams.gravity = 49;
        dimensionPixelOffset = this.f2154a.getResources().getDimensionPixelOffset(z ? C0584d.tooltip_y_offset_touch : C0584d.tooltip_y_offset_non_touch);
        View a = m2797a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.f2158e);
        if (this.f2158e.left < 0 && this.f2158e.top < 0) {
            Resources resources = this.f2154a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            identifier = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f2158e.set(0, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.f2160g);
        view.getLocationOnScreen(this.f2159f);
        view = this.f2159f;
        view[0] = view[0] - this.f2160g[0];
        view = this.f2159f;
        view[1] = view[1] - this.f2160g[1];
        layoutParams.x = (this.f2159f[0] + i) - (a.getWidth() / 2);
        view = MeasureSpec.makeMeasureSpec(0, 0);
        this.f2155b.measure(view, view);
        view = this.f2155b.getMeasuredHeight();
        i = ((this.f2159f[1] + i2) - dimensionPixelOffset) - view;
        i2 = (this.f2159f[1] + i3) + dimensionPixelOffset;
        if (z) {
            if (i >= 0) {
                layoutParams.y = i;
            } else {
                layoutParams.y = i2;
            }
        } else if (view + i2 <= this.f2158e.height()) {
            layoutParams.y = i2;
        } else {
            layoutParams.y = i;
        }
    }

    /* renamed from: a */
    private static View m2797a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (view = view.getContext(); view instanceof ContextWrapper; view = ((ContextWrapper) view).getBaseContext()) {
            if (view instanceof Activity) {
                return ((Activity) view).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
