package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p024c.p025a.C0350a;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.p024c.p025a.C3189c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperFactory */
/* renamed from: android.support.v7.view.menu.q */
public final class C0665q {
    /* renamed from: a */
    public static Menu m2214a(Context context, C0350a c0350a) {
        return new C4485r(context, c0350a);
    }

    /* renamed from: a */
    public static MenuItem m2215a(Context context, C0351b c0351b) {
        if (VERSION.SDK_INT >= 16) {
            return new C4833l(context, c0351b);
        }
        return new C4483k(context, c0351b);
    }

    /* renamed from: a */
    public static SubMenu m2216a(Context context, C3189c c3189c) {
        return new C4834v(context, c3189c);
    }
}
