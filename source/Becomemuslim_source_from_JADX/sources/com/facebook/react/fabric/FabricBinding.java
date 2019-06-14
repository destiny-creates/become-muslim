package com.facebook.react.fabric;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeMap;

public interface FabricBinding {
    void dispatchEventToEmptyTarget(long j, long j2, String str, NativeMap nativeMap);

    void dispatchEventToTarget(long j, long j2, long j3, String str, NativeMap nativeMap);

    void installFabric(JavaScriptContextHolder javaScriptContextHolder, FabricUIManager fabricUIManager);

    void releaseEventHandler(long j, long j2);

    void releaseEventTarget(long j, long j2);
}
