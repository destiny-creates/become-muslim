package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import expolib_v1.com.facebook.infer.annotation.Assertions;

class ModalHostHelper {
    private static final Point MAX_POINT = new Point();
    private static final Point MIN_POINT = new Point();
    private static final Point SIZE_POINT = new Point();

    ModalHostHelper() {
    }

    @TargetApi(16)
    public static Point getModalHostSize(Context context) {
        Display defaultDisplay = ((WindowManager) Assertions.assertNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(MIN_POINT, MAX_POINT);
        defaultDisplay.getSize(SIZE_POINT);
        int[] iArr = new int[1];
        int i = 0;
        iArr[0] = 16843277;
        boolean z = context.getTheme().obtainStyledAttributes(iArr).getBoolean(0, false);
        context = context.getResources();
        int identifier = context.getIdentifier("status_bar_height", "dimen", "android");
        if (z && identifier > 0) {
            i = (int) context.getDimension(identifier);
        }
        if (SIZE_POINT.x < SIZE_POINT.y) {
            return new Point(MIN_POINT.x, MAX_POINT.y + i);
        }
        return new Point(MAX_POINT.x, MIN_POINT.y + i);
    }
}
