package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectArguments.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CameraEffectJSONUtility {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnArgumentsBuilder(Builder builder, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$1 */
    static class C39051 implements Setter {
        C39051() {
        }

        public void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
            builder.putArgument(str, (String) obj);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$2 */
    static class C39062 implements Setter {
        C39062() {
        }

        public void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
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

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$3 */
    static class C39073 implements Setter {
        C39073() {
        }

        public void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
            JSONArray jSONArray = (JSONArray) obj;
            String[] strArr = new String[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    strArr[i] = (String) obj2;
                    i++;
                } else {
                    str = new StringBuilder();
                    str.append("Unexpected type in an array: ");
                    str.append(obj2.getClass());
                    throw new IllegalArgumentException(str.toString());
                }
            }
            builder.putArgument(str, strArr);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    static {
        SETTERS.put(String.class, new C39051());
        SETTERS.put(String[].class, new C39062());
        SETTERS.put(JSONArray.class, new C39073());
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
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
        return jSONObject;
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj != JSONObject.NULL) {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnArgumentsBuilder(builder, str, obj);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported type: ");
                        stringBuilder.append(obj.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
        }
        return builder.build();
    }
}
