package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.widget.aw;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/* compiled from: StandardMenuPopup */
/* renamed from: android.support.v7.view.menu.t */
final class C4486t extends C3281m implements C0662o, OnKeyListener, OnItemClickListener, OnDismissListener {
    /* renamed from: a */
    final aw f12023a;
    /* renamed from: b */
    View f12024b;
    /* renamed from: c */
    private final Context f12025c;
    /* renamed from: d */
    private final C3273h f12026d;
    /* renamed from: e */
    private final C0656g f12027e;
    /* renamed from: f */
    private final boolean f12028f;
    /* renamed from: g */
    private final int f12029g;
    /* renamed from: h */
    private final int f12030h;
    /* renamed from: i */
    private final int f12031i;
    /* renamed from: j */
    private final OnGlobalLayoutListener f12032j = new C06671(this);
    /* renamed from: k */
    private final OnAttachStateChangeListener f12033k = new C06682(this);
    /* renamed from: l */
    private OnDismissListener f12034l;
    /* renamed from: m */
    private View f12035m;
    /* renamed from: n */
    private C0661a f12036n;
    /* renamed from: o */
    private ViewTreeObserver f12037o;
    /* renamed from: p */
    private boolean f12038p;
    /* renamed from: q */
    private boolean f12039q;
    /* renamed from: r */
    private int f12040r;
    /* renamed from: s */
    private int f12041s = 0;
    /* renamed from: t */
    private boolean f12042t;

    /* compiled from: StandardMenuPopup */
    /* renamed from: android.support.v7.view.menu.t$1 */
    class C06671 implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ C4486t f1711a;

        C06671(C4486t c4486t) {
            this.f1711a = c4486t;
        }

        public void onGlobalLayout() {
            if (this.f1711a.mo636d() && !this.f1711a.f12023a.m10466g()) {
                View view = this.f1711a.f12024b;
                if (view != null) {
                    if (view.isShown()) {
                        this.f1711a.f12023a.mo634a();
                        return;
                    }
                }
                this.f1711a.mo635c();
            }
        }
    }

    /* compiled from: StandardMenuPopup */
    /* renamed from: android.support.v7.view.menu.t$2 */
    class C06682 implements OnAttachStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ C4486t f1712a;

        public void onViewAttachedToWindow(View view) {
        }

        C06682(C4486t c4486t) {
            this.f1712a = c4486t;
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f1712a.f12037o != null) {
                if (!this.f1712a.f12037o.isAlive()) {
                    this.f1712a.f12037o = view.getViewTreeObserver();
                }
                this.f1712a.f12037o.removeGlobalOnLayoutListener(this.f1712a.f12032j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: a */
    public void mo2736a(C3273h c3273h) {
    }

    /* renamed from: b */
    public boolean mo469b() {
        return false;
    }

    public C4486t(Context context, C3273h c3273h, View view, int i, int i2, boolean z) {
        this.f12025c = context;
        this.f12026d = c3273h;
        this.f12028f = z;
        this.f12027e = new C0656g(c3273h, LayoutInflater.from(context), this.f12028f);
        this.f12030h = i;
        this.f12031i = i2;
        i = context.getResources();
        this.f12029g = Math.max(i.getDisplayMetrics().widthPixels / 2, i.getDimensionPixelSize(C0584d.abc_config_prefDialogWidth));
        this.f12035m = view;
        this.f12023a = new aw(this.f12025c, null, this.f12030h, this.f12031i);
        c3273h.m10065a((C0662o) this, context);
    }

    /* renamed from: a */
    public void mo2739a(boolean z) {
        this.f12027e.m2182a(z);
    }

    /* renamed from: a */
    public void mo2735a(int i) {
        this.f12041s = i;
    }

    /* renamed from: h */
    private boolean m15101h() {
        if (mo636d()) {
            return true;
        }
        if (!this.f12038p) {
            if (this.f12035m != null) {
                this.f12024b = this.f12035m;
                this.f12023a.m10453a((OnDismissListener) this);
                this.f12023a.m10451a((OnItemClickListener) this);
                this.f12023a.m10454a(true);
                View view = this.f12024b;
                Object obj = this.f12037o == null ? 1 : null;
                this.f12037o = view.getViewTreeObserver();
                if (obj != null) {
                    this.f12037o.addOnGlobalLayoutListener(this.f12032j);
                }
                view.addOnAttachStateChangeListener(this.f12033k);
                this.f12023a.m10456b(view);
                this.f12023a.m10463e(this.f12041s);
                if (!this.f12039q) {
                    this.f12040r = C3281m.m10141a(this.f12027e, null, this.f12025c, this.f12029g);
                    this.f12039q = true;
                }
                this.f12023a.m10465g(this.f12040r);
                this.f12023a.m10468h(2);
                this.f12023a.m10449a(m10157g());
                this.f12023a.mo634a();
                ViewGroup e = this.f12023a.mo637e();
                e.setOnKeyListener(this);
                if (this.f12042t && this.f12026d.m10094m() != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f12025c).inflate(C0587g.abc_popup_menu_header_item_layout, e, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f12026d.m10094m());
                    }
                    frameLayout.setEnabled(false);
                    e.addHeaderView(frameLayout, null, false);
                }
                this.f12023a.mo2786a(this.f12027e);
                this.f12023a.mo634a();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo634a() {
        if (!m15101h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    /* renamed from: c */
    public void mo635c() {
        if (mo636d()) {
            this.f12023a.mo635c();
        }
    }

    /* renamed from: d */
    public boolean mo636d() {
        return !this.f12038p && this.f12023a.mo636d();
    }

    public void onDismiss() {
        this.f12038p = true;
        this.f12026d.close();
        if (this.f12037o != null) {
            if (!this.f12037o.isAlive()) {
                this.f12037o = this.f12024b.getViewTreeObserver();
            }
            this.f12037o.removeGlobalOnLayoutListener(this.f12032j);
            this.f12037o = null;
        }
        this.f12024b.removeOnAttachStateChangeListener(this.f12033k);
        if (this.f12034l != null) {
            this.f12034l.onDismiss();
        }
    }

    /* renamed from: b */
    public void mo468b(boolean z) {
        this.f12039q = false;
        if (this.f12027e) {
            this.f12027e.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo465a(C0661a c0661a) {
        this.f12036n = c0661a;
    }

    /* renamed from: a */
    public boolean mo467a(C4487u c4487u) {
        if (c4487u.hasVisibleItems()) {
            C0660n c0660n = new C0660n(this.f12025c, c4487u, this.f12024b, this.f12028f, this.f12030h, this.f12031i);
            c0660n.m2191a(this.f12036n);
            c0660n.m2194a(C3281m.m10143b((C3273h) c4487u));
            c0660n.m2190a(this.f12041s);
            c0660n.m2193a(this.f12034l);
            this.f12034l = null;
            this.f12026d.m10068a(false);
            if (c0660n.m2195a(this.f12023a.m10471j(), this.f12023a.m10472k())) {
                if (this.f12036n != null) {
                    this.f12036n.mo379a(c4487u);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo464a(C3273h c3273h, boolean z) {
        if (c3273h == this.f12026d) {
            mo635c();
            if (this.f12036n != null) {
                this.f12036n.mo378a(c3273h, z);
            }
        }
    }

    /* renamed from: a */
    public void mo2737a(View view) {
        this.f12035m = view;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return null;
        }
        mo635c();
        return true;
    }

    /* renamed from: a */
    public void mo2738a(OnDismissListener onDismissListener) {
        this.f12034l = onDismissListener;
    }

    /* renamed from: e */
    public ListView mo637e() {
        return this.f12023a.mo637e();
    }

    /* renamed from: b */
    public void mo2740b(int i) {
        this.f12023a.m10459c(i);
    }

    /* renamed from: c */
    public void mo2741c(int i) {
        this.f12023a.m10460d(i);
    }

    /* renamed from: c */
    public void mo2742c(boolean z) {
        this.f12042t = z;
    }
}
