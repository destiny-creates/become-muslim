package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.p024c.p025a.C0351b;
import android.util.Log;
import android.view.MenuItem;

/* compiled from: MenuItemCompat */
/* renamed from: android.support.v4.view.h */
public final class C0506h {
    /* renamed from: a */
    static final C0505c f1275a;

    /* compiled from: MenuItemCompat */
    /* renamed from: android.support.v4.view.h$c */
    interface C0505c {
        /* renamed from: a */
        void mo319a(MenuItem menuItem, char c, int i);

        /* renamed from: a */
        void mo320a(MenuItem menuItem, ColorStateList colorStateList);

        /* renamed from: a */
        void mo321a(MenuItem menuItem, Mode mode);

        /* renamed from: a */
        void mo322a(MenuItem menuItem, CharSequence charSequence);

        /* renamed from: b */
        void mo323b(MenuItem menuItem, char c, int i);

        /* renamed from: b */
        void mo324b(MenuItem menuItem, CharSequence charSequence);
    }

    /* compiled from: MenuItemCompat */
    /* renamed from: android.support.v4.view.h$b */
    static class C3225b implements C0505c {
        /* renamed from: a */
        public void mo319a(MenuItem menuItem, char c, int i) {
        }

        /* renamed from: a */
        public void mo320a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        /* renamed from: a */
        public void mo321a(MenuItem menuItem, Mode mode) {
        }

        /* renamed from: a */
        public void mo322a(MenuItem menuItem, CharSequence charSequence) {
        }

        /* renamed from: b */
        public void mo323b(MenuItem menuItem, char c, int i) {
        }

        /* renamed from: b */
        public void mo324b(MenuItem menuItem, CharSequence charSequence) {
        }

        C3225b() {
        }
    }

    /* compiled from: MenuItemCompat */
    /* renamed from: android.support.v4.view.h$a */
    static class C4464a extends C3225b {
        C4464a() {
        }

        /* renamed from: a */
        public void mo322a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        /* renamed from: b */
        public void mo324b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        /* renamed from: a */
        public void mo319a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        /* renamed from: b */
        public void mo323b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        /* renamed from: a */
        public void mo320a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        /* renamed from: a */
        public void mo321a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1275a = new C4464a();
        } else {
            f1275a = new C3225b();
        }
    }

    /* renamed from: a */
    public static MenuItem m1600a(MenuItem menuItem, C0497c c0497c) {
        if (menuItem instanceof C0351b) {
            return ((C0351b) menuItem).mo440a(c0497c);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: a */
    public static void m1604a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).mo441a(charSequence);
        } else {
            f1275a.mo322a(menuItem, charSequence);
        }
    }

    /* renamed from: b */
    public static void m1606b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).mo443b(charSequence);
        } else {
            f1275a.mo324b(menuItem, charSequence);
        }
    }

    /* renamed from: a */
    public static void m1601a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).setNumericShortcut(c, i);
        } else {
            f1275a.mo323b(menuItem, c, i);
        }
    }

    /* renamed from: b */
    public static void m1605b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).setAlphabeticShortcut(c, i);
        } else {
            f1275a.mo319a(menuItem, c, i);
        }
    }

    /* renamed from: a */
    public static void m1602a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).setIconTintList(colorStateList);
        } else {
            f1275a.mo320a(menuItem, colorStateList);
        }
    }

    /* renamed from: a */
    public static void m1603a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof C0351b) {
            ((C0351b) menuItem).setIconTintMode(mode);
        } else {
            f1275a.mo321a(menuItem, mode);
        }
    }
}
