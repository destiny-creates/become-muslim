package com.facebook.places.internal;

import java.util.List;

public interface BleScanner {
    int getErrorCode();

    List<BluetoothScanResult> getScanResults();

    void initAndCheckEligibility();

    void startScanning();

    void stopScanning();
}
