package com.facebook.react.uimanager;

import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.C1864R;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.MatrixMathHelper.MatrixDecompositionContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.util.ReactFindViewUtil;

public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String PROP_ACCESSIBILITY_COMPONENT_TYPE = "accessibilityComponentType";
    private static final String PROP_ACCESSIBILITY_HINT = "accessibilityHint";
    private static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
    private static final String PROP_ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
    private static final String PROP_ACCESSIBILITY_ROLE = "accessibilityRole";
    private static final String PROP_ACCESSIBILITY_STATES = "accessibilityStates";
    private static final String PROP_BACKGROUND_COLOR = "backgroundColor";
    private static final String PROP_ELEVATION = "elevation";
    private static final String PROP_IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
    public static final String PROP_NATIVE_ID = "nativeID";
    private static final String PROP_RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
    private static final String PROP_ROTATION = "rotation";
    private static final String PROP_SCALE_X = "scaleX";
    private static final String PROP_SCALE_Y = "scaleY";
    public static final String PROP_TEST_ID = "testID";
    private static final String PROP_TRANSFORM = "transform";
    private static final String PROP_TRANSLATE_X = "translateX";
    private static final String PROP_TRANSLATE_Y = "translateY";
    private static final String PROP_Z_INDEX = "zIndex";
    private static MatrixDecompositionContext sMatrixDecompositionContext = new MatrixDecompositionContext();
    private static double[] sTransformDecompositionArray = new double[16];

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t, int i) {
        t.setBackgroundColor(i);
    }

    @ReactProp(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t);
        } else {
            setTransformProperty(t, readableArray);
        }
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t, float f) {
        t.setAlpha(f);
    }

    @ReactProp(name = "elevation")
    public void setElevation(T t, float f) {
        if (VERSION.SDK_INT >= 21) {
            t.setElevation(PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(T t, float f) {
        ViewGroupManager.setViewZIndex(t, Math.round(f));
        t = t.getParent();
        if (t != null && (t instanceof ReactZIndexedViewGroup) != null) {
            ((ReactZIndexedViewGroup) t).updateDrawingOrder();
        }
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setLayerType(z ? true : false, null);
    }

    @ReactProp(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(C1864R.id.react_test_id, str);
        t.setTag(str);
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(T t, String str) {
        t.setTag(C1864R.id.view_tag_native_id, str);
        ReactFindViewUtil.notifyViewRendered(t);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setContentDescription(str);
    }

    @ReactProp(name = "accessibilityComponentType")
    public void setAccessibilityComponentType(T t, String str) {
        AccessibilityHelper.updateAccessibilityComponentType(t, str);
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(T t, String str) {
        t.setTag(C1864R.id.accessibility_hint, str);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(T r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r4.toUpperCase();	 Catch:{ NullPointerException -> 0x002c, IllegalArgumentException -> 0x0010 }
        com.facebook.react.uimanager.AccessibilityDelegateUtil.AccessibilityRole.valueOf(r0);	 Catch:{ NullPointerException -> 0x002c, IllegalArgumentException -> 0x0010 }
        r0 = com.facebook.react.C1864R.id.accessibility_role;
        r3.setTag(r0, r4);
        return;
    L_0x0010:
        r3 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Invalid Role ";
        r0.append(r1);
        r0.append(r4);
        r4 = " Passed In";
        r0.append(r4);
        r4 = r0.toString();
        r3.<init>(r4);
        throw r3;
    L_0x002c:
        r3 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Invalid Role ";
        r0.append(r1);
        r0.append(r4);
        r4 = " Passed In";
        r0.append(r4);
        r4 = r0.toString();
        r3.<init>(r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManager.setAccessibilityRole(android.view.View, java.lang.String):void");
    }

    @ReactProp(name = "accessibilityStates")
    public void setViewStates(T t, ReadableArray readableArray) {
        t.setSelected(false);
        t.setEnabled(true);
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                String string = readableArray.getString(i);
                if (string.equals("selected")) {
                    t.setSelected(true);
                } else if (string.equals("disabled")) {
                    t.setEnabled(false);
                }
            }
        }
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str != null) {
            if (!str.equals("auto")) {
                if (str.equals("yes")) {
                    t.setImportantForAccessibility(1);
                    return;
                } else if (str.equals("no")) {
                    t.setImportantForAccessibility(2);
                    return;
                } else if (str.equals("no-hide-descendants") != null) {
                    t.setImportantForAccessibility(4);
                    return;
                } else {
                    return;
                }
            }
        }
        t.setImportantForAccessibility(null);
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f) {
        t.setRotation(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f) {
        t.setScaleX(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f) {
        t.setScaleY(f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f) {
        t.setTranslationX(PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f) {
        t.setTranslationY(PixelUtil.toPixelFromDIP(f));
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (VERSION.SDK_INT >= 19) {
            if (str != null) {
                if (!str.equals(ViewProps.NONE)) {
                    if (str.equals("polite")) {
                        t.setAccessibilityLiveRegion(1);
                        return;
                    } else if (str.equals("assertive") != null) {
                        t.setAccessibilityLiveRegion(2);
                        return;
                    } else {
                        return;
                    }
                }
            }
            t.setAccessibilityLiveRegion(null);
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        MatrixMathHelper.decomposeMatrix(sTransformDecompositionArray, sMatrixDecompositionContext);
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[1]));
        view.setRotation((float) sMatrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) sMatrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) sMatrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) sMatrixDecompositionContext.scale[0]);
        view.setScaleY((float) sMatrixDecompositionContext.scale[1]);
        readableArray = sMatrixDecompositionContext.perspective;
        if (readableArray.length > 2) {
            readableArray = (float) readableArray[2];
            if (readableArray == 0.0f) {
                readableArray = 978111693;
            }
            view.setCameraDistance((DisplayMetricsHolder.getScreenDisplayMetrics().density * (-1.0f / readableArray)) * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
        view.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    private void updateViewAccessibility(T t) {
        AccessibilityDelegateUtil.setDelegate(t);
    }

    protected void onAfterUpdateTransaction(T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
    }
}
