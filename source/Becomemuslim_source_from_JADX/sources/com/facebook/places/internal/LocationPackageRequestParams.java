package com.facebook.places.internal;

import com.amplitude.api.Constants;

public class LocationPackageRequestParams {
    private static final boolean DEFAULT_BLUETOOTH_ENABLED = true;
    private static final long DEFAULT_BLUETOOTH_FLUSH_RESULTS_TIMEOUT_MS = 300;
    private static final int DEFAULT_BLUETOOTH_MAX_SCAN_RESULTS = 25;
    private static final long DEFAULT_BLUETOOTH_SCAN_DURATION_MS = 500;
    private static final long DEFAULT_LAST_LOCATION_MAX_AGE_MS = 60000;
    private static final boolean DEFAULT_LOCATION_ENABLED = true;
    private static final float DEFAULT_LOCATION_MAX_ACCURACY_METERS = 100.0f;
    private static final String[] DEFAULT_LOCATION_PROVIDERS = new String[]{"network", "gps"};
    private static final long DEFAULT_LOCATION_REQUEST_TIMEOUT_MS = 30000;
    private static final boolean DEFAULT_WIFI_ACTIVE_SCAN_ALLOWED = true;
    private static final boolean DEFAULT_WIFI_ACTIVE_SCAN_FORCED = false;
    private static final boolean DEFAULT_WIFI_ENABLED = true;
    private static final int DEFAULT_WIFI_MAX_SCAN_RESULTS = 25;
    private static final long DEFAULT_WIFI_SCAN_MAX_AGE_MS = 30000;
    private static final long DEFAULT_WIFI_SCAN_TIMEOUT_MS = 6000;
    private long bluetoothFlushResultsTimeoutMs;
    private int bluetoothMaxScanResults;
    private long bluetoothScanDurationMs;
    private boolean isBluetoothScanEnabled;
    private boolean isLocationScanEnabled;
    private boolean isWifiActiveScanAllowed;
    private boolean isWifiActiveScanForced;
    private boolean isWifiScanEnabled;
    private long lastLocationMaxAgeMs;
    private float locationMaxAccuracyMeters;
    private final String[] locationProviders;
    private long locationRequestTimeoutMs;
    private int wifiMaxScanResults;
    private long wifiScanMaxAgeMs;
    private long wifiScanTimeoutMs;

    public static class Builder {
        private long bluetoothFlushResultsTimeoutMs = LocationPackageRequestParams.DEFAULT_BLUETOOTH_FLUSH_RESULTS_TIMEOUT_MS;
        private int bluetoothMaxScanResults = 25;
        private long bluetoothScanDurationMs = LocationPackageRequestParams.DEFAULT_BLUETOOTH_SCAN_DURATION_MS;
        private boolean isBluetoothScanEnabled = true;
        private boolean isLocationScanEnabled = true;
        private boolean isWifiActiveScanAllowed = true;
        private boolean isWifiActiveScanForced = false;
        private boolean isWifiScanEnabled = true;
        private long lastLocationMaxAgeMs = LocationPackageRequestParams.DEFAULT_LAST_LOCATION_MAX_AGE_MS;
        private float locationMaxAccuracyMeters = LocationPackageRequestParams.DEFAULT_LOCATION_MAX_ACCURACY_METERS;
        private String[] locationProviders = LocationPackageRequestParams.DEFAULT_LOCATION_PROVIDERS;
        private long locationRequestTimeoutMs = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
        private int wifiMaxScanResults = 25;
        private long wifiScanMaxAgeMs = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
        private long wifiScanTimeoutMs = 6000;

        public LocationPackageRequestParams build() {
            return new LocationPackageRequestParams();
        }

        public Builder setLocationScanEnabled(boolean z) {
            this.isLocationScanEnabled = z;
            return this;
        }

        public Builder setLastLocationMaxAgeMs(long j) {
            this.lastLocationMaxAgeMs = j;
            return this;
        }

        public Builder setLocationProviders(String[] strArr) {
            this.locationProviders = strArr;
            return this;
        }

        public Builder setLocationMaxAccuracyMeters(float f) {
            this.locationMaxAccuracyMeters = f;
            return this;
        }

        public Builder setLocationRequestTimeoutMs(long j) {
            this.locationRequestTimeoutMs = j;
            return this;
        }

        public Builder setWifiScanEnabled(boolean z) {
            this.isWifiScanEnabled = z;
            return this;
        }

        public Builder setWifiScanMaxAgeMs(long j) {
            this.wifiScanMaxAgeMs = j;
            return this;
        }

        public Builder setWifiMaxScanResults(int i) {
            this.wifiMaxScanResults = i;
            return this;
        }

        public Builder setWifiScanTimeoutMs(long j) {
            this.wifiScanTimeoutMs = j;
            return this;
        }

        public Builder setWifiActiveScanAllowed(boolean z) {
            this.isWifiActiveScanAllowed = z;
            return this;
        }

        public Builder setWifiActiveScanForced(boolean z) {
            this.isWifiActiveScanForced = z;
            return this;
        }

        public Builder setBluetoothScanEnabled(boolean z) {
            this.isBluetoothScanEnabled = z;
            return this;
        }

        public Builder setBluetoothScanDurationMs(long j) {
            this.bluetoothScanDurationMs = j;
            return this;
        }

        public Builder setBluetoothMaxScanResults(int i) {
            this.bluetoothMaxScanResults = i;
            return this;
        }

        public Builder setBluetoothFlushResultsTimeoutMs(long j) {
            this.bluetoothFlushResultsTimeoutMs = j;
            return this;
        }
    }

    private LocationPackageRequestParams(Builder builder) {
        this.isLocationScanEnabled = builder.isLocationScanEnabled;
        this.locationProviders = builder.locationProviders;
        this.locationMaxAccuracyMeters = builder.locationMaxAccuracyMeters;
        this.locationRequestTimeoutMs = builder.locationRequestTimeoutMs;
        this.lastLocationMaxAgeMs = builder.lastLocationMaxAgeMs;
        this.isWifiScanEnabled = builder.isWifiScanEnabled;
        this.wifiScanMaxAgeMs = builder.wifiScanMaxAgeMs;
        this.wifiMaxScanResults = builder.wifiMaxScanResults;
        this.wifiScanTimeoutMs = builder.wifiScanTimeoutMs;
        this.isWifiActiveScanAllowed = builder.isWifiActiveScanAllowed;
        this.isWifiActiveScanForced = builder.isWifiActiveScanForced;
        this.isBluetoothScanEnabled = builder.isBluetoothScanEnabled;
        this.bluetoothScanDurationMs = builder.bluetoothScanDurationMs;
        this.bluetoothMaxScanResults = builder.bluetoothMaxScanResults;
        this.bluetoothFlushResultsTimeoutMs = builder.bluetoothFlushResultsTimeoutMs;
    }

    public boolean isLocationScanEnabled() {
        return this.isLocationScanEnabled;
    }

    public String[] getLocationProviders() {
        return this.locationProviders;
    }

    public float getLocationMaxAccuracyMeters() {
        return this.locationMaxAccuracyMeters;
    }

    public long getLocationRequestTimeoutMs() {
        return this.locationRequestTimeoutMs;
    }

    public long getLastLocationMaxAgeMs() {
        return this.lastLocationMaxAgeMs;
    }

    public boolean isWifiScanEnabled() {
        return this.isWifiScanEnabled;
    }

    public long getWifiScanMaxAgeMs() {
        return this.wifiScanMaxAgeMs;
    }

    public int getWifiMaxScanResults() {
        return this.wifiMaxScanResults;
    }

    public long getWifiScanTimeoutMs() {
        return this.wifiScanTimeoutMs;
    }

    public boolean isWifiActiveScanAllowed() {
        return this.isWifiActiveScanAllowed;
    }

    public boolean isWifiActiveScanForced() {
        return this.isWifiActiveScanForced;
    }

    public boolean isBluetoothScanEnabled() {
        return this.isBluetoothScanEnabled;
    }

    public long getBluetoothScanDurationMs() {
        return this.bluetoothScanDurationMs;
    }

    public long getBluetoothFlushResultsTimeoutMs() {
        return this.bluetoothFlushResultsTimeoutMs;
    }

    public int getBluetoothMaxScanResults() {
        return this.bluetoothMaxScanResults;
    }
}
