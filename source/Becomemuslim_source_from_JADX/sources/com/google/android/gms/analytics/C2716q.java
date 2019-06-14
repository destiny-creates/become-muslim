package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.analytics.q */
public abstract class C2716q<T extends C2716q> {
    /* renamed from: a */
    public abstract void m7760a(T t);

    /* renamed from: a */
    public static String m7759a(Map map) {
        return C2716q.m7758a(map, 1);
    }

    /* renamed from: a */
    public static String m7757a(Object obj) {
        return C2716q.m7758a(obj, 0);
    }

    /* renamed from: a */
    private static String m7758a(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj) != 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof List) {
            r0 = new StringBuilder();
            if (i > 0) {
                r0.append("[");
            }
            List list = (List) obj;
            int length = r0.length();
            for (Object next : list) {
                if (r0.length() > length) {
                    r0.append(", ");
                }
                r0.append(C2716q.m7758a(next, i + 1));
            }
            if (i > 0) {
                r0.append("]");
            }
            return r0.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            r0 = new StringBuilder();
            Object obj2 = null;
            int i2 = 0;
            for (Entry entry : new TreeMap((Map) obj).entrySet()) {
                Object a = C2716q.m7758a(entry.getValue(), i + 1);
                if (!TextUtils.isEmpty(a)) {
                    if (i > 0 && obj2 == null) {
                        r0.append("{");
                        i2 = r0.length();
                        obj2 = 1;
                    }
                    if (r0.length() > i2) {
                        r0.append(", ");
                    }
                    r0.append((String) entry.getKey());
                    r0.append('=');
                    r0.append(a);
                }
            }
            if (obj2 != null) {
                r0.append("}");
            }
            return r0.toString();
        }
    }
}
