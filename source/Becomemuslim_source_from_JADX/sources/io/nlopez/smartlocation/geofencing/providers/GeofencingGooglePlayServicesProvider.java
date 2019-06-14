package io.nlopez.smartlocation.geofencing.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C3169a;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C5076f;
import com.google.android.gms.location.C5078i;
import com.google.android.gms.location.C5082m;
import io.nlopez.smartlocation.C6543c;
import io.nlopez.smartlocation.geofencing.C6559a;
import io.nlopez.smartlocation.geofencing.p366a.C6558a;
import io.nlopez.smartlocation.geofencing.p367b.C6560a;
import io.nlopez.smartlocation.p364b.C6537a;
import io.nlopez.smartlocation.p364b.C6538b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeofencingGooglePlayServicesProvider implements C2775b, C2776c, C2815l<Status> {
    /* renamed from: a */
    public static final String f26395a;
    /* renamed from: b */
    private final List<C5076f> f26396b;
    /* renamed from: c */
    private final List<String> f26397c;
    /* renamed from: d */
    private GoogleApiClient f26398d;
    /* renamed from: e */
    private C6538b f26399e;
    /* renamed from: f */
    private C6543c f26400f;
    /* renamed from: g */
    private C6559a f26401g;
    /* renamed from: h */
    private Context f26402h;
    /* renamed from: i */
    private PendingIntent f26403i;
    /* renamed from: j */
    private boolean f26404j;
    /* renamed from: k */
    private final C6537a f26405k;
    /* renamed from: l */
    private BroadcastReceiver f26406l;

    /* renamed from: io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider$1 */
    class C65611 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ GeofencingGooglePlayServicesProvider f21091a;

        C65611(GeofencingGooglePlayServicesProvider geofencingGooglePlayServicesProvider) {
            this.f21091a = geofencingGooglePlayServicesProvider;
        }

        public void onReceive(Context context, Intent intent) {
            if (GeofencingGooglePlayServicesProvider.f26395a.equals(intent.getAction()) != null && intent.hasExtra("geofences") != null) {
                this.f21091a.f26399e.mo5497a("Received geofencing event", new Object[0]);
                context = intent.getIntExtra("transition", -1);
                for (String str : intent.getStringArrayListExtra("geofences")) {
                    C6558a a = this.f21091a.f26401g.m26764a(str);
                    if (a != null) {
                        this.f21091a.f26400f.m26720a(new C6560a(a, context));
                    } else {
                        C6538b a2 = this.f21091a.f26399e;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Tried to retrieve geofence ");
                        stringBuilder.append(str);
                        stringBuilder.append(" but it was not in the store");
                        a2.mo5500c(stringBuilder.toString(), new Object[0]);
                    }
                }
            }
        }
    }

    public static class GeofencingService extends IntentService {
        public GeofencingService() {
            super(GeofencingService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            intent = C5078i.m21560a(intent);
            if (intent != null && !intent.m21561a()) {
                int c = intent.m21563c();
                Intent intent2 = new Intent(GeofencingGooglePlayServicesProvider.f26395a);
                intent2.putExtra("transition", c);
                intent2.putExtra(PlaceFields.LOCATION, intent.m21565e());
                ArrayList arrayList = new ArrayList();
                for (C5076f a : intent.m21564d()) {
                    arrayList.add(a.mo6206a());
                }
                intent2.putStringArrayListExtra("geofences", arrayList);
                sendBroadcast(intent2);
            }
        }
    }

    public /* synthetic */ void onResult(C2814k c2814k) {
        m34509a((Status) c2814k);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(GeofencingGooglePlayServicesProvider.class.getCanonicalName());
        stringBuilder.append(".GEOFENCE_TRANSITION");
        f26395a = stringBuilder.toString();
    }

    public GeofencingGooglePlayServicesProvider() {
        this(null);
    }

    public GeofencingGooglePlayServicesProvider(C6537a c6537a) {
        this.f26396b = Collections.synchronizedList(new ArrayList());
        this.f26397c = Collections.synchronizedList(new ArrayList());
        this.f26404j = false;
        this.f26406l = new C65611(this);
        this.f26405k = c6537a;
    }

    public void onConnected(Bundle bundle) {
        this.f26399e.mo5497a("onConnected", new Object[0]);
        if (this.f26398d.h()) {
            if (this.f26396b.size() > 0) {
                if (C3169a.b(this.f26402h, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    C5082m.f17383c.mo4638a(this.f26398d, this.f26396b, this.f26403i);
                    this.f26396b.clear();
                } else {
                    return;
                }
            }
            if (this.f26397c.size() > 0) {
                C5082m.f17383c.mo4637a(this.f26398d, this.f26397c);
                this.f26397c.clear();
            }
        }
        if (this.f26405k != null) {
            this.f26405k.mo5493a(bundle);
        }
    }

    public void onConnectionSuspended(int i) {
        C6538b c6538b = this.f26399e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectionSuspended ");
        stringBuilder.append(i);
        c6538b.mo5497a(stringBuilder.toString(), new Object[0]);
        if (this.f26405k != null) {
            this.f26405k.mo5491a(i);
        }
    }

    public void onConnectionFailed(C4775b c4775b) {
        this.f26399e.mo5497a("onConnectionFailed", new Object[0]);
        if (this.f26405k != null) {
            this.f26405k.mo5494a(c4775b);
        }
    }

    /* renamed from: a */
    public void m34509a(Status status) {
        if (status.d()) {
            this.f26399e.mo5497a("Geofencing update request successful", new Object[0]);
        } else if (status.c() && (this.f26402h instanceof Activity)) {
            this.f26399e.mo5500c("Unable to register, but we can solve this - will startActivityForResult expecting result code 10003 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity) this.f26402h, 10003);
            } catch (Status status2) {
                this.f26399e.mo5498a(status2, "problem with startResolutionForResult", new Object[0]);
            }
        } else {
            C6538b c6538b = this.f26399e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Registering failed: ");
            stringBuilder.append(status2.a());
            c6538b.mo5501d(stringBuilder.toString(), new Object[0]);
        }
    }
}
