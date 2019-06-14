package com.p073d.p074a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amplitude.api.Constants;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.p073d.p074a.p075a.C1132f;
import com.p073d.p074a.p076b.C1139b;
import com.p073d.p074a.p076b.C1139b.C1138d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;

/* compiled from: AnalyticsContext */
/* renamed from: com.d.a.b */
public class C3466b extends C1166t {

    /* compiled from: AnalyticsContext */
    /* renamed from: com.d.a.b$a */
    public static class C3465a extends C1166t {
        /* renamed from: b */
        public /* synthetic */ C1166t mo783b(String str, Object obj) {
            return m11145a(str, obj);
        }

        C3465a() {
        }

        /* renamed from: a */
        public C3465a m11145a(String str, Object obj) {
            super.mo783b(str, obj);
            return this;
        }

        /* renamed from: a */
        void m11146a(String str, boolean z) {
            if (z && !C1139b.m4020a((CharSequence) str)) {
                m4134c("advertisingId", str);
            }
            m4134c("adTrackingEnabled", Boolean.valueOf(z));
        }
    }

    /* renamed from: b */
    public /* synthetic */ C1166t mo783b(String str, Object obj) {
        return m11151a(str, obj);
    }

    /* renamed from: a */
    static synchronized C3466b m11148a(Context context, C3490s c3490s, boolean z) {
        Map c3466b;
        synchronized (C3466b.class) {
            c3466b = new C3466b(new C1138d());
            c3466b.m11152a(context);
            c3466b.m11155a(c3490s);
            c3466b.m11154a(context, z);
            c3466b.m11161d();
            z = new StringBuilder();
            z.append(Locale.getDefault().getLanguage());
            z.append("-");
            z.append(Locale.getDefault().getCountry());
            c3466b.m4134c("locale", z.toString());
            c3466b.m11158b(context);
            c3466b.m11162e();
            c3466b.m11160c(context);
            C3466b.m11149a(c3466b, "userAgent", System.getProperty("http.agent"));
            C3466b.m11149a(c3466b, "timezone", TimeZone.getDefault().getID());
        }
        return c3466b;
    }

    /* renamed from: a */
    static void m11149a(Map<String, Object> map, String str, CharSequence charSequence) {
        if (C1139b.m4020a(charSequence)) {
            map.put(str, "undefined");
        } else {
            map.put(str, charSequence);
        }
    }

    C3466b(Map<String, Object> map) {
        super(map);
    }

    /* renamed from: a */
    void m11153a(Context context, CountDownLatch countDownLatch, C1132f c1132f) {
        if (C1139b.m4021a("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            new C1149h(this, countDownLatch, c1132f).execute(new Context[]{context});
            return;
        }
        c1132f.m3973c("Not collecting advertising ID because com.google.android.gms.ads.identifier.AdvertisingIdClient was not found on the classpath.", new Object[0]);
        countDownLatch.countDown();
    }

    /* renamed from: a */
    public C3466b m11151a(String str, Object obj) {
        super.mo783b(str, obj);
        return this;
    }

    /* renamed from: a */
    public C3466b m11150a() {
        return new C3466b(Collections.unmodifiableMap(new LinkedHashMap(this)));
    }

    /* renamed from: a */
    void m11155a(C3490s c3490s) {
        m4134c("traits", c3490s.m11219b());
    }

    /* renamed from: b */
    public C3490s m11156b() {
        return (C3490s) m4130a("traits", C3490s.class);
    }

    /* renamed from: a */
    void m11152a(android.content.Context r5) {
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
        r0 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = r0.getPackageInfo(r5, r1);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = com.p073d.p074a.p076b.C1139b.m4015a();	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = "name";	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = r5.applicationInfo;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = r3.loadLabel(r0);	 Catch:{ NameNotFoundException -> 0x003a }
        com.p073d.p074a.C3466b.m11149a(r1, r2, r0);	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = "version";	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x003a }
        com.p073d.p074a.C3466b.m11149a(r1, r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = "namespace";	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x003a }
        com.p073d.p074a.C3466b.m11149a(r1, r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = "build";	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ NameNotFoundException -> 0x003a }
        r1.put(r0, r5);	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = "app";	 Catch:{ NameNotFoundException -> 0x003a }
        r4.m4134c(r5, r1);	 Catch:{ NameNotFoundException -> 0x003a }
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.b.a(android.content.Context):void");
    }

    /* renamed from: a */
    void m11154a(Context context, boolean z) {
        C3465a c3465a = new C3465a();
        c3465a.m4134c("id", z ? C1139b.m4010a(context) : m11156b().m11223d());
        c3465a.m4134c("manufacturer", Build.MANUFACTURER);
        c3465a.m4134c("model", Build.MODEL);
        c3465a.m4134c("name", Build.DEVICE);
        m4134c("device", c3465a);
    }

    /* renamed from: c */
    public C3465a m11159c() {
        return (C3465a) m4130a("device", C3465a.class);
    }

    /* renamed from: d */
    void m11161d() {
        Map a = C1139b.m4015a();
        a.put("name", "analytics-android");
        a.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "4.3.0");
        m4134c("library", a);
    }

    /* renamed from: b */
    void m11158b(Context context) {
        Map a = C1139b.m4015a();
        if (C1139b.m4019a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) C1139b.m4031c(context, "connectivity");
            if (connectivityManager != null) {
                boolean z = true;
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                String str = "wifi";
                boolean z2 = networkInfo != null && networkInfo.isConnected();
                a.put(str, Boolean.valueOf(z2));
                networkInfo = connectivityManager.getNetworkInfo(7);
                str = "bluetooth";
                z2 = networkInfo != null && networkInfo.isConnected();
                a.put(str, Boolean.valueOf(z2));
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                String str2 = "cellular";
                if (networkInfo2 == null || !networkInfo2.isConnected()) {
                    z = false;
                }
                a.put(str2, Boolean.valueOf(z));
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) C1139b.m4031c(context, PlaceFields.PHONE);
        if (telephonyManager != null) {
            a.put("carrier", telephonyManager.getNetworkOperatorName());
        } else {
            a.put("carrier", "unknown");
        }
        m4134c("network", a);
    }

    /* renamed from: e */
    void m11162e() {
        Map a = C1139b.m4015a();
        a.put("name", Constants.PLATFORM);
        a.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, VERSION.RELEASE);
        m4134c("os", a);
    }

    /* renamed from: c */
    void m11160c(Context context) {
        Map a = C1139b.m4015a();
        context = ((WindowManager) C1139b.m4031c(context, "window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getMetrics(displayMetrics);
        a.put("density", Float.valueOf(displayMetrics.density));
        a.put("height", Integer.valueOf(displayMetrics.heightPixels));
        a.put("width", Integer.valueOf(displayMetrics.widthPixels));
        m4134c("screen", a);
    }
}
