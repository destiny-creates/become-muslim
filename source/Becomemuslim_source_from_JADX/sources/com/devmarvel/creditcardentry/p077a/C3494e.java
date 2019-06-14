package com.devmarvel.creditcardentry.p077a;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.devmarvel.creditcardentry.C1175a.C1171e;

/* compiled from: ZipCodeText */
/* renamed from: com.devmarvel.creditcardentry.a.e */
public class C3494e extends C1174b {
    /* renamed from: d */
    private int f9305d;
    /* renamed from: e */
    private String f9306e;

    public C3494e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo803a();
    }

    /* renamed from: a */
    void mo803a() {
        super.mo803a();
        this.f9305d = 5;
        setMaxChars(this.f9305d);
        setHint(C1171e.ZipCodeFieldHint);
    }

    public void setHelperText(String str) {
        this.f9306e = str;
    }

    public String getHelperText() {
        return this.f9306e != null ? this.f9306e : this.b.getString(C1171e.ZipHelp);
    }

    /* renamed from: a */
    public void mo809a(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.toString().matches("^\\d+$") == 0) {
            if (charSequence.length() > 3) {
                setValid(true);
            }
            if (charSequence.length() != this.f9305d || this.f9305d <= null) {
                setValid(false);
            } else {
                this.a.mo810a();
            }
        } else if (charSequence.length() == this.f9305d) {
            setValid(true);
            this.a.mo810a();
        } else {
            setValid(false);
        }
    }

    /* renamed from: a */
    public void mo804a(String str) {
        removeTextChangedListener(this);
        setText(str);
        addTextChangedListener(this);
    }

    public void setMaxChars(int i) {
        if (i > 0) {
            this.f9305d = i;
            setFilters(new InputFilter[]{new LengthFilter(i)});
        }
    }
}
