package com.facebook.ads.internal.view.p118d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.C1603e;
import com.facebook.ads.internal.view.component.C1606h;
import com.facebook.ads.internal.view.p113b.C1577d;

/* renamed from: com.facebook.ads.internal.view.d.a */
public class C1607a extends RelativeLayout {
    /* renamed from: a */
    private static final int f4820a = ((int) (C1523w.f4503b * 72.0f));
    /* renamed from: b */
    private static final int f4821b = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: c */
    private static final LayoutParams f4822c = new LayoutParams(-1, -1);
    /* renamed from: d */
    private final C1321k f4823d;

    public C1607a(Context context, C1321k c1321k) {
        super(context);
        this.f4823d = c1321k;
        m5587a();
    }

    /* renamed from: a */
    private void m5587a() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        ImageView c1603e = new C1603e(getContext());
        C1523w.m5342a((View) c1603e, 0);
        c1603e.setRadius(50);
        new C1577d(c1603e).m5504a().m5508a(this.f4823d.m4556a().m4546b());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(f4820a, f4820a);
        View c1606h = new C1606h(getContext(), this.f4823d.m4562d().m4463a(), true, false, true);
        c1606h.m5586a(this.f4823d.m4559b().m4502a(), this.f4823d.m4559b().m4503b(), false, true);
        c1606h.setAlignment(17);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, f4821b, 0, f4821b);
        View textView = new TextView(getContext());
        textView.setTextColor(-1);
        C1523w.m5344a(textView, false, 16);
        textView.setText(this.f4823d.m4563e().m4494j().m4551c());
        textView.setPadding(f4821b, f4821b / 2, f4821b, f4821b / 2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, f4821b / 2, 0, 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(100.0f);
        gradientDrawable.setColor(469762047);
        C1523w.m5343a(textView, gradientDrawable);
        linearLayout.addView(c1603e, layoutParams);
        linearLayout.addView(c1606h, layoutParams2);
        linearLayout.addView(textView, layoutParams3);
        C1523w.m5342a((View) this, -14473425);
        addView(linearLayout, f4822c);
    }
}
