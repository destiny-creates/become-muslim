package com.p064b.p065a.p068c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.p064b.p065a.p066a.C3402a;
import com.p064b.p065a.p068c.p069a.C1014a;
import com.p064b.p065a.p068c.p069a.p070a.C1010d;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6429j.C7601a;
import io.p347a.p348a.p349a.p350a.p352b.C6429j.C7602b;
import io.p347a.p348a.p349a.p350a.p352b.C6434n;
import io.p347a.p348a.p349a.p350a.p353c.C6459d;
import io.p347a.p348a.p349a.p350a.p353c.C6460e;
import io.p347a.p348a.p349a.p350a.p353c.C6465l;
import io.p347a.p348a.p349a.p350a.p353c.C6466m;
import io.p347a.p348a.p349a.p350a.p353c.C8181g;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p356e.C6486g;
import io.p347a.p348a.p349a.p350a.p356e.C7615b;
import io.p347a.p348a.p349a.p350a.p357f.C6489a;
import io.p347a.p348a.p349a.p350a.p357f.C6490c;
import io.p347a.p348a.p349a.p350a.p357f.C7618b;
import io.p347a.p348a.p349a.p350a.p357f.C7619d;
import io.p347a.p348a.p349a.p350a.p358g.C6499o;
import io.p347a.p348a.p349a.p350a.p358g.C6500p;
import io.p347a.p348a.p349a.p350a.p358g.C6504q;
import io.p347a.p348a.p349a.p350a.p358g.C6504q.C6503b;
import io.p347a.p348a.p349a.p350a.p358g.C6507t;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@C6459d(a = {C1014a.class})
/* compiled from: CrashlyticsCore */
/* renamed from: com.b.a.c.f */
public class C3424f extends C6520i<Void> {
    /* renamed from: A */
    private C1035g f9103A;
    /* renamed from: B */
    private C1014a f9104B;
    /* renamed from: a */
    private final long f9105a;
    /* renamed from: b */
    private final ConcurrentHashMap<String, String> f9106b;
    /* renamed from: c */
    private File f9107c;
    /* renamed from: d */
    private C6489a f9108d;
    /* renamed from: j */
    private C1036h f9109j;
    /* renamed from: k */
    private C1036h f9110k;
    /* renamed from: l */
    private C1037i f9111l;
    /* renamed from: m */
    private C1052l f9112m;
    /* renamed from: n */
    private String f9113n;
    /* renamed from: o */
    private String f9114o;
    /* renamed from: p */
    private String f9115p;
    /* renamed from: q */
    private String f9116q;
    /* renamed from: r */
    private String f9117r;
    /* renamed from: s */
    private String f9118s;
    /* renamed from: t */
    private String f9119t;
    /* renamed from: u */
    private String f9120u;
    /* renamed from: v */
    private String f9121v;
    /* renamed from: w */
    private float f9122w;
    /* renamed from: x */
    private boolean f9123x;
    /* renamed from: y */
    private final C1066x f9124y;
    /* renamed from: z */
    private C6484e f9125z;

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$2 */
    class C10232 implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C3424f f2880a;

        C10232(C3424f c3424f) {
            this.f2880a = c3424f;
        }

        public /* synthetic */ Object call() {
            return m3552a();
        }

        /* renamed from: a */
        public Void m3552a() {
            this.f2880a.f9109j.m3565a();
            C6514c.h().a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$3 */
    class C10243 implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3424f f2881a;

        C10243(C3424f c3424f) {
            this.f2881a = c3424f;
        }

        public /* synthetic */ Object call() {
            return m3553a();
        }

        /* renamed from: a */
        public Boolean m3553a() {
            try {
                boolean c = this.f2881a.f9109j.m3567c();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Initialization marker file removed: ");
                stringBuilder.append(c);
                C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
                return Boolean.valueOf(c);
            } catch (Throwable e) {
                C6514c.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$4 */
    class C10254 implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3424f f2882a;

        C10254(C3424f c3424f) {
            this.f2882a = c3424f;
        }

        public /* synthetic */ Object call() {
            return m3554a();
        }

        /* renamed from: a */
        public Boolean m3554a() {
            return Boolean.valueOf(this.f2882a.f9109j.m3566b());
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$a */
    public static class C1030a {
        /* renamed from: a */
        private float f2891a = -1.0f;
        /* renamed from: b */
        private C1037i f2892b;
        /* renamed from: c */
        private C1066x f2893c;
        /* renamed from: d */
        private boolean f2894d = false;

        /* renamed from: a */
        public C1030a m3555a(C1037i c1037i) {
            if (c1037i == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.f2892b == null) {
                this.f2892b = c1037i;
                return this;
            } else {
                throw new IllegalStateException("listener already set.");
            }
        }

        /* renamed from: a */
        public C3424f m3556a() {
            if (this.f2891a < 0.0f) {
                this.f2891a = 1.0f;
            }
            return new C3424f(this.f2891a, this.f2892b, this.f2893c, this.f2894d);
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$b */
    private static final class C1031b implements Callable<Boolean> {
        /* renamed from: a */
        private final C1036h f2895a;

        public /* synthetic */ Object call() {
            return m3557a();
        }

        public C1031b(C1036h c1036h) {
            this.f2895a = c1036h;
        }

        /* renamed from: a */
        public Boolean m3557a() {
            if (!this.f2895a.m3566b()) {
                return Boolean.FALSE;
            }
            C6514c.h().a("CrashlyticsCore", "Found previous crash marker.");
            this.f2895a.m3567c();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$d */
    private static class C1032d {
        /* renamed from: a */
        private boolean f2896a;
        /* renamed from: b */
        private final CountDownLatch f2897b;

        private C1032d() {
            this.f2896a = false;
            this.f2897b = new CountDownLatch(1);
        }

        /* renamed from: a */
        void m3558a(boolean z) {
            this.f2896a = z;
            this.f2897b.countDown();
        }

        /* renamed from: a */
        boolean m3559a() {
            return this.f2896a;
        }

        /* renamed from: b */
        void m3560b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r1 = this;
            r0 = r1.f2897b;	 Catch:{ InterruptedException -> 0x0005 }
            r0.await();	 Catch:{ InterruptedException -> 0x0005 }
        L_0x0005:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.b.a.c.f.d.b():void");
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$5 */
    class C34215 implements C6503b<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3424f f9101a;

        C34215(C3424f c3424f) {
            this.f9101a = c3424f;
        }

        /* renamed from: b */
        public /* synthetic */ Object m10927b(C6507t c6507t) {
            return m10926a(c6507t);
        }

        /* renamed from: a */
        public Boolean m10926a(C6507t c6507t) {
            if (c6507t.f20969d.f20936a != null) {
                return Boolean.valueOf(this.f9101a.m10976y() ^ 1);
            }
            return Boolean.valueOf(null);
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$6 */
    class C34226 implements C6503b<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C3424f f9102a;

        C34226(C3424f c3424f) {
            this.f9102a = c3424f;
        }

        /* renamed from: b */
        public /* synthetic */ Object m10929b(C6507t c6507t) {
            return m10928a(c6507t);
        }

        /* renamed from: a */
        public Boolean m10928a(C6507t c6507t) {
            Activity b = this.f9102a.F().b();
            c6507t = (b == null || b.isFinishing() || !this.f9102a.m10975x()) ? true : this.f9102a.m10939a(b, (C6499o) c6507t.f20968c);
            return Boolean.valueOf(c6507t);
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$c */
    private static final class C3423c implements C1037i {
        /* renamed from: a */
        public void mo752a() {
        }

        private C3423c() {
        }
    }

    /* compiled from: CrashlyticsCore */
    /* renamed from: com.b.a.c.f$1 */
    class C48431 extends C8181g<Void> {
        /* renamed from: a */
        final /* synthetic */ C3424f f13745a;

        C48431(C3424f c3424f) {
            this.f13745a = c3424f;
        }

        public /* synthetic */ Object call() {
            return m17211a();
        }

        /* renamed from: a */
        public Void m17211a() {
            return this.f13745a.m10956d();
        }

        /* renamed from: b */
        public C6460e m17212b() {
            return C6460e.f20858d;
        }
    }

    /* renamed from: b */
    private static int m10941b(float f, int i) {
        return (int) (f * ((float) i));
    }

    /* renamed from: a */
    public String m10950a() {
        return "2.3.8.97";
    }

    /* renamed from: b */
    public String m10955b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    /* renamed from: f */
    protected /* synthetic */ Object m10957f() {
        return m10956d();
    }

    public C3424f() {
        this(1.0f, null, null, false);
    }

    C3424f(float f, C1037i c1037i, C1066x c1066x, boolean z) {
        this(f, c1037i, c1066x, z, C6434n.a("Crashlytics Exception Handler"));
    }

    C3424f(float f, C1037i c1037i, C1066x c1066x, boolean z, ExecutorService executorService) {
        this.f9113n = null;
        this.f9114o = null;
        this.f9115p = null;
        this.f9122w = f;
        if (c1037i == null) {
            c1037i = new C3423c();
        }
        this.f9111l = c1037i;
        this.f9124y = c1066x;
        this.f9123x = z;
        this.f9103A = new C1035g(executorService);
        this.f9106b = new ConcurrentHashMap();
        this.f9105a = System.currentTimeMillis();
    }

    protected boolean d_() {
        return m10954a(super.E());
    }

    /* renamed from: a */
    boolean m10954a(Context context) {
        if (this.f9123x) {
            return false;
        }
        this.f9118s = new C6424g().a(context);
        if (this.f9118s == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Initializing Crashlytics ");
        stringBuilder.append(m10950a());
        C6514c.h().c("CrashlyticsCore", stringBuilder.toString());
        this.f9108d = new C7618b(this);
        this.f9110k = new C1036h("crash_marker", this.f9108d);
        this.f9109j = new C1036h("initialization_marker", this.f9108d);
        try {
            m10936a(context, this.f9118s);
            ad c3428u = new C3428u(context, m10959h());
            boolean u = m10972u();
            m10933K();
            m10937a(c3428u);
            if (!u || C6428i.n(context) == null) {
                return true;
            }
            m10932J();
            return false;
        } catch (Context context2) {
            throw new C6466m(context2);
        } catch (Context context22) {
            C6514c.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", context22);
            return false;
        }
    }

    /* renamed from: a */
    private void m10936a(Context context, String str) {
        C6486g c3425k = this.f9124y != null ? new C3425k(this.f9124y) : null;
        this.f9125z = new C7615b(C6514c.h());
        this.f9125z.a(c3425k);
        this.f9117r = context.getPackageName();
        this.f9119t = D().j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Installer package name is: ");
        stringBuilder.append(this.f9119t);
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f9117r, 0);
        this.f9120u = Integer.toString(packageInfo.versionCode);
        this.f9121v = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.f9116q = C6428i.m(context);
        m10948a(this.f9116q, C3424f.m10943b(context)).m3452a(str, this.f9117r);
    }

    /* renamed from: a */
    private void m10937a(ad adVar) {
        try {
            C6514c.h().a("CrashlyticsCore", "Installing exception handler...");
            this.f9112m = new C1052l(Thread.getDefaultUncaughtExceptionHandler(), this.f9103A, D(), adVar, this.f9108d, this);
            this.f9112m.m3628b();
            Thread.setDefaultUncaughtExceptionHandler(this.f9112m);
            C6514c.h().a("CrashlyticsCore", "Successfully installed exception handler.");
        } catch (ad adVar2) {
            C6514c.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", adVar2);
        }
    }

    /* renamed from: d */
    protected Void m10956d() {
        m10970s();
        this.f9112m.m3633g();
        try {
            C6507t b = C6504q.a().b();
            if (b == null) {
                C6514c.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
                m10971t();
                return null;
            } else if (b.f20969d.f20938c) {
                this.f9112m.m3629c();
                C1054n a = m10949a(b);
                if (a == null) {
                    C6514c.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    m10971t();
                    return null;
                }
                new aa(a).m3457a(this.f9122w);
                m10971t();
                return null;
            } else {
                C6514c.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                m10971t();
                return null;
            }
        } catch (Throwable e) {
            C6514c.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            m10971t();
        }
    }

    /* renamed from: e */
    public static C3424f m10946e() {
        return (C3424f) C6514c.a(C3424f.class);
    }

    /* renamed from: a */
    public void m10952a(Throwable th) {
        if (this.f9123x || !C3424f.m10944c("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C6514c.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f9112m.m3624a(Thread.currentThread(), th);
        }
    }

    /* renamed from: a */
    public void m10951a(String str, String str2) {
        if (!this.f9123x) {
            if (str == null) {
                str = E();
                if (str != null) {
                    if (C6428i.i(str) != null) {
                        throw new IllegalArgumentException("Custom attribute key must not be null.");
                    }
                }
                C6514c.h().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            str = C3424f.m10945d(str);
            if (this.f9106b.size() < 64 || this.f9106b.containsKey(str)) {
                if (str2 == null) {
                    str2 = "";
                } else {
                    str2 = C3424f.m10945d(str2);
                }
                this.f9106b.put(str, str2);
                this.f9112m.m3625a(this.f9106b);
                return;
            }
            C6514c.h().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
        }
    }

    /* renamed from: a */
    static void m10938a(String str) {
        C3402a c3402a = (C3402a) C6514c.a(C3402a.class);
        if (c3402a != null) {
            c3402a.m10825a(new C7602b(str));
        }
    }

    /* renamed from: b */
    static void m10942b(String str) {
        C3402a c3402a = (C3402a) C6514c.a(C3402a.class);
        if (c3402a != null) {
            c3402a.m10824a(new C7601a(str));
        }
    }

    /* renamed from: g */
    Map<String, String> m10958g() {
        return Collections.unmodifiableMap(this.f9106b);
    }

    /* renamed from: a */
    C1015a m10948a(String str, boolean z) {
        return new C1015a(str, z);
    }

    /* renamed from: h */
    String m10959h() {
        return this.f9117r;
    }

    /* renamed from: i */
    String m10960i() {
        return this.f9118s;
    }

    /* renamed from: j */
    String m10961j() {
        return this.f9119t;
    }

    /* renamed from: k */
    String m10962k() {
        return this.f9121v;
    }

    /* renamed from: l */
    String m10963l() {
        return this.f9120u;
    }

    /* renamed from: m */
    String m10964m() {
        return C6428i.b(E(), "com.crashlytics.ApiEndpoint");
    }

    /* renamed from: n */
    String m10965n() {
        return this.f9116q;
    }

    /* renamed from: o */
    C1052l m10966o() {
        return this.f9112m;
    }

    /* renamed from: p */
    String m10967p() {
        return D().a() ? this.f9113n : null;
    }

    /* renamed from: q */
    String m10968q() {
        return D().a() ? this.f9114o : null;
    }

    /* renamed from: r */
    String m10969r() {
        return D().a() ? this.f9115p : null;
    }

    /* renamed from: J */
    private void m10932J() {
        Callable c48431 = new C48431(this);
        for (C6465l a : I()) {
            c48431.a(a);
        }
        Future submit = F().f().submit(c48431);
        C6514c.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C6514c.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C6514c.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C6514c.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    /* renamed from: s */
    void m10970s() {
        this.f9103A.m3561a(new C10232(this));
    }

    /* renamed from: t */
    void m10971t() {
        this.f9103A.m3563b(new C10243(this));
    }

    /* renamed from: u */
    boolean m10972u() {
        return ((Boolean) this.f9103A.m3561a(new C10254(this))).booleanValue();
    }

    /* renamed from: v */
    C1010d m10973v() {
        return this.f9104B != null ? this.f9104B.m3451a() : null;
    }

    /* renamed from: w */
    File m10974w() {
        if (this.f9107c == null) {
            this.f9107c = new C7618b(this).a();
        }
        return this.f9107c;
    }

    /* renamed from: x */
    boolean m10975x() {
        return ((Boolean) C6504q.a().a(new C34215(this), Boolean.valueOf(false))).booleanValue();
    }

    /* renamed from: y */
    boolean m10976y() {
        return new C7619d(this).a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    void m10953a(boolean z) {
        C6490c c7619d = new C7619d(this);
        c7619d.a(c7619d.b().putBoolean("always_send_reports_opt_in", z));
    }

    /* renamed from: z */
    boolean m10977z() {
        return ((Boolean) C6504q.a().a(new C34226(this), Boolean.valueOf(true))).booleanValue();
    }

    /* renamed from: a */
    C1054n m10949a(C6507t c6507t) {
        return c6507t != null ? new C3426o(this, m10964m(), c6507t.f20966a.f20931d, this.f9125z) : null;
    }

    /* renamed from: K */
    private void m10933K() {
        if (Boolean.TRUE.equals((Boolean) this.f9103A.m3561a(new C1031b(this.f9110k)))) {
            try {
                this.f9111l.mo752a();
            } catch (Throwable e) {
                C6514c.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* renamed from: A */
    void m10947A() {
        this.f9110k.m3565a();
    }

    /* renamed from: a */
    private boolean m10939a(Activity activity, C6499o c6499o) {
        final C1058q c1058q = new C1058q(activity, c6499o);
        C1032d c1032d = new C1032d();
        final Activity activity2 = activity;
        final C1032d c1032d2 = c1032d;
        final C6499o c6499o2 = c6499o;
        activity.runOnUiThread(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ C3424f f2890e;

            /* compiled from: CrashlyticsCore */
            /* renamed from: com.b.a.c.f$7$1 */
            class C10261 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C10297 f2883a;

                C10261(C10297 c10297) {
                    this.f2883a = c10297;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c1032d2.m3558a(true);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: CrashlyticsCore */
            /* renamed from: com.b.a.c.f$7$2 */
            class C10272 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C10297 f2884a;

                C10272(C10297 c10297) {
                    this.f2884a = c10297;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c1032d2.m3558a(false);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: CrashlyticsCore */
            /* renamed from: com.b.a.c.f$7$3 */
            class C10283 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C10297 f2885a;

                C10283(C10297 c10297) {
                    this.f2885a = c10297;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f2885a.f2890e.m10953a(true);
                    c1032d2.m3558a(true);
                    dialogInterface.dismiss();
                }
            }

            public void run() {
                Builder builder = new Builder(activity2);
                OnClickListener c10261 = new C10261(this);
                float f = activity2.getResources().getDisplayMetrics().density;
                int a = C3424f.m10941b(f, 5);
                View textView = new TextView(activity2);
                textView.setAutoLinkMask(15);
                textView.setText(c1058q.m3642b());
                textView.setTextAppearance(activity2, 16973892);
                textView.setPadding(a, a, a, a);
                textView.setFocusable(false);
                View scrollView = new ScrollView(activity2);
                scrollView.setPadding(C3424f.m10941b(f, 14), C3424f.m10941b(f, 2), C3424f.m10941b(f, 10), C3424f.m10941b(f, 12));
                scrollView.addView(textView);
                builder.setView(scrollView).setTitle(c1058q.m3641a()).setCancelable(false).setNeutralButton(c1058q.m3643c(), c10261);
                if (c6499o2.f20947d) {
                    builder.setNegativeButton(c1058q.m3645e(), new C10272(this));
                }
                if (c6499o2.f20949f) {
                    builder.setPositiveButton(c1058q.m3644d(), new C10283(this));
                }
                builder.show();
            }
        });
        C6514c.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        c1032d.m3560b();
        return c1032d.m3559a();
    }

    /* renamed from: B */
    static C6500p m10931B() {
        C6507t b = C6504q.a().b();
        if (b == null) {
            return null;
        }
        return b.f20967b;
    }

    /* renamed from: b */
    private static boolean m10943b(Context context) {
        return C6428i.a(context, "com.crashlytics.RequireBuildId", true);
    }

    /* renamed from: c */
    private static boolean m10944c(String str) {
        C3424f e = C3424f.m10946e();
        if (e != null) {
            if (e.f9112m != null) {
                return true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
        stringBuilder.append(str);
        C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), null);
        return null;
    }

    /* renamed from: d */
    private static String m10945d(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }
}
