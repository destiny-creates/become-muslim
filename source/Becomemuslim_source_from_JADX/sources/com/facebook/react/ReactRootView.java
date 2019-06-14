package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.systrace.Systrace;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class ReactRootView extends SizeMonitoringFrameLayout implements RootView, MeasureSpecProvider {
    private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
    private Bundle mAppProperties;
    private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
    private boolean mIsAttachedToInstance;
    private String mJSModuleName;
    private JSTouchDispatcher mJSTouchDispatcher;
    private ReactInstanceManager mReactInstanceManager;
    private ReactRootViewEventListener mRootViewEventListener;
    private int mRootViewTag;
    private boolean mShouldLogContentAppeared;
    private int mUIManagerType = 1;
    private boolean mWasMeasured = false;
    private int mWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);

    private class CustomGlobalLayoutListener implements OnGlobalLayoutListener {
        private int mDeviceRotation = 0;
        private int mKeyboardHeight = 0;
        private final int mMinKeyboardHeightDetected;
        private DisplayMetrics mScreenMetrics = new DisplayMetrics();
        private final Rect mVisibleViewArea;
        private DisplayMetrics mWindowMetrics = new DisplayMetrics();

        CustomGlobalLayoutListener() {
            DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) PixelUtil.toPixelFromDIP(60.0f);
        }

        public void onGlobalLayout() {
            if (ReactRootView.this.mReactInstanceManager != null && ReactRootView.this.mIsAttachedToInstance) {
                if (ReactRootView.this.mReactInstanceManager.getCurrentReactContext() != null) {
                    checkForKeyboardEvents();
                    checkForDeviceOrientationChanges();
                    checkForDeviceDimensionsChanges();
                }
            }
        }

        private void checkForKeyboardEvents() {
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            int i = DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom;
            if (this.mKeyboardHeight != i && i > this.mMinKeyboardHeightDetected) {
                this.mKeyboardHeight = i;
                WritableMap createMap = Arguments.createMap();
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putDouble("screenY", (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.bottom));
                createMap2.putDouble("screenX", (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.left));
                createMap2.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()));
                createMap2.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mKeyboardHeight));
                createMap.putMap("endCoordinates", createMap2);
                ReactRootView.this.sendEvent("keyboardDidShow", createMap);
            } else if (this.mKeyboardHeight != 0 && i <= this.mMinKeyboardHeightDetected) {
                this.mKeyboardHeight = 0;
                ReactRootView.this.sendEvent("keyboardDidHide", null);
            }
        }

        private void checkForDeviceOrientationChanges() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.mDeviceRotation != rotation) {
                this.mDeviceRotation = rotation;
                emitOrientationChanged(rotation);
            }
        }

        private void checkForDeviceDimensionsChanges() {
            DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext());
            if (!areMetricsEqual(this.mWindowMetrics, DisplayMetricsHolder.getWindowDisplayMetrics()) || !areMetricsEqual(this.mScreenMetrics, DisplayMetricsHolder.getScreenDisplayMetrics())) {
                this.mWindowMetrics.setTo(DisplayMetricsHolder.getWindowDisplayMetrics());
                this.mScreenMetrics.setTo(DisplayMetricsHolder.getScreenDisplayMetrics());
                emitUpdateDimensionsEvent();
            }
        }

        private boolean areMetricsEqual(DisplayMetrics displayMetrics, DisplayMetrics displayMetrics2) {
            if (VERSION.SDK_INT >= 17) {
                return displayMetrics.equals(displayMetrics2);
            }
            displayMetrics = (displayMetrics.widthPixels == displayMetrics2.widthPixels && displayMetrics.heightPixels == displayMetrics2.heightPixels && displayMetrics.density == displayMetrics2.density && displayMetrics.densityDpi == displayMetrics2.densityDpi && displayMetrics.scaledDensity == displayMetrics2.scaledDensity && displayMetrics.xdpi == displayMetrics2.xdpi && displayMetrics.ydpi == displayMetrics2.ydpi) ? true : null;
            return displayMetrics;
        }

        private void emitOrientationChanged(int i) {
            double d;
            double d2;
            boolean z = true;
            switch (i) {
                case 0:
                    i = "portrait-primary";
                    d = 0.0d;
                    break;
                case 1:
                    i = "landscape-primary";
                    d2 = -90.0d;
                    break;
                case 2:
                    i = "portrait-secondary";
                    d = 180.0d;
                    break;
                case 3:
                    i = "landscape-secondary";
                    d2 = 90.0d;
                    break;
                default:
                    return;
            }
            d2 = d;
            z = false;
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", i);
            createMap.putDouble("rotationDegrees", d2);
            createMap.putBoolean("isLandscape", z);
            ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
        }

        private void emitUpdateDimensionsEvent() {
            ((DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
        }
    }

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ReactRootView(Context context) {
        super(context);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (!ViewProps.sDefaultOverflowHidden) {
            setClipChildren(false);
        }
    }

    protected void onMeasure(int i, int i2) {
        Systrace.beginSection(0, "ReactRootView.onMeasure");
        try {
            int i3;
            View childAt;
            this.mWidthMeasureSpec = i;
            this.mHeightMeasureSpec = i2;
            int mode = MeasureSpec.getMode(i);
            if (mode != LinearLayoutManager.INVALID_OFFSET) {
                if (mode != 0) {
                    i = MeasureSpec.getSize(i);
                    mode = MeasureSpec.getMode(i2);
                    if (mode != LinearLayoutManager.INVALID_OFFSET) {
                        if (mode == 0) {
                            i2 = MeasureSpec.getSize(i2);
                            setMeasuredDimension(i, i2);
                            this.mWasMeasured = true;
                            if (this.mReactInstanceManager == 0 && this.mIsAttachedToInstance == 0) {
                                attachToReactInstanceManager();
                                enableLayoutCalculation();
                            } else {
                                enableLayoutCalculation();
                                updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                            }
                            Systrace.endSection(0);
                        }
                    }
                    i2 = 0;
                    for (i3 = 0; i3 < getChildCount(); i3++) {
                        childAt = getChildAt(i3);
                        i2 = Math.max(i2, ((childAt.getTop() + childAt.getMeasuredHeight()) + childAt.getPaddingTop()) + childAt.getPaddingBottom());
                    }
                    setMeasuredDimension(i, i2);
                    this.mWasMeasured = true;
                    if (this.mReactInstanceManager == 0) {
                    }
                    enableLayoutCalculation();
                    updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    Systrace.endSection(0);
                }
            }
            mode = 0;
            for (i = 0; i < getChildCount(); i++) {
                View childAt2 = getChildAt(i);
                mode = Math.max(mode, ((childAt2.getLeft() + childAt2.getMeasuredWidth()) + childAt2.getPaddingLeft()) + childAt2.getPaddingRight());
            }
            i = mode;
            mode = MeasureSpec.getMode(i2);
            if (mode != LinearLayoutManager.INVALID_OFFSET) {
                if (mode == 0) {
                    i2 = MeasureSpec.getSize(i2);
                    setMeasuredDimension(i, i2);
                    this.mWasMeasured = true;
                    if (this.mReactInstanceManager == 0) {
                    }
                    enableLayoutCalculation();
                    updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    Systrace.endSection(0);
                }
            }
            i2 = 0;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                childAt = getChildAt(i3);
                i2 = Math.max(i2, ((childAt.getTop() + childAt.getMeasuredHeight()) + childAt.getPaddingTop()) + childAt.getPaddingBottom());
            }
            setMeasuredDimension(i, i2);
            this.mWasMeasured = true;
            if (this.mReactInstanceManager == 0) {
            }
            enableLayoutCalculation();
            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
            Systrace.endSection(0);
        } catch (Throwable th) {
            Systrace.endSection(0);
        }
    }

    public int getWidthMeasureSpec() {
        if (this.mWasMeasured || getLayoutParams() == null || getLayoutParams().width <= 0) {
            return this.mWidthMeasureSpec;
        }
        return MeasureSpec.makeMeasureSpec(getLayoutParams().width, 1073741824);
    }

    public int getHeightMeasureSpec() {
        if (this.mWasMeasured || getLayoutParams() == null || getLayoutParams().height <= 0) {
            return this.mHeightMeasureSpec;
        }
        return MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824);
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            if (this.mReactInstanceManager.getCurrentReactContext() != null) {
                if (this.mJSTouchDispatcher == null) {
                    FLog.m5714w(ReactConstants.TAG, "Unable to dispatch touch to JS before the dispatcher is available");
                    return;
                }
                this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
                return;
            }
        }
        FLog.m5714w(ReactConstants.TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Canvas canvas2) {
            handleException(canvas2);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            if (this.mReactInstanceManager.getCurrentReactContext() != null) {
                this.mAndroidHWInputDeviceHelper.handleKeyEvent(keyEvent);
                return super.dispatchKeyEvent(keyEvent);
            }
        }
        FLog.m5714w(ReactConstants.TAG, "Unable to handle key event as the catalyst instance has not been attached");
        return super.dispatchKeyEvent(keyEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            if (this.mReactInstanceManager.getCurrentReactContext() != null) {
                this.mAndroidHWInputDeviceHelper.clearFocus();
                super.onFocusChanged(z, i, rect);
                return;
            }
        }
        FLog.m5714w(ReactConstants.TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
        super.onFocusChanged(z, i, rect);
    }

    public void requestChildFocus(View view, View view2) {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            if (this.mReactInstanceManager.getCurrentReactContext() != null) {
                this.mAndroidHWInputDeviceHelper.onFocusChanged(view2);
                super.requestChildFocus(view, view2);
                return;
            }
        }
        FLog.m5714w(ReactConstants.TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
        super.requestChildFocus(view, view2);
    }

    private void dispatchJSTouchEvent(MotionEvent motionEvent) {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            if (this.mReactInstanceManager.getCurrentReactContext() != null) {
                if (this.mJSTouchDispatcher == null) {
                    FLog.m5714w(ReactConstants.TAG, "Unable to dispatch touch to JS before the dispatcher is available");
                    return;
                }
                this.mJSTouchDispatcher.handleTouchEvent(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
                return;
            }
        }
        FLog.m5714w(ReactConstants.TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.mIsAttachedToInstance) {
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.mShouldLogContentAppeared != null) {
            this.mShouldLogContentAppeared = null;
            if (this.mJSModuleName != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, this.mJSModuleName, this.mRootViewTag);
            }
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        Systrace.beginSection(0, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            if (this.mReactInstanceManager.hasStartedCreatingInitialContext() == null) {
                this.mReactInstanceManager.createReactContextInBackground();
            }
            attachToReactInstanceManager();
        } finally {
            Systrace.endSection(0);
        }
    }

    private void enableLayoutCalculation() {
        if (this.mReactInstanceManager == null) {
            FLog.m5714w(ReactConstants.TAG, "Unable to enable layout calculation for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
        if (currentReactContext != null) {
            ((UIManagerModule) currentReactContext.getCatalystInstance().getNativeModule(UIManagerModule.class)).getUIImplementation().enableLayoutCalculationForRootNode(getRootViewTag());
        }
    }

    private void updateRootLayoutSpecs(int i, int i2) {
        if (this.mReactInstanceManager == null) {
            FLog.m5714w(ReactConstants.TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
        if (currentReactContext != null) {
            final ReactContext reactContext = currentReactContext;
            final int i3 = i;
            final int i4 = i2;
            currentReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(currentReactContext) {
                public void runGuarded() {
                    UIManagerHelper.getUIManager(reactContext, ReactRootView.this.getUIManagerType()).updateRootLayoutSpecs(ReactRootView.this.getRootViewTag(), i3, i4);
                }
            });
        }
    }

    public void unmountReactApplication() {
        if (this.mReactInstanceManager != null && this.mIsAttachedToInstance) {
            this.mReactInstanceManager.detachRootView(this);
            this.mReactInstanceManager = null;
            this.mIsAttachedToInstance = false;
        }
        this.mShouldLogContentAppeared = false;
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (this.mRootViewEventListener != null) {
            this.mRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    String getJSModuleName() {
        return (String) Assertions.assertNotNull(this.mJSModuleName);
    }

    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (getRootViewTag() != null) {
            runApplication();
        }
    }

    void runApplication() {
        Systrace.beginSection(0, "ReactRootView.runApplication");
        try {
            if (this.mReactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Systrace.endSection(0);
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    WritableMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                    Bundle appProperties = getAppProperties();
                    if (appProperties != null) {
                        writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                    }
                    if (getUIManagerType() == 2) {
                        writableNativeMap.putBoolean("fabric", true);
                    }
                    this.mShouldLogContentAppeared = true;
                    ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(getJSModuleName(), writableNativeMap);
                    Systrace.endSection(0);
                    return;
                }
            }
            Systrace.endSection(0);
        } catch (Throwable th) {
            Systrace.endSection(0);
        }
    }

    @VisibleForTesting
    void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void attachToReactInstanceManager() {
        Systrace.beginSection(0, "attachToReactInstanceManager");
        try {
            if (!this.mIsAttachedToInstance) {
                this.mIsAttachedToInstance = true;
                ((ReactInstanceManager) Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                Systrace.endSection(0);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    protected void finalize() {
        super.finalize();
        Assertions.assertCondition(this.mIsAttachedToInstance ^ 1, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    public void handleException(Throwable th) {
        if (this.mReactInstanceManager == null || this.mReactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? true : true;
    }

    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    void sendEvent(String str, WritableMap writableMap) {
        if (this.mReactInstanceManager != null) {
            ((RCTDeviceEventEmitter) this.mReactInstanceManager.getCurrentReactContext().getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }
}
