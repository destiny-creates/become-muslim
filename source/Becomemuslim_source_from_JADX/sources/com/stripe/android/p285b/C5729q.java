package com.stripe.android.p285b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: StripeJsonModel */
/* renamed from: com.stripe.android.b.q */
public abstract class C5729q {
    /* renamed from: a */
    public abstract JSONObject mo5065a();

    /* renamed from: b */
    public abstract Map<String, Object> mo5066b();

    public String toString() {
        return mo5065a().toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5729q)) {
            return null;
        }
        return toString().equals(((C5729q) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    /* renamed from: a */
    static void m24268a(Map<String, Object> map, String str, C5729q c5729q) {
        if (c5729q != null) {
            map.put(str, c5729q.mo5066b());
        }
    }

    /* renamed from: a */
    static void m24270a(org.json.JSONObject r0, java.lang.String r1, com.stripe.android.p285b.C5729q r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r2 = r2.mo5065a();	 Catch:{ JSONException -> 0x000a }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.q.a(org.json.JSONObject, java.lang.String, com.stripe.android.b.q):void");
    }

    /* renamed from: a */
    static void m24269a(Map<String, Object> map, String str, List<? extends C5729q> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(((C5729q) list.get(i)).mo5066b());
            }
            map.put(str, arrayList);
        }
    }

    /* renamed from: a */
    static void m24271a(org.json.JSONObject r2, java.lang.String r3, java.util.List<? extends com.stripe.android.p285b.C5729q> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0023 }
        r0.<init>();	 Catch:{ JSONException -> 0x0023 }
        r4 = r4.iterator();	 Catch:{ JSONException -> 0x0023 }
    L_0x000c:
        r1 = r4.hasNext();	 Catch:{ JSONException -> 0x0023 }
        if (r1 == 0) goto L_0x0020;	 Catch:{ JSONException -> 0x0023 }
    L_0x0012:
        r1 = r4.next();	 Catch:{ JSONException -> 0x0023 }
        r1 = (com.stripe.android.p285b.C5729q) r1;	 Catch:{ JSONException -> 0x0023 }
        r1 = r1.mo5065a();	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1);	 Catch:{ JSONException -> 0x0023 }
        goto L_0x000c;	 Catch:{ JSONException -> 0x0023 }
    L_0x0020:
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x0023 }
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.q.a(org.json.JSONObject, java.lang.String, java.util.List):void");
    }
}
