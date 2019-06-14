package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2901l;
import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.bz */
public final class bz {
    /* renamed from: a */
    private static final char[] f16449a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m20371a(boolean z) {
        return z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    /* renamed from: a */
    public static Map<String, String> m20372a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 3);
            Object obj = null;
            if (split2.length > 1) {
                hashMap.put(split2[0], TextUtils.isEmpty(split2[1]) ? null : split2[1]);
                if (!(split2.length != 3 || TextUtils.isEmpty(split2[1]) || hashMap.containsKey(split2[1]))) {
                    Object obj2 = split2[1];
                    if (!TextUtils.isEmpty(split2[2])) {
                        obj = split2[2];
                    }
                    hashMap.put(obj2, obj);
                }
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static double m20368a(java.lang.String r2, double r3) {
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
        r3 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        if (r2 != 0) goto L_0x0005;
    L_0x0004:
        return r3;
    L_0x0005:
        r0 = java.lang.Double.parseDouble(r2);	 Catch:{ NumberFormatException -> 0x000a }
        return r0;
    L_0x000a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.a(java.lang.String, double):double");
    }

    /* renamed from: b */
    public static long m20380b(java.lang.String r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.b(java.lang.String):long");
    }

    /* renamed from: a */
    public static boolean m20379a(String str, boolean z) {
        if (!(str == null || str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str.equalsIgnoreCase("yes"))) {
            if (!str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO) != null) {
                    return null;
                }
                return true;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static java.lang.String m20382c(java.lang.String r11) {
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
        r0 = android.text.TextUtils.isEmpty(r11);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "?";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x0010:
        r0 = "[\\?]";
        r0 = r11.split(r0);
        r2 = r0.length;
        r3 = 1;
        if (r2 <= r3) goto L_0x001c;
    L_0x001a:
        r11 = r0[r3];
    L_0x001c:
        r0 = "%3D";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x002b }
        r11 = java.net.URLDecoder.decode(r11, r0);	 Catch:{ UnsupportedEncodingException -> 0x002b }
        goto L_0x0035;
    L_0x002b:
        return r1;
    L_0x002c:
        r0 = "=";
        r0 = r11.contains(r0);
        if (r0 != 0) goto L_0x0035;
    L_0x0034:
        return r1;
    L_0x0035:
        r11 = com.google.android.gms.internal.p210i.bz.m20372a(r11);
        r0 = "dclid";
        r1 = "utm_source";
        r2 = "gclid";
        r3 = "aclid";
        r4 = "utm_campaign";
        r5 = "utm_medium";
        r6 = "utm_term";
        r7 = "utm_content";
        r8 = "utm_id";
        r9 = "anid";
        r10 = "gmob_t";
        r0 = new java.lang.String[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 0;
    L_0x0059:
        r3 = 11;
        if (r2 >= r3) goto L_0x008e;
    L_0x005d:
        r3 = r0[r2];
        r3 = r11.get(r3);
        r3 = (java.lang.CharSequence) r3;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x008b;
    L_0x006b:
        r3 = r1.length();
        if (r3 <= 0) goto L_0x0076;
    L_0x0071:
        r3 = "&";
        r1.append(r3);
    L_0x0076:
        r3 = r0[r2];
        r1.append(r3);
        r3 = "=";
        r1.append(r3);
        r3 = r0[r2];
        r3 = r11.get(r3);
        r3 = (java.lang.String) r3;
        r1.append(r3);
    L_0x008b:
        r2 = r2 + 1;
        goto L_0x0059;
    L_0x008e:
        r11 = r1.toString();
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.c(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static fh m20369a(bl blVar, String str) {
        C2872v.a(blVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            String str2 = "?";
            str = String.valueOf(str);
            str = C2901l.a(new URI(str.length() != 0 ? str2.concat(str) : new String(str2)), Utf8Charset.NAME);
            blVar = new fh();
            blVar.m31584e((String) str.get("utm_content"));
            blVar.m31580c((String) str.get("utm_medium"));
            blVar.m31576a((String) str.get("utm_campaign"));
            blVar.m31578b((String) str.get("utm_source"));
            blVar.m31582d((String) str.get("utm_term"));
            blVar.m31586f((String) str.get("utm_id"));
            blVar.m31588g((String) str.get("anid"));
            blVar.m31590h((String) str.get("gclid"));
            blVar.m31592i((String) str.get("dclid"));
            blVar.m31594j((String) str.get("aclid"));
            return blVar;
        } catch (String str3) {
            blVar.m21034d("No valid campaign data found", str3);
            return null;
        }
    }

    /* renamed from: a */
    public static String m20370a(Locale locale) {
        if (locale == null) {
            return null;
        }
        Object language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-");
            stringBuilder.append(locale.getCountry().toLowerCase(locale));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m20373a(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    /* renamed from: b */
    public static void m20381b(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty((CharSequence) map.get(str))) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m20375a(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
    }

    /* renamed from: a */
    public static void m20374a(Map<String, String> map, String str, Map<String, String> map2) {
        bz.m20373a((Map) map, str, (String) map2.get(str));
    }

    /* renamed from: d */
    public static java.security.MessageDigest m20383d(java.lang.String r2) {
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
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.d(java.lang.String):java.security.MessageDigest");
    }

    /* renamed from: a */
    public static boolean m20376a(double d, String str) {
        if (d > 0.0d) {
            if (d < 100.0d) {
                int i;
                if (TextUtils.isEmpty(str)) {
                    i = 1;
                } else {
                    i = 0;
                    for (int length = str.length() - 1; length >= 0; length--) {
                        char charAt = str.charAt(length);
                        i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                        int i2 = 266338304 & i;
                        if (i2 != 0) {
                            i ^= i2 >> 21;
                        }
                    }
                }
                return ((double) (i % 10000)) >= d * 100.0d;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m20384e(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http:") == null) {
            return true;
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m20378a(android.content.Context r3, java.lang.String r4, boolean r5) {
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
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001c }
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001c }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x001c }
        r3 = r1.getReceiverInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x001c }
        if (r3 == 0) goto L_0x001c;	 Catch:{ NameNotFoundException -> 0x001c }
    L_0x0010:
        r4 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x001c }
        if (r4 == 0) goto L_0x001c;	 Catch:{ NameNotFoundException -> 0x001c }
    L_0x0014:
        if (r5 == 0) goto L_0x001a;	 Catch:{ NameNotFoundException -> 0x001c }
    L_0x0016:
        r3 = r3.exported;	 Catch:{ NameNotFoundException -> 0x001c }
        if (r3 == 0) goto L_0x001c;
    L_0x001a:
        r3 = 1;
        return r3;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.a(android.content.Context, java.lang.String, boolean):boolean");
    }

    /* renamed from: a */
    public static boolean m20377a(android.content.Context r3, java.lang.String r4) {
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
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0016 }
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0016 }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x0016 }
        r3 = r1.getServiceInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0016 }
        if (r3 == 0) goto L_0x0016;	 Catch:{ NameNotFoundException -> 0x0016 }
    L_0x0010:
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x0016 }
        if (r3 == 0) goto L_0x0016;
    L_0x0014:
        r3 = 1;
        return r3;
    L_0x0016:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bz.a(android.content.Context, java.lang.String):boolean");
    }
}
