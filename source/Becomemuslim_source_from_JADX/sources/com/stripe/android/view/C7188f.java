package com.stripe.android.view;

import android.support.design.widget.TextInputLayout;
import com.stripe.android.view.StripeEditText.C5800c;

/* compiled from: ErrorListener */
/* renamed from: com.stripe.android.view.f */
class C7188f implements C5800c {
    /* renamed from: a */
    TextInputLayout f25450a;

    C7188f(TextInputLayout textInputLayout) {
        this.f25450a = textInputLayout;
    }

    /* renamed from: a */
    public void mo5080a(String str) {
        if (str == null) {
            this.f25450a.setErrorEnabled(false);
        } else {
            this.f25450a.setError(str);
        }
    }
}
