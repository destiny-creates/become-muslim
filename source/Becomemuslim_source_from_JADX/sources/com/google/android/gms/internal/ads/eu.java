package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

@cm
public final class eu extends du {
    /* renamed from: a */
    private static final Object f28650a = new Object();
    /* renamed from: b */
    private static eu f28651b;
    /* renamed from: c */
    private final Context f28652c;
    /* renamed from: d */
    private final et f28653d;
    /* renamed from: e */
    private final ScheduledExecutorService f28654e = Executors.newSingleThreadScheduledExecutor();

    private eu(Context context, et etVar) {
        this.f28652c = context;
        this.f28653d = etVar;
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.ads.dp m37473a(android.content.Context r19, com.google.android.gms.internal.ads.et r20, com.google.android.gms.internal.ads.dl r21, java.util.concurrent.ScheduledExecutorService r22) {
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
        r1 = r19;
        r8 = r20;
        r0 = r21;
        r2 = r22;
        r3 = "Starting ad request from service using: google.afma.request.getAdDictionary";
        com.google.android.gms.internal.ads.mt.m19918b(r3);
        r9 = new com.google.android.gms.internal.ads.atc;
        r3 = com.google.android.gms.internal.ads.asp.f14923N;
        r4 = com.google.android.gms.internal.ads.aph.m18688f();
        r3 = r4.m18889a(r3);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        r4 = "load_ad";
        r5 = r0.f28548d;
        r5 = r5.f28279a;
        r9.<init>(r3, r4, r5);
        r3 = r0.f28545a;
        r4 = 10;
        if (r3 <= r4) goto L_0x0045;
    L_0x002e:
        r3 = r0.f28519A;
        r5 = -1;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x0045;
    L_0x0036:
        r3 = r0.f28519A;
        r3 = r9.m18917a(r3);
        r4 = "cts";
        r4 = new java.lang.String[]{r4};
        r9.m18922a(r3, r4);
    L_0x0045:
        r10 = r9.m18916a();
        r3 = r8.f15363i;
        r3 = r3.mo4390a(r1);
        r4 = com.google.android.gms.internal.ads.asp.cA;
        r5 = com.google.android.gms.internal.ads.aph.m18688f();
        r4 = r5.m18889a(r4);
        r4 = (java.lang.Long) r4;
        r4 = r4.longValue();
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r3 = com.google.android.gms.internal.ads.nd.m19939a(r3, r4, r6, r2);
        r4 = r8.f15362h;
        r4 = r4.mo4244a(r1);
        r5 = com.google.android.gms.internal.ads.asp.bv;
        r6 = com.google.android.gms.internal.ads.aph.m18688f();
        r5 = r6.m18889a(r5);
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r4 = com.google.android.gms.internal.ads.nd.m19939a(r4, r5, r7, r2);
        r5 = r8.f15357c;
        r6 = r0.f28551g;
        r6 = r6.packageName;
        r5 = r5.mo4299a(r6);
        r6 = r8.f15357c;
        r7 = r0.f28551g;
        r7 = r7.packageName;
        r6 = r6.mo4300b(r7);
        r7 = r8.f15364j;
        r11 = r0.f28552h;
        r12 = r0.f28551g;
        r7 = r7.mo4302a(r11, r12);
        r11 = com.google.android.gms.ads.internal.ax.p();
        r11 = r11.m19437a(r1);
        r12 = 0;
        r13 = com.google.android.gms.internal.ads.nd.m19938a(r12);
        r14 = r0.f28547c;
        r14 = r14.f28263c;
        if (r14 == 0) goto L_0x00bc;
    L_0x00b2:
        r15 = "_ad";
        r14 = r14.getString(r15);
        if (r14 == 0) goto L_0x00bc;
    L_0x00ba:
        r15 = 1;
        goto L_0x00bd;
    L_0x00bc:
        r15 = 0;
    L_0x00bd:
        r14 = r0.f28525G;
        if (r14 == 0) goto L_0x00cb;
    L_0x00c1:
        if (r15 != 0) goto L_0x00cb;
    L_0x00c3:
        r13 = r8.f15360f;
        r14 = r0.f28550f;
        r13 = r13.mo4096a(r14);
    L_0x00cb:
        r14 = com.google.android.gms.internal.ads.asp.cr;
        r15 = com.google.android.gms.internal.ads.aph.m18688f();
        r14 = r15.m18889a(r14);
        r14 = (java.lang.Long) r14;
        r14 = r14.longValue();
        r16 = r9;
        r9 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r9 = com.google.android.gms.internal.ads.nd.m19939a(r13, r14, r9, r2);
        r13 = com.google.android.gms.internal.ads.nd.m19938a(r12);
        r14 = com.google.android.gms.internal.ads.asp.aJ;
        r15 = com.google.android.gms.internal.ads.aph.m18688f();
        r14 = r15.m18889a(r14);
        r14 = (java.lang.Boolean) r14;
        r14 = r14.booleanValue();
        if (r14 == 0) goto L_0x0115;
    L_0x00f9:
        r13 = r8.f15364j;
        r13 = r13.mo4301a(r1);
        r14 = com.google.android.gms.internal.ads.asp.aK;
        r15 = com.google.android.gms.internal.ads.aph.m18688f();
        r14 = r15.m18889a(r14);
        r14 = (java.lang.Long) r14;
        r14 = r14.longValue();
        r12 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r13 = com.google.android.gms.internal.ads.nd.m19939a(r13, r14, r12, r2);
    L_0x0115:
        r12 = r0.f28545a;
        r14 = 4;
        if (r12 < r14) goto L_0x0121;
    L_0x011a:
        r12 = r0.f28559o;
        if (r12 == 0) goto L_0x0121;
    L_0x011e:
        r12 = r0.f28559o;
        goto L_0x0122;
    L_0x0121:
        r12 = 0;
    L_0x0122:
        r14 = com.google.android.gms.internal.ads.asp.ad;
        r15 = com.google.android.gms.internal.ads.aph.m18688f();
        r14 = r15.m18889a(r14);
        r14 = (java.lang.Boolean) r14;
        r14.booleanValue();
        com.google.android.gms.ads.internal.ax.e();
        r14 = "android.permission.ACCESS_NETWORK_STATE";
        r14 = com.google.android.gms.internal.ads.jw.m19707a(r1, r14);
        if (r14 == 0) goto L_0x014f;
    L_0x013c:
        r14 = "connectivity";
        r14 = r1.getSystemService(r14);
        r14 = (android.net.ConnectivityManager) r14;
        r14 = r14.getActiveNetworkInfo();
        if (r14 != 0) goto L_0x014f;
    L_0x014a:
        r14 = "Device is offline.";
        com.google.android.gms.internal.ads.mt.m19918b(r14);
    L_0x014f:
        r14 = r0.f28545a;
        r15 = 7;
        if (r14 < r15) goto L_0x0157;
    L_0x0154:
        r14 = r0.f28566v;
        goto L_0x015f;
    L_0x0157:
        r14 = java.util.UUID.randomUUID();
        r14 = r14.toString();
    L_0x015f:
        r15 = new com.google.android.gms.internal.ads.fa;
        r2 = r0.f28550f;
        r2 = r2.packageName;
        r15.<init>(r1, r14, r2);
        r2 = r0.f28547c;
        r2 = r2.f28263c;
        if (r2 == 0) goto L_0x017f;
    L_0x016e:
        r2 = r0.f28547c;
        r2 = r2.f28263c;
        r15 = "_ad";
        r2 = r2.getString(r15);
        if (r2 == 0) goto L_0x017f;
    L_0x017a:
        r0 = com.google.android.gms.internal.ads.ez.m19396a(r1, r0, r2);
        return r0;
    L_0x017f:
        r2 = r8.f15358d;
        r15 = r0.f28567w;
        r2 = r2.mo3954a(r15);
        r15 = com.google.android.gms.internal.ads.asp.cA;
        r17 = r10;
        r10 = com.google.android.gms.internal.ads.aph.m18688f();
        r10 = r10.m18889a(r15);
        r10 = (java.lang.Long) r10;
        r18 = r14;
        r14 = r10.longValue();
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r1 = 0;
        r3 = com.google.android.gms.internal.ads.nd.m19944a(r3, r1, r14, r10);
        r3 = (android.os.Bundle) r3;
        r4 = com.google.android.gms.internal.ads.nd.m19943a(r4, r1);
        r4 = (com.google.android.gms.internal.ads.fs) r4;
        r9 = com.google.android.gms.internal.ads.nd.m19943a(r9, r1);
        r9 = (android.location.Location) r9;
        r10 = com.google.android.gms.internal.ads.nd.m19943a(r13, r1);
        r10 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r10;
        r7 = com.google.android.gms.internal.ads.nd.m19943a(r7, r1);
        r7 = (java.lang.String) r7;
        r5 = com.google.android.gms.internal.ads.nd.m19943a(r5, r1);
        r5 = (java.lang.String) r5;
        r6 = com.google.android.gms.internal.ads.nd.m19943a(r6, r1);
        r6 = (java.lang.String) r6;
        r11 = com.google.android.gms.internal.ads.nd.m19943a(r11, r1);
        r11 = (com.google.android.gms.internal.ads.fi) r11;
        if (r11 != 0) goto L_0x01dc;
    L_0x01d0:
        r0 = "Error fetching device info. This is not recoverable.";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
        r0 = new com.google.android.gms.internal.ads.dp;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x01dc:
        r1 = new com.google.android.gms.internal.ads.es;
        r1.<init>();
        r1.f15351j = r0;
        r1.f15352k = r11;
        r1.f15346e = r4;
        r1.f15345d = r9;
        r1.f15343b = r3;
        r1.f15349h = r7;
        r1.f15350i = r10;
        if (r2 != 0) goto L_0x01f6;
    L_0x01f1:
        r3 = r1.f15344c;
        r3.clear();
    L_0x01f6:
        r1.f15344c = r2;
        r1.f15342a = r12;
        r1.f15347f = r5;
        r1.f15348g = r6;
        r2 = r8.f15356b;
        r3 = r19;
        r2 = r2.mo3848a(r3);
        r1.f15353l = r2;
        r2 = r8.f15365k;
        r1.f15354m = r2;
        r1 = com.google.android.gms.internal.ads.ez.m19400a(r3, r1);
        if (r1 != 0) goto L_0x0219;
    L_0x0212:
        r0 = new com.google.android.gms.internal.ads.dp;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x0219:
        r2 = r0.f28545a;
        r4 = 7;
        if (r2 >= r4) goto L_0x0227;
    L_0x021e:
        r2 = "request_id";	 Catch:{ JSONException -> 0x0226 }
        r14 = r18;	 Catch:{ JSONException -> 0x0226 }
        r1.put(r2, r14);	 Catch:{ JSONException -> 0x0226 }
        goto L_0x0227;
    L_0x0227:
        r2 = "arc";
        r2 = new java.lang.String[]{r2};
        r9 = r16;
        r10 = r17;
        r9.m18922a(r10, r2);
        r9.m18916a();
        r2 = r8.f15366l;
        r2 = r2.mo4245a();
        r1 = r2.mo6092b(r1);
        r2 = com.google.android.gms.internal.ads.ev.f24070a;
        r4 = r22;
        r1 = com.google.android.gms.internal.ads.nd.m19940a(r1, r2, r4);
        r11 = 10;
        r2 = java.util.concurrent.TimeUnit.SECONDS;
        r1 = com.google.android.gms.internal.ads.nd.m19939a(r1, r11, r2, r4);
        r2 = r8.f15359e;
        r2 = r2.mo4241a();
        if (r2 == 0) goto L_0x025e;
    L_0x0259:
        r4 = "AdRequestServiceImpl.loadAd.flags";
        com.google.android.gms.internal.ads.nb.m19936a(r2, r4);
    L_0x025e:
        r2 = 0;
        r1 = com.google.android.gms.internal.ads.nd.m19943a(r1, r2);
        r7 = r1;
        r7 = (com.google.android.gms.internal.ads.fg) r7;
        if (r7 != 0) goto L_0x026f;
    L_0x0268:
        r0 = new com.google.android.gms.internal.ads.dp;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x026f:
        r1 = r7.m19418a();
        r4 = -2;
        if (r1 == r4) goto L_0x0280;
    L_0x0276:
        r0 = new com.google.android.gms.internal.ads.dp;
        r1 = r7.m19418a();
        r0.<init>(r1);
        return r0;
    L_0x0280:
        r9.m18925d();
        r1 = r7.m19427i();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0296;
    L_0x028d:
        r1 = r7.m19427i();
        r12 = com.google.android.gms.internal.ads.ez.m19396a(r3, r0, r1);
        goto L_0x0297;
    L_0x0296:
        r12 = r2;
    L_0x0297:
        if (r12 != 0) goto L_0x02ba;
    L_0x0299:
        r1 = r7.m19423e();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x02ba;
    L_0x02a3:
        r1 = r0.f28555k;
        r2 = r1.f28709a;
        r4 = r7.m19423e();
        r0 = r21;
        r1 = r19;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r9;
        r8 = r20;
        r12 = m37474a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x02ba:
        if (r12 != 0) goto L_0x02c2;
    L_0x02bc:
        r12 = new com.google.android.gms.internal.ads.dp;
        r0 = 0;
        r12.<init>(r0);
    L_0x02c2:
        r0 = "tts";
        r0 = new java.lang.String[]{r0};
        r9.m18922a(r10, r0);
        r0 = r9.m18923b();
        r12.f28618w = r0;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.eu.a(android.content.Context, com.google.android.gms.internal.ads.et, com.google.android.gms.internal.ads.dl, java.util.concurrent.ScheduledExecutorService):com.google.android.gms.internal.ads.dp");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static com.google.android.gms.internal.ads.dp m37474a(com.google.android.gms.internal.ads.dl r18, android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.google.android.gms.internal.ads.fg r24, com.google.android.gms.internal.ads.atc r25, com.google.android.gms.internal.ads.et r26) {
        /*
        r0 = r18;
        r1 = r25;
        r2 = r26;
        if (r1 == 0) goto L_0x000d;
    L_0x0008:
        r4 = r25.m18916a();
        goto L_0x000e;
    L_0x000d:
        r4 = 0;
    L_0x000e:
        r5 = new com.google.android.gms.internal.ads.fe;	 Catch:{ IOException -> 0x01d7 }
        r6 = r24.m19421c();	 Catch:{ IOException -> 0x01d7 }
        r5.<init>(r0, r6);	 Catch:{ IOException -> 0x01d7 }
        r6 = "AdRequestServiceImpl: Sending request: ";
        r7 = java.lang.String.valueOf(r21);	 Catch:{ IOException -> 0x01d7 }
        r8 = r7.length();	 Catch:{ IOException -> 0x01d7 }
        if (r8 == 0) goto L_0x0029;
    L_0x0023:
        r6 = r6.concat(r7);	 Catch:{ IOException -> 0x01d7 }
        r7 = r6;
        goto L_0x002e;
    L_0x0029:
        r7 = new java.lang.String;	 Catch:{ IOException -> 0x01d7 }
        r7.<init>(r6);	 Catch:{ IOException -> 0x01d7 }
    L_0x002e:
        com.google.android.gms.internal.ads.mt.m19918b(r7);	 Catch:{ IOException -> 0x01d7 }
        r6 = new java.net.URL;	 Catch:{ IOException -> 0x01d7 }
        r7 = r21;
        r6.<init>(r7);	 Catch:{ IOException -> 0x01d7 }
        r7 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ IOException -> 0x01d7 }
        r7 = r7.b();	 Catch:{ IOException -> 0x01d7 }
        r9 = 0;
        r10 = 0;
    L_0x0042:
        if (r2 == 0) goto L_0x0049;
    L_0x0044:
        r11 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r11.mo4242a();	 Catch:{ IOException -> 0x01d7 }
    L_0x0049:
        r11 = r6.openConnection();	 Catch:{ IOException -> 0x01d7 }
        r11 = (java.net.HttpURLConnection) r11;	 Catch:{ IOException -> 0x01d7 }
        r12 = com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x01cb }
        r13 = r19;
        r14 = r20;
        r12.m19740a(r13, r14, r9, r11);	 Catch:{ all -> 0x01cb }
        r12 = r24.m19425g();	 Catch:{ all -> 0x01cb }
        if (r12 == 0) goto L_0x007e;
    L_0x0060:
        r12 = android.text.TextUtils.isEmpty(r22);	 Catch:{ all -> 0x01cb }
        if (r12 != 0) goto L_0x006e;
    L_0x0066:
        r12 = "x-afma-drt-cookie";
        r15 = r22;
        r11.addRequestProperty(r12, r15);	 Catch:{ all -> 0x01cb }
        goto L_0x0070;
    L_0x006e:
        r15 = r22;
    L_0x0070:
        r12 = android.text.TextUtils.isEmpty(r23);	 Catch:{ all -> 0x01cb }
        if (r12 != 0) goto L_0x0080;
    L_0x0076:
        r12 = "x-afma-drt-v2-cookie";
        r9 = r23;
        r11.addRequestProperty(r12, r9);	 Catch:{ all -> 0x01cb }
        goto L_0x0082;
    L_0x007e:
        r15 = r22;
    L_0x0080:
        r9 = r23;
    L_0x0082:
        r12 = r0.f28526H;	 Catch:{ all -> 0x01cb }
        r16 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x01cb }
        if (r16 != 0) goto L_0x0094;
    L_0x008a:
        r16 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.ads.mt.m19918b(r16);	 Catch:{ all -> 0x01cb }
        r3 = "Cookie";
        r11.addRequestProperty(r3, r12);	 Catch:{ all -> 0x01cb }
    L_0x0094:
        r3 = 1;
        if (r24 == 0) goto L_0x00cb;
    L_0x0097:
        r16 = r24.m19422d();	 Catch:{ all -> 0x01cb }
        r16 = android.text.TextUtils.isEmpty(r16);	 Catch:{ all -> 0x01cb }
        if (r16 != 0) goto L_0x00cb;
    L_0x00a1:
        r11.setDoOutput(r3);	 Catch:{ all -> 0x01cb }
        r16 = r24.m19422d();	 Catch:{ all -> 0x01cb }
        r3 = r16.getBytes();	 Catch:{ all -> 0x01cb }
        r9 = r3.length;	 Catch:{ all -> 0x01cb }
        r11.setFixedLengthStreamingMode(r9);	 Catch:{ all -> 0x01cb }
        r9 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00c4 }
        r12 = r11.getOutputStream();	 Catch:{ all -> 0x00c4 }
        r9.<init>(r12);	 Catch:{ all -> 0x00c4 }
        r9.write(r3);	 Catch:{ all -> 0x00c0 }
        com.google.android.gms.common.util.C2902m.a(r9);	 Catch:{ all -> 0x01cb }
        goto L_0x00cc;
    L_0x00c0:
        r0 = move-exception;
        r17 = r9;
        goto L_0x00c7;
    L_0x00c4:
        r0 = move-exception;
        r17 = 0;
    L_0x00c7:
        com.google.android.gms.common.util.C2902m.a(r17);	 Catch:{ all -> 0x01cb }
        throw r0;	 Catch:{ all -> 0x01cb }
    L_0x00cb:
        r3 = 0;
    L_0x00cc:
        r9 = new com.google.android.gms.internal.ads.mm;	 Catch:{ all -> 0x01cb }
        r12 = r0.f28566v;	 Catch:{ all -> 0x01cb }
        r9.<init>(r12);	 Catch:{ all -> 0x01cb }
        r9.m19909a(r11, r3);	 Catch:{ all -> 0x01cb }
        r3 = r11.getResponseCode();	 Catch:{ all -> 0x01cb }
        r12 = r11.getHeaderFields();	 Catch:{ all -> 0x01cb }
        r9.m19908a(r11, r3);	 Catch:{ all -> 0x01cb }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r13 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r3 < r0) goto L_0x0132;
    L_0x00e7:
        if (r3 >= r13) goto L_0x0132;
    L_0x00e9:
        r0 = r6.toString();	 Catch:{ all -> 0x01cb }
        r6 = new java.io.InputStreamReader;	 Catch:{ all -> 0x012b }
        r10 = r11.getInputStream();	 Catch:{ all -> 0x012b }
        r6.<init>(r10);	 Catch:{ all -> 0x012b }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0127 }
        r10 = com.google.android.gms.internal.ads.jw.m19691a(r6);	 Catch:{ all -> 0x0127 }
        com.google.android.gms.common.util.C2902m.a(r6);	 Catch:{ all -> 0x01cb }
        r9.m19906a(r10);	 Catch:{ all -> 0x01cb }
        m37477a(r0, r12, r10, r3);	 Catch:{ all -> 0x01cb }
        r5.m19414a(r0, r12, r10);	 Catch:{ all -> 0x01cb }
        if (r1 == 0) goto L_0x0114;
    L_0x010b:
        r0 = "ufe";
        r0 = new java.lang.String[]{r0};	 Catch:{ all -> 0x01cb }
        r1.m18922a(r4, r0);	 Catch:{ all -> 0x01cb }
    L_0x0114:
        r0 = r24.m19428j();	 Catch:{ all -> 0x01cb }
        r0 = r5.m19413a(r7, r0);	 Catch:{ all -> 0x01cb }
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x0126;
    L_0x0121:
        r1 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r1.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x0126:
        return r0;
    L_0x0127:
        r0 = move-exception;
        r17 = r6;
        goto L_0x012e;
    L_0x012b:
        r0 = move-exception;
        r17 = 0;
    L_0x012e:
        com.google.android.gms.common.util.C2902m.a(r17);	 Catch:{ all -> 0x01cb }
        throw r0;	 Catch:{ all -> 0x01cb }
    L_0x0132:
        r0 = r6.toString();	 Catch:{ all -> 0x01cb }
        r6 = 0;
        m37477a(r0, r12, r6, r3);	 Catch:{ all -> 0x01cb }
        if (r3 < r13) goto L_0x01a4;
    L_0x013c:
        r0 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r3 >= r0) goto L_0x01a4;
    L_0x0140:
        r0 = "Location";
        r0 = r11.getHeaderField(r0);	 Catch:{ all -> 0x01cb }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x01cb }
        if (r3 == 0) goto L_0x0162;
    L_0x014c:
        r0 = "No location header to follow redirect.";
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ all -> 0x01cb }
        r0 = new com.google.android.gms.internal.ads.dp;	 Catch:{ all -> 0x01cb }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x01cb }
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x0161;
    L_0x015c:
        r1 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r1.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x0161:
        return r0;
    L_0x0162:
        r3 = new java.net.URL;	 Catch:{ all -> 0x01cb }
        r3.<init>(r0);	 Catch:{ all -> 0x01cb }
        r0 = 1;
        r10 = r10 + r0;
        r0 = com.google.android.gms.internal.ads.asp.df;	 Catch:{ all -> 0x01cb }
        r9 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x01cb }
        r0 = r9.m18889a(r0);	 Catch:{ all -> 0x01cb }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x01cb }
        r0 = r0.intValue();	 Catch:{ all -> 0x01cb }
        if (r10 <= r0) goto L_0x0191;
    L_0x017b:
        r0 = "Too many redirects.";
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ all -> 0x01cb }
        r0 = new com.google.android.gms.internal.ads.dp;	 Catch:{ all -> 0x01cb }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x01cb }
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x0190;
    L_0x018b:
        r1 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r1.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x0190:
        return r0;
    L_0x0191:
        r5.m19415a(r12);	 Catch:{ all -> 0x01cb }
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x019e;
    L_0x0199:
        r0 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r0.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x019e:
        r6 = r3;
        r0 = r18;
        r9 = 0;
        goto L_0x0042;
    L_0x01a4:
        r0 = 46;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01cb }
        r1.<init>(r0);	 Catch:{ all -> 0x01cb }
        r0 = "Received error HTTP response code: ";
        r1.append(r0);	 Catch:{ all -> 0x01cb }
        r1.append(r3);	 Catch:{ all -> 0x01cb }
        r0 = r1.toString();	 Catch:{ all -> 0x01cb }
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ all -> 0x01cb }
        r0 = new com.google.android.gms.internal.ads.dp;	 Catch:{ all -> 0x01cb }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x01cb }
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x01ca;
    L_0x01c5:
        r1 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r1.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x01ca:
        return r0;
    L_0x01cb:
        r0 = move-exception;
        r11.disconnect();	 Catch:{ IOException -> 0x01d7 }
        if (r2 == 0) goto L_0x01d6;
    L_0x01d1:
        r1 = r2.f15361g;	 Catch:{ IOException -> 0x01d7 }
        r1.mo4243b();	 Catch:{ IOException -> 0x01d7 }
    L_0x01d6:
        throw r0;	 Catch:{ IOException -> 0x01d7 }
    L_0x01d7:
        r0 = move-exception;
        r1 = "Error while connecting to ad server: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x01ed;
    L_0x01e8:
        r0 = r1.concat(r0);
        goto L_0x01f2;
    L_0x01ed:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x01f2:
        com.google.android.gms.internal.ads.mt.m19924e(r0);
        r0 = new com.google.android.gms.internal.ads.dp;
        r1 = 2;
        r0.<init>(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.eu.a(com.google.android.gms.internal.ads.dl, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.fg, com.google.android.gms.internal.ads.atc, com.google.android.gms.internal.ads.et):com.google.android.gms.internal.ads.dp");
    }

    /* renamed from: a */
    public static eu m37475a(Context context, et etVar) {
        eu euVar;
        synchronized (f28650a) {
            if (f28651b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                asp.m18892a(context);
                f28651b = new eu(context, etVar);
                if (context.getApplicationContext() != null) {
                    ax.e().m19748c(context);
                }
                jk.m19604a(context);
            }
            euVar = f28651b;
        }
        return euVar;
    }

    /* renamed from: a */
    private static void m37477a(String str, Map<String, List<String>> map, String str2, int i) {
        if (mt.m19917a(2)) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 39);
            stringBuilder.append("Http Response: {\n  URL:\n    ");
            stringBuilder.append(str);
            stringBuilder.append("\n  Headers:");
            jn.m30864a(stringBuilder.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str3).length() + 5);
                    stringBuilder2.append("    ");
                    stringBuilder2.append(str3);
                    stringBuilder2.append(":");
                    jn.m30864a(stringBuilder2.toString());
                    for (String valueOf : (List) map.get(str3)) {
                        String str4 = "      ";
                        String valueOf2 = String.valueOf(valueOf2);
                        jn.m30864a(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
                    }
                }
            }
            jn.m30864a("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    jn.m30864a(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                jn.m30864a("    null");
            }
            StringBuilder stringBuilder3 = new StringBuilder(34);
            stringBuilder3.append("  Response Code:\n    ");
            stringBuilder3.append(i);
            stringBuilder3.append("\n}");
            jn.m30864a(stringBuilder3.toString());
        }
    }

    /* renamed from: a */
    public final dp mo4236a(dl dlVar) {
        return m37473a(this.f28652c, this.f28653d, dlVar, this.f28654e);
    }

    /* renamed from: a */
    public final void mo4237a(dl dlVar, dw dwVar) {
        ax.i().m30831a(this.f28652c, dlVar.f28555k);
        Future a = ju.m19678a(new ew(this, dlVar, dwVar));
        ax.t().m19837a();
        ax.t().m19838b().postDelayed(new ex(this, a), 60000);
    }

    /* renamed from: a */
    public final void mo4238a(ee eeVar, dz dzVar) {
        jn.m30864a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public final void mo4239b(ee eeVar, dz dzVar) {
        jn.m30864a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }
}
