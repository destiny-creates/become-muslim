package com.stripe.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import com.stripe.android.C5772r.C5771a;
import com.stripe.android.p284a.C5711h;
import com.stripe.android.p284a.C7151a;
import com.stripe.android.p284a.C7152b;
import com.stripe.android.p284a.C7153c;
import com.stripe.android.p284a.C7154d;
import com.stripe.android.p284a.C7155e;
import com.stripe.android.p284a.C8033f;
import com.stripe.android.p284a.C8034g;
import com.stripe.android.p285b.C5728m;
import com.stripe.android.p285b.C7158d;
import com.stripe.android.p285b.C7160g;
import com.stripe.android.p285b.C7162i;
import com.stripe.android.p285b.C7168u;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StripeApiHandler */
/* renamed from: com.stripe.android.q */
class C5770q {
    /* renamed from: a */
    private static final SSLSocketFactory f19151a = new C5774t();

    /* compiled from: StripeApiHandler */
    /* renamed from: com.stripe.android.q$a */
    interface C5767a {
        /* renamed from: a */
        void m24358a(C5711h c5711h);

        /* renamed from: a */
        void m24359a(C5773s c5773s);

        /* renamed from: a */
        boolean m24360a();
    }

    /* compiled from: StripeApiHandler */
    /* renamed from: com.stripe.android.q$b */
    private static final class C5768b {
        /* renamed from: a */
        public final String f19149a;
        /* renamed from: b */
        public final String f19150b;

        C5768b(String str, String str2) {
            this.f19149a = str;
            this.f19150b = str2;
        }
    }

    /* compiled from: StripeApiHandler */
    /* renamed from: com.stripe.android.q$c */
    interface C5769c {
        /* renamed from: a */
        void m24361a(C5773s c5773s);
    }

    /* renamed from: a */
    static void m24386a(Map<String, Object> map, C5759n c5759n, C5767a c5767a) {
        if (c5759n != null) {
            if (c5767a == null || c5767a.m24360a()) {
                String d = c5759n.m24331d();
                if (d != null) {
                    if (!d.trim().isEmpty()) {
                        C5770q.m24387a((Map) map, "https://q.stripe.com", "GET", c5759n, c5767a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static C7162i m24365a(C5771a c5771a, Context context, C5728m c5728m, String str, String str2, C5767a c5767a) {
        return C5770q.m24366a(c5771a, context, c5728m, str, str2, c5767a, null);
    }

    /* renamed from: a */
    static C7162i m24366a(C5771a c5771a, Context context, C5728m c5728m, String str, String str2, C5767a c5767a, C5769c c5769c) {
        Map b = c5728m.m24265b();
        C5772r.m24410a(c5771a, context, b);
        c5771a = C5759n.m24327a(str, str2, ShareConstants.FEED_SOURCE_PARAM).m24322a();
        try {
            str2 = c5771a.m24331d();
            if (C5775u.m24419b(str2)) {
                return null;
            }
            C5770q.m24382a(context, c5767a);
            C5770q.m24386a(C5739h.m24305b(context, null, str2, c5728m.m24262a()), C5759n.m24325a(str).m24322a(), c5767a);
            c5771a = C5770q.m24390b("POST", C5770q.m24391b(), b, c5771a);
            if (c5769c != null) {
                c5769c.m24361a(c5771a);
            }
            return C7162i.m33274a(c5771a.m24413b());
        } catch (C5771a c5771a2) {
            throw new C7152b(c5771a2.getMessage(), c5771a2.m24156a(), c5771a2.m24157b(), c5771a2);
        }
    }

    /* renamed from: a */
    static C7162i m24367a(String str, String str2, String str3) {
        try {
            return C7162i.m33274a(C5770q.m24390b("GET", C5770q.m24398c(str), C5728m.m24253a(str2), C5759n.m24325a(str3).m24322a()).m24413b());
        } catch (String str4) {
            throw new C7152b(str4.getMessage(), str4.m24156a(), str4.m24157b(), str4);
        }
    }

    /* renamed from: a */
    static com.stripe.android.p285b.C7168u m24368a(android.content.Context r3, java.util.Map<java.lang.String, java.lang.Object> r4, com.stripe.android.C5759n r5, java.lang.String r6, com.stripe.android.C5770q.C5767a r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.m24331d();	 Catch:{ ClassCastException -> 0x0024 }
        r1 = com.stripe.android.C5775u.m24419b(r0);	 Catch:{ ClassCastException -> 0x0024 }
        if (r1 == 0) goto L_0x000c;	 Catch:{ ClassCastException -> 0x0024 }
    L_0x000a:
        r3 = 0;	 Catch:{ ClassCastException -> 0x0024 }
        return r3;	 Catch:{ ClassCastException -> 0x0024 }
    L_0x000c:
        r1 = "product_usage";	 Catch:{ ClassCastException -> 0x0024 }
        r1 = r4.get(r1);	 Catch:{ ClassCastException -> 0x0024 }
        r1 = (java.util.List) r1;	 Catch:{ ClassCastException -> 0x0024 }
        r2 = "product_usage";	 Catch:{ ClassCastException -> 0x0024 }
        r4.remove(r2);	 Catch:{ ClassCastException -> 0x0024 }
        com.stripe.android.C5770q.m24382a(r3, r7);	 Catch:{ ClassCastException -> 0x0024 }
        r3 = com.stripe.android.C5739h.m24301a(r3, r1, r0, r6);	 Catch:{ ClassCastException -> 0x0024 }
        com.stripe.android.C5770q.m24386a(r3, r5, r7);	 Catch:{ ClassCastException -> 0x0024 }
        goto L_0x0029;
    L_0x0024:
        r3 = "product_usage";
        r4.remove(r3);
    L_0x0029:
        r3 = "POST";
        r6 = com.stripe.android.C5770q.m24370a();
        r3 = com.stripe.android.C5770q.m24396c(r3, r6, r4, r5);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.q.a(android.content.Context, java.util.Map, com.stripe.android.n, java.lang.String, com.stripe.android.q$a):com.stripe.android.b.u");
    }

    /* renamed from: a */
    static C7162i m24364a(Context context, String str, String str2, List<String> list, String str3, String str4, String str5, C5767a c5767a) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, str3);
        if (context != null) {
            C5770q.m24386a(C5739h.m24306c(context, list, str2, str4), C5759n.m24325a(str2).m24323b("2017-06-05").m24322a(), c5767a);
        }
        C5773s a = C5770q.m24369a("POST", C5770q.m24372a(str), hashMap, C5759n.m24325a(str5).m24323b("2017-06-05").m24322a());
        C5770q.m24383a(a);
        return C7162i.m33274a(a.m24413b());
    }

    /* renamed from: b */
    static C7158d m24389b(Context context, String str, String str2, List<String> list, String str3, String str4, String str5, C5767a c5767a) {
        Map hashMap = new HashMap();
        hashMap.put("default_source", str3);
        if (context != null) {
            C5770q.m24386a(C5739h.m24302a(context, list, str4, null, str2, "default_source"), C5759n.m24325a(str2).m24323b("2017-06-05").m24322a(), c5767a);
        }
        C5773s a = C5770q.m24369a("POST", C5770q.m24393b(str), hashMap, C5759n.m24325a(str5).m24323b("2017-06-05").m24322a());
        C5770q.m24383a(a);
        return C7158d.m33248b(a.m24413b());
    }

    /* renamed from: a */
    static C7158d m24362a(Context context, String str, String str2, List<String> list, C7160g c7160g, String str3, C5767a c5767a) {
        Map hashMap = new HashMap();
        hashMap.put("shipping", c7160g.mo5066b());
        if (context != null) {
            C5770q.m24386a(C5739h.m24302a(context, list, null, null, str2, "set_shipping_info"), C5759n.m24325a(str2).m24323b("2017-06-05").m24322a(), c5767a);
        }
        C5773s a = C5770q.m24369a("POST", C5770q.m24393b(str), hashMap, C5759n.m24325a(str3).m24323b("2017-06-05").m24322a());
        C5770q.m24383a(a);
        return C7158d.m33248b(a.m24413b());
    }

    /* renamed from: a */
    static C7158d m24363a(String str, String str2) {
        C5773s a = C5770q.m24369a("GET", C5770q.m24393b(str), null, C5759n.m24325a(str2).m24323b("2017-06-05").m24322a());
        C5770q.m24383a(a);
        return C7158d.m33248b(a.m24413b());
    }

    /* renamed from: a */
    static String m24373a(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        map = C5770q.m24400c((Map) map).iterator();
        while (map.hasNext()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            C5768b c5768b = (C5768b) map.next();
            stringBuilder.append(C5770q.m24399c(c5768b.f19149a, c5768b.f19150b));
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static Map<String, String> m24380a(C5759n c5759n) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Accept-Charset", Utf8Charset.NAME);
        hashMap.put("Accept", "application/json");
        hashMap.put("User-Agent", String.format("Stripe/v1 AndroidBindings/%s", new Object[]{"6.0.0"}));
        if (c5759n != null) {
            hashMap.put("Authorization", String.format(Locale.ENGLISH, "Bearer %s", new Object[]{c5759n.m24331d()}));
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("java.version", System.getProperty("java.version"));
        hashMap2.put("os.name", "android");
        hashMap2.put("os.version", String.valueOf(VERSION.SDK_INT));
        hashMap2.put("bindings.version", "6.0.0");
        hashMap2.put("lang", "Java");
        hashMap2.put("publisher", "Stripe");
        hashMap.put("X-Stripe-Client-User-Agent", new JSONObject(hashMap2).toString());
        if (!(c5759n == null || c5759n.m24328a() == null)) {
            hashMap.put("Stripe-Version", c5759n.m24328a());
        }
        if (!(c5759n == null || c5759n.m24333f() == null)) {
            hashMap.put("Stripe-Account", c5759n.m24333f());
        }
        if (!(c5759n == null || c5759n.m24330c() == null)) {
            hashMap.put("Idempotency-Key", c5759n.m24330c());
        }
        return hashMap;
    }

    /* renamed from: a */
    static String m24370a() {
        return String.format(Locale.ENGLISH, "%s/v1/%s", new Object[]{"https://api.stripe.com", "tokens"});
    }

    /* renamed from: b */
    static String m24391b() {
        return String.format(Locale.ENGLISH, "%s/v1/%s", new Object[]{"https://api.stripe.com", "sources"});
    }

    /* renamed from: c */
    static String m24397c() {
        return String.format(Locale.ENGLISH, "%s/v1/%s", new Object[]{"https://api.stripe.com", "customers"});
    }

    /* renamed from: a */
    static String m24372a(String str) {
        return String.format(Locale.ENGLISH, "%s/%s", new Object[]{C5770q.m24393b(str), "sources"});
    }

    /* renamed from: b */
    static String m24393b(String str) {
        return String.format(Locale.ENGLISH, "%s/%s", new Object[]{C5770q.m24397c(), str});
    }

    /* renamed from: c */
    static String m24398c(String str) {
        return String.format(Locale.ENGLISH, "%s/%s", new Object[]{C5770q.m24391b(), str});
    }

    /* renamed from: a */
    static void m24383a(C5773s c5773s) {
        int a = c5773s.m24412a();
        String b = c5773s.m24413b();
        c5773s = c5773s.m24414c();
        String str = null;
        if (c5773s == null) {
            c5773s = null;
        } else {
            c5773s = (List) c5773s.get("Request-Id");
        }
        if (c5773s != null && c5773s.size() > 0) {
            str = (String) c5773s.get(0);
        }
        if (a < HttpStatus.HTTP_OK || a >= 300) {
            C5770q.m24384a(b, a, str);
        }
    }

    /* renamed from: b */
    private static org.json.JSONObject m24395b(java.util.Map<java.lang.String, ? extends java.lang.Object> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r5 != 0) goto L_0x0004;
    L_0x0002:
        r5 = 0;
        return r5;
    L_0x0004:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = r5.keySet();
        r1 = r1.iterator();
    L_0x0011:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0057;
    L_0x0017:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = r5.get(r2);
        if (r3 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0011;
    L_0x0024:
        r4 = r3 instanceof java.util.Map;	 Catch:{  }
        if (r4 == 0) goto L_0x0034;
    L_0x0028:
        r3 = (java.util.Map) r3;	 Catch:{ JSONException -> 0x0032 }
        r3 = com.stripe.android.C5770q.m24395b(r3);	 Catch:{ JSONException -> 0x0032 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0032 }
        goto L_0x0011;
        goto L_0x0011;
    L_0x0034:
        r4 = r3 instanceof java.util.List;	 Catch:{  }
        if (r4 == 0) goto L_0x0042;	 Catch:{  }
    L_0x0038:
        r3 = (java.util.List) r3;	 Catch:{  }
        r3 = com.stripe.android.C5770q.m24381a(r3);	 Catch:{  }
        r0.put(r2, r3);	 Catch:{  }
        goto L_0x0011;	 Catch:{  }
    L_0x0042:
        r4 = r3 instanceof java.lang.Number;	 Catch:{  }
        if (r4 != 0) goto L_0x0053;	 Catch:{  }
    L_0x0046:
        r4 = r3 instanceof java.lang.Boolean;	 Catch:{  }
        if (r4 == 0) goto L_0x004b;	 Catch:{  }
    L_0x004a:
        goto L_0x0053;	 Catch:{  }
    L_0x004b:
        r3 = r3.toString();	 Catch:{  }
        r0.put(r2, r3);	 Catch:{  }
        goto L_0x0011;	 Catch:{  }
    L_0x0053:
        r0.put(r2, r3);	 Catch:{  }
        goto L_0x0011;
    L_0x0057:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.q.b(java.util.Map):org.json.JSONObject");
    }

    /* renamed from: a */
    private static JSONArray m24381a(List list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (next instanceof Map) {
                jSONArray.put(C5770q.m24395b((Map) next));
            } else if (next instanceof List) {
                jSONArray.put(C5770q.m24381a((List) next));
            } else {
                if (!(next instanceof Number)) {
                    if (!(next instanceof Boolean)) {
                        jSONArray.put(next.toString());
                    }
                }
                jSONArray.put(next);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static void m24385a(HttpURLConnection httpURLConnection, C5759n c5759n) {
        if (c5759n.m24329b() != null && !TextUtils.isEmpty(c5759n.m24329b())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("m=");
            stringBuilder.append(c5759n.m24329b());
            httpURLConnection.setRequestProperty("Cookie", stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m24375a(String str, String str2, C5759n c5759n) {
        str = C5770q.m24374a(C5770q.m24394b(str, str2), c5759n);
        str.setRequestMethod("GET");
        return str;
    }

    /* renamed from: a */
    private static HttpURLConnection m24376a(String str, Map<String, Object> map, C5759n c5759n) {
        OutputStream outputStream;
        str = C5770q.m24374a(str, c5759n);
        str.setDoOutput(true);
        str.setRequestMethod("POST");
        str.setRequestProperty(HttpHeaders.CONTENT_TYPE, C5770q.m24392b(c5759n));
        try {
            outputStream = str.getOutputStream();
            try {
                outputStream.write(C5770q.m24388a((Map) map, c5759n));
                if (outputStream != null) {
                    outputStream.close();
                }
                return str;
            } catch (Throwable th) {
                str = th;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw str;
            }
        } catch (Throwable th2) {
            str = th2;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            throw str;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m24374a(String str, C5759n c5759n) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        httpURLConnection.setReadTimeout(80000);
        httpURLConnection.setUseCaches(false);
        if (C5770q.m24401d(str)) {
            for (Entry entry : C5770q.m24380a(c5759n).entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (C5770q.m24402e(str) != null) {
            C5770q.m24385a(httpURLConnection, c5759n);
        }
        if ((httpURLConnection instanceof HttpsURLConnection) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(f19151a);
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m24387a(java.util.Map<java.lang.String, java.lang.Object> r4, java.lang.String r5, java.lang.String r6, com.stripe.android.C5759n r7, com.stripe.android.C5770q.C5767a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r0 = java.lang.Boolean.valueOf(r0);
        r1 = 0;
        r2 = "networkaddress.cache.ttl";	 Catch:{ SecurityException -> 0x0014 }
        r2 = java.security.Security.getProperty(r2);	 Catch:{ SecurityException -> 0x0014 }
        r1 = "networkaddress.cache.ttl";	 Catch:{ SecurityException -> 0x0015 }
        r3 = "0";	 Catch:{ SecurityException -> 0x0015 }
        java.security.Security.setProperty(r1, r3);	 Catch:{ SecurityException -> 0x0015 }
        goto L_0x001a;
    L_0x0014:
        r2 = r1;
    L_0x0015:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
    L_0x001a:
        r4 = com.stripe.android.C5770q.m24369a(r6, r5, r4, r7);	 Catch:{ h -> 0x003b }
        if (r8 == 0) goto L_0x0023;	 Catch:{ h -> 0x003b }
    L_0x0020:
        r8.m24359a(r4);	 Catch:{ h -> 0x003b }
    L_0x0023:
        r4 = r0.booleanValue();
        if (r4 == 0) goto L_0x0061;
    L_0x0029:
        if (r2 != 0) goto L_0x0033;
    L_0x002b:
        r4 = "networkaddress.cache.ttl";
        r5 = "-1";
        java.security.Security.setProperty(r4, r5);
        goto L_0x0061;
    L_0x0033:
        r4 = "networkaddress.cache.ttl";
        java.security.Security.setProperty(r4, r2);
        goto L_0x0061;
    L_0x0039:
        r4 = move-exception;
        goto L_0x0042;
    L_0x003b:
        r4 = move-exception;
        if (r8 == 0) goto L_0x0058;
    L_0x003e:
        r8.m24358a(r4);	 Catch:{ all -> 0x0039 }
        goto L_0x0058;
    L_0x0042:
        r5 = r0.booleanValue();
        if (r5 == 0) goto L_0x0057;
    L_0x0048:
        if (r2 != 0) goto L_0x0052;
    L_0x004a:
        r5 = "networkaddress.cache.ttl";
        r6 = "-1";
        java.security.Security.setProperty(r5, r6);
        goto L_0x0057;
    L_0x0052:
        r5 = "networkaddress.cache.ttl";
        java.security.Security.setProperty(r5, r2);
    L_0x0057:
        throw r4;
    L_0x0058:
        r4 = r0.booleanValue();
        if (r4 == 0) goto L_0x0061;
    L_0x005e:
        if (r2 != 0) goto L_0x0033;
    L_0x0060:
        goto L_0x002b;
    L_0x0061:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.q.a(java.util.Map, java.lang.String, java.lang.String, com.stripe.android.n, com.stripe.android.q$a):void");
    }

    /* renamed from: c */
    private static List<C5768b> m24400c(Map<String, Object> map) {
        return C5770q.m24379a((Map) map, null);
    }

    /* renamed from: a */
    private static List<C5768b> m24378a(List<Object> list, String str) {
        List<C5768b> linkedList = new LinkedList();
        String format = String.format("%s[]", new Object[]{str});
        if (list.isEmpty() != null) {
            linkedList.add(new C5768b(str, ""));
        } else {
            for (Object a : list) {
                linkedList.addAll(C5770q.m24377a(a, format));
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private static List<C5768b> m24379a(Map<String, Object> map, String str) {
        List<C5768b> linkedList = new LinkedList();
        if (map == null) {
            return linkedList;
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null) {
                str2 = String.format("%s[%s]", new Object[]{str, str2});
            }
            linkedList.addAll(C5770q.m24377a(value, str2));
        }
        return linkedList;
    }

    /* renamed from: a */
    private static List<C5768b> m24377a(Object obj, String str) {
        if (obj instanceof Map) {
            return C5770q.m24379a((Map) obj, str);
        }
        if (obj instanceof List) {
            return C5770q.m24378a((List) obj, str);
        }
        if ("".equals(obj)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("You cannot set '");
            stringBuilder.append(str);
            stringBuilder.append("' to an empty string. We interpret empty strings as null in requests. You may set '");
            stringBuilder.append(str);
            stringBuilder.append("' to null to delete the property.");
            throw new C7155e(stringBuilder.toString(), str, null, Integer.valueOf(0), null);
        } else if (obj == null) {
            obj = new LinkedList();
            obj.add(new C5768b(str, ""));
            return obj;
        } else {
            List linkedList = new LinkedList();
            linkedList.add(new C5768b(str, obj.toString()));
            return linkedList;
        }
    }

    /* renamed from: b */
    private static String m24394b(String str, String str2) {
        if (str2 != null) {
            if (!str2.isEmpty()) {
                String str3 = str.contains("?") ? "&" : "?";
                return String.format("%s%s%s", new Object[]{str, str3, str2});
            }
        }
        return str;
    }

    /* renamed from: b */
    private static String m24392b(C5759n c5759n) {
        if ("json_data".equals(c5759n.m24332e()) != null) {
            return String.format("application/json; charset=%s", new Object[]{Utf8Charset.NAME});
        }
        return String.format("application/x-www-form-urlencoded;charset=%s", new Object[]{Utf8Charset.NAME});
    }

    /* renamed from: a */
    private static byte[] m24388a(Map<String, Object> map, C5759n c5759n) {
        try {
            if ("json_data".equals(c5759n.m24332e()) == null) {
                return C5770q.m24373a((Map) map).getBytes(Utf8Charset.NAME);
            }
            map = C5770q.m24395b((Map) map);
            if (map != null) {
                return map.toString().getBytes(Utf8Charset.NAME);
            }
            throw new C7155e("Unable to create JSON data from parameters. Please contact support@stripe.com for assistance.", null, null, Integer.valueOf(0), null);
        } catch (Map<String, Object> map2) {
            throw new C7155e("Unable to encode parameters to UTF-8. Please contact support@stripe.com for assistance.", null, null, Integer.valueOf(0), map2);
        }
    }

    /* renamed from: a */
    private static String m24371a(InputStream inputStream) {
        String next = new Scanner(inputStream, Utf8Charset.NAME).useDelimiter("\\A").next();
        inputStream.close();
        return next;
    }

    /* renamed from: a */
    private static C5773s m24369a(String str, String str2, Map<String, Object> map, C5759n c5759n) {
        Object obj = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            int hashCode = str.hashCode();
            if (hashCode != 70454) {
                if (hashCode == 2461856) {
                    if (str.equals("POST")) {
                        obj = 1;
                    }
                }
            } else if (str.equals("GET")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    str = C5770q.m24375a(str2, C5770q.m24373a((Map) map), c5759n);
                    break;
                case 1:
                    str = C5770q.m24376a(str2, (Map) map, c5759n);
                    break;
                default:
                    throw new C7151a(String.format("Unrecognized HTTP method %s. This indicates a bug in the Stripe bindings. Please contact support@stripe.com for assistance.", new Object[]{str}));
            }
            String str3 = str;
            str = str3.getResponseCode();
            if (str < 200 || str >= 300) {
                str2 = C5770q.m24371a(str3.getErrorStream());
            } else {
                str2 = C5770q.m24371a(str3.getInputStream());
            }
            c5759n = new C5773s(str, str2, str3.getHeaderFields());
            if (str3 != null) {
                str3.disconnect();
            }
            return c5759n;
        } catch (String str4) {
            throw new C7151a(String.format("IOException during API request to Stripe (%s): %s Please check your internet connection and try again. If this problem persists, you should check Stripe's service status at https://twitter.com/stripestatus, or let us know at support@stripe.com.", new Object[]{C5770q.m24370a(), str4.getMessage()}), str4);
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: a */
    private static void m24384a(String str, int i, String str2) {
        str = C5738g.m24298a(str);
        if (i != 429) {
            switch (i) {
                case 400:
                    throw new C7155e(str.f19096b, str.f19098d, str2, Integer.valueOf(i), null);
                case 401:
                    throw new C7153c(str.f19096b, str2, Integer.valueOf(i));
                case 402:
                    throw new C7154d(str.f19096b, str2, str.f19097c, str.f19098d, str.f19099e, str.f19100f, Integer.valueOf(i), null);
                case 403:
                    throw new C8033f(str.f19096b, str2, Integer.valueOf(i));
                case HttpStatus.HTTP_NOT_FOUND /*404*/:
                    throw new C7155e(str.f19096b, str.f19098d, str2, Integer.valueOf(i), null);
                default:
                    throw new C7152b(str.f19096b, str2, Integer.valueOf(i), null);
            }
        }
        throw new C8034g(str.f19096b, str.f19098d, str2, Integer.valueOf(i), null);
    }

    /* renamed from: b */
    private static com.stripe.android.C5773s m24390b(java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8, com.stripe.android.C5759n r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r9 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);
        r2 = 0;
        r3 = "networkaddress.cache.ttl";	 Catch:{ SecurityException -> 0x0018 }
        r3 = java.security.Security.getProperty(r3);	 Catch:{ SecurityException -> 0x0018 }
        r4 = "networkaddress.cache.ttl";	 Catch:{ SecurityException -> 0x0019 }
        r5 = "0";	 Catch:{ SecurityException -> 0x0019 }
        java.security.Security.setProperty(r4, r5);	 Catch:{ SecurityException -> 0x0019 }
        goto L_0x001d;
    L_0x0018:
        r3 = r0;
    L_0x0019:
        r1 = java.lang.Boolean.valueOf(r2);
    L_0x001d:
        r4 = r9.m24331d();
        r4 = r4.trim();
        r4 = r4.isEmpty();
        if (r4 != 0) goto L_0x0077;
    L_0x002b:
        r6 = com.stripe.android.C5770q.m24369a(r6, r7, r8, r9);
        r7 = r6.m24412a();
        r8 = r6.m24413b();
        r9 = r6.m24414c();
        if (r9 != 0) goto L_0x003f;
    L_0x003d:
        r9 = r0;
        goto L_0x0047;
    L_0x003f:
        r4 = "Request-Id";
        r9 = r9.get(r4);
        r9 = (java.util.List) r9;
    L_0x0047:
        if (r9 == 0) goto L_0x0056;
    L_0x0049:
        r4 = r9.size();
        if (r4 <= 0) goto L_0x0056;
    L_0x004f:
        r9 = r9.get(r2);
        r0 = r9;
        r0 = (java.lang.String) r0;
    L_0x0056:
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 < r9) goto L_0x005e;
    L_0x005a:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r7 < r9) goto L_0x0061;
    L_0x005e:
        com.stripe.android.C5770q.m24384a(r8, r7, r0);
    L_0x0061:
        r7 = r1.booleanValue();
        if (r7 == 0) goto L_0x0076;
    L_0x0067:
        if (r3 != 0) goto L_0x0071;
    L_0x0069:
        r7 = "networkaddress.cache.ttl";
        r8 = "-1";
        java.security.Security.setProperty(r7, r8);
        goto L_0x0076;
    L_0x0071:
        r7 = "networkaddress.cache.ttl";
        java.security.Security.setProperty(r7, r3);
    L_0x0076:
        return r6;
    L_0x0077:
        r6 = new com.stripe.android.a.c;
        r7 = java.lang.Integer.valueOf(r2);
        r8 = "No API key provided. (HINT: set your API key using 'Stripe.apiKey = <API-KEY>'. You can generate API keys from the Stripe web interface. See https://stripe.com/api for details or email support@stripe.com if you have questions.";
        r6.<init>(r8, r0, r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.q.b(java.lang.String, java.lang.String, java.util.Map, com.stripe.android.n):com.stripe.android.s");
    }

    /* renamed from: c */
    private static C7168u m24396c(String str, String str2, Map<String, Object> map, C5759n c5759n) {
        return C7168u.m33337a(C5770q.m24390b(str, str2, map, c5759n).m24413b());
    }

    /* renamed from: a */
    private static void m24382a(Context context, C5767a c5767a) {
        Map a = C5776v.m24423a(context);
        C5772r.m24411a(a);
        if (c5767a == null || c5767a.m24360a()) {
            C5770q.m24387a(a, "https://m.stripe.com/4", "POST", C5759n.m24326a(null, "json_data").m24321a(C5776v.m24426b(context)).m24322a(), c5767a);
        }
    }

    /* renamed from: d */
    private static boolean m24401d(String str) {
        if (!str.startsWith("https://api.stripe.com")) {
            if (str.startsWith("https://q.stripe.com") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static boolean m24402e(String str) {
        return str.startsWith("https://m.stripe.com/4");
    }

    /* renamed from: c */
    private static String m24399c(String str, String str2) {
        return String.format("%s=%s", new Object[]{C5770q.m24403f(str), C5770q.m24403f(str2)});
    }

    /* renamed from: f */
    private static String m24403f(String str) {
        return str == null ? null : URLEncoder.encode(str, Utf8Charset.NAME);
    }
}
