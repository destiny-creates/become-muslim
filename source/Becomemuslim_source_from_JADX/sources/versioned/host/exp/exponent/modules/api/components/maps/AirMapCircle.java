package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5138e;
import com.google.android.gms.maps.model.C7848f;
import com.google.android.gms.maps.model.LatLng;

public class AirMapCircle extends AirMapFeature {
    private LatLng center;
    private C5138e circle;
    private C7848f circleOptions;
    private int fillColor;
    private double radius;
    private int strokeColor;
    private float strokeWidth;
    private float zIndex;

    public AirMapCircle(Context context) {
        super(context);
    }

    public void setCenter(LatLng latLng) {
        this.center = latLng;
        if (this.circle != null) {
            this.circle.m21771a(this.center);
        }
    }

    public void setRadius(double d) {
        this.radius = d;
        if (this.circle != null) {
            this.circle.m21768a(this.radius);
        }
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        if (this.circle != null) {
            this.circle.m21773b(i);
        }
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        if (this.circle != null) {
            this.circle.m21770a(i);
        }
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        if (this.circle != null) {
            this.circle.m21769a(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.circle != null) {
            this.circle.m21772b(f);
        }
    }

    public C7848f getCircleOptions() {
        if (this.circleOptions == null) {
            this.circleOptions = createCircleOptions();
        }
        return this.circleOptions;
    }

    private C7848f createCircleOptions() {
        C7848f c7848f = new C7848f();
        c7848f.m38287a(this.center);
        c7848f.m38284a(this.radius);
        c7848f.m38290b(this.fillColor);
        c7848f.m38286a(this.strokeColor);
        c7848f.m38285a(this.strokeWidth);
        c7848f.m38289b(this.zIndex);
        return c7848f;
    }

    public Object getFeature() {
        return this.circle;
    }

    public void addToMap(C5125c c5125c) {
        this.circle = c5125c.m21700a(getCircleOptions());
    }

    public void removeFromMap(C5125c c5125c) {
        this.circle.m21767a();
    }
}
