package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CxxModuleWrapperBase implements NativeModule {
    @DoNotStrip
    private HybridData mHybridData;

    public boolean canOverrideExistingModule() {
        return false;
    }

    public native String getName();

    public void initialize() {
    }

    static {
        ReactBridge.staticInit();
    }

    public void onCatalystInstanceDestroy() {
        this.mHybridData.resetNative();
    }

    protected CxxModuleWrapperBase(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    protected void resetModule(HybridData hybridData) {
        if (hybridData != this.mHybridData) {
            this.mHybridData.resetNative();
            this.mHybridData = hybridData;
        }
    }
}
