package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.bridge.WritableNativeMap;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DisplayMetricsHolder {
    private static DisplayMetrics sScreenDisplayMetrics;
    private static DisplayMetrics sWindowDisplayMetrics;

    public static void setWindowDisplayMetrics(DisplayMetrics displayMetrics) {
        sWindowDisplayMetrics = displayMetrics;
    }

    public static void initDisplayMetricsIfNotInitialized(Context context) {
        if (getScreenDisplayMetrics() == null) {
            initDisplayMetrics(context);
        }
    }

    public static void initDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setWindowDisplayMetrics(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Assertions.assertNotNull(windowManager, "WindowManager is null!");
        context = windowManager.getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            context.getRealMetrics(displayMetrics2);
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                displayMetrics2.widthPixels = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(context, new Object[0])).intValue();
                displayMetrics2.heightPixels = ((Integer) method.invoke(context, new Object[0])).intValue();
            } catch (Context context2) {
                throw new RuntimeException("Error getting real dimensions for API level < 17", context2);
            }
        }
        setScreenDisplayMetrics(displayMetrics2);
    }

    @Deprecated
    public static DisplayMetrics getWindowDisplayMetrics() {
        return sWindowDisplayMetrics;
    }

    public static void setScreenDisplayMetrics(DisplayMetrics displayMetrics) {
        sScreenDisplayMetrics = displayMetrics;
    }

    public static DisplayMetrics getScreenDisplayMetrics() {
        return sScreenDisplayMetrics;
    }

    public static Map<String, Map<String, Object>> getDisplayMetricsMap(double d) {
        boolean z;
        Map<String, Map<String, Object>> hashMap;
        if (sWindowDisplayMetrics == null) {
            if (sScreenDisplayMetrics == null) {
                z = false;
                Assertions.assertNotNull(Boolean.valueOf(z), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
                hashMap = new HashMap();
                hashMap.put("windowPhysicalPixels", getPhysicalPixelsMap(sWindowDisplayMetrics, d));
                hashMap.put("screenPhysicalPixels", getPhysicalPixelsMap(sScreenDisplayMetrics, d));
                return hashMap;
            }
        }
        z = true;
        Assertions.assertNotNull(Boolean.valueOf(z), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        hashMap = new HashMap();
        hashMap.put("windowPhysicalPixels", getPhysicalPixelsMap(sWindowDisplayMetrics, d));
        hashMap.put("screenPhysicalPixels", getPhysicalPixelsMap(sScreenDisplayMetrics, d));
        return hashMap;
    }

    public static WritableNativeMap getDisplayMetricsNativeMap(double d) {
        boolean z;
        WritableNativeMap writableNativeMap;
        if (sWindowDisplayMetrics == null) {
            if (sScreenDisplayMetrics == null) {
                z = false;
                Assertions.assertNotNull(Boolean.valueOf(z), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
                writableNativeMap = new WritableNativeMap();
                writableNativeMap.putMap("windowPhysicalPixels", getPhysicalPixelsNativeMap(sWindowDisplayMetrics, d));
                writableNativeMap.putMap("screenPhysicalPixels", getPhysicalPixelsNativeMap(sScreenDisplayMetrics, d));
                return writableNativeMap;
            }
        }
        z = true;
        Assertions.assertNotNull(Boolean.valueOf(z), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("windowPhysicalPixels", getPhysicalPixelsNativeMap(sWindowDisplayMetrics, d));
        writableNativeMap.putMap("screenPhysicalPixels", getPhysicalPixelsNativeMap(sScreenDisplayMetrics, d));
        return writableNativeMap;
    }

    private static Map<String, Object> getPhysicalPixelsMap(DisplayMetrics displayMetrics, double d) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
        hashMap.put("scale", Float.valueOf(displayMetrics.density));
        hashMap.put("fontScale", Double.valueOf(d));
        hashMap.put("densityDpi", Integer.valueOf(displayMetrics.densityDpi));
        return hashMap;
    }

    private static WritableNativeMap getPhysicalPixelsNativeMap(DisplayMetrics displayMetrics, double d) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", displayMetrics.widthPixels);
        writableNativeMap.putInt("height", displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", (double) displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d);
        writableNativeMap.putDouble("densityDpi", (double) displayMetrics.densityDpi);
        return writableNativeMap;
    }
}
