package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

@cm
public final class lr {
    /* renamed from: a */
    private static final lt<Map<String, ?>> f15764a = new ls();

    /* renamed from: a */
    public static List<String> m19836a(JSONArray jSONArray, List<String> list) {
        list = new ArrayList();
        if (jSONArray == null) {
            return list;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }
}
