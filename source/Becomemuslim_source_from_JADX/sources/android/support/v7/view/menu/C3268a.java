package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.C0366b;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.view.C0497c;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem */
/* renamed from: android.support.v7.view.menu.a */
public class C3268a implements C0351b {
    /* renamed from: a */
    private final int f8439a;
    /* renamed from: b */
    private final int f8440b;
    /* renamed from: c */
    private final int f8441c;
    /* renamed from: d */
    private final int f8442d;
    /* renamed from: e */
    private CharSequence f8443e;
    /* renamed from: f */
    private CharSequence f8444f;
    /* renamed from: g */
    private Intent f8445g;
    /* renamed from: h */
    private char f8446h;
    /* renamed from: i */
    private int f8447i = 4096;
    /* renamed from: j */
    private char f8448j;
    /* renamed from: k */
    private int f8449k = 4096;
    /* renamed from: l */
    private Drawable f8450l;
    /* renamed from: m */
    private int f8451m = 0;
    /* renamed from: n */
    private Context f8452n;
    /* renamed from: o */
    private OnMenuItemClickListener f8453o;
    /* renamed from: p */
    private CharSequence f8454p;
    /* renamed from: q */
    private CharSequence f8455q;
    /* renamed from: r */
    private ColorStateList f8456r = null;
    /* renamed from: s */
    private Mode f8457s = null;
    /* renamed from: t */
    private boolean f8458t = false;
    /* renamed from: u */
    private boolean f8459u = false;
    /* renamed from: v */
    private int f8460v = 16;

    /* renamed from: a */
    public C0497c mo442a() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public View getActionView() {
        return null;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m10004a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m10006a(view);
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return mo441a(charSequence);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m10009b(i);
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return mo443b(charSequence);
    }

    public C3268a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f8452n = context;
        this.f8439a = i2;
        this.f8440b = i;
        this.f8441c = i3;
        this.f8442d = i4;
        this.f8443e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f8448j;
    }

    public int getAlphabeticModifiers() {
        return this.f8449k;
    }

    public int getGroupId() {
        return this.f8440b;
    }

    public Drawable getIcon() {
        return this.f8450l;
    }

    public Intent getIntent() {
        return this.f8445g;
    }

    public int getItemId() {
        return this.f8439a;
    }

    public char getNumericShortcut() {
        return this.f8446h;
    }

    public int getNumericModifiers() {
        return this.f8447i;
    }

    public int getOrder() {
        return this.f8442d;
    }

    public CharSequence getTitle() {
        return this.f8443e;
    }

    public CharSequence getTitleCondensed() {
        return this.f8444f != null ? this.f8444f : this.f8443e;
    }

    public boolean isCheckable() {
        return (this.f8460v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f8460v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f8460v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f8460v & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f8448j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f8448j = Character.toLowerCase(c);
        this.f8449k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f8460v = z | (this.f8460v & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f8460v = (z ? true : false) | (this.f8460v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f8460v = (z ? true : false) | (this.f8460v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f8450l = drawable;
        this.f8451m = null;
        m10003b();
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f8451m = i;
        this.f8450l = C0366b.m1103a(this.f8452n, i);
        m10003b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f8445g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f8446h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f8446h = c;
        this.f8447i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f8453o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f8446h = c;
        this.f8448j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f8446h = c;
        this.f8447i = KeyEvent.normalizeMetaState(i);
        this.f8448j = Character.toLowerCase(c2);
        this.f8449k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f8443e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f8443e = this.f8452n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8444f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f8460v & 8;
        if (z) {
            i = 0;
        }
        this.f8460v = i2 | i;
        return this;
    }

    /* renamed from: a */
    public C0351b m10006a(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0351b m10004a(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0351b mo440a(C0497c c0497c) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public C0351b m10009b(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0351b mo441a(CharSequence charSequence) {
        this.f8454p = charSequence;
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f8454p;
    }

    /* renamed from: b */
    public C0351b mo443b(CharSequence charSequence) {
        this.f8455q = charSequence;
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f8455q;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8456r = colorStateList;
        this.f8458t = true;
        m10003b();
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f8456r;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f8457s = mode;
        this.f8459u = true;
        m10003b();
        return this;
    }

    public Mode getIconTintMode() {
        return this.f8457s;
    }

    /* renamed from: b */
    private void m10003b() {
        if (this.f8450l == null) {
            return;
        }
        if (this.f8458t || this.f8459u) {
            this.f8450l = C0259a.m703g(this.f8450l);
            this.f8450l = this.f8450l.mutate();
            if (this.f8458t) {
                C0259a.m692a(this.f8450l, this.f8456r);
            }
            if (this.f8459u) {
                C0259a.m695a(this.f8450l, this.f8457s);
            }
        }
    }
}
