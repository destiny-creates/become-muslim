package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.view.C1668m;
import com.facebook.ads.internal.view.C1673p;

/* renamed from: com.facebook.ads.internal.view.component.b */
public class C1600b extends LinearLayout {
    /* renamed from: a */
    private C1673p f4796a = new C1673p(getContext(), 2);
    /* renamed from: b */
    private int f4797b;

    public C1600b(Context context, C1425f c1425f, C1429k c1429k) {
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        this.f4796a.setMinTextSize((float) (c1429k.m5044h() - 2));
        this.f4796a.setText(c1425f.m5007m());
        C1668m.m5651a(this.f4796a, c1429k);
        this.f4796a.setLayoutParams(new LayoutParams(-2, -2));
        addView(this.f4796a);
        int i = 21;
        if (c1425f.m5007m() != null) {
            i = Math.min(c1425f.m5007m().length(), 21);
        }
        this.f4797b = i;
        addView(C1668m.m5650a(context, c1425f, c1429k));
    }

    public int getMinVisibleTitleCharacters() {
        return this.f4797b;
    }

    public TextView getTitleTextView() {
        return this.f4796a;
    }
}
