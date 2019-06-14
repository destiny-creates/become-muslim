package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.view.C0497c;
import android.support.v4.view.C0497c.C0496b;
import android.support.v7.p037c.p038a.C0631b;
import android.support.v7.view.menu.C0664p.C0663a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: MenuItemImpl */
/* renamed from: android.support.v7.view.menu.j */
public final class C3276j implements C0351b {
    /* renamed from: F */
    private static String f8515F;
    /* renamed from: G */
    private static String f8516G;
    /* renamed from: H */
    private static String f8517H;
    /* renamed from: I */
    private static String f8518I;
    /* renamed from: A */
    private View f8519A;
    /* renamed from: B */
    private C0497c f8520B;
    /* renamed from: C */
    private OnActionExpandListener f8521C;
    /* renamed from: D */
    private boolean f8522D = false;
    /* renamed from: E */
    private ContextMenuInfo f8523E;
    /* renamed from: a */
    C3273h f8524a;
    /* renamed from: b */
    private final int f8525b;
    /* renamed from: c */
    private final int f8526c;
    /* renamed from: d */
    private final int f8527d;
    /* renamed from: e */
    private final int f8528e;
    /* renamed from: f */
    private CharSequence f8529f;
    /* renamed from: g */
    private CharSequence f8530g;
    /* renamed from: h */
    private Intent f8531h;
    /* renamed from: i */
    private char f8532i;
    /* renamed from: j */
    private int f8533j = 4096;
    /* renamed from: k */
    private char f8534k;
    /* renamed from: l */
    private int f8535l = 4096;
    /* renamed from: m */
    private Drawable f8536m;
    /* renamed from: n */
    private int f8537n = 0;
    /* renamed from: o */
    private C4487u f8538o;
    /* renamed from: p */
    private Runnable f8539p;
    /* renamed from: q */
    private OnMenuItemClickListener f8540q;
    /* renamed from: r */
    private CharSequence f8541r;
    /* renamed from: s */
    private CharSequence f8542s;
    /* renamed from: t */
    private ColorStateList f8543t = null;
    /* renamed from: u */
    private Mode f8544u = null;
    /* renamed from: v */
    private boolean f8545v = false;
    /* renamed from: w */
    private boolean f8546w = false;
    /* renamed from: x */
    private boolean f8547x = false;
    /* renamed from: y */
    private int f8548y = 16;
    /* renamed from: z */
    private int f8549z = 0;

    /* compiled from: MenuItemImpl */
    /* renamed from: android.support.v7.view.menu.j$1 */
    class C32751 implements C0496b {
        /* renamed from: a */
        final /* synthetic */ C3276j f8514a;

        C32751(C3276j c3276j) {
            this.f8514a = c3276j;
        }

        /* renamed from: a */
        public void mo473a(boolean z) {
            this.f8514a.f8524a.m10063a(this.f8514a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m10106a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m10108a(view);
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return mo441a(charSequence);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m10115b(i);
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return mo443b(charSequence);
    }

    C3276j(C3273h c3273h, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f8524a = c3273h;
        this.f8525b = i2;
        this.f8526c = i;
        this.f8527d = i3;
        this.f8528e = i4;
        this.f8529f = charSequence;
        this.f8549z = i5;
    }

    /* renamed from: b */
    public boolean m10118b() {
        if ((this.f8540q != null && this.f8540q.onMenuItemClick(this)) || this.f8524a.mo2750a(this.f8524a, (MenuItem) this)) {
            return true;
        }
        if (this.f8539p != null) {
            this.f8539p.run();
            return true;
        }
        if (this.f8531h != null) {
            try {
                this.f8524a.m10085e().startActivity(this.f8531h);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f8520B == null || !this.f8520B.mo476d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f8548y & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f8548y |= 16;
        } else {
            this.f8548y &= -17;
        }
        this.f8524a.m10076b(false);
        return this;
    }

    public int getGroupId() {
        return this.f8526c;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f8525b;
    }

    public int getOrder() {
        return this.f8527d;
    }

    /* renamed from: c */
    public int m10119c() {
        return this.f8528e;
    }

    public Intent getIntent() {
        return this.f8531h;
    }

    public MenuItem setIntent(Intent intent) {
        this.f8531h = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f8534k;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f8534k == c) {
            return this;
        }
        this.f8534k = Character.toLowerCase(c);
        this.f8524a.m10076b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f8534k == c && this.f8535l == i) {
            return this;
        }
        this.f8534k = Character.toLowerCase(c);
        this.f8535l = KeyEvent.normalizeMetaState(i);
        this.f8524a.m10076b((boolean) 0);
        return this;
    }

    public int getAlphabeticModifiers() {
        return this.f8535l;
    }

    public char getNumericShortcut() {
        return this.f8532i;
    }

    public int getNumericModifiers() {
        return this.f8533j;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f8532i == c) {
            return this;
        }
        this.f8532i = c;
        this.f8524a.m10076b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f8532i == c && this.f8533j == i) {
            return this;
        }
        this.f8532i = c;
        this.f8533j = KeyEvent.normalizeMetaState(i);
        this.f8524a.m10076b((boolean) 0);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f8532i = c;
        this.f8534k = Character.toLowerCase(c2);
        this.f8524a.m10076b((boolean) '\u0000');
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f8532i = c;
        this.f8533j = KeyEvent.normalizeMetaState(i);
        this.f8534k = Character.toLowerCase(c2);
        this.f8535l = KeyEvent.normalizeMetaState(i2);
        this.f8524a.m10076b((boolean) '\u0000');
        return this;
    }

    /* renamed from: d */
    char m10121d() {
        return this.f8524a.mo2751b() ? this.f8534k : this.f8532i;
    }

    /* renamed from: e */
    String m10123e() {
        char d = m10121d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f8515F);
        if (d == '\b') {
            stringBuilder.append(f8517H);
        } else if (d == '\n') {
            stringBuilder.append(f8516G);
        } else if (d != ' ') {
            stringBuilder.append(d);
        } else {
            stringBuilder.append(f8518I);
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    boolean m10125f() {
        return this.f8524a.mo2752c() && m10121d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f8538o;
    }

    public boolean hasSubMenu() {
        return this.f8538o != null;
    }

    /* renamed from: a */
    public void m10112a(C4487u c4487u) {
        this.f8538o = c4487u;
        c4487u.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f8529f;
    }

    /* renamed from: a */
    CharSequence m10111a(C0663a c0663a) {
        if (c0663a == null || c0663a.mo438a() == null) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f8529f = charSequence;
        this.f8524a.m10076b(false);
        if (this.f8538o != null) {
            this.f8538o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f8524a.m10085e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8530g != null ? this.f8530g : this.f8529f;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8530g = charSequence;
        if (charSequence == null) {
            charSequence = this.f8529f;
        }
        this.f8524a.m10076b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f8536m != null) {
            return m10105a(this.f8536m);
        }
        if (this.f8537n == 0) {
            return null;
        }
        Drawable b = C0631b.m2112b(this.f8524a.m10085e(), this.f8537n);
        this.f8537n = 0;
        this.f8536m = b;
        return m10105a(b);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f8537n = 0;
        this.f8536m = drawable;
        this.f8547x = true;
        this.f8524a.m10076b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f8536m = null;
        this.f8537n = i;
        this.f8547x = true;
        this.f8524a.m10076b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8543t = colorStateList;
        this.f8545v = true;
        this.f8547x = true;
        this.f8524a.m10076b(false);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f8543t;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f8544u = mode;
        this.f8546w = true;
        this.f8547x = true;
        this.f8524a.m10076b(false);
        return this;
    }

    public Mode getIconTintMode() {
        return this.f8544u;
    }

    /* renamed from: a */
    private Drawable m10105a(Drawable drawable) {
        if (drawable != null && this.f8547x && (this.f8545v || this.f8546w)) {
            drawable = C0259a.m703g(drawable).mutate();
            if (this.f8545v) {
                C0259a.m692a(drawable, this.f8543t);
            }
            if (this.f8546w) {
                C0259a.m695a(drawable, this.f8544u);
            }
            this.f8547x = false;
        }
        return drawable;
    }

    public boolean isCheckable() {
        return (this.f8548y & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        boolean z2 = this.f8548y;
        this.f8548y = z | (this.f8548y & -2);
        if (z2 != this.f8548y) {
            this.f8524a.m10076b(false);
        }
        return this;
    }

    /* renamed from: a */
    public void m10114a(boolean z) {
        this.f8548y = (z ? true : false) | (this.f8548y & -5);
    }

    /* renamed from: g */
    public boolean m10126g() {
        return (this.f8548y & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f8548y & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f8548y & 4) != 0) {
            this.f8524a.m10066a((MenuItem) this);
        } else {
            m10117b(z);
        }
        return this;
    }

    /* renamed from: b */
    void m10117b(boolean z) {
        boolean z2 = this.f8548y;
        this.f8548y = (z ? true : false) | (this.f8548y & -3);
        if (z2 != this.f8548y) {
            this.f8524a.m10076b(false);
        }
    }

    public boolean isVisible() {
        boolean z = false;
        if (this.f8520B == null || !this.f8520B.mo2746b()) {
            if ((this.f8548y & 8) == 0) {
                z = true;
            }
            return z;
        }
        if ((this.f8548y & 8) == 0 && this.f8520B.mo2747c()) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    boolean m10120c(boolean z) {
        boolean z2 = this.f8548y;
        this.f8548y = (z ? false : true) | (this.f8548y & -9);
        if (z2 != this.f8548y) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m10120c(z)) {
            this.f8524a.m10063a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f8540q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f8529f != null ? this.f8529f.toString() : null;
    }

    /* renamed from: a */
    void m10113a(ContextMenuInfo contextMenuInfo) {
        this.f8523E = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f8523E;
    }

    /* renamed from: h */
    public void m10127h() {
        this.f8524a.m10074b(this);
    }

    /* renamed from: i */
    public boolean m10128i() {
        return this.f8524a.m10098q();
    }

    /* renamed from: j */
    public boolean m10129j() {
        return (this.f8548y & 32) == 32;
    }

    /* renamed from: k */
    public boolean m10130k() {
        return (this.f8549z & 1) == 1;
    }

    /* renamed from: l */
    public boolean m10131l() {
        return (this.f8549z & 2) == 2;
    }

    /* renamed from: d */
    public void m10122d(boolean z) {
        if (z) {
            this.f8548y |= 32;
        } else {
            this.f8548y &= -33;
        }
    }

    /* renamed from: m */
    public boolean m10132m() {
        return (this.f8549z & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f8549z = i;
                this.f8524a.m10074b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* renamed from: a */
    public C0351b m10108a(View view) {
        this.f8519A = view;
        this.f8520B = null;
        if (view != null && view.getId() == -1 && this.f8525b > 0) {
            view.setId(this.f8525b);
        }
        this.f8524a.m10074b(this);
        return this;
    }

    /* renamed from: a */
    public C0351b m10106a(int i) {
        Context e = this.f8524a.m10085e();
        m10108a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f8519A != null) {
            return this.f8519A;
        }
        if (this.f8520B == null) {
            return null;
        }
        this.f8519A = this.f8520B.mo2744a((MenuItem) this);
        return this.f8519A;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    /* renamed from: a */
    public C0497c mo442a() {
        return this.f8520B;
    }

    /* renamed from: a */
    public C0351b mo440a(C0497c c0497c) {
        if (this.f8520B != null) {
            this.f8520B.m1584f();
        }
        this.f8519A = null;
        this.f8520B = c0497c;
        this.f8524a.m10076b(true);
        if (this.f8520B != null) {
            this.f8520B.mo2745a(new C32751(this));
        }
        return this;
    }

    /* renamed from: b */
    public C0351b m10115b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m10133n()) {
            return false;
        }
        if (this.f8521C != null) {
            if (!this.f8521C.onMenuItemActionExpand(this)) {
                return false;
            }
        }
        return this.f8524a.mo2753c(this);
    }

    public boolean collapseActionView() {
        if ((this.f8549z & 8) == 0) {
            return false;
        }
        if (this.f8519A == null) {
            return true;
        }
        if (this.f8521C != null) {
            if (!this.f8521C.onMenuItemActionCollapse(this)) {
                return false;
            }
        }
        return this.f8524a.mo2754d(this);
    }

    /* renamed from: n */
    public boolean m10133n() {
        boolean z = false;
        if ((this.f8549z & 8) == 0) {
            return false;
        }
        if (this.f8519A == null && this.f8520B != null) {
            this.f8519A = this.f8520B.mo2744a((MenuItem) this);
        }
        if (this.f8519A != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public void m10124e(boolean z) {
        this.f8522D = z;
        this.f8524a.m10076b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f8522D;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f8521C = onActionExpandListener;
        return this;
    }

    /* renamed from: a */
    public C0351b mo441a(CharSequence charSequence) {
        this.f8541r = charSequence;
        this.f8524a.m10076b(false);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f8541r;
    }

    /* renamed from: b */
    public C0351b mo443b(CharSequence charSequence) {
        this.f8542s = charSequence;
        this.f8524a.m10076b(false);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f8542s;
    }
}
