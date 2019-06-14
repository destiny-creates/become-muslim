package io.nlopez.smartlocation.geofencing;

import android.content.SharedPreferences;
import io.nlopez.smartlocation.geofencing.p366a.C6558a;
import io.nlopez.smartlocation.geofencing.p366a.C6558a.C6557a;

/* compiled from: GeofencingStore */
/* renamed from: io.nlopez.smartlocation.geofencing.a */
public class C6559a {
    /* renamed from: a */
    private static final String f21087a;
    /* renamed from: b */
    private SharedPreferences f21088b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6559a.class.getCanonicalName());
        stringBuilder.append(".KEY");
        f21087a = stringBuilder.toString();
    }

    /* renamed from: a */
    public C6558a m26764a(String str) {
        if (this.f21088b == null || !this.f21088b.contains(m26763a(str, "LATITUDE")) || !this.f21088b.contains(m26763a(str, "LONGITUDE"))) {
            return null;
        }
        C6557a c6557a = new C6557a(str);
        c6557a.m26756a(Double.longBitsToDouble(this.f21088b.getLong(m26763a(str, "LATITUDE"), 0)));
        c6557a.m26761b(Double.longBitsToDouble(this.f21088b.getLong(m26763a(str, "LONGITUDE"), 0)));
        c6557a.m26757a(this.f21088b.getFloat(m26763a(str, "RADIUS"), 0.0f));
        c6557a.m26758a(this.f21088b.getInt(m26763a(str, "TRANSITION"), 0));
        c6557a.m26759a(this.f21088b.getLong(m26763a(str, "EXPIRATION"), 0));
        c6557a.m26762b(this.f21088b.getInt(m26763a(str, "LOITERING_DELAY"), 0));
        return c6557a.m26760a();
    }

    /* renamed from: a */
    private String m26763a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f21087a);
        stringBuilder.append("_");
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
