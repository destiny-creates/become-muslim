package com.facebook.ads.internal.p100o;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.p091f.C1380e;
import com.facebook.ads.internal.p091f.C3578a;
import com.facebook.ads.internal.p092g.C1384a;
import com.facebook.ads.internal.p093h.C1388c;
import com.facebook.ads.internal.p096k.C1404a;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p101p.p102a.C1443a;
import com.facebook.ads.internal.p101p.p102a.C1444b;
import com.facebook.ads.internal.p101p.p102a.C1449m;
import com.facebook.ads.internal.p101p.p102a.C1450n;
import com.facebook.ads.internal.p105q.p106a.C1506i;
import com.facebook.ads.internal.p105q.p106a.C1510m;
import com.facebook.ads.internal.p105q.p108c.C1535d;
import com.facebook.ads.internal.p105q.p108c.C1535d.C1534a;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1492i;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.facebook.ads.internal.o.c */
public class C1438c {
    /* renamed from: i */
    private static final C1510m f4264i = new C1510m();
    /* renamed from: j */
    private static final ThreadPoolExecutor f4265j = ((ThreadPoolExecutor) Executors.newCachedThreadPool(f4264i));
    /* renamed from: a */
    private final Context f4266a;
    /* renamed from: b */
    private final C1440e f4267b = C1440e.m5087a();
    /* renamed from: c */
    private final C1405a f4268c = C1405a.m4843x(this.f4266a);
    /* renamed from: d */
    private Map<String, String> f4269d;
    /* renamed from: e */
    private C1437a f4270e;
    /* renamed from: f */
    private C1434b f4271f;
    /* renamed from: g */
    private C1443a f4272g;
    /* renamed from: h */
    private final String f4273h = C1439d.m5085a();

    /* renamed from: com.facebook.ads.internal.o.c$a */
    public interface C1437a {
        /* renamed from: a */
        void mo915a(C3593g c3593g);

        /* renamed from: a */
        void mo916a(C1481a c1481a);
    }

    /* renamed from: com.facebook.ads.internal.o.c$2 */
    class C35922 extends C1444b {
        /* renamed from: a */
        final /* synthetic */ C1438c f9598a;

        C35922(C1438c c1438c) {
            this.f9598a = c1438c;
        }

        /* renamed from: a */
        void m11710a(com.facebook.ads.internal.p101p.p102a.C1449m r5) {
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
            r0 = r4.f9598a;
            r0 = r0.f4271f;
            com.facebook.ads.internal.p100o.C1433a.m5055b(r0);
            r0 = r4.f9598a;
            r1 = 0;
            r0.f4272g = r1;
            r0 = r5.m5132a();	 Catch:{ JSONException -> 0x0049 }
            if (r0 == 0) goto L_0x0049;	 Catch:{ JSONException -> 0x0049 }
        L_0x0015:
            r0 = r0.m5137e();	 Catch:{ JSONException -> 0x0049 }
            r1 = r4.f9598a;	 Catch:{ JSONException -> 0x0049 }
            r1 = r1.f4267b;	 Catch:{ JSONException -> 0x0049 }
            r1 = r1.m5091a(r0);	 Catch:{ JSONException -> 0x0049 }
            r2 = r1.m5093b();	 Catch:{ JSONException -> 0x0049 }
            r3 = com.facebook.ads.internal.p100o.C1442f.C1441a.ERROR;	 Catch:{ JSONException -> 0x0049 }
            if (r2 != r3) goto L_0x0049;	 Catch:{ JSONException -> 0x0049 }
        L_0x002b:
            r1 = (com.facebook.ads.internal.p100o.C3594h) r1;	 Catch:{ JSONException -> 0x0049 }
            r2 = r1.m11715f();	 Catch:{ JSONException -> 0x0049 }
            r1 = r1.m11716g();	 Catch:{ JSONException -> 0x0049 }
            r3 = com.facebook.ads.internal.protocol.AdErrorType.ERROR_MESSAGE;	 Catch:{ JSONException -> 0x0049 }
            r1 = com.facebook.ads.internal.protocol.AdErrorType.adErrorTypeFromCode(r1, r3);	 Catch:{ JSONException -> 0x0049 }
            r3 = r4.f9598a;	 Catch:{ JSONException -> 0x0049 }
            if (r2 != 0) goto L_0x0040;	 Catch:{ JSONException -> 0x0049 }
        L_0x003f:
            goto L_0x0041;	 Catch:{ JSONException -> 0x0049 }
        L_0x0040:
            r0 = r2;	 Catch:{ JSONException -> 0x0049 }
        L_0x0041:
            r0 = com.facebook.ads.internal.protocol.C1481a.m5241a(r1, r0);	 Catch:{ JSONException -> 0x0049 }
            r3.m5073a(r0);	 Catch:{ JSONException -> 0x0049 }
            return;
        L_0x0049:
            r0 = r4.f9598a;
            r1 = com.facebook.ads.internal.protocol.AdErrorType.NETWORK_ERROR;
            r5 = r5.getMessage();
            r5 = com.facebook.ads.internal.protocol.C1481a.m5241a(r1, r5);
            r0.m5073a(r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.c.2.a(com.facebook.ads.internal.p.a.m):void");
        }

        /* renamed from: a */
        public void mo966a(C1450n c1450n) {
            if (c1450n != null) {
                String e = c1450n.m5137e();
                C1433a.m5055b(this.f9598a.f4271f);
                this.f9598a.f4272g = null;
                this.f9598a.m5074a(e);
            }
        }

        /* renamed from: a */
        public void mo967a(Exception exception) {
            if (C1449m.class.equals(exception.getClass())) {
                m11710a((C1449m) exception);
            } else {
                this.f9598a.m5073a(C1481a.m5241a(AdErrorType.NETWORK_ERROR, exception.getMessage()));
            }
        }
    }

    public C1438c(Context context) {
        this.f4266a = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m5072a(C3593g c3593g) {
        if (this.f4270e != null) {
            this.f4270e.mo915a(c3593g);
        }
        m5082a();
    }

    /* renamed from: a */
    private void m5073a(C1481a c1481a) {
        if (this.f4270e != null) {
            this.f4270e.mo916a(c1481a);
        }
        m5082a();
    }

    /* renamed from: a */
    private void m5074a(String str) {
        try {
            C1481a a;
            C1442f a2 = this.f4267b.m5091a(str);
            C1388c a3 = a2.mo968a();
            if (a3 != null) {
                this.f4268c.m4847a(a3.m4761b());
                C1433a.m5052a(a3.m4759a().m4769d(), this.f4271f);
            }
            String c;
            switch (a2.m5093b()) {
                case ADS:
                    C3593g c3593g = (C3593g) a2;
                    if (a3 != null) {
                        if (a3.m4759a().m4770e()) {
                            C1433a.m5053a(str, this.f4271f);
                        }
                        Object obj = this.f4269d != null ? (String) this.f4269d.get("CLIENT_REQUEST_ID") : null;
                        c = a2.m5094c();
                        if (!(TextUtils.isEmpty(c) || TextUtils.isEmpty(obj))) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < "9n016rsr18194oq187s9s48p6n0sr7s8".length(); i++) {
                                int i2;
                                char charAt = "9n016rsr18194oq187s9s48p6n0sr7s8".charAt(i);
                                if ((charAt < 'a' || charAt > 'm') && (charAt < 'A' || charAt > 'M')) {
                                    if ((charAt >= 'n' && charAt <= 'z') || (charAt >= 'N' && charAt <= 'Z')) {
                                        i2 = charAt - 13;
                                    }
                                    stringBuilder.append(charAt);
                                } else {
                                    i2 = charAt + 13;
                                }
                                charAt = (char) i2;
                                stringBuilder.append(charAt);
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(obj);
                            stringBuilder2.append(c);
                            stringBuilder2.append(stringBuilder.toString());
                            byte[] bytes = stringBuilder2.toString().getBytes("iso-8859-1");
                            MessageDigest instance = MessageDigest.getInstance("SHA-1");
                            instance.update(bytes, 0, bytes.length);
                            if (!a2.m5095d().equals(C1506i.m5302a(instance.digest()))) {
                                C1540a.m5396a(this.f4266a, "network", C1541b.f4563h, new C1492i());
                            }
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(c);
                            stringBuilder2.append(obj);
                            stringBuilder2.append(stringBuilder.toString());
                            byte[] bytes2 = stringBuilder2.toString().getBytes("iso-8859-1");
                            MessageDigest instance2 = MessageDigest.getInstance("SHA-1");
                            instance2.update(bytes2, 0, bytes2.length);
                            C1380e.m4722a(new C3578a(c, C1506i.m5302a(instance2.digest())), this.f4266a);
                        }
                        if (!(TextUtils.isEmpty(a2.m5096e()) || TextUtils.isEmpty(obj))) {
                            new C1404a(this.f4266a, obj, a2.m5096e()).m4817a();
                        }
                    }
                    m5072a(c3593g);
                    return;
                case ERROR:
                    C3594h c3594h = (C3594h) a2;
                    c = c3594h.m11715f();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c3594h.m11716g(), AdErrorType.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    a = C1481a.m5241a(adErrorTypeFromCode, str);
                    break;
                default:
                    a = C1481a.m5241a(AdErrorType.UNKNOWN_RESPONSE, str);
                    break;
            }
            m5073a(a);
        } catch (Exception e) {
            m5073a(C1481a.m5241a(AdErrorType.PARSER_FAILURE, e.getMessage()));
        }
    }

    /* renamed from: b */
    private C1444b m5075b() {
        return new C35922(this);
    }

    /* renamed from: a */
    public void m5082a() {
        if (this.f4272g != null) {
            this.f4272g.m5120c(1);
            this.f4272g.m5118b(1);
            this.f4272g = null;
        }
    }

    /* renamed from: a */
    public void m5083a(final C1434b c1434b) {
        m5082a();
        if (C1535d.m5375c(this.f4266a) == C1534a.NONE) {
            m5073a(new C1481a(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f4271f = c1434b;
        C1384a.m4732a(this.f4266a);
        if (C1433a.m5054a(c1434b)) {
            String c = C1433a.m5056c(c1434b);
            if (c != null) {
                m5074a(c);
                return;
            } else {
                m5073a(C1481a.m5241a(AdErrorType.LOAD_TOO_FREQUENTLY, null));
                return;
            }
        }
        f4265j.submit(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C1438c f4262b;

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
                r6 = this;
                r0 = r6.f4262b;
                r0 = r0.f4266a;
                com.facebook.ads.internal.p088c.C1355b.m4643a(r0);
                r0 = r3;
                r0 = r0.m5063e();
                r0 = r0.m5258a();
                if (r0 == 0) goto L_0x003b;
            L_0x0015:
                r0 = r3;	 Catch:{ b -> 0x0021 }
                r0 = r0.m5063e();	 Catch:{ b -> 0x0021 }
                r1 = com.facebook.ads.internal.p088c.C1355b.f3939b;	 Catch:{ b -> 0x0021 }
                r0.m5257a(r1);	 Catch:{ b -> 0x0021 }
                goto L_0x002b;
            L_0x0021:
                r0 = move-exception;
                r1 = r6.f4262b;
                r0 = com.facebook.ads.internal.protocol.C1481a.m5242a(r0);
                r1.m5073a(r0);
            L_0x002b:
                r0 = r6.f4262b;
                r1 = r3;
                r1 = r1.m5063e();
                r1 = r1.m5259b();
                r0.m5074a(r1);
                return;
            L_0x003b:
                r0 = r6.f4262b;
                r1 = r3;
                r1 = r1.m5064f();
                r0.f4269d = r1;
                r0 = r6.f4262b;	 Catch:{ Exception -> 0x0095 }
                r0 = r0.f4269d;	 Catch:{ Exception -> 0x0095 }
                r1 = "M_BANNER_KEY";	 Catch:{ Exception -> 0x0095 }
                r2 = new java.lang.String;	 Catch:{ Exception -> 0x0095 }
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0095 }
                r3.<init>();	 Catch:{ Exception -> 0x0095 }
                r4 = r6.f4262b;	 Catch:{ Exception -> 0x0095 }
                r4 = r4.f4266a;	 Catch:{ Exception -> 0x0095 }
                r4 = r4.getPackageName();	 Catch:{ Exception -> 0x0095 }
                r3.append(r4);	 Catch:{ Exception -> 0x0095 }
                r4 = " ";	 Catch:{ Exception -> 0x0095 }
                r3.append(r4);	 Catch:{ Exception -> 0x0095 }
                r4 = r6.f4262b;	 Catch:{ Exception -> 0x0095 }
                r4 = r4.f4266a;	 Catch:{ Exception -> 0x0095 }
                r4 = r4.getPackageManager();	 Catch:{ Exception -> 0x0095 }
                r5 = r6.f4262b;	 Catch:{ Exception -> 0x0095 }
                r5 = r5.f4266a;	 Catch:{ Exception -> 0x0095 }
                r5 = r5.getPackageName();	 Catch:{ Exception -> 0x0095 }
                r4 = r4.getInstallerPackageName(r5);	 Catch:{ Exception -> 0x0095 }
                r3.append(r4);	 Catch:{ Exception -> 0x0095 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x0095 }
                r3 = r3.getBytes();	 Catch:{ Exception -> 0x0095 }
                r4 = 2;	 Catch:{ Exception -> 0x0095 }
                r3 = android.util.Base64.encode(r3, r4);	 Catch:{ Exception -> 0x0095 }
                r2.<init>(r3);	 Catch:{ Exception -> 0x0095 }
                r0.put(r1, r2);	 Catch:{ Exception -> 0x0095 }
            L_0x0095:
                r0 = r3;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.f4248c;	 Catch:{ Exception -> 0x00f0 }
                r1 = com.facebook.ads.internal.protocol.C1487f.NATIVE_250;	 Catch:{ Exception -> 0x00f0 }
                if (r0 == r1) goto L_0x00b6;	 Catch:{ Exception -> 0x00f0 }
            L_0x009d:
                r0 = r3;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.f4248c;	 Catch:{ Exception -> 0x00f0 }
                r1 = com.facebook.ads.internal.protocol.C1487f.NATIVE_UNKNOWN;	 Catch:{ Exception -> 0x00f0 }
                if (r0 == r1) goto L_0x00b6;	 Catch:{ Exception -> 0x00f0 }
            L_0x00a5:
                r0 = r3;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.f4248c;	 Catch:{ Exception -> 0x00f0 }
                r1 = com.facebook.ads.internal.protocol.C1487f.NATIVE_BANNER;	 Catch:{ Exception -> 0x00f0 }
                if (r0 == r1) goto L_0x00b6;	 Catch:{ Exception -> 0x00f0 }
            L_0x00ad:
                r0 = r3;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.f4248c;	 Catch:{ Exception -> 0x00f0 }
                if (r0 != 0) goto L_0x00b4;	 Catch:{ Exception -> 0x00f0 }
            L_0x00b3:
                goto L_0x00b6;	 Catch:{ Exception -> 0x00f0 }
            L_0x00b4:
                r0 = 0;	 Catch:{ Exception -> 0x00f0 }
                goto L_0x00b7;	 Catch:{ Exception -> 0x00f0 }
            L_0x00b6:
                r0 = 1;	 Catch:{ Exception -> 0x00f0 }
            L_0x00b7:
                r1 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r2 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r2 = r2.f4266a;	 Catch:{ Exception -> 0x00f0 }
                r0 = com.facebook.ads.internal.p105q.p108c.C1535d.m5374b(r2, r0);	 Catch:{ Exception -> 0x00f0 }
                r1.f4272g = r0;	 Catch:{ Exception -> 0x00f0 }
                r0 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.f4272g;	 Catch:{ Exception -> 0x00f0 }
                r1 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r1 = r1.f4273h;	 Catch:{ Exception -> 0x00f0 }
                r2 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r2 = r2.f4272g;	 Catch:{ Exception -> 0x00f0 }
                r2 = r2.m5117b();	 Catch:{ Exception -> 0x00f0 }
                r3 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r3 = r3.f4269d;	 Catch:{ Exception -> 0x00f0 }
                r2 = r2.m5140a(r3);	 Catch:{ Exception -> 0x00f0 }
                r3 = r6.f4262b;	 Catch:{ Exception -> 0x00f0 }
                r3 = r3.m5075b();	 Catch:{ Exception -> 0x00f0 }
                r0.m5110a(r1, r2, r3);	 Catch:{ Exception -> 0x00f0 }
                goto L_0x0100;
            L_0x00f0:
                r0 = move-exception;
                r1 = r6.f4262b;
                r2 = com.facebook.ads.internal.protocol.AdErrorType.AD_REQUEST_FAILED;
                r0 = r0.getMessage();
                r0 = com.facebook.ads.internal.protocol.C1481a.m5241a(r2, r0);
                r1.m5073a(r0);
            L_0x0100:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.c.1.run():void");
            }
        });
    }

    /* renamed from: a */
    public void m5084a(C1437a c1437a) {
        this.f4270e = c1437a;
    }
}
