package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.component.h */
public class C1606h extends LinearLayout {
    /* renamed from: a */
    private static final float f4815a = Resources.getSystem().getDisplayMetrics().density;
    /* renamed from: b */
    private static final int f4816b = ((int) (f4815a * 6.0f));
    /* renamed from: c */
    private static final int f4817c = ((int) (f4815a * 8.0f));
    /* renamed from: d */
    private final TextView f4818d;
    /* renamed from: e */
    private final TextView f4819e;

    public C1606h(Context context, C1312d c1312d, boolean z, boolean z2, boolean z3) {
        super(context);
        setOrientation(1);
        this.f4818d = new TextView(context);
        C1523w.m5344a(this.f4818d, true, z2 ? 18 : 22);
        this.f4818d.setTextColor(c1312d.m4508c(z));
        this.f4818d.setEllipsize(TruncateAt.END);
        this.f4818d.setLineSpacing((float) f4816b, 1.0f);
        this.f4819e = new TextView(context);
        C1523w.m5344a(this.f4819e, false, z2 ? 14 : 16);
        this.f4819e.setTextColor(c1312d.m4507b(z));
        this.f4819e.setEllipsize(TruncateAt.END);
        this.f4819e.setLineSpacing((float) f4816b, 1.0f);
        addView(this.f4818d, new LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(0, z3 ? f4817c / 2 : f4817c, 0, 0);
        addView(this.f4819e, layoutParams);
    }

    /* renamed from: a */
    public void m5586a(String str, String str2, boolean z, boolean z2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        TextView textView;
        int isEmpty = TextUtils.isEmpty(str) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(str2) ^ 1;
        TextView textView2 = this.f4818d;
        if (isEmpty == 0) {
            charSequence = str2;
        }
        textView2.setText(charSequence);
        TextView textView3 = this.f4819e;
        if (isEmpty == 0) {
            charSequence2 = "";
        }
        textView3.setText(charSequence2);
        int i = 3;
        if (isEmpty != 0) {
            if (isEmpty2 != 0) {
                this.f4818d.setMaxLines(z ? 1 : 2);
                textView = this.f4819e;
                if (z) {
                    i = 1;
                } else {
                    if (z2) {
                    }
                    i = 2;
                }
                textView.setMaxLines(i);
            }
        }
        textView = this.f4818d;
        if (!z) {
            if (z2) {
                i = 4;
            }
            textView.setMaxLines(i);
        }
        i = 2;
        textView.setMaxLines(i);
    }

    public void setAlignment(int i) {
        this.f4818d.setGravity(i);
        this.f4819e.setGravity(i);
    }
}
