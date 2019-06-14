package com.facebook.ads.internal.view.p119e;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.view.component.C1604f;
import com.facebook.ads.internal.view.p113b.C1577d;

/* renamed from: com.facebook.ads.internal.view.e.d */
class C3636d extends C1604f {
    /* renamed from: a */
    private final ImageView f9735a;

    public C3636d(Context context) {
        super(context);
        this.f9735a = new ImageView(context);
        this.f9735a.setAdjustViewBounds(true);
        addView(this.f9735a, new LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public void m11880a(String str) {
        C1577d c1577d = new C1577d(this.f9735a);
        c1577d.m5504a();
        c1577d.m5508a(str);
    }
}
