package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.widget.av;
import android.support.v7.widget.aw;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
/* renamed from: android.support.v7.view.menu.e */
final class C4482e extends C3281m implements C0662o, OnKeyListener, OnDismissListener {
    /* renamed from: a */
    final Handler f11994a;
    /* renamed from: b */
    final List<C0654a> f11995b = new ArrayList();
    /* renamed from: c */
    View f11996c;
    /* renamed from: d */
    boolean f11997d;
    /* renamed from: e */
    private final Context f11998e;
    /* renamed from: f */
    private final int f11999f;
    /* renamed from: g */
    private final int f12000g;
    /* renamed from: h */
    private final int f12001h;
    /* renamed from: i */
    private final boolean f12002i;
    /* renamed from: j */
    private final List<C3273h> f12003j = new ArrayList();
    /* renamed from: k */
    private final OnGlobalLayoutListener f12004k = new C06511(this);
    /* renamed from: l */
    private final OnAttachStateChangeListener f12005l = new C06522(this);
    /* renamed from: m */
    private final av f12006m = new C32713(this);
    /* renamed from: n */
    private int f12007n = 0;
    /* renamed from: o */
    private int f12008o = 0;
    /* renamed from: p */
    private View f12009p;
    /* renamed from: q */
    private int f12010q;
    /* renamed from: r */
    private boolean f12011r;
    /* renamed from: s */
    private boolean f12012s;
    /* renamed from: t */
    private int f12013t;
    /* renamed from: u */
    private int f12014u;
    /* renamed from: v */
    private boolean f12015v;
    /* renamed from: w */
    private boolean f12016w;
    /* renamed from: x */
    private C0661a f12017x;
    /* renamed from: y */
    private ViewTreeObserver f12018y;
    /* renamed from: z */
    private OnDismissListener f12019z;

    /* compiled from: CascadingMenuPopup */
    /* renamed from: android.support.v7.view.menu.e$1 */
    class C06511 implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ C4482e f1681a;

        C06511(C4482e c4482e) {
            this.f1681a = c4482e;
        }

        public void onGlobalLayout() {
            if (this.f1681a.mo636d() && this.f1681a.f11995b.size() > 0 && !((C0654a) this.f1681a.f11995b.get(0)).f1687a.m10466g()) {
                View view = this.f1681a.f11996c;
                if (view != null) {
                    if (view.isShown()) {
                        for (C0654a c0654a : this.f1681a.f11995b) {
                            c0654a.f1687a.mo634a();
                        }
                        return;
                    }
                }
                this.f1681a.mo635c();
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    /* renamed from: android.support.v7.view.menu.e$2 */
    class C06522 implements OnAttachStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ C4482e f1682a;

        public void onViewAttachedToWindow(View view) {
        }

        C06522(C4482e c4482e) {
            this.f1682a = c4482e;
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f1682a.f12018y != null) {
                if (!this.f1682a.f12018y.isAlive()) {
                    this.f1682a.f12018y = view.getViewTreeObserver();
                }
                this.f1682a.f12018y.removeGlobalOnLayoutListener(this.f1682a.f12004k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup */
    /* renamed from: android.support.v7.view.menu.e$a */
    private static class C0654a {
        /* renamed from: a */
        public final aw f1687a;
        /* renamed from: b */
        public final C3273h f1688b;
        /* renamed from: c */
        public final int f1689c;

        public C0654a(aw awVar, C3273h c3273h, int i) {
            this.f1687a = awVar;
            this.f1688b = c3273h;
            this.f1689c = i;
        }

        /* renamed from: a */
        public ListView m2177a() {
            return this.f1687a.mo637e();
        }
    }

    /* compiled from: CascadingMenuPopup */
    /* renamed from: android.support.v7.view.menu.e$3 */
    class C32713 implements av {
        /* renamed from: a */
        final /* synthetic */ C4482e f8474a;

        C32713(C4482e c4482e) {
            this.f8474a = c4482e;
        }

        /* renamed from: a */
        public void mo471a(C3273h c3273h, MenuItem menuItem) {
            this.f8474a.f11994a.removeCallbacksAndMessages(c3273h);
        }

        /* renamed from: b */
        public void mo472b(final C3273h c3273h, final MenuItem menuItem) {
            C0654a c0654a = null;
            this.f8474a.f11994a.removeCallbacksAndMessages(null);
            int size = this.f8474a.f11995b.size();
            int i = 0;
            while (i < size) {
                if (c3273h == ((C0654a) this.f8474a.f11995b.get(i)).f1688b) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                i++;
                if (i < this.f8474a.f11995b.size()) {
                    c0654a = (C0654a) this.f8474a.f11995b.get(i);
                }
                this.f8474a.f11994a.postAtTime(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ C32713 f1686d;

                    public void run() {
                        if (c0654a != null) {
                            this.f1686d.f8474a.f11997d = true;
                            c0654a.f1688b.m10068a(false);
                            this.f1686d.f8474a.f11997d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            c3273h.m10070a(menuItem, 4);
                        }
                    }
                }, c3273h, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    /* renamed from: b */
    public boolean mo469b() {
        return false;
    }

    /* renamed from: f */
    protected boolean mo2743f() {
        return false;
    }

    public C4482e(Context context, View view, int i, int i2, boolean z) {
        this.f11998e = context;
        this.f12009p = view;
        this.f12000g = i;
        this.f12001h = i2;
        this.f12002i = z;
        this.f12015v = false;
        this.f12010q = m15073i();
        context = context.getResources();
        this.f11999f = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(C0584d.abc_config_prefDialogWidth));
        this.f11994a = new Handler();
    }

    /* renamed from: a */
    public void mo2739a(boolean z) {
        this.f12015v = z;
    }

    /* renamed from: h */
    private aw m15072h() {
        aw awVar = new aw(this.f11998e, null, this.f12000g, this.f12001h);
        awVar.m15169a(this.f12006m);
        awVar.m10451a((OnItemClickListener) this);
        awVar.m10453a((OnDismissListener) this);
        awVar.m10456b(this.f12009p);
        awVar.m10463e(this.f12008o);
        awVar.m10454a(true);
        awVar.m10468h(2);
        return awVar;
    }

    /* renamed from: a */
    public void mo634a() {
        if (!mo636d()) {
            for (C3273h c : this.f12003j) {
                m15069c(c);
            }
            this.f12003j.clear();
            this.f11996c = this.f12009p;
            if (this.f11996c != null) {
                Object obj = this.f12018y == null ? 1 : null;
                this.f12018y = this.f11996c.getViewTreeObserver();
                if (obj != null) {
                    this.f12018y.addOnGlobalLayoutListener(this.f12004k);
                }
                this.f11996c.addOnAttachStateChangeListener(this.f12005l);
            }
        }
    }

    /* renamed from: c */
    public void mo635c() {
        int size = this.f11995b.size();
        if (size > 0) {
            C0654a[] c0654aArr = (C0654a[]) this.f11995b.toArray(new C0654a[size]);
            for (size--; size >= 0; size--) {
                C0654a c0654a = c0654aArr[size];
                if (c0654a.f1687a.mo636d()) {
                    c0654a.f1687a.mo635c();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return null;
        }
        mo635c();
        return true;
    }

    /* renamed from: i */
    private int m15073i() {
        return C0517s.m1711e(this.f12009p) == 1 ? 0 : 1;
    }

    /* renamed from: d */
    private int m15070d(int i) {
        ListView a = ((C0654a) this.f11995b.get(this.f11995b.size() - 1)).m2177a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f11996c.getWindowVisibleDisplayFrame(rect);
        if (this.f12010q == 1) {
            if ((iArr[0] + a.getWidth()) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: a */
    public void mo2736a(C3273h c3273h) {
        c3273h.m10065a((C0662o) this, this.f11998e);
        if (mo636d()) {
            m15069c(c3273h);
        } else {
            this.f12003j.add(c3273h);
        }
    }

    /* renamed from: c */
    private void m15069c(C3273h c3273h) {
        C0654a c0654a;
        View a;
        LayoutInflater from = LayoutInflater.from(this.f11998e);
        ListAdapter c0656g = new C0656g(c3273h, from, this.f12002i);
        if (!mo636d() && this.f12015v) {
            c0656g.m2182a(true);
        } else if (mo636d()) {
            c0656g.m2182a(C3281m.m10143b(c3273h));
        }
        int a2 = C3281m.m10141a(c0656g, null, this.f11998e, this.f11999f);
        aw h = m15072h();
        h.mo2786a(c0656g);
        h.m10465g(a2);
        h.m10463e(this.f12008o);
        if (this.f11995b.size() > 0) {
            c0654a = (C0654a) this.f11995b.get(this.f11995b.size() - 1);
            a = m15065a(c0654a, c3273h);
        } else {
            c0654a = null;
            a = c0654a;
        }
        if (a != null) {
            int i;
            h.mo2773c(false);
            h.m15170a(null);
            int d = m15070d(a2);
            Object obj = d == 1 ? 1 : null;
            this.f12010q = d;
            if (VERSION.SDK_INT >= 26) {
                h.m10456b(a);
                d = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f12009p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                if ((this.f12008o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f12009p.getWidth();
                    iArr2[0] = iArr2[0] + a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                d = iArr2[1] - iArr[1];
            }
            i = (this.f12008o & 5) == 5 ? obj != null ? i + a2 : i - a.getWidth() : obj != null ? i + a.getWidth() : i - a2;
            h.m10459c(i);
            h.m10457b(true);
            h.m10460d(d);
        } else {
            if (this.f12011r) {
                h.m10459c(this.f12013t);
            }
            if (this.f12012s) {
                h.m10460d(this.f12014u);
            }
            h.m10449a(m10157g());
        }
        this.f11995b.add(new C0654a(h, c3273h, this.f12010q));
        h.mo634a();
        ViewGroup e = h.mo637e();
        e.setOnKeyListener(this);
        if (c0654a == null && this.f12016w && c3273h.m10094m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0587g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c3273h.m10094m());
            e.addHeaderView(frameLayout, null, false);
            h.mo634a();
        }
    }

    /* renamed from: a */
    private MenuItem m15064a(C3273h c3273h, C3273h c3273h2) {
        int size = c3273h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c3273h.getItem(i);
            if (item.hasSubMenu() && c3273h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m15065a(C0654a c0654a, C3273h c3273h) {
        c3273h = m15064a(c0654a.f1688b, c3273h);
        if (c3273h == null) {
            return null;
        }
        int headersCount;
        C0656g c0656g;
        c0654a = c0654a.m2177a();
        ListAdapter adapter = c0654a.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0656g = (C0656g) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0656g = (C0656g) adapter;
            headersCount = 0;
        }
        int count = c0656g.getCount();
        while (i < count) {
            if (c3273h == c0656g.m2181a(i)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            return null;
        }
        i = (i + headersCount) - c0654a.getFirstVisiblePosition();
        if (i >= 0) {
            if (i < c0654a.getChildCount()) {
                return c0654a.getChildAt(i);
            }
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo636d() {
        return this.f11995b.size() > 0 && ((C0654a) this.f11995b.get(0)).f1687a.mo636d();
    }

    public void onDismiss() {
        C0654a c0654a;
        int size = this.f11995b.size();
        for (int i = 0; i < size; i++) {
            c0654a = (C0654a) this.f11995b.get(i);
            if (!c0654a.f1687a.mo636d()) {
                break;
            }
        }
        c0654a = null;
        if (c0654a != null) {
            c0654a.f1688b.m10068a(false);
        }
    }

    /* renamed from: b */
    public void mo468b(boolean z) {
        for (C0654a a : this.f11995b) {
            C3281m.m10142a(a.m2177a().getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo465a(C0661a c0661a) {
        this.f12017x = c0661a;
    }

    /* renamed from: a */
    public boolean mo467a(C4487u c4487u) {
        for (C0654a c0654a : this.f11995b) {
            if (c4487u == c0654a.f1688b) {
                c0654a.m2177a().requestFocus();
                return true;
            }
        }
        if (!c4487u.hasVisibleItems()) {
            return null;
        }
        mo2736a((C3273h) c4487u);
        if (this.f12017x != null) {
            this.f12017x.mo379a(c4487u);
        }
        return true;
    }

    /* renamed from: d */
    private int m15071d(C3273h c3273h) {
        int size = this.f11995b.size();
        for (int i = 0; i < size; i++) {
            if (c3273h == ((C0654a) this.f11995b.get(i)).f1688b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo464a(C3273h c3273h, boolean z) {
        int d = m15071d(c3273h);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f11995b.size()) {
                ((C0654a) this.f11995b.get(i)).f1688b.m10068a(false);
            }
            C0654a c0654a = (C0654a) this.f11995b.remove(d);
            c0654a.f1688b.m10075b((C0662o) this);
            if (this.f11997d) {
                c0654a.f1687a.m15172b(null);
                c0654a.f1687a.m10455b(0);
            }
            c0654a.f1687a.mo635c();
            d = this.f11995b.size();
            if (d > 0) {
                this.f12010q = ((C0654a) this.f11995b.get(d - 1)).f1689c;
            } else {
                this.f12010q = m15073i();
            }
            if (d == 0) {
                mo635c();
                if (this.f12017x) {
                    this.f12017x.mo378a(c3273h, true);
                }
                if (this.f12018y != null) {
                    if (this.f12018y.isAlive() != null) {
                        this.f12018y.removeGlobalOnLayoutListener(this.f12004k);
                    }
                    this.f12018y = null;
                }
                this.f11996c.removeOnAttachStateChangeListener(this.f12005l);
                this.f12019z.onDismiss();
            } else if (z) {
                ((C0654a) this.f11995b.get(0)).f1688b.m10068a(false);
            }
        }
    }

    /* renamed from: a */
    public void mo2735a(int i) {
        if (this.f12007n != i) {
            this.f12007n = i;
            this.f12008o = C0501e.m1587a(i, C0517s.m1711e(this.f12009p));
        }
    }

    /* renamed from: a */
    public void mo2737a(View view) {
        if (this.f12009p != view) {
            this.f12009p = view;
            this.f12008o = C0501e.m1587a(this.f12007n, C0517s.m1711e(this.f12009p));
        }
    }

    /* renamed from: a */
    public void mo2738a(OnDismissListener onDismissListener) {
        this.f12019z = onDismissListener;
    }

    /* renamed from: e */
    public ListView mo637e() {
        if (this.f11995b.isEmpty()) {
            return null;
        }
        return ((C0654a) this.f11995b.get(this.f11995b.size() - 1)).m2177a();
    }

    /* renamed from: b */
    public void mo2740b(int i) {
        this.f12011r = true;
        this.f12013t = i;
    }

    /* renamed from: c */
    public void mo2741c(int i) {
        this.f12012s = true;
        this.f12014u = i;
    }

    /* renamed from: c */
    public void mo2742c(boolean z) {
        this.f12016w = z;
    }
}
