package com.facebook.react.modules.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SystemClock;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.stetho.server.http.HttpStatus;

@ReactModule(name = "LocationObserver")
public class LocationModule extends ReactContextBaseJavaModule {
    private static final float RCT_DEFAULT_LOCATION_ACCURACY = 100.0f;
    private final LocationListener mLocationListener = new C19441();
    private String mWatchedProvider;

    /* renamed from: com.facebook.react.modules.location.LocationModule$1 */
    class C19441 implements LocationListener {
        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        C19441() {
        }

        public void onLocationChanged(Location location) {
            ((RCTDeviceEventEmitter) LocationModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("geolocationDidChange", LocationModule.locationToMap(location));
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            StringBuilder stringBuilder;
            if (i == 0) {
                i = LocationModule.this;
                bundle = PositionError.POSITION_UNAVAILABLE;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Provider ");
                stringBuilder.append(str);
                stringBuilder.append(" is out of service.");
                i.emitError(bundle, stringBuilder.toString());
            } else if (i == 1) {
                i = LocationModule.this;
                bundle = PositionError.TIMEOUT;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Provider ");
                stringBuilder.append(str);
                stringBuilder.append(" is temporarily unavailable.");
                i.emitError(bundle, stringBuilder.toString());
            }
        }
    }

    private static class LocationOptions {
        private final float distanceFilter;
        private final boolean highAccuracy;
        private final double maximumAge;
        private final long timeout;

        private LocationOptions(long j, double d, boolean z, float f) {
            this.timeout = j;
            this.maximumAge = d;
            this.highAccuracy = z;
            this.distanceFilter = f;
        }

        private static LocationOptions fromReactMap(ReadableMap readableMap) {
            long j = readableMap.hasKey("timeout") ? (long) readableMap.getDouble("timeout") : Clock.MAX_TIME;
            double d = readableMap.hasKey("maximumAge") ? readableMap.getDouble("maximumAge") : Double.POSITIVE_INFINITY;
            boolean z = readableMap.hasKey("enableHighAccuracy") && readableMap.getBoolean("enableHighAccuracy");
            return new LocationOptions(j, d, z, readableMap.hasKey("distanceFilter") ? (float) readableMap.getDouble("distanceFilter") : LocationModule.RCT_DEFAULT_LOCATION_ACCURACY);
        }
    }

    private static class SingleUpdateRequest {
        private static final int TWO_MINUTES = 120000;
        private final Callback mError;
        private final Handler mHandler;
        private final LocationListener mLocationListener;
        private final LocationManager mLocationManager;
        private Location mOldLocation;
        private final String mProvider;
        private final Callback mSuccess;
        private final long mTimeout;
        private final Runnable mTimeoutRunnable;
        private boolean mTriggered;

        /* renamed from: com.facebook.react.modules.location.LocationModule$SingleUpdateRequest$1 */
        class C19451 implements Runnable {
            C19451() {
            }

            public void run() {
                synchronized (SingleUpdateRequest.this) {
                    if (!SingleUpdateRequest.this.mTriggered) {
                        SingleUpdateRequest.this.mError.invoke(PositionError.buildError(PositionError.TIMEOUT, "Location request timed out"));
                        SingleUpdateRequest.this.mLocationManager.removeUpdates(SingleUpdateRequest.this.mLocationListener);
                        FLog.m5686i(ReactConstants.TAG, "LocationModule: Location request timed out");
                        SingleUpdateRequest.this.mTriggered = true;
                    }
                }
            }
        }

        /* renamed from: com.facebook.react.modules.location.LocationModule$SingleUpdateRequest$2 */
        class C19462 implements LocationListener {
            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            C19462() {
            }

            public void onLocationChanged(Location location) {
                synchronized (SingleUpdateRequest.this) {
                    if (!SingleUpdateRequest.this.mTriggered && SingleUpdateRequest.this.isBetterLocation(location, SingleUpdateRequest.this.mOldLocation)) {
                        SingleUpdateRequest.this.mSuccess.invoke(LocationModule.locationToMap(location));
                        SingleUpdateRequest.this.mHandler.removeCallbacks(SingleUpdateRequest.this.mTimeoutRunnable);
                        SingleUpdateRequest.this.mTriggered = true;
                        SingleUpdateRequest.this.mLocationManager.removeUpdates(SingleUpdateRequest.this.mLocationListener);
                    }
                    SingleUpdateRequest.this.mOldLocation = location;
                }
            }
        }

        private SingleUpdateRequest(LocationManager locationManager, String str, long j, Callback callback, Callback callback2) {
            this.mHandler = new Handler();
            this.mTimeoutRunnable = new C19451();
            this.mLocationListener = new C19462();
            this.mLocationManager = locationManager;
            this.mProvider = str;
            this.mTimeout = j;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public void invoke(Location location) {
            this.mOldLocation = location;
            this.mLocationManager.requestLocationUpdates(this.mProvider, 100, 1.0f, this.mLocationListener);
            this.mHandler.postDelayed(this.mTimeoutRunnable, this.mTimeout);
        }

        private boolean isBetterLocation(Location location, Location location2) {
            if (location2 == null) {
                return true;
            }
            long time = location.getTime() - location2.getTime();
            Object obj = time > 120000 ? 1 : null;
            Object obj2 = time < -120000 ? 1 : null;
            Object obj3 = time > 0 ? 1 : null;
            if (obj != null) {
                return true;
            }
            if (obj2 != null) {
                return false;
            }
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            obj = accuracy > 0 ? 1 : null;
            obj2 = accuracy < 0 ? 1 : null;
            Object obj4 = accuracy > HttpStatus.HTTP_OK ? 1 : null;
            location = isSameProvider(location.getProvider(), location2.getProvider());
            if (obj2 != null) {
                return true;
            }
            if (obj3 != null && obj == null) {
                return true;
            }
            if (obj3 == null || obj4 != null || location == null) {
                return false;
            }
            return true;
        }

        private boolean isSameProvider(String str, String str2) {
            if (str != null) {
                return str.equals(str2);
            }
            return str2 == null ? true : null;
        }
    }

    public String getName() {
        return "LocationObserver";
    }

    public LocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getCurrentPosition(ReadableMap readableMap, Callback callback, Callback callback2) {
        readableMap = LocationOptions.fromReactMap(readableMap);
        try {
            LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService(PlaceFields.LOCATION);
            String validProvider = getValidProvider(locationManager, readableMap.highAccuracy);
            if (validProvider == null) {
                callback2.invoke(new Object[]{PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "No location provider available.")});
                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(validProvider);
            if (lastKnownLocation == null || ((double) (SystemClock.currentTimeMillis() - lastKnownLocation.getTime())) >= readableMap.maximumAge) {
                new SingleUpdateRequest(locationManager, validProvider, readableMap.timeout, callback, callback2).invoke(lastKnownLocation);
                return;
            }
            callback.invoke(new Object[]{locationToMap(lastKnownLocation)});
        } catch (ReadableMap readableMap2) {
            throwLocationPermissionMissing(readableMap2);
        }
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if (!"gps".equals(this.mWatchedProvider)) {
            readableMap = LocationOptions.fromReactMap(readableMap);
            try {
                LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService(PlaceFields.LOCATION);
                String validProvider = getValidProvider(locationManager, readableMap.highAccuracy);
                if (validProvider == null) {
                    emitError(PositionError.POSITION_UNAVAILABLE, "No location provider available.");
                    return;
                }
                if (!validProvider.equals(this.mWatchedProvider)) {
                    locationManager.removeUpdates(this.mLocationListener);
                    locationManager.requestLocationUpdates(validProvider, 1000, readableMap.distanceFilter, this.mLocationListener);
                }
                this.mWatchedProvider = validProvider;
            } catch (ReadableMap readableMap2) {
                throwLocationPermissionMissing(readableMap2);
            }
        }
    }

    @ReactMethod
    public void stopObserving() {
        ((LocationManager) getReactApplicationContext().getSystemService(PlaceFields.LOCATION)).removeUpdates(this.mLocationListener);
        this.mWatchedProvider = null;
    }

    private static String getValidProvider(LocationManager locationManager, boolean z) {
        z = z ? "gps" : "network";
        if (!locationManager.isProviderEnabled(z)) {
            z = z.equals("gps") ? "network" : "gps";
            if (locationManager.isProviderEnabled(z) == null) {
                return null;
            }
        }
        return z;
    }

    private static WritableMap locationToMap(Location location) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("latitude", location.getLatitude());
        createMap2.putDouble("longitude", location.getLongitude());
        createMap2.putDouble("altitude", location.getAltitude());
        createMap2.putDouble("accuracy", (double) location.getAccuracy());
        createMap2.putDouble("heading", (double) location.getBearing());
        createMap2.putDouble("speed", (double) location.getSpeed());
        createMap.putMap("coords", createMap2);
        createMap.putDouble("timestamp", (double) location.getTime());
        if (VERSION.SDK_INT >= 18) {
            createMap.putBoolean("mocked", location.isFromMockProvider());
        }
        return createMap;
    }

    private void emitError(int i, String str) {
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(i, str));
    }

    private static void throwLocationPermissionMissing(SecurityException securityException) {
        throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", securityException);
    }
}
