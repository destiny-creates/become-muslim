package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.C4267b;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.concurrent.TimeUnit;

@cm
public final class eh extends ji {
    /* renamed from: a */
    private static final long f28636a = TimeUnit.SECONDS.toMillis(10);
    /* renamed from: b */
    private static final Object f28637b = new Object();
    /* renamed from: c */
    private static boolean f28638c = false;
    /* renamed from: d */
    private static bao f28639d = null;
    /* renamed from: e */
    private static HttpClient f28640e = null;
    /* renamed from: f */
    private static C4267b f28641f = null;
    /* renamed from: g */
    private static ae<Object> f28642g = null;
    /* renamed from: h */
    private final co f28643h;
    /* renamed from: i */
    private final dm f28644i;
    /* renamed from: j */
    private final Object f28645j = new Object();
    /* renamed from: k */
    private final Context f28646k;
    /* renamed from: l */
    private bbb f28647l;
    /* renamed from: m */
    private anc f28648m;

    public eh(Context context, dm dmVar, co coVar, anc anc) {
        super(true);
        this.f28643h = coVar;
        this.f28646k = context;
        this.f28644i = dmVar;
        this.f28648m = anc;
        synchronized (f28637b) {
            if (!f28638c) {
                f28641f = new C4267b();
                f28640e = new HttpClient(context.getApplicationContext(), dmVar.f15311j);
                f28642g = new ep();
                f28639d = new bao(this.f28646k.getApplicationContext(), this.f28644i.f15311j, (String) aph.m18688f().m18889a(asp.f14936a), new eo(), new en());
                f28638c = true;
            }
        }
    }

    /* renamed from: a */
    private final com.google.android.gms.internal.ads.dp m37465a(com.google.android.gms.internal.ads.dl r9) {
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
        r8 = this;
        com.google.android.gms.ads.internal.ax.e();
        r0 = com.google.android.gms.internal.ads.jw.m19688a();
        r1 = r8.m37466a(r9, r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0014;
    L_0x000e:
        r9 = new com.google.android.gms.internal.ads.dp;
        r9.<init>(r2);
        return r9;
    L_0x0014:
        r3 = com.google.android.gms.ads.internal.ax.l();
        r3 = r3.b();
        r5 = f28641f;
        r5 = r5.a(r0);
        r6 = com.google.android.gms.internal.ads.mi.f15796a;
        r7 = new com.google.android.gms.internal.ads.ej;
        r7.<init>(r8, r1, r0);
        r6.post(r7);
        r0 = f28636a;
        r6 = com.google.android.gms.ads.internal.ax.l();
        r6 = r6.b();
        r6 = r6 - r3;
        r0 = r0 - r6;
        r3 = -1;
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ CancellationException -> 0x0074, CancellationException -> 0x0074, TimeoutException -> 0x006d, ExecutionException -> 0x0067 }
        r0 = r5.get(r0, r4);	 Catch:{ CancellationException -> 0x0074, CancellationException -> 0x0074, TimeoutException -> 0x006d, ExecutionException -> 0x0067 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ CancellationException -> 0x0074, CancellationException -> 0x0074, TimeoutException -> 0x006d, ExecutionException -> 0x0067 }
        if (r0 != 0) goto L_0x0049;
    L_0x0043:
        r9 = new com.google.android.gms.internal.ads.dp;
        r9.<init>(r3);
        return r9;
    L_0x0049:
        r1 = r8.f28646k;
        r0 = r0.toString();
        r9 = com.google.android.gms.internal.ads.ez.m19396a(r1, r9, r0);
        r0 = r9.f28599d;
        r1 = -3;
        if (r0 == r1) goto L_0x0066;
    L_0x0058:
        r0 = r9.f28597b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0066;
    L_0x0060:
        r9 = new com.google.android.gms.internal.ads.dp;
        r0 = 3;
        r9.<init>(r0);
    L_0x0066:
        return r9;
    L_0x0067:
        r9 = new com.google.android.gms.internal.ads.dp;
        r9.<init>(r2);
        return r9;
    L_0x006d:
        r9 = new com.google.android.gms.internal.ads.dp;
        r0 = 2;
        r9.<init>(r0);
        return r9;
    L_0x0074:
        r9 = new com.google.android.gms.internal.ads.dp;
        r9.<init>(r3);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.eh.a(com.google.android.gms.internal.ads.dl):com.google.android.gms.internal.ads.dp");
    }

    /* renamed from: a */
    private final org.json.JSONObject m37466a(com.google.android.gms.internal.ads.dl r6, java.lang.String r7) {
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
        r5 = this;
        r0 = r6.f28547c;
        r0 = r0.f28263c;
        r1 = "sdk_less_server_data";
        r0 = r0.getBundle(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r2 = com.google.android.gms.ads.internal.ax.p();	 Catch:{ Exception -> 0x001f }
        r3 = r5.f28646k;	 Catch:{ Exception -> 0x001f }
        r2 = r2.m19437a(r3);	 Catch:{ Exception -> 0x001f }
        r2 = r2.get();	 Catch:{ Exception -> 0x001f }
        r2 = (com.google.android.gms.internal.ads.fi) r2;	 Catch:{ Exception -> 0x001f }
        goto L_0x0026;
    L_0x001f:
        r2 = move-exception;
        r3 = "Error grabbing device info: ";
        com.google.android.gms.internal.ads.mt.m19921c(r3, r2);
        r2 = r1;
    L_0x0026:
        r3 = r5.f28646k;
        r4 = new com.google.android.gms.internal.ads.es;
        r4.<init>();
        r4.f15351j = r6;
        r4.f15352k = r2;
        r6 = com.google.android.gms.internal.ads.ez.m19400a(r3, r4);
        if (r6 != 0) goto L_0x0038;
    L_0x0037:
        return r1;
    L_0x0038:
        r2 = r5.f28646k;	 Catch:{ IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f }
        r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2);	 Catch:{ IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f }
        goto L_0x0046;
    L_0x003f:
        r2 = move-exception;
        r3 = "Cannot get advertising id info";
        com.google.android.gms.internal.ads.mt.m19921c(r3, r2);
        r2 = r1;
    L_0x0046:
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "request_id";
        r3.put(r4, r7);
        r7 = "request_param";
        r3.put(r7, r6);
        r6 = "data";
        r3.put(r6, r0);
        if (r2 == 0) goto L_0x0072;
    L_0x005c:
        r6 = "adid";
        r7 = r2.getId();
        r3.put(r6, r7);
        r6 = "lat";
        r7 = r2.isLimitAdTrackingEnabled();
        r7 = java.lang.Integer.valueOf(r7);
        r3.put(r6, r7);
    L_0x0072:
        r6 = com.google.android.gms.ads.internal.ax.e();	 Catch:{ JSONException -> 0x007b }
        r6 = r6.m19737a(r3);	 Catch:{ JSONException -> 0x007b }
        return r6;
    L_0x007b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.eh.a(com.google.android.gms.internal.ads.dl, java.lang.String):org.json.JSONObject");
    }

    /* renamed from: a */
    protected static void m37467a(bac bac) {
        bac.mo6655a("/loadAd", f28641f);
        bac.mo6655a("/fetchHttpRequest", f28640e);
        bac.mo6655a("/invalidRequest", f28642g);
    }

    /* renamed from: b */
    protected static void m37469b(bac bac) {
        bac.mo6656b("/loadAd", f28641f);
        bac.mo6656b("/fetchHttpRequest", f28640e);
        bac.mo6656b("/invalidRequest", f28642g);
    }

    /* renamed from: a */
    public final void mo6079a() {
        mt.m19918b("SdkLessAdLoaderBackgroundTask started.");
        String j = ax.B().m19555j(this.f28646k);
        dl dlVar = new dl(this.f28644i, -1, ax.B().m19553h(this.f28646k), ax.B().m19554i(this.f28646k), j);
        ax.B().m19550f(this.f28646k, j);
        dp a = m37465a(dlVar);
        long b = ax.l().b();
        dlVar = dlVar;
        mi.f15796a.post(new ei(this, new it(dlVar, a, null, null, a.f28599d, b, a.f28608m, null, this.f28648m)));
    }

    public final void h_() {
        synchronized (this.f28645j) {
            mi.f15796a.post(new em(this));
        }
    }
}
