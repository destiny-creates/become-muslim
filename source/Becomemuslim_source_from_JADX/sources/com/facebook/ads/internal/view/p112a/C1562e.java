package com.facebook.ads.internal.view.p112a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p105q.p107b.C1527b;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.common.util.UriUtil;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.e */
public class C1562e extends LinearLayout {
    /* renamed from: a */
    private TextView f4671a;
    /* renamed from: b */
    private TextView f4672b;
    /* renamed from: c */
    private Drawable f4673c;

    public C1562e(Context context) {
        super(context);
        m5471a();
    }

    /* renamed from: a */
    private void m5471a() {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.f4671a = new TextView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f4671a.setTextColor(-16777216);
        this.f4671a.setTextSize(2, 20.0f);
        this.f4671a.setEllipsize(TruncateAt.END);
        this.f4671a.setSingleLine(true);
        this.f4671a.setVisibility(8);
        addView(this.f4671a, layoutParams);
        this.f4672b = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f4672b.setAlpha(0.5f);
        this.f4672b.setTextColor(-16777216);
        this.f4672b.setTextSize(2, 15.0f);
        this.f4672b.setCompoundDrawablePadding((int) (f * 5.0f));
        this.f4672b.setEllipsize(TruncateAt.END);
        this.f4672b.setSingleLine(true);
        this.f4672b.setVisibility(8);
        addView(this.f4672b, layoutParams);
    }

    private Drawable getPadlockDrawable() {
        if (this.f4673c == null) {
            this.f4673c = C1528c.m5357a(getContext(), C1527b.BROWSER_PADLOCK);
        }
        return this.f4673c;
    }

    public void setSubtitle(String str) {
        TextView textView;
        int i;
        if (TextUtils.isEmpty(str)) {
            this.f4672b.setText(null);
            textView = this.f4672b;
            i = 8;
        } else {
            Uri parse = Uri.parse(str);
            this.f4672b.setText(parse.getHost());
            this.f4672b.setCompoundDrawablesRelativeWithIntrinsicBounds(UriUtil.HTTPS_SCHEME.equals(parse.getScheme()) ? getPadlockDrawable() : null, null, null, null);
            textView = this.f4672b;
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void setTitle(String str) {
        TextView textView;
        int i;
        if (TextUtils.isEmpty(str)) {
            this.f4671a.setText(null);
            textView = this.f4671a;
            i = 8;
        } else {
            this.f4671a.setText(str);
            textView = this.f4671a;
            i = 0;
        }
        textView.setVisibility(i);
    }
}
