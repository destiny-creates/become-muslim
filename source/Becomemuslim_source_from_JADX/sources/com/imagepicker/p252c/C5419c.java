package com.imagepicker.p252c;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ReadableMapUtils */
/* renamed from: com.imagepicker.c.c */
public class C5419c {
    /* renamed from: a */
    public static boolean m22997a(Class cls, ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
            return false;
        }
        if (String.class.equals(cls) != null) {
            return TextUtils.isEmpty(readableMap.getString(str)) ^ 1;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m22996a(ReadableMap readableMap, String str) {
        return C5419c.m22997a(ReadableMap.class, readableMap, str);
    }

    /* renamed from: b */
    public static boolean m22998b(ReadableMap readableMap, String str) {
        return C5419c.m22997a(String.class, readableMap, str);
    }
}
