package expo.modules.camera.events;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.Pools.C4463b;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;
import java.util.List;

public class FacesDetectedEvent extends C7368a {
    private static final C4463b<FacesDetectedEvent> EVENTS_POOL = new C4463b(3);
    private List<Bundle> mFaces;
    private int mViewTag;

    private FacesDetectedEvent() {
    }

    public static FacesDetectedEvent obtain(int i, List<Bundle> list) {
        FacesDetectedEvent facesDetectedEvent = (FacesDetectedEvent) EVENTS_POOL.acquire();
        if (facesDetectedEvent == null) {
            facesDetectedEvent = new FacesDetectedEvent();
        }
        facesDetectedEvent.init(i, list);
        return facesDetectedEvent;
    }

    private void init(int i, List<Bundle> list) {
        this.mViewTag = i;
        this.mFaces = list;
    }

    public short getCoalescingKey() {
        if (this.mFaces.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.mFaces.size();
    }

    public String getEventName() {
        return Events.EVENT_ON_FACES_DETECTED.toString();
    }

    public Bundle getEventBody() {
        Bundle bundle = new Bundle();
        bundle.putString("type", "face");
        Parcelable[] parcelableArr = new Bundle[this.mFaces.size()];
        this.mFaces.toArray(parcelableArr);
        bundle.putParcelableArray("faces", parcelableArr);
        bundle.putInt(TouchesHelper.TARGET_KEY, this.mViewTag);
        return bundle;
    }
}
