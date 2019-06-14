package com.facebook.places.internal;

import com.facebook.places.internal.ScannerException.Type;
import java.util.List;

public class BleScannerLegacy implements BleScanner {
    public int getErrorCode() {
        return -1;
    }

    public List<BluetoothScanResult> getScanResults() {
        return null;
    }

    BleScannerLegacy() {
    }

    public void initAndCheckEligibility() {
        throw new ScannerException(Type.NOT_SUPPORTED);
    }

    public void startScanning() {
        throw new ScannerException(Type.NOT_SUPPORTED);
    }

    public void stopScanning() {
        throw new ScannerException(Type.NOT_SUPPORTED);
    }
}
