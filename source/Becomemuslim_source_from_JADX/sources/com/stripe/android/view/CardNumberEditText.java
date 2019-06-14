package com.stripe.android.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.C5712a;
import com.stripe.android.C5775u;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CardNumberEditText extends StripeEditText {
    /* renamed from: b */
    private static final Integer[] f32834b = new Integer[]{Integer.valueOf(4), Integer.valueOf(9), Integer.valueOf(14)};
    /* renamed from: c */
    private static final Set<Integer> f32835c = new HashSet(Arrays.asList(f32834b));
    /* renamed from: d */
    private static final Integer[] f32836d = new Integer[]{Integer.valueOf(4), Integer.valueOf(11)};
    /* renamed from: e */
    private static final Set<Integer> f32837e = new HashSet(Arrays.asList(f32836d));
    /* renamed from: a */
    String f32838a = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    /* renamed from: f */
    private C5784a f32839f;
    /* renamed from: g */
    private C5785b f32840g;
    /* renamed from: h */
    private int f32841h = 19;
    /* renamed from: i */
    private boolean f32842i = false;
    /* renamed from: j */
    private boolean f32843j = false;

    /* renamed from: com.stripe.android.view.CardNumberEditText$1 */
    class C57831 implements TextWatcher {
        /* renamed from: a */
        int f19177a;
        /* renamed from: b */
        int f19178b;
        /* renamed from: c */
        final /* synthetic */ CardNumberEditText f19179c;

        C57831(CardNumberEditText cardNumberEditText) {
            this.f19179c = cardNumberEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19179c.f32842i == null) {
                this.f19177a = i;
                this.f19178b = i3;
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19179c.f32842i == 0) {
                if (i < 4) {
                    this.f19179c.m44336b(charSequence.toString());
                }
                if (i <= 16) {
                    charSequence = C5775u.m24420c(charSequence.toString());
                    if (charSequence != null) {
                        charSequence = C5816n.m24528b(charSequence, this.f19179c.f32838a);
                        i = new StringBuilder();
                        for (i3 = 0; i3 < charSequence.length; i3++) {
                            if (charSequence[i3] == null) {
                                break;
                            }
                            if (i3 != 0) {
                                i.append(' ');
                            }
                            i.append(charSequence[i3]);
                        }
                        charSequence = i.toString();
                        i = this.f19179c.m44341a(charSequence.length(), this.f19177a, this.f19178b);
                        this.f19179c.f32842i = true;
                        this.f19179c.setText(charSequence);
                        this.f19179c.setSelection(i);
                        this.f19179c.f32842i = 0;
                    }
                }
            }
        }

        public void afterTextChanged(Editable editable) {
            boolean z = true;
            if (editable.length() == this.f19179c.f32841h) {
                boolean c = this.f19179c.f32843j;
                this.f19179c.f32843j = C5712a.m24161b(editable.toString());
                this.f19179c.setShouldShowError(this.f19179c.f32843j ^ true);
                if (!c && this.f19179c.f32843j != null && this.f19179c.f32840g != null) {
                    this.f19179c.f32840g.mo5074a();
                    return;
                }
                return;
            }
            editable = this.f19179c;
            if (this.f19179c.getText() == null || !C5712a.m24161b(this.f19179c.getText().toString())) {
                z = false;
            }
            editable.f32843j = z;
            this.f19179c.setShouldShowError(false);
        }
    }

    /* renamed from: com.stripe.android.view.CardNumberEditText$a */
    interface C5784a {
        /* renamed from: a */
        void mo5073a(String str);
    }

    /* renamed from: com.stripe.android.view.CardNumberEditText$b */
    interface C5785b {
        /* renamed from: a */
        void mo5074a();
    }

    public CardNumberEditText(Context context) {
        super(context);
        m44335b();
    }

    public CardNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m44335b();
    }

    public CardNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m44335b();
    }

    public String getCardBrand() {
        return this.f32838a;
    }

    public String getCardNumber() {
        return this.f32843j ? C5775u.m24420c(getText().toString()) : null;
    }

    public int getLengthMax() {
        return this.f32841h;
    }

    void setCardNumberCompleteListener(C5785b c5785b) {
        this.f32840g = c5785b;
    }

    void setCardBrandChangeListener(C5784a c5784a) {
        this.f32839f = c5784a;
        this.f32839f.mo5073a(this.f32838a);
    }

    /* renamed from: a */
    void mo6856a() {
        setFilters(new InputFilter[]{new LengthFilter(this.f32841h)});
    }

    /* renamed from: a */
    int m44341a(int i, int i2, int i3) {
        int i4 = 0;
        Object obj = null;
        for (Integer num : "American Express".equals(this.f32838a) ? f32837e : f32835c) {
            if (i2 <= num.intValue() && i2 + i3 > num.intValue()) {
                i4++;
            }
            if (i3 == 0 && i2 == num.intValue() + 1) {
                obj = 1;
            }
        }
        i2 = (i2 + i3) + i4;
        if (obj != null && i2 > 0) {
            i2--;
        }
        return i2 <= i ? i2 : i;
    }

    /* renamed from: b */
    private void m44335b() {
        addTextChangedListener(new C57831(this));
    }

    /* renamed from: a */
    private void m44331a(String str) {
        if (!this.f32838a.equals(str)) {
            this.f32838a = str;
            if (this.f32839f != null) {
                this.f32839f.mo5073a(this.f32838a);
            }
            str = this.f32841h;
            this.f32841h = m44338c(this.f32838a);
            if (str != this.f32841h) {
                mo6856a();
            }
        }
    }

    /* renamed from: b */
    private void m44336b(String str) {
        m44331a(C5712a.m24158a(str));
    }

    /* renamed from: c */
    private static int m44338c(String str) {
        if (!"American Express".equals(str)) {
            if ("Diners Club".equals(str) == null) {
                return 19;
            }
        }
        return 17;
    }
}
