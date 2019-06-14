package com.facebook.ads.internal.p085a;

/* renamed from: com.facebook.ads.internal.a.a */
public enum C1296a {
    CANNOT_OPEN,
    CANNOT_TRACK;

    /* renamed from: a */
    public static boolean m4441a(C1296a c1296a) {
        if (!CANNOT_OPEN.equals(c1296a)) {
            if (!CANNOT_TRACK.equals(c1296a)) {
                return false;
            }
        }
        return true;
    }
}
