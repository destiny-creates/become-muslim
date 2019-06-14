package com.facebook.places.internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@TargetApi(21)
public class BleScannerImpl implements BleScanner {
    private static final byte[] EDDYSTONE_PREFIX = fromHexString("16aafe");
    private static final byte[] GRAVITY_PREFIX = fromHexString("17ffab01");
    private static final byte[] IBEACON_PREFIX = fromHexString("ff4c000215");
    private static final String TAG = "BleScannerImpl";
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private Context context;
    private int errorCode;
    private boolean isScanInProgress;
    private LocationPackageRequestParams params;
    private ScanCallBackImpl scanCallBack;
    private final List<BluetoothScanResult> scanResults = new ArrayList();

    /* renamed from: com.facebook.places.internal.BleScannerImpl$2 */
    class C18522 implements Comparator<BluetoothScanResult> {
        C18522() {
        }

        public int compare(BluetoothScanResult bluetoothScanResult, BluetoothScanResult bluetoothScanResult2) {
            return bluetoothScanResult2.rssi - bluetoothScanResult.rssi;
        }
    }

    private class ScanCallBackImpl extends ScanCallback {
        private ScanCallBackImpl() {
        }

        public void onScanFailed(int i) {
            super.onScanFailed(i);
            BleScannerImpl.this.errorCode = i;
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    for (ScanResult access$400 : list) {
                        BluetoothScanResult access$4002 = BleScannerImpl.newBluetoothScanResult(access$400);
                        if (access$4002 != null) {
                            BleScannerImpl.this.scanResults.add(access$4002);
                        }
                    }
                }
            } catch (List<ScanResult> list2) {
                BleScannerImpl.logException("Exception in ble scan callback", list2);
            }
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    scanResult = BleScannerImpl.newBluetoothScanResult(scanResult);
                    if (scanResult != null) {
                        BleScannerImpl.this.scanResults.add(scanResult);
                    }
                }
            } catch (int i2) {
                BleScannerImpl.logException("Exception in ble scan callback", i2);
            }
        }
    }

    BleScannerImpl(Context context, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context;
        this.params = locationPackageRequestParams;
    }

    public synchronized void initAndCheckEligibility() {
        if (VERSION.SDK_INT < 21) {
            throw new ScannerException(Type.NOT_SUPPORTED);
        } else if (!Validate.hasBluetoothPermission(this.context)) {
            throw new ScannerException(Type.PERMISSION_DENIED);
        } else if (Validate.hasLocationPermission(this.context)) {
            this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (this.bluetoothAdapter == null || !this.bluetoothAdapter.isEnabled()) {
                throw new ScannerException(Type.DISABLED);
            }
            this.bluetoothLeScanner = this.bluetoothAdapter.getBluetoothLeScanner();
            if (this.bluetoothLeScanner == null) {
                throw new ScannerException(Type.UNKNOWN_ERROR);
            }
        } else {
            throw new ScannerException(Type.PERMISSION_DENIED);
        }
    }

    public synchronized void startScanning() {
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
        monitor-enter(r5);
        r0 = r5.isScanInProgress;	 Catch:{ all -> 0x0058 }
        if (r0 != 0) goto L_0x0050;	 Catch:{ all -> 0x0058 }
    L_0x0005:
        r0 = new com.facebook.places.internal.BleScannerImpl$ScanCallBackImpl;	 Catch:{ all -> 0x0058 }
        r1 = 0;	 Catch:{ all -> 0x0058 }
        r0.<init>();	 Catch:{ all -> 0x0058 }
        r5.scanCallBack = r0;	 Catch:{ all -> 0x0058 }
        r0 = 1;	 Catch:{ all -> 0x0058 }
        r5.isScanInProgress = r0;	 Catch:{ all -> 0x0058 }
        r2 = 0;	 Catch:{ all -> 0x0058 }
        r5.errorCode = r2;	 Catch:{ all -> 0x0058 }
        r2 = r5.scanResults;	 Catch:{ all -> 0x0058 }
        monitor-enter(r2);	 Catch:{ all -> 0x0058 }
        r3 = r5.scanResults;	 Catch:{ all -> 0x004d }
        r3.clear();	 Catch:{ all -> 0x004d }
        monitor-exit(r2);	 Catch:{ all -> 0x004d }
        r2 = r5.bluetoothLeScanner;	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0045;
    L_0x0020:
        r2 = new android.bluetooth.le.ScanSettings$Builder;	 Catch:{ Exception -> 0x003d }
        r2.<init>();	 Catch:{ Exception -> 0x003d }
        r3 = 2;	 Catch:{ Exception -> 0x003d }
        r2.setScanMode(r3);	 Catch:{ Exception -> 0x003d }
        r3 = 0;	 Catch:{ Exception -> 0x003d }
        r2.setReportDelay(r3);	 Catch:{ Exception -> 0x003d }
        r3 = r5.bluetoothLeScanner;	 Catch:{ Exception -> 0x003d }
        r2 = r2.build();	 Catch:{ Exception -> 0x003d }
        r4 = r5.scanCallBack;	 Catch:{ Exception -> 0x003d }
        r3.startScan(r1, r2, r4);	 Catch:{ Exception -> 0x003d }
        r5.isScanInProgress = r0;	 Catch:{ Exception -> 0x003d }
        monitor-exit(r5);
        return;
    L_0x003d:
        r0 = new com.facebook.places.internal.ScannerException;	 Catch:{ all -> 0x0058 }
        r1 = com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR;	 Catch:{ all -> 0x0058 }
        r0.<init>(r1);	 Catch:{ all -> 0x0058 }
        throw r0;	 Catch:{ all -> 0x0058 }
    L_0x0045:
        r0 = new com.facebook.places.internal.ScannerException;	 Catch:{ all -> 0x0058 }
        r1 = com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR;	 Catch:{ all -> 0x0058 }
        r0.<init>(r1);	 Catch:{ all -> 0x0058 }
        throw r0;	 Catch:{ all -> 0x0058 }
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x004d }
        throw r0;	 Catch:{ all -> 0x0058 }
    L_0x0050:
        r0 = new com.facebook.places.internal.ScannerException;	 Catch:{ all -> 0x0058 }
        r1 = com.facebook.places.internal.ScannerException.Type.SCAN_ALREADY_IN_PROGRESS;	 Catch:{ all -> 0x0058 }
        r0.<init>(r1);	 Catch:{ all -> 0x0058 }
        throw r0;	 Catch:{ all -> 0x0058 }
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.BleScannerImpl.startScanning():void");
    }

    public synchronized void stopScanning() {
        this.bluetoothLeScanner.flushPendingScanResults(this.scanCallBack);
        this.bluetoothLeScanner.stopScan(this.scanCallBack);
        waitForMainLooper(this.params.getBluetoothFlushResultsTimeoutMs());
        this.isScanInProgress = false;
    }

    private void waitForMainLooper(long j) {
        try {
            final Object obj = new Object();
            synchronized (obj) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            synchronized (obj) {
                                obj.notify();
                            }
                        } catch (Exception e) {
                            BleScannerImpl.logException("Exception waiting for main looper", e);
                        }
                    }
                });
                obj.wait(j);
            }
        } catch (long j2) {
            logException("Exception waiting for main looper", j2);
        }
    }

    public synchronized int getErrorCode() {
        return this.errorCode;
    }

    public synchronized List<BluetoothScanResult> getScanResults() {
        List<BluetoothScanResult> arrayList;
        synchronized (this.scanResults) {
            int bluetoothMaxScanResults = this.params.getBluetoothMaxScanResults();
            if (this.scanResults.size() > bluetoothMaxScanResults) {
                arrayList = new ArrayList(bluetoothMaxScanResults);
                Collections.sort(this.scanResults, new C18522());
                arrayList.addAll(this.scanResults.subList(0, bluetoothMaxScanResults));
            } else {
                arrayList = new ArrayList(this.scanResults.size());
                arrayList.addAll(this.scanResults);
            }
        }
        return arrayList;
    }

    private static BluetoothScanResult newBluetoothScanResult(ScanResult scanResult) {
        ScanRecord scanRecord = scanResult.getScanRecord();
        return isBeacon(scanRecord.getBytes()) ? new BluetoothScanResult(formatPayload(scanRecord.getBytes()), scanResult.getRssi(), scanResult.getTimestampNanos()) : null;
    }

    private static String formatPayload(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                return toHexString(bArr, getPayloadLength(bArr));
            }
        }
        return null;
    }

    private static int getPayloadLength(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == (byte) 0) {
                return i;
            }
            if (b < (byte) 0) {
                return bArr.length;
            }
            i += b + 1;
        }
        return bArr.length;
    }

    private static String toHexString(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i < 0 || i > bArr.length) {
            i = bArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return stringBuffer.toString();
    }

    private static void logException(String str, Exception exception) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, exception);
        }
    }

    private static boolean isBeacon(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            if (b <= (byte) 0) {
                return false;
            }
            int i2 = (b + 1) + i;
            if (i2 > length) {
                return false;
            }
            if (isAdvPacketBeacon(bArr, i)) {
                return 1;
            }
            i = i2;
        }
        return false;
    }

    private static boolean isAdvPacketBeacon(byte[] bArr, int i) {
        int i2 = i + 1;
        if (isArrayContained(bArr, i2, IBEACON_PREFIX) || isArrayContained(bArr, i2, EDDYSTONE_PREFIX) || isArrayContained(bArr, i, GRAVITY_PREFIX) || isAltBeacon(bArr, i) != null) {
            return true;
        }
        return null;
    }

    private static boolean isAltBeacon(byte[] bArr, int i) {
        int i2 = i + 5;
        boolean z = false;
        if (i2 >= bArr.length) {
            return false;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        i = bArr[i + 4];
        bArr = bArr[i2];
        if (b == (byte) 27 && b2 == (byte) -1 && i == -66 && bArr == -84) {
            z = true;
        }
        return z;
    }

    private static boolean isArrayContained(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return 1;
    }

    private static byte[] fromHexString(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
