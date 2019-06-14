package com.facebook.places.model;

import android.location.Location;
import java.util.HashSet;
import java.util.Set;

public class CurrentPlaceRequestParams {
    private final Set<String> fields;
    private final int limit;
    private final Location location;
    private final ConfidenceLevel minConfidenceLevel;
    private final ScanMode scanMode;

    public static class Builder {
        private final Set<String> fields = new HashSet();
        private int limit;
        private Location location;
        private ConfidenceLevel minConfidenceLevel;
        private ScanMode scanMode = ScanMode.HIGH_ACCURACY;

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setScanMode(ScanMode scanMode) {
            this.scanMode = scanMode;
            return this;
        }

        public Builder setMinConfidenceLevel(ConfidenceLevel confidenceLevel) {
            this.minConfidenceLevel = confidenceLevel;
            return this;
        }

        public Builder setLimit(int i) {
            this.limit = i;
            return this;
        }

        public Builder addField(String str) {
            this.fields.add(str);
            return this;
        }

        public CurrentPlaceRequestParams build() {
            return new CurrentPlaceRequestParams();
        }
    }

    public enum ConfidenceLevel {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum ScanMode {
        HIGH_ACCURACY,
        LOW_LATENCY
    }

    private CurrentPlaceRequestParams(Builder builder) {
        this.fields = new HashSet();
        this.location = builder.location;
        this.scanMode = builder.scanMode;
        this.minConfidenceLevel = builder.minConfidenceLevel;
        this.limit = builder.limit;
        this.fields.addAll(builder.fields);
    }

    public Location getLocation() {
        return this.location;
    }

    public ScanMode getScanMode() {
        return this.scanMode;
    }

    public ConfidenceLevel getMinConfidenceLevel() {
        return this.minConfidenceLevel;
    }

    public int getLimit() {
        return this.limit;
    }

    public Set<String> getFields() {
        return this.fields;
    }
}
