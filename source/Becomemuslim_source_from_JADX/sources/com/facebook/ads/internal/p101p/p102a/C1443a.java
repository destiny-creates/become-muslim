package com.facebook.ads.internal.p101p.p102a;

import android.os.Build.VERSION;
import com.facebook.ads.AdError;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.facebook.ads.internal.p.a.a */
public class C1443a {
    /* renamed from: f */
    private static int[] f4284f = new int[20];
    /* renamed from: g */
    private static final String f4285g = C1443a.class.getSimpleName();
    /* renamed from: a */
    protected final C1453q f4286a = new C45681(this);
    /* renamed from: b */
    protected final C1446d f4287b = new C3595e();
    /* renamed from: c */
    protected C1454r f4288c = new C3597g();
    /* renamed from: d */
    protected int f4289d = AdError.SERVER_ERROR_CODE;
    /* renamed from: e */
    protected int f4290e = 8000;
    /* renamed from: h */
    private int f4291h = 3;
    /* renamed from: i */
    private Map<String, String> f4292i = new TreeMap();
    /* renamed from: j */
    private boolean f4293j;
    /* renamed from: k */
    private Set<String> f4294k;
    /* renamed from: l */
    private Set<String> f4295l;

    /* renamed from: com.facebook.ads.internal.p.a.a$1 */
    class C45681 extends C3596f {
        /* renamed from: a */
        final /* synthetic */ C1443a f12435a;

        C45681(C1443a c1443a) {
            this.f12435a = c1443a;
        }
    }

    static {
        C1443a.m5098c();
        if (VERSION.SDK_INT > 8) {
            C1443a.m5097a();
        }
    }

    /* renamed from: a */
    public static void m5097a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    /* renamed from: c */
    private static void m5098c() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* renamed from: c */
    private void m5099c(HttpURLConnection httpURLConnection) {
        for (String str : this.f4292i.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f4292i.get(str));
        }
    }

    /* renamed from: a */
    protected int m5100a(int i) {
        return f4284f[i + 2] * 1000;
    }

    /* renamed from: a */
    protected int m5101a(java.net.HttpURLConnection r3, byte[] r4) {
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
        r0 = 0;
        r1 = r2.f4286a;	 Catch:{ all -> 0x001b }
        r1 = r1.mo970a(r3);	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r2.f4286a;	 Catch:{ all -> 0x000f }
        r0.mo972a(r1, r4);	 Catch:{ all -> 0x000f }
        goto L_0x0011;	 Catch:{ all -> 0x000f }
    L_0x000f:
        r3 = move-exception;	 Catch:{ all -> 0x000f }
        goto L_0x001d;	 Catch:{ all -> 0x000f }
    L_0x0011:
        r3 = r3.getResponseCode();	 Catch:{ all -> 0x000f }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return r3;
    L_0x001b:
        r3 = move-exception;
        r1 = r0;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ Exception -> 0x0022 }
    L_0x0022:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(java.net.HttpURLConnection, byte[]):int");
    }

    /* renamed from: a */
    public C1443a m5102a(String str, String str2) {
        this.f4292i.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public com.facebook.ads.internal.p101p.p102a.C1450n m5103a(com.facebook.ads.internal.p101p.p102a.C1448l r10) {
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
        r9 = this;
        r0 = java.lang.System.currentTimeMillis();
        r2 = 0;
    L_0x0005:
        r3 = r9.f4291h;
        if (r2 >= r3) goto L_0x008b;
    L_0x0009:
        r3 = r9.m5100a(r2);	 Catch:{ m -> 0x0063 }
        r9.m5120c(r3);	 Catch:{ m -> 0x0063 }
        r3 = r9.f4288c;	 Catch:{ m -> 0x0063 }
        r3 = r3.mo980a();	 Catch:{ m -> 0x0063 }
        if (r3 == 0) goto L_0x0041;	 Catch:{ m -> 0x0063 }
    L_0x0018:
        r3 = r9.f4288c;	 Catch:{ m -> 0x0063 }
        r4 = new java.lang.StringBuilder;	 Catch:{ m -> 0x0063 }
        r4.<init>();	 Catch:{ m -> 0x0063 }
        r5 = r2 + 1;	 Catch:{ m -> 0x0063 }
        r4.append(r5);	 Catch:{ m -> 0x0063 }
        r5 = "of";	 Catch:{ m -> 0x0063 }
        r4.append(r5);	 Catch:{ m -> 0x0063 }
        r5 = r9.f4291h;	 Catch:{ m -> 0x0063 }
        r4.append(r5);	 Catch:{ m -> 0x0063 }
        r5 = ", trying ";	 Catch:{ m -> 0x0063 }
        r4.append(r5);	 Catch:{ m -> 0x0063 }
        r5 = r10.m5128a();	 Catch:{ m -> 0x0063 }
        r4.append(r5);	 Catch:{ m -> 0x0063 }
        r4 = r4.toString();	 Catch:{ m -> 0x0063 }
        r3.mo978a(r4);	 Catch:{ m -> 0x0063 }
    L_0x0041:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ m -> 0x0063 }
        r0 = r10.m5128a();	 Catch:{ m -> 0x005e }
        r1 = r10.m5129b();	 Catch:{ m -> 0x005e }
        r5 = r10.m5130c();	 Catch:{ m -> 0x005e }
        r6 = r10.m5131d();	 Catch:{ m -> 0x005e }
        r0 = r9.m5104a(r0, r1, r5, r6);	 Catch:{ m -> 0x005e }
        if (r0 == 0) goto L_0x005c;
    L_0x005b:
        return r0;
    L_0x005c:
        r0 = r3;
        goto L_0x0085;
    L_0x005e:
        r0 = move-exception;
        r7 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x0064;
    L_0x0063:
        r3 = move-exception;
    L_0x0064:
        r4 = r9.m5113a(r3, r0);
        if (r4 == 0) goto L_0x0071;
    L_0x006a:
        r4 = r9.f4291h;
        r4 = r4 + -1;
        if (r2 >= r4) goto L_0x0071;
    L_0x0070:
        goto L_0x0085;
    L_0x0071:
        r4 = r9.f4286a;
        r4 = r4.mo974a(r3);
        if (r4 == 0) goto L_0x008a;
    L_0x0079:
        r4 = r9.f4291h;
        r4 = r4 + -1;
        if (r2 >= r4) goto L_0x008a;
    L_0x007f:
        r4 = r9.f4289d;	 Catch:{ InterruptedException -> 0x0089 }
        r4 = (long) r4;	 Catch:{ InterruptedException -> 0x0089 }
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0089 }
    L_0x0085:
        r2 = r2 + 1;
        goto L_0x0005;
    L_0x0089:
        throw r3;
    L_0x008a:
        throw r3;
    L_0x008b:
        r10 = 0;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(com.facebook.ads.internal.p.a.l):com.facebook.ads.internal.p.a.n");
    }

    /* renamed from: a */
    protected com.facebook.ads.internal.p101p.p102a.C1450n m5104a(java.lang.String r4, com.facebook.ads.internal.p101p.p102a.C1447j r5, java.lang.String r6, byte[] r7) {
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
        r3 = this;
        r0 = 0;
        r1 = 0;
        r3.f4293j = r0;	 Catch:{ Exception -> 0x008e, all -> 0x008b }
        r4 = r3.m5108a(r4);	 Catch:{ Exception -> 0x008e, all -> 0x008b }
        r3.m5111a(r4, r5, r6);	 Catch:{ Exception -> 0x0089 }
        r3.m5099c(r4);	 Catch:{ Exception -> 0x0089 }
        r5 = r3.f4288c;	 Catch:{ Exception -> 0x0089 }
        r5 = r5.mo980a();	 Catch:{ Exception -> 0x0089 }
        if (r5 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x0089 }
    L_0x0016:
        r5 = r3.f4288c;	 Catch:{ Exception -> 0x0089 }
        r5.mo979a(r4, r7);	 Catch:{ Exception -> 0x0089 }
    L_0x001b:
        r4.connect();	 Catch:{ Exception -> 0x0089 }
        r5 = 1;	 Catch:{ Exception -> 0x0089 }
        r3.f4293j = r5;	 Catch:{ Exception -> 0x0089 }
        r6 = r3.f4295l;	 Catch:{ Exception -> 0x0089 }
        if (r6 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0089 }
    L_0x0025:
        r6 = r3.f4295l;	 Catch:{ Exception -> 0x0089 }
        r6 = r6.isEmpty();	 Catch:{ Exception -> 0x0089 }
        if (r6 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x0089 }
    L_0x002d:
        r6 = 1;	 Catch:{ Exception -> 0x0089 }
        goto L_0x0030;	 Catch:{ Exception -> 0x0089 }
    L_0x002f:
        r6 = 0;	 Catch:{ Exception -> 0x0089 }
    L_0x0030:
        r2 = r3.f4294k;	 Catch:{ Exception -> 0x0089 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x0089 }
    L_0x0034:
        r2 = r3.f4294k;	 Catch:{ Exception -> 0x0089 }
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x0089 }
        if (r2 != 0) goto L_0x003d;	 Catch:{ Exception -> 0x0089 }
    L_0x003c:
        goto L_0x003e;	 Catch:{ Exception -> 0x0089 }
    L_0x003d:
        r5 = 0;	 Catch:{ Exception -> 0x0089 }
    L_0x003e:
        r0 = r4 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ Exception -> 0x0089 }
        if (r0 == 0) goto L_0x0059;
    L_0x0042:
        if (r6 != 0) goto L_0x0046;
    L_0x0044:
        if (r5 == 0) goto L_0x0059;
    L_0x0046:
        r5 = r4;	 Catch:{ Exception -> 0x0051 }
        r5 = (javax.net.ssl.HttpsURLConnection) r5;	 Catch:{ Exception -> 0x0051 }
        r6 = r3.f4295l;	 Catch:{ Exception -> 0x0051 }
        r0 = r3.f4294k;	 Catch:{ Exception -> 0x0051 }
        com.facebook.ads.internal.p101p.p102a.C1451o.m5139a(r5, r6, r0);	 Catch:{ Exception -> 0x0051 }
        goto L_0x0059;
    L_0x0051:
        r5 = move-exception;
        r6 = f4285g;	 Catch:{ Exception -> 0x0089 }
        r0 = "Unable to validate SSL certificates.";	 Catch:{ Exception -> 0x0089 }
        android.util.Log.e(r6, r0, r5);	 Catch:{ Exception -> 0x0089 }
    L_0x0059:
        r5 = r4.getDoOutput();	 Catch:{ Exception -> 0x0089 }
        if (r5 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x0089 }
    L_0x005f:
        if (r7 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x0089 }
    L_0x0061:
        r3.m5101a(r4, r7);	 Catch:{ Exception -> 0x0089 }
    L_0x0064:
        r5 = r4.getDoInput();	 Catch:{ Exception -> 0x0089 }
        if (r5 == 0) goto L_0x006f;	 Catch:{ Exception -> 0x0089 }
    L_0x006a:
        r5 = r3.m5107a(r4);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0074;	 Catch:{ Exception -> 0x0089 }
    L_0x006f:
        r5 = new com.facebook.ads.internal.p.a.n;	 Catch:{ Exception -> 0x0089 }
        r5.<init>(r4, r1);	 Catch:{ Exception -> 0x0089 }
    L_0x0074:
        r6 = r3.f4288c;
        r6 = r6.mo980a();
        if (r6 == 0) goto L_0x0081;
    L_0x007c:
        r6 = r3.f4288c;
        r6.mo977a(r5);
    L_0x0081:
        if (r4 == 0) goto L_0x0086;
    L_0x0083:
        r4.disconnect();
    L_0x0086:
        return r5;
    L_0x0087:
        r5 = move-exception;
        goto L_0x00c7;
    L_0x0089:
        r5 = move-exception;
        goto L_0x0090;
    L_0x008b:
        r5 = move-exception;
        r4 = r1;
        goto L_0x00c7;
    L_0x008e:
        r5 = move-exception;
        r4 = r1;
    L_0x0090:
        r6 = r3.m5116b(r4);	 Catch:{ Exception -> 0x00b8 }
        if (r6 == 0) goto L_0x00b2;
    L_0x0096:
        r7 = r6.m5133a();	 Catch:{ all -> 0x00af }
        if (r7 <= 0) goto L_0x00b2;
    L_0x009c:
        r5 = r3.f4288c;
        r5 = r5.mo980a();
        if (r5 == 0) goto L_0x00a9;
    L_0x00a4:
        r5 = r3.f4288c;
        r5.mo977a(r6);
    L_0x00a9:
        if (r4 == 0) goto L_0x00ae;
    L_0x00ab:
        r4.disconnect();
    L_0x00ae:
        return r6;
    L_0x00af:
        r5 = move-exception;
        r1 = r6;
        goto L_0x00c7;
    L_0x00b2:
        r7 = new com.facebook.ads.internal.p.a.m;	 Catch:{ all -> 0x00af }
        r7.<init>(r5, r6);	 Catch:{ all -> 0x00af }
        throw r7;	 Catch:{ all -> 0x00af }
    L_0x00b8:
        r5.printStackTrace();	 Catch:{ all -> 0x00c1 }
        r6 = new com.facebook.ads.internal.p.a.m;	 Catch:{ all -> 0x0087 }
        r6.<init>(r5, r1);	 Catch:{ all -> 0x0087 }
        throw r6;	 Catch:{ all -> 0x0087 }
    L_0x00c1:
        r6 = new com.facebook.ads.internal.p.a.m;	 Catch:{ all -> 0x0087 }
        r6.<init>(r5, r1);	 Catch:{ all -> 0x0087 }
        throw r6;	 Catch:{ all -> 0x0087 }
    L_0x00c7:
        r6 = r3.f4288c;
        r6 = r6.mo980a();
        if (r6 == 0) goto L_0x00d4;
    L_0x00cf:
        r6 = r3.f4288c;
        r6.mo977a(r1);
    L_0x00d4:
        if (r4 == 0) goto L_0x00d9;
    L_0x00d6:
        r4.disconnect();
    L_0x00d9:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(java.lang.String, com.facebook.ads.internal.p.a.j, java.lang.String, byte[]):com.facebook.ads.internal.p.a.n");
    }

    /* renamed from: a */
    public C1450n m5105a(String str, C1452p c1452p) {
        return m5114b(new C3599i(str, c1452p));
    }

    /* renamed from: a */
    public C1450n m5106a(String str, String str2, byte[] bArr) {
        return m5114b(new C3600k(str, null, str2, bArr));
    }

    /* renamed from: a */
    protected com.facebook.ads.internal.p101p.p102a.C1450n m5107a(java.net.HttpURLConnection r4) {
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
        r3 = this;
        r0 = 0;
        r1 = r3.f4286a;	 Catch:{ all -> 0x001d }
        r1 = r1.mo976b(r4);	 Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r3.f4286a;	 Catch:{ all -> 0x0010 }
        r0 = r0.mo975a(r1);	 Catch:{ all -> 0x0010 }
        goto L_0x0012;	 Catch:{ all -> 0x0010 }
    L_0x0010:
        r4 = move-exception;	 Catch:{ all -> 0x0010 }
        goto L_0x001f;	 Catch:{ all -> 0x0010 }
    L_0x0012:
        r2 = new com.facebook.ads.internal.p.a.n;	 Catch:{ all -> 0x0010 }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x0010 }
        if (r1 == 0) goto L_0x001c;
    L_0x0019:
        r1.close();	 Catch:{ Exception -> 0x001c }
    L_0x001c:
        return r2;
    L_0x001d:
        r4 = move-exception;
        r1 = r0;
    L_0x001f:
        if (r1 == 0) goto L_0x0024;
    L_0x0021:
        r1.close();	 Catch:{ Exception -> 0x0024 }
    L_0x0024:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.a(java.net.HttpURLConnection):com.facebook.ads.internal.p.a.n");
    }

    /* renamed from: a */
    protected HttpURLConnection m5108a(String str) {
        try {
            URL url = new URL(str);
            return this.f4286a.mo971a(str);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is not a valid URL");
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    /* renamed from: a */
    protected void m5109a(C1448l c1448l, C1444b c1444b) {
        this.f4287b.mo969a(this, c1444b).mo981a(c1448l);
    }

    /* renamed from: a */
    public void m5110a(String str, C1452p c1452p, C1444b c1444b) {
        m5109a(new C3600k(str, c1452p), c1444b);
    }

    /* renamed from: a */
    protected void m5111a(HttpURLConnection httpURLConnection, C1447j c1447j, String str) {
        httpURLConnection.setConnectTimeout(this.f4289d);
        httpURLConnection.setReadTimeout(this.f4290e);
        this.f4286a.mo973a(httpURLConnection, c1447j, str);
    }

    /* renamed from: a */
    public void m5112a(Set<String> set) {
        this.f4295l = set;
    }

    /* renamed from: a */
    protected boolean m5113a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f4288c.mo980a()) {
            C1454r c1454r = this.f4288c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ELAPSED TIME = ");
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(", CT = ");
            stringBuilder.append(this.f4289d);
            stringBuilder.append(", RT = ");
            stringBuilder.append(this.f4290e);
            c1454r.mo978a(stringBuilder.toString());
        }
        boolean z = false;
        if (this.f4293j) {
            if (currentTimeMillis >= ((long) this.f4290e)) {
                z = true;
            }
            return z;
        }
        if (currentTimeMillis >= ((long) this.f4289d)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public C1450n m5114b(C1448l c1448l) {
        try {
            return m5104a(c1448l.m5128a(), c1448l.m5129b(), c1448l.m5130c(), c1448l.m5131d());
        } catch (C1449m e) {
            this.f4286a.mo974a(e);
            return null;
        } catch (Exception e2) {
            this.f4286a.mo974a(new C1449m(e2, null));
            return null;
        }
    }

    /* renamed from: b */
    public C1450n m5115b(String str, C1452p c1452p) {
        return m5114b(new C3600k(str, c1452p));
    }

    /* renamed from: b */
    protected com.facebook.ads.internal.p101p.p102a.C1450n m5116b(java.net.HttpURLConnection r4) {
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
        r3 = this;
        r0 = 0;
        r1 = r4.getErrorStream();	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r3.f4286a;	 Catch:{ all -> 0x000e }
        r0 = r0.mo975a(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0010;	 Catch:{ all -> 0x000e }
    L_0x000e:
        r4 = move-exception;	 Catch:{ all -> 0x000e }
        goto L_0x001d;	 Catch:{ all -> 0x000e }
    L_0x0010:
        r2 = new com.facebook.ads.internal.p.a.n;	 Catch:{ all -> 0x000e }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x000e }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return r2;
    L_0x001b:
        r4 = move-exception;
        r1 = r0;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ Exception -> 0x0022 }
    L_0x0022:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.a.a.b(java.net.HttpURLConnection):com.facebook.ads.internal.p.a.n");
    }

    /* renamed from: b */
    public C1452p m5117b() {
        return new C1452p();
    }

    /* renamed from: b */
    public void m5118b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f4291h = i;
    }

    /* renamed from: b */
    public void m5119b(Set<String> set) {
        this.f4294k = set;
    }

    /* renamed from: c */
    public void m5120c(int i) {
        this.f4289d = i;
    }
}
