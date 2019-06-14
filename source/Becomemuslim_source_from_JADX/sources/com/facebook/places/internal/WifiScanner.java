package com.facebook.places.internal;

import java.util.List;

public interface WifiScanner {
    WifiScanResult getConnectedWifi();

    List<WifiScanResult> getWifiScans();

    void initAndCheckEligibility();

    boolean isWifiScanningEnabled();
}
