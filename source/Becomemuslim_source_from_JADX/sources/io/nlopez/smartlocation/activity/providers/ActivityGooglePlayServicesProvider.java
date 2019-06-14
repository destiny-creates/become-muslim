package io.nlopez.smartlocation.activity.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.C5072a;
import com.google.android.gms.location.C7834c;
import io.nlopez.smartlocation.C6532a;
import io.nlopez.smartlocation.activity.C6535a;
import io.nlopez.smartlocation.activity.p363a.C6534a;
import io.nlopez.smartlocation.p364b.C6537a;
import io.nlopez.smartlocation.p364b.C6538b;

public class ActivityGooglePlayServicesProvider implements C2775b, C2776c, C2815l<Status> {
    /* renamed from: a */
    private static final String f26372a;
    /* renamed from: b */
    private GoogleApiClient f26373b;
    /* renamed from: c */
    private C6538b f26374c;
    /* renamed from: d */
    private C6532a f26375d;
    /* renamed from: e */
    private C6535a f26376e;
    /* renamed from: f */
    private Context f26377f;
    /* renamed from: g */
    private boolean f26378g;
    /* renamed from: h */
    private boolean f26379h;
    /* renamed from: i */
    private PendingIntent f26380i;
    /* renamed from: j */
    private C6534a f26381j;
    /* renamed from: k */
    private final C6537a f26382k;
    /* renamed from: l */
    private BroadcastReceiver f26383l;

    /* renamed from: io.nlopez.smartlocation.activity.providers.ActivityGooglePlayServicesProvider$1 */
    class C65361 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ ActivityGooglePlayServicesProvider f21051a;

        C65361(ActivityGooglePlayServicesProvider activityGooglePlayServicesProvider) {
            this.f21051a = activityGooglePlayServicesProvider;
        }

        public void onReceive(Context context, Intent intent) {
            if (ActivityGooglePlayServicesProvider.f26372a.equals(intent.getAction()) != null && intent.hasExtra("activity") != null) {
                this.f21051a.f26374c.mo5497a("sending new activity", new Object[0]);
                this.f21051a.m34480a((C7834c) intent.getParcelableExtra("activity"));
            }
        }
    }

    public static class ActivityRecognitionService extends IntentService {
        public ActivityRecognitionService() {
            super(ActivityRecognitionService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            if (ActivityRecognitionResult.m38201a(intent)) {
                intent = ActivityRecognitionResult.m38203b(intent).m38205a();
                Intent intent2 = new Intent(ActivityGooglePlayServicesProvider.f26372a);
                intent2.putExtra("activity", intent);
                sendBroadcast(intent2);
            }
        }
    }

    public /* synthetic */ void onResult(C2814k c2814k) {
        m34483a((Status) c2814k);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ActivityGooglePlayServicesProvider.class.getCanonicalName());
        stringBuilder.append(".DETECTED_ACTIVITY");
        f26372a = stringBuilder.toString();
    }

    public ActivityGooglePlayServicesProvider() {
        this(null);
    }

    public ActivityGooglePlayServicesProvider(C6537a c6537a) {
        this.f26378g = false;
        this.f26379h = false;
        this.f26383l = new C65361(this);
        this.f26382k = c6537a;
    }

    /* renamed from: a */
    private void m34481a(C6534a c6534a) {
        if (this.f26373b.h()) {
            this.f26380i = PendingIntent.getService(this.f26377f, 0, new Intent(this.f26377f, ActivityRecognitionService.class), 134217728);
            C5072a.f17362b.mo4626a(this.f26373b, c6534a.m26705a(), this.f26380i).a(this);
        }
    }

    public void onConnected(Bundle bundle) {
        this.f26374c.mo5497a("onConnected", new Object[0]);
        if (this.f26378g) {
            m34481a(this.f26381j);
        }
        if (this.f26382k != null) {
            this.f26382k.mo5493a(bundle);
        }
    }

    public void onConnectionSuspended(int i) {
        C6538b c6538b = this.f26374c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectionSuspended ");
        stringBuilder.append(i);
        c6538b.mo5497a(stringBuilder.toString(), new Object[0]);
        if (this.f26382k != null) {
            this.f26382k.mo5491a(i);
        }
    }

    public void onConnectionFailed(C4775b c4775b) {
        this.f26374c.mo5497a("onConnectionFailed", new Object[0]);
        if (this.f26382k != null) {
            this.f26382k.mo5494a(c4775b);
        }
    }

    /* renamed from: a */
    private void m34480a(C7834c c7834c) {
        if (this.f26375d != null) {
            this.f26375d.m26702a(c7834c);
        }
        if (this.f26376e != null) {
            this.f26376e.m26707a("GMS", c7834c);
        }
    }

    /* renamed from: a */
    public void m34483a(Status status) {
        if (status.d()) {
            this.f26374c.mo5497a("Activity update request successful", new Object[0]);
        } else if (status.c() && (this.f26377f instanceof Activity)) {
            this.f26374c.mo5500c("Unable to register, but we can solve this - will startActivityForResult expecting result code 10002 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity) this.f26377f, 10002);
            } catch (Status status2) {
                this.f26374c.mo5498a(status2, "problem with startResolutionForResult", new Object[0]);
            }
        } else {
            C6538b c6538b = this.f26374c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Registering failed: ");
            stringBuilder.append(status2.a());
            c6538b.mo5501d(stringBuilder.toString(), new Object[0]);
        }
    }
}
