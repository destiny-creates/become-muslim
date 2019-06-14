package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.design.widget.C4445m;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.stripe.android.C5756m.C5747b;

public class StripeEditText extends C4445m {
    /* renamed from: a */
    private C5798a f32427a;
    /* renamed from: b */
    private C5799b f32428b;
    /* renamed from: c */
    private ColorStateList f32429c;
    /* renamed from: d */
    private boolean f32430d;
    /* renamed from: e */
    private int f32431e;
    /* renamed from: f */
    private int f32432f;
    /* renamed from: g */
    private Handler f32433g;
    /* renamed from: h */
    private String f32434h;
    /* renamed from: i */
    private C5800c f32435i;

    /* renamed from: com.stripe.android.view.StripeEditText$2 */
    class C57962 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ StripeEditText f19227a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C57962(StripeEditText stripeEditText) {
            this.f19227a = stripeEditText;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f19227a.f32427a != null) {
                this.f19227a.f32427a.mo5076a(editable.toString());
            }
        }
    }

    /* renamed from: com.stripe.android.view.StripeEditText$3 */
    class C57973 implements OnKeyListener {
        /* renamed from: a */
        final /* synthetic */ StripeEditText f19228a;

        C57973(StripeEditText stripeEditText) {
            this.f19228a = stripeEditText;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && keyEvent.getAction() == null && this.f19228a.f32428b != null && this.f19228a.length() == null) {
                this.f19228a.f32428b.mo5079a();
            }
            return null;
        }
    }

    /* renamed from: com.stripe.android.view.StripeEditText$a */
    interface C5798a {
        /* renamed from: a */
        void mo5076a(String str);
    }

    /* renamed from: com.stripe.android.view.StripeEditText$b */
    interface C5799b {
        /* renamed from: a */
        void mo5079a();
    }

    /* renamed from: com.stripe.android.view.StripeEditText$c */
    interface C5800c {
        /* renamed from: a */
        void mo5080a(String str);
    }

    /* renamed from: com.stripe.android.view.StripeEditText$d */
    private class C5801d extends InputConnectionWrapper {
        /* renamed from: a */
        final /* synthetic */ StripeEditText f19229a;

        C5801d(StripeEditText stripeEditText, InputConnection inputConnection, boolean z) {
            this.f19229a = stripeEditText;
            super(inputConnection, z);
        }

        public boolean deleteSurroundingText(int i, int i2) {
            if (getTextBeforeCursor(1, 0).length() == 0 && this.f19229a.f32428b != null) {
                this.f19229a.f32428b.mo5079a();
            }
            return super.deleteSurroundingText(i, i2);
        }
    }

    public StripeEditText(Context context) {
        super(context);
        mo6856a();
    }

    public StripeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo6856a();
    }

    public StripeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo6856a();
    }

    public ColorStateList getCachedColorStateList() {
        return this.f32429c;
    }

    public boolean getShouldShowError() {
        return this.f32430d;
    }

    public int getDefaultErrorColorInt() {
        m42844b();
        if (VERSION.SDK_INT >= 23) {
            return getResources().getColor(this.f32431e, null);
        }
        return getResources().getColor(this.f32431e);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (super.onCreateInputConnection(editorInfo) == null) {
            return null;
        }
        return new C5801d(this, super.onCreateInputConnection(editorInfo), true);
    }

    void setAfterTextChangedListener(C5798a c5798a) {
        this.f32427a = c5798a;
    }

    void setDeleteEmptyListener(C5799b c5799b) {
        this.f32428b = c5799b;
    }

    void setErrorMessageListener(C5800c c5800c) {
        this.f32435i = c5800c;
    }

    void setErrorMessage(String str) {
        this.f32434h = str;
    }

    public void setErrorColor(int i) {
        this.f32432f = i;
    }

    /* renamed from: a */
    public void m42847a(final int i, long j) {
        this.f32433g.postDelayed(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ StripeEditText f19226b;

            public void run() {
                this.f19226b.setHint(i);
            }
        }, j);
    }

    public void setShouldShowError(boolean z) {
        if (this.f32434h == null || this.f32435i == null) {
            this.f32430d = z;
            if (this.f32430d) {
                setTextColor(this.f32432f);
            } else {
                setTextColor(this.f32429c);
            }
            refreshDrawableState();
            return;
        }
        this.f32435i.mo5080a(z ? this.f32434h : null);
        this.f32430d = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f32433g.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    private void mo6856a() {
        this.f32433g = new Handler();
        m42845c();
        m42846d();
        m42844b();
        this.f32429c = getTextColors();
    }

    /* renamed from: b */
    private void m42844b() {
        this.f32429c = getTextColors();
        if (C5816n.m24527b(this.f32429c.getDefaultColor())) {
            this.f32431e = C5747b.error_text_light_theme;
        } else {
            this.f32431e = C5747b.error_text_dark_theme;
        }
    }

    /* renamed from: c */
    private void m42845c() {
        addTextChangedListener(new C57962(this));
    }

    /* renamed from: d */
    private void m42846d() {
        setOnKeyListener(new C57973(this));
    }
}
