package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5136a;
import com.google.android.gms.maps.model.C5139g;
import com.google.android.gms.maps.model.C7849h;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class AirMapOverlay extends AirMapFeature implements ImageReadable {
    private LatLngBounds bounds;
    private C5139g groundOverlay;
    private C7849h groundOverlayOptions;
    private Bitmap iconBitmap;
    private C5136a iconBitmapDescriptor;
    private final ImageReader mImageReader;
    private C5125c map;
    private float transparency;
    private float zIndex;

    public AirMapOverlay(Context context) {
        super(context);
        this.mImageReader = new ImageReader(context, getResources(), this);
    }

    public void setBounds(ReadableArray readableArray) {
        this.bounds = new LatLngBounds(new LatLng(readableArray.getArray(1).getDouble(0), readableArray.getArray(0).getDouble(1)), new LatLng(readableArray.getArray(0).getDouble(0), readableArray.getArray(1).getDouble(1)));
        if (this.groundOverlay != null) {
            this.groundOverlay.m21776a(this.bounds);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.groundOverlay != null) {
            this.groundOverlay.m21775a(f);
        }
    }

    public void setImage(String str) {
        this.mImageReader.setImage(str);
    }

    public C7849h getGroundOverlayOptions() {
        if (this.groundOverlayOptions == null) {
            this.groundOverlayOptions = createGroundOverlayOptions();
        }
        return this.groundOverlayOptions;
    }

    private C7849h createGroundOverlayOptions() {
        if (this.groundOverlayOptions != null) {
            return this.groundOverlayOptions;
        }
        if (this.iconBitmapDescriptor == null) {
            return null;
        }
        C7849h c7849h = new C7849h();
        c7849h.m38301a(this.iconBitmapDescriptor);
        c7849h.m38300a(this.bounds);
        c7849h.m38304b(this.zIndex);
        return c7849h;
    }

    public Object getFeature() {
        return this.groundOverlay;
    }

    public void addToMap(C5125c c5125c) {
        C7849h groundOverlayOptions = getGroundOverlayOptions();
        if (groundOverlayOptions != null) {
            this.groundOverlay = c5125c.m21701a(groundOverlayOptions);
            this.groundOverlay.m21779b(true);
            return;
        }
        this.map = c5125c;
    }

    public void removeFromMap(C5125c c5125c) {
        this.map = null;
        if (this.groundOverlay != null) {
            this.groundOverlay.m21774a();
            this.groundOverlay = null;
            this.groundOverlayOptions = null;
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public void setIconBitmapDescriptor(C5136a c5136a) {
        this.iconBitmapDescriptor = c5136a;
    }

    public void update() {
        this.groundOverlay = getGroundOverlay();
        if (this.groundOverlay != null) {
            this.groundOverlay.m21777a(this.iconBitmapDescriptor);
            this.groundOverlay.m21779b(true);
        }
    }

    private C5139g getGroundOverlay() {
        if (this.groundOverlay != null) {
            return this.groundOverlay;
        }
        if (this.map == null) {
            return null;
        }
        C7849h groundOverlayOptions = getGroundOverlayOptions();
        if (groundOverlayOptions != null) {
            return this.map.m21701a(groundOverlayOptions);
        }
        return null;
    }
}
