package com.facebook.ads.internal.view.component.p116a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.C1604f;
import com.facebook.ads.internal.view.component.C1606h;

/* renamed from: com.facebook.ads.internal.view.component.a.f */
final class C1598f extends RelativeLayout {
    /* renamed from: a */
    private final View f4784a;
    /* renamed from: b */
    private final C1604f f4785b;

    public C1598f(Context context, View view) {
        super(context);
        this.f4784a = view;
        this.f4785b = new C1604f(context);
        C1523w.m5341a(this.f4785b);
    }

    /* renamed from: a */
    public void m5575a(int i) {
        this.f4784a.setLayoutParams(new LayoutParams(-1, i));
    }

    /* renamed from: a */
    public void m5576a(View view, View view2, C1606h c1606h, boolean z) {
        ViewGroup.LayoutParams layoutParams;
        this.f4785b.addView(this.f4784a, new LayoutParams(-1, -2));
        if (view2 != null) {
            layoutParams = new LayoutParams(C1593b.f4756b, C1593b.f4756b);
            layoutParams.addRule(6, this.f4784a.getId());
            layoutParams.addRule(7, this.f4784a.getId());
            layoutParams.setMargins(C1593b.f4755a, C1593b.f4755a, C1593b.f4755a, C1593b.f4755a);
            this.f4785b.addView(view2, layoutParams);
        }
        view2 = new LinearLayout(getContext());
        view2.setOrientation(1);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(8, this.f4784a.getId());
        if (c1606h != null) {
            ViewGroup.LayoutParams layoutParams2;
            if (z) {
                layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                c1606h.setAlignment(3);
                layoutParams2.setMargins(C1593b.f4755a / 2, C1593b.f4755a / 2, C1593b.f4755a / 2, C1593b.f4755a / 2);
                view2.addView(c1606h, layoutParams2);
                Drawable gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
                gradientDrawable.setCornerRadius(0.0f);
                gradientDrawable.setGradientType(0);
                C1523w.m5343a(view2, gradientDrawable);
            } else {
                layoutParams2 = new LayoutParams(-1, -2);
                layoutParams2.addRule(3, this.f4785b.getId());
                layoutParams2.setMargins(0, C1593b.f4755a, 0, 0);
                c1606h.setAlignment(17);
                addView(c1606h, layoutParams2);
            }
        }
        if (view != null) {
            view2.addView(view, new LayoutParams(-1, -2));
        }
        this.f4785b.addView(view2, layoutParams);
        addView(this.f4785b, new LayoutParams(-1, -2));
    }
}
