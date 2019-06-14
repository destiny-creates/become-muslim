package com.facebook.react.bridge;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Arguments {
    private static Object makeNativeObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!((obj instanceof Float) || (obj instanceof Long) || (obj instanceof Byte))) {
            if (!(obj instanceof Short)) {
                if (obj.getClass().isArray()) {
                    return makeNativeArray(obj);
                }
                if (obj instanceof List) {
                    return makeNativeArray((List) obj);
                }
                if (obj instanceof Map) {
                    return makeNativeMap((Map) obj);
                }
                return obj instanceof Bundle ? makeNativeMap((Bundle) obj) : obj;
            }
        }
        return new Double(((Number) obj).doubleValue());
    }

    public static WritableNativeArray makeNativeArray(List list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (list == null) {
            return writableNativeArray;
        }
        for (Object makeNativeObject : list) {
            Object makeNativeObject2 = makeNativeObject(makeNativeObject2);
            if (makeNativeObject2 == null) {
                writableNativeArray.pushNull();
            } else if (makeNativeObject2 instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) makeNativeObject2).booleanValue());
            } else if (makeNativeObject2 instanceof Integer) {
                writableNativeArray.pushInt(((Integer) makeNativeObject2).intValue());
            } else if (makeNativeObject2 instanceof Double) {
                writableNativeArray.pushDouble(((Double) makeNativeObject2).doubleValue());
            } else if (makeNativeObject2 instanceof String) {
                writableNativeArray.pushString((String) makeNativeObject2);
            } else if (makeNativeObject2 instanceof WritableNativeArray) {
                writableNativeArray.pushArray((WritableNativeArray) makeNativeObject2);
            } else if (makeNativeObject2 instanceof WritableNativeMap) {
                writableNativeArray.pushMap((WritableNativeMap) makeNativeObject2);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(makeNativeObject2.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return writableNativeArray;
    }

    public static <T> WritableNativeArray makeNativeArray(final Object obj) {
        if (obj == null) {
            return new WritableNativeArray();
        }
        return makeNativeArray(new AbstractList() {
            public int size() {
                return Array.getLength(obj);
            }

            public Object get(int i) {
                return Array.get(obj, i);
            }
        });
    }

    private static void addEntry(WritableNativeMap writableNativeMap, String str, Object obj) {
        obj = makeNativeObject(obj);
        if (obj == null) {
            writableNativeMap.putNull(str);
        } else if (obj instanceof Boolean) {
            writableNativeMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            writableNativeMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableNativeMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            writableNativeMap.putString(str, (String) obj);
        } else if (obj instanceof WritableNativeArray) {
            writableNativeMap.putArray(str, (WritableNativeArray) obj);
        } else if (obj instanceof WritableNativeMap) {
            writableNativeMap.putMap(str, (WritableNativeMap) obj);
        } else {
            str = new StringBuilder();
            str.append("Could not convert ");
            str.append(obj.getClass());
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static WritableNativeMap makeNativeMap(Map<String, Object> map) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (map == null) {
            return writableNativeMap;
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            addEntry(writableNativeMap, (String) entry.getKey(), entry.getValue());
        }
        return writableNativeMap;
    }

    public static WritableNativeMap makeNativeMap(Bundle bundle) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (bundle == null) {
            return writableNativeMap;
        }
        for (String str : bundle.keySet()) {
            addEntry(writableNativeMap, str, bundle.get(str));
        }
        return writableNativeMap;
    }

    public static WritableArray createArray() {
        return new WritableNativeArray();
    }

    public static WritableMap createMap() {
        return new WritableNativeMap();
    }

    public static WritableNativeArray fromJavaArgs(Object[] objArr) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Object obj : objArr) {
            if (obj == null) {
                writableNativeArray.pushNull();
            } else {
                Class cls = obj.getClass();
                if (cls == Boolean.class) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (cls == Integer.class) {
                    writableNativeArray.pushDouble(((Integer) obj).doubleValue());
                } else if (cls == Double.class) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (cls == Float.class) {
                    writableNativeArray.pushDouble(((Float) obj).doubleValue());
                } else if (cls == String.class) {
                    writableNativeArray.pushString(obj.toString());
                } else if (cls == WritableNativeMap.class) {
                    writableNativeArray.pushMap((WritableNativeMap) obj);
                } else if (cls == WritableNativeArray.class) {
                    writableNativeArray.pushArray((WritableNativeArray) obj);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot convert argument of type ");
                    stringBuilder.append(cls);
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }
        return writableNativeArray;
    }

    public static WritableArray fromArray(Object obj) {
        WritableArray createArray = createArray();
        int i = 0;
        int length;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            length = strArr.length;
            while (i < length) {
                createArray.pushString(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            length = bundleArr.length;
            while (i < length) {
                createArray.pushMap(fromBundle(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            length = iArr.length;
            while (i < length) {
                createArray.pushInt(iArr[i]);
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            length = fArr.length;
            while (i < length) {
                createArray.pushDouble((double) fArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            length = dArr.length;
            while (i < length) {
                createArray.pushDouble(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            length = zArr.length;
            while (i < length) {
                createArray.pushBoolean(zArr[i]);
                i++;
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown array type ");
            stringBuilder.append(obj.getClass());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return createArray;
    }

    public static WritableArray fromList(List list) {
        WritableArray createArray = createArray();
        for (Object next : list) {
            if (next == null) {
                createArray.pushNull();
            } else if (next.getClass().isArray()) {
                createArray.pushArray(fromArray(next));
            } else if (next instanceof Bundle) {
                createArray.pushMap(fromBundle((Bundle) next));
            } else if (next instanceof List) {
                createArray.pushArray(fromList((List) next));
            } else if (next instanceof String) {
                createArray.pushString((String) next);
            } else if (next instanceof Integer) {
                createArray.pushInt(((Integer) next).intValue());
            } else if (next instanceof Number) {
                createArray.pushDouble(((Number) next).doubleValue());
            } else if (next instanceof Boolean) {
                createArray.pushBoolean(((Boolean) next).booleanValue());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value type ");
                stringBuilder.append(next.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return createArray;
    }

    public static WritableMap fromBundle(Bundle bundle) {
        WritableMap createMap = createMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                createMap.putNull(str);
            } else if (obj.getClass().isArray()) {
                createMap.putArray(str, fromArray(obj));
            } else if (obj instanceof String) {
                createMap.putString(str, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    createMap.putInt(str, ((Integer) obj).intValue());
                } else {
                    createMap.putDouble(str, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                createMap.putMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createMap.putArray(str, fromList((List) obj));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append(obj.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return createMap;
    }

    public static ArrayList toList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (readableArray.getType(i)) {
                case Null:
                    arrayList.add(null);
                    break;
                case Boolean:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case Number:
                    double d = readableArray.getDouble(i);
                    if (d != Math.rint(d)) {
                        arrayList.add(Double.valueOf(d));
                        break;
                    }
                    arrayList.add(Integer.valueOf((int) d));
                    break;
                case String:
                    arrayList.add(readableArray.getString(i));
                    break;
                case Map:
                    arrayList.add(toBundle(readableArray.getMap(i)));
                    break;
                case Array:
                    arrayList.add(toList(readableArray.getArray(i)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object in array.");
            }
        }
        return arrayList;
    }

    public static Bundle toBundle(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Bundle bundle = new Bundle();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    bundle.putString(nextKey, null);
                    break;
                case Boolean:
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    bundle.putBundle(nextKey, toBundle(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    bundle.putSerializable(nextKey, toList(readableMap.getArray(nextKey)));
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not convert object with key: ");
                    stringBuilder.append(nextKey);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return bundle;
    }
}
