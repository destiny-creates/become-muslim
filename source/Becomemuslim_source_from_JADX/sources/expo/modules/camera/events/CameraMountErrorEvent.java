package expo.modules.camera.events;

import android.os.Bundle;
import android.support.v4.util.Pools.C4463b;
import com.facebook.share.internal.ShareConstants;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class CameraMountErrorEvent extends C7368a {
    private static final C4463b<CameraMountErrorEvent> EVENTS_POOL = new C4463b(3);
    private String mMessage;

    private CameraMountErrorEvent() {
    }

    public static CameraMountErrorEvent obtain(String str) {
        CameraMountErrorEvent cameraMountErrorEvent = (CameraMountErrorEvent) EVENTS_POOL.acquire();
        if (cameraMountErrorEvent == null) {
            cameraMountErrorEvent = new CameraMountErrorEvent();
        }
        cameraMountErrorEvent.init(str);
        return cameraMountErrorEvent;
    }

    private void init(String str) {
        this.mMessage = str;
    }

    public String getEventName() {
        return Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    public Bundle getEventBody() {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.mMessage);
        return bundle;
    }
}
