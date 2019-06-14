package com.facebook.react.animated;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.List;

class EventAnimationDriver implements RCTEventEmitter {
    private List<String> mEventPath;
    ValueAnimatedNode mValueNode;

    public EventAnimationDriver(List<String> list, ValueAnimatedNode valueAnimatedNode) {
        this.mEventPath = list;
        this.mValueNode = valueAnimatedNode;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        if (writableMap != null) {
            for (i = 0; i < this.mEventPath.size() - 1; i++) {
                writableMap = writableMap.getMap((String) this.mEventPath.get(i));
            }
            this.mValueNode.mValue = writableMap.getDouble((String) this.mEventPath.get(this.mEventPath.size() - 1));
            return;
        }
        throw new IllegalArgumentException("Native animated events must have event data.");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by native animated events");
    }
}
