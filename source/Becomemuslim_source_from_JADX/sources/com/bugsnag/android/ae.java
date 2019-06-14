package com.bugsnag.android;

import java.util.Map;

/* compiled from: MapUtils */
final class ae {
    /* renamed from: a */
    static String m3737a(String str, Map<String, Object> map) {
        str = map.get(str);
        return (str instanceof String) != null ? str : null;
    }
}
