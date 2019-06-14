package com.facebook.react.fabric.jsc;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.fabric.FabricBinding;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class FabricJSCBinding implements FabricBinding {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    private native void installFabric(long j, Object obj);

    public native void dispatchEventToEmptyTarget(long j, long j2, String str, NativeMap nativeMap);

    public native void dispatchEventToTarget(long j, long j2, long j3, String str, NativeMap nativeMap);

    public native void releaseEventHandler(long j, long j2);

    public native void releaseEventTarget(long j, long j2);

    static {
        SoLoader.loadLibrary("fabricjscjni");
    }

    public void installFabric(JavaScriptContextHolder javaScriptContextHolder, FabricUIManager fabricUIManager) {
        fabricUIManager.setBinding(this);
        installFabric(javaScriptContextHolder.get(), (Object) fabricUIManager);
    }
}
