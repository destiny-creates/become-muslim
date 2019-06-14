package com.idehub.GoogleAnalyticsBridge;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ConvertToWritable */
/* renamed from: com.idehub.GoogleAnalyticsBridge.b */
public class C5400b {
    /* renamed from: a */
    public static WritableMap m22947a(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                createMap.putNull(str);
            } else if (value instanceof Integer) {
                createMap.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                createMap.putDouble(str, ((Double) value).doubleValue());
            } else if (value instanceof Double) {
                createMap.putDouble(str, ((Double) value).doubleValue());
            } else if (value instanceof List) {
                createMap.putArray(str, C5400b.m22946a((List) value));
            } else if (value instanceof Map) {
                createMap.putMap(str, C5400b.m22947a((Map) value));
            } else if (value instanceof String) {
                createMap.putString(str, (String) value);
            } else {
                createMap.putString(str, value.toString());
            }
        }
        return createMap;
    }

    /* renamed from: a */
    public static WritableArray m22946a(List<Object> list) {
        WritableArray createArray = Arguments.createArray();
        for (Object next : list) {
            if (next == null) {
                createArray.pushNull();
            } else if (next instanceof Integer) {
                createArray.pushInt(((Integer) next).intValue());
            } else if (next instanceof Long) {
                createArray.pushDouble(((Double) next).doubleValue());
            } else if (next instanceof Double) {
                createArray.pushDouble(((Double) next).doubleValue());
            } else if (next instanceof List) {
                createArray.pushArray(C5400b.m22946a((List) next));
            } else if (next instanceof Map) {
                createArray.pushMap(C5400b.m22947a((Map) next));
            } else if (next instanceof String) {
                createArray.pushString((String) next);
            } else {
                createArray.pushString(next.toString());
            }
        }
        return createArray;
    }
}
