package host.exp.exponent.p346j;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONUtils */
/* renamed from: host.exp.exponent.j.g */
public class C6389g {
    /* renamed from: a */
    public static String m26207a(Object obj) {
        if (obj instanceof HashMap) {
            return C6389g.m26209a((HashMap) obj).toString();
        }
        if (obj instanceof ArrayList) {
            return C6389g.m26208a((ArrayList) obj).toString();
        }
        return String.valueOf(obj);
    }

    /* renamed from: a */
    public static JSONArray m26208a(ArrayList<Object> arrayList) {
        JSONArray jSONArray = new JSONArray();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            Object next = arrayList.next();
            if (next instanceof HashMap) {
                next = C6389g.m26209a((HashMap) next);
            } else if (next instanceof ArrayList) {
                next = C6389g.m26208a((ArrayList) next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m26209a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        for (String str : hashMap.keySet()) {
            Object obj = hashMap.get(str);
            if (obj instanceof HashMap) {
                obj = C6389g.m26209a((HashMap) obj);
            } else if (obj instanceof ArrayList) {
                obj = C6389g.m26208a((ArrayList) obj);
            }
            jSONObject.put(str, obj);
        }
        return jSONObject;
    }
}
