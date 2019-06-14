package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1429k;

/* renamed from: com.facebook.ads.internal.view.m */
public abstract class C1668m {
    /* renamed from: a */
    public static LinearLayout m5650a(Context context, C1425f c1425f, C1429k c1429k) {
        LinearLayout linearLayout = new LinearLayout(context);
        View c1674q = new C1674q(context);
        c1674q.setText(c1425f.m5012r());
        C1668m.m5652b(c1674q, c1429k);
        linearLayout.addView(c1674q);
        return linearLayout;
    }

    /* renamed from: a */
    public static void m5651a(TextView textView, C1429k c1429k) {
        textView.setTextColor(c1429k.m5035c());
        textView.setTextSize((float) c1429k.m5044h());
        textView.setTypeface(c1429k.m5028a(), 1);
    }

    /* renamed from: b */
    public static void m5652b(TextView textView, C1429k c1429k) {
        textView.setTextColor(c1429k.m5037d());
        textView.setTextSize((float) c1429k.m5045i());
        textView.setTypeface(c1429k.m5028a());
    }
}
