package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.p105q.p106a.C1507j;

/* renamed from: com.facebook.ads.internal.view.l */
public class C3693l extends C1426g {
    /* renamed from: a */
    private C1676s f9905a;

    public C3693l(Context context) {
        super(context);
        this.f9905a = new C1676s(context);
        this.f9905a.setScaleType(ScaleType.CENTER_CROP);
        C1507j.m5304a(this.f9905a, C1507j.INTERNAL_AD_MEDIA);
        addView(this.f9905a, new LayoutParams(-1, -1));
    }

    public View getAdContentsView() {
        return this.f9905a;
    }
}
