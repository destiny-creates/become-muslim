package com.facebook.ads.internal.p098m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p101p.p102a.C1443a;
import com.facebook.ads.internal.p105q.p108c.C1535d;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.b */
public class C1411b {
    /* renamed from: a */
    private static final String f4120a = "b";
    /* renamed from: b */
    private final C1410a f4121b;
    /* renamed from: c */
    private final Context f4122c;
    /* renamed from: d */
    private final ThreadPoolExecutor f4123d;
    /* renamed from: e */
    private final ConnectivityManager f4124e;
    /* renamed from: f */
    private final C1443a f4125f;
    /* renamed from: g */
    private final Handler f4126g;
    /* renamed from: h */
    private final long f4127h;
    /* renamed from: i */
    private final long f4128i;
    /* renamed from: j */
    private final Runnable f4129j = new C14081(this);
    /* renamed from: k */
    private final Runnable f4130k = new C14092(this);
    /* renamed from: l */
    private volatile boolean f4131l;
    /* renamed from: m */
    private int f4132m;
    /* renamed from: n */
    private long f4133n;

    /* renamed from: com.facebook.ads.internal.m.b$1 */
    class C14081 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1411b f4118a;

        C14081(C1411b c1411b) {
            this.f4118a = c1411b;
        }

        public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r0 = r4.f4118a;
            com.facebook.ads.internal.p098m.C1411b.m4872a(r0);
            r0 = r4.f4118a;
            r0 = r0.f4133n;
            r2 = 0;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x001a;
        L_0x0011:
            r0 = r4.f4118a;	 Catch:{ InterruptedException -> 0x001a }
            r0 = r0.f4133n;	 Catch:{ InterruptedException -> 0x001a }
            java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x001a }
        L_0x001a:
            r0 = r4.f4118a;
            r0.m4879d();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.b.1.run():void");
        }
    }

    /* renamed from: com.facebook.ads.internal.m.b$2 */
    class C14092 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1411b f4119a;

        C14092(C1411b c1411b) {
            this.f4119a = c1411b;
        }

        public void run() {
            this.f4119a.f4131l = false;
            if (this.f4119a.f4123d.getQueue().isEmpty()) {
                this.f4119a.f4123d.execute(this.f4119a.f4129j);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.m.b$a */
    interface C1410a {
        /* renamed from: a */
        JSONObject mo956a();

        /* renamed from: a */
        boolean mo957a(JSONArray jSONArray);

        /* renamed from: b */
        void mo958b();

        /* renamed from: b */
        void mo959b(JSONArray jSONArray);

        /* renamed from: c */
        boolean mo960c();
    }

    C1411b(Context context, C1410a c1410a) {
        this.f4121b = c1410a;
        this.f4122c = context;
        this.f4123d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f4124e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f4125f = C1535d.m5373b(context);
        this.f4126g = new Handler(Looper.getMainLooper());
        this.f4127h = C1405a.m4832m(context);
        this.f4128i = C1405a.m4833n(context);
    }

    /* renamed from: a */
    static /* synthetic */ int m4872a(C1411b c1411b) {
        int i = c1411b.f4132m + 1;
        c1411b.f4132m = i;
        return i;
    }

    /* renamed from: a */
    private void m4873a(long j) {
        this.f4126g.postDelayed(this.f4130k, j);
    }

    /* renamed from: c */
    private void m4876c() {
        if (this.f4132m >= 5) {
            m4881e();
            m4883b();
            return;
        }
        this.f4133n = this.f4132m == 1 ? 2000 : this.f4133n * 2;
        m4882a();
    }

    /* renamed from: d */
    private void m4879d() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f4124e;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x00aa }
        if (r0 == 0) goto L_0x00a4;	 Catch:{ Exception -> 0x00aa }
    L_0x0008:
        r0 = r0.isConnectedOrConnecting();	 Catch:{ Exception -> 0x00aa }
        if (r0 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x00aa }
    L_0x000e:
        goto L_0x00a4;	 Catch:{ Exception -> 0x00aa }
    L_0x0010:
        r0 = r4.f4121b;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.mo956a();	 Catch:{ Exception -> 0x00aa }
        if (r0 != 0) goto L_0x001c;	 Catch:{ Exception -> 0x00aa }
    L_0x0018:
        r4.m4881e();	 Catch:{ Exception -> 0x00aa }
        return;	 Catch:{ Exception -> 0x00aa }
    L_0x001c:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00aa }
        r1.<init>();	 Catch:{ Exception -> 0x00aa }
        r2 = "attempt";	 Catch:{ Exception -> 0x00aa }
        r3 = r4.f4132m;	 Catch:{ Exception -> 0x00aa }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x00aa }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x00aa }
        r2 = "data";	 Catch:{ Exception -> 0x00aa }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x00aa }
        r1 = new com.facebook.ads.internal.p.a.p;	 Catch:{ Exception -> 0x00aa }
        r1.<init>();	 Catch:{ Exception -> 0x00aa }
        r2 = "payload";	 Catch:{ Exception -> 0x00aa }
        r3 = r0.toString();	 Catch:{ Exception -> 0x00aa }
        r1.m5143a(r2, r3);	 Catch:{ Exception -> 0x00aa }
        r2 = r4.f4125f;	 Catch:{ Exception -> 0x00aa }
        r3 = r4.f4122c;	 Catch:{ Exception -> 0x00aa }
        r3 = com.facebook.ads.internal.p100o.C1439d.m5086a(r3);	 Catch:{ Exception -> 0x00aa }
        r1 = r2.m5115b(r3, r1);	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x00aa }
    L_0x004d:
        r2 = r1.m5137e();	 Catch:{ Exception -> 0x00aa }
        goto L_0x0053;	 Catch:{ Exception -> 0x00aa }
    L_0x0052:
        r2 = 0;	 Catch:{ Exception -> 0x00aa }
    L_0x0053:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x00aa }
        if (r3 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x00aa }
    L_0x0059:
        r1 = "events";	 Catch:{ Exception -> 0x00aa }
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x006c;	 Catch:{ Exception -> 0x00aa }
    L_0x0061:
        r1 = r4.f4121b;	 Catch:{ Exception -> 0x00aa }
        r2 = "events";	 Catch:{ Exception -> 0x00aa }
        r0 = r0.getJSONArray(r2);	 Catch:{ Exception -> 0x00aa }
    L_0x0069:
        r1.mo959b(r0);	 Catch:{ Exception -> 0x00aa }
    L_0x006c:
        r4.m4876c();	 Catch:{ Exception -> 0x00aa }
        goto L_0x00ad;	 Catch:{ Exception -> 0x00aa }
    L_0x0070:
        r1 = r1.m5133a();	 Catch:{ Exception -> 0x00aa }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00aa }
        if (r1 == r3) goto L_0x0089;	 Catch:{ Exception -> 0x00aa }
    L_0x0078:
        r1 = "events";	 Catch:{ Exception -> 0x00aa }
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x00aa }
        if (r1 == 0) goto L_0x006c;	 Catch:{ Exception -> 0x00aa }
    L_0x0080:
        r1 = r4.f4121b;	 Catch:{ Exception -> 0x00aa }
        r2 = "events";	 Catch:{ Exception -> 0x00aa }
        r0 = r0.getJSONArray(r2);	 Catch:{ Exception -> 0x00aa }
        goto L_0x0069;	 Catch:{ Exception -> 0x00aa }
    L_0x0089:
        r0 = r4.f4121b;	 Catch:{ Exception -> 0x00aa }
        r1 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00aa }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00aa }
        r0 = r0.mo957a(r1);	 Catch:{ Exception -> 0x00aa }
        if (r0 != 0) goto L_0x0097;	 Catch:{ Exception -> 0x00aa }
    L_0x0096:
        goto L_0x006c;	 Catch:{ Exception -> 0x00aa }
    L_0x0097:
        r0 = r4.f4121b;	 Catch:{ Exception -> 0x00aa }
        r0 = r0.mo960c();	 Catch:{ Exception -> 0x00aa }
        if (r0 == 0) goto L_0x00a0;	 Catch:{ Exception -> 0x00aa }
    L_0x009f:
        goto L_0x006c;	 Catch:{ Exception -> 0x00aa }
    L_0x00a0:
        r4.m4881e();	 Catch:{ Exception -> 0x00aa }
        goto L_0x00ad;	 Catch:{ Exception -> 0x00aa }
    L_0x00a4:
        r0 = r4.f4128i;	 Catch:{ Exception -> 0x00aa }
        r4.m4873a(r0);	 Catch:{ Exception -> 0x00aa }
        return;
    L_0x00aa:
        r4.m4876c();
    L_0x00ad:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.b.d():void");
    }

    /* renamed from: e */
    private void m4881e() {
        this.f4132m = 0;
        this.f4133n = 0;
        if (this.f4123d.getQueue().size() == 0) {
            this.f4121b.mo958b();
        }
    }

    /* renamed from: a */
    void m4882a() {
        this.f4131l = true;
        this.f4126g.removeCallbacks(this.f4130k);
        m4873a(this.f4127h);
    }

    /* renamed from: b */
    void m4883b() {
        if (!this.f4131l) {
            this.f4131l = true;
            this.f4126g.removeCallbacks(this.f4130k);
            m4873a(this.f4128i);
        }
    }
}
