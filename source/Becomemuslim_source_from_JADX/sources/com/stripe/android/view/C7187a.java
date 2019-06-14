package com.stripe.android.view;

import com.stripe.android.view.StripeEditText.C5799b;

/* compiled from: BackUpFieldDeleteListener */
/* renamed from: com.stripe.android.view.a */
class C7187a implements C5799b {
    /* renamed from: a */
    private StripeEditText f25449a;

    C7187a(StripeEditText stripeEditText) {
        this.f25449a = stripeEditText;
    }

    /* renamed from: a */
    public void mo5079a() {
        String obj = this.f25449a.getText().toString();
        if (obj.length() > 1) {
            this.f25449a.setText(obj.substring(0, obj.length() - 1));
        }
        this.f25449a.requestFocus();
        this.f25449a.setSelection(this.f25449a.length());
    }
}
