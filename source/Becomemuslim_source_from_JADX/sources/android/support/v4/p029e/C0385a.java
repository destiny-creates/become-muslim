package android.support.v4.p029e;

import android.net.ConnectivityManager;
import android.os.Build.VERSION;

/* compiled from: ConnectivityManagerCompat */
/* renamed from: android.support.v4.e.a */
public final class C0385a {
    /* renamed from: a */
    public static boolean m1164a(ConnectivityManager connectivityManager) {
        if (VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        connectivityManager = connectivityManager.getActiveNetworkInfo();
        if (connectivityManager == null) {
            return true;
        }
        switch (connectivityManager.getType()) {
            case null:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            case 1:
            case 7:
            case 9:
                return null;
            default:
                return true;
        }
    }
}
