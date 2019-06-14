package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$1 */
    static class C37601 implements Setter {
        C37601() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$2 */
    static class C37612 implements Setter {
        C37612() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$3 */
    static class C37623 implements Setter {
        C37623() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$4 */
    static class C37634 implements Setter {
        C37634() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$5 */
    static class C37645 implements Setter {
        C37645() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$6 */
    static class C37656 implements Setter {
        C37656() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            JSONArray jSONArray = new JSONArray();
            for (Object put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$7 */
    static class C37667 implements Setter {
        C37667() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    arrayList.add((String) obj2);
                    i++;
                } else {
                    str = new StringBuilder();
                    str.append("Unexpected type in an array: ");
                    str.append(obj2.getClass());
                    throw new IllegalArgumentException(str.toString());
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    static {
        SETTERS.put(Boolean.class, new C37601());
        SETTERS.put(Integer.class, new C37612());
        SETTERS.put(Long.class, new C37623());
        SETTERS.put(Double.class, new C37634());
        SETTERS.put(String.class, new C37645());
        SETTERS.put(String[].class, new C37656());
        SETTERS.put(JSONArray.class, new C37667());
    }

    public static JSONObject convertToJSON(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnJSON(jSONObject, str, obj);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported type: ");
                        stringBuilder.append(obj.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj != JSONObject.NULL) {
                    if (obj instanceof JSONObject) {
                        bundle.putBundle(str, convertToBundle((JSONObject) obj));
                    } else {
                        Setter setter = (Setter) SETTERS.get(obj.getClass());
                        if (setter != null) {
                            setter.setOnBundle(bundle, str, obj);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported type: ");
                            stringBuilder.append(obj.getClass());
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                }
            }
        }
        return bundle;
    }
}
