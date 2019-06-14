package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0503f;
import android.support.v4.view.C0512p;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0525w;
import android.support.v4.view.C3232y;
import android.support.v4.view.aa;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0583c;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.p035a.C0591a.C0589i;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.p037c.p038a.C0631b;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.C0642d;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C0664p;
import android.support.v7.view.menu.C3272f;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0799m;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0679a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ai;
import android.support.v7.widget.ao;
import android.support.v7.widget.ao.C0757a;
import android.support.v7.widget.bv;
import android.support.v7.widget.by;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDelegateImplV9 */
/* renamed from: android.support.v7.app.j */
class C4478j extends C3248f implements C0657a, Factory2 {
    /* renamed from: t */
    private static final boolean f11952t = (VERSION.SDK_INT < 21);
    /* renamed from: A */
    private View f11953A;
    /* renamed from: B */
    private boolean f11954B;
    /* renamed from: C */
    private boolean f11955C;
    /* renamed from: D */
    private boolean f11956D;
    /* renamed from: E */
    private C0617d[] f11957E;
    /* renamed from: F */
    private C0617d f11958F;
    /* renamed from: G */
    private boolean f11959G;
    /* renamed from: H */
    private final Runnable f11960H = new C06151(this);
    /* renamed from: I */
    private boolean f11961I;
    /* renamed from: J */
    private Rect f11962J;
    /* renamed from: K */
    private Rect f11963K;
    /* renamed from: L */
    private AppCompatViewInflater f11964L;
    /* renamed from: m */
    C0640b f11965m;
    /* renamed from: n */
    ActionBarContextView f11966n;
    /* renamed from: o */
    PopupWindow f11967o;
    /* renamed from: p */
    Runnable f11968p;
    /* renamed from: q */
    C0525w f11969q = null;
    /* renamed from: r */
    boolean f11970r;
    /* renamed from: s */
    int f11971s;
    /* renamed from: u */
    private ai f11972u;
    /* renamed from: v */
    private C3252a f11973v;
    /* renamed from: w */
    private C3255e f11974w;
    /* renamed from: x */
    private boolean f11975x;
    /* renamed from: y */
    private ViewGroup f11976y;
    /* renamed from: z */
    private TextView f11977z;

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$1 */
    class C06151 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4478j f1570a;

        C06151(C4478j c4478j) {
            this.f1570a = c4478j;
        }

        public void run() {
            if ((this.f1570a.f11971s & 1) != 0) {
                this.f1570a.m15043f(0);
            }
            if ((this.f1570a.f11971s & 4096) != 0) {
                this.f1570a.m15043f(108);
            }
            this.f1570a.f11970r = false;
            this.f1570a.f11971s = 0;
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$5 */
    class C06165 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4478j f1571a;

        /* compiled from: AppCompatDelegateImplV9 */
        /* renamed from: android.support.v7.app.j$5$1 */
        class C44751 extends C3232y {
            /* renamed from: a */
            final /* synthetic */ C06165 f11949a;

            C44751(C06165 c06165) {
                this.f11949a = c06165;
            }

            /* renamed from: a */
            public void mo326a(View view) {
                this.f11949a.f1571a.f11966n.setVisibility(0);
            }

            /* renamed from: b */
            public void mo327b(View view) {
                this.f11949a.f1571a.f11966n.setAlpha(1.0f);
                this.f11949a.f1571a.f11969q.m1756a(null);
                this.f11949a.f1571a.f11969q = null;
            }
        }

        C06165(C4478j c4478j) {
            this.f1571a = c4478j;
        }

        public void run() {
            this.f1571a.f11967o.showAtLocation(this.f1571a.f11966n, 55, 0, 0);
            this.f1571a.m15049t();
            if (this.f1571a.m15048s()) {
                this.f1571a.f11966n.setAlpha(0.0f);
                this.f1571a.f11969q = C0517s.m1717k(this.f1571a.f11966n).m1754a(1.0f);
                this.f1571a.f11969q.m1756a(new C44751(this));
                return;
            }
            this.f1571a.f11966n.setAlpha(1.0f);
            this.f1571a.f11966n.setVisibility(0);
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$d */
    protected static final class C0617d {
        /* renamed from: a */
        int f1572a;
        /* renamed from: b */
        int f1573b;
        /* renamed from: c */
        int f1574c;
        /* renamed from: d */
        int f1575d;
        /* renamed from: e */
        int f1576e;
        /* renamed from: f */
        int f1577f;
        /* renamed from: g */
        ViewGroup f1578g;
        /* renamed from: h */
        View f1579h;
        /* renamed from: i */
        View f1580i;
        /* renamed from: j */
        C3273h f1581j;
        /* renamed from: k */
        C3272f f1582k;
        /* renamed from: l */
        Context f1583l;
        /* renamed from: m */
        boolean f1584m;
        /* renamed from: n */
        boolean f1585n;
        /* renamed from: o */
        boolean f1586o;
        /* renamed from: p */
        public boolean f1587p;
        /* renamed from: q */
        boolean f1588q = false;
        /* renamed from: r */
        boolean f1589r;
        /* renamed from: s */
        Bundle f1590s;

        C0617d(int i) {
            this.f1572a = i;
        }

        /* renamed from: a */
        public boolean m2090a() {
            boolean z = false;
            if (this.f1579h == null) {
                return false;
            }
            if (this.f1580i != null) {
                return true;
            }
            if (this.f1582k.m10036a().getCount() > 0) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        void m2088a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0581a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0581a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0589i.Theme_AppCompat_CompactMenu, true);
            }
            Context c0642d = new C0642d(context, 0);
            c0642d.getTheme().setTo(newTheme);
            this.f1583l = c0642d;
            context = c0642d.obtainStyledAttributes(C0590j.AppCompatTheme);
            this.f1573b = context.getResourceId(C0590j.AppCompatTheme_panelBackground, 0);
            this.f1577f = context.getResourceId(C0590j.AppCompatTheme_android_windowAnimationStyle, 0);
            context.recycle();
        }

        /* renamed from: a */
        void m2089a(C3273h c3273h) {
            if (c3273h != this.f1581j) {
                if (this.f1581j != null) {
                    this.f1581j.m10075b(this.f1582k);
                }
                this.f1581j = c3273h;
                if (!(c3273h == null || this.f1582k == null)) {
                    c3273h.m10064a(this.f1582k);
                }
            }
        }

        /* renamed from: a */
        C0664p m2087a(C0661a c0661a) {
            if (this.f1581j == null) {
                return null;
            }
            if (this.f1582k == null) {
                this.f1582k = new C3272f(this.f1583l, C0587g.abc_list_menu_item_layout);
                this.f1582k.mo465a(c0661a);
                this.f1581j.m10064a(this.f1582k);
            }
            return this.f1582k.m10035a(this.f1578g);
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$2 */
    class C32492 implements C0512p {
        /* renamed from: a */
        final /* synthetic */ C4478j f8347a;

        C32492(C4478j c4478j) {
            this.f8347a = c4478j;
        }

        /* renamed from: a */
        public aa mo63a(View view, aa aaVar) {
            int b = aaVar.m1563b();
            int g = this.f8347a.m15044g(b);
            if (b != g) {
                aaVar = aaVar.m1562a(aaVar.m1561a(), g, aaVar.m1564c(), aaVar.m1565d());
            }
            return C0517s.m1686a(view, aaVar);
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$3 */
    class C32503 implements C0757a {
        /* renamed from: a */
        final /* synthetic */ C4478j f8348a;

        C32503(C4478j c4478j) {
            this.f8348a = c4478j;
        }

        /* renamed from: a */
        public void mo375a(Rect rect) {
            rect.top = this.f8348a.m15044g(rect.top);
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$4 */
    class C32514 implements C0679a {
        /* renamed from: a */
        final /* synthetic */ C4478j f8349a;

        /* renamed from: a */
        public void mo376a() {
        }

        C32514(C4478j c4478j) {
            this.f8349a = c4478j;
        }

        /* renamed from: b */
        public void mo377b() {
            this.f8349a.m15051v();
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$a */
    private final class C3252a implements C0661a {
        /* renamed from: a */
        final /* synthetic */ C4478j f8350a;

        C3252a(C4478j c4478j) {
            this.f8350a = c4478j;
        }

        /* renamed from: a */
        public boolean mo379a(C3273h c3273h) {
            Callback q = this.f8350a.m9869q();
            if (q != null) {
                q.onMenuOpened(108, c3273h);
            }
            return true;
        }

        /* renamed from: a */
        public void mo378a(C3273h c3273h, boolean z) {
            this.f8350a.m15032b(c3273h);
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$b */
    class C3253b implements C0639a {
        /* renamed from: a */
        final /* synthetic */ C4478j f8351a;
        /* renamed from: b */
        private C0639a f8352b;

        /* compiled from: AppCompatDelegateImplV9 */
        /* renamed from: android.support.v7.app.j$b$1 */
        class C44771 extends C3232y {
            /* renamed from: a */
            final /* synthetic */ C3253b f11951a;

            C44771(C3253b c3253b) {
                this.f11951a = c3253b;
            }

            /* renamed from: b */
            public void mo327b(View view) {
                this.f11951a.f8351a.f11966n.setVisibility(8);
                if (this.f11951a.f8351a.f11967o != null) {
                    this.f11951a.f8351a.f11967o.dismiss();
                } else if ((this.f11951a.f8351a.f11966n.getParent() instanceof View) != null) {
                    C0517s.m1721o((View) this.f11951a.f8351a.f11966n.getParent());
                }
                this.f11951a.f8351a.f11966n.removeAllViews();
                this.f11951a.f8351a.f11969q.m1756a(null);
                this.f11951a.f8351a.f11969q = null;
            }
        }

        public C3253b(C4478j c4478j, C0639a c0639a) {
            this.f8351a = c4478j;
            this.f8352b = c0639a;
        }

        /* renamed from: a */
        public boolean mo381a(C0640b c0640b, Menu menu) {
            return this.f8352b.mo381a(c0640b, menu);
        }

        /* renamed from: b */
        public boolean mo383b(C0640b c0640b, Menu menu) {
            return this.f8352b.mo383b(c0640b, menu);
        }

        /* renamed from: a */
        public boolean mo382a(C0640b c0640b, MenuItem menuItem) {
            return this.f8352b.mo382a(c0640b, menuItem);
        }

        /* renamed from: a */
        public void mo380a(C0640b c0640b) {
            this.f8352b.mo380a(c0640b);
            if (this.f8351a.f11967o != null) {
                this.f8351a.b.getDecorView().removeCallbacks(this.f8351a.f11968p);
            }
            if (this.f8351a.f11966n != null) {
                this.f8351a.m15049t();
                this.f8351a.f11969q = C0517s.m1717k(this.f8351a.f11966n).m1754a(0.0f);
                this.f8351a.f11969q.m1756a(new C44771(this));
            }
            if (this.f8351a.e != null) {
                this.f8351a.e.mo386b(this.f8351a.f11965m);
            }
            this.f8351a.f11965m = null;
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$c */
    private class C3254c extends ContentFrameLayout {
        /* renamed from: a */
        final /* synthetic */ C4478j f8353a;

        public C3254c(C4478j c4478j, Context context) {
            this.f8353a = c4478j;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!this.f8353a.mo2722a(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m9881a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f8353a.m15041e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0631b.m2112b(getContext(), i));
        }

        /* renamed from: a */
        private boolean m9881a(int i, int i2) {
            if (i >= -5 && i2 >= -5 && i <= getWidth() + 5) {
                if (i2 <= getHeight() + 5) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$e */
    private final class C3255e implements C0661a {
        /* renamed from: a */
        final /* synthetic */ C4478j f8354a;

        C3255e(C4478j c4478j) {
            this.f8354a = c4478j;
        }

        /* renamed from: a */
        public void mo378a(C3273h c3273h, boolean z) {
            Menu menu;
            C3273h p = c3273h.mo2755p();
            Object obj = p != c3273h ? 1 : null;
            C4478j c4478j = this.f8354a;
            if (obj != null) {
                menu = p;
            }
            C0617d a = c4478j.m15011a(menu);
            if (a == null) {
                return;
            }
            if (obj != null) {
                this.f8354a.m15015a(a.f1572a, a, p);
                this.f8354a.m15019a(a, true);
                return;
            }
            this.f8354a.m15019a(a, z);
        }

        /* renamed from: a */
        public boolean mo379a(C3273h c3273h) {
            if (c3273h == null && this.f8354a.h) {
                Callback q = this.f8354a.m9869q();
                if (!(q == null || this.f8354a.m9868p())) {
                    q.onMenuOpened(108, c3273h);
                }
            }
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImplV9 */
    /* renamed from: android.support.v7.app.j$6 */
    class C44766 extends C3232y {
        /* renamed from: a */
        final /* synthetic */ C4478j f11950a;

        C44766(C4478j c4478j) {
            this.f11950a = c4478j;
        }

        /* renamed from: a */
        public void mo326a(View view) {
            this.f11950a.f11966n.setVisibility(0);
            this.f11950a.f11966n.sendAccessibilityEvent(32);
            if ((this.f11950a.f11966n.getParent() instanceof View) != null) {
                C0517s.m1721o((View) this.f11950a.f11966n.getParent());
            }
        }

        /* renamed from: b */
        public void mo327b(View view) {
            this.f11950a.f11966n.setAlpha(1.0f);
            this.f11950a.f11969q.m1756a(null);
            this.f11950a.f11969q = null;
        }
    }

    /* renamed from: a */
    void m15024a(ViewGroup viewGroup) {
    }

    C4478j(Context context, Window window, C0610d c0610d) {
        super(context, window, c0610d);
    }

    /* renamed from: a */
    public void mo2717a(Bundle bundle) {
        if ((this.c instanceof Activity) != null && android.support.v4.app.aa.m756b((Activity) this.c) != null) {
            bundle = m9865m();
            if (bundle == null) {
                this.f11961I = true;
            } else {
                bundle.mo404e(true);
            }
        }
    }

    /* renamed from: b */
    public void mo2724b(Bundle bundle) {
        m15006w();
    }

    /* renamed from: l */
    public void mo2732l() {
        m15006w();
        if (this.h) {
            if (this.f == null) {
                if (this.c instanceof Activity) {
                    this.f = new C3264p((Activity) this.c, this.i);
                } else if (this.c instanceof Dialog) {
                    this.f = new C3264p((Dialog) this.c);
                }
                if (this.f != null) {
                    this.f.mo404e(this.f11961I);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2718a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0608a a = mo367a();
            if (a instanceof C3264p) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.mo408g();
            }
            if (toolbar != null) {
                a = new C3261m(toolbar, ((Activity) this.c).getTitle(), this.d);
                this.f = a;
                this.b.setCallback(a.m9915h());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            mo2730f();
        }
    }

    /* renamed from: a */
    public <T extends View> T mo2714a(int i) {
        m15006w();
        return this.b.findViewById(i);
    }

    /* renamed from: a */
    public void mo2716a(Configuration configuration) {
        if (this.h && this.f11975x) {
            C0608a a = mo367a();
            if (a != null) {
                a.mo393a(configuration);
            }
        }
        C0799m.m2896a().m2918a(this.a);
        mo374i();
    }

    /* renamed from: d */
    public void mo372d() {
        C0608a a = mo367a();
        if (a != null) {
            a.mo406f(false);
        }
    }

    /* renamed from: e */
    public void mo2729e() {
        C0608a a = mo367a();
        if (a != null) {
            a.mo406f(true);
        }
    }

    /* renamed from: a */
    public void mo2719a(View view) {
        m15006w();
        ViewGroup viewGroup = (ViewGroup) this.f11976y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    /* renamed from: b */
    public void mo2723b(int i) {
        m15006w();
        ViewGroup viewGroup = (ViewGroup) this.f11976y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    /* renamed from: a */
    public void mo2720a(View view, LayoutParams layoutParams) {
        m15006w();
        ViewGroup viewGroup = (ViewGroup) this.f11976y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    /* renamed from: b */
    public void mo2725b(View view, LayoutParams layoutParams) {
        m15006w();
        ((ViewGroup) this.f11976y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    /* renamed from: g */
    public void mo373g() {
        if (this.f11970r) {
            this.b.getDecorView().removeCallbacks(this.f11960H);
        }
        super.mo373g();
        if (this.f != null) {
            this.f.mo408g();
        }
    }

    /* renamed from: w */
    private void m15006w() {
        if (!this.f11975x) {
            this.f11976y = m15007x();
            CharSequence r = m9870r();
            if (!TextUtils.isEmpty(r)) {
                mo2726b(r);
            }
            m15008y();
            m15024a(this.f11976y);
            this.f11975x = true;
            C0617d a = m15010a(0, false);
            if (!m9868p()) {
                if (a == null || a.f1581j == null) {
                    mo3337d(108);
                }
            }
        }
    }

    /* renamed from: x */
    private ViewGroup m15007x() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0590j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0590j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0590j.AppCompatTheme_windowNoTitle, false)) {
                mo2728c(1);
            } else if (obtainStyledAttributes.getBoolean(C0590j.AppCompatTheme_windowActionBar, false)) {
                mo2728c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0590j.AppCompatTheme_windowActionBarOverlay, false)) {
                mo2728c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0590j.AppCompatTheme_windowActionModeOverlay, false)) {
                mo2728c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0590j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                if (this.j) {
                    view = (ViewGroup) from.inflate(C0587g.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view = (ViewGroup) from.inflate(C0587g.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    C0517s.m1696a(view, new C32492(this));
                } else {
                    ((ao) view).setOnFitSystemWindowsListener(new C32503(this));
                }
            } else if (this.k) {
                view = (ViewGroup) from.inflate(C0587g.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
            } else if (this.h) {
                Context c0642d;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0581a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0642d = new C0642d(this.a, typedValue.resourceId);
                } else {
                    c0642d = this.a;
                }
                view = (ViewGroup) LayoutInflater.from(c0642d).inflate(C0587g.abc_screen_toolbar, null);
                this.f11972u = (ai) view.findViewById(C0586f.decor_content_parent);
                this.f11972u.setWindowCallback(m9869q());
                if (this.i) {
                    this.f11972u.mo488a(109);
                }
                if (this.f11954B) {
                    this.f11972u.mo488a(2);
                }
                if (this.f11955C) {
                    this.f11972u.mo488a(5);
                }
            } else {
                view = null;
            }
            if (view != null) {
                if (this.f11972u == null) {
                    this.f11977z = (TextView) view.findViewById(C0586f.title);
                }
                by.m2842b(view);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0586f.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.b.setContentView(view);
                contentFrameLayout.setAttachListener(new C32514(this));
                return view;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
            stringBuilder.append(this.h);
            stringBuilder.append(", windowActionBarOverlay: ");
            stringBuilder.append(this.i);
            stringBuilder.append(", android:windowIsFloating: ");
            stringBuilder.append(this.k);
            stringBuilder.append(", windowActionModeOverlay: ");
            stringBuilder.append(this.j);
            stringBuilder.append(", windowNoTitle: ");
            stringBuilder.append(this.l);
            stringBuilder.append(" }");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: y */
    private void m15008y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f11976y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m2253a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0590j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0590j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0590j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0590j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0590j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0590j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: c */
    public boolean mo2728c(int i) {
        i = m15005h(i);
        if (this.l && i == 108) {
            return false;
        }
        if (this.h && i == 1) {
            this.h = false;
        }
        switch (i) {
            case 1:
                m15009z();
                this.l = true;
                return true;
            case 2:
                m15009z();
                this.f11954B = true;
                return true;
            case 5:
                m15009z();
                this.f11955C = true;
                return true;
            case 10:
                m15009z();
                this.j = true;
                return true;
            case 108:
                m15009z();
                this.h = true;
                return true;
            case 109:
                m15009z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(i);
        }
    }

    /* renamed from: b */
    void mo2726b(CharSequence charSequence) {
        if (this.f11972u != null) {
            this.f11972u.setWindowTitle(charSequence);
        } else if (m9865m() != null) {
            m9865m().mo399b(charSequence);
        } else if (this.f11977z != null) {
            this.f11977z.setText(charSequence);
        }
    }

    /* renamed from: a */
    void mo2715a(int i, Menu menu) {
        if (i == 108) {
            i = mo367a();
            if (i != 0) {
                i.mo409g(false);
            }
        } else if (i == 0) {
            C0617d a = m15010a(i, true);
            if (a.f1586o) {
                m15019a(a, false);
            }
        }
    }

    /* renamed from: b */
    boolean mo2727b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        i = mo367a();
        if (i != 0) {
            i.mo409g(true);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo389a(C3273h c3273h, MenuItem menuItem) {
        Callback q = m9869q();
        if (!(q == null || m9868p())) {
            c3273h = m15011a(c3273h.mo2755p());
            if (c3273h != null) {
                return q.onMenuItemSelected(c3273h.f1572a, menuItem);
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo388a(C3273h c3273h) {
        m14995a(c3273h, true);
    }

    /* renamed from: b */
    public C0640b m15028b(C0639a c0639a) {
        if (c0639a != null) {
            if (this.f11965m != null) {
                this.f11965m.mo419c();
            }
            C0639a c3253b = new C3253b(this, c0639a);
            c0639a = mo367a();
            if (c0639a != null) {
                this.f11965m = c0639a.mo425a(c3253b);
                if (!(this.f11965m == null || this.e == null)) {
                    this.e.mo385a(this.f11965m);
                }
            }
            if (this.f11965m == null) {
                this.f11965m = mo2713a(c3253b);
            }
            return this.f11965m;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: f */
    public void mo2730f() {
        C0608a a = mo367a();
        if (a == null || !a.mo405e()) {
            mo3337d(0);
        }
    }

    /* renamed from: a */
    android.support.v7.view.C0640b mo2713a(android.support.v7.view.C0640b.C0639a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r7.m15049t();
        r0 = r7.f11965m;
        if (r0 == 0) goto L_0x000c;
    L_0x0007:
        r0 = r7.f11965m;
        r0.mo419c();
    L_0x000c:
        r0 = r8 instanceof android.support.v7.app.C4478j.C3253b;
        if (r0 != 0) goto L_0x0016;
    L_0x0010:
        r0 = new android.support.v7.app.j$b;
        r0.<init>(r7, r8);
        r8 = r0;
    L_0x0016:
        r0 = r7.e;
        r1 = 0;
        if (r0 == 0) goto L_0x0028;
    L_0x001b:
        r0 = r7.m9868p();
        if (r0 != 0) goto L_0x0028;
    L_0x0021:
        r0 = r7.e;	 Catch:{ AbstractMethodError -> 0x0028 }
        r0 = r0.mo384a(r8);	 Catch:{ AbstractMethodError -> 0x0028 }
        goto L_0x0029;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        if (r0 == 0) goto L_0x002f;
    L_0x002b:
        r7.f11965m = r0;
        goto L_0x016c;
    L_0x002f:
        r0 = r7.f11966n;
        r2 = 0;
        r3 = 1;
        if (r0 != 0) goto L_0x00dc;
    L_0x0035:
        r0 = r7.k;
        if (r0 == 0) goto L_0x00bd;
    L_0x0039:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r4 = r7.a;
        r4 = r4.getTheme();
        r5 = android.support.v7.p035a.C0591a.C0581a.actionBarTheme;
        r4.resolveAttribute(r5, r0, r3);
        r5 = r0.resourceId;
        if (r5 == 0) goto L_0x006e;
    L_0x004d:
        r5 = r7.a;
        r5 = r5.getResources();
        r5 = r5.newTheme();
        r5.setTo(r4);
        r4 = r0.resourceId;
        r5.applyStyle(r4, r3);
        r4 = new android.support.v7.view.d;
        r6 = r7.a;
        r4.<init>(r6, r2);
        r6 = r4.getTheme();
        r6.setTo(r5);
        goto L_0x0070;
    L_0x006e:
        r4 = r7.a;
    L_0x0070:
        r5 = new android.support.v7.widget.ActionBarContextView;
        r5.<init>(r4);
        r7.f11966n = r5;
        r5 = new android.widget.PopupWindow;
        r6 = android.support.v7.p035a.C0591a.C0581a.actionModePopupWindowStyle;
        r5.<init>(r4, r1, r6);
        r7.f11967o = r5;
        r5 = r7.f11967o;
        r6 = 2;
        android.support.v4.widget.C0560n.m1894a(r5, r6);
        r5 = r7.f11967o;
        r6 = r7.f11966n;
        r5.setContentView(r6);
        r5 = r7.f11967o;
        r6 = -1;
        r5.setWidth(r6);
        r5 = r4.getTheme();
        r6 = android.support.v7.p035a.C0591a.C0581a.actionBarSize;
        r5.resolveAttribute(r6, r0, r3);
        r0 = r0.data;
        r4 = r4.getResources();
        r4 = r4.getDisplayMetrics();
        r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4);
        r4 = r7.f11966n;
        r4.setContentHeight(r0);
        r0 = r7.f11967o;
        r4 = -2;
        r0.setHeight(r4);
        r0 = new android.support.v7.app.j$5;
        r0.<init>(r7);
        r7.f11968p = r0;
        goto L_0x00dc;
    L_0x00bd:
        r0 = r7.f11976y;
        r4 = android.support.v7.p035a.C0591a.C0586f.action_mode_bar_stub;
        r0 = r0.findViewById(r4);
        r0 = (android.support.v7.widget.ViewStubCompat) r0;
        if (r0 == 0) goto L_0x00dc;
    L_0x00c9:
        r4 = r7.m9866n();
        r4 = android.view.LayoutInflater.from(r4);
        r0.setLayoutInflater(r4);
        r0 = r0.m2478a();
        r0 = (android.support.v7.widget.ActionBarContextView) r0;
        r7.f11966n = r0;
    L_0x00dc:
        r0 = r7.f11966n;
        if (r0 == 0) goto L_0x016c;
    L_0x00e0:
        r7.m15049t();
        r0 = r7.f11966n;
        r0.m10163c();
        r0 = new android.support.v7.view.e;
        r4 = r7.f11966n;
        r4 = r4.getContext();
        r5 = r7.f11966n;
        r6 = r7.f11967o;
        if (r6 != 0) goto L_0x00f7;
    L_0x00f6:
        goto L_0x00f8;
    L_0x00f7:
        r3 = 0;
    L_0x00f8:
        r0.<init>(r4, r5, r8, r3);
        r3 = r0.mo416b();
        r8 = r8.mo381a(r0, r3);
        if (r8 == 0) goto L_0x016a;
    L_0x0105:
        r0.mo420d();
        r8 = r7.f11966n;
        r8.m10160a(r0);
        r7.f11965m = r0;
        r8 = r7.m15048s();
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r8 == 0) goto L_0x0134;
    L_0x0117:
        r8 = r7.f11966n;
        r1 = 0;
        r8.setAlpha(r1);
        r8 = r7.f11966n;
        r8 = android.support.v4.view.C0517s.m1717k(r8);
        r8 = r8.m1754a(r0);
        r7.f11969q = r8;
        r8 = r7.f11969q;
        r0 = new android.support.v7.app.j$6;
        r0.<init>(r7);
        r8.m1756a(r0);
        goto L_0x015a;
    L_0x0134:
        r8 = r7.f11966n;
        r8.setAlpha(r0);
        r8 = r7.f11966n;
        r8.setVisibility(r2);
        r8 = r7.f11966n;
        r0 = 32;
        r8.sendAccessibilityEvent(r0);
        r8 = r7.f11966n;
        r8 = r8.getParent();
        r8 = r8 instanceof android.view.View;
        if (r8 == 0) goto L_0x015a;
    L_0x014f:
        r8 = r7.f11966n;
        r8 = r8.getParent();
        r8 = (android.view.View) r8;
        android.support.v4.view.C0517s.m1721o(r8);
    L_0x015a:
        r8 = r7.f11967o;
        if (r8 == 0) goto L_0x016c;
    L_0x015e:
        r8 = r7.b;
        r8 = r8.getDecorView();
        r0 = r7.f11968p;
        r8.post(r0);
        goto L_0x016c;
    L_0x016a:
        r7.f11965m = r1;
    L_0x016c:
        r8 = r7.f11965m;
        if (r8 == 0) goto L_0x017b;
    L_0x0170:
        r8 = r7.e;
        if (r8 == 0) goto L_0x017b;
    L_0x0174:
        r8 = r7.e;
        r0 = r7.f11965m;
        r8.mo385a(r0);
    L_0x017b:
        r8 = r7.f11965m;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.j.a(android.support.v7.view.b$a):android.support.v7.view.b");
    }

    /* renamed from: s */
    final boolean m15048s() {
        return this.f11975x && this.f11976y != null && C0517s.m1730x(this.f11976y);
    }

    /* renamed from: t */
    void m15049t() {
        if (this.f11969q != null) {
            this.f11969q.m1761b();
        }
    }

    /* renamed from: u */
    boolean m15050u() {
        if (this.f11965m != null) {
            this.f11965m.mo419c();
            return true;
        }
        C0608a a = mo367a();
        if (a == null || !a.mo407f()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    boolean mo2721a(int i, KeyEvent keyEvent) {
        C0608a a = mo367a();
        if (a != null && a.mo396a(i, keyEvent) != 0) {
            return true;
        }
        if (this.f11958F == 0 || m14997a(this.f11958F, keyEvent.getKeyCode(), keyEvent, 1) == 0) {
            if (this.f11958F == 0) {
                C0617d a2 = m15010a(0, true);
                m15000b(a2, keyEvent);
                keyEvent = m14997a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1584m = false;
                if (keyEvent != null) {
                    return true;
                }
            }
            return false;
        }
        if (this.f11958F != 0) {
            this.f11958F.f1585n = true;
        }
        return true;
    }

    /* renamed from: a */
    boolean mo2722a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m15038c(keyCode, keyEvent) : m15035b(keyCode, keyEvent);
    }

    /* renamed from: b */
    boolean m15035b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i = this.f11959G;
            this.f11959G = false;
            C0617d a = m15010a(0, false);
            if (a != null && a.f1586o) {
                if (i == 0) {
                    m15019a(a, true);
                }
                return true;
            } else if (m15050u() != 0) {
                return true;
            }
        } else if (i == 82) {
            m15004e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    boolean m15038c(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.f11959G = z;
        } else if (i == 82) {
            m15003d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public View m15029b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.f11964L == null) {
            String string = this.a.obtainStyledAttributes(C0590j.AppCompatTheme).getString(C0590j.AppCompatTheme_viewInflaterClass);
            if (string != null) {
                if (!AppCompatViewInflater.class.getName().equals(string)) {
                    try {
                        this.f11964L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to instantiate custom view inflater ");
                        stringBuilder.append(string);
                        stringBuilder.append(". Falling back to default.");
                        Log.i("AppCompatDelegate", stringBuilder.toString(), th);
                        this.f11964L = new AppCompatViewInflater();
                    }
                }
            }
            this.f11964L = new AppCompatViewInflater();
        }
        if (f11952t) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = m14998a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f11964L.m2000a(view, str, context, attributeSet, z, f11952t, true, bv.m2802a());
    }

    /* renamed from: a */
    private boolean m14998a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        while (viewParent != null) {
            if (viewParent != decorView && (viewParent instanceof View)) {
                if (!C0517s.m1683A((View) viewParent)) {
                    viewParent = viewParent.getParent();
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public void mo2731h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0503f.m1591b(from, this);
        } else if (!(from.getFactory2() instanceof C4478j)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo3335a(view, str, context, attributeSet);
        if (a != null) {
            return a;
        }
        return m15029b(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* renamed from: a */
    View mo3335a(View view, String str, Context context, AttributeSet attributeSet) {
        if ((this.c instanceof Factory) != null) {
            view = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m14994a(C0617d c0617d, KeyEvent keyEvent) {
        if (!c0617d.f1586o) {
            if (!m9868p()) {
                if (c0617d.f1572a == 0) {
                    if (((this.a.getResources().getConfiguration().screenLayout & 15) == 4 ? 1 : null) != null) {
                        return;
                    }
                }
                Callback q = m9869q();
                if (q == null || q.onMenuOpened(c0617d.f1572a, c0617d.f1581j)) {
                    WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
                    if (windowManager != null && m15000b(c0617d, keyEvent) != null) {
                        int i;
                        KeyEvent layoutParams;
                        if (c0617d.f1578g != null) {
                            if (c0617d.f1588q == null) {
                                if (c0617d.f1580i != null) {
                                    keyEvent = c0617d.f1580i.getLayoutParams();
                                    if (keyEvent != null && keyEvent.width == -1) {
                                        i = -1;
                                        c0617d.f1585n = false;
                                        layoutParams = new WindowManager.LayoutParams(i, -2, c0617d.f1575d, c0617d.f1576e, 1002, 8519680, -3);
                                        layoutParams.gravity = c0617d.f1574c;
                                        layoutParams.windowAnimations = c0617d.f1577f;
                                        windowManager.addView(c0617d.f1578g, layoutParams);
                                        c0617d.f1586o = true;
                                        return;
                                    }
                                }
                                i = -2;
                                c0617d.f1585n = false;
                                layoutParams = new WindowManager.LayoutParams(i, -2, c0617d.f1575d, c0617d.f1576e, 1002, 8519680, -3);
                                layoutParams.gravity = c0617d.f1574c;
                                layoutParams.windowAnimations = c0617d.f1577f;
                                windowManager.addView(c0617d.f1578g, layoutParams);
                                c0617d.f1586o = true;
                                return;
                            }
                        }
                        if (c0617d.f1578g == null) {
                            if (m14996a(c0617d) == null || c0617d.f1578g == null) {
                                return;
                            }
                        } else if (c0617d.f1588q != null && c0617d.f1578g.getChildCount() > null) {
                            c0617d.f1578g.removeAllViews();
                        }
                        if (m15001c(c0617d) != null) {
                            if (c0617d.m2090a() != null) {
                                keyEvent = c0617d.f1579h.getLayoutParams();
                                if (keyEvent == null) {
                                    keyEvent = new LayoutParams(-2, -2);
                                }
                                c0617d.f1578g.setBackgroundResource(c0617d.f1573b);
                                ViewParent parent = c0617d.f1579h.getParent();
                                if (parent != null && (parent instanceof ViewGroup)) {
                                    ((ViewGroup) parent).removeView(c0617d.f1579h);
                                }
                                c0617d.f1578g.addView(c0617d.f1579h, keyEvent);
                                if (c0617d.f1579h.hasFocus() == null) {
                                    c0617d.f1579h.requestFocus();
                                }
                                i = -2;
                                c0617d.f1585n = false;
                                layoutParams = new WindowManager.LayoutParams(i, -2, c0617d.f1575d, c0617d.f1576e, 1002, 8519680, -3);
                                layoutParams.gravity = c0617d.f1574c;
                                layoutParams.windowAnimations = c0617d.f1577f;
                                windowManager.addView(c0617d.f1578g, layoutParams);
                                c0617d.f1586o = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                m15019a(c0617d, true);
            }
        }
    }

    /* renamed from: a */
    private boolean m14996a(C0617d c0617d) {
        c0617d.m2088a(m9866n());
        c0617d.f1578g = new C3254c(this, c0617d.f1583l);
        c0617d.f1574c = 81;
        return true;
    }

    /* renamed from: a */
    private void m14995a(C3273h c3273h, boolean z) {
        if (this.f11972u == null || this.f11972u.mo490e() == null || (ViewConfiguration.get(this.a).hasPermanentMenuKey() != null && this.f11972u.mo492g() == null)) {
            C0617d a = m15010a(0, true);
            a.f1588q = true;
            m15019a(a, false);
            m14994a(a, (KeyEvent) false);
            return;
        }
        c3273h = m9869q();
        if (this.f11972u.mo491f()) {
            if (z) {
                this.f11972u.mo494i();
                if (!m9868p()) {
                    c3273h.onPanelClosed(108, m15010a(0, true).f1581j);
                }
            }
        }
        if (!(c3273h == null || m9868p())) {
            if (this.f11970r && (this.f11971s & true)) {
                this.b.getDecorView().removeCallbacks(this.f11960H);
                this.f11960H.run();
            }
            z = m15010a(0, true);
            if (!(z.f1581j == null || z.f1589r || !c3273h.onPreparePanel(0, z.f1580i, z.f1581j))) {
                c3273h.onMenuOpened(108, z.f1581j);
                this.f11972u.mo493h();
            }
        }
    }

    /* renamed from: b */
    private boolean m14999b(C0617d c0617d) {
        Context context = this.a;
        if ((c0617d.f1572a == 0 || c0617d.f1572a == 108) && this.f11972u != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0581a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0581a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0581a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                Context c0642d = new C0642d(context, 0);
                c0642d.getTheme().setTo(theme2);
                context = c0642d;
            }
        }
        C3273h c3273h = new C3273h(context);
        c3273h.mo2749a((C0657a) this);
        c0617d.m2089a(c3273h);
        return true;
    }

    /* renamed from: c */
    private boolean m15001c(C0617d c0617d) {
        boolean z = true;
        if (c0617d.f1580i != null) {
            c0617d.f1579h = c0617d.f1580i;
            return true;
        } else if (c0617d.f1581j == null) {
            return false;
        } else {
            if (this.f11974w == null) {
                this.f11974w = new C3255e(this);
            }
            c0617d.f1579h = (View) c0617d.m2087a(this.f11974w);
            if (c0617d.f1579h == null) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    private boolean m15000b(C0617d c0617d, KeyEvent keyEvent) {
        if (m9868p()) {
            return false;
        }
        if (c0617d.f1584m) {
            return true;
        }
        Object obj;
        if (!(this.f11958F == null || this.f11958F == c0617d)) {
            m15019a(this.f11958F, false);
        }
        Callback q = m9869q();
        if (q != null) {
            c0617d.f1580i = q.onCreatePanelView(c0617d.f1572a);
        }
        if (c0617d.f1572a != 0) {
            if (c0617d.f1572a != 108) {
                obj = null;
                if (!(obj == null || this.f11972u == null)) {
                    this.f11972u.mo495j();
                }
                if (c0617d.f1580i == null && (obj == null || !(m9865m() instanceof C3261m))) {
                    if (c0617d.f1581j == null || c0617d.f1589r) {
                        if (c0617d.f1581j != null && (!m14999b(c0617d) || c0617d.f1581j == null)) {
                            return false;
                        }
                        if (!(obj == null || this.f11972u == null)) {
                            if (this.f11973v == null) {
                                this.f11973v = new C3252a(this);
                            }
                            this.f11972u.mo489a(c0617d.f1581j, this.f11973v);
                        }
                        c0617d.f1581j.m10088g();
                        if (q.onCreatePanelMenu(c0617d.f1572a, c0617d.f1581j)) {
                            c0617d.m2089a(null);
                            if (!(obj == null || this.f11972u == null)) {
                                this.f11972u.mo489a(null, this.f11973v);
                            }
                            return false;
                        }
                        c0617d.f1589r = false;
                    }
                    c0617d.f1581j.m10088g();
                    if (c0617d.f1590s != null) {
                        c0617d.f1581j.m10073b(c0617d.f1590s);
                        c0617d.f1590s = null;
                    }
                    if (q.onPreparePanel(0, c0617d.f1580i, c0617d.f1581j)) {
                        if (!(obj == null || this.f11972u == null)) {
                            this.f11972u.mo489a(null, this.f11973v);
                        }
                        c0617d.f1581j.m10089h();
                        return false;
                    }
                    c0617d.f1587p = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1 ? true : null;
                    c0617d.f1581j.setQwertyMode(c0617d.f1587p);
                    c0617d.f1581j.m10089h();
                }
                c0617d.f1584m = true;
                c0617d.f1585n = false;
                this.f11958F = c0617d;
                return true;
            }
        }
        obj = 1;
        this.f11972u.mo495j();
        if (c0617d.f1581j != null) {
        }
        if (this.f11973v == null) {
            this.f11973v = new C3252a(this);
        }
        this.f11972u.mo489a(c0617d.f1581j, this.f11973v);
        c0617d.f1581j.m10088g();
        if (q.onCreatePanelMenu(c0617d.f1572a, c0617d.f1581j)) {
            c0617d.f1589r = false;
            c0617d.f1581j.m10088g();
            if (c0617d.f1590s != null) {
                c0617d.f1581j.m10073b(c0617d.f1590s);
                c0617d.f1590s = null;
            }
            if (q.onPreparePanel(0, c0617d.f1580i, c0617d.f1581j)) {
                if (keyEvent == null) {
                }
                if (KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
                }
                c0617d.f1587p = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1 ? true : null;
                c0617d.f1581j.setQwertyMode(c0617d.f1587p);
                c0617d.f1581j.m10089h();
                c0617d.f1584m = true;
                c0617d.f1585n = false;
                this.f11958F = c0617d;
                return true;
            }
            this.f11972u.mo489a(null, this.f11973v);
            c0617d.f1581j.m10089h();
            return false;
        }
        c0617d.m2089a(null);
        this.f11972u.mo489a(null, this.f11973v);
        return false;
    }

    /* renamed from: b */
    void m15032b(C3273h c3273h) {
        if (!this.f11956D) {
            this.f11956D = true;
            this.f11972u.mo496k();
            Callback q = m9869q();
            if (!(q == null || m9868p())) {
                q.onPanelClosed(108, c3273h);
            }
            this.f11956D = null;
        }
    }

    /* renamed from: e */
    void m15041e(int i) {
        m15019a(m15010a(i, true), true);
    }

    /* renamed from: a */
    void m15019a(C0617d c0617d, boolean z) {
        if (z && c0617d.f1572a == 0 && this.f11972u != null && this.f11972u.mo491f()) {
            m15032b(c0617d.f1581j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0617d.f1586o || c0617d.f1578g == null)) {
            windowManager.removeView(c0617d.f1578g);
            if (z) {
                m15015a(c0617d.f1572a, c0617d, null);
            }
        }
        c0617d.f1584m = false;
        c0617d.f1585n = false;
        c0617d.f1586o = false;
        c0617d.f1579h = null;
        c0617d.f1588q = true;
        if (this.f11958F == c0617d) {
            this.f11958F = null;
        }
    }

    /* renamed from: d */
    private boolean m15003d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0617d a = m15010a(i, true);
            if (!a.f1586o) {
                return m15000b(a, keyEvent);
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m15004e(int i, KeyEvent keyEvent) {
        if (this.f11965m != null) {
            return false;
        }
        C0617d a = m15010a(i, true);
        AudioManager audioManager;
        if (i != 0 || this.f11972u == 0 || this.f11972u.mo490e() == 0 || ViewConfiguration.get(this.a).hasPermanentMenuKey() != 0) {
            if (a.f1586o == 0) {
                if (a.f1585n == 0) {
                    if (a.f1584m != 0) {
                        if (a.f1589r != 0) {
                            a.f1584m = false;
                            i = m15000b(a, keyEvent);
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            m14994a(a, keyEvent);
                            i = 1;
                            if (i != 0) {
                                audioManager = (AudioManager) this.a.getSystemService("audio");
                                if (audioManager == null) {
                                    audioManager.playSoundEffect(0);
                                } else {
                                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                }
                            }
                            return i;
                        }
                    }
                }
            }
            i = a.f1586o;
            m15019a(a, true);
            if (i != 0) {
                audioManager = (AudioManager) this.a.getSystemService("audio");
                if (audioManager == null) {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                } else {
                    audioManager.playSoundEffect(0);
                }
            }
            return i;
        }
        if (this.f11972u.mo491f() != 0) {
            i = this.f11972u.mo494i();
        } else if (m9868p() == 0 && m15000b(a, keyEvent) != 0) {
            i = this.f11972u.mo493h();
        }
        if (i != 0) {
            audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager == null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return i;
        i = 0;
        if (i != 0) {
            audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager == null) {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            } else {
                audioManager.playSoundEffect(0);
            }
        }
        return i;
    }

    /* renamed from: a */
    void m15015a(int i, C0617d c0617d, Menu menu) {
        if (menu == null) {
            if (c0617d == null && i >= 0 && i < this.f11957E.length) {
                c0617d = this.f11957E[i];
            }
            if (c0617d != null) {
                menu = c0617d.f1581j;
            }
        }
        if ((c0617d == null || c0617d.f1586o != null) && m9868p() == null) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* renamed from: a */
    C0617d m15011a(Menu menu) {
        C0617d[] c0617dArr = this.f11957E;
        int i = 0;
        int length = c0617dArr != null ? c0617dArr.length : 0;
        while (i < length) {
            C0617d c0617d = c0617dArr[i];
            if (c0617d != null && c0617d.f1581j == menu) {
                return c0617d;
            }
            i++;
        }
        return null;
    }

    /* renamed from: a */
    protected C0617d m15010a(int i, boolean z) {
        z = this.f11957E;
        if (!z || z.length <= i) {
            Object obj = new C0617d[(i + 1)];
            if (z) {
                System.arraycopy(z, 0, obj, 0, z.length);
            }
            this.f11957E = obj;
            z = obj;
        }
        C0617d c0617d = z[i];
        if (c0617d != null) {
            return c0617d;
        }
        c0617d = new C0617d(i);
        z[i] = c0617d;
        return c0617d;
    }

    /* renamed from: a */
    private boolean m14997a(C0617d c0617d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0617d.f1584m || m15000b(c0617d, keyEvent)) && c0617d.f1581j != null) {
            z = c0617d.f1581j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == null && this.f11972u == null) {
            m15019a(c0617d, (boolean) 1);
        }
        return z;
    }

    /* renamed from: d */
    private void mo3337d(int i) {
        this.f11971s = (1 << i) | this.f11971s;
        if (this.f11970r == 0) {
            C0517s.m1697a(this.b.getDecorView(), this.f11960H);
            this.f11970r = true;
        }
    }

    /* renamed from: f */
    void m15043f(int i) {
        C0617d a = m15010a(i, true);
        if (a.f1581j != null) {
            Bundle bundle = new Bundle();
            a.f1581j.m10061a(bundle);
            if (bundle.size() > 0) {
                a.f1590s = bundle;
            }
            a.f1581j.m10088g();
            a.f1581j.clear();
        }
        a.f1589r = true;
        a.f1588q = true;
        if ((i == 108 || i == 0) && this.f11972u != 0) {
            C0617d a2 = m15010a(0, false);
            if (a2 != null) {
                a2.f1584m = false;
                m15000b(a2, (KeyEvent) 0);
            }
        }
    }

    /* renamed from: g */
    int m15044g(int i) {
        Object obj;
        int i2 = 0;
        if (this.f11966n == null || !(this.f11966n.getLayoutParams() instanceof MarginLayoutParams)) {
            obj = null;
        } else {
            Object obj2;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f11966n.getLayoutParams();
            obj = 1;
            if (this.f11966n.isShown()) {
                if (this.f11962J == null) {
                    this.f11962J = new Rect();
                    this.f11963K = new Rect();
                }
                Rect rect = this.f11962J;
                Rect rect2 = this.f11963K;
                rect.set(0, i, 0, 0);
                by.m2840a(this.f11976y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f11953A == null) {
                        this.f11953A = new View(this.a);
                        this.f11953A.setBackgroundColor(this.a.getResources().getColor(C0583c.abc_input_method_navigation_guard));
                        this.f11976y.addView(this.f11953A, -1, new LayoutParams(-1, i));
                    } else {
                        LayoutParams layoutParams = this.f11953A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f11953A.setLayoutParams(layoutParams);
                        }
                    }
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (this.f11953A == null) {
                    obj = null;
                }
                if (!(this.j || r3 == null)) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                this.f11966n.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f11953A != null) {
            View view = this.f11953A;
            if (obj == null) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: z */
    private void m15009z() {
        if (this.f11975x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: h */
    private int m15005h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* renamed from: v */
    void m15051v() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.f11972u;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r2.f11972u;
        r0.mo496k();
    L_0x0009:
        r0 = r2.f11967o;
        if (r0 == 0) goto L_0x0028;
    L_0x000d:
        r0 = r2.b;
        r0 = r0.getDecorView();
        r1 = r2.f11968p;
        r0.removeCallbacks(r1);
        r0 = r2.f11967o;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0025;
    L_0x0020:
        r0 = r2.f11967o;	 Catch:{ IllegalArgumentException -> 0x0025 }
        r0.dismiss();	 Catch:{ IllegalArgumentException -> 0x0025 }
    L_0x0025:
        r0 = 0;
        r2.f11967o = r0;
    L_0x0028:
        r2.m15049t();
        r0 = 0;
        r0 = r2.m15010a(r0, r0);
        if (r0 == 0) goto L_0x003b;
    L_0x0032:
        r1 = r0.f1581j;
        if (r1 == 0) goto L_0x003b;
    L_0x0036:
        r0 = r0.f1581j;
        r0.close();
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.j.v():void");
    }
}
