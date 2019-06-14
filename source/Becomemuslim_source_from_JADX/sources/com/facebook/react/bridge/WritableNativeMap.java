package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import expolib_v1.com.facebook.infer.annotation.Assertions;

@DoNotStrip
public class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    private static native HybridData initHybrid();

    private native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private native void putNativeArray(String str, WritableNativeArray writableNativeArray);

    private native void putNativeMap(String str, WritableNativeMap writableNativeMap);

    public native void putBoolean(String str, boolean z);

    public native void putDouble(String str, double d);

    public native void putInt(String str, int i);

    public native void putNull(String str);

    public native void putString(String str, String str2);

    static {
        ReactBridge.staticInit();
    }

    public void putMap(String str, WritableMap writableMap) {
        boolean z;
        if (writableMap != null) {
            if (!(writableMap instanceof WritableNativeMap)) {
                z = false;
                Assertions.assertCondition(z, "Illegal type provided");
                putNativeMap(str, (WritableNativeMap) writableMap);
            }
        }
        z = true;
        Assertions.assertCondition(z, "Illegal type provided");
        putNativeMap(str, (WritableNativeMap) writableMap);
    }

    public void putArray(String str, WritableArray writableArray) {
        boolean z;
        if (writableArray != null) {
            if (!(writableArray instanceof WritableNativeArray)) {
                z = false;
                Assertions.assertCondition(z, "Illegal type provided");
                putNativeArray(str, (WritableNativeArray) writableArray);
            }
        }
        z = true;
        Assertions.assertCondition(z, "Illegal type provided");
        putNativeArray(str, (WritableNativeArray) writableArray);
    }

    public void merge(ReadableMap readableMap) {
        Assertions.assertCondition(readableMap instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) readableMap);
    }

    public WritableNativeMap() {
        super(initHybrid());
    }
}
