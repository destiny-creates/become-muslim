package com.facebook.react.bridge;

import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;

public interface UIManager extends JSIModule, PerformanceCounter {
    <T extends SizeMonitoringFrameLayout & MeasureSpecProvider> int addRootView(T t);

    void clearJSResponder();

    void dispatchCommand(int i, int i2, ReadableArray readableArray);

    void setJSResponder(int i, boolean z);

    void updateRootLayoutSpecs(int i, int i2, int i3);
}
