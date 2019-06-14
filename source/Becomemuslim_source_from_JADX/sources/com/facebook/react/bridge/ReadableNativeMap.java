package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.HashMap;

@DoNotStrip
public class ReadableNativeMap extends NativeMap implements ReadableMap {
    private static int mJniCallCounter;
    private static boolean mUseNativeAccessor;
    private String[] mKeys;
    private HashMap<String, Object> mLocalMap;
    private HashMap<String, ReadableType> mLocalTypeMap;

    @DoNotStrip
    private static class ReadableNativeMapKeySetIterator implements ReadableMapKeySetIterator {
        @DoNotStrip
        private final HybridData mHybridData;
        @DoNotStrip
        private final ReadableNativeMap mMap;

        private static native HybridData initHybrid(ReadableNativeMap readableNativeMap);

        public native boolean hasNextKey();

        public native String nextKey();

        public ReadableNativeMapKeySetIterator(ReadableNativeMap readableNativeMap) {
            this.mMap = readableNativeMap;
            this.mHybridData = initHybrid(readableNativeMap);
        }
    }

    private native ReadableNativeArray getArrayNative(String str);

    private native boolean getBooleanNative(String str);

    private native double getDoubleNative(String str);

    private native int getIntNative(String str);

    private native ReadableNativeMap getMapNative(String str);

    private native String getStringNative(String str);

    private native ReadableType getTypeNative(String str);

    private native boolean hasKeyNative(String str);

    private native String[] importKeys();

    private native Object[] importTypes();

    private native Object[] importValues();

    private native boolean isNullNative(String str);

    static {
        ReactBridge.staticInit();
    }

    protected ReadableNativeMap(HybridData hybridData) {
        super(hybridData);
    }

    public static void setUseNativeAccessor(boolean z) {
        mUseNativeAccessor = z;
    }

    public static int getJNIPassCounter() {
        return mJniCallCounter;
    }

    private HashMap<String, Object> getLocalMap() {
        if (this.mLocalMap != null) {
            return this.mLocalMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importValues());
                mJniCallCounter++;
                this.mLocalMap = new HashMap();
                for (int i = 0; i < this.mKeys.length; i++) {
                    this.mLocalMap.put(this.mKeys[i], objArr[i]);
                }
            }
        }
        return this.mLocalMap;
    }

    private HashMap<String, ReadableType> getLocalTypeMap() {
        if (this.mLocalTypeMap != null) {
            return this.mLocalTypeMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalTypeMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importTypes());
                mJniCallCounter++;
                this.mLocalTypeMap = new HashMap();
                for (int i = 0; i < this.mKeys.length; i++) {
                    this.mLocalTypeMap.put(this.mKeys[i], (ReadableType) objArr[i]);
                }
            }
        }
        return this.mLocalTypeMap;
    }

    public boolean hasKey(String str) {
        if (!mUseNativeAccessor) {
            return getLocalMap().containsKey(str);
        }
        mJniCallCounter++;
        return hasKeyNative(str);
    }

    public boolean isNull(String str) {
        boolean z = true;
        if (mUseNativeAccessor) {
            mJniCallCounter++;
            return isNullNative(str);
        } else if (getLocalMap().containsKey(str)) {
            if (getLocalMap().get(str) != null) {
                z = false;
            }
            return z;
        } else {
            throw new NoSuchKeyException(str);
        }
    }

    private Object getValue(String str) {
        if (hasKey(str) && !isNull(str)) {
            return Assertions.assertNotNull(getLocalMap().get(str));
        }
        throw new NoSuchKeyException(str);
    }

    private <T> T getValue(String str, Class<T> cls) {
        T value = getValue(str);
        checkInstance(str, value, cls);
        return value;
    }

    private Object getNullableValue(String str) {
        if (hasKey(str)) {
            return getLocalMap().get(str);
        }
        throw new NoSuchKeyException(str);
    }

    private <T> T getNullableValue(String str, Class<T> cls) {
        T nullableValue = getNullableValue(str);
        checkInstance(str, nullableValue, cls);
        return nullableValue;
    }

    private void checkInstance(String str, Object obj, Class cls) {
        if (obj == null) {
            return;
        }
        if (!cls.isInstance(obj)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value for ");
            stringBuilder.append(str);
            stringBuilder.append(" cannot be cast from ");
            stringBuilder.append(obj.getClass().getSimpleName());
            stringBuilder.append(" to ");
            stringBuilder.append(cls.getSimpleName());
            throw new ClassCastException(stringBuilder.toString());
        }
    }

    public boolean getBoolean(String str) {
        if (!mUseNativeAccessor) {
            return ((Boolean) getValue(str, Boolean.class)).booleanValue();
        }
        mJniCallCounter++;
        return getBooleanNative(str);
    }

    public double getDouble(String str) {
        if (!mUseNativeAccessor) {
            return ((Double) getValue(str, Double.class)).doubleValue();
        }
        mJniCallCounter++;
        return getDoubleNative(str);
    }

    public int getInt(String str) {
        if (!mUseNativeAccessor) {
            return ((Double) getValue(str, Double.class)).intValue();
        }
        mJniCallCounter++;
        return getIntNative(str);
    }

    public String getString(String str) {
        if (!mUseNativeAccessor) {
            return (String) getNullableValue(str, String.class);
        }
        mJniCallCounter++;
        return getStringNative(str);
    }

    public ReadableArray getArray(String str) {
        if (!mUseNativeAccessor) {
            return (ReadableArray) getNullableValue(str, ReadableArray.class);
        }
        mJniCallCounter++;
        return getArrayNative(str);
    }

    public ReadableNativeMap getMap(String str) {
        if (!mUseNativeAccessor) {
            return (ReadableNativeMap) getNullableValue(str, ReadableNativeMap.class);
        }
        mJniCallCounter++;
        return getMapNative(str);
    }

    public ReadableType getType(String str) {
        if (mUseNativeAccessor) {
            mJniCallCounter++;
            return getTypeNative(str);
        } else if (getLocalTypeMap().containsKey(str)) {
            return (ReadableType) Assertions.assertNotNull(getLocalTypeMap().get(str));
        } else {
            throw new NoSuchKeyException(str);
        }
    }

    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableNativeMapKeySetIterator(this);
    }

    public HashMap<String, Object> toHashMap() {
        String nextKey;
        if (mUseNativeAccessor) {
            ReadableMapKeySetIterator keySetIterator = keySetIterator();
            HashMap<String, Object> hashMap = new HashMap();
            while (keySetIterator.hasNextKey()) {
                mJniCallCounter++;
                nextKey = keySetIterator.nextKey();
                mJniCallCounter++;
                switch (getType(nextKey)) {
                    case Null:
                        hashMap.put(nextKey, null);
                        break;
                    case Boolean:
                        hashMap.put(nextKey, Boolean.valueOf(getBoolean(nextKey)));
                        break;
                    case Number:
                        hashMap.put(nextKey, Double.valueOf(getDouble(nextKey)));
                        break;
                    case String:
                        hashMap.put(nextKey, getString(nextKey));
                        break;
                    case Map:
                        hashMap.put(nextKey, ((ReadableNativeMap) Assertions.assertNotNull(getMap(nextKey))).toHashMap());
                        break;
                    case Array:
                        hashMap.put(nextKey, ((ReadableArray) Assertions.assertNotNull(getArray(nextKey))).toArrayList());
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Could not convert object with key: ");
                        stringBuilder.append(nextKey);
                        stringBuilder.append(".");
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return hashMap;
        }
        HashMap<String, Object> hashMap2 = new HashMap(getLocalMap());
        for (String nextKey2 : hashMap2.keySet()) {
            switch (getType(nextKey2)) {
                case Null:
                case Boolean:
                case Number:
                case String:
                    break;
                case Map:
                    hashMap2.put(nextKey2, ((ReadableNativeMap) Assertions.assertNotNull(getMap(nextKey2))).toHashMap());
                    break;
                case Array:
                    hashMap2.put(nextKey2, ((ReadableArray) Assertions.assertNotNull(getArray(nextKey2))).toArrayList());
                    break;
                default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not convert object with key: ");
                    stringBuilder.append(nextKey2);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return hashMap2;
    }
}
