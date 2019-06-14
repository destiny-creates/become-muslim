package com.facebook.react.bridge;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class JsonWriterHelper {
    JsonWriterHelper() {
    }

    public static void value(JsonWriter jsonWriter, Object obj) {
        if (obj instanceof Map) {
            mapValue(jsonWriter, (Map) obj);
        } else if (obj instanceof List) {
            listValue(jsonWriter, (List) obj);
        } else {
            objectValue(jsonWriter, obj);
        }
    }

    private static void mapValue(JsonWriter jsonWriter, Map<?, ?> map) {
        jsonWriter.beginObject();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            jsonWriter.name(entry.getKey().toString());
            value(jsonWriter, entry.getValue());
        }
        jsonWriter.endObject();
    }

    private static void listValue(JsonWriter jsonWriter, List<?> list) {
        jsonWriter.beginArray();
        for (Object objectValue : list) {
            objectValue(jsonWriter, objectValue);
        }
        jsonWriter.endArray();
    }

    private static void objectValue(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
        } else if (obj instanceof String) {
            jsonWriter.value((String) obj);
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown value: ");
            stringBuilder.append(obj);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
