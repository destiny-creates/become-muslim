package com.devmarvel.creditcardentry.p077a;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.devmarvel.creditcardentry.C1175a.C1171e;
import com.devmarvel.creditcardentry.p078b.C1186c;

/* compiled from: ExpDateText */
/* renamed from: com.devmarvel.creditcardentry.a.c */
public class C3492c extends C1174b {
    /* renamed from: d */
    private String f9300d;
    /* renamed from: e */
    private String f9301e;

    public C3492c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo803a();
    }

    /* renamed from: a */
    void mo803a() {
        super.mo803a();
        setHint(C1171e.ExpDateFieldHint);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f9300d = charSequence.toString();
    }

    public void afterTextChanged(Editable editable) {
        editable = editable.toString();
        if (editable.length() > this.f9300d.length()) {
            mo804a(editable);
        }
    }

    /* renamed from: a */
    public void mo804a(String str) {
        removeTextChangedListener(this);
        Object c = C1186c.m4156c(str);
        setText(c);
        setSelection(c.length());
        addTextChangedListener(this);
        if (c.length() == 5) {
            setValid(true);
            String str2 = null;
            if (str.startsWith(c)) {
                str2 = str.replace(c, "");
            }
            this.a.mo815b(str2);
        } else if (c.length() < str.length()) {
            setValid(null);
            this.a.mo811a((EditText) this);
        }
    }

    public void setHelperText(String str) {
        this.f9301e = str;
    }

    public String getHelperText() {
        return this.f9301e != null ? this.f9301e : this.b.getString(C1171e.ExpirationDateHelp);
    }
}
