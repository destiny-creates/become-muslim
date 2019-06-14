package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.C0646g;
import android.support.v7.view.C0648i;
import android.support.v7.view.menu.C3273h;
import android.support.v7.widget.bq;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: AppCompatDelegateImplBase */
/* renamed from: android.support.v7.app.f */
abstract class C3248f extends C0611e {
    /* renamed from: m */
    private static boolean f8329m = true;
    /* renamed from: n */
    private static final boolean f8330n = (VERSION.SDK_INT < 21);
    /* renamed from: o */
    private static final int[] f8331o = new int[]{16842836};
    /* renamed from: a */
    final Context f8332a;
    /* renamed from: b */
    final Window f8333b;
    /* renamed from: c */
    final Callback f8334c = this.f8333b.getCallback();
    /* renamed from: d */
    final Callback f8335d;
    /* renamed from: e */
    final C0610d f8336e;
    /* renamed from: f */
    C0608a f8337f;
    /* renamed from: g */
    MenuInflater f8338g;
    /* renamed from: h */
    boolean f8339h;
    /* renamed from: i */
    boolean f8340i;
    /* renamed from: j */
    boolean f8341j;
    /* renamed from: k */
    boolean f8342k;
    /* renamed from: l */
    boolean f8343l;
    /* renamed from: p */
    private CharSequence f8344p;
    /* renamed from: q */
    private boolean f8345q;
    /* renamed from: r */
    private boolean f8346r;

    /* compiled from: AppCompatDelegateImplBase */
    /* renamed from: android.support.v7.app.f$a */
    class C3247a extends C0648i {
        /* renamed from: a */
        final /* synthetic */ C3248f f8328a;

        public void onContentChanged() {
        }

        C3247a(C3248f c3248f, Callback callback) {
            this.f8328a = c3248f;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!this.f8328a.mo2722a(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent)) {
                if (this.f8328a.mo2721a(keyEvent.getKeyCode(), keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C3273h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C3273h c3273h = menu instanceof C3273h ? (C3273h) menu : null;
            if (i == 0 && c3273h == null) {
                return false;
            }
            if (c3273h != null) {
                c3273h.m10079c(true);
            }
            i = super.onPreparePanel(i, view, menu);
            if (c3273h != null) {
                c3273h.m10079c(false);
            }
            return i;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f8328a.mo2727b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f8328a.mo2715a(i, menu);
        }
    }

    /* renamed from: a */
    abstract C0640b mo2713a(C0639a c0639a);

    /* renamed from: a */
    abstract void mo2715a(int i, Menu menu);

    /* renamed from: a */
    abstract boolean mo2721a(int i, KeyEvent keyEvent);

    /* renamed from: a */
    abstract boolean mo2722a(KeyEvent keyEvent);

    /* renamed from: b */
    abstract void mo2726b(CharSequence charSequence);

    /* renamed from: b */
    abstract boolean mo2727b(int i, Menu menu);

    /* renamed from: c */
    public void mo371c(Bundle bundle) {
    }

    /* renamed from: i */
    public boolean mo374i() {
        return false;
    }

    /* renamed from: l */
    abstract void mo2732l();

    /* renamed from: o */
    public boolean mo3338o() {
        return false;
    }

    static {
        if (f8330n && !f8329m) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (m2082a(th)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(th.getMessage());
                        stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        Throwable notFoundException = new NotFoundException(stringBuilder.toString());
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                /* renamed from: a */
                private boolean m2082a(Throwable th) {
                    boolean z = false;
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    th = th.getMessage();
                    if (th != null && (th.contains("drawable") || th.contains("Drawable") != null)) {
                        z = true;
                    }
                    return z;
                }
            });
        }
    }

    C3248f(Context context, Window window, C0610d c0610d) {
        this.f8332a = context;
        this.f8333b = window;
        this.f8336e = c0610d;
        if ((this.f8334c instanceof C3247a) == null) {
            this.f8335d = mo3336a(this.f8334c);
            this.f8333b.setCallback(this.f8335d);
            context = bq.m2768a(context, (AttributeSet) null, f8331o);
            window = context.m2777b(null);
            if (window != null) {
                this.f8333b.setBackgroundDrawable(window);
            }
            context.m2774a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: a */
    Callback mo3336a(Callback callback) {
        return new C3247a(this, callback);
    }

    /* renamed from: a */
    public C0608a mo367a() {
        mo2732l();
        return this.f8337f;
    }

    /* renamed from: m */
    final C0608a m9865m() {
        return this.f8337f;
    }

    /* renamed from: b */
    public MenuInflater mo369b() {
        if (this.f8338g == null) {
            mo2732l();
            this.f8338g = new C0646g(this.f8337f != null ? this.f8337f.mo398b() : this.f8332a);
        }
        return this.f8338g;
    }

    /* renamed from: n */
    final Context m9866n() {
        C0608a a = mo367a();
        Context b = a != null ? a.mo398b() : null;
        return b == null ? this.f8332a : b;
    }

    /* renamed from: c */
    public void mo370c() {
        this.f8345q = true;
    }

    /* renamed from: d */
    public void mo372d() {
        this.f8345q = false;
    }

    /* renamed from: g */
    public void mo373g() {
        this.f8346r = true;
    }

    /* renamed from: p */
    final boolean m9868p() {
        return this.f8346r;
    }

    /* renamed from: q */
    final Callback m9869q() {
        return this.f8333b.getCallback();
    }

    /* renamed from: a */
    public final void mo368a(CharSequence charSequence) {
        this.f8344p = charSequence;
        mo2726b(charSequence);
    }

    /* renamed from: r */
    final CharSequence m9870r() {
        if (this.f8334c instanceof Activity) {
            return ((Activity) this.f8334c).getTitle();
        }
        return this.f8344p;
    }
}
