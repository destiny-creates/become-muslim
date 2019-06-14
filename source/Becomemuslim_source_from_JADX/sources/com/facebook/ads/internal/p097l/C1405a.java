package com.facebook.ads.internal.p097l;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.l.a */
public final class C1405a {
    /* renamed from: a */
    private static C1405a f4101a;
    /* renamed from: b */
    private final SharedPreferences f4102b;

    private C1405a(Context context) {
        this.f4102b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    /* renamed from: a */
    private static int m4818a(Context context, String str, int i) {
        int a = C1405a.m4843x(context).m4844a(str, i);
        return (a < 0 || a >= 101) ? i : a;
    }

    /* renamed from: a */
    public static boolean m4819a(Context context) {
        return VERSION.SDK_INT >= 14 && C1405a.m4821b("com.google.android.exoplayer2", "ExoPlayer") && C1405a.m4843x(context).m4848a("adnw_enable_exoplayer", false);
    }

    /* renamed from: b */
    public static boolean m4820b(Context context) {
        return VERSION.SDK_INT >= 18 && C1405a.m4843x(context).m4848a("adnw_enable_debug_overlay", false);
    }

    /* renamed from: b */
    private static boolean m4821b(java.lang.String r1, java.lang.String r2) {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0019 }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x0019 }
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0019 }
        r1 = ".";	 Catch:{ ClassNotFoundException -> 0x0019 }
        r0.append(r1);	 Catch:{ ClassNotFoundException -> 0x0019 }
        r0.append(r2);	 Catch:{ ClassNotFoundException -> 0x0019 }
        r1 = r0.toString();	 Catch:{ ClassNotFoundException -> 0x0019 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0019 }
        r1 = 1;
        return r1;
    L_0x0019:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.l.a.b(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: c */
    public static boolean m4822c(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_block_lockscreen", false);
    }

    /* renamed from: d */
    public static boolean m4823d(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_android_memory_opt", false);
    }

    /* renamed from: e */
    public static boolean m4824e(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_android_disable_blur", false);
    }

    /* renamed from: f */
    public static boolean m4825f(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_android_disable_playable_precache", false);
    }

    /* renamed from: g */
    public static boolean m4826g(Context context) {
        return VERSION.SDK_INT >= 19 && C1405a.m4843x(context).m4848a("adnw_enable_iab", false);
    }

    /* renamed from: h */
    public static boolean m4827h(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_debug_logging", false);
    }

    /* renamed from: i */
    public static java.util.Set<java.lang.String> m4828i(android.content.Context r3) {
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
        r3 = com.facebook.ads.internal.p097l.C1405a.m4843x(r3);
        r0 = "additional_debug_logging_black_list";
        r1 = "";
        r3 = r3.m4846a(r0, r1);
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0027 }
        r1.<init>(r3);	 Catch:{ JSONException -> 0x0027 }
        r3 = 0;	 Catch:{ JSONException -> 0x0027 }
    L_0x0017:
        r2 = r1.length();	 Catch:{ JSONException -> 0x0027 }
        if (r3 >= r2) goto L_0x0027;	 Catch:{ JSONException -> 0x0027 }
    L_0x001d:
        r2 = r1.getString(r3);	 Catch:{ JSONException -> 0x0027 }
        r0.add(r2);	 Catch:{ JSONException -> 0x0027 }
        r3 = r3 + 1;
        goto L_0x0017;
    L_0x0027:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.l.a.i(android.content.Context):java.util.Set<java.lang.String>");
    }

    /* renamed from: j */
    public static int m4829j(Context context) {
        return C1405a.m4818a(context, "additional_debug_logging_black_list_percentage", 0);
    }

    /* renamed from: k */
    public static int m4830k(Context context) {
        return C1405a.m4818a(context, "additional_debug_logging_sampling_percentage", 100);
    }

    /* renamed from: l */
    public static boolean m4831l(Context context) {
        return C1405a.m4843x(context).m4848a("device_id_based_routing", false);
    }

    /* renamed from: m */
    public static long m4832m(Context context) {
        return C1405a.m4843x(context).m4845a("unified_logging_immediate_delay_ms", 500);
    }

    /* renamed from: n */
    public static long m4833n(Context context) {
        return ((long) C1405a.m4843x(context).m4844a("unified_logging_dispatch_interval_seconds", 300)) * 1000;
    }

    /* renamed from: o */
    public static int m4834o(Context context) {
        return C1405a.m4843x(context).m4844a("unified_logging_event_limit", -1);
    }

    /* renamed from: p */
    public static boolean m4835p(Context context) {
        return C1405a.m4843x(context).m4846a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    /* renamed from: q */
    public static int m4836q(Context context) {
        return C1405a.m4843x(context).m4844a("minimum_elapsed_time_after_impression", -1);
    }

    /* renamed from: r */
    public static int m4837r(Context context) {
        return C1405a.m4843x(context).m4844a("stack_trace_sample_rate", 0);
    }

    /* renamed from: s */
    public static boolean m4838s(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_top_activity_viewability", false);
    }

    /* renamed from: t */
    public static boolean m4839t(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_enhanced_viewability_area_check", false);
    }

    /* renamed from: u */
    public static boolean m4840u(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_viewability_check_area_based", false);
    }

    /* renamed from: v */
    public static String m4841v(Context context) {
        return C1405a.m4843x(context).m4846a("adnw_logging_endpoint_prefix", "www");
    }

    /* renamed from: w */
    public static boolean m4842w(Context context) {
        return C1405a.m4843x(context).m4848a("adnw_mapp_markup_impression_after_image_load", false);
    }

    /* renamed from: x */
    public static C1405a m4843x(Context context) {
        if (f4101a == null) {
            synchronized (C1405a.class) {
                if (f4101a == null) {
                    f4101a = new C1405a(context);
                }
            }
        }
        return f4101a;
    }

    /* renamed from: a */
    public int m4844a(java.lang.String r3, int r4) {
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
        r0 = r2.f4102b;
        r1 = java.lang.String.valueOf(r4);
        r3 = r0.getString(r3, r1);
        r0 = "null";	 Catch:{ NumberFormatException -> 0x001d }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x001d }
        if (r0 == 0) goto L_0x0014;	 Catch:{ NumberFormatException -> 0x001d }
    L_0x0012:
        r3 = r4;	 Catch:{ NumberFormatException -> 0x001d }
        goto L_0x001c;	 Catch:{ NumberFormatException -> 0x001d }
    L_0x0014:
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x001d }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x001d }
    L_0x001c:
        return r3;
    L_0x001d:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.l.a.a(java.lang.String, int):int");
    }

    /* renamed from: a */
    public long m4845a(java.lang.String r3, long r4) {
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
        r0 = r2.f4102b;
        r1 = java.lang.String.valueOf(r4);
        r3 = r0.getString(r3, r1);
        r0 = "null";	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r3.equals(r0);	 Catch:{ NumberFormatException -> 0x001c }
        if (r0 == 0) goto L_0x0013;	 Catch:{ NumberFormatException -> 0x001c }
    L_0x0012:
        goto L_0x001c;	 Catch:{ NumberFormatException -> 0x001c }
    L_0x0013:
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x001c }
        r4 = r0;
    L_0x001c:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.l.a.a(java.lang.String, long):long");
    }

    /* renamed from: a */
    public String m4846a(String str, String str2) {
        str = this.f4102b.getString(str, str2);
        return (str == null || str.equals("null")) ? str2 : str;
    }

    /* renamed from: a */
    public void m4847a(String str) {
        if (str != null && !str.isEmpty()) {
            if (!str.equals("[]")) {
                Editor edit = this.f4102b.edit();
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    edit.putString(str2, jSONObject.getString(str2));
                }
                edit.apply();
            }
        }
    }

    /* renamed from: a */
    public boolean m4848a(String str, boolean z) {
        str = this.f4102b.getString(str, String.valueOf(z));
        return str.equals("null") ? z : Boolean.valueOf(str).booleanValue();
    }
}
