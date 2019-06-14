package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.C0574s;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* compiled from: AppCompatCheckBox */
/* renamed from: android.support.v7.widget.j */
public class C3322j extends CheckBox implements C0574s {
    private final C0797l mCompoundButtonHelper;

    public C3322j(Context context) {
        this(context, null);
    }

    public C3322j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.checkboxStyle);
    }

    public C3322j(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.mCompoundButtonHelper = new C0797l(this);
        this.mCompoundButtonHelper.m2885a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.m2887c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0631b.m2112b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.m2881a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.m2883a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.m2882a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.m2884a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.m2886b() : null;
    }
}
