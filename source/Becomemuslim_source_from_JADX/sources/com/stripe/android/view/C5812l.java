package com.stripe.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stripe.android.C5756m.C5747b;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.p285b.C7161h;

/* compiled from: ShippingMethodView */
/* renamed from: com.stripe.android.view.l */
class C5812l extends RelativeLayout {
    /* renamed from: a */
    int f19247a;
    /* renamed from: b */
    int f19248b;
    /* renamed from: c */
    int f19249c;
    /* renamed from: d */
    private C7161h f19250d;
    /* renamed from: e */
    private TextView f19251e;
    /* renamed from: f */
    private TextView f19252f;
    /* renamed from: g */
    private TextView f19253g;
    /* renamed from: h */
    private ImageView f19254h;

    C5812l(Context context) {
        super(context);
        m24517a();
    }

    public void setSelected(boolean z) {
        if (z) {
            this.f19251e.setTextColor(this.f19247a);
            this.f19252f.setTextColor(this.f19247a);
            this.f19253g.setTextColor(this.f19247a);
            this.f19254h.setVisibility(0);
            return;
        }
        this.f19251e.setTextColor(this.f19249c);
        this.f19252f.setTextColor(this.f19248b);
        this.f19253g.setTextColor(this.f19249c);
        this.f19254h.setVisibility(4);
    }

    /* renamed from: a */
    private void m24517a() {
        C5812l.inflate(getContext(), C5752g.shipping_method_view, this);
        this.f19251e = (TextView) findViewById(C5750e.tv_label_smv);
        this.f19252f = (TextView) findViewById(C5750e.tv_detail_smv);
        this.f19253g = (TextView) findViewById(C5750e.tv_amount_smv);
        this.f19254h = (ImageView) findViewById(C5750e.iv_selected_icon);
        this.f19247a = C5816n.m24523a(getContext()).data;
        this.f19249c = C5816n.m24530d(getContext()).data;
        this.f19248b = C5816n.m24529c(getContext()).data;
        m24518b();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(16);
        layoutParams.height = C5816n.m24521a(getContext(), 72);
        setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m24518b() {
        Resources resources = getResources();
        Context context = getContext();
        if (VERSION.SDK_INT >= 23) {
            this.f19247a = C5816n.m24524a(this.f19247a) ? resources.getColor(C5747b.accent_color_default, context.getTheme()) : this.f19247a;
            this.f19249c = C5816n.m24524a(this.f19249c) ? resources.getColor(C5747b.color_text_unselected_primary_default, context.getTheme()) : this.f19249c;
            this.f19248b = C5816n.m24524a(this.f19248b) ? resources.getColor(C5747b.color_text_unselected_secondary_default, context.getTheme()) : this.f19248b;
            return;
        }
        this.f19247a = C5816n.m24524a(this.f19247a) ? resources.getColor(C5747b.accent_color_default) : this.f19247a;
        this.f19249c = C5816n.m24524a(this.f19249c) ? resources.getColor(C5747b.color_text_unselected_primary_default) : this.f19249c;
        this.f19248b = C5816n.m24524a(this.f19248b) ? resources.getColor(C5747b.color_text_unselected_secondary_default) : this.f19248b;
    }

    /* renamed from: a */
    void m24519a(C7161h c7161h) {
        this.f19250d = c7161h;
        this.f19251e.setText(this.f19250d.m33272e());
        this.f19252f.setText(this.f19250d.m33273f());
        this.f19253g.setText(C5810j.m24516a(this.f19250d.m33271d(), this.f19250d.m33270c(), getContext().getString(C5754i.price_free)));
    }
}
