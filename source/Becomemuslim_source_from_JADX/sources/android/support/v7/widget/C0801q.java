package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.C0557k;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageHelper */
/* renamed from: android.support.v7.widget.q */
public class C0801q {
    /* renamed from: a */
    private final ImageView f2234a;
    /* renamed from: b */
    private bo f2235b;
    /* renamed from: c */
    private bo f2236c;
    /* renamed from: d */
    private bo f2237d;

    public C0801q(ImageView imageView) {
        this.f2234a = imageView;
    }

    /* renamed from: a */
    public void m2926a(AttributeSet attributeSet, int i) {
        attributeSet = bq.m2769a(this.f2234a.getContext(), attributeSet, C0590j.AppCompatImageView, i, 0);
        try {
            i = this.f2234a.getDrawable();
            if (i == 0) {
                int g = attributeSet.m2786g(C0590j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    i = C0631b.m2112b(this.f2234a.getContext(), g);
                    if (i != 0) {
                        this.f2234a.setImageDrawable(i);
                    }
                }
            }
            if (i != 0) {
                al.m2614b(i);
            }
            if (attributeSet.m2787g(C0590j.AppCompatImageView_tint) != 0) {
                C0557k.m1886a(this.f2234a, attributeSet.m2783e(C0590j.AppCompatImageView_tint));
            }
            if (attributeSet.m2787g(C0590j.AppCompatImageView_tintMode) != 0) {
                C0557k.m1887a(this.f2234a, al.m2612a(attributeSet.m2771a(C0590j.AppCompatImageView_tintMode, -1), null));
            }
            attributeSet.m2774a();
        } catch (Throwable th) {
            attributeSet.m2774a();
        }
    }

    /* renamed from: a */
    public void m2923a(int i) {
        if (i != 0) {
            i = C0631b.m2112b(this.f2234a.getContext(), i);
            if (i != 0) {
                al.m2614b(i);
            }
            this.f2234a.setImageDrawable(i);
        } else {
            this.f2234a.setImageDrawable(null);
        }
        m2930d();
    }

    /* renamed from: a */
    boolean m2927a() {
        return VERSION.SDK_INT < 21 || !(this.f2234a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: a */
    void m2924a(ColorStateList colorStateList) {
        if (this.f2236c == null) {
            this.f2236c = new bo();
        }
        this.f2236c.f2133a = colorStateList;
        this.f2236c.f2136d = true;
        m2930d();
    }

    /* renamed from: b */
    ColorStateList m2928b() {
        return this.f2236c != null ? this.f2236c.f2133a : null;
    }

    /* renamed from: a */
    void m2925a(Mode mode) {
        if (this.f2236c == null) {
            this.f2236c = new bo();
        }
        this.f2236c.f2134b = mode;
        this.f2236c.f2135c = true;
        m2930d();
    }

    /* renamed from: c */
    Mode m2929c() {
        return this.f2236c != null ? this.f2236c.f2134b : null;
    }

    /* renamed from: d */
    void m2930d() {
        Drawable drawable = this.f2234a.getDrawable();
        if (drawable != null) {
            al.m2614b(drawable);
        }
        if (drawable != null && (!m2922e() || !m2921a(drawable))) {
            if (this.f2236c != null) {
                C0799m.m2899a(drawable, this.f2236c, this.f2234a.getDrawableState());
            } else if (this.f2235b != null) {
                C0799m.m2899a(drawable, this.f2235b, this.f2234a.getDrawableState());
            }
        }
    }

    /* renamed from: e */
    private boolean m2922e() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        } else {
            if (this.f2235b != null) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: a */
    private boolean m2921a(Drawable drawable) {
        if (this.f2237d == null) {
            this.f2237d = new bo();
        }
        bo boVar = this.f2237d;
        boVar.m2766a();
        ColorStateList a = C0557k.m1885a(this.f2234a);
        if (a != null) {
            boVar.f2136d = true;
            boVar.f2133a = a;
        }
        Mode b = C0557k.m1888b(this.f2234a);
        if (b != null) {
            boVar.f2135c = true;
            boVar.f2134b = b;
        }
        if (!boVar.f2136d) {
            if (!boVar.f2135c) {
                return null;
            }
        }
        C0799m.m2899a(drawable, boVar, this.f2234a.getDrawableState());
        return true;
    }
}
