package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p024c.p025a.C3189c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuWrapperICS */
/* renamed from: android.support.v7.view.menu.v */
class C4834v extends C4485r implements SubMenu {
    C4834v(Context context, C3189c c3189c) {
        super(context, c3189c);
    }

    /* renamed from: b */
    public C3189c m17153b() {
        return (C3189c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m17153b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m17153b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m17153b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m17153b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m17153b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m17153b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m17153b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m17153b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m10028a(m17153b().getItem());
    }
}
