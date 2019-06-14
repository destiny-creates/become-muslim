package com.facebook.places.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WifiScannerImpl implements WifiScanner {
    private static final String SSID_NOMAP = "_nomap";
    private static final String SSID_OPTOUT = "_optout";
    private ScanResultBroadcastReceiver broadcastReceiver;
    private Context context;
    private final LocationPackageRequestParams params;
    private final Object scanLock = new Object();
    private WifiManager wifiManager;

    /* renamed from: com.facebook.places.internal.WifiScannerImpl$1 */
    static class C18581 implements Comparator<ScanResult> {
        C18581() {
        }

        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    private class ScanResultBroadcastReceiver extends BroadcastReceiver {
        private ScanResultBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) != null) {
                synchronized (WifiScannerImpl.this.scanLock) {
                    WifiScannerImpl.this.scanLock.notify();
                }
                WifiScannerImpl.this.unregisterBroadcastReceiver();
            }
        }
    }

    WifiScannerImpl(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context;
        this.params = locationPackageRequestParams;
    }

    public void initAndCheckEligibility() {
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.wifi")) {
            throw new ScannerException(Type.NOT_SUPPORTED);
        } else if (Validate.hasWiFiPermission(this.context)) {
            if (this.wifiManager == null) {
                this.wifiManager = (WifiManager) this.context.getSystemService("wifi");
            }
            if (!isWifiScanningAlwaysOn()) {
                if (!this.wifiManager.isWifiEnabled()) {
                    throw new ScannerException(Type.DISABLED);
                }
            }
        } else {
            throw new ScannerException(Type.PERMISSION_DENIED);
        }
    }

    public WifiScanResult getConnectedWifi() {
        try {
            WifiInfo connectionInfo = this.wifiManager.getConnectionInfo();
            if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getBSSID()) || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED)) {
                if (!isWifiSsidBlacklisted(connectionInfo.getSSID())) {
                    WifiScanResult wifiScanResult = new WifiScanResult();
                    wifiScanResult.bssid = connectionInfo.getBSSID();
                    wifiScanResult.ssid = connectionInfo.getSSID();
                    wifiScanResult.rssi = connectionInfo.getRssi();
                    wifiScanResult.timestampMs = SystemClock.elapsedRealtime();
                    if (VERSION.SDK_INT >= 21) {
                        wifiScanResult.frequency = connectionInfo.getFrequency();
                    }
                    return wifiScanResult;
                }
            }
            return null;
        } catch (Exception e) {
            throw new ScannerException(Type.UNKNOWN_ERROR, e);
        }
    }

    public boolean isWifiScanningEnabled() {
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
        r1 = this;
        r1.initAndCheckEligibility();	 Catch:{ ScannerException -> 0x000d }
        r0 = r1.context;	 Catch:{ ScannerException -> 0x000d }
        r0 = com.facebook.internal.Validate.hasLocationPermission(r0);	 Catch:{ ScannerException -> 0x000d }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        r0 = 1;
        return r0;
    L_0x000d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.WifiScannerImpl.isWifiScanningEnabled():boolean");
    }

    private boolean isWifiScanningAlwaysOn() {
        return VERSION.SDK_INT >= 18 ? this.wifiManager.isScanAlwaysAvailable() : false;
    }

    private List<WifiScanResult> getCachedScanResults() {
        try {
            List<ScanResult> filterWifiScanResultsByMaxAge = filterWifiScanResultsByMaxAge(this.wifiManager.getScanResults(), this.params.getWifiScanMaxAgeMs());
            filterResults(filterWifiScanResultsByMaxAge, this.params.getWifiMaxScanResults());
            List<WifiScanResult> arrayList = new ArrayList(filterWifiScanResultsByMaxAge.size());
            for (ScanResult scanResult : filterWifiScanResultsByMaxAge) {
                if (!isWifiSsidBlacklisted(scanResult.SSID)) {
                    WifiScanResult wifiScanResult = new WifiScanResult();
                    wifiScanResult.bssid = scanResult.BSSID;
                    wifiScanResult.ssid = scanResult.SSID;
                    wifiScanResult.rssi = scanResult.level;
                    wifiScanResult.frequency = scanResult.frequency;
                    if (VERSION.SDK_INT >= 17) {
                        wifiScanResult.timestampMs = TimeUnit.MICROSECONDS.toMillis(scanResult.timestamp);
                    } else {
                        wifiScanResult.timestampMs = SystemClock.elapsedRealtime();
                    }
                    arrayList.add(wifiScanResult);
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new ScannerException(Type.UNKNOWN_ERROR, e);
        }
    }

    private static boolean isWifiSsidBlacklisted(String str) {
        return (str == null || (!str.endsWith(SSID_NOMAP) && str.contains(SSID_OPTOUT) == null)) ? null : true;
    }

    private static void filterResults(List<ScanResult> list, int i) {
        if (list.size() > i) {
            Collections.sort(list, new C18581());
            list.subList(i, list.size()).clear();
        }
    }

    private static List<ScanResult> filterWifiScanResultsByMaxAge(List<ScanResult> list, long j) {
        List<ScanResult> arrayList = new ArrayList();
        if (list != null) {
            if (VERSION.SDK_INT < 17) {
                arrayList.addAll(list);
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                for (ScanResult scanResult : list) {
                    long j2 = elapsedRealtime - (scanResult.timestamp / 1000);
                    if (j2 < 0) {
                        j2 = System.currentTimeMillis() - scanResult.timestamp;
                    }
                    if (j2 < j) {
                        arrayList.add(scanResult);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List<WifiScanResult> getWifiScans() {
        List<WifiScanResult> list;
        Object obj;
        list = null;
        if (!this.params.isWifiActiveScanForced()) {
            list = getCachedScanResults();
        }
        if (list != null) {
            if (!list.isEmpty()) {
                obj = null;
                if (this.params.isWifiActiveScanForced() || (this.params.isWifiActiveScanAllowed() && r1 != null)) {
                    list = getActiveScanResults();
                }
            }
        }
        obj = 1;
        list = getActiveScanResults();
        return list;
    }

    private java.util.List<com.facebook.places.internal.WifiScanResult> getActiveScanResults() {
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
        r5 = this;
        r0 = 0;
        r1 = r5.context;	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r1 = com.facebook.internal.Validate.hasChangeWifiStatePermission(r1);	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        if (r1 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x0032, all -> 0x002d }
    L_0x0009:
        r5.registerBroadcastReceiver();	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r1 = r5.wifiManager;	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r1 = r1.startScan();	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        if (r1 == 0) goto L_0x0032;
    L_0x0014:
        r1 = r5.scanLock;	 Catch:{ InterruptedException -> 0x0027 }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x0027 }
        r2 = r5.scanLock;	 Catch:{ all -> 0x0024 }
        r3 = r5.params;	 Catch:{ all -> 0x0024 }
        r3 = r3.getWifiScanTimeoutMs();	 Catch:{ all -> 0x0024 }
        r2.wait(r3);	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        goto L_0x0027;	 Catch:{ all -> 0x0024 }
    L_0x0024:
        r2 = move-exception;	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r2;	 Catch:{ InterruptedException -> 0x0027 }
    L_0x0027:
        r1 = r5.getCachedScanResults();	 Catch:{ Exception -> 0x0032, all -> 0x002d }
        r0 = r1;
        goto L_0x0032;
    L_0x002d:
        r0 = move-exception;
        r5.unregisterBroadcastReceiver();
        throw r0;
    L_0x0032:
        r5.unregisterBroadcastReceiver();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.WifiScannerImpl.getActiveScanResults():java.util.List<com.facebook.places.internal.WifiScanResult>");
    }

    private void registerBroadcastReceiver() {
        if (this.broadcastReceiver != null) {
            unregisterBroadcastReceiver();
        }
        this.broadcastReceiver = new ScanResultBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.context.registerReceiver(this.broadcastReceiver, intentFilter);
    }

    private void unregisterBroadcastReceiver() {
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
        r2 = this;
        r0 = r2.broadcastReceiver;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = r2.context;	 Catch:{ Exception -> 0x000b }
        r1 = r2.broadcastReceiver;	 Catch:{ Exception -> 0x000b }
        r0.unregisterReceiver(r1);	 Catch:{ Exception -> 0x000b }
    L_0x000b:
        r0 = 0;
        r2.broadcastReceiver = r0;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.WifiScannerImpl.unregisterBroadcastReceiver():void");
    }
}
