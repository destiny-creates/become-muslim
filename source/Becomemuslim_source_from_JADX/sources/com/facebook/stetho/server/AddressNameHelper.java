package com.facebook.stetho.server;

import com.facebook.stetho.common.ProcessUtil;

public class AddressNameHelper {
    private static final String PREFIX = "stetho_";

    public static String createCustomAddress(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREFIX);
        stringBuilder.append(ProcessUtil.getProcessName());
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
