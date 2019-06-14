package expo.modules.camera.events;

import android.os.Bundle;
import android.support.v4.util.Pools.C4463b;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class PictureSavedEvent extends C7368a {
    private static final C4463b<PictureSavedEvent> EVENTS_POOL = new C4463b(3);
    private Bundle mResponse;

    private PictureSavedEvent() {
    }

    public static PictureSavedEvent obtain(Bundle bundle) {
        PictureSavedEvent pictureSavedEvent = (PictureSavedEvent) EVENTS_POOL.acquire();
        if (pictureSavedEvent == null) {
            pictureSavedEvent = new PictureSavedEvent();
        }
        pictureSavedEvent.init(bundle);
        return pictureSavedEvent;
    }

    private void init(Bundle bundle) {
        this.mResponse = bundle;
    }

    public short getCoalescingKey() {
        Bundle bundle = this.mResponse.getBundle("data");
        if (bundle != null) {
            if (bundle.containsKey("uri")) {
                String string = bundle.getString("uri");
                if (string == null) {
                    return (short) -1;
                }
                return (short) (string.hashCode() % 32767);
            }
        }
        return (short) -1;
    }

    public String getEventName() {
        return Events.EVENT_ON_PICTURE_SAVED.toString();
    }

    public Bundle getEventBody() {
        return this.mResponse;
    }
}
