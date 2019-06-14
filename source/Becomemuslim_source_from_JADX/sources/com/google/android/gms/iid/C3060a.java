package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.C3211a;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
/* renamed from: com.google.android.gms.iid.a */
public class C3060a {
    /* renamed from: a */
    private static final C3066l<Boolean> f7794a = C3065k.m8972a().mo2604a("gcm_check_for_different_iid_in_token", true);
    /* renamed from: b */
    private static Map<String, C3060a> f7795b = new C3211a();
    /* renamed from: c */
    private static final long f7796c = TimeUnit.DAYS.toMillis(7);
    /* renamed from: d */
    private static C3067m f7797d;
    /* renamed from: e */
    private static C3063h f7798e;
    /* renamed from: f */
    private static String f7799f;
    /* renamed from: g */
    private Context f7800g;
    /* renamed from: h */
    private String f7801h = "";

    private C3060a(Context context, String str) {
        this.f7800g = context.getApplicationContext();
        this.f7801h = str;
    }

    /* renamed from: a */
    static int m8930a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Context context2) {
            context2 = String.valueOf(context2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(context2).length() + 38);
            stringBuilder.append("Never happens: can't find own package ");
            stringBuilder.append(context2);
            Log.w("InstanceID", stringBuilder.toString());
            return 0;
        }
    }

    /* renamed from: b */
    static String m8933b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Context context2) {
            context2 = String.valueOf(context2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(context2).length() + 38);
            stringBuilder.append("Never happens: can't find own package ");
            stringBuilder.append(context2);
            Log.w("InstanceID", stringBuilder.toString());
            return null;
        }
    }

    @Deprecated
    /* renamed from: c */
    public static C3060a m8934c(Context context) {
        return C3060a.m8931a(context, null);
    }

    /* renamed from: a */
    public static synchronized C3060a m8931a(Context context, Bundle bundle) {
        C3060a c3060a;
        synchronized (C3060a.class) {
            bundle = bundle == null ? "" : bundle.getString("subtype");
            if (bundle == null) {
                bundle = "";
            }
            context = context.getApplicationContext();
            if (f7797d == null) {
                String packageName = context.getPackageName();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(packageName).length() + 73);
                stringBuilder.append("Instance ID SDK is deprecated, ");
                stringBuilder.append(packageName);
                stringBuilder.append(" should update to use Firebase Instance ID");
                Log.w("InstanceID", stringBuilder.toString());
                f7797d = new C3067m(context);
                f7798e = new C3063h(context);
            }
            f7799f = Integer.toString(C3060a.m8930a(context));
            c3060a = (C3060a) f7795b.get(bundle);
            if (c3060a == null) {
                c3060a = new C3060a(context, bundle);
                f7795b.put(bundle, c3060a);
            }
        }
        return c3060a;
    }

    /* renamed from: d */
    private final KeyPair m8936d() {
        return f7797d.m8985c(this.f7801h).m9018a();
    }

    @Deprecated
    /* renamed from: a */
    public String m8937a() {
        return C3060a.m8932a(m8936d());
    }

    /* renamed from: a */
    static java.lang.String m8932a(java.security.KeyPair r3) {
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
        r3 = r3.getPublic();
        r3 = r3.getEncoded();
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = r0.digest(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r3[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 & 15;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = r1 + 112;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = (byte) r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3[r0] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = 11;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = android.util.Base64.encodeToString(r3, r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        return r3;
    L_0x0025:
        r3 = "InstanceID";
        r0 = "Unexpected error, device missing required algorithms";
        android.util.Log.w(r3, r0);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.a.a(java.security.KeyPair):java.lang.String");
    }

    /* renamed from: b */
    final void m8940b() {
        f7797d.m8986d(this.f7801h);
    }

    /* renamed from: c */
    public static C3067m m8935c() {
        return f7797d;
    }

    @Deprecated
    /* renamed from: a */
    public String m8938a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String str3 = null;
            String a = f7797d.m8978a("appVersion");
            Object obj = 1;
            if (a != null) {
                if (a.equals(f7799f)) {
                    long b = f7797d.m8982b(this.f7801h, str, str2);
                    if (b >= 0) {
                        if (System.currentTimeMillis() - b < f7796c) {
                            obj = null;
                        }
                    }
                }
            }
            if (obj == null) {
                str3 = f7797d.m8979a(this.f7801h, str, str2);
            }
            if (str3 != null) {
                return str3;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle = m8939b(str, str2, bundle);
            if (((Boolean) f7794a.mo2605a()).booleanValue() && bundle.contains(":")) {
                if (!bundle.startsWith(String.valueOf(m8937a()).concat(":"))) {
                    C4428b.m14713a(this.f7800g, f7797d);
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
            if (bundle == null) {
                return bundle;
            }
            f7797d.m8980a(this.f7801h, str, str2, bundle, f7799f);
            return bundle;
        }
        throw new IOException("MAIN_THREAD");
    }

    /* renamed from: b */
    public final String m8939b(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        str2 = "".equals(this.f7801h) != null ? str : this.f7801h;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str2);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str2);
        }
        str = C3063h.m8958a(f7798e.m8969a(bundle, m8936d()));
        if ("RST".equals(str) == null && str.startsWith("RST|") == null) {
            return str;
        }
        C4428b.m14713a(this.f7800g, f7797d);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
