package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C3273h.C0657a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder */
/* renamed from: android.support.v7.view.menu.u */
public class C4487u extends C3273h implements SubMenu {
    /* renamed from: d */
    private C3273h f12043d;
    /* renamed from: e */
    private C3276j f12044e;

    public C4487u(Context context, C3273h c3273h, C3276j c3276j) {
        super(context);
        this.f12043d = c3273h;
        this.f12044e = c3276j;
    }

    public void setQwertyMode(boolean z) {
        this.f12043d.setQwertyMode(z);
    }

    /* renamed from: b */
    public boolean mo2751b() {
        return this.f12043d.mo2751b();
    }

    /* renamed from: c */
    public boolean mo2752c() {
        return this.f12043d.mo2752c();
    }

    /* renamed from: s */
    public Menu m15127s() {
        return this.f12043d;
    }

    public MenuItem getItem() {
        return this.f12044e;
    }

    /* renamed from: a */
    public void mo2749a(C0657a c0657a) {
        this.f12043d.mo2749a(c0657a);
    }

    /* renamed from: p */
    public C3273h mo2755p() {
        return this.f12043d.mo2755p();
    }

    /* renamed from: a */
    boolean mo2750a(C3273h c3273h, MenuItem menuItem) {
        if (!super.mo2750a(c3273h, menuItem)) {
            if (this.f12043d.mo2750a(c3273h, menuItem) == null) {
                return null;
            }
        }
        return true;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f12044e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f12044e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m10055a(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m10086e(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m10057a(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m10083d(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m10056a(view);
    }

    /* renamed from: c */
    public boolean mo2753c(C3276j c3276j) {
        return this.f12043d.mo2753c(c3276j);
    }

    /* renamed from: d */
    public boolean mo2754d(C3276j c3276j) {
        return this.f12043d.mo2754d(c3276j);
    }

    /* renamed from: a */
    public String mo2748a() {
        int itemId = this.f12044e != null ? this.f12044e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.mo2748a());
        stringBuilder.append(":");
        stringBuilder.append(itemId);
        return stringBuilder.toString();
    }
}
