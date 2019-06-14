package com.stripe.android.view;

import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;

/* compiled from: PaymentFlowPagerEnum */
/* renamed from: com.stripe.android.view.i */
enum C5809i {
    SHIPPING_INFO(C5754i.title_add_an_address, C5752g.activity_enter_shipping_info),
    SHIPPING_METHOD(C5754i.title_select_shipping_method, C5752g.activity_select_shipping_method);
    
    /* renamed from: c */
    private int f19243c;
    /* renamed from: d */
    private int f19244d;

    private C5809i(int i, int i2) {
        this.f19243c = i;
        this.f19244d = i2;
    }

    /* renamed from: a */
    int m24513a() {
        return this.f19243c;
    }

    /* renamed from: b */
    int m24514b() {
        return this.f19244d;
    }
}
