package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0514r;
import android.support.v4.widget.C0534b;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* compiled from: AppCompatButton */
/* renamed from: android.support.v7.widget.i */
public class C3321i extends Button implements C0514r, C0534b {
    /* renamed from: b */
    private final C0795h f8838b;
    /* renamed from: c */
    private final C0810z f8839c;

    public C3321i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.buttonStyle);
    }

    public C3321i(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8838b = new C0795h(this);
        this.f8838b.m2877a(attributeSet, i);
        this.f8839c = C0810z.m2939a((TextView) this);
        this.f8839c.mo604a(attributeSet, i);
        this.f8839c.mo603a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8838b != null) {
            this.f8838b.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8838b != null) {
            this.f8838b.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8838b != null) {
            this.f8838b.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8838b != null ? this.f8838b.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8838b != null) {
            this.f8838b.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8838b != null ? this.f8838b.m2878b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8838b != null) {
            this.f8838b.m2880c();
        }
        if (this.f8839c != null) {
            this.f8839c.mo603a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f8839c != null) {
            this.f8839c.m2948a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8839c != null) {
            this.f8839c.m2952a(z, i, i2, i3, i4);
        }
    }

    public void setTextSize(int i, float f) {
        if (a) {
            super.setTextSize(i, f);
        } else if (this.f8839c != null) {
            this.f8839c.m2946a(i, f);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f8839c != null && a == null && this.f8839c.m2955c() != null) {
            this.f8839c.m2954b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (a) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f8839c != null) {
            this.f8839c.m2945a(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f8839c != null) {
            this.f8839c.m2947a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f8839c != null) {
            this.f8839c.m2953a(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        int i = 0;
        if (a) {
            if (super.getAutoSizeTextType() == 1) {
                i = 1;
            }
            return i;
        } else if (this.f8839c != null) {
            return this.f8839c.m2956d();
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (a) {
            return super.getAutoSizeStepGranularity();
        }
        return this.f8839c != null ? this.f8839c.m2957e() : -1;
    }

    public int getAutoSizeMinTextSize() {
        if (a) {
            return super.getAutoSizeMinTextSize();
        }
        return this.f8839c != null ? this.f8839c.m2958f() : -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (a) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.f8839c != null ? this.f8839c.m2959g() : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f8839c != null) {
            return this.f8839c.m2960h();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f8839c != null) {
            this.f8839c.m2951a(z);
        }
    }
}
