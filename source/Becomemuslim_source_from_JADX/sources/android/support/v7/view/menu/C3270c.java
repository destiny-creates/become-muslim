package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.p024c.p025a.C3189c;
import android.support.v4.util.C3211a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper */
/* renamed from: android.support.v7.view.menu.c */
abstract class C3270c<T> extends C0650d<T> {
    /* renamed from: a */
    final Context f8471a;
    /* renamed from: c */
    private Map<C0351b, MenuItem> f8472c;
    /* renamed from: d */
    private Map<C3189c, SubMenu> f8473d;

    C3270c(Context context, T t) {
        super(t);
        this.f8471a = context;
    }

    /* renamed from: a */
    final MenuItem m10028a(MenuItem menuItem) {
        if (!(menuItem instanceof C0351b)) {
            return menuItem;
        }
        C0351b c0351b = (C0351b) menuItem;
        if (this.f8472c == null) {
            this.f8472c = new C3211a();
        }
        menuItem = (MenuItem) this.f8472c.get(menuItem);
        if (menuItem == null) {
            menuItem = C0665q.m2215a(this.f8471a, c0351b);
            this.f8472c.put(c0351b, menuItem);
        }
        return menuItem;
    }

    /* renamed from: a */
    final SubMenu m10029a(SubMenu subMenu) {
        if (!(subMenu instanceof C3189c)) {
            return subMenu;
        }
        C3189c c3189c = (C3189c) subMenu;
        if (this.f8473d == null) {
            this.f8473d = new C3211a();
        }
        SubMenu subMenu2 = (SubMenu) this.f8473d.get(c3189c);
        if (subMenu2 == null) {
            subMenu2 = C0665q.m2216a(this.f8471a, c3189c);
            this.f8473d.put(c3189c, subMenu2);
        }
        return subMenu2;
    }

    /* renamed from: a */
    final void m10030a() {
        if (this.f8472c != null) {
            this.f8472c.clear();
        }
        if (this.f8473d != null) {
            this.f8473d.clear();
        }
    }

    /* renamed from: a */
    final void m10031a(int i) {
        if (this.f8472c != null) {
            Iterator it = this.f8472c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: b */
    final void m10032b(int i) {
        if (this.f8472c != null) {
            Iterator it = this.f8472c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
    }
}
