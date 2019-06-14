package net.openid.appauth;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: AdditionalParamsProcessor */
/* renamed from: net.openid.appauth.a */
class C6572a {
    /* renamed from: a */
    static Set<String> m26794a(String... strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                return Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
            }
        }
        return Collections.emptySet();
    }

    /* renamed from: a */
    static Map<String, String> m26792a(Map<String, String> map, Set<String> set) {
        if (map == null) {
            return Collections.emptyMap();
        }
        Map linkedHashMap = new LinkedHashMap();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            Object obj = (String) entry.getKey();
            Object obj2 = (String) entry.getValue();
            C6605p.m26933a(obj, (Object) "additional parameter keys cannot be null");
            C6605p.m26933a(obj2, (Object) "additional parameter values cannot be null");
            C6605p.m26936a(set.contains(obj) ^ true, "Parameter %s is directly supported via the authorization request builder, use the builder method instead", obj);
            linkedHashMap.put(obj, obj2);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static Map<String, String> m26793a(JSONObject jSONObject, Set<String> set) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!set.contains(str)) {
                linkedHashMap.put(str, jSONObject.get(str).toString());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    static Map<String, String> m26791a(Uri uri, Set<String> set) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!set.contains(str)) {
                linkedHashMap.put(str, uri.getQueryParameter(str));
            }
        }
        return linkedHashMap;
    }
}
