package com.stripe.android.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IconTextInputLayout extends TextInputLayout {
    /* renamed from: a */
    Rect f29834a;
    /* renamed from: b */
    Object f29835b;
    /* renamed from: c */
    Method f29836c;

    public IconTextInputLayout(Context context) {
        this(context, null);
    }

    public IconTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m38959a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m38958b();
    }

    /* renamed from: a */
    void m38959a() {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mCollapsingTextHelper");
            declaredField.setAccessible(true);
            this.f29835b = declaredField.get(this);
            declaredField = this.f29835b.getClass().getDeclaredField("mCollapsedBounds");
            declaredField.setAccessible(true);
            this.f29834a = (Rect) declaredField.get(this.f29835b);
            this.f29836c = this.f29835b.getClass().getDeclaredMethod("recalculate", new Class[0]);
        } catch (Exception e) {
            this.f29835b = null;
            this.f29834a = null;
            this.f29836c = null;
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m38958b() {
        if (this.f29835b != null) {
            if (getEditText() != null) {
                try {
                    this.f29834a.left = getEditText().getLeft() + getEditText().getPaddingLeft();
                    this.f29836c.invoke(this.f29835b, new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
