package com.facebook.ads.internal.p099n;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.C4630j;
import com.facebook.ads.internal.view.p113b.C1578e;
import com.facebook.ads.internal.view.p120f.C1660d;
import com.facebook.ads.internal.view.p120f.C1660d.C1650a;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p123c.C4602h;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.n.d */
public class C1421d {
    /* renamed from: a */
    private static final String f4163a = "d";
    /* renamed from: b */
    private final C4597g f4164b;
    /* renamed from: c */
    private final C1545a f4165c;
    /* renamed from: d */
    private final C1544a f4166d;
    /* renamed from: e */
    private final View f4167e;
    /* renamed from: f */
    private final C1650a f4168f = new C35821(this);
    /* renamed from: g */
    private C4630j f4169g;
    /* renamed from: h */
    private C1420a f4170h;
    /* renamed from: i */
    private Context f4171i;
    /* renamed from: j */
    private boolean f4172j;
    /* renamed from: k */
    private boolean f4173k;
    /* renamed from: l */
    private boolean f4174l;
    /* renamed from: m */
    private final AtomicBoolean f4175m = new AtomicBoolean(false);
    /* renamed from: n */
    private final AtomicBoolean f4176n = new AtomicBoolean(false);
    /* renamed from: o */
    private C1431m f4177o = C1431m.DEFAULT;

    /* renamed from: com.facebook.ads.internal.n.d$3 */
    class C14193 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C1421d f4162a;

        C14193(C1421d c1421d) {
            this.f4162a = c1421d;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4162a.f4169g != null && motionEvent.getAction() == 1) {
                this.f4162a.f4169g.mo2891a();
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.n.d$a */
    public interface C1420a {
        /* renamed from: a */
        void mo856a(boolean z);
    }

    /* renamed from: com.facebook.ads.internal.n.d$1 */
    class C35821 implements C1650a {
        /* renamed from: a */
        final /* synthetic */ C1421d f9587a;

        C35821(C1421d c1421d) {
            this.f9587a = c1421d;
        }

        /* renamed from: a */
        public void mo961a() {
            this.f9587a.f4176n.set(true);
            if (this.f9587a.f4170h != null) {
                this.f9587a.f4170h.mo856a(this.f9587a.f4175m.get());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.n.d$2 */
    class C35832 implements C1578e {
        /* renamed from: a */
        final /* synthetic */ C1421d f9588a;

        C35832(C1421d c1421d) {
            this.f9588a = c1421d;
        }

        /* renamed from: a */
        public void mo841a(boolean z) {
            this.f9588a.f4175m.set(z);
            if (this.f9588a.f4176n.get() && this.f9588a.f4170h != null) {
                this.f9588a.f4170h.mo856a(z);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.n.d$4 */
    class C35844 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C1421d f9589a;

        C35844(C1421d c1421d) {
            this.f9589a = c1421d;
        }

        /* renamed from: a */
        public void mo925a() {
            if (this.f9589a.f4169g != null) {
                if (!this.f9589a.f4174l && (this.f9589a.f4173k || this.f9589a.m4927m())) {
                    this.f9589a.m4910a(C1624a.AUTO_STARTED);
                }
                this.f9589a.f4173k = false;
                this.f9589a.f4174l = false;
            }
        }

        /* renamed from: b */
        public void mo962b() {
            if (this.f9589a.f4169g != null) {
                if (this.f9589a.f4169g.getState() == C1658d.PAUSED) {
                    this.f9589a.f4174l = true;
                } else if (this.f9589a.f4169g.getState() == C1658d.STARTED) {
                    this.f9589a.f4173k = true;
                }
                this.f9589a.m4911a(this.f9589a.f4174l);
            }
        }
    }

    public C1421d(Context context, View view) {
        this.f4171i = context;
        this.f4167e = view;
        this.f4164b = new C4597g(context);
        this.f4166d = m4925k();
        this.f4165c = m4924j();
        m4920g();
    }

    /* renamed from: a */
    private void m4910a(C1624a c1624a) {
        if (this.f4169g != null) {
            this.f4169g.m11914a(c1624a);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f4163a, "MediaViewVideo is null; unable to find it.");
        }
    }

    /* renamed from: a */
    private void m4911a(boolean z) {
        if (this.f4169g != null) {
            this.f4169g.m11917a(z);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f4163a, "MediaViewVideo is null; unable to find it.");
        }
    }

    /* renamed from: g */
    private void m4920g() {
        float f = C1523w.f4503b;
        int i = (int) (2.0f * f);
        int i2 = (int) (f * 25.0f);
        C1625b c4602h = new C4602h(this.f4171i);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        c4602h.setPadding(i, i2, i2, i);
        c4602h.setLayoutParams(layoutParams);
        for (i = 0; i < ((ViewGroup) this.f4167e).getChildCount(); i++) {
            View childAt = ((ViewGroup) this.f4167e).getChildAt(0);
            if (childAt instanceof C4630j) {
                this.f4169g = (C4630j) childAt;
                break;
            }
        }
        if (this.f4169g != null) {
            this.f4169g.m11915a(this.f4164b);
            this.f4169g.m11915a(c4602h);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f4163a, "Unable to find MediaViewVideo child.");
        }
        this.f4165c.m5432a(0);
        this.f4165c.m5434b(250);
    }

    /* renamed from: h */
    private void m4922h() {
        if (this.f4169g != null) {
            ((C1660d) this.f4169g.getVideoView()).setViewImplInflationListener(this.f4168f);
        }
    }

    /* renamed from: i */
    private void m4923i() {
        if (this.f4169g != null) {
            ((C1660d) this.f4169g.getVideoView()).setViewImplInflationListener(null);
        }
    }

    /* renamed from: j */
    private C1545a m4924j() {
        return new C1545a(this.f4167e, 50, true, this.f4166d);
    }

    /* renamed from: k */
    private C1544a m4925k() {
        return new C35844(this);
    }

    /* renamed from: l */
    private void m4926l() {
        if (this.f4167e.getVisibility() == 0 && this.f4172j && this.f4167e.hasWindowFocus()) {
            this.f4165c.m5431a();
            return;
        }
        if (this.f4169g != null && this.f4169g.getState() == C1658d.PAUSED) {
            this.f4174l = true;
        }
        this.f4165c.m5436c();
    }

    /* renamed from: m */
    private boolean m4927m() {
        return this.f4169g != null ? this.f4169g.getState() == C1658d.PLAYBACK_COMPLETED ? false : this.f4177o == C1431m.ON : false;
    }

    /* renamed from: a */
    public void m4928a() {
        this.f4177o = C1431m.DEFAULT;
        m4923i();
    }

    /* renamed from: a */
    public void m4929a(C1425f c1425f, C1420a c1420a) {
        this.f4173k = false;
        this.f4174l = false;
        this.f4170h = c1420a;
        m4922h();
        C4597g c4597g = this.f4164b;
        String a = (c1425f == null || c1425f.m5005k() == null) ? null : c1425f.m5005k().m5022a();
        c4597g.m15852a(a, new C35832(this));
        this.f4177o = c1425f.m4975E();
        this.f4165c.m5431a();
    }

    /* renamed from: b */
    public void m4930b() {
        if (this.f4169g != null) {
            this.f4169g.getVideoView().setOnTouchListener(new C14193(this));
        }
    }

    /* renamed from: c */
    public void m4931c() {
        this.f4172j = true;
        m4926l();
    }

    /* renamed from: d */
    public void m4932d() {
        this.f4172j = false;
        m4926l();
    }

    /* renamed from: e */
    public void m4933e() {
        m4926l();
    }

    /* renamed from: f */
    public void m4934f() {
        m4926l();
    }
}
