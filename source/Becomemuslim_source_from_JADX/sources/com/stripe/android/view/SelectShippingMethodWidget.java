package com.stripe.android.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0701i;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.p285b.C7161h;
import java.util.List;

public class SelectShippingMethodWidget extends FrameLayout {
    /* renamed from: a */
    RecyclerView f19206a;
    /* renamed from: b */
    C7193k f19207b;

    public SelectShippingMethodWidget(Context context) {
        super(context);
        m24477a();
    }

    public SelectShippingMethodWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24477a();
    }

    public SelectShippingMethodWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24477a();
    }

    public C7161h getSelectedShippingMethod() {
        return this.f19207b.m33412a();
    }

    /* renamed from: a */
    public void m24478a(List<C7161h> list, C7161h c7161h) {
        this.f19207b.m33416a((List) list, c7161h);
    }

    /* renamed from: a */
    private void m24477a() {
        inflate(getContext(), C5752g.select_shipping_method_widget, this);
        this.f19206a = (RecyclerView) findViewById(C5750e.rv_shipping_methods_ssmw);
        C0701i linearLayoutManager = new LinearLayoutManager(getContext());
        this.f19207b = new C7193k();
        this.f19206a.setHasFixedSize(true);
        this.f19206a.setAdapter(this.f19207b);
        this.f19206a.setLayoutManager(linearLayoutManager);
    }
}
