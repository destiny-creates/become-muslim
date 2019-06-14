package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
/* renamed from: android.support.design.widget.k */
class C0193k {
    /* renamed from: a */
    private static C0193k f441a;
    /* renamed from: b */
    private final Object f442b = new Object();
    /* renamed from: c */
    private final Handler f443c = new Handler(Looper.getMainLooper(), new C01901(this));
    /* renamed from: d */
    private C0192b f444d;
    /* renamed from: e */
    private C0192b f445e;

    /* compiled from: SnackbarManager */
    /* renamed from: android.support.design.widget.k$1 */
    class C01901 implements Callback {
        /* renamed from: a */
        final /* synthetic */ C0193k f437a;

        C01901(C0193k c0193k) {
            this.f437a = c0193k;
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return null;
            }
            this.f437a.m444a((C0192b) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager */
    /* renamed from: android.support.design.widget.k$a */
    interface C0191a {
        /* renamed from: a */
        void m433a();

        /* renamed from: a */
        void m434a(int i);
    }

    /* compiled from: SnackbarManager */
    /* renamed from: android.support.design.widget.k$b */
    private static class C0192b {
        /* renamed from: a */
        final WeakReference<C0191a> f438a;
        /* renamed from: b */
        int f439b;
        /* renamed from: c */
        boolean f440c;

        /* renamed from: a */
        boolean m435a(C0191a c0191a) {
            return (c0191a == null || this.f438a.get() != c0191a) ? null : true;
        }
    }

    /* renamed from: a */
    static C0193k m436a() {
        if (f441a == null) {
            f441a = new C0193k();
        }
        return f441a;
    }

    private C0193k() {
    }

    /* renamed from: a */
    public void m443a(C0191a c0191a, int i) {
        synchronized (this.f442b) {
            if (m440f(c0191a)) {
                m437a(this.f444d, i);
            } else if (m441g(c0191a) != null) {
                m437a(this.f445e, i);
            }
        }
    }

    /* renamed from: a */
    public void m442a(C0191a c0191a) {
        synchronized (this.f442b) {
            if (m440f(c0191a) != null) {
                this.f444d = null;
                if (this.f445e != null) {
                    m438b();
                }
            }
        }
    }

    /* renamed from: b */
    public void m445b(C0191a c0191a) {
        synchronized (this.f442b) {
            if (m440f(c0191a) != null) {
                m439b(this.f444d);
            }
        }
    }

    /* renamed from: c */
    public void m446c(C0191a c0191a) {
        synchronized (this.f442b) {
            if (m440f(c0191a) != null && this.f444d.f440c == null) {
                this.f444d.f440c = true;
                this.f443c.removeCallbacksAndMessages(this.f444d);
            }
        }
    }

    /* renamed from: d */
    public void m447d(C0191a c0191a) {
        synchronized (this.f442b) {
            if (!(m440f(c0191a) == null || this.f444d.f440c == null)) {
                this.f444d.f440c = false;
                m439b(this.f444d);
            }
        }
    }

    /* renamed from: e */
    public boolean m448e(C0191a c0191a) {
        synchronized (this.f442b) {
            if (!m440f(c0191a)) {
                if (m441g(c0191a) == null) {
                    c0191a = null;
                }
            }
            c0191a = true;
        }
        return c0191a;
    }

    /* renamed from: b */
    private void m438b() {
        if (this.f445e != null) {
            this.f444d = this.f445e;
            this.f445e = null;
            C0191a c0191a = (C0191a) this.f444d.f438a.get();
            if (c0191a != null) {
                c0191a.m433a();
            } else {
                this.f444d = null;
            }
        }
    }

    /* renamed from: a */
    private boolean m437a(C0192b c0192b, int i) {
        C0191a c0191a = (C0191a) c0192b.f438a.get();
        if (c0191a == null) {
            return null;
        }
        this.f443c.removeCallbacksAndMessages(c0192b);
        c0191a.m434a(i);
        return true;
    }

    /* renamed from: f */
    private boolean m440f(C0191a c0191a) {
        return (this.f444d == null || this.f444d.m435a(c0191a) == null) ? null : true;
    }

    /* renamed from: g */
    private boolean m441g(C0191a c0191a) {
        return (this.f445e == null || this.f445e.m435a(c0191a) == null) ? null : true;
    }

    /* renamed from: b */
    private void m439b(C0192b c0192b) {
        if (c0192b.f439b != -2) {
            int i = 2750;
            if (c0192b.f439b > 0) {
                i = c0192b.f439b;
            } else if (c0192b.f439b == -1) {
                i = 1500;
            }
            this.f443c.removeCallbacksAndMessages(c0192b);
            this.f443c.sendMessageDelayed(Message.obtain(this.f443c, 0, c0192b), (long) i);
        }
    }

    /* renamed from: a */
    void m444a(C0192b c0192b) {
        synchronized (this.f442b) {
            if (this.f444d == c0192b || this.f445e == c0192b) {
                m437a(c0192b, 2);
            }
        }
    }
}
