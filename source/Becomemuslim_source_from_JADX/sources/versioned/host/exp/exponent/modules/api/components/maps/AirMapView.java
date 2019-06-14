package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.v4.content.C0382f;
import android.support.v4.view.C0500d;
import android.support.v4.view.C0507i;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.C5106a;
import com.google.android.gms.maps.C5107b;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.C5125c.C5109b;
import com.google.android.gms.maps.C5125c.C5110c;
import com.google.android.gms.maps.C5125c.C5111d;
import com.google.android.gms.maps.C5125c.C5112e;
import com.google.android.gms.maps.C5125c.C5113f;
import com.google.android.gms.maps.C5125c.C5114g;
import com.google.android.gms.maps.C5125c.C5115h;
import com.google.android.gms.maps.C5125c.C5116i;
import com.google.android.gms.maps.C5125c.C5117j;
import com.google.android.gms.maps.C5125c.C5118k;
import com.google.android.gms.maps.C5125c.C5119l;
import com.google.android.gms.maps.C5125c.C5120m;
import com.google.android.gms.maps.C5125c.C5121n;
import com.google.android.gms.maps.C5125c.C5122o;
import com.google.android.gms.maps.C5125c.C5123p;
import com.google.android.gms.maps.C5125c.C5124q;
import com.google.android.gms.maps.C5126d;
import com.google.android.gms.maps.C5128f;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C5141i;
import com.google.android.gms.maps.model.C5142j;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.model.C5144p;
import com.google.android.gms.maps.model.C5145r;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7853o;
import com.google.android.gms.maps.model.CameraPosition.C5134a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBounds.C5135a;
import com.google.maps.android.p247a.p249b.C5384b;
import com.google.maps.android.p247a.p249b.C6922f;
import com.google.maps.android.p247a.p249b.C6923j;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AirMapView extends C5126d implements C5109b, C5113f, C5119l, C5121n, C5128f {
    private static final String[] PERMISSIONS = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private ViewAttacherGroup attacherGroup;
    private final int baseMapPadding = 50;
    private LatLngBounds boundsToMove;
    private boolean cacheEnabled = false;
    private ImageView cacheImageView;
    private LatLngBounds cameraLastIdleBounds;
    private int cameraMoveReason = 0;
    private final ThemedReactContext context;
    private boolean destroyed = false;
    private final EventDispatcher eventDispatcher;
    private final List<AirMapFeature> features = new ArrayList();
    private final C0500d gestureDetector;
    private boolean handlePanDrag = false;
    private boolean initialRegionSet = false;
    private Boolean isMapLoaded = Boolean.valueOf(false);
    private C6922f kmlLayer;
    private LifecycleEventListener lifecycleListener;
    private Integer loadingBackgroundColor = null;
    private Integer loadingIndicatorColor = null;
    private final AirMapManager manager;
    public C5125c map;
    private RelativeLayout mapLoadingLayout;
    private ProgressBar mapLoadingProgressBar;
    private final Map<C5143l, AirMapMarker> markerMap = new HashMap();
    private boolean moveOnMarkerPress = true;
    private boolean paused = false;
    private final Map<C5144p, AirMapPolygon> polygonMap = new HashMap();
    private final Map<C5145r, AirMapPolyline> polylineMap = new HashMap();
    private boolean showUserLocation = false;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapView$1 */
    class C67411 extends SimpleOnGestureListener {
        C67411() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (AirMapView.this.handlePanDrag != null) {
                AirMapView.this.onPanDrag(motionEvent2);
            }
            return null;
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapView$2 */
    class C67422 implements OnLayoutChangeListener {
        C67422() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (AirMapView.this.paused == null) {
                AirMapView.this.cacheView();
            }
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapView$5 */
    class C77785 implements C5122o {
        C77785() {
        }

        public void onPolygonClick(C5144p c5144p) {
            WritableMap makeClickEventData = AirMapView.this.makeClickEventData((LatLng) c5144p.m21811b().get(0));
            makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "polygon-press");
            AirMapView.this.manager.pushEvent(AirMapView.this.context, (View) AirMapView.this.polygonMap.get(c5144p), "onPress", makeClickEventData);
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapView$6 */
    class C77796 implements C5123p {
        C77796() {
        }

        public void onPolylineClick(C5145r c5145r) {
            WritableMap makeClickEventData = AirMapView.this.makeClickEventData((LatLng) c5145r.m21823b().get(0));
            makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "polyline-press");
            AirMapView.this.manager.pushEvent(AirMapView.this.context, (View) AirMapView.this.polylineMap.get(c5145r), "onPress", makeClickEventData);
        }
    }

    private static boolean contextHasBug(Context context) {
        if (!(context == null || context.getResources() == null)) {
            if (context.getResources().getConfiguration() != null) {
                return null;
            }
        }
        return true;
    }

    private static Context getNonBuggyContext(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext) {
        if (!contextHasBug(reactApplicationContext.getCurrentActivity())) {
            return reactApplicationContext.getCurrentActivity();
        }
        if (contextHasBug(themedReactContext) == null) {
            return themedReactContext;
        }
        if (contextHasBug(themedReactContext.getCurrentActivity()) == null) {
            return themedReactContext.getCurrentActivity();
        }
        return contextHasBug(themedReactContext.getApplicationContext()) == null ? themedReactContext.getApplicationContext() : themedReactContext;
    }

    public AirMapView(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext, AirMapManager airMapManager, GoogleMapOptions googleMapOptions) {
        super(getNonBuggyContext(themedReactContext, reactApplicationContext), googleMapOptions);
        this.manager = airMapManager;
        this.context = themedReactContext;
        super.onCreate(null);
        super.onResume();
        super.getMapAsync(this);
        this.gestureDetector = new C0500d(themedReactContext, new C67411());
        addOnLayoutChangeListener(new C67422());
        this.eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.attacherGroup = new ViewAttacherGroup(this.context);
        themedReactContext = new LayoutParams(0, 0);
        themedReactContext.width = 0;
        themedReactContext.height = 0;
        themedReactContext.leftMargin = 99999999;
        themedReactContext.topMargin = 99999999;
        this.attacherGroup.setLayoutParams(themedReactContext);
        addView(this.attacherGroup);
    }

    public void onMapReady(final C5125c c5125c) {
        if (!this.destroyed) {
            this.map = c5125c;
            this.map.m21711a((C5109b) this);
            this.map.m21721a((C5119l) this);
            this.map.m21723a((C5121n) this);
            this.map.m21715a((C5113f) this);
            this.manager.pushEvent(this.context, this, "onMapReady", new WritableNativeMap());
            c5125c.m21722a(new C5120m() {
                public void onMyLocationChange(Location location) {
                    WritableMap writableNativeMap = new WritableNativeMap();
                    WritableMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putDouble("latitude", location.getLatitude());
                    writableNativeMap2.putDouble("longitude", location.getLongitude());
                    writableNativeMap2.putDouble("altitude", location.getAltitude());
                    writableNativeMap2.putDouble("timestamp", (double) location.getTime());
                    writableNativeMap2.putDouble("accuracy", (double) location.getAccuracy());
                    writableNativeMap2.putDouble("speed", (double) location.getSpeed());
                    if (VERSION.SDK_INT >= 18) {
                        writableNativeMap2.putBoolean("isFromMockProvider", location.isFromMockProvider());
                    }
                    writableNativeMap.putMap("coordinate", writableNativeMap2);
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, this, "onUserLocationChange", writableNativeMap);
                }
            });
            c5125c.m21720a(new C5118k() {
                public boolean onMarkerClick(C5143l c5143l) {
                    View access$500 = AirMapView.this.getMarkerMap(c5143l);
                    WritableMap makeClickEventData = AirMapView.this.makeClickEventData(c5143l.m21795b());
                    makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "marker-press");
                    makeClickEventData.putString("id", access$500.getIdentifier());
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, this, "onMarkerPress", makeClickEventData);
                    makeClickEventData = AirMapView.this.makeClickEventData(c5143l.m21795b());
                    makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "marker-press");
                    makeClickEventData.putString("id", access$500.getIdentifier());
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, access$500, "onPress", makeClickEventData);
                    if (this.moveOnMarkerPress) {
                        return null;
                    }
                    c5143l.m21804e();
                    return true;
                }
            });
            c5125c.m21724a(new C77785());
            c5125c.m21725a(new C77796());
            c5125c.m21716a(new C5114g() {
                public void onInfoWindowClick(C5143l c5143l) {
                    WritableMap makeClickEventData = AirMapView.this.makeClickEventData(c5143l.m21795b());
                    makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "callout-press");
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, this, "onCalloutPress", makeClickEventData);
                    makeClickEventData = AirMapView.this.makeClickEventData(c5143l.m21795b());
                    makeClickEventData.putString(NativeProtocol.WEB_DIALOG_ACTION, "callout-press");
                    View access$500 = AirMapView.this.getMarkerMap(c5143l);
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, access$500, "onCalloutPress", makeClickEventData);
                    c5143l = AirMapView.this.makeClickEventData(c5143l.m21795b());
                    c5143l.putString(NativeProtocol.WEB_DIALOG_ACTION, "callout-press");
                    View calloutView = access$500.getCalloutView();
                    if (calloutView != null) {
                        AirMapView.this.manager.pushEvent(AirMapView.this.context, calloutView, "onPress", c5143l);
                    }
                }
            });
            c5125c.m21717a(new C5115h() {
                public void onMapClick(LatLng latLng) {
                    latLng = AirMapView.this.makeClickEventData(latLng);
                    latLng.putString(NativeProtocol.WEB_DIALOG_ACTION, "press");
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, this, "onPress", latLng);
                }
            });
            c5125c.m21719a(new C5117j() {
                public void onMapLongClick(LatLng latLng) {
                    AirMapView.this.makeClickEventData(latLng).putString(NativeProtocol.WEB_DIALOG_ACTION, "long-press");
                    AirMapView.this.manager.pushEvent(AirMapView.this.context, this, "onLongPress", AirMapView.this.makeClickEventData(latLng));
                }
            });
            c5125c.m21714a(new C5112e() {
                public void onCameraMoveStarted(int i) {
                    AirMapView.this.cameraMoveReason = i;
                }
            });
            c5125c.m21713a(new C5111d() {
                public void onCameraMove() {
                    LatLngBounds latLngBounds = c5125c.m21737d().m21742a().f29239e;
                    AirMapView.this.cameraLastIdleBounds = null;
                    AirMapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(AirMapView.this.getId(), latLngBounds, true));
                }
            });
            c5125c.m21712a(new C5110c() {
                public void onCameraIdle() {
                    LatLngBounds latLngBounds = c5125c.m21737d().m21742a().f29239e;
                    if (AirMapView.this.cameraMoveReason == 0) {
                        return;
                    }
                    if (AirMapView.this.cameraLastIdleBounds == null || LatLngBoundsUtils.BoundsAreDifferent(latLngBounds, AirMapView.this.cameraLastIdleBounds)) {
                        AirMapView.this.cameraLastIdleBounds = latLngBounds;
                        AirMapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(AirMapView.this.getId(), latLngBounds, false));
                    }
                }
            });
            c5125c.m21718a(new C5116i() {
                public void onMapLoaded() {
                    AirMapView.this.isMapLoaded = Boolean.valueOf(true);
                    AirMapView.this.cacheView();
                }
            });
            this.lifecycleListener = new LifecycleEventListener() {
                public void onHostResume() {
                    if (AirMapView.this.hasPermissions()) {
                        c5125c.m21738d(AirMapView.this.showUserLocation);
                    }
                    synchronized (AirMapView.this) {
                        if (!AirMapView.this.destroyed) {
                            AirMapView.this.onResume();
                        }
                        AirMapView.this.paused = false;
                    }
                }

                public void onHostPause() {
                    if (AirMapView.this.hasPermissions()) {
                        c5125c.m21738d(false);
                    }
                    synchronized (AirMapView.this) {
                        if (!AirMapView.this.destroyed) {
                            AirMapView.this.onPause();
                        }
                        AirMapView.this.paused = true;
                    }
                }

                public void onHostDestroy() {
                    AirMapView.this.doDestroy();
                }
            };
            this.context.addLifecycleEventListener(this.lifecycleListener);
        }
    }

    private boolean hasPermissions() {
        if (C0382f.a(getContext(), PERMISSIONS[0]) == 0) {
            return true;
        }
        if (C0382f.a(getContext(), PERMISSIONS[1]) == 0) {
            return true;
        }
        return false;
    }

    public synchronized void doDestroy() {
        if (!this.destroyed) {
            this.destroyed = true;
            if (!(this.lifecycleListener == null || this.context == null)) {
                this.context.removeLifecycleEventListener(this.lifecycleListener);
                this.lifecycleListener = null;
            }
            if (!this.paused) {
                onPause();
                this.paused = true;
            }
            onDestroy();
        }
    }

    public void setInitialRegion(ReadableMap readableMap) {
        if (!this.initialRegionSet && readableMap != null) {
            setRegion(readableMap);
            this.initialRegionSet = true;
        }
    }

    public void setRegion(ReadableMap readableMap) {
        AirMapView airMapView = this;
        ReadableMap readableMap2 = readableMap;
        if (readableMap2 != null) {
            Double valueOf = Double.valueOf(readableMap2.getDouble("longitude"));
            Double valueOf2 = Double.valueOf(readableMap2.getDouble("latitude"));
            Double valueOf3 = Double.valueOf(readableMap2.getDouble("longitudeDelta"));
            Double valueOf4 = Double.valueOf(readableMap2.getDouble("latitudeDelta"));
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(valueOf2.doubleValue() - (valueOf4.doubleValue() / 2.0d), valueOf.doubleValue() - (valueOf3.doubleValue() / 2.0d)), new LatLng(valueOf2.doubleValue() + (valueOf4.doubleValue() / 2.0d), valueOf.doubleValue() + (valueOf3.doubleValue() / 2.0d)));
            if (super.getHeight() > 0) {
                if (super.getWidth() > 0) {
                    airMapView.map.m21709a(C5107b.m21694a(latLngBounds, 0));
                    airMapView.boundsToMove = null;
                }
            }
            airMapView.map.m21709a(C5107b.m21693a(new LatLng(valueOf2.doubleValue(), valueOf.doubleValue()), 10.0f));
            airMapView.boundsToMove = latLngBounds;
        }
    }

    public void setShowsUserLocation(boolean z) {
        this.showUserLocation = z;
        if (hasPermissions()) {
            this.map.m21738d(z);
        }
    }

    public void setShowsMyLocationButton(boolean z) {
        if (hasPermissions() || !z) {
            this.map.m21735c().m21746c(z);
        }
    }

    public void setToolbarEnabled(boolean z) {
        if (hasPermissions() || !z) {
            this.map.m21735c().m21752i(z);
        }
    }

    public void setCacheEnabled(boolean z) {
        this.cacheEnabled = z;
        cacheView();
    }

    public void enableMapLoading(boolean z) {
        if (z && !this.isMapLoaded.booleanValue()) {
            getMapLoadingLayoutView().setVisibility(0);
        }
    }

    public void setMoveOnMarkerPress(boolean z) {
        this.moveOnMarkerPress = z;
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.loadingBackgroundColor = num;
        if (this.mapLoadingLayout == null) {
            return;
        }
        if (num == null) {
            this.mapLoadingLayout.setBackgroundColor(-1);
        } else {
            this.mapLoadingLayout.setBackgroundColor(this.loadingBackgroundColor.intValue());
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.loadingIndicatorColor = num;
        if (this.mapLoadingProgressBar != null) {
            Integer valueOf = num == null ? Integer.valueOf(Color.parseColor("#606060")) : num;
            if (VERSION.SDK_INT >= 21) {
                ColorStateList valueOf2 = ColorStateList.valueOf(num.intValue());
                ColorStateList valueOf3 = ColorStateList.valueOf(num.intValue());
                num = ColorStateList.valueOf(num.intValue());
                this.mapLoadingProgressBar.setProgressTintList(valueOf2);
                this.mapLoadingProgressBar.setSecondaryProgressTintList(valueOf3);
                this.mapLoadingProgressBar.setIndeterminateTintList(num);
                return;
            }
            num = Mode.SRC_IN;
            if (VERSION.SDK_INT <= 10) {
                num = Mode.MULTIPLY;
            }
            if (this.mapLoadingProgressBar.getIndeterminateDrawable() != null) {
                this.mapLoadingProgressBar.getIndeterminateDrawable().setColorFilter(valueOf.intValue(), num);
            }
            if (this.mapLoadingProgressBar.getProgressDrawable() != null) {
                this.mapLoadingProgressBar.getProgressDrawable().setColorFilter(valueOf.intValue(), num);
            }
        }
    }

    public void setHandlePanDrag(boolean z) {
        this.handlePanDrag = z;
    }

    public void addFeature(View view, int i) {
        if (view instanceof AirMapMarker) {
            AirMapMarker airMapMarker = (AirMapMarker) view;
            airMapMarker.addToMap(this.map);
            this.features.add(i, airMapMarker);
            i = airMapMarker.getVisibility();
            airMapMarker.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) airMapMarker.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(airMapMarker);
            }
            this.attacherGroup.addView(airMapMarker);
            airMapMarker.setVisibility(i);
            this.markerMap.put((C5143l) airMapMarker.getFeature(), airMapMarker);
        } else if (view instanceof AirMapPolyline) {
            AirMapPolyline airMapPolyline = (AirMapPolyline) view;
            airMapPolyline.addToMap(this.map);
            this.features.add(i, airMapPolyline);
            this.polylineMap.put((C5145r) airMapPolyline.getFeature(), airMapPolyline);
        } else if (view instanceof AirMapPolygon) {
            AirMapPolygon airMapPolygon = (AirMapPolygon) view;
            airMapPolygon.addToMap(this.map);
            this.features.add(i, airMapPolygon);
            this.polygonMap.put((C5144p) airMapPolygon.getFeature(), airMapPolygon);
        } else if (view instanceof AirMapCircle) {
            AirMapCircle airMapCircle = (AirMapCircle) view;
            airMapCircle.addToMap(this.map);
            this.features.add(i, airMapCircle);
        } else if (view instanceof AirMapUrlTile) {
            AirMapUrlTile airMapUrlTile = (AirMapUrlTile) view;
            airMapUrlTile.addToMap(this.map);
            this.features.add(i, airMapUrlTile);
        } else if (view instanceof AirMapLocalTile) {
            AirMapLocalTile airMapLocalTile = (AirMapLocalTile) view;
            airMapLocalTile.addToMap(this.map);
            this.features.add(i, airMapLocalTile);
        } else if (view instanceof AirMapOverlay) {
            AirMapOverlay airMapOverlay = (AirMapOverlay) view;
            airMapOverlay.addToMap(this.map);
            this.features.add(i, airMapOverlay);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                addFeature(viewGroup2.getChildAt(i2), i);
            }
        } else {
            addView(view, i);
        }
    }

    public int getFeatureCount() {
        return this.features.size();
    }

    public View getFeatureAt(int i) {
        return (View) this.features.get(i);
    }

    public void removeFeatureAt(int i) {
        AirMapFeature airMapFeature = (AirMapFeature) this.features.remove(i);
        if (airMapFeature instanceof AirMapMarker) {
            this.markerMap.remove(airMapFeature.getFeature());
        }
        airMapFeature.removeFromMap(this.map);
    }

    public WritableMap makeClickEventData(LatLng latLng) {
        WritableMap writableNativeMap = new WritableNativeMap();
        WritableMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.f29231a);
        writableNativeMap2.putDouble("longitude", latLng.f29232b);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        latLng = this.map.m21737d().m21740a(latLng);
        writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("x", (double) latLng.x);
        writableNativeMap2.putDouble("y", (double) latLng.y);
        writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap2);
        return writableNativeMap;
    }

    public void updateExtraData(Object obj) {
        if (this.boundsToMove != null) {
            HashMap hashMap = (HashMap) obj;
            int intValue = hashMap.get("width") == null ? 0 : ((Float) hashMap.get("width")).intValue();
            obj = hashMap.get("height") == null ? null : ((Float) hashMap.get("height")).intValue();
            if (intValue > 0) {
                if (obj > null) {
                    this.map.m21709a(C5107b.m21695a(this.boundsToMove, intValue, obj, 0));
                    this.boundsToMove = null;
                }
            }
            this.map.m21709a(C5107b.m21694a(this.boundsToMove, 0));
            this.boundsToMove = null;
        }
    }

    public void animateToNavigation(LatLng latLng, float f, float f2, int i) {
        if (this.map != null) {
            this.map.m21710a(C5107b.m21691a(new C5134a(this.map.m21699a()).m21757c(f).m21756b(f2).m21754a(latLng).m21755a()), i, 0.0f);
        }
    }

    public void animateToRegion(LatLngBounds latLngBounds, int i) {
        if (this.map != null) {
            this.map.m21710a(C5107b.m21694a(latLngBounds, 0), i, null);
        }
    }

    public void animateToViewingAngle(float f, int i) {
        if (this.map != null) {
            this.map.m21710a(C5107b.m21691a(new C5134a(this.map.m21699a()).m21756b(f).m21755a()), i, null);
        }
    }

    public void animateToBearing(float f, int i) {
        if (this.map != null) {
            this.map.m21710a(C5107b.m21691a(new C5134a(this.map.m21699a()).m21757c(f).m21755a()), i, null);
        }
    }

    public void animateToCoordinate(LatLng latLng, int i) {
        if (this.map != null) {
            this.map.m21710a(C5107b.m21692a(latLng), i, null);
        }
    }

    public void fitToElements(boolean z) {
        if (this.map != null) {
            C5135a c5135a = new C5135a();
            Object obj = null;
            for (AirMapFeature airMapFeature : this.features) {
                if (airMapFeature instanceof AirMapMarker) {
                    c5135a.m21758a(((C5143l) airMapFeature.getFeature()).m21795b());
                    obj = 1;
                }
            }
            if (obj != null) {
                C5106a a = C5107b.m21694a(c5135a.m21759a(), 50);
                if (z) {
                    this.map.m21733b(a);
                } else {
                    this.map.m21709a(a);
                }
            }
        }
    }

    public void fitToSuppliedMarkers(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map != null) {
            C5135a c5135a = new C5135a();
            String[] strArr = new String[readableArray.size()];
            Object obj = null;
            for (int i = 0; i < readableArray.size(); i++) {
                strArr[i] = readableArray.getString(i);
            }
            readableArray = Arrays.asList(strArr);
            for (AirMapFeature airMapFeature : this.features) {
                if (airMapFeature instanceof AirMapMarker) {
                    String identifier = ((AirMapMarker) airMapFeature).getIdentifier();
                    C5143l c5143l = (C5143l) airMapFeature.getFeature();
                    if (readableArray.contains(identifier)) {
                        c5135a.m21758a(c5143l.m21795b());
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                C5106a a = C5107b.m21694a(c5135a.m21759a(), 50);
                if (readableMap != null) {
                    this.map.m21708a(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
                }
                if (z) {
                    this.map.m21733b(a);
                } else {
                    this.map.m21709a(a);
                }
            }
        }
    }

    public void fitToCoordinates(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map != null) {
            C5135a c5135a = new C5135a();
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                c5135a.m21758a(new LatLng(Double.valueOf(map.getDouble("latitude")).doubleValue(), Double.valueOf(map.getDouble("longitude")).doubleValue()));
            }
            C5106a a = C5107b.m21694a(c5135a.m21759a(), 50);
            if (readableMap != null) {
                this.map.m21708a(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.m21733b(a);
            } else {
                this.map.m21709a(a);
            }
            this.map.m21708a(0, 0, 0, 0);
        }
    }

    public void setMapBoundaries(ReadableMap readableMap, ReadableMap readableMap2) {
        if (this.map != null) {
            C5135a c5135a = new C5135a();
            c5135a.m21758a(new LatLng(Double.valueOf(readableMap.getDouble("latitude")).doubleValue(), Double.valueOf(readableMap.getDouble("longitude")).doubleValue()));
            c5135a.m21758a(new LatLng(Double.valueOf(readableMap2.getDouble("latitude")).doubleValue(), Double.valueOf(readableMap2.getDouble("longitude")).doubleValue()));
            this.map.m21728a(c5135a.m21759a());
        }
    }

    public View getInfoWindow(C5143l c5143l) {
        return getMarkerMap(c5143l).getCallout();
    }

    public View getInfoContents(C5143l c5143l) {
        return getMarkerMap(c5143l).getInfoContents();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.a(motionEvent);
        boolean z = false;
        switch (C0507i.a(motionEvent)) {
            case 0:
                ViewParent parent = getParent();
                if (this.map != null && this.map.m21735c().m21744a()) {
                    z = true;
                }
                parent.requestDisallowInterceptTouchEvent(z);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            default:
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void onMarkerDragStart(C5143l c5143l) {
        this.manager.pushEvent(this.context, this, "onMarkerDragStart", makeClickEventData(c5143l.m21795b()));
        this.manager.pushEvent(this.context, getMarkerMap(c5143l), "onDragStart", makeClickEventData(c5143l.m21795b()));
    }

    public void onMarkerDrag(C5143l c5143l) {
        this.manager.pushEvent(this.context, this, "onMarkerDrag", makeClickEventData(c5143l.m21795b()));
        this.manager.pushEvent(this.context, getMarkerMap(c5143l), "onDrag", makeClickEventData(c5143l.m21795b()));
    }

    public void onMarkerDragEnd(C5143l c5143l) {
        this.manager.pushEvent(this.context, this, "onMarkerDragEnd", makeClickEventData(c5143l.m21795b()));
        this.manager.pushEvent(this.context, getMarkerMap(c5143l), "onDragEnd", makeClickEventData(c5143l.m21795b()));
    }

    public void onPoiClick(C7853o c7853o) {
        WritableMap makeClickEventData = makeClickEventData(c7853o.f29285a);
        makeClickEventData.putString("placeId", c7853o.f29286b);
        makeClickEventData.putString("name", c7853o.f29287c);
        this.manager.pushEvent(this.context, this, "onPoiClick", makeClickEventData);
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.mapLoadingProgressBar == null) {
            this.mapLoadingProgressBar = new ProgressBar(getContext());
            this.mapLoadingProgressBar.setIndeterminate(true);
        }
        if (this.loadingIndicatorColor != null) {
            setLoadingIndicatorColor(this.loadingIndicatorColor);
        }
        return this.mapLoadingProgressBar;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.mapLoadingLayout == null) {
            this.mapLoadingLayout = new RelativeLayout(getContext());
            this.mapLoadingLayout.setBackgroundColor(-3355444);
            addView(this.mapLoadingLayout, new ViewGroup.LayoutParams(-1, -1));
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mapLoadingLayout.addView(getMapLoadingProgressBar(), layoutParams);
            this.mapLoadingLayout.setVisibility(4);
        }
        setLoadingBackgroundColor(this.loadingBackgroundColor);
        return this.mapLoadingLayout;
    }

    private ImageView getCacheImageView() {
        if (this.cacheImageView == null) {
            this.cacheImageView = new ImageView(getContext());
            addView(this.cacheImageView, new ViewGroup.LayoutParams(-1, -1));
            this.cacheImageView.setVisibility(4);
        }
        return this.cacheImageView;
    }

    private void removeCacheImageView() {
        if (this.cacheImageView != null) {
            ((ViewGroup) this.cacheImageView.getParent()).removeView(this.cacheImageView);
            this.cacheImageView = null;
        }
    }

    private void removeMapLoadingProgressBar() {
        if (this.mapLoadingProgressBar != null) {
            ((ViewGroup) this.mapLoadingProgressBar.getParent()).removeView(this.mapLoadingProgressBar);
            this.mapLoadingProgressBar = null;
        }
    }

    private void removeMapLoadingLayoutView() {
        removeMapLoadingProgressBar();
        if (this.mapLoadingLayout != null) {
            ((ViewGroup) this.mapLoadingLayout.getParent()).removeView(this.mapLoadingLayout);
            this.mapLoadingLayout = null;
        }
    }

    private void cacheView() {
        if (this.cacheEnabled) {
            final ImageView cacheImageView = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.isMapLoaded.booleanValue()) {
                this.map.m21726a(new C5124q() {
                    public void onSnapshotReady(Bitmap bitmap) {
                        cacheImageView.setImageBitmap(bitmap);
                        cacheImageView.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        removeCacheImageView();
        if (this.isMapLoaded.booleanValue()) {
            removeMapLoadingLayoutView();
        }
    }

    public void onPanDrag(MotionEvent motionEvent) {
        this.manager.pushEvent(this.context, this, "onPanDrag", makeClickEventData(this.map.m21737d().m21741a(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
    }

    public void setKmlSrc(String str) {
        try {
            InputStream inputStream = (InputStream) new FileUtil(this.context).execute(new String[]{str}).get();
            if (inputStream != null) {
                this.kmlLayer = new C6922f(this.map, inputStream, this.context);
                this.kmlLayer.m32460c();
                str = new WritableNativeMap();
                WritableArray writableNativeArray = new WritableNativeArray();
                if (this.kmlLayer.mo4899b() == null) {
                    this.manager.pushEvent(this.context, this, "onKmlReady", str);
                    return;
                }
                C5384b c5384b = (C5384b) this.kmlLayer.mo4899b().iterator().next();
                if (c5384b != null) {
                    if (c5384b.m22845f() != null) {
                        if (c5384b.m22845f().iterator().hasNext()) {
                            c5384b = (C5384b) c5384b.m22845f().iterator().next();
                        }
                        Integer valueOf = Integer.valueOf(0);
                        for (C6923j c6923j : c5384b.m22846g()) {
                            C7851m c7851m = new C7851m();
                            if (c6923j.m32462f() != null) {
                                c7851m = c6923j.m32464h();
                            } else {
                                c7851m.m38318a(C5137b.m21761a());
                            }
                            LatLng latLng = (LatLng) c6923j.m22893c().mo4902d();
                            String str2 = "";
                            String str3 = "";
                            if (c6923j.m22892b("name")) {
                                str2 = c6923j.m22890a("name");
                            }
                            if (c6923j.m22892b("description")) {
                                str3 = c6923j.m22890a("description");
                            }
                            c7851m.m38317a(latLng);
                            c7851m.m38319a(str2);
                            c7851m.m38323b(str3);
                            View airMapMarker = new AirMapMarker(this.context, c7851m);
                            if (c6923j.m32462f() != null && c6923j.m32462f().m32513g() != null) {
                                airMapMarker.setImage(c6923j.m32462f().m32513g());
                            } else if (c5384b.m22836a(c6923j.m32461e()) != null) {
                                airMapMarker.setImage(c5384b.m22836a(c6923j.m32461e()).m32513g());
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append(" - ");
                            stringBuilder.append(valueOf);
                            String stringBuilder2 = stringBuilder.toString();
                            airMapMarker.setIdentifier(stringBuilder2);
                            Integer valueOf2 = Integer.valueOf(valueOf.intValue() + 1);
                            addFeature(airMapMarker, valueOf.intValue());
                            WritableMap makeClickEventData = makeClickEventData(latLng);
                            makeClickEventData.putString("id", stringBuilder2);
                            makeClickEventData.putString("title", str2);
                            makeClickEventData.putString("description", str3);
                            writableNativeArray.pushMap(makeClickEventData);
                            valueOf = valueOf2;
                        }
                        str.putArray("markers", writableNativeArray);
                        this.manager.pushEvent(this.context, this, "onKmlReady", str);
                        return;
                    }
                }
                this.manager.pushEvent(this.context, this, "onKmlReady", str);
            }
        } catch (String str4) {
            str4.printStackTrace();
        } catch (String str42) {
            str42.printStackTrace();
        } catch (String str422) {
            str422.printStackTrace();
        } catch (String str4222) {
            str4222.printStackTrace();
        }
    }

    public void onIndoorBuildingFocused() {
        C5141i b = this.map.m21731b();
        int i = 0;
        if (b != null) {
            List<C5142j> b2 = b.m21783b();
            WritableArray createArray = Arguments.createArray();
            for (C5142j c5142j : b2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i);
                createMap.putString("name", c5142j.m21785a());
                createMap.putString("shortName", c5142j.m21786b());
                createArray.pushMap(createMap);
                i++;
            }
            WritableMap createMap2 = Arguments.createMap();
            WritableMap createMap3 = Arguments.createMap();
            createMap3.putArray("levels", createArray);
            createMap3.putInt("activeLevelIndex", b.m21782a());
            createMap3.putBoolean("underground", b.m21784c());
            createMap2.putMap("IndoorBuilding", createMap3);
            this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap2);
            return;
        }
        WritableMap createMap4 = Arguments.createMap();
        WritableArray createArray2 = Arguments.createArray();
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putArray("levels", createArray2);
        createMap5.putInt("activeLevelIndex", 0);
        createMap5.putBoolean("underground", false);
        createMap4.putMap("IndoorBuilding", createMap5);
        this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap4);
    }

    public void onIndoorLevelActivated(C5141i c5141i) {
        int a = c5141i.m21782a();
        C5142j c5142j = (C5142j) c5141i.m21783b().get(a);
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("activeLevelIndex", a);
        createMap2.putString("name", c5142j.m21785a());
        createMap2.putString("shortName", c5142j.m21786b());
        createMap.putMap("IndoorLevel", createMap2);
        this.manager.pushEvent(this.context, this, "onIndoorLevelActivated", createMap);
    }

    public void setIndoorActiveLevelIndex(int i) {
        C5141i b = this.map.m21731b();
        if (b != null && i >= 0 && i < b.m21783b().size()) {
            C5142j c5142j = (C5142j) b.m21783b().get(i);
            if (c5142j != null) {
                c5142j.m21787c();
            }
        }
    }

    private AirMapMarker getMarkerMap(C5143l c5143l) {
        AirMapMarker airMapMarker = (AirMapMarker) this.markerMap.get(c5143l);
        if (airMapMarker != null) {
            return airMapMarker;
        }
        for (Entry entry : this.markerMap.entrySet()) {
            if (((C5143l) entry.getKey()).m21795b().equals(c5143l.m21795b()) && ((C5143l) entry.getKey()).m21800c().equals(c5143l.m21800c())) {
                airMapMarker = (AirMapMarker) entry.getValue();
                break;
            }
        }
        return airMapMarker;
    }
}
