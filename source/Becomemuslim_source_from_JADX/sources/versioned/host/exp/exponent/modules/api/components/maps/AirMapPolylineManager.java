package versioned.host.exp.exponent.modules.api.components.maps;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.maps.model.C8226c;
import com.google.android.gms.maps.model.C8227t;
import com.google.android.gms.maps.model.C8228v;
import java.util.Map;

public class AirMapPolylineManager extends ViewGroupManager<AirMapPolyline> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapPolyline";
    }

    public AirMapPolylineManager(ReactApplicationContext reactApplicationContext) {
        if (VERSION.SDK_INT >= 17) {
            this.metrics = new DisplayMetrics();
            ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
            return;
        }
        this.metrics = reactApplicationContext.getResources().getDisplayMetrics();
    }

    public AirMapPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new AirMapPolyline(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(AirMapPolyline airMapPolyline, ReadableArray readableArray) {
        airMapPolyline.setCoordinates(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(AirMapPolyline airMapPolyline, float f) {
        airMapPolyline.setWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(AirMapPolyline airMapPolyline, int i) {
        airMapPolyline.setColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(AirMapPolyline airMapPolyline, boolean z) {
        airMapPolyline.setGeodesic(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(AirMapPolyline airMapPolyline, float f) {
        airMapPolyline.setZIndex(f);
    }

    @ReactProp(name = "lineCap")
    public void setlineCap(AirMapPolyline airMapPolyline, String str) {
        int hashCode = str.hashCode();
        if (hashCode != -894674659) {
            if (hashCode != 3035667) {
                if (hashCode == 108704142) {
                    if (str.equals("round") != null) {
                        str = true;
                        switch (str) {
                            case null:
                                str = new C8226c();
                                break;
                            case 1:
                                str = new C8227t();
                                break;
                            case 2:
                                str = new C8228v();
                                break;
                            default:
                                str = new C8227t();
                                break;
                        }
                        airMapPolyline.setLineCap(str);
                    }
                }
            } else if (str.equals("butt") != null) {
                str = null;
                switch (str) {
                    case null:
                        str = new C8226c();
                        break;
                    case 1:
                        str = new C8227t();
                        break;
                    case 2:
                        str = new C8228v();
                        break;
                    default:
                        str = new C8227t();
                        break;
                }
                airMapPolyline.setLineCap(str);
            }
        } else if (str.equals(MessengerShareContentUtility.IMAGE_RATIO_SQUARE) != null) {
            str = 2;
            switch (str) {
                case null:
                    str = new C8226c();
                    break;
                case 1:
                    str = new C8227t();
                    break;
                case 2:
                    str = new C8228v();
                    break;
                default:
                    str = new C8227t();
                    break;
            }
            airMapPolyline.setLineCap(str);
        }
        str = -1;
        switch (str) {
            case null:
                str = new C8226c();
                break;
            case 1:
                str = new C8227t();
                break;
            case 2:
                str = new C8228v();
                break;
            default:
                str = new C8227t();
                break;
        }
        airMapPolyline.setLineCap(str);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
