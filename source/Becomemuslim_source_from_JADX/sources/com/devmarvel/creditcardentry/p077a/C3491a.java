package com.devmarvel.creditcardentry.p077a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.devmarvel.creditcardentry.C1175a.C1171e;
import com.devmarvel.creditcardentry.library.C1190a;
import com.devmarvel.creditcardentry.p078b.C1186c;

/* compiled from: CreditCardText */
/* renamed from: com.devmarvel.creditcardentry.a.a */
public class C3491a extends C1174b {
    /* renamed from: d */
    private C1190a f9298d;
    /* renamed from: e */
    private String f9299e;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C3491a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo803a();
    }

    @SuppressLint({"RtlHardcoded"})
    /* renamed from: a */
    void mo803a() {
        super.mo803a();
        setGravity(19);
    }

    public void afterTextChanged(Editable editable) {
        editable = editable.toString();
        if (editable.length() >= 4) {
            mo804a(editable);
        } else if (this.f9298d != null) {
            this.f9298d = null;
            this.a.mo812a(C1190a.INVALID);
        }
    }

    /* renamed from: a */
    public void mo804a(String str) {
        C1190a a = C1186c.m4151a(str);
        if (a.equals(C1190a.INVALID)) {
            setValid(false);
            this.a.mo811a((EditText) this);
            return;
        }
        if (this.f9298d != a) {
            this.a.mo812a(a);
        }
        this.f9298d = a;
        String a2 = C1186c.m4152a(str, a);
        if (!str.equalsIgnoreCase(a2)) {
            removeTextChangedListener(this);
            setText(a2);
            setSelection(a2.length());
            addTextChangedListener(this);
        }
        if (a2.length() >= C1186c.m4150a(a)) {
            String str2 = null;
            if (str.startsWith(a2)) {
                str2 = str.replace(a2, "");
            }
            if (C1186c.m4155b(a2) != null) {
                setValid(true);
                this.a.mo813a(str2);
            } else {
                setValid(false);
                this.a.mo811a((EditText) this);
            }
        } else {
            setValid(false);
        }
    }

    public C1190a getType() {
        return this.f9298d;
    }

    public void setHelperText(String str) {
        this.f9299e = str;
    }

    public String getHelperText() {
        return this.f9299e != null ? this.f9299e : this.b.getString(C1171e.CreditCardNumberHelp);
    }
}
