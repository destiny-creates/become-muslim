package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.support.v4.util.Pools.C4463b;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandler;

public class RNGestureHandlerEvent extends Event<RNGestureHandlerEvent> {
    private static final C4463b<RNGestureHandlerEvent> EVENTS_POOL = new C4463b(7);
    public static final String EVENT_NAME = "onGestureHandlerEvent";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private WritableMap mExtraData;

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public static RNGestureHandlerEvent obtain(GestureHandler gestureHandler, RNGestureHandlerEventDataExtractor rNGestureHandlerEventDataExtractor) {
        RNGestureHandlerEvent rNGestureHandlerEvent = (RNGestureHandlerEvent) EVENTS_POOL.acquire();
        if (rNGestureHandlerEvent == null) {
            rNGestureHandlerEvent = new RNGestureHandlerEvent();
        }
        rNGestureHandlerEvent.init(gestureHandler, rNGestureHandlerEventDataExtractor);
        return rNGestureHandlerEvent;
    }

    private RNGestureHandlerEvent() {
    }

    private void init(GestureHandler gestureHandler, RNGestureHandlerEventDataExtractor rNGestureHandlerEventDataExtractor) {
        super.init(gestureHandler.getView().getId());
        this.mExtraData = Arguments.createMap();
        if (rNGestureHandlerEventDataExtractor != null) {
            rNGestureHandlerEventDataExtractor.extractEventData(gestureHandler, this.mExtraData);
        }
        this.mExtraData.putInt("handlerTag", gestureHandler.getTag());
        this.mExtraData.putInt(ServerProtocol.DIALOG_PARAM_STATE, gestureHandler.getState());
    }

    public void onDispose() {
        this.mExtraData = null;
        EVENTS_POOL.release(this);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, this.mExtraData);
    }
}
