package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.C0574s;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* compiled from: AppCompatRadioButton */
/* renamed from: android.support.v7.widget.u */
public class C3329u extends RadioButton implements C0574s {
    /* renamed from: a */
    private final C0797l f8847a;
    /* renamed from: b */
    private final C0810z f8848b;

    public C3329u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.radioButtonStyle);
    }

    public C3329u(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8847a = new C0797l(this);
        this.f8847a.m2885a(attributeSet, i);
        this.f8848b = new C0810z(this);
        this.f8848b.mo604a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f8847a != null) {
            this.f8847a.m2887c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0631b.m2112b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f8847a != null ? this.f8847a.m2881a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f8847a != null) {
            this.f8847a.m2883a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f8847a != null ? this.f8847a.m2882a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f8847a != null) {
            this.f8847a.m2884a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f8847a != null ? this.f8847a.m2886b() : null;
    }
}
