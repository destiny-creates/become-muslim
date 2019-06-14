package android.support.v4.p020a.p021a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompat */
/* renamed from: android.support.v4.a.a.a */
public final class C0259a {
    /* renamed from: a */
    private static Method f654a;
    /* renamed from: b */
    private static boolean f655b;
    /* renamed from: c */
    private static Method f656c;
    /* renamed from: d */
    private static boolean f657d;

    @Deprecated
    /* renamed from: a */
    public static void m688a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: a */
    public static void m696a(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* renamed from: b */
    public static boolean m697b(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.isAutoMirrored() : null;
    }

    /* renamed from: a */
    public static void m689a(Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    /* renamed from: a */
    public static void m691a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m690a(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof C0261c) {
            ((C0261c) drawable).setTint(i);
        }
    }

    /* renamed from: a */
    public static void m692a(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof C0261c) {
            ((C0261c) drawable).setTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m695a(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof C0261c) {
            ((C0261c) drawable).setTintMode(mode);
        }
    }

    /* renamed from: c */
    public static int m699c(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.getAlpha() : null;
    }

    /* renamed from: a */
    public static void m693a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: d */
    public static boolean m700d(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.canApplyTheme() : null;
    }

    /* renamed from: e */
    public static ColorFilter m701e(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.getColorFilter() : null;
    }

    /* renamed from: f */
    public static void m702f(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
        } else if (VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                C0259a.m702f(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof C0262d) {
                C0259a.m702f(((C0262d) drawable).mo162a());
            } else if (drawable instanceof DrawableContainer) {
                DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                if (drawableContainerState != null) {
                    int childCount = drawableContainerState.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        Drawable child = drawableContainerState.getChild(i);
                        if (child != null) {
                            C0259a.m702f(child);
                        }
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    /* renamed from: a */
    public static void m694a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* renamed from: g */
    public static Drawable m703g(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable;
        }
        return VERSION.SDK_INT >= 21 ? !(drawable instanceof C0261c) ? new C4824g(drawable) : drawable : VERSION.SDK_INT >= 19 ? !(drawable instanceof C0261c) ? new C4452f(drawable) : drawable : !(drawable instanceof C0261c) ? new C3159e(drawable) : drawable;
    }

    /* renamed from: h */
    public static <T extends Drawable> T m704h(Drawable drawable) {
        return drawable instanceof C0262d ? ((C0262d) drawable).mo162a() : drawable;
    }

    /* renamed from: b */
    public static boolean m698b(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!f655b) {
            try {
                f654a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f654a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f655b = true;
        }
        if (f654a != null) {
            try {
                f654a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Drawable drawable2) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", drawable2);
                f654a = null;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static int m705i(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (VERSION.SDK_INT < 17) {
            return 0;
        }
        if (!f657d) {
            try {
                f656c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f656c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
            }
            f657d = true;
        }
        if (f656c != null) {
            try {
                return ((Integer) f656c.invoke(drawable, new Object[0])).intValue();
            } catch (Drawable drawable2) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", drawable2);
                f656c = null;
            }
        }
        return 0;
    }

    private C0259a() {
    }
}
