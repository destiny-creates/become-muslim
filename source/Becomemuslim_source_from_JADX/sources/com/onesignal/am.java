package com.onesignal;

import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.onesignal.C5526p.C5521a;
import com.onesignal.C5526p.C5523d;
import com.onesignal.C5526p.C5525f;
import com.onesignal.aa.C5441a;
import com.onesignal.ab.C5442a;
import com.onesignal.ar.C5480a;
import com.onesignal.au.C5482a;
import com.onesignal.bj.C5495a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OneSignal */
public class am {
    /* renamed from: A */
    private static long f18374A = -1;
    /* renamed from: B */
    private static bd f18375B;
    /* renamed from: C */
    private static bb f18376C;
    /* renamed from: D */
    private static bc f18377D;
    /* renamed from: E */
    private static C5498d f18378E = new C6960c();
    /* renamed from: F */
    private static int f18379F;
    /* renamed from: G */
    private static al f18380G;
    /* renamed from: H */
    private static String f18381H;
    /* renamed from: I */
    private static boolean f18382I;
    /* renamed from: J */
    private static boolean f18383J;
    /* renamed from: K */
    private static boolean f18384K;
    /* renamed from: L */
    private static boolean f18385L;
    /* renamed from: M */
    private static C5525f f18386M;
    /* renamed from: N */
    private static Collection<JSONArray> f18387N = new ArrayList();
    /* renamed from: O */
    private static HashSet<String> f18388O = new HashSet();
    /* renamed from: P */
    private static C5461f f18389P;
    /* renamed from: Q */
    private static boolean f18390Q;
    /* renamed from: R */
    private static boolean f18391R;
    /* renamed from: S */
    private static boolean f18392S;
    /* renamed from: T */
    private static JSONObject f18393T;
    /* renamed from: U */
    private static boolean f18394U;
    /* renamed from: V */
    private static ah f18395V;
    /* renamed from: W */
    private static ag<Object, ai> f18396W;
    /* renamed from: X */
    private static OSSubscriptionState f18397X;
    /* renamed from: Y */
    private static ag<Object, ak> f18398Y;
    /* renamed from: Z */
    private static C5545z f18399Z;
    /* renamed from: a */
    static String f18400a;
    private static C5462g aa;
    private static au ab;
    private static int ac = 0;
    /* renamed from: b */
    static Context f18401b;
    /* renamed from: c */
    static boolean f18402c;
    /* renamed from: d */
    static ExecutorService f18403d;
    /* renamed from: e */
    public static ConcurrentLinkedQueue<Runnable> f18404e = new ConcurrentLinkedQueue();
    /* renamed from: f */
    static AtomicLong f18405f = new AtomicLong();
    /* renamed from: g */
    public static String f18406g = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
    /* renamed from: h */
    static boolean f18407h = true;
    /* renamed from: i */
    static C5456a f18408i;
    /* renamed from: j */
    static boolean f18409j;
    /* renamed from: k */
    static boolean f18410k = false;
    /* renamed from: l */
    static C5507k f18411l;
    /* renamed from: m */
    static ah f18412m;
    /* renamed from: n */
    static OSSubscriptionState f18413n;
    /* renamed from: o */
    private static C5460e f18414o;
    /* renamed from: p */
    private static C5460e f18415p;
    /* renamed from: q */
    private static String f18416q;
    /* renamed from: r */
    private static boolean f18417r;
    /* renamed from: s */
    private static C5464i f18418s = C5464i.NONE;
    /* renamed from: t */
    private static C5464i f18419t = C5464i.WARN;
    /* renamed from: u */
    private static String f18420u = null;
    /* renamed from: v */
    private static String f18421v = null;
    /* renamed from: w */
    private static int f18422w;
    /* renamed from: x */
    private static boolean f18423x;
    /* renamed from: y */
    private static C5463h f18424y;
    /* renamed from: z */
    private static long f18425z = 1;

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$1 */
    static class C54471 implements ThreadFactory {
        C54471() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            runnable = new StringBuilder();
            runnable.append("OS_PENDING_EXECUTOR_");
            runnable.append(thread.getId());
            thread.setName(runnable.toString());
            return thread;
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$2 */
    static class C54482 implements Runnable {
        C54482() {
        }

        public void run() {
            as.m23324m();
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$8 */
    static class C54548 implements Runnable {

        /* compiled from: OneSignal */
        /* renamed from: com.onesignal.am$8$1 */
        class C54531 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C54548 f18339a;

            C54531(C54548 c54548) {
                this.f18339a = c54548;
            }

            public void run() {
                am.m23143X();
            }
        }

        C54548() {
        }

        public void run() {
            if (am.m23244m() != null) {
                al.m23090a(new C54531(this));
            }
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$9 */
    static class C54559 implements Runnable {
        C54559() {
        }

        public void run() {
            am.m23143X();
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$a */
    public static class C5456a {
        /* renamed from: a */
        C5465j f18340a;
        /* renamed from: b */
        C5466k f18341b;
        /* renamed from: c */
        boolean f18342c;
        /* renamed from: d */
        boolean f18343d;
        /* renamed from: e */
        boolean f18344e;
        /* renamed from: f */
        boolean f18345f;
        /* renamed from: g */
        boolean f18346g;
        /* renamed from: h */
        C5467l f18347h;

        private C5456a() {
            this.f18347h = C5467l.InAppAlert;
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$b */
    public interface C5457b {
        /* renamed from: a */
        void m23109a(C5470o c5470o);

        /* renamed from: a */
        void m23110a(JSONObject jSONObject);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$c */
    public enum C5458c {
        VALIDATION,
        REQUIRES_EMAIL_AUTH,
        INVALID_OPERATION,
        NETWORK
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$d */
    public static class C5459d {
        /* renamed from: a */
        private C5458c f18353a;
        /* renamed from: b */
        private String f18354b;

        C5459d(C5458c c5458c, String str) {
            this.f18353a = c5458c;
            this.f18354b = str;
        }

        /* renamed from: a */
        public String m23111a() {
            return this.f18354b;
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$e */
    public interface C5460e {
        /* renamed from: a */
        void m23112a();

        /* renamed from: a */
        void m23113a(C5459d c5459d);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$f */
    public interface C5461f {
        /* renamed from: a */
        void m23114a(JSONObject jSONObject);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$g */
    private static class C5462g {
        /* renamed from: a */
        JSONArray f18355a;
        /* renamed from: b */
        boolean f18356b;
        /* renamed from: c */
        C5480a f18357c;

        C5462g(JSONArray jSONArray) {
            this.f18355a = jSONArray;
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$h */
    public interface C5463h {
        /* renamed from: a */
        void m23115a(String str, String str2);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$i */
    public enum C5464i {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$j */
    public interface C5465j {
        void notificationOpened(ad adVar);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$k */
    public interface C5466k {
        void notificationReceived(aa aaVar);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$l */
    public enum C5467l {
        None,
        InAppAlert,
        Notification
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$m */
    private static class C5468m implements Runnable {
        /* renamed from: a */
        private Runnable f18370a;
        /* renamed from: b */
        private long f18371b;

        C5468m(Runnable runnable) {
            this.f18370a = runnable;
        }

        public void run() {
            this.f18370a.run();
            am.m23204d(this.f18371b);
        }
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$n */
    public interface C5469n {
        /* renamed from: a */
        void m23118a(JSONObject jSONObject);

        /* renamed from: b */
        void m23119b(JSONObject jSONObject);
    }

    /* compiled from: OneSignal */
    /* renamed from: com.onesignal.am$o */
    public static class C5470o {
        /* renamed from: a */
        private String f18372a;
        /* renamed from: b */
        private int f18373b;

        C5470o(int i, String str) {
            this.f18372a = str;
            this.f18373b = i;
        }
    }

    /* renamed from: e */
    private static boolean m23213e(int i) {
        return i < -6;
    }

    /* renamed from: E */
    static /* synthetic */ int m23124E() {
        int i = ac;
        ac = i + 1;
        return i;
    }

    /* renamed from: h */
    private static ah m23225h(Context context) {
        if (context == null) {
            return null;
        }
        if (f18395V == null) {
            f18395V = new ah(false);
            f18395V.f18316a.m23073b(new OSPermissionChangedInternalObserver());
        }
        return f18395V;
    }

    /* renamed from: a */
    static ag<Object, ai> m23145a() {
        if (f18396W == null) {
            f18396W = new ag("onOSPermissionChanged", true);
        }
        return f18396W;
    }

    /* renamed from: i */
    private static OSSubscriptionState m23229i(Context context) {
        if (context == null) {
            return null;
        }
        if (f18397X == null) {
            f18397X = new OSSubscriptionState(false, m23225h(context).m23077b());
            m23225h(context).f18316a.m23072a(f18397X);
            f18397X.f18245a.m23073b(new OSSubscriptionChangedInternalObserver());
        }
        return f18397X;
    }

    /* renamed from: b */
    static ag<Object, ak> m23181b() {
        if (f18398Y == null) {
            f18398Y = new ag("onOSSubscriptionChanged", true);
        }
        return f18398Y;
    }

    /* renamed from: j */
    private static C5545z m23233j(Context context) {
        if (context == null) {
            return null;
        }
        if (f18399Z == null) {
            f18399Z = new C5545z(false);
            f18399Z.f18591a.m23073b(new C5544y());
        }
        return f18399Z;
    }

    /* renamed from: c */
    public static C5456a m23194c() {
        if (f18408i == null) {
            f18408i = new C5456a();
        }
        return f18408i;
    }

    /* renamed from: a */
    static void m23152a(Context context) {
        Object obj = f18401b == null ? 1 : null;
        f18401b = context.getApplicationContext();
        if (obj != null) {
            aq.m23284b();
        }
    }

    /* renamed from: a */
    public static void m23153a(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.onesignal.am.C5465j r11, com.onesignal.am.C5466k r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        m23152a(r8);
        r0 = f18410k;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r0 = m23207d();
        if (r0 != 0) goto L_0x0022;
    L_0x000d:
        r0 = com.onesignal.am.C5464i.VERBOSE;
        r1 = "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.";
        m23187b(r0, r1);
        r0 = new com.onesignal.k;
        r2 = r0;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        r2.<init>(r3, r4, r5, r6, r7);
        f18411l = r0;
        return;
    L_0x0022:
        r0 = m23194c();
        f18408i = r0;
        r0 = f18408i;
        r1 = 0;
        r0.f18346g = r1;
        r0 = f18408i;
        r0.f18340a = r11;
        r11 = f18408i;
        r11.f18341b = r12;
        r11 = f18417r;
        if (r11 != 0) goto L_0x003b;
    L_0x0039:
        f18416q = r9;
    L_0x003b:
        r9 = new com.onesignal.al;
        r9.<init>();
        f18380G = r9;
        r9 = f18380G;
        r9 = r9.m23106c();
        f18379F = r9;
        r9 = f18380G;
        r11 = f18379F;
        r9 = r9.m23104a(r8, r11, r10);
        f18422w = r9;
        r9 = f18422w;
        r11 = -999; // 0xfffffffffffffc19 float:NaN double:NaN;
        if (r9 != r11) goto L_0x005b;
    L_0x005a:
        return;
    L_0x005b:
        r9 = f18402c;
        if (r9 == 0) goto L_0x0069;
    L_0x005f:
        r8 = f18408i;
        r8 = r8.f18340a;
        if (r8 == 0) goto L_0x0068;
    L_0x0065:
        m23139T();
    L_0x0068:
        return;
    L_0x0069:
        r9 = r8 instanceof android.app.Activity;
        f18423x = r9;
        f18400a = r10;
        r10 = f18408i;
        r10 = r10.f18345f;
        m23206d(r10);
        r10 = 1;
        if (r9 == 0) goto L_0x0083;
    L_0x0079:
        r8 = (android.app.Activity) r8;
        com.onesignal.C5440a.f18258b = r8;
        r8 = f18401b;
        com.onesignal.C5542w.m23576a(r8);
        goto L_0x0085;
    L_0x0083:
        com.onesignal.C5440a.f18257a = r10;
    L_0x0085:
        r8 = android.os.SystemClock.elapsedRealtime();
        f18425z = r8;
        com.onesignal.as.m23316e();
        r8 = f18401b;
        r8 = (android.app.Application) r8;
        r9 = new com.onesignal.b;
        r9.<init>();
        r8.registerActivityLifecycleCallbacks(r9);
        r8 = "com.amazon.device.iap.PurchasingListener";	 Catch:{ ClassNotFoundException -> 0x00a8 }
        java.lang.Class.forName(r8);	 Catch:{ ClassNotFoundException -> 0x00a8 }
        r8 = new com.onesignal.bb;	 Catch:{ ClassNotFoundException -> 0x00a8 }
        r9 = f18401b;	 Catch:{ ClassNotFoundException -> 0x00a8 }
        r8.<init>(r9);	 Catch:{ ClassNotFoundException -> 0x00a8 }
        f18376C = r8;	 Catch:{ ClassNotFoundException -> 0x00a8 }
    L_0x00a8:
        r8 = m23237k();
        if (r8 == 0) goto L_0x00c6;
    L_0x00ae:
        r9 = f18400a;
        r8 = r8.equals(r9);
        if (r8 != 0) goto L_0x00d0;
    L_0x00b6:
        r8 = com.onesignal.am.C5464i.DEBUG;
        r9 = "APP ID changed, clearing user id as it is no longer valid.";
        m23187b(r8, r9);
        r8 = f18400a;
        m23239k(r8);
        com.onesignal.as.m23320i();
        goto L_0x00d0;
    L_0x00c6:
        r8 = f18401b;
        com.onesignal.C5504f.m23441a(r1, r8);
        r8 = f18400a;
        m23239k(r8);
    L_0x00d0:
        r8 = f18401b;
        r8 = m23225h(r8);
        com.onesignal.OSPermissionChangedInternalObserver.m23033a(r8);
        r8 = f18423x;
        if (r8 != 0) goto L_0x00e3;
    L_0x00dd:
        r8 = m23244m();
        if (r8 != 0) goto L_0x00f3;
    L_0x00e3:
        r8 = m23144Y();
        f18392S = r8;
        r8 = java.lang.System.currentTimeMillis();
        m23150a(r8);
        m23134O();
    L_0x00f3:
        r8 = f18408i;
        r8 = r8.f18340a;
        if (r8 == 0) goto L_0x00fc;
    L_0x00f9:
        m23139T();
    L_0x00fc:
        r8 = f18401b;
        r8 = com.onesignal.bd.m23361a(r8);
        if (r8 == 0) goto L_0x010d;
    L_0x0104:
        r8 = new com.onesignal.bd;
        r9 = f18401b;
        r8.<init>(r9);
        f18375B = r8;
    L_0x010d:
        r8 = com.onesignal.bc.m23349a();
        if (r8 == 0) goto L_0x011c;
    L_0x0113:
        r8 = new com.onesignal.bc;
        r9 = f18401b;
        r8.<init>(r9);
        f18377D = r8;
    L_0x011c:
        r8 = f18401b;
        com.onesignal.ax.m38542a(r8);
        f18402c = r10;
        m23132M();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.a(android.content.Context, java.lang.String, java.lang.String, com.onesignal.am$j, com.onesignal.am$k):void");
    }

    /* renamed from: d */
    private static void m23204d(long j) {
        if (f18405f.get() == j) {
            m23187b(C5464i.INFO, "Last Pending Task has ran, shutting down");
            f18403d.shutdown();
        }
    }

    /* renamed from: M */
    private static void m23132M() {
        if (!f18404e.isEmpty()) {
            f18403d = Executors.newSingleThreadExecutor(new C54471());
            while (!f18404e.isEmpty()) {
                f18403d.submit((Runnable) f18404e.poll());
            }
        }
    }

    /* renamed from: a */
    private static void m23163a(C5468m c5468m) {
        c5468m.f18371b = f18405f.incrementAndGet();
        C5464i c5464i;
        StringBuilder stringBuilder;
        if (f18403d == null) {
            c5464i = C5464i.INFO;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Adding a task to the pending queue with ID: ");
            stringBuilder.append(c5468m.f18371b);
            m23187b(c5464i, stringBuilder.toString());
            f18404e.add(c5468m);
        } else if (!f18403d.isShutdown()) {
            c5464i = C5464i.INFO;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Executor is still running, add to the executor with ID: ");
            stringBuilder.append(c5468m.f18371b);
            m23187b(c5464i, stringBuilder.toString());
            f18403d.submit(c5468m);
        }
    }

    /* renamed from: N */
    private static boolean m23133N() {
        if (f18402c && f18403d == null) {
            return false;
        }
        if (!f18402c && f18403d == null) {
            return true;
        }
        if (f18403d == null || f18403d.isShutdown()) {
            return false;
        }
        return true;
    }

    /* renamed from: O */
    private static void m23134O() {
        if (!f18391R) {
            boolean z = true;
            f18391R = true;
            f18382I = false;
            if (f18392S) {
                f18383J = false;
            }
            m23135P();
            m23138S();
            if (!f18385L) {
                if (!f18408i.f18342c) {
                    z = false;
                }
            }
            f18385L = z;
        }
    }

    /* renamed from: P */
    private static void m23135P() {
        C5523d anonymousClass12 = new C5523d() {
            /* renamed from: a */
            public C5521a mo4937a() {
                return C5521a.STARTUP;
            }

            /* renamed from: a */
            public void mo4938a(C5525f c5525f) {
                am.f18386M = c5525f;
                am.f18383J = true;
                am.m23141V();
            }
        };
        boolean z = f18408i.f18342c && !f18385L;
        C5526p.m23513a(f18401b, z, anonymousClass12);
    }

    /* renamed from: Q */
    private static au m23136Q() {
        if (ab != null) {
            return ab;
        }
        if (f18379F == 2) {
            ab = new av();
        } else if (al.m23091a()) {
            ab = new ax();
        } else {
            ab = new ay();
        }
        return ab;
    }

    /* renamed from: R */
    private static void m23137R() {
        m23136Q().mo4942a(f18401b, f18416q, new C5482a() {
            /* renamed from: a */
            public void mo4939a(String str, int i) {
                if (i < 1) {
                    if (as.m23319h() == null && (am.f18422w == 1 || am.m23213e(am.f18422w))) {
                        am.f18422w = i;
                    }
                } else if (am.m23213e(am.f18422w)) {
                    am.f18422w = i;
                }
                am.f18381H = str;
                am.f18382I = true;
                am.m23229i(am.f18401b).m23041b(str);
                am.m23141V();
            }
        });
    }

    /* renamed from: S */
    private static void m23138S() {
        if (f18384K) {
            m23137R();
            return;
        }
        C5480a anonymousClass18 = new C5480a() {

            /* compiled from: OneSignal */
            /* renamed from: com.onesignal.am$18$1 */
            class C54461 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass18 f18328a;

                C54461(AnonymousClass18 anonymousClass18) {
                    this.f18328a = anonymousClass18;
                }

                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r4 = this;
                    r0 = com.onesignal.am.ac;	 Catch:{ Throwable -> 0x0031 }
                    r0 = r0 * 10000;	 Catch:{ Throwable -> 0x0031 }
                    r0 = r0 + 30000;	 Catch:{ Throwable -> 0x0031 }
                    r1 = 90000; // 0x15f90 float:1.26117E-40 double:4.4466E-319;	 Catch:{ Throwable -> 0x0031 }
                    if (r0 <= r1) goto L_0x0010;	 Catch:{ Throwable -> 0x0031 }
                L_0x000d:
                    r0 = 90000; // 0x15f90 float:1.26117E-40 double:4.4466E-319;	 Catch:{ Throwable -> 0x0031 }
                L_0x0010:
                    r1 = com.onesignal.am.C5464i.INFO;	 Catch:{ Throwable -> 0x0031 }
                    r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0031 }
                    r2.<init>();	 Catch:{ Throwable -> 0x0031 }
                    r3 = "Failed to get Android parameters, trying again in ";	 Catch:{ Throwable -> 0x0031 }
                    r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
                    r3 = r0 / 1000;	 Catch:{ Throwable -> 0x0031 }
                    r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
                    r3 = " seconds.";	 Catch:{ Throwable -> 0x0031 }
                    r2.append(r3);	 Catch:{ Throwable -> 0x0031 }
                    r2 = r2.toString();	 Catch:{ Throwable -> 0x0031 }
                    com.onesignal.am.m23187b(r1, r2);	 Catch:{ Throwable -> 0x0031 }
                    r0 = (long) r0;	 Catch:{ Throwable -> 0x0031 }
                    java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0031 }
                L_0x0031:
                    com.onesignal.am.m23124E();
                    com.onesignal.am.m23138S();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.18.1.run():void");
                }
            }

            /* renamed from: a */
            void mo4936a(int i, String str, Throwable th) {
                new Thread(new C54461(this), "OS_PARAMS_REQUEST").start();
            }

            /* renamed from: a */
            void mo4940a(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("android_sender_id") != null) {
                        am.f18417r = true;
                        am.f18416q = jSONObject.getString("android_sender_id");
                    }
                    am.f18409j = jSONObject.optBoolean("enterp", false);
                    am.f18394U = jSONObject.optBoolean("use_email_auth", false);
                    am.f18393T = jSONObject.getJSONObject("awl_list");
                    aq.m23280a(aq.f18435a, "GT_FIREBASE_TRACKING_ENABLED", jSONObject.optBoolean("fba", false));
                    C5530r.m23553a(am.f18401b, jSONObject);
                } catch (String str2) {
                    str2.printStackTrace();
                }
                am.f18384K = true;
                am.m23137R();
            }
        };
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apps/");
        stringBuilder.append(f18400a);
        stringBuilder.append("/android_params.js");
        String stringBuilder2 = stringBuilder.toString();
        String m = m23244m();
        if (m != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("?player_id=");
            stringBuilder3.append(m);
            stringBuilder2 = stringBuilder3.toString();
        }
        m23187b(C5464i.DEBUG, "Starting request to get Android parameters.");
        ar.m23291a(stringBuilder2, anonymousClass18);
    }

    /* renamed from: T */
    private static void m23139T() {
        for (JSONArray b : f18387N) {
            m23190b(b, true, false);
        }
        f18387N.clear();
    }

    /* renamed from: a */
    public static void m23160a(C5464i c5464i, String str) {
        m23187b(c5464i, str);
    }

    /* renamed from: d */
    public static boolean m23207d() {
        return m23242l();
    }

    /* renamed from: a */
    public static void m23175a(boolean z) {
        boolean d = m23207d();
        m23199c(z);
        if (!d && z && f18411l) {
            m23153a(f18411l.f18519a, f18411l.f18520b, f18411l.f18521c, f18411l.f18522d, f18411l.f18523e);
            f18411l = false;
        }
    }

    /* renamed from: b */
    public static void m23191b(boolean z) {
        if (!f18410k || z) {
            f18410k = z;
        } else {
            m23187b(C5464i.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    /* renamed from: a */
    static boolean m23179a(String str) {
        if (!f18410k || m23207d()) {
            return null;
        }
        if (str != null) {
            C5464i c5464i = C5464i.WARN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(str);
            stringBuilder.append(" was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
            m23187b(c5464i, stringBuilder.toString());
        }
        return true;
    }

    /* renamed from: a */
    public static void m23159a(C5464i c5464i, C5464i c5464i2) {
        f18419t = c5464i;
        f18418s = c5464i2;
    }

    /* renamed from: a */
    public static void m23149a(int i, int i2) {
        m23159a(m23216f(i), m23216f(i2));
    }

    /* renamed from: f */
    private static C5464i m23216f(int i) {
        switch (i) {
            case 0:
                return C5464i.NONE;
            case 1:
                return C5464i.FATAL;
            case 2:
                return C5464i.ERROR;
            case 3:
                return C5464i.WARN;
            case 4:
                return C5464i.INFO;
            case 5:
                return C5464i.DEBUG;
            case 6:
                return C5464i.VERBOSE;
            default:
                if (i < 0) {
                    return C5464i.NONE;
                }
                return C5464i.VERBOSE;
        }
    }

    /* renamed from: a */
    private static boolean m23178a(C5464i c5464i) {
        if (c5464i.compareTo(f18418s) >= 1) {
            return c5464i.compareTo(f18419t) < 1;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    static void m23187b(C5464i c5464i, String str) {
        m23161a(c5464i, str, null);
    }

    /* renamed from: a */
    static void m23161a(final C5464i c5464i, String str, Throwable th) {
        if (c5464i.compareTo(f18419t) < 1) {
            if (c5464i == C5464i.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (c5464i == C5464i.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (c5464i == C5464i.INFO) {
                Log.i("OneSignal", str, th);
            } else if (c5464i == C5464i.WARN) {
                Log.w("OneSignal", str, th);
            } else if (c5464i == C5464i.ERROR || c5464i == C5464i.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (c5464i.compareTo(f18418s) < 1 && C5440a.f18258b != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                str = stringBuilder.toString();
                if (th != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(th.getMessage());
                    str = stringBuilder.toString();
                    Writer stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    th = new StringBuilder();
                    th.append(str);
                    th.append(stringWriter.toString());
                    str = th.toString();
                }
                al.m23090a(new Runnable() {
                    public void run() {
                        if (C5440a.f18258b != null) {
                            new Builder(C5440a.f18258b).setTitle(c5464i.toString()).setMessage(str).show();
                        }
                    }
                });
            } catch (C5464i c5464i2) {
                Log.e("OneSignal", "Error showing logging message.", c5464i2);
            }
        }
    }

    /* renamed from: b */
    private static void m23189b(String str, int i, Throwable th, String str2) {
        String str3 = "";
        if (str2 != null && m23178a(C5464i.INFO)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder.append(str2);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            str3 = stringBuilder.toString();
        }
        C5464i c5464i = C5464i.WARN;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("HTTP code: ");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(str);
        stringBuilder2.append(str3);
        m23161a(c5464i, stringBuilder2.toString(), th);
    }

    /* renamed from: e */
    static boolean m23212e() {
        boolean z = false;
        f18423x = false;
        C5526p.m23519c();
        if (!f18402c) {
            return false;
        }
        if (f18376C != null) {
            f18376C.m23345a();
        }
        if (f18425z == -1) {
            return false;
        }
        long elapsedRealtime = (long) ((((double) (SystemClock.elapsedRealtime() - f18425z)) / 1000.0d) + 0.5d);
        f18425z = SystemClock.elapsedRealtime();
        if (elapsedRealtime >= 0) {
            if (elapsedRealtime <= 86400) {
                if (f18401b == null) {
                    m23187b(C5464i.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                    return false;
                }
                boolean f = m23219f();
                m23150a(System.currentTimeMillis());
                long t = m23256t() + elapsedRealtime;
                m23209e(t);
                int i = (t > 60 ? 1 : (t == 60 ? 0 : -1));
                if (i >= 0) {
                    if (m23244m() != null) {
                        if (!f) {
                            at.m23328a(f18401b);
                        }
                        at.m23327a();
                        return false;
                    }
                }
                if (i >= 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: f */
    static boolean m23219f() {
        boolean c = as.m23313c();
        if (c) {
            at.m23328a(f18401b);
        }
        if (!C5526p.m23515a(f18401b)) {
            if (!c) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static void m23151a(long j, boolean z) {
        try {
            JSONObject put = new JSONObject().put("app_id", f18400a).put("type", 1).put(ServerProtocol.DIALOG_PARAM_STATE, "ping").put("active_time", j);
            m23198c(put);
            m23168a(m23244m(), put, z);
            String n = m23248n();
            if (n != null) {
                m23168a(n, put, z);
            }
        } catch (Throwable th) {
            m23161a(C5464i.ERROR, "Generating on_focus:JSON Failed.", th);
        }
    }

    /* renamed from: a */
    private static void m23168a(String str, JSONObject jSONObject, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        stringBuilder.append("/on_focus");
        str = stringBuilder.toString();
        C5480a anonymousClass20 = new C5480a() {
            /* renamed from: a */
            void mo4936a(int i, String str, Throwable th) {
                am.m23189b("sending on_focus Failed", i, th, str);
            }

            /* renamed from: a */
            void mo4940a(String str) {
                am.m23209e(0);
            }
        };
        if (z) {
            ar.m23300d(str, jSONObject, anonymousClass20);
        } else {
            ar.m23296b(str, jSONObject, anonymousClass20);
        }
    }

    /* renamed from: g */
    static void m23222g() {
        f18423x = true;
        C5526p.m23519c();
        f18425z = SystemClock.elapsedRealtime();
        f18392S = m23144Y();
        m23150a(System.currentTimeMillis());
        m23134O();
        if (f18375B != null) {
            f18375B.m23374a();
        }
        C5542w.m23576a(f18401b);
        m23225h(f18401b).m23076a();
        if (f18377D != null && m23201c(f18401b)) {
            f18377D.m23352b();
        }
        at.m23331b(f18401b);
    }

    /* renamed from: h */
    static boolean m23228h() {
        return f18423x;
    }

    /* renamed from: c */
    private static void m23198c(org.json.JSONObject r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "net_type";	 Catch:{ Throwable -> 0x000b }
        r1 = f18380G;	 Catch:{ Throwable -> 0x000b }
        r1 = r1.m23107d();	 Catch:{ Throwable -> 0x000b }
        r2.put(r0, r1);	 Catch:{ Throwable -> 0x000b }
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.c(org.json.JSONObject):void");
    }

    /* renamed from: U */
    private static int m23140U() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    /* renamed from: V */
    private static void m23141V() {
        C5464i c5464i = C5464i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("registerUser: registerForPushFired:");
        stringBuilder.append(f18382I);
        stringBuilder.append(", locationFired: ");
        stringBuilder.append(f18383J);
        stringBuilder.append(", awlFired: ");
        stringBuilder.append(f18384K);
        m23187b(c5464i, stringBuilder.toString());
        if (f18382I && f18383J) {
            if (f18384K) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            am.m23142W();
                            an.m23263a(am.f18401b, am.f18400a, am.f18420u, C6960c.m32667a());
                        } catch (Throwable e) {
                            am.m23161a(C5464i.FATAL, "FATAL Error registering device!", e);
                        }
                    }
                }, "OS_REG_USER").start();
            }
        }
    }

    /* renamed from: W */
    private static void m23142W() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f18401b;
        r0 = r0.getPackageName();
        r1 = f18401b;
        r1 = r1.getPackageManager();
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "app_id";
        r4 = f18400a;
        r2.put(r3, r4);
        r3 = f18378E;
        r4 = f18401b;
        r3 = r3.mo4960a(r4);
        if (r3 == 0) goto L_0x0027;
    L_0x0022:
        r4 = "ad_id";
        r2.put(r4, r3);
    L_0x0027:
        r3 = "device_os";
        r4 = android.os.Build.VERSION.RELEASE;
        r2.put(r3, r4);
        r3 = "timezone";
        r4 = m23140U();
        r2.put(r3, r4);
        r3 = "language";
        r4 = com.onesignal.al.m23099f();
        r2.put(r3, r4);
        r3 = "sdk";
        r4 = "031005";
        r2.put(r3, r4);
        r3 = "sdk_type";
        r4 = f18406g;
        r2.put(r3, r4);
        r3 = "android_package";
        r2.put(r3, r0);
        r3 = "device_model";
        r4 = android.os.Build.MODEL;
        r2.put(r3, r4);
        r3 = 0;
        r4 = "game_version";	 Catch:{ NameNotFoundException -> 0x0066 }
        r0 = r1.getPackageInfo(r0, r3);	 Catch:{ NameNotFoundException -> 0x0066 }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x0066 }
        r2.put(r4, r0);	 Catch:{ NameNotFoundException -> 0x0066 }
    L_0x0066:
        r0 = r1.getInstalledPackages(r3);	 Catch:{ Throwable -> 0x00a7 }
        r1 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00a7 }
        r1.<init>();	 Catch:{ Throwable -> 0x00a7 }
        r4 = "SHA-256";	 Catch:{ Throwable -> 0x00a7 }
        r4 = java.security.MessageDigest.getInstance(r4);	 Catch:{ Throwable -> 0x00a7 }
        r5 = 0;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0076:
        r6 = r0.size();	 Catch:{ Throwable -> 0x00a7 }
        if (r5 >= r6) goto L_0x00a2;	 Catch:{ Throwable -> 0x00a7 }
    L_0x007c:
        r6 = r0.get(r5);	 Catch:{ Throwable -> 0x00a7 }
        r6 = (android.content.pm.PackageInfo) r6;	 Catch:{ Throwable -> 0x00a7 }
        r6 = r6.packageName;	 Catch:{ Throwable -> 0x00a7 }
        r6 = r6.getBytes();	 Catch:{ Throwable -> 0x00a7 }
        r4.update(r6);	 Catch:{ Throwable -> 0x00a7 }
        r6 = r4.digest();	 Catch:{ Throwable -> 0x00a7 }
        r7 = 2;	 Catch:{ Throwable -> 0x00a7 }
        r6 = android.util.Base64.encodeToString(r6, r7);	 Catch:{ Throwable -> 0x00a7 }
        r7 = f18393T;	 Catch:{ Throwable -> 0x00a7 }
        r7 = r7.has(r6);	 Catch:{ Throwable -> 0x00a7 }
        if (r7 == 0) goto L_0x009f;	 Catch:{ Throwable -> 0x00a7 }
    L_0x009c:
        r1.put(r6);	 Catch:{ Throwable -> 0x00a7 }
    L_0x009f:
        r5 = r5 + 1;	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x0076;	 Catch:{ Throwable -> 0x00a7 }
    L_0x00a2:
        r0 = "pkgs";	 Catch:{ Throwable -> 0x00a7 }
        r2.put(r0, r1);	 Catch:{ Throwable -> 0x00a7 }
    L_0x00a7:
        r0 = "net_type";
        r1 = f18380G;
        r1 = r1.m23107d();
        r2.put(r0, r1);
        r0 = "carrier";
        r1 = f18380G;
        r1 = r1.m23108e();
        r2.put(r0, r1);
        r0 = "rooted";
        r1 = com.onesignal.ba.m23343a();
        r2.put(r0, r1);
        com.onesignal.as.m23305a(r2);
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "identifier";
        r2 = f18381H;
        r0.put(r1, r2);
        r1 = "subscribableStatus";
        r2 = f18422w;
        r0.put(r1, r2);
        r1 = "androidPermission";
        r2 = m23259w();
        r0.put(r1, r2);
        r1 = "device_type";
        r2 = f18379F;
        r0.put(r1, r2);
        com.onesignal.as.m23310b(r0);
        r0 = f18407h;
        if (r0 == 0) goto L_0x00fc;
    L_0x00f3:
        r0 = f18386M;
        if (r0 == 0) goto L_0x00fc;
    L_0x00f7:
        r0 = f18386M;
        com.onesignal.as.m23302a(r0);
    L_0x00fc:
        r0 = f18392S;
        if (r0 == 0) goto L_0x0103;
    L_0x0100:
        com.onesignal.as.m23322k();
    L_0x0103:
        f18391R = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.W():void");
    }

    @Deprecated
    /* renamed from: b */
    public static void m23188b(final String str) {
        if (!m23179a("SyncHashedEmail()") && al.m23093a(str)) {
            Runnable anonymousClass22 = new Runnable() {
                public void run() {
                    as.m23303a(str.trim().toLowerCase());
                }
            };
            if (f18401b != null) {
                if (m23133N() == null) {
                    anonymousClass22.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "You should initialize OneSignal before calling syncHashedEmail! Moving this operation to a pending task queue.");
            m23163a(new C5468m(anonymousClass22));
        }
    }

    /* renamed from: a */
    public static void m23167a(final String str, final String str2, C5460e c5460e) {
        if (!m23179a("setEmail()")) {
            if (!al.m23093a(str)) {
                str = "Email is invalid";
                if (c5460e != null) {
                    c5460e.m23113a(new C5459d(C5458c.VALIDATION, str));
                }
                m23187b(C5464i.ERROR, str);
            } else if (f18394U && str2 == null) {
                str = "Email authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard.";
                if (c5460e != null) {
                    c5460e.m23113a(new C5459d(C5458c.REQUIRES_EMAIL_AUTH, str));
                }
                m23187b(C5464i.ERROR, str);
            } else {
                f18414o = c5460e;
                c5460e = new Runnable() {
                    public void run() {
                        String trim = str.trim();
                        String str = str2;
                        if (str != null) {
                            str.toLowerCase();
                        }
                        am.m23233j(am.f18401b).m23589b(trim);
                        as.m23304a(trim.toLowerCase(), str);
                    }
                };
                if (f18401b != null) {
                    if (m23133N() == null) {
                        c5460e.run();
                        return;
                    }
                }
                m23187b(C5464i.ERROR, "You should initialize OneSignal before calling setEmail! Moving this operation to a pending task queue.");
                m23163a(new C5468m(c5460e));
            }
        }
    }

    /* renamed from: a */
    public static void m23156a(C5460e c5460e) {
        if (!m23179a("logoutEmail()")) {
            if (m23248n() == null) {
                if (c5460e != null) {
                    c5460e.m23113a(new C5459d(C5458c.INVALID_OPERATION, "logoutEmail not valid as email was not set or already logged out!"));
                }
                m23187b(C5464i.ERROR, "logoutEmail not valid as email was not set or already logged out!");
                return;
            }
            f18415p = c5460e;
            c5460e = new C54482();
            if (f18401b != null) {
                if (!m23133N()) {
                    c5460e.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "You should initialize OneSignal before calling logoutEmail! Moving this operation to a pending task queue.");
            m23163a(new C5468m(c5460e));
        }
    }

    /* renamed from: c */
    public static void m23197c(final String str) {
        if (!m23179a("setExternalId()")) {
            Runnable c54493 = new Runnable() {
                public void run() {
                    try {
                        as.m23309b(str);
                    } catch (JSONException e) {
                        String str = str == "" ? "remove" : "set";
                        C5464i c5464i = C5464i.ERROR;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Attempted to ");
                        stringBuilder.append(str);
                        stringBuilder.append(" external ID but encountered a JSON exception");
                        am.m23160a(c5464i, stringBuilder.toString());
                        e.printStackTrace();
                    }
                }
            };
            if (f18401b != null) {
                if (m23133N() == null) {
                    c54493.run();
                    return;
                }
            }
            m23163a(new C5468m(c54493));
        }
    }

    /* renamed from: i */
    public static void m23231i() {
        if (!m23179a("removeExternalUserId()")) {
            m23197c("");
        }
    }

    /* renamed from: a */
    public static void m23166a(String str, String str2) {
        if (!m23179a("sendTag()")) {
            try {
                m23172a(new JSONObject().put(str, str2));
            } catch (String str3) {
                str3.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m23172a(JSONObject jSONObject) {
        m23173a(jSONObject, null);
    }

    /* renamed from: a */
    public static void m23173a(final JSONObject jSONObject, final C5457b c5457b) {
        if (!m23179a("sendTags()")) {
            Runnable c54504 = new Runnable() {
                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r7 = this;
                    r0 = r3;
                    if (r0 != 0) goto L_0x0016;
                L_0x0004:
                    r0 = r4;
                    if (r0 == 0) goto L_0x0015;
                L_0x0008:
                    r0 = r4;
                    r1 = new com.onesignal.am$o;
                    r2 = -1;
                    r3 = "Attempted to send null tags";
                    r1.<init>(r2, r3);
                    r0.m23109a(r1);
                L_0x0015:
                    return;
                L_0x0016:
                    r0 = 0;
                    r0 = com.onesignal.as.m23314d(r0);
                    r0 = r0.f18503b;
                    r1 = new org.json.JSONObject;
                    r1.<init>();
                    r2 = r3;
                    r2 = r2.keys();
                L_0x0028:
                    r3 = r2.hasNext();
                    if (r3 == 0) goto L_0x0088;
                L_0x002e:
                    r3 = r2.next();
                    r3 = (java.lang.String) r3;
                    r4 = r3;	 Catch:{ Throwable -> 0x0086 }
                    r4 = r4.opt(r3);	 Catch:{ Throwable -> 0x0086 }
                    r5 = r4 instanceof org.json.JSONArray;	 Catch:{ Throwable -> 0x0086 }
                    if (r5 != 0) goto L_0x006a;	 Catch:{ Throwable -> 0x0086 }
                L_0x003e:
                    r5 = r4 instanceof org.json.JSONObject;	 Catch:{ Throwable -> 0x0086 }
                    if (r5 == 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0086 }
                L_0x0042:
                    goto L_0x006a;	 Catch:{ Throwable -> 0x0086 }
                L_0x0043:
                    r5 = r3;	 Catch:{ Throwable -> 0x0086 }
                    r5 = r5.isNull(r3);	 Catch:{ Throwable -> 0x0086 }
                    if (r5 != 0) goto L_0x005c;	 Catch:{ Throwable -> 0x0086 }
                L_0x004b:
                    r5 = "";	 Catch:{ Throwable -> 0x0086 }
                    r5 = r5.equals(r4);	 Catch:{ Throwable -> 0x0086 }
                    if (r5 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x0086 }
                L_0x0053:
                    goto L_0x005c;	 Catch:{ Throwable -> 0x0086 }
                L_0x0054:
                    r4 = r4.toString();	 Catch:{ Throwable -> 0x0086 }
                    r1.put(r3, r4);	 Catch:{ Throwable -> 0x0086 }
                    goto L_0x0028;	 Catch:{ Throwable -> 0x0086 }
                L_0x005c:
                    if (r0 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0086 }
                L_0x005e:
                    r4 = r0.has(r3);	 Catch:{ Throwable -> 0x0086 }
                    if (r4 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0086 }
                L_0x0064:
                    r4 = "";	 Catch:{ Throwable -> 0x0086 }
                    r1.put(r3, r4);	 Catch:{ Throwable -> 0x0086 }
                    goto L_0x0028;	 Catch:{ Throwable -> 0x0086 }
                L_0x006a:
                    r4 = com.onesignal.am.C5464i.ERROR;	 Catch:{ Throwable -> 0x0086 }
                    r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0086 }
                    r5.<init>();	 Catch:{ Throwable -> 0x0086 }
                    r6 = "Omitting key '";	 Catch:{ Throwable -> 0x0086 }
                    r5.append(r6);	 Catch:{ Throwable -> 0x0086 }
                    r5.append(r3);	 Catch:{ Throwable -> 0x0086 }
                    r3 = "'! sendTags DO NOT supported nested values!";	 Catch:{ Throwable -> 0x0086 }
                    r5.append(r3);	 Catch:{ Throwable -> 0x0086 }
                    r3 = r5.toString();	 Catch:{ Throwable -> 0x0086 }
                    com.onesignal.am.m23187b(r4, r3);	 Catch:{ Throwable -> 0x0086 }
                    goto L_0x0028;
                    goto L_0x0028;
                L_0x0088:
                    r2 = r1.toString();
                    r3 = "{}";
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x009a;
                L_0x0094:
                    r0 = r4;
                    com.onesignal.as.m23306a(r1, r0);
                    goto L_0x00a3;
                L_0x009a:
                    r1 = r4;
                    if (r1 == 0) goto L_0x00a3;
                L_0x009e:
                    r1 = r4;
                    r1.m23110a(r0);
                L_0x00a3:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.4.run():void");
                }
            };
            if (f18401b != null) {
                if (m23133N() == null) {
                    c54504.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue.");
            if (c5457b != null) {
                c5457b.m23109a(new C5470o(-1, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue."));
            }
            m23163a(new C5468m(c54504));
        }
    }

    /* renamed from: a */
    public static void m23174a(JSONObject jSONObject, final C5469n c5469n) {
        if (!m23179a("postNotification()")) {
            try {
                if (!jSONObject.has("app_id")) {
                    jSONObject.put("app_id", m23237k());
                }
                ar.m23296b("notifications/", jSONObject, new C5480a() {
                    /* renamed from: a */
                    public void mo4940a(String str) {
                        C5464i c5464i = C5464i.DEBUG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("HTTP create notification success: ");
                        stringBuilder.append(str != null ? str : "null");
                        am.m23187b(c5464i, stringBuilder.toString());
                        if (c5469n != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("errors")) {
                                    c5469n.m23119b(jSONObject);
                                } else {
                                    c5469n.m23118a(new JSONObject(str));
                                }
                            } catch (String str2) {
                                str2.printStackTrace();
                            }
                        }
                    }

                    /* renamed from: a */
                    void mo4936a(int r2, java.lang.String r3, java.lang.Throwable r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r1 = this;
                        r0 = "create notification failed";
                        com.onesignal.am.m23189b(r0, r2, r4, r3);
                        r4 = r3;
                        if (r4 == 0) goto L_0x0029;
                    L_0x0009:
                        if (r2 != 0) goto L_0x000d;
                    L_0x000b:
                        r3 = "{\"error\": \"HTTP no response error\"}";	 Catch:{ Throwable -> 0x0018 }
                    L_0x000d:
                        r2 = r3;	 Catch:{ Throwable -> 0x0018 }
                        r4 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0018 }
                        r4.<init>(r3);	 Catch:{ Throwable -> 0x0018 }
                        r2.m23119b(r4);	 Catch:{ Throwable -> 0x0018 }
                        goto L_0x0029;
                    L_0x0018:
                        r2 = r3;	 Catch:{ JSONException -> 0x0025 }
                        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0025 }
                        r4 = "{\"error\": \"Unknown response!\"}";	 Catch:{ JSONException -> 0x0025 }
                        r3.<init>(r4);	 Catch:{ JSONException -> 0x0025 }
                        r2.m23119b(r3);	 Catch:{ JSONException -> 0x0025 }
                        goto L_0x0029;
                    L_0x0025:
                        r2 = move-exception;
                        r2.printStackTrace();
                    L_0x0029:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.5.a(int, java.lang.String, java.lang.Throwable):void");
                    }
                });
            } catch (Throwable e) {
                m23161a(C5464i.ERROR, "HTTP create notification json exception!", e);
                if (c5469n != null) {
                    try {
                        c5469n.m23119b(new JSONObject("{'error': 'HTTP create notification json exception!'}"));
                    } catch (JSONObject jSONObject2) {
                        jSONObject2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m23157a(final C5461f c5461f) {
        if (!m23179a("getTags()")) {
            f18389P = c5461f;
            Runnable c54516 = new Runnable() {
                public void run() {
                    if (c5461f == null) {
                        am.m23187b(C5464i.ERROR, "getTagsHandler is null!");
                    } else if (am.m23244m() != null) {
                        am.m23196c(am.f18389P);
                    }
                }
            };
            if (f18401b == null) {
                m23187b(C5464i.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                f18404e.add(c54516);
                return;
            }
            c54516.run();
        }
    }

    /* renamed from: c */
    private static void m23196c(final C5461f c5461f) {
        if (c5461f != null) {
            new Thread(new Runnable() {
                public void run() {
                    C5495a d = as.m23314d(am.f18390Q ^ true);
                    if (d.f18502a) {
                        am.f18390Q = true;
                    }
                    if (d.f18503b != null) {
                        if (!d.toString().equals("{}")) {
                            c5461f.m23114a(d.f18503b);
                            return;
                        }
                    }
                    c5461f.m23114a(null);
                }
            }, "OS_GETTAGS_CALLBACK").start();
        }
    }

    /* renamed from: d */
    public static void m23205d(String str) {
        m23165a(str, null);
    }

    /* renamed from: a */
    public static void m23165a(String str, C5457b c5457b) {
        if (!m23179a("deleteTag()")) {
            Collection arrayList = new ArrayList(1);
            arrayList.add(str);
            m23169a(arrayList, c5457b);
        }
    }

    /* renamed from: a */
    public static void m23169a(Collection<String> collection, C5457b c5457b) {
        if (!m23179a("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String put : collection) {
                    jSONObject.put(put, "");
                }
                m23173a(jSONObject, c5457b);
            } catch (Throwable th) {
                m23161a(C5464i.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    /* renamed from: a */
    public static void m23158a(C5463h c5463h) {
        if (!m23179a("idsAvailable()")) {
            f18424y = c5463h;
            c5463h = new C54548();
            if (f18401b != null) {
                if (!m23133N()) {
                    c5463h.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
            m23163a(new C5468m(c5463h));
        }
    }

    /* renamed from: j */
    static void m23235j() {
        if (f18424y != null) {
            al.m23090a(new C54559());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: X */
    private static synchronized void m23143X() {
        /*
        r0 = com.onesignal.am.class;
        monitor-enter(r0);
        r1 = f18424y;	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        r1 = com.onesignal.as.m23319h();	 Catch:{ all -> 0x0028 }
        r2 = com.onesignal.as.m23318g();	 Catch:{ all -> 0x0028 }
        r3 = 0;
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        r1 = r3;
    L_0x0015:
        r2 = m23244m();	 Catch:{ all -> 0x0028 }
        if (r2 != 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r0);
        return;
    L_0x001d:
        r4 = f18424y;	 Catch:{ all -> 0x0028 }
        r4.m23115a(r2, r1);	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0026;
    L_0x0024:
        f18424y = r3;	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r0);
        return;
    L_0x0028:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.X():void");
    }

    /* renamed from: a */
    static void m23170a(JSONArray jSONArray, boolean z, C5480a c5480a) {
        if (!m23179a("sendPurchases()")) {
            if (m23244m() == null) {
                aa = new C5462g(jSONArray);
                aa.f18356b = z;
                aa.f18357c = c5480a;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", f18400a);
                if (z) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                jSONArray = new StringBuilder();
                jSONArray.append("players/");
                jSONArray.append(m23244m());
                jSONArray.append("/on_purchase");
                ar.m23296b(jSONArray.toString(), jSONObject, c5480a);
                if (m23248n() != null) {
                    jSONArray = new StringBuilder();
                    jSONArray.append("players/");
                    jSONArray.append(m23248n());
                    jSONArray.append("/on_purchase");
                    ar.m23296b(jSONArray.toString(), jSONObject, false);
                }
            } catch (Throwable th) {
                m23161a(C5464i.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    /* renamed from: a */
    private static boolean m23176a(Context context, JSONArray jSONArray) {
        int i = 0;
        if (m23179a(null)) {
            return false;
        }
        int length = jSONArray.length();
        boolean z = false;
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("custom")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
                    if (jSONObject2.has("u")) {
                        String optString = jSONObject2.optString("u", null);
                        if (!optString.contains("://")) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("http://");
                            stringBuilder.append(optString);
                            optString = stringBuilder.toString();
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString.trim()));
                        intent.addFlags(1476919296);
                        context.startActivity(intent);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                C5464i c5464i = C5464i.ERROR;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error parsing JSON item ");
                stringBuilder2.append(i);
                stringBuilder2.append("/");
                stringBuilder2.append(length);
                stringBuilder2.append(" for launching a web URL.");
                m23161a(c5464i, stringBuilder2.toString(), th);
            }
            i++;
        }
        return z;
    }

    /* renamed from: b */
    private static void m23190b(JSONArray jSONArray, boolean z, boolean z2) {
        if (f18408i != null) {
            if (f18408i.f18340a != null) {
                m23155a(m23193c(jSONArray, z, z2));
                return;
            }
        }
        f18387N.add(jSONArray);
    }

    /* renamed from: c */
    private static ad m23193c(JSONArray jSONArray, boolean z, boolean z2) {
        int length = jSONArray.length();
        ad adVar = new ad();
        aa aaVar = new aa();
        aaVar.f18265a = m23257u();
        aaVar.f18266b = z;
        aaVar.f18267c = jSONArray.optJSONObject(false).optInt("notificationId");
        String str = null;
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                aaVar.f18268d = C5529q.m23530a(jSONObject);
                if (str == null && jSONObject.has("actionSelected")) {
                    str = jSONObject.optString("actionSelected", null);
                }
                if (obj != null) {
                    obj = null;
                } else {
                    if (aaVar.f18270f == null) {
                        aaVar.f18270f = new ArrayList();
                    }
                    aaVar.f18270f.add(aaVar.f18268d);
                }
            } catch (Throwable th) {
                C5464i c5464i = C5464i.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error parsing JSON item ");
                stringBuilder.append(i);
                stringBuilder.append("/");
                stringBuilder.append(length);
                stringBuilder.append(" for callback.");
                m23161a(c5464i, stringBuilder.toString(), th);
            }
        }
        adVar.f18276a = aaVar;
        adVar.f18277b = new ab();
        adVar.f18277b.f18275b = str;
        adVar.f18277b.f18274a = str != null ? C5442a.ActionTaken : C5442a.Opened;
        if (z2) {
            adVar.f18276a.f18269e = C5441a.InAppAlert;
        } else {
            adVar.f18276a.f18269e = C5441a.Notification;
        }
        return adVar;
    }

    /* renamed from: a */
    private static void m23155a(final ad adVar) {
        al.m23090a(new Runnable() {
            public void run() {
                am.f18408i.f18340a.notificationOpened(adVar);
            }
        });
    }

    /* renamed from: a */
    static void m23171a(JSONArray jSONArray, boolean z, boolean z2) {
        ad c = m23193c(jSONArray, z, z2);
        if (f18377D && m23201c(f18401b)) {
            f18377D.m23353b(c);
        }
        if (f18408i) {
            if (f18408i.f18341b) {
                f18408i.f18341b.notificationReceived(c.f18276a);
            }
        }
    }

    /* renamed from: a */
    public static void m23154a(Context context, JSONArray jSONArray, boolean z) {
        if (!m23179a(null)) {
            m23185b(context, jSONArray);
            if (f18377D != null && m23201c(f18401b)) {
                f18377D.m23351a(m23193c(jSONArray, true, z));
            }
            boolean z2 = false;
            boolean equals = "DISABLE".equals(al.m23086a(context, "com.onesignal.NotificationOpened.DEFAULT"));
            if (!equals) {
                z2 = m23176a(context, jSONArray);
            }
            m23190b(jSONArray, true, z);
            if (!(z || r0 || equals)) {
                m23238k(context);
            }
        }
    }

    /* renamed from: k */
    private static void m23238k(Context context) {
        if (!m23179a(null)) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268566528);
                context.startActivity(launchIntentForPackage);
            }
        }
    }

    /* renamed from: b */
    private static void m23185b(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i).optString("custom", null)).optString("i", null);
                if (!f18388O.contains(optString)) {
                    f18388O.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", m23241l(context));
                    jSONObject.put("player_id", m23245m(context));
                    jSONObject.put("opened", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("notifications/");
                    stringBuilder.append(optString);
                    ar.m23293a(stringBuilder.toString(), jSONObject, new C5480a() {
                        /* renamed from: a */
                        void mo4936a(int i, String str, Throwable th) {
                            am.m23189b("sending Notification Opened Failed", i, th, str);
                        }
                    });
                }
            } catch (Throwable th) {
                m23161a(C5464i.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    /* renamed from: k */
    private static void m23239k(String str) {
        if (f18401b != null) {
            aq.m23279a(aq.f18435a, "GT_APP_ID", str);
        }
    }

    /* renamed from: k */
    static String m23237k() {
        return m23241l(f18401b);
    }

    /* renamed from: l */
    private static String m23241l(Context context) {
        return context == null ? "" : aq.m23283b(aq.f18435a, "GT_APP_ID", null);
    }

    /* renamed from: l */
    static boolean m23242l() {
        return aq.m23285b(aq.f18435a, "ONESIGNAL_USER_PROVIDED_CONSENT", false);
    }

    /* renamed from: c */
    static void m23199c(boolean z) {
        aq.m23280a(aq.f18435a, "ONESIGNAL_USER_PROVIDED_CONSENT", z);
    }

    /* renamed from: m */
    private static String m23245m(Context context) {
        return context == null ? "" : aq.m23283b(aq.f18435a, "GT_PLAYER_ID", null);
    }

    /* renamed from: m */
    static String m23244m() {
        if (f18420u == null && f18401b != null) {
            f18420u = aq.m23283b(aq.f18435a, "GT_PLAYER_ID", null);
        }
        return f18420u;
    }

    /* renamed from: e */
    static void m23210e(String str) {
        f18420u = str;
        if (f18401b != null) {
            aq.m23279a(aq.f18435a, "GT_PLAYER_ID", f18420u);
        }
    }

    /* renamed from: n */
    static String m23248n() {
        if ("".equals(f18421v)) {
            return null;
        }
        if (f18421v == null && f18401b != null) {
            f18421v = aq.m23283b(aq.f18435a, "OS_EMAIL_ID", null);
        }
        return f18421v;
    }

    /* renamed from: f */
    static void m23217f(String str) {
        f18421v = str;
        if (f18401b != null) {
            aq.m23279a(aq.f18435a, "OS_EMAIL_ID", "".equals(f18421v) ? null : f18421v);
        }
    }

    /* renamed from: b */
    static boolean m23192b(Context context) {
        return aq.m23285b(aq.f18435a, "OS_FILTER_OTHER_GCM_RECEIVERS", false);
    }

    /* renamed from: d */
    static void m23206d(boolean z) {
        if (f18401b != null) {
            aq.m23280a(aq.f18435a, "OS_FILTER_OTHER_GCM_RECEIVERS", z);
        }
    }

    /* renamed from: g */
    static void m23223g(String str) {
        m23210e(str);
        m23235j();
        m23196c(f18389P);
        m23229i(f18401b).m23038a(str);
        if (aa != null) {
            m23170a(aa.f18355a, aa.f18356b, aa.f18357c);
            aa = null;
        }
        as.m23321j();
        an.m23263a(f18401b, f18400a, str, C6960c.m32667a());
    }

    /* renamed from: h */
    static void m23226h(String str) {
        m23217f(str);
        m23233j(f18401b).m23587a(str);
        try {
            as.m23310b(new JSONObject().put("parent_player_id", str));
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: c */
    static boolean m23201c(Context context) {
        return aq.m23285b(aq.f18435a, "GT_FIREBASE_TRACKING_ENABLED", false);
    }

    /* renamed from: e */
    public static void m23211e(boolean z) {
        if (f18401b != null) {
            aq.m23280a(aq.f18435a, "GT_VIBRATE_ENABLED", z);
        }
    }

    /* renamed from: d */
    static boolean m23208d(Context context) {
        return aq.m23285b(aq.f18435a, "GT_VIBRATE_ENABLED", true);
    }

    /* renamed from: f */
    public static void m23218f(boolean z) {
        if (f18401b != null) {
            aq.m23280a(aq.f18435a, "GT_SOUND_ENABLED", z);
        }
    }

    /* renamed from: e */
    static boolean m23214e(Context context) {
        return aq.m23285b(aq.f18435a, "GT_SOUND_ENABLED", true);
    }

    /* renamed from: a */
    static void m23150a(long j) {
        aq.m23277a(aq.f18435a, "OS_LAST_SESSION_TIME", j);
    }

    /* renamed from: n */
    private static long m23247n(Context context) {
        return aq.m23281b(aq.f18435a, "OS_LAST_SESSION_TIME", -31000);
    }

    /* renamed from: a */
    public static void m23162a(C5467l c5467l) {
        m23194c().f18346g = true;
        m23194c().f18347h = c5467l;
    }

    /* renamed from: a */
    public static void m23148a(int i) {
        m23162a(m23220g(i));
    }

    /* renamed from: g */
    private static C5467l m23220g(int i) {
        switch (i) {
            case 0:
                return C5467l.None;
            case 1:
                return C5467l.InAppAlert;
            case 2:
                return C5467l.Notification;
            default:
                if (i < 0) {
                    return C5467l.None;
                }
                return C5467l.Notification;
        }
    }

    /* renamed from: o */
    static boolean m23250o() {
        boolean z = true;
        if (f18408i == null) {
            return true;
        }
        if (f18408i.f18347h != C5467l.Notification) {
            z = false;
        }
        return z;
    }

    /* renamed from: p */
    static boolean m23252p() {
        boolean z = false;
        if (f18408i == null) {
            return false;
        }
        if (f18408i.f18347h == C5467l.InAppAlert) {
            z = true;
        }
        return z;
    }

    /* renamed from: g */
    public static void m23224g(final boolean z) {
        if (!m23179a("setSubscription()")) {
            Runnable anonymousClass13 = new Runnable() {
                public void run() {
                    am.m23229i(am.f18401b).m23039a(z);
                    as.m23311b(z);
                }
            };
            if (f18401b) {
                if (!m23133N()) {
                    anonymousClass13.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "OneSignal.init has not been called. Moving subscription action to a waiting task queue.");
            m23163a(new C5468m(anonymousClass13));
        }
    }

    /* renamed from: h */
    public static void m23227h(boolean z) {
        if (!m23179a("setLocationShared()")) {
            f18407h = z;
            if (!z) {
                as.m23315d();
            }
            C5464i c5464i = C5464i.DEBUG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("shareLocation:");
            stringBuilder.append(f18407h);
            m23187b(c5464i, stringBuilder.toString());
        }
    }

    /* renamed from: q */
    public static void m23253q() {
        if (!m23179a("promptLocation()")) {
            Runnable anonymousClass14 = new Runnable() {

                /* compiled from: OneSignal */
                /* renamed from: com.onesignal.am$14$1 */
                class C69481 implements C5523d {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass14 f24807a;

                    C69481(AnonymousClass14 anonymousClass14) {
                        this.f24807a = anonymousClass14;
                    }

                    /* renamed from: a */
                    public C5521a mo4937a() {
                        return C5521a.PROMPT_LOCATION;
                    }

                    /* renamed from: a */
                    public void mo4938a(C5525f c5525f) {
                        if (!(am.m23179a("promptLocation()") || c5525f == null)) {
                            as.m23302a(c5525f);
                        }
                    }
                }

                public void run() {
                    C5526p.m23513a(am.f18401b, true, new C69481(this));
                    am.f18385L = true;
                }
            };
            if (f18401b != null) {
                if (!m23133N()) {
                    anonymousClass14.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "OneSignal.init has not been called. Could not prompt for location at this time - moving this operation to awaiting queue.");
            m23163a(new C5468m(anonymousClass14));
        }
    }

    /* renamed from: r */
    public static void m23254r() {
        if (!m23179a("clearOneSignalNotifications()")) {
            Runnable anonymousClass15 = new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r11 = this;
                    r0 = com.onesignal.am.f18401b;
                    r1 = "notification";
                    r0 = r0.getSystemService(r1);
                    r0 = (android.app.NotificationManager) r0;
                    r1 = com.onesignal.am.f18401b;
                    r1 = com.onesignal.ao.m23264a(r1);
                    r2 = 0;
                    r3 = r1.m23267b();	 Catch:{ Throwable -> 0x00ae }
                    r4 = "android_notification_id";
                    r5 = new java.lang.String[]{r4};	 Catch:{ Throwable -> 0x00ae }
                    r4 = "notification";
                    r6 = "dismissed = 0 AND opened = 0";
                    r7 = 0;
                    r8 = 0;
                    r9 = 0;
                    r10 = 0;
                    r3 = r3.query(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00ae }
                    r4 = r3.moveToFirst();	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    if (r4 == 0) goto L_0x0040;
                L_0x002d:
                    r4 = "android_notification_id";
                    r4 = r3.getColumnIndex(r4);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r4 = r3.getInt(r4);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r0.cancel(r4);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r4 = r3.moveToNext();	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    if (r4 != 0) goto L_0x002d;
                L_0x0040:
                    r0 = r1.m23266a();	 Catch:{ Throwable -> 0x0077 }
                    r0.beginTransaction();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r1 = "opened = 0";
                    r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r4.<init>();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r5 = "dismissed";
                    r6 = 1;
                    r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r4.put(r5, r6);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r5 = "notification";
                    r0.update(r5, r4, r1, r2);	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0071, all -> 0x006f }
                    if (r0 == 0) goto L_0x008b;
                L_0x0062:
                    r0.endTransaction();	 Catch:{ Throwable -> 0x0066, all -> 0x00a6 }
                    goto L_0x008b;
                L_0x0066:
                    r0 = move-exception;
                    r1 = com.onesignal.am.C5464i.ERROR;	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r2 = "Error closing transaction! ";
                L_0x006b:
                    com.onesignal.am.m23161a(r1, r2, r0);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    goto L_0x008b;
                L_0x006f:
                    r1 = move-exception;
                    goto L_0x0097;
                L_0x0071:
                    r1 = move-exception;
                    r2 = r0;
                    goto L_0x0078;
                L_0x0074:
                    r1 = move-exception;
                    r0 = r2;
                    goto L_0x0097;
                L_0x0077:
                    r1 = move-exception;
                L_0x0078:
                    r0 = com.onesignal.am.C5464i.ERROR;	 Catch:{ all -> 0x0074 }
                    r4 = "Error marking all notifications as dismissed! ";
                    com.onesignal.am.m23161a(r0, r4, r1);	 Catch:{ all -> 0x0074 }
                    if (r2 == 0) goto L_0x008b;
                L_0x0081:
                    r2.endTransaction();	 Catch:{ Throwable -> 0x0085, all -> 0x00a6 }
                    goto L_0x008b;
                L_0x0085:
                    r0 = move-exception;
                    r1 = com.onesignal.am.C5464i.ERROR;	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r2 = "Error closing transaction! ";
                    goto L_0x006b;
                L_0x008b:
                    r0 = 0;
                    r1 = com.onesignal.am.f18401b;	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    com.onesignal.C5504f.m23441a(r0, r1);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    if (r3 == 0) goto L_0x00bb;
                L_0x0093:
                    r3.close();
                    goto L_0x00bb;
                L_0x0097:
                    if (r0 == 0) goto L_0x00a5;
                L_0x0099:
                    r0.endTransaction();	 Catch:{ Throwable -> 0x009d, all -> 0x00a6 }
                    goto L_0x00a5;
                L_0x009d:
                    r0 = move-exception;
                    r2 = com.onesignal.am.C5464i.ERROR;	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                    r4 = "Error closing transaction! ";
                    com.onesignal.am.m23161a(r2, r4, r0);	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                L_0x00a5:
                    throw r1;	 Catch:{ Throwable -> 0x00a8, all -> 0x00a6 }
                L_0x00a6:
                    r0 = move-exception;
                    goto L_0x00bc;
                L_0x00a8:
                    r0 = move-exception;
                    r2 = r3;
                    goto L_0x00af;
                L_0x00ab:
                    r0 = move-exception;
                    r3 = r2;
                    goto L_0x00bc;
                L_0x00ae:
                    r0 = move-exception;
                L_0x00af:
                    r1 = com.onesignal.am.C5464i.ERROR;	 Catch:{ all -> 0x00ab }
                    r3 = "Error canceling all notifications! ";
                    com.onesignal.am.m23161a(r1, r3, r0);	 Catch:{ all -> 0x00ab }
                    if (r2 == 0) goto L_0x00bb;
                L_0x00b8:
                    r2.close();
                L_0x00bb:
                    return;
                L_0x00bc:
                    if (r3 == 0) goto L_0x00c1;
                L_0x00be:
                    r3.close();
                L_0x00c1:
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.15.run():void");
                }
            };
            if (f18401b != null) {
                if (!m23133N()) {
                    anonymousClass15.run();
                    return;
                }
            }
            m23187b(C5464i.ERROR, "OneSignal.init has not been called. Could not clear notifications at this time - moving this operation toa waiting task queue.");
            m23163a(new C5468m(anonymousClass15));
        }
    }

    /* renamed from: b */
    public static void m23183b(final int i) {
        if (!m23179a("cancelNotification()")) {
            Runnable anonymousClass16 = new Runnable() {
                public void run() {
                    Throwable th;
                    C5464i c5464i;
                    StringBuilder stringBuilder;
                    SQLiteDatabase a;
                    try {
                        a = ao.m23264a(am.f18401b).m23266a();
                        try {
                            a.beginTransaction();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("android_notification_id = ");
                            stringBuilder2.append(i);
                            stringBuilder2.append(" AND ");
                            stringBuilder2.append("opened");
                            stringBuilder2.append(" = 0 AND ");
                            stringBuilder2.append(UIManagerModuleConstants.ACTION_DISMISSED);
                            stringBuilder2.append(" = 0");
                            String stringBuilder3 = stringBuilder2.toString();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(UIManagerModuleConstants.ACTION_DISMISSED, Integer.valueOf(1));
                            if (a.update("notification", contentValues, stringBuilder3, null) > 0) {
                                C5543x.m23582a(am.f18401b, a, i);
                            }
                            C5504f.m23442a(a, am.f18401b);
                            a.setTransactionSuccessful();
                            if (a != null) {
                                try {
                                    a.endTransaction();
                                } catch (Throwable th2) {
                                    am.m23161a(C5464i.ERROR, "Error closing transaction! ", th2);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                c5464i = C5464i.ERROR;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Error marking a notification id ");
                                stringBuilder.append(i);
                                stringBuilder.append(" as dismissed! ");
                                am.m23161a(c5464i, stringBuilder.toString(), th);
                                if (a != null) {
                                    a.endTransaction();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (a != null) {
                                    try {
                                        a.endTransaction();
                                    } catch (Throwable th22) {
                                        am.m23161a(C5464i.ERROR, "Error closing transaction! ", th22);
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th222) {
                        th = th222;
                        a = null;
                        if (a != null) {
                            a.endTransaction();
                        }
                        throw th;
                    }
                }
            };
            if (f18401b != null) {
                if (!m23133N()) {
                    anonymousClass16.run();
                    ((NotificationManager) f18401b.getSystemService("notification")).cancel(i);
                    return;
                }
            }
            C5464i c5464i = C5464i.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OneSignal.init has not been called. Could not clear notification id: ");
            stringBuilder.append(i);
            stringBuilder.append(" at this time - movingthis operation to a waiting task queue. The notification will still be canceledfrom NotificationManager at this time.");
            m23187b(c5464i, stringBuilder.toString());
            f18404e.add(anonymousClass16);
        }
    }

    /* renamed from: s */
    public static aj m23255s() {
        if (m23179a("getPermissionSubscriptionState()")) {
            return null;
        }
        if (f18401b == null) {
            m23187b(C5464i.ERROR, "OneSignal.init has not been called. Could not get OSPermissionSubscriptionState");
            return null;
        }
        aj ajVar = new aj();
        ajVar.f18320a = m23229i(f18401b);
        ajVar.f18321b = m23225h(f18401b);
        ajVar.f18322c = m23233j(f18401b);
        return ajVar;
    }

    /* renamed from: t */
    static long m23256t() {
        if (f18374A == -1 && f18401b != null) {
            f18374A = aq.m23281b(aq.f18435a, "GT_UNSENT_ACTIVE_TIME", 0);
        }
        C5464i c5464i = C5464i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetUnsentActiveTime: ");
        stringBuilder.append(f18374A);
        m23187b(c5464i, stringBuilder.toString());
        return f18374A;
    }

    /* renamed from: e */
    private static void m23209e(long j) {
        f18374A = j;
        if (f18401b != null) {
            C5464i c5464i = C5464i.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SaveUnsentActiveTime: ");
            stringBuilder.append(f18374A);
            m23187b(c5464i, stringBuilder.toString());
            aq.m23277a(aq.f18435a, "GT_UNSENT_ACTIVE_TIME", j);
        }
    }

    /* renamed from: a */
    private static boolean m23180a(String str, Context context) {
        boolean moveToFirst;
        Throwable th;
        C5464i c5464i;
        StringBuilder stringBuilder;
        if (str != null) {
            if (!"".equals(str)) {
                Cursor cursor = null;
                try {
                    context = ao.m23264a(context).m23267b().query("notification", new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, null, null, null);
                    try {
                        moveToFirst = context.moveToFirst();
                        if (context != null) {
                            context.close();
                        }
                    } catch (Throwable th2) {
                        str = th2;
                        cursor = context;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    m23161a(C5464i.ERROR, "Could not check for duplicate, assuming unique.", th);
                    if (cursor != null) {
                        cursor.close();
                    }
                    moveToFirst = false;
                    if (moveToFirst) {
                        return false;
                    }
                    c5464i = C5464i.DEBUG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Duplicate GCM message received, skip processing of ");
                    stringBuilder.append(str);
                    m23187b(c5464i, stringBuilder.toString());
                    return true;
                }
                if (moveToFirst) {
                    return false;
                }
                c5464i = C5464i.DEBUG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Duplicate GCM message received, skip processing of ");
                stringBuilder.append(str);
                m23187b(c5464i, stringBuilder.toString());
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m23177a(Context context, JSONObject jSONObject) {
        String d = m23203d(jSONObject);
        if (d != null) {
            if (m23180a(d, context) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    static String m23147a(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        try {
            if (bundle.containsKey("custom")) {
                JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
                if (jSONObject.has("i") != null) {
                    return jSONObject.optString("i", null);
                }
                m23187b(C5464i.DEBUG, "Not a OneSignal formatted GCM message. No 'i' field in custom.");
            } else {
                m23187b(C5464i.DEBUG, "Not a OneSignal formatted GCM message. No 'custom' field in the bundle.");
            }
        } catch (Throwable th) {
            m23161a(C5464i.DEBUG, "Could not parse bundle, probably not a OneSignal notification.", th);
        }
        return null;
    }

    /* renamed from: d */
    private static java.lang.String m23203d(org.json.JSONObject r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0013 }
        r2 = "custom";	 Catch:{ Throwable -> 0x0013 }
        r3 = r3.optString(r2);	 Catch:{ Throwable -> 0x0013 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0013 }
        r3 = "i";	 Catch:{ Throwable -> 0x0013 }
        r3 = r1.optString(r3, r0);	 Catch:{ Throwable -> 0x0013 }
        return r3;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.am.d(org.json.JSONObject):java.lang.String");
    }

    /* renamed from: u */
    static boolean m23257u() {
        return f18402c && m23228h();
    }

    /* renamed from: v */
    static void m23258v() {
        f18392S = false;
        m23150a(System.currentTimeMillis());
    }

    /* renamed from: Y */
    private static boolean m23144Y() {
        boolean z = true;
        if (f18392S) {
            return true;
        }
        if ((System.currentTimeMillis() - m23247n(f18401b)) / 1000 < 30) {
            z = false;
        }
        return z;
    }

    /* renamed from: w */
    static boolean m23259w() {
        return f18408i.f18344e ? al.m23092a(f18401b) : true;
    }

    /* renamed from: x */
    static void m23260x() {
        if (f18415p != null) {
            f18415p.m23112a();
            f18415p = null;
        }
    }

    /* renamed from: y */
    static void m23261y() {
        if (f18415p != null) {
            f18415p.m23113a(new C5459d(C5458c.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f18415p = null;
        }
    }

    /* renamed from: z */
    static void m23262z() {
        if (f18414o != null) {
            f18414o.m23112a();
            f18414o = null;
        }
    }

    /* renamed from: A */
    static void m23120A() {
        if (f18414o != null) {
            f18414o.m23113a(new C5459d(C5458c.NETWORK, "Failed due to network failure. Will retry on next sync."));
            f18414o = null;
        }
    }
}
