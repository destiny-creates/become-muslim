package expolib_v1.p321a.p322a.p325c;

/* compiled from: HttpMethod */
/* renamed from: expolib_v1.a.a.c.f */
public final class C6161f {
    /* renamed from: a */
    public static boolean m25293a(String str) {
        if (!(str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE"))) {
            if (str.equals("MOVE") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m25294b(String str) {
        if (!(str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH"))) {
            if (str.equals("REPORT") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m25295c(String str) {
        if (!(C6161f.m25294b(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL"))) {
            if (str.equals("LOCK") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m25296d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m25297e(String str) {
        return str.equals("PROPFIND") ^ 1;
    }
}
