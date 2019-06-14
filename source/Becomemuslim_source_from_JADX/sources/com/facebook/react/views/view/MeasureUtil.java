package com.facebook.react.views.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View.MeasureSpec;
import com.facebook.yoga.YogaMeasureMode;

public class MeasureUtil {
    public static int getMeasureSpec(float f, YogaMeasureMode yogaMeasureMode) {
        if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
            return MeasureSpec.makeMeasureSpec((int) f, 1073741824);
        }
        if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
            return MeasureSpec.makeMeasureSpec((int) f, LinearLayoutManager.INVALID_OFFSET);
        }
        return MeasureSpec.makeMeasureSpec(0, 0);
    }
}
