package expolib_v1.p321a.p322a.p325c;

import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6246z;
import java.net.Proxy.Type;

/* compiled from: RequestLine */
/* renamed from: expolib_v1.a.a.c.i */
public final class C6162i {
    /* renamed from: a */
    public static String m25299a(C6246z c6246z, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c6246z.m25823b());
        stringBuilder.append(' ');
        if (C6162i.m25300b(c6246z, type) != null) {
            stringBuilder.append(c6246z.m25821a());
        } else {
            stringBuilder.append(C6162i.m25298a(c6246z.m25821a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static boolean m25300b(C6246z c6246z, Type type) {
        return (c6246z.m25830h() == null && type == Type.HTTP) ? true : null;
    }

    /* renamed from: a */
    public static String m25298a(C6237r c6237r) {
        String h = c6237r.m25771h();
        c6237r = c6237r.m25774k();
        if (c6237r == null) {
            return h;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h);
        stringBuilder.append('?');
        stringBuilder.append(c6237r);
        return stringBuilder.toString();
    }
}
