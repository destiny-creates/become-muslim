package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompat */
/* renamed from: android.support.v4.widget.e */
public final class C0542e {
    /* renamed from: a */
    private static final C0541c f1381a;

    /* compiled from: CompoundButtonCompat */
    /* renamed from: android.support.v4.widget.e$c */
    static class C0541c {
        /* renamed from: a */
        private static Field f1379a;
        /* renamed from: b */
        private static boolean f1380b;

        C0541c() {
        }

        /* renamed from: a */
        public void mo329a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof C0574s) {
                ((C0574s) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo330a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof C0574s) {
                ((C0574s) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        /* renamed from: a */
        public Drawable mo2704a(CompoundButton compoundButton) {
            if (!f1380b) {
                try {
                    f1379a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f1379a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f1380b = true;
            }
            if (f1379a != null) {
                try {
                    return (Drawable) f1379a.get(compoundButton);
                } catch (CompoundButton compoundButton2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", compoundButton2);
                    f1379a = null;
                }
            }
            return null;
        }
    }

    /* compiled from: CompoundButtonCompat */
    /* renamed from: android.support.v4.widget.e$a */
    static class C3234a extends C0541c {
        C3234a() {
        }

        /* renamed from: a */
        public void mo329a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        /* renamed from: a */
        public void mo330a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* compiled from: CompoundButtonCompat */
    /* renamed from: android.support.v4.widget.e$b */
    static class C4468b extends C3234a {
        C4468b() {
        }

        /* renamed from: a */
        public Drawable mo2704a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1381a = new C4468b();
        } else if (VERSION.SDK_INT >= 21) {
            f1381a = new C3234a();
        } else {
            f1381a = new C0541c();
        }
    }

    /* renamed from: a */
    public static void m1859a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1381a.mo329a(compoundButton, colorStateList);
    }

    /* renamed from: a */
    public static void m1860a(CompoundButton compoundButton, Mode mode) {
        f1381a.mo330a(compoundButton, mode);
    }

    /* renamed from: a */
    public static Drawable m1858a(CompoundButton compoundButton) {
        return f1381a.mo2704a(compoundButton);
    }
}
