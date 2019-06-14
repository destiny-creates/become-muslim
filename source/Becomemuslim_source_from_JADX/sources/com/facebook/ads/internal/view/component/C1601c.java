package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdIconView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1668m;
import com.facebook.ads.internal.view.C1674q;

/* renamed from: com.facebook.ads.internal.view.component.c */
public class C1601c extends LinearLayout {
    /* renamed from: a */
    private AdIconView f4798a;
    /* renamed from: b */
    private C1600b f4799b;
    /* renamed from: c */
    private TextView f4800c;
    /* renamed from: d */
    private LinearLayout f4801d = new LinearLayout(getContext());

    public C1601c(Context context, C1425f c1425f, C1429k c1429k, AdIconView adIconView, boolean z, int i) {
        C1429k c1429k2 = c1429k;
        boolean z2 = z;
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.f4801d.setOrientation(0);
        this.f4801d.setGravity(16);
        layoutParams.weight = 3.0f;
        this.f4801d.setLayoutParams(layoutParams);
        linearLayout.addView(this.f4801d);
        this.f4798a = adIconView;
        float a = (float) m5584a(z2, i);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Math.round(displayMetrics.density * a), Math.round(a * displayMetrics.density));
        layoutParams2.setMargins(0, 0, Math.round(displayMetrics.density * 15.0f), 0);
        this.f4798a.setLayoutParams(layoutParams2);
        this.f4801d.addView(this.f4798a);
        View linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        this.f4801d.addView(linearLayout2);
        this.f4799b = new C1600b(getContext(), c1425f, c1429k2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(0, 0, Math.round(displayMetrics.density * 15.0f), 0);
        layoutParams3.weight = 0.5f;
        this.f4799b.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f4799b);
        this.f4800c = new TextView(getContext());
        this.f4800c.setPadding(Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f));
        this.f4800c.setText(c1425f.m5011q());
        this.f4800c.setTextColor(c1429k.m5041f());
        this.f4800c.setTextSize(14.0f);
        this.f4800c.setTypeface(c1429k.m5028a(), 1);
        this.f4800c.setMaxLines(2);
        this.f4800c.setEllipsize(TruncateAt.END);
        this.f4800c.setGravity(17);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(c1429k.m5039e());
        gradientDrawable.setCornerRadius(displayMetrics.density * 5.0f);
        gradientDrawable.setStroke(1, c1429k.m5043g());
        C1523w.m5343a(this.f4800c, gradientDrawable);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 0.25f;
        this.f4800c.setLayoutParams(layoutParams4);
        if (!c1425f.m5003i()) {
            r0.f4800c.setVisibility(4);
        }
        linearLayout2.addView(r0.f4800c);
        if (z2) {
            View c1674q = new C1674q(getContext());
            c1674q.setText(c1425f.m5009o());
            C1668m.m5652b(c1674q, c1429k2);
            c1674q.setMinTextSize((float) (c1429k.m5045i() - 1));
            LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams5.weight = 1.0f;
            c1674q.setLayoutParams(layoutParams5);
            c1674q.setGravity(80);
            linearLayout.addView(c1674q);
        }
    }

    /* renamed from: a */
    private int m5584a(boolean z, int i) {
        return (int) (((double) (i - 30)) * (3.0d / ((double) (z + 3))));
    }

    public TextView getCallToActionView() {
        return this.f4800c;
    }

    public AdIconView getIconView() {
        return this.f4798a;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        TextView titleTextView = this.f4799b.getTitleTextView();
        if (titleTextView.getLayout().getLineEnd(titleTextView.getLineCount() - 1) < this.f4799b.getMinVisibleTitleCharacters()) {
            this.f4801d.removeView(this.f4798a);
            super.onMeasure(i, i2);
        }
    }
}
