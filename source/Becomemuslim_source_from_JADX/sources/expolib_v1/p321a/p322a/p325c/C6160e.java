package expolib_v1.p321a.p322a.p325c;

import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import expolib_v1.p321a.C6228l;
import expolib_v1.p321a.C6229m;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.p322a.C6165c;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* compiled from: HttpHeaders */
/* renamed from: expolib_v1.a.a.c.e */
public final class C6160e {
    /* renamed from: a */
    private static final Pattern f19903a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static long m25280a(ab abVar) {
        return C6160e.m25281a(abVar.m25584g());
    }

    /* renamed from: a */
    public static long m25281a(C6234q c6234q) {
        return C6160e.m25282a(c6234q.m25718a(HttpHeaders.CONTENT_LENGTH));
    }

    /* renamed from: a */
    private static long m25282a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.e.a(java.lang.String):long");
    }

    /* renamed from: a */
    public static boolean m25285a(ab abVar, C6234q c6234q, C6246z c6246z) {
        for (String str : C6160e.m25292e(abVar)) {
            if (!C6165c.m25319a(c6234q.m25721b(str), c6246z.m25824b(str))) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m25287b(ab abVar) {
        return C6160e.m25288b(abVar.m25584g());
    }

    /* renamed from: b */
    public static boolean m25288b(C6234q c6234q) {
        return C6160e.m25290c(c6234q).contains("*");
    }

    /* renamed from: e */
    private static Set<String> m25292e(ab abVar) {
        return C6160e.m25290c(abVar.m25584g());
    }

    /* renamed from: c */
    public static Set<String> m25290c(C6234q c6234q) {
        Set<String> emptySet = Collections.emptySet();
        int a = c6234q.m25716a();
        Set<String> set = emptySet;
        for (int i = 0; i < a; i++) {
            if ("Vary".equalsIgnoreCase(c6234q.m25717a(i))) {
                String b = c6234q.m25720b(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    /* renamed from: c */
    public static C6234q m25289c(ab abVar) {
        return C6160e.m25283a(abVar.m25587j().m25576a().m25825c(), abVar.m25584g());
    }

    /* renamed from: a */
    public static C6234q m25283a(C6234q c6234q, C6234q c6234q2) {
        c6234q2 = C6160e.m25290c(c6234q2);
        if (c6234q2.isEmpty()) {
            return new C6233a().m25709a();
        }
        C6233a c6233a = new C6233a();
        int a = c6234q.m25716a();
        for (int i = 0; i < a; i++) {
            String a2 = c6234q.m25717a(i);
            if (c6234q2.contains(a2)) {
                c6233a.m25708a(a2, c6234q.m25720b(i));
            }
        }
        return c6233a.m25709a();
    }

    /* renamed from: a */
    public static void m25284a(C6229m c6229m, C6237r c6237r, C6234q c6234q) {
        if (c6229m != C6229m.f20280a) {
            c6234q = C6228l.m25680a(c6237r, c6234q);
            if (!c6234q.isEmpty()) {
                c6229m.saveFromResponse(c6237r, c6234q);
            }
        }
    }

    /* renamed from: d */
    public static boolean m25291d(ab abVar) {
        if (abVar.m25576a().m25823b().equals("HEAD")) {
            return false;
        }
        int c = abVar.m25580c();
        if (((c >= 100 && c < HttpStatus.HTTP_OK) || c == 204 || c == 304) && C6160e.m25280a(abVar) == -1) {
            if ("chunked".equalsIgnoreCase(abVar.m25577a("Transfer-Encoding")) == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m25279a(String str, int i, String str2) {
        while (i < str.length()) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m25278a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m25286b(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0019 }
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x000f;
    L_0x000b:
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        return r2;
    L_0x000f:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0017;
    L_0x0015:
        r2 = 0;
        return r2;
    L_0x0017:
        r2 = (int) r0;
        return r2;
    L_0x0019:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.e.b(java.lang.String, int):int");
    }
}
