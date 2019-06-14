package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5144p;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class AirMapPolygon extends AirMapFeature {
    private List<LatLng> coordinates;
    private int fillColor;
    private boolean geodesic;
    private List<List<LatLng>> holes;
    private C5144p polygon;
    private C7854q polygonOptions;
    private int strokeColor;
    private float strokeWidth;
    private boolean tappable;
    private float zIndex;

    public AirMapPolygon(Context context) {
        super(context);
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.coordinates = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            this.coordinates.add(i, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        if (this.polygon != null) {
            this.polygon.m21809a(this.coordinates);
        }
    }

    public void setHoles(ReadableArray readableArray) {
        if (readableArray != null) {
            this.holes = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableArray array = readableArray.getArray(i);
                if (array.size() >= 3) {
                    List arrayList = new ArrayList();
                    for (int i2 = 0; i2 < array.size(); i2++) {
                        ReadableMap map = array.getMap(i2);
                        arrayList.add(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
                    }
                    if (arrayList.size() == 3) {
                        arrayList.add(arrayList.get(0));
                    }
                    this.holes.add(arrayList);
                }
            }
            if (this.polygon != null) {
                this.polygon.m21814b(this.holes);
            }
        }
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        if (this.polygon != null) {
            this.polygon.m21813b(i);
        }
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        if (this.polygon != null) {
            this.polygon.m21808a(i);
        }
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        if (this.polygon != null) {
            this.polygon.m21807a(f);
        }
    }

    public void setTappable(boolean z) {
        this.tappable = z;
        if (this.polygon) {
            this.polygon.m21816c(this.tappable);
        }
    }

    public void setGeodesic(boolean z) {
        this.geodesic = z;
        if (this.polygon != null) {
            this.polygon.m21815b(z);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.polygon != null) {
            this.polygon.m21812b(f);
        }
    }

    public C7854q getPolygonOptions() {
        if (this.polygonOptions == null) {
            this.polygonOptions = createPolygonOptions();
        }
        return this.polygonOptions;
    }

    private C7854q createPolygonOptions() {
        C7854q c7854q = new C7854q();
        c7854q.m38342a(this.coordinates);
        c7854q.m38347b(this.fillColor);
        c7854q.m38341a(this.strokeColor);
        c7854q.m38340a(this.strokeWidth);
        c7854q.m38349b(this.geodesic);
        c7854q.m38346b(this.zIndex);
        if (this.holes != null) {
            for (int i = 0; i < this.holes.size(); i++) {
                c7854q.m38348b((Iterable) this.holes.get(i));
            }
        }
        return c7854q;
    }

    public Object getFeature() {
        return this.polygon;
    }

    public void addToMap(C5125c c5125c) {
        this.polygon = c5125c.m21703a(getPolygonOptions());
        this.polygon.m21816c(this.tappable);
    }

    public void removeFromMap(C5125c c5125c) {
        this.polygon.m21806a();
    }
}
