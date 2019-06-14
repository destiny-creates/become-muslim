package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface NativeModule {

    public interface NativeMethod {
        String getType();

        void invoke(JSInstance jSInstance, ReadableNativeArray readableNativeArray);
    }

    boolean canOverrideExistingModule();

    String getName();

    void initialize();

    void onCatalystInstanceDestroy();
}
