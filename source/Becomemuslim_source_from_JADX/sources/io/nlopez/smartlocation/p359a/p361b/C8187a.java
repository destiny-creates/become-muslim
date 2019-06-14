package io.nlopez.smartlocation.p359a.p361b;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.C3169a;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.C5082m;
import com.google.android.gms.location.C7836n.C5083a;
import com.google.android.gms.location.C7837o;
import com.google.android.gms.location.LocationRequest;
import io.nlopez.smartlocation.C6544d;
import io.nlopez.smartlocation.p359a.C6530b;
import io.nlopez.smartlocation.p359a.C7633c;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p364b.C6537a;
import io.nlopez.smartlocation.p364b.C6538b;
import io.nlopez.smartlocation.p364b.C6541d;

/* compiled from: LocationGooglePlayServicesProvider */
/* renamed from: io.nlopez.smartlocation.a.b.a */
public class C8187a implements C2775b, C2776c, C2815l<Status>, C5081l, C7633c {
    /* renamed from: a */
    private GoogleApiClient f30389a;
    /* renamed from: b */
    private C6538b f30390b;
    /* renamed from: c */
    private C6544d f30391c;
    /* renamed from: d */
    private boolean f30392d;
    /* renamed from: e */
    private boolean f30393e;
    /* renamed from: f */
    private C6530b f30394f;
    /* renamed from: g */
    private LocationRequest f30395g;
    /* renamed from: h */
    private Context f30396h;
    /* renamed from: i */
    private C6537a f30397i;
    /* renamed from: j */
    private C6541d f30398j;
    /* renamed from: k */
    private boolean f30399k;
    /* renamed from: l */
    private boolean f30400l;
    /* renamed from: m */
    private boolean f30401m;
    /* renamed from: n */
    private C2815l<C7837o> f30402n;

    /* compiled from: LocationGooglePlayServicesProvider */
    /* renamed from: io.nlopez.smartlocation.a.b.a$1 */
    class C76301 implements C2815l<C7837o> {
        /* renamed from: a */
        final /* synthetic */ C8187a f26359a;

        C76301(C8187a c8187a) {
            this.f26359a = c8187a;
        }

        public /* synthetic */ void onResult(C2814k c2814k) {
            m34464a((C7837o) c2814k);
        }

        /* renamed from: a */
        public void m34464a(com.google.android.gms.location.C7837o r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r5 = r5.m38225b();
            r0 = r5.e();
            r1 = 0;
            if (r0 == 0) goto L_0x0067;
        L_0x000b:
            r2 = 6;
            if (r0 == r2) goto L_0x0026;
        L_0x000e:
            r5 = 8502; // 0x2136 float:1.1914E-41 double:4.2005E-320;
            if (r0 == r5) goto L_0x0013;
        L_0x0012:
            goto L_0x0085;
        L_0x0013:
            r5 = r4.f26359a;
            r5 = r5.f30390b;
            r0 = "Location settings are inadequate, and cannot be fixed here. Dialog not created.";
            r1 = new java.lang.Object[r1];
            r5.mo5499b(r0, r1);
            r5 = r4.f26359a;
            r5.mo5490a();
            goto L_0x0085;
        L_0x0026:
            r0 = r4.f26359a;
            r0 = r0.f30390b;
            r2 = "Location settings are not satisfied. Show the user a dialog toupgrade location settings. You should hook into the Activity onActivityResult and call this provider onActivityResult method for continuing this call flow. ";
            r3 = new java.lang.Object[r1];
            r0.mo5500c(r2, r3);
            r0 = r4.f26359a;
            r0 = r0.f30396h;
            r0 = r0 instanceof android.app.Activity;
            if (r0 == 0) goto L_0x0059;
        L_0x003d:
            r0 = r4.f26359a;	 Catch:{ SendIntentException -> 0x004b }
            r0 = r0.f30396h;	 Catch:{ SendIntentException -> 0x004b }
            r0 = (android.app.Activity) r0;	 Catch:{ SendIntentException -> 0x004b }
            r2 = 20001; // 0x4e21 float:2.8027E-41 double:9.882E-320;	 Catch:{ SendIntentException -> 0x004b }
            r5.a(r0, r2);	 Catch:{ SendIntentException -> 0x004b }
            goto L_0x0085;
        L_0x004b:
            r5 = r4.f26359a;
            r5 = r5.f30390b;
            r0 = "PendingIntent unable to execute request.";
            r1 = new java.lang.Object[r1];
            r5.mo5499b(r0, r1);
            goto L_0x0085;
        L_0x0059:
            r5 = r4.f26359a;
            r5 = r5.f30390b;
            r0 = "Provided context is not the context of an activity, therefore we cant launch the resolution activity.";
            r1 = new java.lang.Object[r1];
            r5.mo5500c(r0, r1);
            goto L_0x0085;
        L_0x0067:
            r5 = r4.f26359a;
            r5 = r5.f30390b;
            r0 = "All location settings are satisfied.";
            r1 = new java.lang.Object[r1];
            r5.mo5497a(r0, r1);
            r5 = r4.f26359a;
            r0 = 1;
            r5.f30400l = r0;
            r5 = r4.f26359a;
            r0 = r4.f26359a;
            r0 = r0.f30395g;
            r5.m39755a(r0);
        L_0x0085:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.nlopez.smartlocation.a.b.a.1.a(com.google.android.gms.location.o):void");
        }
    }

    public /* synthetic */ void onResult(C2814k c2814k) {
        m39764a((Status) c2814k);
    }

    public C8187a() {
        this.f30392d = false;
        this.f30393e = false;
        this.f30401m = true;
        this.f30402n = new C76301(this);
        this.f30399k = false;
        this.f30400l = false;
    }

    public C8187a(C6537a c6537a) {
        this();
        this.f30397i = c6537a;
    }

    /* renamed from: a */
    public void mo5492a(Context context, C6538b c6538b) {
        this.f30390b = c6538b;
        this.f30396h = context;
        this.f30394f = new C6530b(context);
        if (this.f30392d) {
            c6538b.mo5497a("already started", new Object[0]);
            return;
        }
        this.f30389a = new C2774a(context).a(C5082m.f17381a).a(this).a(this).b();
        this.f30389a.connect();
    }

    /* renamed from: a */
    private LocationRequest m39753a(C6526b c6526b, boolean z) {
        LocationRequest a = LocationRequest.m38207a().m38215c(c6526b.m26686a()).m38211a(c6526b.m26686a()).m38209a(c6526b.m26687b());
        switch (c6526b.m26688c()) {
            case HIGH:
                a.m38210a(100);
                break;
            case MEDIUM:
                a.m38210a(102);
                break;
            case LOW:
                a.m38210a(104);
                break;
            case LOWEST:
                a.m38210a(105);
                break;
            default:
                break;
        }
        if (z) {
            a.m38213b(1);
        }
        return a;
    }

    /* renamed from: a */
    public void mo5495a(C6544d c6544d, C6526b c6526b, boolean z) {
        this.f30391c = c6544d;
        if (c6544d == null) {
            this.f30390b.mo5497a("Listener is null, you sure about this?", new Object[0]);
        }
        this.f30395g = m39753a(c6526b, z);
        if (this.f30389a.h() != null) {
            m39755a(this.f30395g);
        } else if (this.f30393e != null) {
            this.f30392d = true;
            this.f30389a.connect();
            this.f30393e = false;
        } else {
            this.f30392d = true;
            this.f30390b.mo5497a("still not connected - scheduled start when connection is ok", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m39755a(LocationRequest locationRequest) {
        if (!this.f30399k || this.f30400l) {
            if (!this.f30389a.h()) {
                this.f30390b.mo5500c("startUpdating executed without the GoogleApiClient being connected!!", new Object[0]);
            } else if (C3169a.b(this.f30396h, "android.permission.ACCESS_FINE_LOCATION") == 0 || C3169a.b(this.f30396h, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                C5082m.f17382b.mo4633a(this.f30389a, locationRequest, this, Looper.getMainLooper()).a(this);
            } else {
                this.f30390b.mo5499b("Permission check failed. Please handle it in your app before setting up location", new Object[0]);
                return;
            }
            return;
        }
        this.f30390b.mo5497a("startUpdating wont be executed for now, as we have to test the location settings before", new Object[0]);
        m39760c();
    }

    /* renamed from: c */
    private void m39760c() {
        C5082m.f17384d.mo4625a(this.f30389a, new C5083a().m21577a(this.f30401m).m21576a(this.f30395g).m21578a()).a(this.f30402n);
    }

    /* renamed from: a */
    public void mo5490a() {
        this.f30390b.mo5497a("stop", new Object[0]);
        if (this.f30389a.h()) {
            C5082m.f17382b.mo4634a(this.f30389a, (C5081l) this);
            this.f30389a.disconnect();
        }
        this.f30400l = false;
        this.f30392d = false;
        this.f30393e = true;
    }

    /* renamed from: b */
    public Location mo5496b() {
        if (this.f30389a != null && this.f30389a.h()) {
            if (C3169a.b(this.f30396h, "android.permission.ACCESS_FINE_LOCATION") != 0 && C3169a.b(this.f30396h, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            Location a = C5082m.f17382b.mo4629a(this.f30389a);
            if (a != null) {
                return a;
            }
        }
        if (this.f30394f != null) {
            return this.f30394f.m26694a("GMS");
        }
        return null;
    }

    public void onConnected(Bundle bundle) {
        this.f30390b.mo5497a("onConnected", new Object[0]);
        if (this.f30392d) {
            m39755a(this.f30395g);
        }
        if (this.f30397i != null) {
            this.f30397i.mo5493a(bundle);
        }
        if (this.f30398j != null) {
            this.f30398j.m26717a();
        }
    }

    public void onConnectionSuspended(int i) {
        C6538b c6538b = this.f30390b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectionSuspended ");
        stringBuilder.append(i);
        c6538b.mo5497a(stringBuilder.toString(), new Object[0]);
        if (this.f30397i != null) {
            this.f30397i.mo5491a(i);
        }
        if (this.f30398j != 0) {
            this.f30398j.m26718b();
        }
    }

    public void onConnectionFailed(C4775b c4775b) {
        C6538b c6538b = this.f30390b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectionFailed ");
        stringBuilder.append(c4775b.toString());
        c6538b.mo5497a(stringBuilder.toString(), new Object[0]);
        if (this.f30397i != null) {
            this.f30397i.mo5494a(c4775b);
        }
        if (this.f30398j != null) {
            this.f30398j.m26719c();
        }
    }

    /* renamed from: a */
    public void mo4969a(Location location) {
        this.f30390b.mo5497a("onLocationChanged", location);
        if (this.f30391c != null) {
            this.f30391c.onLocationUpdated(location);
        }
        if (this.f30394f != null) {
            this.f30390b.mo5497a("Stored in SharedPreferences", new Object[0]);
            this.f30394f.m26695a("GMS", location);
        }
    }

    /* renamed from: a */
    public void m39764a(Status status) {
        if (status.d()) {
            this.f30390b.mo5497a("Locations update request successful", new Object[0]);
        } else if (status.c() && (this.f30396h instanceof Activity)) {
            this.f30390b.mo5500c("Unable to register, but we can solve this - will startActivityForResult. You should hook into the Activity onActivityResult and call this provider onActivityResult method for continuing this call flow.", new Object[0]);
            try {
                status.a((Activity) this.f30396h, 10001);
            } catch (Status status2) {
                this.f30390b.mo5498a(status2, "problem with startResolutionForResult", new Object[0]);
            }
        } else {
            C6538b c6538b = this.f30390b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Registering failed: ");
            stringBuilder.append(status2.a());
            c6538b.mo5501d(stringBuilder.toString(), new Object[0]);
        }
    }
}
