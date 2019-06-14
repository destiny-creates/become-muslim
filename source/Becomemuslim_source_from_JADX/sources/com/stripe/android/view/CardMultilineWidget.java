package com.stripe.android.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.TextInputLayout;
import android.support.v4.p020a.p021a.C0259a;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.C5712a;
import com.stripe.android.C5756m.C5748c;
import com.stripe.android.C5756m.C5749d;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.C5756m.C5755j;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.view.CardNumberEditText.C5784a;
import com.stripe.android.view.CardNumberEditText.C5785b;
import com.stripe.android.view.ExpiryDateEditText.C5790a;
import com.stripe.android.view.StripeEditText.C5798a;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CardMultilineWidget extends LinearLayout {
    /* renamed from: a */
    private C5802b f19163a;
    /* renamed from: b */
    private CardNumberEditText f19164b;
    /* renamed from: c */
    private ExpiryDateEditText f19165c;
    /* renamed from: d */
    private StripeEditText f19166d;
    /* renamed from: e */
    private StripeEditText f19167e;
    /* renamed from: f */
    private TextInputLayout f19168f;
    /* renamed from: g */
    private TextInputLayout f19169g;
    /* renamed from: h */
    private TextInputLayout f19170h;
    /* renamed from: i */
    private TextInputLayout f19171i;
    /* renamed from: j */
    private boolean f19172j;
    /* renamed from: k */
    private boolean f19173k;
    /* renamed from: l */
    private boolean f19174l;
    /* renamed from: m */
    private String f19175m;
    /* renamed from: n */
    private int f19176n;

    /* renamed from: com.stripe.android.view.CardMultilineWidget$6 */
    class C57796 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f19159a;

        C57796(CardMultilineWidget cardMultilineWidget) {
            this.f19159a = cardMultilineWidget;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f19159a.f19164b.m42847a(C5754i.card_number_hint, 120);
                if (this.f19159a.f19163a != null) {
                    this.f19159a.f19163a.m24496a("focus_card");
                    return;
                }
                return;
            }
            this.f19159a.f19164b.setHint("");
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$7 */
    class C57807 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f19160a;

        C57807(CardMultilineWidget cardMultilineWidget) {
            this.f19160a = cardMultilineWidget;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f19160a.f19165c.m42847a(C5754i.expiry_date_hint, 90);
                if (this.f19160a.f19163a != null) {
                    this.f19160a.f19163a.m24496a("focus_expiry");
                    return;
                }
                return;
            }
            this.f19160a.f19165c.setHint("");
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$8 */
    class C57818 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f19161a;

        C57818(CardMultilineWidget cardMultilineWidget) {
            this.f19161a = cardMultilineWidget;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f19161a.m24444c();
                this.f19161a.f19166d.m42847a(this.f19161a.getCvcHelperText(), 90);
                if (this.f19161a.f19163a != null) {
                    this.f19161a.f19163a.m24496a("focus_cvc");
                    return;
                }
                return;
            }
            this.f19161a.m24438a(this.f19161a.f19175m);
            this.f19161a.f19166d.setHint("");
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$9 */
    class C57829 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f19162a;

        C57829(CardMultilineWidget cardMultilineWidget) {
            this.f19162a = cardMultilineWidget;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f19162a.f19173k != null) {
                if (z) {
                    this.f19162a.f19167e.m42847a(C5754i.zip_helper, 90);
                    if (this.f19162a.f19163a != null) {
                        this.f19162a.f19163a.m24496a("focus_postal");
                    }
                } else {
                    this.f19162a.f19167e.setHint("");
                }
            }
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$1 */
    class C71761 implements C5784a {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f25438a;

        C71761(CardMultilineWidget cardMultilineWidget) {
            this.f25438a = cardMultilineWidget;
        }

        /* renamed from: a */
        public void mo5073a(String str) {
            this.f25438a.m24438a(str);
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$2 */
    class C71772 implements C5785b {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f25439a;

        C71772(CardMultilineWidget cardMultilineWidget) {
            this.f25439a = cardMultilineWidget;
        }

        /* renamed from: a */
        public void mo5074a() {
            this.f25439a.f19165c.requestFocus();
            if (this.f25439a.f19163a != null) {
                this.f25439a.f19163a.m24495a();
            }
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$3 */
    class C71783 implements C5790a {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f25440a;

        C71783(CardMultilineWidget cardMultilineWidget) {
            this.f25440a = cardMultilineWidget;
        }

        /* renamed from: a */
        public void mo5075a() {
            this.f25440a.f19166d.requestFocus();
            if (this.f25440a.f19163a != null) {
                this.f25440a.f19163a.m24497b();
            }
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$4 */
    class C71794 implements C5798a {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f25441a;

        C71794(CardMultilineWidget cardMultilineWidget) {
            this.f25441a = cardMultilineWidget;
        }

        /* renamed from: a */
        public void mo5076a(String str) {
            if (C5816n.m24525a(this.f25441a.f19175m, str) != null) {
                this.f25441a.m24438a(this.f25441a.f19175m);
                if (this.f25441a.f19173k != null) {
                    this.f25441a.f19167e.requestFocus();
                }
                if (this.f25441a.f19163a != null) {
                    this.f25441a.f19163a.m24498c();
                }
            } else {
                this.f25441a.m24444c();
            }
            this.f25441a.f19166d.setShouldShowError(false);
        }
    }

    /* renamed from: com.stripe.android.view.CardMultilineWidget$5 */
    class C71805 implements C5798a {
        /* renamed from: a */
        final /* synthetic */ CardMultilineWidget f25442a;

        C71805(CardMultilineWidget cardMultilineWidget) {
            this.f25442a = cardMultilineWidget;
        }

        /* renamed from: a */
        public void mo5076a(String str) {
            if (!(CardMultilineWidget.m24439a(true, str) == null || this.f25442a.f19163a == null)) {
                this.f25442a.f19163a.m24499d();
            }
            this.f25442a.f19167e.setShouldShowError(false);
        }
    }

    public CardMultilineWidget(Context context) {
        super(context);
        m24441b((AttributeSet) null);
    }

    public CardMultilineWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24441b(attributeSet);
    }

    public CardMultilineWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24441b(attributeSet);
    }

    CardMultilineWidget(Context context, boolean z) {
        super(context);
        this.f19173k = z;
        m24441b((AttributeSet) null);
    }

    public void setCardInputListener(C5802b c5802b) {
        this.f19163a = c5802b;
    }

    public C7157c getCard() {
        if (!m24454a()) {
            return null;
        }
        String cardNumber = this.f19164b.getCardNumber();
        int[] validDateFields = this.f19165c.getValidDateFields();
        C7157c c7157c = new C7157c(cardNumber, Integer.valueOf(validDateFields[0]), Integer.valueOf(validDateFields[1]), this.f19166d.getText().toString());
        if (this.f19173k) {
            c7157c.m33223d(this.f19167e.getText().toString());
        }
        return c7157c.m33221c("CardMultilineView");
    }

    /* renamed from: a */
    public boolean m24454a() {
        boolean b = C5712a.m24161b(this.f19164b.getCardNumber());
        int i = (this.f19165c.getValidDateFields() == null || !this.f19165c.mo6856a()) ? 0 : 1;
        boolean a = C5816n.m24525a(this.f19175m, this.f19166d.getText().toString());
        this.f19164b.setShouldShowError(b ^ 1);
        this.f19165c.setShouldShowError(i ^ 1);
        this.f19166d.setShouldShowError(a ^ 1);
        boolean a2;
        if (this.f19173k) {
            a2 = m24439a(true, this.f19167e.getText().toString());
            this.f19167e.setShouldShowError(a2 ^ 1);
        } else {
            a2 = true;
        }
        if (b && i != 0 && a && r5) {
            return true;
        }
        return false;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m24438a(this.f19175m);
        }
    }

    public void setShouldShowPostalCode(boolean z) {
        this.f19173k = z;
        m24455b();
    }

    public boolean isEnabled() {
        return this.f19172j;
    }

    public void setEnabled(boolean z) {
        this.f19169g.setEnabled(z);
        this.f19168f.setEnabled(z);
        this.f19170h.setEnabled(z);
        this.f19171i.setEnabled(z);
        this.f19172j = z;
    }

    /* renamed from: b */
    void m24455b() {
        this.f19169g.setHint(getResources().getString(this.f19173k ? C5754i.expiry_label_short : C5754i.acc_label_expiry_date));
        int i = this.f19173k ? C5750e.et_add_source_postal_ml : -1;
        this.f19166d.setNextFocusForwardId(i);
        this.f19166d.setNextFocusDownId(i);
        this.f19171i.setVisibility(this.f19173k ? 0 : 8);
        i = this.f19173k ? getResources().getDimensionPixelSize(C5748c.add_card_expiry_middle_margin) : 0;
        LayoutParams layoutParams = (LayoutParams) this.f19170h.getLayoutParams();
        layoutParams.setMargins(0, 0, i, 0);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(i);
        }
        this.f19170h.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    static boolean m24439a(boolean z, String str) {
        return z && str != null && str.length();
    }

    /* renamed from: a */
    private void m24436a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = getContext().getTheme().obtainStyledAttributes(attributeSet, C5755j.CardMultilineWidget, 0, 0);
            try {
                this.f19173k = attributeSet.getBoolean(C5755j.CardMultilineWidget_shouldShowPostalCode, false);
            } finally {
                attributeSet.recycle();
            }
        }
    }

    /* renamed from: c */
    private void m24444c() {
        if (!C5816n.m24525a(this.f19175m, this.f19166d.getText().toString())) {
            m24434a("American Express".equals(this.f19175m) ? C5749d.ic_cvc_amex : C5749d.ic_cvc, true);
        }
    }

    private int getCvcHelperText() {
        return "American Express".equals(this.f19175m) ? C5754i.cvc_multiline_helper_amex : C5754i.cvc_multiline_helper;
    }

    private int getDynamicBufferInPixels() {
        return new BigDecimal((double) getResources().getDimension(C5748c.card_icon_multiline_padding_bottom)).setScale(0, RoundingMode.HALF_DOWN).intValue();
    }

    /* renamed from: b */
    private void m24441b(AttributeSet attributeSet) {
        setOrientation(1);
        inflate(getContext(), C5752g.card_multiline_widget, this);
        this.f19164b = (CardNumberEditText) findViewById(C5750e.et_add_source_card_number_ml);
        this.f19165c = (ExpiryDateEditText) findViewById(C5750e.et_add_source_expiry_ml);
        this.f19166d = (StripeEditText) findViewById(C5750e.et_add_source_cvc_ml);
        this.f19167e = (StripeEditText) findViewById(C5750e.et_add_source_postal_ml);
        this.f19176n = this.f19164b.getHintTextColors().getDefaultColor();
        this.f19175m = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        m24436a(attributeSet);
        this.f19168f = (TextInputLayout) findViewById(C5750e.tl_add_source_card_number_ml);
        this.f19169g = (TextInputLayout) findViewById(C5750e.tl_add_source_expiry_ml);
        this.f19170h = (TextInputLayout) findViewById(C5750e.tl_add_source_cvc_ml);
        this.f19171i = (TextInputLayout) findViewById(C5750e.tl_add_source_postal_ml);
        if (this.f19173k != null) {
            this.f19169g.setHint(getResources().getString(C5754i.expiry_label_short));
        }
        m24435a(this.f19168f, this.f19169g, this.f19170h, this.f19171i);
        m24447e();
        m24450f();
        m24446d();
        this.f19164b.setCardBrandChangeListener(new C71761(this));
        this.f19164b.setCardNumberCompleteListener(new C71772(this));
        this.f19165c.setExpiryDateEditListener(new C71783(this));
        this.f19166d.setAfterTextChangedListener(new C71794(this));
        m24455b();
        this.f19167e.setAfterTextChangedListener(new C71805(this));
        this.f19164b.mo6856a();
        m24438a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        setEnabled(true);
    }

    /* renamed from: d */
    private void m24446d() {
        this.f19165c.setDeleteEmptyListener(new C7187a(this.f19164b));
        this.f19166d.setDeleteEmptyListener(new C7187a(this.f19165c));
        if (this.f19167e != null) {
            this.f19167e.setDeleteEmptyListener(new C7187a(this.f19166d));
        }
    }

    /* renamed from: e */
    private void m24447e() {
        this.f19164b.setErrorMessage(getContext().getString(C5754i.invalid_card_number));
        this.f19165c.setErrorMessage(getContext().getString(C5754i.invalid_expiry_year));
        this.f19166d.setErrorMessage(getContext().getString(C5754i.invalid_cvc));
        this.f19167e.setErrorMessage(getContext().getString(C5754i.invalid_zip));
    }

    /* renamed from: f */
    private void m24450f() {
        this.f19164b.setOnFocusChangeListener(new C57796(this));
        this.f19165c.setOnFocusChangeListener(new C57807(this));
        this.f19166d.setOnFocusChangeListener(new C57818(this));
        if (this.f19167e != null) {
            this.f19167e.setOnFocusChangeListener(new C57829(this));
        }
    }

    /* renamed from: a */
    private void m24435a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4) {
        this.f19164b.setErrorMessageListener(new C7188f(textInputLayout));
        this.f19165c.setErrorMessageListener(new C7188f(textInputLayout2));
        this.f19166d.setErrorMessageListener(new C7188f(textInputLayout3));
        if (this.f19167e != null) {
            this.f19167e.setErrorMessageListener(new C7188f(textInputLayout4));
        }
    }

    /* renamed from: a */
    private void m24438a(String str) {
        this.f19175m = str;
        m24442b(this.f19175m);
        m24434a(((Integer) C7157c.f25315a.get(str)).intValue(), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN.equals(str));
    }

    /* renamed from: b */
    private void m24442b(String str) {
        if ("American Express".equals(str) != null) {
            this.f19166d.setFilters(new InputFilter[]{new LengthFilter(4)});
            this.f19170h.setHint(getResources().getString(C5754i.cvc_amex_hint));
            return;
        }
        this.f19166d.setFilters(new InputFilter[]{new LengthFilter(3)});
        this.f19170h.setHint(getResources().getString(C5754i.cvc_number_hint));
    }

    /* renamed from: a */
    private void m24434a(int i, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            i = getResources().getDrawable(i, null);
        } else {
            i = getResources().getDrawable(i);
        }
        Drawable drawable = this.f19164b.getCompoundDrawables()[0];
        if (drawable != null) {
            Rect rect = new Rect();
            drawable.copyBounds(rect);
            int compoundDrawablePadding = this.f19164b.getCompoundDrawablePadding();
            if (!this.f19174l) {
                rect.top -= getDynamicBufferInPixels();
                rect.bottom -= getDynamicBufferInPixels();
                this.f19174l = true;
            }
            i.setBounds(rect);
            i = C0259a.g(i);
            if (z) {
                C0259a.a(i.mutate(), this.f19176n);
            }
            this.f19164b.setCompoundDrawablePadding(compoundDrawablePadding);
            this.f19164b.setCompoundDrawables(i, null, null, null);
        }
    }
}
