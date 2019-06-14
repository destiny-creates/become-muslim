package org.apache.p371a.p372a;

/* compiled from: Util */
/* renamed from: org.apache.a.a.o */
class C6636o {
    /* renamed from: a */
    static String m27019a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("--")) {
            return str.substring(2, str.length());
        }
        return str.startsWith("-") ? str.substring(1, str.length()) : str;
    }

    /* renamed from: b */
    static String m27020b(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }
}
