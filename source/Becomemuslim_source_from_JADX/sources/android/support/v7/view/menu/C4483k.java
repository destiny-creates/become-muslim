package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.view.C0497c;
import android.support.v7.view.C0641c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
/* renamed from: android.support.v7.view.menu.k */
public class C4483k extends C3270c<C0351b> implements MenuItem {
    /* renamed from: c */
    private Method f12020c;

    /* compiled from: MenuItemWrapperICS */
    /* renamed from: android.support.v7.view.menu.k$a */
    class C3277a extends C0497c {
        /* renamed from: a */
        final ActionProvider f8550a;
        /* renamed from: b */
        final /* synthetic */ C4483k f8551b;

        public C3277a(C4483k c4483k, Context context, ActionProvider actionProvider) {
            this.f8551b = c4483k;
            super(context);
            this.f8550a = actionProvider;
        }

        /* renamed from: a */
        public View mo474a() {
            return this.f8550a.onCreateActionView();
        }

        /* renamed from: d */
        public boolean mo476d() {
            return this.f8550a.onPerformDefaultAction();
        }

        /* renamed from: e */
        public boolean mo477e() {
            return this.f8550a.hasSubMenu();
        }

        /* renamed from: a */
        public void mo475a(SubMenu subMenu) {
            this.f8550a.onPrepareSubMenu(this.f8551b.m10029a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    /* renamed from: android.support.v7.view.menu.k$b */
    static class C3278b extends FrameLayout implements C0641c {
        /* renamed from: a */
        final CollapsibleActionView f8552a;

        C3278b(View view) {
            super(view.getContext());
            this.f8552a = (CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public void mo478a() {
            this.f8552a.onActionViewExpanded();
        }

        /* renamed from: b */
        public void mo479b() {
            this.f8552a.onActionViewCollapsed();
        }

        /* renamed from: c */
        View m10140c() {
            return (View) this.f8552a;
        }
    }

    /* compiled from: MenuItemWrapperICS */
    /* renamed from: android.support.v7.view.menu.k$c */
    private class C3279c extends C0650d<OnActionExpandListener> implements OnActionExpandListener {
        /* renamed from: a */
        final /* synthetic */ C4483k f8553a;

        C3279c(C4483k c4483k, OnActionExpandListener onActionExpandListener) {
            this.f8553a = c4483k;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f8553a.m10028a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f8553a.m10028a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    /* renamed from: android.support.v7.view.menu.k$d */
    private class C3280d extends C0650d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C4483k f8554a;

        C3280d(C4483k c4483k, OnMenuItemClickListener onMenuItemClickListener) {
            this.f8554a = c4483k;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f8554a.m10028a(menuItem));
        }
    }

    C4483k(Context context, C0351b c0351b) {
        super(context, c0351b);
    }

    public int getItemId() {
        return ((C0351b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((C0351b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((C0351b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0351b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0351b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0351b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0351b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0351b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0351b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0351b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0351b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0351b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0351b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0351b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((C0351b) this.b).setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0351b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((C0351b) this.b).setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0351b) this.b).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((C0351b) this.b).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0351b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((C0351b) this.b).setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0351b) this.b).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((C0351b) this.b).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0351b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0351b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0351b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0351b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0351b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0351b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0351b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0351b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0351b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m10029a(((C0351b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0351b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C3280d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0351b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0351b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0351b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C3278b(view);
        }
        ((C0351b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0351b) this.b).setActionView(i);
        i = ((C0351b) this.b).getActionView();
        if (i instanceof CollapsibleActionView) {
            ((C0351b) this.b).setActionView(new C3278b(i));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0351b) this.b).getActionView();
        return actionView instanceof C3278b ? ((C3278b) actionView).m10140c() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0351b) this.b).mo440a(actionProvider != null ? mo3340a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0497c a = ((C0351b) this.b).mo442a();
        return a instanceof C3277a ? ((C3277a) a).f8550a : null;
    }

    public boolean expandActionView() {
        return ((C0351b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0351b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0351b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0351b) this.b).setOnActionExpandListener(onActionExpandListener != null ? new C3279c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((C0351b) this.b).mo441a(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((C0351b) this.b).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((C0351b) this.b).mo443b(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((C0351b) this.b).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((C0351b) this.b).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((C0351b) this.b).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((C0351b) this.b).setIconTintMode(mode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((C0351b) this.b).getIconTintMode();
    }

    /* renamed from: a */
    public void m15093a(boolean z) {
        try {
            if (this.f12020c == null) {
                this.f12020c = ((C0351b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f12020c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (boolean z2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", z2);
        }
    }

    /* renamed from: a */
    C3277a mo3340a(ActionProvider actionProvider) {
        return new C3277a(this, this.a, actionProvider);
    }
}
