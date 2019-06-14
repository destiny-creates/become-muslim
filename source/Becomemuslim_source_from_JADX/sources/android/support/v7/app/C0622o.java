package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.C0382f;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import java.util.Calendar;

/* compiled from: TwilightManager */
/* renamed from: android.support.v7.app.o */
class C0622o {
    /* renamed from: a */
    private static C0622o f1610a;
    /* renamed from: b */
    private final Context f1611b;
    /* renamed from: c */
    private final LocationManager f1612c;
    /* renamed from: d */
    private final C0621a f1613d = new C0621a();

    /* compiled from: TwilightManager */
    /* renamed from: android.support.v7.app.o$a */
    private static class C0621a {
        /* renamed from: a */
        boolean f1604a;
        /* renamed from: b */
        long f1605b;
        /* renamed from: c */
        long f1606c;
        /* renamed from: d */
        long f1607d;
        /* renamed from: e */
        long f1608e;
        /* renamed from: f */
        long f1609f;

        C0621a() {
        }
    }

    /* renamed from: a */
    static C0622o m2099a(Context context) {
        if (f1610a == null) {
            context = context.getApplicationContext();
            f1610a = new C0622o(context, (LocationManager) context.getSystemService(PlaceFields.LOCATION));
        }
        return f1610a;
    }

    C0622o(Context context, LocationManager locationManager) {
        this.f1611b = context;
        this.f1612c = locationManager;
    }

    /* renamed from: a */
    boolean m2103a() {
        C0621a c0621a = this.f1613d;
        if (m2102c()) {
            return c0621a.f1604a;
        }
        Location b = m2101b();
        if (b != null) {
            m2100a(b);
            return c0621a.f1604a;
        }
        boolean z;
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        if (i >= 6) {
            if (i < 22) {
                z = false;
                return z;
            }
        }
        z = true;
        return z;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m2101b() {
        Location location = null;
        Location a = C0382f.m1159a(this.f1611b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m2098a("network") : null;
        if (C0382f.m1159a(this.f1611b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2098a("gps");
        }
        if (location == null || a == null) {
            if (location != null) {
                a = location;
            }
            return a;
        }
        if (location.getTime() > a.getTime()) {
            a = location;
        }
        return a;
    }

    /* renamed from: a */
    private Location m2098a(String str) {
        try {
            if (this.f1612c.isProviderEnabled(str)) {
                return this.f1612c.getLastKnownLocation(str);
            }
        } catch (String str2) {
            Log.d("TwilightManager", "Failed to get last known location", str2);
        }
        return null;
    }

    /* renamed from: c */
    private boolean m2102c() {
        return this.f1613d.f1609f > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m2100a(Location location) {
        long j;
        C0621a c0621a = this.f1613d;
        long currentTimeMillis = System.currentTimeMillis();
        C0620n a = C0620n.m2096a();
        C0620n c0620n = a;
        c0620n.m2097a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1601a;
        c0620n.m2097a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1603c == 1;
        long j3 = a.f1602b;
        long j4 = j2;
        j2 = a.f1601a;
        long j5 = j3;
        boolean z2 = z;
        a.m2097a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = a.f1602b;
        if (j5 != -1) {
            if (j2 != -1) {
                j = currentTimeMillis > j2 ? 0 + j6 : currentTimeMillis > j5 ? 0 + j2 : 0 + j5;
                j += 60000;
                c0621a.f1604a = z2;
                c0621a.f1605b = j4;
                c0621a.f1606c = j5;
                c0621a.f1607d = j2;
                c0621a.f1608e = j6;
                c0621a.f1609f = j;
            }
        }
        j = 43200000 + currentTimeMillis;
        c0621a.f1604a = z2;
        c0621a.f1605b = j4;
        c0621a.f1606c = j5;
        c0621a.f1607d = j2;
        c0621a.f1608e = j6;
        c0621a.f1609f = j;
    }
}
