package host.exp.exponent.p337d;

import android.content.Context;
import android.provider.Settings.System;
import host.exp.exponent.p339f.C6333f;
import host.exp.exponent.p343g.C6368f;
import host.exp.p333a.C6271b;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* compiled from: ExceptionUtils */
/* renamed from: host.exp.exponent.d.a */
public class C6299a {
    /* renamed from: a */
    public static C6333f m25994a(Exception exception) {
        Context d = C6271b.m25897a().m25924d();
        C6333f a = C6333f.m26051a(exception.toString());
        if (d == null) {
            return a;
        }
        if (exception instanceof C6300b) {
            String exception2 = exception.toString();
            C6300b c6300b = (C6300b) exception;
            if (c6300b.m25997a() != null) {
                String a2 = C6299a.m25995a(c6300b.m25997a(), d);
                if (a2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(exception2);
                    stringBuilder.append(" ");
                    stringBuilder.append(a2);
                    exception2 = stringBuilder.toString();
                }
            }
            return new C6333f(exception2, c6300b.m25998b());
        }
        exception = C6299a.m25995a(exception, d);
        return exception != null ? a.m26054b(exception) : a;
    }

    /* renamed from: a */
    private static String m25995a(Exception exception, Context context) {
        if (!(exception instanceof UnknownHostException)) {
            if (!(exception instanceof ConnectException)) {
                if ((exception instanceof SocketTimeoutException) != null) {
                    return "Network response timed out.";
                }
                return null;
            }
        }
        if (C6299a.m25996a(context) != null) {
            return "Airplane mode is on. Please turn off and try again.";
        }
        if (C6368f.m26111a(context) == null) {
            return "Can't connect to internet. Please try again.";
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m25996a(Context context) {
        return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != null;
    }
}
