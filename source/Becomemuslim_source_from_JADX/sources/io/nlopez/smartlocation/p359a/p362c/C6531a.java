package io.nlopez.smartlocation.p359a.p362c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import com.facebook.places.model.PlaceFields;

/* compiled from: LocationState */
/* renamed from: io.nlopez.smartlocation.a.c.a */
public class C6531a {
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: a */
    private static C6531a f21043a;
    /* renamed from: b */
    private Context f21044b;
    /* renamed from: c */
    private LocationManager f21045c;

    private C6531a(Context context) {
        this.f21044b = context;
        this.f21045c = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
    }

    /* renamed from: a */
    public static C6531a m26696a(Context context) {
        if (f21043a == null) {
            f21043a = new C6531a(context.getApplicationContext());
        }
        return f21043a;
    }

    /* renamed from: a */
    public boolean m26697a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 1;
        r2 = 19;
        if (r0 < r2) goto L_0x001a;
    L_0x0007:
        r0 = 0;
        r2 = r4.f21044b;	 Catch:{ SettingNotFoundException -> 0x0015 }
        r2 = r2.getContentResolver();	 Catch:{ SettingNotFoundException -> 0x0015 }
        r3 = "location_mode";	 Catch:{ SettingNotFoundException -> 0x0015 }
        r2 = android.provider.Settings.Secure.getInt(r2, r3);	 Catch:{ SettingNotFoundException -> 0x0015 }
        goto L_0x0016;
    L_0x0015:
        r2 = 0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = 1;
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r4.f21044b;
        r0 = r0.getContentResolver();
        r2 = "location_providers_allowed";
        r0 = android.provider.Settings.Secure.getString(r0, r2);
        r0 = android.text.TextUtils.isEmpty(r0);
        r0 = r0 ^ r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.nlopez.smartlocation.a.c.a.a():boolean");
    }

    /* renamed from: b */
    public boolean m26698b() {
        if (!m26699c()) {
            if (!m26700d()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m26699c() {
        return this.f21045c.isProviderEnabled("gps");
    }

    /* renamed from: d */
    public boolean m26700d() {
        return this.f21045c.isProviderEnabled("network");
    }

    /* renamed from: e */
    public boolean m26701e() {
        return this.f21045c.isProviderEnabled("passive");
    }
}
