package com.google.android.gms.ads.p170d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.internal.ads.arf;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mt;

@cm
/* renamed from: com.google.android.gms.ads.d.b */
public final class C2630b extends ViewGroup {
    /* renamed from: a */
    private final arf f6668a;

    public final C2603a getAdListener() {
        return this.f6668a.b();
    }

    public final C2631d getAdSize() {
        return this.f6668a.c();
    }

    public final String getAdUnitId() {
        return this.f6668a.e();
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
        this.f6668a.a(c2603a);
    }

    public final void setAdSize(C2631d c2631d) {
        this.f6668a.a(new C2631d[]{c2631d});
    }

    public final void setAdUnitId(String str) {
        this.f6668a.a(str);
    }
}
