package com.google.android.gms.common.util;

import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.common.util.s */
public class C2908s {
    /* renamed from: a */
    private static final Pattern f7395a = Pattern.compile("\\$\\{(.*?)\\}");

    /* renamed from: a */
    public static boolean m8473a(String str) {
        if (str != null) {
            if (str.trim().isEmpty() == null) {
                return null;
            }
        }
        return true;
    }
}
