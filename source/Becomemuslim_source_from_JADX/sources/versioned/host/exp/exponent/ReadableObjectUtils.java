package versioned.host.exp.exponent;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import host.exp.exponent.p334a.C6289b;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadableObjectUtils {
    private static final String TAG = "ReadableObjectUtils";

    /* renamed from: versioned.host.exp.exponent.ReadableObjectUtils$1 */
    static /* synthetic */ class C67021 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$facebook$react$bridge$ReadableType = r0;
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.Null;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.Boolean;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = com.facebook.react.bridge.ReadableType.Map;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.ReadableObjectUtils.1.<clinit>():void");
        }
    }

    public static JSONObject readableToJson(ReadableMap readableMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                switch (C67021.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                    case 1:
                        jSONObject.put(nextKey, null);
                        break;
                    case 2:
                        jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                        break;
                    case 3:
                        jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                        break;
                    case 4:
                        jSONObject.put(nextKey, readableMap.getString(nextKey));
                        break;
                    case 5:
                        jSONObject.put(nextKey, readableToJson(readableMap.getMap(nextKey)));
                        break;
                    case 6:
                        jSONObject.put(nextKey, readableToJson(readableMap.getArray(nextKey)));
                        break;
                    default:
                        break;
                }
            }
        } catch (ReadableMap readableMap2) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error converting ReadableMap to json: ");
            stringBuilder.append(readableMap2.toString());
            C6289b.m25949a(str, stringBuilder.toString());
        }
        return jSONObject;
    }

    public static JSONArray readableToJson(ReadableArray readableArray) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < readableArray.size()) {
            try {
                switch (C67021.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                    case 1:
                        jSONArray.put(null);
                        break;
                    case 2:
                        jSONArray.put(readableArray.getBoolean(i));
                        break;
                    case 3:
                        jSONArray.put(readableArray.getDouble(i));
                        break;
                    case 4:
                        jSONArray.put(readableArray.getString(i));
                        break;
                    case 5:
                        jSONArray.put(readableToJson(readableArray.getMap(i)));
                        break;
                    case 6:
                        jSONArray.put(readableToJson(readableArray.getArray(i)));
                        break;
                    default:
                        break;
                }
                i++;
            } catch (ReadableArray readableArray2) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error converting ReadableArray to json: ");
                stringBuilder.append(readableArray2.toString());
                C6289b.m25949a(str, stringBuilder.toString());
            }
        }
        return jSONArray;
    }

    public static WritableMap jsonToReadable(JSONObject jSONObject) {
        WritableMap createMap = Arguments.createMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj instanceof Float)) {
                if (!(obj instanceof Double)) {
                    if (obj instanceof Number) {
                        createMap.putDouble(str, (double) jSONObject.getLong(str));
                    } else if (obj instanceof Boolean) {
                        createMap.putBoolean(str, jSONObject.getBoolean(str));
                    } else if (obj instanceof String) {
                        createMap.putString(str, jSONObject.getString(str));
                    } else if (obj instanceof JSONObject) {
                        createMap.putMap(str, jsonToReadable(jSONObject.getJSONObject(str)));
                    } else if (obj instanceof JSONArray) {
                        createMap.putArray(str, jsonToReadable(jSONObject.getJSONArray(str)));
                    } else if (obj == JSONObject.NULL) {
                        createMap.putNull(str);
                    }
                }
            }
            createMap.putDouble(str, jSONObject.getDouble(str));
        }
        return createMap;
    }

    public static WritableArray jsonToReadable(JSONArray jSONArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (!(obj instanceof Float)) {
                if (!(obj instanceof Double)) {
                    if (obj instanceof Number) {
                        createArray.pushDouble((double) jSONArray.getLong(i));
                    } else if (obj instanceof Boolean) {
                        createArray.pushBoolean(jSONArray.getBoolean(i));
                    } else if (obj instanceof String) {
                        createArray.pushString(jSONArray.getString(i));
                    } else if (obj instanceof JSONObject) {
                        createArray.pushMap(jsonToReadable(jSONArray.getJSONObject(i)));
                    } else if (obj instanceof JSONArray) {
                        createArray.pushArray(jsonToReadable(jSONArray.getJSONArray(i)));
                    } else if (obj == JSONObject.NULL) {
                        createArray.pushNull();
                    }
                }
            }
            createArray.pushDouble(jSONArray.getDouble(i));
        }
        return createArray;
    }
}
