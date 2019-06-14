package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.C3248f.C3247a;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.C0643f.C3266a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV14 */
/* renamed from: android.support.v7.app.h */
class C4831h extends C4478j {
    /* renamed from: t */
    private int f13684t = -100;
    /* renamed from: u */
    private boolean f13685u;
    /* renamed from: v */
    private boolean f13686v = true;
    /* renamed from: w */
    private C0614b f13687w;

    /* compiled from: AppCompatDelegateImplV14 */
    /* renamed from: android.support.v7.app.h$b */
    final class C0614b {
        /* renamed from: a */
        final /* synthetic */ C4831h f1565a;
        /* renamed from: b */
        private C0622o f1566b;
        /* renamed from: c */
        private boolean f1567c;
        /* renamed from: d */
        private BroadcastReceiver f1568d;
        /* renamed from: e */
        private IntentFilter f1569e;

        /* compiled from: AppCompatDelegateImplV14 */
        /* renamed from: android.support.v7.app.h$b$1 */
        class C06131 extends BroadcastReceiver {
            /* renamed from: a */
            final /* synthetic */ C0614b f1564a;

            C06131(C0614b c0614b) {
                this.f1564a = c0614b;
            }

            public void onReceive(Context context, Intent intent) {
                this.f1564a.m2084b();
            }
        }

        C0614b(C4831h c4831h, C0622o c0622o) {
            this.f1565a = c4831h;
            this.f1566b = c0622o;
            this.f1567c = c0622o.m2103a();
        }

        /* renamed from: a */
        final int m2083a() {
            this.f1567c = this.f1566b.m2103a();
            return this.f1567c ? 2 : 1;
        }

        /* renamed from: b */
        final void m2084b() {
            boolean a = this.f1566b.m2103a();
            if (a != this.f1567c) {
                this.f1567c = a;
                this.f1565a.mo374i();
            }
        }

        /* renamed from: c */
        final void m2085c() {
            m2086d();
            if (this.f1568d == null) {
                this.f1568d = new C06131(this);
            }
            if (this.f1569e == null) {
                this.f1569e = new IntentFilter();
                this.f1569e.addAction("android.intent.action.TIME_SET");
                this.f1569e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f1569e.addAction("android.intent.action.TIME_TICK");
            }
            this.f1565a.a.registerReceiver(this.f1568d, this.f1569e);
        }

        /* renamed from: d */
        final void m2086d() {
            if (this.f1568d != null) {
                this.f1565a.a.unregisterReceiver(this.f1568d);
                this.f1568d = null;
            }
        }
    }

    /* compiled from: AppCompatDelegateImplV14 */
    /* renamed from: android.support.v7.app.h$a */
    class C4474a extends C3247a {
        /* renamed from: c */
        final /* synthetic */ C4831h f11948c;

        C4474a(C4831h c4831h, Callback callback) {
            this.f11948c = c4831h;
            super(c4831h, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.f11948c.mo3338o()) {
                return m14988a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* renamed from: a */
        final ActionMode m14988a(ActionMode.Callback callback) {
            Object c3266a = new C3266a(this.f11948c.a, callback);
            callback = this.f11948c.m15028b((C0639a) c3266a);
            return callback != null ? c3266a.m9991b(callback) : null;
        }
    }

    /* renamed from: a */
    View mo3335a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    C4831h(Context context, Window window, C0610d c0610d) {
        super(context, window, c0610d);
    }

    /* renamed from: a */
    public void mo2717a(Bundle bundle) {
        super.mo2717a(bundle);
        if (bundle != null && this.f13684t == -100) {
            this.f13684t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* renamed from: a */
    Callback mo3336a(Callback callback) {
        return new C4474a(this, callback);
    }

    /* renamed from: o */
    public boolean mo3338o() {
        return this.f13686v;
    }

    /* renamed from: i */
    public boolean mo374i() {
        int w = m17139w();
        int d = mo3337d(w);
        boolean h = d != -1 ? m17138h(d) : false;
        if (w == 0) {
            m17140x();
            this.f13687w.m2085c();
        }
        this.f13685u = true;
        return h;
    }

    /* renamed from: c */
    public void mo370c() {
        super.mo370c();
        mo374i();
    }

    /* renamed from: d */
    public void mo372d() {
        super.mo372d();
        if (this.f13687w != null) {
            this.f13687w.m2086d();
        }
    }

    /* renamed from: d */
    int mo3337d(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        m17140x();
        return this.f13687w.m2083a();
    }

    /* renamed from: w */
    private int m17139w() {
        return this.f13684t != -100 ? this.f13684t : C0611e.m2059j();
    }

    /* renamed from: c */
    public void mo371c(Bundle bundle) {
        super.mo371c(bundle);
        if (this.f13684t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f13684t);
        }
    }

    /* renamed from: g */
    public void mo373g() {
        super.mo373g();
        if (this.f13687w != null) {
            this.f13687w.m2086d();
        }
    }

    /* renamed from: h */
    private boolean m17138h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        i = i == 2 ? 32 : 16;
        if (i2 == i) {
            return false;
        }
        if (m17141y()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                C0618l.m2091a(resources);
            }
        }
        return true;
    }

    /* renamed from: x */
    private void m17140x() {
        if (this.f13687w == null) {
            this.f13687w = new C0614b(this, C0622o.m2099a(this.a));
        }
    }

    /* renamed from: y */
    private boolean m17141y() {
        boolean z = false;
        if (!this.f13685u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            if ((this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0) {
                z = true;
            }
            return z;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }
}
