package net.openid.appauth;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonUtil */
/* renamed from: net.openid.appauth.n */
final class C6604n {

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$b */
    static abstract class C6602b<T> {
        /* renamed from: a */
        public final String f21258a;
        /* renamed from: b */
        public final T f21259b;

        /* renamed from: b */
        abstract T mo5515b(String str);

        C6602b(String str, T t) {
            this.f21258a = str;
            this.f21259b = t;
        }
    }

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$c */
    static abstract class C6603c<T> {
        /* renamed from: a */
        public final String f21260a;
        /* renamed from: b */
        public final List<T> f21261b;

        C6603c(String str, List<T> list) {
            this.f21260a = str;
            this.f21261b = list;
        }
    }

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$a */
    static final class C7642a extends C6602b<Boolean> {
        /* renamed from: b */
        /* synthetic */ Object mo5515b(String str) {
            return m34537a(str);
        }

        C7642a(String str, boolean z) {
            super(str, Boolean.valueOf(z));
        }

        /* renamed from: a */
        Boolean m34537a(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$d */
    static final class C7643d extends C6602b<String> {
        /* renamed from: a */
        String m34539a(String str) {
            return str;
        }

        /* renamed from: b */
        /* synthetic */ Object mo5515b(String str) {
            return m34539a(str);
        }

        C7643d(String str, String str2) {
            super(str, str2);
        }

        C7643d(String str) {
            this(str, null);
        }
    }

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$e */
    static final class C7644e extends C6603c<String> {
        C7644e(String str) {
            super(str, null);
        }

        C7644e(String str, List<String> list) {
            super(str, list);
        }
    }

    /* compiled from: JsonUtil */
    /* renamed from: net.openid.appauth.n$f */
    static final class C7645f extends C6602b<Uri> {
        /* renamed from: b */
        /* synthetic */ Object mo5515b(String str) {
            return m34541a(str);
        }

        C7645f(String str, Uri uri) {
            super(str, uri);
        }

        C7645f(String str) {
            this(str, null);
        }

        /* renamed from: a */
        Uri m34541a(String str) {
            return Uri.parse(str);
        }
    }

    /* renamed from: a */
    public static void m26921a(org.json.JSONObject r2, java.lang.String r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "json must not be null";
        net.openid.appauth.C6605p.m26933a(r2, r0);
        r0 = "field must not be null";
        net.openid.appauth.C6605p.m26933a(r3, r0);
        r0 = java.lang.Integer.valueOf(r4);
        r1 = "value must not be null";
        net.openid.appauth.C6605p.m26933a(r0, r1);
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0017 }
        return;
    L_0x0017:
        r2 = new java.lang.IllegalStateException;
        r3 = "JSONException thrown in violation of contract, ex";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.n.a(org.json.JSONObject, java.lang.String, int):void");
    }

    /* renamed from: a */
    public static void m26924a(JSONObject jSONObject, String str, String str2) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        C6605p.m26933a((Object) str2, (Object) "value must not be null");
        try {
            jSONObject.put(str, str2);
        } catch (JSONObject jSONObject2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", jSONObject2);
        }
    }

    /* renamed from: a */
    public static void m26925a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        C6605p.m26933a((Object) jSONObject2, (Object) "value must not be null");
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONObject jSONObject3) {
            throw new IllegalStateException("JSONException thrown in violation of contract", jSONObject3);
        }
    }

    /* renamed from: b */
    public static void m26927b(JSONObject jSONObject, String str, String str2) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (str2 != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONObject jSONObject2) {
                throw new IllegalStateException("JSONException thrown in violation of contract", jSONObject2);
            }
        }
    }

    /* renamed from: a */
    public static void m26922a(JSONObject jSONObject, String str, Uri uri) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (uri != null) {
            try {
                jSONObject.put(str, uri.toString());
            } catch (JSONObject jSONObject2) {
                throw new IllegalStateException("JSONException thrown in violation of contract", jSONObject2);
            }
        }
    }

    /* renamed from: a */
    public static void m26923a(JSONObject jSONObject, String str, Long l) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (l != null) {
            try {
                jSONObject.put(str, l);
            } catch (JSONObject jSONObject2) {
                throw new IllegalStateException("JSONException thrown in violation of contract", jSONObject2);
            }
        }
    }

    /* renamed from: a */
    public static String m26919a(JSONObject jSONObject, String str) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (jSONObject.has(str)) {
            jSONObject = jSONObject.getString(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("field \"");
            stringBuilder.append(str);
            stringBuilder.append("\" is mapped to a null value");
            throw new JSONException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("field \"");
        stringBuilder.append(str);
        stringBuilder.append("\" not found in json object");
        throw new JSONException(stringBuilder.toString());
    }

    /* renamed from: b */
    public static String m26926b(JSONObject jSONObject, String str) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        jSONObject = jSONObject.getString(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field \"");
        stringBuilder.append(str);
        stringBuilder.append("\" is mapped to a null value");
        throw new JSONException(stringBuilder.toString());
    }

    /* renamed from: c */
    public static Uri m26928c(JSONObject jSONObject, String str) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        jSONObject = jSONObject.getString(str);
        if (jSONObject != null) {
            return Uri.parse(jSONObject);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field \"");
        stringBuilder.append(str);
        stringBuilder.append("\" is mapped to a null value");
        throw new JSONException(stringBuilder.toString());
    }

    /* renamed from: d */
    public static Uri m26929d(JSONObject jSONObject, String str) {
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        jSONObject = jSONObject.getString(str);
        if (jSONObject != null) {
            return Uri.parse(jSONObject);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field \"");
        stringBuilder.append(str);
        stringBuilder.append("\" is mapped to a null value");
        throw new JSONException(stringBuilder.toString());
    }

    /* renamed from: e */
    public static java.lang.Long m26930e(org.json.JSONObject r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "json must not be null";
        net.openid.appauth.C6605p.m26933a(r2, r0);
        r0 = "field must not be null";
        net.openid.appauth.C6605p.m26933a(r3, r0);
        r0 = r2.has(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0022;
    L_0x0011:
        r0 = r2.isNull(r3);
        if (r0 == 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0022;
    L_0x0018:
        r2 = r2.getLong(r3);	 Catch:{ JSONException -> 0x0021 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ JSONException -> 0x0021 }
        return r2;
    L_0x0021:
        return r1;
    L_0x0022:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.n.e(org.json.JSONObject, java.lang.String):java.lang.Long");
    }

    /* renamed from: f */
    public static Map<String, String> m26931f(JSONObject jSONObject, String str) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        C6605p.m26933a((Object) jSONObject, (Object) "json must not be null");
        C6605p.m26933a((Object) str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return linkedHashMap;
        }
        jSONObject = jSONObject.getJSONObject(str);
        str = jSONObject.keys();
        while (str.hasNext()) {
            String str2 = (String) str.next();
            linkedHashMap.put(str2, (String) C6605p.m26933a(jSONObject.getString(str2), (Object) "additional parameter values must not be null"));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static JSONObject m26920a(Map<String, String> map) {
        C6605p.m26932a(map);
        JSONObject jSONObject = new JSONObject();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            C6605p.m26933a(entry.getKey(), (Object) "map entries must not have null keys");
            C6605p.m26933a(entry.getValue(), (Object) "map entries must not have null values");
            C6604n.m26924a(jSONObject, (String) entry.getKey(), (String) entry.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static <T> T m26918a(JSONObject jSONObject, C6602b<T> c6602b) {
        try {
            if (jSONObject.has(c6602b.f21258a)) {
                return c6602b.mo5515b(jSONObject.getString(c6602b.f21258a));
            }
            return c6602b.f21259b;
        } catch (JSONObject jSONObject2) {
            throw new IllegalStateException("unexpected JSONException", jSONObject2);
        }
    }
}
