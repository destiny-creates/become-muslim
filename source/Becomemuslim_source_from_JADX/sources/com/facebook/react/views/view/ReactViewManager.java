package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "RCTView")
public class ReactViewManager extends ViewGroupManager<ReactViewGroup> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;
    @VisibleForTesting
    public static final String REACT_CLASS = "RCTView";
    private static final int[] SPACING_TYPES = new int[]{8, 0, 2, 1, 3, 4, 5};

    public String getName() {
        return "RCTView";
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(ReactViewGroup reactViewGroup, boolean z) {
    }

    @ReactProp(name = "accessible")
    public void setAccessible(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setFocusable(z);
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            reactViewGroup.setFocusable(true);
            reactViewGroup.setFocusableInTouchMode(true);
            reactViewGroup.requestFocus();
        }
    }

    @ReactPropGroup(defaultFloat = 1.0E21f, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public void setBorderRadius(ReactViewGroup reactViewGroup, int i, float f) {
        if (!YogaConstants.isUndefined(f) && f < 0.0f) {
            f = 1.0E21f;
        }
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        if (i == 0) {
            reactViewGroup.setBorderRadius(f);
        } else {
            reactViewGroup.setBorderRadius(f, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setBorderStyle(str);
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        if (readableMap == null) {
            reactViewGroup.setHitSlopRect(null);
            return;
        }
        int i = 0;
        int toPixelFromDIP = readableMap.hasKey(ViewProps.LEFT) ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(ViewProps.LEFT)) : 0;
        int toPixelFromDIP2 = readableMap.hasKey(ViewProps.TOP) ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(ViewProps.TOP)) : 0;
        int toPixelFromDIP3 = readableMap.hasKey(ViewProps.RIGHT) ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(ViewProps.RIGHT)) : 0;
        if (readableMap.hasKey(ViewProps.BOTTOM)) {
            i = (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(ViewProps.BOTTOM));
        }
        reactViewGroup.setHitSlopRect(new Rect(toPixelFromDIP, toPixelFromDIP2, toPixelFromDIP3, i));
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactViewGroup reactViewGroup, String str) {
        if (str == null) {
            reactViewGroup.setPointerEvents(PointerEvents.AUTO);
        } else {
            reactViewGroup.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        reactViewGroup.setTranslucentBackgroundDrawable(readableMap == null ? null : ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap));
    }

    @ReactProp(name = "nativeForegroundAndroid")
    @TargetApi(23)
    public void setNativeForeground(ReactViewGroup reactViewGroup, ReadableMap readableMap) {
        reactViewGroup.setForeground(readableMap == null ? null : ReactDrawableHelper.createDrawableFromJSDescription(reactViewGroup.getContext(), readableMap));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setRemoveClippedSubviews(z);
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(ReactViewGroup reactViewGroup, boolean z) {
        reactViewGroup.setNeedsOffscreenAlphaCompositing(z);
    }

    @ReactPropGroup(defaultFloat = 1.0E21f, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactViewGroup reactViewGroup, int i, float f) {
        if (!YogaConstants.isUndefined(f) && f < 0.0f) {
            f = 1.0E21f;
        }
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        reactViewGroup.setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public void setBorderColor(ReactViewGroup reactViewGroup, int i, Integer num) {
        float f = 1.0E21f;
        float intValue = num == null ? 1.0E21f : (float) (num.intValue() & 16777215);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        reactViewGroup.setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactViewGroup reactViewGroup, String str) {
        reactViewGroup.setOverflow(str);
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
    }

    public void receiveCommand(ReactViewGroup reactViewGroup, int i, ReadableArray readableArray) {
        switch (i) {
            case 1:
                if (readableArray == null || readableArray.size() != 2) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
                } else if (VERSION.SDK_INT >= 21) {
                    reactViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(readableArray.getDouble(0)), PixelUtil.toPixelFromDIP(readableArray.getDouble(1)));
                    return;
                } else {
                    return;
                }
            case 2:
                if (readableArray == null || readableArray.size() != 1) {
                    throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
                }
                reactViewGroup.setPressed(readableArray.getBoolean(0));
                return;
            default:
                return;
        }
    }

    public void addView(ReactViewGroup reactViewGroup, View view, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.addViewWithSubviewClippingEnabled(view, i);
        } else {
            reactViewGroup.addView(view, i);
        }
    }

    public int getChildCount(ReactViewGroup reactViewGroup) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.getAllChildrenCount();
        }
        return reactViewGroup.getChildCount();
    }

    public View getChildAt(ReactViewGroup reactViewGroup, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            return reactViewGroup.getChildAtWithSubviewClippingEnabled(i);
        }
        return reactViewGroup.getChildAt(i);
    }

    public void removeViewAt(ReactViewGroup reactViewGroup, int i) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            i = getChildAt(reactViewGroup, i);
            if (i.getParent() != null) {
                reactViewGroup.removeView(i);
            }
            reactViewGroup.removeViewWithSubviewClippingEnabled(i);
            return;
        }
        reactViewGroup.removeViewAt(i);
    }

    public void removeAllViews(ReactViewGroup reactViewGroup) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.removeAllViewsWithSubviewClippingEnabled();
        } else {
            reactViewGroup.removeAllViews();
        }
    }

    public void startViewTransition(ReactViewGroup reactViewGroup, View view) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.startViewTransitionWithSubviewClippingEnabled(view);
        } else {
            reactViewGroup.startViewTransition(view);
        }
    }

    public void endViewTransition(ReactViewGroup reactViewGroup, View view) {
        if (reactViewGroup.getRemoveClippedSubviews()) {
            reactViewGroup.endViewTransitionWithSubviewClippingEnabled(view);
        } else {
            reactViewGroup.endViewTransition(view);
        }
    }
}
