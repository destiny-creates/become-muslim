package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ax;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(14)
@cm
public final class aks implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: a */
    private static final long f14639a = ((Long) aph.m18688f().m18889a(asp.bn)).longValue();
    /* renamed from: b */
    private final Context f14640b;
    /* renamed from: c */
    private Application f14641c;
    /* renamed from: d */
    private final WindowManager f14642d;
    /* renamed from: e */
    private final PowerManager f14643e;
    /* renamed from: f */
    private final KeyguardManager f14644f;
    /* renamed from: g */
    private BroadcastReceiver f14645g;
    /* renamed from: h */
    private WeakReference<ViewTreeObserver> f14646h;
    /* renamed from: i */
    private WeakReference<View> f14647i;
    /* renamed from: j */
    private akx f14648j;
    /* renamed from: k */
    private lx f14649k = new lx(f14639a);
    /* renamed from: l */
    private boolean f14650l = false;
    /* renamed from: m */
    private int f14651m = -1;
    /* renamed from: n */
    private final HashSet<akw> f14652n = new HashSet();
    /* renamed from: o */
    private final DisplayMetrics f14653o;
    /* renamed from: p */
    private final Rect f14654p;

    public aks(Context context, View view) {
        this.f14640b = context.getApplicationContext();
        this.f14642d = (WindowManager) context.getSystemService("window");
        this.f14643e = (PowerManager) this.f14640b.getSystemService("power");
        this.f14644f = (KeyguardManager) context.getSystemService("keyguard");
        if (this.f14640b instanceof Application) {
            this.f14641c = (Application) this.f14640b;
            this.f14648j = new akx((Application) this.f14640b, this);
        }
        this.f14653o = context.getResources().getDisplayMetrics();
        this.f14654p = new Rect();
        this.f14654p.right = this.f14642d.getDefaultDisplay().getWidth();
        this.f14654p.bottom = this.f14642d.getDefaultDisplay().getHeight();
        View view2 = this.f14647i != null ? (View) this.f14647i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m18555b(view2);
        }
        this.f14647i = new WeakReference(view);
        if (view != null) {
            if (ax.g().mo6877a(view)) {
                m18551a(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: a */
    private final Rect m18548a(Rect rect) {
        return new Rect(m18553b(rect.left), m18553b(rect.top), m18553b(rect.right), m18553b(rect.bottom));
    }

    /* renamed from: a */
    private final void m18549a(int i) {
        int i2 = i;
        if (this.f14652n.size() != 0 && r1.f14647i != null) {
            boolean z;
            boolean z2;
            View view = (View) r1.f14647i.get();
            Object obj = i2 == 1 ? 1 : null;
            Object obj2 = view == null ? 1 : null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    mt.m19919b("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
                z = globalVisibleRect;
                z2 = localVisibleRect;
            } else {
                z = false;
                z2 = false;
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (r1.f14651m != -1) {
                windowVisibility = r1.f14651m;
            }
            boolean z3 = obj2 == null && ax.e().m19743a(view, r1.f14643e, r1.f14644f) && z && z2 && windowVisibility == 0;
            if (obj != null && !r1.f14649k.m19842a() && z3 == r1.f14650l) {
                return;
            }
            if (z3 || r1.f14650l || i2 != 1) {
                akv akv = new akv(ax.l().b(), r1.f14643e.isScreenOn(), view != null ? ax.g().mo6877a(view) : false, view != null ? view.getWindowVisibility() : 8, m18548a(r1.f14654p), m18548a(rect), m18548a(rect2), z, m18548a(rect3), z2, m18548a(rect4), r1.f14653o.density, z3);
                Iterator it = r1.f14652n.iterator();
                while (it.hasNext()) {
                    ((akw) it.next()).mo4298a(akv);
                }
                r1.f14650l = z3;
            }
        }
    }

    /* renamed from: a */
    private final void m18550a(Activity activity, int i) {
        if (this.f14647i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f14647i.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f14651m = i;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m18551a(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f14646h = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f14645g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f14645g = new aku(this);
            ax.E().m19853a(this.f14640b, this.f14645g, intentFilter);
        }
        if (this.f14641c != null) {
            try {
                this.f14641c.registerActivityLifecycleCallbacks(this.f14648j);
            } catch (Throwable e) {
                mt.m19919b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    /* renamed from: b */
    private final int m18553b(int i) {
        return (int) (((float) i) / this.f14653o.density);
    }

    /* renamed from: b */
    private final void m18554b() {
        ax.e();
        jw.f15691a.post(new akt(this));
    }

    /* renamed from: b */
    private final void m18555b(View view) {
        try {
            if (this.f14646h != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f14646h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f14646h = null;
            }
        } catch (Throwable e) {
            mt.m19919b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            mt.m19919b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.f14645g != null) {
            try {
                ax.E().m19852a(this.f14640b, this.f14645g);
            } catch (Throwable e22) {
                mt.m19919b("Failed trying to unregister the receiver", e22);
            } catch (Throwable e222) {
                ax.i().m30834a(e222, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f14645g = null;
        }
        if (this.f14641c != null) {
            try {
                this.f14641c.unregisterActivityLifecycleCallbacks(this.f14648j);
            } catch (Throwable e2222) {
                mt.m19919b("Error registering activity lifecycle callbacks.", e2222);
            }
        }
    }

    /* renamed from: a */
    public final void m18556a() {
        m18549a(4);
    }

    /* renamed from: a */
    public final void m18557a(akw akw) {
        this.f14652n.add(akw);
        m18549a(3);
    }

    /* renamed from: b */
    public final void m18558b(akw akw) {
        this.f14652n.remove(akw);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m18550a(activity, 0);
        m18549a(3);
        m18554b();
    }

    public final void onActivityDestroyed(Activity activity) {
        m18549a(3);
        m18554b();
    }

    public final void onActivityPaused(Activity activity) {
        m18550a(activity, 4);
        m18549a(3);
        m18554b();
    }

    public final void onActivityResumed(Activity activity) {
        m18550a(activity, 0);
        m18549a(3);
        m18554b();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m18549a(3);
        m18554b();
    }

    public final void onActivityStarted(Activity activity) {
        m18550a(activity, 0);
        m18549a(3);
        m18554b();
    }

    public final void onActivityStopped(Activity activity) {
        m18549a(3);
        m18554b();
    }

    public final void onGlobalLayout() {
        m18549a(2);
        m18554b();
    }

    public final void onScrollChanged() {
        m18549a(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f14651m = -1;
        m18551a(view);
        m18549a(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f14651m = -1;
        m18549a(3);
        m18554b();
        m18555b(view);
    }
}
