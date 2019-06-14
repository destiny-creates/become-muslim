package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TopMessageEvent extends Event<TopMessageEvent> {
    public static final String EVENT_NAME = "topMessage";
    private final String mData;

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public TopMessageEvent(int i, String str) {
        super(i);
        this.mData = str;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("data", this.mData);
        rCTEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, createMap);
    }
}
