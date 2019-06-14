package expo.modules.camera.events;

import android.os.Bundle;
import android.support.v4.util.Pools.C4463b;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;

public class CameraReadyEvent extends C7368a {
    private static final C4463b<CameraReadyEvent> EVENTS_POOL = new C4463b(3);

    private CameraReadyEvent() {
    }

    public static CameraReadyEvent obtain() {
        CameraReadyEvent cameraReadyEvent = (CameraReadyEvent) EVENTS_POOL.acquire();
        return cameraReadyEvent == null ? new CameraReadyEvent() : cameraReadyEvent;
    }

    public String getEventName() {
        return Events.EVENT_CAMERA_READY.toString();
    }

    public Bundle getEventBody() {
        return Bundle.EMPTY;
    }
}
