package com.facebook.places.internal;

public class ScannerException extends Exception {
    public Type type;

    public enum Type {
        NOT_SUPPORTED,
        PERMISSION_DENIED,
        DISABLED,
        SCAN_ALREADY_IN_PROGRESS,
        UNKNOWN_ERROR,
        TIMEOUT
    }

    public ScannerException(Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type: ");
        stringBuilder.append(type.name());
        super(stringBuilder.toString());
        this.type = type;
    }

    public ScannerException(Type type, String str) {
        super(str);
        this.type = type;
    }

    public ScannerException(Type type, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type: ");
        stringBuilder.append(type.name());
        super(stringBuilder.toString(), exception);
        this.type = type;
    }
}
