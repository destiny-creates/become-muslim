package com.facebook.places;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.places.internal.BluetoothScanResult;
import com.facebook.places.internal.LocationPackage;
import com.facebook.places.internal.LocationPackageManager;
import com.facebook.places.internal.LocationPackageManager.Listener;
import com.facebook.places.internal.LocationPackageRequestParams.Builder;
import com.facebook.places.internal.ScannerException.Type;
import com.facebook.places.internal.WifiScanResult;
import com.facebook.places.model.CurrentPlaceFeedbackRequestParams;
import com.facebook.places.model.CurrentPlaceRequestParams;
import com.facebook.places.model.CurrentPlaceRequestParams.ConfidenceLevel;
import com.facebook.places.model.CurrentPlaceRequestParams.ScanMode;
import com.facebook.places.model.PlaceInfoRequestParams;
import com.facebook.places.model.PlaceSearchRequestParams;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlaceManager {
    private static final String CURRENT_PLACE_FEEDBACK = "current_place/feedback";
    private static final String CURRENT_PLACE_RESULTS = "current_place/results";
    private static final String PARAM_ACCESS_POINTS = "access_points";
    private static final String PARAM_ACCURACY = "accuracy";
    private static final String PARAM_ALTITUDE = "altitude";
    private static final String PARAM_BLUETOOTH = "bluetooth";
    private static final String PARAM_CATEGORIES = "categories";
    private static final String PARAM_CENTER = "center";
    private static final String PARAM_COORDINATES = "coordinates";
    private static final String PARAM_CURRENT_CONNECTION = "current_connection";
    private static final String PARAM_DISTANCE = "distance";
    private static final String PARAM_ENABLED = "enabled";
    private static final String PARAM_FIELDS = "fields";
    private static final String PARAM_FREQUENCY = "frequency";
    private static final String PARAM_HEADING = "heading";
    private static final String PARAM_LATITUDE = "latitude";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_LONGITUDE = "longitude";
    private static final String PARAM_MAC_ADDRESS = "mac_address";
    private static final String PARAM_MIN_CONFIDENCE_LEVEL = "min_confidence_level";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_PLACE_ID = "place_id";
    private static final String PARAM_Q = "q";
    private static final String PARAM_RSSI = "rssi";
    private static final String PARAM_SCANS = "scans";
    private static final String PARAM_SIGNAL_STRENGTH = "signal_strength";
    private static final String PARAM_SPEED = "speed";
    private static final String PARAM_SSID = "ssid";
    private static final String PARAM_SUMMARY = "summary";
    private static final String PARAM_TRACKING = "tracking";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_WAS_HERE = "was_here";
    private static final String PARAM_WIFI = "wifi";
    private static final String SEARCH = "search";

    public enum LocationError {
        LOCATION_PERMISSION_DENIED,
        LOCATION_SERVICES_DISABLED,
        LOCATION_TIMEOUT,
        UNKNOWN_ERROR
    }

    public interface OnRequestReadyCallback {
        void onLocationError(LocationError locationError);

        void onRequestReady(GraphRequest graphRequest);
    }

    private PlaceManager() {
    }

    public static void newPlaceSearchRequest(final PlaceSearchRequestParams placeSearchRequestParams, final OnRequestReadyCallback onRequestReadyCallback) {
        Builder builder = new Builder();
        builder.setWifiScanEnabled(false);
        builder.setBluetoothScanEnabled(false);
        LocationPackageManager.requestLocationPackage(builder.build(), new Listener() {
            public void onLocationPackage(LocationPackage locationPackage) {
                if (locationPackage.locationError == null) {
                    onRequestReadyCallback.onRequestReady(PlaceManager.newPlaceSearchRequestForLocation(placeSearchRequestParams, locationPackage.location));
                    return;
                }
                onRequestReadyCallback.onLocationError(PlaceManager.getLocationError(locationPackage.locationError));
            }
        });
    }

    public static GraphRequest newPlaceSearchRequestForLocation(PlaceSearchRequestParams placeSearchRequestParams, Location location) {
        String searchText = placeSearchRequestParams.getSearchText();
        if (location == null) {
            if (searchText == null) {
                throw new FacebookException("Either location or searchText must be specified.");
            }
        }
        int limit = placeSearchRequestParams.getLimit();
        Iterable fields = placeSearchRequestParams.getFields();
        Set<String> categories = placeSearchRequestParams.getCategories();
        Bundle bundle = new Bundle(7);
        bundle.putString("type", "place");
        if (location != null) {
            bundle.putString(PARAM_CENTER, String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
            placeSearchRequestParams = placeSearchRequestParams.getDistance();
            if (placeSearchRequestParams > null) {
                bundle.putInt(PARAM_DISTANCE, placeSearchRequestParams);
            }
        }
        if (limit > 0) {
            bundle.putInt(PARAM_LIMIT, limit);
        }
        if (Utility.isNullOrEmpty(searchText) == null) {
            bundle.putString(PARAM_Q, searchText);
        }
        if (categories != null && categories.isEmpty() == null) {
            placeSearchRequestParams = new JSONArray();
            for (String searchText2 : categories) {
                placeSearchRequestParams.put(searchText2);
            }
            bundle.putString(PARAM_CATEGORIES, placeSearchRequestParams.toString());
        }
        if (fields != null && fields.isEmpty() == null) {
            bundle.putString("fields", TextUtils.join(",", fields));
        }
        return new GraphRequest(AccessToken.getCurrentAccessToken(), SEARCH, bundle, HttpMethod.GET);
    }

    public static GraphRequest newPlaceInfoRequest(PlaceInfoRequestParams placeInfoRequestParams) {
        String placeId = placeInfoRequestParams.getPlaceId();
        if (placeId != null) {
            Bundle bundle = new Bundle(1);
            placeInfoRequestParams = placeInfoRequestParams.getFields();
            if (!(placeInfoRequestParams == null || placeInfoRequestParams.isEmpty())) {
                bundle.putString("fields", TextUtils.join(",", placeInfoRequestParams));
            }
            return new GraphRequest(AccessToken.getCurrentAccessToken(), placeId, bundle, HttpMethod.GET);
        }
        throw new FacebookException("placeId must be specified.");
    }

    public static void newCurrentPlaceRequest(final CurrentPlaceRequestParams currentPlaceRequestParams, final OnRequestReadyCallback onRequestReadyCallback) {
        Location location = currentPlaceRequestParams.getLocation();
        ScanMode scanMode = currentPlaceRequestParams.getScanMode();
        Builder builder = new Builder();
        builder.setLocationScanEnabled(location == null);
        if (scanMode != null && scanMode == ScanMode.LOW_LATENCY) {
            builder.setWifiActiveScanAllowed(false);
        }
        LocationPackageManager.requestLocationPackage(builder.build(), new Listener() {
            public void onLocationPackage(LocationPackage locationPackage) {
                if (locationPackage.locationError != null) {
                    onRequestReadyCallback.onLocationError(PlaceManager.getLocationError(locationPackage.locationError));
                    return;
                }
                onRequestReadyCallback.onRequestReady(new GraphRequest(AccessToken.getCurrentAccessToken(), PlaceManager.CURRENT_PLACE_RESULTS, PlaceManager.getCurrentPlaceParameters(currentPlaceRequestParams, locationPackage), HttpMethod.GET));
            }
        });
    }

    public static GraphRequest newCurrentPlaceFeedbackRequest(CurrentPlaceFeedbackRequestParams currentPlaceFeedbackRequestParams) {
        String placeId = currentPlaceFeedbackRequestParams.getPlaceId();
        String tracking = currentPlaceFeedbackRequestParams.getTracking();
        currentPlaceFeedbackRequestParams = currentPlaceFeedbackRequestParams.wasHere();
        if (tracking == null || placeId == null || currentPlaceFeedbackRequestParams == null) {
            throw new FacebookException("tracking, placeId and wasHere must be specified.");
        }
        Bundle bundle = new Bundle(3);
        bundle.putString(PARAM_TRACKING, tracking);
        bundle.putString(PARAM_PLACE_ID, placeId);
        bundle.putBoolean(PARAM_WAS_HERE, currentPlaceFeedbackRequestParams.booleanValue());
        return new GraphRequest(AccessToken.getCurrentAccessToken(), CURRENT_PLACE_FEEDBACK, bundle, HttpMethod.POST);
    }

    private static Bundle getCurrentPlaceParameters(CurrentPlaceRequestParams currentPlaceRequestParams, LocationPackage locationPackage) {
        if (currentPlaceRequestParams != null) {
            if (locationPackage == null) {
                locationPackage = new LocationPackage();
            }
            if (locationPackage.location == null) {
                locationPackage.location = currentPlaceRequestParams.getLocation();
            }
            if (locationPackage.location != null) {
                try {
                    Bundle bundle = new Bundle(6);
                    bundle.putString(PARAM_SUMMARY, PARAM_TRACKING);
                    int limit = currentPlaceRequestParams.getLimit();
                    if (limit > 0) {
                        bundle.putInt(PARAM_LIMIT, limit);
                    }
                    Iterable fields = currentPlaceRequestParams.getFields();
                    if (!(fields == null || fields.isEmpty())) {
                        bundle.putString("fields", TextUtils.join(",", fields));
                    }
                    Location location = locationPackage.location;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PARAM_LATITUDE, location.getLatitude());
                    jSONObject.put(PARAM_LONGITUDE, location.getLongitude());
                    if (location.hasAccuracy()) {
                        jSONObject.put(PARAM_ACCURACY, (double) location.getAccuracy());
                    }
                    if (location.hasAltitude()) {
                        jSONObject.put(PARAM_ALTITUDE, location.getAltitude());
                    }
                    if (location.hasBearing()) {
                        jSONObject.put(PARAM_HEADING, (double) location.getBearing());
                    }
                    if (location.hasSpeed()) {
                        jSONObject.put(PARAM_SPEED, (double) location.getSpeed());
                    }
                    bundle.putString(PARAM_COORDINATES, jSONObject.toString());
                    currentPlaceRequestParams = currentPlaceRequestParams.getMinConfidenceLevel();
                    if (currentPlaceRequestParams == ConfidenceLevel.LOW || currentPlaceRequestParams == ConfidenceLevel.MEDIUM || currentPlaceRequestParams == ConfidenceLevel.HIGH) {
                        bundle.putString(PARAM_MIN_CONFIDENCE_LEVEL, currentPlaceRequestParams.toString().toLowerCase(Locale.US));
                    }
                    if (locationPackage != null) {
                        currentPlaceRequestParams = new JSONObject();
                        currentPlaceRequestParams.put("enabled", locationPackage.isWifiScanningEnabled);
                        WifiScanResult wifiScanResult = locationPackage.connectedWifi;
                        if (wifiScanResult != null) {
                            currentPlaceRequestParams.put(PARAM_CURRENT_CONNECTION, getWifiScanJson(wifiScanResult));
                        }
                        List<WifiScanResult> list = locationPackage.ambientWifi;
                        if (list != null) {
                            JSONArray jSONArray = new JSONArray();
                            for (WifiScanResult wifiScanJson : list) {
                                jSONArray.put(getWifiScanJson(wifiScanJson));
                            }
                            currentPlaceRequestParams.put(PARAM_ACCESS_POINTS, jSONArray);
                        }
                        bundle.putString(PARAM_WIFI, currentPlaceRequestParams.toString());
                        currentPlaceRequestParams = new JSONObject();
                        currentPlaceRequestParams.put("enabled", locationPackage.isBluetoothScanningEnabled);
                        LocationPackage<BluetoothScanResult> locationPackage2 = locationPackage.ambientBluetoothLe;
                        if (locationPackage2 != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (BluetoothScanResult bluetoothScanResult : locationPackage2) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("payload", bluetoothScanResult.payload);
                                jSONObject2.put(PARAM_RSSI, bluetoothScanResult.rssi);
                                jSONArray2.put(jSONObject2);
                            }
                            currentPlaceRequestParams.put(PARAM_SCANS, jSONArray2);
                        }
                        bundle.putString(PARAM_BLUETOOTH, currentPlaceRequestParams.toString());
                    }
                    return bundle;
                } catch (Throwable e) {
                    throw new FacebookException(e);
                }
            }
            throw new FacebookException("A location must be specified");
        }
        throw new FacebookException("Request and location must be specified.");
    }

    private static JSONObject getWifiScanJson(WifiScanResult wifiScanResult) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PARAM_MAC_ADDRESS, wifiScanResult.bssid);
        jSONObject.put(PARAM_SSID, wifiScanResult.ssid);
        jSONObject.put(PARAM_SIGNAL_STRENGTH, wifiScanResult.rssi);
        jSONObject.put(PARAM_FREQUENCY, wifiScanResult.frequency);
        return jSONObject;
    }

    private static LocationError getLocationError(Type type) {
        if (type == Type.PERMISSION_DENIED) {
            return LocationError.LOCATION_PERMISSION_DENIED;
        }
        if (type == Type.DISABLED) {
            return LocationError.LOCATION_SERVICES_DISABLED;
        }
        if (type == Type.TIMEOUT) {
            return LocationError.LOCATION_TIMEOUT;
        }
        return LocationError.UNKNOWN_ERROR;
    }
}
