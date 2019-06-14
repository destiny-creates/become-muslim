package com.facebook.react.uimanager;

import android.view.View;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class RootViewUtil {
    public static RootView getRootView(View view) {
        while (!(view instanceof RootView)) {
            view = view.getParent();
            if (view == null) {
                return null;
            }
            Assertions.assertCondition(view instanceof View);
            view = view;
        }
        return (RootView) view;
    }
}
