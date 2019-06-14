package com.stripe.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.p020a.C0264a;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.C5756m.C5747b;
import com.stripe.android.C5756m.C5748c;
import com.stripe.android.C5756m.C5749d;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5751f;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.p285b.C7159e;
import com.stripe.android.p285b.C7162i;
import com.stripe.android.p285b.C8035j;
import java.util.HashMap;
import java.util.Map;

public class MaskedCardView extends LinearLayout {
    /* renamed from: f */
    static final Map<String, Integer> f19191f = new HashMap();
    /* renamed from: a */
    int f19192a;
    /* renamed from: b */
    int f19193b;
    /* renamed from: c */
    int f19194c;
    /* renamed from: d */
    int f19195d;
    /* renamed from: e */
    int f19196e;
    /* renamed from: g */
    private String f19197g;
    /* renamed from: h */
    private String f19198h;
    /* renamed from: i */
    private boolean f19199i;
    /* renamed from: j */
    private AppCompatImageView f19200j;
    /* renamed from: k */
    private AppCompatTextView f19201k;
    /* renamed from: l */
    private AppCompatImageView f19202l;

    static {
        f19191f.put("American Express", Integer.valueOf(C5749d.ic_amex_template_32));
        f19191f.put("Diners Club", Integer.valueOf(C5749d.ic_diners_template_32));
        f19191f.put("Discover", Integer.valueOf(C5749d.ic_discover_template_32));
        f19191f.put("JCB", Integer.valueOf(C5749d.ic_jcb_template_32));
        f19191f.put("MasterCard", Integer.valueOf(C5749d.ic_mastercard_template_32));
        f19191f.put("Visa", Integer.valueOf(C5749d.ic_visa_template_32));
        f19191f.put(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, Integer.valueOf(C5749d.ic_unknown));
    }

    public MaskedCardView(Context context) {
        super(context);
        m24471b();
    }

    public MaskedCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24471b();
    }

    public MaskedCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24471b();
    }

    public boolean isSelected() {
        return this.f19199i;
    }

    public void setSelected(boolean z) {
        this.f19199i = z;
        m24467f();
        m24465d();
        m24466e();
    }

    void setCard(C7157c c7157c) {
        this.f19197g = c7157c.m33241u();
        this.f19198h = c7157c.m33240t();
        m24465d();
        m24466e();
    }

    void setSourceCardData(C8035j c8035j) {
        this.f19197g = c8035j.m38945c();
        this.f19198h = c8035j.m38946d();
        m24465d();
        m24466e();
    }

    void setCustomerSource(C7159e c7159e) {
        C7162i c = c7159e.m33257c();
        if (c == null || c.m33296p() == null || !"card".equals(c.m33297q()) || !(c.m33296p() instanceof C8035j)) {
            c7159e = c7159e.m33259e();
            if (c7159e != null) {
                setCard(c7159e);
            }
            return;
        }
        setSourceCardData((C8035j) c.m33296p());
    }

    /* renamed from: a */
    void m24470a() {
        setSelected(this.f19199i ^ 1);
    }

    int[] getTextColorValues() {
        return new int[]{this.f19193b, this.f19192a, this.f19196e, this.f19195d};
    }

    String getCardBrand() {
        return this.f19197g;
    }

    String getLast4() {
        return this.f19198h;
    }

    /* renamed from: b */
    void m24471b() {
        inflate(getContext(), C5752g.masked_card_view, this);
        setOrientation(0);
        setMinimumWidth(getResources().getDimensionPixelSize(C5748c.card_widget_min_width));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C5748c.masked_card_vertical_padding);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        this.f19200j = (AppCompatImageView) findViewById(C5750e.masked_icon_view);
        this.f19201k = (AppCompatTextView) findViewById(C5750e.masked_card_info_view);
        this.f19202l = (AppCompatImageView) findViewById(C5750e.masked_check_icon);
        this.f19193b = C5816n.m24523a(getContext()).data;
        this.f19194c = C5816n.m24526b(getContext()).data;
        this.f19196e = C5816n.m24529c(getContext()).data;
        m24468g();
        m24469h();
        m24464c();
        m24467f();
    }

    /* renamed from: c */
    private void m24464c() {
        m24463a(C5749d.ic_checkmark, this.f19202l, true);
    }

    /* renamed from: d */
    private void m24465d() {
        m24463a(((Integer) f19191f.get(this.f19197g)).intValue(), this.f19200j, false);
    }

    /* renamed from: a */
    private void m24463a(int i, ImageView imageView, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            i = getResources().getDrawable(i, imageView.getContext().getTheme());
        } else {
            i = getResources().getDrawable(i);
        }
        if (!this.f19199i) {
            if (!z) {
                z = this.f19194c;
                i = C0259a.g(i);
                C0259a.a(i.mutate(), z);
                imageView.setImageDrawable(i);
            }
        }
        z = this.f19193b;
        i = C0259a.g(i);
        C0259a.a(i.mutate(), z);
        imageView.setImageDrawable(i);
    }

    /* renamed from: e */
    private void m24466e() {
        String string = "American Express".equals(this.f19197g) ? getResources().getString(C5754i.amex_short) : this.f19197g;
        String string2 = getResources().getString(C5754i.ending_in);
        int length = string.length();
        int length2 = string2.length();
        int length3 = this.f19198h.length();
        int i = this.f19199i ? this.f19193b : this.f19196e;
        int i2 = this.f19199i ? this.f19192a : this.f19195d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(this.f19198h);
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        spannableString.setSpan(new TypefaceSpan("sans-serif-medium"), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, length, 33);
        length2 += length;
        spannableString.setSpan(new ForegroundColorSpan(i2), length, length2, 33);
        length3 += length2;
        spannableString.setSpan(new TypefaceSpan("sans-serif-medium"), length2, length3, 33);
        spannableString.setSpan(new ForegroundColorSpan(i), length2, length3, 33);
        this.f19201k.setText(spannableString);
    }

    /* renamed from: f */
    private void m24467f() {
        if (this.f19199i) {
            this.f19202l.setVisibility(0);
        } else {
            this.f19202l.setVisibility(4);
        }
    }

    /* renamed from: g */
    private void m24468g() {
        Resources resources = getResources();
        Context context = getContext();
        if (VERSION.SDK_INT >= 23) {
            this.f19193b = C5816n.m24524a(this.f19193b) ? resources.getColor(C5747b.accent_color_default, context.getTheme()) : this.f19193b;
            this.f19194c = C5816n.m24524a(this.f19194c) ? resources.getColor(C5747b.control_normal_color_default, context.getTheme()) : this.f19194c;
            this.f19196e = C5816n.m24524a(this.f19196e) ? resources.getColor(C5747b.color_text_secondary_default, context.getTheme()) : this.f19196e;
            return;
        }
        this.f19193b = C5816n.m24524a(this.f19193b) ? resources.getColor(C5747b.accent_color_default) : this.f19193b;
        this.f19194c = C5816n.m24524a(this.f19194c) ? resources.getColor(C5747b.control_normal_color_default) : this.f19194c;
        this.f19196e = C5816n.m24524a(this.f19196e) ? resources.getColor(C5747b.color_text_secondary_default) : this.f19196e;
    }

    /* renamed from: h */
    private void m24469h() {
        this.f19192a = C0264a.b(this.f19193b, getResources().getInteger(C5751f.light_text_alpha_hex));
        this.f19195d = C0264a.b(this.f19196e, getResources().getInteger(C5751f.light_text_alpha_hex));
    }
}
