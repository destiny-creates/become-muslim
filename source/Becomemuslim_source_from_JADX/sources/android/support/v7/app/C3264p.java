package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0525w;
import android.support.v4.view.C0526x;
import android.support.v4.view.C0527z;
import android.support.v4.view.C3232y;
import android.support.v7.app.C0608a.C0606b;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.C0638a;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.C0646g;
import android.support.v7.view.C0647h;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0673a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aj;
import android.support.v7.widget.bg;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
/* renamed from: android.support.v7.app.p */
public class C3264p extends C0608a implements C0673a {
    /* renamed from: s */
    static final /* synthetic */ boolean f8375s = (C3264p.class.desiredAssertionStatus() ^ 1);
    /* renamed from: t */
    private static final Interpolator f8376t = new AccelerateInterpolator();
    /* renamed from: u */
    private static final Interpolator f8377u = new DecelerateInterpolator();
    /* renamed from: A */
    private boolean f8378A;
    /* renamed from: B */
    private boolean f8379B;
    /* renamed from: C */
    private ArrayList<C0606b> f8380C = new ArrayList();
    /* renamed from: D */
    private boolean f8381D;
    /* renamed from: E */
    private int f8382E = 0;
    /* renamed from: F */
    private boolean f8383F;
    /* renamed from: G */
    private boolean f8384G = true;
    /* renamed from: H */
    private boolean f8385H;
    /* renamed from: a */
    Context f8386a;
    /* renamed from: b */
    ActionBarOverlayLayout f8387b;
    /* renamed from: c */
    ActionBarContainer f8388c;
    /* renamed from: d */
    aj f8389d;
    /* renamed from: e */
    ActionBarContextView f8390e;
    /* renamed from: f */
    View f8391f;
    /* renamed from: g */
    bg f8392g;
    /* renamed from: h */
    C3263a f8393h;
    /* renamed from: i */
    C0640b f8394i;
    /* renamed from: j */
    C0639a f8395j;
    /* renamed from: k */
    boolean f8396k = true;
    /* renamed from: l */
    boolean f8397l;
    /* renamed from: m */
    boolean f8398m;
    /* renamed from: n */
    C0647h f8399n;
    /* renamed from: o */
    boolean f8400o;
    /* renamed from: p */
    final C0526x f8401p = new C44791(this);
    /* renamed from: q */
    final C0526x f8402q = new C44802(this);
    /* renamed from: r */
    final C0527z f8403r = new C32623(this);
    /* renamed from: v */
    private Context f8404v;
    /* renamed from: w */
    private Activity f8405w;
    /* renamed from: x */
    private Dialog f8406x;
    /* renamed from: y */
    private ArrayList<Object> f8407y = new ArrayList();
    /* renamed from: z */
    private int f8408z = -1;

    /* compiled from: WindowDecorActionBar */
    /* renamed from: android.support.v7.app.p$3 */
    class C32623 implements C0527z {
        /* renamed from: a */
        final /* synthetic */ C3264p f8369a;

        C32623(C3264p c3264p) {
            this.f8369a = c3264p;
        }

        /* renamed from: a */
        public void mo410a(View view) {
            ((View) this.f8369a.f8388c.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar */
    /* renamed from: android.support.v7.app.p$a */
    public class C3263a extends C0640b implements C0657a {
        /* renamed from: a */
        final /* synthetic */ C3264p f8370a;
        /* renamed from: b */
        private final Context f8371b;
        /* renamed from: c */
        private final C3273h f8372c;
        /* renamed from: d */
        private C0639a f8373d;
        /* renamed from: e */
        private WeakReference<View> f8374e;

        public C3263a(C3264p c3264p, Context context, C0639a c0639a) {
            this.f8370a = c3264p;
            this.f8371b = context;
            this.f8373d = c0639a;
            this.f8372c = new C3273h(context).m10054a(1);
            this.f8372c.mo2749a((C0657a) this);
        }

        /* renamed from: a */
        public MenuInflater mo411a() {
            return new C0646g(this.f8371b);
        }

        /* renamed from: b */
        public Menu mo416b() {
            return this.f8372c;
        }

        /* renamed from: c */
        public void mo419c() {
            if (this.f8370a.f8393h == this) {
                if (C3264p.m9936a(this.f8370a.f8397l, this.f8370a.f8398m, false)) {
                    this.f8373d.mo380a(this);
                } else {
                    this.f8370a.f8394i = this;
                    this.f8370a.f8395j = this.f8373d;
                }
                this.f8373d = null;
                this.f8370a.m9968k(false);
                this.f8370a.f8390e.m10162b();
                this.f8370a.f8389d.mo670a().sendAccessibilityEvent(32);
                this.f8370a.f8387b.setHideOnContentScrollEnabled(this.f8370a.f8400o);
                this.f8370a.f8393h = null;
            }
        }

        /* renamed from: d */
        public void mo420d() {
            if (this.f8370a.f8393h == this) {
                this.f8372c.m10088g();
                try {
                    this.f8373d.mo383b(this, this.f8372c);
                } finally {
                    this.f8372c.m10089h();
                }
            }
        }

        /* renamed from: e */
        public boolean m9930e() {
            this.f8372c.m10088g();
            try {
                boolean a = this.f8373d.mo381a((C0640b) this, this.f8372c);
                return a;
            } finally {
                this.f8372c.m10089h();
            }
        }

        /* renamed from: a */
        public void mo413a(View view) {
            this.f8370a.f8390e.setCustomView(view);
            this.f8374e = new WeakReference(view);
        }

        /* renamed from: a */
        public void mo414a(CharSequence charSequence) {
            this.f8370a.f8390e.setSubtitle(charSequence);
        }

        /* renamed from: b */
        public void mo418b(CharSequence charSequence) {
            this.f8370a.f8390e.setTitle(charSequence);
        }

        /* renamed from: a */
        public void mo412a(int i) {
            mo418b(this.f8370a.f8386a.getResources().getString(i));
        }

        /* renamed from: b */
        public void mo417b(int i) {
            mo414a(this.f8370a.f8386a.getResources().getString(i));
        }

        /* renamed from: f */
        public CharSequence mo421f() {
            return this.f8370a.f8390e.getTitle();
        }

        /* renamed from: g */
        public CharSequence mo422g() {
            return this.f8370a.f8390e.getSubtitle();
        }

        /* renamed from: a */
        public void mo415a(boolean z) {
            super.mo415a(z);
            this.f8370a.f8390e.setTitleOptional(z);
        }

        /* renamed from: h */
        public boolean mo423h() {
            return this.f8370a.f8390e.m10164d();
        }

        /* renamed from: i */
        public View mo424i() {
            return this.f8374e != null ? (View) this.f8374e.get() : null;
        }

        /* renamed from: a */
        public boolean mo389a(C3273h c3273h, MenuItem menuItem) {
            return this.f8373d != null ? this.f8373d.mo382a((C0640b) this, menuItem) : null;
        }

        /* renamed from: a */
        public void mo388a(C3273h c3273h) {
            if (this.f8373d != null) {
                mo420d();
                this.f8370a.f8390e.mo481a();
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    /* renamed from: android.support.v7.app.p$1 */
    class C44791 extends C3232y {
        /* renamed from: a */
        final /* synthetic */ C3264p f11978a;

        C44791(C3264p c3264p) {
            this.f11978a = c3264p;
        }

        /* renamed from: b */
        public void mo327b(View view) {
            if (!(this.f11978a.f8396k == null || this.f11978a.f8391f == null)) {
                this.f11978a.f8391f.setTranslationY(0.0f);
                this.f11978a.f8388c.setTranslationY(0.0f);
            }
            this.f11978a.f8388c.setVisibility(8);
            this.f11978a.f8388c.setTransitioning(false);
            this.f11978a.f8399n = null;
            this.f11978a.m9961h();
            if (this.f11978a.f8387b != null) {
                C0517s.m1721o(this.f11978a.f8387b);
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    /* renamed from: android.support.v7.app.p$2 */
    class C44802 extends C3232y {
        /* renamed from: a */
        final /* synthetic */ C3264p f11979a;

        C44802(C3264p c3264p) {
            this.f11979a = c3264p;
        }

        /* renamed from: b */
        public void mo327b(View view) {
            this.f11979a.f8399n = null;
            this.f11979a.f8388c.requestLayout();
        }
    }

    /* renamed from: a */
    static boolean m9936a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (!z) {
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public void mo432m() {
    }

    public C3264p(Activity activity, boolean z) {
        this.f8405w = activity;
        View decorView = activity.getWindow().getDecorView();
        m9935a(decorView);
        if (!z) {
            this.f8391f = decorView.findViewById(true);
        }
    }

    public C3264p(Dialog dialog) {
        this.f8406x = dialog;
        m9935a(dialog.getWindow().getDecorView());
    }

    /* renamed from: a */
    private void m9935a(View view) {
        this.f8387b = (ActionBarOverlayLayout) view.findViewById(C0586f.decor_content_parent);
        if (this.f8387b != null) {
            this.f8387b.setActionBarVisibilityCallback(this);
        }
        this.f8389d = m9937b(view.findViewById(C0586f.action_bar));
        this.f8390e = (ActionBarContextView) view.findViewById(C0586f.action_context_bar);
        this.f8388c = (ActionBarContainer) view.findViewById(C0586f.action_bar_container);
        if (this.f8389d == null || this.f8390e == null || this.f8388c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" can only be used ");
            stringBuilder.append("with a compatible window decor layout");
            throw new IllegalStateException(stringBuilder.toString());
        }
        int dimensionPixelSize;
        this.f8386a = this.f8389d.mo679b();
        view = (this.f8389d.mo697o() & 4) != null ? true : null;
        if (view != null) {
            this.f8378A = true;
        }
        C0638a a = C0638a.m2121a(this.f8386a);
        if (!a.m2127f()) {
            if (view == null) {
                view = null;
                mo401c(view);
                m9938l(a.m2125d());
                view = this.f8386a.obtainStyledAttributes(null, C0590j.ActionBar, C0581a.actionBarStyle, 0);
                if (view.getBoolean(C0590j.ActionBar_hideOnContentScroll, false)) {
                    mo427d(true);
                }
                dimensionPixelSize = view.getDimensionPixelSize(C0590j.ActionBar_elevation, 0);
                if (dimensionPixelSize != 0) {
                    mo392a((float) dimensionPixelSize);
                }
                view.recycle();
            }
        }
        view = true;
        mo401c(view);
        m9938l(a.m2125d());
        view = this.f8386a.obtainStyledAttributes(null, C0590j.ActionBar, C0581a.actionBarStyle, 0);
        if (view.getBoolean(C0590j.ActionBar_hideOnContentScroll, false)) {
            mo427d(true);
        }
        dimensionPixelSize = view.getDimensionPixelSize(C0590j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo392a((float) dimensionPixelSize);
        }
        view.recycle();
    }

    /* renamed from: b */
    private aj m9937b(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view);
        throw new IllegalStateException(stringBuilder.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* renamed from: a */
    public void mo392a(float f) {
        C0517s.m1687a(this.f8388c, f);
    }

    /* renamed from: a */
    public void mo393a(Configuration configuration) {
        m9938l(C0638a.m2121a(this.f8386a).m2125d());
    }

    /* renamed from: l */
    private void m9938l(boolean z) {
        this.f8381D = z;
        if (this.f8381D) {
            this.f8388c.setTabContainer(null);
            this.f8389d.mo674a(this.f8392g);
        } else {
            this.f8389d.mo674a(null);
            this.f8388c.setTabContainer(this.f8392g);
        }
        boolean z2 = true;
        z = m9963i();
        if (this.f8392g != null) {
            if (z) {
                this.f8392g.setVisibility(0);
                if (this.f8387b != null) {
                    C0517s.m1721o(this.f8387b);
                }
            } else {
                this.f8392g.setVisibility(8);
            }
        }
        aj ajVar = this.f8389d;
        boolean z3 = !this.f8381D && z;
        ajVar.mo678a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f8387b;
        if (this.f8381D || !z) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* renamed from: h */
    void m9961h() {
        if (this.f8395j != null) {
            this.f8395j.mo380a(this.f8394i);
            this.f8394i = null;
            this.f8395j = null;
        }
    }

    /* renamed from: a */
    public void mo426a(int i) {
        this.f8382E = i;
    }

    /* renamed from: f */
    public void mo406f(boolean z) {
        this.f8385H = z;
        if (!z && this.f8399n) {
            this.f8399n.m2175c();
        }
    }

    /* renamed from: g */
    public void mo409g(boolean z) {
        if (z != this.f8379B) {
            this.f8379B = z;
            int size = this.f8380C.size();
            for (int i = 0; i < size; i++) {
                ((C0606b) this.f8380C.get(i)).m2013a(z);
            }
        }
    }

    /* renamed from: a */
    public void mo395a(boolean z) {
        m9947a(z ? true : false, 2);
    }

    /* renamed from: b */
    public void mo400b(boolean z) {
        m9947a(z ? true : false, 4);
    }

    /* renamed from: c */
    public void mo401c(boolean z) {
        this.f8389d.mo682b(z);
    }

    /* renamed from: a */
    public void mo394a(CharSequence charSequence) {
        this.f8389d.mo681b(charSequence);
    }

    /* renamed from: b */
    public void mo399b(CharSequence charSequence) {
        this.f8389d.mo677a(charSequence);
    }

    /* renamed from: a */
    public void m9947a(int i, int i2) {
        int o = this.f8389d.mo697o();
        if ((i2 & 4) != 0) {
            this.f8378A = true;
        }
        this.f8389d.mo683c((i & i2) | ((~i2) & o));
    }

    /* renamed from: i */
    public int m9963i() {
        return this.f8389d.mo698p();
    }

    /* renamed from: a */
    public int mo391a() {
        return this.f8389d.mo697o();
    }

    /* renamed from: a */
    public C0640b mo425a(C0639a c0639a) {
        if (this.f8393h != null) {
            this.f8393h.mo419c();
        }
        this.f8387b.setHideOnContentScrollEnabled(false);
        this.f8390e.m10163c();
        C0640b c3263a = new C3263a(this, this.f8390e.getContext(), c0639a);
        if (c3263a.m9930e() == null) {
            return null;
        }
        this.f8393h = c3263a;
        c3263a.mo420d();
        this.f8390e.m10160a(c3263a);
        m9968k(true);
        this.f8390e.sendAccessibilityEvent(32);
        return c3263a;
    }

    /* renamed from: h */
    public void mo428h(boolean z) {
        this.f8396k = z;
    }

    /* renamed from: n */
    private void m9940n() {
        if (!this.f8383F) {
            this.f8383F = true;
            if (this.f8387b != null) {
                this.f8387b.setShowingForActionMode(true);
            }
            m9939m(false);
        }
    }

    /* renamed from: j */
    public void mo429j() {
        if (this.f8398m) {
            this.f8398m = false;
            m9939m(true);
        }
    }

    /* renamed from: o */
    private void m9941o() {
        if (this.f8383F) {
            this.f8383F = false;
            if (this.f8387b != null) {
                this.f8387b.setShowingForActionMode(false);
            }
            m9939m(false);
        }
    }

    /* renamed from: k */
    public void mo430k() {
        if (!this.f8398m) {
            this.f8398m = true;
            m9939m(true);
        }
    }

    /* renamed from: d */
    public void mo427d(boolean z) {
        if (z) {
            if (!this.f8387b.m10176a()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        this.f8400o = z;
        this.f8387b.setHideOnContentScrollEnabled(z);
    }

    /* renamed from: m */
    private void m9939m(boolean z) {
        if (C3264p.m9936a(this.f8397l, this.f8398m, this.f8383F)) {
            if (!this.f8384G) {
                this.f8384G = true;
                m9964i(z);
            }
        } else if (this.f8384G) {
            this.f8384G = false;
            m9966j(z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public void m9964i(boolean r5) {
        /*
        r4 = this;
        r0 = r4.f8399n;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r4.f8399n;
        r0.m2175c();
    L_0x0009:
        r0 = r4.f8388c;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r4.f8382E;
        r1 = 0;
        if (r0 != 0) goto L_0x0084;
    L_0x0014:
        r0 = r4.f8385H;
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        if (r5 == 0) goto L_0x0084;
    L_0x001a:
        r0 = r4.f8388c;
        r0.setTranslationY(r1);
        r0 = r4.f8388c;
        r0 = r0.getHeight();
        r0 = -r0;
        r0 = (float) r0;
        if (r5 == 0) goto L_0x0039;
    L_0x0029:
        r5 = 2;
        r5 = new int[r5];
        r5 = {0, 0};
        r2 = r4.f8388c;
        r2.getLocationInWindow(r5);
        r2 = 1;
        r5 = r5[r2];
        r5 = (float) r5;
        r0 = r0 - r5;
    L_0x0039:
        r5 = r4.f8388c;
        r5.setTranslationY(r0);
        r5 = new android.support.v7.view.h;
        r5.<init>();
        r2 = r4.f8388c;
        r2 = android.support.v4.view.C0517s.m1717k(r2);
        r2 = r2.m1759b(r1);
        r3 = r4.f8403r;
        r2.m1757a(r3);
        r5.m2169a(r2);
        r2 = r4.f8396k;
        if (r2 == 0) goto L_0x006f;
    L_0x0059:
        r2 = r4.f8391f;
        if (r2 == 0) goto L_0x006f;
    L_0x005d:
        r2 = r4.f8391f;
        r2.setTranslationY(r0);
        r0 = r4.f8391f;
        r0 = android.support.v4.view.C0517s.m1717k(r0);
        r0 = r0.m1759b(r1);
        r5.m2169a(r0);
    L_0x006f:
        r0 = f8377u;
        r5.m2172a(r0);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r5.m2168a(r0);
        r0 = r4.f8402q;
        r5.m2171a(r0);
        r4.f8399n = r5;
        r5.m2173a();
        goto L_0x00a3;
    L_0x0084:
        r5 = r4.f8388c;
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.setAlpha(r0);
        r5 = r4.f8388c;
        r5.setTranslationY(r1);
        r5 = r4.f8396k;
        if (r5 == 0) goto L_0x009d;
    L_0x0094:
        r5 = r4.f8391f;
        if (r5 == 0) goto L_0x009d;
    L_0x0098:
        r5 = r4.f8391f;
        r5.setTranslationY(r1);
    L_0x009d:
        r5 = r4.f8402q;
        r0 = 0;
        r5.mo327b(r0);
    L_0x00a3:
        r5 = r4.f8387b;
        if (r5 == 0) goto L_0x00ac;
    L_0x00a7:
        r5 = r4.f8387b;
        android.support.v4.view.C0517s.m1721o(r5);
    L_0x00ac:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.p.i(boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    public void m9966j(boolean r5) {
        /*
        r4 = this;
        r0 = r4.f8399n;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r4.f8399n;
        r0.m2175c();
    L_0x0009:
        r0 = r4.f8382E;
        if (r0 != 0) goto L_0x007a;
    L_0x000d:
        r0 = r4.f8385H;
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        if (r5 == 0) goto L_0x007a;
    L_0x0013:
        r0 = r4.f8388c;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.setAlpha(r1);
        r0 = r4.f8388c;
        r1 = 1;
        r0.setTransitioning(r1);
        r0 = new android.support.v7.view.h;
        r0.<init>();
        r2 = r4.f8388c;
        r2 = r2.getHeight();
        r2 = -r2;
        r2 = (float) r2;
        if (r5 == 0) goto L_0x003e;
    L_0x002f:
        r5 = 2;
        r5 = new int[r5];
        r5 = {0, 0};
        r3 = r4.f8388c;
        r3.getLocationInWindow(r5);
        r5 = r5[r1];
        r5 = (float) r5;
        r2 = r2 - r5;
    L_0x003e:
        r5 = r4.f8388c;
        r5 = android.support.v4.view.C0517s.m1717k(r5);
        r5 = r5.m1759b(r2);
        r1 = r4.f8403r;
        r5.m1757a(r1);
        r0.m2169a(r5);
        r5 = r4.f8396k;
        if (r5 == 0) goto L_0x0065;
    L_0x0054:
        r5 = r4.f8391f;
        if (r5 == 0) goto L_0x0065;
    L_0x0058:
        r5 = r4.f8391f;
        r5 = android.support.v4.view.C0517s.m1717k(r5);
        r5 = r5.m1759b(r2);
        r0.m2169a(r5);
    L_0x0065:
        r5 = f8376t;
        r0.m2172a(r5);
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.m2168a(r1);
        r5 = r4.f8401p;
        r0.m2171a(r5);
        r4.f8399n = r0;
        r0.m2173a();
        goto L_0x0080;
    L_0x007a:
        r5 = r4.f8401p;
        r0 = 0;
        r5.mo327b(r0);
    L_0x0080:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.p.j(boolean):void");
    }

    /* renamed from: k */
    public void m9968k(boolean z) {
        if (z) {
            m9940n();
        } else {
            m9941o();
        }
        if (m9942p()) {
            C0525w a;
            if (z) {
                z = this.f8389d.mo669a(4, 100);
                a = this.f8390e.mo480a(0, 200);
            } else {
                a = this.f8389d.mo669a(0, 200);
                z = this.f8390e.mo480a(8, 100);
            }
            C0647h c0647h = new C0647h();
            c0647h.m2170a(z, a);
            c0647h.m2173a();
        } else if (z) {
            this.f8389d.mo686d(4);
            this.f8390e.setVisibility(0);
        } else {
            this.f8389d.mo686d(0);
            this.f8390e.setVisibility(8);
        }
    }

    /* renamed from: p */
    private boolean m9942p() {
        return C0517s.m1730x(this.f8388c);
    }

    /* renamed from: b */
    public Context mo398b() {
        if (this.f8404v == null) {
            TypedValue typedValue = new TypedValue();
            this.f8386a.getTheme().resolveAttribute(C0581a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f8404v = new ContextThemeWrapper(this.f8386a, i);
            } else {
                this.f8404v = this.f8386a;
            }
        }
        return this.f8404v;
    }

    /* renamed from: l */
    public void mo431l() {
        if (this.f8399n != null) {
            this.f8399n.m2175c();
            this.f8399n = null;
        }
    }

    /* renamed from: f */
    public boolean mo407f() {
        if (this.f8389d == null || !this.f8389d.mo684c()) {
            return false;
        }
        this.f8389d.mo685d();
        return true;
    }

    /* renamed from: e */
    public void mo404e(boolean z) {
        if (!this.f8378A) {
            mo400b(z);
        }
    }

    /* renamed from: a */
    public boolean mo396a(int i, KeyEvent keyEvent) {
        if (this.f8393h == null) {
            return false;
        }
        Menu b = this.f8393h.mo416b();
        if (b == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        b.setQwertyMode(z);
        return b.performShortcut(i, keyEvent, 0);
    }
}
