package com.facebook.ads.internal.view.p114c;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.p086a.C1319i;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.C1603e;
import com.facebook.ads.internal.view.p113b.C1577d;

/* renamed from: com.facebook.ads.internal.view.c.c */
public class C1586c extends LinearLayout {
    /* renamed from: a */
    private C1603e f4743a;
    /* renamed from: b */
    private TextView f4744b;
    /* renamed from: c */
    private TextView f4745c;

    public C1586c(Context context) {
        super(context);
        m5526a(context);
    }

    /* renamed from: a */
    public void m5525a(int i, int i2) {
        this.f4744b.setTextColor(i);
        this.f4745c.setTextColor(i2);
    }

    /* renamed from: a */
    public void m5526a(Context context) {
        int i = (int) (C1523w.f4503b * 32.0f);
        setGravity(16);
        this.f4743a = new C1603e(context);
        this.f4743a.setFullCircleCorners(true);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.setMargins(0, 0, (int) (C1523w.f4503b * 8.0f), 0);
        addView(this.f4743a, layoutParams);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.f4744b = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        C1523w.m5344a(this.f4744b, true, 16);
        this.f4744b.setEllipsize(TruncateAt.END);
        this.f4744b.setSingleLine(true);
        this.f4745c = new TextView(context);
        C1523w.m5344a(this.f4745c, false, 14);
        linearLayout.addView(this.f4744b);
        linearLayout.addView(this.f4745c);
        addView(linearLayout, layoutParams);
    }

    public void setPageDetails(C1319i c1319i) {
        C1577d c1577d = new C1577d(this.f4743a);
        c1577d.m5505a((int) (C1523w.f4503b * 32.0f), (int) (C1523w.f4503b * 32.0f));
        c1577d.m5508a(c1319i.m4546b());
        this.f4744b.setText(c1319i.m4545a());
        this.f4745c.setText(c1319i.m4548d());
    }
}
