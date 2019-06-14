package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public class ReactStylesDiffMap {
    final ReadableMap mBackingMap;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.mBackingMap = readableMap;
    }

    public boolean hasKey(String str) {
        return this.mBackingMap.hasKey(str);
    }

    public boolean isNull(String str) {
        return this.mBackingMap.isNull(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mBackingMap.isNull(str) ? z : this.mBackingMap.getBoolean(str);
    }

    public double getDouble(String str, double d) {
        return this.mBackingMap.isNull(str) ? d : this.mBackingMap.getDouble(str);
    }

    public float getFloat(String str, float f) {
        return this.mBackingMap.isNull(str) ? f : (float) this.mBackingMap.getDouble(str);
    }

    public int getInt(String str, int i) {
        return this.mBackingMap.isNull(str) ? i : this.mBackingMap.getInt(str);
    }

    public String getString(String str) {
        return this.mBackingMap.getString(str);
    }

    public ReadableArray getArray(String str) {
        return this.mBackingMap.getArray(str);
    }

    public ReadableMap getMap(String str) {
        return this.mBackingMap.getMap(str);
    }

    public Dynamic getDynamic(String str) {
        return this.mBackingMap.getDynamic(str);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.mBackingMap.toString());
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
