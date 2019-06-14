package com.bugsnag.android;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.view.OrientationEventListener;
import com.bugsnag.android.C3448s.C1100a;
import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import com.bugsnag.android.ab.C1071a;
import com.facebook.share.internal.ShareConstants;
import java.util.Collections;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: Client */
/* renamed from: com.bugsnag.android.j */
public class C1089j extends Observable implements Observer {
    /* renamed from: a */
    protected final C1091l f3048a;
    /* renamed from: b */
    final Context f3049b;
    /* renamed from: c */
    protected final C1099r f3050c;
    /* renamed from: d */
    protected final C1070a f3051d;
    /* renamed from: e */
    final Breadcrumbs f3052e;
    /* renamed from: f */
    protected final C3449u f3053f;
    /* renamed from: g */
    final ak f3054g;
    /* renamed from: h */
    final C1106v f3055h;
    /* renamed from: i */
    final al f3056i;
    /* renamed from: j */
    SharedPreferences f3057j;
    /* renamed from: k */
    private final aq f3058k = new aq();
    /* renamed from: l */
    private final OrientationEventListener f3059l;

    /* compiled from: Client */
    /* renamed from: com.bugsnag.android.j$1 */
    class C10831 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1089j f3039a;

        C10831(C1089j c1089j) {
            this.f3039a = c1089j;
        }

        public void run() {
            this.f3039a.f3049b.registerReceiver(this.f3039a.f3055h, C1106v.m3923a());
            this.f3039a.f3049b.registerReceiver(new C1088a(this.f3039a), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* compiled from: Client */
    /* renamed from: com.bugsnag.android.j$3 */
    class C10853 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1089j f3042a;

        C10853(C1089j c1089j) {
            this.f3042a = c1089j;
        }

        public void run() {
            this.f3042a.m3805b();
        }
    }

    /* compiled from: Client */
    /* renamed from: com.bugsnag.android.j$a */
    class C1088a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C1089j f3047a;

        C1088a(C1089j c1089j) {
            this.f3047a = c1089j;
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                context = connectivityManager.getActiveNetworkInfo();
                context = (context == null || context.isConnectedOrConnecting() == null) ? null : true;
                if (context != null) {
                    this.f3047a.f3053f.m11086b();
                }
            }
        }
    }

    public C1089j(android.content.Context r5, com.bugsnag.android.C1091l r6) {
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
        r4 = this;
        r4.<init>();
        r0 = new com.bugsnag.android.aq;
        r0.<init>();
        r4.f3058k = r0;
        com.bugsnag.android.C1089j.m3786a(r5);
        r5 = r5.getApplicationContext();
        r4.f3049b = r5;
        r4.f3048a = r6;
        r5 = new com.bugsnag.android.ak;
        r0 = r4.f3048a;
        r1 = r4.f3049b;
        r5.<init>(r0, r1);
        r4.f3054g = r5;
        r5 = r4.f3049b;
        r0 = "connectivity";
        r5 = r5.getSystemService(r0);
        r5 = (android.net.ConnectivityManager) r5;
        r0 = r6.m3869v();
        if (r0 != 0) goto L_0x0038;
    L_0x0030:
        r0 = new com.bugsnag.android.n;
        r0.<init>(r5);
        r6.m3830a(r0);
    L_0x0038:
        r5 = new com.bugsnag.android.al;
        r0 = r4.f3054g;
        r5.<init>(r6, r4, r0);
        r4.f3056i = r5;
        r5 = new com.bugsnag.android.v;
        r5.<init>(r4);
        r4.f3055h = r5;
        r5 = r4.f3049b;
        r0 = "com.bugsnag.android";
        r1 = 0;
        r5 = r5.getSharedPreferences(r0, r1);
        r4.f3057j = r5;
        r5 = new com.bugsnag.android.a;
        r5.<init>(r4);
        r4.f3051d = r5;
        r5 = new com.bugsnag.android.r;
        r5.<init>(r4);
        r4.f3050c = r5;
        r5 = new com.bugsnag.android.Breadcrumbs;
        r5.<init>(r6);
        r4.f3052e = r5;
        r5 = r4.f3048a;
        r5 = r5.m3854h();
        r6 = 1;
        if (r5 != 0) goto L_0x007e;
    L_0x0071:
        r5 = new java.lang.String[r6];
        r0 = r4.f3049b;
        r0 = r0.getPackageName();
        r5[r1] = r0;
        r4.m3810c(r5);
    L_0x007e:
        r5 = r4.f3050c;
        r5 = r5.m3900d();
        r0 = r4.f3048a;
        r0 = r0.m3863p();
        r1 = 0;
        if (r0 == 0) goto L_0x00b5;
    L_0x008d:
        r0 = r4.f3058k;
        r2 = r4.f3057j;
        r3 = "user.id";
        r5 = r2.getString(r3, r5);
        r0.m11053a(r5);
        r5 = r4.f3058k;
        r0 = r4.f3057j;
        r2 = "user.name";
        r0 = r0.getString(r2, r1);
        r5.m11057c(r0);
        r5 = r4.f3058k;
        r0 = r4.f3057j;
        r2 = "user.email";
        r0 = r0.getString(r2, r1);
        r5.m11055b(r0);
        goto L_0x00ba;
    L_0x00b5:
        r0 = r4.f3058k;
        r0.m11053a(r5);
    L_0x00ba:
        r5 = r4.f3049b;
        r5 = r5 instanceof android.app.Application;
        if (r5 == 0) goto L_0x00ca;
    L_0x00c0:
        r5 = r4.f3049b;
        r5 = (android.app.Application) r5;
        r0 = r4.f3056i;
        r5.registerActivityLifecycleCallbacks(r0);
        goto L_0x00cf;
    L_0x00ca:
        r5 = "Bugsnag is unable to setup automatic activity lifecycle breadcrumbs on API Levels below 14.";
        com.bugsnag.android.ad.m3736b(r5);
    L_0x00cf:
        r5 = r4.f3048a;
        r5 = r5.m3849f();
        if (r5 != 0) goto L_0x00ff;
    L_0x00d7:
        r5 = r4.f3049b;	 Catch:{ Exception -> 0x00f2 }
        r5 = r5.getPackageManager();	 Catch:{ Exception -> 0x00f2 }
        r0 = r4.f3049b;	 Catch:{ Exception -> 0x00f2 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00f2 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x00f2 }
        r5 = r5.getApplicationInfo(r0, r2);	 Catch:{ Exception -> 0x00f2 }
        r5 = r5.metaData;	 Catch:{ Exception -> 0x00f2 }
        r0 = "com.bugsnag.android.BUILD_UUID";	 Catch:{ Exception -> 0x00f2 }
        r5 = r5.getString(r0);	 Catch:{ Exception -> 0x00f2 }
        goto L_0x00f8;
    L_0x00f2:
        r5 = "Bugsnag is unable to read build UUID from manifest.";
        com.bugsnag.android.ad.m3736b(r5);
        r5 = r1;
    L_0x00f8:
        if (r5 == 0) goto L_0x00ff;
    L_0x00fa:
        r0 = r4.f3048a;
        r0.m3847e(r5);
    L_0x00ff:
        r5 = new com.bugsnag.android.u;
        r0 = r4.f3048a;
        r1 = r4.f3049b;
        r5.<init>(r0, r1);
        r4.f3053f = r5;
        r5 = r4.f3048a;
        r5 = r5.m3858k();
        if (r5 == 0) goto L_0x0115;
    L_0x0112:
        r4.m3823l();
    L_0x0115:
        r5 = new com.bugsnag.android.j$1;	 Catch:{ RejectedExecutionException -> 0x011e }
        r5.<init>(r4);	 Catch:{ RejectedExecutionException -> 0x011e }
        com.bugsnag.android.C1076b.m3764a(r5);	 Catch:{ RejectedExecutionException -> 0x011e }
        goto L_0x0124;
    L_0x011e:
        r5 = move-exception;
        r0 = "Failed to register for automatic breadcrumb broadcasts";
        com.bugsnag.android.ad.m3733a(r0, r5);
    L_0x0124:
        r5 = "production";
        r0 = r4.f3051d;
        r0 = r0.m3706f();
        r5 = r5.equals(r0);
        r5 = r5 ^ r6;
        com.bugsnag.android.ad.m3734a(r5);
        r5 = r4.f3048a;
        r5.addObserver(r4);
        r5 = r4.f3052e;
        r5.addObserver(r4);
        r5 = r4.f3056i;
        r5.addObserver(r4);
        r5 = r4.f3058k;
        r5.addObserver(r4);
        r5 = new com.bugsnag.android.j$2;
        r6 = r4.f3049b;
        r5.<init>(r4, r6, r4);
        r4.f3059l = r5;
        r5 = r4.f3059l;	 Catch:{ IllegalStateException -> 0x0157 }
        r5.enable();	 Catch:{ IllegalStateException -> 0x0157 }
        goto L_0x016c;
    L_0x0157:
        r5 = move-exception;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = "Failed to set up orientation tracking: ";
        r6.append(r0);
        r6.append(r5);
        r5 = r6.toString();
        com.bugsnag.android.ad.m3736b(r5);
    L_0x016c:
        r5 = r4.f3053f;
        r5.m11082a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.j.<init>(android.content.Context, com.bugsnag.android.l):void");
    }

    /* renamed from: a */
    void m3793a() {
        setChanged();
        super.notifyObservers(new C1068a(C1069b.INSTALL, this.f3048a));
        try {
            C1076b.m3764a(new C10853(this));
        } catch (Throwable e) {
            ad.m3733a("Failed to enqueue native reports, will retry next launch: ", e);
        }
    }

    /* renamed from: b */
    void m3805b() {
        setChanged();
        notifyObservers(new C1068a(C1069b.DELIVER_PENDING, null));
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof C1068a) != null) {
            setChanged();
            super.notifyObservers(obj);
        }
    }

    /* renamed from: c */
    public void m3808c() {
        this.f3056i.m3748a(false);
    }

    /* renamed from: d */
    public final void m3811d() {
        this.f3056i.m3749a();
    }

    /* renamed from: e */
    public final boolean m3814e() {
        return this.f3056i.m3752b();
    }

    /* renamed from: a */
    public void m3796a(String str) {
        this.f3048a.m3831a(str);
    }

    /* renamed from: f */
    public String m3815f() {
        return this.f3048a.m3839c();
    }

    /* renamed from: b */
    public void m3806b(String str) {
        this.f3048a.m3836b(str);
    }

    /* renamed from: a */
    public void m3804a(String... strArr) {
        this.f3048a.m3834a(strArr);
    }

    /* renamed from: b */
    public void m3807b(String... strArr) {
        this.f3048a.m3838b(strArr);
    }

    /* renamed from: c */
    public void m3810c(String... strArr) {
        this.f3048a.m3842c(strArr);
    }

    /* renamed from: c */
    public void m3809c(String str) {
        this.f3048a.m3850f(str);
        ad.m3734a("production".equals(str) ^ 1);
    }

    /* renamed from: a */
    public void m3803a(boolean z) {
        this.f3048a.m3841c(z);
        if (z) {
            this.f3056i.m3753c();
        }
    }

    /* renamed from: a */
    public void m3799a(String str, String str2, String str3) {
        m3812d(str);
        m3813e(str2);
        m3816f(str3);
    }

    /* renamed from: g */
    public aq m3817g() {
        return this.f3058k;
    }

    /* renamed from: h */
    public C1070a m3819h() {
        return this.f3051d;
    }

    /* renamed from: i */
    public C1099r m3820i() {
        return this.f3050c;
    }

    /* renamed from: j */
    public void m3821j() {
        this.f3058k.m11053a(ae.m3737a("id", this.f3050c.m3898b()));
        this.f3058k.m11055b(null);
        this.f3058k.m11057c(null);
        this.f3049b.getSharedPreferences("com.bugsnag.android", 0).edit().remove("user.id").remove("user.email").remove("user.name").apply();
    }

    /* renamed from: d */
    public void m3812d(String str) {
        this.f3058k.m11053a(str);
        if (this.f3048a.m3863p()) {
            m3789a("user.id", str);
        }
    }

    /* renamed from: e */
    public void m3813e(String str) {
        this.f3058k.m11055b(str);
        if (this.f3048a.m3863p()) {
            m3789a("user.email", str);
        }
    }

    /* renamed from: f */
    public void m3816f(String str) {
        this.f3058k.m11057c(str);
        if (this.f3048a.m3863p()) {
            m3789a("user.name", str);
        }
    }

    /* renamed from: a */
    public void m3800a(String str, String str2, StackTraceElement[] stackTraceElementArr, C1082i c1082i) {
        m3795a(new C1100a(this.f3048a, str, str2, stackTraceElementArr, this.f3056i, Thread.currentThread()).m3904a("handledException").m3905a(), C1096q.ASYNC, c1082i);
    }

    /* renamed from: a */
    void m3795a(final com.bugsnag.android.C3448s r5, com.bugsnag.android.C1096q r6, com.bugsnag.android.C1082i r7) {
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
        r4 = this;
        r0 = r5.m11075f();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r4.f3051d;
        r0 = r0.m3703b();
        r1 = "releaseStage";
        r1 = com.bugsnag.android.ae.m3737a(r1, r0);
        r2 = r4.f3048a;
        r1 = r2.m3851g(r1);
        if (r1 != 0) goto L_0x001c;
    L_0x001b:
        return;
    L_0x001c:
        r1 = r4.f3050c;
        r1 = r1.m3898b();
        r5.m11071b(r1);
        r1 = r5.m11069b();
        r1 = r1.f9164a;
        r2 = "device";
        r3 = r4.f3050c;
        r3 = r3.m3899c();
        r1.put(r2, r3);
        r5.m11068a(r0);
        r0 = r5.m11069b();
        r0 = r0.f9164a;
        r1 = "app";
        r2 = r4.f3051d;
        r2 = r2.m3704c();
        r0.put(r1, r2);
        r0 = r4.f3052e;
        r5.m11063a(r0);
        r0 = r4.f3058k;
        r5.m11066a(r0);
        r0 = r5.m11062a();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0070;
    L_0x005e:
        r0 = r4.f3048a;
        r0 = r0.m3839c();
        if (r0 == 0) goto L_0x0067;
    L_0x0066:
        goto L_0x006d;
    L_0x0067:
        r0 = r4.f3051d;
        r0 = r0.m3705e();
    L_0x006d:
        r5.m11067a(r0);
    L_0x0070:
        r0 = r4.m3792b(r5);
        if (r0 != 0) goto L_0x007c;
    L_0x0076:
        r5 = "Skipping notification - beforeNotify task returned false";
        com.bugsnag.android.ad.m3732a(r5);
        return;
    L_0x007c:
        r0 = new com.bugsnag.android.ai;
        r1 = r4.f3048a;
        r1 = r1.m3829a();
        r0.<init>(r1, r5);
        if (r7 == 0) goto L_0x008c;
    L_0x0089:
        r7.mo763a(r0);
    L_0x008c:
        r7 = r5.m11076g();
        r7 = r7.m11095b();
        if (r7 != 0) goto L_0x00ad;
    L_0x0096:
        r7 = r5.m11078i();
        if (r7 == 0) goto L_0x00ad;
    L_0x009c:
        r4.setChanged();
        r7 = new com.bugsnag.android.NativeInterface$a;
        r1 = com.bugsnag.android.NativeInterface.C1069b.NOTIFY_HANDLED;
        r2 = r5.m11072c();
        r7.<init>(r1, r2);
        r4.notifyObservers(r7);
    L_0x00ad:
        r7 = com.bugsnag.android.C1089j.C10875.f3046a;
        r6 = r6.ordinal();
        r6 = r7[r6];
        switch(r6) {
            case 1: goto L_0x00d8;
            case 2: goto L_0x00c4;
            case 3: goto L_0x00b9;
            default: goto L_0x00b8;
        };
    L_0x00b8:
        goto L_0x00db;
    L_0x00b9:
        r6 = r4.f3053f;
        r6.m3929a(r5);
        r5 = r4.f3053f;
        r5.m11086b();
        goto L_0x00db;
    L_0x00c4:
        r6 = new com.bugsnag.android.j$4;	 Catch:{ RejectedExecutionException -> 0x00cd }
        r6.<init>(r4, r0, r5);	 Catch:{ RejectedExecutionException -> 0x00cd }
        com.bugsnag.android.C1076b.m3764a(r6);	 Catch:{ RejectedExecutionException -> 0x00cd }
        goto L_0x00db;
    L_0x00cd:
        r6 = r4.f3053f;
        r6.m3929a(r5);
        r5 = "Exceeded max queue count, saving to disk to send later";
        com.bugsnag.android.ad.m3736b(r5);
        goto L_0x00db;
    L_0x00d8:
        r4.m3794a(r0, r5);
    L_0x00db:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.j.a(com.bugsnag.android.s, com.bugsnag.android.q, com.bugsnag.android.i):void");
    }

    /* renamed from: a */
    private void m3788a(C3448s c3448s) {
        this.f3052e.add(new Breadcrumb(c3448s.m11072c(), BreadcrumbType.ERROR, Collections.singletonMap(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, c3448s.m11073d())));
    }

    /* renamed from: a */
    public void m3802a(Throwable th, Map<String, Object> map, boolean z, C1082i c1082i) {
        String a = m3785a((Map) map, "severity", true);
        String a2 = m3785a((Map) map, "severityReason", true);
        map = m3785a((Map) map, "logLevel", false);
        ad.m3732a(String.format("Internal client notify, severity = '%s', severityReason = '%s'", new Object[]{a, a2}));
        m3795a(new C1100a(this.f3048a, th, this.f3056i, Thread.currentThread(), false).m3902a(Severity.fromString(a)).m3904a(a2).m3906b(map).m3905a(), z ? C1096q.SAME_THREAD : C1096q.ASYNC, c1082i);
    }

    /* renamed from: a */
    private String m3785a(Map<String, Object> map, String str, boolean z) {
        map = map.get(str);
        if (map instanceof String) {
            return (String) map;
        }
        if (!z) {
            return null;
        }
        z = new StringBuilder();
        z.append("Failed to set ");
        z.append(str);
        z.append(" in client data!");
        throw new IllegalStateException(z.toString());
    }

    /* renamed from: a */
    public void m3798a(String str, String str2, Object obj) {
        this.f3048a.m3860m().m11033a(str, str2, obj);
    }

    /* renamed from: k */
    public af m3822k() {
        return this.f3048a.m3860m();
    }

    /* renamed from: a */
    public void m3797a(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        Breadcrumb breadcrumb = new Breadcrumb(str, breadcrumbType, map);
        if (m3790a(breadcrumb) != null) {
            this.f3052e.add(breadcrumb);
        }
    }

    /* renamed from: l */
    public void m3823l() {
        C1107w.m3927a(this);
    }

    /* renamed from: m */
    public void m3824m() {
        C1107w.m3928b(this);
    }

    /* renamed from: a */
    void m3794a(ai aiVar, C3448s c3448s) {
        if (m3791a(aiVar)) {
            try {
                this.f3048a.m3869v().mo779a(aiVar, this.f3048a);
                ad.m3732a("Sent 1 new error to Bugsnag");
                m3788a(c3448s);
            } catch (ai aiVar2) {
                ad.m3733a("Could not send error(s) to Bugsnag, saving to disk to send later", aiVar2);
                this.f3053f.m3929a((C1071a) c3448s);
                m3788a(c3448s);
            } catch (ai aiVar22) {
                ad.m3733a("Problem sending error to Bugsnag", aiVar22);
            }
            return;
        }
        ad.m3732a("Skipping notification - beforeSend task returned false");
    }

    /* renamed from: a */
    void m3801a(Throwable th, Severity severity, af afVar, String str, String str2, Thread thread) {
        m3795a(new C1100a(this.f3048a, th, this.f3056i, thread, true).m3902a(severity).m3903a(afVar).m3904a(str).m3906b(str2).m3905a(), C1096q.ASYNC_WITH_CACHE, (C1082i) null);
    }

    /* renamed from: a */
    private boolean m3791a(ai aiVar) {
        for (C1079e a : this.f3048a.m3862o()) {
            try {
                if (!a.m3767a(aiVar)) {
                    return null;
                }
            } catch (Throwable th) {
                ad.m3733a("BeforeSend threw an Exception", th);
            }
        }
        return true;
    }

    /* renamed from: b */
    private boolean m3792b(C3448s c3448s) {
        for (C1077c a : this.f3048a.m3861n()) {
            try {
                if (!a.m3765a(c3448s)) {
                    return null;
                }
            } catch (Throwable th) {
                ad.m3733a("BeforeNotify threw an Exception", th);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m3790a(Breadcrumb breadcrumb) {
        for (C1078d a : this.f3048a.m3872y()) {
            try {
                if (!a.m3766a(breadcrumb)) {
                    return null;
                }
            } catch (Throwable th) {
                ad.m3733a("BeforeRecordBreadcrumb threw an Exception", th);
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m3789a(String str, String str2) {
        this.f3049b.getSharedPreferences("com.bugsnag.android", 0).edit().putString(str, str2).apply();
    }

    /* renamed from: n */
    C3449u m3825n() {
        return this.f3053f;
    }

    protected void finalize() {
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
        r2 = this;
        r0 = r2.f3055h;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        r0 = r2.f3049b;	 Catch:{ IllegalArgumentException -> 0x000c }
        r1 = r2.f3055h;	 Catch:{ IllegalArgumentException -> 0x000c }
        r0.unregisterReceiver(r1);	 Catch:{ IllegalArgumentException -> 0x000c }
        goto L_0x0011;
    L_0x000c:
        r0 = "Receiver not registered";
        com.bugsnag.android.ad.m3736b(r0);
    L_0x0011:
        super.finalize();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.j.finalize():void");
    }

    /* renamed from: a */
    private static void m3786a(Context context) {
        if ((context instanceof Application) == null) {
            ad.m3736b("Warning - Non-Application context detected! Please ensure that you are initializing Bugsnag from a custom Application class.");
        }
    }

    /* renamed from: o */
    public C1091l m3826o() {
        return this.f3048a;
    }

    /* renamed from: g */
    void m3818g(String str) {
        m3819h().m3702a(str);
    }
}
