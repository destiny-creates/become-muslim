package expo.modules.location;

import android.content.Context;
import android.location.LocationManager;
import com.facebook.places.model.PlaceFields;
import io.nlopez.smartlocation.p359a.p360a.C6524a;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p359a.p360a.C6526b.C6525a;
import java.util.Map;

public class LocationHelpers {
    public static boolean isAnyProviderAvailable(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
        if (locationManager != null && (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network") != null)) {
            z = true;
        }
        return z;
    }

    private static C6525a buildLocationParamsForAccuracy(int i) {
        switch (i) {
            case 1:
                return new C6525a().m26684a(C6524a.LOWEST).m26682a(3000.0f).m26683a(10000);
            case 2:
                return new C6525a().m26684a(C6524a.LOW).m26682a(1000.0f).m26683a(5000);
            case 4:
                return new C6525a().m26684a(C6524a.HIGH).m26682a(50.0f).m26683a(2000);
            case 5:
                return new C6525a().m26684a(C6524a.HIGH).m26682a(25.0f).m26683a(1000);
            case 6:
                return new C6525a().m26684a(C6524a.HIGH).m26682a(0.0f).m26683a(500);
            default:
                return new C6525a().m26684a(C6524a.MEDIUM).m26682a(100.0f).m26683a(3000);
        }
    }

    public static C6526b mapOptionsToLocationParams(Map<String, Object> map) {
        C6525a buildLocationParamsForAccuracy = buildLocationParamsForAccuracy(getAccuracyFromOptions(map));
        if (map.containsKey("timeInterval")) {
            buildLocationParamsForAccuracy.m26683a(((Number) map.get("timeInterval")).longValue());
        }
        if (map.containsKey("distanceInterval")) {
            buildLocationParamsForAccuracy.m26682a(((Number) map.get("distanceInterval")).floatValue());
        }
        return buildLocationParamsForAccuracy.m26685a();
    }

    public static int getAccuracyFromOptions(Map<String, Object> map) {
        Object obj = (map.containsKey("enableHighAccuracy") && ((Boolean) map.get("enableHighAccuracy")).booleanValue()) ? 1 : null;
        if (map.containsKey("accuracy")) {
            return ((Number) map.get("accuracy")).intValue();
        }
        return obj != null ? 4 : 3;
    }
}
