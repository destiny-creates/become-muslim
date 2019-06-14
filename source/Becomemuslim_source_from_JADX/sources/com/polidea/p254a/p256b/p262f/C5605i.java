package com.polidea.p254a.p256b.p262f;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.polidea.p254a.p256b.C5615p;

@TargetApi(19)
/* compiled from: CheckerLocationProvider */
/* renamed from: com.polidea.a.b.f.i */
public class C5605i {
    /* renamed from: a */
    private final ContentResolver f18736a;
    /* renamed from: b */
    private final LocationManager f18737b;

    C5605i(ContentResolver contentResolver, LocationManager locationManager) {
        this.f18736a = contentResolver;
        this.f18737b = locationManager;
    }

    /* renamed from: a */
    public boolean m23827a() {
        boolean z = true;
        if (VERSION.SDK_INT >= 19) {
            try {
                if (Secure.getInt(this.f18736a, "location_mode") == 0) {
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                C5615p.m23866b(e, "Could not use LOCATION_MODE check. Falling back to legacy method.", new Object[0]);
            }
        }
        if (!this.f18737b.isProviderEnabled("network")) {
            if (!this.f18737b.isProviderEnabled("gps")) {
                z = false;
            }
        }
        return z;
    }
}
