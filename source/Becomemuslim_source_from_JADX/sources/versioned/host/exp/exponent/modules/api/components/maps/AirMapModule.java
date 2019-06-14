package versioned.host.exp.exponent.modules.api.components.maps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.maps.C5125c.C5124q;
import com.google.android.gms.maps.model.LatLng;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AirMapModule extends ReactContextBaseJavaModule {
    private static final String SNAPSHOT_FORMAT_JPG = "jpg";
    private static final String SNAPSHOT_FORMAT_PNG = "png";
    private static final String SNAPSHOT_RESULT_BASE64 = "base64";
    private static final String SNAPSHOT_RESULT_FILE = "file";

    public String getName() {
        return "AirMapModule";
    }

    public AirMapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
        return hashMap;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    public static void closeQuietly(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.maps.AirMapModule.closeQuietly(java.io.Closeable):void");
    }

    @ReactMethod
    public void takeSnapshot(int i, ReadableMap readableMap, Promise promise) {
        ReadableMap readableMap2 = readableMap;
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final String string = readableMap2.hasKey("format") ? readableMap2.getString("format") : SNAPSHOT_FORMAT_PNG;
        CompressFormat compressFormat = string.equals(SNAPSHOT_FORMAT_PNG) ? CompressFormat.PNG : string.equals(SNAPSHOT_FORMAT_JPG) ? CompressFormat.JPEG : null;
        final CompressFormat compressFormat2 = compressFormat;
        final double d = readableMap2.hasKey("quality") ? readableMap2.getDouble("quality") : 1.0d;
        DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
        int i2 = 0;
        final Integer valueOf = Integer.valueOf(readableMap2.hasKey("width") ? (int) (((double) displayMetrics.density) * readableMap2.getDouble("width")) : 0);
        if (readableMap2.hasKey("height")) {
            i2 = (int) (((double) displayMetrics.density) * readableMap2.getDouble("height"));
        }
        final Integer valueOf2 = Integer.valueOf(i2);
        final String string2 = readableMap2.hasKey("result") ? readableMap2.getString("result") : "file";
        final int i3 = i;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {

            /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.AirMapModule$1$1 */
            class C77721 implements C5124q {
                C77721() {
                }

                public void onSnapshotReady(Bitmap bitmap) {
                    if (bitmap == null) {
                        promise2.reject("Failed to generate bitmap, snapshot = null");
                        return;
                    }
                    if (!(valueOf.intValue() == 0 || valueOf2.intValue() == 0 || (valueOf.intValue() == bitmap.getWidth() && valueOf2.intValue() == bitmap.getHeight()))) {
                        bitmap = Bitmap.createScaledBitmap(bitmap, valueOf.intValue(), valueOf2.intValue(), true);
                    }
                    if (string2.equals("file")) {
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(".");
                            stringBuilder.append(string);
                            File createTempFile = File.createTempFile("AirMapSnapshot", stringBuilder.toString(), reactApplicationContext.getCacheDir());
                            Closeable fileOutputStream = new FileOutputStream(createTempFile);
                            bitmap.compress(compressFormat2, (int) (d * 100.0d), fileOutputStream);
                            AirMapModule.closeQuietly(fileOutputStream);
                            promise2.resolve(Uri.fromFile(createTempFile).toString());
                        } catch (Bitmap bitmap2) {
                            promise2.reject(bitmap2);
                        }
                    } else if (string2.equals("base64")) {
                        Object byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap2.compress(compressFormat2, (int) (d * 100.0d), byteArrayOutputStream);
                        AirMapModule.closeQuietly(byteArrayOutputStream);
                        promise2.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                    }
                }
            }

            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                AirMapView airMapView = (AirMapView) nativeViewHierarchyManager.resolveView(i3);
                if (airMapView == null) {
                    promise2.reject("AirMapView not found");
                } else if (airMapView.map == null) {
                    promise2.reject("AirMapView.map is not valid");
                } else {
                    airMapView.map.m21726a(new C77721());
                }
            }
        });
    }

    @ReactMethod
    public void pointForCoordinate(int i, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final double d = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        double d2 = 0.0d;
        double d3 = readableMap.hasKey("latitude") ? readableMap.getDouble("latitude") : 0.0d;
        if (readableMap.hasKey("longitude")) {
            d2 = readableMap.getDouble("longitude");
        }
        final LatLng latLng = new LatLng(d3, d2);
        final int i2 = i;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                AirMapView airMapView = (AirMapView) nativeViewHierarchyManager.resolveView(i2);
                if (airMapView == null) {
                    promise2.reject("AirMapView not found");
                } else if (airMapView.map == null) {
                    promise2.reject("AirMapView.map is not valid");
                } else {
                    nativeViewHierarchyManager = airMapView.map.m21737d().m21740a(latLng);
                    WritableMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("x", ((double) nativeViewHierarchyManager.x) / d);
                    writableNativeMap.putDouble("y", ((double) nativeViewHierarchyManager.y) / d);
                    promise2.resolve(writableNativeMap);
                }
            }
        });
    }

    @ReactMethod
    public void coordinateForPoint(final int i, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        int i2 = 0;
        int i3 = readableMap.hasKey("x") ? (int) (readableMap.getDouble("x") * d) : 0;
        if (readableMap.hasKey("y")) {
            i2 = (int) (readableMap.getDouble("y") * d);
        }
        final Point point = new Point(i3, i2);
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                AirMapView airMapView = (AirMapView) nativeViewHierarchyManager.resolveView(i);
                if (airMapView == null) {
                    promise.reject("AirMapView not found");
                } else if (airMapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                } else {
                    nativeViewHierarchyManager = airMapView.map.m21737d().m21741a(point);
                    WritableMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("latitude", nativeViewHierarchyManager.f29231a);
                    writableNativeMap.putDouble("longitude", nativeViewHierarchyManager.f29232b);
                    promise.resolve(writableNativeMap);
                }
            }
        });
    }
}
