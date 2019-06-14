package android.support.v7.widget;

import android.support.v4.view.C0517s;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* compiled from: TooltipCompatHandler */
class bt implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    /* renamed from: i */
    private static bt f2144i;
    /* renamed from: j */
    private static bt f2145j;
    /* renamed from: a */
    private final View f2146a;
    /* renamed from: b */
    private final CharSequence f2147b;
    /* renamed from: c */
    private final Runnable f2148c = new C07801(this);
    /* renamed from: d */
    private final Runnable f2149d = new C07812(this);
    /* renamed from: e */
    private int f2150e;
    /* renamed from: f */
    private int f2151f;
    /* renamed from: g */
    private bu f2152g;
    /* renamed from: h */
    private boolean f2153h;

    /* compiled from: TooltipCompatHandler */
    /* renamed from: android.support.v7.widget.bt$1 */
    class C07801 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ bt f2142a;

        C07801(bt btVar) {
            this.f2142a = btVar;
        }

        public void run() {
            this.f2142a.m2793a(false);
        }
    }

    /* compiled from: TooltipCompatHandler */
    /* renamed from: android.support.v7.widget.bt$2 */
    class C07812 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ bt f2143a;

        C07812(bt btVar) {
            this.f2143a = btVar;
        }

        public void run() {
            this.f2143a.m2789a();
        }
    }

    public void onViewAttachedToWindow(View view) {
    }

    /* renamed from: a */
    public static void m2792a(View view, CharSequence charSequence) {
        if (f2144i != null && f2144i.f2146a == view) {
            m2795b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f2145j != null && f2145j.f2146a == view) {
                f2145j.m2789a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(null);
            view.setOnHoverListener(null);
            return;
        }
        bt btVar = new bt(view, charSequence);
    }

    private bt(View view, CharSequence charSequence) {
        this.f2146a = view;
        this.f2147b = charSequence;
        this.f2146a.setOnLongClickListener(this);
        this.f2146a.setOnHoverListener(this);
    }

    public boolean onLongClick(View view) {
        this.f2150e = view.getWidth() / 2;
        this.f2151f = view.getHeight() / 2;
        m2793a(true);
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2152g != null && this.f2153h != null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2146a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() != null) {
            return false;
        }
        view = motionEvent.getAction();
        if (view != 7) {
            if (view == 10) {
                m2789a();
            }
        } else if (this.f2146a.isEnabled() != null && this.f2152g == null) {
            this.f2150e = (int) motionEvent.getX();
            this.f2151f = (int) motionEvent.getY();
            m2795b(this);
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        m2789a();
    }

    /* renamed from: a */
    private void m2793a(boolean z) {
        if (C0517s.m1683A(this.f2146a)) {
            long j;
            m2795b(null);
            if (f2145j != null) {
                f2145j.m2789a();
            }
            f2145j = this;
            this.f2153h = z;
            this.f2152g = new bu(this.f2146a.getContext());
            this.f2152g.m2800a(this.f2146a, this.f2150e, this.f2151f, this.f2153h, this.f2147b);
            this.f2146a.addOnAttachStateChangeListener(this);
            if (this.f2153h) {
                j = 2500;
            } else if (C0517s.m1720n(this.f2146a) & true) {
                j = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                j = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f2146a.removeCallbacks(this.f2149d);
            this.f2146a.postDelayed(this.f2149d, j);
        }
    }

    /* renamed from: a */
    private void m2789a() {
        if (f2145j == this) {
            f2145j = null;
            if (this.f2152g != null) {
                this.f2152g.m2799a();
                this.f2152g = null;
                this.f2146a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2144i == this) {
            m2795b(null);
        }
        this.f2146a.removeCallbacks(this.f2149d);
    }

    /* renamed from: b */
    private static void m2795b(bt btVar) {
        if (f2144i != null) {
            f2144i.m2796c();
        }
        f2144i = btVar;
        if (f2144i != null) {
            f2144i.m2794b();
        }
    }

    /* renamed from: b */
    private void m2794b() {
        this.f2146a.postDelayed(this.f2148c, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: c */
    private void m2796c() {
        this.f2146a.removeCallbacks(this.f2148c);
    }
}
