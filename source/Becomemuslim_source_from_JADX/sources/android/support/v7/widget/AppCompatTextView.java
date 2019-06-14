package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0514r;
import android.support.v4.widget.C0534b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements C0514r, C0534b {
    /* renamed from: b */
    private final C0795h f8617b;
    /* renamed from: c */
    private final C0810z f8618c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(bn.m2764a(context), attributeSet, i);
        this.f8617b = new C0795h(this);
        this.f8617b.m2877a(attributeSet, i);
        this.f8618c = C0810z.m2939a((TextView) this);
        this.f8618c.mo604a(attributeSet, i);
        this.f8618c.mo603a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8617b != null) {
            this.f8617b.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8617b != null) {
            this.f8617b.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8617b != null) {
            this.f8617b.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8617b != null ? this.f8617b.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8617b != null) {
            this.f8617b.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8617b != null ? this.f8617b.m2878b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f8618c != null) {
            this.f8618c.m2948a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8617b != null) {
            this.f8617b.m2880c();
        }
        if (this.f8618c != null) {
            this.f8618c.mo603a();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8618c != null) {
            this.f8618c.m2952a(z, i, i2, i3, i4);
        }
    }

    public void setTextSize(int i, float f) {
        if (a) {
            super.setTextSize(i, f);
        } else if (this.f8618c != null) {
            this.f8618c.m2946a(i, f);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f8618c != null && a == null && this.f8618c.m2955c() != null) {
            this.f8618c.m2954b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (a) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f8618c != null) {
            this.f8618c.m2945a(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f8618c != null) {
            this.f8618c.m2947a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f8618c != null) {
            this.f8618c.m2953a(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        int i = 0;
        if (a) {
            if (super.getAutoSizeTextType() == 1) {
                i = 1;
            }
            return i;
        } else if (this.f8618c != null) {
            return this.f8618c.m2956d();
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (a) {
            return super.getAutoSizeStepGranularity();
        }
        return this.f8618c != null ? this.f8618c.m2957e() : -1;
    }

    public int getAutoSizeMinTextSize() {
        if (a) {
            return super.getAutoSizeMinTextSize();
        }
        return this.f8618c != null ? this.f8618c.m2958f() : -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (a) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.f8618c != null ? this.f8618c.m2959g() : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f8618c != null) {
            return this.f8618c.m2960h();
        }
        return new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0800o.m2920a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
