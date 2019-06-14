package android.support.v4.p024c.p025a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.C0497c;
import android.view.MenuItem;
import android.view.View;

/* compiled from: SupportMenuItem */
/* renamed from: android.support.v4.c.a.b */
public interface C0351b extends MenuItem {
    /* renamed from: a */
    C0351b mo440a(C0497c c0497c);

    /* renamed from: a */
    C0351b mo441a(CharSequence charSequence);

    /* renamed from: a */
    C0497c mo442a();

    /* renamed from: b */
    C0351b mo443b(CharSequence charSequence);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c, int i);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(Mode mode);

    MenuItem setNumericShortcut(char c, int i);

    MenuItem setShortcut(char c, char c2, int i, int i2);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
