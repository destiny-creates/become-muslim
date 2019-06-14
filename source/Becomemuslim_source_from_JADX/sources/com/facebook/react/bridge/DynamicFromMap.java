package com.facebook.react.bridge;

import android.support.v4.util.Pools.SimplePool;

public class DynamicFromMap implements Dynamic {
    private static final ThreadLocal<SimplePool<DynamicFromMap>> sPool = new C18851();
    private ReadableMap mMap;
    private String mName;

    /* renamed from: com.facebook.react.bridge.DynamicFromMap$1 */
    static class C18851 extends ThreadLocal<SimplePool<DynamicFromMap>> {
        C18851() {
        }

        protected SimplePool<DynamicFromMap> initialValue() {
            return new SimplePool(10);
        }
    }

    private DynamicFromMap() {
    }

    public static DynamicFromMap create(ReadableMap readableMap, String str) {
        DynamicFromMap dynamicFromMap = (DynamicFromMap) ((SimplePool) sPool.get()).acquire();
        if (dynamicFromMap == null) {
            dynamicFromMap = new DynamicFromMap();
        }
        dynamicFromMap.mMap = readableMap;
        dynamicFromMap.mName = str;
        return dynamicFromMap;
    }

    public void recycle() {
        this.mMap = null;
        this.mName = null;
        ((SimplePool) sPool.get()).release(this);
    }

    public boolean isNull() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.isNull(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public boolean asBoolean() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getBoolean(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public double asDouble() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getDouble(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public int asInt() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getInt(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public String asString() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getString(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableArray asArray() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getArray(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableMap asMap() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getMap(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    public ReadableType getType() {
        if (this.mMap != null && this.mName != null) {
            return this.mMap.getType(this.mName);
        }
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
