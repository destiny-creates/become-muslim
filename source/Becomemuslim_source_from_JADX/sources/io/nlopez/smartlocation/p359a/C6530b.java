package io.nlopez.smartlocation.p359a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;

/* compiled from: LocationStore */
/* renamed from: io.nlopez.smartlocation.a.b */
public class C6530b {
    /* renamed from: a */
    private static final String f21041a;
    /* renamed from: b */
    private SharedPreferences f21042b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6530b.class.getCanonicalName());
        stringBuilder.append(".KEY");
        f21041a = stringBuilder.toString();
    }

    public C6530b(Context context) {
        this.f21042b = context.getSharedPreferences("LOCATION_STORE", 0);
    }

    /* renamed from: a */
    public void m26695a(String str, Location location) {
        Editor edit = this.f21042b.edit();
        edit.putString(m26693a(str, "PROVIDER"), location.getProvider());
        edit.putLong(m26693a(str, "LATITUDE"), Double.doubleToLongBits(location.getLatitude()));
        edit.putLong(m26693a(str, "LONGITUDE"), Double.doubleToLongBits(location.getLongitude()));
        edit.putFloat(m26693a(str, "ACCURACY"), location.getAccuracy());
        edit.putLong(m26693a(str, "ALTITUDE"), Double.doubleToLongBits(location.getAltitude()));
        edit.putFloat(m26693a(str, "SPEED"), location.getSpeed());
        edit.putLong(m26693a(str, "TIME"), location.getTime());
        edit.putFloat(m26693a(str, "BEARING"), location.getBearing());
        edit.apply();
    }

    /* renamed from: a */
    public Location m26694a(String str) {
        if (this.f21042b == null || !this.f21042b.contains(m26693a(str, "LATITUDE")) || !this.f21042b.contains(m26693a(str, "LONGITUDE"))) {
            return null;
        }
        Location location = new Location(this.f21042b.getString("PROVIDER", "LocationStore"));
        location.setLatitude(Double.longBitsToDouble(this.f21042b.getLong(m26693a(str, "LATITUDE"), 0)));
        location.setLongitude(Double.longBitsToDouble(this.f21042b.getLong(m26693a(str, "LONGITUDE"), 0)));
        location.setAccuracy(this.f21042b.getFloat(m26693a(str, "ACCURACY"), 0.0f));
        location.setAltitude(Double.longBitsToDouble(this.f21042b.getLong(m26693a(str, "ALTITUDE"), 0)));
        location.setSpeed(this.f21042b.getFloat(m26693a(str, "SPEED"), 0.0f));
        location.setTime(this.f21042b.getLong(m26693a(str, "TIME"), 0));
        location.setBearing(this.f21042b.getFloat(m26693a(str, "BEARING"), 0.0f));
        return location;
    }

    /* renamed from: a */
    private String m26693a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f21041a);
        stringBuilder.append("_");
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
