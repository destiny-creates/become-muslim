package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
public class ReactMarker {
    private static final List<MarkerListener> sListeners = new ArrayList();

    public interface MarkerListener {
        void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i);
    }

    @DoNotStrip
    public static void addListener(MarkerListener markerListener) {
        synchronized (sListeners) {
            if (!sListeners.contains(markerListener)) {
                sListeners.add(markerListener);
            }
        }
    }

    @DoNotStrip
    public static void removeListener(MarkerListener markerListener) {
        synchronized (sListeners) {
            sListeners.remove(markerListener);
        }
    }

    @DoNotStrip
    public static void clearMarkerListeners() {
        synchronized (sListeners) {
            sListeners.clear();
        }
    }

    @DoNotStrip
    public static void logMarker(String str) {
        logMarker(str, null);
    }

    @DoNotStrip
    public static void logMarker(String str, int i) {
        logMarker(str, null, i);
    }

    @DoNotStrip
    public static void logMarker(String str, String str2) {
        logMarker(str, str2, 0);
    }

    @DoNotStrip
    public static void logMarker(String str, String str2, int i) {
        logMarker(ReactMarkerConstants.valueOf(str), str2, i);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants) {
        logMarker(reactMarkerConstants, null, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, int i) {
        logMarker(reactMarkerConstants, null, i);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str) {
        logMarker(reactMarkerConstants, str, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
        synchronized (sListeners) {
            for (MarkerListener logMarker : sListeners) {
                logMarker.logMarker(reactMarkerConstants, str, i);
            }
        }
    }
}
