package com.facebook.react.bridge;

import com.facebook.soloader.SoLoader;

public class ReactBridge {
    private static boolean sDidInit = false;

    public static void staticInit() {
        if (!sDidInit) {
            SoLoader.loadLibrary("reactnativejni");
            sDidInit = true;
        }
    }
}
