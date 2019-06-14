package com.facebook.ads.internal.p094i;

import android.content.Context;
import com.amplitude.api.Constants;
import com.facebook.ads.internal.p088c.C1355b;
import com.facebook.ads.internal.p091f.C1380e;
import com.facebook.ads.internal.p092g.C1384a;
import com.facebook.ads.internal.p092g.C1385b;
import com.facebook.ads.internal.p105q.p106a.C1495c;
import com.facebook.ads.internal.p105q.p106a.C1504g;
import com.facebook.ads.internal.p105q.p106a.C1504g.C1503a;
import com.facebook.ads.internal.p105q.p106a.C1505h;
import com.facebook.ads.internal.p105q.p106a.C1506i;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1511n;
import com.facebook.ads.internal.p105q.p106a.C1519s;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1535d;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.i.c */
public class C1394c {
    /* renamed from: a */
    public static int f4070a = 1303;
    /* renamed from: b */
    private static final AtomicInteger f4071b = new AtomicInteger(0);
    /* renamed from: c */
    private static String f4072c = null;
    /* renamed from: d */
    private static final C1503a f4073d = C1504g.m5290a();
    /* renamed from: e */
    private final Context f4074e;
    /* renamed from: f */
    private final C1385b f4075f;

    public C1394c(Context context, boolean z) {
        this.f4074e = context;
        this.f4075f = new C1385b(context);
        C1394c.m4786a(context, z);
    }

    /* renamed from: a */
    private static void m4786a(final android.content.Context r5, boolean r6) {
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
        r0 = f4071b;
        r1 = 0;
        r2 = 1;
        r0 = r0.compareAndSet(r1, r2);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        com.facebook.ads.internal.p105q.p106a.C1511n.m5312a();	 Catch:{ Exception -> 0x004c }
        r0 = "FBAdPrefs";	 Catch:{ Exception -> 0x004c }
        r0 = r5.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x004c }
        r2 = new com.facebook.ads.internal.g.b;	 Catch:{ Exception -> 0x004c }
        r2.<init>(r5);	 Catch:{ Exception -> 0x004c }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r3.<init>();	 Catch:{ Exception -> 0x004c }
        r4 = "AFP;";	 Catch:{ Exception -> 0x004c }
        r3.append(r4);	 Catch:{ Exception -> 0x004c }
        r2 = r2.m4749g();	 Catch:{ Exception -> 0x004c }
        r3.append(r2);	 Catch:{ Exception -> 0x004c }
        r2 = r3.toString();	 Catch:{ Exception -> 0x004c }
        r3 = 0;	 Catch:{ Exception -> 0x004c }
        r3 = r0.getString(r2, r3);	 Catch:{ Exception -> 0x004c }
        f4072c = r3;	 Catch:{ Exception -> 0x004c }
        r3 = new java.util.concurrent.FutureTask;	 Catch:{ Exception -> 0x004c }
        r4 = new com.facebook.ads.internal.i.c$1;	 Catch:{ Exception -> 0x004c }
        r4.<init>(r5, r0, r2);	 Catch:{ Exception -> 0x004c }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004c }
        r5 = java.util.concurrent.Executors.newSingleThreadExecutor();	 Catch:{ Exception -> 0x004c }
        r5.submit(r3);	 Catch:{ Exception -> 0x004c }
        if (r6 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x004c }
    L_0x0048:
        r3.get();	 Catch:{ Exception -> 0x004c }
        goto L_0x0051;
    L_0x004c:
        r5 = f4071b;
        r5.set(r1);
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.i.c.a(android.content.Context, boolean):void");
    }

    /* renamed from: b */
    private static String m4787b(Context context, String str) {
        try {
            return C1506i.m5301a(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            Map b = new C1394c(context, false).m4791b();
            b.put("subtype", MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
            b.put("subtype_code", String.valueOf(f4070a));
            C1380e.m4718a(e, context, b);
            return null;
        }
    }

    /* renamed from: a */
    public java.lang.String m4790a() {
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
        r7 = this;
        r0 = r7.f4074e;
        r1 = 1;
        com.facebook.ads.internal.p094i.C1394c.m4786a(r0, r1);
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x006c, all -> 0x0066 }
        r1.<init>();	 Catch:{ IOException -> 0x006c, all -> 0x0066 }
        r2 = new android.util.Base64OutputStream;	 Catch:{ IOException -> 0x0061, all -> 0x005c }
        r3 = 0;	 Catch:{ IOException -> 0x0061, all -> 0x005c }
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x0061, all -> 0x005c }
        r3 = new java.util.zip.DeflaterOutputStream;	 Catch:{ IOException -> 0x0057, all -> 0x0052 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0057, all -> 0x0052 }
        r0 = r7.m4791b();	 Catch:{ IOException -> 0x0050 }
        r4 = com.facebook.ads.internal.p088c.C1355b.f3939b;	 Catch:{ IOException -> 0x0050 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ IOException -> 0x0050 }
        if (r4 == 0) goto L_0x0028;	 Catch:{ IOException -> 0x0050 }
    L_0x0023:
        r4 = r7.f4074e;	 Catch:{ IOException -> 0x0050 }
        com.facebook.ads.internal.p088c.C1355b.m4643a(r4);	 Catch:{ IOException -> 0x0050 }
    L_0x0028:
        r4 = "IDFA";	 Catch:{ IOException -> 0x0050 }
        r5 = com.facebook.ads.internal.p088c.C1355b.f3939b;	 Catch:{ IOException -> 0x0050 }
        r0.put(r4, r5);	 Catch:{ IOException -> 0x0050 }
        r4 = new org.json.JSONObject;	 Catch:{ IOException -> 0x0050 }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0050 }
        r0 = r4.toString();	 Catch:{ IOException -> 0x0050 }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x0050 }
        r3.write(r0);	 Catch:{ IOException -> 0x0050 }
        r3.close();	 Catch:{ IOException -> 0x0050 }
        r0 = r1.toString();	 Catch:{ IOException -> 0x0050 }
        r3.close();	 Catch:{ IOException -> 0x004f }
        r2.close();	 Catch:{ IOException -> 0x004f }
        r1.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = move-exception;
        goto L_0x0071;
    L_0x0052:
        r3 = move-exception;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x007a;
    L_0x0057:
        r3 = move-exception;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x0071;
    L_0x005c:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x007a;
    L_0x0061:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x0071;
    L_0x0066:
        r1 = move-exception;
        r2 = r0;
        r3 = r2;
        r0 = r1;
        r1 = r3;
        goto L_0x007a;
    L_0x006c:
        r1 = move-exception;
        r2 = r0;
        r3 = r2;
        r0 = r1;
        r1 = r3;
    L_0x0071:
        r4 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0079 }
        r5 = "Failed to build user token";	 Catch:{ all -> 0x0079 }
        r4.<init>(r5, r0);	 Catch:{ all -> 0x0079 }
        throw r4;	 Catch:{ all -> 0x0079 }
    L_0x0079:
        r0 = move-exception;
    L_0x007a:
        if (r3 == 0) goto L_0x007f;
    L_0x007c:
        r3.close();	 Catch:{ IOException -> 0x0089 }
    L_0x007f:
        if (r2 == 0) goto L_0x0084;	 Catch:{ IOException -> 0x0089 }
    L_0x0081:
        r2.close();	 Catch:{ IOException -> 0x0089 }
    L_0x0084:
        if (r1 == 0) goto L_0x0089;	 Catch:{ IOException -> 0x0089 }
    L_0x0086:
        r1.close();	 Catch:{ IOException -> 0x0089 }
    L_0x0089:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.i.c.a():java.lang.String");
    }

    /* renamed from: b */
    public Map<String, String> m4791b() {
        C1394c.m4786a(this.f4074e, false);
        C1384a.m4732a(this.f4074e);
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.99.0");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = C1523w.f4503b;
        int i = this.f4074e.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.f4074e.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("ATTRIBUTION_ID", C1355b.f3938a);
        hashMap.put("ID_SOURCE", C1355b.f3941d);
        hashMap.put("OS", Constants.PLATFORM);
        hashMap.put("OSVERS", C1385b.f4027a);
        hashMap.put("BUNDLE", this.f4075f.m4748f());
        hashMap.put("APPNAME", this.f4075f.m4746d());
        hashMap.put("APPVERS", this.f4075f.m4749g());
        hashMap.put("APPBUILD", String.valueOf(this.f4075f.m4750h()));
        hashMap.put("CARRIER", this.f4075f.m4745c());
        hashMap.put("MAKE", this.f4075f.m4743a());
        hashMap.put("MODEL", this.f4075f.m4744b());
        hashMap.put("ROOTED", String.valueOf(f4073d.f4446d));
        hashMap.put("INSTALLER", this.f4075f.m4747e());
        hashMap.put("SDK_CAPABILITY", C1495c.m5267b());
        hashMap.put("NETWORK_TYPE", String.valueOf(C1535d.m5375c(this.f4074e).f4544g));
        hashMap.put("SESSION_TIME", C1519s.m5327a(C1511n.m5313b()));
        hashMap.put("SESSION_ID", C1511n.m5314c());
        if (f4072c != null) {
            hashMap.put("AFP", f4072c);
        }
        String a = C1504g.m5291a(this.f4074e);
        if (a != null) {
            hashMap.put("ASHAS", a);
        }
        hashMap.put("UNITY", String.valueOf(C1505h.m5298a(this.f4074e)));
        a = AdInternalSettings.getMediationService();
        if (a != null) {
            hashMap.put("MEDIATION_SERVICE", a);
        }
        hashMap.put("ACCESSIBILITY_ENABLED", String.valueOf(this.f4075f.m4751i()));
        if (this.f4075f.m4752j() != -1) {
            hashMap.put("APP_MIN_SDK_VERSION", String.valueOf(this.f4075f.m4752j()));
        }
        hashMap.put("VALPARAMS", C1392b.m4780a());
        hashMap.put("ANALOG", C1508k.m5306a(C1384a.m4731a()));
        return hashMap;
    }
}
