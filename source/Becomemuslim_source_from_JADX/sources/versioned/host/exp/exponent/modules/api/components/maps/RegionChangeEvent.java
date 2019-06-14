package versioned.host.exp.exponent.modules.api.components.maps;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class RegionChangeEvent extends Event<RegionChangeEvent> {
    private final LatLngBounds bounds;
    private final boolean continuous;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "topChange";
    }

    public RegionChangeEvent(int i, LatLngBounds latLngBounds, boolean z) {
        super(i);
        this.bounds = latLngBounds;
        this.continuous = z;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", this.continuous);
        WritableMap writableNativeMap2 = new WritableNativeMap();
        LatLng a = this.bounds.m38281a();
        writableNativeMap2.putDouble("latitude", a.f29231a);
        writableNativeMap2.putDouble("longitude", a.f29232b);
        writableNativeMap2.putDouble("latitudeDelta", this.bounds.f29234b.f29231a - this.bounds.f29233a.f29231a);
        writableNativeMap2.putDouble("longitudeDelta", this.bounds.f29234b.f29232b - this.bounds.f29233a.f29232b);
        writableNativeMap.putMap("region", writableNativeMap2);
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), writableNativeMap);
    }
}
