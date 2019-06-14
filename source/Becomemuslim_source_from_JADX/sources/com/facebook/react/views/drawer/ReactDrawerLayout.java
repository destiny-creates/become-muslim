package com.facebook.react.views.drawer;

import android.support.v4.widget.C0553i;
import android.support.v4.widget.C0553i.C0550d;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.events.NativeGestureUtil;

class ReactDrawerLayout extends C0553i {
    public static final int DEFAULT_DRAWER_WIDTH = -1;
    private int mDrawerPosition = 8388611;
    private int mDrawerWidth = -1;

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                return true;
            }
        } catch (MotionEvent motionEvent2) {
            Log.w(ReactConstants.TAG, "Error intercepting touch event.", motionEvent2);
        }
        return null;
    }

    void openDrawer() {
        openDrawer(this.mDrawerPosition);
    }

    void closeDrawer() {
        closeDrawer(this.mDrawerPosition);
    }

    void setDrawerPosition(int i) {
        this.mDrawerPosition = i;
        setDrawerProperties();
    }

    void setDrawerWidth(int i) {
        this.mDrawerWidth = i;
        setDrawerProperties();
    }

    void setDrawerProperties() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            C0550d c0550d = (C0550d) childAt.getLayoutParams();
            c0550d.f1390a = this.mDrawerPosition;
            c0550d.width = this.mDrawerWidth;
            childAt.setLayoutParams(c0550d);
            childAt.setClickable(true);
        }
    }
}
