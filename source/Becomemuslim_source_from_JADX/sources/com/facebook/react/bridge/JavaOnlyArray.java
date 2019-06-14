package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaOnlyArray implements ReadableArray, WritableArray {
    private final List mBackingList;

    public static JavaOnlyArray from(List list) {
        return new JavaOnlyArray(list);
    }

    public static JavaOnlyArray of(Object... objArr) {
        return new JavaOnlyArray(objArr);
    }

    public static JavaOnlyArray deepClone(ReadableArray readableArray) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (readableArray.getType(i)) {
                case Null:
                    javaOnlyArray.pushNull();
                    break;
                case Boolean:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case Number:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i));
                    break;
                case String:
                    javaOnlyArray.pushString(readableArray.getString(i));
                    break;
                case Map:
                    javaOnlyArray.pushMap(JavaOnlyMap.deepClone(readableArray.getMap(i)));
                    break;
                case Array:
                    javaOnlyArray.pushArray(deepClone(readableArray.getArray(i)));
                    break;
                default:
                    break;
            }
        }
        return javaOnlyArray;
    }

    private JavaOnlyArray(Object... objArr) {
        this.mBackingList = Arrays.asList(objArr);
    }

    private JavaOnlyArray(List list) {
        this.mBackingList = new ArrayList(list);
    }

    public JavaOnlyArray() {
        this.mBackingList = new ArrayList();
    }

    public int size() {
        return this.mBackingList.size();
    }

    public boolean isNull(int i) {
        return this.mBackingList.get(i) == 0;
    }

    public double getDouble(int i) {
        return ((Number) this.mBackingList.get(i)).doubleValue();
    }

    public int getInt(int i) {
        return ((Number) this.mBackingList.get(i)).intValue();
    }

    public String getString(int i) {
        return (String) this.mBackingList.get(i);
    }

    public JavaOnlyArray getArray(int i) {
        return (JavaOnlyArray) this.mBackingList.get(i);
    }

    public boolean getBoolean(int i) {
        return ((Boolean) this.mBackingList.get(i)).booleanValue();
    }

    public JavaOnlyMap getMap(int i) {
        return (JavaOnlyMap) this.mBackingList.get(i);
    }

    public Dynamic getDynamic(int i) {
        return DynamicFromArray.create(this, i);
    }

    public ReadableType getType(int i) {
        i = this.mBackingList.get(i);
        if (i == 0) {
            return ReadableType.Null;
        }
        if (i instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (!((i instanceof Double) || (i instanceof Float))) {
            if (!(i instanceof Integer)) {
                if (i instanceof String) {
                    return ReadableType.String;
                }
                if (i instanceof ReadableArray) {
                    return ReadableType.Array;
                }
                if ((i instanceof ReadableMap) != 0) {
                    return ReadableType.Map;
                }
                return 0;
            }
        }
        return ReadableType.Number;
    }

    public void pushBoolean(boolean z) {
        this.mBackingList.add(Boolean.valueOf(z));
    }

    public void pushDouble(double d) {
        this.mBackingList.add(Double.valueOf(d));
    }

    public void pushInt(int i) {
        this.mBackingList.add(Integer.valueOf(i));
    }

    public void pushString(String str) {
        this.mBackingList.add(str);
    }

    public void pushArray(WritableArray writableArray) {
        this.mBackingList.add(writableArray);
    }

    public void pushMap(WritableMap writableMap) {
        this.mBackingList.add(writableMap);
    }

    public void pushNull() {
        this.mBackingList.add(null);
    }

    public ArrayList<Object> toArrayList() {
        return new ArrayList(this.mBackingList);
    }

    public String toString() {
        return this.mBackingList.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                JavaOnlyArray javaOnlyArray = (JavaOnlyArray) obj;
                if (this.mBackingList == null) {
                    return javaOnlyArray.mBackingList == null;
                } else {
                    if (this.mBackingList.equals(javaOnlyArray.mBackingList) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.mBackingList != null ? this.mBackingList.hashCode() : 0;
    }
}
