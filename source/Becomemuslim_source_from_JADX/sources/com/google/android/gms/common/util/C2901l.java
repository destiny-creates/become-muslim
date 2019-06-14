package com.google.android.gms.common.util;

import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.common.util.l */
public class C2901l {
    /* renamed from: a */
    private static final Pattern f7390a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    /* renamed from: b */
    private static final Pattern f7391b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    /* renamed from: c */
    private static final Pattern f7392c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    /* renamed from: a */
    public static Map<String, String> m8449a(URI uri, String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        uri = uri.getRawQuery();
        if (uri != null && uri.length() > 0) {
            emptyMap = new HashMap();
            Scanner scanner = new Scanner(uri);
            scanner.useDelimiter("&");
            while (scanner.hasNext() != null) {
                uri = scanner.next().split("=");
                if (uri.length == 0 || uri.length > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                String a = C2901l.m8448a(uri[0], str);
                Object obj = null;
                if (uri.length == 2) {
                    obj = C2901l.m8448a(uri[1], str);
                }
                emptyMap.put(a, obj);
            }
        }
        return emptyMap;
    }

    /* renamed from: a */
    private static String m8448a(String str, String str2) {
        if (str2 == null) {
            try {
                str2 = "ISO-8859-1";
            } catch (String str3) {
                throw new IllegalArgumentException(str3);
            }
        }
        return URLDecoder.decode(str3, str2);
    }
}
