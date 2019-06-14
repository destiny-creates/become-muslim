package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaOnlyMap implements ReadableMap, WritableMap {
    private final Map mBackingMap;

    /* renamed from: com.facebook.react.bridge.JavaOnlyMap$1 */
    class C38281 implements ReadableMapKeySetIterator {
        Iterator<String> mIterator = JavaOnlyMap.this.mBackingMap.keySet().iterator();

        C38281() {
        }

        public boolean hasNextKey() {
            return this.mIterator.hasNext();
        }

        public String nextKey() {
            return (String) this.mIterator.next();
        }
    }

    public static JavaOnlyMap of(Object... objArr) {
        return new JavaOnlyMap(objArr);
    }

    public static JavaOnlyMap deepClone(ReadableMap readableMap) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    javaOnlyMap.putNull(nextKey);
                    break;
                case Boolean:
                    javaOnlyMap.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    javaOnlyMap.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    javaOnlyMap.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    javaOnlyMap.putMap(nextKey, deepClone(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    javaOnlyMap.putArray(nextKey, JavaOnlyArray.deepClone(readableMap.getArray(nextKey)));
                    break;
                default:
                    break;
            }
        }
        return javaOnlyMap;
    }

    private JavaOnlyMap(Object... objArr) {
        if (objArr.length % 2 == 0) {
            this.mBackingMap = new HashMap();
            for (int i = 0; i < objArr.length; i += 2) {
                this.mBackingMap.put(objArr[i], objArr[i + 1]);
            }
            return;
        }
        throw new IllegalArgumentException("You must provide the same number of keys and values");
    }

    public JavaOnlyMap() {
        this.mBackingMap = new HashMap();
    }

    public boolean hasKey(String str) {
        return this.mBackingMap.containsKey(str);
    }

    public boolean isNull(String str) {
        return this.mBackingMap.get(str) == null ? true : null;
    }

    public boolean getBoolean(String str) {
        return ((Boolean) this.mBackingMap.get(str)).booleanValue();
    }

    public double getDouble(String str) {
        return ((Number) this.mBackingMap.get(str)).doubleValue();
    }

    public int getInt(String str) {
        return ((Number) this.mBackingMap.get(str)).intValue();
    }

    public String getString(String str) {
        return (String) this.mBackingMap.get(str);
    }

    public ReadableMap getMap(String str) {
        return (ReadableMap) this.mBackingMap.get(str);
    }

    public JavaOnlyArray getArray(String str) {
        return (JavaOnlyArray) this.mBackingMap.get(str);
    }

    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    public ReadableType getType(String str) {
        Object obj = this.mBackingMap.get(str);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value ");
        stringBuilder.append(obj.toString());
        stringBuilder.append(" for key ");
        stringBuilder.append(str);
        stringBuilder.append("contained in JavaOnlyMap");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public ReadableMapKeySetIterator keySetIterator() {
        return new C38281();
    }

    public void putBoolean(String str, boolean z) {
        this.mBackingMap.put(str, Boolean.valueOf(z));
    }

    public void putDouble(String str, double d) {
        this.mBackingMap.put(str, Double.valueOf(d));
    }

    public void putInt(String str, int i) {
        this.mBackingMap.put(str, Integer.valueOf(i));
    }

    public void putString(String str, String str2) {
        this.mBackingMap.put(str, str2);
    }

    public void putNull(String str) {
        this.mBackingMap.put(str, null);
    }

    public void putMap(String str, WritableMap writableMap) {
        this.mBackingMap.put(str, writableMap);
    }

    public void merge(ReadableMap readableMap) {
        this.mBackingMap.putAll(((JavaOnlyMap) readableMap).mBackingMap);
    }

    public void putArray(String str, WritableArray writableArray) {
        this.mBackingMap.put(str, writableArray);
    }

    public HashMap<String, Object> toHashMap() {
        return new HashMap(this.mBackingMap);
    }

    public String toString() {
        return this.mBackingMap.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                JavaOnlyMap javaOnlyMap = (JavaOnlyMap) obj;
                if (this.mBackingMap == null) {
                    return javaOnlyMap.mBackingMap == null;
                } else {
                    if (this.mBackingMap.equals(javaOnlyMap.mBackingMap) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.mBackingMap != null ? this.mBackingMap.hashCode() : 0;
    }
}
