package com.facebook.react.uimanager;

public class ReactInvalidPropertyException extends RuntimeException {
    public ReactInvalidPropertyException(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid React property `");
        stringBuilder.append(str);
        stringBuilder.append("` with value `");
        stringBuilder.append(str2);
        stringBuilder.append("`, expected ");
        stringBuilder.append(str3);
        super(stringBuilder.toString());
    }
}
