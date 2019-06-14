package com.google.android.gms.ads.p167a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C2633g;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.C2679l;
import com.google.android.gms.internal.ads.arf;
import com.google.android.gms.internal.ads.mt;

/* renamed from: com.google.android.gms.ads.a.e */
public final class C2600e extends ViewGroup {
    /* renamed from: a */
    private final arf f6642a = new arf(this);

    public C2600e(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void m7342a() {
        this.f6642a.a();
    }

    /* renamed from: a */
    public final void m7343a(C2599d c2599d) {
        this.f6642a.a(c2599d.m7341a());
    }

    public final C2603a getAdListener() {
        return this.f6642a.b();
    }

    public final C2631d getAdSize() {
        return this.f6642a.c();
    }

    public final C2631d[] getAdSizes() {
        return this.f6642a.d();
    }

    public final String getAdUnitId() {
        return this.f6642a.e();
    }

    public final C2595a getAppEventListener() {
        return this.f6642a.f();
    }

    public final String getMediationAdapterClassName() {
        return this.f6642a.j();
    }

    public final C2597c getOnCustomRenderedAdLoadedListener() {
        return this.f6642a.g();
    }

    public final C2678k getVideoController() {
        return this.f6642a.k();
    }

    public final C2679l getVideoOptions() {
        return this.f6642a.m();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i3 = ((i3 - i) - measuredWidth) / 2;
            i4 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
    }

    protected final void onMeasure(int i, int i2) {
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

    public final void setAdListener(C2603a c2603a) {
        this.f6642a.a(c2603a);
    }

    public final void setAdSizes(C2631d... c2631dArr) {
        if (c2631dArr == null || c2631dArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f6642a.b(c2631dArr);
    }

    public final void setAdUnitId(String str) {
        this.f6642a.a(str);
    }

    public final void setAppEventListener(C2595a c2595a) {
        this.f6642a.a(c2595a);
    }

    public final void setCorrelator(C2633g c2633g) {
        this.f6642a.a(c2633g);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f6642a.a(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(C2597c c2597c) {
        this.f6642a.a(c2597c);
    }

    public final void setVideoOptions(C2679l c2679l) {
        this.f6642a.a(c2679l);
    }
}
