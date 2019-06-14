package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0514r;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: AppCompatEditText */
/* renamed from: android.support.v7.widget.n */
public class C3326n extends EditText implements C0514r {
    /* renamed from: a */
    private final C0795h f8840a;
    /* renamed from: b */
    private final C0810z f8841b;

    public C3326n(Context context) {
        this(context, null);
    }

    public C3326n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.editTextStyle);
    }

    public C3326n(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8840a = new C0795h(this);
        this.f8840a.m2877a(attributeSet, i);
        this.f8841b = C0810z.m2939a((TextView) this);
        this.f8841b.mo604a(attributeSet, i);
        this.f8841b.mo603a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8840a != null) {
            this.f8840a.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8840a != null) {
            this.f8840a.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8840a != null) {
            this.f8840a.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8840a != null ? this.f8840a.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8840a != null) {
            this.f8840a.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8840a != null ? this.f8840a.m2878b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8840a != null) {
            this.f8840a.m2880c();
        }
        if (this.f8841b != null) {
            this.f8841b.mo603a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f8841b != null) {
            this.f8841b.m2948a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0800o.m2920a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
