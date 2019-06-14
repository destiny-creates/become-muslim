package com.google.android.gms.internal.p213l;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.C2799e;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.cg */
public class cg implements dd {
    /* renamed from: a */
    private static volatile cg f24569a;
    /* renamed from: A */
    private int f24570A;
    /* renamed from: B */
    private final long f24571B;
    /* renamed from: b */
    private final Context f24572b;
    /* renamed from: c */
    private final String f24573c;
    /* renamed from: d */
    private final C5052x f24574d;
    /* renamed from: e */
    private final aa f24575e;
    /* renamed from: f */
    private final bm f24576f;
    /* renamed from: g */
    private final bb f24577g;
    /* renamed from: h */
    private final cb f24578h;
    /* renamed from: i */
    private final fc f24579i;
    /* renamed from: j */
    private final AppMeasurement f24580j;
    /* renamed from: k */
    private final FirebaseAnalytics f24581k;
    /* renamed from: l */
    private final fw f24582l;
    /* renamed from: m */
    private final az f24583m;
    /* renamed from: n */
    private final C2895e f24584n;
    /* renamed from: o */
    private final ea f24585o;
    /* renamed from: p */
    private final df f24586p;
    /* renamed from: q */
    private final C8219n f24587q;
    /* renamed from: r */
    private ax f24588r;
    /* renamed from: s */
    private ed f24589s;
    /* renamed from: t */
    private ak f24590t;
    /* renamed from: u */
    private aw f24591u;
    /* renamed from: v */
    private bs f24592v;
    /* renamed from: w */
    private boolean f24593w = false;
    /* renamed from: x */
    private Boolean f24594x;
    /* renamed from: y */
    private long f24595y;
    /* renamed from: z */
    private int f24596z;

    private cg(de deVar) {
        bd w;
        String str;
        C2872v.a(deVar);
        this.f24574d = new C5052x(deVar.f17089a);
        as.m21262a(this.f24574d);
        this.f24572b = deVar.f17089a;
        this.f24573c = deVar.f17090b;
        hd.m21412a(this.f24572b);
        this.f24584n = C4376h.d();
        this.f24571B = this.f24584n.a();
        this.f24575e = new aa(this);
        dc bmVar = new bm(this);
        bmVar.m38099A();
        this.f24576f = bmVar;
        bmVar = new bb(this);
        bmVar.m38099A();
        this.f24577g = bmVar;
        bmVar = new fw(this);
        bmVar.m38099A();
        this.f24582l = bmVar;
        bmVar = new az(this);
        bmVar.m38099A();
        this.f24583m = bmVar;
        this.f24587q = new C8219n(this);
        C8220s eaVar = new ea(this);
        eaVar.m42729x();
        this.f24585o = eaVar;
        eaVar = new df(this);
        eaVar.m42729x();
        this.f24586p = eaVar;
        this.f24580j = new AppMeasurement(this);
        this.f24581k = new FirebaseAnalytics(this);
        eaVar = new fc(this);
        eaVar.m42729x();
        this.f24579i = eaVar;
        bmVar = new cb(this);
        bmVar.m38099A();
        this.f24578h = bmVar;
        C5052x c5052x = this.f24574d;
        if (this.f24572b.getApplicationContext() instanceof Application) {
            db h = m31966h();
            if (h.mo4752n().getApplicationContext() instanceof Application) {
                Application application = (Application) h.mo4752n().getApplicationContext();
                if (h.f32808a == null) {
                    h.f32808a = new dy(h);
                }
                application.unregisterActivityLifecycleCallbacks(h.f32808a);
                application.registerActivityLifecycleCallbacks(h.f32808a);
                w = h.mo4754r().m42579w();
                str = "Registered activity lifecycle callback";
            }
            this.f24578h.m42612a(new ch(this, deVar));
        }
        w = mo4754r().m42565i();
        str = "Application context is not an Application";
        w.m21307a(str);
        this.f24578h.m42612a(new ch(this, deVar));
    }

    /* renamed from: E */
    private final void m31946E() {
        if (!this.f24593w) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* renamed from: a */
    public static cg m31947a(Context context, String str, String str2) {
        C2872v.a(context);
        C2872v.a(context.getApplicationContext());
        if (f24569a == null) {
            synchronized (cg.class) {
                if (f24569a == null) {
                    f24569a = new cg(new de(context, null));
                }
            }
        }
        return f24569a;
    }

    /* renamed from: a */
    private static void m31949a(db dbVar) {
        if (dbVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* renamed from: a */
    private final void m31950a(de deVar) {
        bd k;
        mo4753q().mo6210d();
        aa.m38031e();
        dc akVar = new ak(this);
        akVar.m38099A();
        this.f24590t = akVar;
        C8220s awVar = new aw(this);
        awVar.m42729x();
        this.f24591u = awVar;
        C8220s axVar = new ax(this);
        axVar.m42729x();
        this.f24588r = axVar;
        axVar = new ed(this);
        axVar.m42729x();
        this.f24589s = axVar;
        this.f24582l.m38100B();
        this.f24576f.m38100B();
        this.f24592v = new bs(this);
        this.f24591u.m42730y();
        mo4754r().m42567k().m21308a("App measurement is starting up, version", Long.valueOf(this.f24575e.m38049f()));
        C5052x c5052x = this.f24574d;
        mo4754r().m42567k().m21307a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        c5052x = this.f24574d;
        String C = awVar.m43958C();
        if (m31969k().m42682h(C)) {
            k = mo4754r().m42567k();
            C = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            k = mo4754r().m42567k();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            C = String.valueOf(C);
            C = C.length() != 0 ? str.concat(C) : new String(str);
        }
        k.m21307a(C);
        mo4754r().m42578v().m21307a("Debug-level message logging enabled");
        if (this.f24596z != this.f24570A) {
            mo4754r().I_().m21309a("Not all components initialized", Integer.valueOf(this.f24596z), Integer.valueOf(this.f24570A));
        }
        this.f24593w = true;
    }

    /* renamed from: b */
    private static void m31951b(dc dcVar) {
        if (dcVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!dcVar.m38103y()) {
            String valueOf = String.valueOf(dcVar.getClass());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append(valueOf);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private static void m31952b(C8220s c8220s) {
        if (c8220s == null) {
            throw new IllegalStateException("Component not created");
        } else if (!c8220s.m42727v()) {
            String valueOf = String.valueOf(c8220s.getClass());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append(valueOf);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: A */
    final void m31953A() {
        C5052x c5052x = this.f24574d;
    }

    /* renamed from: B */
    final void m31954B() {
        C5052x c5052x = this.f24574d;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* renamed from: C */
    final void m31955C() {
        this.f24570A++;
    }

    /* renamed from: D */
    protected final boolean m31956D() {
        m31946E();
        mo4753q().mo6210d();
        if (this.f24594x == null || this.f24595y == 0 || !(this.f24594x == null || this.f24594x.booleanValue() || Math.abs(this.f24584n.b() - this.f24595y) <= 1000)) {
            this.f24595y = this.f24584n.b();
            C5052x c5052x = this.f24574d;
            boolean z = false;
            if (m31969k().m42679f("android.permission.INTERNET") && m31969k().m42679f("android.permission.ACCESS_NETWORK_STATE") && (C2829c.a(this.f24572b).a() || this.f24575e.m38071x() || (bw.m21331a(this.f24572b) && fw.m42640a(this.f24572b, false)))) {
                z = true;
            }
            this.f24594x = Boolean.valueOf(z);
            if (this.f24594x.booleanValue()) {
                this.f24594x = Boolean.valueOf(m31969k().m42677e(m31981w().m43959D()));
            }
        }
        return this.f24594x.booleanValue();
    }

    /* renamed from: a */
    protected final void m31957a() {
        mo4753q().mo6210d();
        if (m31961c().f32326c.m21318a() == 0) {
            m31961c().f32326c.m21319a(this.f24584n.a());
        }
        if (Long.valueOf(m31961c().f32331h.m21318a()).longValue() == 0) {
            mo4754r().m42579w().m21308a("Persisting first open", Long.valueOf(this.f24571B));
            m31961c().f32331h.m21319a(this.f24571B);
        }
        C5052x c5052x;
        if (m31956D()) {
            c5052x = this.f24574d;
            if (!TextUtils.isEmpty(m31981w().m43959D())) {
                String g = m31961c().m42593g();
                if (g == null) {
                    m31961c().m42587c(m31981w().m43959D());
                } else if (!g.equals(m31981w().m43959D())) {
                    mo4754r().m42567k().m21307a("Rechecking which service to use due to a GMP App Id change");
                    m31961c().m42596j();
                    this.f24589s.m44190H();
                    this.f24589s.m44188F();
                    m31961c().m42587c(m31981w().m43959D());
                    m31961c().f32331h.m21319a(this.f24571B);
                    m31961c().f32333j.m21325a(null);
                }
            }
            m31966h().m44098a(m31961c().f32333j.m21324a());
            c5052x = this.f24574d;
            if (!TextUtils.isEmpty(m31981w().m43959D())) {
                boolean y = m31983y();
                if (!(m31961c().m42599w() || this.f24575e.m38053h())) {
                    m31961c().m42590d(y ^ 1);
                }
                if (!this.f24575e.m38058k(m31981w().m43958C()) || y) {
                    m31966h().m44088J();
                }
                m31978t().m44198a(new AtomicReference());
            }
        } else if (m31983y()) {
            if (!m31969k().m42679f("android.permission.INTERNET")) {
                mo4754r().I_().m21307a("App is missing INTERNET permission");
            }
            if (!m31969k().m42679f("android.permission.ACCESS_NETWORK_STATE")) {
                mo4754r().I_().m21307a("App is missing ACCESS_NETWORK_STATE permission");
            }
            c5052x = this.f24574d;
            if (!(C2829c.a(this.f24572b).a() || this.f24575e.m38071x())) {
                if (!bw.m21331a(this.f24572b)) {
                    mo4754r().I_().m21307a("AppMeasurementReceiver not registered/enabled");
                }
                if (!fw.m42640a(this.f24572b, false)) {
                    mo4754r().I_().m21307a("AppMeasurementService not registered/enabled");
                }
            }
            mo4754r().I_().m21307a("Uploading is not possible. App measurement disabled");
        }
    }

    /* renamed from: a */
    final void m31958a(dc dcVar) {
        this.f24596z++;
    }

    /* renamed from: a */
    final void m31959a(C8220s c8220s) {
        this.f24596z++;
    }

    /* renamed from: b */
    public final aa m31960b() {
        return this.f24575e;
    }

    /* renamed from: c */
    public final bm m31961c() {
        cg.m31949a(this.f24576f);
        return this.f24576f;
    }

    /* renamed from: d */
    public final bb m31962d() {
        return (this.f24577g == null || !this.f24577g.m38103y()) ? null : this.f24577g;
    }

    /* renamed from: e */
    public final fc m31963e() {
        cg.m31952b(this.f24579i);
        return this.f24579i;
    }

    /* renamed from: f */
    public final bs m31964f() {
        return this.f24592v;
    }

    /* renamed from: g */
    final cb m31965g() {
        return this.f24578h;
    }

    /* renamed from: h */
    public final df m31966h() {
        cg.m31952b(this.f24586p);
        return this.f24586p;
    }

    /* renamed from: i */
    public final AppMeasurement m31967i() {
        return this.f24580j;
    }

    /* renamed from: j */
    public final FirebaseAnalytics m31968j() {
        return this.f24581k;
    }

    /* renamed from: k */
    public final fw m31969k() {
        cg.m31949a(this.f24582l);
        return this.f24582l;
    }

    /* renamed from: l */
    public final az m31970l() {
        cg.m31949a(this.f24583m);
        return this.f24583m;
    }

    /* renamed from: m */
    public final C2895e mo4751m() {
        return this.f24584n;
    }

    /* renamed from: n */
    public final Context mo4752n() {
        return this.f24572b;
    }

    /* renamed from: o */
    public final ax m31973o() {
        cg.m31952b(this.f24588r);
        return this.f24588r;
    }

    /* renamed from: p */
    public final String m31974p() {
        return this.f24573c;
    }

    /* renamed from: q */
    public final cb mo4753q() {
        cg.m31951b(this.f24578h);
        return this.f24578h;
    }

    /* renamed from: r */
    public final bb mo4754r() {
        cg.m31951b(this.f24577g);
        return this.f24577g;
    }

    /* renamed from: s */
    public final ea m31977s() {
        cg.m31952b(this.f24585o);
        return this.f24585o;
    }

    /* renamed from: t */
    public final ed m31978t() {
        cg.m31952b(this.f24589s);
        return this.f24589s;
    }

    /* renamed from: u */
    public final C5052x mo4755u() {
        return this.f24574d;
    }

    /* renamed from: v */
    public final ak m31980v() {
        cg.m31951b(this.f24590t);
        return this.f24590t;
    }

    /* renamed from: w */
    public final aw m31981w() {
        cg.m31952b(this.f24591u);
        return this.f24591u;
    }

    /* renamed from: x */
    public final C8219n m31982x() {
        if (this.f24587q != null) {
            return this.f24587q;
        }
        throw new IllegalStateException("Component not created");
    }

    /* renamed from: y */
    public final boolean m31983y() {
        mo4753q().mo6210d();
        m31946E();
        boolean z = false;
        if (this.f24575e.m38053h()) {
            return false;
        }
        Boolean i = this.f24575e.m38055i();
        if (i != null) {
            z = i.booleanValue();
        } else if (!C2799e.b()) {
            z = true;
        }
        return m31961c().m42588c(z);
    }

    /* renamed from: z */
    final long m31984z() {
        Long valueOf = Long.valueOf(m31961c().f32331h.m21318a());
        return valueOf.longValue() == 0 ? this.f24571B : Math.min(this.f24571B, valueOf.longValue());
    }
}
