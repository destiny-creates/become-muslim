package com.facebook.react.fabric.events;

import android.annotation.TargetApi;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.Scheduler;
import com.facebook.react.fabric.Work;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.Closeable;
import java.util.HashSet;
import java.util.Set;

@TargetApi(5)
public class FabricEventEmitter implements RCTEventEmitter, Closeable {
    private static final String TAG = "FabricEventEmitter";
    private final FabricUIManager mFabricUIManager;
    private final Scheduler mScheduler;

    private class FabricUIManagerWork implements Work {
        private final String mEventName;
        private final long mEventTarget;
        private final WritableMap mParams;

        public FabricUIManagerWork(long j, String str, WritableMap writableMap) {
            this.mEventTarget = j;
            this.mEventName = str;
            this.mParams = writableMap;
        }

        public void run() {
            try {
                FabricEventEmitter.this.mFabricUIManager.invoke(this.mEventTarget, this.mEventName, this.mParams);
            } catch (Throwable th) {
                String access$100 = FabricEventEmitter.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error sending event ");
                stringBuilder.append(this.mEventName);
                FLog.m5675e(access$100, stringBuilder.toString(), th);
            }
        }
    }

    public FabricEventEmitter(ReactApplicationContext reactApplicationContext, FabricUIManager fabricUIManager) {
        this.mScheduler = new Scheduler(reactApplicationContext);
        this.mFabricUIManager = fabricUIManager;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        try {
            this.mScheduler.scheduleWork(new FabricUIManagerWork(this.mFabricUIManager.getEventTarget(i), str, writableMap));
        } catch (Throwable e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to emmit event for tag ");
            stringBuilder.append(i);
            FLog.m5675e(str2, stringBuilder.toString(), e);
        }
    }

    public void close() {
        this.mScheduler.shutdown();
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        int i;
        int i2;
        if (!TouchesHelper.TOP_TOUCH_END_KEY.equalsIgnoreCase(str)) {
            if (!TouchesHelper.TOP_TOUCH_CANCEL_KEY.equalsIgnoreCase(str)) {
                writableArray = touchSubsequence(writableArray, writableArray2);
                writableArray2 = writableArray.first;
                writableArray = writableArray.second;
                for (i = 0; i < writableArray2.size(); i++) {
                    WritableMap writableMap = getWritableMap(writableArray2.getMap(i));
                    writableMap.putArray(TouchesHelper.CHANGED_TOUCHES_KEY, writableArray2);
                    writableMap.putArray(TouchesHelper.TOUCHES_KEY, writableArray);
                    i2 = writableMap.getInt(TouchesHelper.TARGET_KEY);
                    if (i2 < 1) {
                        FLog.m5674e(TAG, "A view is reporting that a touch occurred on tag zero.");
                        i2 = 0;
                    }
                    receiveEvent(i2, str, writableMap);
                }
            }
        }
        writableArray = removeTouchesAtIndices(writableArray, writableArray2);
        writableArray2 = writableArray.first;
        writableArray = writableArray.second;
        for (i = 0; i < writableArray2.size(); i++) {
            WritableMap writableMap2 = getWritableMap(writableArray2.getMap(i));
            writableMap2.putArray(TouchesHelper.CHANGED_TOUCHES_KEY, writableArray2);
            writableMap2.putArray(TouchesHelper.TOUCHES_KEY, writableArray);
            i2 = writableMap2.getInt(TouchesHelper.TARGET_KEY);
            if (i2 < 1) {
                FLog.m5674e(TAG, "A view is reporting that a touch occurred on tag zero.");
                i2 = 0;
            }
            receiveEvent(i2, str, writableMap2);
        }
    }

    private Pair<WritableArray, WritableArray> removeTouchesAtIndices(WritableArray writableArray, WritableArray writableArray2) {
        WritableArray writableNativeArray = new WritableNativeArray();
        WritableArray writableNativeArray2 = new WritableNativeArray();
        Set hashSet = new HashSet();
        for (int i = 0; i < writableArray2.size(); i++) {
            int i2 = writableArray2.getInt(i);
            writableNativeArray.pushMap(getWritableMap(writableArray.getMap(i2)));
            hashSet.add(Integer.valueOf(i2));
        }
        for (int i3 = 0; i3 < writableArray.size(); i3++) {
            if (hashSet.contains(Integer.valueOf(i3)) == null) {
                writableNativeArray2.pushMap(getWritableMap(writableArray.getMap(i3)));
            }
        }
        return new Pair(writableNativeArray, writableNativeArray2);
    }

    private Pair<WritableArray, WritableArray> touchSubsequence(WritableArray writableArray, WritableArray writableArray2) {
        WritableArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < writableArray2.size(); i++) {
            writableNativeArray.pushMap(getWritableMap(writableArray.getMap(i)));
        }
        return new Pair(writableNativeArray, writableArray);
    }

    private WritableMap getWritableMap(ReadableMap readableMap) {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(readableMap);
        return writableNativeMap;
    }
}
