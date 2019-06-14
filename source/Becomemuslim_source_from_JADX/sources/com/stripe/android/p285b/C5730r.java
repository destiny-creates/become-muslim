package com.stripe.android.p285b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StripeJsonUtils */
/* renamed from: com.stripe.android.b.r */
class C5730r {
    /* renamed from: a */
    static Boolean m24274a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.optBoolean(str));
        }
        return null;
    }

    /* renamed from: b */
    static Integer m24285b(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    /* renamed from: c */
    static Long m24287c(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }

    /* renamed from: d */
    static String m24288d(JSONObject jSONObject, String str) {
        return C5730r.m24275a(jSONObject.optString(str));
    }

    /* renamed from: e */
    static String m24289e(JSONObject jSONObject, String str) {
        jSONObject = C5730r.m24275a(jSONObject.optString(str));
        return (jSONObject == null || jSONObject.length() != 2) ? null : jSONObject;
    }

    /* renamed from: f */
    static String m24290f(JSONObject jSONObject, String str) {
        jSONObject = C5730r.m24275a(jSONObject.optString(str));
        return (jSONObject == null || jSONObject.length() != 3) ? null : jSONObject;
    }

    /* renamed from: a */
    static Map<String, Object> m24277a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (!"null".equals(opt)) {
                if (opt != null) {
                    if (opt instanceof JSONObject) {
                        hashMap.put(str, C5730r.m24277a((JSONObject) opt));
                    } else if (opt instanceof JSONArray) {
                        hashMap.put(str, C5730r.m24276a((JSONArray) opt));
                    } else {
                        hashMap.put(str, opt);
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    static Map<String, String> m24286b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (!"null".equals(opt)) {
                if (opt != null) {
                    hashMap.put(str, opt.toString());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    static java.util.List<java.lang.Object> m24276a(org.json.JSONArray r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0004;
    L_0x0002:
        r4 = 0;
        return r4;
    L_0x0004:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
    L_0x000a:
        r2 = r4.length();
        if (r1 >= r2) goto L_0x0041;
    L_0x0010:
        r2 = r4.get(r1);	 Catch:{ JSONException -> 0x003e }
        r3 = r2 instanceof org.json.JSONArray;	 Catch:{ JSONException -> 0x003e }
        if (r3 == 0) goto L_0x0022;	 Catch:{ JSONException -> 0x003e }
    L_0x0018:
        r2 = (org.json.JSONArray) r2;	 Catch:{ JSONException -> 0x003e }
        r2 = com.stripe.android.p285b.C5730r.m24276a(r2);	 Catch:{ JSONException -> 0x003e }
        r0.add(r2);	 Catch:{ JSONException -> 0x003e }
        goto L_0x003e;	 Catch:{ JSONException -> 0x003e }
    L_0x0022:
        r3 = r2 instanceof org.json.JSONObject;	 Catch:{ JSONException -> 0x003e }
        if (r3 == 0) goto L_0x0032;	 Catch:{ JSONException -> 0x003e }
    L_0x0026:
        r2 = (org.json.JSONObject) r2;	 Catch:{ JSONException -> 0x003e }
        r2 = com.stripe.android.p285b.C5730r.m24277a(r2);	 Catch:{ JSONException -> 0x003e }
        if (r2 == 0) goto L_0x003e;	 Catch:{ JSONException -> 0x003e }
    L_0x002e:
        r0.add(r2);	 Catch:{ JSONException -> 0x003e }
        goto L_0x003e;	 Catch:{ JSONException -> 0x003e }
    L_0x0032:
        r3 = "null";	 Catch:{ JSONException -> 0x003e }
        r3 = r3.equals(r2);	 Catch:{ JSONException -> 0x003e }
        if (r3 == 0) goto L_0x003b;	 Catch:{ JSONException -> 0x003e }
    L_0x003a:
        goto L_0x003e;	 Catch:{ JSONException -> 0x003e }
    L_0x003b:
        r0.add(r2);	 Catch:{ JSONException -> 0x003e }
    L_0x003e:
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONArray):java.util.List<java.lang.Object>");
    }

    /* renamed from: a */
    static org.json.JSONObject m24279a(java.util.Map<java.lang.String, ? extends java.lang.Object> r5) {
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
        r3 = com.stripe.android.p285b.C5730r.m24279a(r3);	 Catch:{ JSONException -> 0x0032 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0032 }
        goto L_0x0011;
        goto L_0x0011;
    L_0x0034:
        r4 = r3 instanceof java.util.List;	 Catch:{  }
        if (r4 == 0) goto L_0x0042;	 Catch:{  }
    L_0x0038:
        r3 = (java.util.List) r3;	 Catch:{  }
        r3 = com.stripe.android.p285b.C5730r.m24278a(r3);	 Catch:{  }
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
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(java.util.Map):org.json.JSONObject");
    }

    /* renamed from: a */
    static org.json.JSONArray m24278a(java.util.List r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
        return r3;
    L_0x0004:
        r0 = new org.json.JSONArray;
        r0.<init>();
        r3 = r3.iterator();
    L_0x000d:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x0048;
    L_0x0013:
        r1 = r3.next();
        r2 = r1 instanceof java.util.Map;
        if (r2 == 0) goto L_0x0025;
    L_0x001b:
        r1 = (java.util.Map) r1;	 Catch:{ ClassCastException -> 0x000d }
        r1 = com.stripe.android.p285b.C5730r.m24279a(r1);	 Catch:{ ClassCastException -> 0x000d }
        r0.put(r1);	 Catch:{ ClassCastException -> 0x000d }
        goto L_0x000d;
    L_0x0025:
        r2 = r1 instanceof java.util.List;
        if (r2 == 0) goto L_0x0033;
    L_0x0029:
        r1 = (java.util.List) r1;
        r1 = com.stripe.android.p285b.C5730r.m24278a(r1);
        r0.put(r1);
        goto L_0x000d;
    L_0x0033:
        r2 = r1 instanceof java.lang.Number;
        if (r2 != 0) goto L_0x0044;
    L_0x0037:
        r2 = r1 instanceof java.lang.Boolean;
        if (r2 == 0) goto L_0x003c;
    L_0x003b:
        goto L_0x0044;
    L_0x003c:
        r1 = r1.toString();
        r0.put(r1);
        goto L_0x000d;
    L_0x0044:
        r0.put(r1);
        goto L_0x000d;
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(java.util.List):org.json.JSONArray");
    }

    /* renamed from: a */
    static void m24283a(org.json.JSONObject r1, java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.stripe.android.C5775u.m24419b(r3);
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    static void m24281a(org.json.JSONObject r0, java.lang.String r1, java.lang.Integer r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r2 = r2.intValue();	 Catch:{ JSONException -> 0x000a }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONObject, java.lang.String, java.lang.Integer):void");
    }

    /* renamed from: a */
    static void m24282a(org.json.JSONObject r2, java.lang.String r3, java.lang.Long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r4.longValue();	 Catch:{ JSONException -> 0x000a }
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONObject, java.lang.String, java.lang.Long):void");
    }

    /* renamed from: a */
    static void m24280a(org.json.JSONObject r0, java.lang.String r1, java.lang.Boolean r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r2 = r2.booleanValue();	 Catch:{ JSONException -> 0x000a }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONObject, java.lang.String, java.lang.Boolean):void");
    }

    /* renamed from: a */
    static void m24284a(org.json.JSONObject r0, java.lang.String r1, org.json.JSONObject r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.r.a(org.json.JSONObject, java.lang.String, org.json.JSONObject):void");
    }

    /* renamed from: a */
    static String m24275a(String str) {
        return ("null".equals(str) || "".equals(str)) ? null : str;
    }
}
