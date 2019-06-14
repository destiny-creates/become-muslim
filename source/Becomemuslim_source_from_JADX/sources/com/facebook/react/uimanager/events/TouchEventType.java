package com.facebook.react.uimanager.events;

public enum TouchEventType {
    START("topTouchStart"),
    END(TouchesHelper.TOP_TOUCH_END_KEY),
    MOVE("topTouchMove"),
    CANCEL(TouchesHelper.TOP_TOUCH_CANCEL_KEY);
    
    private final String mJSEventName;

    private TouchEventType(String str) {
        this.mJSEventName = str;
    }

    public String getJSEventName() {
        return this.mJSEventName;
    }
}
