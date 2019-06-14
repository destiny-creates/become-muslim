package com.stripe.android.p285b;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: StripeSourceTypeModel */
/* renamed from: com.stripe.android.b.t */
abstract class C7167t extends C5729q {
    /* renamed from: a */
    Map<String, Object> f25398a = new HashMap();
    /* renamed from: b */
    Set<String> f25399b = new HashSet();

    C7167t() {
    }

    /* renamed from: a */
    void m33336a(String... strArr) {
        Collections.addAll(this.f25399b, strArr);
    }

    /* renamed from: a */
    void m33335a(Map<String, Object> map) {
        this.f25398a = map;
    }

    /* renamed from: a */
    static Map<String, Object> m33332a(JSONObject jSONObject, Set<String> set) {
        if (jSONObject == null) {
            return null;
        }
        if (set == null) {
            set = new HashSet();
        }
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (!("null".equals(opt) || opt == null)) {
                if (!set.contains(str)) {
                    hashMap.put(str, opt);
                }
            }
        }
        if (hashMap.isEmpty() != null) {
            return null;
        }
        return hashMap;
    }

    /* renamed from: a */
    static void m33334a(org.json.JSONObject r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x002e;
    L_0x0002:
        if (r4 == 0) goto L_0x002e;
    L_0x0004:
        r0 = r4.isEmpty();
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x002e;
    L_0x000b:
        r0 = r4.keySet();
        r0 = r0.iterator();
    L_0x0013:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x002d;
    L_0x0019:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r2 = r4.get(r1);	 Catch:{ JSONException -> 0x0013 }
        if (r2 == 0) goto L_0x0013;	 Catch:{ JSONException -> 0x0013 }
    L_0x0025:
        r2 = r4.get(r1);	 Catch:{ JSONException -> 0x0013 }
        r3.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
        goto L_0x0013;
    L_0x002d:
        return;
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.t.a(org.json.JSONObject, java.util.Map):void");
    }

    /* renamed from: a */
    static void m33333a(Map<String, Object> map, Map<String, Object> map2) {
        if (!(map == null || map2 == null)) {
            if (!map2.isEmpty()) {
                for (String str : map2.keySet()) {
                    map.put(str, map2.get(str));
                }
            }
        }
    }
}
