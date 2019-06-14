package com.facebook.places.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LocationPackageManager {
    private static final String TAG = "LocationPackageManager";

    public interface Listener {
        void onLocationPackage(LocationPackage locationPackage);
    }

    public static void requestLocationPackage(final LocationPackageRequestParams locationPackageRequestParams, final Listener listener) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r0 = new com.facebook.places.internal.LocationPackage;
                r0.<init>();
                r1 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r1 = r1.isLocationScanEnabled();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r2 = 0;
                if (r1 == 0) goto L_0x0029;
            L_0x000e:
                r1 = com.facebook.FacebookSdk.getApplicationContext();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r1 = com.facebook.places.internal.ScannerFactory.newLocationScanner(r1, r3);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r1.initAndCheckEligibility();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r1 = com.facebook.places.internal.LocationPackageManager.newLocationScanFuture(r1, r3);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3 = com.facebook.FacebookSdk.getExecutor();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3.execute(r1);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                goto L_0x002a;
            L_0x0029:
                r1 = r2;
            L_0x002a:
                r3 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3 = r3.isWifiScanEnabled();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                if (r3 == 0) goto L_0x0040;
            L_0x0032:
                r3 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r3 = com.facebook.places.internal.LocationPackageManager.newWifiScanFuture(r3);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r4 = com.facebook.FacebookSdk.getExecutor();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r4.execute(r3);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                goto L_0x0041;
            L_0x0040:
                r3 = r2;
            L_0x0041:
                r4 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r4 = r4.isBluetoothScanEnabled();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                if (r4 == 0) goto L_0x0056;
            L_0x0049:
                r2 = r2;	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r2 = com.facebook.places.internal.LocationPackageManager.newBluetoothScanFuture(r2);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r4 = com.facebook.FacebookSdk.getExecutor();	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                r4.execute(r2);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
            L_0x0056:
                if (r2 == 0) goto L_0x006d;
            L_0x0058:
                r2 = r2.get();	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                r2 = (com.facebook.places.internal.LocationPackage) r2;	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                r4 = r2.ambientBluetoothLe;	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                r0.ambientBluetoothLe = r4;	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                r2 = r2.isBluetoothScanningEnabled;	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                r0.isBluetoothScanningEnabled = r2;	 Catch:{ Exception -> 0x0067, ScannerException -> 0x00a7 }
                goto L_0x006d;
            L_0x0067:
                r2 = move-exception;
                r4 = "Exception scanning for bluetooth beacons";
                com.facebook.places.internal.LocationPackageManager.logException(r4, r2);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
            L_0x006d:
                if (r3 == 0) goto L_0x0088;
            L_0x006f:
                r2 = r3.get();	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r2 = (com.facebook.places.internal.LocationPackage) r2;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r3 = r2.isWifiScanningEnabled;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r0.isWifiScanningEnabled = r3;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r3 = r2.connectedWifi;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r0.connectedWifi = r3;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r2 = r2.ambientWifi;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                r0.ambientWifi = r2;	 Catch:{ Exception -> 0x0082, ScannerException -> 0x00a7 }
                goto L_0x0088;
            L_0x0082:
                r2 = move-exception;
                r3 = "Exception scanning for wifi access points";
                com.facebook.places.internal.LocationPackageManager.logException(r3, r2);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
            L_0x0088:
                if (r1 == 0) goto L_0x00b1;
            L_0x008a:
                r1 = r1.get();	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                r1 = (com.facebook.places.internal.LocationPackage) r1;	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                r2 = r1.locationError;	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                r0.locationError = r2;	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                r1 = r1.location;	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                r0.location = r1;	 Catch:{ Exception -> 0x0099, ScannerException -> 0x00a7 }
                goto L_0x00b1;
            L_0x0099:
                r1 = move-exception;
                r2 = "Exception getting location";
                com.facebook.places.internal.LocationPackageManager.logException(r2, r1);	 Catch:{ ScannerException -> 0x00a7, Exception -> 0x00a0 }
                goto L_0x00b1;
            L_0x00a0:
                r1 = move-exception;
                r2 = "Exception requesting a location package";
                com.facebook.places.internal.LocationPackageManager.logException(r2, r1);
                goto L_0x00b1;
            L_0x00a7:
                r1 = move-exception;
                r2 = "Exception scanning for locations";
                com.facebook.places.internal.LocationPackageManager.logException(r2, r1);
                r1 = r1.type;
                r0.locationError = r1;
            L_0x00b1:
                r1 = r3;
                r1.onLocationPackage(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationPackageManager.1.run():void");
            }
        });
    }

    private static FutureTask<LocationPackage> newLocationScanFuture(final LocationScanner locationScanner, LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask(new Callable<LocationPackage>() {
            public com.facebook.places.internal.LocationPackage call() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r3 = this;
                r0 = new com.facebook.places.internal.LocationPackage;
                r0.<init>();
                r1 = r1;	 Catch:{ ScannerException -> 0x0013, Exception -> 0x000e }
                r1 = r1.getLocation();	 Catch:{ ScannerException -> 0x0013, Exception -> 0x000e }
                r0.location = r1;	 Catch:{ ScannerException -> 0x0013, Exception -> 0x000e }
                goto L_0x001d;
            L_0x000e:
                r1 = com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR;
                r0.locationError = r1;
                goto L_0x001d;
            L_0x0013:
                r1 = move-exception;
                r2 = r1.type;
                r0.locationError = r2;
                r2 = "Exception while getting location";
                com.facebook.places.internal.LocationPackageManager.logException(r2, r1);
            L_0x001d:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationPackageManager.2.call():com.facebook.places.internal.LocationPackage");
            }
        });
    }

    private static FutureTask<LocationPackage> newBluetoothScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask(new Callable<LocationPackage>() {
            public com.facebook.places.internal.LocationPackage call() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r7 = this;
                r0 = new com.facebook.places.internal.LocationPackage;
                r0.<init>();
                r1 = 0;
                r2 = com.facebook.FacebookSdk.getApplicationContext();	 Catch:{ Exception -> 0x0057 }
                r3 = r2;	 Catch:{ Exception -> 0x0057 }
                r2 = com.facebook.places.internal.ScannerFactory.newBleScanner(r2, r3);	 Catch:{ Exception -> 0x0057 }
                r2.initAndCheckEligibility();	 Catch:{ Exception -> 0x0057 }
                r2.startScanning();	 Catch:{ all -> 0x0052 }
                r3 = r2;	 Catch:{ Exception -> 0x001f }
                r3 = r3.getBluetoothScanDurationMs();	 Catch:{ Exception -> 0x001f }
                java.lang.Thread.sleep(r3);	 Catch:{ Exception -> 0x001f }
            L_0x001f:
                r2.stopScanning();	 Catch:{ Exception -> 0x0057 }
                r3 = r2.getErrorCode();	 Catch:{ Exception -> 0x0057 }
                r4 = 1;	 Catch:{ Exception -> 0x0057 }
                if (r3 != 0) goto L_0x0032;	 Catch:{ Exception -> 0x0057 }
            L_0x0029:
                r2 = r2.getScanResults();	 Catch:{ Exception -> 0x0057 }
                r0.ambientBluetoothLe = r2;	 Catch:{ Exception -> 0x0057 }
                r0.isBluetoothScanningEnabled = r4;	 Catch:{ Exception -> 0x0057 }
                goto L_0x005f;	 Catch:{ Exception -> 0x0057 }
            L_0x0032:
                r2 = com.facebook.FacebookSdk.isDebugEnabled();	 Catch:{ Exception -> 0x0057 }
                if (r2 == 0) goto L_0x004f;	 Catch:{ Exception -> 0x0057 }
            L_0x0038:
                r2 = "LocationPackageManager";	 Catch:{ Exception -> 0x0057 }
                r5 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0057 }
                r6 = "Bluetooth LE scan failed with error: %d";	 Catch:{ Exception -> 0x0057 }
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0057 }
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0057 }
                r4[r1] = r3;	 Catch:{ Exception -> 0x0057 }
                r3 = java.lang.String.format(r5, r6, r4);	 Catch:{ Exception -> 0x0057 }
                com.facebook.internal.Utility.logd(r2, r3);	 Catch:{ Exception -> 0x0057 }
            L_0x004f:
                r0.isBluetoothScanningEnabled = r1;	 Catch:{ Exception -> 0x0057 }
                goto L_0x005f;	 Catch:{ Exception -> 0x0057 }
            L_0x0052:
                r3 = move-exception;	 Catch:{ Exception -> 0x0057 }
                r2.stopScanning();	 Catch:{ Exception -> 0x0057 }
                throw r3;	 Catch:{ Exception -> 0x0057 }
            L_0x0057:
                r2 = move-exception;
                r3 = "Exception scanning for bluetooth beacons";
                com.facebook.places.internal.LocationPackageManager.logException(r3, r2);
                r0.isBluetoothScanningEnabled = r1;
            L_0x005f:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationPackageManager.3.call():com.facebook.places.internal.LocationPackage");
            }
        });
    }

    private static FutureTask<LocationPackage> newWifiScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask(new Callable<LocationPackage>() {
            public LocationPackage call() {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    WifiScanner newWifiScanner = ScannerFactory.newWifiScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                    newWifiScanner.initAndCheckEligibility();
                    locationPackage.connectedWifi = newWifiScanner.getConnectedWifi();
                    locationPackage.isWifiScanningEnabled = newWifiScanner.isWifiScanningEnabled();
                    if (locationPackage.isWifiScanningEnabled) {
                        locationPackage.ambientWifi = newWifiScanner.getWifiScans();
                    }
                } catch (Throwable e) {
                    LocationPackageManager.logException("Exception scanning for wifi access points", e);
                    locationPackage.isWifiScanningEnabled = false;
                }
                return locationPackage;
            }
        });
    }

    private static void logException(String str, Throwable th) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, th);
        }
    }
}
