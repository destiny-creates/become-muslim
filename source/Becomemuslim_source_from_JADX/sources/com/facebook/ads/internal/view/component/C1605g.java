package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1668m;

/* renamed from: com.facebook.ads.internal.view.component.g */
public class C1605g extends LinearLayout {
    public C1605g(Context context, C1425f c1425f, C1429k c1429k) {
        super(context);
        float f = C1523w.f4503b;
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setVerticalGravity(16);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        f *= 15.0f;
        layoutParams.setMargins(Math.round(f), Math.round(f), Math.round(f), Math.round(f));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        CharSequence n = c1425f.m5008n();
        View textView = new TextView(getContext());
        if (TextUtils.isEmpty(n)) {
            n = c1425f.m5007m();
        }
        textView.setText(n);
        C1668m.m5651a(textView, c1429k);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine(true);
        linearLayout.addView(textView);
        View textView2 = new TextView(getContext());
        textView2.setText(c1425f.m5009o());
        C1668m.m5652b(textView2, c1429k);
        textView2.setEllipsize(TruncateAt.END);
        textView2.setMaxLines(2);
        linearLayout.addView(textView2);
    }
}
