package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.cz;
import com.google.android.gms.internal.p210i.db;
import com.google.android.gms.internal.p210i.dc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.e.bk */
final class bk {
    /* renamed from: a */
    public static db m8576a(String str) {
        str = eu.m8716a(bk.m8577a(new JSONObject(str)));
        dc a = db.a();
        for (int i = 0; i < str.f28860d.length; i++) {
            a.a(cz.a().a(ab.f16334v.toString(), str.f28860d[i]).a(ab.f16329q.toString(), eu.m8717a(fl.m14592d())).a(fl.m14593e(), str.f28861e[i]).a());
        }
        return a.a();
    }

    /* renamed from: a */
    private static Object m8577a(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, bk.m8577a(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
