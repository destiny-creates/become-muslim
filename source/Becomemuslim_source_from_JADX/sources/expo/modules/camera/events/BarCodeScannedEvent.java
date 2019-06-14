package expo.modules.camera.events;

import android.os.Bundle;
import android.support.v4.util.Pools.C4463b;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.camera.CameraViewManager.Events;
import expo.p304a.p305a.p306a.C5991a.C7368a;
import expo.p307b.p308a.C6019c;

public class BarCodeScannedEvent extends C7368a {
    private static final C4463b<BarCodeScannedEvent> EVENTS_POOL = new C4463b(3);
    private C6019c mBarCode;
    private int mViewTag;

    private BarCodeScannedEvent() {
    }

    public static BarCodeScannedEvent obtain(int i, C6019c c6019c) {
        BarCodeScannedEvent barCodeScannedEvent = (BarCodeScannedEvent) EVENTS_POOL.acquire();
        if (barCodeScannedEvent == null) {
            barCodeScannedEvent = new BarCodeScannedEvent();
        }
        barCodeScannedEvent.init(i, c6019c);
        return barCodeScannedEvent;
    }

    private void init(int i, C6019c c6019c) {
        this.mViewTag = i;
        this.mBarCode = c6019c;
    }

    public short getCoalescingKey() {
        return (short) (this.mBarCode.m25164b().hashCode() % 32767);
    }

    public String getEventName() {
        return Events.EVENT_ON_BAR_CODE_SCANNED.toString();
    }

    public Bundle getEventBody() {
        Bundle bundle = new Bundle();
        bundle.putInt(TouchesHelper.TARGET_KEY, this.mViewTag);
        bundle.putString("data", this.mBarCode.m25164b());
        bundle.putInt("type", this.mBarCode.m25163a());
        return bundle;
    }
}
