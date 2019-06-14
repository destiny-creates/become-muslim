package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.p167a.C2595a;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.arf;
import com.google.android.gms.internal.ads.mt;

/* renamed from: com.google.android.gms.ads.f */
class C2632f extends ViewGroup {
    /* renamed from: a */
    protected final arf f6682a;

    public C2632f(Context context, int i) {
        super(context);
        this.f6682a = new arf(this, i);
    }

    /* renamed from: a */
    public void mo2342a() {
        this.f6682a.i();
    }

    /* renamed from: a */
    public void mo2343a(C2628c c2628c) {
        this.f6682a.a(c2628c.m7408a());
    }

    /* renamed from: b */
    public void mo2344b() {
        this.f6682a.h();
    }

    /* renamed from: c */
    public void mo2345c() {
        this.f6682a.a();
    }

    public C2603a getAdListener() {
        return this.f6682a.b();
    }

    public C2631d getAdSize() {
        return this.f6682a.c();
    }

    public String getAdUnitId() {
        return this.f6682a.e();
    }

    public String getMediationAdapterClassName() {
        return this.f6682a.j();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i3 = ((i3 - i) - measuredWidth) / 2;
            i4 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        int a;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            C2631d c2631d = null;
            try {
                c2631d = getAdSize();
            } catch (Throwable e) {
                mt.b("Unable to retrieve ad size.", e);
            }
            if (c2631d != null) {
                Context context = getContext();
                int b = c2631d.m7413b(context);
                a = c2631d.m7411a(context);
                i3 = b;
            } else {
                a = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            a = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(a, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(C2603a c2603a) {
        this.f6682a.a(c2603a);
        if (c2603a == null) {
            this.f6682a.a(null);
            this.f6682a.a(null);
            return;
        }
        if (c2603a instanceof aok) {
            this.f6682a.a((aok) c2603a);
        }
        if (c2603a instanceof C2595a) {
            this.f6682a.a((C2595a) c2603a);
        }
    }

    public void setAdSize(C2631d c2631d) {
        this.f6682a.a(new C2631d[]{c2631d});
    }

    public void setAdUnitId(String str) {
        this.f6682a.a(str);
    }
}
