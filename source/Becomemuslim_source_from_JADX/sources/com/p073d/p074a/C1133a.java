package com.p073d.p074a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amplitude.api.Constants;
import com.facebook.internal.ServerProtocol;
import com.p073d.p074a.C1133a;
import com.p073d.p074a.C1153k;
import com.p073d.p074a.C3482m.C3481a;
import com.p073d.p074a.C3490s.C3489a;
import com.p073d.p074a.p075a.C1131e;
import com.p073d.p074a.p075a.C1131e.C1130a;
import com.p073d.p074a.p075a.C1132f;
import com.p073d.p074a.p075a.C3460b;
import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C4540a;
import com.p073d.p074a.p075a.C4540a.C3459a;
import com.p073d.p074a.p075a.C4541c;
import com.p073d.p074a.p075a.C4541c.C3461a;
import com.p073d.p074a.p075a.C4542d;
import com.p073d.p074a.p075a.C4542d.C3462a;
import com.p073d.p074a.p075a.C4543g;
import com.p073d.p074a.p075a.C4543g.C3463a;
import com.p073d.p074a.p075a.C4544h;
import com.p073d.p074a.p075a.C4544h.C3464a;
import com.p073d.p074a.p076b.C1139b;
import com.p073d.p074a.p076b.C1139b.C1135a;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Analytics */
/* renamed from: com.d.a.a */
public class C1133a {
    /* renamed from: a */
    static final Handler f3205a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown handler message received: ");
            stringBuilder.append(message.what);
            throw new AssertionError(stringBuilder.toString());
        }
    };
    /* renamed from: b */
    static final List<String> f3206b = new ArrayList(1);
    /* renamed from: c */
    static volatile C1133a f3207c = null;
    /* renamed from: d */
    static final C3483n f3208d = new C3483n();
    /* renamed from: A */
    private final C1140c f3209A;
    /* renamed from: B */
    private List<C1130a> f3210B;
    /* renamed from: C */
    private Map<String, C1131e<?>> f3211C;
    /* renamed from: e */
    final ExecutorService f3212e;
    /* renamed from: f */
    final C1164r f3213f;
    /* renamed from: g */
    final C1153k f3214g;
    /* renamed from: h */
    final C3489a f3215h;
    /* renamed from: i */
    final C3466b f3216i;
    /* renamed from: j */
    final String f3217j;
    /* renamed from: k */
    final C1146e f3218k;
    /* renamed from: l */
    final C1143d f3219l;
    /* renamed from: m */
    final C1148g f3220m;
    /* renamed from: n */
    final ActivityLifecycleCallbacks f3221n;
    /* renamed from: o */
    C3482m f3222o;
    /* renamed from: p */
    final String f3223p;
    /* renamed from: q */
    final int f3224q;
    /* renamed from: r */
    final long f3225r;
    /* renamed from: s */
    final Map<String, Boolean> f3226s = new ConcurrentHashMap();
    /* renamed from: t */
    volatile boolean f3227t;
    /* renamed from: u */
    private final Application f3228u;
    /* renamed from: v */
    private final List<C1152j> f3229v;
    /* renamed from: w */
    private final C1132f f3230w;
    /* renamed from: x */
    private final C3481a f3231x;
    /* renamed from: y */
    private final CountDownLatch f3232y;
    /* renamed from: z */
    private final ExecutorService f3233z;

    /* compiled from: Analytics */
    /* renamed from: com.d.a.a$3 */
    class C11153 implements Callable<C3482m> {
        /* renamed from: a */
        final /* synthetic */ C1133a f3144a;

        C11153(C1133a c1133a) {
            this.f3144a = c1133a;
        }

        public /* synthetic */ Object call() {
            return m3942a();
        }

        /* renamed from: a */
        public C3482m m3942a() {
            Closeable c;
            Throwable th;
            try {
                c = this.f3144a.f3218k.m4053c();
                try {
                    C3482m a = C3482m.m11189a(this.f3144a.f3219l.m4046a(C1139b.m4008a(c.f3246b)));
                    C1139b.m4017a(c);
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    C1139b.m4017a(c);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                c = null;
                th = th4;
                C1139b.m4017a(c);
                throw th;
            }
        }
    }

    /* compiled from: Analytics */
    /* renamed from: com.d.a.a$5 */
    class C11185 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1133a f3147a;

        /* compiled from: Analytics */
        /* renamed from: com.d.a.a$5$1 */
        class C11171 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C11185 f3146a;

            C11171(C11185 c11185) {
                this.f3146a = c11185;
            }

            public void run() {
                this.f3146a.f3147a.m3984a(this.f3146a.f3147a.f3222o);
            }
        }

        C11185(C1133a c1133a) {
            this.f3147a = c1133a;
        }

        public void run() {
            this.f3147a.f3222o = this.f3147a.m4005g();
            if (C1139b.m4023a(this.f3147a.f3222o)) {
                this.f3147a.f3222o = C3482m.m11189a(new C1166t().mo783b("integrations", new C1166t().mo783b("Segment.io", new C1166t().mo783b("apiKey", this.f3147a.f3223p))));
            }
            C1133a.f3205a.post(new C11171(this));
        }
    }

    /* compiled from: Analytics */
    /* renamed from: com.d.a.a$a */
    public static class C1125a {
        /* renamed from: a */
        private final Application f3164a;
        /* renamed from: b */
        private String f3165b;
        /* renamed from: c */
        private boolean f3166c = true;
        /* renamed from: d */
        private int f3167d = 20;
        /* renamed from: e */
        private long f3168e = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
        /* renamed from: f */
        private C1153k f3169f;
        /* renamed from: g */
        private String f3170g;
        /* renamed from: h */
        private C1126b f3171h;
        /* renamed from: i */
        private ExecutorService f3172i;
        /* renamed from: j */
        private ExecutorService f3173j;
        /* renamed from: k */
        private C1147f f3174k;
        /* renamed from: l */
        private final List<C1130a> f3175l = new ArrayList();
        /* renamed from: m */
        private List<C1152j> f3176m;
        /* renamed from: n */
        private boolean f3177n = false;
        /* renamed from: o */
        private boolean f3178o = false;
        /* renamed from: p */
        private boolean f3179p = false;
        /* renamed from: q */
        private C1148g f3180q;

        public C1125a(Context context, String str) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            } else if (C1139b.m4019a(context, "android.permission.INTERNET")) {
                this.f3164a = (Application) context.getApplicationContext();
                if (this.f3164a == null) {
                    throw new IllegalArgumentException("Application context must not be null.");
                } else if (C1139b.m4020a((CharSequence) str) == null) {
                    this.f3165b = str;
                } else {
                    throw new IllegalArgumentException("writeKey must not be null or empty.");
                }
            } else {
                throw new IllegalArgumentException("INTERNET permission is required.");
            }
        }

        /* renamed from: a */
        public C1125a m3943a(String str) {
            if (C1139b.m4020a((CharSequence) str)) {
                throw new IllegalArgumentException("tag must not be null or empty.");
            }
            this.f3170g = str;
            return this;
        }

        /* renamed from: a */
        public C1133a m3944a() {
            if (C1139b.m4020a(this.f3170g)) {
                r1.f3170g = r1.f3165b;
            }
            synchronized (C1133a.f3206b) {
                if (C1133a.f3206b.contains(r1.f3170g)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Duplicate analytics client created with tag: ");
                    stringBuilder.append(r1.f3170g);
                    stringBuilder.append(". If you want to use multiple Analytics clients, use a different writeKey ");
                    stringBuilder.append("or set a tag via the builder during construction.");
                    throw new IllegalStateException(stringBuilder.toString());
                }
                C1133a.f3206b.add(r1.f3170g);
            }
            if (r1.f3169f == null) {
                r1.f3169f = new C1153k();
            }
            if (r1.f3171h == null) {
                r1.f3171h = C1126b.NONE;
            }
            if (r1.f3172i == null) {
                r1.f3172i = new C1135a();
            }
            if (r1.f3174k == null) {
                r1.f3174k = new C1147f();
            }
            if (r1.f3180q == null) {
                r1.f3180q = C1148g.m4059a();
            }
            C1164r c1164r = new C1164r();
            C1143d c1143d = C1143d.f3242a;
            C1146e c1146e = new C1146e(r1.f3165b, r1.f3174k);
            C3481a c3481a = new C3481a(r1.f3164a, c1143d, r1.f3170g);
            C1140c c1140c = new C1140c(C1139b.m4032d(r1.f3164a, r1.f3170g), "opt-out", false);
            C3489a c3489a = new C3489a(r1.f3164a, c1143d, r1.f3170g);
            if (!c3489a.m4124b() || c3489a.m4121a() == null) {
                c3489a.m4122a(C3490s.m11216a());
            }
            C1132f a = C1132f.m3968a(r1.f3171h);
            C3466b a2 = C3466b.m11148a(r1.f3164a, (C3490s) c3489a.m4121a(), r1.f3166c);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            a2.m11153a(r1.f3164a, countDownLatch, a);
            List arrayList = new ArrayList(r1.f3175l.size() + 1);
            arrayList.add(C3488q.f9282a);
            arrayList.addAll(r1.f3175l);
            List a3 = C1139b.m4014a(r1.f3176m);
            ExecutorService executorService = r1.f3173j;
            if (executorService == null) {
                executorService = Executors.newSingleThreadExecutor();
            }
            ExecutorService executorService2 = executorService;
            CountDownLatch countDownLatch2 = countDownLatch;
            C1140c c1140c2 = c1140c;
            return new C1133a(r1.f3164a, r1.f3172i, c1164r, c3489a, a2, r1.f3169f, a, r1.f3170g, Collections.unmodifiableList(arrayList), c1146e, c1143d, c3481a, r1.f3165b, r1.f3167d, r1.f3168e, executorService2, r1.f3177n, countDownLatch2, r1.f3178o, r1.f3179p, c1140c2, r1.f3180q, a3);
        }
    }

    /* compiled from: Analytics */
    /* renamed from: com.d.a.a$b */
    public enum C1126b {
        NONE,
        INFO,
        DEBUG,
        BASIC,
        VERBOSE
    }

    C1133a(Application application, ExecutorService executorService, C1164r c1164r, C3489a c3489a, C3466b c3466b, C1153k c1153k, C1132f c1132f, String str, List<C1130a> list, C1146e c1146e, C1143d c1143d, C3481a c3481a, String str2, int i, long j, ExecutorService executorService2, boolean z, CountDownLatch countDownLatch, boolean z2, boolean z3, C1140c c1140c, C1148g c1148g, List<C1152j> list2) {
        Application application2 = application;
        C1132f c1132f2 = c1132f;
        String str3 = str;
        ExecutorService executorService3 = executorService2;
        this.f3228u = application2;
        this.f3212e = executorService;
        this.f3213f = c1164r;
        this.f3215h = c3489a;
        this.f3216i = c3466b;
        this.f3214g = c1153k;
        this.f3230w = c1132f2;
        this.f3217j = str3;
        this.f3218k = c1146e;
        this.f3219l = c1143d;
        this.f3231x = c3481a;
        this.f3223p = str2;
        this.f3224q = i;
        this.f3225r = j;
        this.f3232y = countDownLatch;
        this.f3209A = c1140c;
        this.f3210B = list;
        this.f3233z = executorService3;
        this.f3220m = c1148g;
        this.f3229v = list2;
        m3978k();
        executorService3.submit(new C11185(this));
        c1132f.m3973c("Created analytics client for project with tag:%s.", str3);
        c3489a = z;
        c3466b = z3;
        final ExecutorService executorService4 = executorService2;
        c1132f = z2;
        this.f3221n = new ActivityLifecycleCallbacks(this) {
            /* renamed from: a */
            final AtomicBoolean f3149a = new AtomicBoolean(false);
            /* renamed from: f */
            final /* synthetic */ C1133a f3154f;

            /* compiled from: Analytics */
            /* renamed from: com.d.a.a$6$1 */
            class C11191 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C11206 f3148a;

                C11191(C11206 c11206) {
                    this.f3148a = c11206;
                }

                public void run() {
                    this.f3148a.f3154f.m3979a();
                }
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (!this.f3149a.getAndSet(true) && c3489a) {
                    this.f3154f.m3993b();
                    if (c3466b) {
                        executorService4.submit(new C11191(this));
                    }
                }
                this.f3154f.m3983a(C1150i.m4067a(activity, bundle));
            }

            public void onActivityStarted(Activity activity) {
                if (c1132f) {
                    this.f3154f.m3980a(activity);
                }
                this.f3154f.m3983a(C1150i.m4066a(activity));
            }

            public void onActivityResumed(Activity activity) {
                this.f3154f.m3983a(C1150i.m4074b(activity));
            }

            public void onActivityPaused(Activity activity) {
                this.f3154f.m3983a(C1150i.m4076c(activity));
            }

            public void onActivityStopped(Activity activity) {
                this.f3154f.m3983a(C1150i.m4077d(activity));
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f3154f.m3983a(C1150i.m4075b(activity, bundle));
            }

            public void onActivityDestroyed(Activity activity) {
                this.f3154f.m3983a(C1150i.m4078e(activity));
            }
        };
        application.registerActivityLifecycleCallbacks(this.f3221n);
    }

    /* renamed from: a */
    void m3979a() {
        Throwable e;
        C1140c c1140c = new C1140c(C1139b.m4032d(this.f3228u, this.f3217j), "tracked_attribution", false);
        if (!c1140c.m4034a()) {
            m3975h();
            Closeable closeable = null;
            try {
                Closeable b = this.f3218k.m4052b();
                try {
                    this.f3219l.m4048a(this.f3216i, new BufferedWriter(new OutputStreamWriter(b.f3247c)));
                    m3987a("Install Attributed", new C3483n(this.f3219l.m4046a(C1139b.m4008a(b.f3245a.getInputStream()))));
                    c1140c.m4033a(true);
                    C1139b.m4017a(b);
                } catch (IOException e2) {
                    e = e2;
                    closeable = b;
                    try {
                        this.f3230w.m3971a(e, "Unable to track attribution information. Retrying on next launch.", new Object[0]);
                        C1139b.m4017a(closeable);
                    } catch (Throwable th) {
                        e = th;
                        b = closeable;
                        C1139b.m4017a(b);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    C1139b.m4017a(b);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                this.f3230w.m3971a(e, "Unable to track attribution information. Retrying on next launch.", new Object[0]);
                C1139b.m4017a(closeable);
            }
        }
    }

    /* renamed from: b */
    void m3993b() {
        PackageInfo a = C1133a.m3974a(this.f3228u);
        String str = a.versionName;
        int i = a.versionCode;
        SharedPreferences d = C1139b.m4032d(this.f3228u, this.f3217j);
        String string = d.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, null);
        int i2 = d.getInt("build", -1);
        if (i2 == -1) {
            m3987a("Application Installed", new C3483n().m11194a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str).m11194a("build", Integer.valueOf(i)));
        } else if (i != i2) {
            m3987a("Application Updated", new C3483n().m11194a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str).m11194a("build", Integer.valueOf(i)).m11194a("previous_version", string).m11194a("previous_build", Integer.valueOf(i2)));
        }
        m3987a("Application Opened", new C3483n().m11194a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str).m11194a("build", Integer.valueOf(i)));
        Editor edit = d.edit();
        edit.putString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str);
        edit.putInt("build", i);
        edit.apply();
    }

    /* renamed from: a */
    static android.content.pm.PackageInfo m3974a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r3.getPackageManager();
        r1 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x000e }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x000e }
        return r0;
    L_0x000e:
        r0 = new java.lang.AssertionError;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Package not found: ";
        r1.append(r2);
        r3 = r3.getPackageName();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.a.a(android.content.Context):android.content.pm.PackageInfo");
    }

    /* renamed from: a */
    void m3980a(Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        try {
            m3990a(null, packageManager.getActivityInfo(activity.getComponentName(), 128).loadLabel(packageManager).toString());
        } catch (Activity activity2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity Not Found: ");
            stringBuilder.append(activity2.toString());
            throw new AssertionError(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    void m3983a(final C1150i c1150i) {
        if (!this.f3227t) {
            this.f3233z.submit(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C1133a f3157b;

                /* compiled from: Analytics */
                /* renamed from: com.d.a.a$7$1 */
                class C11211 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C11227 f3155a;

                    C11211(C11227 c11227) {
                        this.f3155a = c11227;
                    }

                    public void run() {
                        this.f3155a.f3157b.m3995b(c1150i);
                    }
                }

                public void run() {
                    C1133a.f3205a.post(new C11211(this));
                }
            });
        }
    }

    /* renamed from: a */
    public void m3985a(String str) {
        m3989a(str, null, null);
    }

    /* renamed from: a */
    public void m3989a(String str, C3490s c3490s, final C1153k c1153k) {
        m3976i();
        if (C1139b.m4020a((CharSequence) str)) {
            if (C1139b.m4023a((Map) c3490s)) {
                throw new IllegalArgumentException("Either userId or some traits must be provided.");
            }
        }
        C3490s c3490s2 = (C3490s) this.f3215h.m4121a();
        if (!C1139b.m4020a((CharSequence) str)) {
            c3490s2.m11217a(str);
        }
        if (C1139b.m4023a((Map) c3490s) == null) {
            c3490s2.putAll(c3490s);
        }
        this.f3215h.m4122a(c3490s2);
        this.f3216i.m11155a(c3490s2);
        this.f3233z.submit(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1133a f3159b;

            public void run() {
                C1153k c1153k;
                if (c1153k == null) {
                    c1153k = this.f3159b.f3214g;
                } else {
                    c1153k = c1153k;
                }
                this.f3159b.m3981a(new C3462a().m11131c(this.f3159b.f3215h.m4121a()), c1153k);
            }
        });
    }

    /* renamed from: b */
    public void m3996b(String str) {
        m3998b(str, null, null);
    }

    /* renamed from: b */
    public void m3998b(final String str, final C3490s c3490s, final C1153k c1153k) {
        m3976i();
        if (C1139b.m4020a((CharSequence) str)) {
            throw new IllegalArgumentException("groupId must not be null or empty.");
        }
        this.f3233z.submit(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C1133a f3163d;

            public void run() {
                Map c3490s;
                C1153k c1153k;
                if (c3490s == null) {
                    c3490s = new C3490s();
                } else {
                    c3490s = c3490s;
                }
                if (c1153k == null) {
                    c1153k = this.f3163d.f3214g;
                } else {
                    c1153k = c1153k;
                }
                this.f3163d.m3981a(new C3461a().m11122a(str).m11126c(c3490s), c1153k);
            }
        });
    }

    /* renamed from: c */
    public void m4000c(String str) {
        m3988a(str, null, null);
    }

    /* renamed from: a */
    public void m3987a(String str, C3483n c3483n) {
        m3988a(str, c3483n, null);
    }

    /* renamed from: a */
    public void m3988a(final String str, final C3483n c3483n, final C1153k c1153k) {
        m3976i();
        if (C1139b.m4020a((CharSequence) str)) {
            throw new IllegalArgumentException("event must not be null or empty.");
        }
        this.f3233z.submit(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C1133a f3133d;

            public void run() {
                C1153k c1153k;
                Map map;
                if (c1153k == null) {
                    c1153k = this.f3133d.f3214g;
                } else {
                    c1153k = c1153k;
                }
                if (c3483n == null) {
                    map = C1133a.f3208d;
                } else {
                    map = c3483n;
                }
                this.f3133d.m3981a(new C3464a().m11140a(str).m11144c(map), c1153k);
            }
        });
    }

    /* renamed from: a */
    public void m3990a(String str, String str2) {
        m3991a(str, str2, null, null);
    }

    /* renamed from: d */
    public void m4002d(String str) {
        m3991a(null, str, null, null);
    }

    /* renamed from: b */
    public void m3997b(String str, C3483n c3483n) {
        m3991a(null, str, c3483n, null);
    }

    /* renamed from: a */
    public void m3991a(String str, String str2, C3483n c3483n, C1153k c1153k) {
        m3976i();
        if (C1139b.m4020a((CharSequence) str)) {
            if (C1139b.m4020a((CharSequence) str2)) {
                throw new IllegalArgumentException("either category or name must be provided.");
            }
        }
        final C1153k c1153k2 = c1153k;
        final C3483n c3483n2 = c3483n;
        final String str3 = str2;
        final String str4 = str;
        this.f3233z.submit(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ C1133a f3138e;

            public void run() {
                C1153k c1153k;
                Map map;
                if (c1153k2 == null) {
                    c1153k = this.f3138e.f3214g;
                } else {
                    c1153k = c1153k2;
                }
                if (c3483n2 == null) {
                    map = C1133a.f3208d;
                } else {
                    map = c3483n2;
                }
                this.f3138e.m3981a(new C3463a().m11133a(str3).m11138d(str4).m11137c(map), c1153k);
            }
        });
    }

    /* renamed from: a */
    public void m3986a(final String str, final C1153k c1153k) {
        m3976i();
        if (C1139b.m4020a((CharSequence) str)) {
            throw new IllegalArgumentException("newId must not be null or empty.");
        }
        this.f3233z.submit(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1133a f3141c;

            public void run() {
                C1153k c1153k;
                if (c1153k == null) {
                    c1153k = this.f3141c.f3214g;
                } else {
                    c1153k = c1153k;
                }
                this.f3141c.m3981a(((C3459a) new C3459a().m3950c(str)).m11112a(this.f3141c.f3216i.m11156b().m11224e()), c1153k);
            }
        });
    }

    /* renamed from: h */
    private void m3975h() {
        try {
            this.f3232y.await(15, TimeUnit.SECONDS);
        } catch (Throwable e) {
            this.f3230w.m3971a(e, "Thread interrupted while waiting for advertising ID.", new Object[0]);
        }
        if (this.f3232y.getCount() == 1) {
            this.f3230w.m3973c("Advertising ID may not be collected because the API did not respond within 15 seconds.", new Object[0]);
        }
    }

    /* renamed from: a */
    void m3981a(C1127a<?, ?> c1127a, C1153k c1153k) {
        m3975h();
        C3466b a = this.f3216i.m11150a();
        c1127a.m3945a(a);
        c1127a.m3947b(a.m11156b().m11223d());
        c1127a.m3948b(c1153k.m4084a());
        CharSequence c = a.m11156b().m11222c();
        if (!C1139b.m4020a(c)) {
            c1127a.m3950c(c);
        }
        m3982a(c1127a.m3951c());
    }

    /* renamed from: a */
    void m3982a(C3460b c3460b) {
        if (!this.f3209A.m4034a()) {
            this.f3230w.m3970a("Created payload %s.", c3460b);
            new C3485p(0, c3460b, this.f3229v, this).mo794a(c3460b);
        }
    }

    /* renamed from: b */
    void m3994b(C3460b c3460b) {
        this.f3230w.m3970a("Running payload %s.", c3460b);
        switch (c3460b.m11117b()) {
            case identify:
                c3460b = C1150i.m4070a((C4542d) c3460b);
                break;
            case alias:
                c3460b = C1150i.m4068a((C4540a) c3460b);
                break;
            case group:
                c3460b = C1150i.m4069a((C4541c) c3460b);
                break;
            case track:
                c3460b = C1150i.m4072a((C4544h) c3460b);
                break;
            case screen:
                c3460b = C1150i.m4071a((C4543g) c3460b);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown type ");
                stringBuilder.append(c3460b.m11117b());
                throw new AssertionError(stringBuilder.toString());
        }
        f3205a.post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1133a f3143b;

            public void run() {
                this.f3143b.m3995b(c3460b);
            }
        });
    }

    /* renamed from: c */
    public void m3999c() {
        if (this.f3227t) {
            throw new IllegalStateException("Cannot enqueue messages after client is shutdown.");
        }
        m3983a(C1150i.f3256a);
    }

    /* renamed from: d */
    public Application m4001d() {
        return this.f3228u;
    }

    /* renamed from: e */
    public C1132f m4003e() {
        return this.f3230w;
    }

    /* renamed from: f */
    public void m4004f() {
        C1139b.m4032d(this.f3228u, this.f3217j).edit().clear().apply();
        this.f3215h.m4125c();
        this.f3215h.m4122a(C3490s.m11216a());
        this.f3216i.m11155a((C3490s) this.f3215h.m4121a());
        m3983a(C1150i.f3257b);
    }

    /* renamed from: a */
    public void m3992a(boolean z) {
        this.f3209A.m4033a(z);
    }

    /* renamed from: i */
    private void m3976i() {
        if (this.f3227t) {
            throw new IllegalStateException("Cannot enqueue messages after client is shutdown.");
        }
    }

    /* renamed from: j */
    private C3482m m3977j() {
        try {
            C3482m c3482m = (C3482m) this.f3212e.submit(new C11153(this)).get();
            this.f3231x.m4122a(c3482m);
            return c3482m;
        } catch (Throwable e) {
            this.f3230w.m3971a(e, "Thread interrupted while fetching settings.", new Object[0]);
            return null;
        } catch (Throwable e2) {
            this.f3230w.m3971a(e2, "Unable to fetch settings. Retrying in %s ms.", Long.valueOf(60000));
            return null;
        }
    }

    /* renamed from: g */
    C3482m m4005g() {
        Map map = (C3482m) this.f3231x.m4121a();
        if (C1139b.m4023a(map)) {
            return m3977j();
        }
        if (map.m11190a() + 86400000 > System.currentTimeMillis()) {
            return map;
        }
        Map j = m3977j();
        return C1139b.m4023a(j) ? map : j;
    }

    /* renamed from: a */
    void m3984a(C3482m c3482m) {
        c3482m = c3482m.m11193d();
        this.f3211C = new LinkedHashMap(this.f3210B.size());
        for (int i = 0; i < this.f3210B.size(); i++) {
            C1130a c1130a = (C1130a) this.f3210B.get(i);
            String a = c1130a.mo796a();
            Map a2 = c3482m.m4129a(a);
            if (C1139b.m4023a(a2)) {
                this.f3230w.m3973c("Integration %s is not enabled.", a);
            } else {
                C1131e a3 = c1130a.mo795a(a2, this);
                if (a3 == null) {
                    this.f3230w.m3972b("Factory %s couldn't create integration.", c1130a);
                } else {
                    this.f3211C.put(a, a3);
                    this.f3226s.put(a, Boolean.valueOf(false));
                }
            }
        }
        this.f3210B = null;
    }

    /* renamed from: b */
    void m3995b(C1150i c1150i) {
        for (Entry entry : this.f3211C.entrySet()) {
            String str = (String) entry.getKey();
            long nanoTime = System.nanoTime();
            c1150i.mo787a(str, (C1131e) entry.getValue(), this.f3222o);
            this.f3213f.m4119a(str, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            this.f3230w.m3973c("Ran %s on integration %s in %d ns.", c1150i, str, Long.valueOf(r5));
        }
    }

    /* renamed from: k */
    private void m3978k() {
        SharedPreferences d = C1139b.m4032d(this.f3228u, this.f3217j);
        C1140c c1140c = new C1140c(d, "namespaceSharedPreferences", true);
        if (c1140c.m4034a()) {
            C1139b.m4016a(this.f3228u.getSharedPreferences("analytics-android", 0), d);
            c1140c.m4033a(false);
        }
    }
}
