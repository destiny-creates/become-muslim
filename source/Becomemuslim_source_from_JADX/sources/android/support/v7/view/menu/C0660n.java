package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.view.menu.C0662o.C0661a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopupHelper */
/* renamed from: android.support.v7.view.menu.n */
public class C0660n {
    /* renamed from: a */
    private final Context f1699a;
    /* renamed from: b */
    private final C3273h f1700b;
    /* renamed from: c */
    private final boolean f1701c;
    /* renamed from: d */
    private final int f1702d;
    /* renamed from: e */
    private final int f1703e;
    /* renamed from: f */
    private View f1704f;
    /* renamed from: g */
    private int f1705g;
    /* renamed from: h */
    private boolean f1706h;
    /* renamed from: i */
    private C0661a f1707i;
    /* renamed from: j */
    private C3281m f1708j;
    /* renamed from: k */
    private OnDismissListener f1709k;
    /* renamed from: l */
    private final OnDismissListener f1710l;

    /* compiled from: MenuPopupHelper */
    /* renamed from: android.support.v7.view.menu.n$1 */
    class C06591 implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ C0660n f1698a;

        C06591(C0660n c0660n) {
            this.f1698a = c0660n;
        }

        public void onDismiss() {
            this.f1698a.mo700e();
        }
    }

    public C0660n(Context context, C3273h c3273h, View view, boolean z, int i) {
        this(context, c3273h, view, z, i, 0);
    }

    public C0660n(Context context, C3273h c3273h, View view, boolean z, int i, int i2) {
        this.f1705g = 8388611;
        this.f1710l = new C06591(this);
        this.f1699a = context;
        this.f1700b = c3273h;
        this.f1704f = view;
        this.f1701c = z;
        this.f1702d = i;
        this.f1703e = i2;
    }

    /* renamed from: a */
    public void m2193a(OnDismissListener onDismissListener) {
        this.f1709k = onDismissListener;
    }

    /* renamed from: a */
    public void m2192a(View view) {
        this.f1704f = view;
    }

    /* renamed from: a */
    public void m2194a(boolean z) {
        this.f1706h = z;
        if (this.f1708j != null) {
            this.f1708j.mo2739a(z);
        }
    }

    /* renamed from: a */
    public void m2190a(int i) {
        this.f1705g = i;
    }

    /* renamed from: a */
    public void m2189a() {
        if (!m2197c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: b */
    public C3281m m2196b() {
        if (this.f1708j == null) {
            this.f1708j = m2188g();
        }
        return this.f1708j;
    }

    /* renamed from: c */
    public boolean m2197c() {
        if (m2200f()) {
            return true;
        }
        if (this.f1704f == null) {
            return false;
        }
        m2187a(0, 0, false, false);
        return true;
    }

    /* renamed from: a */
    public boolean m2195a(int i, int i2) {
        if (m2200f()) {
            return true;
        }
        if (this.f1704f == null) {
            return false;
        }
        m2187a(i, i2, true, true);
        return true;
    }

    /* renamed from: g */
    private C3281m m2188g() {
        Display defaultDisplay = ((WindowManager) this.f1699a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if ((Math.min(point.x, point.y) >= this.f1699a.getResources().getDimensionPixelSize(C0584d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
            C3281m c4482e = new C4482e(this.f1699a, this.f1704f, this.f1702d, this.f1703e, this.f1701c);
        } else {
            C3281m c4486t = new C4486t(this.f1699a, this.f1700b, this.f1704f, this.f1702d, this.f1703e, this.f1701c);
        }
        r0.mo2736a(this.f1700b);
        r0.mo2738a(this.f1710l);
        r0.mo2737a(this.f1704f);
        r0.mo465a(this.f1707i);
        r0.mo2739a(this.f1706h);
        r0.mo2735a(this.f1705g);
        return r0;
    }

    /* renamed from: a */
    private void m2187a(int i, int i2, boolean z, boolean z2) {
        C3281m b = m2196b();
        b.mo2742c(z2);
        if (z) {
            if (C0501e.m1587a(this.f1705g, C0517s.m1711e(this.f1704f)) & 7) {
                i += this.f1704f.getWidth();
            }
            b.mo2740b(i);
            b.mo2741c(i2);
            z = (int) ((this.f1699a.getResources().getDisplayMetrics().density * true) / true);
            b.m10146a(new Rect(i - z, i2 - z, i + z, i2 + z));
        }
        b.mo634a();
    }

    /* renamed from: d */
    public void m2198d() {
        if (m2200f()) {
            this.f1708j.mo635c();
        }
    }

    /* renamed from: e */
    protected void mo700e() {
        this.f1708j = null;
        if (this.f1709k != null) {
            this.f1709k.onDismiss();
        }
    }

    /* renamed from: f */
    public boolean m2200f() {
        return this.f1708j != null && this.f1708j.mo636d();
    }

    /* renamed from: a */
    public void m2191a(C0661a c0661a) {
        this.f1707i = c0661a;
        if (this.f1708j != null) {
            this.f1708j.mo465a(c0661a);
        }
    }
}
