package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.widget.C0542e;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper */
/* renamed from: android.support.v7.widget.l */
class C0797l {
    /* renamed from: a */
    private final CompoundButton f2212a;
    /* renamed from: b */
    private ColorStateList f2213b = null;
    /* renamed from: c */
    private Mode f2214c = null;
    /* renamed from: d */
    private boolean f2215d = false;
    /* renamed from: e */
    private boolean f2216e = false;
    /* renamed from: f */
    private boolean f2217f;

    C0797l(CompoundButton compoundButton) {
        this.f2212a = compoundButton;
    }

    /* renamed from: a */
    void m2885a(AttributeSet attributeSet, int i) {
        attributeSet = this.f2212a.getContext().obtainStyledAttributes(attributeSet, C0590j.CompoundButton, i, 0);
        try {
            if (attributeSet.hasValue(C0590j.CompoundButton_android_button) != 0) {
                i = attributeSet.getResourceId(C0590j.CompoundButton_android_button, 0);
                if (i != 0) {
                    this.f2212a.setButtonDrawable(C0631b.m2112b(this.f2212a.getContext(), i));
                }
            }
            if (attributeSet.hasValue(C0590j.CompoundButton_buttonTint) != 0) {
                C0542e.m1859a(this.f2212a, attributeSet.getColorStateList(C0590j.CompoundButton_buttonTint));
            }
            if (attributeSet.hasValue(C0590j.CompoundButton_buttonTintMode) != 0) {
                C0542e.m1860a(this.f2212a, al.m2612a(attributeSet.getInt(C0590j.CompoundButton_buttonTintMode, -1), null));
            }
            attributeSet.recycle();
        } catch (Throwable th) {
            attributeSet.recycle();
        }
    }

    /* renamed from: a */
    void m2883a(ColorStateList colorStateList) {
        this.f2213b = colorStateList;
        this.f2215d = true;
        m2888d();
    }

    /* renamed from: a */
    ColorStateList m2882a() {
        return this.f2213b;
    }

    /* renamed from: a */
    void m2884a(Mode mode) {
        this.f2214c = mode;
        this.f2216e = true;
        m2888d();
    }

    /* renamed from: b */
    Mode m2886b() {
        return this.f2214c;
    }

    /* renamed from: c */
    void m2887c() {
        if (this.f2217f) {
            this.f2217f = false;
            return;
        }
        this.f2217f = true;
        m2888d();
    }

    /* renamed from: d */
    void m2888d() {
        Drawable a = C0542e.m1858a(this.f2212a);
        if (a == null) {
            return;
        }
        if (this.f2215d || this.f2216e) {
            a = C0259a.m703g(a).mutate();
            if (this.f2215d) {
                C0259a.m692a(a, this.f2213b);
            }
            if (this.f2216e) {
                C0259a.m695a(a, this.f2214c);
            }
            if (a.isStateful()) {
                a.setState(this.f2212a.getDrawableState());
            }
            this.f2212a.setButtonDrawable(a);
        }
    }

    /* renamed from: a */
    int m2881a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0542e.m1858a(this.f2212a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }
}
