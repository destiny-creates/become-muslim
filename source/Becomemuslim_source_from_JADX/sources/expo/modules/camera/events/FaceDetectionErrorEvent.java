package expo.modules.camera.events;

import android.os.Bundle;
import android.support.v4.util.Pools.C4463b;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;
import expo.p307b.p311d.C6024a;

public class FaceDetectionErrorEvent extends C7368a {
    private static final C4463b<FaceDetectionErrorEvent> EVENTS_POOL = new C4463b(3);
    private C6024a mFaceDetector;

    public short getCoalescingKey() {
        return (short) 0;
    }

    private FaceDetectionErrorEvent() {
    }

    public static FaceDetectionErrorEvent obtain(C6024a c6024a) {
        FaceDetectionErrorEvent faceDetectionErrorEvent = (FaceDetectionErrorEvent) EVENTS_POOL.acquire();
        if (faceDetectionErrorEvent == null) {
            faceDetectionErrorEvent = new FaceDetectionErrorEvent();
        }
        faceDetectionErrorEvent.init(c6024a);
        return faceDetectionErrorEvent;
    }

    private void init(C6024a c6024a) {
        this.mFaceDetector = c6024a;
    }

    public String getEventName() {
        return Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    public Bundle getEventBody() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOperational", isFaceDetectorOperational());
        return bundle;
    }

    private boolean isFaceDetectorOperational() {
        if (this.mFaceDetector == null) {
            return false;
        }
        return this.mFaceDetector.isOperational();
    }
}
