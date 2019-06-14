package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.AudioManager;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout.OnSizeChangedListener;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ReactModule(name = "UIManager")
public class UIManagerModule extends ReactContextBaseJavaModule implements LifecycleEventListener, OnBatchCompleteListener, UIManager {
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.UI_MANAGER);
    protected static final String NAME = "UIManager";
    private int mBatchId = 0;
    private final Map<String, Object> mCustomDirectEvents;
    private final EventDispatcher mEventDispatcher;
    private final List<UIManagerModuleListener> mListeners = new ArrayList();
    private final MemoryTrimCallback mMemoryTrimCallback = new MemoryTrimCallback();
    private final Map<String, Object> mModuleConstants;
    private final UIImplementation mUIImplementation;

    public interface CustomEventNamesResolver {
        String resolveCustomEventName(String str);
    }

    private class MemoryTrimCallback implements ComponentCallbacks2 {
        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        private MemoryTrimCallback() {
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                YogaNodePool.get().clear();
            }
        }
    }

    public interface ViewManagerResolver {
        ViewManager getViewManager(String str);

        List<String> getViewManagerNames();
    }

    /* renamed from: com.facebook.react.uimanager.UIManagerModule$1 */
    class C38851 implements CustomEventNamesResolver {
        C38851() {
        }

        public String resolveCustomEventName(String str) {
            Map map = (Map) UIManagerModule.this.mCustomDirectEvents.get(str);
            return map != null ? (String) map.get("registrationName") : str;
        }
    }

    public String getName() {
        return NAME;
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, int i) {
        super(reactApplicationContext);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
        this.mModuleConstants = createConstants(viewManagerResolver);
        this.mCustomDirectEvents = UIManagerModuleConstants.getDirectEventTypeConstants();
        this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerResolver, this.mEventDispatcher, i);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i) {
        super(reactApplicationContext);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
        this.mCustomDirectEvents = MapBuilder.newHashMap();
        this.mModuleConstants = createConstants(list, null, this.mCustomDirectEvents);
        this.mUIImplementation = new UIImplementation(reactApplicationContext, (List) list, this.mEventDispatcher, i);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public UIImplementation getUIImplementation() {
        return this.mUIImplementation;
    }

    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        this.mEventDispatcher.registerEventEmitter(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    public void onHostResume() {
        this.mUIImplementation.onHostResume();
    }

    public void onHostPause() {
        this.mUIImplementation.onHostPause();
    }

    public void onHostDestroy() {
        this.mUIImplementation.onHostDestroy();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.mEventDispatcher.onCatalystInstanceDestroyed();
        getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
        YogaNodePool.get().clear();
        ViewManagerPropertyUpdater.clear();
    }

    private static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        Systrace.beginSection(0, "CreateUIManagerConstants");
        try {
            viewManagerResolver = UIManagerModuleConstantsHelper.createConstants(viewManagerResolver);
            return viewManagerResolver;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    private static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        Systrace.beginSection(0, "CreateUIManagerConstants");
        try {
            list = UIManagerModuleConstantsHelper.createConstants(list, map, map2);
            return list;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        str = str != null ? this.mUIImplementation.resolveViewManager(str) : null;
        if (str == null) {
            return null;
        }
        SystraceMessage.beginSection(0, "UIManagerModule.getConstantsForViewManager").arg("ViewManager", str.getName()).arg("Lazy", Boolean.valueOf(true)).flush();
        try {
            Map createConstantsForViewManager = UIManagerModuleConstantsHelper.createConstantsForViewManager(str, null, null, null, this.mCustomDirectEvents);
            if (createConstantsForViewManager != null) {
                str = Arguments.makeNativeMap(createConstantsForViewManager);
                return str;
            }
            SystraceMessage.endSection(0).flush();
            return null;
        } finally {
            SystraceMessage.endSection(0).flush();
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.getDefaultExportableEventTypes());
    }

    public CustomEventNamesResolver getDirectEventNamesResolver() {
        return new C38851();
    }

    public void profileNextBatch() {
        this.mUIImplementation.profileNextBatch();
    }

    public Map<String, Long> getPerformanceCounters() {
        return this.mUIImplementation.getProfiledBatchPerfCounters();
    }

    public <T extends SizeMonitoringFrameLayout & MeasureSpecProvider> int addRootView(T t) {
        Systrace.beginSection(0, "UIManagerModule.addRootView");
        final int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        this.mUIImplementation.registerRootView(t, nextRootViewTag, new ThemedReactContext(reactApplicationContext, t.getContext()));
        t.setOnSizeChangedListener(new OnSizeChangedListener() {
            public void onSizeChanged(final int i, final int i2, int i3, int i4) {
                reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
                    public void runGuarded() {
                        UIManagerModule.this.updateNodeSize(nextRootViewTag, i, i2);
                    }
                });
            }
        });
        Systrace.endSection(0);
        return nextRootViewTag;
    }

    @ReactMethod
    public void removeRootView(int i) {
        this.mUIImplementation.removeRootView(i);
    }

    public void updateNodeSize(int i, int i2, int i3) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        this.mUIImplementation.updateNodeSize(i, i2, i3);
    }

    public void setViewLocalData(final int i, final Object obj) {
        ReactContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
            public void runGuarded() {
                UIManagerModule.this.mUIImplementation.setViewLocalData(i, obj);
            }
        });
    }

    @ReactMethod
    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(UIManager.createView) tag: ");
            stringBuilder.append(i);
            stringBuilder.append(", class: ");
            stringBuilder.append(str);
            stringBuilder.append(", props: ");
            stringBuilder.append(readableMap);
            String stringBuilder2 = stringBuilder.toString();
            FLog.m5662d(ReactConstants.TAG, stringBuilder2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, stringBuilder2);
        }
        this.mUIImplementation.createView(i, str, i2, readableMap);
    }

    @ReactMethod
    public void updateView(int i, String str, ReadableMap readableMap) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(UIManager.updateView) tag: ");
            stringBuilder.append(i);
            stringBuilder.append(", class: ");
            stringBuilder.append(str);
            stringBuilder.append(", props: ");
            stringBuilder.append(readableMap);
            String stringBuilder2 = stringBuilder.toString();
            FLog.m5662d(ReactConstants.TAG, stringBuilder2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, stringBuilder2);
        }
        this.mUIImplementation.updateView(i, str, readableMap);
    }

    @ReactMethod
    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(UIManager.manageChildren) tag: ");
            stringBuilder.append(i);
            stringBuilder.append(", moveFrom: ");
            stringBuilder.append(readableArray);
            stringBuilder.append(", moveTo: ");
            stringBuilder.append(readableArray2);
            stringBuilder.append(", addTags: ");
            stringBuilder.append(readableArray3);
            stringBuilder.append(", atIndices: ");
            stringBuilder.append(readableArray4);
            stringBuilder.append(", removeFrom: ");
            stringBuilder.append(readableArray5);
            String stringBuilder2 = stringBuilder.toString();
            FLog.m5662d(ReactConstants.TAG, stringBuilder2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, stringBuilder2);
        }
        this.mUIImplementation.manageChildren(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void setChildren(int i, ReadableArray readableArray) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(UIManager.setChildren) tag: ");
            stringBuilder.append(i);
            stringBuilder.append(", children: ");
            stringBuilder.append(readableArray);
            String stringBuilder2 = stringBuilder.toString();
            FLog.m5662d(ReactConstants.TAG, stringBuilder2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, stringBuilder2);
        }
        this.mUIImplementation.setChildren(i, readableArray);
    }

    @ReactMethod
    public void replaceExistingNonRootView(int i, int i2) {
        this.mUIImplementation.replaceExistingNonRootView(i, i2);
    }

    @ReactMethod
    public void removeSubviewsFromContainerWithID(int i) {
        this.mUIImplementation.removeSubviewsFromContainerWithID(i);
    }

    @ReactMethod
    public void measure(int i, Callback callback) {
        this.mUIImplementation.measure(i, callback);
    }

    @ReactMethod
    public void measureInWindow(int i, Callback callback) {
        this.mUIImplementation.measureInWindow(i, callback);
    }

    @ReactMethod
    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        this.mUIImplementation.measureLayout(i, i2, callback, callback2);
    }

    @ReactMethod
    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        this.mUIImplementation.measureLayoutRelativeToParent(i, callback, callback2);
    }

    @ReactMethod
    public void findSubviewIn(int i, ReadableArray readableArray, Callback callback) {
        this.mUIImplementation.findSubviewIn(i, (float) Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), (float) Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), callback);
    }

    @ReactMethod
    public void viewIsDescendantOf(int i, int i2, Callback callback) {
        this.mUIImplementation.viewIsDescendantOf(i, i2, callback);
    }

    public void registerAnimation(Animation animation) {
        this.mUIImplementation.registerAnimation(animation);
    }

    public void addAnimation(int i, int i2, Callback callback) {
        this.mUIImplementation.addAnimation(i, i2, callback);
    }

    public void removeAnimation(int i, int i2) {
        this.mUIImplementation.removeAnimation(i, i2);
    }

    @ReactMethod
    public void setJSResponder(int i, boolean z) {
        this.mUIImplementation.setJSResponder(i, z);
    }

    @ReactMethod
    public void clearJSResponder() {
        this.mUIImplementation.clearJSResponder();
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i, int i2, ReadableArray readableArray) {
        UIManagerHelper.getUIManager(getReactApplicationContext(), ViewUtil.getUIManagerType(i)).dispatchCommand(i, i2, readableArray);
    }

    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        this.mUIImplementation.dispatchViewManagerCommand(i, i2, readableArray);
    }

    @ReactMethod
    public void playTouchSound() {
        AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.playSoundEffect(0);
        }
    }

    @ReactMethod
    public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mUIImplementation.showPopupMenu(i, readableArray, callback, callback2);
    }

    @ReactMethod
    public void dismissPopupMenu() {
        this.mUIImplementation.dismissPopupMenu();
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        this.mUIImplementation.setLayoutAnimationEnabledExperimental(z);
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mUIImplementation.configureNextLayoutAnimation(readableMap, callback, callback2);
    }

    public void onBatchComplete() {
        int i = this.mBatchId;
        this.mBatchId++;
        SystraceMessage.beginSection(0, "onBatchCompleteUI").arg("BatchId", i).flush();
        for (UIManagerModuleListener willDispatchViewUpdates : this.mListeners) {
            willDispatchViewUpdates.willDispatchViewUpdates(this);
        }
        try {
            this.mUIImplementation.dispatchViewUpdates(i);
        } finally {
            Systrace.endSection(0);
        }
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mUIImplementation.setViewHierarchyUpdateDebugListener(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i, int i2) {
        this.mUIImplementation.sendAccessibilityEvent(i, i2);
    }

    public void addUIBlock(UIBlock uIBlock) {
        this.mUIImplementation.addUIBlock(uIBlock);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mUIImplementation.prependUIBlock(uIBlock);
    }

    public void addUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.add(uIManagerModuleListener);
    }

    public void removeUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.remove(uIManagerModuleListener);
    }

    public int resolveRootTagFromReactTag(int i) {
        return this.mUIImplementation.resolveRootTagFromReactTag(i);
    }

    public void invalidateNodeLayout(int i) {
        ReactShadowNode resolveShadowNode = this.mUIImplementation.resolveShadowNode(i);
        if (resolveShadowNode == null) {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Warning : attempted to dirty a non-existent react shadow node. reactTag=");
            stringBuilder.append(i);
            FLog.m5714w(str, stringBuilder.toString());
            return;
        }
        resolveShadowNode.dirty();
        this.mUIImplementation.dispatchViewUpdates(-1);
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        this.mUIImplementation.updateRootView(i, i2, i3);
        this.mUIImplementation.dispatchViewUpdates(-1);
    }
}
