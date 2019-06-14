package versioned.host.exp.exponent.modules.api.components.maps;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.C7850k;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;

public class AirMapManager extends ViewGroupManager<AirMapView> {
    private static final int ANIMATE_TO_BEARING = 4;
    private static final int ANIMATE_TO_COORDINATE = 2;
    private static final int ANIMATE_TO_NAVIGATION = 9;
    private static final int ANIMATE_TO_REGION = 1;
    private static final int ANIMATE_TO_VIEWING_ANGLE = 3;
    private static final int FIT_TO_COORDINATES = 7;
    private static final int FIT_TO_ELEMENTS = 5;
    private static final int FIT_TO_SUPPLIED_MARKERS = 6;
    private static final String REACT_CLASS = "AIRMap";
    private static final int SET_INDOOR_ACTIVE_LEVEL_INDEX = 10;
    private static final int SET_MAP_BOUNDARIES = 8;
    private final Map<String, Integer> MAP_TYPES = MapBuilder.of("standard", Integer.valueOf(1), "satellite", Integer.valueOf(2), HybridAESEncrypter.NAME, Integer.valueOf(4), "terrain", Integer.valueOf(3), ViewProps.NONE, Integer.valueOf(0));
    private final ReactApplicationContext appContext;
    protected GoogleMapOptions googleMapOptions;

    public String getName() {
        return REACT_CLASS;
    }

    public AirMapManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
        this.googleMapOptions = new GoogleMapOptions();
    }

    protected AirMapView createViewInstance(ThemedReactContext themedReactContext) {
        return new AirMapView(themedReactContext, this.appContext, this, this.googleMapOptions);
    }

    private void emitMapError(ThemedReactContext themedReactContext, String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        createMap.putString("type", str2);
        ((RCTDeviceEventEmitter) themedReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("onError", createMap);
    }

    @ReactProp(name = "region")
    public void setRegion(AirMapView airMapView, ReadableMap readableMap) {
        airMapView.setRegion(readableMap);
    }

    @ReactProp(name = "initialRegion")
    public void setInitialRegion(AirMapView airMapView, ReadableMap readableMap) {
        airMapView.setInitialRegion(readableMap);
    }

    @ReactProp(name = "mapType")
    public void setMapType(AirMapView airMapView, String str) {
        airMapView.map.m21707a(((Integer) this.MAP_TYPES.get(str)).intValue());
    }

    @ReactProp(name = "customMapStyleString")
    public void setMapStyle(AirMapView airMapView, String str) {
        airMapView.map.m21730a(new C7850k(str));
    }

    @ReactProp(name = "mapPadding")
    public void setMapPadding(AirMapView airMapView, ReadableMap readableMap) {
        int i;
        int i2;
        int i3;
        double d = (double) airMapView.getResources().getDisplayMetrics().density;
        int i4 = 0;
        if (readableMap != null) {
            i = readableMap.hasKey(ViewProps.LEFT) ? (int) (readableMap.getDouble(ViewProps.LEFT) * d) : 0;
            i2 = readableMap.hasKey(ViewProps.TOP) ? (int) (readableMap.getDouble(ViewProps.TOP) * d) : 0;
            i3 = readableMap.hasKey(ViewProps.RIGHT) ? (int) (readableMap.getDouble(ViewProps.RIGHT) * d) : 0;
            if (readableMap.hasKey(ViewProps.BOTTOM)) {
                i4 = (int) (readableMap.getDouble(ViewProps.BOTTOM) * d);
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        airMapView.map.m21708a(i, i2, i3, i4);
    }

    @ReactProp(defaultBoolean = false, name = "showsUserLocation")
    public void setShowsUserLocation(AirMapView airMapView, boolean z) {
        airMapView.setShowsUserLocation(z);
    }

    @ReactProp(defaultBoolean = true, name = "showsMyLocationButton")
    public void setShowsMyLocationButton(AirMapView airMapView, boolean z) {
        airMapView.setShowsMyLocationButton(z);
    }

    @ReactProp(defaultBoolean = true, name = "toolbarEnabled")
    public void setToolbarEnabled(AirMapView airMapView, boolean z) {
        airMapView.setToolbarEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "handlePanDrag")
    public void setHandlePanDrag(AirMapView airMapView, boolean z) {
        airMapView.setHandlePanDrag(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsTraffic")
    public void setShowTraffic(AirMapView airMapView, boolean z) {
        airMapView.map.m21729a(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsBuildings")
    public void setShowBuildings(AirMapView airMapView, boolean z) {
        airMapView.map.m21736c(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoors")
    public void setShowIndoors(AirMapView airMapView, boolean z) {
        airMapView.map.m21734b(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoorLevelPicker")
    public void setShowsIndoorLevelPicker(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21747d(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsCompass")
    public void setShowsCompass(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21745b(z);
    }

    @ReactProp(defaultBoolean = false, name = "scrollEnabled")
    public void setScrollEnabled(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21748e(z);
    }

    @ReactProp(defaultBoolean = false, name = "zoomEnabled")
    public void setZoomEnabled(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21749f(z);
    }

    @ReactProp(defaultBoolean = true, name = "zoomControlEnabled")
    public void setZoomControlEnabled(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21743a(z);
    }

    @ReactProp(defaultBoolean = false, name = "rotateEnabled")
    public void setRotateEnabled(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21751h(z);
    }

    @ReactProp(defaultBoolean = false, name = "cacheEnabled")
    public void setCacheEnabled(AirMapView airMapView, boolean z) {
        airMapView.setCacheEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "loadingEnabled")
    public void setLoadingEnabled(AirMapView airMapView, boolean z) {
        airMapView.enableMapLoading(z);
    }

    @ReactProp(defaultBoolean = true, name = "moveOnMarkerPress")
    public void setMoveOnMarkerPress(AirMapView airMapView, boolean z) {
        airMapView.setMoveOnMarkerPress(z);
    }

    @ReactProp(customType = "Color", name = "loadingBackgroundColor")
    public void setLoadingBackgroundColor(AirMapView airMapView, Integer num) {
        airMapView.setLoadingBackgroundColor(num);
    }

    @ReactProp(customType = "Color", name = "loadingIndicatorColor")
    public void setLoadingIndicatorColor(AirMapView airMapView, Integer num) {
        airMapView.setLoadingIndicatorColor(num);
    }

    @ReactProp(defaultBoolean = false, name = "pitchEnabled")
    public void setPitchEnabled(AirMapView airMapView, boolean z) {
        airMapView.map.m21735c().m21750g(z);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(AirMapView airMapView, float f) {
        airMapView.map.m21706a(f);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(AirMapView airMapView, float f) {
        airMapView.map.m21732b(f);
    }

    @ReactProp(name = "kmlSrc")
    public void setKmlSrc(AirMapView airMapView, String str) {
        if (str != null) {
            airMapView.setKmlSrc(str);
        }
    }

    public void receiveCommand(AirMapView airMapView, int i, ReadableArray readableArray) {
        AirMapView airMapView2 = airMapView;
        ReadableArray readableArray2 = readableArray;
        ReadableMap map;
        Integer valueOf;
        switch (i) {
            case 1:
                map = readableArray2.getMap(0);
                valueOf = Integer.valueOf(readableArray2.getInt(1));
                Double valueOf2 = Double.valueOf(map.getDouble("longitude"));
                Double valueOf3 = Double.valueOf(map.getDouble("latitude"));
                Double valueOf4 = Double.valueOf(map.getDouble("longitudeDelta"));
                Double valueOf5 = Double.valueOf(map.getDouble("latitudeDelta"));
                airMapView2.animateToRegion(new LatLngBounds(new LatLng(valueOf3.doubleValue() - (valueOf5.doubleValue() / 2.0d), valueOf2.doubleValue() - (valueOf4.doubleValue() / 2.0d)), new LatLng(valueOf3.doubleValue() + (valueOf5.doubleValue() / 2.0d), valueOf2.doubleValue() + (valueOf4.doubleValue() / 2.0d))), valueOf.intValue());
                return;
            case 2:
                map = readableArray2.getMap(0);
                valueOf = Integer.valueOf(readableArray2.getInt(1));
                airMapView2.animateToCoordinate(new LatLng(Double.valueOf(map.getDouble("latitude")).doubleValue(), Double.valueOf(map.getDouble("longitude")).doubleValue()), valueOf.intValue());
                return;
            case 3:
                airMapView2.animateToViewingAngle((float) readableArray2.getDouble(0), Integer.valueOf(readableArray2.getInt(1)).intValue());
                return;
            case 4:
                airMapView2.animateToBearing((float) readableArray2.getDouble(0), Integer.valueOf(readableArray2.getInt(1)).intValue());
                return;
            case 5:
                airMapView2.fitToElements(readableArray2.getBoolean(0));
                return;
            case 6:
                airMapView2.fitToSuppliedMarkers(readableArray2.getArray(0), readableArray2.getMap(1), readableArray2.getBoolean(2));
                return;
            case 7:
                airMapView2.fitToCoordinates(readableArray2.getArray(0), readableArray2.getMap(1), readableArray2.getBoolean(2));
                return;
            case 8:
                airMapView2.setMapBoundaries(readableArray2.getMap(0), readableArray2.getMap(1));
                return;
            case 9:
                ReadableMap map2 = readableArray2.getMap(0);
                airMapView2.animateToNavigation(new LatLng(Double.valueOf(map2.getDouble("latitude")).doubleValue(), Double.valueOf(map2.getDouble("longitude")).doubleValue()), (float) readableArray2.getDouble(1), (float) readableArray2.getDouble(2), Integer.valueOf(readableArray2.getInt(3)).intValue());
                return;
            case 10:
                airMapView2.setIndoorActiveLevelIndex(readableArray2.getInt(0));
                return;
            default:
                return;
        }
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map of = MapBuilder.of("onMapReady", MapBuilder.of("registrationName", "onMapReady"), "onPress", MapBuilder.of("registrationName", "onPress"), "onLongPress", MapBuilder.of("registrationName", "onLongPress"), "onMarkerPress", MapBuilder.of("registrationName", "onMarkerPress"), "onMarkerSelect", MapBuilder.of("registrationName", "onMarkerSelect"), "onMarkerDeselect", MapBuilder.of("registrationName", "onMarkerDeselect"), "onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress"));
        of.putAll(MapBuilder.of("onUserLocationChange", MapBuilder.of("registrationName", "onUserLocationChange"), "onMarkerDragStart", MapBuilder.of("registrationName", "onMarkerDragStart"), "onMarkerDrag", MapBuilder.of("registrationName", "onMarkerDrag"), "onMarkerDragEnd", MapBuilder.of("registrationName", "onMarkerDragEnd"), "onPanDrag", MapBuilder.of("registrationName", "onPanDrag"), "onKmlReady", MapBuilder.of("registrationName", "onKmlReady"), "onPoiClick", MapBuilder.of("registrationName", "onPoiClick")));
        of.putAll(MapBuilder.of("onIndoorLevelActivated", MapBuilder.of("registrationName", "onIndoorLevelActivated"), "onIndoorBuildingFocused", MapBuilder.of("registrationName", "onIndoorBuildingFocused")));
        return of;
    }

    public Map<String, Integer> getCommandsMap() {
        Map<String, Integer> CreateMap = CreateMap("animateToRegion", Integer.valueOf(1), "animateToCoordinate", Integer.valueOf(2), "animateToViewingAngle", Integer.valueOf(3), "animateToBearing", Integer.valueOf(4), "fitToElements", Integer.valueOf(5), "fitToSuppliedMarkers", Integer.valueOf(6), "fitToCoordinates", Integer.valueOf(7), "animateToNavigation", Integer.valueOf(9));
        CreateMap.putAll(MapBuilder.of("setMapBoundaries", Integer.valueOf(8), "setIndoorActiveLevelIndex", Integer.valueOf(10)));
        return CreateMap;
    }

    public static <K, V> Map<K, V> CreateMap(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        Map<K, V> hashMap = new HashMap();
        K k9 = k;
        V v9 = v;
        hashMap.put(k, v);
        k9 = k2;
        v9 = v2;
        hashMap.put(k2, v2);
        k9 = k3;
        v9 = v3;
        hashMap.put(k3, v3);
        k9 = k4;
        v9 = v4;
        hashMap.put(k4, v4);
        k9 = k5;
        v9 = v5;
        hashMap.put(k5, v5);
        k9 = k6;
        v9 = v6;
        hashMap.put(k6, v6);
        k9 = k7;
        hashMap.put(k7, v7);
        hashMap.put(k8, v8);
        return hashMap;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    public void addView(AirMapView airMapView, View view, int i) {
        airMapView.addFeature(view, i);
    }

    public int getChildCount(AirMapView airMapView) {
        return airMapView.getFeatureCount();
    }

    public View getChildAt(AirMapView airMapView, int i) {
        return airMapView.getFeatureAt(i);
    }

    public void removeViewAt(AirMapView airMapView, int i) {
        airMapView.removeFeatureAt(i);
    }

    public void updateExtraData(AirMapView airMapView, Object obj) {
        airMapView.updateExtraData(obj);
    }

    void pushEvent(ThemedReactContext themedReactContext, View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), str, writableMap);
    }

    public void onDropViewInstance(AirMapView airMapView) {
        airMapView.doDestroy();
        super.onDropViewInstance(airMapView);
    }
}
