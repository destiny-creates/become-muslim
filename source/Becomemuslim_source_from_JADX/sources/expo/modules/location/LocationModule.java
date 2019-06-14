package expo.modules.location;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import expo.modules.location.taskConsumers.GeofencingTaskConsumer;
import expo.modules.location.taskConsumers.LocationTaskConsumer;
import expo.modules.location.utils.TimeoutObject;
import expo.modules.location.utils.TimeoutObject.TimeoutListener;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p315h.C6033a;
import expo.p307b.p315h.C6033a.C6032b;
import expo.p307b.p317j.C6041e;
import io.nlopez.smartlocation.C6542b;
import io.nlopez.smartlocation.C6544d;
import io.nlopez.smartlocation.C6545e;
import io.nlopez.smartlocation.C6550f;
import io.nlopez.smartlocation.C6550f.C6549c;
import io.nlopez.smartlocation.geocoding.p365a.C6552a;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p359a.p362c.C6531a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationModule extends C6006c implements SensorEventListener, C6000g, C6001h {
    public static final int ACCURACY_BALANCED = 3;
    public static final int ACCURACY_BEST_FOR_NAVIGATION = 6;
    public static final int ACCURACY_HIGH = 4;
    public static final int ACCURACY_HIGHEST = 5;
    public static final int ACCURACY_LOW = 2;
    public static final int ACCURACY_LOWEST = 1;
    private static final double DEGREE_DELTA = 0.0355d;
    public static final int GEOFENCING_EVENT_ENTER = 1;
    public static final int GEOFENCING_EVENT_EXIT = 2;
    public static final int GEOFENCING_REGION_STATE_INSIDE = 1;
    public static final int GEOFENCING_REGION_STATE_OUTSIDE = 2;
    public static final int GEOFENCING_REGION_STATE_UNKNOWN = 0;
    private static final String TAG = "LocationModule";
    private static final float TIME_DELTA = 50.0f;
    private int mAccuracy = 0;
    private Context mContext;
    private C5991a mEventEmitter;
    private boolean mGeocoderPaused = false;
    private GeomagneticField mGeofield;
    private float[] mGeomagnetic;
    private float[] mGravity;
    private int mHeadingId;
    private float mLastAzimut = 0.0f;
    private long mLastUpdate = 0;
    private C6526b mLocationParams;
    private C6544d mOnLocationUpdatedListener;
    private C6033a mPermissions;
    private SensorManager mSensorManager;
    private C6041e mTaskManager;
    private C5993b mUIManager;

    /* renamed from: expo.modules.location.LocationModule$3 */
    class C74193 implements C6544d {
        C74193() {
        }

        public void onLocationUpdated(Location location) {
            LocationModule.this.mGeofield = new GeomagneticField((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), System.currentTimeMillis());
        }
    }

    public String getName() {
        return "ExpoLocation";
    }

    public LocationModule(Context context) {
        super(context);
        this.mContext = context;
    }

    public void setModuleRegistry(C6007d c6007d) {
        if (this.mUIManager != null) {
            this.mUIManager.unregisterLifecycleEventListener(this);
        }
        this.mEventEmitter = (C5991a) c6007d.m25133a(C5991a.class);
        this.mUIManager = (C5993b) c6007d.m25133a(C5993b.class);
        this.mPermissions = (C6033a) c6007d.m25133a(C6033a.class);
        this.mTaskManager = (C6041e) c6007d.m25133a(C6041e.class);
        if (this.mUIManager != null) {
            this.mUIManager.registerLifecycleEventListener(this);
        }
    }

    public static <BundleType extends BaseBundle> BundleType locationToBundle(Location location, Class<BundleType> cls) {
        try {
            BaseBundle baseBundle = (BaseBundle) cls.newInstance();
            BaseBundle baseBundle2 = (BaseBundle) cls.newInstance();
            baseBundle2.putDouble("latitude", location.getLatitude());
            baseBundle2.putDouble("longitude", location.getLongitude());
            baseBundle2.putDouble("altitude", location.getAltitude());
            baseBundle2.putDouble("accuracy", (double) location.getAccuracy());
            baseBundle2.putDouble("heading", (double) location.getBearing());
            baseBundle2.putDouble("speed", (double) location.getSpeed());
            if (baseBundle instanceof PersistableBundle) {
                ((PersistableBundle) baseBundle).putPersistableBundle("coords", (PersistableBundle) baseBundle2);
            } else if (baseBundle instanceof Bundle) {
                ((Bundle) baseBundle).putBundle("coords", (Bundle) baseBundle2);
                ((Bundle) baseBundle).putBoolean("mocked", location.isFromMockProvider());
            }
            baseBundle.putDouble("timestamp", (double) location.getTime());
            return baseBundle;
        } catch (Location location2) {
            cls = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected exception was thrown when converting location to the bundle: ");
            stringBuilder.append(location2.toString());
            Log.e(cls, stringBuilder.toString());
            return null;
        }
    }

    private static Bundle addressToMap(Address address) {
        Bundle bundle = new Bundle();
        bundle.putString("city", address.getLocality());
        bundle.putString("street", address.getThoroughfare());
        bundle.putString("region", address.getAdminArea());
        bundle.putString(UserDataStore.COUNTRY, address.getCountryName());
        bundle.putString("postalCode", address.getPostalCode());
        bundle.putString("name", address.getFeatureName());
        bundle.putString("isoCountryCode", address.getCountryCode());
        return bundle;
    }

    private boolean isMissingPermissions() {
        if (this.mPermissions != null) {
            if (this.mPermissions.getPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || this.mPermissions.getPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return false;
            }
        }
        return true;
    }

    @C5996c
    public void getCurrentPositionAsync(Map<String, Object> map, final C6009f c6009f) {
        Long valueOf = map.containsKey("timeout") ? Long.valueOf(((Double) map.get("timeout")).longValue()) : null;
        C6549c a = C6550f.m26737a(this.mContext).m26741a().m26730a().m26731a(LocationHelpers.mapOptionsToLocationParams(map));
        if (!a.m26733b().m26698b()) {
            c6009f.m25152a("E_LOCATION_SERVICES_DISABLED", "Location services are disabled");
        } else if (isMissingPermissions()) {
            c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services");
        } else {
            if (map.containsKey("maximumAge")) {
                double doubleValue = ((Double) map.get("maximumAge")).doubleValue();
                map = a.m26734c();
                if (map != null && ((double) (System.currentTimeMillis() - map.getTime())) < doubleValue) {
                    c6009f.mo5137a(locationToBundle(map, Bundle.class));
                    return;
                }
            }
            map = new TimeoutObject(valueOf);
            map.onTimeout(new TimeoutListener() {
                public void onTimeout() {
                    c6009f.m25152a("E_LOCATION_TIMEOUT", "Location request timed out.");
                }
            });
            map.start();
            a.m26732a(new C6544d() {
                public void onLocationUpdated(Location location) {
                    if (map.markDoneIfNotTimedOut()) {
                        c6009f.mo5137a(LocationModule.locationToBundle(location, Bundle.class));
                    }
                }
            });
        }
    }

    private boolean startWatching() {
        if (this.mContext == null) {
            return false;
        }
        if (!isMissingPermissions()) {
            this.mGeocoderPaused = false;
        }
        if (this.mLocationParams != null) {
            if (this.mOnLocationUpdatedListener != null) {
                C6549c a = C6550f.m26737a(this.mContext).m26741a().m26731a(this.mLocationParams);
                if (!a.m26733b().m26698b()) {
                    return false;
                }
                a.m26732a(this.mOnLocationUpdatedListener);
                return true;
            }
        }
        return false;
    }

    private void stopWatching() {
        if (this.mContext != null) {
            if (Geocoder.isPresent() && !isMissingPermissions()) {
                C6550f.m26737a(this.mContext).m26743b().m26724a();
                this.mGeocoderPaused = true;
            }
            if (this.mLocationParams == null || this.mOnLocationUpdatedListener == null) {
                C6550f.m26737a(this.mContext).m26741a().m26735d();
            }
        }
    }

    @C5996c
    public void getProviderStatusAsync(C6009f c6009f) {
        if (this.mContext == null) {
            c6009f.m25152a("E_CONTEXT_UNAVAILABLE", "Context is not available");
        }
        C6531a b = C6550f.m26737a(this.mContext).m26741a().m26733b();
        Object bundle = new Bundle();
        bundle.putBoolean("locationServicesEnabled", b.m26697a());
        bundle.putBoolean("gpsAvailable", b.m26699c());
        bundle.putBoolean("networkAvailable", b.m26700d());
        bundle.putBoolean("passiveAvailable", b.m26701e());
        c6009f.mo5137a(bundle);
    }

    @C5996c
    public void watchDeviceHeading(int i, C6009f c6009f) {
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mHeadingId = i;
        startHeadingUpdate();
        c6009f.mo5137a((Object) 0);
    }

    public void startHeadingUpdate() {
        if (this.mSensorManager != null) {
            if (this.mContext != null) {
                C6549c a = C6550f.m26737a(this.mContext).m26741a().m26730a().m26731a(C6526b.f21034b);
                Location c = a.m26734c();
                if (c != null) {
                    this.mGeofield = new GeomagneticField((float) c.getLatitude(), (float) c.getLongitude(), (float) c.getAltitude(), System.currentTimeMillis());
                } else {
                    a.m26732a(new C74193());
                }
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(2), 3);
                this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(1), 3);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.mGravity = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.mGeomagnetic = sensorEvent.values;
        }
        if (this.mGravity != null && this.mGeomagnetic != null) {
            sendUpdate();
        }
    }

    private void sendUpdate() {
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (((double) Math.abs(fArr2[0] - this.mLastAzimut)) > DEGREE_DELTA && ((float) (System.currentTimeMillis() - this.mLastUpdate)) > TIME_DELTA) {
                this.mLastAzimut = fArr2[0];
                this.mLastUpdate = System.currentTimeMillis();
                float calcMagNorth = calcMagNorth(fArr2[0]);
                float calcTrueNorth = calcTrueNorth(calcMagNorth);
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle.putInt("watchId", this.mHeadingId);
                bundle2.putDouble("trueHeading", (double) calcTrueNorth);
                bundle2.putDouble("magHeading", (double) calcMagNorth);
                bundle2.putInt("accuracy", this.mAccuracy);
                bundle.putBundle("heading", bundle2);
                this.mEventEmitter.mo5142a("Exponent.headingChanged", bundle);
            }
        }
    }

    private float calcMagNorth(float f) {
        return (((float) Math.toDegrees((double) f)) + 360.0f) % 360.0f;
    }

    private float calcTrueNorth(float f) {
        if (!isMissingPermissions()) {
            if (this.mGeofield != null) {
                return f + this.mGeofield.getDeclination();
            }
        }
        return -1.0f;
    }

    private void stopHeadingWatch() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
        }
    }

    private void destroyHeadingWatch() {
        stopHeadingWatch();
        this.mSensorManager = null;
        this.mGravity = null;
        this.mGeomagnetic = null;
        this.mGeofield = null;
        this.mHeadingId = 0;
        this.mLastAzimut = 0.0f;
        this.mAccuracy = 0;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        this.mAccuracy = i;
    }

    @C5996c
    public void watchPositionImplAsync(final int i, Map<String, Object> map, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services");
            return;
        }
        this.mLocationParams = LocationHelpers.mapOptionsToLocationParams(map);
        this.mOnLocationUpdatedListener = new C6544d() {
            public void onLocationUpdated(Location location) {
                Bundle bundle = new Bundle();
                bundle.putInt("watchId", i);
                bundle.putBundle(PlaceFields.LOCATION, (Bundle) LocationModule.locationToBundle(location, Bundle.class));
                LocationModule.this.mEventEmitter.mo5142a("Exponent.locationChanged", bundle);
            }
        };
        if (startWatching() != 0) {
            c6009f.mo5137a((Object) 0);
        } else {
            c6009f.m25152a("E_LOCATION_SERVICES_DISABLED", "Location services are disabled");
        }
    }

    @C5996c
    public void removeWatchAsync(int i, C6009f c6009f) {
        if (isMissingPermissions()) {
            c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services");
            return;
        }
        if (i == this.mHeadingId) {
            destroyHeadingWatch();
        } else {
            stopWatching();
            this.mLocationParams = null;
            this.mOnLocationUpdatedListener = null;
        }
        c6009f.mo5137a(null);
    }

    @C5996c
    public void geocodeAsync(String str, final C6009f c6009f) {
        if (this.mGeocoderPaused) {
            c6009f.m25152a("E_CANNOT_GEOCODE", "Geocoder is not running.");
        } else if (isMissingPermissions()) {
            c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services.");
        } else {
            if (Geocoder.isPresent()) {
                C6550f.m26737a(this.mContext).m26743b().m26729a(str, new C6542b() {
                    public void onLocationResolved(String str, List<C6552a> list) {
                        Object arrayList = new ArrayList(list.size());
                        for (C6552a c6552a : list) {
                            Bundle bundle = new Bundle();
                            Location a = c6552a.m26746a();
                            bundle.putDouble("latitude", a.getLatitude());
                            bundle.putDouble("longitude", a.getLongitude());
                            bundle.putDouble("altitude", a.getAltitude());
                            bundle.putDouble("accuracy", (double) a.getAccuracy());
                            arrayList.add(bundle);
                        }
                        C6550f.m26737a(LocationModule.this.mContext).m26743b().m26724a();
                        c6009f.mo5137a(arrayList);
                    }
                });
            } else {
                c6009f.m25152a("E_NO_GEOCODER", "Geocoder service is not available for this device.");
            }
        }
    }

    @C5996c
    public void reverseGeocodeAsync(Map<String, Object> map, final C6009f c6009f) {
        if (this.mGeocoderPaused) {
            c6009f.m25152a("E_CANNOT_GEOCODE", "Geocoder is not running.");
        } else if (isMissingPermissions()) {
            c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services.");
        } else {
            Location location = new Location("");
            location.setLatitude(((Double) map.get("latitude")).doubleValue());
            location.setLongitude(((Double) map.get("longitude")).doubleValue());
            if (Geocoder.isPresent() != null) {
                C6550f.m26737a(this.mContext).m26743b().m26725a(location, new C6545e() {
                    public void onAddressResolved(Location location, List<Address> list) {
                        Object arrayList = new ArrayList(list.size());
                        for (Address access$300 : list) {
                            arrayList.add(LocationModule.addressToMap(access$300));
                        }
                        C6550f.m26737a(LocationModule.this.mContext).m26743b().m26724a();
                        c6009f.mo5137a(arrayList);
                    }
                });
            } else {
                c6009f.m25152a("E_NO_GEOCODER", "Geocoder service is not available for this device.");
            }
        }
    }

    @C5996c
    public void requestPermissionsAsync(final C6009f c6009f) {
        if (this.mPermissions == null) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            this.mPermissions.askForPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new C6032b() {
                public void onPermissionsResult(int[] iArr) {
                    for (int i : iArr) {
                        if (i == 0) {
                            c6009f.mo5137a(null);
                            return;
                        }
                    }
                    c6009f.m25152a("E_LOCATION_UNAUTHORIZED", "Not authorized to use location services");
                }
            });
        }
    }

    @C5996c
    public void hasServicesEnabledAsync(C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(LocationHelpers.isAnyProviderAvailable(getContext())));
    }

    @C5996c
    public void startLocationUpdatesAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            this.mTaskManager.registerTask(str, LocationTaskConsumer.class, map);
            c6009f.mo5137a((Object) null);
        } catch (Throwable e) {
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void stopLocationUpdatesAsync(String str, C6009f c6009f) {
        try {
            this.mTaskManager.unregisterTask(str, LocationTaskConsumer.class);
            c6009f.mo5137a((Object) null);
        } catch (Throwable e) {
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void hasStartedLocationUpdatesAsync(String str, C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(this.mTaskManager.taskHasConsumerOfClass(str, LocationTaskConsumer.class)));
    }

    @C5996c
    public void startGeofencingAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            this.mTaskManager.registerTask(str, GeofencingTaskConsumer.class, map);
            c6009f.mo5137a((Object) null);
        } catch (Throwable e) {
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void stopGeofencingAsync(String str, C6009f c6009f) {
        try {
            this.mTaskManager.unregisterTask(str, GeofencingTaskConsumer.class);
            c6009f.mo5137a((Object) null);
        } catch (Throwable e) {
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void hasStartedGeofencingAsync(String str, C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(this.mTaskManager.taskHasConsumerOfClass(str, GeofencingTaskConsumer.class)));
    }

    public void onHostResume() {
        startWatching();
        startHeadingUpdate();
    }

    public void onHostPause() {
        stopWatching();
        stopHeadingWatch();
    }

    public void onHostDestroy() {
        stopWatching();
        stopHeadingWatch();
    }
}
