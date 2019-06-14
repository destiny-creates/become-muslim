package com.devmarvel.creditcardentry.p077a;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import com.devmarvel.creditcardentry.C1175a.C1171e;
import com.devmarvel.creditcardentry.library.C1190a;
import com.devmarvel.creditcardentry.p078b.C1186c;

/* compiled from: SecurityCodeText */
/* renamed from: com.devmarvel.creditcardentry.a.d */
public class C3493d extends C1174b {
    /* renamed from: d */
    private C1190a f9302d;
    /* renamed from: e */
    private int f9303e;
    /* renamed from: f */
    private String f9304f;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C3493d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo803a();
    }

    /* renamed from: a */
    void mo803a() {
        super.mo803a();
        setHint(C1171e.SecurityCodeFieldHint);
    }

    public void afterTextChanged(Editable editable) {
        if (this.f9302d == null) {
            removeTextChangedListener(this);
            setText("");
            addTextChangedListener(this);
        }
    }

    /* renamed from: a */
    public void mo804a(String str) {
        setText(str);
    }

    /* renamed from: a */
    public void mo809a(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f9302d == 0) {
            return;
        }
        if (charSequence.length() >= this.f9303e) {
            setValid(1);
            i = 0;
            if (charSequence.length() > length()) {
                i = String.valueOf(charSequence).substring(this.f9303e);
            }
            removeTextChangedListener(this);
            setText(String.valueOf(charSequence).substring(0, this.f9303e));
            addTextChangedListener(this);
            this.a.mo816c(i);
            return;
        }
        setValid(false);
    }

    public C1190a getType() {
        return this.f9302d;
    }

    public void setType(C1190a c1190a) {
        this.f9302d = c1190a;
        this.f9303e = C1186c.m4154b(c1190a);
    }

    public void setHelperText(String str) {
        this.f9304f = str;
    }

    public String getHelperText() {
        return this.f9304f != null ? this.f9304f : this.b.getString(C1171e.SecurityCodeHelp);
    }
}
