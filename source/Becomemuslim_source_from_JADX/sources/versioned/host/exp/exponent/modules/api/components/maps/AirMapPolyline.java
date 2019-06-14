package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5145r;
import com.google.android.gms.maps.model.C7847d;
import com.google.android.gms.maps.model.C7855s;
import com.google.android.gms.maps.model.C8227t;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class AirMapPolyline extends AirMapFeature {
    private int color;
    private List<LatLng> coordinates;
    private boolean geodesic;
    private C7847d lineCap = new C8227t();
    private C5145r polyline;
    private C7855s polylineOptions;
    private float width;
    private float zIndex;

    public AirMapPolyline(Context context) {
        super(context);
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.coordinates = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            this.coordinates.add(i, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        if (this.polyline != null) {
            this.polyline.m21821a(this.coordinates);
        }
    }

    public void setColor(int i) {
        this.color = i;
        if (this.polyline != null) {
            this.polyline.m21819a(i);
        }
    }

    public void setWidth(float f) {
        this.width = f;
        if (this.polyline != null) {
            this.polyline.m21818a(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.polyline != null) {
            this.polyline.m21824b(f);
        }
    }

    public void setGeodesic(boolean z) {
        this.geodesic = z;
        if (this.polyline != null) {
            this.polyline.m21826b(z);
        }
    }

    public void setLineCap(C7847d c7847d) {
        this.lineCap = c7847d;
        if (this.polyline != null) {
            this.polyline.m21820a(c7847d);
            this.polyline.m21825b(c7847d);
        }
    }

    public C7855s getPolylineOptions() {
        if (this.polylineOptions == null) {
            this.polylineOptions = createPolylineOptions();
        }
        return this.polylineOptions;
    }

    private C7855s createPolylineOptions() {
        C7855s c7855s = new C7855s();
        c7855s.m38361a(this.coordinates);
        c7855s.m38359a(this.color);
        c7855s.m38358a(this.width);
        c7855s.m38367b(this.geodesic);
        c7855s.m38365b(this.zIndex);
        c7855s.m38360a(this.lineCap);
        c7855s.m38366b(this.lineCap);
        return c7855s;
    }

    public Object getFeature() {
        return this.polyline;
    }

    public void addToMap(C5125c c5125c) {
        this.polyline = c5125c.m21704a(getPolylineOptions());
        this.polyline.m21827c(true);
    }

    public void removeFromMap(C5125c c5125c) {
        this.polyline.m21817a();
    }
}
