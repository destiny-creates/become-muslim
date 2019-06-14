package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper */
/* renamed from: android.support.v7.widget.h */
class C0795h {
    /* renamed from: a */
    private final View f2204a;
    /* renamed from: b */
    private final C0799m f2205b;
    /* renamed from: c */
    private int f2206c = -1;
    /* renamed from: d */
    private bo f2207d;
    /* renamed from: e */
    private bo f2208e;
    /* renamed from: f */
    private bo f2209f;

    C0795h(View view) {
        this.f2204a = view;
        this.f2205b = C0799m.m2896a();
    }

    /* renamed from: a */
    void m2877a(AttributeSet attributeSet, int i) {
        attributeSet = bq.m2769a(this.f2204a.getContext(), attributeSet, C0590j.ViewBackgroundHelper, i, 0);
        try {
            if (attributeSet.m2787g(C0590j.ViewBackgroundHelper_android_background) != 0) {
                this.f2206c = attributeSet.m2786g(C0590j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f2205b.m2919b(this.f2204a.getContext(), this.f2206c);
                if (b != 0) {
                    m2879b(b);
                }
            }
            if (attributeSet.m2787g(C0590j.ViewBackgroundHelper_backgroundTint) != 0) {
                C0517s.m1691a(this.f2204a, attributeSet.m2783e(C0590j.ViewBackgroundHelper_backgroundTint));
            }
            if (attributeSet.m2787g(C0590j.ViewBackgroundHelper_backgroundTintMode) != 0) {
                C0517s.m1692a(this.f2204a, al.m2612a(attributeSet.m2771a(C0590j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            attributeSet.m2774a();
        } catch (Throwable th) {
            attributeSet.m2774a();
        }
    }

    /* renamed from: a */
    void m2873a(int i) {
        this.f2206c = i;
        m2879b(this.f2205b != null ? this.f2205b.m2919b(this.f2204a.getContext(), i) : 0);
        m2880c();
    }

    /* renamed from: a */
    void m2876a(Drawable drawable) {
        this.f2206c = -1;
        m2879b((ColorStateList) null);
        m2880c();
    }

    /* renamed from: a */
    void m2874a(ColorStateList colorStateList) {
        if (this.f2208e == null) {
            this.f2208e = new bo();
        }
        this.f2208e.f2133a = colorStateList;
        this.f2208e.f2136d = true;
        m2880c();
    }

    /* renamed from: a */
    ColorStateList m2872a() {
        return this.f2208e != null ? this.f2208e.f2133a : null;
    }

    /* renamed from: a */
    void m2875a(Mode mode) {
        if (this.f2208e == null) {
            this.f2208e = new bo();
        }
        this.f2208e.f2134b = mode;
        this.f2208e.f2135c = true;
        m2880c();
    }

    /* renamed from: b */
    Mode m2878b() {
        return this.f2208e != null ? this.f2208e.f2134b : null;
    }

    /* renamed from: c */
    void m2880c() {
        Drawable background = this.f2204a.getBackground();
        if (background != null && (!m2871d() || !m2870b(background))) {
            if (this.f2208e != null) {
                C0799m.m2899a(background, this.f2208e, this.f2204a.getDrawableState());
            } else if (this.f2207d != null) {
                C0799m.m2899a(background, this.f2207d, this.f2204a.getDrawableState());
            }
        }
    }

    /* renamed from: b */
    void m2879b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2207d == null) {
                this.f2207d = new bo();
            }
            this.f2207d.f2133a = colorStateList;
            this.f2207d.f2136d = true;
        } else {
            this.f2207d = null;
        }
        m2880c();
    }

    /* renamed from: d */
    private boolean m2871d() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        } else {
            if (this.f2207d != null) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: b */
    private boolean m2870b(Drawable drawable) {
        if (this.f2209f == null) {
            this.f2209f = new bo();
        }
        bo boVar = this.f2209f;
        boVar.m2766a();
        ColorStateList s = C0517s.m1725s(this.f2204a);
        if (s != null) {
            boVar.f2136d = true;
            boVar.f2133a = s;
        }
        Mode t = C0517s.m1726t(this.f2204a);
        if (t != null) {
            boVar.f2135c = true;
            boVar.f2134b = t;
        }
        if (!boVar.f2136d) {
            if (!boVar.f2135c) {
                return null;
            }
        }
        C0799m.m2899a(drawable, boVar, this.f2204a.getDrawableState());
        return true;
    }
}
