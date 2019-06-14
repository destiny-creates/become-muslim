package com.facebook.react.uimanager.common;

public class ViewUtil {
    public static int getUIManagerType(int i) {
        return i % 2 == 0 ? 2 : 1;
    }
}
