package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p030f.C0386a;
import android.widget.TextView;

/* compiled from: TextViewCompat */
/* renamed from: android.support.v4.widget.r */
public final class C0573r {
    /* renamed from: a */
    static final C0572g f1410a;

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$g */
    static class C0572g {
        C0572g() {
        }

        /* renamed from: a */
        public void mo2708a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: a */
        public void mo3483a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        /* renamed from: a */
        public Drawable[] mo2709a(TextView textView) {
            return textView.getCompoundDrawables();
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$a */
    static class C3245a extends C0572g {
        C3245a() {
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$b */
    static class C4472b extends C3245a {
        C4472b() {
        }

        /* renamed from: a */
        public void mo2708a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        /* renamed from: a */
        public Drawable[] mo2709a(TextView textView) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            textView = textView.getCompoundDrawables();
            if (obj != null) {
                obj = textView[2];
                Object obj2 = textView[0];
                textView[0] = obj;
                textView[2] = obj2;
            }
            return textView;
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$c */
    static class C4830c extends C4472b {
        C4830c() {
        }

        /* renamed from: a */
        public void mo2708a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: a */
        public Drawable[] mo2709a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$d */
    static class C4892d extends C4830c {
        C4892d() {
        }

        /* renamed from: a */
        public void mo3483a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$e */
    static class C4907e extends C4892d {
        C4907e() {
        }
    }

    /* compiled from: TextViewCompat */
    /* renamed from: android.support.v4.widget.r$f */
    static class C4913f extends C4907e {
        C4913f() {
        }
    }

    static {
        if (C0386a.m1165a()) {
            f1410a = new C4913f();
        } else if (VERSION.SDK_INT >= 26) {
            f1410a = new C4907e();
        } else if (VERSION.SDK_INT >= 23) {
            f1410a = new C4892d();
        } else if (VERSION.SDK_INT >= 18) {
            f1410a = new C4830c();
        } else if (VERSION.SDK_INT >= 17) {
            f1410a = new C4472b();
        } else if (VERSION.SDK_INT >= 16) {
            f1410a = new C3245a();
        } else {
            f1410a = new C0572g();
        }
    }

    /* renamed from: a */
    public static void m1903a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1410a.mo2708a(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: a */
    public static void m1902a(TextView textView, int i) {
        f1410a.mo3483a(textView, i);
    }

    /* renamed from: a */
    public static Drawable[] m1904a(TextView textView) {
        return f1410a.mo2709a(textView);
    }
}
