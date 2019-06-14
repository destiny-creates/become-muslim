package io.nlopez.smartlocation.p359a.p361b;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.C3169a;
import com.facebook.places.model.PlaceFields;
import io.nlopez.smartlocation.C6544d;
import io.nlopez.smartlocation.p359a.C6527a;
import io.nlopez.smartlocation.p359a.C6530b;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p364b.C6538b;

/* compiled from: LocationManagerProvider */
/* renamed from: io.nlopez.smartlocation.a.b.c */
public class C7632c implements LocationListener, C6527a {
    /* renamed from: a */
    private LocationManager f26367a;
    /* renamed from: b */
    private C6544d f26368b;
    /* renamed from: c */
    private C6530b f26369c;
    /* renamed from: d */
    private C6538b f26370d;
    /* renamed from: e */
    private Context f26371e;

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* renamed from: a */
    public void mo5492a(Context context, C6538b c6538b) {
        this.f26367a = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
        this.f26370d = c6538b;
        this.f26371e = context;
        this.f26369c = new C6530b(context);
    }

    /* renamed from: a */
    public void mo5495a(C6544d c6544d, C6526b c6526b, boolean z) {
        this.f26368b = c6544d;
        if (c6544d == null) {
            this.f26370d.mo5497a("Listener is null, you sure about this?", new Object[0]);
        }
        Criteria a = m34473a(c6526b);
        if (!z) {
            this.f26367a.requestLocationUpdates(c6526b.m26686a(), c6526b.m26687b(), a, this, Looper.getMainLooper());
        } else if (C3169a.b(this.f26371e, "android.permission.ACCESS_FINE_LOCATION") == null || C3169a.b(this.f26371e, "android.permission.ACCESS_COARSE_LOCATION") == null) {
            this.f26367a.requestSingleUpdate(a, this, Looper.getMainLooper());
        } else {
            this.f26370d.mo5499b("Permission check failed. Please handle it in your app before setting up location", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo5490a() {
        if (C3169a.b(this.f26371e, "android.permission.ACCESS_FINE_LOCATION") == 0 || C3169a.b(this.f26371e, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.f26367a.removeUpdates(this);
        }
    }

    /* renamed from: b */
    public Location mo5496b() {
        Location lastKnownLocation;
        if (this.f26367a != null) {
            if (C3169a.b(this.f26371e, "android.permission.ACCESS_FINE_LOCATION") != 0 && C3169a.b(this.f26371e, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            lastKnownLocation = this.f26367a.getLastKnownLocation("gps");
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
        }
        lastKnownLocation = this.f26369c.m26694a("LMP");
        if (lastKnownLocation != null) {
            return lastKnownLocation;
        }
        return null;
    }

    /* renamed from: a */
    private Criteria m34473a(C6526b c6526b) {
        c6526b = c6526b.m26688c();
        Criteria criteria = new Criteria();
        switch (c6526b) {
            case HIGH:
                criteria.setAccuracy(1);
                criteria.setHorizontalAccuracy(3);
                criteria.setVerticalAccuracy(3);
                criteria.setBearingAccuracy(3);
                criteria.setSpeedAccuracy(3);
                criteria.setPowerRequirement(3);
                break;
            case MEDIUM:
                criteria.setAccuracy(2);
                criteria.setHorizontalAccuracy(2);
                criteria.setVerticalAccuracy(2);
                criteria.setBearingAccuracy(2);
                criteria.setSpeedAccuracy(2);
                criteria.setPowerRequirement(2);
                break;
            default:
                criteria.setAccuracy(2);
                criteria.setHorizontalAccuracy(1);
                criteria.setVerticalAccuracy(1);
                criteria.setBearingAccuracy(1);
                criteria.setSpeedAccuracy(1);
                criteria.setPowerRequirement(1);
                break;
        }
        return criteria;
    }

    public void onLocationChanged(Location location) {
        this.f26370d.mo5497a("onLocationChanged", location);
        if (this.f26368b != null) {
            this.f26368b.onLocationUpdated(location);
        }
        if (this.f26369c != null) {
            this.f26370d.mo5497a("Stored in SharedPreferences", new Object[0]);
            this.f26369c.m26695a("LMP", location);
        }
    }
}
