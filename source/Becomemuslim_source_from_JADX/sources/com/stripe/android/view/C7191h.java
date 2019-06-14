package com.stripe.android.view;

import android.content.Context;
import android.support.v4.view.C0513q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stripe.android.C5742j;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C7169b;
import com.stripe.android.p285b.C7161h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PaymentFlowPagerAdapter */
/* renamed from: com.stripe.android.view.h */
class C7191h extends C0513q {
    /* renamed from: a */
    private Context f25456a;
    /* renamed from: b */
    private C5742j f25457b;
    /* renamed from: c */
    private List<C5809i> f25458c;
    /* renamed from: d */
    private boolean f25459d;
    /* renamed from: e */
    private List<C7161h> f25460e = new ArrayList();
    /* renamed from: f */
    private C7161h f25461f;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    C7191h(Context context, C5742j c5742j) {
        this.f25456a = context;
        this.f25457b = c5742j;
        this.f25458c = new ArrayList();
        if (this.f25457b.m24314d() != null) {
            this.f25458c.add(C5809i.SHIPPING_INFO);
        }
        if (m33404b() != null) {
            this.f25458c.add(C5809i.SHIPPING_METHOD);
        }
    }

    /* renamed from: b */
    private boolean m33404b() {
        return this.f25457b.m24315e() && ((!this.f25457b.m24314d() || this.f25459d) && !this.f25458c.contains(C5809i.SHIPPING_METHOD));
    }

    /* renamed from: a */
    void m33408a(boolean z) {
        this.f25459d = z;
        if (m33404b()) {
            this.f25458c.add(C5809i.SHIPPING_METHOD);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    void m33407a(List<C7161h> list, C7161h c7161h) {
        this.f25460e = list;
        this.f25461f = c7161h;
    }

    /* renamed from: a */
    void m33406a() {
        this.f25458c.remove(C5809i.SHIPPING_METHOD);
        notifyDataSetChanged();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C5809i c5809i = (C5809i) this.f25458c.get(i);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f25456a).inflate(c5809i.m24514b(), viewGroup, false);
        if (c5809i.equals(C5809i.SHIPPING_METHOD)) {
            C7169b.m33350a().m33367a("ShippingMethodScreen");
            ((SelectShippingMethodWidget) viewGroup2.findViewById(C5750e.select_shipping_method_widget)).m24478a(this.f25460e, this.f25461f);
        }
        if (c5809i.equals(C5809i.SHIPPING_INFO) != 0) {
            C7169b.m33350a().m33367a("ShippingInfoScreen");
            ShippingInfoWidget shippingInfoWidget = (ShippingInfoWidget) viewGroup2.findViewById(C5750e.shipping_info_widget);
            shippingInfoWidget.setHiddenFields(this.f25457b.m24311a());
            shippingInfoWidget.setOptionalFields(this.f25457b.m24312b());
            shippingInfoWidget.m24490a(this.f25457b.m24313c());
        }
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.f25458c.size();
    }

    /* renamed from: a */
    C5809i m33405a(int i) {
        return i < this.f25458c.size() ? (C5809i) this.f25458c.get(i) : 0;
    }

    public CharSequence getPageTitle(int i) {
        return this.f25456a.getString(((C5809i) this.f25458c.get(i)).m24513a());
    }
}
