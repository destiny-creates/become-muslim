package versioned.host.exp.exponent.modules.api.components.maps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class LatLngBoundsUtils {
    public static boolean BoundsAreDifferent(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        LatLngBounds latLngBounds3 = latLngBounds;
        LatLngBounds latLngBounds4 = latLngBounds2;
        LatLng a = latLngBounds.m38281a();
        double d = a.f29231a;
        double d2 = a.f29232b;
        double d3 = latLngBounds3.f29234b.f29231a - latLngBounds3.f29233a.f29231a;
        double d4 = latLngBounds3.f29234b.f29232b - latLngBounds3.f29233a.f29232b;
        a = latLngBounds2.m38281a();
        double d5 = a.f29231a;
        double d6 = a.f29232b;
        double d7 = d3;
        double d8 = latLngBounds4.f29234b.f29231a - latLngBounds4.f29233a.f29231a;
        double d9 = latLngBounds4.f29234b.f29232b - latLngBounds4.f29233a.f29232b;
        double LatitudeEpsilon = LatitudeEpsilon(latLngBounds, latLngBounds2);
        double LongitudeEpsilon = LongitudeEpsilon(latLngBounds, latLngBounds2);
        if (!(different(d, d5, LatitudeEpsilon) || different(d2, d6, LongitudeEpsilon) || different(d7, d8, LatitudeEpsilon))) {
            if (!different(d4, d9, LongitudeEpsilon)) {
                return false;
            }
        }
        return true;
    }

    private static boolean different(double d, double d2, double d3) {
        return Math.abs(d - d2) > d3 ? Double.MIN_VALUE : 0.0d;
    }

    private static double LatitudeEpsilon(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.f29234b.f29231a - latLngBounds.f29233a.f29231a), Math.abs(latLngBounds2.f29234b.f29231a - latLngBounds2.f29233a.f29231a)) / 2560.0d;
    }

    private static double LongitudeEpsilon(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.f29234b.f29232b - latLngBounds.f29233a.f29232b), Math.abs(latLngBounds2.f29234b.f29232b - latLngBounds2.f29233a.f29232b)) / 2560.0d;
    }
}
