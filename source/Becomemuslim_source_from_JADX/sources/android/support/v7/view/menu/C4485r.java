package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p024c.p025a.C0350a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperICS */
/* renamed from: android.support.v7.view.menu.r */
class C4485r extends C3270c<C0350a> implements Menu {
    C4485r(Context context, C0350a c0350a) {
        super(context, c0350a);
    }

    public MenuItem add(CharSequence charSequence) {
        return m10028a((MenuItem) ((C0350a) this.b).add(charSequence));
    }

    public MenuItem add(int i) {
        return m10028a((MenuItem) ((C0350a) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m10028a((MenuItem) ((C0350a) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m10028a((MenuItem) ((C0350a) this.b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m10029a((SubMenu) ((C0350a) this.b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m10029a((SubMenu) ((C0350a) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m10029a((SubMenu) ((C0350a) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m10029a((SubMenu) ((C0350a) this.b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        C4485r c4485r = this;
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((C0350a) c4485r.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = m10028a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        m10032b(i);
        ((C0350a) this.b).removeItem(i);
    }

    public void removeGroup(int i) {
        m10031a(i);
        ((C0350a) this.b).removeGroup(i);
    }

    public void clear() {
        m10030a();
        ((C0350a) this.b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0350a) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0350a) this.b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0350a) this.b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0350a) this.b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m10028a((MenuItem) ((C0350a) this.b).findItem(i));
    }

    public int size() {
        return ((C0350a) this.b).size();
    }

    public MenuItem getItem(int i) {
        return m10028a((MenuItem) ((C0350a) this.b).getItem(i));
    }

    public void close() {
        ((C0350a) this.b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0350a) this.b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0350a) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0350a) this.b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0350a) this.b).setQwertyMode(z);
    }
}
