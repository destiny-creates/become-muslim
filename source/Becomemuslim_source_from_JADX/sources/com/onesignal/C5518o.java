package com.onesignal;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONUtils */
/* renamed from: com.onesignal.o */
class C5518o {
    /* renamed from: a */
    static JSONObject m23504a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        JSONObject jSONObject4;
        Iterator keys = jSONObject2.keys();
        if (jSONObject3 != null) {
            jSONObject4 = jSONObject3;
        } else {
            jSONObject4 = new JSONObject();
        }
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.has(str)) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject5 = jSONObject.getJSONObject(str);
                        JSONObject jSONObject6 = (jSONObject3 == null || !jSONObject3.has(str)) ? null : jSONObject3.getJSONObject(str);
                        String jSONObject7 = C5518o.m23504a(jSONObject5, (JSONObject) obj, jSONObject6, (Set) set).toString();
                        if (!jSONObject7.equals("{}")) {
                            jSONObject4.put(str, new JSONObject(jSONObject7));
                        }
                    } else if (obj instanceof JSONArray) {
                        C5518o.m23505a(str, (JSONArray) obj, jSONObject.getJSONArray(str), jSONObject4);
                    } else if (set == null || !set.contains(str)) {
                        Object obj2 = jSONObject.get(str);
                        if (!obj.equals(obj2)) {
                            if (!(obj2 instanceof Integer) || "".equals(obj)) {
                                jSONObject4.put(str, obj);
                            } else if (((Number) obj2).doubleValue() != ((Number) obj).doubleValue()) {
                                jSONObject4.put(str, obj);
                            }
                        }
                    } else {
                        jSONObject4.put(str, obj);
                    }
                } else if (obj instanceof JSONObject) {
                    jSONObject4.put(str, new JSONObject(obj.toString()));
                } else if (obj instanceof JSONArray) {
                    C5518o.m23505a(str, (JSONArray) obj, null, jSONObject4);
                } else {
                    jSONObject4.put(str, obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject4;
    }

    /* renamed from: a */
    private static void m23505a(String str, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
        if (!str.endsWith("_a")) {
            if (!str.endsWith("_d")) {
                String a = C5518o.m23502a(jSONArray);
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                String str2;
                if (jSONArray2 == null) {
                    str2 = null;
                } else {
                    str2 = C5518o.m23502a(jSONArray2);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str3 = (String) jSONArray.get(i);
                    if (jSONArray2 == null || !r3.contains(str3)) {
                        jSONArray3.put(str3);
                    }
                }
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        jSONArray = jSONArray2.getString(i2);
                        if (!a.contains(jSONArray)) {
                            jSONArray4.put(jSONArray);
                        }
                    }
                }
                if (jSONArray3.toString().equals("[]") == null) {
                    jSONArray = new StringBuilder();
                    jSONArray.append(str);
                    jSONArray.append("_a");
                    jSONObject.put(jSONArray.toString(), jSONArray3);
                }
                if (jSONArray4.toString().equals("[]") == null) {
                    jSONArray = new StringBuilder();
                    jSONArray.append(str);
                    jSONArray.append("_d");
                    jSONObject.put(jSONArray.toString(), jSONArray4);
                }
                return;
            }
        }
        jSONObject.put(str, jSONArray);
    }

    /* renamed from: a */
    static java.lang.String m23502a(org.json.JSONArray r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "[";
        r1 = 0;
    L_0x0003:
        r2 = r4.length();	 Catch:{ Throwable -> 0x002a }
        if (r1 >= r2) goto L_0x002a;	 Catch:{ Throwable -> 0x002a }
    L_0x0009:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002a }
        r2.<init>();	 Catch:{ Throwable -> 0x002a }
        r2.append(r0);	 Catch:{ Throwable -> 0x002a }
        r3 = "\"";	 Catch:{ Throwable -> 0x002a }
        r2.append(r3);	 Catch:{ Throwable -> 0x002a }
        r3 = r4.getString(r1);	 Catch:{ Throwable -> 0x002a }
        r2.append(r3);	 Catch:{ Throwable -> 0x002a }
        r3 = "\"";	 Catch:{ Throwable -> 0x002a }
        r2.append(r3);	 Catch:{ Throwable -> 0x002a }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x002a }
        r1 = r1 + 1;
        r0 = r2;
        goto L_0x0003;
    L_0x002a:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r0 = "]";
        r4.append(r0);
        r4 = r4.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.o.a(org.json.JSONArray):java.lang.String");
    }

    /* renamed from: a */
    static org.json.JSONObject m23503a(org.json.JSONObject r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.has(r5);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r4 = 0;
        return r4;
    L_0x0008:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r4 = r4.optJSONObject(r5);
        r5 = r4.keys();
    L_0x0015:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0033;
    L_0x001b:
        r1 = r5.next();
        r1 = (java.lang.String) r1;
        r2 = r4.get(r1);	 Catch:{ Throwable -> 0x0031 }
        r3 = "";	 Catch:{ Throwable -> 0x0031 }
        r3 = r3.equals(r2);	 Catch:{ Throwable -> 0x0031 }
        if (r3 != 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0031 }
    L_0x002d:
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0015;
        goto L_0x0015;
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.o.a(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }
}
