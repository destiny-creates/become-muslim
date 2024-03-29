package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class YogaConfig {
    public static int SPACING_TYPE = 1;
    private YogaLogger mLogger;
    long mNativePointer = jni_YGConfigNew();
    private YogaNodeCloneFunction mYogaNodeCloneFunction;

    private native void jni_YGConfigFree(long j);

    private native long jni_YGConfigNew();

    private native void jni_YGConfigSetExperimentalFeatureEnabled(long j, int i, boolean z);

    private native void jni_YGConfigSetHasCloneNodeFunc(long j, boolean z);

    private native void jni_YGConfigSetLogger(long j, Object obj);

    private native void jni_YGConfigSetPointScaleFactor(long j, float f);

    private native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(long j, boolean z);

    private native void jni_YGConfigSetUseLegacyStretchBehaviour(long j, boolean z);

    private native void jni_YGConfigSetUseWebDefaults(long j, boolean z);

    static {
        SoLoader.loadLibrary("yoga");
    }

    public YogaConfig() {
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    protected void finalize() {
        try {
            jni_YGConfigFree(this.mNativePointer);
        } finally {
            super.finalize();
        }
    }

    public void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z) {
        jni_YGConfigSetExperimentalFeatureEnabled(this.mNativePointer, yogaExperimentalFeature.intValue(), z);
    }

    public void setUseWebDefaults(boolean z) {
        jni_YGConfigSetUseWebDefaults(this.mNativePointer, z);
    }

    public void setPointScaleFactor(float f) {
        jni_YGConfigSetPointScaleFactor(this.mNativePointer, f);
    }

    public void setUseLegacyStretchBehaviour(boolean z) {
        jni_YGConfigSetUseLegacyStretchBehaviour(this.mNativePointer, z);
    }

    public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z) {
        jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(this.mNativePointer, z);
    }

    public void setLogger(YogaLogger yogaLogger) {
        this.mLogger = yogaLogger;
        jni_YGConfigSetLogger(this.mNativePointer, yogaLogger);
    }

    public YogaLogger getLogger() {
        return this.mLogger;
    }

    public void setOnCloneNode(YogaNodeCloneFunction yogaNodeCloneFunction) {
        this.mYogaNodeCloneFunction = yogaNodeCloneFunction;
        jni_YGConfigSetHasCloneNodeFunc(this.mNativePointer, yogaNodeCloneFunction != null ? true : null);
    }

    @DoNotStrip
    private final YogaNode cloneNode(YogaNode yogaNode, YogaNode yogaNode2, int i) {
        return this.mYogaNodeCloneFunction.cloneNode(yogaNode, yogaNode2, i);
    }
}
