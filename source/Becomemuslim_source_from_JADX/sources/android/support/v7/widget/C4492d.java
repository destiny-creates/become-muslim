package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0497c;
import android.support.v4.view.C0497c.C0495a;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.C0638a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0649b;
import android.support.v7.view.menu.C0660n;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C0664p;
import android.support.v7.view.menu.C0664p.C0663a;
import android.support.v7.view.menu.C0666s;
import android.support.v7.view.menu.C3269b;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3276j;
import android.support.v7.view.menu.C4487u;
import android.support.v7.widget.ActionMenuView.C0675a;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter */
/* renamed from: android.support.v7.widget.d */
class C4492d extends C3269b implements C0495a {
    /* renamed from: A */
    private C3315b f12080A;
    /* renamed from: g */
    C4491d f12081g;
    /* renamed from: h */
    C3317e f12082h;
    /* renamed from: i */
    C3314a f12083i;
    /* renamed from: j */
    C0786c f12084j;
    /* renamed from: k */
    final C3318f f12085k = new C3318f(this);
    /* renamed from: l */
    int f12086l;
    /* renamed from: m */
    private Drawable f12087m;
    /* renamed from: n */
    private boolean f12088n;
    /* renamed from: o */
    private boolean f12089o;
    /* renamed from: p */
    private boolean f12090p;
    /* renamed from: q */
    private int f12091q;
    /* renamed from: r */
    private int f12092r;
    /* renamed from: s */
    private int f12093s;
    /* renamed from: t */
    private boolean f12094t;
    /* renamed from: u */
    private boolean f12095u;
    /* renamed from: v */
    private boolean f12096v;
    /* renamed from: w */
    private boolean f12097w;
    /* renamed from: x */
    private int f12098x;
    /* renamed from: y */
    private final SparseBooleanArray f12099y = new SparseBooleanArray();
    /* renamed from: z */
    private View f12100z;

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$c */
    private class C0786c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4492d f2176a;
        /* renamed from: b */
        private C3317e f2177b;

        public C0786c(C4492d c4492d, C3317e c3317e) {
            this.f2176a = c4492d;
            this.f2177b = c3317e;
        }

        public void run() {
            if (this.f2176a.c != null) {
                this.f2176a.c.m10087f();
            }
            View view = (View) this.f2176a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2177b.m2197c())) {
                this.f2176a.f12082h = this.f2177b;
            }
            this.f2176a.f12084j = null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$a */
    private class C3314a extends C0660n {
        /* renamed from: a */
        final /* synthetic */ C4492d f8821a;

        public C3314a(C4492d c4492d, Context context, C4487u c4487u, View view) {
            this.f8821a = c4492d;
            super(context, c4487u, view, false, C0581a.actionOverflowMenuStyle);
            if (((C3276j) c4487u.getItem()).m10129j() == null) {
                m2192a((View) c4492d.f12081g == null ? (View) c4492d.f : c4492d.f12081g);
            }
            m2191a((C0661a) c4492d.f12085k);
        }

        /* renamed from: e */
        protected void mo700e() {
            this.f8821a.f12083i = null;
            this.f8821a.f12086l = 0;
            super.mo700e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$b */
    private class C3315b extends C0649b {
        /* renamed from: a */
        final /* synthetic */ C4492d f8822a;

        C3315b(C4492d c4492d) {
            this.f8822a = c4492d;
        }

        /* renamed from: a */
        public C0666s mo701a() {
            return this.f8822a.f12083i != null ? this.f8822a.f12083i.m2196b() : null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$e */
    private class C3317e extends C0660n {
        /* renamed from: a */
        final /* synthetic */ C4492d f8825a;

        public C3317e(C4492d c4492d, Context context, C3273h c3273h, View view, boolean z) {
            this.f8825a = c4492d;
            super(context, c3273h, view, z, C0581a.actionOverflowMenuStyle);
            m2190a(8388613);
            m2191a((C0661a) c4492d.f12085k);
        }

        /* renamed from: e */
        protected void mo700e() {
            if (this.f8825a.c != null) {
                this.f8825a.c.close();
            }
            this.f8825a.f12082h = null;
            super.mo700e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$f */
    private class C3318f implements C0661a {
        /* renamed from: a */
        final /* synthetic */ C4492d f8826a;

        C3318f(C4492d c4492d) {
            this.f8826a = c4492d;
        }

        /* renamed from: a */
        public boolean mo379a(C3273h c3273h) {
            boolean z = false;
            if (c3273h == null) {
                return false;
            }
            this.f8826a.f12086l = ((C4487u) c3273h).getItem().getItemId();
            C0661a a = this.f8826a.m10011a();
            if (a != null) {
                z = a.mo379a(c3273h);
            }
            return z;
        }

        /* renamed from: a */
        public void mo378a(C3273h c3273h, boolean z) {
            if (c3273h instanceof C4487u) {
                c3273h.mo2755p().m10068a(false);
            }
            C0661a a = this.f8826a.m10011a();
            if (a != null) {
                a.mo378a(c3273h, z);
            }
        }
    }

    /* compiled from: ActionMenuPresenter */
    /* renamed from: android.support.v7.widget.d$d */
    private class C4491d extends AppCompatImageView implements C0675a {
        /* renamed from: a */
        final /* synthetic */ C4492d f12078a;
        /* renamed from: b */
        private final float[] f12079b = new float[2];

        /* renamed from: c */
        public boolean mo2733c() {
            return false;
        }

        /* renamed from: d */
        public boolean mo2734d() {
            return false;
        }

        public C4491d(final C4492d c4492d, Context context) {
            this.f12078a = c4492d;
            super(context, null, C0581a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            bs.m2788a(this, getContentDescription());
            setOnTouchListener(new ap(this, this) {
                /* renamed from: b */
                final /* synthetic */ C4491d f8824b;

                /* renamed from: a */
                public C0666s mo433a() {
                    if (this.f8824b.f12078a.f12082h == null) {
                        return null;
                    }
                    return this.f8824b.f12078a.f12082h.m2196b();
                }

                /* renamed from: b */
                public boolean mo434b() {
                    this.f8824b.f12078a.m15212d();
                    return true;
                }

                /* renamed from: c */
                public boolean mo702c() {
                    if (this.f8824b.f12078a.f12084j != null) {
                        return false;
                    }
                    this.f8824b.f12078a.m15213e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            this.f12078a.m15212d();
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            i = super.setFrame(i, i2, i3, i4);
            i2 = getDrawable();
            Drawable background = getBackground();
            if (!(i2 == 0 || background == 0)) {
                i2 = getWidth();
                i4 = getHeight();
                int max = Math.max(i2, i4) / 2;
                i2 = (i2 + (getPaddingLeft() - getPaddingRight())) / 2;
                i4 = (i4 + (getPaddingTop() - getPaddingBottom())) / 2;
                C0259a.m691a(background, i2 - max, i4 - max, i2 + max, i4 + max);
            }
            return i;
        }
    }

    public C4492d(Context context) {
        super(context, C0587g.abc_action_menu_layout, C0587g.abc_action_menu_item_layout);
    }

    /* renamed from: a */
    public void mo463a(Context context, C3273h c3273h) {
        super.mo463a(context, c3273h);
        c3273h = context.getResources();
        context = C0638a.m2121a(context);
        if (!this.f12090p) {
            this.f12089o = context.m2123b();
        }
        if (!this.f12096v) {
            this.f12091q = context.m2124c();
        }
        if (!this.f12094t) {
            this.f12093s = context.m2122a();
        }
        context = this.f12091q;
        if (this.f12089o) {
            if (this.f12081g == null) {
                this.f12081g = new C4491d(this, this.a);
                if (this.f12088n) {
                    this.f12081g.setImageDrawable(this.f12087m);
                    this.f12087m = null;
                    this.f12088n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f12081g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            context -= this.f12081g.getMeasuredWidth();
        } else {
            this.f12081g = null;
        }
        this.f12092r = context;
        this.f12098x = (int) (c3273h.getDisplayMetrics().density * 1113587712);
        this.f12100z = null;
    }

    /* renamed from: a */
    public void m15198a(Configuration configuration) {
        if (this.f12094t == null) {
            this.f12093s = C0638a.m2121a(this.b).m2122a();
        }
        if (this.c != null) {
            this.c.m10076b(true);
        }
    }

    /* renamed from: c */
    public void m15210c(boolean z) {
        this.f12089o = z;
        this.f12090p = true;
    }

    /* renamed from: d */
    public void m15211d(boolean z) {
        this.f12097w = z;
    }

    /* renamed from: a */
    public void m15199a(Drawable drawable) {
        if (this.f12081g != null) {
            this.f12081g.setImageDrawable(drawable);
            return;
        }
        this.f12088n = true;
        this.f12087m = drawable;
    }

    /* renamed from: c */
    public Drawable m15209c() {
        if (this.f12081g != null) {
            return this.f12081g.getDrawable();
        }
        return this.f12088n ? this.f12087m : null;
    }

    /* renamed from: a */
    public C0664p mo2780a(ViewGroup viewGroup) {
        C0664p c0664p = this.f;
        C0664p a = super.mo2780a(viewGroup);
        if (c0664p != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    /* renamed from: a */
    public View mo2781a(C3276j c3276j, View view, ViewGroup viewGroup) {
        View actionView = c3276j.getActionView();
        if (actionView == null || c3276j.m10133n()) {
            actionView = super.mo2781a(c3276j, view, viewGroup);
        }
        actionView.setVisibility(c3276j.isActionViewExpanded() != null ? 8 : null);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (actionMenuView.checkLayoutParams(layoutParams) == null) {
            actionView.setLayoutParams(actionMenuView.m10194a(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo2782a(C3276j c3276j, C0663a c0663a) {
        c0663a.mo437a(c3276j, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0663a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f12080A == null) {
            this.f12080A = new C3315b(this);
        }
        actionMenuItemView.setPopupCallback(this.f12080A);
    }

    /* renamed from: a */
    public boolean mo2784a(int i, C3276j c3276j) {
        return c3276j.m10129j();
    }

    /* renamed from: b */
    public void mo468b(boolean z) {
        int size;
        super.mo468b(z);
        ((View) this.f).requestLayout();
        int i = 0;
        if (this.c) {
            z = this.c.m10092k();
            size = z.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0497c a = ((C3276j) z.get(i2)).mo442a();
                if (a != null) {
                    a.m1576a((C0495a) this);
                }
            }
        }
        z = this.c ? this.c.m10093l() : false;
        if (this.f12089o && z) {
            size = z.size();
            if (size == 1) {
                i = ((C3276j) z.get(0)).isActionViewExpanded() ^ 1;
            } else if (size > 0) {
                i = 1;
            }
        }
        if (i != 0) {
            if (!this.f12081g) {
                this.f12081g = new C4491d(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f12081g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f12081g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f12081g, actionMenuView.m10203c());
            }
        } else if (this.f12081g && this.f12081g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f12081g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f12089o);
    }

    /* renamed from: a */
    public boolean mo2785a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f12081g) {
            return null;
        }
        return super.mo2785a(viewGroup, i);
    }

    /* renamed from: a */
    public boolean mo467a(C4487u c4487u) {
        boolean z = false;
        if (!c4487u.hasVisibleItems()) {
            return false;
        }
        C4487u c4487u2 = c4487u;
        while (c4487u2.m15127s() != this.c) {
            c4487u2 = (C4487u) c4487u2.m15127s();
        }
        View a = m15189a(c4487u2.getItem());
        if (a == null) {
            return false;
        }
        this.f12086l = c4487u.getItem().getItemId();
        int size = c4487u.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c4487u.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.f12083i = new C3314a(this, this.b, c4487u, a);
        this.f12083i.m2194a(z);
        this.f12083i.m2189a();
        super.mo467a(c4487u);
        return true;
    }

    /* renamed from: a */
    private View m15189a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0663a) && ((C0663a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    public boolean m15212d() {
        if (!this.f12089o || m15216h() || this.c == null || this.f == null || this.f12084j != null || this.c.m10093l().isEmpty()) {
            return false;
        }
        this.f12084j = new C0786c(this, new C3317e(this, this.b, this.c, this.f12081g, true));
        ((View) this.f).post(this.f12084j);
        super.mo467a(null);
        return true;
    }

    /* renamed from: e */
    public boolean m15213e() {
        if (this.f12084j == null || this.f == null) {
            C0660n c0660n = this.f12082h;
            if (c0660n == null) {
                return false;
            }
            c0660n.m2198d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f12084j);
        this.f12084j = null;
        return true;
    }

    /* renamed from: f */
    public boolean m15214f() {
        return m15213e() | m15215g();
    }

    /* renamed from: g */
    public boolean m15215g() {
        if (this.f12083i == null) {
            return false;
        }
        this.f12083i.m2198d();
        return true;
    }

    /* renamed from: h */
    public boolean m15216h() {
        return this.f12082h != null && this.f12082h.m2200f();
    }

    /* renamed from: i */
    public boolean m15217i() {
        if (this.f12084j == null) {
            if (!m15216h()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo469b() {
        ArrayList i;
        C4492d c4492d;
        int size;
        int i2;
        int i3 = 0;
        if (this.c != null) {
            i = c4492d.c.m10090i();
            size = i.size();
        } else {
            i = null;
            size = 0;
        }
        int i4 = c4492d.f12093s;
        int i5 = c4492d.f12092r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c4492d.f;
        int i6 = i4;
        int i7 = 0;
        Object obj = null;
        int i8 = 0;
        for (i4 = 0; i4 < size; i4++) {
            C3276j c3276j = (C3276j) i.get(i4);
            if (c3276j.m10131l()) {
                i7++;
            } else if (c3276j.m10130k()) {
                i8++;
            } else {
                obj = 1;
            }
            if (c4492d.f12097w && c3276j.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (c4492d.f12089o && (r9 != null || i8 + i7 > i6)) {
            i6--;
        }
        i6 -= i7;
        SparseBooleanArray sparseBooleanArray = c4492d.f12099y;
        sparseBooleanArray.clear();
        if (c4492d.f12095u) {
            i7 = i5 / c4492d.f12098x;
            i2 = ((i5 % c4492d.f12098x) / i7) + c4492d.f12098x;
        } else {
            i7 = 0;
            i2 = 0;
        }
        i8 = i5;
        i5 = 0;
        int i9 = 0;
        while (i5 < size) {
            int i10;
            C3276j c3276j2 = (C3276j) i.get(i5);
            int measuredWidth;
            boolean z;
            if (c3276j2.m10131l()) {
                View a = c4492d.mo2781a(c3276j2, c4492d.f12100z, viewGroup);
                if (c4492d.f12100z == null) {
                    c4492d.f12100z = a;
                }
                if (c4492d.f12095u) {
                    i7 -= ActionMenuView.m10191a(a, i2, i7, makeMeasureSpec, i3);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                measuredWidth = a.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i9 != 0) {
                    measuredWidth = i9;
                }
                i9 = c3276j2.getGroupId();
                if (i9 != 0) {
                    z = true;
                    sparseBooleanArray.put(i9, true);
                } else {
                    z = true;
                }
                c3276j2.m10122d(z);
                i10 = size;
                i9 = measuredWidth;
            } else if (c3276j2.m10130k()) {
                measuredWidth = c3276j2.getGroupId();
                z = sparseBooleanArray.get(measuredWidth);
                boolean z2 = (i6 > 0 || z) && i8 > 0 && (!c4492d.f12095u || i7 > 0);
                if (z2) {
                    int i11 = z2;
                    View a2 = c4492d.mo2781a(c3276j2, c4492d.f12100z, viewGroup);
                    i10 = size;
                    if (c4492d.f12100z == null) {
                        c4492d.f12100z = a2;
                    }
                    if (c4492d.f12095u) {
                        int a3 = ActionMenuView.m10191a(a2, i2, i7, makeMeasureSpec, 0);
                        i7 -= a3;
                        if (a3 == 0) {
                            i11 = 0;
                        }
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i3 = a2.getMeasuredWidth();
                    i8 -= i3;
                    if (i9 == 0) {
                        i9 = i3;
                    }
                    if (c4492d.f12095u) {
                        z2 = i11 & (i8 >= 0 ? 1 : 0);
                    } else {
                        z2 = i11 & (i8 + i9 > 0 ? 1 : 0);
                    }
                } else {
                    boolean z3 = z2;
                    i10 = size;
                }
                if (z2 && measuredWidth != 0) {
                    sparseBooleanArray.put(measuredWidth, true);
                } else if (z) {
                    sparseBooleanArray.put(measuredWidth, false);
                    size = 0;
                    while (size < i5) {
                        C3276j c3276j3 = (C3276j) i.get(size);
                        if (c3276j3.getGroupId() == measuredWidth) {
                            if (c3276j3.m10129j()) {
                                i6++;
                            }
                            c3276j3.m10122d(false);
                        }
                        size++;
                        c4492d = this;
                    }
                }
                if (z2) {
                    i6--;
                }
                c3276j2.m10122d(z2);
            } else {
                i10 = size;
                c3276j2.m10122d(false);
                i5++;
                size = i10;
                c4492d = this;
                i3 = 0;
            }
            i5++;
            size = i10;
            c4492d = this;
            i3 = 0;
        }
        return true;
    }

    /* renamed from: a */
    public void mo464a(C3273h c3273h, boolean z) {
        m15214f();
        super.mo464a(c3273h, z);
    }

    /* renamed from: a */
    public void mo2783a(boolean z) {
        if (z) {
            super.mo467a((C4487u) false);
        } else if (this.c) {
            this.c.m10068a(false);
        }
    }

    /* renamed from: a */
    public void m15202a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo435a(this.c);
    }
}
