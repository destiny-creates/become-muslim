package com.devmarvel.creditcardentry.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p030f.C0392e;
import android.support.v4.p030f.C0393f;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.devmarvel.creditcardentry.C1175a.C1168b;
import com.devmarvel.creditcardentry.C1175a.C1169c;
import com.devmarvel.creditcardentry.C1175a.C1170d;
import com.devmarvel.creditcardentry.C1175a.C1171e;
import com.devmarvel.creditcardentry.C1175a.C1172f;
import com.devmarvel.creditcardentry.p078b.C3497a;

public class CreditCardForm extends RelativeLayout {
    /* renamed from: a */
    private C3497a f3319a;
    /* renamed from: b */
    private boolean f3320b;
    /* renamed from: c */
    private boolean f3321c;
    /* renamed from: d */
    private boolean f3322d;
    /* renamed from: e */
    private boolean f3323e;
    /* renamed from: f */
    private int f3324f;
    /* renamed from: g */
    private Drawable f3325g;
    /* renamed from: h */
    private boolean f3326h;
    /* renamed from: i */
    private boolean f3327i;
    /* renamed from: j */
    private String f3328j;

    /* renamed from: com.devmarvel.creditcardentry.library.CreditCardForm$a */
    static class C1189a extends BaseSavedState {
        public static final Creator<C1189a> CREATOR = C0392e.m1170a(new C34981());
        /* renamed from: a */
        SparseArray f3318a;

        /* renamed from: com.devmarvel.creditcardentry.library.CreditCardForm$a$1 */
        static class C34981 implements C0393f<C1189a> {
            C34981() {
            }

            /* renamed from: a */
            public /* synthetic */ Object mo817a(Parcel parcel, ClassLoader classLoader) {
                return m11277b(parcel, classLoader);
            }

            /* renamed from: a */
            public /* synthetic */ Object[] mo818a(int i) {
                return m11278b(i);
            }

            /* renamed from: b */
            public C1189a m11277b(Parcel parcel, ClassLoader classLoader) {
                return new C1189a(parcel, classLoader);
            }

            /* renamed from: b */
            public C1189a[] m11278b(int i) {
                return new C1189a[i];
            }
        }

        C1189a(Parcelable parcelable) {
            super(parcelable);
        }

        private C1189a(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f3318a = parcel.readSparseArray(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSparseArray(this.f3318a);
        }
    }

    public CreditCardForm(Context context) {
        this(context, null);
    }

    public CreditCardForm(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreditCardForm(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        super(context, attributeSet, i);
        this.f3320b = true;
        this.f3321c = true;
        this.f3322d = true;
        if (!isInEditMode()) {
            if (attributeSet != null) {
                try {
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1172f.CreditCardForm, 0, 0);
                    try {
                        this.f3328j = obtainStyledAttributes.getString(C1172f.CreditCardForm_card_number_hint);
                        this.f3320b = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_include_exp, true);
                        this.f3321c = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_include_security, true);
                        this.f3322d = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_include_zip, true);
                        this.f3323e = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_include_helper, true);
                        this.f3324f = obtainStyledAttributes.getColor(C1172f.CreditCardForm_helper_text_color, getResources().getColor(C1168b.text_helper_color));
                        this.f3325g = obtainStyledAttributes.getDrawable(C1172f.CreditCardForm_input_background);
                        this.f3326h = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_default_text_colors, false);
                        this.f3327i = obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_animate_on_error, true);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Throwable th) {
                        context = th;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw context;
                    }
                } catch (Throwable th2) {
                    context = th2;
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    throw context;
                }
            }
            if (this.f3328j == null) {
                this.f3328j = context.getResources().getString(C1171e.CreditCardFormCardNumberHint);
            }
            if (this.f3325g == null) {
                this.f3325g = context.getResources().getDrawable(C1169c.background_white);
            }
        }
        m4160a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m4160a(Context context, AttributeSet attributeSet, int i) {
        View linearLayout;
        CreditCardForm creditCardForm = this;
        Context context2 = context;
        if (VERSION.SDK_INT >= 11) {
            linearLayout = new LinearLayout(context2);
        } else {
            linearLayout = new LinearLayout(context2);
        }
        View view = linearLayout;
        if (VERSION.SDK_INT >= 17) {
            view.setLayoutDirection(0);
        }
        view.setId(C1170d.cc_form_layout);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.addRule(0);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setPadding(0, 0, 0, 0);
        view.setBackgroundDrawable(creditCardForm.f3325g);
        linearLayout = new FrameLayout(context2);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setPadding(10, 0, 0, 0);
        View imageView = new ImageView(context2);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView.setImageResource(C1190a.INVALID.f3340k);
        linearLayout.addView(imageView);
        View imageView2 = new ImageView(context2);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView2.setImageResource(C1190a.INVALID.f3341l);
        imageView2.setVisibility(8);
        linearLayout.addView(imageView2);
        view.addView(linearLayout);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        creditCardForm.f3319a = new C3497a(context, creditCardForm.f3320b, creditCardForm.f3321c, creditCardForm.f3322d, attributeSet, i);
        creditCardForm.f3319a.setId(C1170d.cc_entry);
        creditCardForm.f3319a.setPadding(0, 0, 0, 6);
        creditCardForm.f3319a.setLayoutParams(layoutParams3);
        creditCardForm.f3319a.setCardImageView(imageView);
        creditCardForm.f3319a.setBackCardImage(imageView2);
        creditCardForm.f3319a.setCardNumberHint(creditCardForm.f3328j);
        creditCardForm.f3319a.setAnimateOnError(creditCardForm.f3327i);
        addView(view);
        if (creditCardForm.f3323e) {
            linearLayout = new TextView(context2);
            linearLayout.setId(C1170d.text_helper);
            linearLayout.setText(getResources().getString(C1171e.CreditCardNumberHelp));
            if (creditCardForm.f3326h) {
                linearLayout.setTextColor(creditCardForm.f3324f);
            }
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(3, view.getId());
            layoutParams4.addRule(14);
            layoutParams4.setMargins(0, 15, 0, 20);
            linearLayout.setLayoutParams(layoutParams4);
            creditCardForm.f3319a.setTextHelper(linearLayout);
            addView(linearLayout);
        }
        view.addView(creditCardForm.f3319a);
    }

    public void setOnCardValidCallback(C1191b c1191b) {
        this.f3319a.setOnCardValidCallback(c1191b);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f3319a.setOnFocusChangeListener(onFocusChangeListener);
    }

    public OnFocusChangeListener getOnFocusChangeListener() {
        return this.f3319a.getOnFocusChangeListener();
    }

    /* renamed from: a */
    public boolean m4162a() {
        return this.f3319a.m11271b();
    }

    public C1192c getCreditCard() {
        return this.f3319a.getCreditCard();
    }

    /* renamed from: b */
    public void m4163b() {
        this.f3319a.m11272c();
    }

    /* renamed from: a */
    public void m4161a(String str, boolean z) {
        this.f3319a.m11267a(str, z);
    }

    /* renamed from: b */
    public void m4164b(String str, boolean z) {
        this.f3319a.m11270b(str, z);
    }

    /* renamed from: c */
    public void m4165c(String str, boolean z) {
        this.f3319a.m11274c(str, z);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C1189a c1189a = (C1189a) parcelable;
        super.onRestoreInstanceState(c1189a.getSuperState());
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).restoreHierarchyState(c1189a.f3318a);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1189a = new C1189a(super.onSaveInstanceState());
        c1189a.f3318a = new SparseArray();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).saveHierarchyState(c1189a.f3318a);
        }
        return c1189a;
    }

    public void setCreditCardTextHelper(String str) {
        this.f3319a.setCreditCardTextHelper(str);
    }

    public void setCreditCardTextHint(String str) {
        this.f3319a.setCreditCardTextHint(str);
    }

    public void setExpDateTextHelper(String str) {
        this.f3319a.setExpDateTextHelper(str);
    }

    public void setExpDateTextHint(String str) {
        this.f3319a.setExpDateTextHint(str);
    }

    public void setSecurityCodeTextHelper(String str) {
        this.f3319a.setSecurityCodeTextHelper(str);
    }

    public void setSecurityCodeTextHint(String str) {
        this.f3319a.setSecurityCodeTextHint(str);
    }

    public void setZipCodeTextHelper(String str) {
        this.f3319a.setZipCodeTextHelper(str);
    }

    public void setZipCodeTextHint(String str) {
        this.f3319a.setZipCodeTextHint(str);
    }

    public void setTypeface(Typeface typeface) {
        this.f3319a.setTypeface(typeface);
    }
}
