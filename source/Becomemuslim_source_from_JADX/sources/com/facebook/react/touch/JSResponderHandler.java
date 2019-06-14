package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

public class JSResponderHandler implements OnInterceptTouchEventListener {
    private static final int JS_RESPONDER_UNSET = -1;
    private volatile int mCurrentJSResponder = -1;
    private ViewParent mViewParentBlockingNativeResponder;

    public void setJSResponder(int i, ViewParent viewParent) {
        this.mCurrentJSResponder = i;
        maybeUnblockNativeResponder();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(1);
            this.mViewParentBlockingNativeResponder = viewParent;
        }
    }

    public void clearJSResponder() {
        this.mCurrentJSResponder = -1;
        maybeUnblockNativeResponder();
    }

    private void maybeUnblockNativeResponder() {
        if (this.mViewParentBlockingNativeResponder != null) {
            this.mViewParentBlockingNativeResponder.requestDisallowInterceptTouchEvent(false);
            this.mViewParentBlockingNativeResponder = null;
        }
    }

    public boolean onInterceptTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent) {
        int i = this.mCurrentJSResponder;
        boolean z = false;
        if (i == -1 || motionEvent.getAction() == 1) {
            return false;
        }
        if (viewGroup.getId() == i) {
            z = true;
        }
        return z;
    }
}
