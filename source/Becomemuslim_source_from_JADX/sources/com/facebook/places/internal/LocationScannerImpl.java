package com.facebook.places.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException.Type;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.List;

public class LocationScannerImpl implements LocationListener, LocationScanner {
    private static final float MIN_DISTANCE_BETWEEN_UPDATES = 0.0f;
    private static final long MIN_TIME_BETWEEN_UPDATES = 100;
    private Context context;
    private List<String> enabledProviders;
    private Location freshLocation;
    private LocationManager locationManager;
    private LocationPackageRequestParams params;
    private final Object scanLock = new Object();

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public LocationScannerImpl(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context;
        this.params = locationPackageRequestParams;
        this.locationManager = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
    }

    public void initAndCheckEligibility() {
        if (Validate.hasLocationPermission(this.context)) {
            this.enabledProviders = new ArrayList(this.params.getLocationProviders().length);
            for (String str : this.params.getLocationProviders()) {
                if (this.locationManager.isProviderEnabled(str)) {
                    this.enabledProviders.add(str);
                }
            }
            if (this.enabledProviders.isEmpty()) {
                throw new ScannerException(Type.DISABLED);
            }
            return;
        }
        throw new ScannerException(Type.PERMISSION_DENIED);
    }

    private Location getLastLocation(String str) {
        str = this.locationManager.getLastKnownLocation(str);
        if (str != null) {
            if (System.currentTimeMillis() - str.getTime() < this.params.getLastLocationMaxAgeMs()) {
                return str;
            }
        }
        return null;
    }

    public Location getLocation() {
        for (String lastLocation : this.enabledProviders) {
            Location lastLocation2 = getLastLocation(lastLocation);
            if (lastLocation2 != null) {
                return lastLocation2;
            }
        }
        return getFreshLocation();
    }

    private android.location.Location getFreshLocation() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r10 = this;
        r0 = 0;
        r10.freshLocation = r0;
        r0 = new android.os.HandlerThread;
        r1 = "LocationScanner";
        r0.<init>(r1);
        r0.start();	 Catch:{ all -> 0x0058 }
        r1 = r10.enabledProviders;	 Catch:{ all -> 0x0058 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0058 }
    L_0x0013:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x002e;	 Catch:{ all -> 0x0058 }
    L_0x0019:
        r2 = r1.next();	 Catch:{ all -> 0x0058 }
        r4 = r2;	 Catch:{ all -> 0x0058 }
        r4 = (java.lang.String) r4;	 Catch:{ all -> 0x0058 }
        r3 = r10.locationManager;	 Catch:{ all -> 0x0058 }
        r5 = 100;	 Catch:{ all -> 0x0058 }
        r7 = 0;	 Catch:{ all -> 0x0058 }
        r9 = r0.getLooper();	 Catch:{ all -> 0x0058 }
        r8 = r10;	 Catch:{ all -> 0x0058 }
        r3.requestLocationUpdates(r4, r5, r7, r8, r9);	 Catch:{ all -> 0x0058 }
        goto L_0x0013;
    L_0x002e:
        r1 = r10.scanLock;	 Catch:{ Exception -> 0x0041 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0041 }
        r2 = r10.scanLock;	 Catch:{ all -> 0x003e }
        r3 = r10.params;	 Catch:{ all -> 0x003e }
        r3 = r3.getLocationRequestTimeoutMs();	 Catch:{ all -> 0x003e }
        r2.wait(r3);	 Catch:{ all -> 0x003e }
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0041;	 Catch:{ all -> 0x003e }
    L_0x003e:
        r2 = move-exception;	 Catch:{ all -> 0x003e }
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        throw r2;	 Catch:{ Exception -> 0x0041 }
    L_0x0041:
        r1 = r10.locationManager;
        r1.removeUpdates(r10);
        r0.quit();
        r0 = r10.freshLocation;
        if (r0 == 0) goto L_0x0050;
    L_0x004d:
        r0 = r10.freshLocation;
        return r0;
    L_0x0050:
        r0 = new com.facebook.places.internal.ScannerException;
        r1 = com.facebook.places.internal.ScannerException.Type.TIMEOUT;
        r0.<init>(r1);
        throw r0;
    L_0x0058:
        r1 = move-exception;
        r2 = r10.locationManager;
        r2.removeUpdates(r10);
        r0.quit();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationScannerImpl.getFreshLocation():android.location.Location");
    }

    public void onLocationChanged(Location location) {
        if (this.freshLocation == null && location.getAccuracy() < this.params.getLocationMaxAccuracyMeters()) {
            synchronized (this.scanLock) {
                this.freshLocation = location;
                this.scanLock.notify();
            }
        }
    }
}
