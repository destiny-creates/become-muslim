package com.facebook.ads.internal.p099n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AdIconView;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1675r;
import com.facebook.ads.internal.view.component.C1601c;
import com.facebook.ads.internal.view.component.C1605g;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.internal.n.a */
public class C1416a {
    /* renamed from: a */
    private static final float f4152a = C1523w.f4503b;
    /* renamed from: b */
    private final C1429k f4153b;
    /* renamed from: c */
    private final C1425f f4154c;
    /* renamed from: d */
    private final RelativeLayout f4155d;
    /* renamed from: e */
    private ArrayList<View> f4156e = new ArrayList();

    public C1416a(Context context, C1425f c1425f, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, MediaView mediaView, AdIconView adIconView, C1430l c1430l, C1429k c1429k) {
        C1426g c1426g;
        this.f4155d = relativeLayout;
        C1523w.m5342a(this.f4155d, c1429k.m5032b());
        this.f4153b = c1429k;
        this.f4154c = c1425f;
        this.f4155d.setLayoutParams(new LayoutParams(-1, Math.round(((float) c1430l.m5049b()) * f4152a)));
        View c1675r = new C1675r(context);
        c1675r.setMinWidth(Math.round(f4152a * 280.0f));
        c1675r.setMaxWidth(Math.round(f4152a * 375.0f));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        c1675r.setLayoutParams(layoutParams);
        this.f4155d.addView(c1675r);
        ViewGroup linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        c1675r.addView(linearLayout);
        switch (c1430l) {
            case HEIGHT_400:
                m4897a(linearLayout);
                break;
            case HEIGHT_300:
                break;
            default:
                break;
        }
        m4898a(linearLayout, mediaView);
        m4899a(linearLayout, c1430l, adIconView);
        View view = this.f4155d;
        if (mediaView == null) {
            c1426g = adIconView;
        }
        c1425f.m4984a(view, c1426g, this.f4156e);
        LayoutParams layoutParams2 = (LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams2.addRule(11);
        layoutParams2.setMargins(Math.round(f4152a * 4.0f), Math.round(f4152a * 4.0f), Math.round(f4152a * 4.0f), Math.round(f4152a * 4.0f));
        c1675r.addView(relativeLayout2);
    }

    /* renamed from: a */
    private void m4897a(ViewGroup viewGroup) {
        View c1605g = new C1605g(this.f4155d.getContext(), this.f4154c, this.f4153b);
        c1605g.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(f4152a * 110.0f)));
        viewGroup.addView(c1605g);
    }

    /* renamed from: a */
    private void m4898a(ViewGroup viewGroup, RelativeLayout relativeLayout) {
        View relativeLayout2 = new RelativeLayout(this.f4155d.getContext());
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(f4152a * 180.0f)));
        C1523w.m5342a(relativeLayout2, this.f4153b.m5032b());
        relativeLayout2.addView(relativeLayout);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, (int) (f4152a * 180.0f));
        layoutParams.addRule(13, -1);
        relativeLayout.setLayoutParams(layoutParams);
        viewGroup.addView(relativeLayout2);
        this.f4156e.add(relativeLayout);
    }

    /* renamed from: a */
    private void m4899a(ViewGroup viewGroup, C1430l c1430l, AdIconView adIconView) {
        View c1601c = new C1601c(this.f4155d.getContext(), this.f4154c, this.f4153b, adIconView, m4900a(c1430l), m4901b(c1430l));
        c1601c.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(((float) m4901b(c1430l)) * f4152a)));
        viewGroup.addView(c1601c);
        this.f4156e.add(c1601c.getIconView());
        this.f4156e.add(c1601c.getCallToActionView());
    }

    /* renamed from: a */
    private boolean m4900a(C1430l c1430l) {
        if (c1430l != C1430l.HEIGHT_300) {
            if (c1430l != C1430l.HEIGHT_120) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private int m4901b(C1430l c1430l) {
        switch (c1430l) {
            case HEIGHT_400:
                return (c1430l.m5049b() - 180) / 2;
            case HEIGHT_300:
                return c1430l.m5049b() - 180;
            case HEIGHT_100:
            case HEIGHT_120:
                return c1430l.m5049b();
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public void m4902a() {
        this.f4154c.m4980J();
    }
}
